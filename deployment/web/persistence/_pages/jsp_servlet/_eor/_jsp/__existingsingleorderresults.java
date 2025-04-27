package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __existingsingleorderresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ExistingSingleOrderResults.jsp", 1743503773389L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n20/07/2012    IN033471      NijithaS    System does not filter the Order Categories in One Day and Continue Order.      \n17/10/2012\t  IN035773      NijithaS\tSearch order that sort by order category, system display correctly in first page but when click �??next�?? to view next page system display all category - not correct. \n19/10/2012    IN033061      Chowminya G  System doesnt display menu cancel/discontinue if the orders are IV Fluid ,IV Fluid+Drug, IV Fluid+Drug(Frequency).\n22/11/2012    IN033160      Chowminya G  Thai screen displayed English date  \n01/08/2018\t\tIN64543\t\t\tDinesh T\t\t01/08/2018\tRamesh G\t\tML-MMOH-CRF-0776\n19/03/2019\t  IN069932\t\tRaja S\t\t19/03/2019\tRamesh G\t\tSKR-SCF-1166\t\n14/10/2019    IN071315\t    Nijitha S   14/10/2019  Ramesh G\t\tGHL-CRF-0607\t\n28/02/2022    IN27707       Suji Keerthi.G   28/02/2022    Ramesh G    SKR-CRF-0052  \n28/06/2022\t  32825\t\t\tRamesh G \t\t\tSKR-SCF-1681 \t \n-----------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/>\n\t\n \t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ExistingSingleOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ViewSingleOrder.js\"></script> \n \t<script language=\"JavaScript\" src=\"../js/ResultOrder.js\"></script> \n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style>\n\t\t.gridData1\n\t\t{\n\t\t\tbackground-color:#FFFFCC;\n\t\t\theight:18px;\n\t\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\t\tfont-size: 8pt;\n\t\t\tcolor: #0000FF;\n\t\t\tfont-weight:normal;\n\t\t\ttext-align:left;\n\t\t\tpadding-left:10px;\n\t\t\tpadding-right:10px;\n\t\t\tvertical-align:middle;\n\t\t\t\n\t\t\tborder-top:0px;\n\t\t\tborder-left:0px;\n\t\t\tborder-right:0px;\n\t\t\t\n\t\t\tborder-color:#EEEEEE;\n\t\t}\n\t\t.gridData2\n\t\t{\n\t\t\tbackground-color:PINK;\n\t\t\theight:18px;\n\t\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\t\tfont-size: 8pt;\n\t\t\tcolor: #0000FF;\n\t\t\tfont-weight:normal;\n\t\t\ttext-align:left;\n\t\t\tpadding-left:10px;\n\t\t\tpadding-right:10px;\n\t\t\tvertical-align:middle;\n\t\t\t\n\t\t\tborder-top:0px;\n\t\t\tborder-left:0px;\n\t\t\tborder-right:0px;\n\t\t\t\n\t\t\tborder-color:#EEEEEE;\n\t\t}\n\t\t.gridData3\n\t\t{\n\t\t\theight:18px;\n\t\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\t\tfont-size: 8pt;\n\t\t\tcolor: #000000;\n\t\t\tfont-weight:normal;\n\t\t\t\n\t\t\tborder-top:0px;\n\t\t\tborder-left:0px;\n\t\t\tborder-right:0px;\n\t\t\t\n\t\t\tborder-color:#EEEEEE;\n\t\t\ttext-align:left;\n\t\t\tpadding-left:10px;\n\t\t\tpadding-right:10px;\n\t\t\tvertical-align:middle;\n\t\t}\n\t\t\n\t</style>\n\t<script>\n\t\n\tfunction hideToolTip(obj,imgObj,row,originaltdcolor)\t\n\t{\n\t\tdynamicMenuHide(obj, window.event,row,originaltdcolor);\n\t}\n\n\tfunction callMouseOver(obj)\t\n\t{\n\t\tcurrClass = obj.className ;\n\t\tobj.className = \'selectedcontextMenuItem\';\n\t}\n\n\tfunction callOnMouseOut(obj)\n\t{\n\t\tobj.className = \'contextMenuItem\';\n\t}\n\n/*function resizeWindow(orderctlHDR, event) {\n  var tooltip = document.getElementById(\"tooltiplayer\");\n  var orderctlRect = orderctlHDR.getBoundingClientRect(); // Get position of the clicked element\n  var tooltipWidth = tooltip.offsetWidth;\n  var tooltipHeight = tooltip.offsetHeight;\n\n  var viewportWidth = document.documentElement.clientWidth; // Viewport width\n  var viewportHeight = document.documentElement.clientHeight; // Viewport height\n\n  // Calculate the default position (to the right of the clicked element)\n  var x = orderctlRect.right + 10; // Add 10px padding between the tooltip and the element\n  var y = orderctlRect.top + window.scrollY; // Align vertically with the clicked element\n\n  // Adjust position if the tooltip exceeds the viewport boundaries\n  if (x + tooltipWidth > viewportWidth) {\n    // If tooltip exceeds the right boundary, place it on the left\n    x = orderctlRect.left - tooltipWidth - 10; // Add 10px padding\n  }\n\n  if (y + tooltipHeight > viewportHeight) {\n    // If tooltip exceeds the bottom boundary, adjust upward\n    y = viewportHeight - tooltipHeight - 20; // Keep 20px margin from the bottom\n  }\n\n  // Apply the calculated position\n  tooltip.style.left = x + \"px\";\n  tooltip.style.top = y + \"px\";\n\n  // Make the tooltip visible\n  tooltip.style.visibility = \"visible\";\n}\n*/\nfunction resizeWindow(orderctlHDR, event) {\n  var tooltip = document.getElementById(\"tooltiplayer\");\n  var orderctlRect = orderctlHDR.getBoundingClientRect(); // Get position of the clicked element\n  var tooltipWidth = tooltip.offsetWidth;\n  var tooltipHeight = tooltip.offsetHeight;\n\n  var viewportWidth = document.documentElement.clientWidth; // Viewport width\n  var viewportHeight = document.documentElement.clientHeight; // Viewport height\n\n  // Calculate the default position (to the right of the clicked element)\n  var x = orderctlRect.right + 10 + window.scrollX; // Adjust for horizontal scroll\n  var y = orderctlRect.top + window.scrollY; // Adjust for vertical scroll\n\n  // Adjust position if the tooltip exceeds the viewport boundaries\n  if (x + tooltipWidth > viewportWidth + window.scrollX) {\n    // If tooltip exceeds the right boundary, place it on the left\n    x = orderctlRect.left - tooltipWidth - 10 + window.scrollX; // Adjust for horizontal scroll\n  }\n\n  if (y + tooltipHeight > viewportHeight + window.scrollY) {\n    // If tooltip exceeds the bottom boundary, adjust upward\n    y = viewportHeight + window.scrollY - tooltipHeight - 20; // Keep 20px margin from the bottom\n  }\n\n  // Apply the calculated position\n  tooltip.style.left = x + \"px\";\n  tooltip.style.top = y + \"px\";\n\n  // Make the tooltip visible\n  tooltip.style.visibility = \"visible\";\n}\n\n\n\n\t\n\t//function displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,orderctlHDR,imgObj)//IN64543\n\tfunction displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,orderctlHDR,imgObj,line)//IN64543\n\t{\n\t\t\t\tcallOnClickMouseOverOnTD(orderctlHDR,imgObj);\n\n\t\t//buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num);//IN64543\n\t\tbuildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,line);//IN64543\n\t\tresizeWindow(orderctlHDR);\n\t}\n\t\n\n\t//function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num)//IN64543\n\tfunction buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,line)//IN64543\n\t{\t\t\n\t\tvar rowval   = val.split (\",\");\n\t\tvar row      = (\"View,Cancel,Amend,Preps,Comments,Instructions,,Discontinue,Hold,Resume,LinkToCurrentEncounter,Replace,ViewReplacedOrder,ViewOriginalOrder,Renew\");\n\t\t\t\n\t\trowval1      = row.split(\",\");\n\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n\t\t\n\t\tfor( var i=0; i<rowval.length; i++ ) \n\t\t{\n\t\t\tvar colval  = rowval[i];\n\t\t\tvar colval1 = rowval1[i];\n\t\t\tif (colval != \"\" )\n\t\t\t{\n\t\t\t\ttab_dat     += \"<tr>\";\n\t\t\t\n\t\t\t\tif (colval1 == \"Renew\" || colval1 == \"Amend\") \n\t\t\t\t{\t\t\t\t\n\t\t\t\t\tqueryString = document.existing_order_dtl.queryString.value;\n\t\t\t\t\tif (colval1 == \"Renew\" && (ord_cat != \'PH\')) \n\t\t\t\t\t{\n\t\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=\\\"javascript:callRenewFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+escape(queryString)+\"\')\\\">\"+colval+\" </a></td>\";\n\t\t\t\t\t} \n\t\t\t\t\telse \n\t\t\t\t\t{\n\t\t\t\t\t\t   tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=\\\"javascript:callAmmendFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\')\\\">\"+colval+\"</a></td>\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t{\n\t\t\t\t\t//var order_status=\"\";//Commented for IN069932 \n\t\t\t\t\t//tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+ord_typ_code+\"\',\'\"+encntr_id+\"\',\'\"+patient_class+\"\',\'\"+location_code+\"\',\'\"+location_type+\"\',\'\"+episode_id+\"\',\'\"+episode_visit_num+\"\',\'\"+iv_prep_yn+\"\')>\"+colval+\" </a></td>\";//Included iv_prep_yn --[IN033061]//IN64543\n\t\t\t\t\t//tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+ord_typ_code+\"\',\'\"+encntr_id+\"\',\'\"+patient_class+\"\',\'\"+location_code+\"\',\'\"+location_type+\"\',\'\"+episode_id+\"\',\'\"+episode_visit_num+\"\',\'\"+iv_prep_yn+\"\',\'\"+line+\"\')>\"+colval+\" </a></td>\";//Included iv_prep_yn --[IN033061]//IN64543\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+ord_typ_code+\"\',\'\"+encntr_id+\"\',\'\"+patient_class+\"\',\'\"+location_code+\"\',\'\"+location_type+\"\',\'\"+episode_id+\"\',\'\"+episode_visit_num+\"\',\'\"+iv_prep_yn+\"\',\'\"+line+\"\',\'\"+p_called_from_ca+\"\')>\"+colval+\" </a></td>\";//Included iv_prep_yn -";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="-[IN033061]//IN64543//Added for IN071315\n\t\t\t\t}\n\t\t\t\ttab_dat     += \"</tr> \"\n\t\t\t}\n\t\t}\n\t\ttab_dat     += \"</table> \"\n\t\t\n\t\tdocument.getElementById(\'tooltd\').innerHTML = tab_dat;\n\t}\n\tasync function viewCanOrderFormatLineCmts(line,order_line_num,orderId,view_by)\n\t{\n\t\tvar dialogHeight =\'14\' ;\n\t\tvar dialogWidth = \'29\' ;\n\t\tvar dialogTop\t= \'189\';\n\t\tvar dialogLeft = \'167\' ;\n\t\tvar title = \'\';\n\t\tvar cancel_date_time = \"\";\n\t\tvar cancel_pract_id  = \"\";\n\n\t\tvar can_reason = eval(\"document.existing_order_dtl.Can_Reason\"+line+\".value\");\n\t\t\t\n\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\';dialogTop:\'+dialogTop+\';dialogLeft:\'+dialogLeft+\';dialogTitle:\'+title+\'; scroll=no; status=no\';\n \t\tif(can_reason==\"Comments\")\n\t\t\tvar narration = eval(\"document.existing_order_dtl.Cmts\"+line+\".value\");\n\t\telse\n\t\t{\n \t\t\tvar narration = eval(\"document.existing_order_dtl.Cancel\"+line+\".value\");\n\t\t\tcancel_date_time =  eval(\"document.existing_order_dtl.Cancel_date_time\"+line+\".value\"); \n\t\t\tcancel_pract_id =  eval(\"document.existing_order_dtl.Cancel_pract_id\"+line+\".value\"); \n\t\t}\t\n \t\tvar arguments = \"\";\n\t\t\t\n\t\tvar finalString\t= \"can_reason=\"+encodeURIComponent(can_reason)+\"&cancel_date_time=\"+cancel_date_time+\"&cancel_pract_id=\"+cancel_pract_id+\"&order_line_num=\"+order_line_num+\"&orderId=\"+orderId+\"&view_by=\"+view_by;\n\t\tvar retVals = await window.showModalDialog(\"../../eOR/jsp/ViewLineComment.jsp?\"+finalString,arguments,features);\n\n\t}\n\tfunction showSlidingDetails(order_id, order_line_num, sliding_scale_yn)\n\t{\n        var dialogHeight= \"13\" ;\n        var dialogWidth = \"35\" ;\n        var dialogTop = \"400\" ;\n        var center = \"1\" ;\n        var status=\"no\";\n        var features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" +    dialogTop;\n        var arguments = \"\" ;\n        var retVal =       window.showModalDialog(\"../../ePH/jsp/QueryPatientDrugProfileRemarks.jsp?order_id=\"+order_id+\"&order_line_num=\"+order_line_num+\"&sliding_scale_yn=\"+sliding_scale_yn+\"&called_frm=SlidingScale\",arguments,features);\n\t}\n\t\n\tfunction callMouseOut(obj,originaltdcolor)\n\t{\n\t\tobj.style.backgroundColor = originaltdcolor;\n\t\tobj.className = \'gridDataBlue\';\n\t}\n</script>\n \t\n</head>\n<body  onscroll=\'continuousprocessScroll()\' onload=\'FocusFirstElement()\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\"existing_order_dtl\" id=\"existing_order_dtl\" action=\"../../eOR/jsp/ExistingSingleOrderResults.jsp\" method=\"post\" >\n<div id=\"divHeadSep\" >\n<table cellpadding=\'3\' cellspacing=\'0\'  cellpadding=\"3\"  style=\"width: 100%; table-layout: fixed;\">\n\t<tr id=\'heading2\'>\n\t\t<TD width=\'50%\' colspan=\'5\' align=\'center\' class=\'CASECONDSELECTHORZ\' style=\'font-size:13pt\'><b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td>\n\t\t<td width=\'1%\' bgcolor=\'#000000\'>&nbsp;</td>\n\t\t<TD width=\'50%\' colspan=\'5\' align=\'center\' class=\'CASECONDSELECTHORZ\' style=\'font-size:13pt\'><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td>\n\t</tr>\n\t<tr id=\'heading1\'>\n\t\t<td class=\'columnheader\' width=\'\' nowrap></td>\n\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td class=\'columnheader\' width=\'\' nowrap></td>\n\t\t<td bgcolor=\'#000000\'>&nbsp;</td>\n\t\t<td class=\'columnheader\' width=\'\' nowrap></td>\n\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<td class=\'columnheader\' width=\'\' nowrap></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<tr align=\'left\'>\n\t\t\t<td class = \'gridData\' colspan=\"11\">\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<tr align=\"right\" id=\'heading\' bgcolor=\'WHITE\'>\n\t\t\t\t\t<td colspan=\"11\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t\t\t \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" \t\t\t\t\t\t\t\t \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<tr align=\"right\" id=\"heading\" bgcolor=\'white\'>\n\t\t\t\t\t<td colspan=\"11\">\n\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<TR height=\"25px;\">\n\t\t\t\t<TD colspan=\'5\' class=\'columnheader\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</TD>\n\t\t\t\t<TD bgcolor=\'#000000\'>&nbsp;</TD>\n\t\t\t\t<TD colspan=\'5\' class=\'columnheader\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</TD>\n\t\t\t</TR>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\n\t\t\t\t<td class=\'gridData3\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t<input type=\'hidden\' name=\'line_num";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'line_num";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'start_date_time";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'start_date_time";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'catalog_code";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'catalog_code";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'item_narration";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'item_narration";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'location_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'location_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'patient_class";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'patient_class";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'cont_order_ind";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'cont_order_ind";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'copy_yn";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'copy_yn";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'source_type";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'source_type";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'order_category";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'order_category";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'ord_typ_code";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'ord_typ_code";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'ord_typ_desc";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'ord_typ_desc";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'ord_id";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' id=\'ord_id";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\n\t\t\t\t<td ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" width=\'\' nowrap  style=\'height:18px;\tfont-family: Verdana, Arial, Helvetica, sans-serif;\tfont-size: 8pt;\tfont-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-top:0px;border-left:0px;border-right:0px;border-style:solid;\' class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'> \n\t\t\t\t<input type=\"hidden\" name=\"Appt";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"Appt";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"Appt_date";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"Appt_date";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"performing_facility_id";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"performing_facility_id";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"appt_locn";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"appt_locn";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"appt_resched_yn";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"appt_resched_yn";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"appt_resched_reason";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"appt_resched_reason";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"no_of_reschedules";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"no_of_reschedules";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"parent_order_id";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"parent_order_id";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"parent_order_line_num";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"parent_order_line_num";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"explanatory_text";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"instrn_type";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"instrn_type";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"><!--IN64543-->\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:showCareSetViewResults(\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\",\"\",\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\",\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\")\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" <!--call Notes view  -->\n\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\',\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\')\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" <!-- Result View --> \n\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t</a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t<input class=\"button\" type=\"button\" name=\"existing_consent_id_lookup";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" id=\"existing_consent_id_lookup";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\"  title=\'Consent Required\' value=\"C\" onClick=\"callMultipleConsent(\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\')\">   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewApptData(escape(\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'))\"> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewOAApptData(escape(\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t<input class=\"BUTTON\" ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" type=\"button\" name=\"ReSchedule";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" value=\"R\" onClick=\"viewReSchedule(escape(\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'))\"> \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t<input class=\"BUTTON\" ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" type=\"button\" name=\"Schedule";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" value=\"S\" onClick=\"BookAppointment(escape(\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'))\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\')\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t<Input type=\'hidden\' name=\"Cancel";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" id=\"Cancel";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"Cancel_date_time";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\" id=\"Cancel_date_time";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"Cancel_pract_id";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\" id=\"Cancel_pract_id";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"Can_Reason";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\" id=\"Can_Reason";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t\t\t\t\t<Input type=\"button\" name=\"cancel_comment";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" id=\"cancel_comment";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" value=\"?\" class=\"button\" onClick=\"viewCanOrderFormatLineCmts(\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\')\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\n\t\t\t\t</td>\n\t\t\t\t<TD class=\'gridData3\' ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="> ";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</TD>\n\t\t\t\t<td border=\'1\' bgcolor=\'#000000\'>&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\'>&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\'>&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\'>&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\'>&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\'>&nbsp;</td>\n\t\n\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\n\t\t\t\t<td class=\'gridData3\' >&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\'>&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\'>&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\'>&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\'>&nbsp;</td>\n\t\t\t\t<td border=\'1\' bgcolor=\'#000000\'>&nbsp;</td>\n\t\t\t\t<td class=\'gridData3\' ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =" \n\t\t\t\t\t</a>\n\t\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'))\"> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\n\t\t\t\t</td>\n\t\t\t\n\t\t\t\t<TD class=\'gridData3\' ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="bgcolor=\'#FFFFCC\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="bgcolor=\'PINK\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =" >";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</TD>\n\t\n\t\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t</tr>\n</table>\n</div>\n<input type=\'hidden\' name=\'source_type\' id=\'source_type\' value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\n<input type=hidden name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n\n<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\n<input type=hidden name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n<input type=hidden name=\'pract_reln_id\' id=\'pract_reln_id\' value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'>\n<input type=hidden name=\'location_type\' id=\'location_type\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n<input type=hidden name=\'location_code\' id=\'location_code\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'>\n<input type=hidden name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n<input type=hidden name=\'function_from\' id=\'function_from\' value=\'\'>\n\n<input type=hidden name=\'p_called_from_ca\' id=\'p_called_from_ca\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'>\n<input type=hidden name=\'sex\' id=\'sex\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n<input type=hidden name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n<input type=hidden name=\'dob\' id=\'dob\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>\n<input type=hidden name=\'visit_adm_date\' id=\'visit_adm_date\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n<input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n<input type=\'hidden\' name=\'encntr_id\' id=\'encntr_id\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'>\n<input type=\'hidden\' name=\'relationship_id\' id=\'relationship_id\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n<input type=\'hidden\' name=\'ord_status\' id=\'ord_status\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'>\n<input type=\'hidden\' name=\'order_by\' id=\'order_by\' value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'>\n<input type=\'hidden\' name=\'catalog\' id=\'catalog\' value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'>\n<input type=\'hidden\' name=\'order_type\' id=\'order_type\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\'>\n<input type=\'hidden\' name=\'view\' id=\'view\' value=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\'>\n<input type=\'hidden\' name=\'priority\' id=\'priority\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n<input type=\'hidden\' name=\'date_from\' id=\'date_from\' value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>\n<input type=\'hidden\' name=\'date_to\' id=\'date_to\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\n<input type=\'hidden\' name=\'order_category\' id=\'order_category\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n<input type=\'hidden\' name=\'view_by\' id=\'view_by\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n<input type=\'hidden\' name=\'search_criteria\' id=\'search_criteria\' value=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\n<input type=\'hidden\' name=\'cosign\' id=\'cosign\' value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>\n<input type=\'hidden\' name=\'activity_type\' id=\'activity_type\' value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'>\n<input type=\'hidden\' name=\'curr_sys_date\' id=\'curr_sys_date\' value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'>\n<input type=\'hidden\' name=\'start_date_obj\' id=\'start_date_obj\' value=\'\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'>\n<input type=\'hidden\' name=\'elapsed_orders\' id=\'elapsed_orders\' value=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\n<input type=\'hidden\' name=\'sys_cancelled_orders\' id=\'sys_cancelled_orders\' value=\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\'>\n<input type=\'hidden\' name=\'group_by\' id=\'group_by\' value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'><!-- Menaka -->\n<input type=\'hidden\' name=\'order_frequency\' id=\'order_frequency\' value=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'><!-- Menaka -->\n<input type=hidden name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\'>\n<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\'>\n<input type=\'hidden\' name=\'category_type\' id=\'category_type\' value=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'>\n<input type=\'hidden\' name=\'ordercate_for_filter\' id=\'ordercate_for_filter\' value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\'> <!-- IN035773  -->\n<input type=\'hidden\' name=\'call_from\' id=\'call_from\' value=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\'> <!-- 32825 -->\n\n</form>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\"position: absolute; visibility: hidden; width: 150px; height: 100px;\" bgcolor=\'blue\' >\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' id=\'tooltd\'>&nbsp;</td>\n\t\t\n\t\t</tr>\n\t</table>\n</div>\n</body>\n<script>\nif(parent.parent.ExistingOrderSearch)\n{\n\tparent.parent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;\n    if(document.getElementById(\"select_all\"))\n\t{\n\t   document.getElementById(\"select_all\").disabled = false;\n\t}\n}\nelse if(parent.ExistingOrderSearch.document.existing_order_search)\n{\n\tparent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;\n\tif(document.getElementById(\"select_all\"))\n\t{\n\t   document.getElementById(\"select_all\").disabled = false;\n\t}\n}\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String login_user	= (String)session.getValue("login_user");
	String mode	   = "1";
	String patient_id	= request.getParameter("patientId");
	String encounter_id	= request.getParameter("encntr_id");
	String bean_id 		= "@existingorderbean"+patient_id+encounter_id;
 	String bean_name = "eOR.ExistingOrder";
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
    bean.setLanguageId(localeName);
	bean.setSiteSpecific("DEFAULT_ORDER_STATUS"); //IN27707
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String pract_reln_id = request.getParameter("pract_reln_id")==null?"":request.getParameter("pract_reln_id");
	String practitioner_type  	= (String) session.getValue("practitioner_type");
	if(practitioner_type== null)practitioner_type = "";
	if(resp_id== null)resp_id = "";
	String order_set_expln_txt="View Order Set Detail";
	String rd_install	= "N";
	String ot_install	= "N";
 	String old_order_date = "";
	
	String episode_id ="";
	String episode_visit_num ="";
	ArrayList allValues = new ArrayList();
	
	
	Properties properties	= (Properties) session.getValue( "jdbc" );
	String patientId		= request.getParameter( "patientId" ) ;
	String encntr_id		= request.getParameter( "encntr_id" ) ;
	String order_status		= request.getParameter( "ord_status" ) ;
	String order_by			= request.getParameter( "order_by" ) ;
	String catalog			= request.getParameter( "catalog" ) ;
	String view				= request.getParameter( "view" ) ;
	String priority			=  request.getParameter( "priority" );
	String date_from		= request.getParameter( "date_from" ) ;
	String date_to			= request.getParameter( "date_to" ) ;
	String order_category	= request.getParameter( "order_categ" ) ;
	
	String order_type		= request.getParameter( "order_type" ) ;
	String view_by			= request.getParameter( "view_by" ) ;
	String search_criteria	= request.getParameter( "search_criteria" ) ;
	String cosign			= request.getParameter("cosign") ;
	String activity_type			= request.getParameter("activity_type") ;
	String elapsed_orders			= request.getParameter("elapsed_orders") ;
	String sys_cancelled_orders			= request.getParameter("sys_cancelled_orders") ;
	String group_by			= request.getParameter( "group_by" ) ;//Menaka
	String order_frequency			= request.getParameter( "order_frequency" ) ;//Menaka
	//IN27707 Starts
	String called_frm1			= request.getParameter( "called_from" ) ;
	if(called_frm1== null)called_frm1 = "";
	String call_from			= request.getParameter( "call_from" )==null?"":request.getParameter( "call_from" );
	if(call_from.equals("undefined")) call_from = "";
	//IN27707 Ends
	String category_type	= "";
	category_type 	= request.getParameter( "category_type" ) ;
	if(category_type != null )category_type = category_type.trim();	else category_type = "I";
	
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"30") ;
		
	
 	int start	 = Integer.parseInt(from);
	int end		= Integer.parseInt(to);
		
	String curr_sys_date    = "";
	String location_type			= bean.checkForNull(request.getParameter("location_type"),"");
	String location_code			= bean.checkForNull(request.getParameter("location_code"),"");
	String patient_class			= bean.checkForNull(request.getParameter("patient_class"),"");
	String p_called_from_ca			= bean.checkForNull(request.getParameter("p_called_from_ca"),"");
	String sex						= bean.checkForNull(request.getParameter("sex"),"");
	String age						= bean.checkForNull(request.getParameter("age"),"");
	String dob						= bean.checkForNull(request.getParameter("dob"),"");
 	String visit_adm_date			= bean.checkForNull(request.getParameter("visit_adm_date"),"");
 	String called_from			= bean.checkForNull(request.getParameter("called_from"),"");
	String str_value				= "";
	String total_query_records		= "0";
	
	if(called_from.equalsIgnoreCase("CategoryList")){
		//order_category	= request.getParameter( "order_category" ) ; 
		order_category	= request.getParameter( "ordercate_for_filter" ) ; //IN033471
	}
	else 
		order_category = "";
		
			
	if(patientId != null )patientId = patientId.trim();			else patientId = "";
	if(encntr_id != null )encntr_id = encntr_id.trim();			else encntr_id = "";

	if(view != null )view = view.trim();						else view = "";
	if(order_status != null )order_status = order_status.trim();else order_status = "";
	if(priority != null )priority = priority.trim();			else priority = "";
	if(date_from != null )date_from = date_from.trim();			else date_from = "";
	if(date_to != null )date_to = date_to.trim();				else date_to = "";
	if(order_category != null )order_category = order_category.trim();	else order_category = "";
	
	if(order_type != null )order_type = order_type.trim();		else order_type = "";
	if(activity_type != null )activity_type = activity_type.trim();		else activity_type = "";
	
	if(cosign != null )cosign = cosign.trim();					else cosign = "";
	if(catalog != null )catalog = catalog.trim();				else catalog = "";
	if(search_criteria != null )search_criteria = search_criteria.trim();	else search_criteria = "";
	if(order_by != null )order_by = order_by.trim();			else order_by = "";
	if(view_by != null )view_by = view_by.trim();				else view_by = "";
	if(group_by != null )group_by = group_by.trim();			else group_by = "";//Menaka
	if(order_frequency != null )order_frequency = order_frequency.trim();				else order_frequency = "";//Menaka
	if(elapsed_orders != null )elapsed_orders = elapsed_orders.trim();				else elapsed_orders = "";
	if(sys_cancelled_orders != null )sys_cancelled_orders = sys_cancelled_orders.trim();				else sys_cancelled_orders = "";
	
	// Get the date Sysdate  (IF Appointment is there, and start_date_time is less than sysdate, then have to pass the sysdate
	ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
	for(int i=0;i<sysdate.size();i++)
	{
		curr_sys_date	= (String)sysdate.get(0);
 	}
	allValues		= bean.getSingleContinuousOrderDetails(view,patientId,encntr_id,order_status,order_by,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, activity_type, practitioner_type,elapsed_orders,sys_cancelled_orders,start,end,(String)session.getAttribute("responsibility_id"),(String)session.getAttribute("ca_practitioner_id"),pract_reln_id,category_type,login_user,facility_id,call_from,called_frm1); //IN27707
		
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	if((allValues.size() == 0))
	{
		
            _bw.write(_wl_block15Bytes, _wl_block15);

				try
				{ 							
					String returnText = SpringCacheBean.getMessage(pageContext,"NO_RECORD_FOUND_FOR_CRITERIA","common");
					out.println(returnText);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
            _bw.write(_wl_block16Bytes, _wl_block16);

	}
	String slClassValue = "";
	slClassValue="gridData3";
	String src_type = request.getParameter("source_type");
	if(src_type==null) src_type= "";
	String cont_order_ind = "";
	String[] existing_details = null;
	String can_reason = null;
	String can_date_time = null,can_pract_id = null;
	String disc_pract_id = null, disc_date_time = null;

	String appt_ref_num  = null, appt_date		= null;
	String appt_locn	  = null, appt_resched_yn		= "N";
	String appt_reqd_yn	  = "N";
	String appt_resched_reason  = null, no_of_reschedules = null;
	String last_action_reason_desc  = null;
	String sec_order_yn	= null,	pri_order_id = null;
	String last_action_type = null;
	String accession_num = null;
	String ext_appl_accession_num = null;
	String accession_num_tooltip = null;

	String order_catalog_nature	= null;
	String display_appt_yn		= "N";
	String notify_yn			= "N";
	String [] colorString = {"X","X","X","X"};
	String color_string = "X,X,X,X";
	String appt_disabled = "";
	String allow_cancel_yn = "";

	StringTokenizer menu_options = null;
	int i = 0;
    String billing_package_ref = "";

	StringBuffer strOrderCtl = new StringBuffer();
	String originaltdcolor = "";
	
	for(int k=0; k<allValues.size(); k++)
	{
		if(strOrderCtl.length() > 0)
			strOrderCtl = strOrderCtl.delete(0,strOrderCtl.length());
		existing_details = (String[])allValues.get(k);
        if(existing_details[0] == null) existing_details[0] = "";
        if(existing_details[1] == null) existing_details[1] = "";
        if(existing_details[2] == null) existing_details[2] = "";
        if(existing_details[3] == null) existing_details[3] = "";
		if(existing_details[4] == null) existing_details[4] = "";
        if(existing_details[5] == null) existing_details[5] = "";
        if(existing_details[6] == null) existing_details[6] = "";
        if(existing_details[7] == null) existing_details[7] = "";
		if(existing_details[8] == null) existing_details[8] = "";
		if(existing_details[9] == null) existing_details[9] = "";
		if(existing_details[10] == null) existing_details[10] = "";
		if(existing_details[11] == null) existing_details[11] = "";
        if(existing_details[12] == null) existing_details[12] = "";
        if(existing_details[13] == null) existing_details[13] = "";
        if(existing_details[14] == null) existing_details[14] = "";
        if(existing_details[15] == null) existing_details[15] = "";
        if(existing_details[16] == null) existing_details[16] = "";
        if(existing_details[17] == null) existing_details[17] = "";
		if(existing_details[18] == null) existing_details[18] = "";
		if(existing_details[19] == null) existing_details[19] = "";
		if(existing_details[20] == null) existing_details[20] = "";
		if(existing_details[21] == null) existing_details[21] = "";
        if(existing_details[22] == null) existing_details[22] = "";
        if(existing_details[23] == null) existing_details[23] = "";
        if(existing_details[24] == null) existing_details[24] = "";
		if(existing_details[25] == null) existing_details[25] = "";
       	if(existing_details[26] == null) existing_details[26] = "N";
       	if(existing_details[27] == null) existing_details[27] = "";
       	if(existing_details[28] == null) existing_details[28] = "";
       	if(existing_details[29] == null) existing_details[29] = "";
       	if(existing_details[30] == null) existing_details[30] = "";
       	if(existing_details[31] == null) existing_details[31] = "";
		if(existing_details[32] == null) existing_details[32] = "";
		if(existing_details[33] == null) existing_details[33] = "";
		if(existing_details[34] == null) existing_details[34] = "";
		if(existing_details[35] == null) existing_details[35] = "";
		if(existing_details[36] == null) existing_details[36] = "";
		if(existing_details[37] == null) existing_details[37] = "";
		if(existing_details[38] == null) existing_details[38] = "";
		if(existing_details[39] == null) existing_details[39] = "";
		if(existing_details[40] == null) existing_details[40] = "";
		if(existing_details[41] == null) existing_details[41] = "";
		if(existing_details[42] == null) existing_details[42] = "";
		if(existing_details[43] == null) existing_details[43] = "";
		if(existing_details[47] == null) existing_details[47] = "";
		if(existing_details[48] == null) existing_details[48] = "";
		if(existing_details[50] == null) existing_details[50] = "";
		if(existing_details[51] == null) existing_details[51] = "";
		if(existing_details[52] == null) existing_details[52] = "";
		if(existing_details[53] == null) existing_details[53] = "";
		if(existing_details[54] == null) existing_details[54] = "";		

		if(existing_details[26] == null) existing_details[26] = "N";
		if(existing_details[36] == null) existing_details[36] = "X,X,X,X"; // color
		if(existing_details[43] == null) existing_details[43] = "";
		if(existing_details[44] == null) existing_details[44] = "";
		if(existing_details[45] == null) existing_details[45] = "";
		if(existing_details[46] == null) existing_details[46] = "";			
		if(existing_details[49] == null) existing_details[49] = "";
		if(existing_details[50] == null) existing_details[50] = "";
		if(existing_details[51] == null) existing_details[51] = "N";
		if(existing_details[52] == null) existing_details[52] = "";
		if(existing_details[53] == null) existing_details[53] = "";
		if(existing_details[54] == null) existing_details[54] = "";
		if(existing_details[55] == null) existing_details[55] = "N";
		if(existing_details[56] == null) existing_details[56] = "";
		if(existing_details[57] == null) existing_details[57] = "";
		if(existing_details[58] == null) existing_details[58] = "0";
		if(existing_details[59] == null) existing_details[59] = "";
		if(existing_details[60] == null) existing_details[60] = "";
		if(existing_details[61] == null) existing_details[61] = "";
		if(existing_details[62] == null) existing_details[62] = "";
		if(existing_details[63] == null) existing_details[63] = "";
		if(existing_details[64] == null) existing_details[64] = "";
		if(existing_details[65] == null) existing_details[65] = "";
		if(existing_details[66] == null) existing_details[66] = "";
		if(existing_details[67] == null) existing_details[67] = "";
		if(existing_details[68] == null) existing_details[68] = "";
		if(existing_details[69] == null) existing_details[69] = "";
		if(existing_details[70] == null) existing_details[70] = "";
		if(existing_details[71] == null) existing_details[71] = "";
		if(existing_details[72] == null) existing_details[72] = "";
		if(existing_details[73] == null) existing_details[73] = "";	
		if(existing_details[74] == null) existing_details[74] = "";
		if(existing_details[75] == null) existing_details[75] = "";
		if(existing_details[76] == null) existing_details[76] = "";	
		if(existing_details[77] == null) existing_details[77] = "";	
				
		menu_options = new StringTokenizer(existing_details[15],"|");
		if(menu_options.hasMoreTokens())
		{
			existing_details[15] = menu_options.nextToken();  //AMEND_ORDER  
			allow_cancel_yn= menu_options.nextToken();    // CANCEL_ORDER Added by Sridhar for MO-CRF-0033
			existing_details[16] = menu_options.nextToken();  //DISCONTINUE 
			existing_details[22] = menu_options.nextToken();  //HOLD       
			existing_details[23] = menu_options.nextToken();  //RESUME    
			existing_details[26] = menu_options.nextToken();  //RENEW        
			existing_details[17] = menu_options.nextToken();  //RESULT_HYPER_LINK   	
			existing_details[63] = menu_options.nextToken();  //LINK_TO_CURRENT_ENCOUNTER
			existing_details[68] = menu_options.nextToken();  //REPLACE FOR PACKAGE BILLING
			existing_details[65] = menu_options.nextToken();  //VIEW_REPLACED_ORDER
			existing_details[66] = menu_options.nextToken();  //VIEW_ORIGINAL_ORDER				
		}
		cont_order_ind			= existing_details[21];
		color_string			= existing_details[36];
		can_reason				= existing_details[37];
		can_pract_id			= existing_details[38];
		can_date_time			= existing_details[39];
		disc_pract_id			= existing_details[40];
		disc_date_time			= existing_details[41];
		last_action_reason_desc	= existing_details[44];	
		appt_date				= existing_details[45];
		appt_ref_num			= existing_details[46];
		order_catalog_nature	= existing_details[47];
		sec_order_yn			= existing_details[48];
		pri_order_id			= existing_details[49];
		appt_locn				= existing_details[50];
		appt_resched_yn			= existing_details[51];
		appt_resched_reason		= existing_details[52];
 		no_of_reschedules		= existing_details[53];
		appt_reqd_yn			= existing_details[54];
		notify_yn				= existing_details[55];
		display_appt_yn			= existing_details[15];  //cancel_yn
		last_action_type		= existing_details[56];
		accession_num			= existing_details[57];
		ext_appl_accession_num	= existing_details[64];
		billing_package_ref			= existing_details[67];
		
		if(existing_details[64] == null || existing_details.equals("")) existing_details[64] = "";
		if(existing_details[78] != null)
			total_query_records		= existing_details[78];
		
		if(k==0) 
		{ 
			if((Integer.parseInt(total_query_records)>0) || (start>1))
			{
				
            _bw.write(_wl_block17Bytes, _wl_block17);
            {java.lang.String __page ="ResultScrollingSingleContinuous.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("chk")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("existing_order_dtl")},{ weblogic.utils.StringUtils.valueOf("order_category"), weblogic.utils.StringUtils.valueOf(order_category
                        )},{ weblogic.utils.StringUtils.valueOf("called_from"), weblogic.utils.StringUtils.valueOf(called_from
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block25Bytes, _wl_block25);

			}
			else
			{
				
            _bw.write(_wl_block26Bytes, _wl_block26);
			
			}
		}  
		existing_details[69] = com.ehis.util.DateUtils.convertDate(existing_details[69],"DMY","en",localeName); //--[IN033160]
		if(!existing_details[69].equals(old_order_date)) 
		{
			
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(existing_details[69]));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(existing_details[69]));
            _bw.write(_wl_block29Bytes, _wl_block29);

		}
		
            _bw.write(_wl_block30Bytes, _wl_block30);

			if(existing_details[76].equals("S"))
			{
				
            _bw.write(_wl_block31Bytes, _wl_block31);
if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} 
            _bw.write(_wl_block32Bytes, _wl_block32);
if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(existing_details[70]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[27]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[13]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[19]));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[20]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[30]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[18]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[8]));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block61Bytes, _wl_block61);

				if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
					accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
				else
					accession_num_tooltip = "";	
			
				if(existing_details[72].equals("CURR_MED_YELLOW"))
				{
					strOrderCtl.append("<td width='' id='orderctl"+i+"' bgcolor='#FFFFCC' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridData1' ");
				}
				else if(existing_details[72].equals("CURR_MED_PINK"))
				{
					strOrderCtl.append("<td width=''  id='orderctl"+i+"' bgcolor='PINK' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridData2' ");
				}
				else
				{
					strOrderCtl.append("<td width='' id='orderctl"+i+"' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridDataBlue'");
				}
				if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) 
				{ // only care set (order set) orders
				
					if(existing_details[72].equals("CURR_MED_PINK"))
					{
						originaltdcolor = "PINK";
					}
					else if(existing_details[72].equals("CURR_MED_YELLOW"))
					{
						originaltdcolor = "#FFFFCC";
					}
					else
					{
						originaltdcolor = "#FFFFFF";
					}
					strOrderCtl.append("onClick=\"showCareSetResults('"+existing_details[9]+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,,'"+originaltdcolor+"')\">");
				}
				else 
				{ // For other categories normal one
					if(((existing_details[0].equalsIgnoreCase("PH"))&&((existing_details[4].equalsIgnoreCase("MS"))||(existing_details[25].equalsIgnoreCase("6"))))||(!(existing_details[67].equalsIgnoreCase(""))))
					{
					
						if(existing_details[72].equals("CURR_MED_PINK"))
						{
							originaltdcolor = "PINK";
						}
						else if(existing_details[72].equals("CURR_MED_YELLOW"))
						{
							originaltdcolor = "#FFFFCC";
						}
						else
						{
							originaltdcolor = "#FFFFFF";
						}
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
						strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
					}
					else
					{

						if(existing_details[72].equals("CURR_MED_PINK"))
						{
							originaltdcolor = "PINK";
						}
						else if(existing_details[72].equals("CURR_MED_YELLOW"))
						{
							originaltdcolor = "#FFFFCC";
						}
						else
						{
							originaltdcolor = "#FFFFFF";
						}
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\"  onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
						strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\"  onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
					}
				}
				if(existing_details[3].indexOf("$$RD##")!=-1)
				{
					String[] str = (String[])existing_details[3].split("!~!");
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
					existing_details[3] = order_detail;
					if(existing_details[3].lastIndexOf(",") ==((existing_details[3].length())-2))
					{
						existing_details[3] = existing_details[3] .substring(0,((existing_details[3].length())-2));
					}
				}
				if(existing_details[3].indexOf("!~!")!=-1)
				{
					existing_details[3] = existing_details[3].replace("!~!",",");
				}
				
				strOrderCtl.append(existing_details[3]);
				if(notify_yn!=null && notify_yn.equals("Y")) 
				{
					strOrderCtl.append("<img height='15' width='15' src=\"../images/Alert.gif\">");
				} 

				if(!(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")))
				{
					strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"' id='imgArrow"+i+"'></td>");
				}

				out.println(strOrderCtl.toString());
				
            _bw.write(_wl_block62Bytes, _wl_block62);
if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} 
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(((colorString[3].equals("X"))?slClassValue:colorString[3])));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(existing_details[62]));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_locn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_resched_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_resched_reason));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(no_of_reschedules));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(existing_details[9]));
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(existing_details[9]));
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(order_set_expln_txt));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(existing_details[79]));
            _bw.write(_wl_block87Bytes, _wl_block87);
			
				if(existing_details[17].trim().equals("Y"))
				{
					if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) 
					{ // only care set (order set) orders 
						
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[3]));
            _bw.write(_wl_block91Bytes, _wl_block91);

					}  
					else 
					{  
						if(last_action_type!=null && last_action_type.equals("NT")) 
						{
							
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block94Bytes, _wl_block94);

						} 
						else 
						{ 
							
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block94Bytes, _wl_block94);

						}
					} 
					
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(existing_details[6]));
            _bw.write(_wl_block97Bytes, _wl_block97);

					if(existing_details[60].equalsIgnoreCase("Y"))
					{
						
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(k));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(k));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[59]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(k));
            _bw.write(_wl_block101Bytes, _wl_block101);

					}
				}
				else
				{  
					if((!appt_ref_num.equals("")) && (!appt_date.equals("")) && (existing_details[14].equals("AB")) ) 
					{
						if( (existing_details[0].equals("RD") && rd_install.equals("Y")) || (existing_details[0].equals("OT") && ot_install.equals("Y")) ) 
						{ 
							
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
		
						}
						else 
						{
							
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);

							if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && !appt_ref_num.equals("") && !existing_details[0].equals("OT")  && display_appt_yn.equals("Y")) 
							{ 
								if(!existing_details[62].equals(facility_id))
								{
									String bookappt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RescheduleFromPerformingFacility.label","or_labels");
									appt_disabled = "disabled title='"+bookappt+"'";
								}
								else
								{
									appt_disabled = "";
								}
								
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(appt_disabled));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);

							} 
						} 
					} 
					if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && appt_ref_num.equals("")  && display_appt_yn.equals("Y")) //&& existing_details[10].equals("R")) Modified by Uma on 8/26/2009 for IN013477
					{ 
						if(!(existing_details[0].equals("RD") && rd_install.equals("Y")) && !(existing_details[0].equals("OT") && ot_install.equals("Y") )&& existing_details[14].equals("OS"))
						{
							if(!existing_details[62].equals(facility_id))
							{
								String bookappt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.AppointmentFromPerformingFacility.label","or_labels");
								appt_disabled = "disabled title='"+bookappt+"'";
							}
							else
							{
								appt_disabled = "";
							}
							
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(appt_disabled));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
		
						}
					}	
					out.println(existing_details[6]);
					out.println("</a>");
					if(existing_details[60].equalsIgnoreCase("Y"))
					{
						
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(k));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(k));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[59]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(k));
            _bw.write(_wl_block113Bytes, _wl_block113);

					}
				}
	 
				if (((existing_details[14].trim()).equals("CN") || (existing_details[14].trim().equals("DC")) || (existing_details[14].trim().equals("RD")) || (existing_details[14].trim().equals("RJ")) || (existing_details[14].trim().equals("HD")) ) || (appt_resched_reason!=null && !appt_resched_reason.equals("")) || ((existing_details[24] != null) && (!(existing_details[24]).equals("")))) 
				{
					can_reason = (existing_details[24]).replace('\"','\n');
					if((can_reason==null || can_reason.equals("")) && (existing_details[14].trim()).equals("HD"))
						can_reason = existing_details[35]; // LAST_ACTION_REASON_DESC
					// If appointment reason (transfer) is there, put the reason
					if(appt_resched_reason!=null && !appt_resched_reason.equals(""))
						can_reason		= appt_resched_reason;
					if(can_reason!=null || !can_reason.equals("")) 
						can_reason = can_reason.replace('\"','\n');
					if((existing_details[14].trim()).equals("DC")) 
					{
						can_date_time 		= 	existing_details[33]; //disc_date_time
						can_pract_id 		= 	existing_details[34]; //disc_pract_id
					} 
					else if (!appt_resched_reason.equals("")) 
					{
						can_date_time 		= 	"";
						can_pract_id 		= 	"";
					}
					else 
					{ // For cancel
						can_date_time 		= 	existing_details[31];
						can_pract_id 		= 	existing_details[32];
					}
					if(existing_details[14].equals("HC") || existing_details[14].equals("HD"))
						str_value = "Hold";
					else if(appt_resched_reason!=null && !appt_resched_reason.equals(""))
						str_value = "Appointment Re-schedule Reason";
					else if(existing_details[14].trim().equals("DC"))
						str_value = "Discontinue";
					else if(existing_details[14].trim().equals("RD"))
						str_value = "Replaced";
					else if(existing_details[14].trim().equals("RG"))
						str_value = "Registered";
					else if(existing_details[14].trim().equals("CN"))
						str_value = "Cancel Reason";
					else
						str_value = existing_details[6];		
					
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(can_reason));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(can_date_time));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(can_pract_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block125Bytes, _wl_block125);
	
				}
				
            _bw.write(_wl_block126Bytes, _wl_block126);
if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} 
            _bw.write(_wl_block127Bytes, _wl_block127);
if((existing_details[71].equalsIgnoreCase("ACTIVE")) && (existing_details[0].equalsIgnoreCase("PH"))){out.println("<img src='../../eOR/images/pharmacy_active.png'>");}else if((existing_details[71].equalsIgnoreCase("NON_ACTIVE")) && (existing_details[0].equalsIgnoreCase("PH"))){out.println("<img src='../../eOR/images/pharmacy_inactive.png'>");}else{out.println("&nbsp");}
            _bw.write(_wl_block128Bytes, _wl_block128);

			}
			else
			{
				
            _bw.write(_wl_block129Bytes, _wl_block129);
if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} 
            _bw.write(_wl_block32Bytes, _wl_block32);
if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(existing_details[70]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[27]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[13]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[19]));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[20]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[30]));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[18]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[8]));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block61Bytes, _wl_block61);

				if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
					accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
				else
					accession_num_tooltip = "";					
				if(existing_details[72].equals("CURR_MED_YELLOW"))
				{
					strOrderCtl.append("<td width='' bgcolor='#FFFFCC' id='orderctl"+i+"' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridData1'");
				}
				else if(existing_details[72].equals("CURR_MED_PINK"))
				{
					strOrderCtl.append("<td  width='' bgcolor='PINK' id='orderctl"+i+"' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridData2'");
				}
				else
				{
					strOrderCtl.append("<td width='' id='orderctl"+i+"' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridDataBlue'");
				}	
				if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) 
				{ // only care set (order set) orders
					if(existing_details[72].equals("CURR_MED_PINK"))
					{
						originaltdcolor = "PINK";
					}
					else if(existing_details[72].equals("CURR_MED_YELLOW"))
					{
						originaltdcolor = "#FFFFCC";
					}
					else
					{
						originaltdcolor = "#FFFFFF";
					}
					strOrderCtl.append("onClick=\"showCareSetResults('"+existing_details[9]+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");
				}
				else 
				{ // For other categories normal one
					if(((existing_details[0].equalsIgnoreCase("PH"))&&((existing_details[4].equalsIgnoreCase("MS"))||(existing_details[25].equalsIgnoreCase("6"))))||(!(existing_details[67].equalsIgnoreCase(""))))
					{
						if(existing_details[72].equals("CURR_MED_PINK"))
						{
							originaltdcolor = "PINK";
						}
						else if(existing_details[72].equals("CURR_MED_YELLOW"))
						{
							originaltdcolor = "#FFFFCC";
						}
						else
						{
							originaltdcolor = "#FFFFFF";
						}
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
						strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
					}
					else
					{
						if(existing_details[72].equals("CURR_MED_PINK"))
						{
							originaltdcolor = "PINK";
						}
						else if(existing_details[72].equals("CURR_MED_YELLOW"))
						{
							originaltdcolor = "#FFFFCC";
						}
						else
						{
							originaltdcolor = "#FFFFFF";
						}
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
						strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+originaltdcolor+"')\" onMouseOut=\"callMouseOut(this,'"+originaltdcolor+"')\">");//IN64543
					}
				}
				if(existing_details[3].indexOf("$$RD##")!=-1)
				{
					String[] str = (String[])existing_details[3].split("!~!");
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
					existing_details[3] = order_detail;
					if(existing_details[3].lastIndexOf(",") ==((existing_details[3].length())-2))
					{
						existing_details[3] = existing_details[3] .substring(0,((existing_details[3].length())-2));
					}
				}
				if(existing_details[3].indexOf("!~!")!=-1)
				{
					existing_details[3] = existing_details[3].replace("!~!",",");
				}
					
				strOrderCtl.append(existing_details[3]);
				if(notify_yn!=null && notify_yn.equals("Y")) 
				{
					strOrderCtl.append("<img height='15' width='15' src=\"../images/Alert.gif\">");
				} 

				if(!(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")))
				{
					strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"' id='imgArrow"+i+"'></td>");
				}

				out.println(strOrderCtl.toString());
				
            _bw.write(_wl_block62Bytes, _wl_block62);
if(existing_details[72].equals("CURR_MED_YELLOW")){ out.println("bgcolor='#FFFFCC'");}else if(existing_details[72].equals("CURR_MED_PINK")){ out.println("bgcolor='PINK'");} 
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(((colorString[3].equals("X"))?slClassValue:colorString[3])));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(existing_details[62]));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_locn));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_resched_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(appt_resched_reason));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(no_of_reschedules));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(existing_details[9]));
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(existing_details[9]));
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(order_set_expln_txt));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(existing_details[79]));
            _bw.write(_wl_block87Bytes, _wl_block87);
			
				if(existing_details[17].trim().equals("Y"))
				{
					if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) 
					{ // only care set (order set) orders 
						
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[3]));
            _bw.write(_wl_block91Bytes, _wl_block91);

					}  
					else 
					{ 
						if(last_action_type!=null && last_action_type.equals("NT")) 
						{ 
						
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block94Bytes, _wl_block94);

						} 
						else 
						{
							
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block94Bytes, _wl_block94);

						}
						
					} 
					
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(existing_details[6]));
            _bw.write(_wl_block130Bytes, _wl_block130);
 
					if(existing_details[60].equalsIgnoreCase("Y"))
					{
						
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(k));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(k));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[59]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(k));
            _bw.write(_wl_block101Bytes, _wl_block101);

					}
				}
				else
				{  
					if((!appt_ref_num.equals("")) && (!appt_date.equals("")) && (existing_details[14].equals("AB")) ) 
					{
						if( (existing_details[0].equals("RD") && rd_install.equals("Y")) || (existing_details[0].equals("OT") && ot_install.equals("Y")) ) 
						{ 
						
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block131Bytes, _wl_block131);
		
						}
						else 
						{
							
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);

							if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && !appt_ref_num.equals("") && !existing_details[0].equals("OT")  && display_appt_yn.equals("Y")) 
							{ 
								if(!existing_details[62].equals(facility_id))
								{
									String bookappt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RescheduleFromPerformingFacility.label","or_labels");
									appt_disabled = "disabled title='"+bookappt+"'";
								}
								else
								{
									appt_disabled = "";
								}
								
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(appt_disabled));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);

							} 
						} 
					} 
					if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && appt_ref_num.equals("")  && display_appt_yn.equals("Y")) //&& existing_details[10].equals("R")) Modified by Uma on 8/26/2009 for IN013477
					{ 
						if(!(existing_details[0].equals("RD") && rd_install.equals("Y")) && !(existing_details[0].equals("OT") && ot_install.equals("Y") )&& existing_details[14].equals("OS"))
						{
							if(!existing_details[62].equals(facility_id))
							{
								String bookappt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.AppointmentFromPerformingFacility.label","or_labels");
								appt_disabled = "disabled title='"+bookappt+"'";
							}
							else
							{
								appt_disabled = "";
							}
							
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(appt_disabled));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
		
						}
					}	
					out.println(existing_details[6]);
					out.println("</a>");
					if(existing_details[60].equalsIgnoreCase("Y"))
					{
						
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(k));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(k));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[59]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(k));
            _bw.write(_wl_block113Bytes, _wl_block113);

					}
				}
	 
				if (((existing_details[14].trim()).equals("CN") || (existing_details[14].trim().equals("DC")) || (existing_details[14].trim().equals("RD")) || (existing_details[14].trim().equals("RJ")) || (existing_details[14].trim().equals("HD")) ) || (appt_resched_reason!=null && !appt_resched_reason.equals("")) || ((existing_details[24] != null) && (!(existing_details[24]).equals("")))) 
				{
					can_reason = (existing_details[24]).replace('\"','\n');
					if((can_reason==null || can_reason.equals("")) && (existing_details[14].trim()).equals("HD"))
						can_reason = existing_details[35]; // LAST_ACTION_REASON_DESC
					// If appointment reason (transfer) is there, put the reason
					if(appt_resched_reason!=null && !appt_resched_reason.equals(""))
						can_reason		= appt_resched_reason;
					if(can_reason!=null || !can_reason.equals("")) 
						can_reason = can_reason.replace('\"','\n');
					if((existing_details[14].trim()).equals("DC")) 
					{
						can_date_time 		= 	existing_details[33]; //disc_date_time
						can_pract_id 		= 	existing_details[34]; //disc_pract_id
					} 
					else if (!appt_resched_reason.equals("")) 
					{
						can_date_time 		= 	"";
						can_pract_id 		= 	"";
					}
					else 
					{ // For cancel
						can_date_time 		= 	existing_details[31];
						can_pract_id 		= 	existing_details[32];
					}
					if(existing_details[14].equals("HC") || existing_details[14].equals("HD"))
						str_value = "Hold";
					else if(appt_resched_reason!=null && !appt_resched_reason.equals(""))
						str_value = "Appointment Re-schedule Reason";
					else if(existing_details[14].trim().equals("DC"))
						str_value = "Discontinue";
					else if(existing_details[14].trim().equals("RD"))
						str_value = "Replaced";
					else if(existing_details[14].trim().equals("RG"))
						str_value = "Registered";
					else if(existing_details[14].trim().equals("CN"))
						str_value = "Cancel Reason";
					else
						str_value = existing_details[6];		
				
					
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(can_reason));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(can_date_time));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(can_pract_id));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block125Bytes, _wl_block125);
	
				}
				
            _bw.write(_wl_block132Bytes, _wl_block132);
if(existing_details[72].equals("CURR_MED_YELLOW")){ 
            _bw.write(_wl_block133Bytes, _wl_block133);
}else if(existing_details[72].equals("CURR_MED_PINK")){ 
            _bw.write(_wl_block134Bytes, _wl_block134);
} 
            _bw.write(_wl_block135Bytes, _wl_block135);
if((existing_details[71].equalsIgnoreCase("ACTIVE")) && (existing_details[0].equalsIgnoreCase("PH"))){out.println("<img src='../../eOR/images/pharmacy_active.png'>");}else if((existing_details[71].equalsIgnoreCase("NON_ACTIVE")) && (existing_details[0].equalsIgnoreCase("PH"))){out.println("<img src='../../eOR/images/pharmacy_inactive.png'>");}else{out.println("&nbsp;");}
            _bw.write(_wl_block136Bytes, _wl_block136);

			}
			i++;
			old_order_date = existing_details[69];
		}
		
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(src_type));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block144Bytes, _wl_block144);
//=bean.getFunctionId()
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(p_called_from_ca));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(age));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(encntr_id));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(order_status));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(catalog));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(view));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(date_from));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(date_to));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(cosign));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(curr_sys_date));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(elapsed_orders));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(sys_cancelled_orders));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(group_by));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(order_frequency));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(from));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(to));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(category_type));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block184Bytes, _wl_block184);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.SingleOrder.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ContinuousOrder.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderName.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.time.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderName.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
