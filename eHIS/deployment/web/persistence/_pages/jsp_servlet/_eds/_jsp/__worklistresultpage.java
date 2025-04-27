package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eDS.Common.DlQuery;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import eCommon.Common.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __worklistresultpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/WorkListResultPage.jsp", 1743595516339L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="<!--Modified Against ML-MMOH-CRF-0672-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/json.js\"></script>\n\t<script type=\"text/javascript\">\n\t\tvar jsonPatientArr = new Array();\n\t\tvar checkAllPatientArr = new Array(); \n\t\tvar jsonPatientObject = new Object();\t\n\t\tvar jsonData;\n\t\tvar pageJsonData;\n\t\tvar checkAllData;\n\t\tvar tempObj=eval(\'(\' + parent.patientObj_NextPrev + \')\');\n\n\t\tif(tempObj !=null && tempObj.patients !=null) {\n\t\t\tjsonPatientArr=eval(\'(\' + parent.patientObj_NextPrev + \')\').patients;\n\t\t\tjsonPatientObject.patients=jsonPatientArr;\n\t\t\tjsonData=parent.patientObj_NextPrev;\t\t\n\t\t}\n\t\t\n\t\t//Added for CRF-0113 Started\n\t\tvar scrollValue=0;\n        \tvar reorder = \'\'; \n\t\tvar anchorID =\'\'; \n\t\t\n//Added Against ML-MMOH-CRF-0600 Starts Here ToolTip\nfunction PendingMealAckToolTip(facility_Id,encounter_Id){\t   \n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\tvar xmlStr =\"<root></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\tvar param=\"facility_Id=\"+facility_Id+\"&encounter_Id=\"+encounter_Id+\"&mode=pendingMealOrderAckDetail_IP\";\n\txmlHttp.open(\"POST\", \"../../servlet/eDS.PlaceDietOrderServlet?\"+param,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = xmlHttp.responseText;\t\n\tvar jsonObjResponse=eval(\'(\' + retVal + \')\');\t\n\tvar orderList=new Array();\n\torderList = jsonObjResponse.jsonMealPendingListIP; \n\tvar OrderDate=getLabel(\"eDS.OrderDate.Label\",\"ds_labels\");\n\tvar MealType=getLabel(\"eDS.MealType.Label\",\"ds_labels\");\n\tvar Status=getLabel(\"eDS.Status.Label\",\"ds_labels\");\t\n\tvar tab_dat  = \"<table id =\'tooltiptable1\' cellpadding=\'3\' cellspacing=0 border=\'1\' class=\'BOX\' width=\'100%\' height=\'100%\' align=\'center\'>\";\n\t\ttab_dat     += \"<tr>\"\n\t\ttab_dat     += \"<th nowrap> <B>\"+OrderDate+\"</B> </a> </th>\"\n\t\ttab_dat     += \"<th nowrap> <B>\"+MealType+\" </B> </a> </th>\"\n\t\ttab_dat     += \"<th nowrap> <B>\"+Status+\"</B> </a> </th>\"\n\t\ttab_dat     += \"</tr> \";\n\t\tfor(var i=0;i<orderList.length;i++)\n\t\t{\t\n\t\t\ttab_dat     += \"<tr>\"\n\t\t\ttab_dat     += \"<td class=\'label\'> \"+(orderList[i].serving_date).substring(0,10)+\" </td>\"\n\t\t\ttab_dat     += \"<td class=\'label\'>\"+orderList[i].mealtypeDesc+\" </td>\"\n\t\t\ttab_dat     += \"<td class=\'label\'>\"+orderList[i].status+\"</td>\"\n\t\t\ttab_dat     += \"</tr> \";\n\t\t}\t\n\t\ttab_dat     += \"</table> \";\n\t\treturn tab_dat;\n   }\n//Added Against ML-MMOH-CRF-0600 Ends Here ToolTip\n\n//function callOrderBy(obj,searchFor,status,NursingUnit,encounterId,patientId,patient_Name,room,bed,sex,fromDate,toDate){\nfunction callOrderBy(obj,alaCarte,searchFor,status,NursingUnit,encounterId,patientId,patient_Name,room,bed,sex,fromDate,toDate){//ML-MMOH-CRF-1123-US2\n\tvar url=\'&orderBy=\'+obj+\'&reOrder=\'+reOrder+\'&anchorID=\'+anchorID+\'&leftScrolling=\'+scrollValue+\'&alaCarte=\'+alaCarte+\'&searchFor=\'+searchFor+\'&status=\'+status+\'&NursingUnit=\'+NursingUnit+\'&encounterId=\'+encounterId+\'&patientId=\'+patientId+\'&room=\'+room+\'&bed=\'+bed+\'&sex=\'+sex+\'&patient_Name=\'+patient_Name+\'&fromDate=\'+fromDate+\'&toDate=\'+toDate;//ML-MMOH-CRF-1123-US2\n     parent.parent.workListResult.qa_query_result.location.href =\'WorkListResultPage.jsp?\'+url;\n   }       \t\n\t\nfunction changeColor(object)\n{\n\tanchorID=object.id;\t\t\n\tif(object.style.color==\'white\')\n  {\n\treOrder=\'1\';\t\t\n\tobject.style.color=\'pink\';\n\treturn;\n  }\n\tif(object.style.color==\'pink\')\n  {\n\treOrder=\'2\';\n\tobject.style.color=\'yellow\';\n\treturn;\n  }\n\tif(object.style.color==\'yellow\')\n  {\n\treOrder=\'1\';\n\tobject.style.color=\'pink\';\n\treturn;\n  }\n}\n//Added for CRF-0113 End\t\n\nasync function showContent(encounterId,patientId,locationCode,patientClass,room,bed,locationType,dateOfBirth,gender,flag,isLos_gt7,diffDays,alaCarte){\n\tif(!placedietorder())\t//IN::39863\n\treturn;\t\n\tvar params = \"&encounterId=\"+encounterId+\"&patientId=\"+patientId+\"&locationCode=\"+locationCode+\"&patientClass=\"+patientClass+\"&room=\"+room+\"&bed=\"+bed+\"&locationType=\"+locationType+\"&dateOfBirth=\"+dateOfBirth+\"&gender=\"+gender+\"&flag=\"+flag+\"&diffDays=\"+diffDays+\"&isLos_gt7=\"+isLos_gt7+\"&alaCarte=\"+alaCarte;//Modified Against ML-MMOH-CRF-0672 and ML-MMOH-CRF-1123-US3\n\tvar url = \"../../eDS/jsp/PlaceDietOrderDSMain.jsp?\"+params;\n\tvar returnVal=\"\";\n\t//var dialogFeatures = \"dialogHeight:\" + 500 + \"; dialogWidth:\" + 500 + \"; scroll:no; status:no;\";\n\tvar dialogTop   = \"65\";\n    var dialogHeight    = \"900px\" ; //30.5\n    var dialogWidth = \"1200px\" ;\n    var dialogFeatures    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop + \"; status: no\" ;\n\tvar arguments = \"\";\n\treturnVal =await top.window.showModalDialog(url, arguments, dialogFeatures);\n\tparent.frames.qa_query_result.location.href =\"../../eDS/jsp/WorkListResultPage.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\tparent.frames.qa_query_result_tail.location.href =\"../../eDS/jsp/WorkListResultTailLegend.jsp\";\t\t\t\t\n}\n\t\t\nasync function PlaceDietOrder_Group(){\t\t\t\n\tvar encounterIds_BulkOrder=document.getElementById(\"encounterIds_BulkOrder\").value;\n\tvar patientIds_BulkOrder=document.getElementById(\"patientIds_BulkOrder\").value;\n\tvar locationCode=document.getElementById(\"locationCode\").value;\n\tvar locationType=document.getElementById(\"locationType\").value;\t\t\n\tvar patientClass_bulk=document.getElementById(\"patientClass_bulk\").value;//ML-MMOH-CRF-0820\n\tvar alaCarte=document.getElementById(\"alaCarte\").value;//ML-MMOH-CRF-1123-US4\n\tvar params =\"locationCode=\"+locationCode+\"&locationType=\"+locationType+\"&patientClass_bulk=\"+patientClass_bulk+\"&alaCarte=\"+alaCarte;//ML-MMOH-CRF-0820 and Modified Against ML-MMOH-CRF-1123-US4\n\n\tvar url = \"../../eDS/jsp/PlaceBulkDietOrderMain.jsp?\"+params;\n\tvar returnVal=\"\";\n\tvar dialogFeatures = \"dialogHeight:\" + 100 + \"; dialogWidth:\" + 100 + \"; scroll:yes; status:no;\";\n\tvar arguments = \"\";\n\tvar obj=eval(\'(\' + jsonData + \')\');\n\tif(obj==null) {\n\t\talert(getMessage(\"DS_SEL_ATLEAST_2PAT\",\"DS\"));\n\t\treturn;\t\t\t\t\n\t}\n\tif(obj.patients==null) {\n\t\talert(getMessage(\"DS_SEL_ATLEAST_2PAT\",\"DS\"));\n\t\treturn;\t\t\t\t\n\t}\t\t\t\n\tif(obj.patients.length<2) {\n\t\talert(getMessage(\"DS_SEL_ATLEAST_2PAT\",\"DS\"));\n\t\treturn;\n\t}\n\treturnVal = await window.showModalDialog(url, obj, dialogFeatures);\n\n\tparent.frames.qa_query_result.location.href =\"../../eDS/jsp/WorkListResultPage.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tparent.frames.qa_query_result_tail.location.href =\"../../eDS/jsp/WorkListResultTailLegend.jsp\";\t\t\t\n}\n\t\t\nfunction bulkOrder(encounterId,patientId,patientClass,dob,gender,profileSL,profileFromDate,obj,age,ageUnit,spFlag,dislikeFlag,diffDays) {//Added Against ML-MMOH-CRF-0672\t\n\tvar encounterIds_BulkOrder=document.getElementById(\"encounterIds_BulkOrder\").value;\n\tvar patientIds_BulkOrder=document.getElementById(\"patientIds_BulkOrder\").value;\n\tvar patientClass_bulk=document.getElementById(\"patientClass_bulk\").value;//ML-MMOH-CRF-0820\n\t\n\tvar jsonDataObject = new Object();\n\tif(obj.checked) {\n\t\tdocument.getElementById(\"encounterIds_BulkOrder\").value=encounterIds_BulkOrder+\"\"+encounterId+\"~\";\n\t\tdocument.getElementById(\"patientIds_BulkOrder\").value=patientIds_BulkOrder+\"\"+patientId+\"~\";\n\t\tdocument.getElementById(\"patientClass_bulk\").value =patientClass_bulk+\"\"+patientClass+\"~\";//ML-MMOH-CRF-0820\n\t\tjsonDataObject.encounterId=encounterId;\n\t\tjsonDataObject.patientId=patientId;\n\t\tjsonDataObject.patientClass=patientClass;\n\t\tjsonDataObject.dob=dob;\n\t\tjsonDataObject.gender=gender;\n\t\tjsonDataObject.profileSL=profileSL;\n\t\tjsonDataObject.fromDate=profileFromDate;\n\t\tjsonDataObject.age=age;\n\t\tjsonDataObject.ageUnit=ageUnit;\n\t\tjsonDataObject.spFlag=spFlag;\n\t\tjsonDataObject.dislikeFlag=dislikeFlag;\n\t\tjsonDataObject.newFlag=\"\";\t\t\t\t\n\t\tjsonDataObject.diffDays=diffDays;//Added Against ML-MMOH-CRF-0672 \n\t\tjsonPatientArr.push({patient:jsonDataObject});\n\t}\n\telse {\n\t\tfor(var i=0;i<jsonPatientArr.length;i++) {\n\t\t\tvar testObj=new Object();\n\t\t\ttestObj=jsonPatientArr[i];\n\t\t\tif(testObj.patient.encounterId==encounterId) {\n\t\t\t\tjsonPatientArr.splice(i,1);\n\t\t\t}\n\t\t}\n\t\tdocument.getElementById(\"chkAll\").checked=false;\n\t\t\n\t\tif(tempObj !=null && tempObj.patients !=null) {\n\t\t\tvar obj=eval(\'(\' + parent.patientObj_NextPrev + \')\').patients;\n\t\t\tfor(var cnt=0;cnt<obj.length;cnt++) {\n\t\t\t\tvar testObj=new Object();\n\t\t\t\ttestObj=obj[cnt];\n\t\t\t\tif(testObj.patient.encounterId==encounterId) {\n\t\t\t\t\tobj.splice(cnt,1);\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}\n\t\t\tvar obj1={};\n\t\t\tobj1.patients=obj;\n\t\t\tparent.patientObj_NextPrev=JSON.stringify(obj1);\n\t\t}\n\t}\n\tjsonPatientObject.patients=jsonPatientArr;\t\t\t\n\tjsonData = JSON.stringify(jsonPatientObject);\n\n\tvar obj=eval(\'(\' + jsonData + \')\');\n\tif(obj.patients==null) {\n\t\tdocument.getElementById(\"Button_BulkOrder\").disabled=true;\n\t\treturn;\n\t}\t\n\telse if(obj.patients.length<2) {\n\t\tdocument.getElementById(\"Button_BulkOrder\").disabled=true;\n\t}\n\telse {\n\t\tdocument.getElementById(\"Button_BulkOrder\").disabled=false;\n\t}\n}\n\nfunction checkAll(obj){\n\tvar encounterId=\" \";\n\tif(obj.checked) {\n\t\tif(tempObj !=null && tempObj.patients !=null) {\n\t\t\tjsonPatientArr=eval(\'(\' + parent.patientObj_NextPrev + \')\').patients;\n\t\t}\n\t\telse {\n\t\t\tjsonPatientArr.splice(0,jsonPatientArr.length);\n\t\t\tjsonPatientObject={};\t\t\t\t\t\n\t\t}\n\t\tfor(var i=0;i<checkAllPatientArr.length;i++) {\t\t\t\t\t\n\t\t\tencounterId=checkAllPatientArr[i].patient.encounterId;\t\t\t\t\t\n\t\t\tif(document.getElementById(\"chk\"+encounterId)!=null && document.getElementById(\"chk\"+encounterId).disabled !=true) {//Added Against ML-MMOH-CRF-0600\n\t\t\t\tjsonPatientArr.push({patient:checkAllPatientArr[i].patient});\n\t\t\t\tdocument.getElementById(\"chk\"+encounterId).checked=true;\n\t\t\t}\n\t\t}\n\t\tjsonPatientObject.patients=jsonPatientArr;\n\t}\n\telse {\n\t\tif(tempObj!=null && tempObj.patients!=null) {\n\t\t\tjsonPatientArr.splice(0,jsonPatientArr.length);\n\t\t\tjsonPatientArr=eval(\'(\' + parent.patientObj_NextPrev + \')\').patients;\n\t\t\tjsonPatientObject={};\n\t\t\tjsonPatientObject.patients=jsonPatientArr;\n\t\t}\n\t\telse {\n\t\t\tjsonPatientArr.splice(0,jsonPatientArr.length);\n\t\t\tjsonPatientObject={};\n\t\t}\n\t\tfor(var i=0;i<checkAllPatientArr.length;i++) {\n\t\t\tencounterId=checkAllPatientArr[i].patient.encounterId;\n\t\t\tif(document.getElementById(\"chk\"+encounterId)) {\n\t\t\t\n\t\t\t\tdocument.getElementById(\"chk\"+encounterId).checked=false;\n\t\t\t\t\n\t\t\t\tfor(var cnt=0;cnt<jsonPatientArr.length;cnt++) {\n\t\t\t\t\tvar testObj=new Object();\n\t\t\t\t\ttestObj=jsonPatientArr[cnt];\n\t\t\t\t\tif(testObj.patient.encounterId==encounterId) {\n\t\t\t\t\t\tjsonPatientArr.splice(cnt,1);\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(tempObj !=null && tempObj.patients !=null) {\n\t\t\t\t\tvar obj=eval(\'(\' + parent.patientObj_NextPrev + \')\').patients;\n\t\t\t\t\tfor(var cnt=0;cnt<obj.length;cnt++) {\n\t\t\t\t\t\tvar testObj=new Object();\n\t\t\t\t\t\ttestObj=obj[cnt];\n\t\t\t\t\t\tif(testObj.patient.encounterId==encounterId) {\n\t\t\t\t\t\t\tobj.splice(cnt,1);\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tvar obj1={};\n\t\t\t\t\tobj1.patients=obj;\n\t\t\t\t\tparent.patientObj_NextPrev=JSON.stringify(obj1);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tjsonPatientObject={};\n\t\tjsonPatientObject.patients=jsonPatientArr;\t\t\t\t\n\t}\n\tjsonData = JSON.stringify(jsonPatientObject);\n\tvar obj=eval(\'(\' + jsonData + \')\');\n\tif(obj==null || obj.patients==null) {\n\t\tdocument.getElementById(\"Button_BulkOrder\").disabled=true;\n\t\treturn;\n\t}\t\t\t\n\telse if(obj.patients.length<2) {\n\t\tdocument.getElementById(\"Button_BulkOrder\").disabled=true;\n\t}\n\telse {\n\t\tdocument.getElementById(\"Button_BulkOrder\").disabled=false;\n\t}\t\t\t\n}\n\t\t\nfunction savePatientObj() {\t\n\tparent.patientObj_NextPrev=JSON.stringify(jsonPatientObject);\t\t\n}\n</script>\n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script><!--Added Against ML-MMOH-CRF-0600-US2 ToolTip--> \n\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t<form name=\'QueryResult\' id=\'QueryResult\'>\n\t<input type=\"hidden\" name=\"locationCode\" id=\"locationCode\" value=\"\">\n\t<input type=\"hidden\" name=\"locationType\" id=\"locationType\" value=\"\">\n\t<input type=\"hidden\" name=\"maxAge\" id=\"maxAge\" value=\"\">\n\t<input type=\"hidden\" name=\"ageUnit\" id=\"ageUnit\" value=\"\">\n\t<input type=\"hidden\" name=\"patientClass\" id=\"patientClass\" value=\"\">\n\t<input type=\"hidden\" name=\"alaCarte\" id=\"alaCarte\" id=\"alaCarte\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"><!--Added Against ML-MMOH-CRF-1123-US4 -->\n<table  align=\'right\'>\n<tr><td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<A HREF=\"../../eDS/jsp/WorkListResultPage.jsp?from=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&to=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&whereclause=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&NursingUnit=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&status=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&encounterId=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&patientId=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&patient_Name=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&room=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&bed=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&sex=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&fromDate=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&toDate=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&reOrder=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&anchorID=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&alaCarte=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onclick =\"savePatientObj();\" text-decoration=\'none\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</A> \n\t<!--CRF-410 & CRF-0113 & CRF-1005-US2 and Modified Against ML-MMOH-CRF-1123-US3-->\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="     \n\t<A HREF=\"../../eDS/jsp/WorkListResultPage.jsp?from=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"  onclick=\"savePatientObj();\"  text-decoration=\'none\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</A>\n\t<!--CRF-410 & CRF-0113 & CRF-1005-US2 and Modified Against ML-MMOH-CRF-1123-US3-->\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</td></tr>\n</table>\n<br><br>\n<!-- Added for CRF-0113 Start -->\n<table  class=\'grid\' id=\'PatCriteriaTbl\' name=\'PatCriteriaTbl\' border=\"1\" cellpadding=\"1\" cellspacing=\"0\" width=\"100%\" >\n\t<tr>\n\t\n\t\t<TH class=\'columnHeadercenter\' nowrap> <a id = \'w10\' href=\"javascript:callOrderBy(\'AD\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');\" onclick=\'changeColor(this);\' style=\'color:white\' >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<!-- CRF-0113-->\n    <div style=\'vertical-align:middle; display:inline;\'>\n\t<span id=\'admId\' value=\"w10\"></span>\n\t</div>\n\t\t    </TH>\n\t\t<TH  class=\'columnHeadercenter\' nowrap> <a id = \'w01\' href=\"javascript:callOrderBy(\'EN\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</a><!--Modified Against ICN:74084-->\n\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t<span id=\'encId\' value=\"w01\"></span>\n\t\t</div>\n        </TH>\n\t\t<TH   class=\'columnHeadercenter\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t</TH>\n\t\t<!-- //CRF-410TH>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t</TH //CRF-410-->\t\t\n\t\t<TH   class=\'columnHeadercenter\' nowrap> <a id = \'w03\' href=\"javascript:callOrderBy(\'PI\',\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</a><!--Modified Against ICN:74084-->\n\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t<span id=\'patId\' value=\"w03\"></span>\n\t\t\t</div> <!-- CRF-0113-->\n\t\t</TH>\n\t\t<TH   class=\'columnHeadercenter\' nowrap> <a id = \'w04\' href=\"javascript:callOrderBy(\'PN\',\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</a>\n\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t<span id=\'patNamId\' value=\"w04\"></span>\n\t\t\t</div><!-- CRF-0113-->\n\t\t</TH>\n\t\t<TH   class=\'columnHeadercenter\' nowrap> <a id = \'w05\' href=\"javascript:callOrderBy(\'GN\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</a>\n\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t<span id=\'genId\' value=\"w05\"></span>\n\t\t\t</div><!-- CRF-0113-->  \n\t\t</TH>\n\t\t<!--TH class=\'columnHeadercenter\' nowrap> \n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</a>\n\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\t\n\t\t\t<span id=\'locId\' value=\"w06\"></span>\n         \t</div>\n\t\t</TH--><!-- Commented Against PMG2017-COMN-CRF-0012[IN066074] -->\n\t\t<TH   class=\'columnHeadercenter\' nowrap> <a id = \'w07\' href=\"javascript:callOrderBy(\'BD\',\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</a>\n\t\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t\t<span id=\'bedId\' value=\"w07\"></span><!-- CRF-0113-->\n\t\t\t</div>\n\t\t</TH>\n\t\t<TH   class=\'columnHeadercenter\' nowrap> <a id = \'w08\' href=\"javascript:callOrderBy(\'RM\',\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</a>\n\t\t<div style=\'vertical-align:middle; display:inline;\'>\n\t\t<span id=\'roomId\' value=\"w08\"></span> <!-- CRF-0113-->\n\t\t</div>\n\t\t</TH>\n\t\t<TH>\n\t\t\t<input type=\"checkbox\" name=\"chkAll\" id=\"chkAll\" id =\"ChkAll\" onclick=\"checkAll(this)\"/>\n\t\t</TH>\n\t</tr>\n<!-- Added for CRF-0113 End -->\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t<script>\n\t\t\t\tdocument.getElementById(\"locationCode\").value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\';\n\t\t\t\tdocument.getElementById(\"locationType\").value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\';\n\t\t\t\tvar ageGroup = \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\t\t\n\t\t\t\tif(parseInt(ageGroup.length)<11){ageGroup=ageGroup+\" 00:00\";}\n\t\t\t\t\n\t\t\t\tvar ageGroupArray = new Array();\n\t\t\t\tageGroupArray\t=  ageGroup.split(\" \");\n\t\t\t\tageGroupArray1\t=\tageGroupArray[0].split(\"/\");\n\t\t\t\tvar today=new Date();\n\t\t\t\tvar dob=new Date(ageGroupArray1[2], ageGroupArray1[1], ageGroupArray1[0]);\n\t\t\t\tvar one_day=1000*60*60*24;\n\n\t\t\t\t//Calculate difference btw the two dates, and convert to days\n\n\t\t\t\tvar days1=Math.floor((dob.getTime()-today.getTime())/(one_day))+1;\n\n\t\t\t\tvar year=365;\n\t\t\t\tvar month=30;\n\t\t\t\tvar years = parseInt(days1)/parseInt(year)\n\t\t\t\tdays2=parseInt(days1)%parseInt(year)\n\t\t\t\tvar months=Math.floor(parseInt(days2)/parseInt(month));\n\t\t\t\tvar days=Math.floor(parseInt(days2)%parseInt(month));\n\t\t\t\t\n\t\t\t\tvar maxAge = \'\';\n\t\t\t\tvar ageUnit = \'\';\n\n\t\t\t\tif( parseInt(Math.abs(years)) > 0){\n\t\t\t\t\tmaxAge=  parseInt(Math.abs(years));\n\t\t\t\t\tageUnit = \'Y\';\n\t\t\t\t}else if(parseInt(Math.abs(months)) > 0){\n\t\t\t\t\tmaxAge =  parseInt(Math.abs(months));\n\t\t\t\t\tageUnit = \'M\';\n\t\t\t\t}else if( parseInt(Math.abs(days)) > 0){\n\t\t\t\t\tmaxAge =  parseInt(Math.abs(days));\n\t\t\t\t\tageUnit = \'D\';\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\"maxAge\").value=maxAge;\n\t\t\t\tdocument.getElementById(\"ageUnit\").value=ageUnit; \n\t\t\t</script>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' width=\'12%\' nowrap>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t\t\n\t\t\t\t<!--MMS-CRF-006-->\n\t\t\t\t<!-- Modified against ML-MMOH-CRF-0600-US2 and ML-MMOH-CRF-1005-US2 starts-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t   <td width=\'12%\' nowrap style=\"font-size:7pt;font-weight:normal;color:;background-color:\" >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t   <img src=\"../../eDS/css/Action_Pending.PNG\" onClick=\"Tip(PendingMealAckToolTip(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'),FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\"  onmouseout=\'UnTip();\'></img><img src=\"../../eOT/images/drugInfo.gif\"></img><img src=\"../../eDS/css/Mother_Accompany_Child.png\"></img><!--Changes against on Mouseout issue-->\n\t\t\t\t\t\t  \n\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t       <td width=\'12%\' nowrap>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" \n\t\t\t\t\t\t   <img src=\"../../eOT/images/drugInfo.gif\"></img><img src=\"../../eDS/css/Action_Pending.PNG\"  onClick=\"Tip(PendingMealAckToolTip(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'),FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\" onmouseout=\'UnTip();\'></img><!--Changes against on Mouseout issue-->\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t   <img src=\"../../eOT/images/drugInfo.gif\"></img><img src=\"../../eDS/css/Mother_Accompany_Child.png\"></img>\n\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t   <img src=\"../../eDS/css/Action_Pending.PNG\"  onClick=\"Tip(PendingMealAckToolTip(\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'),FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\" onmouseout=\'UnTip();\'></img><img src=\"../../eDS/css/Mother_Accompany_Child.png\"></img><!--Changes against on Mouseout issue-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<img src=\"../../eOT/images/drugInfo.gif\"></img>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t    <td width=\'12%\' nowrap>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="<img src=\"../../eDS/css/Mother_Accompany_Child.png\"></img>\n\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="<img src=\"../../eOT/images/drugInfo.gif\"></img><img src=\"../../eDS/css/Mother_Accompany_Child.png\"></img>\n\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t<!-- Modified against ML-MMOH-CRF-0600-US2 and ML-MMOH-CRF-1005-US2 ends-->\n\t\t\t\t\t<!--MMS-CRF-006-->\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' width=\'12%\' nowrap>\n\t\t\t\t\t<!-- Added Against ML-MMOH-CRF-0672 Starts Here-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\n\t\t\t\t  <!--Modified Against ML-MMOH-CRF-0600-US2 starts -->\n\t\t\t\t    ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t<a href disabled = \"javascript:showContent(\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\')\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" </a> <!-- Modified Against ML-MMOH-CRF-1123-US3 -->\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t<a href = \"javascript:showContent(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" </a> <!--Modified Against ML-MMOH-CRF-1123-US3 -->\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" </a> <!--Modified Against ML-MMOH-CRF-1123-US3 -->\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n               \t\t\t  <!--Modified Against ML-MMOH-CRF-0600-US2 ends-->\n\t\t\t\t\t\t  \t\t\t\n\t\t\t\t\t<!-- Added Against ML-MMOH-CRF-0672 Ends Here-->\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</td><!-- Added Against  PMG2017-CRF-0012[IN:066074]-->\n\t\t\t\t\t<!--td class= width=\'12%\' nowrap></td>--location -->\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' nowrap>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\n\t\t\t\t\t<td style=\"display:none;\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"dischargePatientYN\" id=\"dischargePatientYN\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t\t</td>\n\t\t\t\t\t<!--ML-MMOH-CRF-0600-US2  and  ML-MMOH-CRF-0672 Ends Here-->\n\t\t\t\t\t<!--Modified Against ML-MMOH-CRF-0600-US2 starts -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' >\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"chk";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\'chk";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="disabled";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" onclick=\"bulkOrder(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\',this,\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\')\"/disabled></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t\t\t\t\t<input type=\"checkbox\" name=\"chk";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\')\"/></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t<!--Modified Against ML-MMOH-CRF-0600-US2 ends -->\n\t\t\t\t\n\t\t\t\t<script>\n\t\t\t\t\t\tvar obj=new Object();\n\t\t\t\t\t\tvar flag1=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\t\t\t\t\t\t\n\t\t\t\t\t\tobj.encounterId=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\t\t\t\t\t\tobj.patientId=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\t\t\t\t\t\tobj.patientClass=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n\t\t\t\t\t\tobj.dob=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\";\n\t\t\t\t\t\tobj.gender=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\";\n\t\t\t\t\t\tobj.profileSL=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\";\n\t\t\t\t\t\tobj.fromDate=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\";\t\t\t\t\t\t\n\t\t\t\t\t\tobj.age=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\";\n\t\t\t\t\t\tobj.ageUnit=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\t\t\t\t\tobj.spFlag=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\";\n\t\t\t\t\t\tobj.dislikeFlag=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\";\n\t\t\t\t\t\tobj.newFlag=\"\";\n\t\t\t\t\t\tobj.diffDays=";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =";//Added Against ML-MMOH-CRF-0672 \n\t\t\t\t\t\t\n\t\t\t\t\t\tif(flag1!=\'Y\') {\n \t\t\t\t\t\t\tcheckAllPatientArr.push({patient:obj});\n\t\t\t\t\t\t}\n \t\t\t\t\t\t\n\t\t\t\t</script>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n</table>\n\t<input type=\"hidden\" name=\"patientIds_BulkOrder\" id=\"patientIds_BulkOrder\" value=\"\">\n\t<input type=\"hidden\" name=\"encounterIds_BulkOrder\" id=\"encounterIds_BulkOrder\" value=\"\">\n\t<input type=\"hidden\" name=\"patientClass_bulk\" id=\"patientClass_bulk\" value=\"\">\n\t\n\t<!-- Added for CRF-0113 -->\n\t<input type=\"hidden\" name=\"reOrder\" id=\"reOrder\"  value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t<input type=\"hidden\" name=\"orderBy\" id=\"orderBy\"  value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t<input type=\"hidden\" name=\"anchorID\" id=\"anchorID\"  value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t<!-- Added for CRF-0113 -->\n      \n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t <table border=\'1\' width=\'100%\'>\n\t<tr align=\"right\">\n\t\t<td>\n\t\t\t<input type=\"button\" name=\"Button_BulkOrder\" id=\"Button_BulkOrder\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" class=\"button\" onClick=\"PlaceDietOrder_Group()\" disabled=\"true\"/>\n\t\t</td>\n\t</tr>\n\t</table>\n\t<script>\n\tif(jsonPatientArr.length >=2) {\n\t\tdocument.getElementById(\"Button_BulkOrder\").disabled=false;\n\t}\n\tvar count=0;\n\tfor(var i=0;i<jsonPatientArr.length;i++) {\n\t\tvar testObj=new Object();\n\t\ttestObj=jsonPatientArr[i];\n\t\tvar id=testObj.patient.encounterId;\n\t\tif(document.getElementById(\"chk\"+id)) {\n\t\t\tdocument.getElementById(\"chk\"+id).checked=true;\n\t\t\tcount++;\n\t\t}\n\t}\n\tif(checkAllPatientArr.length==count) {\n\t\tdocument.getElementById(\"chkAll\").checked=true;\n\t}\n\t\n\t</script>\t\n";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\n</form>\n<!-- Added for CRF-0113-->\n <script >\n       ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n       var str = document.querySelectorAll(\'#PatCriteriaTbl\');\n        console.log(str);\n\t\tvar con = str.toString();\n\t\tvar ch1 = con.split(\",\");\n\t\tvar res = ch1[0].substring(24,26);\n\t\n\t  if(\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'==\'1\')\n\t  {   \n       var ch = \"\";\n       ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n       ch = document.getElementById(\'PatCriteriaTbl\').style.color= \'pink\';\n\t\tif(res == \"EN\")\n\t\t{\t\t   \n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \";\n\t\t}\n\t\telse if(res == \"AD\")\n\t\t{\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \";\n\t\t\t\n\t\t}\n\t\telse if (res == \"PI\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \"         \n\t\t}\n\t\telse if (res == \"PN\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \"         \n\t\t}\n\t\telse if (res == \"GN\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \"         \n\t\t}\t\t\n\t\telse if (res == \"BD\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \";\n         \n\t\t}else if (res == \"RM\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \"+\"<img src=../../eDS/css/Maxtomin.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\t\t\t         \n\t\t}\t\t\n\t}\n\telse if(\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'==\'2\')\n\t{\t\t\n\t\tch = document.getElementById(\'PatCriteriaTbl\').style.color=\'yellow\';\n\t\tif(res == \'EN\')\n\t\t{\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \";\n\t\t}\n\t\telse if(res == \"AD\")\n\t\t{\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \";\t\t\t\n\t\t}\n\t\telse if (res == \"PI\"){\t\t\t\n\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \"         \n\t\t}\n\t\telse if (res == \"PN\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \"         \n\t\t}\n\t\telse if (res == \"GN\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \"         \n\t\t}\t\t\n\t\telse if (res == \"BD\"){\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \"         \n\t\t}else if (res == \"RM\"){\t\t\t\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').roomId.innerHTML= \" \"+\"<img src=../../eDS/css/Mintomax.PNG></img>\";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').encId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').admId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').patNamId.innerHTML= \" \";\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').genId.innerHTML= \" \";\n\t\t\t//ch.innerHTML =document.getElementById(\'PatCriteriaTbl\').locId.innerHTML= \" \"; //Commented Against PMG2017-COMN-CRF-0012[IN066074]\n\t\t\tch.innerHTML =document.getElementById(\'PatCriteriaTbl\').bedId.innerHTML= \" \";         \n\t\t}\t\t\n\t}\t\n</script>\n</body>\n\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
	(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	String facility_Id	= (String)session.getAttribute("facility_id");
	String language_Id  = (String)session.getAttribute("LOCALE");
	session.removeAttribute("ALLMENUITEMSMAP"); // AAKH-CRF-0065
	String param = request.getQueryString();
 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(param));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(param));
            _bw.write(_wl_block10Bytes, _wl_block10);

		String whereClause = checkForNull(request.getParameter("whereclause"));
		if(whereClause==null) whereClause="";
   	    String sql = "";
   	    int maxRecord = 0;
		//MMS-CRF-006
		PreparedStatement pstmt=null,pstmt1 = null,pstmt2=null,pstmt3=null,pstmt4=null,pstmt5=null,pstmt6=null,pstmt7=null,pstmt_KitchenCode = null,pstmt8=null,pstmt9=null,pstmt10 = null,pstmt11 = null;//Modified Against ML-MMOH-CRF-1005-US2 
		ResultSet rst=null,rst1 = null,rst2=null,rst3=null,rst4=null,rst5=null,rst6=null,rst7=null,rst_KitchenCode=null,rst8=null,rst9=null,rst10=null,rst11=null;//Modified Against ML-MMOH-CRF-1005-US2 

		Connection conn = null;
		conn = ConnectionManager.getConnection(request);
       //  	String visitStyle ="";//Added for CRF-0113
		//Added Against ML-MMOH-CRF-0672 Starts Here
		boolean isLos_gt7=false;
		isLos_gt7=CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");
		//Using same function for Selayang
		//Added Against ML-MMOH-CRF-1123-US2 Starts Here
		boolean isAlaCarte=false;
		isAlaCarte=CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");
		//Added Against ML-MMOH-CRF-1123-US2 Ends Here
		
		//Added Against ML-MMOH-SCF-1804 Starts
		boolean isBedNum = false;
		isBedNum = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_COMPLAINTS");
		//Added Against ML-MMOH-SCF-1804 Ends
		
		//Added Against ML-MMOH-CRF-0672 Ends Here
		String NursingUnit = request.getParameter("NursingUnit");
		String encounterId = request.getParameter("encounterId");
		String patientId = request.getParameter("patientId");
		String practitionerId = request.getParameter("practitionerId");
		String sex = request.getParameter("sex");
		String fromDate = com.ehis.util.DateUtils.convertDate(request.getParameter("fromDate"),"DMY", language_Id, "en");
		String toDate = com.ehis.util.DateUtils.convertDate(request.getParameter("toDate"),"DMY", language_Id, "en");
		String from = checkForNull(request.getParameter("from"));
		String to = checkForNull(request.getParameter( "to" ));
		String status = checkForNull(request.getParameter("status"));
		//MMS-CRF-006
		String searchFor = checkForNull(request.getParameter("SearchFor"));
		//ML-MMOH-CRF-1123-US2
		String alaCarte="";
		if(isAlaCarte==true){
			alaCarte = checkForNull(request.getParameter("alaCarte"));
		}else{
			alaCarte = "";
		}
		//ML-MMOH-CRF-1123-US2
		String DIET_TYPE_MODIFIED="";
		//String dietician="";
		//MMS-CRF-006
		String NBM_DIET="";//ML-MMOH-CRF-0410
		//Added for CRF-0113
        String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
		String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
		//String leftScrolling= request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");
	    String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
		//Added for CRF-0113
		int start = (from.equals(""))?1:Integer.parseInt(from);
		int end = (to.equals(""))?10:Integer.parseInt(to);//Added Against ML-MMOH-CRF-1005-US2
		int gracePeriod = 0;
	  	//Modified against ML-MMOH-CRF-0600-US2 starts here
		String AllowOrderIP = "";
		String strQury = "select grace_period,ALLOW_PLACE_ORD_IP  from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_Id+"'";
		String patientAge = "";   //Added Against PMG2017-COMN-CRF-0012[IN:066074]
    	try{
    		pstmt = conn.prepareStatement(strQury);
    		rst	= pstmt.executeQuery();
    		if(rst != null && rst.next()){
    			gracePeriod = rst.getInt(1);
				AllowOrderIP = rst.getString(2);			
		//Modified against ML-MMOH-CRF-0600-US2 ends here
    		}
    	}
    	catch(Exception ee){
    		System.err.println("Exception in WorkListResultPage-->"+ee.getMessage());
		ee.printStackTrace();
    	}

    	boolean flag=false;    	
		//Commented against CRF-0410
		//String strsql = "select distinct to_char(a.visit_Adm_Date_Time,'DD/MM/YYYY HH24:MI:SS'),a.encounter_Id,a.patient_Id, m.patient_name,m.sex, to_char(m.date_Of_Birth,'DD/MM/YYYY'),a.assign_Care_Locn_Type, a.assign_Care_Locn_Code, i.short_Desc,a.assign_Room_Num, a.assign_Bed_Num,a.patient_Class,a.discharge_date_time,a.adt_status from Pr_Encounter a, Mp_Patient m,Mp_Episode_Type_Vw v, Ip_Nursing_Unit_Lang_Vw i,ds_epsd_diet_profile_hdr hdr,ds_epsd_meal_plan_hdr mealplan,ds_epsd_dietician_referral ref where a.PATIENT_CLASS = v.patient_Class and i.facility_Id = a.facility_Id and i.nursing_Unit_Code = a.assign_Care_Locn_Code and i.language_Id='"+language_Id+"'and ((a.discharge_date_time + '"+gracePeriod+"' / 24) >=  SYSDATE or a.discharge_Date_Time is null) and  a.adt_Status <> '09' and a.PATIENT_CLASS in ('IP','DC') and a.deceased_Date_Time is null and a.FACILITY_ID ='"+facility_Id+"' and a.patient_Id = m.patient_Id(+) AND ref.encounter_id(+) = a.encounter_id AND ref.operating_facility_id(+) = a.facility_id ";//MMS-CRF-006
		 //Modified against CRF-0410 Starts
		 //String strsql = "select distinct to_char(a.visit_Adm_Date_Time,'DD/MM/YYYY HH24:MI:SS'),a.encounter_Id,a.patient_Id,TRIM(m.patient_name) patient_name, m.sex, to_char(m.date_Of_Birth,'DD/MM/YYYY'),a.assign_Care_Locn_Type, a.assign_Care_Locn_Code, i.short_Desc,a.assign_Room_Num, a.assign_Bed_Num,a.patient_Class,a.discharge_date_time,a.adt_status,a.visit_adm_date_time vst_dt_tm, get_age (m.date_of_birth) || ' / ' || DECODE (m.sex, 'M', 'Male', 'F', 'Female', 'Unknown') age from Pr_Encounter a, Mp_Patient m,Mp_Episode_Type_Vw v, Ip_Nursing_Unit_Lang_Vw i,ds_epsd_diet_profile_hdr hdr,ds_epsd_dietician_referral ref";//Added for CRF-0113 & ICN-64265 & PMG2017-CRF-0012[IN:066074]
		 String strsql = DlQuery.DL_PLACE_DIET_ORDER;
		
		 if ((status != null && status.equals("M")) || (status != null && status.equals("ALL"))){
		 		strsql=strsql+",ds_epsd_meal_plan_hdr mealplan ";
		}
		 	if ((status != null && status.equals("A")) || (status != null && status.equals("ALL"))){
		 		strsql=strsql+",ds_epsd_nbm_profile nbm ";
		}		 
				strsql=strsql+" where a.PATIENT_CLASS = v.patient_Class and i.facility_Id = a.facility_Id and i.nursing_Unit_Code = a.assign_Care_Locn_Code and i.language_Id='"+language_Id+"'and ((a.discharge_date_time + '"+gracePeriod+"' / 24) >=  SYSDATE or a.discharge_Date_Time is null) and  a.adt_Status <> '09' and a.PATIENT_CLASS in ('IP','DC') and a.deceased_Date_Time is null and a.FACILITY_ID ='"+facility_Id+"' and a.patient_Id = m.patient_Id(+) AND ref.encounter_id(+) = a.encounter_id AND ref.operating_facility_id(+) = a.facility_id ";//MMS-CRF-006
		//Modified against CRF-0410 Ends
		
		if(isBedNum) strsql=strsql+"and assign_bed_num not in(' ')";	//Added Against ML-MMOH-SCF-1804
					
    	if((whereClause == null || whereClause.equals(""))){
    		int cnt=0;
     			if ( !(NursingUnit == null || NursingUnit.equals("")) ){
    				sql = sql + "and i.nursing_Unit_Code = replace('"+NursingUnit+"','%','')";
    					cnt++;
    			}
    			if ( !(encounterId == null || encounterId.equals("")) ){
    				if(cnt>0)
						sql = sql + "and a.encounter_Id = NVL('"+encounterId+"',a.encounter_id)";
	    			else{
						sql=sql+"where a.encounter_Id = NVL('"+encounterId+"',a.encounter_id)";
						cnt=1;
					}
				}
				if ( !(patientId == null || patientId.equals("")) ){
					if(cnt>0)
						sql = sql + " and a.patient_Id = NVL('"+patientId+"',a.patient_id)";
					else{
						sql=sql+" where a.patient_Id = NVL('"+patientId+"',a.patient_id)";
						cnt=1;
					}
				}
				if ( !(sex == null || sex.equals("")) ){
					if(cnt>0)
						sql = sql + "and m.sex =  NVL('"+sex+"',m.sex)";
					else{
						sql=sql+" where m.sex =  NVL('"+sex+"',m.sex)";
						cnt=1;
					}
				}
				if ( !(practitionerId == null || practitionerId.equals("")) ){
					if(cnt>0)
						sql = sql + "and nvl(a.attend_Practitioner_Id,'XX') = NVL('"+practitionerId+"',a.attend_Practitioner_Id) ";
					else{
						sql=sql+" where nvl(a.attend_Practitioner_Id,'XX') = NVL('"+practitionerId+"',a.attend_Practitioner_Id)";
						cnt=1;
					}
				}

				if ( !(fromDate == null || fromDate.equals("")) ){
					if(cnt>0)
						sql = sql + " and (trunc(a.visit_Adm_Date_Time) between to_date(nvl(replace('"+fromDate+"'||'%','%',''),'15/09/1947'),'dd/mm/yyyy')";
					else{
						sql=sql+" where (trunc(a.visit_Adm_Date_Time) between to_date(nvl(replace('"+fromDate+"'||'%','%',''),'15/09/1947'),'dd/mm/yyyy')";
						cnt=1;
					}
				}else{
					sql = sql + " and (trunc(a.visit_Adm_Date_Time) between to_date(nvl(replace('"+fromDate+"'||'%','%',''),'15/09/1947'),'dd/mm/yyyy')";
				}
				if ( !(toDate == null || toDate.equals("")) ){
					if(cnt>0)
						sql = sql + "and to_date(nvl(replace('"+toDate+"'||'%','%',''),'31/12/2999'),'dd/mm/yyyy'))";
					else{
						sql=sql+"where and to_date(nvl(replace('"+toDate+"'||'%','%',''),'31/12/2999'),'dd/mm/yyyy')) ";
						cnt=1;
					}
        		}else{
        			sql = sql + "and to_date(nvl(replace('"+toDate+"'||'%','%',''),'31/12/2999'),'dd/mm/yyyy'))";
        		}				
				
				if (status != null && status.equals("A")){
					if(cnt>0)
							//Commented against CRF-0410
							//sql = sql + "AND nvl(hdr.status, 'ZZ') <> 'X' and hdr.encounter_id(+)=a.encounter_id and mealplan.encounter_id(+)=a.encounter_id and trunc(sysdate) between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY'))";
							//Modified against CRF-0410
							sql = sql + " AND nbm.encounter_id(+) = a.encounter_id AND nbm.operating_facility_id(+) = a.facility_id AND NVL (nbm.status, 'ZZ') <> 'X' AND nvl(hdr.status, 'ZZ') <> 'X' and hdr.encounter_id(+)=a.encounter_id and ((trunc(sysdate) between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY'))) OR (TRUNC (SYSDATE) BETWEEN TRUNC(nbm.NIL_BY_MOUTH_FRM) AND NVL (nbm.NIL_BY_MOUTH_TO,TO_DATE ('31/12/2999','DD/MM/YYYY')))) AND NOT EXISTS (SELECT 1 from ds_epsd_meal_plan_hdr mealplan where mealplan.encounter_id = a.encounter_id and mealplan.operating_facility_id = a.facility_id AND TRUNC (mealplan.serving_date) = TRUNC (SYSDATE)  AND mealplan.meal_plan_modified_yn = 'Y')";
					else{
							//Commented against CRF-0410
							//sql=sql+"where hdr.encounter_id(+)=a.encounter_id AND nvl(hdr.status, 'ZZ') <> 'X' and mealplan.encounter_id(+)=a.encounter_id and trunc(sysdate) between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY'))";
							//Modified against CRF-0410						
							sql=sql+"where nbm.encounter_id(+) = a.encounter_id AND nbm.operating_facility_id(+) = a.facility_id AND NVL (nbm.status, 'ZZ') <> 'X' AND hdr.encounter_id(+)=a.encounter_id AND nvl(hdr.status, 'ZZ') <> 'X' and ((trunc(sysdate) between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY')))OR (TRUNC (SYSDATE) BETWEEN TRUNC(nbm.NIL_BY_MOUTH_FRM) AND NVL (nbm.NIL_BY_MOUTH_TO,TO_DATE ('31/12/2999','DD/MM/YYYY')))) AND NOT EXISTS (SELECT 1 from ds_epsd_meal_plan_hdr mealplan where mealplan.encounter_id = a.encounter_id and mealplan.operating_facility_id = a.facility_id AND TRUNC (mealplan.serving_date) = TRUNC (SYSDATE)  AND mealplan.meal_plan_modified_yn = 'Y')";
							cnt=1;
					}
				}
				
				if (status != null && status.equals("P")){
					if(cnt>0)
					//Commented against CRF-0410
					   //sql = sql + "and hdr.encounter_id=a.encounter_id and mealplan.encounter_id=a.encounter_id and sysdate not between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY'))";
						
						//Modified against CRF-0410 Starts
						sql=sql+"and  hdr.encounter_id(+)=a.encounter_id and (a.facility_id ,a.ENCOUNTER_ID) NOT IN (select hdr1.OPERATING_FACILITY_ID ,hdr1.ENCOUNTER_ID from ds_epsd_diet_profile_hdr hdr1 where hdr1.OPERATING_FACILITY_ID = '"+facility_Id+"' and hdr1.encounter_Id =NVL('"+encounterId+"',hdr1.encounter_id) and trunc(sysdate) between hdr1.period_from AND nvl(hdr1.period_to,to_date('31/12/2999','DD/MM/YYYY')) AND NVL (hdr1.status, 'ZZ') <> 'X' ) AND NOT EXISTS (SELECT 1 from ds_epsd_nbm_profile where encounter_id = a.encounter_id and operating_facility_id = a.facility_id AND TRUNC (SYSDATE) BETWEEN TRUNC(NIL_BY_MOUTH_FRM) AND NVL (TRUNC(NIL_BY_MOUTH_TO), TO_DATE ('31/12/5000', 'DD/MM/YYYY' )))";
					
					else{
					//Commented against CRF-0410
						//sql = sql + "where hdr.encounter_id=a.encounter_id and sysdate not between hdr.period_from AND nvl(hdr.period_to,to_date('31/12/2999','DD/MM/YYYY'))";
						//Modified against CRF-0410 Starts
						sql=sql+"where hdr.encounter_id(+)=a.encounter_id and (a.facility_id ,a.ENCOUNTER_ID) NOT IN (select hdr1.OPERATING_FACILITY_ID ,hdr1.ENCOUNTER_ID from ds_epsd_diet_profile_hdr hdr1 where hdr1.OPERATING_FACILITY_ID = '"+facility_Id+"' and hdr1.encounter_Id =NVL('"+encounterId+"',hdr1.encounter_id) and trunc(sysdate) between hdr1.period_from AND nvl(hdr1.period_to,to_date('31/12/2999','DD/MM/YYYY')) AND NVL (hdr1.status, 'ZZ') <> 'X' ) AND NOT EXISTS (SELECT 1 from ds_epsd_nbm_profile where encounter_id = a.encounter_id and operating_facility_id = a.facility_id AND TRUNC (SYSDATE) BETWEEN TRUNC(NIL_BY_MOUTH_FRM) AND NVL (TRUNC(NIL_BY_MOUTH_TO), TO_DATE ('31/12/5000', 'DD/MM/YYYY' )))";
						
						cnt=1;
					}
				}

				if (status != null && status.equals("M")){
					if(cnt>0)
						sql = sql + "and hdr.encounter_id(+)=a.encounter_id and mealplan.encounter_id(+)=a.encounter_id and mealplan.meal_plan_modified_yn='Y' and trunc(mealplan.serving_date)=trunc(sysdate)";
					else{
						sql=sql+"where hdr.encounter_id(+)=a.encounter_id and mealplan.encounter_id(+)=a.encounter_id and mealplan.meal_plan_modified_yn='Y' and trunc(mealplan.serving_date)=trunc(sysdate)";
						cnt=1;
					}
				}
				//Maheshwaran K modified the query for performance issue for specific ward -ML-MMOH-SCF-2366
				if (status != null && status.equals("ALL")){
					if(cnt>0){
						//sql = sql + "AND nbm.encounter_id(+) = a.encounter_id AND nbm.operating_facility_id(+) = a.facility_id and hdr.encounter_id(+)=a.encounter_id and mealplan.encounter_id(+)=a.encounter_id ";
						sql = sql + "AND nbm.encounter_id(+) = hdr.encounter_id AND nbm.operating_facility_id(+) = hdr.operating_facility_id AND nbm.profile_sl (+) = hdr.profile_sl and hdr.encounter_id(+)=a.encounter_id  AND hdr.operating_facility_id (+) = a.facility_id AND mealplan.encounter_id(+)=a.encounter_id AND mealplan.operating_facility_id (+) = a.facility_id "; 
					}else{
						//sql=sql+"where nbm.encounter_id(+) = hdr.encounter_id AND nbm.operating_facility_id(+) = a.facility_id AND hdr.encounter_id(+)=a.encounter_id and mealplan.encounter_id(+)=a.encounter_id ";
						sql=sql+"where nbm.encounter_id(+) = hdr.encounter_id AND nbm.operating_facility_id(+) = hdr.operating_facility_id AND nbm.profile_sl (+) = hdr.profile_sl AND hdr.encounter_id(+)=a.encounter_id  AND hdr.operating_facility_id (+) = a.facility_id AND mealplan.encounter_id(+)=a.encounter_id AND mealplan.operating_facility_id (+) = a.facility_id ";
						cnt=1;
					}				
				}
				
				//Added Below Conditition Against KDAH-CRF-0511
				 if (status != null && status.equals("R")){
					if(cnt>0)
						sql = sql + " AND hdr.encounter_id(+)=a.encounter_id AND TRUNC(SYSDATE) = hdr.PERIOD_TO  ";
					else{
						sql=sql+" where hdr.encounter_id(+)=a.encounter_id AND TRUNC(SYSDATE) = hdr.PERIOD_TO  ";
						cnt=1;
					}				
				} 
				
				
				//MMS-CRF-006
				if(searchFor!=null && searchFor.equals("RD"))	{
					sql=sql+"	AND ref.dietician_refrl_yn='Y' 	";
				}//MMS-CRF-006
				
			     if(searchFor!=null && searchFor.equals("DM")) {					
					sql=sql+"AND hdr.diet_type_modified = 'Y' AND (TRUNC (SYSDATE) BETWEEN hdr.period_from AND NVL (hdr.period_to,TO_DATE ('31/12/2999', 'DD/MM/YYYY')) OR hdr.PERIOD_FROM > TRUNC (SYSDATE)) AND hdr.diet_type_modified='Y' and nvl(hdr.status,'N') !='X' ";//59325
				 }
				 if(searchFor!=null && searchFor.equals("CD")){
					sql=sql+"	AND  hdr.diet_type_modified = 'Y' AND TRUNC (SYSDATE) BETWEEN hdr.period_from AND NVL (hdr.period_to,TO_DATE ('31/12/2999', 'DD/MM/YYYY')) and nvl(hdr.status,'N') !='X' ";
				 }
				 if(searchFor!=null && searchFor.equals("FD")){
					sql=sql+"	AND hdr.PERIOD_FROM > TRUNC (SYSDATE) AND hdr.diet_type_modified='Y' and nvl(hdr.status,'N') !='X'	";
				 }
				//Added for ML-MMOH-CRF-1123-US2 Starts
				if(isAlaCarte==true){
				 if(alaCarte.equals("AC")){
					sql=sql+"	AND trunc(sysdate - a.visit_adm_date_time) > 8 ";
				 } 
				  if(alaCarte.equals("NAC")){
					 sql=sql+"	AND trunc(sysdate - a.visit_adm_date_time) < 8 ";
				 }
				}
				//Added for ML-MMOH-CRF-1123-US2 Ends
	//Added for CRF-0113 Starts
//	String desc="";
          		   if (orderBy.equals("AD")){
					if(reOrder.equals("1")){
							sql= sql+" order by vst_dt_tm desc ";
							
					}else{
							sql =sql+" order by vst_dt_tm  ";
						
					}
			   }else if (orderBy.equals("EN")){
					if(reOrder.equals("1")){
						     sql =sql+" order by encounter_id desc ";
					}else{
							sql= sql+" order by encounter_id ";
					}
			   }else if (orderBy.equals("PI")){
					if(reOrder.equals("1")){
							 sql =sql+" order by patient_id desc ";
					}else{
							 sql= sql+" order by patient_id ";
					}
			  }else if (orderBy.equals("PN")){
					if(reOrder.equals("1")){
							 sql =sql+" order by lower(trim(patient_name)) desc ";
					}else{
							 sql =sql+" order by lower(trim(patient_name)) ";//Modified for ICN-64265
					}
			  }else if(orderBy.equals("GN")){
				    if(reOrder.equals("1")){
						   sql =sql+" order by sex desc ";
					}else{
						   sql =sql+" order by sex ";
				    }
			  }
			  else if(orderBy.equals("RM")){
				       if(reOrder.equals("1")){
						   sql =sql+" order by assign_Room_Num desc ";
					}else{
						   sql =sql+" order by assign_Room_Num ";						  
					}
					} 
			  else if(orderBy.equals("BD")){
		              if(reOrder.equals("1")){
						   sql =sql+" order by assign_Bed_Num desc ";
					}else{
						   sql =sql+" order by assign_Bed_Num";
					}
					  }                
    }
    	//Added for CRF-0113 Ends
       else
            sql = whereClause;
             //end of where clause IF
 			strsql=strsql+sql;			
 	  try{
	     	String adm_Date = "";
	     	String encounter_Id = "";
	     	String patient_Id = "";
	     	String patient_Name = ""; 
	     	String gender = "";
	     	String location = "";
	     	String bed = "";
	     	String room = "";
	     	String classValue= "";
	     	String dateOfBirth = "";
	     	String locationType = "";
	     	String patientClass = "";
	     	String isMealPlanModified="";
	     	String dieticianReferral="";
	     	String dieticianReferralNew="";
	     	String fromdate="";
	     	String profileSL="";
	     	Boolean isMealOrderActive=false;
	     	String classStatus= "";
	     	String classDieticianReferral="";
	     	String classDieticianReferralNew="";
	     	String language_id = (String)session.getAttribute("LOCALE");
	     	//int i = 0;
	     	String flag1 = "";
	     	pstmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;		
			rst	= pstmt.executeQuery();
			//getting maximum record
	    	rst.last();	maxRecord = rst.getRow();
	    	if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			}
			//again move the resultset pointer to initial position
			rst.beforeFirst();			
			
			//IN::39863 - Check if the selected nursing unit is  mapping value
			String strQuery_kitchencode = "select count(*) from Ds_Wards_Kitchen_Vw where operating_Facility_Id = '"+facility_Id+"' and  NURSING_UNIT_CODE='"+NursingUnit+"' and linked_yn = 'Y'";
			pstmt_KitchenCode = conn.prepareStatement(strQuery_kitchencode);
			rst_KitchenCode	= pstmt_KitchenCode.executeQuery();
			int count = 0;
    		if(rst_KitchenCode != null && rst_KitchenCode.next()){
    			count = rst_KitchenCode.getInt(1);
    		}
			if(count == 0){
				out.println("<script>function placedietorder(){alert(getMessage('DS_KIT_NOTSET_FOR_NURSUNIT','DS'));return false;}</script>");
			}else{
				out.println("<script>function placedietorder(){return true;}</script>");
			}
		 	//IN:39863
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block12Bytes, _wl_block12);

if ( !(start <= 1) ){ 

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(URLEncoder.encode(sql)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(NursingUnit));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(status));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(room));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
}if ( !( (start+10) > maxRecord ) ) {
	
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(URLEncoder.encode(sql)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(NursingUnit));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(status));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(room));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(searchFor));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(status));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(NursingUnit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(room));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(searchFor));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(status));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(NursingUnit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(room));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(searchFor));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(status));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(NursingUnit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(room));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(searchFor));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(status));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(NursingUnit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(room));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(searchFor));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(status));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(NursingUnit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(room));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(searchFor));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(status));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(NursingUnit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(room));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(searchFor));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(status));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(NursingUnit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(room));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

		if ( start!= 1 ) rst.absolute(start-1);
		int i=start;
		while(rst != null && rst.next() && i<=end){
				classStatus= "";
				classDieticianReferral= "";
				classDieticianReferralNew=""; // Refer to Dietician IN 42110
				isMealPlanModified="";
				isMealOrderActive=false;
				dieticianReferral="";
				dieticianReferralNew="";	// Refer to Dietician IN 42110
				fromdate="";
				profileSL="0";
				
				flag=true;
				if ( i % 2 == 0 )
					classValue = "QRYODD" ;
				else
					classValue = "QRYEVEN" ;

				adm_Date = com.ehis.util.DateUtils.convertDate(rst.getString(1),"DMYHMS", "en", language_id);
				encounter_Id = rst.getString(2);
				patient_Id = rst.getString(3);
				patient_Name = rst.getString(4);
				gender = rst.getString(5);
				dateOfBirth = rst.getString(6);
				locationType = rst.getString(7);
				location = rst.getString(8);
				//MMS-CRF-006
				//DIET_TYPE_MODIFIED=checkForNull(rst.getString("DIET_TYPE_MODIFIED"));
				//DIET_TYPE_MODIFIED="Y";
				//MMS-CRF-006
				
				if(rst.getString(10) ==  null){
					room = "&nbsp;";
				}else{
					room = rst.getString(10);
				}
				if(rst.getString(11) == null){
					bed = "&nbsp;";
				}else{
					bed = rst.getString(11);
				}
				if(rst.getString(13) != null && rst.getString(14).equals("08")){
					flag1 = "Y";
				}else{
					flag1 = "N";
				}				
				
				if(dateOfBirth.length()<11){dateOfBirth=dateOfBirth+" 00:00";}
				
				String ageGroupArray[] = null;
				String ageGroupArray1[] = null;
				
				ageGroupArray	=  dateOfBirth.split(" ");
				ageGroupArray1	=	ageGroupArray[0].split("/");
				Date today=new Date();
				
				Date dob=new Date(Integer.parseInt(ageGroupArray1[2])-1900, Integer.parseInt(ageGroupArray1[1]), Integer.parseInt(ageGroupArray1[0]));
				
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date tDate = dateFormat.parse(dateFormat.format(today));
								
				int one_day=1000*60*60*24;

				//Calculate difference btw the two dates, and convert to days
				//int days1=Math.floor((dob.getTime()-today.getTime())/(one_day))+1;				
				//long diff = Math.abs((today.getTime() - dob.getTime()));

				java.sql.Timestamp dateCompare = new 	Timestamp(tDate.getTime());
				
				long diff = Math.abs(dateCompare.getTime() - dob.getTime());
				
				int days1 = (int) Math.floor(diff/one_day);
				int year=365;
				int month=30;
				int years = days1/year;
				int days2=days1%year;
				int months=Math.abs(days2/month);
				int days=Math.abs(days2%month);
				
				int maxAge = 0;
				String ageUnit = "";

				if(Math.abs(years) > 0){
					maxAge=  Math.abs(years);
					ageUnit = "Y";
				}else if(Math.abs(months) > 0){
					maxAge =  Math.abs(months);
					ageUnit = "M";
				}else if( Math.abs(days) > 0){
					maxAge =  Math.abs(days);
					ageUnit = "D";
				}				
				
				patientClass = rst.getString(12);
				/*Added Against Start PMG2017-COMN-CRF-0012[IN:066074]*/
				patientAge = checkForNull(rst.getString("age"));				
				/*Added Against End PMG2017-COMN-CRF-0012[IN:066074]*/
				
				String sql_mealplan ="select MEAL_PLAN_MODIFIED_YN from ds_epsd_meal_plan_hdr where encounter_id='"+encounter_Id+"' and trunc(SERVING_DATE)=trunc(sysdate) and MEAL_PLAN_MODIFIED_YN='Y'";
				//String sql_activeMealOrder="select * from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' AND nvl(status, 'ZZ') <> 'X' and trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY')) ";//CRF-410
				
				//Added Against ML-MMOH-CRF-1460 Starts
				boolean isMACNBM = false;
				isMACNBM = CommonBean.isSiteSpecific(conn,"DS","DS_MAC_NBM");
				String sql_activeMealOrder = "";
				if(isMACNBM)
				{
				 sql_activeMealOrder="select 'X' from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' AND nvl(status, 'ZZ') <> 'X' and trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY')) union all select 'X' from ds_epsd_nbm_profile where encounter_id='"+encounter_Id+"' and nvl(status,'ZZ')<>'X' and trunc(sysdate) between trunc(NIL_BY_MOUTH_FRM) and trunc(NIL_BY_MOUTH_TO) UNION ALL SELECT 'X' FROM ds_epsd_diet_profile_att WHERE encounter_id = '"+encounter_Id+"' AND NVL (status, 'ZZ') <> 'X' AND TRUNC (SYSDATE) BETWEEN TRUNC (period_from) AND TRUNC (period_to) "; 
				}
				//Added Against ML-MMOH-CRF-1460 Ends
				else{
					sql_activeMealOrder="select 'X' from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' AND nvl(status, 'ZZ') <> 'X' and trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY')) union all select 'X' from ds_epsd_nbm_profile where encounter_id='"+encounter_Id+"' and nvl(status,'ZZ')<>'X' and trunc(sysdate) between trunc(NIL_BY_MOUTH_FRM) and trunc(NIL_BY_MOUTH_TO)";//CRF-410
				}
				String sql_dieticianReferral="select dietician_refrl_yn from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' and trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY'))";

				// Refer to Dietician IN 42110
				String sql_dieticianReferral_New = "select dietician_refrl_yn from ds_epsd_dietician_referral where encounter_id='"+encounter_Id+"'";

				String sql_maxProfileSL="select to_char(period_from,'DD/MM/YYYY'),(select max(profile_sl) from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"') profile_sl from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' and profile_sl=(select max(profile_sl) from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"')";
 
				//MMS-CRF-006				
		     	pstmt1 = conn.prepareStatement(sql_mealplan,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst1	= pstmt1.executeQuery();
				while(rst1 != null && rst1.next()){
					isMealPlanModified="Y";
				}
				
		     	pstmt2 = conn.prepareStatement(sql_activeMealOrder,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst2	= pstmt2.executeQuery();
				while(rst2 != null && rst2.next()){
					isMealOrderActive=true;
				}
				
		     	pstmt3 = conn.prepareStatement(sql_dieticianReferral,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst3	= pstmt3.executeQuery();
				while(rst3 != null && rst3.next()){
					dieticianReferral = rst3.getString(1);
					if(dieticianReferral==null) dieticianReferral="&nbsp;"; 
				}
				
				pstmt4 = conn.prepareStatement(sql_maxProfileSL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst4	= pstmt4.executeQuery();
				while(rst4 != null && rst4.next()){
					fromdate=rst4.getString(1);
					profileSL = rst4.getString(2);
					if(fromdate==null) profileSL="";
					if(profileSL==null) profileSL="0"; 
				}
				
				// Refer to Dietician IN 42110
				pstmt5 = conn.prepareStatement(sql_dieticianReferral_New,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst5	= pstmt5.executeQuery();
				while(rst5 != null && rst5.next()){
					dieticianReferralNew = rst5.getString(1);
					if(dieticianReferralNew==null) dieticianReferralNew="&nbsp;"; 
				}
				
				String sql_spl_foodItem_exists="select * from ds_epsd_diet_profile_spl where encounter_id ='"+encounter_Id+"' and profile_sl='"+profileSL+"' and operating_facility_id='"+facility_Id+"'";
				String sql_foodDislikes_exists="select * from ds_patient_food_dislikes where patient_id ='"+patient_Id+"'";
				String sp_flag="N";
				String dislike_flag="N";
				
				if(isMealPlanModified.equals("Y"))	classStatus="OAYELLOW";
				else if(isMealOrderActive) classStatus="OAGREEN";
				else classStatus="OARED";
				
				if(dieticianReferral.equals("Y"))	classDieticianReferral="CYANCLR";
				else classDieticianReferral=classValue;
				
				// Refer to Dietician IN 42110
				if(dieticianReferralNew.equals("Y"))	classDieticianReferralNew="CYANCLR";
				else classDieticianReferralNew=classValue;
				
				pstmt6 = conn.prepareStatement(sql_spl_foodItem_exists,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst6	= pstmt6.executeQuery();
				while(rst6 != null && rst6.next()){
					sp_flag="Y";
					break;
				}

				pstmt7 = conn.prepareStatement(sql_foodDislikes_exists,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
				rst7	= pstmt7.executeQuery();
				while(rst7 != null && rst7.next()){
					dislike_flag="Y";
					break;
				}
				//006 starts
				
				String sql_DIET_TYPE_MODIFIED="select DIET_TYPE_MODIFIED from ds_epsd_diet_profile_hdr where encounter_id='"+encounter_Id+"' and ( trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY')) ";//59325
					
				if(!isMealOrderActive){
					sql_DIET_TYPE_MODIFIED+=" OR PERIOD_FROM  > TRUNC (SYSDATE) ";
				}
					
				sql_DIET_TYPE_MODIFIED+=" ) and diet_type_modified='Y' and nvl(STATUS,'N') !='X'";
				
				//006 ends				
				pstmt8=conn.prepareStatement(sql_DIET_TYPE_MODIFIED,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				 rst8 =pstmt8.executeQuery();
				 if(rst8!=null && rst8.next())
				 {
				 DIET_TYPE_MODIFIED=checkForNull(rst8.getString("DIET_TYPE_MODIFIED"));//006		 
				 }else{
				 DIET_TYPE_MODIFIED="N";
				 }
				 
				 //410 color code changes starts 
				 if(classDieticianReferralNew.equals("CYANCLR")){
					classDieticianReferralNew="<img src=../../eDS/css/blue.png></img>";
				 }else{
					classDieticianReferralNew="";
				 }
				 
				 if(classStatus.equals("OAGREEN")){
					classStatus="<img src=../../eDS/css/green.png></img>";
				 }else if(classStatus.equals("OARED")){
					classStatus="<img src=../../eDS/css/red.png></img>";
				 }else if(classStatus.equals("OAYELLOW")){
					classStatus="<img src=../../eDS/css/yellow.png></img>";
				 }
				 //410 color code changes ends
				 
				String sql_NBM_diet ="SELECT 'F',to_char(nil_by_mouth_frm,'dd/mm/yyyy - hh24:mi'),to_char(nil_by_mouth_to,'dd/mm/yyyy - hh24:mi') FROM ds_epsd_nbm_profile WHERE encounter_id = '"+encounter_Id+"' AND TRUNC (SYSDATE) BETWEEN (TRUNC (nil_by_mouth_frm)) AND (TRUNC (nil_by_mouth_to)) AND operating_facility_id = '"+facility_Id+"' AND status is null UNION ALL SELECT 'P',to_char(nil_by_mouth_frm,'dd/mm/yyyy - hh24:mi'),to_char(nil_by_mouth_to,'dd/mm/yyyy - hh24:mi') FROM ds_epsd_diet_profile_hdr WHERE encounter_id = '"+encounter_Id+"' AND TRUNC (SYSDATE) BETWEEN (TRUNC (nil_by_mouth_frm)) AND (TRUNC (nil_by_mouth_to)) AND TRUNC(SYSDATE) BETWEEN PERIOD_FROM AND PERIOD_TO AND operating_facility_id = '"+facility_Id+"' AND status is null ";
				
				pstmt9=conn.prepareStatement(sql_NBM_diet,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rst9 =pstmt9.executeQuery();
				NBM_DIET="";
				if(rst9!=null && rst9.next())
				{
					if(rst9.getString(1).equals("F")){
						NBM_DIET="<img src=../../eDS/css/NBM_Without_Diet.PNG title='"+rst9.getString(2)+"\n"+rst9.getString(3)+"'></img>";
					}else{						
						NBM_DIET="<img src=../../eDS/css/NBM_With_Diet.PNG title='"+rst9.getString(2)+"\n"+rst9.getString(3)+"'></img>";
				}
				}				 
				//410 color code changes ends				
		//ML-MMOH-CRF-0600-US2 Starts Here		
	    String meal="";		
		//String sql_Action_Pending = "SELECT 1 FROM (SELECT distinct a.encounter_id, a.serving_date, b.status curr_stat, a.meal_type, CASE WHEN b.status = 'MP'  THEN 1 WHEN b.status = 'MR'  THEN 2 WHEN b.status = 'MS'  THEN 3 WHEN b.status = 'MJ'  AND  1 = (SELECT 1 from ds_param_for_facility WHERE ip_mealreject_yn = 'Y') THEN 4 ELSE 0 END status FROM ds_epsd_meal_plan_dtl a, ds_epsd_meal_plan_hdr_audit b, ds_epsd_diet_profile_hdr c  WHERE a.operating_facility_id =  '"+facility_Id+"' AND a.encounter_id = '"+encounter_Id+"' AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.meal_type = b.meal_type(+) AND a.spl_food_item_yn = 'N' AND a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID AND a.ENCOUNTER_ID = c.ENCOUNTER_ID AND c.PROFILE_SL = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id and encounter_id = a.encounter_id) AND a.serving_date between c.PERIOD_FROM and c.PERIOD_TO UNION SELECT distinct a.encounter_id, a.serving_date, b.status curr_stat, a.meal_type, CASE WHEN b.status = 'MP'  THEN 1 WHEN b.status = 'MR'  THEN 2 WHEN b.status = 'MS'  THEN 3 WHEN b.status = 'MJ'  AND  1 = (SELECT 1 from ds_param_for_facility WHERE ip_mealreject_yn = 'Y') THEN 4 ELSE 0 END status FROM ds_epsd_meal_plan_dtl a,ds_epsd_meal_plan_spl_audit b, ds_epsd_diet_profile_hdr c WHERE a.operating_facility_id =  '"+facility_Id+"' AND a.encounter_id = '"+encounter_Id+"' AND a.operating_facility_id    = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.spl_food_item_yn = 'Y' AND a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID AND a.ENCOUNTER_ID = c.ENCOUNTER_ID AND c.PROFILE_SL = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id and encounter_id = a.encounter_id) AND a.serving_date between c.PERIOD_FROM and c.PERIOD_TO) WHERE status <(SELECT CASE WHEN ip_mealprepared_yn = 'Y'  THEN 1 WHEN ip_mealreceived_yn = 'Y'  THEN 2 WHEN ip_mealserved_yn   = 'Y'  THEN 3 WHEN ip_mealreject_yn   = 'Y'  THEN 4 ELSE 0 END status FROM ds_param_for_facility)";//Special Food Item Concept Included
		String sql_Action_Pending = "SELECT 1 FROM (SELECT distinct a.encounter_id, a.serving_date, b.status curr_stat, a.meal_type, CASE WHEN b.status = 'MP'  THEN 1 WHEN b.status = 'MR'  THEN 2 WHEN b.status = 'MS'  THEN 3 WHEN b.status = 'MJ'  AND  1 = (SELECT 1 from ds_param_for_facility WHERE ip_mealreject_yn = 'Y' AND operating_facility_id = '"+facility_Id+"') THEN 4 ELSE 0 END status FROM ds_epsd_meal_plan_dtl a, ds_epsd_meal_plan_hdr_audit b, ds_epsd_diet_profile_hdr c  WHERE a.operating_facility_id =  '"+facility_Id+"' AND a.encounter_id = '"+encounter_Id+"' AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.meal_type = b.meal_type(+) AND a.spl_food_item_yn = 'N' AND a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID AND a.ENCOUNTER_ID = c.ENCOUNTER_ID AND c.PROFILE_SL = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id and encounter_id = a.encounter_id) AND a.serving_date between c.PERIOD_FROM and c.PERIOD_TO UNION SELECT distinct a.encounter_id, a.serving_date, b.status curr_stat, a.meal_type, CASE WHEN b.status = 'MP'  THEN 1 WHEN b.status = 'MR'  THEN 2 WHEN b.status = 'MS'  THEN 3 WHEN b.status = 'MJ'  AND  1 = (SELECT 1 from ds_param_for_facility WHERE ip_mealreject_yn = 'Y' AND operating_facility_id = '"+facility_Id+"') THEN 4 ELSE 0 END status FROM ds_epsd_meal_plan_dtl a,ds_epsd_meal_plan_spl_audit b, ds_epsd_diet_profile_hdr c WHERE a.operating_facility_id =  '"+facility_Id+"' AND a.encounter_id = '"+encounter_Id+"' AND a.operating_facility_id    = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.spl_food_item_yn = 'Y' AND a.OPERATING_FACILITY_ID = c.OPERATING_FACILITY_ID AND a.ENCOUNTER_ID = c.ENCOUNTER_ID AND c.PROFILE_SL = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id and encounter_id = a.encounter_id) AND a.serving_date between c.PERIOD_FROM and c.PERIOD_TO) WHERE status <(SELECT MAX (ip_param_val) FROM (SELECT CASE WHEN ip_mealprepared_yn = 'Y' THEN 1 ELSE 0 END ip_param_val FROM ds_param_for_facility WHERE operating_facility_id = '"+facility_Id+"' UNION ALL SELECT CASE WHEN ip_mealreceived_yn = 'Y' THEN 2 ELSE 0 END ip_param_val FROM ds_param_for_facility WHERE operating_facility_id = '"+facility_Id+"' UNION ALL SELECT CASE WHEN ip_mealserved_yn = 'Y' THEN 3 ELSE 0 END ip_param_val FROM ds_param_for_facility WHERE operating_facility_id = '"+facility_Id+"'))";//Special Food Item & IP Status Validation included & 67340 , 67340
		pstmt10 = conn.prepareStatement(sql_Action_Pending,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rst10	= pstmt10.executeQuery(); 
		if(rst10 != null && rst10.next())
		 {
		 	meal = rst10.getString(1);		   	
		 }	
		//ML-MMOH-CRF-0600-US2 Ends Here
		
		//Added Against ML-MMOH-CRF-1005-US2 Starts Here
		String APPL_FOR_ATT="";
			String sql_APPL_ATT="select 1 from DS_EPSD_DIET_PROFILE_ATT where encounter_id = ? and  (trunc(sysdate) between period_from AND nvl(period_to,to_date('31/12/2999','DD/MM/YYYY'))OR PERIOD_FROM  > TRUNC (SYSDATE))";//59325
								
				pstmt11=conn.prepareStatement(sql_APPL_ATT,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				pstmt11.setString(1,encounter_Id);
				 rst11 =pstmt11.executeQuery();
				 if(rst11!=null && rst11.next())
				 {
				 APPL_FOR_ATT=checkForNull(rst11.getString(1));//006		 
				 }
		//Added Against ML-MMOH-CRF-1005-US2 Ends Here
		
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(location));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dateOfBirth));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(adm_Date));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block55Bytes, _wl_block55);

					    if(AllowOrderIP.equals("Y")){
					
            _bw.write(_wl_block56Bytes, _wl_block56);

						if((DIET_TYPE_MODIFIED.equals("Y")) && (meal.equals("1")) && (APPL_FOR_ATT.equals("1"))) {
					
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(facility_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block59Bytes, _wl_block59);

						}else if((DIET_TYPE_MODIFIED.equals("Y")) && (meal.equals("1"))){
					
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(facility_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block62Bytes, _wl_block62);

						}else if((DIET_TYPE_MODIFIED.equals("Y"))  && (APPL_FOR_ATT.equals("1"))){
					
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block63Bytes, _wl_block63);

						}else if((meal.equals("1")) && (APPL_FOR_ATT.equals("1"))){
					
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block65Bytes, _wl_block65);

						}else if((meal.equals("1"))){
					
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(facility_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block62Bytes, _wl_block62);

						}else if((DIET_TYPE_MODIFIED.equals("Y"))){
					
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
						else if((APPL_FOR_ATT.equals("1"))){
					
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block68Bytes, _wl_block68);
}else{
						
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block56Bytes, _wl_block56);
 }
					   }else if((DIET_TYPE_MODIFIED.equals("Y")) && (APPL_FOR_ATT.equals("1"))){
					
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block69Bytes, _wl_block69);

						}else if((DIET_TYPE_MODIFIED.equals("Y"))){
					
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
						else if((APPL_FOR_ATT.equals("1"))){
					
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block68Bytes, _wl_block68);
}else{
						
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classStatus));
            out.print( String.valueOf(classDieticianReferralNew));
            out.print( String.valueOf(NBM_DIET));
            _bw.write(_wl_block56Bytes, _wl_block56);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
 
					long diffDays=0;
					if(isLos_gt7){ 					
						DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						Date current_date = null;
						Date adm_date2 = null;					
						current_date=dateFormat1.parse(dateFormat1.format(new Date()));
						adm_date2=dateFormat1.parse(adm_Date);
						long date_diff = current_date.getTime() - adm_date2.getTime();
						diffDays = date_diff / (24 * 60 * 60 * 1000);
					}
					
            _bw.write(_wl_block72Bytes, _wl_block72);

						if(AllowOrderIP.equals("Y")){
					
            _bw.write(_wl_block56Bytes, _wl_block56);

						if(meal.equals("1")){	
					
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(room));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dateOfBirth));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(flag1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(isLos_gt7));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(diffDays));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block75Bytes, _wl_block75);
					
					    }else{
					
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(room));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dateOfBirth));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(flag1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(isLos_gt7));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(diffDays));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block77Bytes, _wl_block77);

						}
						}else{
					
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(location));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(room));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dateOfBirth));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(flag1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(isLos_gt7));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(diffDays));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(alaCarte));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block78Bytes, _wl_block78);

						}
					
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(patient_Name));
            out.print( String.valueOf(isMealPlanModified));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(patientAge));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bed));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(room));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(flag1));
            _bw.write(_wl_block83Bytes, _wl_block83);

						if(AllowOrderIP.equals("Y")){
					
            _bw.write(_wl_block56Bytes, _wl_block56);

						if(meal.equals("1")){	
					
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block88Bytes, _wl_block88);
if(flag1.equals("Y")) {
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dateOfBirth));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(profileSL));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromdate));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(maxAge));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ageUnit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sp_flag));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dislike_flag));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(diffDays));
            _bw.write(_wl_block92Bytes, _wl_block92);
					
						}
						else{
					
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block88Bytes, _wl_block88);
if(flag1.equals("Y")) {
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dateOfBirth));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(profileSL));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromdate));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(maxAge));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ageUnit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sp_flag));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dislike_flag));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(diffDays));
            _bw.write(_wl_block94Bytes, _wl_block94);
  
						}
						}else{
					
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block88Bytes, _wl_block88);
if(flag1.equals("Y")) {
            _bw.write(_wl_block89Bytes, _wl_block89);
}
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dateOfBirth));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(profileSL));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(fromdate));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(maxAge));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ageUnit));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sp_flag));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dislike_flag));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(diffDays));
            _bw.write(_wl_block94Bytes, _wl_block94);
}
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(flag1));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(encounter_Id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(dateOfBirth));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(profileSL));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(fromdate));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(maxAge));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(ageUnit));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(sp_flag));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(dislike_flag));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(diffDays));
            _bw.write(_wl_block108Bytes, _wl_block108);

				i++;
				}
		     	}
		     	catch(Exception e){
		     		e.printStackTrace();
		     	}
		     	finally{
					if(pstmt!=null)	pstmt.close();
					if(rst!=null)	rst.close();
					if(pstmt1!=null)	pstmt1.close();
					if(rst1!=null)	rst1.close();
					
					if(pstmt_KitchenCode != null)  pstmt_KitchenCode.close();
					if(rst_KitchenCode != null) rst_KitchenCode.close();
					
					if(conn != null){
						ConnectionManager.returnConnection(conn,request);
					}
				}
		 
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(orderBy));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block112Bytes, _wl_block112);
 if(flag) {
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
} 
            _bw.write(_wl_block115Bytes, _wl_block115);
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block117Bytes, _wl_block117);
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block119Bytes, _wl_block119);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.admDate.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DieticianReferral.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.groupOrder.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
