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

public final class __ordersetexistingorderresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderSetExistingOrderResults.jsp", 1743590276517L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           \tcreated\n31/05/2013    IN040092\t\tKarthi L      When we Place \"Order Set\" Billing details are displayed.\n13/08/2014\t  IN049419\t\tRamesh G\t\tAn Audit Trail for Additional Information Amendment of Order\n07/06/2020\t  IN072524\tNijitha S     \t\t07/06/2020\t\tRamesh G\t\tML-MMOH-CRF-1229.2\n--------------------------------------------------------------------------------------------------------------------\n-->\n";
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

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script><!-- used for date valifdation-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ExistingOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ViewOrder.js\"></script> <!-- added to include the function for displaying the cancel reason -->\n \t<script language=\"JavaScript\" src=\"../js/ResultOrder.js\"></script> <!-- added to include the function for viewing the results onclicking the status hyperlink -->\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \t<Style> </Style>\n\t<script>\n\tfunction dummy(){\n\t}\n\n\tfunction hideToolTip(obj,imgObj,row)\t\n\t{\n\t\tdynamichide(obj, window.event,row);\n\t  /*document.getElementById(\"tooltiplayer\").style.visibility = \'hidden\'\n\t\t if (obj != null)\n\t\t  {\n\t\t\t\tobj.className = \'gridDataBlue\';\n\t\t\t\teval(\"document.all.\"+imgObj).src = \"../../eCommon/images/inactiveArrow.gif\";\n\t\t  }*/\t \n\t}\n\n\n\tfunction callMouseOver(obj)\t{\n\t\tcurrClass = obj.className ;\n\t\tobj.className = \'selectedcontextMenuItem\';\n\n\t}\n\n\tfunction callOnMouseOut(obj){\n\t\tobj.className = \'contextMenuItem\';\n\t}\n\n\n\tfunction resizeWindow(orderctlHDR)\n\t{\n\t    var orderctlHDR1 = orderctlHDR.id;\n\t\t\n\t\tvar element = document.getElementById(orderctlHDR1);\n\t\tvar wdth = element.offsetWidth;\n\t\tvar hght1 = element.offsetHeight;\n\n\t\t/*var wdth = eval(\"document.all.\"+orderctlHDR1).offsetWidth;\n\t\tvar hght1 = eval(\"document.all.\"+orderctlHDR1).offsetHeight;\t*/\t\n\t\t\n\t\tvar wdth1 = getPos(orderctlHDR).x +wdth;\n\t\tvar hght = getPos(orderctlHDR).y ;\t\n\n\t\tbodwidth  = document.body.offsetWidth\n\t\tbodheight = document.body.offsetHeight\n\t\n\t\tvar z = bodwidth- (event.x + wdth);\t\n\t\t\n\t\tvar x \t  = event.x;\n\t\tvar y \t  = event.y;\t\n\n\t\tx \t  = x + (document.getElementById(\"tooltiplayer\").offsetWidth);\n\t\ty \t  = hght + (document.getElementById(\"tooltiplayer\").offsetHeight);\t\n\n\t\tif(x<bodwidth){\n\t\t\tx= wdth1;\t\t\t\n\t\t}else{\t\t\t\n\t\t\tx = getPos(orderctlHDR).x;\n\t\t}\n\t\tif(y<bodheight){\t\t\t\n\t\t\ty = hght;\n\t\t\t\n\t\t}else\n\t\t{\n\t\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight*2) + hght1 ;\t\n\t\t}\n\t\n\t\tdocument.getElementById(\"tooltiplayer\").style.posLeft= x;\n\t\tdocument.getElementById(\"tooltiplayer\").style.posTop = y;\n\t\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'visible\'\n\t}\n\n\tfunction displayToolTip(val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn,orderctlHDR,imgObj) {\n\t\t  \t\n\t\t\tcallMouseOverOnTD(orderctlHDR,imgObj);\n\n\t\t\tbuildTable (val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn)\n\t\t\tresizeWindow(orderctlHDR)\n\n\t}\n\n\n\tfunction displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,orderctlHDR,imgObj) {\n\t\t\t\n\t\t\tcallMouseOverOnTD(orderctlHDR,imgObj);\n\n\t\t\tbuildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn);\n\t\t\tresizeWindow(orderctlHDR)\n\t}\n\n\n\tfunction buildTable(val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn) {\n\n        var rowval   = val.split (\",\");\n\t\tvar row      = (\"View,Cancels,Ammend,Discontinue,Hold,Resume,Renew,\");\n\t\trowval1      = row.split(\",\");\n\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n\t\tfor( var i=0; i<rowval.length; i++ ) {\n\t\t\tvar colval  = rowval[i]\n\n\t\t\tvar colval1 = rowval1[i];\n\t\t\tif (colval != \"\")\n\t\t\t{\n\t\t\t\n\t\t\t\ttab_dat     += \"<tr>\"\n\t\t\t\tif(colval1 == \"Ammend\" || colval1 == \"Renew\")\n\t\t\t\t{\n\t\t\t\t\tqueryString = document.existing_order_dtl.queryString.value;\n\n\t\t\t\t\tif (colval1 == \"Renew\" && (ord_cat != \'PH\')) \n\t\t\t\t\t{\n\t\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\'  id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callRenewFunctions(\'\"+orderId+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+colval1+\"\',\'\"+queryString+\"\')>\"+colval+\" </a></td>\"\n\t\t\t\t\t} else \n\t\t\t\t\t{\n\t\t\t\t\t\t//IN049419 Start.\n\t\t\t\t\t\t//tab_dat     += \"<td class = \'contextMenuItem\'  id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callAmmendFunctions(\'\"+orderId+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+colval1+\"\')>\"+colval+\" </a></td>\"\n\t\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\'  id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callAmmendFunctions(\'\"+orderId+\"\',\'\"+patient_id+\"\',\'\"+ord_cat+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+colval1+\"\')>\"+colval+\" </a></td>\"\n\t\t\t\t\t\t//IN049419 End.\n\t\t\t\t\t}\n\t\t\t\t}else\n\t\t\t\t{\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\'  id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a  class= \'contextMenuLink\' href=javascript:callMenuFunctions(\'\"+colval1+\"\',\'\"+patient_id+\"\',\'\"+ord_cat+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\',\'\',\'\"+encntr_id+\"\',\'\"+patient_class+\"\')>\"+colval+\" </a></td>\"\n\n\t\t\t\t\t//function callMenuFunctions(colval1,patient_id,ord_cat,colval,orderId,cont_order_ind,order_status,sex,ord_typ_code,catalog_code,encounter_id,pat_class){\n\t\t\t\t}\n\t\t\t\ttab_dat     += \"</tr> \"\n\t\t\t}\n\t\t}\n\t\t\ttab_dat     += \"</table> \"\n\t\tdocument.getElementById(\"t\").innerHTML = tab_dat\n\t}\n\n\tfunction buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn) {\n\n\t    var rowval   = val.split (\",\");\n\t\tvar row      = (\"View,Cancel,Amend,Preps,Comments,Instructions,,Discontinue,Hold,Resume,Renew\");\n\t\trowval1      = row.split(\",\");\n\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n\t\tfor( var i=0; i<rowval.length; i++ ) {\n\t\t\tvar colval  = rowval[i]\n\n\t\t\tvar colval1 = rowval1[i];\n\t\t\tif (colval != \"\")\n\t\t\t{\n\t\t\t\n\t\t\t\ttab_dat     += \"<tr>\";\n\t\t\t\tif (colval1 == \"Renew\" || colval1 == \"Amend\") {\n\n\t\t\t\t\tqueryString = document.existing_order_dtl.queryString.value;\n\n\t\t\t\t\tif (colval1 == \"Renew\" && (ord_cat != \'PH\')) {\n\t\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\'  id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\'   href=javascript:callRenewFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+escape(queryString)+\"\')>\"+colval+\" </a></td>\";\n\t\t\t\t\t} else {\n\t\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\'  id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callAmmendFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\')>\"+colval+\" </a></td>\";\n\t\t\t\t\t}\n\t\t\t\t} else {\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\'  id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\')>\"+colval+\" </a></td>\";\n\t\t\t\t}\n\t\t\t\ttab_dat     += \"</tr> \"\n\t\t\t}\n\t\t}\n\t\t\ttab_dat     += \"</table> \"\n\t\tdocument.getElementById(\"t\").innerHTML = tab_dat\n\t}\n\tasync function viewCanOrderFormatLineCmts(can_reason, line,order_line_num,orderId,view_by){\n\t\t\t\n\t\t\t//alert(\"order_line_num====\"+order_line_num);\n\t\t\t\n\t\t\tvar dialogHeight =\'14\' ;\n\t\t\tvar dialogWidth = \'29\' ;\n\t\t\tvar dialogTop\t= \'189\';\n\t\t\tvar dialogLeft = \'167\' ;\n\t\t\tvar title = \'\'\n\t\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\';dialogTop:\'+dialogTop+\';dialogLeft:\'+dialogLeft+\';dialogTitle:\'+title+\'; scroll=no; status=no\';\n              /*if(can_reason==\"Cancel Reason\")\n\t\t\t\tcan_reason=getLabel(\'eOR.CancelReason.label\',\'OR\');\n\t\t\t  else if(can_reason==\"Discontinue\")\n\t\t\t\tcan_reason=getLabel(\'eOR.Discontinue.label\',\'OR\');\n\t\t\telse if(can_reason==\"Comments\")\n\t\t\t\tcan_reason=getLabel(\'Common.Comments.label\',\'Common\');*/\n\n\n\t\t\tif(can_reason==\"Comments\")\n\t\t\t\tvar narration = eval(\"document.existing_order_dtl.Cmts\"+line+\".value\");\n\t\t\telse\n\t\t\t\tvar narration = eval(\"document.existing_order_dtl.Cancel\"+line+\".value\");\n\n\t\t\tvar arguments = \"\";\n\t\t\tvar finalString\t= \"can_reason=\"+encodeURIComponent(can_reason)+\"&order_line_num=\"+order_line_num+\"&orderId=\"+orderId+\"&view_by=\"+view_by;\n\t\t\tvar retVals = await window.showModalDialog(\"../../eOR/jsp/ViewLineComment.jsp?\"+finalString,arguments,features);\n\n}\n\t</script>\n\n\t<STYLE TYPE=\"text/css\">\n       \n        TD.ORTOOLTIPS\n\t {\n\t\tBACKGROUND-COLOR: ACTIVEBORDER;\n\t\tCOLOR :BLACK;\n\t\tFONT-SIZE: 9PT ;\n\t }\n\tTABLE.ORPOPUPMENUS\n\t {\n\t   BORDER:2";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="PX SOLID WHITE;\n\t   WIDTH:100%;\n\t   FONT-SIZE: SMALLER;\n\t   PADDING: 0;\n\t }\n\tTD.ORMENU\n\t  {\n\t\tBACKGROUND-COLOR: #C0C0C0 ;\n\t\tFONT-SIZE: 9PT ;\n\t\tBORDER-STYLE: DASHED;\n\t\tBORDER-LEFT-COLOR: #FFA500;\n\t\tBORDER-RIGHT-COLOR: #FFA500;\n\t\tBORDER-TOP-COLOR: #FFFACD;\n\t\tBORDER-BOTTOM-COLOR: #FFFACD;\n\t  }\n\n\t TD.ORMENULAYER\n\t  {\n\t \t  FONT-FAMILY: VERDANA ;\n\t \t  FONT-SIZE: 10PT ;\n\t \t  BACKGROUND-COLOR: #D8BFD8;\n\t \t  COLOR: WHITE;\n\t   }\n\n  \t</STYLE>\n</head>\n<body onscroll=\'moveFrame()\' onload=\'FocusFirstElement()\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"COMMON\"));\n\t\t\tif(parent.parent.ExistingOrderSearch){\n\t\t\t\tparent.parent.ExistingOrderHeader.location.href = \"../../eCommon/html/blank.html\"\n\t\t\t\tparent.parent.ExistingOrderResult.location.href = \"../../eCommon/html/blank.html\"\n\t\t\t}else if(parent.ExistingOrderSearch){\n\t\t\t\tparent.ExistingOrderHeader.location.href = \"../../eCommon/html/blank.html\"\n\t\t\t\tparent.ExistingOrderResult.location.href = \"../../eCommon/html/blank.html\"\n\t\t\t}\n\t\t\tparent.window.close();\n\t\t</script>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name=\'existing_order_dtl\' id=\'existing_order_dtl\' target=\'messageFrame\' >\n<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" align=\'center\' id=\"tableresult\" class=\"grid\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n\t\t\t<script>alert(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\");</script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\t\t\tvar msg=getMessage(\"BILLING_SERVICE_NOT_DEFINED\",\"OR\");\n\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\");\n\t\t\t\t\talert(msg);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<script>\n\t\t\t\t\t//parent.criteriaDetailFrame.document.getElementById(\"recordApply\").disabled=true;\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<tr><td class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></td><td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></td><td colspan=\"6\" class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"><table cellpadding=0 cellspacing=0 border=0 width=\'100%\' align=\'right\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="style=\'border-width:0;display:inline\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="style=\'border-width:0;display:none\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" class=\"grid\"> <!--  condition added for IN035929[IN040092] -->\n\t\t\t\t\n\t\t\t\t\t<tr ><td colspan=\"\" width=\'20%\' class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</B></font></td>\n\t\t\t\t\t\t<td colspan=\"\" width=\'20%\' class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</B></font></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'25%\' class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><B>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</B></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" width=\'25%\' class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'actual_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</span></font></td>\n\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" style=\'border-width: 0;text-align: right;\'><font class=\'label\' size=\"1\"><span id=\'payable_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</span></font></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'included_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</span></font></td>\n\t\t\t\t\t\t\t<td colspan=\"\" class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" style=\'border-width: 0;text-align: center;\'><font class=\'label\' size=\"1\"><span id=\'approved_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</span></font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t</tr>\n\t\t\t\t</table></td></tr>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n \t<tr>\n\n\t   <td ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" class=\"CAHIGHERLEVELCOLOR\"> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\n\t\t   </td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\n  \t\t\n\t</tr>\n\t<tr>\n\t\n\t<tr>\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'></td>\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'> ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<input type=\'hidden\' name=\'line_num";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' id=\'line_num";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t\t<input type=\'hidden\' name=\'catalog_code";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'catalog_code";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t\t<input type=\'hidden\' name=\'item_narration";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'item_narration";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\t<input type=\'hidden\' name=\'location_code";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'location_code";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<input type=\'hidden\' name=\'patient_class";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'patient_class";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t<input type=\'hidden\' name=\'cont_order_ind";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'cont_order_ind";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t<input type=\'hidden\' name=\'copy_yn";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'copy_yn";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t\t<input type=\'hidden\' name=\'source_type";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'source_type";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t<input type=\'hidden\' name=\'location_code";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n            <input type=\'hidden\' name=\'copy_yn";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n            <input type=\'hidden\' name=\'source_type";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t    <input type=\'hidden\' name=\'order_category";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' id=\'order_category";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t<input type=\'hidden\' name=\'ord_typ_code";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' id=\'ord_typ_code";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t<input type=\'hidden\' name=\'ord_typ_desc";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' id=\'ord_typ_desc";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t<input type=\'hidden\' name=\'ord_id";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' id=\'ord_id";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\n\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t\n\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\n<!-- \t\tsample for line level\t\t<a href=\'javascript: dummy()\' onClick=\"displayToolTip1(\'View,Cancel,Preps,Comments,Instructions,,Discontinue\',\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\',\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\',\'CN\',\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\')\"  onMouseOver=\'hideToolTip()\'> -->\n\t\t\n\t\t<!-- </td> -->\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="  </td>\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'> \n\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t<a class=\"gridLink\"  href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\',\'\',\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\')\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" </a>\n\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t<input type=\"hidden\" name=\"Cancel";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" id=\"Cancel";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t\t<input type=button name=\"cancel_comment";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" id=\"cancel_comment";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" value=\"?\" class=\"button\" onClick=\"viewCanOrderFormatLineCmts(\'Cancel Reason\',\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\')\">\n\n\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"Cancel";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\')\">\n\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t          <Input type=\'hidden\' name=\'Cancel";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' id=\'Cancel";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\n\t\t          <Input type=\"button\" name=\"cancel_comment";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\')\">\n\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t</td>\n\t</tr>\n\t<input type=hidden name=\'priority";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' id=\'priority";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n    ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t<input type=hidden name=\'ord_status";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' id=\'ord_status";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\n\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n<tr style=\'visibility:hidden\'>\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\n\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\n        <td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t<td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n  <td class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\n</tr>\n</table>\n<input type=\'hidden\' name=\'source_type\' id=\'source_type\' value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n<input type=hidden name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\n\n<input type=hidden name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n<input type=hidden name=\'pract_reln_id\' id=\'pract_reln_id\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n<input type=hidden name=\'location_type\' id=\'location_type\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n<input type=hidden name=\'location_code\' id=\'location_code\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n<input type=hidden name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n<input type=hidden name=\'p_called_from_ca\' id=\'p_called_from_ca\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n<input type=hidden name=\'sex\' id=\'sex\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n<input type=hidden name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n<input type=hidden name=\'dob\' id=\'dob\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n<input type=hidden name=\'visit_adm_date\' id=\'visit_adm_date\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n<input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\n<script>\n\t\t\tif(parent.parent.ExistingOrderHeader.document.getElementById(\"tableheader\")==null)\n\t\t\t{\n\t\t\t\tsetTimeout(\"alignHeading(\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\');\",300);\n\t\t\t}\n\t\t\telse \n\t\t\t\talignHeading(\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\');\n\t</script>\n</form>\n\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:12%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;

	String patient_id	= request.getParameter("patientId");
	String encounter_id	= request.getParameter("encntr_id");
	String bean_id 		= "@existingorderbean"+patient_id+encounter_id;

	String bean_name = "eOR.ExistingOrder";
	String bill_bean_id			 = "Or_billingQueryBean" ;
	String bill_bean_name		 = "eOR.OrderEntryBillingQueryBean";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String practitioner_type = (String)session.getValue("practitioner_type");

	
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String pract_reln_id = (String)request.getParameter("relationship_id");
	HashMap setBills_dtls			= null;
	HashMap bill_dtls				= null;
	String[] billing_details 		= null;
	ArrayList BillChargeInfo		= null;

	if(resp_id== null)resp_id = "";
	if(pract_reln_id== null) pract_reln_id= "";
	if(practitioner_id == null)practitioner_id = "";
	ArrayList allValues = new ArrayList();
	String[] OrderSetValues = new String[9];//IN072524
/* Mandatory checks end */

	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	OrderEntryBillingQueryBean bill_bean = (OrderEntryBillingQueryBean)getBeanObject(bill_bean_id,bill_bean_name, request ) ;
	bill_bean.setLanguageId(localeName);
	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	//bean.setMode( mode ) ;

// THESE ARE THE PARAMS FOR AMMEND FUNCTION

	String location_type			= bean.checkForNull(request.getParameter("location_type"),"");
	String location_code			= bean.checkForNull(request.getParameter("location_code"),"");
	String patient_class			= bean.checkForNull(request.getParameter("patient_class"),"");
	String p_called_from_ca			= bean.checkForNull(request.getParameter("p_called_from_ca"),"");
	String sex						= bean.checkForNull(request.getParameter("sex"),"");
	String age						= bean.checkForNull(request.getParameter("age"),"");
	String dob						= bean.checkForNull(request.getParameter("dob"),"");
	String visit_adm_date			= bean.checkForNull(request.getParameter("visit_adm_date"),"");

// THESE ARE THE PARAMS FOR AMMEND FUNCTION - END

	String patientId		= request.getParameter( "patientId" ) ;
	String encntr_id		= request.getParameter( "encntr_id" ) ;
	String order_status		= request.getParameter( "ord_status" ) ;
		order_status		= "Z"; // By default make the order_status as "Z", should bring the record for all status
	String order_by			= request.getParameter( "order_by" ) ;
	String catalog			= request.getParameter( "catalog" ) ;
	String view				= request.getParameter( "view" ) ;
	String priority			= request.getParameter( "priority" ) ;
	String date_from		= request.getParameter( "date_from" ) ;
	String date_to			= request.getParameter( "date_to" ) ;
	String order_category	= request.getParameter( "order_category" ) ;
	String order_type		= request.getParameter( "order_type" ) ;
	String view_by			= request.getParameter( "view_by" ) ;
 	String search_criteria	= request.getParameter( "search_criteria" ) ;
	String cosign			= request.getParameter( "cosign" ) ;
	String orderId			= request.getParameter( "orderId" ) ; // Will get orderId only if it is for OrderSet results
	String allow_cancel_yn	= "" ; // Will get orderId only if it is for OrderSet results

	String show_bill_info_yn = bean.getBillingInterfaceShowYn(facility_id); //added for IN035929[IN040092]	
	
	if(patientId != null )patientId = patientId.trim();			else patientId = "";
	if(encntr_id != null )encntr_id = encntr_id.trim();			else encntr_id = "";
	if(orderId != null )orderId = orderId.trim();			else orderId = "";
	

	if(view != null )view = view.trim();						else view = "";
	if(order_status != null )order_status = order_status.trim();else order_status = "";
	if(priority != null )priority = priority.trim();			else priority = "";
	if(date_from != null )date_from = date_from.trim();			else date_from = "";
	if(date_to != null )date_to = date_to.trim();				else date_to = "";
	if(order_category != null )order_category = order_category.trim();	else order_category = "";
	if(order_type != null )order_type = order_type.trim();		else order_type = "";
	if(cosign != null )cosign = cosign.trim();					else cosign = "";
	if(catalog != null )catalog = catalog.trim();				else catalog = "";
	if(search_criteria != null )search_criteria = search_criteria.trim();	else search_criteria = "";
	if(order_by != null )order_by = order_by.trim();			else order_by = "";
	if(view_by != null )view_by = view_by.trim();				else view_by = "";

	//allValues		= bean.getOrderSetSearchDetails(view,patientId,encntr_id,order_status,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, orderId,practitioner_type);
	allValues		= bean.getOrderSetSearchDetails(view,patientId,encntr_id,order_status,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, orderId,practitioner_type);
 
	if(allValues.size() == 0){

            _bw.write(_wl_block9Bytes, _wl_block9);
	}

            _bw.write(_wl_block10Bytes, _wl_block10);

	String slClassValue = "";
	String src_type = "";
	//String tmp_ord_cat = "";
	String fontValue = "";

	String cont_order_ind = "";
	//String printEnable   = null;

	String[] existing_details = null;
	String can_reason = null;
 	//String menu_security1 = (String)bean.getMenu("AMEND_ORDER",resp_id,pract_reln_id);
	//String menu_security2 = null;
	//String menu_security_hold = (String)bean.getMenu("HOLD",resp_id,pract_reln_id);
	//String menu_security_resume = (String)bean.getMenu("RESUME",resp_id,pract_reln_id);
	//String line_menu_security1 = (String)bean.getMenu("CANCEL_ORDER",resp_id,pract_reln_id);
	//String line_menu_security2 = (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);
	String order_grouping_category = null;
	String color_string="";
	StringTokenizer colorTokenizer=null;
	StringTokenizer menu_options=null;
//	Added by Sridhar Reddy on 11/11/2008 for Displaytooltip
	StringBuffer strOrderCtl = new StringBuffer();	
	String billing_interface_yn = "N";
	billing_interface_yn = bill_bean.getBillingInterfaceYn();
	//String bl_info_display = "";
	//String careset_cat_desc = "";
	String order_set_bill_yn = "N";
	OrderSetValues=bill_bean.getOrderSetDetails(bean.checkForNull(orderId,""));
	String order_line_num=bean.checkForNull(OrderSetValues[1],"");
	String dateString=bean.checkForNull(OrderSetValues[2],"");
	String bill_order_catalog_code=bean.checkForNull(OrderSetValues[3],"");
	String order_qty=bean.checkForNull(OrderSetValues[4],"");
	order_set_bill_yn=bean.checkForNull(OrderSetValues[5],"");
	String bill_order_category=bean.checkForNull(OrderSetValues[6],"");
	String fpp_yn=bean.checkForNull(OrderSetValues[9],"");//IN072524
	String fpp_category=bean.checkForNull(OrderSetValues[10],"");//IN072524
	//String bill_order_set_desc=bean.checkForNull(OrderSetValues[7],"");
	if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !bill_order_category.equals("BT"))
	{
		int numbering=0;
		//String displaytooltip="";
		//qty_value1 records[0]DP011G3 dateString28/02/2009 11:33 localeNameen bean.getPatientId()0000000310 bean.getEncounterId()10011862 bean.getPatientClass()IP bean.getPractitionerId()NAREN 
		//IN072524 Starts
		if("Y".equals(fpp_yn)){
			BillChargeInfo		= bill_bean.getBillChargeDetailsfpp(order_qty,bill_order_catalog_code,dateString,localeName, orderId,order_line_num,patient_id,encntr_id,patient_class,practitioner_id,fpp_yn,fpp_category) ;
		}
		else{
			BillChargeInfo		= bill_bean.getBillChargeDetails(order_qty,bill_order_catalog_code,dateString,localeName, orderId,order_line_num,patient_id,encntr_id,patient_class,practitioner_id) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
		}
		//IN072524 Ends
		if(BillChargeInfo==null) 
			BillChargeInfo= new ArrayList();
		billing_details = null;
		for( int m=0 ; m< BillChargeInfo.size() ; m++ ) 
		{
			billing_details 	= (String[])BillChargeInfo.get(m);
			setBills_dtls		= new HashMap();
			setBills_dtls.put("charged_yn"       , billing_details[1]);
			setBills_dtls.put("total_payable"    , billing_details[2]);
			setBills_dtls.put("patient_payable"  , billing_details[3]);
			setBills_dtls.put("quantity"         ,order_qty);
			setBills_dtls.put("incl_excl_action" , billing_details[4]);
			setBills_dtls.put("preapp_yn"        , billing_details[5]);
			setBills_dtls.put("patient_paid_amt" , billing_details[6]);
			setBills_dtls.put("bl_panel_str"     , billing_details[0]);
			setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
			setBills_dtls.put("serv_panel_code"  , billing_details[11]);
			setBills_dtls.put("p_episode_type"	 , billing_details[13]);
			setBills_dtls.put("p_episode_id"	 , billing_details[14]);
			setBills_dtls.put("p_visit_id"		 , billing_details[15]);
			setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
			setBills_dtls.put("rate"		 , "");
			setBills_dtls.put("excl_incl_ind_for_screen"		 , billing_details[4]);
			setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
				
			setBills_dtls.put("fpp_yn"		 , fpp_yn);//IN072524
			setBills_dtls.put("fpp_category"		 , fpp_category);//IN072524
			//servicepanel=bean.checkForNull(billing_details[10],"");
			//servicepanelcode=bean.checkForNull(billing_details[11],"");
			bill_bean.setOrderBillDtls(patientId+encntr_id+bill_order_catalog_code, setBills_dtls); 
			 if(!billing_details[9].equals(""))
			{
				numbering=1;
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(billing_details[9]));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
			}
			if(billing_details[10].equals("")||billing_details[11].equals(""))
			{
						numbering=1;
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
 
				}
			}
			if(numbering==1&& order_set_bill_yn.equalsIgnoreCase("Y"))
			{	
			
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
			bill_dtls = (HashMap)bill_bean.getOrderBillDtls(patient_id+encntr_id+bill_order_catalog_code);
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(show_bill_info_yn.equals("Y")) {
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

						if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
						{
						
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

						}
						
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block34Bytes, _wl_block34);

						if(bean.checkForNull((String)bill_dtls.get("serv_panel_ind"),"").equalsIgnoreCase("S"))
						{
						
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("E")?"No":(bean.checkForNull((String)bill_dtls.get("incl_excl_action"),"").equals("I")?"Yes":"")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bill_order_catalog_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("Y")?"Yes":(bean.checkForNull((String)bill_dtls.get("preapp_yn"),"").equals("N")?"No":"")));
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						
            _bw.write(_wl_block40Bytes, _wl_block40);

	}
	// end
	for(int i=0; i<allValues.size(); i++){
		//printEnable = "Y";
		if(strOrderCtl.length() > 0)
			strOrderCtl = strOrderCtl.delete(0,strOrderCtl.length());
		
		existing_details = (String[])allValues.get(i);

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
       /* if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";

		if(view_by.trim().equals("L")){

			menu_options			= new StringTokenizer(existing_details[15],"|");
							
			if(menu_options.hasMoreTokens()){
				existing_details[15] = menu_options.nextToken();  //AMEND        
				allow_cancel_yn = menu_options.nextToken();  //Cancel        
				existing_details[16] = menu_options.nextToken();  //DISCONTINUE         
				existing_details[22] = menu_options.nextToken();  //HOLD                
				existing_details[23] = menu_options.nextToken();  //RESUME              
				existing_details[26] = menu_options.nextToken();  //RENEW               
				existing_details[17] = menu_options.nextToken();  //RESULT_HYPER_LINK   
				//existing_details[29] = "Y";
			}

			if(existing_details[25] == null) existing_details[25] = "";
        	if(existing_details[26] == null) existing_details[26] = "N";
        	if(existing_details[27] == null) existing_details[27] = "";
        	if(existing_details[28] == null) existing_details[28] = "";
        	if(existing_details[29] == null) existing_details[29] = "";
        	if(existing_details[30] == null) existing_details[30] = "";
			cont_order_ind = existing_details[21];
		}else{
			menu_options			= new StringTokenizer(existing_details[12],"|");
							
			if(menu_options.hasMoreTokens()){
				existing_details[12] =	menu_options.nextToken();  //AMEND
				allow_cancel_yn =	menu_options.nextToken();  //AMEND
				existing_details[15] =	menu_options.nextToken();  //DISCONTINUE 
				existing_details[20] =	menu_options.nextToken();  //HOLD 
				existing_details[21] =	menu_options.nextToken();  //RESUME 
				existing_details[23] =	menu_options.nextToken();  //RENEW 
				existing_details[14] =	menu_options.nextToken();  //RESULT_HYPER_LINK 
			}

		}

            _bw.write(_wl_block41Bytes, _wl_block41);
 
	if(!existing_details[0].equals(order_grouping_category)) { 
            _bw.write(_wl_block42Bytes, _wl_block42);
if(view_by.trim().equals("L")){ out.println("colspan='9'"); } else{ out.println("colspan='6'"); } 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block44Bytes, _wl_block44);
 } 
            _bw.write(_wl_block45Bytes, _wl_block45);
if(view_by.trim().equals("L")){

        String [] colorString = {"X","X","X","X"};
{
            color_string = bean.getColorCodings(facility_id,existing_details[9],existing_details[12],existing_details[11]);
            colorTokenizer = new StringTokenizer(color_string,",");
            int index = 0;
            while(colorTokenizer.hasMoreTokens()) {
                String tempToken = colorTokenizer.nextToken();
                 if (tempToken.equals("#7FFF00"))
                    colorString[index] = "QRY1";
                else if (tempToken.equals("#008000"))
                    colorString[index] = "QRY2";
                else if (tempToken.equals("#A52A2A"))
                    colorString[index] = "QRY3";
                else if (tempToken.equals("#FF0000"))
                    colorString[index] = "QRY4";
                else if (tempToken.equals("#0000CD"))
                    colorString[index] = "QRY5";
                else if (tempToken.equals("#808000"))
                    colorString[index] = "QRY6";
                else if (tempToken.equals("#CD5C5C"))
                    colorString[index] = "QRY7";
				else if (tempToken.equals("#D8BFD8"))
                    colorString[index] = "QRY8";
				else if (tempToken.equals("#DDA0DD"))  //OLD #F5DEB3  
                    colorString[index] = "QRY9";
				else if (tempToken.equals("#F4A460"))
                    colorString[index] = "QRY10";
				else if (tempToken.equals("LIGHTYELLOW"))
                    colorString[index] = "LIGHTYELLOW";
				else if (tempToken.equals("BROWN"))
                    colorString[index] = "BROWN";
			    else if (tempToken.equals("X"))
					colorString[index] = slClassValue; 

                index++;
            }
        }

    
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(((colorString[0].equals("X"))?slClassValue:colorString[0])));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(((colorString[2].equals("X"))?slClassValue:colorString[2])));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(existing_details[27]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(existing_details[28]));
            _bw.write(_wl_block50Bytes, _wl_block50);
} else {
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(existing_details[7]));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block52Bytes, _wl_block52);

			if(existing_details[10].trim().equalsIgnoreCase("U")){
				fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
				existing_details[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");

			}else if(existing_details[10].trim().equalsIgnoreCase("S")){
				fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
               existing_details[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");

			}else{
				fontValue = "<font size=1 color=black><b>";
				existing_details[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			}

		
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(fontValue));
            out.print( String.valueOf(existing_details[2]));
            _bw.write(_wl_block54Bytes, _wl_block54);
if(view_by.trim().equals("L")){
			
			
			
			
			
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[13]));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[19]));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[20]));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[30]));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[18]));
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
			cont_order_ind = existing_details[19];
		
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[17]));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[18]));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[24]));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[16]));
            _bw.write(_wl_block76Bytes, _wl_block76);



		  }
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[8]));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block85Bytes, _wl_block85);
				  
		  if((view_by.trim()).equals("H")) {
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(existing_details[8]));
            _bw.write(_wl_block87Bytes, _wl_block87);
	
			strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
			
			//menu_security = "";
			//menu_security1 = "";
			if (existing_details[22]==null)existing_details[22] = "";
			if (existing_details[23].equals("")) existing_details[23] = "N";
			
			//if(existing_details[12].trim().equals("Y"))
			//{
				//menu_security = (String)bean.getMenu("CANCEL_ORDER",resp_id,pract_reln_id);
				//menu_security1 = (String)bean.getMenu("AMEND_ORDER",resp_id,pract_reln_id);

					//if(line_menu_security1.trim().equals("A") && menu_security1.trim().equals("A") )
					//{				
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+','+getLabel('Common.cancel.label','Common')+','+getLabel('Common.Amend.label','COMMON')+',,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"   onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//} else if(line_menu_security1.trim().equals("A") && menu_security1.trim().equals("") )
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+','+getLabel('Common.cancel.label','Common')+',,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//} else if(line_menu_security1.trim().equals("") && menu_security1.trim().equals("A") )
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,'+getLabel('Common.Amend.label','COMMON')+','+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else 
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else if(existing_details[15].trim().equals("Y") && existing_details[20].trim().equals("Y"))
			//{				
				 //menu_security2 = (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);
				 //menu_security_hold = (String)bean.getMenu("HOLD",resp_id,pract_reln_id);
					//if(line_menu_security2.trim().equals("A") &&menu_security_hold.trim().equals("A"))
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,'+getLabel('Common.Discontinue.label','COMMON')+','+getLabel('Common.Hold.label','COMMON')+',,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else if((line_menu_security2.trim().equals("X") || line_menu_security2.trim().equals("")) &&menu_security_hold.trim().equals("A"))
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,'+getLabel('Common.Hold.label','COMMON')+',,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else if(line_menu_security2.trim().equals("A") &&(menu_security_hold.trim().equals("X") || menu_security_hold.trim().equals("")))
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else if(existing_details[15].trim().equals("Y")) {
 					//menu_security2 = (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);
					//if(line_menu_security2.trim().equals("A"))
					//{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else if (existing_details[20].trim().equals("Y")) 
			//{
				 //menu_security_hold = (String)bean.getMenu("HOLD",resp_id,pract_reln_id);
					//if(menu_security_hold.trim().equals("A"))
					//{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,'+getLabel('Common.Hold.label','COMMON')+',,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else if(existing_details[21].trim().equals("Y") )
			//{ // Resume Check
				 //menu_security_resume = (String)bean.getMenu("RESUME",resp_id,pract_reln_id);
					//if(menu_security_resume.trim().equals("A") )
					//{
						//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,'+getLabel('eOR.Resume.label','OR')+',"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else
					//{
					//	strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else
			//{
					//strOrderCtl.append(" onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,,,,"+((existing_details[23].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
			//}
			strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[12].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[20].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[21].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+",','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");

 
 	}else if((view_by.trim()).equals("L")) {
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(existing_details[8]));
            _bw.write(_wl_block50Bytes, _wl_block50);
	
			strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");	
			

			//line_menu_security1 = "";
			//line_menu_security2 = "";
			//menu_security_hold  = "";

			//if(existing_details[15].trim().equals("Y") )
			//{ //cancel check
				
				//line_menu_security1 = (String)bean.getMenu("CANCEL_ORDER",resp_id,pract_reln_id);
				
				//if(line_menu_security1.trim().equals("A"))
				//{					
					//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+','+getLabel('Common.cancel.label','Common')+','+getLabel('Common.Amend.label','COMMON')+','+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");  					

				//}else
				//{						   
					//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
	
				//}
			//}else if( existing_details[16].trim().equals("Y") && existing_details[22].trim().equals("Y"))
			//{//discontinue check & hold
				
				//- Temporrily Hold in the line level is commented and will be incorporated by uncommenting the required lines when it requires
				//line_menu_security2 = (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);
				//menu_security_hold = (String)bean.getMenu("HOLD",resp_id,pract_reln_id);

					//if(line_menu_security2.trim().equals("A") && menu_security_hold.trim().equals("A"))
					//{	
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");		
		
					//}else if((line_menu_security2.trim().equals("X")|| line_menu_security2.trim().equals("")) && menu_security_hold.trim().equals("A"))
					//{
	
				 		//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");

					//}else if(line_menu_security2.trim().equals("A") && (menu_security_hold.trim().equals("X") || menu_security_hold.trim().equals("")))
					//{	
				 		//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else
					//{	
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}
			//else if( existing_details[16].trim().equals("Y"))
			//{//discontinue check
				
				//- Temporrily Hold in the line level is commented and will be incorporated by uncommenting the required lines when it requires
				//line_menu_security2 = (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);

					//if(line_menu_security2.trim().equals("A"))
					//{	
						 //strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,'+getLabel('Common.Discontinue.label','COMMON')+',,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}
			//}else if( existing_details[22].trim().equals("Y"))
			//{//hold check
				
				//- Temporrily Hold in the line level is commented and will be incorporated by uncommenting the required lines when it requires
				//menu_security_hold = (String)bean.getMenu("HOLD",resp_id,pract_reln_id);

					//if(menu_security_hold.trim().equals("A"))
					//{
						// strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,'+getLabel('Common.Hold.label','COMMON')+',,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
					//}else
					//{
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");	
					//}
			//}else if( existing_details[23].trim().equals("Y"))
			//{//Resume check
				 //menu_security_resume = (String)bean.getMenu("RESUME",resp_id,pract_reln_id);
					//if(menu_security_resume.trim().equals("A") )
					//{
		
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,'+getLabel('eOR.Resume.label','OR')+',"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
				//}
			//}else 
			//{	
					//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',,,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[26].trim().equals("Y"))? "+getLabel('eOR.Renew.label','OR')+" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
	
			//}
			strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
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
		strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"'></td>");

		out.println(strOrderCtl.toString());
	
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(existing_details[5]));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block94Bytes, _wl_block94);
	if(!(view_by.trim().equals("L"))){
				if(existing_details[14].trim().equals("Y")){
					//printEnable = "N";
		
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(existing_details[6]));
            _bw.write(_wl_block98Bytes, _wl_block98);
		}else{
					out.println(existing_details[6]);
				}
			}else if((view_by.trim().equals("L"))){
				if(existing_details[17].trim().equals("Y")){
					//printEnable = "N";
		
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(existing_details[6]));
            _bw.write(_wl_block98Bytes, _wl_block98);
		}else{
					out.println(existing_details[6]);
				}
			}
			can_reason = "";
			if(!(view_by.trim().equals("L"))){
				if(((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ")) || ((existing_details[11] != null) && (!(existing_details[11]).equals("")))){
				can_reason = (existing_details[11]).replace('\"','\n');
		
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(can_reason));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[13]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block105Bytes, _wl_block105);
		} else if ((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ")) {
					//can_reason = (existing_details[9]).replace('\"','\n');
		
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(bean.getHeaderLineCancelReason(existing_details[9])));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[13]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block107Bytes, _wl_block107);
}
			} else {
			                          if (((existing_details[14].trim()).equals("CN") || (existing_details[14].trim().equals("DC")) || (existing_details[14].trim().equals("RD")) || (existing_details[14].trim().equals("RJ"))) || ((existing_details[24] != null) && (!(existing_details[24]).equals("")))) {
                   	can_reason = (existing_details[24]).replace('\"','\n');
		
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(can_reason));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block111Bytes, _wl_block111);
}
        }
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(existing_details[10]));
            _bw.write(_wl_block115Bytes, _wl_block115);
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf((!(view_by.trim().equals("L")))?existing_details[13]:existing_details[14]));
            _bw.write(_wl_block118Bytes, _wl_block118);
	src_type = existing_details[16];
	order_grouping_category = existing_details[0];
	}

            _bw.write(_wl_block119Bytes, _wl_block119);
if (view_by.equals("L"))
{
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
} else {
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
if (view_by.equals("L")) 
{
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
} else {
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
}
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(src_type));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(allValues.size()));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block133Bytes, _wl_block133);
//=bean.getFunctionId()
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(p_called_from_ca));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(age));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(order_set_bill_yn));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(order_set_bill_yn));
            _bw.write(_wl_block148Bytes, _wl_block148);

	//putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block149Bytes, _wl_block149);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ApprovalReqd.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderedAt.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
}
