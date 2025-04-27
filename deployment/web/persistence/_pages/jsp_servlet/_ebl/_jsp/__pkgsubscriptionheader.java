package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.PkgSubsBean;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pkgsubscriptionheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgSubscriptionHeader.jsp", 1738044048286L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<!--<script language=\"javascript\" src=\'../../eBL/js/PkgDef.js\'></script>-->\n<script language=\"javascript\" src=\'../../eBL/js/PkgSubs.js\'></script> \n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nasync function pkgSubscriptionWindow(){\n\tvar patientId = document.frmPkgDefHeader.patientId.value;\n\tvar alvisitAdmDateHidden = $(\'#alvisitAdmDateHidden\').val();\n\tvar siteSpec=$(parent.PkgSubscriptionDtls.document).find(\'#site_spec\').val();\n\tvar siteBLPkgBlngGrpYN=$(parent.PkgSubscriptionDtls.document).find(\'#siteBLPkgBlngGrpYN\').val();//Added By Shikha For GHL-CRF-0520.1\n\n\tif (patientId == \'\') {\n\t\talert(\"Please Provide Patient ID\");\n\t} else {\n\t\tvar pkgSubsDoc = parent.PkgSubscriptionDtls.document;\n\t\tvar selectCheckBoxList = $(pkgSubsDoc).find(\n\t\t\t\t\"input[name=existingPkgChecked]:checked\").map(function() {\n\t\t\treturn this.value;\n\t\t}).get().join(\",\");\n\t\tvar dateArray = selectCheckBoxList.split(\',\');\n\n\t\tvar dateAr = \"\";\n\t\tvar dte = \"\";\n\t\t/* \talert(\'dateARray \'+dateArray)\n\t\t\talert(\'dateArray.length \'+dateArray.length);\n\t\t */\n\t\tvar len = $(parent.PkgSubscriptionDtls.document).find(\n\t\t\t\t\'#pkgSubsExistingPkgTbl tr\').length;\n\n\t\tvar payer_code=\'\';\n\t\tvar payer_group_code=\'\'; \n\t\t\t \n\t\tvar  payer_code_temp=\'\';\n\t\tvar payer_group_code_temp=\'\';\n\t\tvar payer_group_code=\'\';\t\t\t\t\n\t\t\t\n\t//if (siteSpec == \'true\') {\n\t\t\nif(selectCheckBoxList.length>0){\n\tfor (i = 0; i <= len; i++) {\n\t\tfor ( var j = 0; j <= dateArray.length; j++) {\n\t\t\tif (i == dateArray[j]) {\t\t\t\t\n\t\t\t\tif(parent.PkgSubscriptionDtls.document.getElementById(\"payer_group_code\"+i).value!=null && parent.PkgSubscriptionDtls.document.getElementById(\"payer_group_code\"+i).value!=\"null\")\t{ \n\t\t\t\t\tpayer_code+=parent.PkgSubscriptionDtls.document.getElementById(\"payer_code\"+i).value+\",\"+payer_code_temp;\n\t\t\t\t\tpayer_code_temp=payer_code;\n\t\t\t\t\tpayer_code=\'\';\n\t\t\t\t\tpayer_group_code+=parent.PkgSubscriptionDtls.document.getElementById(\"payer_group_code\"+i).value+\",\"+payer_group_code_temp;\t\t\t\t\t\t\t\n\t\t\t\t\tpayer_group_code_temp=payer_group_code;\t\n\t\t\t\t\tpayer_group_code=\'\';\t\t\t\t\t\t\n\t\t\t\t}\t\t\t\t\t\n\t\t\telse{\n\t\t\t\tif(payer_group_code_temp==\'\') \n\t\t\t\t{\n\t\t\t\t\tpayer_group_code_temp=\'\';\n\t\t\t\t\tpayer_code_temp=\'\';\n\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\tdte = parent.PkgSubscriptionDtls.document\n\t\t\t\t\t\t\t.getElementById(\"from_date\" + i).value;\t\t\t\t\t\n\t\t\t\tdateAr += dte + \",\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\n\t//var episodeIdList=$(pkgSubsDoc).find(\"input[name=existingPkgEpiType]\").map(function () {return this.value;}).get().join(\"|\");\n\t$(\"#selectCheckBoxList\").val(selectCheckBoxList);\n\tvar frmObj = parent.PkgSubscriptionDtls.document.frmPkgSubs;\n\tif (frmObj != \"\" && frmObj != null && frmObj != undefined) {\n\t\t/* Karthik added validation here to perform extra check for Multi encounter cases while subscription - Starts */\n\t\tvar isEmptyPackageCode = parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_0.value;\n\t\tif (isEmptyPackageCode == \'\' && selectCheckBoxList == \'\') {\n\t\t\talert(\"Please Select a Package\");\n\t\t} else {\n\t\t\tvar totalRecords = parent.PkgSubscriptionDtls.document.frmPkgSubs.total_records.value;\n\t\t\tvar packageCodeList = \'\';\n\t\t\tvar packageEpisodeType = \'\';\n\t\t\tvar packageBlngClassCode=\'\';\n\t\t\tvar packageBlngGrpCode=\'\';\n\t\t\tvar payerGrpCode=\"\";\n\t\t\tvar payerCode=\"\";\n\t\t\tvar payerGrpCodeTemp=\"\";\n\t\t\tvar payerCodeTemp=\"\";\n\t\tfor(var i=0;i<totalRecords;i++){\n\t\t\tpayerGrpCode=\'\';\n\t\t\tpayerCode=\'\';\t\t\t\t\t\n\t\t\tpackageCodeList += eval(\"parent.PkgSubscriptionDtls.document.frmPkgSubs.packageCode_\"+i).value + \"|\";\n\t\t\tpackageEpisodeType+= eval(\"parent.PkgSubscriptionDtls.document.frmPkgSubs.episodeType_\"+i).value + \"|\";\n\t\t\tpackageBlngClassCode+= eval(\"parent.PkgSubscriptionDtls.document.frmPkgSubs.blng_class_code\"+i).value + \"|\";\n\t\t//Added By Shikha For GHL-CRF-0520.1\n\t\tif(siteBLPkgBlngGrpYN==\"Y\"){\t\t\t\t\t\n\t\t\tpackageBlngGrpCode+= eval(\"parent.PkgSubscriptionDtls.document.frmPkgSubs.blngGrpCode_\"+i).value + \"|\"; \n\t\t}//Added By Shikha For GHL-CRF-0520.1\n\t\t\tif(eval(\"parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_\"+i).value!=\"null\"&&eval(\"parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_\"+i).value!=null&&eval(\"parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_\"+i).value!=\'\')\n\t\t\t{\t\n\t\t\t\tpayerGrpCode+=eval(\"parent.PkgSubscriptionDtls.document.frmPkgSubs.payerGrpCode_\"+i).value+\",\"+payerGrpCodeTemp;\n\t\t\t\tpayerGrpCodeTemp=payerGrpCode;\n\t\t\t\tpayerCode+=eval(\"parent.PkgSubscriptionDtls.document.frmPkgSubs.payerCode_\"+i).value+\",\"+payerCodeTemp;\n\t\t\t\tpayerCodeTemp=payerCode;\n\t\t\t}\n\t\t\telse{\t\t\t\t\t\t\n\t\t\t\t\tif(payerGrpCodeTemp==\'\'){\n\t\t\t\t\t\tpayerGrpCodeTemp=\'\';\n\t\t\t\t\t\tpayerCodeTemp=\'\';\n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\n\t}\t\t\t\t\t\n\t\t\n\tvar pkgCodeArray=selectCheckBoxList.split(\',\');\n\tif(pkgCodeArray===undefined) pkgCodeArray=\'\';\n\tfor (var i = 0; i < pkgCodeArray.length; i++) {\n\t\t\tpackageCodeList += $(pkgSubsDoc).find(\"input[name=existingPkgCode\"+pkgCodeArray[i]+\"]\").val()  + \"|\";\n\t\t\tpackageEpisodeType += $(pkgSubsDoc).find(\"input[name=existingPkgEpiType\"+pkgCodeArray[i]+\"]\").val()  + \"|\";\n\t\t}\n\n\tvar URL=\"../../eBL/jsp/PkgSubscriptionAssociationDtlsValidation.jsp?action=across_encounter_check&packageCodeList=\"+packageCodeList+\"&packageEpisodeTypes=\"+packageEpisodeType ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlHttp.open(\"POST\",URL,false);\n\txmlHttp.send();\n\tvar responseText=trimString(xmlHttp.responseText);\n\tvar acrossEncounterParameter=\"N\";\n\tif(responseText.indexOf(\"SUCCESS_ACROSS_ENCOUNTER\")!=-1){ // If across encounter is true as SUCCESS_ACROSS_ENCOUNTER is  found\n\t\tacrossEncounterParameter=\"Y\";\n\t}else{//across encounter is false as SUCCESS_ACROSS_ENCOUNTER is  found\n\t\tacrossEncounterParameter=\"N\";\t\n\t}\n\tvar dialogUrl=\"\";\n\tvar title = \"Associate Encounter\";\n\t//Added By Shikha For GHL-CRF-0520.1\n\tif(siteBLPkgBlngGrpYN==\"Y\"){\n\t\t\tdialogUrl = \"../../eBL/jsp/PkgSubscriptionAssociationDtls.jsp?patientId=\"\n\t\t\t\t\t+ patientId\n\t\t\t\t\t+ \"&acrossEncounterParameter=\"\n\t\t\t\t\t+ acrossEncounterParameter\n\t\t\t\t\t+ \"&packageCodeList=\"\n\t\t\t\t\t+ packageCodeList\n\t\t\t\t\t+ \"&packageEpisodeTypes=\"\n\t\t\t\t\t+ packageEpisodeType\n\t\t\t\t\t+ \"&selectCheckBoxList=\"\n\t\t\t\t\t+ selectCheckBoxList\n\t\t\t\t\t+ \"&alvisitAdmDateHidden=\"\n\t\t\t\t\t+ alvisitAdmDateHidden\n\t\t\t\t\t+ \"&packageBlngClassCode=\"\n\t\t\t\t\t+ packageBlngClassCode\n\t\t\t\t\t+ \"&packageBlngGrpCode=\"\n\t\t\t\t\t+ packageBlngGrpCode //Added By Shikha For GHL-CRF-0520.1\n\t\t\t\t\t+\"&payerCodeTemp=\"\n\t\t\t\t\t+ payerCodeTemp\n\t\t\t\t\t+ \"&payerGrpCodeTemp=\"\n\t\t\t\t\t+ payerGrpCodeTemp\n\t\t\t\t\t+\"&payer_code_temp=\"\n\t\t\t\t\t+ payer_code_temp\n\t\t\t\t\t+ \"&payer_group_code_temp=\"\n\t\t\t\t\t+ payer_group_code_temp\n\t\t\t\t\t+ \"&title=\"\n\t\t\t\t\t+title;\n\t\t}else{\n\t\t\t\tdialogUrl = \"../../eBL/jsp/PkgSubscriptionAssociationDtls.jsp?patientId=\"\n\t\t\t\t\t+ patientId\n\t\t\t\t\t+ \"&acrossEncounterParameter=\"\n\t\t\t\t\t+ acrossEncounterParameter\n\t\t\t\t\t+ \"&packageCodeList=\"\n\t\t\t\t\t+ packageCodeList\n\t\t\t\t\t+ \"&packageEpisodeTypes=\"\n\t\t\t\t\t+ packageEpisodeType\n\t\t\t\t\t+ \"&selectCheckBoxList=\"\n\t\t\t\t\t+ selectCheckBoxList\n\t\t\t\t\t+ \"&alvisitAdmDateHidden=\"\n\t\t\t\t\t+ alvisitAdmDateHidden\n\t\t\t\t\t+ \"&packageBlngClassCode=\"\n\t\t\t\t\t+ packageBlngClassCode\n\t\t\t\t\t+\"&payerCodeTemp=\"\n\t\t\t\t\t+ payerCodeTemp\n\t\t\t\t\t+ \"&payerGrpCodeTemp=\"\n\t\t\t\t\t+ payerGrpCodeTemp\n\t\t\t\t\t+\"&payer_code_temp=\"\n\t\t\t\t\t+ payer_code_temp\n\t\t\t\t\t+ \"&payer_group_code_temp=\"\n\t\t\t\t\t+ payer_group_code_temp\n\t\t\t\t\t+ \"&title=\"\n\t\t\t\t\t+title;\n\t\t}\n\t\tvar dialogFeatures  = \"dialogHeight:\" + \"60vh\" + \"; dialogWidth:\" + \"70vw\" +\" ; scroll=auto; \";\n\t\tvar returnVal = await window.showModalDialog(dialogUrl,null,dialogFeatures);\n\t\tvar dataArr = $.trim(returnVal).split(\'::\');\n\t\tif (dataArr[0] == 1)\n\t\tparent.PkgSubscriptionDtls.document.frmPkgSubs.Add.disabled= true;\n\t\telse\n\t\tparent.PkgSubscriptionDtls.document.frmPkgSubs.Add.disabled= false;\t\t\t\t\n\t\t\n\tif (siteSpec == \'true\') {\t\t\n\t\tif(selectCheckBoxList!=\'\'){\t\t\t\n\t\t\tvar dataArrr = $.trim(dataArr[1]).split(\',\');\n\t\t\tvar alvisitAdmDateHdn = dataArr[2];\n\t\t\tif (returnVal == \'undefined\' || returnVal == undefined) {\n\t\t\t\tvar dataArr = selectCheckBoxList.split(\',\');\n\t\t\t\tvar existingDate = dateAr.split(\',\');\n\t\t\t\tvar length = $(parent.PkgSubscriptionDtls.document)\n\t\t\t\t\t\t.find(\'#pkgSubsExistingPkgTbl tr\').length;\n\t\t\t\tfor ( var i = 0; i <= length; i++) {\n\t\t\t\t\tfor ( var j = 0; j <= existingDate.length; j++) {\n\t\t\t\t\t\tif (i == existingDate[j]) {\n\t\t\t\t\t\t\tparent.PkgSubscriptionDtls.document\n\t\t\t\t\t\t\t\t\t.getElementById(\"from_date\" + i).value = existingDate[i];\n\t\t\t\t\t\t\tparent.PkgSubscriptionDtls.document\n\t\t\t\t\t\t\t.getElementById(\"fromdatehdn\" + i).value = existingDate[i];\n\t\t\t\t\t\t\t/* $.ajax({\n\t\t\t\t\t\t\t\turl:\"../../eBL/jsp/PkgAssociationExistingPackagesPersistance.jsp\",\n\t\t\t\t\t\t\t\ttype:\'post\',\n\t\t\t\t\t\t\t\tdata:{\n\t\t\t\t\t\t\t\t  existingPkgCode: $(parent.PkgSubscriptionDtls.document).find(\'#existingPkgCode\'+i).val(),\n\t\t\t\t\t\t\t\t  existingPkgSeqNo:$(parent.PkgSubscriptionDtls.document).find(\'#existingPkgSeqNo\'+i).val(),\n\t\t\t\t\t\t\t\t  existingPkgEpiType:$(parent.PkgSubscriptionDtls.document).find(\'#existingPkgEpiType\'+i).val(),\n\t\t\t\t\t\t\t\t  existingPkgFrmDte:$(parent.PkgSubscriptionDtls.document).find(\'#fromdate\'+i).val(),\n\t\t\t\t\t\t\t\t  operation: \'modify\'\n\t\t\t\t\t\t\t\t},\n\t\t\t\t\t\t\t\tasync:false,\n\t\t\t\t\t\t\t\tsuccess: function(data) {\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t});    */\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\tif (returnVal != \'undefined\' || returnVal != undefined) {\n\t\t\t$(\'#alvisitAdmDateHidden\').val(alvisitAdmDateHdn);\n\t\t\tvar length = $(parent.PkgSubscriptionDtls.document)\n\t\t\t\t\t.find(\'#pkgSubsExistingPkgTbl tr\').length;\n\t\t\tif (alvisitAdmDateHdn != \'\') {\n\t\t\t\tfor ( var i = 0; i <= length; i++) {\n\t\t\t\t\tfor ( var j = 0; j <= dataArrr.length; j++) {\n\t\t\t\t\t\tif (i == dataArrr[j]) {\n\t\t\t\t\t\t\tparent.PkgSubscriptionDtls.document\n\t\t\t\t\t\t\t\t\t.getElementById(\"from_date\"\n\t\t\t\t\t\t\t\t\t\t\t+ i).value = alvisitAdmDateHdn;\n\t\t\t\t\t\t\tparent.PkgSubscriptionDtls.document\n\t\t\t\t\t\t\t.getElementById(\"fromdatehdn\"\n\t\t\t\t\t\t\t\t\t+ i).value = alvisitAdmDateHdn;\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t/* callvalidate(i, \'null\',\n\t\t\t\t\t\t\t\t\t\'Pkgsubsheader\'); */\n\t\t\t\t\t\t$.ajax({\n\t\t\t\t\t\t\t\turl:\"../../eBL/jsp/PkgAssociationExistingPackagesPersistance.jsp\",\n\t\t\t\t\t\t\t\ttype:\'post\',\n\t\t\t\t\t\t\t\tdata:{\n\t\t\t\t\t\t\t\t  existingPkgCode: $(parent.PkgSubscriptionDtls.document).find(\'#existingPkgCode\'+i).val(),\n\t\t\t\t\t\t\t\t  existingPkgSeqNo:$(parent.PkgSubscriptionDtls.document).find(\'#existingPkgSeqNo\'+i).val(),\n\t\t\t\t\t\t\t\t  existingPkgEpiType:$(pare";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="nt.PkgSubscriptionDtls.document).find(\'#existingPkgEpiType\'+i).val(),\n\t\t\t\t\t\t\t\t  existingPkgFrmDte:$(parent.PkgSubscriptionDtls.document).find(\'#from_date\'+i).val(),\n\t\t\t\t\t\t\t\t  operation: \'modify\'\n\t\t\t\t\t\t\t\t},\n\t\t\t\t\t\t\t\tasync:false,\n\t\t\t\t\t\t\t\tsuccess: function(data) {\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t});\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t }\n\t\t\t}\t\t\t\t\t\n\t\t  }\n\t\t}\n\t\tif(selectCheckBoxList!=\'\'){\n\t\t\t\t $.ajax({\n\t\t\t\t\t url:\"../../eBL/jsp/PkgAssociationExistingPackagesValidation.jsp\",\n\t\t\t\t\t type:\'post\',\n\t\t\t\t\t  async:false,\n\t\t\t\t\t data: {\n\t\t\t\t\t\t  operation:    \"encounterChecked\"\t  \n\t\t\t\t\t },          \n\t\t\t\t\t success: function(data) {\n\t\t\t\t\t\t var obj = jQuery.parseJSON(data);\n\t\t\t\t\t  var returnVal =obj.flag;\n\t\t\t\t\t\t  if(returnVal==\"FAIL\"){\n\t\t\t\t\t\t  $(\"#noEncounterToAssociate\").val(\'true\');\n\t\t\t\t\t\t  }else{\n\t\t\t\t\t\t  $(\"#noEncounterToAssociate\").val(\'false\');  \n\t\t\t\t\t\t  }\n\t\t\t\t\t }\t\t\t\t\t \n\t\t\t\t   });  \n\t\t\t}\n\t\t }\n\t\t}\n\t}\n}\n</script>\n</head>\n\n";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block7 ="\n   <script>\n   function select_pat_id()\n\t{\t\n\t\tdocument.forms[0].patientId.focus();\n\t}\t  \n   </script>\n\t\t\n\t<body onLoad=\"select_pat_id();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" >\n\t\n\t<form name=\'frmPkgDefHeader\' id=\'frmPkgDefHeader\' >\n\t<table border=\'0\' cellpadding=\'1\' cellspacing=\'1\' align=\'center\' width=\'100%\'>\n\t<tr>\t\t\n\t\t<td class=\"label\" width=\"25%\"><b>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</b>\n\t\t<INPUT TYPE=\"TEXT\"  name=\"patientId\" id=\"patientId\" SIZE=\"10\" maxlength=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' VALUE=\'\' tabindex =\'1\' onKeyPress=\'changeToUpper()\' onBlur=\"callPatValidation(this);\" ><input type=\'button\' class=\'button\' name=\"patientidbut\" id=\"patientidbut\" value=\'?\' onClick=\"return getPatID()\" tabindex=\'2\'><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t<!-- Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Starts  -->\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<a name=\'assocPkgLink\' id=\'assocPkgLink\' href=\"#\" onClick =\"pkgSubscriptionWindow()\" > Associate Encounter </a>\t\t\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<!--  Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - ends   -->\t \n\t\t</td>\t\n\t</tr>\n</table>\n\n<input type=\'hidden\' name=\'strMessageId\' id=\'strMessageId\' id=\'strMessageId\' value=\"\" >\n<input type=\'hidden\' name=\'strErrorText\' id=\'strErrorText\' id=\'strErrorText\'  value=\"\" >\n<input type=\'hidden\' name=\'alvisitAdmDateHidden\' id=\'alvisitAdmDateHidden\' id=\'alvisitAdmDateHidden\' value=\'\'>\n\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" >\n<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\"\" >\n<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\"\" >\n<input type=\'hidden\' name=\'siteParam\' id=\'siteParam\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" >\n<input type=\'hidden\' name=\'strPackageSeqno\' id=\'strPackageSeqno\' value=\"\" >\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n<input type=\'hidden\' name=\'selectCheckBoxList\' id=\'selectCheckBoxList\' id=\'selectCheckBoxList\' value=\'\'>\n<input type=\'hidden\' name=\'noEncounterToAssociate\' id=\'noEncounterToAssociate\' id=\'noEncounterToAssociate\' value=\'true\'>\n<input type=\'hidden\' name=\'siteBLPkgBlngGrpYN\' id=\'siteBLPkgBlngGrpYN\' id=\'siteBLPkgBlngGrpYN\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<!-- add below 2 hidden fields for NMC-JD-CRF-0084 05-02-2021 STARTS-->\n<input type=\'hidden\' name=\'blPkgDepositSubscription\' id=\'blPkgDepositSubscription\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n<input type=\'hidden\' name=\'sysdateparam\' id=\'sysdateparam\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n<!-- add below 2 hidden fields for NMC-JD-CRF-0084 05-02-2021 EndS-->\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);
 
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	Statement stmt				= null;
	ResultSet rs = null;ResultSet rscurr=null;
	String sysDate="";
	String sysDateTime="";
	int noofdecimal=2;
	String PatIDLen = "";//Added by lakshmi for patient id lenght
	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;
	String facility_id			= (String)session.getAttribute("facility_id");
	ArrayList<String>	episodeTypeList	=	new ArrayList<String>();
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	try {
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
		} catch(Exception ex) {
			System.err.println("Error in PkgSubscriptionHeader.jsp for getting site3TierAlmoFeature Connection: "+ex);
			ex.printStackTrace();
		}	
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

	//Added against GHL-CRF-0631
	boolean isSiteSpec = false;
	String siteBLPkgBlngGrpYN = "N";	
	try {
			isSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "BL_CAL_BY_FACILITY");
			if (isSiteSpec)
				siteBLPkgBlngGrpYN = "Y";
			else
				siteBLPkgBlngGrpYN = "N";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception in isSiteSpec_GHL " + e);
		}
	//Added against GHL-CRF-0631
	
	//add below 2 hidden fields for NMC-JD-CRF-0084 05-02-2021 STARTS
	boolean blPkgDepositSubscription = false;
		try{
			blPkgDepositSubscription = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_PKG_DEPOSIT_SUBSCRIPTION_YN");
			}catch(Exception ex) {
				System.err.println("Error in PkgSubscriptionHeader.jsp for getting site3TierAlmoFeature Connection: "+ex);
				ex.printStackTrace();
			}
	//add below 2 hidden fields for NMC-JD-CRF-0084 05-02-2021 ENDS

	try
	{
		String params = request.getQueryString();		
		String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;
		//Added by lakshmi against patient id length issue starts here
		try{
				String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
				pstmt1=con.prepareStatement(sqlLen);
				rs1=pstmt1.executeQuery();
				while(rs1.next() && rs1!=null){
					PatIDLen   = (rs1.getString("PATIENT_ID_LENGTH")==null)?"0":rs1.getString("PATIENT_ID_LENGTH");
				}
				if(rs1!=null) rs1.close();
				if(pstmt1!=null) pstmt1.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception @ Patient Id Length :"+e);
				e.printStackTrace();
			}
	//Added by lakshmi against patient id length issue ends here
		
		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				if( rs.next() )
					sysDate = rs.getString(1); 
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception @ HEADER sysDate :"+e);
			e.printStackTrace();
		}

	//add for NMC-JD-CRF-0084 05-02-2021 STARTS
	try
	{
		String query_date_time="select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_date_time) ;
		if( rs != null ) 
		{
			if( rs.next() )
				sysDateTime = rs.getString(1); 
		}
	if (rs != null)   rs.close();
	if (stmt != null)   stmt.close();
	}		
	catch(Exception e)
	{
		System.out.println("Exception @ sysdate  :"+e);
		e.printStackTrace();
	}
	
	//add for NMC-JD-CRF-0084 05-02-2021 ENDS

		try{		
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
				rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					noofdecimal  =  rscurr.getInt(1);		
				}	
				if(rscurr != null) rscurr.close();
				pstmt.close();
			}catch(Exception e) {System.out.println("3="+e.toString());
				e.printStackTrace();
			}
		
		/* Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Starts*/
		String siteParam="";				
		
			try{
				String siteParamSql = "Select CUSTOMER_ID from SM_SITE_PARAM ";
				pstmt = con.prepareStatement(siteParamSql);		
				rs1 = pstmt.executeQuery();
				if(rs1 != null){
					while(rs1.next()){
						siteParam = rs1.getString("CUSTOMER_ID");
						if(siteParam==null){
							siteParam="";
						}
					}
				}			
				pstmt = null;
				rs1 = null;			
			}
			catch(Exception e)
			{
					System.out.println("Exception in getting bl_param"+e);
			}		
		/* Karthik added for adding Package Association along with subscription 43507  -   MMS-QH-CRF-0139  - Ends*/

   
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block9Bytes, _wl_block9);
 //Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		if(siteParam.equals("ALMO") || site3TierAlmoFeature == true){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}//Ended V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(siteParam));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(siteBLPkgBlngGrpYN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(blPkgDepositSubscription));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sysDateTime));
            _bw.write(_wl_block18Bytes, _wl_block18);

	}
	catch(Exception e)
	{
		System.out.println("Exception from Package defintion header :"+e);
		e.printStackTrace();
	}
	finally
	{
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
		if(pstmt !=null) pstmt.close();
		if(rs1!=null) rs1.close();//Added by lakshmi against patient id length 
		if(pstmt1 !=null) pstmt1.close();//Added by lakshmi against patient id length
		if(con !=null) ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
}
