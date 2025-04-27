package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.util.*;
import java.sql.*;
import eXH.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispitemsformachinecodestab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DispItemsForMachineCodesTab.jsp", 1743586671182L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n    <script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n\t<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script language=\"javascript\" src=\"../../eXH/js/DispenseItemMachineCodes.js\"></script>\n</head>\n<body onSelect=\"codeArrestThruSelect();\">\t \n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script type=\"text/javascript\">\n//*************************************************\n// function\taddForm\n//*************************************************\nfunction addSelect() {\n\t//alert(\"add button\");\n\tvar flag = checkNull();\n\tif(flag==true){\n\t\tvar class_val =\"\";\n\t\tvar required_Duplicate_Check = 0;\n\t\tvar totalRows = parent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").rows.length;\n\t\t//alert(\"totalRows..\"+totalRows);\n\t\tvar formObj = parent.frames[0];\t\t\n\t\tvar rowCount = document.forms[0].rowCount.value;\n\t\tvar dispList_facility = document.forms[0].facility_id.value;\n\t\t//alert(dispList_facility);\n\t\tvar dispList_dispLocn = document.forms[0].disp_locn.value;\n\t\tvar dispList_machine = document.forms[0].machine_code.value;\n\t\tvar dispList_item = document.forms[0].item_desc.value;\n\n\t\tvar hid_facility = document.forms[0].facility.value;\n\t\tvar hid_disp_locn = document.forms[0].disp_location.value;\n\t\tvar hid_machinde = document.forms[0].machine.value;\n\t\tvar hid_item = document.forms[0].item.value;\n\t\t\n\n\t\tvar high_alert_drug = \"N\";\n\t\tvar pack_only = \"N\";\n\t\tvar select = \"\";\n\t\tif(document.forms[0].high_alert_yn.checked) {high_alert_drug = \"Y\";}\n\t\tif(document.forms[0].pack_only_yn.checked) {pack_only = \"Y\";}\n\n\t\t//var newRow = parent.frames[0].document.all(\"dispItemsMachineCodesListTable\").insertRow();\n\t\tvar newRow = parent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").insertRow();\n\t\tvar cell1=newRow.insertCell(0);\n\t\tvar cell2=newRow.insertCell(1);\n\t\tvar cell3=newRow.insertCell(2);\n\t\tvar cell4=newRow.insertCell(3);\n\t\t\n\t\tvar cell5=newRow.insertCell(4);\n\t\tvar cell6=newRow.insertCell(5);\n\t\tvar cell7=newRow.insertCell(6);\n\n\t\t\n\n\t\tcell1.innerHTML=\"<td id=\'\"+\"dispList_facility\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+\"<a href=\\\"javascript:getItemDetails(\'\"+dispList_facility+\"\',\'\"+dispList_dispLocn+\"\',\'\"+dispList_machine+\"\',\'\"+dispList_item+\"\',\'\"+high_alert_drug+\"\',\'\"+pack_only+\"\',\'\"+select+\"\',\'\"+totalRows+\"\');\\\">\"+dispList_facility+\"</a><input type=\'hidden\' name=\'\"+\"hid_facility_id\"+totalRows+\"\' id=\'\"+\"hid_facility_id\"+totalRows+\"\' value=\'\"+hid_facility+\"\' /></td>\";\n\n\t\tcell2.innerHTML=\"<td id=\'\"+\"dispList_dispLocn\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+dispList_dispLocn+\"<input type=\'hidden\' name=\'\"+\"hid_dispense_location\"+totalRows+\"\' id=\'\"+\"hid_dispense_location\"+totalRows+\"\' value=\'\"+hid_disp_locn+\"\' /></td>\";\n\n\t\tcell3.innerHTML=\"<td id=\'\"+\"dispList_machine\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+dispList_machine+\"<input type=\'hidden\' name=\'\"+\"hid_machine\"+totalRows+\"\' id=\'\"+\"hid_machine\"+totalRows+\"\' value=\'\"+hid_machinde+\"\' /></td>\";\n\n\t\tcell4.innerHTML=\"<td id=\'\"+\"dispList_item\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+dispList_item+\"<input type=\'hidden\' name=\'\"+\"hid_item\"+totalRows+\"\' id=\'\"+\"hid_item\"+totalRows+\"\' value=\'\"+hid_item+\"\' /></td>\";\n\n\t\tcell5.innerHTML=\"<td id=\'\"+\"high_alert_drug\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+high_alert_drug+\"<input type=\'hidden\' name=\'\"+\"hid_high_alert_drug\"+totalRows+\"\' id=\'\"+\"hid_high_alert_drug\"+totalRows+\"\' value=\'\"+high_alert_drug+\"\' /></td>\";\n\n\t\tcell6.innerHTML=\"<td id=\'\"+\"pack_only\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+pack_only+\"<input type=\'hidden\' name=\'\"+\"mode\"+totalRows+\"\' id=\'\"+\"mode\"+totalRows+\"\' value=\'insert\'/><input type=\'hidden\' name=\'\"+\"hid_pack\"+totalRows+\"\' id=\'\"+\"hid_pack\"+totalRows+\"\' value=\'\"+pack_only+\"\' /></td>\";\n\n\t\tcell7.innerHTML=\"<td id=\'\"+\"select\"+totalRows+\"\' class=\'\"+class_val+\"\'>\"+select+\"<input type=\'checkbox\' name=\'\"+\"selectBox\"+totalRows+\"\' id=\'\"+\"selectBox\"+totalRows+\"\' value=\'\"+select+\"\' /><input type=\'hidden\' name=\'\"+\"hid_selectBox\"+totalRows+\"\' id=\'\"+\"hid_selectBox\"+totalRows+\"\' /></td>\";\n\n\t\t\n\n\n\n\t\t//alert(\"after cell1\");\n\t\tresetFields();\n\t\t//reloadQueueFrame();\n\n\t\t\n\t}\n\t\n}\n\n//*************************************************\n// function\tcheckNull\n//*************************************************\nfunction checkNull(){\n\t//alert(\"checkNull\");\n\tvar flag;\n \tvar error=\"\";\n\tvar facilityId = document.forms[0].facility_id.value;\n\tvar facilityId_label = getLabel(\"eXH.FacilityID.label\",\"Common\");\n\tvar dispLocn = document.forms[0].disp_locn.value;\n\tvar dispLocn_label = getLabel(\"eXH.DispLocnCode.label\",\"Common\");\n\tvar machine = document.forms[0].machine_code.value;\n\tvar machine_label = getLabel(\"eXH.Machine.label\",\"Common\");\n\tvar item = document.forms[0].item_desc.value;\n\tvar item_label = getLabel(\"eXH.item.label\",\"Common\");\n\n\tif(facilityId==\"\") {\n \t\tflag=false;\n \t\terror+= getMessage(\"CAN_NOT_BE_BLANK\",\"Common\").replace(\"$\",facilityId_label)+\"<br>\";\n \t}\n \tif(dispLocn==\"\") {\n \t\tflag=false;\n \t\terror+= getMessage(\"CAN_NOT_BE_BLANK\",\"Common\").replace(\"$\",dispLocn_label)+\"<br>\";\n \t}\n\n\tif(machine==\"\") {\n \t\tflag=false;\n \t\terror+= getMessage(\"CAN_NOT_BE_BLANK\",\"Common\").replace(\"$\",machine_label)+\"<br>\";\n \t}\n \tif(item==\"\") {\n \t\tflag=false;\n \t\terror+= getMessage(\"CAN_NOT_BE_BLANK\",\"Common\").replace(\"$\",item_label)+\"<br>\";\n \t}\n\tparent.parent.messageFrame.location.href =\'../../eCommon/jsp/error.jsp?err_num=\'+error;\n\tif(flag==false) return false; else return true;\n}\n\n//*********************************************************************\n// function resetFields\n//*********************************************************************\nfunction resetFields(){\n\t\tdocument.forms[0].facility_id.value = \"\";\n\t\tdocument.forms[0].disp_locn.value = \"\";\n\t\tdocument.forms[0].machine_code.value = \"\";\n\t\tdocument.forms[0].item_desc.value = \"\";\n\t\t//document.forms[0].itemQty.value = \"\";\n\t\tdocument.getElementById(\"high_alert_yn\").checked = false;\n\t\tdocument.getElementById(\"pack_only_yn\").checked = false;\n\t\t\n\t\tdocument.forms[0].facility_id.disabled = false;\n\t\tdocument.forms[0].disp_locn.disabled = false;\n\t\tdocument.forms[0].machine_code.disabled = false;\n\t\tdocument.forms[0].item_desc.disabled = false;\n\t\t\n\t\t\n\t\tdocument.forms[0].high_alert_yn.disabled = false;\n\t\tdocument.forms[0].pack_only_yn.disabled = false;\n}\n//****************************************************************\n// function cancelRecord\n//****************************************************************\nfunction cancelRecord(){\n\tvar facilityID = document.getElementById(\"facility_id\").value;\n\tvar dispLocation = document.getElementById(\"disp_locn\").value;\n\tvar machine = document.getElementById(\"machine_code\").value;\n\tvar item = document.getElementById(\"item_desc\").value;\t\n\tvar highAlert=document.getElementById(\"high_aler_drug_yn\").value;\n\tvar packOnly = document.getElementById(\"pack_only_expensive_drug_yn\").value;\t\t\t\n\tvar rowCount = document.forms[0].rowCount.value;\n\t//var totalRows = parent.frames[2].document.getElementById(\"listContentTable\").rows.length;\n\tvar totalRows = parent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").rows.length;\n\talert(\"cancelRecord totalRows..\"+totalRows);\n\tif(totalRows>0){\t\t\t\n\t\tfor(i=1;i<=totalRows;i++){\t\t\t\t\n\t var hdnI = i;\n\t var selectedText = parent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").rows[i].cells[0].innerText;\n\t alert(\"selectedText..\"+selectedText);\n\t\t if(selectedText == facilityID){\t\t\t\t\n\t\t\tif(i<=rowCount){\t\t\t\n\t\t\t\t\t//resetFields();\t\t\t\t\t\n\t\t\t\t\tparent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").rows[i].cells[0].innerText = selectedText;\n\t\t\t\t\tparent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").rows[i].cells[0].style.color = \'#FF0000\';\n\t\t\t\t\tparent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").rows[i].cells[1].style.color = \'#FF0000\';\n\t\t\t\t\tparent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").rows[i].cells[2].style.color = \'#FF0000\';\n\t\t\t\t\tparent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").rows[i].cells[3].style.color = \'#FF0000\';\n\t\t\t\t\tparent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").rows[i].cells[4].style.color = \'#FF0000\';\n\t\t\t\t\tparent.frames[0].document.getElementById(\"dispItemsMachineCodesListTable\").rows[i].cells[5].style.color = \'#FF0000\';\n\t\t\t\t\t\n\t\t\t\t\tvar hdntxt = \"mode\"+hdnI;\n\t\t\t\t\talert(\"hdntxt..\"+hdntxt);\n\t\t\t\t\tparent.frames[0].document.getElementById(hdntxt).value=\'delete\';\n\t\t\t\t}\t\t\t\t\t\n\t\t\t\treturn true;\n\t\t\t}\n\t\t}\n\t}\n}\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<form name=\"formDispItemsForMachineCodesTab\" id=\"formDispItemsForMachineCodesTab\" id=\"frmid\"  method=\"post\" action=\"../../servlet/eXH.XHDispItemsForMachineCodeServlet\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<table border=\"0\" cellpadding=\"1\" cellspacing=\"0\" width=\'100%\'  align=center>\n\t\t\t<a  name=\"tab1\"></a>\n\t\t\t<img  src=\"../../eST/images/IndividualItem.gif\" border=0>\n\t\t\t<tr>\n\t\t\t\t<td  colspan=\"4\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\n\t\t\t     <td  class=\"label\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t <input type=\'text\' id=\"facilityID\" name=\'facility_id\' id=\'facility_id\' size=25 value=\'\' onBlur=\'GetFacilityLookup(facility_id)\'>\n\t\t\t\t <input type=button class=button name=\'user_lookup\' id=\'user_lookup\' value=\'?\' onClick=\'GetFacilityLookup(facility_id)\'>\n\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t\t\t\t <input type=hidden id=\"facility\"  name =\'facility\' value=\'\' ></td>\t\n\t\t\t\t <td colspan=2> </td>\n\t\t\t\t\n\t\t\t\t <td  class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t <input type=\'text\' id=\"dispenseLocantion\" name=\'disp_locn\' id=\'disp_locn\' size=25 value=\'\' onBlur=\'GetMachineLocnLookup(disp_locn,facility)\'>\n\t\t\t\t <input type=button class=button name=\'user_lookup\' id=\'user_lookup\' value=\'?\' onClick=\'GetMachineLocnLookup(disp_locn,facility)\'>\n\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t\t\t\t <input type=hidden id=\"disp_location\"  name =\'disp_location\' value=\'\' ></td>\t\n\t\t\t\t <td colspan=2> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t <input type=\'text\' id=\"machineCode\" name=\'machine_code\' id=\'machine_code\' size=25 value=\'\' onBlur=\'GetMachineLookup(machine_code)\'>\n\t\t\t\t <input type=button class=button name=\'user_lookup\' id=\'user_lookup\' value=\'?\' onClick=\'GetMachineLookup(machine_code)\'>\n\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t\t\t\t <input type=hidden id=\"machine\"  name =\'machine\' value=\'\' ></td>\t\n\t\t\t\t <td colspan=2> </td>\n\n\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td  class=\'fields\'><input type=\'text\' id=\"itemCode\" name=\"item_desc\" id=\"item_desc\" value=\'\' maxLength=25 size=25 onBlur=\'GetItemLookup(item_desc)\'>\n\t\t\t\t<input name=\"item_search\" id=\"item_search\" class=\"button\" onClick=\"GetItemLookup(item_desc);\" type=\"button\" value=\"?\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" >&nbsp;<IMG src=\"../../eCommon/images/mandatory.gif\"align=\'center\'></td>\n\t\t\t\t<input type=hidden id=\"item\"  name =\'item\' value=\'\' ></td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\n\t\t\t\t<td class=\'fields\'><input type=checkbox id =\"high_alert_yn\" name =\'high_aler_drug_yn\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" onClick=\'validatecheckbox(high_aler_drug_yn);\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'></td>\n\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\n\t\t\t\t<td class=\'fields\'><input type=checkbox id=\"pack_only_yn\" name =\'pack_only_expensive_drug_yn\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" onClick=\'validatecheckbox(pack_only_expensive_drug_yn);\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'></td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t\n\t\t\t<tr>\n\t\t\t\n\t\t\t<table border=\"0\" cellpadding=\"1\" cellspacing=\"0\" width=\'100%\' align=center>\n\t\t\t<tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\"label\" colspan=\'4\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\"label\" colspan=\'4\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t<td  class=\'fields\'>\n\t\t\t\t    \n\t\t\t\t\t<input type=\'button\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' name=\'add_single\' class=\'BUTTON\' onClick=\'addSelect();\'></input>&nbsp;&nbsp;&nbsp; \n\t\t\t\t\t<input class=\"button\" type=\"add_single\"  name=\"ove\" id=\"ove\" disabled style=\'display:none\' value=\'Move\' > \n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</tr>\n\t\t\t\n\t\t\t</table>\n\t\t\t<br> <br><br><br><br><br><br><br><br><br><br><br><br>\n\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\t\t\t\n\t\t\t<input type=hidden name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<input type=hidden name=\"rowCount\" id=\"rowCount\" value=\"\" />\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<table border=\"0\" cellpadding=\"1\" cellspacing=\"0\" width=\'100%\'  align=center>\n\t\t\t<a  name=\"tab1\"></a>\n\t\t\t<img  src=\"../../eST/images/IndividualItem.gif\" border=0>\n\t\t\t<tr>\n\t\t\t\t<td  colspan=\"4\">&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t     <td  class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t <input type=\'text\' id=\"facilityID\" name=\'facility_id\' id=\'facility_id\' size=25 value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onBlur=\'GetFacilityLookup(facility_id)\' disabled>\n\t\t\t\t <input type=button class=button name=\'user_lookup\' id=\'user_lookup\' value=\'?\' onClick=\'GetFacilityLookup(facility_id)\' disabled>\n\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t\t\t\t <input type=hidden id=\"facility\"  name =\'facility\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' ></td>\t\n\t\t\t\t <td colspan=2> </td>\n\t\t\t\t\n\t\t\t\t <td  class=\"label\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t <input type=\'text\' id=\"dispenseLocantion\" name=\'disp_locn\' id=\'disp_locn\' size=25 value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onBlur=\'GetMachineLocnLookup(disp_locn,facility)\' disabled>\n\t\t\t\t <input type=button class=button name=\'user_lookup\' id=\'user_lookup\' value=\'?\' onClick=\'GetMachineLocnLookup(disp_locn,facility)\' disabled>\n\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t\t\t\t <input type=hidden id=\"disp_location\"  name =\'disp_location\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' ></td>\t\n\t\t\t\t <td colspan=2> </td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t<td class=\'fields\'>\n\t\t\t\t <input type=\'text\' id=\"machineCode\" name=\'machine_code\' id=\'machine_code\' size=25 value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onBlur=\'GetMachineLookup(machine_code)\' >\n\t\t\t\t <input type=button class=button name=\'user_lookup\' id=\'user_lookup\' value=\'?\' onClick=\'GetMachineLookup(machine_code)\'>\n\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t\t\t\t <input type=hidden id=\"machine\"  name =\'machine\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' ></td>\t\n\t\t\t\t <td colspan=2> </td>\n\n\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t<td  class=\'fields\'><input type=\'text\' id=\"itemCode\" name=\"item_desc\" id=\"item_desc\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' maxLength=25 size=25 onBlur=\'GetItemLookup(item_desc)\' disabled>\n\t\t\t\t<input name=\"item_search\" id=\"item_search\" class=\"button\" onClick=\"GetItemLookup(item_desc);\" type=\"button\" value=\"?\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="  disabled>&nbsp;<IMG src=\"../../eCommon/images/mandatory.gif\"align=\'center\'></td>\n\t\t\t\t<input type=hidden id=\"item\"  name =\'item\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' ></td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\t\t\t\t\n\t\t\t\t<td class=\'fields\'><input type=checkbox id =\"high_alert_yn\" name =\'high_aler_drug_yn\' ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'></td>\n\n\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=checkbox id=\"pack_only_yn\" name =\'pack_only_expensive_drug_yn\' ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t<input type=hidden name=\"rowCount\" id=\"rowCount\" value=\"\" />\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	String locale		=	(String)session.getAttribute("LOCALE");
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


   String mode;
   String function_id;
   String facility_id = "";
   String DispLocn = "";
   String Machine = "";
   String high_aler_drug_yn = "";
   String pack_only_expensive_drug_yn = "";

   
   boolean editMode			=		false;
   mode						=		request.getParameter("mode");
   System.out.println("DispItemForMachineCodes ::: Mode ::: "+mode);
   String facilityID_rslt = request.getParameter("facility_id");
   String dispLocn_rslt = request.getParameter("disp_locn");
   String machine_rslt = request.getParameter("machine_code");
   String item_rslt = request.getParameter("item_desc");
   String highAlert_rslt = request.getParameter("high_alert_yn")==null?"":request.getParameter("high_alert_yn");
   String packOnly_rslt = request.getParameter("pack_only_yn")==null?"":request.getParameter("pack_only_yn");
   System.out.println("DispItemForMachineCodes ::: fac ::: "+facilityID_rslt+" :: "+dispLocn_rslt+" :: "+machine_rslt+" :: "+item_rslt+" :: "+highAlert_rslt+" :: "+packOnly_rslt);
	
   String facilityName = request.getParameter("facilityName");
   String dispLocnName = request.getParameter("dispLocnName");
   String machineName = request.getParameter("machineName");
   String itemName = request.getParameter("itemName");

   System.out.println("facilityName :: "+facilityName+":: dispLocnName :: "+dispLocnName+" :: machineName :: "+machineName+" :: itemName :: "+itemName);
	
	String disabled				=		"";	
	String checked				=		"";	
	String gif_visibility		=		"visibility:visibile";
	String modify_legend		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
	String add_legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String dis_abled			=		"disabled";
	

            _bw.write(_wl_block9Bytes, _wl_block9);

if(mode.equals("Insert")){


            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(high_aler_drug_yn.equals("Y")?"checked":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(high_aler_drug_yn.equals("Y")?"Y":"N"));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pack_only_expensive_drug_yn.equals("Y")?"checked":""));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pack_only_expensive_drug_yn.equals("Y")?"Y":"N"));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(editMode?modify_legend:add_legend));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block24Bytes, _wl_block24);

}else if(mode.equals("Modify")){

            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(facilityID_rslt));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dispLocnName));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(dispLocn_rslt));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(machineName));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(machine_rslt));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(itemName));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(item_rslt));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(highAlert_rslt.equals("Y")?"checked":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(high_aler_drug_yn.equals("Y")?"Y":"N"));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(packOnly_rslt.equals("Y")?"checked":""));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pack_only_expensive_drug_yn.equals("Y")?"Y":"N"));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(editMode?modify_legend:add_legend));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);

			}

            _bw.write(_wl_block43Bytes, _wl_block43);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.FacilityID.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.DispLocnCode.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Machine.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.item.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.HighAlertDrugYN.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.PackOnlyExpensiveDrugYN.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.FacilityID.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.DispLocnCode.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Machine.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.item.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.HighAlertDrugYN.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.PackOnlyExpensiveDrugYN.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
