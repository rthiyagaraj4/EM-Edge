package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __modifymealplanitem extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/ModifyMealPlanItem.jsp", 1743595344175L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\'javascript\' src=\'../../eDS/js/ModifyMealPlan.js\'></script>\n<script language=\'javascript\' src=\'../../eDS/js/PlaceDietOrderPHIS.js\'></script>\n\n\n</head>\n<body onLoad=\"\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\n\n<script type=\"text/javascript\">\nfunction callMouseOver(obj){\n\t\t\tcurrClass = obj.className ;\n\t\t\tobj.className = \'OTMENU\';\n\t\t}\n\n\t\tfunction callOnMouseOut(obj){\n\t\t\tobj.className = currClass;\n\t\t}\n// Added for INC 41451\nfunction itemSelect(){\n   var flag =checkNull();\n   if(flag==true){\n\t\tvar class_val =\"\";\n\t\tvar required_Duplicate_Check = 0;\n\t\tvar totalRows = parent.frames[2].document.getElementById(\"listContentTable\").rows.length;\n\t\tvar formObj = parent.frames[2];\n\t\tvar rowCount = document.forms[0].rowCount.value;\n\t\tvar item_slr = document.forms[0].srlNo.value;\n\t\tvar item_Desc = document.getElementById(\"itemType\").options[document.getElementById(\'itemType\').selectedIndex].text;\n\t\tvar item_Type = document.forms[0].itemType.value;\n\t\tvar item_desc = document.forms[0].itemDesc.value;\n\t\tvar item_Code = document.forms[0].itemCode.value;\n\t\tvar short_Desc = document.forms[0].short_Desc.value;//MMS-KH-CRF-029.1\n\t\tvar item_Qty = document.forms[0].itemQty.value;\n\t\tvar spl_Food_Item_Yn = \"N\";\n\t\tvar freq_Yn = \"N\";\n\t\tif(document.forms[0].splFoodItem.checked) {spl_Food_Item_Yn = \"Y\";}\n\t\tif(document.forms[0].freq.checked) {freq_Yn = \"Y\";}\n\n\t\tif(document.forms[0].srlNo.disabled != true){\n\t\tif(required_Duplicate_Check != 1){\n\t\t\t\tvar f1=srlNoDuplicateCheck(item_slr);\n\t\t\t\t\tif(f1 == false)\n\t\t\t\t\treturn\n\t\t\t\tvar f2=foodItemDuplicateCheck(item_Code);\n\t\t\t\t\tif(f2 == false)\n\t\t\t\t\treturn\n\t\t\t}\n\t\t}\n\t\t//MMS-KH-CRF-0029.1-US009 Start\n\t\tvar drugCode=\"\";\n\t\tvar enabledrugfoodYN = document.getElementById(\"enableDrugYN\").value;\t\n\t\tif(enabledrugfoodYN==\"Y\"){\n\t\t\tvar v_intr_flag = modifyMeal();\n\t\t\tdrugCode = document.forms[0].drugCode.value;\n\t\t\tif (v_intr_flag == \'N\')\n\t\t\t\treturn;\n\t\t}\n\t\t//MMS-KH-CRF-0029.1-US009 End\n\t\tif(document.forms[0].srlNo.disabled == true){\n\t\t\tformObj.document.getElementById(\"item_Qty\"+rowCount).innerText = item_Qty;\n\t\t\tformObj.document.getElementById(\"hid_item_Qty\"+rowCount).value = item_Qty;\n\t\t}\n\t\telse{\n\t\t\t\tvar newRow = parent.frames[2].document.all(\"listContentTable\").insertRow();\n\t\t\t\tvar cell1=newRow.insertCell(0);\n\t\t\t\tvar cell2=newRow.insertCell(1);\n\t\t\t\tvar cell3=newRow.insertCell(2);\n\t\t\t\tvar cell4=newRow.insertCell(3);\n\t\t\t\tcell4.setAttribute(\'id\',\'item_Qty\'+totalRows);\n\t\t\t\tvar cell5=newRow.insertCell(4);\n\t\t\t\tvar cell6=newRow.insertCell(5);\n\n\t\t\t\tcell1.innerHTML=\"<td id=\'\"+\"item_slr\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+\"<a href=\\\"javascript:getItemDetails(\'\"+item_slr+\"\',\'\"+item_Type+\"\',\'\"+item_Code+\"\',\'\"+short_Desc+\"\',\'\"+spl_Food_Item_Yn+\"\',\'\"+freq_Yn+\"\',\'\"+totalRows+\"\');\\\">\"+item_slr+\"</a><input type=\'hidden\' name=\'\"+\"hid_item_slr\"+totalRows+\"\' id=\'\"+\"hid_item_slr\"+totalRows+\"\' value=\'\"+item_slr+\"\' /></td>\";\n\n\t\t\t\tcell2.innerHTML=\"<td id=\'\"+\"item_Type\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+item_Desc+\"<input type=\'hidden\' name=\'\"+\"hid_item_Type\"+totalRows+\"\' id=\'\"+\"hid_item_Type\"+totalRows+\"\' value=\'\"+item_Type+\"\' /></td>\";\n\n\t\t\t\tcell3.innerHTML=\"<td id=\'\"+\"item_Code\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+item_desc+\"<input type=\'hidden\' name=\'\"+\"hid_item_Code\"+totalRows+\"\' id=\'\"+\"hid_item_Code\"+totalRows+\"\' value=\'\"+item_Code+\"\' /><input type=\'hidden\' name=\'\"+\"hid_drug_Code\"+totalRows+\"\' id=\'\"+\"hid_drug_Code\"+totalRows+\"\' value=\'\"+drugCode+\"\'/></td>\"; // Modified for MMS-KH-CRF-0029.1-US009\n\n                cell4.innerHTML=\"<td id=\'\"+\"item_Qty\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+item_Qty+\"<input type=\'hidden\' name=\'\"+\"hid_item_Qty\"+totalRows+\"\' id=\'\"+\"hid_item_Qty\"+totalRows+\"\' value=\'\"+item_Qty+\"\' /></td>\";\n\n\t\t\t\tcell5.innerHTML=\"<td id=\'\"+\"spl_Food_Item_Yn\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+spl_Food_Item_Yn+\"<input type=\'hidden\' name=\'\"+\"hid_spl_Food_Item_Yn\"+totalRows+\"\' id=\'\"+\"hid_spl_Food_Item_Yn\"+totalRows+\"\' value=\'\"+spl_Food_Item_Yn+\"\' /></td>\";\n\n\t\t\t\tcell6.innerHTML=\"<td id=\'\"+\"freq_Yn\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+freq_Yn+\"<input type=\'hidden\' name=\'\"+\"mode\"+totalRows+\"\' id=\'\"+\"mode\"+totalRows+\"\' value=\'insert\'/><input type=\'hidden\' name=\'\"+\"hid_freq_Yn\"+totalRows+\"\' id=\'\"+\"hid_freq_Yn\"+totalRows+\"\' value=\'\"+freq_Yn+\"\' /></td>\";\n\t\t}\n\t\tresetFields();\n\t\t}\n}\n\n\n//Added for MMS-KH-CRF-0029.1 - US009 Start\nasync function modifyMeal()\n{\n\tvar language_Id =document.getElementById(\"locale\").value;\n\tvar facility=document.getElementById(\"facility_id\").value;\n\tvar encounter = parent.frames[0].document.forms[0].encounter_id.value;\t\n\tvar fromDate=parent.frames[0].document.forms[0].service_date.value;\n\tvar dateTo = parent.frames[0].document.forms[0].service_date.value;\n\tvar item_Code = document.forms[0].itemCode.value;\n\tvar mode = \"modify_Meal\";\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root></root>\";\n\tvar param=\"locale=\"+language_Id+\"&facility=\"+facility+\"&encounter=\"+encounter+\"&fromDate=\"+fromDate+\"&dateTo=\"+dateTo+\"&item_Code=\"+item_Code+\"&mode_diet=\"+mode; \n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\", \"../../servlet/eDS.ModifyMealPlanServlet?\"+param,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = localTrimString(xmlHttp.responseText);\n\tvar restrict = retVal.split(\",\");\n\tvar param1=\"func_mode=getretVal&ret_val=\"+retVal+\"&fromDate=\"+fromDate+\"&dateTo=\"+dateTo;\n\tif(retVal!=\"\" && restrict[8] ==\" E\")\t\n\t{ \n \t\tvar retVal2;\n\t\tvar dialogUrl1 = \"../../eDS/jsp/AlertValidation.jsp?\"+param1;\n\t\tvar dialogArguments = \"\";\n\t\tvar dialogFeatures = \"dialogHeight:13;dialogWidth:28;status:no;scroll:yes\";\t\t\t\n\t\tretVal2 = await window.showModalDialog(dialogUrl1, dialogArguments ,dialogFeatures);\n\t\tif(restrict[7]==\" N\")\t\t\n\t\t{\n\t\t\tdocument.getElementById(\"remarksImg\").style.visibility = \'visible\';\n\t\t\tdocument.getElementById(\"remarksAlert\").value = \'Y\';\n\t\t\tvar tempVar = localTrimString(restrict[9]);\n\t\t\ttempVar = tempVar.substr(0, tempVar.length - 1);\n\t\t\tdocument.getElementById(\"drugCode\").value = tempVar;\n\t\t\treturn \"Y\";\n\t\t}\n\t\telse if(restrict[7]==\" Y\")\n\t\t\treturn \"N\";\n\t}\n\telse{\n\t\tdocument.getElementById(\"drugCode\").value = \"\";\n\t\treturn \"Y\";\n\t}\n}\n\nvar remarks = \"\";\nasync function Remarks(){\t\n\tvar remarkHdr = \"\";\n\tvar formObj = parent.frames[2].document.forms[0];\n\tif(document.getElementById(\"remarks\").value != \"null\" &&  document.getElementById(\"remarks\").value != \"\" && remarks == \"\"){\n\t\tremarkHdr = document.getElementById(\"remarks\").value;\n\t}\n\t//Added for MMS-KH-CRF-0029.1 - US009 Start\n\tif(parent.ModifyMealPlanSearch.document.forms[0].onLoadRem.value != null &&  formObj.document.getElementById(\"onLoadRem\").value != \"\" && \t\t\t\tparent.ModifyMealPlanSearch.document.forms[0].onLoadRem.value != undefined && parent.ModifyMealPlanSearch.document.forms[0].onLoadRem.value != \"undefined\"){\n\t\tremarkHdr = formObj.document.getElementById(\"onLoadRem\").value;\n\t}\n\t//Added for MMS-KH-CRF-0029.1 - US009 End\n\tif(remarks != null || remarks == undefined){\n\tif(remarkHdr != \"\"){\n\t\tremarks = remarkHdr;\n\t}\n\telse{\n\t\tremarkHdr = remarks;\n\t}\n\t}\n\telse{\n\t\tremarkHdr = \"\";\n\t}\n\tvar dialogUrl1 = \"../../eDS/jsp/Remarks.jsp?&remarkHdr=\"+encodeURIComponent(remarkHdr);\n\tvar dialogArguments = remarks;\n\tvar dialogFeatures = \"dialogHeight:13;dialogWidth:28;status:no;scroll:yes\";\n\treturnRemarks = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);\n\tif(returnRemarks != null){\n\t\tremarks = returnRemarks;\n\t\tdocument.getElementById(\"remarksVal\").value = returnRemarks;\n\t}\n\n\tif(returnRemarks == undefined){\n\t\treturnRemarks = dialogArguments;\t\t\n\t}\n}\n//Added for MMS-KH-CRF-0029.1 - US009 End\n\n// modified by N Munisekhar on 12-June-2013 against [IN40763]\nfunction checkNull(){\n\tvar flag;\n \tvar error=\"\";\n \tvar srlNo=document.forms[0].srlNo.value;\n \tvar srlNo_label=getLabel(\"Common.SrlNo.label\",\"Common\");\n \tvar itemType=document.forms[0].itemType.value;\n \tvar itemType_label=getLabel(\"Common.Itemtype.label\",\"Common\");\n\tvar itemDesc=document.forms[0].itemDesc.value;\n \tvar itemDesc_label=getLabel(\"Common.item.label\",\"Common\");\n\tvar itemQty=document.forms[0].itemQty.value;;\n \tvar itemQty_label=getLabel(\"eOT.ServingQty.Label\",\"OT\");\n\n\n \tif(srlNo==\"\") {\n \t\tflag=false;\n \t\terror+= getMessage(\"CAN_NOT_BE_BLANK\",\"Common\").replace(\"$\",srlNo_label)+\"<br>\";\n \t}\n \tif(itemType==\"\") {\n \t\tflag=false;\n \t\terror+= getMessage(\"CAN_NOT_BE_BLANK\",\"Common\").replace(\"$\",itemType_label)+\"<br>\";\n \t}\n\n\tif(itemDesc==\"\") {\n \t\tflag=false;\n \t\terror+= getMessage(\"CAN_NOT_BE_BLANK\",\"Common\").replace(\"$\",itemDesc_label)+\"<br>\";\n \t}\n \tif(itemQty==\"\") {\n \t\tflag=false;\n \t\terror+= getMessage(\"CAN_NOT_BE_BLANK\",\"Common\").replace(\"$\",itemQty_label)+\"<br>\";\n \t}\n\tparent.parent.messageFrame.location.href =\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+error;\n\tif(flag==false) return false; else return true;\n }\nfunction resetFields(){\n\t\tdocument.forms[0].srlNo.value = \"\";\n\t\tdocument.forms[0].itemType.value = \"\";\n\t\tdocument.forms[0].itemDesc.value = \"\";\n\t\tdocument.forms[0].itemCode.value = \"\";\n\t\tdocument.forms[0].itemQty.value = \"\";\n\t\t// modified by N Munisekhar on 23-May-2013 against [IN39955]\n\t\t//document.forms[0].splFoodItem.value = \"\";\n\t\tdocument.getElementById(\"splFoodItem\").checked = false;\n\t\tdocument.getElementById(\"freq\").checked = false;\n\t\t//document.forms[0].frequency.value =\"\";\n\n\t\tparent.ModifyMealPlanItem.document.forms[0].srlNo.disabled = false;\n\t\tparent.ModifyMealPlanItem.document.forms[0].itemType.disabled = false;\n\t\tparent.ModifyMealPlanItem.document.forms[0].itemDesc.disabled = false;\n\t\t\n\t\t// modified by Subhani on 08-07-2013 against [INC 41244]\n\t\tparent.ModifyMealPlanItem.document.forms[0].splFoodItem.disabled = false;\n\t\tparent.ModifyMealPlanItem.document.forms[0].freq.disabled = false;\n}\n\nfunction srlNoDuplicateCheck(item_slr){\n\tvar formObj = parent.frames[2];\n    var totRows= parent.frames[2].document.getElementById(\"listContentTable\").rows.length;\n\t\tvar f1;\n\t\tvar error=\"\";\n\t\n\t\tfor(var i=1;i<totRows;i++)\n\t\t{\n\t\t\t\tvar srlNo = formObj.document.getElementById(\"hid_item_slr\"+i).value;\n\t\t\t\tif(item_slr == srlNo){\n\t\t\t\t\talert(getMessage(\"DS_DUP_SRLNUM\",\"DS\")); //\"DUPILICATE SERIAL NUMBER\");\n\t\t\t\t\tf1 = false;\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t}\n\t\tif(f1==false)\n\t\t\treturn false;\n\t\telse\n\t\t\treturn true;\n\t}\n\nfunction foodItemDuplicateCheck(item_Code){\n\t\tvar formObj = parent.frames[2];\n\t\tvar totRows= parent.frames[2].document.getElementById(\"listContentTable\").rows.length;\n\t\tvar f1;\n\t\tvar error=\"\";\n\t\tfor(var i =1;i<totRows;i++)\n\t\t{\n\t\t\t\tvar itemCode = formObj.document.getElementById(\"hid_item_Code\"+i).value;\n\t\t\t\tif(item_Code == itemCode){\n\t\t\t\t\talert(getMessage(\"DS_DUP_ITMCODE\",\"DS\")); //\"DUPILICATE ITEM CODE\");\n\t\t\t\t\tf1 = false;\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t}\n\t\tif(f1==false)\n\t\t\treturn false;\n\t\telse\n\t\t\treturn true;\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<form name=\"ModifyMealPlan_Item\" id=\"ModifyMealPlan_Item\"  onload=\'FocusFirstElement()\'  action=\"../../servlet/eDL.ModifyMealPlanServlet\" method=\"post\" target=\"messageFrame\">\n\t\t\t<table width=\"100%\" border=\"0\" cellpaddin";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="g=\"\" cellspacing=\"0\">\n\t\t\t\t\t\t<tr><td>\n\t\t\t\t\t\t<table border=\"0 \" cellpadding=\"\" cellspacing=\"0\" >\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td align=\"right\" class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input type=text name=\"srlNo\" id=\"srlNo\" onkeypress=\"CheckNumber()\" size=\"2\" maxlength=\"2\" value =\"\"/>\n\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td align=\"right\" class=\"label\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t<select name=\"itemType\" id=\"itemType\" onchange=\"\" >\n\t\t\t\t\t\t<option value=\"\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t</option>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t</option>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t</select>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</td>\n\t\t\t<td>\n          <!--modified by N Munisekhar on 23-May-2013 against [IN39955]-->\n\t\t\t\t<input type=\"hidden\" name=\"itemCode\" id=\"itemCode\" value=\"\">\n\t\t\t\t<input type=\"text\" name=\"itemDesc\" id=\"itemDesc\" size=\"10\" onkeypress=\"return CheckForSpecChars(event)\" onblur=\"if(this.value!=\'\')showLookup(itemCode,itemDesc); else itemCode.value=\'\'\" value=\"\" />\n\t\t\t\t<input type=\"button\" class=\"button\" name=\"lookUp\" id=\"lookUp\" value=\"?\"  onclick=\'showLookup(itemCode,itemDesc);\' >\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\"right\" class=\"label\">\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td>\n\t\t\t\t<input type=text name=\"itemQty\" id=\"itemQty\" onkeypress=\"CheckNumber()\" size=\"6\" value =\"\" maxlength=\"6\"/>\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t</tr>\n\t<tr>\n\t\t<td align=\"right\" class=\"label\">\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t</td>\n\t\t<td>\n\t\t\t<input type=text name=\"sheduleTime\" id=\"sheduleTime\" onkeypress=\"vaidateFromTime()\" size=\"5\" maxlength=\"5\" disabled/>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td align=\"right\" class=\"label\">\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</td>\n\t\t<td><!--modified by N Munisekhar on 23-May-2013 against [IN39955]-->\n\t\t\t<input type=\"checkbox\" id=\'splFoodItem\' name=\"splFoodItem\" id=\"splFoodItem\" value=\"\"/>\n\t\t</td>\n\n\t\t<td align=\"right\" class=\"label\">\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</td>\n\t\t<td><!--modified by N Munisekhar on 23-May-2013 against [IN39955]-->\n\t\t\t<input type=\"checkbox\" id=\'freq\' name=\"freq\" id=\"freq\"  onclick=\"EnabledScheduleTime()\" value=\"\"/>\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td colspan=\'2\' align=\'right\'>\n\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' onClick=\"itemSelect()\" >\n\t\t</td>\n\t\t<td align=\'right\'>\n\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onClick=\"cancelRecord()\" >\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<td align=\'right\'>\n\t\t\t<div id=\"remarks\" style=\'visibility:visible\'>&nbsp;\n\t\t\t\t<a href=\"#\" onclick=\"return Remarks();\"> ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a>\n\t\t\t\t<img id=\"remarksImg\" src=\'../../eCommon/images/mandatory.gif\' style=\'visibility:hidden\'></img>\t<!--Added Against ICN-72015-->\n\t\t\t</div>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</tr>\n\n</table>\n\t</td>\n</table>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\t\t<input type=hidden name=\"rowCount\" id=\"rowCount\" value=\"\" />\n\t\t\t<input type=hidden name=\"item_slr\" id=\"item_slr\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" />\n\t\t\t<input type=hidden name=\"encounter_id\" id=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" />\n\t\t\t<input type=hidden name=\"service_date\" id=\"service_date\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" />\n\t\t\t<input type=hidden name=\"kitchenCode\" id=\"kitchenCode\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" />\n\t\t\t<input type=hidden name=\"mealType\" id=\"mealType\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" />\n\t\t\t<input type=hidden name=\"dietType\" id=\"dietType\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" />\n\t\t\t<input type=hidden name=\"frequency\" id=\"frequency\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" />\n\t\t\t<input type=hidden name=\"item_Type\" id=\"item_Type\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" />\n\t\t\t<input type=hidden name=\"item_Code\" id=\"item_Code\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" />\n\t\t\t<input type=hidden name=\"short_Desc\" id=\"short_Desc\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" />\n\t\t\t<input type=hidden name=\"item_Qty\" id=\"item_Qty\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" />\n\t\t\t<input type=hidden name=\"meal_Category\" id=\"meal_Category\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" />\n\t\t\t<input type=hidden name=\"patient_Class\" id=\"patient_Class\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" />\n\t\t\t<input type=hidden name=\"status\" id=\"status\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" />\n\t\t\t<!--<input type=hidden name=\"spl_Food_Item_Yn\" id=\"spl_Food_Item_Yn\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" />\n\t\t\t<input type=hidden name=\"freq_Yn\" id=\"freq_Yn\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" />-->\n\t\t\t<input type=hidden name=\"serving_Uom_Code\" id=\"serving_Uom_Code\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" />\n\t\t\t<input type=hidden name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" />\n\n\t\t\t<input type=hidden name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" />\n\t\t\t<input type=hidden name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" />\n\t\t\t<!-- MMS-KH-CRF-0029.1-US009 Start-->\n\t\t\t<input type=\"hidden\" name=\"enableDrugYN\" id=\"enableDrugYN\" id=\"enableDrugYN\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"remarksAlert\" id=\"remarksAlert\" id=\"remarksAlert\" value=\"\"/>\n\t\t\t<input type=\"hidden\" name=\"remarksVal\" id=\"remarksVal\" id=\"remarksVal\" value=\"\"/>\n\t\t\t<input type=\"hidden\" name=\"drugCode\" id=\"drugCode\" id=\"drugCode\" value=\"\"/>\n\t\t\t<!-- MMS-KH-CRF-0029.1-US009 End-->\n\t\t</form>\n</html>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 

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
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String facility_id	= (String) session.getValue("facility_id");
		//Checkstyle Violation commented by Munisekhar
		//String func_mode = request.getParameter("func_mode") ;
		//String patient_id	= "";

		String encounter_id = request.getParameter("encounterId");
		if(encounter_id==null) encounter_id="";

		String service_date = request.getParameter("servingDate");
		if(service_date==null) service_date="";

		String kitchenCode = request.getParameter("kitchenCode");
		if(kitchenCode==null) kitchenCode="";

		String mealType = request.getParameter("mealType");
		if(mealType==null) mealType="";
		String dietType = request.getParameter("dietType");
		if(dietType==null) dietType="";
		//String frequency = request.getParameter("frequency");
		  String frequency = "N";
		//if(frequency==null) frequency="";
        //Checkstyle Violation commented by Munisekhar
		//String strSysDate="";
		//String table_name ="";
        //String class_val = "";

		//String frequency = request.getParameter("frequency");
		//if(frequency==null) frequency="";

		String item_sl= "";
		 item_sl= (String) request.getParameter("item_slr");
        // if (null == item_sl) item_slr = (String) request.getAttribute("item_slr");
        //if (null == item_sl) item_sl= "";


       // item_sl = request.getParameter("item_slr");
		String item_Type   =request.getParameter("item_Type");
		if(item_Type==null) item_Type="";
		String item_Code   = "";
		String short_Desc   = request.getParameter("short_Desc");
		if(short_Desc==null) short_Desc="";
		String item_Qty   = request.getParameter("item_Qty");
		if(item_Qty==null) item_Qty="";
		String meal_Category   = "";
		String patient_Class = "";
		String serving_Uom_Code = "";
		String spl_Food_Item_Yn = request.getParameter("spl_Food_Item_Yn");
		if(spl_Food_Item_Yn==null) spl_Food_Item_Yn="";
		String freq_Yn = request.getParameter("freq_Yn");
		if(freq_Yn==null) freq_Yn="";
		String status = request.getParameter("status");
		String mode="";
		//Checkstyle Violation commented by Munisekhar
		//String serving_Date = request.getParameter("servingDate");
		//String PatIDLen ="";
        // String item_type_disable ="";
		//String item_select = "";
		//String classValue= "";
		//String rowNum = "";
		//Statement stmt	= null;
		//PreparedStatement pstmt1=null;
		//ResultSet rs1=null;
		//int rowCount = 0;
		String item_desc = "";
		String item_slr   = "";
		Connection conn=null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt3=null;	//MMS-KH-CRF-0029.1-US009
		ResultSet rs=null;
		ResultSet rs3=null;
		String enableDrugYN="";//MMS-KH-CRF-0029.1-US009		
		conn = ConnectionManager.getConnection(request);
		
		try	{

            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

				try{
						String sql_meal ="SELECT DS_GET_DESC.DS_ITEM_TYPE(ITEM_TYPE,'"+locale+"','2'),ITEM_TYPE FROM DS_item_type WHERE NVL (EFF_STATUS, 'E') = 'E'";
						pstmt			= conn.prepareStatement(sql_meal) ;
						rs				= pstmt.executeQuery();
						while(rs!=null && rs.next()){
						item_Code=rs.getString(2);
						item_desc=rs.getString(1);
						if(item_desc != null && !item_desc.equals("")){
						
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

						}
						}
						}catch(Exception e){
						e.printStackTrace();
					   }finally{
				try{
						if(rs!=null)rs.close();
						if(cstmt!=null)cstmt.close();
						//if(conn!=null) ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
				}
			
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

			//MMS-KH-CRF-0029.1 - US009 Start
			String enableDrugFood="select ENABLE_DRUG_FOOD_YN from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";
			pstmt3=conn.prepareStatement(enableDrugFood);						
			rs3=pstmt3.executeQuery();
			while(rs3 != null && rs3.next()){
				enableDrugYN=checkForNull(rs3.getString("ENABLE_DRUG_FOOD_YN"));
			}
			if(rs3!=null) rs3.close();
			if(pstmt3!=null) pstmt3.close();
			//MMS-KH-CRF-0029.1 - US009 Ends
			if(enableDrugYN.equals("Y")){
		
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

	
	}catch(Exception e)
	{
	e.printStackTrace();
	}finally
		{
			try{
				if(rs!=null) rs.close();
				pstmt.close();
				ConnectionManager.returnConnection(conn, request);
				}catch(Exception ee){
					ee.printStackTrace();
					System.err.println("Exception in modify123==>"+ee);
				}
			}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(item_slr));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(service_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(mealType));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dietType));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(frequency));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(item_Type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(short_Desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(item_Qty));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(meal_Category));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_Class));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(status));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(spl_Food_Item_Yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(freq_Yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(serving_Uom_Code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(enableDrugYN));
            _bw.write(_wl_block47Bytes, _wl_block47);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SrlNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Itemtype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ServingQty.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ScheduleTime.Label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SpclFoodItems.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Freq.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Remarks.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
