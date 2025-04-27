package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import eDS.DSCommonBean;
import eDS.*;
import java.util.ArrayList;
import java.net.URLEncoder;
import java.util.*;
import com.ehis.util.*;

public final class __documentmealservedemrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/DocumentMealServedEMRecord.jsp", 1709184548000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\nFile Name\t\t: DocumentMealServedOPRecord.jsp\nFile Description: Document Result frame: This is to document/acknowledge the placed order .\nCRF#\t\t\t: Bru-HIMS-CRF-230\nAuthor\t\t\t: Abirami\nDate\t\t\t: Aug-2013\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="<!-- Modified Against ML-MMOH-CRF-1125 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\"StyleSheet\" type=\"text/css\"\n\thref=\"../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></link>\n<link rel=\"stylesheet\" type=\"text/css\"\n\thref=\"../../eCommon/html/CommonCalendar.css\" />\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"Javascript\" src=\"../../framework/js/PopupWindow.js\"></script>\n<script language=\"Javascript\" src=\"../../eDS/js/json.js\"></script>\n<script language=\"Javascript\" src=\"../../eDS/js/DocumentOPMealServed.js\"></script>\n<script language=\"javascript\" src=\"../../eDS/js/DSCommon.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t<form name=\"MultipleSelectForAllPatients\" id=\"MultipleSelectForAllPatients\">\n<!-- ML-MMOH-CRF-0681-->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<!-- ML-MMOH-CRF-0681-->\n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/> <!-- Added Against 683 CRF-->\n\t<!-- Added Against ML-MMOH-CRF-1061-US4 Starts Here -->\t\n\t<input type=\"hidden\" name=\"OPstatus_Ser_YN\" id=\"OPstatus_Ser_YN\" id=\"OPstatus_Ser_YN\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n\t<input type=\"hidden\" name=\"OPstatus_Acc_YN\" id=\"OPstatus_Acc_YN\" id=\"OPstatus_Acc_YN\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n\t<input type=\"hidden\" name=\"OPstatus_Rej_YN\" id=\"OPstatus_Rej_YN\" id=\"OPstatus_Rej_YN\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\t\n\t<!-- Added Against ML-MMOH-CRF-1061-US4 Ends Here -->\n\t<input type=\"hidden\" name=\"isMealComplaints\" id=\"isMealComplaints\" id =\"isMealComplaints\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"> <!-- Added Against ML-MMOH-CRF-1125-->\n\t<div id=\"tableResult\" style=\"display:none\">\n\t<table width=\"100%\" border=\"0\">\n\t\t\t<tr align=\"left\">\n\t\t\t\t<td width=20% align=\"right\" class=\"label\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t<!-- <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> -->\n\n\t\t\t\t<td width=50% >\n\t\t\t\t\t<select name=\"setStatus\" id=\"setStatus\" onchange=\"setStatusForAll();\">\n\t\t\t\t\t\t<option value=\'\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t<!-- Modified Against ML-MMOH-CRF-1061-US4 Starts Here -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<option value=\'MS\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<option value=\'MA\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<option value=\'MR\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<!-- Modified Against ML-MMOH-CRF-1061-US4 Starts Here -->\n\t\t\t\t\t</select>\n\t\t\t\t\t<input type=\"text\" name=\"setDate\" id=\"setDate\" onchange=\"setDateForAll();\" size=\"16\" maxlength=\"16\" value =\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onclick=\"showCalendar(\'setDate\',\'DD/MM/YYYY\',\'hh:mm\');setDateForAll();\"/>\n\t\t\t\t</td>\n\t\t\t\t<td width=20%>&nbsp;</td>\n\t\t\t</tr>\n\t</table>\n\t\n\t<table align=\'right\'>\n\t<tr nowrap>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t<td>\n\t<A HREF=\"../../eDS/jsp/DocumentMealServedEMRecord.jsp?from=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&to=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" text-decoration=\'none\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</A>\n\t</td>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t<td id=\"hrefNextMealOrder\">\n\t<A HREF=\"../../eDS/jsp/DocumentMealServedEMRecord.jsp?from=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</A>\n\t</td>\n\t</tr>\n\t</table>\n\t<br><br>\n\t\t<table border=\'1\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=\"mealSelectedTable\">\n\t\t\t<tr>\n\t\t\t\t<TH class=\'ColumnHeaderCenter\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t</th>\n\t\t\t\t<TH class=\'ColumnHeaderCenter\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t</TH>\n\t\t\t\t<TH class=\'ColumnHeaderCenter\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t</TH>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<TH class=\'ColumnHeaderCenter\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\t\n\t\t\t\t<TH class=\'ColumnHeaderCenter\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t</TH> \n\t\t\t\t<TH class=\'ColumnHeaderCenter\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t</TH>\n\t\t\t\t<!-- Added Against Start 683 CRF-->\n\t\t\t\t<TH class=\'ColumnHeaderCenter\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t</TH>\n\t\t\t\t<!-- Added Against End 683 CRF-->\n\t\t\t\t<!--Added Against Start ML-MMOH-CRF-681-->\n\t\t\t\t<TH class=\'ColumnHeaderCenter\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t</TH>\n\t\t\t\t<!-- Added Against End ML-MMOH-CRF-681-->\n\t\t\t</tr>\n\t\t\t<tbody id=\"divDocEMOrderList\">\n\t\t\t</tbody>\n\t\t\t<input type=hidden name=\"totalRows_EM\" id=\"totalRows_EM\" value=\"\"/>\n\t\t</table>\n\t\t</div>\n\t\t<script>\n\tloadResult();\n\t\t// Function  : This will executed on loading of this Script: - Start\n\t\n\tfunction loadResult()\n\t{\n\t\tvar jsonDataObject = new Object();\n\t\tvar orderList=new Array();\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\tvar xmlStr =\"<root></root>\";\n\t\t\n\t\t//jsonDataObject.facilityid \t= parent.frames[1].document.forms[0].facility_id.value;\n// \t\tjsonDataObject.speciality \t= parent.frames[1].document.getElementById(\"speciality\").value;\n\t\tjsonDataObject.locationType = parent.frames[1].document.getElementById(\"loctype_EM\").value;\n\t\t\n\t\tif(jsonDataObject.locationType == \"Y\")\n\t\t\tjsonDataObject.locationType = \"D\";\n\t\t\t\n\t\tif(parent.frames[1].document.getElementById(\"location_EM\").value == \"\")\n\t\t\tjsonDataObject.locationCode = \"\";\n\t\telse\n\t\t\tjsonDataObject.locationCode = parent.frames[1].document.getElementById(\"hdnlocation_EM\").value;\n\t\t\n\t\tjsonDataObject.restype \t\t= parent.frames[1].document.getElementById(\"resourceType_EM\").value; \n\t\tif(parent.frames[1].document.getElementById(\"practitioner_name_EM\").value == \"\")\n\t\t\tjsonDataObject.resource\t\t= \"\";\n\t\telse\n\t\t\tjsonDataObject.resource \t= parent.frames[1].document.getElementById(\"practitioner_EM\").value; \n\t\t\n\t\tjsonDataObject.servingdate  = parent.frames[1].document.getElementById(\"servingdate_EM\").value;\n\t\tjsonDataObject.mealType\t\t= parent.frames[1].document.getElementById(\"mealType_EM\").value; \n\t\tjsonDataObject.priorityZone\t\t= parent.frames[1].document.getElementById(\"priorityZone\").value; \n\t\tjsonDataObject.treatmentArea\t\t= parent.frames[1].document.getElementById(\"treatmentArea\").value;\n\n\t\tvar jsonData = JSON.stringify(jsonDataObject);\n\n\t\t \n\t\tvar param=\"jsonData=\"+jsonData+\"&language_Id=en&mode=searchDocMealOrder_EM\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\", \"../../servlet/eDS.DocumentOPMealServlet?\"+param,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal = xmlHttp.responseText;\n\n\t\tvar jsonObjResponse=eval(\'(\' + retVal + \')\');\n\n\t\t//Getting Meal Record List::\n\t\t\n\t\torderList = jsonObjResponse.jsonDocOPOrderList;\n\t\tvar divOrderList = document.getElementById(\"divDocEMOrderList\");\n\t\tvar row_ind1 = 0;\n\n\t\tvar from = document.getElementById(\"from\").value;\n\t\tvar to = document.getElementById(\"to\").value;\n\t\t\n\t\t//Added Against ML-MMOH-CRF-1061-US4 Starts Here\n\t\tvar OPstatus_Ser_YN = document.getElementById(\"OPstatus_Ser_YN\").value;\n\t\tvar OPstatus_Acc_YN = document.getElementById(\"OPstatus_Acc_YN\").value;\n\t\tvar OPstatus_Rej_YN = document.getElementById(\"OPstatus_Rej_YN\").value;\n\t\t//Added Against ML-MMOH-CRF-1061-US4 Ends Here\n\t\tvar isMealComplaints = document.getElementById(\"isMealComplaints\").value;//Added Against ML-MMOH-CRF-1125\n\t\t//var start = 0;\n\t\t//var end =13;\n\t\tvar start = \"\";\n\t\tvar end = \"\";\n\t\tif(from == \"\")\n\t\t  start = 0; \n\t\telse\n\t\t  start = from;\n\t\t  \n\t\tif(to == \"\")\n\t\t  end = 13; \n\t\telse\n\t\t  end = to;\n\n\t\tif(orderList!=null)\n\t\t{\n\t\t\t//getting maximum record\n\t\t\t//document.getElementById(\"totalRows\").value = orderList.length;\n\t\t\tif(orderList.length == 0){\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\tdocument.getElementById(\"tableResult\").style.display = \"none\";\n\t\t\t\treturn;\n\t\t\t}\t\n\t\t\telse{\n\t\t\t\tdocument.getElementById(\"tableResult\").style.display = \"inline\";\n\t\t\t\t//for(var itr=0; itr < orderList.length;itr++){\n\t\t\t\tif(orderList.length <= end)\n\t\t\t\t{\n\t\t\t\t\tend = orderList.length;\n\t\t\t\t\tdocument.getElementById(\"hrefNextMealOrder\").innerHTML=\"\";\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t//if((from+13) == orderList.length)\n\t\t\t\t//\tdocument.getElementById(\"hrefNextMealOrder\").innerHTML=\"\";\n\t\t\t\t\t\n\t\t\t\tfor(var itr=start; parseInt(itr,10) <parseInt(end,10);itr++){\n\t\t\t\t\n\t\t\t\t\t\tvar newRow3 = divOrderList.insertRow(row_ind1);\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar newCellDesc = fnInsertCell(newRow3);\n\t\t\t\t\t\tvar selPatId = \"<label>\"+orderList[itr].patient_id+\"</label>\";\n\t\t\t\t\t\tselPatId += \"<input type=hidden  name=\\\'patId_EM\"+ row_ind1+\"\\\' id=\\\'patId_EM\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].patient_id+\"\\\'/>\";\n\t\t\t\t\t\tnewCellDesc.innerHTML = selPatId;\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\t\tvar selEnctId;\n\t\t\t\t\t\tif(orderList[itr].Encounterid == null)\n\t\t\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\t\t\tselEnctId = \"<label>&nbsp;</label>\";\n\t\t\t\t\t\t\tselEnctId += \"<input type=hidden  name=\\\'encounterid_EM\"+ row_ind1+\"\\\' id=\\\'encounterid_EM\"+ row_ind1+\"\\\' value=\\\'\'/>\";\n\t\t\t\t\t\t}else\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tselEnctId = \"<label>\"+orderList[itr].Encounterid+\"</label>\";\n\t\t\t\t\t\t\tselEnctId += \"<input type=hidden  name=\\\'encounterid_EM\"+ row_ind1+\"\\\' id=\\\'encounterid_EM\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].Encounterid+\"\\\'/>\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tnewCellDesc2.innerHTML = selEnctId;\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\t\tvar selPatName = \"<label>\"+orderList[itr].patient_name+\"</label>\";\n\t\t\t\t\t\tselPatName += \"<input type=hidden  name=\\\'patName_EM\"+ row_ind1+\"\\\' id=\\\'patName_EM\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].patient_name+\"\\\'/>\";\n\t\t\t\t\t\tnewCellDesc2.innerHTML = selPatName;\n\t\t\t\t\t\t\n\t\t\t\t\t\t/* var newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\t\tvar selApptDate = \"\";\n\t\t\t\t\t\tif(orderList[itr].ApptDate != null && orderList[itr].ApptDate != \"undefined\" && orderList[itr].ApptDate != \"\")\n\t\t\t\t\t\t\tselApptDate = \"<label>\"+orderList[itr].ApptDate + \" \" + orderList[itr].ApptTime +\"</label>\";\n\t\t\t\t\t\telse\t\n\t\t\t\t\t\t\tselApptDate = \"<label>&nbsp;</label>\";\n\t\t\t\t\t\tselApptDate += \"<input type=hidden  name=\\\'apptDate\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].ApptDate + \" \" + orderList[itr].ApptTime +\"\\\'/>\";\n\t\t\t\t\t\tnewCellDesc2.innerHTML = selApptDate; */\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\t\tvar selVisitDate = \"\";\n\t\t\t\t\t\tif(orderList[itr].VisitDate != null && orderList[itr].VisitDate != \"undefined\" && orderList[itr].VisitDate != \"\")\n\t\t\t\t\t\t\tselVisitDate = \"<label>\"+orderList[itr].VisitDate+\"</label>\";\n\t\t\t\t\t\telse\t\n\t\t\t\t\t\t\tselVisitDate = \"<label>&nbsp;</label>\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\tselVisitDate += \"<input type=hidden  name=\\\'visitDate_EM\"+ row_ind1+\"\\\' id=\\\'visitDate_EM\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].VisitDate+\"\\\'/>\";\n\t\t\t\t\t\tnewCellDesc2.innerHTML = selVisitDate;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t/* var newCellDesc2 = fnInsertCell(newRow3); \n\t\t\t\t\t\tvar selApptNo;\n\t\t\t\t\t\tif(orderList[itr].ApptNo == null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tselApptNo = \"<label>&nbsp;</label>\";\n\t\t\t\t\t\t\tselApptNo += \"<input type=hidden  name=\\\'apptNo\"+ row_ind1+\"\\\' value=\\\'\'/>\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tselApptNo = \"<label>\"+orderList[itr].ApptNo+\"</label>\";\n\t\t\t\t\t\t\tselApptNo += \"<input type=hidden  name=\\\'apptNo\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].ApptNo+\"\\\'/>\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\tnewCellDesc2.innerHTML = selApptNo; */\n\t\t\t\t\t\t\n\t\t\t\t\t\t//Status:\n\t\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\t\tvar selObj = \"<SELECT name=\'status_EM\"+row_ind1+\"\' id=\'status_EM\"+row_ind1+\"\' onchange=\\\"chkStatus(this,\'\"+row_ind1+\"\');\\\">\";\n\t\t\t\t\t\tvar label=\"Select\";\n\t\t\t\t\t\tselObj += \"<option value=\'\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</option>\";\n\t\t\t\t\t\t\n\t\t\t\t//Modified Against ML-MMOH-CRF-1061-US4 Starts Here \n\t\t\t\t\tif(OPstatus_Ser_YN==\'Y\'){\n\t\t\t\t\t\tif(orderList[itr].status == \'MS\')\n\t\t\t\t\t\t\tselObj += \"<option value=\'MS\' selected>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</option>\";\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tselObj += \"<option value=\'MS\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</option>\";\n\t\t\t\t\t}\t\n\t\t\t\t\tif(OPstatus_Acc_YN==\'Y\'){\t\t\t\t\t\n\t\t\t\t\t\tif(orderList[itr].status == \'MA\')\n\t\t\t\t\t\t\tselObj += \"<option value=\'MA\' selected>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</option>\";\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tselObj += \"<option value=\'MA\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</option>\";\n\t\t\t\t\t}\n\t\t\t\t\tif(OPstatus_Rej_YN==\'Y\'){\n\t\t\t\t\t\tif(orderList[itr].status == \'MR\')\n\t\t\t\t\t\t\tselObj += \"<option value=\'MR\' selected>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option>\";\t\t\t\t\t\t\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tselObj += \"<option value=\'MR\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option>\";\n\t\t\t\t\t}\n\t\t\t\t//Modified Against ML-MMOH-CRF-1061-US4 Ends Here\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(orderList[itr].status != null)\n\t\t\t\t\t\t\tselObj += \"<input type=hidden  name=\\\'hdnstatus_EM\"+ row_ind1+\"\\\' id=\\\'hdnstatus_EM\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].status+\"\\\'/>\";\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tselObj += \"<input type=hidden  name=\\\'hdnstatus_EM\"+ row_ind1+\"\\\' id=\\\'hdnstatus_EM\"+ row_ind1+\"\\\' value=\\\'\'/>\";\n\t\t\t\t\t\tnewCellDesc2.innerHTML = selObj;\n\t\t\t\t\t\t\n\t\t\t\t\t\t// Acknowledgement Date:://ML-MMOH-CRF-681\n\t\t\t\t\t\tvar newCellDesc2 = newRow3.insertCell(newRow3.cells.length);\n\t\t\t\t\t\tvar sAckDate = orderList[itr].AckDate;\t\n\t\t\t\t\t\tvar sCurDate = orderList[itr].sys_date;\t\t\t\t\t\t\n\t\t\t\t\t\tif(sAckDate == null || sAckDate == \"undefined\" || sAckDate == \"\")\n\t\t\t\t\t\t\tsCurDate = orderList[itr].sys_date; \n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tsCurDate = orderList[itr].AckDate;\n\t\t\t\t\t\n\t\t\t\t\t\tvar selAckDate = \"<input type=\\\"text\\\" name=\\\'ackDate_EM\"+row_ind1+\"\\\' id=\\\'ackDate_EM\"+row_ind1+\"\\\' value=\\\'\"+ sCurDate + \"\\\'  onblur=\\\"if(trim(this.value)!=\'\')isValidDateTime_AllPatients(this);\\\" >\";\n\t\t\t\t\t\tselAckDate += \"<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"return showCalendar(\'ackDate_EM\"+row_ind1+\"\\\',\'DD/MM/YYYY\',\'hh:mm\');\\\" >\"; \n\t\t\t\t\t\tselAckDate += \"<input type=hidden  name=\\\'hdnackDate_EM\"+ row_ind1+\"\\\' id=\\\'hdnackDate_EM\"+ row_ind1+\"\\\' value=\\\'\"+sCurDate+\"\\\'/>\";\n\t\t\t\t\t\t//ML-MMOH-CRF-681\n\t\t\t\t\t\t\n\t\t\t\t\t\tnewCellDesc2.innerHTML = selAckDate;\n\t\t\t\t\t\tnewCellDesc.align = \"center\";\n\t\t\t\t\t\t\n\t\t\t\t\t\t//Compliants Added in Emergency Added Against Start ML-MMOH-CRF-0683 [IN062278]\n\t\t\t\t//Modified Against ML-MMOH-CRF-1125 Starts Here\n\t\t\t\tif(isMealComplaints==\"true\"){\n\t\t\t\t\tif(orderList[itr].othersComp_desc!=\"\" && orderList[itr].status==\'MR\'){\n\t\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\t\t\t\t\t\t\n\t\t\t\t\t\tvar selComplaint = \"<input type=\\\"text\\\"  id=\\\'complaintDesc\"+row_ind1+\"\\\' name=\\\'complaintDesc\"+ row_ind1+\"\\\' id=\\\'complaintDesc\"+ row_ind1+\"\\\' disabled value=\\\'\"+orderList[itr].complaint_desc+\"\\\' onblur=\\\"if(trim(this.value)!=\'\') return complaintsLookup(\'complaintDesc\"+row_ind1+\"\',\'\"+row_ind1+\"\\\');\\\" >\";\n\t\t\t\t\t\tvar empty=\"\";\n\n\t\t\t\t\t\tselComplaint += \"<input type=hidden  id=\\\'complaintCode\"+row_ind1+\"\\\' name=\\\'complaintCode\"+ row_ind1+\"\\\' id=\\\'complaintCode\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].complaint_code+\"\\\'/>\";\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar sym= \"?\";\n\t\t\t\t\t\tselComplaint += \"<input type=\\\"button\\\" id=\\\'bt\"+row_ind1+\"\\\' disabled class=\\\"BUTTON\\\" name=\\\'bt\"+row_ind1+\"\\\' id=\\\'bt\"+row_ind1+\"\\\' value=\\\'\"+ sym + \"\\\'  onclick=\\\"if(trim(this.value)!=\'\') return complaintsLookup(\'complaintDesc\"+row_ind1+\"\',\'\"+row_ind1+\"\\\');\\\" >\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\t\t\t\t\t\t\n\t\t\t\t\t\tvar selComplaint = \"<input type=\\\"text\\\"  id=\\\'complaintDesc\"+row_ind1+\"\\\' name=\\\'complaintDesc\"+ row_ind1+\"\\\' id=\\\'complaintDesc\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].complaint_desc+\"\\\' onblur=\\\"if(trim(this.value)!=\'\') return complaintsLookup(\'complaintDesc\"+row_ind1+\"\',\'\"+row_ind1+\"\\\');\\\" onchange=\\\"enableOthers_EM(\'\"+row_ind1+\"\');\\\"  >\";\n\t\t\t\t\t\tvar empty=\"\";\n\n\t\t\t\t\t\tselComplaint += \"<input type=hidden  id=\\\'complaintCode\"+row_ind1+\"\\\' name=\\\'complaintCode\"+ row_ind1+\"\\\' id=\\\'complaintCode\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].complaint_code+\"\\\'/>\";\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar sym= \"?\";\n\t\t\t\t\t\tselComplaint += \"<input type=\\\"button\\\" id=\\\'bt\"+row_ind1+\"\\\' class=\\\"BUTTON\\\" name=\\\'bt\"+row_ind1+\"\\\' id=\\\'bt\"+row_ind1+\"\\\' value=\\\'\"+ sym + \"\\\'  onclick=\\\"if(trim(this.value)!=\'\') return complaintsLookup(\'complaintDesc\"+row_ind1+\"\',\'\"+row_ind1+\"\\\');\\\" >\";\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\t\t\t\t\t\t\n\t\t\t\t\t\tvar selComplaint = \"<input type=\\\"text\\\"  id=\\\'complaintDesc\"+row_ind1+\"\\\' name=\\\'complaintDesc\"+ row_ind1+\"\\\' id=\\\'complaintDesc\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].complaint_desc+\"\\\' onblur=\\\"if(trim(this.value)!=\'\') return complaintsLookup(\'complaintDesc\"+row_ind1+\"\',\'\"+row_ind1+\"\\\');\\\" >\";\n\t\t\t\t\t\tvar empty=\"\";\n\n\t\t\t\t\t\tselComplaint += \"<input type=hidden  id=\\\'complaintCode\"+row_ind1+\"\\\' name=\\\'complaintCode\"+ row_ind1+\"\\\' id=\\\'complaintCode\"+ row_ind1+\"\\\' value=\\\'\"+orderList[itr].complaint_code+\"\\\'/>\";\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\tvar sym= \"?\";\n\t\t\t\t\t\tselComplaint += \"<input type=\\\"button\\\" id=\\\'bt\"+row_ind1+\"\\\' class=\\\"BUTTON\\\" name=\\\'bt\"+row_ind1+\"\\\' id=\\\'bt\"+row_ind1+\"\\\' value=\\\'\"+ sym + \"\\\'  onclick=\\\"if(trim(this.value)!=\'\') return complaintsLookup(\'complaintDesc\"+row_ind1+\"\',\'\"+row_ind1+\"\\\');\\\" >\";\n\t\t\t\t}\n\t\t\t\t//Modified Against ML-MMOH-CRF-1125 Ends Here\n\t\t\t\t\n\t\t\t\t//Newly Added Against ML-MMOH-CRF-1125 Starts Here\n\t\t\t\tvar Others = \"Others\";\n\t\t\t\tif(isMealComplaints==\"true\"){\n\t\t\t\t\tif(orderList[itr].complaint_code == \"&nbsp\"){\n\t\t\t\t\t\torderList[itr].complaint_code=\"\";\t\t\t\n\t\t\t\t\t}\t\n\t\t\t\t\tif(orderList[itr].complaint_code!=\"\" && orderList[itr].status == \'MR\'){\n\t\t\t\t\t\t\tselComplaint += \"<a id=\\\'othersLink\"+row_ind1+\"\\\' name=\\\'othersLink\"+row_ind1+\"\\\' id=\\\'othersLink\"+row_ind1+\"\\\' style=\\\'visibility:visible\\\'  disabled href=\'javascript:OtherComplaints(\"+row_ind1+\");\'> \"+Others+\" </a>\";\n\t\t\t\t\t\t\tselComplaint +=\"<input type=hidden id=\\\'othersComp\"+row_ind1+\"\\\' name=\\\'othersComp\"+row_ind1+\"\\\' id=\\\'othersComp\"+row_ind1+\"\\\' value=\\\'\"+orderList[itr].othersComp_desc+\"\\\'>\";\n\t\t\t\t\t\t\tselComplaint += \"<img src=\'../../eCommon/images/mandatory.gif\' id=\\\'cmp\"+row_ind1+\"\\\'  style=\\\'visibility:visible\\\' />\";\n\t\t\t\t\t\t}else if(orderList[itr].othersComp_desc!=\"\" && orderList[itr].status == \'MR\'){\n\t\t\t\t\t\t\tselComplaint += \"<a id=\\\'othersLink\"+row_ind1+\"\\\' name=\\\'othersLink\"+row_ind1+\"\\\' id=\\\'othersLink\"+row_ind1+\"\\\' style=\\\'visibility:visible\\\'  href=\'javascript:OtherComplaints(\"+row_ind1+\");\'> \"+Others+\" </a>\";\n\t\t\t\t\t\t\tselComplaint +=\"<input type=hidden id=\\\'othersComp\"+row_ind1+\"\\\' name=\\\'othersComp\"+row_ind1+\"\\\' id=\\\'othersComp\"+row_ind1+\"\\\' value=\\\'\"+orderList[itr].othersComp_desc+\"\\\'>\";\n\t\t\t\t\t\t\tselComplaint += \"<img src=\'../../eCommon/images/mandatory.gif\' id=\\\'cmp\"+row_ind1+\"\\\'  style=\\\'visibility:visible\\\' />\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tselComplaint += \"<a id=\\\'othersLink\"+row_ind1+\"\\\' name=\\\'othersLink\"+row_ind1+\"\\\' id=\\\'othersLink\"+row_ind1+\"\\\' style=\\\'visibility:hidden\\\'  href=\'javascript:OtherComplaints(\"+row_ind1+\");\'> \"+Others+\" </a>\";\n\t\t\t\t\t\t\tselComplaint +=\"<input type=hidden id=\\\'othersComp\"+row_ind1+\"\\\' name=\\\'othersComp\"+row_ind1+\"\\\' id=\\\'othersComp\"+row_ind1+\"\\\' value=\\\'\"+orderList[itr].othersComp_desc+\"\\\'>\";\n\t\t\t\t\t\t\tselComplaint += \"<img src=\'../../eCommon/images/mandatory.gif\' id=\\\'cmp\"+row_ind1+\"\\\'  style=\\\'visibility:hidden\\\' />\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t\t//Newly Added Against ML-MMOH-CRF-1125 Ends Here\n\t\t\t\t\t\t\n\t\t\t\t\t\tselComplaint += \"<img src=\'../../eCommon/images/mandatory.gif\' id=\\\'cmp\"+row_ind1+\"\\\'  style=\\\'visibility:hidden\\\' />\";\n\t\t\t\t\t\tnewCellDesc2.innerHTML = selComplaint; \n\t\t\t\t\t\t//Added Against End ML-MMOH-CRF-0683 [IN062278]\n\t\t\t\t\t\t\n\t\t\t\t\t\t//Added Against Start ML-MMOH-CRF-681\t\n\t\t\t\t\t\tvar MealReplaceYn = orderList[itr].MealReplaceYn;\n\t\t\t\t\t\tif(MealReplaceYn == null || MealReplaceYn == \"undefined\" || MealReplaceYn == \"&nbsp\")\n\t\t\t\t\t\t\tMealReplaceYn = \"N\";\n\t\t\t\t\t\telse if(MealReplaceYn == \"Y\")\n\t\t\t\t\t\t\tMealReplaceYn = \"Y\";\n\t\t\t\t\t\tvar newCellDesc2 = fnInsertCell(newRow3);\n\t\t\t\t\t\tvar label=\"Select\";\n\t\t\t\t\t\tvar mealObj = \"\";\n\t\t\t\t\t\tif(orderList[itr].status == \'MR\'){\n\t\t\t\t\t\t\tmealObj = \"<SELECT id=\'MealReplaceYn\"+row_ind1+\"\' name=\'MealReplaceYn\"+row_ind1+\"\' id=\'MealReplaceYn\"+row_ind1+\"\'>\";\n\t\t\t\t\t\t\tif(MealReplaceYn ==\"N\"){\n\t\t\t\t\t\t\t\tmealObj += \"<option value=\'N\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\";\n\t\t\t\t\t\t\t\tmealObj += \"<option value=\'Y\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\";\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tmealObj += \"<option value=\'Y\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</option>\";\n\t\t\t\t\t\t\tmealObj += \"<option value=\'N\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</option>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tmealObj = \"<SELECT id=\'MealReplaceYn\"+row_ind1+\"\' name=\'MealReplaceYn\"+row_ind1+\"\' id=\'MealReplaceYn\"+row_ind1+\"\' disabled>\";\t\t\n\t\t\t\t\t\t\tmealObj += \"<option value=\'N\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</option>\";\n\t\t\t\t\t\t\tmealObj += \"<option value=\'Y\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</option>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\tif(orderList[itr].status != null){\n\t\t\t\t\t\t\tmealObj += \"<input type=hidden  name=\\\'mealstatus\"+ row_ind1+\"\\\' id=\\\'mealstatus\"+ row_ind1+\"\\\' value=\\\'\"+MealReplaceYn+\"\\\'/>\";\n\t\t\t\t\t\t\t}\t\n\t\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tmealObj += \"<input type=hidden  name=\\\'mealstatus\"+ row_ind1+\"\\\' id=\\\'mealstatus\"+ row_ind1+\"\\\' value=\\\'\'\"+MealReplaceYn+\"\'/>\";  \n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tnewCellDesc2.innerHTML = mealObj;\n\t\t\t\t\t\t//Added Against End ML-MMOH-CRF-681\t\n\t\t\t\t\t\trow_ind1++;\n\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\"totalRows_EM\").value = row_ind1;\n\t\t\t}\n\t\t}else\n\t\t{\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t}\n\t}\n\t// Function  : This will executed on loading of this Script: - End\n\t\t</script>\n\t</form>\n<!-- ML-MMOH-CRF-0681-->\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n<!-- ML-MMOH-CRF-0681-->\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	//Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 

            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String imgUrl = "";
	if (sStyle.equals("IeStyle.css")) {
		imgUrl = "../../eCommon/images/searchBoxBG.jpg";
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String sysDate ="";
	String locale=(String) session.getValue("LOCALE");
	//Added Against ML-MMOH-CRF-1061-US4 Starts Here
	String patient_class_OP="OP";
	String status_code_OP="";
	String status_desc_OP="";

	String status_code1="";
	String status_code2="";
	String status_code3="";
	String status_desc1="";
	String status_desc2="";
	String status_desc3="";
	
	String OPstatus_Ser_YN="";
	String OPstatus_Acc_YN="";
	String OPstatus_Rej_YN="";	
	String STATUS_ACT_YN_OP="";
	String sql_Query="";
	//Added Against ML-MMOH-CRF-1061-US4 Ends Here
	boolean isMealComplaints = false; //Added Against ML-MMOH-CRF-1125
	try{
		conn = ConnectionManager.getConnection(request);
		isMealComplaints = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_COMPLAINTS"); //Added Against ML-MMOH-CRF-1125
		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'DD/MM/YYYY HH24:MI') CURRENT_DATE FROM DUAL");

		rst = pstmt.executeQuery();
		while(rst.next()){
			sysDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMYHM","en",locale);
		}

		//Added Against ML-MMOH-CRF-1061-US4 Starts Here
			sql_Query= "SELECT status_code , status_desc ,STATUS_ACT_YN FROM DS_MEAL_ACK_STATUS_MAST WHERE disp_sl_no <= 3 AND patient_class ='"+patient_class_OP+"' AND STATUS_ACT_YN ='Y' ORDER BY patient_class, disp_sl_no DESC";
			pstmt=conn.prepareStatement(sql_Query);
			rst=pstmt.executeQuery();
			while (rst.next()){		
			status_code_OP = rst.getString(1);
			status_desc_OP = rst.getString(2);
			STATUS_ACT_YN_OP = rst.getString(3);
				if((status_code_OP.equals("MS"))){
					status_code1 = rst.getString(1);
					status_desc1 = rst.getString(2);
					OPstatus_Ser_YN	= rst.getString(3);
				}else if((status_code_OP.equals("MA"))){
					status_code2 = rst.getString(1);
					status_desc2 = rst.getString(2);
					OPstatus_Acc_YN = rst.getString(3);
				}else if((status_code_OP.equals("MR"))){
					status_code3 = rst.getString(1);
					status_desc3 = rst.getString(2);
					OPstatus_Rej_YN = rst.getString(3);
				}
			}
			//Added Against ML-MMOH-CRF-1061-US4 Ends Here
		

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getParameter("from")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getParameter( "to" )));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(OPstatus_Ser_YN));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(OPstatus_Acc_YN));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(OPstatus_Rej_YN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(isMealComplaints));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(OPstatus_Ser_YN.equals("Y")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(status_desc1));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
if(OPstatus_Acc_YN.equals("Y")){
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(status_desc2));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
if(OPstatus_Rej_YN.equals("Y")){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(status_desc3));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sysDate));
            _bw.write(_wl_block27Bytes, _wl_block27);

	String from = request.getParameter("from");
	String to = request.getParameter( "to" );

	int start = (from.equals(""))?0:Integer.parseInt(from);
	int end = (to.equals(""))?13:Integer.parseInt(to);
	if ( !(start <= 0) ) {
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((start-13)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((end-13)));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((start+13)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((end+13)));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(status_desc1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(status_desc1));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(status_desc2));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(status_desc2));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(status_desc3));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(status_desc3));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println(e);
		}finally{
		if(rst!=null)
			rst.close();
		if(pstmt!=null)
			pstmt.close();
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
		}

            _bw.write(_wl_block56Bytes, _wl_block56);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.statusDateTimeforAllPatients.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.VisitDateTime.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Complaints.Label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.FoodReplacement.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.no.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.yes.label", java.lang.String .class,"key"));
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
}
