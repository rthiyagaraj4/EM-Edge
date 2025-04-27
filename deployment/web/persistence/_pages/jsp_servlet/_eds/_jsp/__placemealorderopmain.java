package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import java.sql.Connection;
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

public final class __placemealorderopmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/PlaceMealOrderOPMain.jsp", 1745232235131L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nFile Name\t\t: PlaceMealOrderOPMain.jsp\nFile Description:  Result Frame : This file is for Placing OP Meal Order.\nCRF#\t\t\t: Bru-HIMS-CRF-230\nAuthor\t\t\t: Abirami\nDate\t\t\t: Aug-2013\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/json.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/DSCommon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<style>\n\tselect\n\t{\n     min-width: 3vw;\n     overflow: auto;\n    }\n</style>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n</head>\n<script language=\"javascript\">\n //ML-MMOH-CRF-0596\n\tfunction checkTheBox(mealTypes,checkBoxCount,encounterCount,row_ind1,secondCount) \n    \t{\t \n\t      var temp=0;\n\t      var temp1=0;\n\t        for (i=0; i<mealTypeList.length; i++) {\n\t\t\t//var meal1 = \"\"\t;//Commented Against Ml-MMOH-CRF-0825(ICN-68623)\n\t\t\tvar meal=mealTypeList[i].mealType+\"\"+row_ind1;//63577\n\t\t    if (parent.frames[1].document.getElementById(meal).checked == true){//63577\n\t\t\t//Commented Against Ml-MMOH-CRF-0825(ICN-68623) Starts here\n\t\t\t//meal1=parent.frames[1].document.getElementById(meal).name.substring(0,meal.length-1);\n\t\t\t//parent.frames[1].document.getElementById(\"mealone\").value= meal1;\n\t\t\t////Commented Against Ml-MMOH-CRF-0825(ICN-68623) Ends here\n\t\t\ttemp++;\n\t\t\tdocument.QueryResult.ChkboxCount.value=temp;\n\t\t    } if (parent.frames[1].document.getElementById(meal).checked == false){// 63577\t\t\t\t\n\t\t\t\ttemp1++;\n\t\t\t}\n\t\t\t}\n\t\t\t if(mealTypeList.length == temp1 && parseInt(encounterCount) == 0)\n\t\t\t{\t\t\t \n\t\t\ttemp=0;\t\t\n\t\t\tencounterCount=0;\t\t\t \n\t\t\t}\t\t\t\n\t\t\tif(parseInt(temp) > 1 || parseInt(encounterCount) > 0 )\n\t\t\t\t{\n\t\t\t\tif(parseInt(encounterCount) > 0)\n\t\t\t\t{\n\t\t\t   \tif(parseInt(temp) > 1)\n\t\t\t\t{\n\t\t\t\t\talert(\"Not Allowed to Place Multiple Meals for a Day\");\n\t\t\t\t\tvar mealType1=mealTypeList[checkBoxCount].mealType+\"\"+row_ind1; //63577\n\t\t\t\t\tparent.frames[1].document.getElementById(mealType1).checked = false;//63577\t\t\t\t \n\t\t\t\t}\t\n\t\t\t\telse if(parseInt(temp)== 1 && parseInt(secondCount) == 0)\n\t\t\t\t{\n\t\t\t\t\talert(\"Not Allowed to Place Multiple Meals for a Day\");\n\t\t\t\t\tvar mealType1=mealTypeList[checkBoxCount].mealType+\"\"+row_ind1;//63577\n\t\t\t\t\tparent.frames[1].document.getElementById(mealType1).checked = false;\t//63577\t\t\t\t\t \n\t\t\t\t}\t\t\n\t\t\t\t}\t\t\t\t\n\t\t\t\telse{\n\t\t\t\tif(parseInt(document.QueryResult.ChkboxCount.value) > 1  || (document.QueryResult.encounterCount.value ) > 0 )\n\t\t\t\t\talert(\"Not Allowed to Place Multiple Meals for a Day\");\n\t\t\t\t \tvar mealType1=mealTypeList[checkBoxCount].mealType+\"\"+row_ind1;//63577\n\t\t\t\t \tparent.frames[1].document.getElementById(mealType1).checked = false;\t//63577\t\t\n\t\t\t\t\t}\t\t\t\t \n\t            }\n\t\t\t//Added Against Ml-MMOH-CRF-0825(ICN-68623) Starts here\t\t\n\t\t\tvar check = document.querySelectorAll(\'input[type=\"checkbox\"].\'+mealTypes);\n\t\t\tvar chkedValues = \"\" ;\n\t\t\tvar chkedArray = new Array();\n\t\t\tvar j = 0; \n\t\t\tfor (i=0; i < check.length; i++)\n\t\t\t{\n\t\t\tif (check[i].checked)\n\t\t\t\t{\n\t\t\t\tif(chkedValues.length == 0)\n\t\t\t\tchkedValues = chkedValues;\n\t\t\t\tchkedValues = chkedValues + check[i].value + \",\";\n\t\t\t\tchkedArray[j] = i;\n\t\t\t\tj++;\n\t\t\t\t}\n\t\t\t}\n\t\t\tchkedValues=chkedValues.substring(0,chkedValues.length-1);\n\t\t\tparent.frames[1].document.getElementById(\"mealone\").value = chkedValues;\n\t\t\t//Added Against Ml-MMOH-CRF-0825(ICN-68623) Ends here\n\t    }\t\t\n//ML-MMOH-CRF-0596\t\n\t\n//Added Against ML-MMOH-CRF-0825 Starts Here\nfunction checkTheBox1(mealTypes,checkBoxCount,encounterCount,row_ind1,secondCount,obj){\n\t\tvar check = document.querySelectorAll(\'input[type=\"checkbox\"].\'+mealTypes);\n        var chkedValues = \"\";\n\t\tvar chkedArray = new Array();\n\t\tvar j = 0;\n\t\tfor (i=0; i < check.length; i++)\n\t\t{\n\t\t\n\t\tif (check[i].checked)\n\t\t\t{\n\t\t\tif(chkedValues.length == 0)\n\t\t\tchkedValues = chkedValues;\n\t\t\t//check[i].value =  check[i].value.substring(0,check[i].value.length-1);\n\t\t\tchkedValues = chkedValues + check[i].value + \",\";\n\t\t\tchkedArray[j] = i;\n\t\t\tj++;\n\t\t\t}\n\t\t}\n\t\t\n\t chkedValues=chkedValues.substring(0,chkedValues.length-1);\n\t document.forms[0].mealone.value = chkedValues; \n\t}\n//Added Against ML-MMOH-CRF-0825 Ends Here\n\n</script>\n<!-- Added Against ML-MMOH-CRF-0825 Starts Here -->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<!-- Added Against ML-MMOH-CRF-0825 Ends Here -->\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t\n<form name=\'QueryResult\' id=\'QueryResult\' action=\'../../servlet/eDS.PlaceMealOrderOPServlet\' method=\'post\' >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<input type=\"hidden\" name=\"locationCode\" id=\"locationCode\" value=\"\">\n<input type=\"hidden\" name=\"locationType\" id=\"locationType\" value=\"\">\n<input type=\"hidden\" name=\"jsonData\" id=\"jsonData\" value=\"\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"\">\n<input type=\"hidden\" name=\"ChkboxCount\" id=\"ChkboxCount\" value=\"\"><!---ML-MMOH-CRF-0596----->\n<input type=\"hidden\" name=\"splility\" id=\"splility\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"> <!--ML-MMOH-CRF-0596------>\n<input type=\"hidden\" name=\"encounterCount\" id=\"encounterCount\" value=\"\"> <!---ML-MMOH-CRF-0596--->\n<input type=\"hidden\" name=\"secondCount\" id=\"secondCount\" value=\"\"> <!---ML-MMOH-CRF-0596--->\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\"> <!---ML-MMOH-CRF-0596--->\n<input type=\"hidden\" name=\"systemDate\" id=\"systemDate\" id=\"systemDate\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"><!-- ML-MMOH-CRF-0825 -->\n<table width=\"100%\"  border=\"0\" align=\"left\" cellpadding=\"0\" cellspacing=\"0\">\t\t\n\t\t\n\t<tr>\n\t\t<td class=LABEL>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td><input name=\"kitchen\" id=\"kitchen\" type=\"text\" readonly/>\n\t\t\t<input name=\"hdnkitchen\" id=\"hdnkitchen\" type=\"hidden\" readonly/>\n\t\t</td>\n\t\t<td  class=LABEL colspan=\"1\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td nowrap colspan=\"1\" id=\"tdHdrDietType\" >\n\t\t\t<select name=\"dietType\" id=\"dietType\" onKeyUp=\"diettype_Autocomplete();\" onchange=\"fecthDietTypeToMealClass();\" onClick=\"Select()\"> <!--Modified Against ML-MMOH-CRF-0674--->\n\t\t\t\t<option>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t</option>\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t</tr>\n</table>\n<br/><br/>\n<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"   align=\"center\" >\n\t<tr><th colspan=13 align=left>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </th></tr>\n\t<tr><td><br/></td></tr>\t\n</table>\t\n\n\t<div border=\"2\" style=\"width:100%;height:80%;float:left;overflow-x: scroll;overflow-y: scroll;position:absolute;\">\n\t<table width=200% border=\"1\" cellpadding=\"0\" cellspacing=\"0\"   id=\"result\" >\n\t\t\t<thead id=\"divOPMealOrderHdr\" height=10%><tr>\n\t\t\t\t\t</tr></thead>\n\t\n\t\t\t<tbody id=\"divOPMealOrderList\" height=90% style = \"overflow:scroll;\">\t\n\t\t\t</tbody>\n\t</table>\n\t</div>\t\n\t\n\t\t<input type=hidden name=\"mealTypeCount\" id=\"mealTypeCount\"/>\n\t\t<input type=hidden name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\n<table><tr><td></td></tr>\n</table>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n<input type=\"hidden\" name=\"LATE_IRREGULAR_DIET_ORD_FOR_OP\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_OP\" id=\"LATE_IRREGULAR_DIET_ORD_FOR_OP\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" /><!-- Added Against ML-MMOH-CRF-0825 -->\n\n<script language=\"javascript\">\n/**\nFile Name\t\t\t: PlaceMealOrderOPMain.js\nFile Description\t: This is to Placing order for Outpatient.\nCRF#\t\t\t\t: Bru-HIMS-CRF-230\nAuthor\t\t\t\t: Abirami\nDate\t\t\t\t: Aug-2013\n**/\n\n\tvar gRecordUpdated = new Array();\n\tvar nIndex = 0;\n\t//Set Flag for identifying the changes on row.\n\tfunction setFlagForDietType(rowind, modFlag)\n\t{\t\n\t\tif(modFlag == \"N\" || modFlag == \"Y\" )\n\t\t\tgRecordUpdated[nIndex++] = rowind;\n\t}\n\t//CRF-0684\n\tfunction setFlagForMenuType(rowind, modFlag)\n\t{\n\t\tif(modFlag == \"N\" || modFlag == \"Y\" )\n\t\t\tgRecordUpdated[nIndex++] = rowind;\n\t}\n\t\n\t//Set Flag for identifying the changes on row.\n\tfunction setFlag(rowind)\n\t{ \n\t\tgRecordUpdated[nIndex++] = rowind;\n\t}\n\t\n\t//Fetching Header Diet Type values to the Diettype column of all the rows of the table.\n\tfunction fecthDietTypeToMealClass(){\n\t\tfor(var i=0;i<divOPMealOrderList.rows.length; i++)\n\t\t\t{\n\t\t\t\tvar tmpmodFlag = parent.frames[1].document.getElementById(\"modFlag\"+i).value;\n\t\t\t\t//Added Against Ml-MMOH-CRF-0674 starts Here\n\t\t\t\tdocument.getElementById(\"diettype_auto1\").value=\"\";\n\t\t\t\tdocument.getElementById(\"auto_flag1\").value=\"false\";\t\t\t\t\n\t\t\t\tfecthDietType1(i,tmpmodFlag);\n\t\t\t\t//Added Against Ml-MMOH-CRF-0674 Ends Here\n\t\t\t\tparent.frames[1].document.getElementById(\"dietTypes\"+i).value = document.getElementById(\"dietTypes\").value ;\n\t\t\t\t\n\t\t\t\tif( tmpmodFlag == \"N\" || tmpmodFlag == \"Y\") \n\t\t\t\t\tgRecordUpdated[nIndex++] = i; // Set Flag for identifying the changes on row\n\t\t\t}\n\t}\n\t\n\tvar checkBoxCount =\"\"; //ML-MMOH-CRF-0596\n\t//Non-Function Source: This code will be executed on this page load:\n\tvar globalMealTypeList = new Array();\n\tvar globalSplFoodList  = new Array();\n\tvar globalFoodDislike  = new Array();\n\tvar OPMealTypes = new Array();\n\tvar PreparatoryInstruction_Label=getLabel(\"eOT.preparatoryInstruction.Label\",\"OT\");//417\n\tvar Remarks_Label=getLabel(\"eDS.Remarks.Label\",\"DS\");//417\n\t\t\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\tvar xmlStr =\"<root></root>\";\n\tvar params = parent.jsonOPObj;\n\t\n\tvar diettype_auto=\"\";//Added Against ML-MMOH-CRF-0674\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\", \"../../servlet/eDS.PlaceMealOrderOPServlet?\"+params+\"&diettype_auto=\"+diettype_auto,false);//Added Against ML-MMOH-CRF-0674\n\txmlHttp.send(xmlDoc);\n\tvar retVal = xmlHttp.responseText;\t\n\t\n\tvar jsonObjResponse=eval(\'(\' + retVal + \')\');\n\t\n\t/*** Setting Header Values****/\n\t\n\t//Getting and Setting Kitchen values::\n\tdocument.getElementById(\"kitchen\").value = jsonObjResponse.jsonKitchenDesc;\n\tdocument.getElementById(\"hdnkitchen\").value = jsonObjResponse.jsonKitchenCode;\n\t\n\t//Getting and Setting Diet type values::\n\t//Getting diet type list::\n\tvar dietList=new Array();\n\tdietList = jsonObjResponse.jsonDietList;\n\t\n\t//Added Starts against ML-MMOH-CRF-0418 \n\tvar dietListlength=0;\n\tif(typeof(dietList)!=\'undefined\')\n\tdietListlength=dietList.length; \n\t//Added Ends against ML-MMOH-CRF-0418\n\t\n\tvar selObj = \"<SELECT name=\'dietTypes\' id=\'dietTypes\' onKeyUp=\'diettype_Autocomplete();\' onClick=\'Select()\' onchange=\'fecthDietTypeToMealClass();\'>\";//Added Against ML-MMOH-CRF-0674\n\tvar label=getLabel(\"Common.defaultSelect.label\",\"Common\");\n\t//Added against ML-MMOH-CRF-0418 \n\tif(dietListlength!=1)\n\tselObj += \"<OPTION value=\'\'>\"+label+\"</OPTION>\";\n\tfor (var j=0; j < dietListlength;j++) {//Modified against ML-MMOH-CRF-0418 \n\t\tvar value = (dietList[j].DietCode);\n\t\tvar desc = (dietList[j].DietDesc);\n\t\tselObj += \"<OPTION value=\'\" + value + \"\'>\" + desc + \"</OPTION>\";\n\t}\t\n\tdocument.getElementById(\"tdHdrDietType\").innerHTML = selObj;\n\t\n\t//Added for CRf-0684\n      \t  var menuList=new Array();\n\t  menuList = jsonObjResponse.jsonMenuList;\n\t  var menuListlength=0;\n\t  if(typeof(menuList)!=\'undefined\')\n\t  \tmenuListlength=menuList.length;\n      \t\tvar selObj = \"<SELECT name=\'menuType\' id=\'menuType\'  >\";\n\t  \tvar label=getLabel(\"Common.defaultSelect.label\",\"Common\");\n\t  if(menuListlength!=1)\n\t   \tselObj += \"<OPTION value=\'\'>\"+label+\"</OPTION>\";\n\t   for (var j=0; j < menuListlength;j++) {\n\t   \tvar value = (menuList[j].menuCode);\n       \t\tvar desc = (menuList[j].shortDesc);\n\t   \tselObj += \"<OPTION value=\'\" + value + \"\'>\" + desc + \"</OPTION>\";\n\t\t}\t               \n\t\t\t\t\t\n\t/****** Setting Table values ******/\n\t\n\t//Getting Meal Type List::\n\tvar mealTypeList=new Array();\n\tmealTypeList = jsonObjResponse.jsonMealList;\n\tglobalMealTypeList = jsonObjResponse.jsonMealList;\n\tvar strMealTypes = \"\";\n\t\n\tfor (var j=0; j < globalMealTypeList.length;j++) {\n\t\n\t\tif(strMealTypes != \"\")\n\t\t{\n\t\t\t//strMealTypes += \",\" + globalMealTypeList[j].mealType + \",\" + globalMealTypeList[j].shortDesc;\n\t\t\tstrMealTypes += \"::\" + globalMealTypeList[j].mealType;\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//strMealTypes += globalMealTypeList[j].mealType + \",\" + globalMealTypeList[j].shortDesc;\n\t\t\tstrMealTypes += globalMealTypeList[j].mealType;\n\t\t}\n\t}\t\n\tOPMealTypes = strMealTypes;\n\t\n\t var tHead = document.getElementById(\"divOPMealOrderHdr\");\n\t var newTH = document.createElement(\'th\');\n\t tHead.rows[0].appendChild(newTH); //append ne th to table \n\t newTH.innerHTML = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\n\t var newTH = document.createElement(\'th\');\n\t tHead.rows[0].appendChild(newTH); //append ne th to table \n\t newTH.innerHTML = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t \n\t var newTH = document.createElement(\'th\');\n\t tHead.rows[0].appendChild(newTH); //append ne th to table \n\t newTH.innerHTML = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t \n\t  //CRF 684\n\t  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t var newTH = document.createElement(\'th\');\n\t tHead.rows[0].appendChild(newTH); //append ne th to table \n\t newTH.innerHTML = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\t\n\t  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t \n\t var newTH = document.createElement(\'th\');\n\t tHead.rows[0].appendChild(newTH); //append ne th to table \n\t newTH.innerHTML = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\n\t\t\n\t  for (var j=0; j < mealTypeList.length;j++) {\n\t\t\tvar newTH = document.createElement(\'th\');\n\t\t\ttHead.rows[0].appendChild(newTH); //append ne th to table \n\t\t\t\n\t\t\tnewTH.innerHTML = mealTypeList[j].shortDesc;\n\t\t\t//newTH.innerHTML = mealTypeList[j][1];\n\t\t}\n\n\t  //Setting hidden value for mealtype count::\n\t document.getElementById(\"mealTypeCount\").value = mealTypeList;\t\n\t\t\n\t var newTH = document.createElement(\'th\');\n\t tHead.rows[0].appendChild(newTH); //append ne th to table \n\t newTH.innerHTML = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\n     \tvar newTH = document.createElement(\'th\');\n\t tHead.rows[0].appendChild(newTH); //append ne th to table \n\t newTH.innerHTML = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\n\t//MMOH-CRF-417\n\t var newTH = document.createElement(\'th\');\n\t tHead.rows[0].appendChild(newTH); //append ne th to table \n\t newTH.innerHTML = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t//MMOH-CRF-417\n\t \n\t var newTH = document.createElement(\'th\');\n\t tHead.rows[0].appendChild(newTH); //append ne th to table \n\t newTH.innerHTML = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</TH>\"; \n\t\n \t//Getting Meal Record List::\n\tvar orderList=new Array();\n\torderList = jsonObjResponse.jsonOrderList;\n\tvar divOPMealOrderList = document.getElementById(\"divOPMealOrderList\");\n\tvar row_ind1 = 0;\n\t\n\tif(orderList!=null)\n\t{\n\t\t//getting maximum record\n\t\t\n\t    if(orderList.length == 0){\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t}\n\t\telse{\t\n\t\t\t//Mealtype outer list , which has the list for all records\n\t\t\tvar mealList=new Array();\n\t\t\tmealList = jsonObjResponse.jsonMealTypeList;\n\t\t\t\n\t\t\tfor(var itr=0; itr <orderList.length;itr++){\n\t\t\t\t\tvar newRow3 = divOPMealOrderList.insertRow(row_ind1);\n\t\t\t\t\t//FOr Mealtype::\n\t\t\t\t\t\n\t\t\t\t\tvar objMealTypes = new Array();\n\t\t\t\t\tif(orderList[itr].apptno != \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tobjMealTypes = eval(\"mealList[0].appt\"+orderList[itr].apptno);\n\t\t\t\t\t}else if(orderList[itr].encounterid != \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tobjMealTypes = eval(\"mealList[0].enct\"+orderList[itr].encounterid);\n\t\t\t\t\t}\n\t\t\t\t\t \n\t\t\t\t\t var specality=document.QueryResult.splility.value;//ML-MMOH-CRF-0596\n\n\t\t\t\t\t \n\t\t\t\t\t//Patient ID:\n\t\t\t\t\tvar newCellDesc = fnInsertCell(newRow3);\n\t\t\t\t\tnewCellDesc.appendChild(document.createTextNode(orderList[itr].patientId));\n\t\t\t\t\tnewCellDesc.id = \"patId\"+ row_ind1;\n\t\t\t\t\tnewCellDesc.value = orderList[itr].patientId;\n\t\t\t\t\tif(orderList[itr].patientId == \"\")\n\t\t\t\t\t\tnewCellDesc.innerHTML = \"&nbsp;\";\n\t\t\t\t\t//ML-MMOH-CRF-0596\n\t\t\t\t\tvar patient_id = newCellDesc.value;\t\t\t\n\t\t\t                var xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\tvar params = \"func_mode=OPMealCount&patient_id=\"+patient_id+\"&specality=\"+specality;//ML-MMOH-CRF-0596\n\t\t\t\t\txmlHttp.open(\"GET\",\"../../eDS/jsp/DLCommonValidation.jsp?\"+params,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\t\tvar encounterCount =retVal;\n\t\t\t\t\tdocument.QueryResult.encounterCount.value=encounterCount;\n\t\t\t\t\t//ML-MMOH-CRF-0596\n\n\t\t\t\t\t\n\t\t\t\t\t//PatientName:\n\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\tnewCellDesc2.appendChild(document.createTextNode(orderList[itr].patientName));\n\t\t\t\t\tnewCellDesc2.id = \"patName\"+ row_ind1;\n\t\t\t\t\tnewCellDesc2.value = orderList[itr].patientName;\n\t\t\t\t\tif(orderList[itr].patientName == \"\")\n\t\t\t\t\t\tnewCellDesc2.innerHTML = \"&nbsp;\";\n\t\t\t\t\t\n\t\t\t\t\t//Appointment Date:\n\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\tnewCellDesc2.appendChild(document.createTextNode(orderList[itr].apptDate + \" \" + orderList[itr].apptTime));\n\t\t\t\t\tnewCellDesc2.id = \"apptDate\"+ row_ind1;\n\t\t\t\t\tnewCellDesc2.value = orderList[itr].apptDate;\n\t\t\t\t\tif(orderList[itr].apptDate == \"\")\n\t\t\t\t\t\tnewCellDesc2.innerHTML = \"&nbsp;\";\n\t\t\t\t\t\t\n\t\t\t\t\t//Visit Date:\n\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\tnewCellDesc2.appendChild(document.createTextNode(orderList[itr].visitDate));\n\t\t\t\t\tnewCellDesc2.id = \"visitDate\"+ row_ind1;\n\t\t\t\t\tnewCellDesc2.value = orderList[itr].visitDate;\n\t\t\t\t\tif(orderList[itr].visitDate == \"\")\n\t\t\t\t\t\tnewCellDesc2.innerHTML = \"&nbsp;\";\n\t\t\t\t\t\t\n\t\t\t\t\t//Appointment No:\n\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\tif(orderList[itr].ApptNo == null)\n\t\t\t\t\t\torderList[itr].ApptNo = \"\";\n\t\t\t\t\tnewCellDesc2.appendChild(document.createTextNode(orderList[itr].apptno));\n\t\t\t\t\tnewCellDesc2.id = \"apptNo\"+ row_ind1;\n\t\t\t\t\tnewCellDesc2.value = orderList[itr].apptno;\n\t\t\t\t\tif(orderList[itr].apptno == \"\")\n\t\t\t\t\t\tnewCellDesc2.innerHTML = \"&nbsp;\";\n\t\t\t\t\t\t\n\t\t\t\t\t//Encounter ID:\n\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\tnewCellDesc2.appendChild(document.createTextNode(orderList[itr].encounterid));\n\t\t\t\t\tnewCellDesc2.id = \"enctId\"+ row_ind1;\n\t\t\t\t\tnewCellDesc2.value = orderList[itr].encounterid;\n\t\t\t\t\tif(orderList[itr].encounterid == \"\")\n\t\t\t\t\t\tnewCellDesc2.innerHTML = \"&nbsp;\";\n\t\t\t\t\t\n\t\t\t\t\t//ML-MMOH-CRF-0596\t\t\t\t\t\t\n\t                \t\tvar encounteridnew=newCellDesc2.value;\n\t\t\t        \tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\tvar params2 = \"func_mode=OPMealCount2&encounteridnew=\"+encounteridnew+\"&specality=\"+specality;//ML-MMOH-CRF-0596\n\t\t\t\t\txmlHttp.open(\"GET\",\"../../eDS/jsp/DLCommonValidation.jsp?\"+params2,false);\n\t\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\t\tvar retVal2 = trimString(xmlHttp.responseText);\n\t\t\t\t\tvar secondCount =retVal2;\n\t\t\t\t\tdocument.QueryResult.secondCount.value=secondCount;\t\n\t\t\t\t\t//ML-MMOH-CRF-0596\n\t\t\t\t\t\n\t\t\t//CRF-684\n\t\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\tvar sModFlag = orderList[itr].modifiedFlag;\n\t\t\t\tvar selObj = \"<SELECT name=\'menuType\"+row_ind1+\"\' id=\'menuType\"+row_ind1+\"\'    onchange=\\\"setFlagForMenuType(\'\"+row_ind1+\"\',\'\"+sModFlag+\"\');\\\">\";\n\t\t\t\tvar label=getLabel(\"Common.defaultSelect.label\",\"Common\");\t\t\t\t\t\t\n\n\t\t\t\tvar menuList=new Array();\n\t\t\t\tmenuList = jsonObjResponse.jsonMenuList;\n\t\t\t\tvar menuListlength=0;\n\t\t\t\tif(typeof(menuList)!=\'undefined\')\n\t\t\t\tmenuListlength=menuList.length;\n\t\t\t\tif(menuListlength!=1)\n\t\t\t\tselObj += \"<OPTION value=\'\'>\"+label+\"</OPTION>\";\n\t\t\t\tfor (var j=0; j < menuListlength;j++) {\n\t\t\t\tvar value = (menuList[j].menuCode);\n\t\t\t\tvar desc = (menuList[j].shortDesc);\n\t\t\t\tvar DEFAULT_YN = (menuList[j].DEFAULT_YN);\n\t\t\t\tvar defaultcount = (menuList[j].defaultcount);\n\t\t\t    \tif(defaultcount == 1 && DEFAULT_YN == \"Y\")\n\t\t\t\t{\n\t\t\t\t    selObj += \"<OPTION value=\'\" + value + \"\' selected>\" + desc + \"</OPTION>\";\n\t\t\t\t}\n\t                 \telse if((menuList[j].menuCode) == (orderList[itr].menuType))\n\t\t\t\t{\n\t\t\t\t\t selObj += \"<OPTION value=\'\" + value + \"\' selected>\" + desc + \"</OPTION>\";\n\t\t\t    \t}\n\t\t\t\telse{\n\t\t\t\t\t    selObj += \"<OPTION value=\'\" + value + \"\'>\" + desc + \"</OPTION>\";\t\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\t}\t\t           \n\t                 \t\t\t\n\t\t\t\tselObj += \"</SELECT>\";\t\t\t\t\t\t\n\t\t\t\tselObj += \"<img src=\'../../eCommon/images/mandatory.gif\' id=\\\'menuType\"+row_ind1+\"\\\'  style=\\\'visibility:visible\\\' />\";\n\t\t\t\tnewCellDesc2.innerHTML = selObj;\n\t\t\t  ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t \n\n\t\t\t\t\t//Diet Type:\n\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\tvar sModFlag = orderList[itr].modifiedFlag;\n\n\t\t\t\t\tvar selObj = \"<SELECT name=\'dietTypes\"+row_ind1+\"\' id=\'dietTypes\"+row_ind1+\"\' onKeyUp=\\\"diettype_Autocomplete1(\'\"+row_ind1+\"\',\'\"+sModFlag+\"\')\\\" onClick=\\\"Select1(\'\"+row_ind1+\"\',\'\"+sModFlag+\"\')\\\" onchange=\\\"setFlagForDietType(\'\"+row_ind1+\"\',\'\"+sModFlag+\"\');\\\">\";//Added Against Ml-MMOH-CRF-0674\t\t\t\t\n\t\t\t\t\n\t\t\t\t\tvar label=getLabel(\"Common.defaultSelect.label\",\"Common\");\n\t\t\t\t\n         \t\t   //Added Starts against ML-MMOH-CRF-0418 \n\t               var dietListlength=0;\n\t               if(typeof(dietList)!=\'undefined\')\n\t               dietListlength=dietList.length;\n\t               //Added Ends against ML-MMOH-CRF-0418\n\t\n\t                //Added against ML-MMOH-CRF-0418 \n\t                if(dietListlength!=1)\n\t\t\t\t\t selObj += \"<OPTION value=\'\'>\"+label+\"</OPTION>\";\n\t\t\t\t\tfor (var j=0; j <dietListlength;j++) { //Modified against ML-MMOH-CRF-0418 \n\t\t\t\t\t\t//var value = (dietList[j]);\n\t\t\t\t\t\t//var desc = (dietList[j]);\n\t\t\t\t\t\tvar value = (dietList[j].DietCode);\n\t\t\t\t\t\tvar desc = (dietList[j].DietDesc);\n\t\t\t\t\t\tif((dietList[j].DietCode) == (orderList[itr].diettype)){\n\t\t\t\t\t\t\tselObj += \"<OPTION value=\'\" + value + \"\' selected>\" + desc + \"</OPTION>\";\n                           \t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tselObj += \"<OPTION value=\'\" + value + \"\'>\" + desc + \"</OPTION>\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tselObj += \"</SELECT>\";\n\t\t\t\t\tnewCellDesc2.innerHTML = selObj;\t\t\t\t\t\n                     \n\t\t\t\t\t//MealTypes:\n\t\t\t\t\t     ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\t\t\t\n\t\t\t\t\t   for (var j=0; j < mealTypeList.length;j++) {\n\t\t\t\t\t\tvar newCellDesc2 = newRow3.insertCell(newRow3.cells.length);\n\t\t\t\t\t\tnewCellDesc2.align = \"center\";\n\t\t\t\t\t\tvar tmpMealtype = mealTypeList[j].mealType;\n\t\t\t\t\t\tvar varMealName = mealTypeList[j].mealType + \"\" + row_ind1;\n\t\t\t\t\t\t\n\t\t\t\t\t\t//Added Against ML-MMOH-CRF-0825 Starts Here\n\t\t\t\t\t\tvar ServingStartTimeOP = mealTypeList[j].ServingStartTimeOP;\n\t\t\t\t\t\tif (ServingStartTimeOP == \"undefined\" || ServingStartTimeOP== null){\n\t\t\t\t\t\t\tServingStartTimeOP = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar ServingEndTimeOP = mealTypeList[j].ServingEndTimeOP;\n\t\t\t\t\t\tif (ServingEndTimeOP == \"undefined\" || ServingEndTimeOP== null){\n\t\t\t\t\t\t\tServingEndTimeOP = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar IrregularStartTimeOP = mealTypeList[j].IrregularStartTimeOP;\n\t\t\t\t\t\tif (IrregularStartTimeOP == \"undefined\" || IrregularStartTimeOP== null){\n\t\t\t\t\t\t\tIrregularStartTimeOP = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar IrregularEndTimeOP = mealTypeList[j].IrregularEndTimeOP;\n\t\t\t\t\t\tif (IrregularEndTimeOP == \"undefined\" || IrregularEndTimeOP== null){\n\t\t\t\t\t\t\tIrregularEndTimeOP = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar nextServingStartTimeOP = mealTypeList[j].nextServingStartTimeOP;\n\t\t\t\t\t\tif(ServingStartTimeOP==\"\" && ServingEndTimeOP==\"\" && IrregularStartTimeOP==\"\" && IrregularEndTimeOP==\"\"){\n\t\t\t\t\t\t\tIrregularEndTimeOP = nextServingStartTimeOP;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar today = new Date(); \n\t\t\t\t\t\tvar hour=today.getHours();\n\t\t\t\t\t\tif(hour<=9){\n\t\t\t\t\t\t\thour=\"0\"+\"\"+hour;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar minute=today.getMinutes();\n\t\t\t\t\t\tif(minute<=9){\n\t\t\t\t\t\t\tminute=\"0\"+\"\"+minute;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar Sys_time = hour+\":\"+minute;\t\n\t\t\t\t\t\tvar lateIrregularDietOrderOP = document.getElementById(\"LATE_IRREGULAR_DIET_ORD_FOR_OP\").value;\n\t\t\t\t\t\t//Added Against ML-MMOH-CRF-0825 Ends Here\n\t\t\t\t\t\t\n\t\t\t\t\t\t//var mealName1 = mealTypeList[j].mealType;\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(objMealTypes != \"undefined\" && objMealTypes.contains(tmpMealtype))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t//Modified Against ML-MMOH-CRF-0825 Starts Here\n\t\t\t\t\t\t\tif(lateIrregularDietOrderOP == \"Y\" && IrregularEndTimeOP == \"\" && ServingEndTimeOP != \"\" && ServingEndTimeOP < Sys_time){\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\' align = \'center\' disabled onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' value=\'N\'>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(lateIrregularDietOrderOP == \"Y\" && IrregularEndTimeOP != \"\" && IrregularEndTimeOP < Sys_time){\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\'  align = \'center\' disabled onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' value=\'N\'>\";\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\' align = \'center\' onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' checked value=\'\"+ varMealName +\"\' onclick =\\\"checkTheBox1(this.className,\'\"+checkBoxCount+\"\',\'\"+encounterCount+\"\',\'\"+row_ind1+\"\',\'\"+secondCount+\"\',this);\\\">\";\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\tif(lateIrregularDietOrderOP == \"Y\" && IrregularEndTimeOP == \"\" && ServingEndTimeOP != \"\" && ServingEndTimeOP < Sys_time){\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\' align = \'center\' disabled onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' value=\'N\'>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(lateIrregularDietOrderOP == \"Y\" && IrregularEndTimeOP != \"\" && IrregularEndTimeOP < Sys_time){\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\'  align = \'center\' disabled onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' value=\'N\'>\";\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\' align = \'center\' onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' value=\'\"+ varMealName +\"\' onclick =\\\"checkTheBox1(this.className,\'\"+checkBoxCount+\"\',\'\"+encounterCount+\"\',\'\"+row_ind1+\"\',\'\"+secondCount+\"\',this);\\\">\";\n\t\t\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//Modified Against ML-MMOH-CRF-0825 Ends Here\n\t\t\t\t\t\tnewCellDesc2.innerHTML = sel;\n\t\t\t\t\t    }\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\t\t\t\n\t\t\t\t\t ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\t\t\t   \n\t\t\t\t\t    for (var j=0; j < mealTypeList.length;j++) {\n\t\t\t\t\t\tvar newCellDesc2 = newRow3.insertCell(newRow3.cells.length);\n\t\t\t\t\t\tnewCellDesc2.align = \"center\";\n\t\t\t\t\t\tvar tmpMealtype = mealTypeList[j].mealType;\n\t\t\t\t\t\t//Added Against ML-MMOH-CRF-0825 Starts Here\n\t\t\t\t\t\tvar ServingStartTimeOP = mealTypeList[j].ServingStartTimeOP;\n\t\t\t\t\t\tif (ServingStartTimeOP == \"undefined\" || ServingStartTimeOP== null){\n\t\t\t\t\t\t\tServingStartTimeOP = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar ServingEndTimeOP = mealTypeList[j].ServingEndTimeOP;\n\t\t\t\t\t\tif (ServingEndTimeOP == \"undefined\" || ServingEndTimeOP== null){\n\t\t\t\t\t\t\tServingEndTimeOP = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar IrregularStartTimeOP = mealTypeList[j].IrregularStartTimeOP;\n\t\t\t\t\t\tif (IrregularStartTimeOP == \"undefined\" || IrregularStartTimeOP== null){\n\t\t\t\t\t\t\tIrregularStartTimeOP = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar IrregularEndTimeOP = mealTypeList[j].IrregularEndTimeOP;\n\t\t\t\t\t\tif (IrregularEndTimeOP == \"undefined\" || IrregularEndTimeOP== null){\n\t\t\t\t\t\t\tIrregularEndTimeOP = \"\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar nextServingStartTimeOP = mealTypeList[j].nextServingStartTimeOP;\n\t\t\t\t\t\tif(ServingStartTimeOP==\"\" && ServingEndTimeOP==\"\" && IrregularStartTimeOP==\"\" && IrregularEndTimeOP==\"\" ){\n\t\t\t\t\t\t\tIrregularEndTimeOP = nextServingStartTimeOP;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar today = new Date();\n\t\t\t\t\t\tvar hour=today.getHours();\n\t\t\t\t\t\tif(hour<=9){\n\t\t\t\t\t\t\thour=\"0\"+\"\"+hour;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar minute=today.getMinutes();\n\t\t\t\t\t\tif(minute<=9){\n\t\t\t\t\t\t\tminute=\"0\"+\"\"+minute;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar Sys_time = hour+\":\"+minute;\n\t\t\t\t\t\tvar lateIrregularDietOrderOP = document.getElementById(\"LATE_IRREGULAR_DIET_ORD_FOR_OP\").value;\n\t\t\t\t\t\t//Added Against ML-MMOH-CRF-0825 Ends Here\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar varMealName = mealTypeList[j].mealType + \"\" + row_ind1;\n\t\t\t\t\t\tif(objMealTypes != \"undefined\" && objMealTypes.contains(tmpMealtype))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//Modified Against ML-MMOH-CRF-0825 Starts Here\n\t\t\t\t\t\t\tif(lateIrregularDietOrderOP == \"Y\" && IrregularEndTimeOP == \"\" && ServingEndTimeOP != \"\" && ServingEndTimeOP < Sys_time){\n\t\t\t\t\t\t\t\tcheckBoxCount=j;\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\' align = \'center\' disabled onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' value=\'N\' onclick =\\\"checkTheBox(this.className,\'\"+checkBoxCount+\"\',\'\"+encounterCount+\"\',\'\"+row_ind1+\"\',\'\"+secondCount+\"\');\\\">\";\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\t\telse if(lateIrregularDietOrderOP == \"Y\" && IrregularEndTimeOP != \"\" && IrregularEndTimeOP < Sys_time ){\n\t\t\t\t\t\t\t\tcheckBoxCount=j;\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\'  align = \'center\' disabled onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' value=\'N\' onclick =\\\"checkTheBox(this.className,\'\"+checkBoxCount+\"\',\'\"+encounterCount+\"\',\'\"+row_ind1+\"\',\'\"+secondCount+\"\');\\\">\";\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\tcheckBoxCount=j;\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\' align = \'center\' onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' checked value=\'\"+ varMealName +\"\' onclick =\\\"checkTheBox(this.className,\'\"+checkBoxCount+\"\',\'\"+encounterCount+\"\',\'\"+row_ind1+\"\',\'\"+secondCount+\"\');\\\" >\";//ML-MMOH-CRF-0596 and Modified Against ML-MMOH-CRF-0825(ICN-68623)\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tif(lateIrregularDietOrderOP == \"Y\" && IrregularEndTimeOP == \"\" && ServingEndTimeOP != \"\" && ServingEndTimeOP < Sys_time){\n\t\t\t\t\t\t\t\tcheckBoxCount=j;\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\' align = \'center\' disabled onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' value=\'N\' onclick =\\\"checkTheBox(this.className,\'\"+checkBoxCount+\"\',\'\"+encounterCount+\"\',\'\"+row_ind1+\"\',\'\"+secondCount+\"\');\\\">\"; //ML-MMOH-CRF-0596\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse if(lateIrregularDietOrderOP == \"Y\" && IrregularEndTimeOP != \"\" && IrregularEndTimeOP < Sys_time){\n\t\t\t\t\t\t\t\tcheckBoxCount=j;\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\' align = \'center\' disabled onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' value=\'N\' onclick =\\\"checkTheBox(this.className,\'\"+checkBoxCount+\"\',\'\"+encounterCount+\"\',\'\"+row_ind1+\"\',\'\"+secondCount+\"\');\\\">\"; //ML-MMOH-CRF-0596\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\tcheckBoxCount=j;\n\t\t\t\t\t\t\t\tsel = \"<input type=\'checkbox\' class=\'mealTypes\' align = \'center\' onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'\"+ varMealName +\"\' id=\'\"+ varMealName +\"\' value=\'\"+ varMealName +\"\' onclick =\\\"checkTheBox(this.className,\'\"+checkBoxCount+\"\',\'\"+encounterCount+\"\',\'\"+row_ind1+\"\',\'\"+secondCount+\"\');\\\">\"; //ML-MMOH-CRF-0596 and Modified Against ML-MMOH-CRF-0825(ICN-68623)\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//Modified Against ML-MMOH-CRF-0825 Ends Here\n\t\t\t\t\t\tnewCellDesc2.innerHTML = sel;\n\t\t\t\t    \t}\n\t\t\t\t\t\t\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\n\t\t\t\t\t//Food Dislike:\n\t\t\t\t\tvar foodDislike = new Array();\n\t\t\t\t\tfoodDislike = orderList[itr].jsonFoodList.jsonFoodItem;\n\t\t\t\t\t\n\t\t\t\t\tif(foodDislike != undefined)\n\t\t\t\t\t{\n\t\t\t\t\t\tglobalFoodDislike[row_ind1] = orderList[itr].jsonFoodList.jsonFoodItem;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tglobalFoodDislike[row_ind1] = new Array();\n\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t//globalFoodDislike. push(foodDislike);\n\t\t\t\t\t\n\t\t\t\t\tvar nFoodDislike = \'foodDislike\'+row_ind1;\n\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\tvar selObj = \"<div id=\'\"+nFoodDislike+\"\' value=\"+foodDislike+\"><SELECT name=\'fooddislike\' id=\'fooddislike\' onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" size=2>\";\n\t\t\t\t\tif(foodDislike != undefined)\n\t\t\t\t\t{\n\t\t\t\t\t\tfor (var j=0; j < foodDislike.length;j++) {\n\t\t\t\t\t\t\tvar internObj = foodDislike[j];\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar value = internObj[0]\n\t\t\t\t\t\t\tvar desc = internObj[1];\n\t\t\t\t\t\t\tselObj += \"<OPTION value=\'\" + value + \"\'>\" + desc + \"</OPTION>\";\n\t\t\t\t\t\t}\t\n\t\t\t\t\t}\n\t\t\t\t\tselObj += \"</SELECT></div>\";\n\t\t\t\t\tselObj += \"<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'   name=\'btnfoodDislike\' onClick=\\\"return getFoodItem(this,\\\'\" + nFoodDislike + \"\\\',\\\'\" + row_ind1 + \"\\\')\\\";>\";\t\n\t\t\t\t\tnewCellDesc2.innerHTML = selObj;\n\n\t\t\t\t\t//Special Food Item:\n\t\t\t\t\t\n\t\t\t\t\tvar splfoodList = new Array();\n\t\t\t\t\tsplfoodList = orderList[itr].jsonSplFoodList.jsonSplFoodItem;\n\t\t\t\t\tif(splfoodList != undefined)\n\t\t\t\t\t\tglobalSplFoodList[row_ind1] = orderList[itr].jsonSplFoodList.jsonSplFoodItem;\n\t\t\t\t\telse\n\t\t\t\t\t\tglobalSplFoodList[row_ind1] = new Array();\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar nSplFood = \'splFoodSrl\'+itr;\n\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\t\tvar selObj = \"<div id=\'\"+nSplFood+\"\'><SELECT name=\'splfooditem\' id=\'splfooditem\' onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" size=2>\";\n\t\t\t\t   \n\t\t\t\t\tif(splfoodList != undefined)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar uniqueFoodItem = new Array();\n\t\t\t\t\t\tvar indexUniqueFI = 0;\n\t\t\t\t\t\tfor (var j=0; j < splfoodList.length;j++) {\n\t\t\t\t\t\t\tvar splinternObj = splfoodList[j];\n\t\t\t\t\t\t\tvar value = splinternObj[1];\n\t\t\t\t\t\t\tvar desc = splinternObj[3];\n\t\t\t\t\t\t\tif(!uniqueFoodItem.contains(value)) //To avoid replication of same food item [with different mealtype] in placeorder screen\n\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\tuniqueFoodItem[indexUniqueFI++] = value;\n\t\t\t\t\t\t\t\tselObj += \"<OPTION value=\'\" + value + \"\'>\" + desc + \"</OPTION>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\t\n\t\t\t\t\t}\t\n\t\t\t\t\tselObj += \"</SELECT></div>\";\n\t\t\t\t\tselObj += \"<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'   name=\'btnsplfoodItem\' onClick=\\\"return getSplFoodItem(\\\'\" + row_ind1 + \"\\\',\\\'\" + nSplFood + \"\\\')\\\";>\";\n\t\t\t\t\t\n\t\t\t\t\t//Hidden Variables:\n\t\t\t\t\t//1- SplFoodItem hidden variable::\n\t\t\t\t\t\n\t\t\t\t\tvar nHdnSplFood = \'hdnsplfoodItem\'+row_ind1;\n\t\t\t\t\tvar nHdnFoodDislike = \'hdnfoodDislikeItem\'+row_ind1;\n\t\t\t\t\t\n\t\t\t\t\tselObj += \"<input type=\'hidden\' value=\'\"+ foodDislike +\"\'   name=\'\" + nHdnFoodDislike + \"\' id=\'\" + nHdnFoodDislike + \"\'/>\";\n\t\t\t\t\tselObj += \"<input type=\'hidden\' value=\'\"+ splfoodList +\"\'   name=\'\" + nHdnSplFood + \"\' id=\'\" + nHdnSplFood + \"\'/>\";\n\t\t\t\t\t//2-ModFlag::\n\t\t\t\t\tselObj += \"<input type=\'hidden\' value=\'\"+orderList[itr].modifiedFlag+\"\'   name=\'modFlag\"+row_ind1+\"\' id=\'modFlag\"+row_ind1+\"\'/>\";\n\t\t\t\t\t//3-ServingDate::\n\t\t\t\t\tvar nHdnServingDate = \'hdnservingdate\'+row_ind1;\n\t\t\t\t\tselObj += \"<input type=\'hidden\' value=\'\"+orderList[itr].servingDate+\"\'   name=\'\" + nHdnServingDate + \"\' id=\'\" + nHdnServingDate + \"\'/>\";\n\t\t\t\t\tnewCellDesc2.innerHTML = selObj;\n\t\t\t\t\t\n\t\t\t\t\t//Prepartory Instruction\n\t\t\t\t\t//MMOH-CRF-417\t\t\t\t\t\n\t\t\t\t\tvar newCellDesc3 = fnInsertCell(newRow3);\n\t\t\t\t\thtmlRemarks = \"<textarea  onkeypress=\\\"restrictSpecialChars(event)\\\" onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'prepartoryInstr\"+ row_ind1 +\"\' id=\'prepartoryInstr\"+ row_ind1 +\"\' onKeyPress=\\\"return maxLength(this,\'400\');\\\" onKeyUp=\\\"return maxLengthPaste(this,\'400\',\'\"+row_ind1+\"\');\\\" onblur=\\\"return hasInvalidChars(this,\'\"+PreparatoryInstruction_Label+\"\');\\\" value=\'\\\"+orderList[itr].prepartoryInstr+\\\"\' rows=2>\"+decodeURIComponent(orderList[itr].prepartoryInstr)+\"</textarea>\";\n\t\t\t\t\t<!--058037-->\n\t\t\t\t\tnewCellDesc3.innerHTML = htmlRemarks;\n\t\t\t\t\t//MMOH-CRF-417\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t//Remarks:\n\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\thtmlRemarks = \"<textarea onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'remarks\"+ row_ind1 +\"\' id=\'remarks\"+ row_ind1 +\"\'  onKeyPress=\\\"return maxLength(this,\'150\');\\\" onKeyUp=\\\"return maxLengthPaste(this,\'150\',\'\"+row_ind1+\"\');\\\" value=\'\\\"+orderList[itr].remarks+\\\"\' rows=2>\"+decodeURIComponent(orderList[itr].remarks)+\"</textarea>\";\n\t\t\t\t\t//MMOH-CRF-417\n\t\t\t\t\thtmlRemarks = \"<textarea  onkeypress=\\\"restrictSpecialChars(event)\\\" onchange=\\\"setFlag(\'\"+row_ind1+\"\');\\\" name=\'remarks\"+ row_ind1 +\"\' id=\'remarks\"+ row_ind1 +\"\' onKeyPress=\\\"return maxLength(this,\'150\');\\\" onKeyUp=\\\"return maxLengthPaste(this,\'150\',\'\"+row_ind1+\"\');\\\" onblur=\\\"return hasInvalidChars(this,\'\"+Remarks_Label+\"\');\\\" value=\'\\\"+orderList[itr].remarks+\\\"\' rows=2>\"+decodeURIComponent(orderList[itr].remarks)+\"</textarea>\"; <!--058037-->\n\t\t\t\t\t//htmlRemarks = \"<textarea onchange=\\\"if(trim(this.value)!=\'\')setFlag(\'\"+row_ind1+\"\');\\\" name=\'remarks\"+ row_ind1 +\"\'  onkeypress=\\\"restrictSpecialChars(event)\\\"   maxlength=150 value=\'\"+orderList[itr].remarks+\"\' rows=2>\"+orderList[itr].remarks+\"</textarea>\";\n\t\t\t\t\t\n\t\t\t\t\tnewCellDesc2.innerHTML = htmlRemarks;\n\t\t\t\t\t\n\t\t\t\t\trow_ind1++;\n\t\t\t\t}\t\n\t\t\t} \n\t}else\n\t{\n\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t}\n\t\n\t//To restrict the control characters to maximum given extent:\n\t  function maxLength(field,maxChars)\n\t { \n\t\t  if(field.value.length >= maxChars) {\n\t\t\t  event.returnValue=false; \n\t\t\t  \n\t\t\t  return false;\n\t\t   }\n\t }  \n\n\t function maxLengthPaste(field,maxChars,rowind)\n\t {\n\t\tif(field.value.length > maxChars) {\n\t\t\tvar str = field.value;\n\t\t\tfield.value = str.substring(0,maxChars);\n\t\t\tsetFlag(rowind);\n\t\t}\n\t }\n\n\t//Function : Create new Cell on the row: \n\tfunction fnInsertCell(newRow)\n\t{\n\t\t\tvar newCellDesc = newRow.insertCell(newRow.cells.length);\n\t\t\t\tnewCellDesc.className = \"lable\";\n\t\t\t\t\n\t\t\t\tnewCellDesc.colSpan = \"1\";\n\t\t\t\tnewCellDesc.align = \"center\";\n\t\t\t\tnewCellDesc.setAttribute(\"border\", \"0px\");\n\t\t\t\tnewCellDesc.style.fontSize =\"10pt\"\n\t\t\t\tnewCellDesc.style.color = \"#4E387E\"\t\t\t\t\n\t\t\t\treturn newCellDesc;\n\t}\n\n\t//var foodDislikeList = new Array();\n\tvar countRowValue = 0;\n\tvar foodDislikeListArr = new Array();\n\tvar itemCodeDel = new Array();\n\t//Getting Food Dislike Items:\n\tasync function getFoodItem(obj1, obj2, rowno)\n\t{\n\t\tvar foodDislikeList = new Array();\n\t\tvar dialogUrl1 = \"../../eDS/jsp/OPFoodDislikes.jsp\";\n\t\tvar nFoodDislikeSrl = \"hdnfoodDislikeItem\" + rowno;\n\t\tvar dialogArguments = document.getElementById(nFoodDislikeSrl).value;\n\t\tvar tmpFoodDislike = document.getElementById(nFoodDislikeSrl).value;\n\t\tvar dialogFeatures = \"dialogHeight:52vh;dialogWidth:50vw;status:no;scroll:no\";\n\t\t\n\t\treturnVal1 = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);\n\t\t\n\t\tif (returnVal1) {\n\t\t\tfoodDislikeList = returnVal1;\n\t\t\tglobalFoodDislike[rowno] = returnVal1;\n\t\t\tvar tbodyObj = document.getElementById(obj2);\n\t\t\tvar selObj = \"<SELECT name=\'fooddislike\' id=\'fooddislike\' size=2>\";\n\t\t\tfor (var i = 0; i < foodDislikeList.length; i++) {\n\t\t\t\tvar arrFoodItem = foodDislikeList[i];\n\t\t\t\tif(arrFoodItem != null && arrFoodItem[2] != \"-1\")\n\t\t\t\t{\n\t\t\t\t\tvar value = arrFoodItem[0];\n\t\t\t\t\tvar desc = arrFoodItem[1];\n\t\t\t\t\tselObj += \"<OPTION value=\'\" + value + \"\'>\" + desc + \"</OPTION>\";\n\t\t\t\t}\n\t\t\t}\t\n\t\t\tselObj += \"</SELECT>\";\n\t\t\ttbodyObj.innerHTML = selObj;\n\t\t\ttbodyObj.value=foodDislikeList; //used as hidden field for taking row values on insertion..\n\t\t\tdocument.getElementById(nFoodDislikeSrl).value = returnVal1;\n\t\t}else\n\t\t{\n\t\t\tdocument.getElementById(nFoodDislikeSrl).value = tmpFoodDislike;\n\t\t}\n\t\tsetFlag(rowno); //Updating the flag which is for notifying that record is updated with fooditem.\n\t}\n\t\n\tvar supplimentArray = new Array();\n\tvar returnVal1 = null;\n\t\n\t//Function : Getting Special Food Items:\n\tasync function getSplFoodItem(iter,obj2)\n\t{\t\n\t\tvar k=0;\n\t\tvar j=0;\n\t\tvar qryEven = \"QRYEVEN\";\n\t\tvar qryOdd = \"QRYODD\";\n\t\tvar nSplFoodSrl = \"hdnsplfoodItem\" + iter;\n\t\t\n\t\t//var encounterId = document.getElementById(\"encounterId\").value;\n\t\t//var patientClass = document.getElementById(\"patientClass\").value;\n\n\t\tvar encounterId  =  \"E1\";\n\t\tvar patientClass =  \"OP\";\n\t\tvar dialogUrl1 = \"../../eDS/jsp/OPSpFoodItems.jsp?encounterId=\"+encounterId+\"&patientClass=\"+patientClass+\"&fecthedMealTypes=\"+OPMealTypes;\n\t\t\n\t\tvar dialogArguments = document.getElementById(nSplFoodSrl).value ;\n\t\t\n\t\tvar tmpSplFoods = document.getElementById(nSplFoodSrl).value;\n\t\tvar dialogFeatures = \"dialogHeight:90vh;dialogWidth:80vw;status:no;scroll:no\";\n\t\treturnVal1 = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);\t\t\n\t\t\n\t\tif (returnVal1) {\n\t\t\n\t\t\tsplfoodList = returnVal1;\n\t\t\tglobalSplFoodList[iter] = returnVal1;\n\t\t\t\n\t\t\tvar tbodyObj = document.getElementById(obj2);\n\t\t\t\n\t\t\tvar selObj = \"<SELECT name=\'splfooditem\' id=\'splfooditem\' size=2>\";\n\t\t\tvar uniqueFoodItem = new Array();\n\t\t\tvar indexUniqueFI = 0;\n\t\t\tfor (var i = 0; i < splfoodList.length; i++) { //Abirami\n\t\t\t\tvar arrFoodItem = splfoodList[i];\n\t\t\t\tif(arrFoodItem[7] != -1)\n\t\t\t\t{\n\t\t\t\t\tvar value = arrFoodItem[0];\n\t\t\t\t\tvar desc = arrFoodItem[3];\n\t\t\t\t\tif(!uniqueFoodItem.contains(value)) //To avoid replication of same food item [with different mealtype] in placeorder screen\n\t\t\t\t\t{\t\n\t\t\t\t\t\tuniqueFoodItem[indexUniqueFI++] = value;\n\t\t\t\t\t\tselObj += \"<OPTION value=\'\" + value + \"\'>\" + desc + \"</OPTION>\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\t\n\t\t\tselObj += \"</SELECT>\";\n\t\t\ttbodyObj.innerHTML = selObj;\n\t\t\tdocument.getElementById(nSplFoodSrl).value = returnVal1;\n\t\t}else if(tmpSplFoods == \"\")\n\t\t{\n\t\t\tvar tbodyObj = document.getElementById(obj2);\n\t\t\tvar selObj = \"<SELECT name=\'splfooditem\' id=\'splfooditem\' size=2>\";\n\t\t\tselObj += \"<OPTION value=\'\'></OPTION>\";\n\t\t\tselObj += \"</SELECT>\";\n\t\t\ttbodyObj.innerHTML = selObj;\n\t\t\tdocument.getElementById(nSplFoodSrl).value = \"\";\n\t\t}else\n\t\t{\n\t\t\tdocument.getElementById(nSplFoodSrl).value = tmpSplFoods;\n\t\t}\n\t\tsetFlag(iter); //Updating the flag which is for notifying that record is updated with fooditem.\n\t}\t\n\t\n\t//Function : Inserting/Updating the Records of Placed Order into the Database:  \n\tfunction apply()\n\t{ \n\t\t//for(var i =0 ; i<gRecordUpdated.length; i++)\n\t\tvar sWarnMsgForMealType = \"\"\n\t\tvar divOPMealOrderList = parent.frames[1].document.getElementById(\"divOPMealOrderList\");\n\t\tfor(var i=0;i<divOPMealOrderList.rows.length; i++) //For each row\n\t\t{ \n\t\t\t\tvar remarks     = trim(parent.frames[1].document.getElementById(\"remarks\"+i).value);\n\t\t\t\tvar prepartoryInstr     = trim(parent.frames[1].document.getElementById(\"prepartoryInstr\"+i).value);//MMOH-CRF-417 \n\t\t\t\tvar foodDislike = globalFoodDislike[i];\n\t\t\t\tvar splFoodItem = globalSplFoodList[i]; \n\t\t\t\tvar sPatId \t\t= parent.frames[1].document.getElementById(\"patId\"+i).value;\n\t\t\t\tvar sPatName \t= parent.frames[1].document.getElementById(\"patName\"+i).value;\n\t\t\t\tvar sApptNo \t= parent.frames[1].document.getElementById(\"apptNo\"+i).value;\n\t\t\t\tvar sEnctId \t= parent.frames[1].document.getElementById(\"enctId\"+i).value;\n\t\t\t\tvar bRowMealTypeChecked = false;\n\t\t\t\tvar valExistsInFD = false;\n\t\t\t\tvar valExistsInSplFood = false;\n\t\t\t\t\n\t\t\t\tfor (var count = 0; count < foodDislike.length; count++) {\n\t\t\t\t\tif(foodDislike[count]!=null && foodDislike[count][2] != null && foodDislike[count][2] != \"-1\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvalExistsInFD = true;\n\t\t\t\t\t}\n\t\t\t\t}\t\n\t\t\t\t\n\t\t\t\tfor (var icount = 0; icount < splFoodItem.length; icount++) {\n\t\t\t\t\tif(splFoodItem[icount]!=null && splFoodItem[icount][7] != null && splFoodItem[icount][7] != \"-1\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvalExistsInSplFood = true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//if( (remarks!=\"\" || foodDislike!=\"\" || splFoodItem !=\"\") ) //if one of these fields are entered\n\t\t\t\tif( (remarks!=\"\" || valExistsInFD == true || valExistsInSplFood == true || prepartoryInstr!=\"\") ) //if one of these fields are entered\n\t\t\t\t{  \n\t\t\t\t\t//417 checking any special character are there in preparatoryInstruction column and remarks column\n\t\t\t\t\tvar sp_flag=hasInvalidChars(parent.frames[1].document.getElementById(\"prepartoryInstr\"+i),PreparatoryInstruction_Label);\n\t\t\t\t\tif(sp_flag==true){\n\t\t\t\t\tsp_flag=hasInvalidChars(parent.frames[1].document.getElementById(\"remarks\"+i),Remarks_Label);\n\t\t\t\t\t\tif(sp_flag==false){\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\tfor (var j=0; j < mealTypeList.length;j++) { // for each mealtype\n\t\t\t\t\t\tvar varMealType = globalMealTypeList[j].mealType+\"\"+i;\n\t\t\t\t\t\tif(parent.frames[1].document.getElementById(varMealType).checked) //if mealtype is checked\n\t\t\t\t\t\t{ \n\t\t\t\t\t\t\tbRowMealTypeChecked = true; \n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\tif(!bRowMealTypeChecked) //if none of the mealtype is checked\n\t\t\t\t\t{ \n\t\t\t\t\t\tif(sWarnMsgForMealType != \"\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tsWarnMsgForMealType += \"\\n\"+ sApptNo +\"\\t\" + sEnctId;\n\t\t\t\t\t\t}else\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t//sWarnMsgForMealType = \"Atleast One MealType Should be selected for the following appointment/visit:\\nAppt No\\tEncounter ID \\n\"+ sApptNo +\"\\t\" + sEnctId;\n\t\t\t\t\t\t\tsWarnMsgForMealType = getMessage(\"DS_SEL_MEALTYPE\",\"DS\") + \"\\n\"+ sApptNo +\"\\t\" + sEnctId;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t}\n\t\n\t\tif(sWarnMsgForMealType!=\"\")\n\t\t{\n\t\t\talert(sWarnMsgForMealType);\n\t\t\treturn;\n\t\t} \n\t\t// CRF- 0684 \n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n \t    if(parent.frames[1].document.querySelectorAll(\"menuType\").value ==  \"\"){\n\t\t\talert(getMessage(\"DS_MENU_TYPE\",\"DS\"));\n\t\t\treturn;\n\t\t}\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t    // CRF- 0684\n\t\tif(gRecordUpdated.length <1)\n\t\t{\n\t\t\t//alert(\'Atleast one Record Should be Updated...\');\n\t\t\talert(getMessage(\"DS_UPD_REC\",\"DS\"));\n\t\t\treturn;\n\t\t}\n\n\t\t//Added Against ML-MMOH-CRF-0825 Starts Here\n\t\tfor (var j=0; j < mealTypeList.length;j++) {\n\t\t\t\tvar Mealtype_Name = mealTypeList[j].shortDesc+\"\"+row_ind1;\n\t\t\t\tvar mealTypeCode = mealTypeList[j].mealType+\"\"+row_ind1;\n\t\t\t\tvar irregular_meal_name=\"\";\n\t\t\t\tvar irregular_meal_code=\"\";\t\t\t\t\n\t\t\t\tvar dateFrom=document.getElementById(\"systemDate\").value;\n\t\t\t\tvar ServingStartTimeOP = mealTypeList[j].ServingStartTimeOP;\n\t\t\t\tvar IrregularStartTimeOP = mealTypeList[j].IrregularStartTimeOP;\n\t\t\t\t\tif (IrregularStartTimeOP == \"undefined\" || IrregularStartTimeOP== null){\n\t\t\t\t\t\tIrregularStartTimeOP = \"\";\n\t\t\t\t\t}\n\t\t\t\tvar IrregularEndTimeOP = mealTypeList[j].IrregularEndTimeOP;\n\t\t\t\t\tif (IrregularEndTimeOP == \"undefined\" || IrregularEndTimeOP== null){\n\t\t\t\t\t\tIrregularEndTimeOP = \"\";\n\t\t\t\t\t}\n\t\t\t\tvar nextServingStartTimeOP = mealTypeList[j].nextServingStartTimeOP;\n\t\t\t\t\tif(IrregularEndTimeOP==\"\"){\n\t\t\t\t\t\tIrregularEndTimeOP = nextServingStartTimeOP;\n\t\t\t\t\t}\n\t\t\t\tvar today = new Date();\n\t\t\t\tvar hour=today.getHours();\n\t\t\t\tif(hour<=9){\n\t\t\t\t\thour=\"0\"+\"\"+hour;\n\t\t\t\t}\n\t\t\t\tvar minute=today.getMinutes();\n\t\t\t\tif(minute<=9){\n\t\t\t\t\tminute=\"0\"+\"\"+minute;\n\t\t\t\t}\n\t\t\t\tvar Sys_time = hour+\":\"+minute;\n\t\t\t\tvar lateIrregularDietOrderOP = document.getElementById(\"LATE_IRREGULAR_DIET_ORD_FOR_OP\").value;\n\t\t\t\n\t\t\tirregular_meal_name=Mealtype_Name.substring(0,Mealtype_Name.length-1);\n\t\t\tirregular_meal_code=mealTypeCode.substring(0,mealTypeCode.length-1);\n\t\t\t\n\t\t\tvar chkvalue = parent.frames[1].document.getElementById(\"mealone\").value;\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\n\t\t\t\t\tif(lateIrregularDietOrderOP == \"Y\" && IrregularStartTimeOP!=\"\" && IrregularEndTimeOP!=\"\" && IrregularStartTimeOP < Sys_time && IrregularEndTimeOP > Sys_time){\n\t\t\t\t\t\tvar msg=getMessage(\"DS_IRREGULAR_DIET_ORDER\",\"DS\");\n\t\t\t\t\t\tmsg=msg.replace(\"#\", dateFrom);\n\t\t\t\t\t\tmsg+=\"\"+irregular_meal_name;\n\t\t\t\t\t\t//Modified Against ML-MMOH-CRF-0825(ICN-68623) Starts Here\n\t\t\t\t\t\tvar str_array = chkvalue.split(\',\');\n\t\t\t\t\t\tfor(var i = 0; i < str_array.length; i++) {\n\t\t\t\t\t\t\tstr_array[i] = str_array[i].replace(/^\\s*/, \"\").replace(/\\s*$/, \"\");\n\t\t\t\t\t\t\tstr_array[i] =  str_array[i].substring(0,str_array[i].length-1);\n\t\t\t\t\t\t\tif(str_array[i] != \"undefined\" && str_array[i] == irregular_meal_code){\n\t\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//Modified Against ML-MMOH-CRF-0825(ICN-68623) Ends Here\n\t\t\t\t\t}\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\tif(lateIrregularDietOrderOP == \"Y\" && IrregularStartTimeOP!=\"\" && IrregularEndTimeOP!=\"\" && IrregularStartTimeOP < Sys_time && IrregularEndTimeOP > Sys_time){\n\t\t\t\t\tvar msg=getMessage(\"DS_IRREGULAR_DIET_ORDER\",\"DS\");\n\t\t\t\t\tmsg=msg.replace(\"#\", dateFrom);\n\t\t\t\t\tmsg+=\"\"+irregular_meal_name;\n\t\t\t\t\tvar str_array = chkvalue.split(\',\');\n\t\t\t\t\tfor(var i = 0; i < str_array.length; i++) {\n\t\t\t\t\t\tstr_array[i] = str_array[i].replace(/^\\s*/, \"\").replace(/\\s*$/, \"\");\n\t\t\t\t\t\tstr_array[i] =  str_array[i].substring(0,str_array[i].length-1);\n\t\t\t\t\t\tif(str_array[i] != \"undefined\" && str_array[i] == irregular_meal_code){\n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\t\tbreak;//Added Against ML-MMOH-CRF-0825(ICN-68623)\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t }\n\t\t//Added Against ML-MMOH-CRF-0825 Ends Here\n\t\t\n\t\tvar jsonObjMealOrders \t= new Object();\t\n\t\t\n\t\tvar jsonArrMealOrders\t= new Array();\n\t\tvar noEntry = true;\n\t\tvar sWarningMsg = \"\";\n\t\tvar tmpjsonApptObj \t\t= new Array();\n\t\tvar tmpjsonEnctObj \t\t= new Array();\n\t\tvar nIndexForAppt = 0;\n\t\tvar nIndexForEnct = 0;\n\t\t//Getting records and sending as JSON object into servlet: \n\t\tfor(var i=0;i<divOPMealOrderList.rows.length; i++)\n\t\t{ \n\t\t\tif(gRecordUpdated.contains(i))\n\t\t\t{ \n\t\t\t\t//Declaration::\t\t\t\n\t\t\t\tvar jsonRowDataObject \t= new Object();\n\t\t\t\tvar jsonMealTypeObj \t= new Array();\n\t\t\t\t\n\t\t\t\tvar sPatId \t\t=\tparent.frames[1].document.getElementById(\"patId\"+i).value;\n\t\t\t\tvar sPatName \t=\tparent.frames[1].document.getElementById(\"patName\"+i).value;\n\t\t\t\tvar sApptNo \t=\tparent.frames[1].document.getElementById(\"apptNo\"+i).value;\n\t\t\t\tvar sEnctId \t=\tparent.frames[1].document.getElementById(\"enctId\"+i).value;\n\t\t\t\t//Getting values::\n\t\t\t\tjsonRowDataObject.patientId   = sPatId;\n\t\t\t\tjsonRowDataObject.patientName = sPatName;\n\n\t\t\t\tjsonRowDataObject.apptDate    = parent.frames[1].document.getElementById(\"apptDate\"+i).value;\n\t\t\t\tjsonRowDataObject.visitDate   = parent.frames[1].document.getElementById(\"visitDate\"+i).value;\n\t\t\t\tjsonRowDataObject.servingDate = parent.frames[1].document.getElementById(\"hdnservingdate\"+i).value;\n\t\t\t\tjsonRowDataObject.apptNo      = sApptNo;\n\t\t\t\tjsonRowDataObject.enctId      = sEnctId;\n\t\t\t\tjsonRowDataObject.dietTypes   = parent.frames[1].document.getElementById(\"dietTypes\"+i).value;\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\tjsonRowDataObject.menuType   = parent.frames[1].document.getElementById(\"menuType\"+i).value;\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47_0 ="\n\t\t\t\t//jsonRowDataObject.remarks     = trim(parent.frames[1].document.getElementById(\"remarks\"+i).value);\n\t\t\t\tjsonRowDataObject.remarks     = encodeURIComponent(trim(parent.frames[1].document.getElementById(\"remarks\"+i).value)); // Lang-support for Remarks\n\t\t\t\tjsonRowDataObject.prepartoryInstr     = encodeURIComponent(trim(parent.frames[1].document.getElementById(\"prepartoryInstr\"+i).value)); // MMOH-CRF-417\n\t\t\t\tjsonRowDataObject.foodDislike = globalFoodDislike[i];\t\n\t\t\t\tjsonRowDataObject.splFoodItem = globalSplFoodList[i];\n\t\t\t\tjsonRowDataObject.modFlag \t= parent.frames[1].document.getElementById(\"modFlag\"+i).value;\n\n\t\t\t\tif(jsonRowDataObject.enctId != \"\")\n\t\t\t\t\ttmpjsonEnctObj[nIndexForEnct++] = jsonRowDataObject.enctId;\n\t\t\t\telse\n\t\t\t\t\ttmpjsonApptObj[nIndexForAppt++] = jsonRowDataObject.apptNo;\n\t\t\t\t\t\n\t\t\t\tif(jsonRowDataObject.modFlag == \'N\' || jsonRowDataObject.modFlag == \'Y\')\n\t\t\t\t{\n\t\t\t\t\tif(sWarningMsg != \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tsWarningMsg += \"\\n\"+sApptNo +\"\\t\" + sEnctId ;\n\t\t\t\t\t}else\n\t\t\t\t\t{\n\t\t\t\t\t\t//sWarningMsg = \"Meal Order has already been placed for the following appointment/visit. Saving the changes will override the previous meal order. Are you sure you wish to continue?\\nAppt No\\tEncounter ID\"\n\t\t\t\t\t\tsWarningMsg = getMessage(\"DS_OVERRIDE_MEALORDER\",\"DS\") + \"\\n\"+ sApptNo +\"\\t\" + sEnctId;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tfor (var j=0; j < mealTypeList.length;j++) {\n\t\t\t\t\tvar varMealType = globalMealTypeList[j].mealType+\"\"+i;\n\t\t\t\t\t\n\t\t\t\t\tif(parent.frames[1].document.getElementById(varMealType).checked)\n\t\t\t\t\t\tjsonMealTypeObj.push(globalMealTypeList[j].mealType);\n\t\t\t\t}\n\t\t\t\tjsonRowDataObject.mealTypes = jsonMealTypeObj;\n\t\t\t\tif( (jsonRowDataObject.mealTypes != \"\" && jsonRowDataObject.modFlag == \"\") || jsonRowDataObject.modFlag != \"\")\n\t\t\t\t\tjsonArrMealOrders.push({rowmealOrder:jsonRowDataObject});\n\t\t\t}\n\t\t}\n\t\tif(sWarningMsg!=\"\")\n\t\t{\n\t\t\tif(!window.confirm(sWarningMsg))\n\t\t\t\treturn false;\n\t\t}\n\t\t//Check if the selected appointments are cancelled:: Start\n\t\tvar tmpjsonDataObject = new Object();\n\n\t\ttmpjsonDataObject.apptObj = tmpjsonApptObj;\n\t\ttmpjsonDataObject.enctObj = tmpjsonEnctObj;\n\n\t\tvar tmpjsonData = JSON.stringify(tmpjsonDataObject);\n\t\tvar arguments=\"jsonData=\"+tmpjsonData+\"&language_Id=en&mode=chkCanceledAppt\";\n\t\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root></root>\";\n\t\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\", \"../../servlet/eDS.PlaceMealOrderOPServlet?\"+arguments,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal = xmlHttp.responseText;\n\t\t\n\t\tvar tmpjsonObjResponse=eval(\'(\' + retVal + \')\');\n\n\t\tvar apptList=new Array();\n\t\tvar enctList=new Array();\n\t\tapptList = tmpjsonObjResponse.apptList;\n\t\tenctList = tmpjsonObjResponse.enctList;\n\t\tvar sWarMsgForInvalidOrder = \"\";\n\t\t\n\t\tif (apptList!= \"undefined\" && apptList != null && apptList.length>0) \n\t\t{ \n\t\t\t//sWarMsgForInvalidOrder = \"Unable to place meal order as the Appointment/Visit details do not match for the following Appointment/Visit: \\nAppt No  Encounter ID\";\n\t\t\tsWarMsgForInvalidOrder = getMessage(\"DS_UNABLE_PLACE_ORDER\",\"DS\");\n\t\t\tfor (var j=0; j < apptList.length;j++) {\n\t\t\t\tsWarMsgForInvalidOrder += \"\\n\" + apptList[j];\n\t\t\t}\t\n\t\t}\n\t\tif (enctList!= \"undefined\" && enctList != null && enctList.length>0) \n\t\t{ \n\t\t\tif(sWarMsgForInvalidOrder == \"\")\n\t\t\t{\n\t\t\t\t//sWarMsgForInvalidOrder = \"Unable to place meal order as the Appointment/Visit details do not match for the following Appointment/Visit: \\nAppt No  Encounter ID\";\n\t\t\t\tsWarMsgForInvalidOrder = getMessage(\"DS_UNABLE_PLACE_ORDER\",\"DS\");\n\t\t\t}\n\t\t\tfor (var j=0; j < enctList.length;j++) {\n\t\t\t\tsWarMsgForInvalidOrder += \"\\n\" + enctList[itr].appt_id + \"\\t\" + enctList[itr].encounter_id;\n\t\t\t}\t\n\t\t}\n\n\t\tif(sWarMsgForInvalidOrder  != \"\")\n\t\t{ \n\t\t\tif(!window.confirm(sWarMsgForInvalidOrder))\n\t\t\t\treturn;\n\t\t}\n\t\n\t\t// Inserting the other selected Encounter/Appoint Meal Order into the Database:\n\t\tjsonObjMealOrders.mealOrders = jsonArrMealOrders;\n\t\t\t\n\t\tvar jsonData = JSON.stringify(jsonObjMealOrders);\n\t\t\n\t\tdocument.getElementById(\"jsonData\").value = jsonData;\n\t\tdocument.getElementById(\"mode\").value = \"insertOPMealOrder\";\n\t\tdocument.getElementById(\"kitchen\").value = document.getElementById(\"hdnkitchen\").value;\n\t\tdocument.forms[0].submit();\n\t\t\n\t}\n\t//Added Against Ml-MMOH-CRF-0674 starts Here\n\tfunction fecthDietType()\n\t{\n\t\n\tvar diettype_auto=document.getElementById(\"diettype_auto\").value;\n\t\n\t//var diettype_auto=parent.frames[1].document.getElementById(\"diettype_auto\").value;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\tvar xmlStr =\"<root></root>\";\n\tvar params = parent.jsonOPObj;\t\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\", \"../../servlet/eDS.PlaceMealOrderOPServlet?\"+params+\"&diettype_auto=\"+diettype_auto,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = xmlHttp.responseText;\t\n\tvar jsonObjResponse=eval(\'(\' + retVal + \')\');\t\t\n\tvar dietList=new Array();\n\tdietList = jsonObjResponse.jsonDietList;\n\t\n\t//Added Starts against ML-MMOH-CRF-0418 \n\tvar dietListlength=0;\n\tif(typeof(dietList)!=\'undefined\')\n\tdietListlength=dietList.length;\n\t//Added Ends against ML-MMOH-CRF-0418\n\tvar selObj = \"<SELECT name=\'dietTypes\' id=\'dietTypes\' onKeyUp=\'diettype_Autocomplete();\' onClick=\'Select()\' onchange=\'fecthDietTypeToMealClass();\'>\";\n\tvar label=getLabel(\"Common.defaultSelect.label\",\"Common\");\n\t//Added against ML-MMOH-CRF-0418 \n\t//if(dietListlength!=1)\n\tselObj += \"<OPTION value=\'\'>\"+label+\"</OPTION>\";\n\tfor (var j=0; j < dietListlength;j++) {//Modified against ML-MMOH-CRF-0418 \n\t\tvar value = (dietList[j].DietCode);\n\t\tvar desc = (dietList[j].DietDesc);\n\t\tselObj += \"<OPTION value=\'\" + value + \"\'>\" + desc + \"</OPTION>\";\n\t}\t\n\tdocument.getElementById(\"tdHdrDietType\").innerHTML = selObj;\n\t\n\tvar str=document.getElementById(\"dietTypes\").value;\n\tvar auto_flag=document.getElementById(\"auto_flag\").value\n\tif(str == \"\" && auto_flag == \"true\")\n\t{\n\t\tvar sel = document.getElementById(\'dietTypes\');\n\t\tvar len = sel.options.length;\n\t\tif(len <= 3)\n\t\t\tsel.setAttribute(\'size\', len);\n\t\telse\n\t\t\tsel.setAttribute(\'size\', 3);\n\t}\n\telse if(str != \"\" && auto_flag == \"false2\")\n\t{\n\t\tvar sel = document.getElementById(\'dietTypes\');\n\t\tvar len = sel.options.length;\n\t\tif(len <= 3)\n\t\t\tsel.setAttribute(\'size\', len);\n\t\telse\n\t\t\tsel.setAttribute(\'size\', 3);\n\t}\t\t\n}\n\t\nfunction diettype_Autocomplete()\n{\n\tdocument.getElementById(\"diettype_auto\").value=\"\"; \n\tvar selText=\"\";\n\tvar theKeyCode = window.event.keyCode;\n\tif(theKeyCode != 37 && theKeyCode != 38 && theKeyCode != 39 && theKeyCode != 40 && theKeyCode != 13 && theKeyCode != 8)\n\t{\n\t\tdocument.getElementById(\"auto_flag\").value=\"true\";\n\t\tselText += String.fromCharCode(theKeyCode);\n\t\tdocument.getElementById(\"diettype_auto\").value=selText;\n\t\tfecthDietType();\t\t\t \n\t}\n}\n\nfunction Select()\n{\n\tvar auto_flag=document.getElementById(\"auto_flag\").value;\n\tvar myDropDown = document.getElementById(\"dietTypes\");\n\tvar str = myDropDown.options[myDropDown.selectedIndex].value;\t   \n\t\tif(auto_flag == \"true\" && str!=\"\")\n\t\t{\tmyDropDown.size = 1;\n\t\t\tdocument.getElementById(\"auto_flag\").value=\"false2\";\n\t\t\tdocument.getElementById(\"diettype_auto\").value=\"\";\n\t\t}\n\t\telse if(auto_flag == \"true\" && str==\"\")\n\t\t{\t\t\t\n\t\t\tmyDropDown.size = 1;  \n\t\t\tdocument.getElementById(\"diettype_auto\").value=\"\";\n\t\t\tdocument.getElementById(\"auto_flag\").value=\"false\";\n\t\t\tfecthDietType();\t\t\t\t\n\t\t}\n\t\telse if(auto_flag == \"false2\" && str==\"\")\n\t\t{\n\t\t\tdocument.getElementById(\"diettype_auto\").value=\"\";\n\t\t\tdocument.getElementById(\"auto_flag\").value=\"false\";\n\t\t\tfecthDietType();\t\t\t \n\t\t}\t\t\n}   \n\nfunction diettype_Autocomplete1(rowcount,sModFlag)\n{\n\tdocument.getElementById(\"diettype_auto1\").value=\"\"; \n\tvar selText=\"\";\n\tvar theKeyCode = window.event.keyCode;\n\tif(theKeyCode != 37 && theKeyCode != 38 && theKeyCode != 39 && theKeyCode != 40 && theKeyCode != 13 && theKeyCode != 8)\n\t{\n\t\tdocument.getElementById(\"auto_flag1\").value=\"true\";\n\t\tselText += String.fromCharCode(theKeyCode);\n\t\tdocument.getElementById(\"diettype_auto1\").value=selText;\n\t\tfecthDietType1(rowcount,sModFlag);\t\t\t \n\t}\n}\n\nfunction fecthDietType1(rowcount,sModFlag)\n\t{\n\tvar diettype_auto=document.getElementById(\"diettype_auto1\").value;\n\tvar objnew;\n\t\tobjnew = document.getElementById(\"dietTypes\"+rowcount);\n\t\twhile(objnew.length > 0){\n\t\t\tobjnew.remove(0);\n\t\t}\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\tvar xmlStr =\"<root></root>\";\n\tvar params = parent.jsonOPObj;\t\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\", \"../../servlet/eDS.PlaceMealOrderOPServlet?\"+params+\"&diettype_auto=\"+diettype_auto,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = xmlHttp.responseText;\t\n\tvar jsonObjResponse=eval(\'(\' + retVal + \')\');\t\t\n\tvar dietList=new Array();\n\tdietList = jsonObjResponse.jsonDietList;\t\t\t\t\n         \t\t//Added Starts against ML-MMOH-CRF-0418 \n\t               var dietListlength=0;\n\t               if(typeof(dietList)!=\'undefined\')\n\t               dietListlength=dietList.length;\n\t               //Added Ends against ML-MMOH-CRF-0418\n\t\n\t\tvar Entry = document.createElement(\"OPTION\");\n\t\tvar msg=getLabel(\"Common.defaultSelect.label\",\"Common\");\t\t\t\t\t \t\t\n\t\tEntry.text = msg;\n\t\tEntry.value= \"\";\n\t\tobjnew.add(Entry);\n\t\tfor (var j=0; j <dietListlength;j++) {\n\t\t\t\tvar Entry = document.createElement(\"option\");\t\t\t\t\n\t\t\t\tEntry.text = msg;\n\t\t\t\tEntry.value= \"\";\n\t\t\t\tvar value = (dietList[j].DietCode);\n\t\t\t\tvar desc = (dietList[j].DietDesc);\t\t\t\t\t\t\n\t\t\t\tEntry.value  =value ;\n\t\t\t\tEntry.text  =desc ;\n\t\t\t\tobjnew.add(Entry);\t\t\t\n\t\t\t}\n\t\t//\tparent.frames[1].document.getElementById(\"modFlag\"+rowcount).value=sModFlag;\n\t\t\t\t//For Extended Dropdown List starts Here\n\t\tvar str = document.getElementById(\'dietTypes\'+rowcount).value;\n\t\tvar auto_flag=document.getElementById(\"auto_flag1\").value;\n\t\tif(str == \"\" && auto_flag == \"true\")\n\t\t\t{\n\t\t\t\tvar sel = document.getElementById(\'dietTypes\'+rowcount);\n\t\t\t\tvar len = sel.options.length;\n\t\t\t\tif(len <= 3)\n\t\t\t\t\tsel.setAttribute(\'size\', len);\n\t\t\t\telse\n\t\t\t\t\tsel.setAttribute(\'size\', 3);\n\t\t\t}\n\t\telse if(str != \"\" && auto_flag == \"false2\")\n\t\t\t{\n\t\t\t\tvar sel = document.getElementById(\'dietTypes\'+rowcount);\n\t\t\t\tvar len = sel.options.length;\n\t\t\t\tif(len <= 3)\n\t\t\t\t\tsel.setAttribute(\'size\', len);\n\t\t\t\telse\n\t\t\t\t\tsel.setAttribute(\'size\', 3);\n\t\t\t}\n\t\t\t//For Extended Dropdown List Ends Here\n\t}\n\nfunction Select1(rowcount,sModFlag)\n{\n\t\tvar auto_flag=document.getElementById(\"auto_flag1\").value;\n\t\tvar myDropDown = document.getElementById(\"dietTypes\"+rowcount);\t\t\n\t\tvar str = myDropDown.options[myDropDown.selectedIndex].value;  \n\t\t\n\t\t\tif(auto_flag == \"true\" && str!=\"\")\n\t\t\t{\tmyDropDown.size = 1;\n\t\t\t\tdocument.getElementById(\"auto_flag1\").value=\"false2\";\n\t\t\t\tdocument.getElementById(\"diettype_auto1\").value=\"\";\t\t\t\t\n\t\t\t}\n\t\t\telse if(auto_flag == \"true\" && str==\"\")\n\t\t\t{\t\t\t\n\t\t\t\tmyDropDown.size = 1;  \n\t\t\t\tdocument.get";
    private final static byte[]  _wl_block47_0Bytes = _getBytes( _wl_block47_0 );

    private final static java.lang.String  _wl_block47_1 ="ElementById(\"diettype_auto1\").value=\"\";\n\t\t\t\tdocument.getElementById(\"auto_flag1\").value=\"false\";\n\t\t\t\tfecthDietType1(rowcount,sModFlag);\t\t \t\t\t\t\n\t\t\t}\n\t\telse if(auto_flag == \"false2\" && str==\"\")\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"diettype_auto1\").value=\"\";\n\t\t\t\tdocument.getElementById(\"auto_flag1\").value=\"false\";\n\t\t\t\tfecthDietType1(rowcount,sModFlag);\t\t\t \n\t\t\t}\t\t\n}\n\n //Added against ML-MMOH-CRF-0674 Ends Here\n</script>\n\t<INPUT type=\"hidden\" name=\"diettype_auto\" id=\"diettype_auto\" id=\"diettype_auto\" value=\"\"><!-- Added against ML-MMOH-CRF-0674-->\n\t<INPUT type=\"hidden\" name=\"auto_flag\" id=\"auto_flag\" id=\"auto_flag\" value=\"false\"><!-- Added against ML-MMOH-CRF-0674-->\n\t<INPUT type=\"hidden\" name=\"diettype_auto1\" id=\"diettype_auto1\" id=\"diettype_auto1\" value=\"\"><!-- Added against ML-MMOH-CRF-0674-->\n\t<INPUT type=\"hidden\" name=\"auto_flag1\" id=\"auto_flag1\" id=\"auto_flag1\" value=\"false\"><!-- Added against ML-MMOH-CRF-0674-->\t\n\t<INPUT type=\"hidden\" name=\"mealone\" id=\"mealone\" id=\"mealone\" value=\"\"><!-- Added against ML-MMOH-CRF-0825-->\t\n </form>\n</body>\n\n";
    private final static byte[]  _wl_block47_1Bytes = _getBytes( _wl_block47_1 );
 
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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
	(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
	String facility_Id	= (String)session.getAttribute("facility_id");
	String language_Id  = (String)session.getAttribute("LOCALE");
 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
             org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            __tag0.setValue(language_Id 
);
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
    	String SystemDate_display = dateFormat.format(date);
	SystemDate_display = com.ehis.util.DateUtils.convertDate(SystemDate_display,"DMY","en",language_Id);

            _bw.write(_wl_block10Bytes, _wl_block10);

	String params = request.getQueryString() ; 
	String splility=request.getParameter("splility");
	//out.println("splility=>"+splility);
	//Added Against ML-MMOH-CRF-0825 Starts Here
	PreparedStatement pstmt = null;
	ResultSet rs=null;	
	String LATE_IRREGULAR_DIET_ORD_FOR_OP = "";
	//Added Against ML-MMOH-CRF-0825 Ends Here
	Connection conn = null;

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(splility));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(SystemDate_display));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facility_Id));
            _bw.write(_wl_block18Bytes, _wl_block18);

    	//ML-MMOH-CRF-0596
		boolean isMealType = false;
	    boolean isMenuType =false;
			try{ //Common-ICN-0071
	conn = ConnectionManager.getConnection(request);	
	isMealType = CommonBean.isSiteSpecific(conn,"DS","PLACE_ORDER_FOR_ATTENDANT");//Using same function for Selayang
	//ML-MMOH-CRF-0596
	
	 //Added Against ML-MMOH-CRF-0825 Starts Here
	String Late_Irr_OP_Query = "select LATE_IRREGULAR_DIET_ORD_FOR_OP from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = ? "; 
	pstmt = conn.prepareStatement(Late_Irr_OP_Query);	
	pstmt.setString(1,facility_Id);	
	rs	= pstmt.executeQuery();
	if(rs != null && rs.next()){
			LATE_IRREGULAR_DIET_ORD_FOR_OP=rs.getString("LATE_IRREGULAR_DIET_ORD_FOR_OP");
		}
	  //Added Against ML-MMOH-CRF-0825 Ends Here	    

            _bw.write(_wl_block2Bytes, _wl_block2);

     //ML-MMOH-CRF-0684

     isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
	  }
		catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
		} //Common-ICN-0071

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(LATE_IRREGULAR_DIET_ORD_FOR_OP));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
if(isMenuType)
	    {
	  
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

				if(isMenuType){
	                  
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);

						if(!isMealType){
					     
            _bw.write(_wl_block34Bytes, _wl_block34);
 } 
            _bw.write(_wl_block35Bytes, _wl_block35);

					     //ML-MMOH-CRF-0596
					     if(isMealType){
					 
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
if(isMenuType){
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);

				if(isMealType){
			
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);

			if(!isMealType){
			
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
if(isMenuType){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47_0Bytes, _wl_block47_0);
            _bw.write(_wl_block47_1Bytes, _wl_block47_1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setBasename(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.resources.Labels", java.lang.String .class,"basename"));
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ds_labels", java.lang.String .class,"var"));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Kitchen.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DietType.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.SelectedPatients.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ApptDate/Time.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.VisitDateTime.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuType.Label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.DietType.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.FoodDislike.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.SpecialFoodItem.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.preparatoryInstruction.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.Remarks.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
