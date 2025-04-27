package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eCommon.Common.*;
import org.json.simple.*;
import java.util.Map.Entry;
import java.util.Set;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eBL.*;
import eBL.resources.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import eCA.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcodereditservice extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCoderEditService.jsp", 1737915893668L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n<!--<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/BLCoderServices.css\'></link>-->\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eBL/images/BLCoderServices.css\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\t\n<script language=\"javascript\" src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language =\"javascript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script language =\"javascript\" src =\'../../eBL/js/cptLookup.js\'></Script>\n<script language=\"javascript\">\n\n//Global Declaration\nvar dataArr = [];\nvar addRowFlag;\nvar dupFlag;\nvar subFlag=\"Y\";\n//V201015 Starts\nvar visitAdmDatetime=\"\";\nvar datetime=\"\";\n//V201015 Starts\n\n//Function to find the Value is Numeric or Not\nfunction isNo(e){\n\tif(!isNumber(e)){\n\t\talert(getMessage(\'BL8532\',\'BL\'));\n\t\tdocument.getElementById(e.id).focus();\n\t}else{\n\t\te.value = parseFloat(e.value).toFixed(2);\n\t}\n}\n\n// Function to get current date and Time\n//V201015 Starts\nfunction getCurrentDateTime()\n{\n\tvar currentdate = new Date(); \n\tvar minutes=currentdate.getMinutes();\n\tvar month=(\"0\" + (currentdate.getMonth() + 1)).slice(-2);\n\tif(minutes.length==1){\n\t\tminutes=\"0\"+minutes;\n\t}\n\tdatetime = currentdate.getDate() + \"/\"\n\t\t\t+  month  + \"/\" \n\t\t\t+  currentdate.getFullYear()+ \" \"  \n\t\t\t+  currentdate.getHours() + \":\"  \n\t\t\t+  minutes+ \":\"\n\t\t\t+  currentdate.getSeconds();\n\t\t\treturn datetime;\n}\n//V201015 Ends\n\n//RRestricting alphabets in KeyPress\nfunction restrictAlphabets(evt){\n\tvar x = evt.which || evt.keyCode;\n\tif((x>47 && x<58) || x==46)\n\t\treturn true;\n\telse\n\t\treturn false;\n}\n\n//Is Number Function\nfunction isNumber(n) {\n\treturn !isNaN(parseFloat(n.value)) && isFinite(n.value);\n}\n\n//Date Format validation\nfunction dateRegEx(e){\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tvar pattern = new RegExp(\"^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4} (2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$\");\n\tif (e.value.search(pattern)===0){\n\t\treturn true;\n\t}\n\telse {\n\t\talert(\"Please provide valid date in format dd/mm/yyyy hh:mm:ss, including leading zero. Exapmle: 01/02/2015 03:04:59\");\n\t\tdocument.getElementById(e.id).focus();\n\t\tdocument.getElementById(e.id).value=getCurrentDateTime();\t//V201015 Added\n\t\treturn false; \n\t} \n}\n\n//Fucntion to Populate Service Type Description\nfunction populateServTypeDesc(servCode,rIndex){\n\tif(servCode!=\"\" && servCode!=null){\n\t\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?servCode=\"+servCode+\"&CalledFor=servCode\";\n\t\tvar xmlDoc = \"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\t\t\n\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\txmlHttp.send(\"\");\n\t\tvar resText=xmlHttp.responseText;\n\t\tresText = trimString(resText);\n\t\tvar nFin = resText.indexOf(\"~\");\n\t\tvar resFin = resText.substr(nFin+1);\n\t\tif(resFin==\"\" || resFin==null){\n\t\t\talert(\"Error at server end..\");\n\t\t}else{\n\t\t\tdocument.getElementById(\"serviceTypeDesc\"+rIndex).value=resFin;\n\t\t}\n\t}\n}\n\n/*Three Column Look up Starts*/\nfunction callCPTSearch(e)\n{\n\tvar formObj=document.BLCoderEditService;\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tvar servCodeVal=document.getElementById(\"serviceCode\"+RowIndex).value;\n\tvar cptCodeVal=document.getElementById(\"cptCode\"+RowIndex).value;\n\tvar serTypeInd=document.getElementById(\"servicetype\"+RowIndex).value;\n\tvar LangId=document.getElementById(\"locale\").value;\n\tvar Facility_Id=document.getElementById(\"FacilityId\").value;\n\tif(formObj!=null){\n\t\tvar argumentArray\t= new Array();\n\t\tvar dataNameArray\t= new Array();\n\t\tvar dataValueArray\t= new Array();\n\t\tvar dataTypeArray\t= new Array();\n\t\tvar target\t\t\t= \"\";\n\t\tvar sql\t\t\t\t= \"\"; \n\t\t//sql = \"SELECT a.generic_id code, a.generic_name description, b.thirdparty_type thirdparty_type FROM ph_generic_name_lang_vw a, ph_generic_ext_prod_ref b WHERE a.generic_id = b.generic_id AND UPPER (a.generic_id) LIKE UPPER (?) AND UPPER (LTRIM (a.generic_name, \'*\')) LIKE UPPER (?) AND UPPER (b.thirdparty_type) LIKE UPPER (?) AND a.eff_status = \'E\' AND b.eff_status = \'E\' AND b.product_id = \'CIMS\' AND a.language_id = \'\"+locale+\"\'\";\n\t\tsql=\"SELECT cpt_code cptcode, service_code code, service_desc description FROM BL_CODER_CONV_CPT_SERV_CODE_VW where service_type=\'\"+serTypeInd+\"\' AND UPPER (cpt_code) LIKE UPPER (?) AND UPPER (service_desc) LIKE UPPER (?) AND UPPER (service_code) LIKE UPPER (?)\";\n\t\targumentArray[0] = sql ;\n\t\targumentArray[1] = dataNameArray;\n\t\targumentArray[2] = dataValueArray;\n\t\targumentArray[3] = dataTypeArray;\n\t\targumentArray[4] = \"1,2\";\n\t\targumentArray[5] = cptCodeVal;\n\t\targumentArray[6] = CODE_LINK;\n\t\targumentArray[7] = CODE_DESC; \t\n\t\tvar retVal = cptLookup(\"CPT Code\", argumentArray);\n\t\tvar arr = retVal.split(\"\\\"\");\n\t\tif (retVal != null && retVal != \'\' && retVal != \"null\"){\n\t\t\t//To remove duplications While selecting in LOV\n\t\t\tdocument.getElementById(\"cptCode\"+RowIndex).value=arr[0];\n\t\t\tdocument.getElementById(\"serviceCode\"+RowIndex).value=arr[1];\n\t\t\tvalidateCPTCode(e);\n\t\t}\n\t\telse{\n\t\t\tdocument.getElementById(\"cptCode\"+RowIndex).value=\"\";\n\t\t\tdocument.getElementById(\"serviceCode\"+RowIndex).value=\"\";\n\t\t\tdocument.getElementById(\"serviceDesc\"+RowIndex).value=\"\";\n\t\t\tdocument.getElementById(\"ServPrice\"+RowIndex).value=\"\";\n\t\t\tdocument.getElementById(\"InsAmt\"+RowIndex).value=\"\";\n\t\t\tdocument.getElementById(\"serviceQty\"+RowIndex).value=\"1\";\n\t\t}\n\t}\n}\n\n//Validate CPT code\nfunction validateCPTCode(e){\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tif(e.value!=\"\" && e.value!=null){\n\t\tvar cptCode=document.getElementById(\"cptCode\"+RowIndex).value;\n\t\tvar servCode=document.getElementById(\"serviceCode\"+RowIndex).value;\n\t\tvar FacilityId = document.getElementById(\'FacilityId\').value;\n\t\tvar LangId=document.getElementById(\"locale\").value;\n\t\tvar serTypeInd=document.getElementById(\"servicetype\"+RowIndex).value;\n\t\tvar loginUser = document.getElementById(\'logInUserId\').value;\n\t\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?servCode=\"+servCode+\"&cptCode=\"+cptCode+\"&CalledFor=cptCode&FacilityId=\"+FacilityId+\"&LangId=\"+LangId+\"&loginUser=\"+loginUser+\"&serTypeInd=\"+serTypeInd;\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\t\t\n\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\txmlHttp.send(\"\");\n\t\tvar responseText=xmlHttp.responseText;\n\t\tif(responseText != null && responseText != \"\"){\n\t\t\tvar n = responseText.indexOf(\"~\");\n\t\t\tvar res = responseText.substr(n+1);\n\t\t\tres = res.split(\"~\");\n\t\t\tif(res[0]==\"S\"){\n\t\t\t\tdocument.getElementById(\"serviceCode\"+RowIndex).value=res[1];\n\t\t\t\tdocument.getElementById(\"serviceDesc\"+RowIndex).value=res[2];\n\t\t\t\tdocument.getElementById(\"serviceDesc\"+RowIndex).title=res[2];//V230516-aakh-crf-0153\n\t\t\t\tvalidateServCode(e);\n\t\t\t\tvar servType=document.getElementById(\'servicetype\'+RowIndex).value;\n\t\t\t\tif(servType==\"S\")\n\t\t\t\t\tpopulateServTypeDesc(res[1],RowIndex);\n\t\t\t}else if(res[0]==\"E\"){\t\n\t\t\t\tdocument.getElementById(\"cptCode\"+RowIndex).value=\"\";\t\t \n\t\t\t\tdocument.getElementById(\"serviceCode\"+RowIndex).value=\"\";\n\t\t\t\tdocument.getElementById(\"serviceDesc\"+RowIndex).value=\"\";\n\t\t\t\tdocument.getElementById(\"serviceDesc\"+RowIndex).title=\"\";//V230516-aakh-crf-0153\n\t\t\t\tdocument.getElementById(\"ServPrice\"+RowIndex).value=\"\";\n\t\t\t\tdocument.getElementById(\"InsAmt\"+RowIndex).value=\"\";\n\t\t\t\tdocument.getElementById(\"serviceQty\"+RowIndex).value=\"1\";\n\t\t\t\talert(res[1]);\n\t\t\t}\n\t\t\telse{\n\t\t\t\tcallCPTSearch(e);\n\t\t\t}\n\t\t}\n\t}else{\n\t\tfor(var g=0;g<dupArr.length;g++){\n\t\t\tvar m = dupArr[i].split(\"~\");\n\t\t\tif(RowIndex==m[1]){\n\t\t\t\tdupArr.splice(g, 1);\n\t\t\t}\n\t\t}\n\t\tdocument.getElementById(\"cptCode\"+RowIndex).value=\"\";\t\t \n\t\tdocument.getElementById(\"serviceCode\"+RowIndex).value=\"\";\n\t\tdocument.getElementById(\"serviceTypeDesc\"+RowIndex).value=\"\";\n\t\tdocument.getElementById(\"serviceDesc\"+RowIndex).value=\"\";\n\t\tdocument.getElementById(\"serviceDesc\"+RowIndex).title=\"\";//V230516-aakh-crf-0153\n\t\tdocument.getElementById(\"ServPrice\"+RowIndex).value=\"\";\n\t\tdocument.getElementById(\"InsAmt\"+RowIndex).value=\"\";\n\t\tdocument.getElementById(\"serviceQty\"+RowIndex).value=\"1\";\n\t}\n}\n\n//Function to save Update flag\nfunction billClick(e){\n\tvar table = document.getElementById(\'serviceTable1\');\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tvar addFlag=document.getElementById(\'serviceAddRow\'+RowIndex).value;\n\tvar canFlag=document.getElementById(\'serviceCancelRow\'+RowIndex).value;\n\tvar chkbox = table.rows[RowIndex].cells[14].getElementsByTagName(\'input\')[0];\n\tvar serviceModFlag=document.getElementById(\"serviceModAppNo\"+RowIndex).value;\n\tvar episodeFlag=document.getElementById(\'EpisodeType\').value;\n\tif(episodeFlag==\"I\" || episodeFlag==\"D\"){\n\t\talert(getMessage(\'BL9763\',\'BL\'));\n\t\tdocument.getElementById(e.id).checked = true;\n\t}else{\n\tif(canFlag!=\"Y\" && addFlag!=\"Y\"){\n\t\t//if(false == chkbox.checked && serviceModFlag!=\'Y\'){\n\t\tif((false == chkbox.checked || true == chkbox.checked) && serviceModFlag!=\'Y\'){ // Modifiied for AAKH-SCF-0506 BY PALANI NARAYANAN\n\t\t\tdocument.getElementById(\"modifyYN\"+RowIndex).value=\"Y\";\n\t\t}\n\t}\n\t}\n}\n\nfunction performClinicianBlur(e){\n\t//Validation\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tvar addFlag=document.getElementById(\'serviceAddRow\'+RowIndex).value;\n\tvar canFlag=document.getElementById(\'serviceCancelRow\'+RowIndex).value;\n\tvar serviceModFlag=document.getElementById(\"serviceModAppNo\"+RowIndex).value;\n\tif(canFlag!=\"Y\" && addFlag!=\"Y\" && serviceModFlag!=\'Y\'){\n\t\tdocument.getElementById(\"modifyYN\"+RowIndex).value=\"Y\";\n\t}\n\telse{\n\t\tdocument.getElementById(\"modifyYN\"+RowIndex).value=\"N\";\n\t}\n}\n\n//Function to save Update flag\nfunction ModAppNo(e){\n\t//Validation\n\tvar chngVal=e.value;\n\tvar lastVal=document.getElementById(e.id).defaultValue;\n\tif(chngVal!=lastVal){\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tvar addFlag=document.getElementById(\'serviceAddRow\'+RowIndex).value;\n\tvar canFlag=document.getElementById(\'serviceCancelRow\'+RowIndex).value;\n\t\tif(canFlag!=\"Y\" && addFlag!=\"Y\"){\n\t\t\tdocument.getElementById(\"serviceModAppNo\"+RowIndex).value=\"Y\";\n\t\t}\n\t\telse{\n\t\t\tdocument.getElementById(\"serviceModAppNo\"+RowIndex).value=\"N\";\n\t\t}\n\t\tif(e.id==\"ApproveDate\"+RowIndex){\n\t\t\tif(e.value!=null && e.value!=\"\"){\n\t\t\t\tif(dateRegEx(e)){\n\t\t\t\t//Future Date validation JS\n\t\t\t\t// function checkDate() {\n\t\t\t\tvar selectedText = e.value;\n\t\t\t\tvar selectedDate = new Date(selectedText);\n\t\t\t\tvar now = new Date(getCurrentDateTime());//V201015 Modified\n\t\t\t\tif (selectedDate > now) {\n\t\t\t\t\talert(\"Date cannot be greater than the System date\");\n\t\t\t\t\tdocument.getElementById(\'ApproveDate\'+RowIndex).value=getCurrentDateTime();\t//V201015 Modified\n\t\t\t\t}\t\t\t\t\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tif(addFlag!=\"Y\"){\n\t\t\t\t\tdocument.getElementById(\'ApproveDate\'+RowIndex).value=document.getElementById(\'appDateHid\'+RowIndex).value;\n\t\t\t\t}else{\n\t\t\t\t\tdocument.getElementById(\'ApproveDate\'+RowIndex).value=getCurrentDateTime();//V201015 Modified\n\t\t\t\t}\n\t\t\t}\n\t\t}else if(e.id==\"ApproveNum\"+RowIndex){\n\t\t\tif(e.value!=null && e.value!=\"\"){\n\t\t\t\tvar AppDateVal=document.getElementById(\'ApproveDate\'+RowIndex).value;\n\t\t\t\tif(AppDateVal==\"\" || AppDateVal==null){\n\t\t\t\t\tdocument.getElementById(\'ApproveDate\'+RowIndex).value=getCurrentDateTime();//V201015 Modified\n\t\t\t\t}\t\t\t\t\t\t\n\t\t\t}else{\n\t\t\t\tif(addFlag!=\"Y\"){\n\t\t\t\t\tdocument.getElementById(\'ApproveNum\'+RowIndex).value=document.getElementById(\'appNoHid\'+RowIndex).value;\n\t\t\t\t}else{\n\t\t\t\t\tdocument.getElementById(\'ApproveNum\'+RowIndex).value=\"\";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n}\n\n//Deleting Row against Cancel service Check box\nfunction deleteRow() {\n\ttry{\n\t\tvar table = document.getElementById(\'serviceTable1\');\n\t\tvar rowCount = table.rows.length;\n\t\tfor(var i=1; i<rowCount; i++) {\n\t\t\tvar row = table.rows[i];\n\t\t\tvar chkbox = row.cells[16].childNodes[0];\n\t\t\tif(null != chkbox && true == chkbox.checked) {\n\t\t\t\tif(rowCount <= 1) {\n\t\t\t\t\talert(\"Cannot delete all the rows.\");\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t\ttable.deleteRow(i);\n\t\t\t\trowCount--;\n\t\t\t\ti--;\n\t\t\t}\n\t\t}\n\t}catch(e){\n\t\talert(e);\n\t}\n}\n\n// function to get Date and Time From DB\n//V201015 Starts\nfunction getVisitAdmDate(){\n\tvar ServEncounterId = document.getElementById(\"+ServEncounterId+\").value;\n\tvar PatientID = document.getElementById(\'PatientID\').value;\n\t//Getting Visit Admission Date\n\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=visitAdmDate&ServEncounterId=\"+ServEncounterId+\"&PatientID=\"+PatientID;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\t\t\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(\"\");\n\tvar responseText=xmlHttp.responseText;\n\tif(responseText!=\"\" && responseText!=null){\n\tvar strtIndex = responseText.indexOf(\"~\");\n\tif(strtIndex!=-1){\n\t\tvar finDateTime = responseText.substr(strtIndex+1);\n\t\treturn finDateTime;\n\t}\n\t}\n}\t\n//V201015 Ends\n\nfunction addRow1(x) {\n\taddRowFlag=\"Y\";\n\tvar orderclinicianID;\n\tvar orderclinicianName;\n\tvar RowIndex=x.parentNode.parentNode.rowIndex;\n\tvar table = document.getElementById(\'serviceTable1\');\n\tvar rowCount = table.rows.length;\n\tvar row = table.insertRow(rowCount);\n\trow.setAttribute(\"id\",\"serviceRow\"+rowCount);\n\trow.onclick = function() {RowChange(this);}; // for IE\n\tvar colCount = table.rows[RowIndex].cells.length;\n\tfor(var i=0; i<colCount; i++) {\n\t\tvar newcell\t= row.insertCell(i);\n\t\t\n\t\t\tdatetime = getCurrentDateTime();//V201015 Modified\n\t\t\tvisitAdmDatetime = getCurrentDateTime();//V201015 Modified\n\t\tif(i==0){\t\n\t\t\tvisitAdmDatetime=getVisitAdmDate();//V201015 Modified\n\t\t\tnewcell.innerHTML =\"<input type=\'text\' class=\'gridDataInputMore\' onblur=\'validateDateTime(this)\' name=\'serviceDate\"+rowCount+\"\' id=\'serviceDate\"+rowCount+\"\' id=\'serviceDate\"+rowCount+\"\' value=\'\"+visitAdmDatetime+\"\' size=\'19\' maxlength=\'19\'><img src=\'../../eCommon/images/CommonCalendar.gif\'  onclick=\\\"return showCalendar(\'serviceDate\"+rowCount+\"\',null,\'hh:mm:ss\');\\\"><input type=\'hidden\' id=\'servDateHid\"+rowCount+\"\'value=\'\"+visitAdmDatetime+\"\'>\"; //V201222 Modified\n\t\t\t//newcell.className = \'gridData\';\n\t\t}\n\t\telse if(i==1){\n\t\tnewcell.innerHTML=\"<select name=\'servicetype\"+rowCount+\"\' id=\'servicetype\"+rowCount+\"\' id=\'servicetype\"+rowCount+\"\' onchange=\'DrugTypeChange(this)\'>\"    \n\t\t\t+\"<option value=\'Select\' >-Select-</option>\"\n\t\t\t+\"<option value=\'S\' selected>Service</option>\"\n\t\t\t+\"<option value=\'I\' >Drug</option>\"\n\t\t\t+\" </select>\";\n\t\t}\n\t\telse if(i==17){\n\t\tnewcell.innerHTML =\"<input type=\'checkbox\' name=\'Cancelcheck\"+rowCount+\"\' id=\'Cancelcheck\"+rowCount+\"\'  id=\'Cancelcheck\"+rowCount+\"\' onclick=\'CancelClick(this)\' value=\'\' /><input style=\'display:none;\' type=\'text\' id=\'serviceCancelRow\"+rowCount+\"\' value=\'\' ><input style=\'display:none;\' type=\'text\' id=\'primKeyModuleID\"+rowCount+\"\' value=\'\' >\";\n\t\t}\n\t\telse if(i==15){\n\t\t\tnewcell.innerHTML=\"<input type=\'checkbox\' name=\'checkboxBill\"+rowCount+\"\' id=\'checkboxBill\"+rowCount+\"\' value=\'checked\' id=\'checkboxBill\"+rowCount+\"\'  onclick=\'billClick(this)\' checked/><input style=\'display:none;\' type=\'text\' id=\'serviceBillCheck\"+rowCount+\"\'>\";\n\t\t}\n\t\telse if(i==16){\n\t\t\tnewcell.innerHTML = \"<input type=\'button\' name=\'AddBTn\"+rowCount+\"\' id=\'AddBTn\"+rowCount+\"\'  value=\'+\' onclick=\'addRow1(this)\' id=\'AddBTn\"+rowCount+\"\'><input style=\'display:none;\' type=\'text\' id=\'serviceAddRow\"+rowCount+\"\' value=\'Y\' >\";\n\t\t}\n\t\t\n\t\telse if(i==10){\n\t\t\t newcell.innerHTML = \"<input type=\'checkbox\' name=\'checkboxZero\"+rowCount+\"\' id=\'checkboxZero\"+rowCount+\"\' id=\'checkboxZero\"+rowCount+\"\' onclick=\'zeroPriceClick(this)\' />\";\n\t\t\t//newcell.className = \'gridData\';\n\t\t}\n\t\telse if(i==8){\n\t\t\t newcell.innerHTML = \"<input type=\'text\' class=\'gridDataInputLess\' style=\'width: 50px;\' onkeypress=\'return restrictAlphabets(event);\' onblur=\'validateServQty(this)\' id=\'serviceQty\"+rowCount+\"\' name=\'serviceQty\"+rowCount+\"\' id=\'serviceQty\"+rowCount+\"\' ><input type=\'text\'  style=\'display:none;\' id=\'serviceRateCharge\"+rowCount+\"\' value=\'\' >\";\n\t\t\t//newcell.className = \'gridData\';\n\t\t}\n\t\telse if(i==3){\n\t\t\tnewcell.innerHTML=\"<input type=\'text\' class=\'gridDataInput\' onblur=\'validateCPTCode(this)\' name=\'cptCode\"+rowCount+\"\' id=\'cptCode\"+rowCount+\"\' id=\'cptCode\"+rowCount+\"\' contenteditable><input type=\'button\' class=\'button\' value=\'?\' onclick=\'callCPTSearch(this)\' name = \'servCodeLovButton\'> \";\n\t\t\t//newcell.className = \'gridData\';\n\t\t}\n\t\telse if(i==4){\n\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInputMore\' type=\'text\' name=\'serviceDesc\"+rowCount+\"\' id=\'serviceDesc\"+rowCount+\"\' id=\'serviceDesc\"+rowCount+\"\' readonly>\"; //V201222 Modified\n\t\t}\n\t\telse if(i==5){\n\t\t\tnewcell.innerHTML=\"<input type=\'text\' class=\'gridDataInput\' onblur=\'validateServCode(this)\' name=\'serviceCode\"+rowCount+\"\' id=\'serviceCode\"+rowCount+\"\' id=\'serviceCode\"+rowCount+\"\' contenteditable> \";\n\t\t\t//newcell.className = \'gridData\';\n\t\t}\n\t\telse if(i==6){\n\t\t\t//Getting Ordering Clinician\n\t\t\tvar FacilityId = document.getElementById(\'FacilityId\').value;\n\t\t\tvar EncounterId = document.getElementById(\"+ServEncounterId+\").value;\n\t\t\tvar PatientID = document.getElementById(\'PatientID\').value;\n\t\t\tvar EpisodeId = document.getElementById(\'EpisodeId\').value;\n\t\t\tvar EpisodeType = document.getElementById(\'EpisodeType\').value;\n\t\t\tvar VisitID = document.getElementById(\'VisitID\').value;\n\t\t\tvar LangId=document.getElementById(\"locale\").value;\n\t\t\tvar params=\"&FacilityId=\"+FacilityId+\"&EpisodeType=\"+EpisodeType+\"&EncounterId=\"+EncounterId+\"&VisitID=\"+VisitID+\"&LangId=\"+LangId;\n\t\t\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=orderClinician\"+params;\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\t\t\n\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\txmlHttp.send(\"\");\n\t\t\tvar responseText=xmlHttp.responseText;\n\t\t\tif(responseText!=\"\" && responseText!=null){\n\t\t\tvar strtIndex = responseText.indexOf(\"~\");\n\t\t\tif(strtIndex!=-1){\n\t\t\t\tvar res1 = responseText.substr(strtIndex+1);\n\t\t\t\tvar res = res1.split(\"~\");\n\t\t\t\torderclinicianID = res[0];\n\t\t\t\torderclinicianName=res[1];\n\t\t\t}else{\n\t\t\t\torderclinicianID = \"\";\n\t\t\t\torderclinicianName=\"\";\n\t\t\t}\n\t\t\t}\t\t\t\t\t\n\t\t\tnewcell.innerHTML=\"<input type=\'text\' class=\'gridDataInput\' name=\'orderClinic\"+rowCount+\"\' id=\'orderClinic\"+rowCount+\"\' id=\'orderClinic\"+rowCount+\"\' contenteditable><input type=\'button\' class=\'button\' value=\'?\' onclick=\'orderingClinicianLookUp(this)\' name = \'OrderLovButton\'><input style=\'display:none;\' type=\'text\' id=\'orderClinicID\"+rowCount+\"\' value=\'\' > \";\n\t\t}\n\t\telse if(i==7){\n\t\t\tnewcell.innerHTML=\"<input type=\'text\' class=\'gridDataInput\' name=\'performClinic\"+rowCount+\"\' id=\'performClinic\"+rowCount+\"\' id=\'performClinic\"+rowCount+\"\' contenteditable><input type=\'button\' class=\'button\' value=\'?\' onclick=\'performingClinicianLookUp(this)\'  id=\'PerformLovButton\' name=\'PerformLovButton\' id=\'PerformLovButton\'><input style=\'display:none;\' type=\'text\' id=\'performClinicID\"+rowCount+\"\' value=\'\'><input style=\'display:none;\' type=\'text\' id=\'modifyYN\"+rowCount+\"\' value=\'N\' >\";\n\t\t}\n\t\telse if(i==12){\n\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' style=\'width: 75px;\' type=\'text\' name=\'ApproveDate\"+rowCount+\"\' id=\'ApproveDate\"+rowCount+\"\' id=\'ApproveDate\"+rowCount+\"\' onblur=\'ModAppNo(this)\' value=\'\"+datetime+\"\' size=\'19\' maxlength=\'19\' ><img id=\'AppDateImg\"+rowCount+\"\' src=\'../../eCommon/images/CommonCalendar.gif\'  onclick=\\\"return showCalendar(\'ApproveDate\"+rowCount+\"\',null,\'hh:mm:ss\');\\\">\";//V201222 Modified\n\t\t}\n\t\telse if(i==13){\n\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'ServPrice\"+rowCount+\"\' id=\'ServPrice\"+rowCount+\"\' id=\'ServPrice\"+rowCount+\"\' onblur=\'isNo(this)\' onkeypress=\'return restrictAlphabets(event);\' value=\'\' >\";\n\t\t}\n\t\telse if(i==14){\n\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'InsAmt\"+rowCount+\"\' id=\'InsAmt\"+rowCount+\"\' id=\'InsAmt\"+rowCount+\"\' value=\'\' disabled>\";\n\t\t}\n\t\telse if(i==11){\n\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'ApproveNum\"+rowCount+\"\' id=\'ApproveNum\"+rowCount+\"\' id=\'ApproveNum\"+rowCount+\"\' maxlength=\'20\' value=\'\' ><input style=\'display:none;\' type=\'text\' id=\'serviceModAppNo\"+rowCount+\"\' value=\'N\' >\";\n\t\t}\n\t\telse if(i>=18){\n\t\t\tnewcell.innerHTML =\"<input type=\'text\' style=\'display:none;\' hidden>\";\n\t\t\tnewcell.style.display = table.rows[RowIndex].cells[i].style.display ; // to copy display style \n\t\t\t//newcell.className = \'hideCol\';\n\t\t}else if(i==9){\n\t\t\tnewcell.innerHTML =\"<input type=\'text\' class=\'gridDataInputLess\' maxlength=\'30\' contenteditable>\";\n\t\t}\n\t\telse if(i==2){\n\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInputLess\' type=\'text\' maxlength=\'100\' name=\'serviceTypeDesc\"+rowCount+\"\' id=\'serviceTypeDesc\"+rowCount+\"\' id=\'serviceTypeDesc\"+rowCount+\"\' value=\\\"\\\" ><input type=\'text\' style=\'display:none;\' id=\'preAppFlagID\"+rowCount+\"\' value=\\\"N\\\" hidden>\";\n\t\t}\n\t\telse{\n\t\t\tvar classname;\n\t\t\tif(i==2){\n\t\t\t\tclassname=\"gridDataInputLess\";\n\t\t\t\t\n\t\t\t}else{\n\t\t\t\tclassname=\"gridDataInput\";\n\t\t\t}\n\t\t\tnewcell.innerHTML =\"<input type=\'text\' class=\'\"+classname+\"\'  contenteditable>\";\n\t\t}\n\t\t\n\t\tswitch(newcell.childNodes[0].type) {\n\t\t\tcase \"text\":\n\t\t\t\t\tnewcell.childNodes[0].value = \"\";\n\t\t\t\t\tif(i==8){\n\t\t\t\t\t\tnewcell.childNodes[0].value = \"1\";\n\t\t\t\t\t}\n\t\t\t\t\tif(i==12){\n\t\t\t\t\t\tnewcell.childNodes[0].value = getCurrentDateTime();//V201015 Modified\n\t\t\t\t\t}\n\t\t\t\t\tif(i==0){\n\t\t\t\t\t\tnewcell.childNodes[0].value = visitAdmDatetime;\n\t\t\t\t\tdocument.getElementById(\'servDateHid\'+rowCount).value=visitAdmDatetime;\n\t\t\t\t\t}\n\t\t\t\t\tif(i==6){\n\t\t\t\t\tnewcell.childNodes[0].value = orderclinicianName;\n\t\t\t\t\tdocument.getElementById(\'orderClinicID\'+rowCount).value=orderclinicianID;\n\t\t\t\t\t}\n\t\t\t\t\tif(i==7){\n\t\t\t\t\tnewcell.childNodes[0].value = orderclinicianName;\n\t\t\t\t\tdocument.getElementById(\'performClinicID\'+rowCount).value=orderclinicianID;\n\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\tcase \"checkbox\":\n\t\t\t\t\tnewcell.childNodes[0].checked = false;\n\t\t\t\t\tif(i==15){\n\t\t\t\t\t\tnewcell.childNodes[0].checked = true;\n\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\tcase \"select-one\":\n\t\t\t\t\tnewcell.childNodes[0].selectedIndex = 1;\n\t\t\t\t\tbreak;\n\t\t}\n\t}\n}\n//Adding Row against Add row button Click\nfunction addRow(x) {\n\taddRowFlag=\"Y\";\n\tvar orderclinicianID;\n\tvar orderclinicianName;\n\tvar siteSpecPatPayable=document.getElementById(\'siteSpecPatPayable\').value;//V230222\n\t\n\tvar RowIndex=x.parentNode.parentNode.rowIndex;\n\tvar table = document.getElementById(\'serviceTable1\');\n\tvar rowCount = table.rows.length;\n\tvar row = table.insertRow(rowCount);\n\trow.setAttribute(\"id\",\"serviceRow\"+rowCount);\n\trow.onclick = function() {RowChange(this);}; // for IE\n\tvar colCount = table.rows[RowIndex].cells.length;\n\tfor(var i=0; i<colCount; i++) {\n\t\tvar newcell\t= row.insertCell(i);\n\t\t\n\t\t\tdatetime = getCurrentDateTime();//V201015 Modified\n\t\t\tvisitAdmDatetime = getCurrentDateTime();//V201015 Modified\n\t\tif(siteSpecPatPayable==\"true\" || siteSpecPatPayable==true){\n\t\t\t\tif(i==0){\t\n\t\t\t\t\tvisitAdmDatetime=getVisitAdmDate();//V201015 Modified\n\t\t\t\t\tnewcell.innerHTML =\"<input type=\'text\' class=\'gridDataInputMore\' onblur=\'validateDateTime(this)\' name=\'serviceDate\"+rowCount+\"\' id=\'serviceDate\"+rowCount+\"\' id=\'serviceDate\"+rowCount+\"\' value=\'\"+visitAdmDatetime+\"\' size=\'19\' maxlength=\'19\'><img src=\'../../eCommon/images/CommonCalendar.gif\'  onclick=\\\"return showCalendar(\'serviceDate\"+rowCount+\"\',null,\'hh:mm:ss\');\\\"><input type=\'hidden\' id=\'servDateHid\"+rowCount+\"\'value=\'\"+visitAdmDatetime+\"\'>\"; //V201222 Modified\n\t\t\t\t\t//newcell.className = \'gridData\';\n\t\t\t\t}\n\t\t\t\telse if(i==1){\n\t\t\t\tnewcell.innerHTML=\"<select name=\'servicetype\"+rowCount+\"\' id=\'servicetype\"+rowCount+\"\' id=\'servicetype\"+rowCount+\"\' onchange=\'DrugTypeChange(this)\'>\"    \n\t\t\t\t\t+\"<option value=\'Select\' >-Select-</option>\"\n\t\t\t\t\t+\"<option value=\'S\' selected>Service</option>\"\n\t\t\t\t\t+\"<option value=\'I\' >Drug</option>\"\n\t\t\t\t\t+\" </select>\";\n\t\t\t\t}\n\t\t\t\telse if(i==17){\n\t\t\t\tnewcell.innerHTML =\"<input type=\'checkbox\' name=\'Cancelcheck\"+rowCount+\"\' id=\'Cancelcheck\"+rowCount+\"\'  id=\'Cancelcheck\"+rowCount+\"\' onclick=\'CancelClick(this)\' value=\'\' /><input style=\'display:none;\' type=\'text\' id=\'serviceCancelRow\"+rowCount+\"\' value=\'\' ><input style=\'display:none;\' type=\'text\' id=\'primKeyModuleID\"+rowCount+\"\' value=\'\' >\";\n\t\t\t\t}\n\t\t\t\telse if(i==15){\n\t\t\t\t\tnewcell.innerHTML=\"<input type=\'checkbox\' name=\'checkboxBill\"+rowCount+\"\' id=\'checkboxBill\"+rowCount+\"\' value=\'checked\' id=\'checkboxBill\"+rowCount+\"\'  onclick=\'billClick(this)\' checked/><input style=\'display:none;\' type=\'text\' id=\'serviceBillCheck\"+rowCount+\"\'>\";\n\t\t\t\t}\n\t\t\t\telse if(i==16){\n\t\t\t\t\tnewcell.innerHTML = \"<input type=\'button\' name=\'AddBTn\"+rowCount+\"\' id=\'AddBTn\"+rowCount+\"\'  value=\'+\' onclick=\'addRow(this)\' id=\'AddBTn\"+rowCount+\"\'><input style=\'display:none;\' type=\'text\' id=\'serviceAddRow\"+rowCount+\"\' value=\'Y\' >\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\telse if(i==9){\n\t\t\t\t\t newcell.innerHTML = \"<input type=\'checkbox\' name=\'checkboxZero\"+rowCount+\"\' id=\'checkboxZero\"+rowCount+\"\' id=\'checkboxZero\"+rowCount+\"\' onclick=\'zeroPriceClick(this)\' />\";\n\t\t\t\t\t//newcell.className = \'gridData\';\n\t\t\t\t}\n\t\t\t\telse if(i==7){\n\t\t\t\t\t newcell.innerHTML = \"<input type=\'text\' class=\'gridDataInputLess\' style=\'width: 50px;\' onkeypress=\'return restrictAlphabets(event);\' onblur=\'validateServQty(this)\' id=\'serviceQty\"+rowCount+\"\' name=\'serviceQty\"+rowCount+\"\' id=\'serviceQty\"+rowCount+\"\' ><input type=\'text\'  style=\'display:none;\' id=\'serviceRateCharge\"+rowCount+\"\' value=\'\' >\";\n\t\t\t\t\t//newcell.className = \'gridData\';\n\t\t\t\t}\n\t\t\t\telse if(i==3){\n\t\t\t\t\tnewcell.innerHTML=\"<input type=\'text\' class=\'gridDataInput\' onblur=\'validateCPTCode(this)\' name=\'cptCode\"+rowCount+\"\' id=\'cptCode\"+rowCount+\"\' id=\'cptCode\"+rowCount+\"\' contenteditable><input type=\'hidden\' class=\'gridDataInput\' onblur=\'validateServCode(this)\' name=\'serviceCode\"+rowCount+\"\' id=\'serviceCode\"+rowCount+\"\' id=\'serviceCode\"+rowCount+\"\' contenteditable><input type=\'button\' class=\'button\' value=\'?\' onclick=\'callCPTSearch(this)\' name = \'servCodeLovButton\'> \";\n\t\t\t\t\t//newcell.className = \'gridData\';\n\t\t\t\t}\n\t\t\t\telse if(i==4){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInputMore\' type=\'text\' name=\'serviceDesc\"+rowCount+\"\' id=\'serviceDesc\"+rowCount+\"\' id=\'serviceDesc\"+rowCount+\"\' readonly  value=\'\' title=\'\'>\"; //V201222 Modified\n\t\t\t\t}\n\t\t\t\telse if(i==5){\n\t\t\t\t\t//Getting Ordering Clinician\n\t\t\t\t\tvar FacilityId = document.getElementById(\'FacilityId\').value;\n\t\t\t\t\tvar EncounterId = document.getElementById(\"+ServEncounterId+\").value;\n\t\t\t\t\tvar PatientID = document.getElementById(\'PatientID\').value;\n\t\t\t\t\tvar EpisodeId = document.getElementById(\'EpisodeId\').value;\n\t\t\t\t\tvar EpisodeType = document.getElementById(\'EpisodeType\').value;\n\t\t\t\t\tvar VisitID = document.getElementById(\'VisitID\').value;\n\t\t\t\t\tvar LangId=document.getElementById(\"locale\").value;\n\t\t\t\t\tvar params=\"&FacilityId=\"+FacilityId+\"&EpisodeType=\"+EpisodeType+\"&EncounterId=\"+EncounterId+\"&VisitID=\"+VisitID+\"&LangId=\"+LangId;\n\t\t\t\t\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=orderClinician\"+params;\n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest() ;\t\t\n\t\t\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\t\t\txmlHttp.send(\"\");\n\t\t\t\t\tvar responseText=xmlHttp.responseText;\n\t\t\t\t\tif(responseText!=\"\" && responseText!=null){\n\t\t\t\t\tvar strtIndex = responseText.indexOf(\"~\");\n\t\t\t\t\tif(strtIndex!=-1){\n\t\t\t\t\t\tvar res1 = responseText.substr(strtIndex+1);\n\t\t\t\t\t\tvar res = res1.split(\"~\");\n\t\t\t\t\t\torderclinicianID = res[0];\n\t\t\t\t\t\torderclinicianName=res[1];\n\t\t\t\t\t}else{\n\t\t\t\t\t\torderclinicianID = \"\";\n\t\t\t\t\t\torderclinicianName=\"\";\n\t\t\t\t\t}\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\tnewcell.innerHTML=\"<input type=\'text\' class=\'gridDataInput\' name=\'orderClinic\"+rowCount+\"\' id=\'orderClinic\"+rowCount+\"\' id=\'orderClinic\"+rowCount+\"\' contenteditable><input type=\'button\' class=\'button\' value=\'?\' onclick=\'orderingClinicianLookUp(this)\' name = \'OrderLovButton\'><input style=\'display:none;\' type=\'text\' id=\'orderClinicID\"+rowCount+\"\' value=\'\' > \";\n\t\t\t\t}\n\t\t\t\telse if(i==6){\n\t\t\t\t\tnewcell.innerHTML=\"<input type=\'text\' class=\'gridDataInput\' name=\'performClinic\"+rowCount+\"\' id=\'performClinic\"+rowCount+\"\' id=\'performClinic\"+rowCount+\"\' contenteditable><input type=\'button\' class=\'button\' value=\'?\' onclick=\'performingClinicianLookUp(this)\'  id=\'PerformLovButton\' name=\'PerformLovButton\' id=\'PerformLovButton\'><input style=\'display:none;\' type=\'text\' id=\'performClinicID\"+rowCount+\"\' value=\'\'><input style=\'display:none;\' type=\'text\' id=\'modifyYN\"+rowCount+\"\' value=\'N\' >\";\n\t\t\t\t}\n\t\t\t\telse if(i==11){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' style=\'width: 75px;\' type=\'text\' name=\'ApproveDate\"+rowCount+\"\' id=\'ApproveDate\"+rowCount+\"\' id=\'ApproveDate\"+rowCount+\"\' onblur=\'ModAppNo(this)\' value=\'\"+datetime+\"\' size=\'19\' maxlength=\'19\' ><img id=\'AppDateImg\"+rowCount+\"\' src=\'../../eCommon/images/CommonCalendar.gif\'  onclick=\\\"return showCalendar(\'ApproveDate\"+rowCount+\"\',null,\'hh:mm:ss\');\\\">\";//V201222 Modified\n\t\t\t\t}\n\t\t\t\telse if(i==12){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'ServPrice\"+rowCount+\"\' id=\'ServPrice\"+rowCount+\"\' id=\'ServPrice\"+rowCount+\"\' onblur=\'isNo(this)\' onkeypress=\'return restrictAlphabets(event);\' value=\'\' >\";\n\t\t\t\t}\n\t\t\t\telse if(i==13){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'InsAmt\"+rowCount+\"\' id=\'InsAmt\"+rowCount+\"\' id=\'InsAmt\"+rowCount+\"\'  value=\'\' disabled>\";\n\t\t\t\t\t\n\t\t\t\t}else if(i==14){\n\t\t\t\t\tif(siteSpecPatPayable==true || siteSpecPatPayable==\"true\"){\n\t\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'patPay\"+rowCount+\"\' id=\'patPay\"+rowCount+\"\' id=\'patPay\"+rowCount+\"\' value=\'0.0\' disabled>\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(i==10){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'ApproveNum\"+rowCount+\"\' id=\'ApproveNum\"+rowCount+\"\' id=\'ApproveNum\"+rowCount+\"\' maxlength=\'20\' value=\'\' ><input style=\'display:none;\' type=\'text\' id=\'serviceModAppNo\"+rowCount+\"\' value=\'N\' >\";\n\t\t\t\t}\n\t\t\t\telse if(i>=18){\n\t\t\t\t\tnewcell.innerHTML =\"<input type=\'text\' style=\'display:none;\' hidden>\";\n\t\t\t\t\tnewcell.style.display = table.rows[RowIndex].cells[i].style.display ; // to copy display style \n\t\t\t\t\t//newcell.className = \'hideCol\';\n\t\t\t\t}else if(i==8){\n\t\t\t\t\tnewcell.innerHTML =\"<input type=\'text\' class=\'gridDataInputLess\' maxlength=\'30\' contenteditable>\";\n\t\t\t\t}\n\t\t\t\telse if(i==2){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInputLess\' type=\'text\' maxlength=\'100\' name=\'serviceTypeDesc\"+rowCount+\"\' id=\'serviceTypeDesc\"+rowCount+\"\' id=\'serviceTypeDesc\"+rowCount+\"\' value=\\\"\\\" ><input type=\'text\' style=\'display:none;\' id=\'preAppFlagID\"+rowCount+\"\' value=\\\"N\\\" hidden>\";\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tvar classname;\n\t\t\t\t\tif(i==2){\n\t\t\t\t\t\tclassname=\"gridDataInputLess\";\n\t\t\t\t\t\t\n\t\t\t\t\t}else{\n\t\t\t\t\t\tclassname=\"gridDataInput\";\n\t\t\t\t\t}\n\t\t\t\t\tnewcell.innerHTML =\"<input type=\'text\' class=\'\"+classname+\"\'  contenteditable>\";\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\tif(i==0){\t\n\t\t\t\tvisitAdmDatetime=getVisitAdmDate();//V201015 Modified\n\t\t\t\tnewcell.innerHTML =\"<input type=\'text\' class=\'gridDataInputMore\' onblur=\'validateDateTime(this)\' name=\'serviceDate\"+rowCount+\"\' id=\'serviceDate\"+rowCount+\"\' id=\'serviceDate\"+rowCount+\"\' value=\'\"+visitAdmDatetime+\"\' size=\'19\' maxlength=\'19\'><img src=\'../../eCommon/images/CommonCalendar.gif\'  onclick=\\\"return showCalendar(\'serviceDate\"+rowCount+\"\',null,\'hh:mm:ss\');\\\"><input type=\'hidden\' id=\'servDateHid\"+rowCount+\"\'value=\'\"+visitAdmDatetime+\"\'>\"; //V201222 Modified\n\t\t\t\t\t//newcell.className = \'gridData\';\n\t\t\t\t}\n\t\t\t\telse if(i==1){\n\t\t\t\tnewcell.innerHTML=\"<select name=\'servicetype\"+rowCount+\"\' id=\'servicetype\"+rowCount+\"\' id=\'servicetype\"+rowCount+\"\' onchange=\'DrugTypeChange(this)\'>\"    \n\t\t\t\t\t+\"<option value=\'Select\' >-Select-</option>\"\n\t\t\t\t\t+\"<option value=\'S\' selected>Service</option>\"\n\t\t\t\t\t+\"<option value=\'I\' >Drug</option>\"\n\t\t\t\t\t+\" </select>\";\n\t\t\t\t}\n\t\t\t\telse if(i==16+j){\n\t\t\t\tnewcell.innerHTML =\"<input type=\'checkbox\' name=\'Cancelcheck\"+rowCount+\"\' id=\'Cancelcheck\"+rowCount+\"\'  id=\'Cancelcheck\"+rowCount+\"\' onclick=\'CancelClick(this)\' value=\'\' /><input style=\'display:none;\' type=\'text\' id=\'serviceCancelRow\"+rowCount+\"\' value=\'\' ><input style=\'display:none;\' type=\'text\' id=\'primKeyModuleID\"+rowCount+\"\' value=\'\' >\";\n\t\t\t\t}\n\t\t\t\telse if(i==14+j){\n\t\t\t\t\tnewcell.innerHTML=\"<input type=\'checkbox\' name=\'checkboxBill\"+rowCount+\"\' id=\'checkboxBill\"+rowCount+\"\' value=\'checked\' id=\'checkboxBill\"+rowCount+\"\'  onclick=\'billClick(this)\' checked/><input style=\'display:none;\' type=\'text\' id=\'serviceBillCheck\"+rowCount+\"\'>\";\n\t\t\t\t}\n\t\t\t\telse if(i==15+j){\n\t\t\t\t\tnewcell.innerHTML = \"<input type=\'button\' name=\'AddBTn\"+rowCount+\"\' id=\'AddBTn\"+rowCount+\"\'  value=\'+\' onclick=\'addRow(this)\' id=\'AddBTn\"+rowCount+\"\'><input style=\'display:none;\' type=\'text\' id=\'serviceAddRow\"+rowCount+\"\' value=\'Y\' >\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\telse if(i==9){\n\t\t\t\t\t newcell.innerHTML = \"<input type=\'checkbox\' name=\'checkboxZero\"+rowCount+\"\' id=\'checkboxZero\"+rowCount+\"\' id=\'checkboxZero\"+rowCount+\"\' onclick=\'zeroPriceClick(this)\' />\";\n\t\t\t\t\t//newcell.className = \'gridData\';\n\t\t\t\t}\n\t\t\t\telse if(i==7){\n\t\t\t\t\t newcell.innerHTML = \"<input type=\'text\' class=\'gridDataInputLess\' style=\'width: 50px;\' onkeypress=\'return restrictAlphabets(event);\' onblur=\'validateServQty(this)\' id=\'serviceQty\"+rowCount+\"\' name=\'serviceQty\"+rowCount+\"\' id=\'serviceQty\"+rowCount+\"\' ><input type=\'text\'  style=\'display:none;\' id=\'serviceRateCharge\"+rowCount+\"\' value=\'\' >\";\n\t\t\t\t\t//newcell.className = \'gridData\';\n\t\t\t\t}\n\t\t\t\telse if(i==3){\n\t\t\t\t\tnewcell.innerHTML=\"<input type=\'text\' class=\'gridDataInput\' onblur=\'validateCPTCode(this)\' name=\'cptCode\"+rowCount+\"\' id=\'cptCode\"+rowCount+\"\' id=\'cptCode\"+rowCount+\"\' contenteditable><input type=\'hidden\' class=\'gridDataInput\' onblur=\'validateServCode(this)\' name=\'serviceCode\"+rowCount+\"\' id=\'serviceCode\"+rowCount+\"\' id=\'serviceCode\"+rowCount+\"\' contenteditable><input type=\'button\' class=\'button\' value=\'?\' onclick=\'callCPTSearch(this)\' name = \'servCodeLovButton\'> \";\n\t\t\t\t\t//newcell.className = \'gridData\';\n\t\t\t\t}\n\t\t\t\telse if(i==4){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInputMore\' type=\'text\' name=\'serviceDesc\"+rowCount+\"\' id=\'serviceDesc\"+rowCount+\"\' id=\'serviceDesc\"+rowCount+\"\' readonly>\"; //V201222 Modified\n\t\t\t\t}\n\t\t\t\telse if(i==5){\n\t\t\t\t\t//Getting Ordering Clinician\n\t\t\t\t\tvar FacilityId = document.getElementById(\'FacilityId\').value;\n\t\t\t\t\tvar EncounterId = document.getElementById(\"+ServEncounterId+\").value;\n\t\t\t\t\tvar PatientID = document.getElementById(\'PatientID\').value;\n\t\t\t\t\tvar EpisodeId = document.getElementById(\'EpisodeId\').value;\n\t\t\t\t\tvar EpisodeType = document.getElementById(\'EpisodeType\').value;\n\t\t\t\t\tvar VisitID = document.getElementById(\'VisitID\').value;\n\t\t\t\t\tvar LangId=document.getElementById(\"locale\").value;\n\t\t\t\t\tvar params=\"&FacilityId=\"+FacilityId+\"&EpisodeType=\"+EpisodeType+\"&EncounterId=\"+EncounterId+\"&VisitID=\"+VisitID+\"&LangId=\"+LangId;\n\t\t\t\t\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=orderClinician\"+params;\n\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\tvar xmlHttp = new XMLHttpRequest() ;\t\t\n\t\t\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\t\t\txmlHttp.send(\"\");\n\t\t\t\t\tvar responseText=xmlHttp.responseText;\n\t\t\t\t\tif(responseText!=\"\" && responseText!=null){\n\t\t\t\t\tvar strtIndex = responseText.indexOf(\"~\");\n\t\t\t\t\tif(strtIndex!=-1){\n\t\t\t\t\t\tvar res1 = responseText.substr(strtIndex+1);\n\t\t\t\t\t\tvar res = res1.split(\"~\");\n\t\t\t\t\t\torderclinicianID = res[0];\n\t\t\t\t\t\torderclinicianName=res[1];\n\t\t\t\t\t}else{\n\t\t\t\t\t\torderclinicianID = \"\";\n\t\t\t\t\t\torderclinicianName=\"\";\n\t\t\t\t\t}\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\tnewcell.innerHTML=\"<input type=\'text\' class=\'gridDataInput\' name=\'orderClinic\"+rowCount+\"\' id=\'orderClinic\"+rowCount+\"\' id=\'orderClinic\"+rowCount+\"\' contenteditable><input type=\'button\' class=\'button\' value=\'?\' onclick=\'orderingClinicianLookUp(this)\' name = \'OrderLovButton\'><input style=\'display:none;\' type=\'text\' id=\'orderClinicID\"+rowCount+\"\' value=\'\' > \";\n\t\t\t\t}\n\t\t\t\telse if(i==6){\n\t\t\t\t\tnewcell.innerHTML=\"<input type=\'text\' class=\'gridDataInput\' name=\'performClinic\"+rowCount+\"\' id=\'performClinic\"+rowCount+\"\' id=\'performClinic\"+rowCount+\"\' contenteditable><input type=\'button\' class=\'button\' value=\'?\' onclick=\'performingClinicianLookUp(this)\'  id=\'PerformLovButton\' name=\'PerformLovButton\' id=\'PerformLovButton\'><input style=\'display:none;\' type=\'text\' id=\'performClinicID\"+rowCount+\"\' value=\'\'><input style=\'display:none;\' type=\'text\' id=\'modifyYN\"+rowCount+\"\' value=\'N\' >\";\n\t\t\t\t}\n\t\t\t\telse if(i==11){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' style=\'width: 75px;\' type=\'text\' name=\'ApproveDate\"+rowCount+\"\' id=\'ApproveDate\"+rowCount+\"\' id=\'ApproveDate\"+rowCount+\"\' onblur=\'ModAppNo(this)\' value=\'\"+datetime+\"\' size=\'19\' maxlength=\'19\' ><img id=\'AppDateImg\"+rowCount+\"\' src=\'../../eCommon/images/CommonCalendar.gif\'  onclick=\\\"return showCalendar(\'ApproveDate\"+rowCount+\"\',null,\'hh:mm:ss\');\\\">\";//V201222 Modified\n\t\t\t\t}\n\t\t\t\telse if(i==12){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'ServPrice\"+rowCount+\"\' id=\'ServPrice\"+rowCount+\"\' id=\'ServPrice\"+rowCount+\"\' onblur=\'isNo(this)\' onkeypress=\'return restrictAlphabets(event);\' value=\'\' >\";\n\t\t\t\t}\n\t\t\t\telse if(i==13){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'InsAmt\"+rowCount+\"\' id=\'InsAmt\"+rowCount+\"\' id=\'InsAmt\"+rowCount+\"\'  value=\'\' disabled>\";\n\t\t\t\t\t\n\t\t\t\t}else if(i==13+j){\n\t\t\t\t\tif(siteSpecPatPayable==true || siteSpecPatPayable==\"true\"){\n\t\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'patPay\"+rowCount+\"\' id=\'patPay\"+rowCount+\"\' id=\'patPay\"+rowCount+\"\' value=\'0.0\' disabled>\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(i==10){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInput\' type=\'text\' name=\'ApproveNum\"+rowCount+\"\' id=\'ApproveNum\"+rowCount+\"\' id=\'ApproveNum\"+rowCount+\"\' maxlength=\'20\' value=\'\' ><input style=\'display:none;\' type=\'text\' id=\'serviceModAppNo\"+rowCount+\"\' value=\'N\' >\";\n\t\t\t\t}\n\t\t\t\telse if(i>=17+j){\n\t\t\t\t\tnewcell.innerHTML =\"<input type=\'text\' style=\'display:none;\' hidden>\";\n\t\t\t\t\tnewcell.style.display = table.rows[RowIndex].cells[i].style.display ; // to copy display style \n\t\t\t\t\t//newcell.className = \'hideCol\';\n\t\t\t\t}else if(i==8){\n\t\t\t\t\tnewcell.innerHTML =\"<input type=\'text\' class=\'gridDataInputLess\' maxlength=\'30\' contenteditable>\";\n\t\t\t\t}\n\t\t\t\telse if(i==2){\n\t\t\t\t\tnewcell.innerHTML=\"<input class=\'gridDataInputLess\' type=\'text\' maxlength=\'100\' name=\'serviceTypeDesc\"+rowCount+\"\' id=\'serviceTypeDesc\"+rowCount+\"\' id=\'serviceTypeDesc\"+rowCount+\"\' value=\\\"\\\" ><input type=\'text\' style=\'display:none;\' id=\'preAppFlagID\"+rowCount+\"\' value=\\\"N\\\" hidden>\";\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tvar classname;\n\t\t\t\t\tif(i==2){\n\t\t\t\t\t\tclassname=\"gridDataInputLess\";\n\t\t\t\t\t\t\n\t\t\t\t\t}else{\n\t\t\t\t\t\tclassname=\"gridDataInput\";\n\t\t\t\t\t}\n\t\t\t\t\tnewcell.innerHTML =\"<input type=\'text\' class=\'\"+classname+\"\'  contenteditable>\";\n\t\t\t\t}\n\t\t\t}\n\t\tswitch(newcell.childNodes[0].type) {\n\t\t\tcase \"text\":\n\t\t\t\t\tnewcell.childNodes[0].value = \"\";\n\t\t\t\t\tif(i==7){\n\t\t\t\t\t\tnewcell.childNodes[0].value = \"1\";\n\t\t\t\t\t}\n\t\t\t\t\tif(i==11){\n\t\t\t\t\t\tnewcell.childNodes[0].value = getCurrentDateTime();//V201015 Modified\n\t\t\t\t\t}\n\t\t\t\t\tif(i==0){\n\t\t\t\t\t\tnewcell.childNodes[0].value = visitAdmDatetime;\n\t\t\t\t\tdocument.getElementById(\'servDateHid\'+rowCount).value=visitAdmDatetime;\n\t\t\t\t\t}\n\t\t\t\t\tif(i==5){\n\t\t\t\t\tnewcell.childNodes[0].value = orderclinicianName;\n\t\t\t\t\tdocument.getElementById(\'orderClinicID\'+rowCount).value=orderclinicianID;\n\t\t\t\t\t}\n\t\t\t\t\tif(i==6){\n\t\t\t\t\tnewcell.childNodes[0].value = orderclinicianName;\n\t\t\t\t\tdocument.getElementById(\'performClinicID\'+rowCount).value=orderclinicianID;\n\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\tcase \"checkbox\":\n\t\t\t\t\tnewcell.childNodes[0].checked = false;\n\t\t\t\t\tif(i==14){\n\t\t\t\t\t\tnewcell.childNodes[0].checked = true;\n\t\t\t\t\t}\n\t\t\t\t\tbreak;\n\t\t\tcase \"select-one\":\n\t\t\t\t\tnewcell.childNodes[0].selectedIndex = 1;\n\t\t\t\t\tbreak;\n\t\t}\n\t}\n}\n\n//Drug/Non-Drug Change Event\nfunction DrugTypeChange(x){\n\tvar siteSpecPatPayable=document.getElementById(\'siteSpecPatPayable\').value;//V230222\n\tvar RowIndex=x.parentNode.parentNode.rowIndex;\n\tdocument.getElementById(\"cptCode\"+RowIndex).value=\"\";\t\t \n\tdocument.getElementById(\"serviceCode\"+RowIndex).value=\"\";\n\tdocument.getElementById(\"serviceDesc\"+RowIndex).value=\"\";\n\tdocument.getElementById(\"ServPrice\"+RowIndex).value=\"\";\n\tdocument.getElementById(\"InsAmt\"+RowIndex).value=\"\";\n\tdocument.getElementById(\"serviceQty\"+RowIndex).value=\"1\";\n\tif(x.value==\"I\"){\n\t\tdocument.getElementById(\'serviceTypeDesc\'+RowIndex).value=\"Drug\";\n\t}else{\n\t\tdocument.getElementById(\'serviceTypeDesc\'+RowIndex).value=\"\";\n\t}\n\tif(siteSpecPatPayable==true || siteSpecPatPayable==\"true\"){\n\t\tdocument.getElementById(\'patPay\'+RowIndex).value=\"\";\n\t}//V230222\n}\n\n//Function Formload event\nfunction onLoadServiceEdit() {\n\t\t\n\t//Making Editable Functionlaity bas ed on billable check box\n\ttry{\n\t\tvar table = document.getElementById(\'serviceTable1\');\n\t\tvar serviceSize = document.getElementById(\'serviceSize\').value;//V201015 Added\n\t\tvar rowCount = table.rows.length;\n\t\tvar siteSpecServiceCode=document.getElementById(\'siteSpecServiceCode\').value;\n\t\tvar siteSpecPatPayable=document.getElementById(\'siteSpecPatPayable\').value;//V230222\n\t\t//V201015 Starts\n\t\t//New row Condition\n\t\tif(serviceSize==0){\n\t\t\taddRowFlag=\"Y\";\n\t\t\t//Date Time Value From DB\n\t\t\tdocument.getElementById(\'serviceDate1\').value=getVisitAdmDate();//V201015 Modified\n\t\t\t//Approval Date\n\t\t\tdocument.getElementById(\'ApproveDate1\').value=getCurrentDateTime();//V201015 Modified\n\t\t}//V201015 Ends\n\t\telse{\n\t\tif(siteSpecServiceCode == \"true\"){\n\t\t// var i=1 to start after header\n\t\tfor(var j=rowCount-1; j>0; j--) {\n\t\t\tvar colCount = table.rows[j].cells.length;\n\t\t\t//Disabling based on cancel service\n\t\t\tvar Cancelchkbox = table.rows[j].cells[17].getElementsByTagName(\'input\')[0];\n\t\t\tif(\'checkbox\' == Cancelchkbox.type && true == Cancelchkbox.checked){\n\t\t\t\tfor(var k=0; k<colCount; k++){\n\t\t\t\t\tif(k==13 || k==14){\n\t\t\t\t\t\tvar colDecVal = table.rows[j].cells[k].childNodes[0].value;\n\t\t\t\t\t\ttable.rows[j].cells[k].childNodes[0].value=parseFloat(colDecVal).toFixed(2);\n\t\t\t\t\t}\n\t\t\t\t\tif(k!=16){\n\t\t\t\t\tif(\'checkbox\' == Cancelchkbox.type && true == Cancelchkbox.checked) {\n\t\t\t\t\t\tvar str=table.rows[j].cells[k].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<IMG\", \"<IMG disabled\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"<SELECT\", \"<SELECT disabled\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[k].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[k].className=\'unselectable\';\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar str=table.rows[j].cells[k].innerHTML;\n\t\t\t\t\t\tvar res;\t\t\t\t\t\t\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[k].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[k].className=\'selectable\';\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\t//var chkbox = table.rows[j].cells[14].getElementsByTagName(\'input\')[0];\n\t\t\t\tvar getBillVal=document.getElementById(\'serviceBillCheck\'+j).value;\n\t\t\t\tfor(var i=0; i<colCount; i++) {\n\t\t\t\t\tif(i==13 || i==14){\n\t\t\t\t\t\tvar colDecVal = table.rows[j].cells[i].childNodes[0].value;\n\t\t\t\t\t\ttable.rows[j].cells[i].childNodes[0].value=parseFloat(colDecVal).toFixed(2);\n\t\t\t\t\t}\n\t\t\t\t//if(i!=16 && i!=15){//Commented against AAKH-SCF-0484\n\t\t\t\tif(i!=16){//Added against AAKH-SCF-0484\n\t\t\t\t\tif(getBillVal==\"checked\") {\n\t\t\t\t\t\tvar str=table.rows[j].cells[i].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<IMG\", \"<IMG disabled\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"<SELECT\", \"<SELECT disabled\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[i].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[i].className=\'unselectable\';\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t//if(i==1|| i==2|| i==3|| i==4|| i==5|| i==7|| i==8|| i==12|| i==13)\n\t\t\t\t\t\tif(i==1|| i==2|| i==3|| i==4|| i==5|| i==6 || i==8|| i==9|| i==13|| i==14){\n\t\t\t\t\t\t\tvar str=table.rows[j].cells[i].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<IMG\", \"<IMG disabled\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"<SELECT\", \"<SELECT disabled\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[i].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[i].className=\'unselectable\';\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\tvar str=table.rows[j].cells[i].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[i].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[i].className=\'selectable\';\n\t\t\t\t\t}\t\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t}\n\t\t\t//Disabling Approve Numebr and Date based on Rate Charge Flag\n\t\t\tvar preApFlag=document.getElementById(\'preAppFlagID\'+j).value;\n\t\t\t\tif(preApFlag==\"N\"){\n\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+j).value = \"\";\n\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+j).value = \"\";\n\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+j).disabled = true;\n\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+j).disabled = true;\n\t\t\t\t\tdocument.getElementById(\"AppDateImg\"+j).disabled = true;\n\t\t\t\t}\n\t\t\t\telse if(preApFlag==\"Y\"){\n\t\t\t\t\tvar appDateValue=document.getElementById(\'ApproveDate\'+j).value;\n\t\t\t\t\tvar appNoValue=document.getElementById(\'ApproveNum\'+j).value;\n\t\t\t\t\tif(appDateValue!=null && appDateValue!=\"\"){\n\t\t\t\t\t\tdocument.getElementById(\'appDateHid\'+j).value=appDateValue;\n\t\t\t\t\t}\n\t\t\t\t\tif(appNoValue!=null && appNoValue!=\"\"){\n\t\t\t\t\t\tdocument.getElementById(\'appNoHid\'+j).value=appNoValue;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t}\n\t\t\telse if(siteSpecPatPayable==true || siteSpecPatPayable==\"true\"){\n\t\t\t\tfor(var j=rowCount-1; j>0; j--) {\n\t\t\tvar colCount = table.rows[j].cells.length;\n\t\t\t//Disabling based on cancel service\n\t\t\tvar Cancelchkbox = table.rows[j].cells[17].getElementsByTagName(\'input\')[0];\n\t\t\tif(\'checkbox\' == Cancelchkbox.type && true == Cancelchkbox.checked){\n\t\t\t\tfor(var k=0; k<colCount; k++){\n\t\t\t\t\tif(k==12 || k==13 ||k==14){\n\t\t\t\t\t\tvar colDecVal = table.rows[j].cells[k].childNodes[0].value;\n\t\t\t\t\t\ttable.rows[j].cells[k].childNodes[0].value=parseFloat(colDecVal).toFixed(2);\n\t\t\t\t\t}\n\t\t\t\t\tif(k!=16){\n\t\t\t\t\tif(\'checkbox\' == Cancelchkbox.type && true == Cancelchkbox.checked) {\n\t\t\t\t\t\tvar str=table.rows[j].cells[k].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<IMG\", \"<IMG disabled\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"<SELECT\", \"<SELECT disabled\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[k].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[k].className=\'unselectable\';\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar str=table.rows[j].cells[k].innerHTML;\n\t\t\t\t\t\tvar res;\t\t\t\t\t\t\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[k].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[k].className=\'selectable\';\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\t//var chkbox = table.rows[j].cells[14].getElementsByTagName(\'input\')[0];\n\t\t\t\tvar getBillVal=document.getElementById(\'serviceBillCheck\'+j).value;\n\t\t\t\tfor(var i=0; i<colCount; i++) {\n\t\t\t\t\t\n\t\t\t\t\tif(i==12 || i==13 || i==14){\n\t\t\t\t\t\tvar colDecVal = table.rows[j].cells[i].childNodes[0].value;\n\t\t\t\t\t\ttable.rows[j].cells[i].childNodes[0].value=parseFloat(colDecVal).toFixed(2);\n\t\t\t\t\t}\n\t\t\t\t//if(i!=16 && i!=15){//Commented against AAKH-SCF-0484\n\t\t\t\tif(i!=16){//Added against AAKH-SCF-0484\n\t\t\t\t\tif(getBillVal==\"checked\") {\n\t\t\t\t\t\tvar str=table.rows[j].cells[i].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<IMG\", \"<IMG disabled\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"<SELECT\", \"<SELECT disabled\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[i].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[i].className=\'unselectable\';\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tif(i==1|| i==2|| i==3|| i==4|| i==5|| i==7|| i==8|| i==12|| i==13 || i==14){\n\t\t\t\t\t\t\tvar str=table.rows[j].cells[i].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<IMG\", \"<IMG disabled\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"<SELECT\", \"<SELECT disabled\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[i].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[i].className=\'unselectable\';\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\tvar str=table.rows[j].cells[i].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[i].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[i].className=\'selectable\';\n\t\t\t\t\t}\t\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t}\n\t\t\t//Disabling Approve Numebr and Date based on Rate Charge Flag\n\t\t\tvar preApFlag=document.getElementById(\'preAppFlagID\'+j).value;\n\t\t\t\tif(preApFlag==\"N\"){\n\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+j).value = \"\";\n\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+j).value = \"\";\n\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+j).disabled = true;\n\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+j).disabled = true;\n\t\t\t\t\tdocument.getElementById(\"AppDateImg\"+j).disabled = true;\n\t\t\t\t}\n\t\t\t\telse if(preApFlag==\"Y\"){\n\t\t\t\t\tvar appDateValue=document.getElementById(\'ApproveDate\'+j).value;\n\t\t\t\t\tvar appNoValue=document.getElementById(\'ApproveNum\'+j).value;\n\t\t\t\t\tif(appDateValue!=null && appDateValue!=\"\"){\n\t\t\t\t\t\tdocument.getElementById(\'appDateHid\'+j).value=appDateValue;\n\t\t\t\t\t}\n\t\t\t\t\tif(appNoValue!=null && appNoValue!=\"\"){\n\t\t\t\t\t\tdocument.getElementById(\'appNoHid\'+j).value=appNoValue;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t  } //V230222\n\t\t\telse\n\t\t\t{\n\t\t\t\tfor(var j=rowCount-1; j>0; j--) {\n\t\t\tvar colCount = table.rows[j].cells.length;\n\t\t\t//Disabling based on cancel service\n\t\t\tvar Cancelchkbox = table.rows[j].cells[16].getElementsByTagName(\'input\')[0];\n\t\t\tif(\'checkbox\' == Cancelchkbox.type && true == Cancelchkbox.checked){\n\t\t\t\tfor(var k=0; k<colCount; k++){\n\t\t\t\t\tif(k==12 || k==13){\n\t\t\t\t\t\tvar colDecVal = table.rows[j].cells[k].childNodes[0].value;\n\t\t\t\t\t\ttable.rows[j].cells[k].childNodes[0].value=parseFloat(colDecVal).toFixed(2);\n\t\t\t\t\t}\n\t\t\t\t\tif(k!=15){\n\t\t\t\t\tif(\'checkbox\' == Cancelchkbox.type && true == Cancelchkbox.checked) {\n\t\t\t\t\t\tvar str=table.rows[j].cells[k].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<IMG\", \"<IMG disabled\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"<SELECT\", \"<SELECT disabled\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[k].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[k].className=\'unselectable\';\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar str=table.rows[j].cells[k].innerHTML;\n\t\t\t\t\t\tvar res;\t\t\t\t\t\t\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[k].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[k].className=\'selectable\';\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}else{\n\t\t\t\t//var chkbox = table.rows[j].cells[14].getElementsByTagName(\'input\')[0];\n\t\t\t\tvar getBillVal=document.getElementById(\'serviceBillCheck\'+j).value;\n\t\t\t\tfor(var i=0; i<colCount; i++) {\n\t\t\t\t\tif(i==12 || i==13){\n\t\t\t\t\t\tvar colDecVal = table.rows[j].cells[i].childNodes[0].value;\n\t\t\t\t\t\ttable.rows[j].cells[i].childNodes[0].value=parseFloat(colDecVal).toFixed(2);\n\t\t\t\t\t}\n\t\t\t\t//if(i!=16 && i!=15){//Commented against AAKH-SCF-0484\n\t\t\t\tif(i!=15){//Added against AAKH-SCF-0484\n\t\t\t\t\tif(getBillVal==\"checked\") {\n\t\t\t\t\t\tvar str=table.rows[j].cells[i].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<IMG\", \"<IMG disabled\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"<SELECT\", \"<SELECT disabled\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[i].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[i].className=\'unselectable\';\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tif(i==1|| i==2|| i==3|| i==4|| i==5|| i==7|| i==8|| i==12|| i==13){\n\t\t\t\t\t\t\tvar str=table.rows[j].cells[i].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<IMG\", \"<IMG disabled\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"<SELECT\", \"<SELECT disabled\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[i].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[i].className=\'unselectable\';\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\tvar str=table.rows[j].cells[i].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[i].innerHTML=res;\n\t\t\t\t\t\t//table.rows[j].cells[i].className=\'selectable\';\n\t\t\t\t\t}\t\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t}\n\t\t\t//Disabling Approve Numebr and Date based on Rate Charge Flag\n\t\t\tvar preApFlag=document.getElementById(\'preAppFlagID\'+j).value;\n\t\t\t\tif(preApFlag==\"N\"){\n\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+j).value = \"\";\n\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+j).value = \"\";\n\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+j).disabled = true;\n\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+j).disabled = true;\n\t\t\t\t\tdocument.getElementById(\"AppDateImg\"+j).disabled = true;\n\t\t\t\t}\n\t\t\t\telse if(preApFlag==\"Y\"){\n\t\t\t\t\tvar appDateValue=document.getElementById(\'ApproveDate\'+j).value;\n\t\t\t\t\tvar appNoValue=document.getElementById(\'ApproveNum\'+j).value;\n\t\t\t\t\tif(appDateValue!=null && appDateValue!=\"\"){\n\t\t\t\t\t\tdocument.getElementById(\'appDateHid\'+j).value=appDateValue;\n\t\t\t\t\t}\n\t\t\t\t\tif(appNoValue!=null && appNoValue!=\"\"){\n\t\t\t\t\t\tdocument.getElementById(\'appNoHid\'+j).value=appNoValue;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t  }\n\t\t}\n\t}catch(e){\n\t\t\talert(\"Exception in Editable functionality against billable checkbox Row \"+e);\n\t\t}\n}\n \n//Save Function\nfunction SaveServices() {\ntry{\n\t//document.getElementById(\"Save3\").disabled = true;//V201015\n\tvar table = document.getElementById(\'serviceTable1\');\n\tvar SesId=document.getElementById(\'SessionId\').value;\n\tvar siteSpecServiceCode=document.getElementById(\'siteSpecServiceCode\').value;\n\tvar FacilityId = document.getElementById(\'FacilityId\').value;\n\tvar ServEncounterId = document.getElementById(\"+ServEncounterId+\").value;\n\tvar PatientID = document.getElementById(\'PatientID\').value;\n\tvar EpisodeId = document.getElementById(\'EpisodeId\').value;\n\tvar EpisodeType = document.getElementById(\'EpisodeType\').value;\n\tvar VisitID = document.getElementById(\'VisitID\').value;\n\tvar rowCount = table.rows.length;\t\n\tvar WS_NO = document.getElementById(\'logInWSno\').value;\t\t\n\tvar loginUser = document.getElementById(\'logInUserId\').value;\n\tdataArr=ArrNoDupe(dataArr);\n\tfor (r = 0; r < dataArr.length; r++) {\n\t\tvar dataArrId= document.getElementById(dataArr[r]);\n\t\tvar appModFlag = document.getElementById(\'serviceModAppNo\'+dataArrId.rowIndex).value;\n\t\tvar addNewRowFlag = document.getElementById(\'serviceAddRow\'+dataArrId.rowIndex).value;\n\t\tvar preAppFlag= document.getElementById(\'preAppFlagID\'+dataArrId.rowIndex).value;\n\t\tvar appNumber= document.getElementById(\"ApproveNum\"+dataArrId.rowIndex).value;\n\t\tvar appDate= document.getElementById(\"ApproveDate\"+dataArrId.rowIndex).value;\n\t\tvar cptCodeVal=trimString(document.getElementById(\"cptCode\"+dataArrId.rowIndex).value);\n\t\tvar servCodeVal=document.getElementById(\"serviceCode\"+dataArrId.rowIndex).value;\n\t\tif(appModFlag==\"Y\" || addNewRowFlag==\"Y\"){\n\t\t\tif(preAppFlag==\"Y\"){\n\t\t\t\tif(appNumber==\"\" || appNumber==null){\n\t\t\t\t\tif(cptCodeVal!=\"\" && cptCodeVal!=null){\n\t\t\t\t\t\talert(\"Approval Number required for the service \"+cptCodeVal);\n\t\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+dataArrId.rowIndex).focus();\n\t\t\t\t\t\tdocument.getElementById(\"Save3\").disabled = false;//V201015\n\t\t\t\t\t\tdocument.getElementById(\'Save3\').style.opacity=\'0\';\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}else if((cptCodeVal==\"\" || cptCodeVal==null) && (servCodeVal!=\"\" && servCodeVal!=null)){\n\t\t\t\t\t\talert(\"Approval Number required for the service \"+servCodeVal);\n\t\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+dataArrId.rowIndex).focus();\n\t\t\t\t\t\tdocument.getElementById(\"Save3\").disabled = false;//V201015\n\t\t\t\t\t\tdocument.getElementById(\'Save3\').style.opacity=\'0\';\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}else if(appDate==\"\" || appDate==null){\n\t\t\t\t\tif(cptCodeVal!=\"\" && cptCodeVal!=null){\n\t\t\t\t\t\talert(\"Approval Date required for the service \"+cptCodeVal);\n\t\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+dataArrId.rowIndex).focus();\n\t\t\t\t\t\tdocument.getElementById(\"Save3\").disabled = false;//V201015\n\t\t\t\t\t\tdocument.getElementById(\'Save3\').style.opacity=\'0\';\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}else if((cptCodeVal==\"\" || cptCodeVal==null) && (servCodeVal!=\"\" && servCodeVal!=null)){\n\t\t\t\t\t\talert(\"Approval Date required for the service \"+servCodeVal);\n\t\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+dataArrId.rowIndex).focus();\n\t\t\t\t\t\tdocument.getElementById(\"Save3\").disabled = false;//V201015\n\t\t\t\t\t\tdocument.getElementById(\'Save3\').style.opacity=\'0\';\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\t//Getting Row Values to JSON\n\tvar serviceJSON=[];\t\t\t\t//V201222 Modified\n\tfor (index = 0; index < dataArr.length; index++) { \n\tvar dataArrayId= document.getElementById(dataArr[index]);\n\tvar SaveColCount = table.rows[dataArrayId.rowIndex].cells.length;\n\tvar FinalValues=\"\";\n\t//Getting Cell value against each row\n\t\n\tvar siteSpecPatPayable=document.getElementById(\'siteSpecPatPayable\').value;//V230222\n\tvar siteSpecSearch=document.getElementById(\'siteSpecSearch\').value;//V230529\n\ttry{\n\t\tif(siteSpecServiceCode == \"true\"){\n\t\tfor(var k=0; k<SaveColCount; k++) {\n\t\t\tif(k==5) continue;\n\t\t\tvar colDelValues = table.rows[dataArrayId.rowIndex].cells[k].childNodes[0].value;\n\t\t\tif(k==1){\n\t\t\t\tif(colDelValues==\"Service\" || colDelValues==\"Drug\"){\n\t\t\t\t\tcolDelValues=\"S\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(k==3){\n\t\t\t\tcolDelValues=document.getElementById(\'serviceCode\'+dataArrayId.rowIndex).value;\n\t\t\t}\n\t\t\tif(k==6){\n\t\t\t\tcolDelValues=document.getElementById(\'orderClinicID\'+dataArrayId.rowIndex).value;\n\t\t\t}\n\t\t\tif(k==7){\n\t\t\t\tcolDelValues=document.getElementById(\'performClinicID\'+dataArrayId.rowIndex).value;\n\t\t\t}\n\t\t\tif(k==4){\n\t\t\t\tcolDelValues = colDelValues.replace(/,/g, \' \');\n\t\t\t\tcolDelValues=encodeURIComponent(colDelValues);\n\t\t\t}\n\t\t\tif(k==17){\n\t\t\t\tvar chkbox = table.rows[dataArrayId.rowIndex].cells[17].getElementsByTagName(\'input\')[0];\n\t\t\t\tif(\'checkbox\' == chkbox.type && true == chkbox.checked) {\n\t\t\t\t\tcolDelValues=\"Y\";\n\t\t\t\t}else{\n\t\t\t\t\tcolDelValues=\"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(k==16){\n\t\t\t\tif(document.getElementById(\'serviceAddRow\'+dataArrayId.rowIndex).value==\"Y\"){\n\t\t\t\t\tcolDelValues=\"Y\";\n\t\t\t\t}else{\n\t\t\t\t\tcolDelValues=\"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(k==10 || k==15){\n\t\t\t\tvar chkbox = table.rows[dataArrayId.rowIndex].cells[k].getElementsByTagName(\'input\')[0];\n\t\t\t\tif(\'checkbox\' == chkbox.type && true == chkbox.checked) {\n\t\t\t\t\tcolDelValues=\"Y\";\n\t\t\t\t}else{\n\t\t\t\t\tcolDelValues=\"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tFinalValues=FinalValues+colDelValues+\"~\";\n\t\t}\n\t\t}\n\t\telse if(siteSpecPatPayable==\"true\" || siteSpecPatPayable==true){ //V230222\n\t\t\tfor(var k=0; k<SaveColCount; k++) {\n\t\t\tvar colDelValues = table.rows[dataArrayId.rowIndex].cells[k].childNodes[0].value;\n\t\t\tif(k==1){\n\t\t\t\tif(colDelValues==\"Service\" || colDelValues==\"Drug\"){\n\t\t\t\t\tcolDelValues=\"S\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(k==3){\n\t\t\t\tcolDelValues=document.getElementById(\'serviceCode\'+dataArrayId.rowIndex).value;\n\t\t\t}\n\t\t\tif(k==5){\n\t\t\t\tcolDelValues=document.getElementById(\'orderClinicID\'+dataArrayId.rowIndex).value;\n\t\t\t}\n\t\t\tif(k==6){\n\t\t\t\tcolDelValues=document.getElementById(\'performClinicID\'+dataArrayId.rowIndex).value;\n\t\t\t}\n\t\t\tif(k==4){\n\t\t\t\tcolDelValues = colDelValues.replace(/,/g, \' \');\n\t\t\t\tcolDelValues=encodeURIComponent(colDelValues);\n\t\t\t}\n\t\t\tif(k==17){\n\t\t\t\tvar chkbox = table.rows[dataArrayId.rowIndex].cells[17].getElementsByTagName(\'input\')[0];\n\t\t\t\tif(\'checkbox\' == chkbox.type && true == chkbox.checked) {\n\t\t\t\t\tcolDelValues=\"Y\";\n\t\t\t\t}else{\n\t\t\t\t\tcolDelValues=\"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(k==16){\n\t\t\t\tif(document.getElementById(\'serviceAddRow\'+dataArrayId.rowIndex).value==\"Y\"){\n\t\t\t\t\tcolDelValues=\"Y\";\n\t\t\t\t}else{\n\t\t\t\t\tcolDelValues=\"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(k==9 || k==15){\n\t\t\t\tvar chkbox = table.rows[dataArrayId.rowIndex].cells[k].getElementsByTagName(\'input\')[0];\n\t\t\t\tif(\'checkbox\' == chkbox.type && true == chkbox.checked) {\n\t\t\t\t\tcolDelValues=\"Y\";\n\t\t\t\t}else{\n\t\t\t\t\tcolDelValues=\"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tFinalValues=FinalValues+colDelValues+\"~\";\n\t\t\t}\n\t\t\t\n\t\t\t//16/11/2022 15:50:18~S~~ADHS_2~Home%20Visit-Specialist~DRJAMEEL~DRJAMEEL~1~~N~~~3675.00~0.00~N~checked~Y~N~~~~~~~~~~~~\n\n\t\t}\n\t\telse{\n\t\t\tfor(var k=0; k<SaveColCount; k++) {\n\t\t\tvar colDelValues = table.rows[dataArrayId.rowIndex].cells[k].childNodes[0].value;\n\t\t\tif(k==1){\n\t\t\t\tif(colDelValues==\"Service\" || colDelValues==\"Drug\"){\n\t\t\t\t\tcolDelValues=\"S\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(k==3){\n\t\t\t\tcolDelValues=document.getElementById(\'serviceCode\'+dataArrayId.rowIndex).value;\n\t\t\t}\n\t\t\tif(k==5){\n\t\t\t\tcolDelValues=document.getElementById(\'orderClinicID\'+dataArrayId.rowIndex).value;\n\t\t\t}\n\t\t\tif(k==6){\n\t\t\t\tcolDelValues=document.getElementById(\'performClinicID\'+dataArrayId.rowIndex).value;\n\t\t\t}\n\t\t\tif(k==4){\n\t\t\t\tcolDelValues = colDelValues.replace(/,/g, \' \');\n\t\t\t\tcolDelValues=encodeURIComponent(colDelValues);\n\t\t\t}\n\t\t\tif(k==16){\n\t\t\t\tvar chkbox = table.rows[dataArrayId.rowIndex].cells[16].getElementsByTagName(\'input\')[0];\n\t\t\t\tif(\'checkbox\' == chkbox.type && true == chkbox.checked) {\n\t\t\t\t\tcolDelValues=\"Y\";\n\t\t\t\t}else{\n\t\t\t\t\tcolDelValues=\"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(k==15){\n\t\t\t\tif(document.getElementById(\'serviceAddRow\'+dataArrayId.rowIndex).value==\"Y\"){\n\t\t\t\t\tcolDelValues=\"Y\";\n\t\t\t\t}else{\n\t\t\t\t\tcolDelValues=\"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(k==9 || k==14){\n\t\t\t\tvar chkbox = table.rows[dataArrayId.rowIndex].cells[k].getElementsByTagName(\'input\')[0];\n\t\t\t\tif(\'checkbox\' == chkbox.type && true == chkbox.checked) {\n\t\t\t\t\tcolDelValues=\"Y\";\n\t\t\t\t}else{\n\t\t\t\t\tcolDelValues=\"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tFinalValues=FinalValues+colDelValues+\"~\";\n\t\t}\n\n\t\t}\n\t}catch(e){\n\t\talert(\"Exception in Getting values in SaveServices Row \"+e);\n\t}\t\t\n\t\t//Appending all other common values\n\t\tvar ModifiedFlag=document.getElementById(\'serviceModAppNo\'+dataArrayId.rowIndex).value;\n\t\tvar cptCode=document.getElementById(\'cptCode\'+dataArrayId.rowIndex).value;\n\t\tvar modifyYN=document.getElementById(\'modifyYN\'+dataArrayId.rowIndex).value;\n\t\tFinalValues=FinalValues+FacilityId+\'~\'+ServEncounterId+\'~\'+EpisodeId+\'~\'+EpisodeType+\'~\'+PatientID+\'~\'+VisitID+\'~\'+ModifiedFlag+\'~\'+WS_NO+\'~\'+loginUser+\'~\'+cptCode+\'~\'+modifyYN+\'~\';\n\t\tif(cptCode!=\"\" && cptCode!=null){\n\t\t\tserviceJSON.push(FinalValues);\n\t\t}\n\t}\n\tif(serviceJSON.length!=0 && subFlag==\"Y\"){\n\t\tsubFlag=\"N\";\n\t\t/*var temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?serviceJSON=\"+serviceJSON+\"&CalledFor=SaveData&SessionId=\"+SesId;\n\t\t\tvar xmlDoc = new ActiveXObject( \"Microsoft.XMLDom\") ;\n\t\t\tvar xmlHttp = new ActiveXObject( \"Microsoft.XMLHTTP\") ;\t\t\n\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\txmlHttp.send(\"\");\n\t\tvar responseText=xmlHttp.responseText;\n\t\tdocument.getElementById(\"Save3\").disabled = false;//V201015\n\t\tdocument.getElementById(\'Save3\').style.opacity=\'0\';\n\t\t*/\n\t\t$.ajax({\n\t\t\turl: \"../../eBL/jsp/BLCoderFunServiceValidations.jsp?serviceJSON=\"+serviceJSON+\"&CalledFor=SaveData&SessionId=\"+SesId+\"&siteSpecPatPayable=\"+siteSpecPatPayable+\"&siteSpecSearch=\"+siteSpecSearch, //V230222\n\t\t\ttype: \'POST\',\n\t\t\tsuccess: function(result) {\n\t\t\t\tdocument.getElementById(\"Save3\").disabled = false;//V201015\n\t\t\t\tdocument.getElementById(\'Save3\').style.opacity=\'0\';\n                  },\n\t\t\tasync:   false\n\t\t\t});\n\t}\n\tdocument.getElementById(\"Save3\").disabled = false;//V201015\n\tdocument.getElementById(\'Save3\').style.opacity=\'0\';\n\t}catch(e){\n\t\talert(\"Exception in SaveServices Row \"+e);\n\t}\n}\n\n//Function to remove element from JS array\nfunction removeItemAll(arr, value) {\n\tvar i = 0;\n\twhile (i < arr.length) {\n\tif (arr[i] === value) {\n\t\tarr.splice(i, 1);\n\t} else {\n\t\t++i;\n\t\t}\n\t}\n\treturn arr;\n}\n\n// function that Closes the open Window \nfunction windowClose() { \n\twindow.opener.setValue(true);\n\twindow.parent.close(); \n}\n\n//Zero price Click Event\nfunction zeroPriceClick(e){\ntry{\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tvar myTable = document.getElementById(\'serviceTable1\');\n\tvar primModId=document.getElementById(\'primKeyModuleID\'+RowIndex).value;\n\t// var i=1 to start ";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="after header\n\tvar chkbox = myTable.rows[RowIndex].cells[9].getElementsByTagName(\'input\')[0];\n\t\tif(\'checkbox\' == chkbox.type && true == chkbox.checked) {\n\t\t\tvar str=myTable.rows[RowIndex].cells[16].innerHTML;\n\t\t\tvar res;\n\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t}\n\t\t\t\tmyTable.rows[RowIndex].cells[16].innerHTML=res;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvar str=myTable.rows[RowIndex].cells[16].innerHTML;\n\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t}\n\t\t\tif(primModId!=\"PH\" && primModId!=\"ST\"){\n\t\t\t\tmyTable.rows[RowIndex].cells[16].innerHTML=res;\n\t\t\t}\n\t\t}\n\t}\n\tcatch(e){\n\t\t\talert(\"Exception Zero Price Row \"+e);\n\t\t}\n}\n\n//Cancel Service Click Function\nfunction CancelClick(e){\n\ttry{\n\t\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\t\tvar myTable = document.getElementById(\'serviceTable1\');\n\t\t// var i=1 to start after header\n\t\tvar chkbox = myTable.rows[RowIndex].cells[16].getElementsByTagName(\'input\')[0];\n\t\tvar getBillVal=document.getElementById(\'serviceBillCheck\'+RowIndex).value;\n\t\t\tif(\'checkbox\' == chkbox.type && true == chkbox.checked) {\n\t\t\t\tdocument.getElementById(\'serviceCancelRow\'+RowIndex).value=\"Y\";\n\t\t\t\tvar str=myTable.rows[RowIndex].cells[9].innerHTML;\n\t\t\t\tvar res;\n\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t}\n\t\t\t\t\tmyTable.rows[RowIndex].cells[9].innerHTML=res;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'serviceCancelRow\'+RowIndex).value=\"N\";\n\t\t\t\tif(getBillVal!=\"checked\"){\n\t\t\t\tvar str=myTable.rows[RowIndex].cells[9].innerHTML;\n\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\tres = str.replace(\"disabled\", \"\");\n\t\t\t\t\t}\n\t\t\t\tmyTable.rows[RowIndex].cells[9].innerHTML=res;\n\t\t\t\t}\n\t\t\t}\n\t\t//Validation\n\t\tvar addFlag=document.getElementById(\'serviceAddRow\'+RowIndex).value;\n\t\tvar modFlag=document.getElementById(\'serviceModAppNo\'+RowIndex).value;\n\t\tvar canFlag=document.getElementById(\'serviceCancelRow\'+RowIndex).value;\n\t\tif(addFlag!=\"Y\" && canFlag==\"Y\"){\n\t\t\tdocument.getElementById(\'serviceAddRow\'+RowIndex).value=\"N\";\n\t\t\tdocument.getElementById(\'serviceModAppNo\'+RowIndex).value=\"N\";\n\t\t}\t\t\n\t}\n\tcatch(e){\n\t\t\talert(\"Exception Zero Price Row \"+e);\n\t\t}\n}\n\n//RowClick Event Id Capture\nfunction RowChange(e){\t\n\tif(addRowFlag!=\'Y\'){\n\t\tvar RowIndex=e.rowIndex;\n\t\tdataArr.push(e.id);\n\t\tvar returned=[];\n\t\treturned=ArrNoDupe(dataArr);\n\t\tdataArr=[];\n\t\tdataArr=returned;\n\t}\n\telse{\n\t\taddRowFlag=\'N\';\n\t}\n}\n\n//To find duplication in array\nfunction ArrNoDupe(a) {\n    var temp = {};\n    for (var i = 0; i < a.length; i++)\n        temp[a[i]] = true;\n    var r = [];\n    for (var k in temp)\n        r.push(k);\n    return r;\n}\n\n//Validating Date Time for Inpatient and Out Patient\nfunction validateDateTime(e){\n\tvar DateTime=e.value;\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tif(DateTime!=null && DateTime!=\"\"){\n\t\tif(dateRegEx(e)){\n\t\t\t//Validation\n\t\t\tvar addFlag=document.getElementById(\'serviceAddRow\'+RowIndex).value;\n\t\t\tvar canFlag=document.getElementById(\'serviceCancelRow\'+RowIndex).value;\n\t\t\tvar serviceModFlag=document.getElementById(\"serviceModAppNo\"+RowIndex).value;\n\t\t\t\tif(canFlag!=\"Y\" && addFlag!=\"Y\" && serviceModFlag!=\'Y\'){\n\t\t\t\t\tdocument.getElementById(\"modifyYN\"+RowIndex).value=\"Y\";\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tdocument.getElementById(\"modifyYN\"+RowIndex).value=\"N\";\n\t\t\t\t}\n\t\t\tvar FacId=document.getElementById(\"FacilityId\").value;\n\t\t\tvar EncounterId=document.getElementById(\"ServEncounterId\").value;\n\t\t\t//var formObj=document.BLCoderEditService;\n\t\t\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?dateTime=\"+DateTime+\"&FacilityId=\"+FacId+\"&EncounterId=\"+EncounterId+\"&CalledFor=DateValidation\";\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\t\t\n\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\txmlHttp.send(\"\");\n\t\t\tvar responseText=xmlHttp.responseText;\n\t\t\tresponseText=trimString(responseText);\n\t\t\tvar n1 = responseText.indexOf(\"~\");\n\t\t\tvar res1 =responseText.substr(n1+1);\n\t\t\tif(res1 != null && res1 != \"\"){\n\t\t\t\talert(res1);\n\t\t\t\tdocument.getElementById(e.id).value=document.getElementById(\"servDateHid\"+RowIndex).value;\n\t\t\t}\n\t\t}\n\t}\n\telse{\n\t\talert(\"Service date cannot be empty\");\n\t\tdocument.getElementById(e.id).value=document.getElementById(\"servDateHid\"+RowIndex).value;\n\t}\t\n}\t\n\n//Validating Service Quantity\nfunction validateServQty(e){\n\tif(e.value!=0){\n\t\tif(isNumber(e)){\n\t\t\tvar serviceQty = e.value;\n\t\t\tvar strtIndex = serviceQty.indexOf(\".\");\n\t\t\tif(strtIndex!=-1){\n\t\t\t\tdocument.getElementById(e.id).value=parseFloat(serviceQty).toFixed(3);\n\t\t\t}\n\t\t\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\t\t\tvar FacId=document.getElementById(\"FacilityId\").value;\n\t\t\tvar LangId=document.getElementById(\"locale\").value;\n\t\t\tvar loginUser=document.getElementById(\"loginUser\").value;\n\t\t\tvar ServEncounterId = document.getElementById(\"+ServEncounterId+\").value;\n\t\t\tvar ServDate = document.getElementById(\'serviceDate\'+RowIndex).value;\n\t\t\tvar ServTypeInd = document.getElementById(\'servicetype\'+RowIndex).value;\n\t\t\tvar cptCode=document.getElementById(\"cptCode\"+RowIndex).value;\n\t\t\tvar serviceCode = document.getElementById(\'serviceCode\'+RowIndex).value;\n\t\t\tvar serviceRateCharge = document.getElementById(\'serviceRateCharge\'+RowIndex).value;\n\t\t\tvar siteSpecPatPayable = document.getElementById(\'siteSpecPatPayable\').value;//V230222\n\t\t\tvar params=\"FacId=\"+FacId+\"&LangId=\"+LangId+\"&loginUser=\"+loginUser+\"&ServEncounterId=\"+ServEncounterId+\"&ServDate=\"+ServDate+\"&ServTypeInd=\"+ServTypeInd+\"&serviceCode=\"+serviceCode+\"&serviceQty=\"+serviceQty+\"&serviceRateCharge=\"+serviceRateCharge+\"&cptCode=\"+cptCode+\"&siteSpecPatPayable=\"+siteSpecPatPayable;//V230222\n\t\t\t//Ajax Call\n\t\t\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?\"+params+\"&CalledFor=servQtyCheck\";\n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\t\t\n\t\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\t\txmlHttp.send(\"\");\n\t\t\tvar responseText1=xmlHttp.responseText;\n\t\t\tresponseText1 = trimString(responseText1);\n\t\t\tvar n1 = responseText1.indexOf(\"~\");\n\t\t\tvar res1 = responseText1.substr(n1+1);\n\t\t\tres1 = res1.split(\"~\");\n\t\t\tif(res1[0]!=\"Error\"){\n\t\t\tvar serPrice=res1[0];\n\t\t\tvar insPrice=res1[1];\n\t\t\tdocument.getElementById(\"ServPrice\"+RowIndex).value = parseFloat(serPrice).toFixed(2);\n\t\t\tdocument.getElementById(\"InsAmt\"+RowIndex).value=parseFloat(insPrice).toFixed(2);\n\t\t\tdocument.getElementById(\"preAppFlagID\"+RowIndex).value=res1[2];\n\t\t\tif(siteSpecPatPayable==\"true\" || siteSpecPatPayable==true){\n\t\t\t\tvar pat_pay=res1[3];\n\t\t\t\tdocument.getElementById(\"patPay\"+RowIndex).value=pat_pay;\n\t\t\t\t\n\t\t\t}//V230222\n\t\t\t\tif(res1[2]==\"Y\"){\n\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+RowIndex).disabled = false;\n\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+RowIndex).disabled = false;\n\t\t\t\t\tdocument.getElementById(\"AppDateImg\"+RowIndex).disabled = false;\n\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+RowIndex).value = \"\";\n\t\t\t\t}else{\n\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+RowIndex).value = \"\";\n\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+RowIndex).value = \"\";\n\t\t\t\t\tdocument.getElementById(\"ApproveNum\"+RowIndex).disabled = true;\n\t\t\t\t\tdocument.getElementById(\"ApproveDate\"+RowIndex).disabled = true;\n\t\t\t\t\tdocument.getElementById(\"AppDateImg\"+RowIndex).disabled = true;\n\t\t\t\t}\n\t\t\t}\n\t\t\telse{\n\t\t\t\talert(res1[1]);\n\t\t\t}\n\t\t}else{\n\t\t\talert(getMessage(\'BL8532\',\'BL\'));\n\t\t\tdocument.getElementById(e.id).focus();\n\t\t}\n\t}else{\n\t\talert(\"Quantity cannot be Zero\");\n\t\tdocument.getElementById(e.id).focus();\n\t}\n}\t\n\n//Populating Service COde realted values\nfunction validateServCode(e){\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tvar serviceCode=document.getElementById(\"serviceCode\"+RowIndex).value;\n\tvar FacId=document.getElementById(\"FacilityId\").value;\n\tvar LangId=document.getElementById(\"locale\").value;\n\tvar loginUser=document.getElementById(\"loginUser\").value;\n\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?serviceCode=\"+serviceCode+\"&FacilityId=\"+FacId+\"&LangId=\"+LangId+\"&loginUser=\"+loginUser+\"&CalledFor=ServiceCode\";\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\t\t\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(\"\");\n\tvar responseText=xmlHttp.responseText;\n\tif(responseText != null && responseText != \"\"){\n\tvar n = responseText.indexOf(\"~\");\n\tvar res = responseText.substr(n+1);\n\tres = res.split(\"~\");\n\tif(res[0]!=\"Error\"){\n\t//document.getElementById(\"serviceDesc\"+RowIndex).value=res[0];\n\tdocument.getElementById(\"serviceRateCharge\"+RowIndex).value=res[1];\n\tdocument.getElementById(\"serviceQty\"+RowIndex).value=res[2];\n\tif(res[1]==\"C\"){\n\t\tdocument.getElementById(\"InsAmt\"+RowIndex).disabled = true;\n\t\tdocument.getElementById(\"ServPrice\"+RowIndex).disabled = false;\n\t\tdocument.getElementById(\"ServPrice\"+RowIndex).focus();\n\t}else{\n\t\tdocument.getElementById(\"serviceQty\"+RowIndex).disabled = false;\n\t\tdocument.getElementById(\"serviceQty\"+RowIndex).focus();\n\t\tdocument.getElementById(\"InsAmt\"+RowIndex).disabled = true;\n\t}\n\t//Populating Quantity\n\tvar ServEncounterId = document.getElementById(\"+ServEncounterId+\").value;\n\tvar ServDate = document.getElementById(\'serviceDate\'+RowIndex).value;\n\tvar cptCode=document.getElementById(\"cptCode\"+RowIndex).value;\n\tvar ServTypeInd = document.getElementById(\'servicetype\'+RowIndex).value;\n\tvar serviceQty = document.getElementById(\"serviceQty\"+RowIndex).value;\n\tvar serviceRateCharge = document.getElementById(\'serviceRateCharge\'+RowIndex).value;\n\tvar siteSpecPatPayable = document.getElementById(\'siteSpecPatPayable\').value;\n\tvar params=\"FacId=\"+FacId+\"&LangId=\"+LangId+\"&loginUser=\"+loginUser+\"&ServEncounterId=\"+ServEncounterId+\"&ServDate=\"+ServDate+\"&ServTypeInd=\"+ServTypeInd+\"&serviceCode=\"+serviceCode+\"&serviceQty=\"+serviceQty+\"&serviceRateCharge=\"+serviceRateCharge+\"&cptCode=\"+cptCode+\"&siteSpecPatPayable=\"+siteSpecPatPayable;//V230222;\n\t//Ajax Call\n\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?\"+params+\"&CalledFor=servQtyCheck\";\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\t\t\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(\"\");\n\tvar responseText1=xmlHttp.responseText;\n\tresponseText1 = trimString(responseText1);\n\tvar n1 = responseText1.indexOf(\"~\");\n\tvar res1 = responseText1.substr(n1+1);\n\tres1 = res1.split(\"~\");\n\tif(res1[0]!=\"Error\"){\n\t\tvar serPrice=res1[0];\n\t\tvar insPrice=res1[1];\n\t\tif(siteSpecPatPayable==\"true\" || siteSpecPatPayable==true){\n\t\t\tvar patpay=res1[3];\n\t\t\tdocument.getElementById(\"patPay\"+RowIndex).value =parseFloat(patpay).toFixed(2);\n\t\t}//V230222\n\t\tdocument.getElementById(\"ServPrice\"+RowIndex).value =parseFloat(serPrice).toFixed(2);\n\t\tdocument.getElementById(\"InsAmt\"+RowIndex).value=parseFloat(insPrice).toFixed(2);\n\t\tdocument.getElementById(\"preAppFlagID\"+RowIndex).value=res1[2];\n\t\tif(res1[2]==\"Y\"){\n\t\t\t\tdocument.getElementById(\"ApproveNum\"+RowIndex).disabled = false;\n\t\t\t\tdocument.getElementById(\"ApproveDate\"+RowIndex).disabled = false;\n\t\t\t\tdocument.getElementById(\"AppDateImg\"+RowIndex).disabled = false;\n\t\t\t\tdocument.getElementById(\"ApproveNum\"+RowIndex).value = \"\";\n\t\t\t}else{\n\t\t\t\tdocument.getElementById(\"ApproveNum\"+RowIndex).value = \"\";\n\t\t\t\tdocument.getElementById(\"ApproveDate\"+RowIndex).value = \"\";\n\t\t\t\tdocument.getElementById(\"ApproveNum\"+RowIndex).disabled = true;\n\t\t\t\tdocument.getElementById(\"ApproveDate\"+RowIndex).disabled = true;\n\t\t\t\tdocument.getElementById(\"AppDateImg\"+RowIndex).disabled = true;\n\t\t\t}\n\t}\n\telse{\n\t\talert(res1[1]);\n\t}\n\t}\n\telse{\n\t\talert(res1[1]);\n\t}\t\n}\n}\n\n//Populating service Code in LookUp\nfunction serviceCodeLookUp(e){\n\tvar formObj=document.BLCoderEditService;\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tvar servCodeVal=document.getElementById(\"serviceCode\"+RowIndex).value;\n\tvar LangId=document.getElementById(\"locale\").value;\n\tvar Facility_Id=document.getElementById(\"FacilityId\").value;\n\tif(formObj!=null){\t\n\t\t\tvar argumentArray  = new Array() ;\n\t\t\tvar dataNameArray  = new Array() ;\n\t\t\tvar dataValueArray = new Array() ;\n\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\tvar title=\"Service Code\";\t\n\t\t\targumentArray[0]\t=  \"SELECT blng_serv_code code, SHORT_DESC description FROM bl_blng_serv WHERE DIR_ENTRY_FLAG = \'Y\' AND upper(blng_serv_code) like upper(?) and upper(SHORT_DESC) like upper(?)  order by 2 \";\t\t\t\t\n\t\t\targumentArray[1]   = dataNameArray ;\n\t\t\targumentArray[2]   = dataValueArray ;\n\t\t\targumentArray[3]   = dataTypeArray ;\n\t\t\targumentArray[4]   = \"1,2\";\n\t\t\targumentArray[5]   = servCodeVal;\n\t\t\targumentArray[6]   = CODE_LINK ;\n\t\t\targumentArray[7]   = CODE_DESC ;\t\n\t\t\tretVal = await CommonLookup( title, argumentArray );\n\t\t\tif(retVal != null && retVal != \"\"){\n\t\t\t\tdocument.getElementById(\"serviceCode\"+RowIndex).value=retVal[0];\n\t\t\t\tvalidateServCode(e)\t;\t\t\t\t\n\t\t\t}else{\n\t\t\t\tdocument.getElementById(\"serviceCode\"+RowIndex).value=\"\";\t\t\t\n\t\t\t}\n\t\t}\n}\n\n//Populating Values in Ordering Clinician LookUp\nfunction performingClinicianLookUp(e){\t\n\tvar formObj=document.BLCoderEditService;\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tvar orderClinicVal=document.getElementById(\"performClinic\"+RowIndex).value;\n\tvar LangId=document.getElementById(\"locale\").value;\n\tvar Facility_Id=document.getElementById(\"FacilityId\").value;\n\tif(formObj!=null){\t\n\t\t\tvar argumentArray  = new Array() ;\n\t\t\tvar dataNameArray  = new Array() ;\n\t\t\tvar dataValueArray = new Array() ;\n\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\tvar title=\"Performing Clinician\";\t\t\t\n\t\t\targumentArray[0]\t=  \"SELECT practitioner_id code,NAME description  FROM bl_am_pract_staff_vw WHERE facility_id = \'\"+Facility_Id+\"\' AND UPPER (language_id) = UPPER (\'\"+LangId+\"\')  and upper(practitioner_id) like upper(?) and upper(NAME) like upper(?)  order by 2 \";\t\t\t\t\n\t\t\targumentArray[1]   = dataNameArray ;\n\t\t\targumentArray[2]   = dataValueArray ;\n\t\t\targumentArray[3]   = dataTypeArray ;\n\t\t\targumentArray[4]   = \"1,2\";\n\t\t\targumentArray[5]   = orderClinicVal;\n\t\t\targumentArray[6]   = CODE_LINK ;\n\t\t\targumentArray[7]   = CODE_DESC ;\t\n\t\t\tretVal = await CommonLookup( title, argumentArray );\n\t\t\tif(retVal != null && retVal != \"\"){\n\t\t\t\tdocument.getElementById(\"performClinicID\"+RowIndex).value=retVal[0];\n\t\t\t\tdocument.getElementById(\"performClinic\"+RowIndex).value=retVal[1];\t\n\t\t\t\tdocument.getElementById(\"performClinic\"+RowIndex).focus();\t\t\n\t\t\t}else{\n\t\t\t\tdocument.getElementById(\"performClinicID\"+RowIndex).value=\"\";\n\t\t\t\tdocument.getElementById(\"performClinic\"+RowIndex).value=\"\";\t\n\t\t\t\tdocument.getElementById(\"performClinic\"+RowIndex).focus();\t\t\t\n\t\t\t}\n\t\t}\t\n}\n\n//Populating Values in Ordering Clinician LookUp\nfunction orderingClinicianLookUp(e){\t\n\tvar formObj=document.BLCoderEditService;\n\tvar RowIndex=e.parentNode.parentNode.rowIndex;\n\tvar orderClinicVal=document.getElementById(\"orderClinic\"+RowIndex).value;\n\tvar LangId=document.getElementById(\"locale\").value;\n\tvar Facility_Id=document.getElementById(\"FacilityId\").value;\n\tif(formObj!=null){\t\n\t\t\t\tvar argumentArray  = new Array() ;\n\t\t\t\tvar dataNameArray  = new Array() ;\n\t\t\t\tvar dataValueArray = new Array() ;\n\t\t\t\tvar dataTypeArray  = new Array() ;\n\t\t\t\tvar title=\"Ordering Clinician\";\t\t\t\n\t\t\t\targumentArray[0]\t=  \"SELECT practitioner_id code,NAME description  FROM bl_am_pract_staff_vw WHERE facility_id = \'\"+Facility_Id+\"\' AND UPPER (language_id) = UPPER (\'\"+LangId+\"\')  and upper(practitioner_id) like upper(?) and upper(NAME) like upper(?)  order by 2 \";\t\t\t\t\n\t\t\t\targumentArray[1]   = dataNameArray ;\n\t\t\t\targumentArray[2]   = dataValueArray ;\n\t\t\t\targumentArray[3]   = dataTypeArray ;\n\t\t\t\targumentArray[4]   = \"1,2\";\n\t\t\t\targumentArray[5]   = orderClinicVal;\n\t\t\t\targumentArray[6]   = CODE_LINK ;\n\t\t\t\targumentArray[7]   = CODE_DESC ;\t\n\t\t\t\tretVal = await CommonLookup( title, argumentArray );\n\t\t\t\tif(retVal != null && retVal != \"\"){\n\t\t\t\t\tdocument.getElementById(\"orderClinicID\"+RowIndex).value=retVal[0];\n\t\t\t\t\tdocument.getElementById(\"orderClinic\"+RowIndex).value=retVal[1];\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\tdocument.getElementById(\"orderClinicID\"+RowIndex).value=\"\";\n\t\t\t\t\tdocument.getElementById(\"orderClinic\"+RowIndex).value=\"\";\t\t\n\t\t\t\t}\n\t\t\t}\n}\n\n//Trim String\nfunction trimString(sInString)\n{\n  sInString = sInString.replace( /^\\s+/g, \"\" );// strip leading\n  return sInString.replace( /\\s+$/g, \"\" );// strip trailing\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onload=\"onLoadServiceEdit()\" onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\">\n<form name=\'BLCoderEditService\' id=\'BLCoderEditService\' method=\'post\'>\n<center>\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n  <tr>\n    <td><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\">\n\t      <tr >\n\t      \t <td class=\"BOLD\">Services</td>\n\t      \t  <td width=\"60%\"></td>&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t   ";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n\t      \t  <td style=\"align:center\">\n\t\t\t\t<input type=\"text\" name=\"searchCPT\" id=\"searchCPT\" id=\"searchCPT\" placeholder=\"CPT Code Search\" title=\"search CPT Code\"> \n\t\t\t\t<img alt=\"search\" src=\"..\\..\\eBL\\images\\search.png\" onclick=\"searchCptCode(searchCPT)\">\n\t\t\t\t</td> \n\t\t\t   ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<td></td>\n\t      </tr>\n      </table>\n      <tr>\n        <td><table width=\'100%\' align=\"center\" cellpadding=\"4\" cellspacing=\"0\" class=\'grid\' id=\"serviceTable1\" >\n          <tr>\n            <td class=\'COLUMNHEADER\' >Date &amp; Time</td>\n            <td class=\'COLUMNHEADER\' >Drug/Non drug </td>\n            <td class=\'COLUMNHEADER\' >Service Type</td>\n            <td class=\'COLUMNHEADER\' >Service Code(CPT)</td>\n            <td class=\'COLUMNHEADER\' >Service Description</td>\n\t\t\t<!--Added by Kamatchi S for TH-KW-CRF-0143-->\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<td class=\'COLUMNHEADER\' >Billing Service Code</td>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n            <td class=\'COLUMNHEADER\' style=\"width: 90px;\">Ordering Clinician </td>\n            <td class=\'COLUMNHEADER\' style=\"width: 90px;\">Performing Clinician</td>\n            <td class=\'COLUMNHEADER\' style=\"width: 90px;\">Quantity</td>  <!-- V201222 Modified -->\n            <td class=\'COLUMNHEADER\' >Modifier/ Adjuster</td>\n            <td class=\'COLUMNHEADER\' >Zero Price</td>\n            <td class=\'COLUMNHEADER\' >Approval No.</td>\n            <td class=\'COLUMNHEADER\' style=\"width: 70px;\">Approval Date </td> <!-- V201222 Modified -->\n            <td class=\'COLUMNHEADER\' >Service Price</td>\n            ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n            <td class=\'COLUMNHEADER\' >Ins/Cash Price</td>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<td class=\'COLUMNHEADER\' >Ins.Price</td>\t\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<td class=\'COLUMNHEADER\' >Patient Payable</td>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\n            <td class=\'COLUMNHEADER\' >Bill-able</td>\n            <td class=\'COLUMNHEADER\' >Add Row</td>\n            <td class=\'COLUMNHEADER\' >Cancel Services</td>\n            <td style=\"display:none;\">BillDocTypeCode</td>\n            <td style=\"display:none;\">BillDocNo</td>\n            <td style=\"display:none;\">CustGrpCode</td>\n            <td style=\"display:none;\">CustCode</td>\n            <td style=\"display:none;\">TrxDocRef</td>\n            <td style=\"display:none;\">TrxDocRefLineNo</td>\n            <td style=\"display:none;\">TrxDocRefSeqNoNo</td>\n            <td style=\"display:none;\">TrxDate</td>\n            <td style=\"display:none;\">SettlementInd</td>\n            <td style=\"display:none;\">PatientAmt</td>\n            <td style=\"display:none;\">Key Value</td>\n            </tr>\n\t\t\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n          <tr id=\"serviceRow";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  onclick=\"RowChange(this)\"  >\n            <td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"><input type=\"text\" onblur=\"validateDateTime(this)\" class=\"gridDataInputMore ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" name=\"serviceDate";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"serviceDate";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" size=\"19\" maxlength=\"19\"><img src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendar(\'serviceDate";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',null,\'hh:mm:ss\');\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="><input type=\"hidden\" id=\"servDateHid";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></td>\n            <td class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"><select name=\"servicetype";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"servicetype";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onchange=\"DrugTypeChange(this)\">       \n\t    <option value=\"Select\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">-Select-</option>\n              <option value=\"S\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">Service</option>\n              <option value=\"I\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">Drug</option>\n              </select></td>\n            <td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"><input class=\"gridDataInputLess ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" type=\"text\" maxlength=\"100\" name=\"serviceTypeDesc";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"serviceTypeDesc";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"><input type=\"hidden\" id=\"preAppFlagID";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" value=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="></td>\n            <td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t<input class=\"gridDataInput ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" style=\"width: 100px\" type=\"text\" name=\"cptCode";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" onblur=\"validateCPTCode(this)\" id=\"cptCode";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<input class=\"gridDataInput ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" type=\"hidden\" name=\"serviceCode";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"serviceCode";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t</td><!--Condition Added by Kamatchi S for TH-KW-CRF-0143-->\n            <td class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"><input class=\"gridDataInputMore ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" type=\"text\" name=\"serviceDesc";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"serviceDesc";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" title=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"></td><!-- V201222 Modified -->\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<!--Added by Kamatchi S for TH-KW-CRF-0143-->\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"><input class=\"gridDataInput ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" type=\"text\" name=\"serviceCode";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"></td>\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n            <td class=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" type=\"text\" name=\"orderClinic";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"orderClinic";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" ><input style=\"display:none;\" type=\"text\" id=\"orderClinicID";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"> </td>\n            <td class=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" type=\"text\" onblur=\"performClinicianBlur(this);\" name=\"performClinic";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"performClinic";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"><input type=\"button\" class=\"button\" value=\"?\" onclick=\"performingClinicianLookUp(this)\" id=\'PerformLovButton\' name =\"PerformLovButton\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="><input style=\"display:none;\" type=\"text\" id=\"performClinicID";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"><input style=\"display:none;\" type=\"text\" id=\"modifyYN";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" value=\"N\" ></td>\n            <td class=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" style=\"width: 50px;\" type=\"text\" onkeypress=\"return restrictAlphabets(event);\" name=\"serviceQty";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"serviceQty";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" onblur=\"validateServQty(this)\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" ><input style=\"display:none;\" type=\"text\" id=\"serviceRateCharge";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" value=\"\" ></td><!-- V201222 Modified -->\n            <td class=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" type=\"text\" maxlength=\"30\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" ></td>\n            <td class=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"><input type=\"checkbox\" name=\"checkboxZero";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"checkboxZero";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"  ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" id=\"checkboxZero";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" onclick=\"zeroPriceClick(this)\"  value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" /></td>\n            <td class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" type=\"text\" name=\"ApproveNum";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"ApproveNum";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" maxlength=\"20\" onblur=\"ModAppNo(this);\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" ><input type=\"hidden\" id=\"appNoHid";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"><input style=\"display:none;\" type=\"text\" id=\"serviceModAppNo";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" style=\"width: 75px;\" type=\"text\" name=\"ApproveDate";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"ApproveDate";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" onblur=\"ModAppNo(this);\"  value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" size=\"19\" maxlength=\"19\" ><input type=\"hidden\" id=\"appDateHid";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"><img id=\"AppDateImg";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendar(\'ApproveDate";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="></td> <!-- V201222 Modified -->\n            <td class=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" type=\"text\" name=\"ServPrice";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" onkeypress=\"return restrictAlphabets(event);\" onblur=\"isNo(this)\" id=\"ServPrice";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"  value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" type=\"text\" name=\"InsAmt";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"  id=\"InsAmt";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" disabled></td>\n\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t <td class=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" type=\"text\" name=\"patPay";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" id=\"patPay";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<input type=\"checkbox\" name=\"checkboxBill";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" id=\"checkboxBill";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"  onclick=\"billClick(this)\" ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="/><input style=\"display:none;\" type=\"text\" id=\"serviceBillCheck";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" >\n\t\t\t</td>\n            <td class=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"><input type=\"button\" name=\"AddBTn";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"AddBTn";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"  value=\"+\" onclick=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="addRow1(this);";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="addRow(this)";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" disabled ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" id=\"AddBTn";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t<input style=\"display:none;\" type=\"text\" id=\"serviceAddRow";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" value=\"\" ></td><!--Condition Added by Kamatchi S for TH-KW-CRF-0143-->\n            <td class=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"><input type=\"checkbox\" name=\"Cancelcheck";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" id=\"Cancelcheck";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" value=\"\" id=\"Cancelcheck";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" onclick=\"CancelClick(this)\" ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" /><input style=\"display:none;\" type=\"text\" id=\"serviceCancelRow";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" value=\"\" ><input style=\"display:none;\" type=\"text\" id=\"primKeyModuleID";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\" ></td>\n\t\t\t<td style=\"display:none;\"><input type=\"text\" style=\"display:none;\" id=\"keyValId";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" ></td>\n\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t<td style=\"display:none;\"><input type=\"hidden\" name=\"isbilled";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"isbilled";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"></td>\n\t\t\t<td style=\"display:none;\"><input type=\"hidden\" name=\"boldYN";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" id=\"boldYN";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n        <tr id=\"serviceRow";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\"  onclick=\"RowChange(this)\">\n            <td><input type=\"text\" onblur=\"validateDateTime(this)\" class=\"gridDataInputMore\" name=\"serviceDate";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" value=\"\" size=\"19\" maxlength=\"19\"><img src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendar(\'serviceDate";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\',null,\'hh:mm:ss\');\"><input type=\"hidden\" id=\"servDateHid";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" value=\"\"></td>\n            <td><select name=\"servicetype";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" onchange=\"DrugTypeChange(this)\">       \n\t\t\t\t\t<option value=\"Select\" >-Select-</option>\n              <option value=\"S\" selected>Service</option>\n              <option value=\"I\" >Drug</option>\n              </select></td>\n            <td><input class=\"gridDataInputLess\" type=\"text\" maxlength=\"100\" name=\"serviceTypeDesc";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" value=\"\" ><input type=\"hidden\" id=\"preAppFlagID";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" value=\"N\"></td>\n            <td><input class=\"gridDataInput\" type=\"text\" name=\"cptCode";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" id=\"cptCode";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" value=\"\" >";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="<input class=\"gridDataInput\" type=\"hidden\" name=\"serviceCode";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" value=\"\">";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="<input type=\'button\' class=\'button\' value=\'?\' onclick=\'callCPTSearch(this)\' name = \'servCodeLovButton\'></td><!--Condition Added by Kamatchi S for TH-KW-CRF-0143-->\n            <td><input class=\"gridDataInputMore\" type=\"text\" name=\"serviceDesc";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" value=\"\" ></td><!-- V201222 Modified -->\n\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="<!--Added by Kamatchi S for TH-KW-CRF-0143-->\n\t\t\t<td><input class=\"gridDataInput\" type=\"text\" name=\"serviceCode";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" value=\"\"></td>\n\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n            <td><input class=\"gridDataInput\" type=\"text\" name=\"orderClinic";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" value=\"\" ><input style=\"display:none;\" type=\"text\" id=\"orderClinicID";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" value=\"\"><input type=\'button\' class=\'button\' value=\'?\' onclick=\'orderingClinicianLookUp(this)\' name = \'OrderLovButton\'> </td>\n            <td><input class=\"gridDataInput\" type=\"text\" onblur=\"performClinicianBlur(this);\" name=\"performClinic";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" value=\"\"><input type=\"button\" class=\"button\" value=\"?\" onclick=\"performingClinicianLookUp(this)\" id=\'PerformLovButton\' name =\"PerformLovButton\"><input style=\"display:none;\" type=\"text\" id=\"performClinicID";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" value=\"\"><input style=\"display:none;\" type=\"text\" id=\"modifyYN";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" value=\"N\" ></td>\n            <td><input class=\"gridDataInputLess\" style=\"width: 50px;\" type=\"text\" onkeypress=\"return restrictAlphabets(event);\" name=\"serviceQty";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" onblur=\"validateServQty(this)\" value=\"1\" ><input style=\"display:none;\" type=\"text\" id=\"serviceRateCharge";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" value=\"\" ></td><!-- V201222 Modified -->\n            <td><input class=\"gridDataInputLess\" type=\"text\" maxlength=\"30\" value=\"\" ></td>\n            <td><input type=\"checkbox\" name=\"checkboxZero";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\"  id=\"checkboxZero";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" onclick=\"zeroPriceClick(this)\"  value=\"\" /></td>\n            <td><input class=\"gridDataInput\" type=\"text\" name=\"ApproveNum";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\" maxlength=\"20\" onblur=\"ModAppNo(this);\" value=\"\" ><input style=\"display:none;\" type=\"text\" id=\"serviceModAppNo";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" value=\"N\" ></td>\n            <td><input class=\"gridDataInput\" style=\"width: 75px;\" type=\"text\" name=\"ApproveDate";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" onblur=\"ModAppNo(this);\"  value=\"\" size=\"19\" maxlength=\"19\" ><img id=\"AppDateImg";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\',null,\'hh:mm:ss\');\"></td><!-- V201222 Modified -->\n            <td><input class=\"gridDataInput\" type=\"text\" name=\"ServPrice";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\" id=\"ServPrice";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\"  value=\'\'></td>\n            <td><input class=\"gridDataInput\" type=\"text\" name=\"InsAmt";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\" id=\"InsAmt";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" value=\'\' disabled></td>\n\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t <td><input class=\"gridDataInput\" type=\"text\" name=\"patPay";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" value=\"\" disabled></td>\n\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n            <td><input type=\"checkbox\" name=\"checkboxBill";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" value=\"checked\" id=\"checkboxBill";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\"  onclick=\"billClick(this)\" checked/><input style=\"display:none;\" type=\"text\" id=\"serviceBillCheck";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" value=\"\" ></td>\n            <td><input type=\"button\" name=\"AddBTn";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\"  id=\"AddBTn";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\"><input style=\"display:none;\" type=\"text\" id=\"serviceAddRow";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" value=\"Y\" ></td><!--Condition Added by Kamatchi S for TH-KW-CRF-0143-->\n            <td><input type=\"checkbox\" name=\"Cancelcheck";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" onclick=\"CancelClick(this)\"/><input style=\"display:none;\" type=\"text\" id=\"serviceCancelRow";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" value=\"N\" ><input style=\"display:none;\" type=\"text\" id=\"primKeyModuleID";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" value=\"\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"\"></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"\" ></td>\n\t\t\t<td style=\"display:none;\"><input type=\"text\" style=\"display:none;\" id=\"keyValId";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" value=\"\" ></td>\n\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" value=\"\"></td>\n\t\t\t<td style=\"display:none;\"><input type=\"hidden\" name=\"boldYN";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n          </table></td>\n        </tr>\n      <tr>        \n          <td style=\"text-align:left\">\n          <input type=\"submit\" name=\"Save3\" id=\"Save3\" id=\"Save3\" value=\"Save\" onclick=\"document.getElementById(\'Save3\').disabled = true; document.getElementById(\'Save3\').style.opacity=\'0.5\'; return SaveServices();\"/>\n          <input type=\"button\" name=\"Close1\" id=\"Close1\" id=\"Close1\" value=\"Close\" onclick=\"windowClose()\"/></td>\n        </tr>\n      </table></td>\n  </tr>\n</table>\n</center>\n\t\t  \n<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n<input type=\"hidden\" name=\"FacilityId\" id=\"FacilityId\" id=\"FacilityId\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n<input type=\"hidden\" name=\"ServEncounterId\" id=\"ServEncounterId\" id=\"ServEncounterId\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\"> \n<input type=\"hidden\" name=\"EpisodeId\" id=\"EpisodeId\" id=\"EpisodeId\" value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n<input type=\"hidden\" name=\"EpisodeType\" id=\"EpisodeType\" id=\"EpisodeType\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"> \n<input type=\"hidden\" name=\"PatientId\" id=\"PatientId\" id=\"PatientId\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n<input type=\"hidden\" name=\"VisitId\" id=\"VisitId\" id=\"VisitId\" value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\"> \n<input type=\"hidden\" name=\"loginUser\" id=\"loginUser\" id=\"loginUser\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\"> \n<input type=\"hidden\" name=\"logInWSno\" id=\"logInWSno\" id=\"logInWSno\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\"> \n<input type=\"hidden\" name=\"logInUserId\" id=\"logInUserId\" id=\"logInUserId\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\"> \n<input type=\"hidden\" name=\"SessionId\" id=\"SessionId\" id=\"SessionId\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n<input type=\"hidden\" name=\"siteSpecPatPayable\" id=\"siteSpecPatPayable\" id=\"siteSpecPatPayable\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\"> <!--V230222-->\n<input type=\"hidden\" name=\"serviceSize\" id=\"serviceSize\" id=\"serviceSize\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\"><!--V201015 Added-->\n<input type=\"hidden\" name=\"siteSpecServiceCode\" id=\"siteSpecServiceCode\" id=\"siteSpecServiceCode\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\"><!--V201015 Added-->\n<input type=\"hidden\" name=\"siteSpecSearch\" id=\"siteSpecSearch\" id=\"siteSpecSearch\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\"><!--V230529 Added-->\n<input type=\"hidden\" name=\"limit\" id=\"limit\" id=\"limit\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n\n  </form>\n  <div class=\'COLUMNHEADER\' name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:10%; visibility:hidden; background-color:blue;\'>\n\t \t<table id=\'tooltiptable\' cellpadding=\"0\" cellspacing=0 border-collapse=collapse  style=\'position:absolute;\' width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'100%\' id=\'menu_table\'></td>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n  </body>\n</html>\n\n";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );
	
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Version     	Developer Name		Rev.Date		Rev.Name		SCF/CRF
-------------------------------------------------------------------------------------------------------------------------------------
17/06/2020 	  		         Ram kumar S									  AAKH-CRF-0122
15/10/2020 	 V201015	     Ram kumar S									  AAKH-SCF-0458
22/12/2020 	 V201222	     Ram kumar S									  AAKH-SCF-0479
29/09/2022                   Kamatchi S                                       TH-KW-CRF-0143
V230516						Mohanapriya										  AAKH-CRF-0153
-------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Connection con	= null;//Modified by Kamatchi S for TH-KW-CRF-0143
	con = ConnectionManager.getConnection(request);//Added by Kamatchi S for TH-KW-CRF-0143
	Boolean siteSpecServiceCode = false;//Added by Kamatchi S for TH-KW-CRF-0143
	siteSpecServiceCode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_SERVICE_CODE_REQD");//Added by Kamatchi S for TH-KW-CRF-0143
	String siteSpecPatPayable=request.getParameter("siteSpecPatPayable");//V230222/AAKH-CRF-0172
	String siteSpecSearch=request.getParameter("siteSpecSearch");//V230222/AAKH-CRF-0153
	System.err.println("siteSpecPatPayable "+siteSpecPatPayable);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
if(siteSpecSearch.equals("true")){
            _bw.write(_wl_block8Bytes, _wl_block8);
 } 
            _bw.write(_wl_block9Bytes, _wl_block9);
 if(siteSpecServiceCode){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);
 if(siteSpecServiceCode){
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
            _bw.write(_wl_block13Bytes, _wl_block13);
}
			 if(siteSpecPatPayable.equals("true")){
            _bw.write(_wl_block14Bytes, _wl_block14);
} //V230222
            _bw.write(_wl_block15Bytes, _wl_block15);
	
	//Connection con	= null;//Commented for TH-KW-CRF-0143 by Kamatchi S
	Connection conSession = null;
	PreparedStatement pstmtSession = null ;
	ResultSet rsSession = null;
	String bean_id		=	"";
	String bean_name	=	"";
	String facilityId	= (String) session.getValue("facility_id");
	String encounter_id	= request.getParameter("ServiceEncounterId");
	String loginUser	= (String) session.getValue("login_user");
	String SessionId    = request.getParameter("ServiceSessionId");//session.getId();
	String PatientID=request.getParameter("patientId");//V201015 Added
	String episodeID=request.getParameter("episode_id");
	String visitID=request.getParameter("visit_Id");
	String episodeType=request.getParameter("episode_type");
	bean_id				= "CACoderFunction" ;
	bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
	String coderClearanceStatus = "";
	coderClearanceStatus = bean.getCoderClearanceStatus(facilityId,PatientID,episodeType,episodeID,visitID);
	DecimalFormat df = new DecimalFormat("0.00");//V230222
	String User			=	"";
	String Sys_Message_ID="";
	String Message_Text="";
	java.util.Properties p=null;
	p = (java.util.Properties) session.getValue( "jdbc" );
	String WS_NO  = p.getProperty("client_ip_address");
	bean_id		= 	"BLCoderPatServiceBean" ;
	bean_name	= 	"eBL.BLCoderPatServiceBean"; 
	LinkedHashMap 	blCoderpatServices	=	null;
	BLCoderPatServiceBean blCoderPatServiceBean = 	null;
	BLCoderPatService	blCoderPatService = null;	
	blCoderpatServices	=	new LinkedHashMap();
	blCoderPatServiceBean	= 	(BLCoderPatServiceBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request );
	blCoderPatServiceBean.clearBean();
	
	String sessioStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String localeLang			= (String)session.getAttribute("LOCALE");

	//if(Transaction_Status.equals("S")){	//Loading DB Values from Temporary table to HasMap
			blCoderPatServiceBean.getDBValues(SessionId,facilityId,encounter_id);
		//}
	//Getting Loaded Hashmap with Services
	int limit=1;
	String KeyValue="";
	String EpisodeType=request.getParameter("episode_type");//V201015 Added
	String EpisodeID=request.getParameter("episode_id");//V201015 Added
	String logInUserId=loginUser;//V201015 Added
	String logInWSno=WS_NO;//V201015 Added
	String VisitID="";
	int serviceSize=0;
	//SimpleDateFormat serviceIPSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
	//SimpleDateFormat serviceOPSdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	blCoderpatServices	= 	(LinkedHashMap)blCoderPatServiceBean.getBLCoderPatSearchValues();

	serviceSize=blCoderpatServices.size();
	if(!blCoderpatServices.isEmpty()) {
         Iterator it = blCoderpatServices.entrySet().iterator();
         while(it.hasNext()) {
            Map.Entry obj = (Entry)it.next();
           blCoderPatService=(BLCoderPatService)obj.getValue();
		   KeyValue=(String)obj.getKey();
		   if(blCoderPatService!=null){
			   //Login User ID
			   logInUserId= blCoderPatService.getlogInID();
				logInUserId=(logInUserId==null?"":logInUserId);
				//Login WS No ID
			   logInWSno= blCoderPatService.getlogInWSNo();
				logInWSno=(logInWSno==null?"":logInWSno);
			   //Bill Doc type code
			   String BillDocTypeCode= blCoderPatService.getBillDocTypeCode();
				BillDocTypeCode=(BillDocTypeCode==null?"":BillDocTypeCode);
			   //Bill Doc Number
			   String BillDocNo= blCoderPatService.getBillDocNum();
				BillDocNo=(BillDocNo==null?"":BillDocNo);
			   //Customer Group Code
			   String CustGrpCode= blCoderPatService.getCustGroupCode();
				CustGrpCode=(CustGrpCode==null?"":CustGrpCode);
			   //Customer Code
			   String CustCode= blCoderPatService.getCustCode();
				CustCode=(CustCode==null?"":CustCode);
			   //TRX Doc Ref
			   String TrxDocRef= blCoderPatService.getTrxDocRef();
				TrxDocRef=(TrxDocRef==null?"":TrxDocRef);
			   //TRX Doc Ref Line No
			   String TrxDocRefLineNo= blCoderPatService.getTrxDocRefLineNum();
				TrxDocRefLineNo=(TrxDocRefLineNo==null?"":TrxDocRefLineNo);
			   //TRX Doc Ref Seq No
			   String TrxDocRefSeqNo= blCoderPatService.getTrxDocRefSeqNum();
				TrxDocRefSeqNo=(TrxDocRefSeqNo==null?"":TrxDocRefSeqNo);
			   //TRX Date
			   String TrxDate= blCoderPatService.getTrxDate();
				TrxDate=(TrxDate==null?"":TrxDate);
				/*if(!TrxDate.equals("")){
				java.util.Date servdateTime3 = serviceIPSdf.parse(TrxDate);
				TrxDate = serviceOPSdf.format(servdateTime3);
				}*/
			   //Episode Type
			    EpisodeType= blCoderPatService.getEpisodeType();
				EpisodeType=(EpisodeType==null?"":EpisodeType);
			   //Episode Id
			    EpisodeID= blCoderPatService.getEpisodeId();
				EpisodeID=(EpisodeID==null?"":EpisodeID);
			   //Visit Id
			    VisitID= blCoderPatService.getVisitId();
				VisitID=(VisitID==null?"":VisitID);
			   //Settlement Ind
			   String SettlementInd= blCoderPatService.getSettlementInd();
				SettlementInd=(SettlementInd==null?"":SettlementInd);
			   //Patient Amount
			   String PatientAmt= blCoderPatService.getPatientAmount();
				PatientAmt=(PatientAmt==null?"":PatientAmt);
			   //Date and Time
				String Service_Date=  blCoderPatService.getServiceDate();
				Service_Date=(Service_Date==null?"":Service_Date);
				/*if(!Service_Date.equals("")){
				java.util.Date servdateTime2 = serviceIPSdf.parse(Service_Date);
				Service_Date = serviceOPSdf.format(servdateTime2);
				}*/
			   // Drug-NonDrug
				String Service_Type_Ind=  blCoderPatService.getServTypeInd();
				Service_Type_Ind=(Service_Type_Ind==null?"":Service_Type_Ind);
				String opt1="";
				String opt2="";
				String opt3="";
				if(Service_Type_Ind.equals("") || Service_Type_Ind.equals("S")){
					Service_Type_Ind="S";
					opt1="";
					opt2="selected";
					opt3="";
				}else if(Service_Type_Ind.equals("I")){
					Service_Type_Ind="I";
					opt1="";
					opt2="";
					opt3="selected";
				}else{
					Service_Type_Ind="I";
					opt1="selected";
					opt2="";
					opt3="";
				}
			   // Service Type
				String Service_Type=  blCoderPatService.getServTypeDesc();
				Service_Type=(Service_Type==null?"":Service_Type);
				//Pre Approval Flag
				String preAppFlag=  blCoderPatService.getPreAppFlag();
				preAppFlag=(preAppFlag==null?"":preAppFlag);
				// CPT Code
				String CPT_Code=  blCoderPatService.getcptCode();
				CPT_Code=(CPT_Code==null?"":CPT_Code);
			   // Service Code
				String Service_Code=  blCoderPatService.getServItemCode();
				Service_Code=(Service_Code==null?"":Service_Code);
			   // Service Description
				String Service_Desc=  blCoderPatService.getServItemDesc();
				Service_Desc=(Service_Desc==null?"":Service_Desc);
			   // Ordering Clinician Id
				String Ordering_Clinician=  blCoderPatService.getPhysicianId();
				Ordering_Clinician=(Ordering_Clinician==null?"":Ordering_Clinician);
				//ordering Physician Name
				String orderingClinicianName=  blCoderPatService.getOrderingPhysicianName();
				orderingClinicianName=(orderingClinicianName==null?"":orderingClinicianName);
			   // Performing Clinician Id
				String Perform_Clinician=  blCoderPatService.getPerformPhysicianId();
				Perform_Clinician=(Perform_Clinician==null?"":Perform_Clinician);
				//Perform Physician Name 
				String performClinicianName=  blCoderPatService.getPerformPhysicianName();
				performClinicianName=(performClinicianName==null?"":performClinicianName);
			   // Quantity
				String Quantity=  blCoderPatService.getServQty();
			   // Modifier/Adjuster
				String Mod_Adjus=  blCoderPatService.getModifierAdjusterId();
				Mod_Adjus=(Mod_Adjus==null?"":Mod_Adjus);
			   // Zero Price
				String Zero_Price=  blCoderPatService.getZeroPriceYN();
				String  disableCancelFlag="";
				Zero_Price=(Zero_Price==null?"":Zero_Price);
				if(Zero_Price.equals("Y")){
					Zero_Price="checked";
					disableCancelFlag="disabled";
				}else{
					Zero_Price="unchecked";
					disableCancelFlag="";
				}					
			   // Approval Number
				String Approval_No=  blCoderPatService.getCDRApprovalNo();
				Approval_No=(Approval_No==null?"":Approval_No);
			   // Approval Date
				String Approval_Date=  blCoderPatService.getCDRApprovalDate();
				Approval_Date=(Approval_Date==null?"":Approval_Date);
				/*if(!Approval_Date.equals("")){
				java.util.Date servdateTime4 = serviceIPSdf.parse(Approval_Date);
				Approval_Date = serviceOPSdf.format(servdateTime4);
				}*/
			   // Service Price
				String Service_Price=  blCoderPatService.getServiceAmount();
			   // Insurance Amount
				String Ins_Amt=  blCoderPatService.getInsuranceAmount();
				Float insAmt=Float.parseFloat(Ins_Amt);
				Ins_Amt = df.format(insAmt);System.err.println("Ins_Amt 2165 "+Ins_Amt);
				//V230222
				String pat_pay=  blCoderPatService.getPatientPayable();
				Float pat_payable=Float.parseFloat(pat_pay);
				pat_pay = df.format(pat_payable);
				
				System.err.println("Ins_Amt 2162 "+Ins_Amt);
				System.err.println("SettlementInd 2162 "+SettlementInd);
				System.err.println("pat_pay 2162 "+pat_pay);
				
				//V230222
			   // Billable CheckBox
				String Billable_Check=  blCoderPatService.getBillableYN();
				Billable_Check=(Billable_Check==null?"":Billable_Check);
				if(Billable_Check.equals("Y")){
					Billable_Check="checked";
				}else{
					Billable_Check="unchecked";
				}	
				//BillYN
				String	Bill_YN=blCoderPatService.getBillYN();
				String  disableBillFlag="";
				String  isbilled="";//V230516
				String boldYN="";//V230516
				System.out.println("Bill_YN "+Bill_YN);
				System.out.println("siteSpecPatPayable "+siteSpecPatPayable);
				
				if(Bill_YN.equals("Y")){
					Bill_YN="checked";
					disableBillFlag="disabled";
					 if(siteSpecSearch.equals("true")){
						isbilled="";//V230516-AAKH-CRF-0153
						boldYN="";
					 }
				}else{
					Bill_YN="unchecked";
					disableBillFlag="";
					 if(siteSpecSearch.equals("true")){
						isbilled="unbilled";//V230516-AAKH-CRF-0153
						boldYN="bolder";
					 }
				}			
			   // Add Row
				String AddRow=  blCoderPatService.getAddRowYN();
				AddRow=(AddRow==null?"":AddRow);
				if(AddRow.equals("Y")){
					AddRow="disabled";
				}else{
					AddRow="";
				}
			   // Cancel Services
				String Cancel_Services=  blCoderPatService.getCancelRowYN();
				String elemProp="";
				Cancel_Services=(Cancel_Services==null?"":Cancel_Services);
				if(Cancel_Services.equals("Y")){
					Cancel_Services="checked";
					elemProp="disabled";
				}else{
					Cancel_Services="unchecked";
					elemProp="";
				}
				//Primary Key Module
				String primKeyModFlag="";
				String primKeyModId=blCoderPatService.getprimaryKeyModID();
				primKeyModId=(primKeyModId==null?"":primKeyModId);
				if(primKeyModId.equals("PH") || primKeyModId.equals("ST")){
					primKeyModFlag="disabled";
				}				

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disableBillFlag));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Date));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(opt1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(opt2));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(opt3));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(preAppFlag));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(CPT_Code));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(!siteSpecServiceCode){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Code));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Service_Desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
if(siteSpecServiceCode){
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Code));
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(orderingClinicianName));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Ordering_Clinician));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(performClinicianName));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(elemProp));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disableBillFlag));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Perform_Clinician));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(Quantity));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(Mod_Adjus));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(Zero_Price));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(Zero_Price));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(Approval_No));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Approval_No));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(Approval_Date));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Approval_Date));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disableBillFlag));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(Service_Price));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Ins_Amt));
            _bw.write(_wl_block98Bytes, _wl_block98);
 if(siteSpecPatPayable.equals("true")){
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_pay));
            _bw.write(_wl_block98Bytes, _wl_block98);
} //V230222
			
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Billable_Check));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(Billable_Check));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Bill_YN));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block109Bytes, _wl_block109);
if(siteSpecServiceCode){
            _bw.write(_wl_block110Bytes, _wl_block110);
}else{
			
            _bw.write(_wl_block111Bytes, _wl_block111);
}
            _bw.write(_wl_block112Bytes, _wl_block112);
if(siteSpecServiceCode && coderClearanceStatus.equals("Y")){
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(Cancel_Services));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disableCancelFlag));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(primKeyModFlag));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(primKeyModId));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(BillDocTypeCode));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(BillDocNo));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(CustGrpCode));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(CustCode));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(TrxDocRef));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(TrxDocRefLineNo));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(TrxDocRefSeqNo));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(TrxDate));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(SettlementInd));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(PatientAmt));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(KeyValue));
            _bw.write(_wl_block126Bytes, _wl_block126);
 if(siteSpecSearch.equals("true") || siteSpecPatPayable.equals("true")){
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block55Bytes, _wl_block55);
 }
            _bw.write(_wl_block131Bytes, _wl_block131);
				
			} 
			limit++;				
         }
      }//V201015 Starts
	  else{
		   
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block141Bytes, _wl_block141);
if(!siteSpecServiceCode){
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block143Bytes, _wl_block143);
}
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block145Bytes, _wl_block145);
if(siteSpecServiceCode){
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block147Bytes, _wl_block147);
}
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block165Bytes, _wl_block165);
 if(siteSpecPatPayable.equals("true")){
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block167Bytes, _wl_block167);
} //V230222
			
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block109Bytes, _wl_block109);
	if(siteSpecServiceCode){
            _bw.write(_wl_block110Bytes, _wl_block110);
}else{
			
            _bw.write(_wl_block111Bytes, _wl_block111);
}
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block178Bytes, _wl_block178);
 if(siteSpecSearch.equals("true") || siteSpecPatPayable.equals("true")){
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block147Bytes, _wl_block147);
 }
            _bw.write(_wl_block180Bytes, _wl_block180);

	  }	
		//V201015 Ends	  

            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(localeLang));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(EpisodeID));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(EpisodeType));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(PatientID));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(VisitID));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(logInWSno));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(logInUserId));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(SessionId));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(siteSpecPatPayable));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(serviceSize));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(siteSpecServiceCode));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(siteSpecSearch));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block197Bytes, _wl_block197);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
