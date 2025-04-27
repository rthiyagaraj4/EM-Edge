package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import eOR.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __tasklistrightresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/TaskListRightResult.jsp", 1736502764284L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\' />\n\n<!-- <link rel=\'StyleSheet\' href=\'../../eCommon/html/contextMenu.css\' type=\'text/css\' /> -->\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCA/js/TaskList.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\t\n\t<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n\t<Script Language=\"JavaScript\" src=\"../../eBT/js/BTMessage.js\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\n\tvar detailArray = new Array(); \n\n\tfunction hideToolTip(obj,imgObj)\n\t{\n\t\tdocument.getElementById(\"tooltiplayer\").style.visibility = \'hidden\'\n\t\tif (obj != null)\n\t\t{\n\t\t\tobj.className = \'gridDataBlue\';\n\t\t\tdocument.getElementById(imgObj).src = \"../../eCommon/images/inactiveArrow.gif\";\n\t\t}\t\n\t}\n\n\tfunction callMouseOver(obj)\n\t{\n\t\tcurrClass = obj.className ;\n\t\tobj.className = \'selectedcontextMenuItem\';\n\t}\n\n\tfunction callOnMouseOut(obj)\n\t{\n\t\tobj.className = \'contextMenuItem\';\n\t}\n\n\tfunction callMouseOver_BT(colval1,index,obj)\n\t{\n\t\tcurrClass = obj.className ;\n\t\tobj.className = \'selectedcontextMenuItem\';\n\n\t\tvar tabdata = \"<table class=\'grid\' cellpadding=0 cellspacing=0 border=1><tr><td class=columnHeadercenter nowrap>Product</td><td class=columnHeadercenter nowrap>Unit No</td><td class=columnHeadercenter nowrap>Blood Group</td><td class=columnHeadercenter nowrap>Rhesus</td></tr>\";\n\n\t\tif(colval1 == \'PRDDTL\')\n\t\t{\n\t\t\tif(detailArray[index] != \'\')\n\t\t\t{\n\t\t\t\ttabdata +=detailArray[index]+\"</table>\";\n\t\t\t\tdocument.getElementById(\"details\").innerHTML = tabdata;\n\n\t\t\t\tvar wdth \t  = obj.offsetWidth;\n\t\t\t\tvar hght1 \t  = obj.offsetHeight;\n\n\t\t\t\tvar wdth1 = getPos(obj).x - wdth;\n\t\t\t\tvar hght = getPos(obj).y + hght1;\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\"details\").style.top  = hght;\n\t\t\t\tdocument.getElementById(\"details\").style.left  = wdth1;\n\t\t\t\tdocument.getElementById(\"details\").style.visibility = \'visible\' ;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\"details\").style.visibility=\'hidden\' ;\n\t\t}\n\n\t}\n\n\tfunction callOnMouseOut_BT(obj)\n\t{\n\t\tobj.className = \'contextMenuItem\';\n\t\tdocument.getElementById(\"details\").style.visibility=\'hidden\' ;\n\t}\n\n\tfunction getPos(inputElement)\n\t{\n\t\tvar coords =  new Object();\n\t\tcoords.x = 0;\n\t\tcoords.y = 0;\n\t\ttry\n\t\t{\n\t\t\ttargetElement = inputElement;\n\t\t\tif(targetElement.x && targetElement.y)\n\t\t\t{\n\t\t\t\tcoords.x = targetElement.x;\n\t\t\t\tcoords.y = targetElement.y;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(targetElement.offsetParent)\n\t\t\t\t{\n\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t\twhile(targetElement = targetElement.offsetParent)\n\t\t\t\t\t{\n\t\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//alert(\"Could not find any reference for coordinate positioning.\");\n\t\t\t\t}\n\t\t\t}\n\t\t\treturn coords;\n\t\t}\n\t\tcatch(error)\n\t\t{\n\t\t\treturn coords;\n\t\t}\n\t}\n\n\t//function displayToolTip(val,val1,orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id, task_categ, index, specimen_no, order_facility_id, unit_no, product_code, product_desc, blood_group, rhesus_code, row_id,parent_order_id, orderctlHDR, imgObj,dob,accssion_num,practname,patientDtls,patName,curr_sys_date)//IN065942\n\nfunction displayToolTip(val, val1, orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id, task_categ, index, specimen_no, order_facility_id, unit_no, product_code, product_desc, blood_group, rhesus_code, row_id, parent_order_id, orderctlHDR, imgObj, dob, accssion_num, practname, patientDtls, patName, curr_sys_date, prn_reg_ord, split_order_yn) \n{\n    callMouseOverOnTD(orderctlHDR, imgObj);\n\n    // Call the appropriate buildTable function based on task_categ\n    if (task_categ == \'B\') {\n        buildTable_BT(val, val1, orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id, index, specimen_no, order_facility_id, unit_no, product_code, product_desc, blood_group, rhesus_code, row_id);\n    } else {\n        buildTable(val, val1, orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id, parent_order_id, dob, accssion_num, practname, patientDtls, patName, curr_sys_date, index, task_categ, prn_reg_ord, split_order_yn);\n    }\n\n    // Get the clicked element\'s position\n    var orderctlHDR1 = orderctlHDR.id;\n    var elementWidth = document.getElementById(orderctlHDR1).offsetWidth;\n    var elementHeight = document.getElementById(orderctlHDR1).offsetHeight;\n    var elementPos = getPos(orderctlHDR);\n    \n    var x = elementPos.x + elementWidth; // Positioning the tooltip immediately to the right\n    var y = elementPos.y;\n\n    // Get the body dimensions\n    var bodyWidth = document.body.offsetWidth;\n    var bodyHeight = document.body.offsetHeight;\n\n    // Ensure the tooltip stays within the bounds of the screen horizontally\n    if (x + document.getElementById(\"tooltiplayer\").offsetWidth > bodyWidth) {\n        x = bodyWidth - document.getElementById(\"tooltiplayer\").offsetWidth;\n    }\n\n    // Vertical position handling: Allow overflow\n    if (y + document.getElementById(\"tooltiplayer\").offsetHeight > bodyHeight) {\n        // Ensure the tooltip doesn\'t overflow vertically out of the body\n        y = bodyHeight - document.getElementById(\"tooltiplayer\").offsetHeight;\n    }\n\n    // Allow top overflow by allowing negative `y` values\n    var tooltipHeight = document.getElementById(\"tooltiplayer\").offsetHeight;\n    if (y < -tooltipHeight) {\n        y = -tooltipHeight; // Tooltip will overflow the top if y is less than negative tooltip height\n    }\n\n    // Set the position of the tooltip\n    document.getElementById(\"tooltiplayer\").style.left = x + \"px\";\n    document.getElementById(\"tooltiplayer\").style.top = y < 0 ? \"0px\" : y + \"px\";\n    document.getElementById(\"tooltiplayer\").style.visibility = \'visible\';\n}\n\n\n\n\n\t//function buildTable(val, val1, orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id,parent_order_id,dob,accssion_num,practname,patientDtls,patName,curr_sys_date,index,task_categ)//IN065942\n\tfunction buildTable(val, val1, orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id,parent_order_id,dob,accssion_num,practname,patientDtls,patName,curr_sys_date,index,task_categ,prn_reg_ord,split_order_yn)//IN065942//IN071618\n\t{\n\t\tvar rowval   = val.split (\",\");\t\n\t\t//IN061903 start\n\t\t//var row      = (\"Completion,ResultEntry,RecordProcedure,SentOut,ReceiveResult,LB,Discontinue,Hold,UpdateLine,UpdateOrder,LB,Replace,ChangePerformLocn,LB,View,RegisterOrder,NewList,SpecimenCollection,SpecimenDispatch,RecordConsent\"); //Chowminya,IN29559\n\t\tvar row      = (\"Completion,ResultEntry,RecordProcedure,SentOut,ReceiveResult,LB,Discontinue,NotDone,Hold,UpdateLine,UpdateOrder,LB,Replace,ChangePerformLocn,LB,View,RegisterOrder,NewList,SpecimenCollection,SpecimenDispatch,RecordConsent\");\n\t\t//IN061903 ends\n\t\trowval1      = row.split(\",\");\n\t\tvar nn = 0;\n\t\t\n\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n \t\tfor( var i=0; i<rowval.length; i++ )\n\t\t{\n\t\t\tvar colval  = rowval[i];\n\t\t\tvar colval1 = rowval1[i];\n\t\t\t\n\t\t\tif (colval != \"\" )\n\t\t\t{\n\t\t\t\ttab_dat   =  tab_dat+\"<tr>\" ;\t\t\n\t\t\t\n\t\t\t\tif(colval1==\"LB\")\n\t\t\t\t{\n\t\t\t\t\tif(colval==\"LINE\") \n\t\t\t\t\t{\n\t\t\t\t\t\tif(nn>0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\ttab_dat    = tab_dat+ \"<td class=\'contextMenuItemSeperator\' nowrap id=\'mouse\'><hr class=\'contextMenuItemSeperator\' size=3 width=\'100%\' align=center></td>\" ;\n\t\t\t\t\t\t\tnn=0;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\t\ttab_dat    = tab_dat+ \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'>\"+colval+\" </td>\" ;\n\t\t\t\t\t\tnn=nn+1;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if (colval1 != \"ChangePerformLocn\" && colval1 != \"SentOut\" && colval1 != \"RegisterOrder\" && colval1 != \"ReceiveResult\" && colval1!=\"NewList\" && colval1!=\"SpecimenCollection\" && colval1!=\"SpecimenDispatch\" && (!((sent_out_flag == \'S\' || sent_out_flag == \'R\') && (colval1 == \"ResultEntry\" || colval1 == \"Completion\" ))) ||  colval1 == \"Replace\" ||  colval1 == \"ChangeChargeType\")\t\t\t\n\t\t\t\t{\n\t\t\t\t\t/*if(((colval1==\"Replace\"))||((colval1==\"UpdateLine\"))||((colval1==\"UpdateOrder\")))\n\t\t\t\t\t{\n\t\t\t\t\t\tif( parent_order_id == null || parent_order_id == \"undefined\" || parent_order_id == \"\")\n                          orderId = orderId;\n\t\t\t\t\t\telse\n\t\t\t\t\t\torderId = parent_order_id;\n\t\t\t\t\t}*/\n\n\t\t\t\t\tnn=nn+1;\n\t\t\t\t\t\n\t\t\t\t\ttab_dat    =tab_dat+ \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(t";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="his)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+encounterId+\"\',\'\"+sex+\"\',\'\"+patient_id+\"\',\'\"+escape(procedure_code)+\"\',\'\"+patient_class+\"\',\'\',\'\"+ord_cat+\"\',\'\"+order_status+\"\',\'\"+order_line_num+\"\',\'\"+performing_facility+\"\',\'\"+performing_location_type+\"\',\'\"+performing_location+\"\',\'\"+int_or_ext+\"\',\'\"+sent_out_flag+\"\',\'\"+escape(patient_dtls)+\"\',\'\"+escape(discr_msr_id)+\"\',\'\"+proc_code_scheme+\"\',\'\"+order_type_code+\"\',\'\"+order_set_id+\"\',\'\"+dob+\"\',\'\"+accssion_num+\"\',\'\"+escape(practname)+\"\',\'\"+escape(patientDtls)+\"\',\'\"+escape(patName)+\"\',\'\"+ord_pract_id+\"\',\'\"+escape(curr_sys_date)+\"\',\'\"+index+\"\',\'\"+task_categ+\"\');>\"+colval+\" </a></td>\" ;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tnn=nn+1;\n\t\t\t\t\t\t\n\t\t\t\t\t//tab_dat    = tab_dat+ \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callPerfMenuFunctions(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+encounterId+\"\',\'\"+sex+\"\',\'\"+patient_id+\"\',\'\"+escape(procedure_code)+\"\',\'\"+patient_class+\"\',\'\"+ord_cat+\"\',\'\"+order_status+\"\',\'\"+order_line_num+\"\',\'\"+performing_facility+\"\',\'\"+performing_location_type+\"\',\'\"+performing_location+\"\',\'\"+int_or_ext+\"\',\'\"+sent_out_flag+\"\',\'\"+priority+\"\',\'\"+order_type_code+\"\',\'\"+source_type+\"\',\'\"+source_code+\"\',\'\"+cont_order_ind+\"\',\'\"+appt_ref_num+\"\',\'\"+ord_pract_id+\"\',\'\"+escape(date_time)+\"\',\'\"+consent_status+\"\',\'\"+order_set_id+\"\',\'\"+dob+\"\');>\"+colval+\" </a></td>\" ;//IN065942\n\t\t\t\t\t//tab_dat    = tab_dat+ \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callPerfMenuFunctions(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+encounterId+\"\',\'\"+sex+\"\',\'\"+patient_id+\"\',\'\"+escape(procedure_code)+\"\',\'\"+patient_class+\"\',\'\"+ord_cat+\"\',\'\"+order_status+\"\',\'\"+order_line_num+\"\',\'\"+performing_facility+\"\',\'\"+performing_location_type+\"\',\'\"+performing_location+\"\',\'\"+int_or_ext+\"\',\'\"+sent_out_flag+\"\',\'\"+priority+\"\',\'\"+order_type_code+\"\',\'\"+source_type+\"\',\'\"+source_code+\"\',\'\"+cont_order_ind+\"\',\'\"+appt_ref_num+\"\',\'\"+ord_pract_id+\"\',\'\"+escape(date_time)+\"\',\'\"+consent_status+\"\',\'\"+order_set_id+\"\',\'\"+dob+\"\',\'\"+prn_reg_ord+\"\');>\"+colval+\" </a></td>\" ;//IN065942\n\t\t\t\t\ttab_dat    = tab_dat+ \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callPerfMenuFunctions(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+encounterId+\"\',\'\"+sex+\"\',\'\"+patient_id+\"\',\'\"+escape(procedure_code)+\"\',\'\"+patient_class+\"\',\'\"+ord_cat+\"\',\'\"+order_status+\"\',\'\"+order_line_num+\"\',\'\"+performing_facility+\"\',\'\"+performing_location_type+\"\',\'\"+performing_location+\"\',\'\"+int_or_ext+\"\',\'\"+sent_out_flag+\"\',\'\"+priority+\"\',\'\"+order_type_code+\"\',\'\"+source_type+\"\',\'\"+source_code+\"\',\'\"+cont_order_ind+\"\',\'\"+appt_ref_num+\"\',\'\"+ord_pract_id+\"\',\'\"+escape(date_time)+\"\',\'\"+consent_status+\"\',\'\"+order_set_id+\"\',\'\"+dob+\"\',\'\"+prn_reg_ord+\"\',\'\"+split_order_yn+\"\');>\"+colval+\" </a></td>\" ;//IN065942//IN071618\n\t\t\t\t}\n\t\t\t\n\t\t\t\ttab_dat = tab_dat+ \"</tr> \" ;\n\t\t\t}\n\t\t\t\n\t\t}\n\t\ttab_dat = tab_dat+ \"</table> \";\n\t\tdocument.getElementById(\"t\").innerHTML = tab_dat;\n\t}\n\n\tfunction buildTable_BT(val,val1,orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id, index, specimen_no, order_facility_id, unit_no, product_code, product_desc, blood_group, rhesus_code, row_id)\n\t{\n\t\tvar colval = \"\";\n\t\tvar rowval   = val.split (\",\");\t\n\t\t\n\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n \t\tfor( var i=0; i<rowval.length; i++ ) \n\t\t{\n\t\t\tvar colval1  = rowval[i];\n\t\t\t\n\t\t\tif (colval1 != \"\" )\n\t\t\t{\n\t\t\t\ttab_dat   =  tab_dat+\"<tr>\" ;\t\t\n\t\t\t\n\t\t\t\tif(colval1 == \"DIVIDER\")\n\t\t\t\t{\n\t\t\t\t\ttab_dat = tab_dat+ \"<td class=\'contextMenuItemSeperator\' nowrap id=\'mouse\'><hr class=\'contextMenuItemSeperator\' size=3 width=\'100%\' align=center></td>\" ;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tif(colval1 == \"ORDDTL\")\n\t\t\t\t\t\tcolval = getLabel(\"eCA.ViewOrderDetail.label\",\"CA\");\n\t\t\t\t\telse if(colval1 == \"PRDDTL\")\n\t\t\t\t\t\tcolval = getLabel(\"eCA.ProductDetails.label\",\"CA\");\n\t\t\t\t\telse if(colval1 == \"TRANSHIST\")\n\t\t\t\t\t\tcolval = getLabel(\"eCA.TransfusionHistory.label\",\"CA\");\n\t\t\t\t\telse if(colval1 == \"REQRMENT\")\n\t\t\t\t\t\tcolval = getLabel(\"Common.Requirement.label\",\"Common\");\n\t\t\t\t\telse if(colval1 == \"ANDIBODY\")\n\t\t\t\t\t\tcolval = getLabel(\"eCA.Antibody.label\",\"CA\");\n\t\t\t\t\telse if(colval1 == \"RQSTREPRNT\")\n\t\t\t\t\t\tcolval = getLabel(\"Common.Reprint.label\",\"Common\");\n\t\t\t\t\telse if(colval1 == \"RQSTPRNT\")\n\t\t\t\t\t\tcolval = getLabel(\"Common.Request.label\",\"Common\") + \" / \" + getLabel(\"Common.print.label\",\"Common\");\n\t\t\t\t\telse if(colval1 == \"RECCONS\")\n\t\t\t\t\t\tcolval = getLabel(\"eCA.RecordConsumption.label\",\"CA\");\n\t\t\t\t\t\n\t\t\t\t\ttab_dat  = tab_dat+ \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\\\"callMouseOver_BT(\'\"+colval1+\"\',\'\"+index+\"\',this)\\\" onMouseOut=\'callOnMouseOut_BT(this);\'><a class= \'contextMenuLink\' href=javascript:callBTMenuFunctions(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+encounterId+\"\',\'\"+sex+\"\',\'\"+patient_id+\"\',\'\"+escape(procedure_code)+\"\',\'\"+patient_class+\"\',\'\"+ord_cat+\"\',\'\"+order_status+\"\',\'\"+order_line_num+\"\',\'\"+performing_facility+\"\',\'\"+performing_location_type+\"\',\'\"+performing_location+\"\',\'\"+int_or_ext+\"\',\'\"+sent_out_flag+\"\',\'\"+priority+\"\',\'\"+order_type_code+\"\',\'\"+source_type+\"\',\'\"+source_code+\"\',\'\"+cont_order_ind+\"\',\'\"+appt_ref_num+\"\',\'\"+ord_pract_id+\"\',\'\"+escape(date_time)+\"\',\'\"+consent_status+\"\',\'\"+order_set_id+\"\',\'\"+specimen_no+\"\',\'\"+order_facility_id+\"\',\'\"+escape(unit_no)+\"\',\'\"+product_code+\"\',\'\"+escape(product_desc)+\"\',\'\"+blood_group+\"\',\'\"+rhesus_code+\"\',\'\"+row_id+\"\');>\"+colval+\" </a></td>\" ;\n\t\t\t\t}\n\t\t\t\n\t\t\t\ttab_dat = tab_dat+ \"</tr> \" ;\n\t\t\t}\n\t\t}\n\t\ttab_dat = tab_dat+ \"</table> \";\n\t\tdocument.getElementById(\"t\").innerHTML = tab_dat;\n\t}\n\t/*function dummy()\n\t{}*/\n\n\t</script>\n\t\n</head>\n<!-- Modified by Kishore Kumar N on Sept08-09 for CRF 691\t-->\n<body onScroll=\"processScroll()\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\' onLoad=\"enableBtn(\'";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="\');moveFrame(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\">\n<!-- ends here.  -->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\t/*\t\tModified by Kishore Kumar N on Sept08-09 for CRF 691\t*/\n\t\t\tclearValuesfor(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'); \n\t\t\t/*ends here.*/\n\t\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<form name=\'TaskListFilterResultForm\' id=\'TaskListFilterResultForm\'  action=\"../../eCA/jsp/TaskListRightResult.jsp\" method=\"post\">\n<div id=\"divHeadSep\">\n<table class=\'grid\' width=\"96%\" height=\'\' id=\"tableresult\">\n<tr id=\"heading\" >\n\t\t<td class=columnheader width=\'\' nowrap>&nbsp;&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n        <td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\t\t\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n        <td class=columnheader width=\'\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n</tr>\n\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<tr align=\"right\">\n\t\t\t\t\t<td colspan=\"10\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="   \t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="  \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'CAGROUP\' colspan=\'8\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t&nbsp;\n\t\t\t\t\t<font color=\'red\'>Known Case of Allergy</font>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<!-- IN036495 Start.<td class=\'CAGROUP\' colspan=\'2\'> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t<td class=\'CAGROUP\' colspan=\'3\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<td class=\'CAGROUP\' colspan=\'2\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t<!--IN036495 End.-->\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<input type=\'button\' name=\'viewMARChart";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'viewMARChart";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' onClick=\"callMednDetails(\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\')\">\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\n\t\t\t<!--\t<tr>\n\t\t\t\t\t<td class=\'CAGROUP\' colspan=\'10\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t</tr>-->\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'CAGROUP\' colspan=\'11\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'CAGROUP\' colspan=\'10\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t\t</tr>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n<input type=\'hidden\' name=\'adminStatus";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'adminStatus";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=\'hidden\' name=\'taskCategory";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'taskCategory";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n<input type=\'hidden\' name=\'RESULT_TYPE";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'RESULT_TYPE";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n<input type=\'hidden\' name=\'RESULT_ID";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'RESULT_ID";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n<input type=\'hidden\' name=\'status";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'status";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n<input type=\'hidden\' name=\'scheduleDate";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'scheduleDate";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n<input type=\'hidden\' name=\'taskCode";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'taskCode";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<input type=\'hidden\' name=\'taskType";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'taskType";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n<input type=\'hidden\' name=\'taskSrlNo";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'taskSrlNo";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n<input type=\'hidden\' name=\'patientId";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'patientId";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n<input type=\'hidden\' name=\'remarks";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'remarks";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' value=\'\'>\n<input type=\'hidden\' name=\'performedId";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id=\'performedId";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n<input type=\'hidden\' name=\'orderId";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' id=\'orderId";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n<input type=\'hidden\' name=\'orderNum";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'orderNum";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n<input type=\'hidden\' name=\'encounterId";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' id=\'encounterId";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n<input type=\'hidden\' name=\'facilityId";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' id=\'facilityId";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n<input type=\'hidden\' name=\'contOrderInd";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' id=\'contOrderInd";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n<input type=\'hidden\' name=\'apptRefNum";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' id=\'apptRefNum";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n<input type=\'hidden\' name=\'ordPractID";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' id=\'ordPractID";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n<input type=\"hidden\" name=\"orderCategory";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"orderCategory";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"> <!-- 26826 -->\n\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" <input type=\"hidden\" name =\"dxChkBfrPlaceOrderYN";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\"> ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" value=\"Y\"> ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n<tr>\n";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' nowrap><img src=\"../../eCA/images/TL_BloodCon.gif\" name=\'buc\' alt=\'Blood Unit Consumption\' height=\'15\' width=\'15\'/></td>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n<td width=\'\' class=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' style=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' nowrap>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="&nbsp;</td>\t\t<!-- Indicator-->\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'  nowrap>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</td>\t\t<!-- Date-->\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" \n\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\t\t<!-- Time-->\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' wrap>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\t<!-- Order Type-->\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t<!--IN065942, starts-->\n\t\t<!-- <td width=\'\' id=\'orderctl";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' class=\'gridDataBlue\' wrap  onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\', \'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\', this, \'imgArrow";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\')\"  style=\'cursor:pointer\' onMouseOver=\"hideToolTip(this,\'imgArrow";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\')\"> ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t<img align=\'right\' src=\"../../eCommon/images/inactiveArrow.gif\" name=\"imgArrow";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t\t</td> -->\n\t\t<td width=\'\' id=\'orderctl";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="<!--IN071618 -->\n\t\t<!--IN065942,ends-->\n\t\t<img align=\'right\' src=\"../../eCommon/images/inactiveArrow.gif\" name=\"imgArrow";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" id=\"imgArrow";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t</td>\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t<td width=\'\' class=\'gridDataBlue\' id=\'orderctl";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' style=\'cursor:pointer\' onClick=\"displayToolTip_int(\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\',this)\" onMouseOver=\'hideToolTip()\'  wrap ><!-- <a href=\'javascript:dummy()\'  onClick=\"displayToolTip_int(\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\')\"  onMouseOver=\'hideToolTip()\'> -->";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="<!-- </a> --></td>\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' style=\'cursor:pointer\' onClick=\"displayToolTipForEvents_int(\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\',this)\"  onMouseOver=\'hideToolTip()\' wrap ><!-- <a href=\'javascript:dummy()\'  onClick=\"displayToolTipForEvents_int(\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\',\'\',\'\',\'\',this)\"  onMouseOver=\'hideToolTip()\' wrap >";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' wrap >";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t<!--<td width=\'\' class=\'gridDataBlue\' id=\'orderctl";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' style=\'cursor:pointer\' onClick=\"displayToolTipForEventsPopulation(\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\',this)\"  onMouseOver=\'hideToolTip()\' wrap ><!-- <a href=\'javascript:dummy()\'  onClick=\"displayToolTipForEventsPopulation(\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\')\"  onMouseOver=\'hideToolTip()\'> -->\n\t\t<td width=\'\' class=\'gridDataBlue\' id=\'orderctl";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\',this,\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\')\"  onMouseOver=\'hideToolTip()\' wrap ><!--IN066125-->";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'  wrap>";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\t\t<!-- Patient Name-->\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'  wrap>&nbsp; ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="<img style=\'display;cursor: hand;\' src=\'../../eCA/images/flow_text.gif\' onClick=\"viewPatientInstructions(\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\');\">";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</td>\t\t<!-- record[51]Patient Instructions-->\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t<td style=\"width:60px\" class=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\t\t<!-- Ordered By-->\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</td>\t<!-- priority-->\n\t<td style=\"width:60px\" class=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td>\t<!-- Stage-->\n\t<td style=\"width:60px\" class=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</td>\t<!-- position-->\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t<td style=\"width:60px\" class=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'  nowrap><a href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\')\">";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</a>\n\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t<img title=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' src=\"../../eCA/images/MarkError.gif\"/>\n\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t</td>\t<!-- status-->\n";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t\t<td style=\"width:60px\" class=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'><a href=\"javascript:viewHistory(\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</a></td>\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'><a href=\"javascript:viewRequest(\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n</tr>\t \n";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n</table>\n</div>\n\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n<input type=\"hidden\" name=\"total_recs\" id=\"total_recs\" value=\"1\">\n<input type=\"hidden\" name=\"chk0\" id=\"chk0\" value=\"on\">\n<input type=\"hidden\" name=\"ord_id0\" id=\"ord_id0\" value=\"\">\n<input type=\"hidden\" name=\"cont_order_ind0\" id=\"cont_order_ind0\" value=\"\">\n<input type=\"hidden\" name=\"appt_ref_num0\" id=\"appt_ref_num0\" value=\"\">\n<input type=\"hidden\" name=\"encounter_id0\" id=\"encounter_id0\" value=\"\">\n<input type=\"hidden\" name=\"view_by0\" id=\"view_by0\" value=\"H\">\n<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"1\">\n<input type=\"hidden\" name=\"line_id0\" id=\"line_id0\" value=\"\">\n<input type=\"hidden\" name=\"order_set_id0\" id=\"order_set_id0\" value=\"\">\n<input type=\"hidden\" name=\"route_admin\" id=\"route_admin\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n<input type=\"hidden\" name=\"nursing_unit\" id=\"nursing_unit\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n<input type=\"hidden\" name=\"callFrom\" id=\"callFrom\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n<input type=\"hidden\" name=\"isBTViewBillDtls\" id=\"isBTViewBillDtls\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\"><!--IN065324-->\n<input type=\"hidden\" name=\"pract_type\" id=\"pract_type\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\"><!--IN065942-->\n<input type=\"hidden\" name=\"order_category0\" id=\"order_category0\" value=\"\"><!--IN065942-->\n<input type=\"hidden\" name=\"prn_reg_ord0\" id=\"prn_reg_ord0\" value=\"\"><!--IN065942-->\n<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"\"><!-- IN071618 -->\n<!-- For Next & previous -->\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n <!-- For Next & previous -->\n\n</form>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div>\n<div name=\'details\' id=\'details\' style=\'position:absolute; width:60%; visibility:hidden;\' bgcolor=\'blue\'>\n\n</div>\n</body>\n</html>\n<!--IN069244 starts-->\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n<script>\nparent.parent.TaskListRightFrame.TaskListRightResultFrame.location.href=\"../jsp/VitalSignFrameSet.jsp?";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\";\t\n</script>\n";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n<!--IN069244 ends-->\n";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );
	
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

/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      	Name        	Description
--------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
22/03/2012    	IN29559       	DineshT      	Record consent criteria in TaskList function
26/06/2012    	IN033488      	Chowminya G    	Incident No: IN033488 -  Error Marking - Result completed indicator> 
27/07/2012    	IN034216      	Chowminya G    	Incident No: IN034216 -  Blood Unit Consumption Records are not displaying in Task List. 
09/11/2012		IN030473		Ramesh G		Bru-HIMS-CRF-032 
28/11/2012		IN036495		Ramesh G		Task List: The Alignment is not correct
29/05/2013		IN040198		Chowminya G		Status of the Order Catalog is displayed wrongly
12/06/2013	  	IN040761		Akbar			Task List : Include Bed Number & Priority Zone (AE)
26/06/2013	  	IN041063		Nijitha			ALPHA-CA-For discharged Inpatients the Bed No, and for Emergency patients Priority Zone is displayed at Tasklist function. 
---------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903		Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
19/10/2017	IN065324		Dinesh T			19/10/2017		Ramesh G		To display the price in OR screen and 																						the billing status in Manage Specimen 																						screen
15/12/2017	IN065942		Dinesh T			15/12/2017		Ramesh G		In Nuclear medicine  department we required the barcode 																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
03/01/2018	IN066125		Dinesh T			03/01/2017		Ramesh G		EM run on window 10 and IE 11
14/03/2019	IN068778		Selvin M			14/03/2019		Ramesh G		TBMC-CRF-0011
22/01/2019	IN069244		Ramya Maddena		25/01/2019		Ramesh Goli	   	MMS-KH-CRF-0005.1
20/04/2020	IN072853		Sivabagyam M		20/04/2020		Ramesh G		CA-MMS-TASK_LIST
05/15/2020	IN071618	   	Nijitha S	 		05/15/2020		Ramesh Goli		PMG2019-MMS-CRF-0004
22/08/2020	IN073625		Ramesh Goli			22/08/2020		Ramesh G		OR-PMG2020-TECH-CRF-0001/01-Place Order
27/07/2022	26826			Ramesh G											MMS-DM-CRF-0197
-------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
/*		Added by Kishore Kumar N on Sept08-09 for CRF 691	*/
String callFrom = request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
/* ends here. */

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);
            out.print( String.valueOf(callFrom));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(callFrom));
            _bw.write(_wl_block10Bytes, _wl_block10);

PatTaskListRepository patTask = (PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);




java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) property.getProperty("LOCALE");

String practitioner_id=(String) session.getValue("ca_practitioner_id");
String practitioner_type=(String) session.getValue("practitioner_type");//IN065942
String resp_id    			=	(String) session.getValue("responsibility_id");
String locn_desc=request.getParameter("locn_desc")==null?"":request.getParameter("locn_desc");
String locn_code=request.getParameter("locn_code")==null?"":request.getParameter("locn_code");

String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String location_type=request.getParameter("location_type")==null?"":request.getParameter("location_type");
String status_code =request.getParameter("status_code")==null?"":request.getParameter("status_code");
String taskSelect=request.getParameter("taskSelect")==null?"":request.getParameter("taskSelect");

String OrderCategory=request.getParameter("OrderCategory")==null?"":request.getParameter("OrderCategory");
String OrderType=request.getParameter("OrderType")==null?"":request.getParameter("OrderType");
String Groupby=request.getParameter("Groupby")==null?"":request.getParameter("Groupby");
String To_date=request.getParameter("To_date")==null?"":request.getParameter("To_date");
String From_date=request.getParameter("From_date")==null?"":request.getParameter("From_date");
//Commented by Archana Dhal related to IN18772 and IN18781.
//From_date = com.ehis.util.DateUtils.convertDate(From_date,"DMY",locale,"en");
//To_date = com.ehis.util.DateUtils.convertDate(To_date,"DMY",locale,"en");

String pat_discharge=request.getParameter("pat_discharge")==null?"":request.getParameter("pat_discharge");
String chkAll=request.getParameter("chkAll")==null?"":request.getParameter("chkAll");
String ckhDue=request.getParameter("ckhDue")==null?"":request.getParameter("ckhDue");
String chkElapsed=request.getParameter("chkElapsed")==null?"":request.getParameter("chkElapsed");
String chkPerformed=request.getParameter("chkPerformed")==null?"":request.getParameter("chkPerformed");
String chkFuture=request.getParameter("chkFuture")==null?"":request.getParameter("chkFuture");
String chkReg=request.getParameter("chkReg")==null?"":request.getParameter("chkReg");
String chkOverdue=request.getParameter("chkOverdue")==null?"":request.getParameter("chkOverdue");
String chkUnclassify=request.getParameter("chkUnclassify")==null?"":request.getParameter("chkUnclassify");
String taskSelectAll=request.getParameter("taskSelectAll")==null?"":request.getParameter("taskSelectAll");
String AdminRoute=request.getParameter("AdminRoute")==null?"":request.getParameter("AdminRoute");
String bt_status=request.getParameter("bt_status")==null?"":request.getParameter("bt_status");
String definition=request.getParameter("definition")==null?"":request.getParameter("definition");
String interventionType=request.getParameter("interventionType")==null?"":request.getParameter("interventionType");
String viewBy=request.getParameter("viewBy")==null?"":request.getParameter("viewBy");
String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String isBTViewBillDtls=request.getParameter("isBTViewBillDtls")==null?"":request.getParameter("isBTViewBillDtls");//IN065324

String taskListstr1 = "",taskListstrKey = "",taskListstrVal = "";
int taskIndex = 0;

String facilityId =session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;

String slClassValue="";
String discr_msr_id="";
String sent_out_flag 		= "";
String temp_id="";
String location="";
String cont_order_ind="";
String cellBGColor = "";
String patientDetails ="";
String maxRecord = "";

StringTokenizer strTokens = null;
ArrayList TaskAlldata =new ArrayList();
ArrayList ErrStatusChk		= null;//--[IN033488]

String action_type    = "";//--[IN033488]
	String action_date_time    = "";
	String action_by_id    = "";

String bean_id = "Or_ResultReporting";
String bean_name = "eOR.ResultReportingBean";

//26826 Start.
ResultReportingBean bean					= (ResultReportingBean)getBeanObject( bean_id, bean_name, request ) ;
bean.setSiteSpecific("DX_CHK_BFR_PLACE_ORDERS");
//26826 End.

String from	 = patTask.checkForNull(request.getParameter( "from" )) ;
String to	 = patTask.checkForNull(request.getParameter( "to" )) ;

if (from.equals(""))
	from = "1";

if (to.equals(""))
	to = "50";

int start	 = Integer.parseInt(from);
int end		 = Integer.parseInt(to);

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

StringBuffer layer = new StringBuffer();
String sql = "";
String product_desc = "";
String blood_group = "";
String rhesus_code = "";
String request_by = "";
String request_date = "";
String parent_order_id = "";
String split_order_yn = "N";//IN071618
try
{
	con = ConnectionManager.getConnection(request);

	if (taskSelectAll != null && taskSelectAll != "")
	{			
		strTokens = new StringTokenizer(taskSelectAll,"||");	
		while (strTokens.hasMoreTokens())
		{				
			taskListstr1 = strTokens.nextToken();
			taskIndex = taskListstr1.indexOf("~");
			taskListstrKey = taskListstr1.substring(0,taskIndex);
			taskListstrVal = taskListstr1.substring(taskIndex+1,taskListstr1.length());				
			if (taskListstrVal.equals("A"))
			{
				TaskAlldata.add(taskListstrKey);
			}											
		}									
	}
	
	// Added By Sridhar Reddy PMG20089-CRF-0691
	HashMap paramListMap = new  HashMap();
	paramListMap.put("locn_desc",locn_desc);
	if(callFrom.equals("IM") && viewBy.equals("A"))
		paramListMap.put("locn_code","");
	else
		paramListMap.put("locn_code",locn_code);

	paramListMap.put("location_type",location_type);
	paramListMap.put("status_code",status_code);
	paramListMap.put("taskSelect",taskSelect);
	paramListMap.put("OrderCategory",OrderCategory);
	paramListMap.put("OrderType",OrderType);
	paramListMap.put("Groupby",Groupby);
	paramListMap.put("To_date",To_date);
	paramListMap.put("From_date",From_date);
	paramListMap.put("pat_discharge",pat_discharge);
	paramListMap.put("patient_id",patient_id);
	paramListMap.put("facilityId",facilityId);
	paramListMap.put("chkAll",chkAll);
	paramListMap.put("ckhDue",ckhDue);
	paramListMap.put("chkElapsed",chkElapsed);
	paramListMap.put("chkPerformed",chkPerformed);
	paramListMap.put("chkFuture",chkFuture);
	paramListMap.put("chkReg",chkReg);
	paramListMap.put("chkOverdue",chkOverdue);
	paramListMap.put("chkUnclassify",chkUnclassify);
	paramListMap.put("practitioner_id",practitioner_id);
	paramListMap.put("resp_id",resp_id);
	paramListMap.put("TaskAlldata",TaskAlldata);
	paramListMap.put("AdminRoute",AdminRoute);
	paramListMap.put("bt_status",bt_status);
	paramListMap.put("definition",definition);
	paramListMap.put("interventionType",interventionType);
	paramListMap.put("start",start);
	paramListMap.put("end",end);
	paramListMap.put("callFrom",callFrom);
	paramListMap.put("viewBy",viewBy);
	paramListMap.put("encounter_id",encounter_id);	
	paramListMap.put("relationship_id",request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id"));
	ArrayList taskResult = patTask.getTaskResult(property,paramListMap);

	// End PMG20089-CRF-0691

    // Commented By Sridhar Reddy PMG20089-CRF-0691
	//ArrayList taskResult = patTask.getTaskResult(property,locn_desc,locn_code,location_type,status_code,taskSelect,OrderCategory,OrderType,Groupby,To_date,From_date,pat_discharge,patient_id,facilityId,chkAll,ckhDue,chkElapsed,chkPerformed,chkFuture,chkReg,chkOverdue,chkUnclassify,practitioner_id,resp_id,TaskAlldata,AdminRoute,bt_status,definition,interventionType,start,end);	
	
	if( taskResult.size() == 0)//IN072853
	//if( taskResult.size() == 0 && !"V".equals(taskSelect))// added taskSelect condition for IN069244 //commented for IN072853
	{ 

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(callFrom));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else
	{

            _bw.write(_wl_block13Bytes, _wl_block13);
if (Groupby.equals("P")){	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if (Groupby.equals("T")){	
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
if (taskSelect.equals("I")||taskSelect.equals("")){	
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

	for( int i=0 ; i< taskResult.size() ; i++ )
	{
		if(i % 2 == 0)
		{
			slClassValue = "gridData";
		}
		else
		{
			slClassValue = "gridData";
		}	

		String[] record = (String[])taskResult.get(i);
		if(i==0)
		{
			if(record[48] != null)
				maxRecord = patTask.checkForNull((String)record[48]);
			else
				maxRecord = "0";
			
			if((Integer.parseInt(maxRecord)>0) || (start>1))
			{
	
            _bw.write(_wl_block22Bytes, _wl_block22);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(maxRecord
                        )},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("TaskListFilterResultForm")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block28Bytes, _wl_block28);

			}
		}
		if(record[34].equals("B"))
		{
			//In below query 'am_get_desc.am_practitioner(a.REQUEST_FOR_ISSUE_BY,?,'2') REQUEST_FOR_ISSUE_BY' is added by Archana Dhal on 11/23/2010 related to incident no. IN025159.
			sql = "SELECT F.short_Desc PRODUCT_DESC,A.unit_no UNIT_NO, B.blood_group BLOOD_GROUP, B.rhesus_code RHESUS_CODE, am_get_desc.am_practitioner(a.REQUEST_FOR_ISSUE_BY,?,'2') REQUEST_FOR_ISSUE_BY, TO_CHAR (a.REQUEST_FOR_ISSUE_DATE, 'dd/mm/yyyy HH24:MI') REQUEST_FOR_ISSUE_DATE FROM BT_UNIT_REQUEST_DTL A, BT_BLOOD_UNITS_MAST B, BT_PRODUCT_MAST_LANG_VW F WHERE A.PATIENT_ID = ? and F.language_id = ? and  A.OPERATING_FACILITY_ID = ? AND b.unit_no = a.unit_no AND b.product_code = a.product_code AND f.product_code = a.product_code 	and a.PRODUCT_CODE = ? and a.UNIT_NO = ? AND a.SPECIMEN_NO = ? ORDER BY A.issued_date";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,record[22]);
			pstmt.setString(3,locale);
			pstmt.setString(4,record[43]);//--[IN034216]
			pstmt.setString(5,record[45]);
			pstmt.setString(6,record[44]);
			pstmt.setString(7,record[42]);

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				layer.setLength(0);
				product_desc = rs.getString("PRODUCT_DESC") == null ? "" : rs.getString("PRODUCT_DESC");
				blood_group = rs.getString("BLOOD_GROUP") == null ? "" : rs.getString("BLOOD_GROUP");
				rhesus_code = rs.getString("RHESUS_CODE") == null ? "" : rs.getString("RHESUS_CODE");
				request_by = rs.getString("REQUEST_FOR_ISSUE_BY") == null ? "" : rs.getString("REQUEST_FOR_ISSUE_BY");
				request_date = rs.getString("REQUEST_FOR_ISSUE_DATE") == null ? "" : rs.getString("REQUEST_FOR_ISSUE_DATE");
				
				layer.append("<tr><td class=gridData nowrap>"+product_desc+"</td>"+
							"<td class=gridData>"+rs.getString("UNIT_NO")+"</td>"+
							"<td class=gridData>"+blood_group+"</td>"+
							"<td class=gridData>"+rhesus_code+"</td></tr>");
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			out.println("<script>detailArray["+i+"]='"+layer.toString()+"';</script>");
		}

		String accession_num = "";
		String trans_pract_id = "";
		String note_type = "";
		String note_desc = "";
		String note_group = "";
		String request_pract_name = "";
		String req_pract_id = "";
		
		if(record[34].equals("I") && record[2].equals("$NTS"))
		{
			sql = "select a.REQ_ACCESSION_NUM contr_mod_accession_num,a.TRANS_PRACT_ID,a.NOTE_TYPE, ca_get_desc.CA_NOTE_TYPE(a.NOTE_TYPE,?,1) NOTE_TYPE_DESC,( select ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,1) from ca_note_type f  where  f.note_type=a.NOTE_TYPE ) note_group_desc, am_get_desc.am_practitioner (a.REQ_PRACT_ID,?,'1') request_pract_name,a.REQ_PRACT_ID  from CA_TRANSRIPTION_REQ  A, CA_PAT_TASK_LIST B where a.REQ_REFERENCE=b.REQ_REFERENCE and a.REQ_ACCESSION_NUM=b.REQ_ACCESSION_NUM and b.TASK_SRL_NO =? and b.PATIENT_ID=? /*and b.TASK_CODE='&NTS'*/";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,record[6]);
			pstmt.setString(5,record[22]);
		
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				accession_num = rs.getString("contr_mod_accession_num") == null ? "" : rs.getString("contr_mod_accession_num");
				trans_pract_id = rs.getString("TRANS_PRACT_ID") == null ? "" : rs.getString("TRANS_PRACT_ID");
				note_type = rs.getString("NOTE_TYPE") == null ? "" : rs.getString("NOTE_TYPE");
				note_desc = rs.getString("NOTE_TYPE_DESC") == null ? "" : rs.getString("NOTE_TYPE_DESC");
				note_group = rs.getString("note_group_desc") == null ? "" : rs.getString("note_group_desc");
				request_pract_name = rs.getString("request_pract_name") == null ? "" : rs.getString("request_pract_name");
				/*Added by Archana Dhal the below getString of REQ_PRACT_ID on 4/26/2010 at 4:20 PM for IN020723*/
				req_pract_id = rs.getString("REQ_PRACT_ID") == null ? "" : rs.getString("REQ_PRACT_ID");
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}
		if(record[8].compareTo("R")==0 || record[8].compareTo("N")==0)
		{
			record[8]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		}
		else if(record[8].compareTo("U")==0)
		{
			record[8]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		}
		else if(record[8].compareTo("S")==0)
		{
			record[8]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Stat.label","or_labels");
		}	

		String sex1 = "";
		if (record[14].equalsIgnoreCase("M"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if(record[14].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

		if(record[31].equalsIgnoreCase("C"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}
		else if(record[31].equalsIgnoreCase("N"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		}
		else if(record[31].equalsIgnoreCase("R"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
		}
		String patientDtls="";//Chowminya,IN29559
		String patName=record[12];
		String curr_sys_date=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName);
		patientDtls = record[12]+","+sex1+"/"+record[13]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[22];
		
		//Include Bed number - IN040761/Start
		//IN041063 Starts
		int visit_status=0;
		int adt_status=0;
		if(record[54] != null && !"".equals(record[54]))
		 visit_status = Integer.parseInt(record[54]);
		if(record[55] != null && !"".equals(record[55]))
		 adt_status = Integer.parseInt(record[55]);
		int dischargeStatus_EM=07;
		int dischargeStatus_IP=8;
		String BedDtls="";
		/*if(record[52] != null && !"".equals(record[52])) 
		{
			BedDtls = ","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","")+ ": "+record[52] ;
		}*/
		if(record[52] != null && !"".equals(record[52])) 
		{
			if("IP".equals(record[21]) && adt_status < dischargeStatus_IP || "EM".equals(record[21]) && visit_status < dischargeStatus_EM)
			{	
				BedDtls = ","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","")+ ": "+record[52] ;
			}
		}		
		if(record[21].equalsIgnoreCase("EM") && visit_status < dischargeStatus_EM)
		{
		//IN041063 Ends
			BedDtls = BedDtls +","+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PriorityZone.label","")+": "+record[53];
		}
		patientDtls = patientDtls + BedDtls;
		//Include Bed number - IN040761/End
		
		record[12]=record[12]+","+sex1+"/"+record[13]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[22]+","+location+"/"+record[33]+",";		

		StringBuffer menuText = new StringBuffer();
		String proc_code_scheme="";
		String procedure_code="";

		if (!(record[34].equals("S")) && !(record[34].equals("B")))
		{

		record[16]=record[16]+"_|Y|";
		if (record[34].equals("R"))				
			record[16]=record[16]+"Y|"; 	
		if(record[34].equals("C"))  //Condition Added by Chowminya,IN29559
			record[16]=record[16]+"N|N|N|N|Y|"; 
		}
		else
		{


			if(record[16].equals(""))
			{

				record[16]="N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|";

			}
		}
		StringTokenizer kv=new StringTokenizer(record[16],"|");		
		int count=kv.countTokens();
		
		boolean linef=false;
		boolean lineg=false;
		System.out.println("record[16]========>736====>"+record[16]);
		if(record[16].indexOf(":")!=-1)
		{

			String tempTokens="";
			StringBuffer stringtoken=new StringBuffer();
			while (kv.hasMoreTokens()) 
			{
				tempTokens = kv.nextToken();
				if(tempTokens.trim().length()>1)
				{

					String[] values1=record[16].split(":");
					proc_code_scheme=values1[1];
					procedure_code=values1[2];
					tempTokens=tempTokens.substring(0,1);
				}
				stringtoken.append(tempTokens);				
				stringtoken.append("|");				
			}
			record[16]=stringtoken.toString();
			stringtoken.setLength(0);
		}
		int n=1;		

		if(record[34].equals("B"))
		{

			StringTokenizer strToken = new StringTokenizer(record[16],"|");
			//int count1 = strToken.countTokens();
			String valueToken = "";
			while(strToken.hasMoreTokens()) 
			{
				valueToken = strToken.nextToken();
					menuText.append(valueToken+",");
			}
		}
		else
		{
			//System.out.println("---------------------inside else---------------------------");			
			if(count>1)
			{
				//IN073625 Start.
				//String[] values=record[16].split("|");
				String[] values=record[16].split("\\|");
				//IN073625 End.
				for(int m=0;m<values.length;m++) //IN073625
				//for(int m=0;m<count*2;m++) //IN073625
				{
					//System.out.println("(m===============tasklistrightresult.jsp======785==>"+m);
					//if(m%2==1)  //IN073625
					//{ //IN073625
					//	System.out.println("(m]================tasklistrightresult.jsp======788==>"+m);
						if(values[m].trim().length()>1)
						{
							values[m]=values[m].substring(0,1);
						}
					//	System.out.println("(values[m]================tasklistrightresult.jsp======793==>"+values[m]+"<=======");
						if(values[m].equals("Y") || values[m].equals("_"))
						{	
						//	System.out.println("(n===============tasklistrightresult.jsp======796==>"+n);
							switch(n)
							{
								/* IN061903 start
								case 1: menuText.append( "'+getLabel('eOR.OrderCompletion.label','OR')+',");lineg=true;break;  
								case 2: menuText.append( "'+getLabel('eOR.ResultEntry.label','OR')+',");lineg=true;break;
								case 3: menuText.append( "'+getLabel('eOR.RecordProcedure.label','OR')+',");lineg=true;
										break;
								case 4: menuText.append( "'+getLabel('eOR.SentOut.label','OR')+',");lineg=true;break;
								case 5: menuText.append( "'+getLabel('eOR.ReceiveResult.label','OR')+',");lineg=true;break;
								case 6: menuText.append( "LINE,");break;
								case 7: menuText.append( "'+getLabel('eOR.Discontinue.label','OR')+',");break;
								case 8: menuText.append( "'+getLabel('eOR.Hold.label','OR')+',");break;
								case 9: menuText.append( "'+getLabel('eOR.ReviewLineStatus.label','OR')+',");break;
								case 10: menuText.append( "'+getLabel('eOR.ReviewOrderStatus.label','OR')+',");break;
								case 11: menuText.append( "LINE,");break;
								case 12: menuText.append( "'+getLabel('eOR.Replace.label','OR')+',");break;
								case 13: menuText.append( "'+getLabel('eOR.RedirectOrder.label','OR')+',");break;
								case 14: menuText.append( "LINE,");break;
								case 15: menuText.append( "'+getLabel('Common.view.label','common')+',");
										 break;
								case 16: menuText.append( "'+getLabel('Common.RegisterOrder.label','COMMON')+',");
										 break;
								case 17: menuText.append( "'+getLabel('eOR.NewList.label','OR')+',");
										 break;
								case 18: menuText.append( "'+getLabel('eOR.SpecimenCollection.label','OR')+',");
										 break;
								case 19: menuText.append( "'+getLabel('eOR.SpecimenDispatch.label','OR')+',");
										 break;
								case 20: menuText.append( "'+getLabel('eOR.RecordConsent.label','OR')+',"); //Added By Chowminya,IN29559
										 break;
								*/
								case 1: menuText.append( "'+getLabel('eOR.OrderCompletion.label','OR')+',");lineg=true;break;  
								case 2: menuText.append( "'+getLabel('eOR.ResultEntry.label','OR')+',");lineg=true;break;
								case 3: menuText.append( "'+getLabel('eOR.RecordProcedure.label','OR')+',");lineg=true;
										break;
								case 4: menuText.append( "'+getLabel('eOR.SentOut.label','OR')+',");lineg=true;break;
								case 5: menuText.append( "'+getLabel('eOR.ReceiveResult.label','OR')+',");lineg=true;break;
								case 6: menuText.append( "LINE,");break;
								case 7: menuText.append( "'+getLabel('eOR.Discontinue.label','OR')+',");
								break;
								case 8: menuText.append("'+getLabel('eOR.NOTDONE.label','OR')+',");break;
								case 9: menuText.append( "'+getLabel('eOR.Hold.label','OR')+',");break;
								case 10: menuText.append( "'+getLabel('eOR.ReviewLineStatus.label','OR')+',");break;
								case 11: menuText.append( "'+getLabel('eOR.ReviewOrderStatus.label','OR')+',");break;
								case 12: menuText.append( "LINE,");break;
								case 13: menuText.append( "'+getLabel('eOR.Replace.label','OR')+',");break;
								case 14: menuText.append( "'+getLabel('eOR.RedirectOrder.label','OR')+',");break;
								case 15: menuText.append( "LINE,");break;
								case 16: menuText.append( "'+getLabel('Common.view.label','common')+',");
										 break;
								case 17: menuText.append( "'+getLabel('Common.RegisterOrder.label','COMMON')+',");
										 break;
								case 18: menuText.append( "'+getLabel('eOR.NewList.label','OR')+',");
										 break;
								case 19: menuText.append( "'+getLabel('eOR.SpecimenCollection.label','OR')+',");
										 break;
								case 20: menuText.append( "'+getLabel('eOR.SpecimenDispatch.label','OR')+',");
										 break;
								case 21: menuText.append( "'+getLabel('eOR.RecordConsent.label','OR')+',"); //Added By Chowminya,IN29559								
										 break;
								//IN061903 ends
								default: if(!linef)
										 menuText.append(",");
							}
						}
						else
							menuText.append(",");
						n++;
					//	} //IN073625
						//System.out.println("menuText================tasklistrightresult.jsp======866==>"+menuText);
					}
				}
			}

		if (record[12] != "" && record[12] != null)
		{
			patientDetails = record[12].substring(0,record[12].indexOf(",",record[12].indexOf("ID:")));
			patientDetails = patientDetails + BedDtls;   //IN040761 -> included to append Bed No & Pri zone
		}
		if (Groupby.equals("P"))
		{	
			if(!temp_id.equals(record[22]))
			{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patientDetails));
            _bw.write(_wl_block30Bytes, _wl_block30);

					if(taskSelect.equals("M") && patTask.getCustomerID().equals("SKR")) 
					{
						if(Integer.parseInt(patTask.getAllergyYN(record[22]))>0)
						{
					
            _bw.write(_wl_block31Bytes, _wl_block31);

						}
					}
					
            _bw.write(_wl_block32Bytes, _wl_block32);

					if (taskSelect.equals("I")||taskSelect.equals(""))
					{
					
            _bw.write(_wl_block33Bytes, _wl_block33);

					}else{
					
            _bw.write(_wl_block34Bytes, _wl_block34);

					}
					
            _bw.write(_wl_block35Bytes, _wl_block35);

					if(taskSelect.equals("") || taskSelect.equals("M"))
					{

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(To_date));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[21]));
            _bw.write(_wl_block41Bytes, _wl_block41);

					}
					else
						out.println("&nbsp;");

            _bw.write(_wl_block42Bytes, _wl_block42);

				temp_id=record[22];
			}
		}
		else if (Groupby.equals("T"))
		{
			if(!temp_id.equals(record[4]))
			{ //IN036495 Start.

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block44Bytes, _wl_block44);
				
				if (taskSelect.equals("I")||taskSelect.equals(""))
					{
					
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block46Bytes, _wl_block46);

					}else{
					
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block48Bytes, _wl_block48);

					}
				//IN036495 End.
				temp_id=record[4];
			}
		}
		
		//IN071618 Starts
		String color_billed = "";
		
		if(!"null".equals(record[57]) || !"".equals(record[57]))
		{
				StringTokenizer stoken = new StringTokenizer(record[57],"!");
			
				while (stoken.hasMoreTokens()) 
				{
				  
				      stoken.nextToken();
		              stoken.nextToken();
		              stoken.nextToken();
					  color_billed = stoken.nextToken();
				 
				}	
				if (color_billed.equals("FULLYORPARTIALLYPAID")) {
					split_order_yn = "Y";
				} 
				

		
		} 
		//IN071618 Ends
		/*for(int j=0;j<record.length;j++)
		{
			out.println("record ="+record[j]+"=<BR>");
		}*/

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[34]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[35]));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[36]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[3]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[36]));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[19]));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[20]));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[26]));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[37]));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[38]));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(record[39]));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(record[58]));
            _bw.write(_wl_block90Bytes, _wl_block90);

//26826 Start.
if(!"".equals(record[58])){
	String  dxChkBfrPlaceOrderYN= bean.allowedNewOrdersYN(record[22],record[20],record[21],record[26],record[58]);

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(dxChkBfrPlaceOrderYN));
            _bw.write(_wl_block92Bytes, _wl_block92);
	
}else{

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);

}
//26826 End.	
	if(record[5].equals("D"))
	{
		cellBGColor = "background-color:#CCFFCC";
	}
	else if(record[5].equals("O") )
	{
		cellBGColor = "background-color:#CCECFF";
	}
	else if(record[5].equals("C") || record[5].equals("P") )
	{
		cellBGColor = "background-color:#66FFCC";
	}
	else if(record[5].equals("E") )
	{
		cellBGColor = "background-color:#FF99CC";
	}
	else if(record[5].equals("F") )
	{
		cellBGColor = "background-color:#D7D7D7";
	}
	else
	{
		cellBGColor = "";
	}
	

            _bw.write(_wl_block94Bytes, _wl_block94);

	if(record[34].equals("B"))
	{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block96Bytes, _wl_block96);

	}
	else
	{

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(cellBGColor));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(record[34]));
            _bw.write(_wl_block100Bytes, _wl_block100);

	}
	if (Groupby.equals("P"))
	{	
		/*
			Modified by Kishore kumar N, for ICN-20903,
 		    date coverted into THAI by using locale
		*/
		String dt = com.ehis.util.DateUtils.convertDate(record[4],"DMY","en",locale);

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(dt));
            _bw.write(_wl_block102Bytes, _wl_block102);

	/*
		ends here.
	*/
	}

            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(record[17]));
            _bw.write(_wl_block104Bytes, _wl_block104);

	if(record[34].equals("I") && record[2].equals("$NTS"))
	{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block106Bytes, _wl_block106);

	}
	else
	{

            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block106Bytes, _wl_block106);

	}
	if(record[41]==null)record[41]="";
	if(record[15].indexOf("$$RD##")!=-1)
	{
		String[] str = (String[])record[15].split("!~!");
		String order_detail ="";
		String[] strtitle = null;
		for(int s=0;s<str.length;s++)
		{
			if(str[s].indexOf("$$RD##")!=-1)
			{
				String line_order = (String)str[s];
				strtitle  =line_order.split("::");
				String titleText = "";
				if(strtitle[1].length()>0)
				{
					titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
				}
				else
				{
					titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
				}
				strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
				order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
			}
			else
			{
				order_detail = order_detail+str[s]+", ";
			}
		}
		record[15] = order_detail;
		if(record[15].lastIndexOf(",") ==((record[15].length())-2))
		{
			record[15] = record[15] .substring(0,((record[15].length())-2));
		}
	}
	if(record[15].indexOf("!~!")!=-1)
	{
		record[15] = record[15].replace("!~!",",");
	}
	
	if(record[34].equals("O") || record[34].equals("R") || record[34].equals("S") || record[34].equals("B") || record[34].equals("C"))
	{
		/*if(record[37].equalsIgnoreCase("DS"))
		{
			parent_order_id = (String)patTask.parentOrderID(record[19]);
			
		}*/

            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(menuText));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[18]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[19]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[20]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[14]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(procedure_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[21]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[23]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[24]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[26]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[27]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[28]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[29]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(sent_out_flag));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[30]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[8]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[31]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[32]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(java.net.URLEncoder.encode(record[12])));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(java.net.URLEncoder.encode(discr_msr_id)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[37]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[38]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[39]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[3]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[40]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[41]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[34]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[42]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[43]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[44]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[45]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(product_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(blood_group));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(rhesus_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[46]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(parent_order_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[49]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[50]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(record[7])));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(patientDtls)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(patName)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(curr_sys_date)));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(record[15]));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(menuText));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[18]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[19]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[20]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[14]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(procedure_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[21]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[23]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[24]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[26]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[27]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[28]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[29]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(sent_out_flag));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[30]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[8]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[31]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[32]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(java.net.URLEncoder.encode(record[12])));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(java.net.URLEncoder.encode(discr_msr_id)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[37]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[38]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[39]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[3]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[40]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[41]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[34]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[42]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[43]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[44]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[45]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(product_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(blood_group));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(rhesus_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(record[46]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(parent_order_id));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[49]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[50]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(record[7])));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(patientDtls)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(patName)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(java.net.URLEncoder.encode(curr_sys_date)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[56]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(split_order_yn));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(record[15]));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
 split_order_yn ="N";//IN071618
	}
	else if ((record[5].equals("D") || record[5].equals("O") ) && (record[34].equals("I")))
	{
		if(record[11].equals("Pending"))
		{
			if(record[35].equals(""))
			{

            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(record[15]));
            _bw.write(_wl_block122Bytes, _wl_block122);

			}
			else
			{
				if(record[35].equals("NT") && record[2].equals("$NTS"))
				{
                   /*Added by Archana Dhal the below trans_pract_id parameter is replaced by req_pract_id parameter on 4/26/2010 at 4:20 PM for IN020723*/

            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[35]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[36]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[21]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(req_pract_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[35]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[36]));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(note_desc));
            _bw.write(_wl_block122Bytes, _wl_block122);

				}
				else
				{

            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[35]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[36]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[21]));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(record[15]));
            _bw.write(_wl_block126Bytes, _wl_block126);

				}
			}
		}
		else
		{
			if(record[35].equals("NT") && record[2].equals("$NTS"))
			{

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(note_desc));
            _bw.write(_wl_block126Bytes, _wl_block126);

			}
			else
			{

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(record[15]));
            _bw.write(_wl_block126Bytes, _wl_block126);

			}
		}
	}
	else if(record[5].equals("D") || record[5].equals("O"))
	{

            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[35]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[36]));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[35]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[36]));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[35]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[36]));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(record[49]));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(record[15]));
            _bw.write(_wl_block122Bytes, _wl_block122);

	}
	else
	{
		if(record[34].equals("I") && record[35].equals("NT") && record[2].equals("$NTS"))
		{

            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(note_desc));
            _bw.write(_wl_block126Bytes, _wl_block126);

		}
		else
		{

            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(record[15]));
            _bw.write(_wl_block126Bytes, _wl_block126);

		}
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

	if (Groupby.equals("T"))
	{

            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(patientDetails));
            _bw.write(_wl_block137Bytes, _wl_block137);
	
	}
	//IN030473 Start.
	if (taskSelect.equals("I")||taskSelect.equals(""))
	{ 

            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block138Bytes, _wl_block138);
if(!"".equals(record[51])){
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[20]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[26]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[51]));
            _bw.write(_wl_block140Bytes, _wl_block140);
}
            _bw.write(_wl_block141Bytes, _wl_block141);
	
	}
	//IN030473 End.
	if(record[34].equals("I") && record[2].equals("$NTS"))
	{

            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(request_pract_name));
            _bw.write(_wl_block143Bytes, _wl_block143);

	}
	else
	{

            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(record[7].equals("")?"&nbsp;":record[7]));
            _bw.write(_wl_block143Bytes, _wl_block143);

	}

            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(record[8].equals("")?"&nbsp;":record[8]));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(record[9].equals("")?"&nbsp;":record[9]));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(record[10].equals("")?"&nbsp;":record[10]));
            _bw.write(_wl_block146Bytes, _wl_block146);

	if(record[34].equals("O") && record[5].equals("C") && !record[24].equals("PF"))
	{

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(record[18]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[19]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(record[23]));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(record[11].equals("")?"&nbsp;":record[11]));
            _bw.write(_wl_block150Bytes, _wl_block150);

		//--[IN033488]
		StringBuffer error_desc=new StringBuffer();	
		error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
		error_desc.append(" ");
		error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
		error_desc.append(" ");
		if(record[24].trim().equals("RM") ||record[24].trim().equals("RS")) 
		{
		ErrStatusChk  = patTask.getRltNoteSts(record[19],locale); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record1 		= (String[])ErrStatusChk.get(j);
					action_type				= record1[2];
					action_date_time		= record1[1];
					action_by_id			= record1[0];
				}
			}
		if(action_type.equals("ER"))
		{
		
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(error_desc));
            out.print( String.valueOf(action_by_id));
            _bw.write(_wl_block152Bytes, _wl_block152);

		action_type = "";//IN040198
		}
		}
		
		//--[IN033488]
		
            _bw.write(_wl_block153Bytes, _wl_block153);

	}
	else
	{
		if(record[34].equals("B"))
		{	
			if(record[47].equals("Transfused"))
			{
				record[47] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA."+record[47]+".label","ca_labels");

            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(record[47]));
            _bw.write(_wl_block156Bytes, _wl_block156);

			}
			else if(record[47].equals("ReserveAndRequest"))
			{
				record[47] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA."+record[47]+".label","ca_labels");

            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(request_date));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(request_by));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(record[47]));
            _bw.write(_wl_block156Bytes, _wl_block156);


			}
			else
			{
				record[47] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA."+record[47]+".label","ca_labels");

            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(record[47].equals("")?"&nbsp;":record[47]));
            _bw.write(_wl_block126Bytes, _wl_block126);

			}
		}
		else if(record[34].equals("I"))
		{
			if(record[11].equals("Pending") && record[2].equals("$NTS"))
			{

            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingTranscription.label","ca_labels")));
            _bw.write(_wl_block126Bytes, _wl_block126);

			}
			else
			{

            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(record[11].equals("")?"&nbsp;":record[11]));
            _bw.write(_wl_block126Bytes, _wl_block126);

			}
		}
		else
		{

            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(record[11].equals("")?"&nbsp;":record[11]));
            _bw.write(_wl_block126Bytes, _wl_block126);

		}
	}

            _bw.write(_wl_block158Bytes, _wl_block158);

	} //for
} //else

}
catch(Exception e)
{
	
	e.printStackTrace();
}
finally 
{
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();
	if(con!=null)ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(AdminRoute));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(callFrom));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(isBTViewBillDtls));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(from));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(to));
            _bw.write(_wl_block169Bytes, _wl_block169);
 if("V".equals(taskSelect)){

            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block171Bytes, _wl_block171);
}
            _bw.write(_wl_block172Bytes, _wl_block172);

	putObjectInBean("patTask",patTask,session);

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Request.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.PatientInstructionsIntervention.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestedBy.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stage.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Position.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ViewMARChart.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
