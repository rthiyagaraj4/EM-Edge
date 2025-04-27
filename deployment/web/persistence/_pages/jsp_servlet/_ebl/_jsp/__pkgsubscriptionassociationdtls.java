package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pkgsubscriptionassociationdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgSubscriptionAssociationDtls.jsp", 1742877373283L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n16-apr-2014      100           \tKarthikeyan.K       created  for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139\n1            V220826            34883           MMS-ME-SCF-0104                      Namrata\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eBL/js/PkgDef.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\ttype=\'text/css\' />\n<script>\n\n//function load() {\n//\tdocument.title = \"Associate Encounter\";\n//}\nfunction checkEpisode(index)\n{\n\t\n\t\n\tvar objSel = eval(\"document.PkgSubscriptionAssociationDtlsForm.selectEncounter\"+index);\n\t\n\t\n\tif (objSel.checked==true)\n\t\t{\n\t\n\t\t\tvar episode_types = document.PkgSubscriptionAssociationDtlsForm.episode_types.value;\t\n\t\t\tvar packageCodeList= document.PkgSubscriptionAssociationDtlsForm.packageCodeList.value;\t \n\t\t\t\n\t\t\tvar episode_type = eval(\"document.PkgSubscriptionAssociationDtlsForm.alPatientClass\"+index).value;\t\n\t\t\tvar retArray= episode_types.split(\"|\");\n\t\t\tvar pkgArray= packageCodeList.split(\"|\");\n\t\t\t\n\t\t\tfor(i=0;i<retArray.length;i++)\n\t\t\t\t{\t\t\n\t\t\t\t if(retArray[i] != \'\' && retArray[i] != \'undefined\' && retArray[i].indexOf(episode_type)<0)\t\t\t\n\t\t\t\t \t\t{\n\t\t\t\t\t \n\t\t\t\t\t \t\t\n\t\t\t\t\t \t\talert(getMessage(\"BL8688\",\"BL\"));\n\t\t\t\t\t \t\teval(\"document.PkgSubscriptionAssociationDtlsForm.selectEncounter\"+index).checked=false;\n\t\t\t\t\t \t\treturn  false; \n\t\t\t\t\t \t}\t\t\n\t\t\t\t else if( (retArray[i] ==\'\' && pkgArray[i]!=\'\') && i <retArray.length-1)\n\t\t\t\t\t {\n\t\t\t\t\t \talert(\"Please complete all entries in package selection\");\n\t\t\t\t\t \teval(\"document.PkgSubscriptionAssociationDtlsForm.selectEncounter\"+index).checked=false;\n\t\t\t\t\t \treturn false;\n\t\t\t\t\t }\n\t\t\t\t}\n\t\tisAcrossEncounter(index);  \n\t/* \talert(index);\n\t\talert($(\'#alVisitAdmDate\'+index).val());\n\t */\tvar alVisitAdmDate=$(\'#alVisitAdmDate\'+index).val();\n\t\t\n\n\t\t$(\'#alvisitAdmDateHdn\').val(alVisitAdmDate);\n\t\t\t\tvar payerCode=$(\'#payerCode\').val();\n\t\tvar payerGrpCode=$(\'#payerGrpCode\').val();\n\t\t\n\t\tvar payerCodeExistingPkg=$(\'#payerCodeExistingPkg\').val();\n\t\tvar payerGrpCodeExistingPkg=$(\'#payerGrpCodeExistingPkg\').val();\n\t\t\n\t//Added By Vijay For MMS-ICN-00015\n\t//alert(\"cust_group_code:\"+payerGrpCode);\n\tif(payerGrpCode!=\"null\" && payerGrpCode!=\'\' && payerGrpCode!=null || payerCodeExistingPkg!=\"\" && payerCodeExistingPkg!=\"null\" && payerCodeExistingPkg!=null) //|| payerGrpCode!=null)//payerGrpCode!=null) ||payerGrpCode!=\'null\')\n\t{\n\t// alert(\"test\");\n\t$.ajax({\t\n\turl:\"../../eBL/jsp/BLPkgAscteValidation.jsp\",\n\ttype:\"Post\",\n\tdataType:\"text\",\n\tdata:{\n\t\t calledFrom:\'patientPayerValidation\',\n\t\t payerCode:$(\'#payerCode\').val(),\n\t\t payerGrpCode:$(\'#payerGrpCode\').val(),      \n\t\t episodeId:  $(\"#alEpisodeId\"+index).val(),   \t\n\t\t visitId:  $(\"#alVisitId\"+index).val(), \n\t\t facility_id:$(\'#facility_id\').val(),\n\t\t payerCodeExistingPkg:payerCodeExistingPkg,\n\t\t payerGrpCodeExistingPkg:payerGrpCodeExistingPkg\n\t},\n\tasync:false,\n\tsuccess:function(data){\n\t\t//Added by jeyachitra for edge support\n\t  if(data.indexOf(\'<!DOCTYPE html>\')!=-1)\n\t\t{\n\t\t\t  data = data.replace(/<!DOCTYPE html>/gi, \"\");\n\t\t\t  data= trimString(data);\n\t\t}\n\t var obj = jQuery.parseJSON(data);\n\t //alert(obj.flag);\n\t\n\tif(obj.flag!=\'Y\')\n\t\t{\n\t\talert(\'Payer Group associated with Package is not present in Financial Details\');\n\t\teval(\"document.PkgSubscriptionAssociationDtlsForm.selectEncounter\"+index).checked=false;\n\t\t\treturn false;\n\t\t}\n\t}\t\n\t});\n\t}\n\n\t//--- Ends ---\n\t\n\t}\n\t\t}\n\t\t\n\nfunction isAcrossEncounter(index){\n\tvar totalRecords=document.PkgSubscriptionAssociationDtlsForm.totalRecords.value;\n\tvar acrossEncounterParameter=document.PkgSubscriptionAssociationDtlsForm.acrossEncounterParameter.value;\n\tif(acrossEncounterParameter==\'N\'){// if across encounter is not supported\n\t\tfor(var i=0;i<totalRecords;i++){\n\t\teval(\"document.PkgSubscriptionAssociationDtlsForm.selectEncounter\"+i).checked=false;\t\t\t\t\t\n\t\t}\n\t\teval(\"document.PkgSubscriptionAssociationDtlsForm.selectEncounter\"+index).checked=true;\n\t}\n}\n\nfunction loadMultipleEncounters(){\n\t\n\tvar pkgSubscriptionAssociationDtlsForm=document.PkgSubscriptionAssociationDtlsForm;\n\t    var chkCount = 0; \n\t\tfor(var i=0; i<pkgSubscriptionAssociationDtlsForm.elements.length; i++)\n\t\t{\n\t\t\tvar fieldName=pkgSubscriptionAssociationDtlsForm.elements[i].name;\n\t\t\tvar indexFound=fieldName.indexOf(\"selectEncounter\");\n\t\t\tif(indexFound!=-1){\n\t\t\t\tvar fieldValue=pkgSubscriptionAssociationDtlsForm.elements[i].checked;\n\t\t\t\tif(fieldValue==true){\n\t\t\t\t\tpkgSubscriptionAssociationDtlsForm.elements[i].value=true;\n\t\t\t\t\tchkCount = 1;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\n\t\tif(chkCount == 0){\n\t\t\talert(\"Select one encounter to be associated\");\n\t\t\treturn false;\n\t\t}\n\t\tvar frmObj=document.PkgSubscriptionAssociationDtlsForm;\n\t\tvar temp_jsp=\"../../eBL/jsp/PkgSubscriptionAssociationDtlsValidation.jsp?action=submit&totalRecords=\"+frmObj.totalRecords.value;\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\t\t\n\n\t\t\t\n\t\t\tif(frmObj!=\"\" && frmObj!=null && frmObj !=undefined )\n\t\t\t{\n\t\t\t/*Changed for MMS-JU-SCF-0151 PALANINARAYANAN  */\n\t\t\tvar xmlString=formXMLStringMainPkgSub(frmObj);\n\t\t\tvar updation=formValidation(xmlString,temp_jsp);\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlString, \"text/xml\");\n\t\t\t}\t\t\t\t\n\n\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\txmlHttp.send(xmlDoc);\t//any XML object can also be sent as a parameter\n\t\t\n\t\tif(xmlHttp.responseText.indexOf(\'<!DOCTYPE html>\')!=-1)\n\t\t{\n\t\t\txmlHttp.responseText = xmlHttp.responseText.replace(/<!DOCTYPE html>/gi, \"\");\n\t\t}\n\t\tvar encounterCombinationString = trimString(xmlHttp.responseText);\n\t \n\t\tvar selectCheckBoxList=$(\'#selectCheckBoxList\').val();\n\t\t\n\t\tvar dataArrr=$.trim(selectCheckBoxList).split(\',\');\n\t\t\n\t\tvar alvisitAdmDateHdn=$(\'#alvisitAdmDateHdn\').val();\n\t\tvar visitDatTime=$(\'#visitDatTime\').val();\n\t\t\n\t\t//visitDatTime\n\t\tif(alvisitAdmDateHdn==\'\' ||alvisitAdmDateHdn==null||alvisitAdmDateHdn==undefined||alvisitAdmDateHdn==\'undefined\')\n\t\t\t{\n\t\t\talvisitAdmDateHdn=visitDatTime;\n\t\t\t\n\t\t\t//return false;\n\t\t\t}\n\t\t//alert(\"ret value:\" +chkCount + \"::\" + selectCheckBoxList+ \"::\" +alvisitAdmDateHdn + \"::\" + encounterCombinationString);\n\t\twindow.returnValue = chkCount + \"::\" + selectCheckBoxList+ \"::\" +alvisitAdmDateHdn + \"::\" + encounterCombinationString ;\n\t\t\n\t\twindow.close();\n\n\t\n}\n\n\n$(document).ready(function () {\n\n\t\n \t$(\".selectEncounterCheckBox\").click(function(){\n \t\tvar objthis=$(this);\n \t\tvar index = $(\'#PkgSubscriptionAssociationDataSet tr\').index($(this).closest(\'tr\')) - 1;\n\t\t \n \t\tif($(this).is(\":checked\") == true) {\n\t\t \t \t $.ajax({\n\t\t\t          url:\"../../eBL/jsp/PkgAssociationExistingPackagesValidation.jsp\",\n\t\t\t          type:\'post\',\n\t\t\t\t\t  async:false,\n\t\t\t          data: {\n\t\t\t        \t  \t  operation:    \"encounterAssociationValidation\",\n\t\t\t        \t  \t  patientId:  \t$(\"#patientId\").val(), \n\t\t\t        \t\t  encounterId:  $(\"#alEncounterId\"+index).val(),\n\t\t\t        \t\t  episodeId:  $(\"#alEpisodeId\"+index).val(),   \t\n\t\t\t        \t\t  visitId:  $(\"#alVisitId\"+index).val()   \t\n\t\t\t          },          \n\t\t\t          success: function(data) {\n\t\t\t        \t  if(data.indexOf(\'<!DOCTYPE html>\')!=-1)\n\t\t\t\t\t\t\t{\n\t\t\t        \t\t  data = data.replace(/<!DOCTYPE html>/gi, \"\");\n\t\t\t        \t\t  data= trimString(data);\n\t\t\t\t\t\t\t}\n\t\t                  var obj = jQuery.parseJSON(data);\n\t\t\t        \t  var returnVal =obj.flag;\n\t\t\t        \t  var returnDesc= obj.desc;//Karthik modified code for MMS-RY-SCF-0065\n\t\t\t\t      \t  if(returnVal==\"FAIL\" && returnDesc==\"ENC_ALREADY_ASSOCIATED\"){\n\t\t\t        \t\t  alert(\"Encounter is Already associated to One or more Packages\");\n\t\t\t        \t\t  objthis.prop(\"checked\",false);\n\t\t\t        \t\t  \n\t\t\t        \t  }\n\t\t\t\t      \t  \n\t\t\t\t      \t  if(returnVal==\"FAIL\" && returnDesc==\"PAYER_NA_FIN_DTLS\"){//Karthik modified code for MMS-RY-SCF-0065\n\t\t\t        \t\t  alert(\"Payer Information not present in Patient Financial Details \");\n\t\t\t        \t\t  objthis.prop(\"checked\",false);\t\t\t        \t\t  \n\t\t\t        \t  }\n\t\t\t\t      \t  \n\t\t\t          }\n\t\t\t          \n\t\t\t        });  \n \t\t\t}\n\n\t}); \n\n\t  \n});\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>alert(\'Query caused No records\');window.close();</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<HTML>\n\n<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n<body>\n\t<FORM name=\"PkgSubscriptionAssociationDtlsForm\" id=\"PkgSubscriptionAssociationDtlsForm\">\n\t<div class=\"scroll-container\" style=\"max-height: 79vh; overflow-y: auto; overflow-x: hidden; border: 1px solid #ccc; padding: 5px; width: 99%;\">\n\t\t<table id=\'PkgSubscriptionAssociationDataSet\' border=\"1\" width=\"100%\"\n\t\t\tcellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\t<td width=\'*\'></td>\n\t\t\t</tr>\n\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<tr>\n\t\t\t\t<td><input readonly class=\"label\" name=\"alPatientClass";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"alPatientClass";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"\n\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></td>\n\t\t\t\t<td><input readonly class=\"label\" id=\"alEpisodeId";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"\n\t\t\t\t\tname=\"alEpisodeId";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></td>\n\t\t\t\t<td><input readonly class=\"label\" id=\"alEncounterId";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"\n\t\t\t\t\tname=\"alEncounterId";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></td>\n\t\t\t\t<td><input readonly class=\"label\" id=\"alVisitId";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"\n\t\t\t\t\tname=\"alVisitId";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></td>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<td><input readonly class=\"label\" id=\"alVisitAdmDate";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"\n\t\t\t\t\tname=\"alVisitAdmDate";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"></td>\n\t\t\t\t<td><input readonly class=\"label\"\n\t\t\t\t\tid=\"alChkOutDischrgDate";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" name=\"alChkOutDischrgDate";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<td align=center><input type=\"checkbox\"\n\t\t\t\t\tclass=\'selectEncounterCheckBox\' name=\"selectEncounter";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"selectEncounter";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\tvalue=\"false\" onclick=\"checkEpisode(";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =");\"></td>\n\t\t\t\t<td></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<input type=hidden name=totalRecords id=totalRecords\n\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t<input type=hidden id=patientId name=patientId id=patientId value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t<input type=hidden name=acrossEncounterParameter id=acrossEncounterParameter\n\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t<input type=hidden name=episode_types id=episode_types value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t<input type=hidden name=packageCodeList id=packageCodeList\n\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\n\t\t\t<input type=hidden name=selectCheckBoxList id=\'selectCheckBoxList\'\n\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\n\t\t\t<input type=hidden name=alvisitAdmDateHdn id=\'alvisitAdmDateHdn\'\n\t\t\t\tvalue=\"\">\n\n\t\t\t<input type=\'hidden\' name=\'indexhidden\' id=\'indexhidden\' id=\'indexhidden\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'visitDatTime\' id=\'visitDatTime\' id=\'visitDatTime\'\n\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\n\t\t\t<input type=\'hidden\' name=\'payerGrpCode\' id=\'payerGrpCode\' id=\'payerGrpCode\'\n\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t<input type=\'hidden\' name=\'payerCode\' id=\'payerCode\' id=\'payerCode\'\n\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\n\t\t\t<input type=\'hidden\' name=\'payerCodeExistingPkg\' id=\'payerCodeExistingPkg\'\n\t\t\t\tid=\'payerCodeExistingPkg\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t<input type=\'hidden\' name=\'payerGrpCodeExistingPkg\' id=\'payerGrpCodeExistingPkg\'\n\t\t\t\tid=\'payerGrpCodeExistingPkg\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t<!-- Below hidden fields are added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  STRATS-->\n\t\t\t<input type=\'hidden\' name=\'package_seq_no\' id=\'package_seq_no\' id=\'package_seq_no\'\n\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'eff_from_date\' id=\'eff_from_date\' id=\'eff_from_date\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' id=\'function_id\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\t\t\t\n\t\t\t<!-- Below hidden fields are added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  ENDS-->\n\t\t</table>\n\t\t</div>\n\t\t<TABLE width=\'100%\' border=\'0\' cellpadding=\'3\' cellspacing=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'25%\' class=\'fields\'></td>\n\t\t\t\t<td width=\'20%\' class=\'fields\'><input type=\'button\'\n\t\t\t\t\tclass=\'button\'\n\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'\n\t\t\t\t\tsize=\'20\' onClick=\'loadMultipleEncounters();\'></td>\n\t\t\t</tr>\n\t\t</TABLE>\n\t</FORM>\n</BODY>\n</html>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);

	System.err.println("PkgSubscriptionAssociationDtls.jsp?"+request.getQueryString());

	String facilityId = (String) session.getValue("facility_id");
	String payerCode = request.getParameter("payerCodeTemp");
	String payerGrpCode = request.getParameter("payerGrpCodeTemp");
	String payerCodeExistingPkg = request.getParameter("payer_code_temp");
	String payerGrpCodeExistingPkg = request.getParameter("payer_group_code_temp");
	//Added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622 Starts
	String packageCodeList = request.getParameter("packageCodeList");
	String package_seq_no = request.getParameter("package_seq_no");
	String eff_from_date = request.getParameter("eff_from_date");
	String function_id = request.getParameter("function_id");
	//Added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  Ends
	StringBuilder sbs = new StringBuilder();
	StringBuilder sb = new StringBuilder();
	String blngcodestr = "";
	String packageBlngClassCode = request.getParameter("packageBlngClassCode");
	StringTokenizer st = new StringTokenizer(packageBlngClassCode, "|");
	System.out.println("Total  PackagesaddList : " + st.countTokens());
	if (st.countTokens() > 0) {
		String s1 = packageBlngClassCode;
		String[] words = s1.split("\\|");
		for (String w : words) {
			sbs.append("'" + w + "'" + ",");
		}
		System.out.println("w words :" + sbs.toString());
		blngcodestr = sbs.toString();
		blngcodestr = blngcodestr.substring(0, blngcodestr.length() - 1);
	}
	
	System.err.println("function_id in subass:"+function_id);
	
	

	ArrayList<PkgAssociationExistingPackagesBean> pkgAssociationExistingPackagesBeanList = (session
			.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG")) == null
					? new ArrayList<PkgAssociationExistingPackagesBean>()
					: (ArrayList<PkgAssociationExistingPackagesBean>) session
							.getAttribute("BL_PKG_ASSOCIATION_EXISTING_PKG");
							
	if (pkgAssociationExistingPackagesBeanList.size() > 0) {
		System.err.println("Total PackagesBeanList : " + pkgAssociationExistingPackagesBeanList.size());
		for (PkgAssociationExistingPackagesBean bean : pkgAssociationExistingPackagesBeanList) {
			System.err.println("bean" + bean.getExistingPkgBlngClassCode());
			sb.append("'" + bean.getExistingPkgBlngClassCode() + "'" + ",");
		}
		sbs.append(sb);
		blngcodestr = sbs.toString();
		blngcodestr = blngcodestr.substring(0, blngcodestr.length() - 1);
	}

	System.err.println("Final blngcodestr :" + blngcodestr);
	String patientId = request.getParameter("patientId");
	String episodeTypes = request.getParameter("packageEpisodeTypes");
	String selectCheckBoxList = request.getParameter("selectCheckBoxList");
	String visitDatTime = request.getParameter("alvisitAdmDateHidden");

	ArrayList<String> encounterListArray = new ArrayList<String>();
	String acrossEncounterParameter = request.getParameter("acrossEncounterParameter");
	Boolean siteSpec = false;
	Connection con = null;

	try {
		con = ConnectionManager.getConnection();
		siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "DISP_PKG_DATE_FIELDS_DUR_SUBS");
		System.out.println("SiteSpec" + siteSpec);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception in site specific " + e);
	}
	
	// Added the condition to check for called function id because if called from MPP, each package seq should be allowed to select its 
	// own encounter. If earlier session value is loaded then other sequence encounter will be loaded by default, which shouldnt happen
	
	if (session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS") != null && !"EBL_TRAN_PACKAGE_MAINTAIN".equals(function_id)) {
		HashMap<String, ArrayList<String>> packageSubscriptionAssociationEncounters = new HashMap<String, ArrayList<String>>();
		ArrayList<String> encounterCombinationArray = new ArrayList<String>();
		packageSubscriptionAssociationEncounters = (HashMap<String, ArrayList<String>>) session
				.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
		encounterCombinationArray = packageSubscriptionAssociationEncounters.get(patientId);
		if (encounterCombinationArray == null) {
			encounterCombinationArray = new ArrayList<String>();
		}
		for (int encCount = 0; encCount < encounterCombinationArray.size(); encCount++) {
			StringTokenizer stEncList = new StringTokenizer(encounterCombinationArray.get(encCount), "|");
			String headerEpisodeType = stEncList.nextToken();
			String encounterId = stEncList.nextToken();
			encounterListArray.add(encounterId);
		}
	}

	System.out.println(
			session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS") + "@@" + encounterListArray);

	session.removeAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");

	PreparedStatement pstmt = null;
	ResultSet rscurr = null;
	ArrayList<String> alPatientClass = new ArrayList<String>();
	ArrayList<String> alEpisodeId = new ArrayList<String>();
	ArrayList<String> alEncounterId = new ArrayList<String>();
	ArrayList<String> alVisitId = new ArrayList<String>();
	ArrayList<String> alVisitAdmDate = new ArrayList<String>();
	ArrayList<String> alChkOutDischrgDate = new ArrayList<String>();
	String assocEncQuery = "";

	try {
		if (siteSpec) {
			//MMS-SCF-0385 Karthik changed Query to Sort and prioritize latest Encounter first 
			System.out.println("Inside SiteSpec:" + siteSpec);
			assocEncQuery = "SELECT PATIENT_CLASS, EPISODE_ID,ENCOUNTER_ID, REPLACE(ENCOUNTER_ID,EPISODE_ID,'') VISIT_ID,to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') VISIT_ADM_DATE_TIME_1, VISIT_ADM_DATE_TIME, to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') DISCHARGE_DATE_TIME FROM PR_ENCOUNTER a WHERE PATIENT_ID =? and FACILITY_ID=? AND ((patient_class IN ('OP','EM') AND visit_status NOT IN ('99')) OR (patient_class IN ('IP','DC') AND adt_status NOT IN ('09'))) "; //V220826
			
			if(!"".equals(blngcodestr))
				assocEncQuery = assocEncQuery + " AND EXISTS (SELECT 1 FROM bl_blng_class b WHERE b.patient_category_code = SUBSTR (a.patient_class, 1, 1) AND blng_class_code IN (" + blngcodestr + "))";
					
			assocEncQuery = assocEncQuery + " order by VISIT_ADM_DATE_TIME desc";
		} else {
			assocEncQuery = "SELECT PATIENT_CLASS, EPISODE_ID,ENCOUNTER_ID, REPLACE(ENCOUNTER_ID,EPISODE_ID,'') VISIT_ID,to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') VISIT_ADM_DATE_TIME_1, VISIT_ADM_DATE_TIME ,to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') DISCHARGE_DATE_TIME FROM PR_ENCOUNTER WHERE PATIENT_ID =? and FACILITY_ID=? AND ((patient_class IN ('OP','EM') AND visit_status NOT IN ('99')) OR (patient_class IN ('IP','DC') AND adt_status NOT IN ('09'))) order by VISIT_ADM_DATE_TIME desc";//V220826
	
		}
		System.err.println("assocEncQuery:"+assocEncQuery);
		pstmt = con.prepareStatement(assocEncQuery);
		pstmt.setString(1, patientId);
		pstmt.setString(2, (String) session.getValue("facility_id"));
		rscurr = pstmt.executeQuery();
		
		if (rscurr != null)
			while (rscurr.next()) {
				String tmpPatientClass = rscurr.getString("PATIENT_CLASS");
				if (tmpPatientClass == null)
					tmpPatientClass = "";
				String tmpEpisodeId = rscurr.getString("EPISODE_ID");
				if (tmpEpisodeId == null)
					tmpEpisodeId = "";
				String tmpEncounterId = rscurr.getString("ENCOUNTER_ID");
				if (tmpEncounterId == null)
					tmpEncounterId = "";
				String tmpVisitId = rscurr.getString("VISIT_ID");
				if (tmpVisitId == null)
					tmpVisitId = "";
				String tmpVisitAdmDate = rscurr.getString("VISIT_ADM_DATE_TIME_1"); //V220826
				System.err.println("tmpVisitAdmDate is: "+rscurr.getString("VISIT_ADM_DATE_TIME"));
				if (tmpVisitAdmDate == null)
					tmpVisitAdmDate = "";
				String tmpChkOutDischrgDate = rscurr.getString("DISCHARGE_DATE_TIME");
				if (tmpChkOutDischrgDate == null)
					tmpChkOutDischrgDate = "";

				alPatientClass.add(tmpPatientClass);
				alEpisodeId.add(tmpEpisodeId);
				alEncounterId.add(tmpEncounterId);
				alVisitId.add(tmpVisitId);
				alVisitAdmDate.add(tmpVisitAdmDate);
				alChkOutDischrgDate.add(tmpChkOutDischrgDate);
			}
		if (rscurr != null)
			rscurr.close();
		pstmt.close();
	} catch (Exception e) {
		System.out.println("Error episodeTypeList=" + e.toString());
		e.printStackTrace();
	} finally {
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	if (alPatientClass.size() < 1) {

            _bw.write(_wl_block8Bytes, _wl_block8);

	} else {

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getParameter("title")));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

					if (siteSpec) {
				
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

					}
				
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

				for (int i = 0; i < alPatientClass.size(); i++) {
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(alPatientClass.get(i)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alEpisodeId.get(i)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alEncounterId.get(i)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alVisitId.get(i)));
            _bw.write(_wl_block25Bytes, _wl_block25);

					if (siteSpec) {
				
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alVisitAdmDate.get(i)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(alChkOutDischrgDate.get(i)));
            _bw.write(_wl_block25Bytes, _wl_block25);

					}
				
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(encounterListArray.contains(alEncounterId.get(i)) ? "checked" : ""));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);

				}
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(alPatientClass.size()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(acrossEncounterParameter));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(episodeTypes));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(request.getParameter("packageCodeList")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(selectCheckBoxList));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(visitDatTime));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(payerGrpCode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(payerCode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(payerCodeExistingPkg));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(payerGrpCodeExistingPkg));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(package_seq_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(eff_from_date));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

	}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitID.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VisitAdmissionDate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CheckOutDischargeDate.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Submit.label", java.lang.String .class,"key"));
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
}
