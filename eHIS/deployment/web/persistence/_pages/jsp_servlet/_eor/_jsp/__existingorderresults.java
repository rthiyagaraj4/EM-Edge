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
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __existingorderresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ExistingOrderResults.jsp", 1742296190000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n \n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\n \t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script><!-- used for date validation-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/ExistingOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/ViewOrder.js\"></script> <!-- added to include the function for displaying the cancel reason -->\n \t<script language=\"JavaScript\" src=\"../../eOR/js/ResultOrder.js\"></script> <!-- added to include the function for viewing the results onclicking the status hyperlink -->\n \t<script language=\"JavaScript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \t\n \t<Style>\t\t\n    </Style>\n\t<script>\n\t//IN029948 Starts\n\tasync function showDetailsPH(patient_id,order_id,order_line_no,line_status_text)\n\t{\n\tvar dialogHeight= \"40vh\" ;\n\tvar dialogWidth\t= \"50vw\" ;\n\tvar dialogTop = \"240\" ;\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n\tvar retVal = await window.showModalDialog(\"../../ePH/jsp/QueryPatientDrugProfileLocations.jsp?patient_id=\"+patient_id+\"&order_id=\"+order_id+\"&order_line_no=\"+order_line_no+\"&line_status_text=\"+line_status_text,arguments,features);\n\t}\n\t//IN029948 Ends\n\tfunction dummy(){}\n\tfunction hideToolTip(obj,imgObj,row)\t\n\t{\n\t\tdynamichide(obj, window.event,row);\n\t  /*document.getElementById(\'tooltiplayer\').style.visibility = \'hidden\'\n\t   if (obj != null)\n\t  {\n\t\t\tobj.className = \'gridDataBlue\';\n\t\t\teval(\"document.all.\"+imgObj).src = \"../../eCommon/images/inactiveArrow.gif\";\n\t  }*/\t\n\t}\n\n\n\tfunction callMouseOver(obj)\t{\n\t\tcurrClass = obj.className ;\n\t\tobj.className = \'selectedcontextMenuItem\';\n\n\t}\n\n\tfunction callOnMouseOut(obj){\n\t\tobj.className = \'contextMenuItem\';\n\t}\n\n\n\t/*function resizeWindow(orderctlHDR)\n\t{\n\t\t\n\t    var orderctlHDR1 = orderctlHDR.id;\n\t\tvar wdth = document.getElementById(\'orderctlHDR1\').offsetWidth;\n\t\tvar hght1 = document.getElementById(\'orderctlHDR1\').offsetHeight;\t\t\n\t\t\n\t\tvar wdth1 = getPos(orderctlHDR).x +wdth;\n\t\tvar hght = getPos(orderctlHDR).y ;\t\n\n\t\tbodwidth  = document.body.offsetWidth\n\t\tbodheight = document.body.offsetHeight\n\t\t\n\t\tvar z = bodwidth- (event.x + wdth);\t\n\t\t\n\t\tvar x \t  = event.x;\n\t\tvar y \t  = event.y;\t\n\t\t\n\t\tx \t  = x + (document.getElementById(\'tooltiplayer\').offsetWidth);\n\t\ty \t  = hght + (document.getElementById(\'tooltiplayer\').offsetHeight);\t\n\t\t\n\t\tif(x<bodwidth){\n\t\t\tx= wdth1;\n\t\t\t\n\t\t}else{\t\t\t\n\t\t\tx = getPos(orderctlHDR).x;\n\t\t\t\n\t\t}\n\t\tif(y<bodheight){\t\t\t\n\t\t\ty = hght;\n\t\t\t\n\t\t}else\n\t\t{\n\t\t\ty = y - (document.getElementById(\'tooltiplayer\').offsetHeight*2) + hght1 ;\t\n\t\t}\n\t\n\t\tdocument.getElementById(\'tooltiplayer\').style.posLeft= x;\n\t\tdocument.getElementById(\'tooltiplayer\').style.posTop = y;\n\t\tdocument.getElementById(\'tooltiplayer\').style.visibility=\'visible\'\n\t}\n\n\tfunction displayToolTip(val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn,ord_typ_code,catalog_code,episode_id,episode_visit_num,orderctlHDR,imgObj,existing_order_called_from_new){//Added existing_order_called_from_new for IN074110\n\t\t\n\n\t\tcallMouseOverOnTD(orderctlHDR,imgObj);\n\n\t\tbuildTable (val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn,ord_typ_code,catalog_code,episode_id,episode_visit_num,existing_order_called_from_new)//Added existing_order_called_from_new for IN074110\n\t\t\tresizeWindow(orderctlHDR);\n\n\t}\n\n\n\t//function displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,orderctlHDR,imgObj)//IN64543\n\t//function displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,orderctlHDR,imgObj,instrn_type)//IN64543\n\tfunction displayToolTip1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,orderctlHDR,imgObj,instrn_type,view_by,existing_order_called_from_new)//IN061961//Added existing_order_called_from_new for IN074110\n\t{\n\t\t\t//buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,iv_prep_yn)\n\t\t  \n\t\t\tcallMouseOverOnTD(orderctlHDR,imgObj);\n\t\t\t\n\t\t\t//buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num);//IN64543\n\t\t\t//buildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,instrn_type);//IN64543\n\t\t\tbuildTable1 (val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,instrn_type,view_by,existing_order_called_from_new);//IN061961//Added existing_order_called_from_new for IN074110\n\t\t\tresizeWindow(orderctlHDR);\n\t}\n\n\n\tfunction buildTable(val,ord_cat,val1,orderId,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,sex,age,dob,visit_adm_date,cont_order_ind,order_status,iv_prep_yn,ord_typ_code,catalog_code,episode_id,episode_visit_num,existing_order_called_from_new) {//Added existing_order_called_from_new for IN074110\n\n\t\t\n\t\t\n        var rowval   = val.split (\",\");\n\t\tvar row      = (\"View,Cancels,Ammend,Discontinue,Hold,Resume,LinkToCurrentEncounter,ViewReplacedOrder,ViewOriginalOrder,Renew\");\n\t\trowval1      = row.split(\",\");\n\t\t//var tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'80%\' height=\'100%\' align=\'center\'>\"\n\t\tvar tab_dat = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\' style=\'background-color: lightgrey; border: 1px solid black; \'>\";\n    \n\t\tfor( var i=0; i<rowval.length; i++ ) {\n\t\t\t//alert(rowval.length);\n\t\t\t//alert(i);\n\t\t\t//alert(rowval[i]);\n\t\t\tvar colval  = rowval[i];\n\n\t\t\tvar colval1 = rowval1[i];\n\n\t\t\tif (colval != \"\" )\n\t\t\t{\n\t\t\t\ttab_dat     += \"<tr>\"\n\t\t\t\tif(colval1 == \"Ammend\" || colval1 == \"Renew\"){\n\t\t\t\t\t//alert(document.existing_order_dtl.queryString.value);\n\t\t\t\t\t\n\t\t\t\t\tqueryString = document.existing_order_dtl.queryString.value;\n\n\t\t\t\t\tif (colval1 == \"Renew\" && (ord_cat != \'PH\')) {\n\t\t\t\t\t\t\n\t\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callRenewFunctions(\'\"+orderId+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+colval1+\"\',\'\"+queryString+\"\')>\"+colval+\" </a></td>\"\n\t\t\t\t\t} else {\n\n\t\t\t\t\t\t//IN049419 Start.\n\t\t\t\t\t\t//tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callAmmendFunctions(\'\"+orderId+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+colval1+\"\')>\"+colval+\" </a></td>\"\n\t\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callAmmendFunctions(\'\"+orderId+\"\',\'\"+patient_id+\"\',\'\"+ord_cat+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+colval1+\"\')>\"+colval+\" </a></td>\"\n\t\t\t\t\t\t//IN049419 End.\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions(\'\"+colval1+\"\',\'\"+patient_id+\"\',\'\"+ord_cat+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+ord_typ_code+\"\',\'\"+catalog_code+\"\',\'\"+encntr_id+\"\',\'\"+patient_class+\"\',\'\"+location_code+\"\',\'\"+location_type+\"\',\'\"+episode_id+\"\',\'\"+episode_visit_num+\"\',\'\"+existing_order_called_from_new+\"\')>\"+colval+\" </a></td>\"//Added existing_order_called_from_new for IN074110\n\t\t\t\t}\n\t\t\t\ttab_dat     += \"</tr> \"\n\t\t\t}\n\t\t}\n\t\t\ttab_dat     += \"</table> \"\n\t\tdocument.getElementById(\'t\').innerHTML = tab_dat;\n\t}\n\n\t//function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,cont_order_ind,order_status,sex,iv_prep_yn) {\n\t//function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num) {//IN64543\n\t\t//function buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,instrn_type) {//IN64543\n\t\tfunction buildTable1(val,ord_cat,val1,orderId,cancel_type,order_line_num,catalog_code,item_narration,patient_id,encntr_id,pract_reln_id,location_type,location_code,patient_class,p_called_from_ca,cont_order_ind,order_status,sex,age,dob,visit_adm_date,iv_prep_yn,ord_typ_code,episode_id,episode_visit_num,instrn_type,view_by,existing_order_called_from_new) {//IN061961//Added existing_order_called_from_new for IN074110\n\t\t\n\t    var rowval   = val.split (\",\");\n\t\t//IN061903 start\n\t\t//var row      = (\"View,Cancel,Amend,Preps,Comments,Instructions,,Discontinue,Hold,Resume,LinkToCurrentEncounter,Replace,ViewReplacedOrder,ViewOriginalOrder,Renew\");//IN072654\n\t\tvar row      = (\"View,Cancel,Amend,Preps,Comments,Instructions,,Discontinue,Hold,Resume,LinkToCurrentEncounter,Replace,ViewReplacedOrder,ViewOriginalOrder,Renew,InteractionDtls\");//IN072654\n\t\t//var row      = (\"View,Cancel,Amend,Preps,Comments,Instructions,,Discontinue,Hold,Resume,LinkToCurrentEncounter,Replace,ViewReplacedOrder,ViewOriginalOrder,Renew,NotDone\");\n\t\t//IN061903 ends\t\n\t\trowval1      = row.split(\",\");\n\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n\t\t\n\t\tfor( var i=0; i<rowval.length; i++ ) \n\t\t{\n\t\t\t\n\t\t\tvar colval  = rowval[i];\n\t\t\tvar colval1 = rowval1[i];\n\t\t\tif (colval != \"\" )\n\t\t\t{\n\t\t\t\ttab_dat     += \"<tr>\";\n\t\t\t\n\t\t\t\tif (colval1 == \"Renew\" || colval1 == \"Amend\") \n\t\t\t\t{\t\t\t\t\n\t\t\t\t\tqueryString = document.existing_order_dtl.queryString.value;\n\t\t\t\t\tif (colval1 == \"Renew\" && (ord_cat != \'PH\')) \n\t\t\t\t\t{\n\t\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=\\\"javascript:callRenewFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+escape(queryString)+\"\')\\\">\"+colval+\" </a></td>\";\n\t\t\t\t\t} \n\t\t\t\t\telse \n\t\t\t\t\t{\n\t\t\t\t\t\tvar cnsnt_with_order_yn = document.existing_order_dtl.queryString.value;\n\t\t\t\t\t\t   tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=\\\"javascript:callAmmendFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+cnsnt_with_order_yn+\"\')\\\">\"+colval+\"</a></td>\";\n\t\t\t\t\t\t\n\t\t\t\t\t\t//alert(\"tab_dat\"+tab_dat);\n\t\t\t\t\t\t// tab_dat     += \"<td class = \'ORMENULAYER\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=\\\"javascript:callAmmendFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\',\'\"+order_Set_id+\"\')\\\"><B>\"+colval+\" </B></a></td>\";\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t//var order_status=\"\"; //Commented IN042100\n\t\t\t\t\t//tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+ord_typ_code+\"\',\'\"+encntr_id+\"\',\'\"+patient_class+\"\',\'\"+location_code+\"\',\'\"+location_type+\"\',\'\"+episode_id+\"\',\'\"+episode_visit_num+\"\',\'\"+iv_prep_yn+\"\')>\"+colval+\" </a></td>\"; //Included iv_prep_yn --[IN033061]//IN64543\n\t\t\t\t\t//tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+ord_typ_code+\"\',\'\"+encntr_id+\"\',\'\"+patient_class+\"\',\'\"+location_code+\"\',\'\"+location_type+\"\',\'\"+episode_id+\"\',\'\"+episode_visit_num+\"\',\'\"+iv_prep_yn+\"\',\'\"+instrn_type+\"\')>\"+colval+\" </a></td>\"; //Included iv_prep_yn --[IN033061]//IN64543\n\t\t\t\t\t//tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+ord_typ_code+\"\',\'\"+encntr_id+\"\',\'\"+patient_class+\"\',\'\"+location_code+\"\',\'\"+location_type+\"\',\'\"+episode_id+\"\',\'\"+episode_visit_num+\"\',\'\"+iv_prep_yn+\"\',\'\"+instrn_type+\"\',\'\"+view_by+\"\')>\"+colval+\" </a></td>\"; //IN061961 Commented for IN071315\n\t\t\t\t\t//tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+ord_typ_code+\"\',\'\"+encntr_id+\"\',\'\"+patient_class+\"\',\'\"+location_code+\"\',\'\"+location_type+\"\',\'\"+episode_id+\"\',\'\"+episode_visit_num+\"\',\'\"+iv_prep_yn+\"\',\'\"+instrn_type+\"\',\'\"+view_by+\"\',\'\"+p_called_from_ca+\"\')>\"+colval+\" </a></td>\"; //Added for IN071315\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions1(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+ord_cat+\"\',\'\"+orderId+\"\',\'\"+cancel_type+\"\',\'\"+order_line_num+\"\',\'\"+catalog_code+\"\',\'\"+item_narration+\"\',\'\"+patient_id+\"\',\'\"+cont_order_ind+\"\',\'\"+order_status+\"\',\'\"+sex+\"\',\'\"+ord_typ_code+\"\',\'\"+encntr_id+\"\',\'\"+patient_class+\"\',\'\"+location_code+\"\',\'\"+location_type+\"\',\'\"+episode_id+\"\',\'\"+episode_visit_num+\"\',\'\"+iv_prep_yn+\"\',\'\"+instrn_type+\"\',\'\"+view_by+\"\',\'\"+p_called_from_ca+\"\',\'\"+existing_order_called_from_new+\"\')>\"+colval+\" </a></td>\"; //Added for IN071315//Added existing_order_called_from_new for IN074110\n\t\t\t\t}\n\t\t\t\ttab_dat     += \"</tr> \"\n\t\t\t}\n\t\t}\n\t\t\ttab_dat     += \"</table> \"\n\t\t\t//alert(tab_dat);\n\t\tdocument.getElementById(\'t\').innerHTML = tab_dat;\n\t}\n\tfunction viewCanOrderFormatLineCmts1(line,order_line_num,orderId,view_by){\n\t\t\tvar dialogHeight =\'18\' ;\n\t\t\tvar dialogWidth = \'29\' ;\n\t\t\tvar dialogTop\t= \'189\';\n\t\t\tvar dialogLeft = \'167\' ;\n\t\t\tvar title = \'\';\n\t\t\tvar cancel_date_time = \"\";\n\t\t\tvar cancel_pract_id  = \"\";\n\t\t\tvar order_status = eval(\"document.existing_order_dtl.order_status\"+line+\".value\");\n\t\t\t/*if(can_reason==\"Cancel Reason\")\n\t\t\t\tcan_reason=getLabel(\'eOR.CancelReason.label\',\'OR\');\n\t\t\telse if(can_reason==\"Discontinue\")\n\t\t\t\tcan_reason=getLabel(\'eOR.Discontinue.label\',\'OR\');\n\t\t\telse if(can_reason==\"Comments\")\n\t\t\t\tcan_reason=getLabel(\'Common.Comments.label\',\'Common\');*/\n\t\t\tvar can_reason = eval(\"document.existing_order_dtl.Can_Reason\"+line+\".value\");\n\t\t    var order_category = eval(\"document.existing_order_dtl.order_category\"+line+\".value\");\n\t\t\t\n\t\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\';dialogTop:\'+dialogTop+\';dialogLeft:\'+dialogLeft+\';dialogTitle:\'+title+\'; scroll=no; status=no\';\n \t\t\tif(can_reason==\"Comments\")\n\t\t\t\tvar narration = eval(\"document.existing_order_dtl.Cmts\"+line+\".value\");\n\t\t\telse{\n \t\t\t\tvar narration = eval(\"document.existing_order_dtl.Cancel\"+line+\".value\");\n\t\t\t\tcancel_date_time =  eval(\"document.existing_order_dtl.Cancel_date_time\"+line+\".value\"); \n\t\t\t\tcancel_pract_id =  eval(\"document.existing_order_dtl.Cancel_pract_id\"+line+\".value\"); \n\t\t\t}\t\n \t\t\tvar arguments = \"\";\n\t\t\t\n\t\t\t//var finalString\t= \"can_reason=\"+encodeURIComponent(can_reason)+\"&cancel_date_time=\"+cancel_date_time+\"&cancel_pract_id=\"+cancel_pract_id+\"&order_line_num=\"+order_line_num+\"&orderId=\"+orderId+\"&view_by=\"+view_by;IN033472\n\t\t\tvar Appt_can_remarks\t\t= eval(\"parent.ExistingOrderResult.document.existing_order_dtl.Appt_can_remarks\"+line+\".value\");//IN033472\n\t\t\tvar Appt_can_reason\t\t= eval(\"parent.ExistingOrderResult.document.existing_order_dtl.Appt_can_reason\"+line+\".value\");//ML-MMOH-CRF-1617.1\n\t\t\tif (Appt_can_remarks !== \"\" || Appt_can_reason !== \"\") {\n\t\t\t    can_reason = \"Appointment cancel Reason\";\n\t\t\t}\n\t\t\t\n\t\t\tvar finalString\t= \"can_reason=\"+encodeURIComponent(can_reason)+\"&cancel_date_time=\"+cancel_date_time+\"&cancel_pract_id=\"+cancel_pract_id+\"&order_line_num=\"+order_line_num+\"&orderId=\"+orderId+\"&view_by=\"+view_by+\"&order_category=\"+order_category+\"&order_status=\"+order_status;//IN033472//ML-MMOH-CRF-1617.1\n\t\t\t//var finalString\t= \"can_reason=\"+encodeURIComponent(can_reason)+\"&cancel_date_time=\"+cancel_date_time+\"&cancel_pract_id=\"+cancel_pract_id+\"&order_line_num=\"+order_line_num+\"&orderId=\"+orderId+\"&view_by=\"+view_by+\"&appt_resched_reason=\"+appt_resched_reason;//IN033472\n\t\t\t\n\t\t\tvar retVals = window.showModalDialog(\"../../eOR/jsp/ViewLineComment.jsp?\"+finalString,arguments,features);\n\n}\n\t//ML-MMOH-CRF-1617.1 START\nfunction viewCanOrderFormatLineCmts(line,order_line_num,orderId,view_by){\n\t\t\n\tvar can_reason = eval(\"document.existing_order_dtl.Can_Reason\"+line+\".value\");\t\n\tvar order_status = eval(\"document.existing_order_dtl.order_status\"+line+\".value\");\n\tif(order_status==\"Appt Scheduled\"){\n\t\tvar dialogHeight =\'18\' ;\n\t}else{\n\t\tvar dialogHeight =\'14\' ;\n\t}\n\t\n\t\tvar dialogWidth = \'29\' ;\n\t\tvar dialogTop\t= \'189\';\n\t\tvar dialogLeft = \'167\' ;\n\t\tvar title = \'\';\n\t\tvar cancel_date_time = \"\";\n\t\tvar cancel_pract_id  = \"\";\n\n\t\t\t/*if(can_reason==\"Cancel Reason\")\n\t\t\t\tcan_reason=getLabel(\'eOR.CancelReason.label\',\'OR\');\n\t\t\telse if(can_reason==\"Discontinue\")\n\t\t\t\tcan_reason=getLabel(\'eOR.Discontinue.label\',\'OR\');\n\t\t\telse if(can_reason==\"Comments\")\n\t\t\t\tcan_reason=getLabel(\'Common.Comments.label\',\'Common\');*/\n\t\t\tvar can_reason = eval(\"document.existing_order_dtl.Can_Reason\"+line+\".value\");\n\t\t\t\n\t\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\';dialogTop:\'+dialogTop+\';dialogLeft:\'+dialogLeft+\';dialogTitle:\'+title+\'; scroll=no; status=no\';\n \t\t\tif(can_reason==\"Comments\")\n\t\t\t\tvar narration = eval(\"document.existing_order_dtl.Cmts\"+line+\".value\");\n\t\t\telse{\n \t\t\t\tvar narration = document.getElementById(\'Cancel\'+line).value;\n\t\t\t\tcancel_date_time =  document.getElementById(\'Cancel_date_time\'+line).value; \n\t\t\t\tcancel_pract_id =  document.getElementById(\'Cancel_pract_id\'+line).value; \n\t\t\t}\t\n \t\t\tvar arguments = \"\";\n\t\t\t\n\t\t\t//var finalString\t= \"can_reason=\"+encodeURIComponent(can_reason)+\"&cancel_date_time=\"+cancel_date_time+\"&cancel_pract_id=\"+cancel_pract_id+\"&order_line_num=\"+order_line_num+\"&orderId=\"+orderId+\"&view_by=\"+view_by;IN033472\n\t\t\tvar appt_resched_reason\t\t= parent.ExistingOrderResult.document.getElementById(\'appt_resched_reason\'+line).value;//IN033472\n\t\t\tvar finalString\t= \"can_reason=\"+encodeURIComponent(can_reason)+\"&cancel_date_time=\"+cancel_date_time+\"&cancel_pract_id=\"+cancel_pract_id+\"&order_line_num=\"+order_line_num+\"&orderId=\"+orderId+\"&view_by=\"+view_by+\"&appt_resched_reason=\"+appt_resched_reason;//IN033472\n\t\t\tvar retVals =await  top.window.showModalDialog(\"../../eOR/jsp/ViewLineComment.jsp?\"+finalString,arguments,features);\n\n}\nasync function showSlidingDetails(order_id, order_line_num, sliding_scale_yn){\n                var dialogHeight= \"13vh\" ;\n                var dialogWidth = \"35vh\" ;\n                var dialogTop = \"400\" ;\n                var center = \"1\" ;\n                var status=\"no\";\n                var features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" +             dialogTop;\n                var arguments = \"\" ;\n                var retVal =       await window.showModalDialog(\"../../ePH/jsp/QueryPatientDrugProfileRemarks.jsp?order_id=\"+order_id+\"&order_line_num=\"+order_line_num+\"&sliding_scale_yn=\"+sliding_scale_yn+\"&called_frm=SlidingScale\",arguments,features);\n}\n\n\n\t</script>\n\n\t<!-- <STYLE TYPE=\"text/css\">\n       \tA:link\n       \t {\n       \t     COLOR: blue;\n       \t }\n     \tA:visited\n     \t {\n             COLOR: blue ;\n         }\n        A:active\n         {\n             COLOR: red;\n         }\n     </STYLE> -->\n\t<!--IN065091 start-->\n\t<style>\n\tTD.QRY11 \n\t{\n\t\tBACKGROUND-COLOR: #05bbea;\n\t\tFONT-SIZE: 9PT ;\n\t\tBORDER-COLOR:\tBLACK;\n\t\tBORDER-LEFT-COLOR: #D5E2E5;\n\t\tBORDER-RIGHT-COLOR: #D5E2E5;\n\t\tBORDER-TOP-COLOR: #D5E2E5;\n\t\tBORDER-BOTTOM-COLOR: #D5E2E5;\n\t}\n\t</style>\n\t<!--IN065091 Ends-->\n</head>\n<body  onscroll=\'processScroll()\' onload=\'FocusFirstElement()\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\tif(parent.parent.ExistingOrderSearch){\n\t\t\t\tparent.parent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;\n\t\t\t\t//parent.parent.ExistingOrderHeader.location.href = \"../../eCommon/html/blank.html\"\n\t\t\t\tparent.parent.ExistingOrderResult.location.href = \"../../eCommon/html/blank.html\"\n\t\t\t}else if(parent.ExistingOrderSearch){\n\t\t\t\tparent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;\n\t\t\t\t//parent.ExistingOrderHeader.location.href = \"../../eCommon/html/blank.html\"\n\t\t\t\tparent.ExistingOrderResult.location.href = \"../../eCommon/html/blank.html\"\n\t\t\t}\n\n\t\t</script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\"existing_order_dtl\" id=\"existing_order_dtl\" action=\"../../eOR/jsp/ExistingOrderResults.jsp\" method=\"post\" >\n<div id=\"divHeadSep\" style=\"position: absolute;width:100%\">\n\t<table cellpadding=3 cellspacing=0 border=\'0\' width=\"100%\" height=\'\' id=\"tableresult\" class=\"grid\">\n\t\t<tr id=\"heading\" style=\"text-align:left;\">\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<th  class=\'columnheader\' width=\'\' nowrap></th>\n\t\t\t<th  class=\'columnheader\' width=\'\' nowrap></th>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<th  class=\'columnheader\' width=\'\' nowrap></th><!--IN065091-->\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<th class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t<th class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<th class=\'columnheader\' width=\'\' nowrap></th>\n\t\t\t<th  class=\'columnheader\' width=\'\' nowrap></th>\n\t\t\t\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n        <th class=\'columnheader\' width=\'\' nowrap >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n        ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\n\t\t<!-- Arvind -->\n\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<!--<td class=\'columnheader\' width=\'\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td> --><!--IN038336-->\n\t\t\t<th class=\'columnheader\' width=\'\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th><!--IN038336 -->\n\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<!--IN063816 start-->\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<th class=\'columnheader\' width=\'\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<!--IN063816 ends-->\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\n\t\t<th class=\'columnheader\' width=\'50\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\n\t\t\t<th class=\'columnheader\' width=\'\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="<BR><input type=checkbox name=\'select_all\' id=\'select_all\' onClick=\'clickAll()\' disabled></th>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</tr>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<tr align=\"right\">\n\t<!--IN063816 start-->\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<!--<td colspan=\"13\">--><!--IN065942-->\n\t\t\t<td colspan=\"14\"><!--IN065942-->\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<!--<td colspan=\"12\">--><!--IN065942-->\n\t\t<td colspan=\"13\"><!--IN065942-->\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t<!--IN063816 ends-->\n\t\t<!--<td colspan=\"11\">--><!--IN065942-->\n\t\t<td colspan=\"12\"><!--IN065942-->\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" \n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="   \n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\t\t\t \n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="  \n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<tr>\n\n\t\t\t<td ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" class=\"CAHIGHERLEVELCOLOR\"> ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\n\t\t\t</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t   <!-- For Header and Line Level --> <!-- For Color -->\n\t   <td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'></td>\n\t  ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t   <td width=\'\' nowrap  class=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t   ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<a class=\'gridLink\' href=\'javascript: dummy()\' onClick=\"showSecondayOrders(\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\',\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\')\"><img src=\'../../eOR/images/SecondaryOrder.gif\' border=\'0\'  title=\'Secondary Orders Exists\'></img></a>\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t<a class=\'gridLink\' href=\'javascript: dummy()\' onClick=\"showCareSetResults(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\"  onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\",\"existing_order_dtl\")\' onMouseOut=\"hideToolTip()\">S</a>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t<td width=\'\' nowrap  class=\'QRY11\'></td><!--IN065091-->\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<td width=\'\' nowrap  class = \'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'></td><!--IN065091-->\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="<a class=\'gridLink\' href=\'javascript: dummy()\' onClick=\"showSecondayOrders(\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\')\"><img src=\'../../eOR/images/SecondaryOrder.gif\' border=\'0\'  title=\'Secondary Orders Exists\'></img></a>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t<a class=\'gridLink\' href=\'javascript: dummy()\' onClick=\"showCareSetResults(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\",\"existing_order_dtl\")\' onMouseOut=\"hideToolTip()\">S</a>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\n\t\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'> ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n  ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t<input type=\'hidden\' name=\'line_num";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'line_num";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t<input type=\'hidden\' name=\'start_date_time";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'start_date_time";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t<input type=\'hidden\' name=\'catalog_code";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' id=\'catalog_code";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t<input type=\'hidden\' name=\'item_narration";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' id=\'item_narration";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t<input type=\'hidden\' name=\'location_code";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' id=\'location_code";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t<input type=\'hidden\' name=\'patient_class";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' id=\'patient_class";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t<input type=\'hidden\' name=\'cont_order_ind";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' id=\'cont_order_ind";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t<input type=\'hidden\' name=\'copy_yn";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' id=\'copy_yn";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t<input type=\'hidden\' name=\'source_type";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' id=\'source_type";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t<input type=\'hidden\' name=\'lv_neonate_spec_yn";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' id=\'lv_neonate_spec_yn";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"><!-- 31792 -->\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t<input type=\'hidden\' name=\'catalog_code";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n            <input type=\'hidden\' name=\'copy_yn";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n            <input type=\'hidden\' name=\'source_type";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n            ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t<input type=\'hidden\' name=\'item_narration";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"><!-- IN068659 -->\n\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t    <input type=\'hidden\' name=\'order_category";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' id=\'order_category";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t<input type=\'hidden\' name=\'ord_typ_code";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'ord_typ_code";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t<input type=\'hidden\' name=\'ord_typ_desc";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' id=\'ord_typ_desc";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t<input type=\'hidden\' name=\'ord_id";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' id=\'ord_id";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t\n\t\n\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t <input type=\'hidden\' name=\'lv_neonate_spec_yn";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"><!-- 31792 -->\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</td>\n\t\t\t<!-- <td width=\'\' class=\'gridDataBlue\'>  -->\n\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\n\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\n\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t<!-- <td width=\'\' class=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>  --> \n\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\t \n\t\t\n<!-- \t\tsample for line level\t\t<a href=\'javascript: dummy()\' onClick=\"displayToolTip1(\'\'+getLabel(\'Common.view.label\',\'Common\')+\',Cancel,Preps,Comments,Instructions,,Discontinue\',\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\',\'CN\',\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\')\"  onMouseOver=\'hideToolTip()\'> -->\n\n\t\t</td>\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" </a> </td>\n\t\t<td width=\'\' nowrap  style=\'height:18px;\tfont-family: Verdana, Arial, Helvetica, sans-serif;\tfont-size: 8pt;\tfont-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-top:0px;border-left:0px;border-right:0px;border-style:solid;\' class=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'> \n\t\t\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t<input type=\"hidden\" name=\"Appt";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" id=\"Appt";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n\t\t<input type=\"hidden\" name=\"Appt_date";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" id=\"Appt_date";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t\t<input type=\"hidden\" name=\"performing_facility_id";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" id=\"performing_facility_id";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t\t<input type=\"hidden\" name=\"performing_facility_id_hdr";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" id=\"performing_facility_id_hdr";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\"><!-- IN054720 -->\n\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t<input type=\"hidden\" name=\"appt_locn";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" id=\"appt_locn";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t<input type=\"hidden\" name=\"appt_resched_yn";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" id=\"appt_resched_yn";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t<input type=\"hidden\" name=\"appt_resched_reason";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" id=\"appt_resched_reason";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t\t<input type=\"hidden\" name=\"no_of_reschedules";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" id=\"no_of_reschedules";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\n        <input type=\"hidden\" name=\"parent_order_id";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" id=\"parent_order_id";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" value=\"\">\n\t\t<input type=\"hidden\" name=\"parent_order_line_num";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" id=\"parent_order_line_num";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" value=\"\">\n\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" id=\"explanatory_text";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t<!--<input type =\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">-->\n \n\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t<img width=\'20\' height=\'20\' src=\'../../eCA/images/modifiedresult.png\' alt=\'Result Modified\'/>\n\t\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:showCareSetViewResults(\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\",\"\",\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\",\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\")\'>\n ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =" <!--call Notes view  -->\n\t\t\t\t\t\t\t<!-- <a href=\"javascript:showNotes(\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\')\"> -->\n\t\t\t\t\t\t\t<!--IN064215 start-->\n\t\t\t\t\t\t\t<!--<a class=\"gridLink\" href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\',\'\',\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\')\">-->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\')\">\n\t\t\t\t\t\t\t<!--IN064215 ends-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" <!-- Result View --> \n\t\t\t\t\t\t\t<!--IN064215 start-->\n\t\t\t\t\t\t\t<!--<a class=\"gridLink\" href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewApptData(escape(\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'))\"> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:viewOAApptData(escape(\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t\t\t<input class=\"BUTTON\" type=\"button\" name=\"ReSchedule";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" id=\"ReSchedule";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" value=\"R\" onClick=\"viewReSchedule(escape(\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'))\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\t\t\t\t\t\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\t<input class=\"BUTTON\" type=\"button\" name=\"Schedule";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" id=\"Schedule";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" value=\"S\" onClick=\"BookAppointment(escape(\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'))\">\n\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t<input class=\"button\" type=\"button\" name=\"existing_consent_id_lookup";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" id=\"existing_consent_id_lookup";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\"  title=\'Consent Details\' value=\"C\" onClick=\"callMultipleConsentHdr(\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\')\"><!-- title changed from consent required to Consent IN037398-->\n";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\t\n\t\t\t\t\t\t<!--<input class=\"button\" type=\"button\" name=\"rec_consent_with_order";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" id=\"rec_consent_with_order";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"  title=\'Consent Details\' value=\"RC\" onClick=\"callConsentRec(\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\')\">-->\n\t\t\t\t\t\t<input class=\"button\" type=\"button\" name=\"rec_consent_with_order";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\')\">\t\t\n";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t\t\t<a class=\'gridLink\' href=\'javascript: dummy()\' onClick=\"callNotifyDetailsHdr(\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\')\"><img src=\'../../eOR/images/Notification_Completed.png\' border=\'0\'  title=\'Notification Details\'></img></a> <!--IN069597 -->\n\t\t\t\t\t \t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t\t\t<img width=\'20\' height=\'20\' src=\'../../eCA/images/modifiedresult.png\' alt=\'Result Modified\'/>\n\t\t\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:showCareSetViewResults(\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\")\'>\n\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =" <!--call Notes view  -->\n\t\t\t\t\t\t\t\t<!-- <a href=\"javascript:showNotes(\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\')\"> -->\n\t\t\t\t\t\t\t\t<!--IN064215 start-->\n\t\t\t\t\t\t\t\t<!--<a class=\"gridLink\" href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\')\">-->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!-- <a class=\"gridLink\" href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\')\">-->\n\t\t\t\t\t\t\t\t<!--IN064215 ends-->\n\t\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\')\"><!--\tIN061961-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 =" <!-- Result View --> \n\t\t\t\t\t\t\t\t<!--IN064215 start-->\n\t\t\t\t\t\t\t\t<!--<a class=\"gridLink\" href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\')\"> -->\n\t\t\t\t\t\t\t\t<!--IN064215 ends-->\n\t\t\t\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:resultViewOrder(\'Result\',\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =" </a>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t\t\t\t\t<input class=\"button\" type=\"button\" name=\"existing_consent_id_lookup";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\"  title=\'Consent Details\' value=\"C\" onClick=\"callMultipleConsent(\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\')\">   <!-- title changed from consent required to Consent IN037398--> <!-- IN041421 -->\n\t ";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\'))\"> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t\t\t\t\t<input class=\"BUTTON\" ";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 =" type=\"button\" name=\"ReSchedule";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n\t\t\t\t\t\t\t\t\t<input class=\"BUTTON\" ";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 =" type=\"button\" name=\"Schedule";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t\t\t<a class=\"gridLink\" href=\"javascript:resultViewForRegisteredOrder(\'Result\',\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\')\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\n\t\t\t\t\t\t\t\t\t\t       \n\t\t\t        <Input type=\"button\" name=\"cancel_comment";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" value=\"?\" class=\"button\" onClick=\"viewCanOrderFormatLineCmts1(\'";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\')\">\n\t\t\t          <Input type=\'hidden\' name=\"Cancel";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n\t\t\t\t\t  <input type=\"hidden\" name=\"Cancel_date_time";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n\t\t\t\t\t  <input type=\"hidden\" name=\"Cancel_pract_id";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\n\t\t\t\t\t  <input type=\"hidden\" name=\"Can_Reason";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n\t\t\t\t\t  <input type=\"hidden\" name=\"Appt_can_remarks";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n\t\t\t\t\t  <input type=\"hidden\" name=\"Appt_can_reason";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t\t\t\t\t  <input type=\"hidden\" name=\"order_category";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n\t\t\t\t\t   <input type=\"hidden\" name=\"order_status";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n\t\t\t\t\t    \n\t\t\t\t\t";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\')\"> <!-- title changed from consent required to Consent IN037398--><!-- IN041421 -->\n\t ";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\t\t\n\t\t\t\t\t<!--<input class=\"button\" type=\"button\" name=\"rec_consent_with_order";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\')\">-->\n\t\t\t\t\t<input class=\"button\" type=\"button\" name=\"rec_consent_with_order";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\')\">\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n\t\t\t\t<input type=\"hidden\" name=\"Cancel";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\" id=\"Cancel";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"Cancel_date_time";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\" id=\"Cancel_date_time";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"Cancel_pract_id";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\" id=\"Cancel_pract_id";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\n\t\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\">\n\t\t\t<!--\t<input type=button name=\"cancel_comment";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\" id=\"cancel_comment";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\" value=\"?\" class=\"button\" onClick=\"viewCanOrderFormatLineCmts(\'Cancel Reason\',\'";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\')\">-->\n\t\t\t\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\n               ";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="  \n\t\t\t\t\t <Input type=\"button\" name=\"cancel_comment";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\" value=\"?\" class=\"button\" onClick=\"viewCanOrderFormatLineCmts(\'";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n\t\t\t          <input type=\"hidden\" name=\"Cancel_date_time";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"> \n\t\t\t\t\t  <input type=\"hidden\" name=\"order_status";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\t\t\t\t ";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n\t\t               \n\t\t\t\t         <Input type=\"button\" name=\"cancel_comment";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\')\">\n\t\t\t\t          <Input type=\'hidden\' name=\"Cancel";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n\t\t\t\t          <input type=\"hidden\" name=\"Cancel_date_time";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t\t\t\t\t\t  <input type=\"hidden\" name=\"Cancel_pract_id";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t\t\t\t\t\t  <input type=\"hidden\" name=\"Can_Reason";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n\t\t\t\t\t\t  <input type=\"hidden\" name=\"Appt_resched_remarks";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n\t\t\t\t\t\t  <input type=\"hidden\" name=\"order_category";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\">\n\t\t\t\t\t\t  <input type=\"hidden\" name=\"order_status";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\">\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\n               \n\t\t";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\n\t\t\t\t<img title=\'";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\' src=\"../../eCA/images/MarkError.gif\"/>\n\t\t\t";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n\t\t</td>\n\t\t<!-- Arvind -->\n\t\t";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n\t\t\t <!-- Commented as part of IN033172 fix <td class=\'";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\'>-->\n\t\t\t ";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\n\t\t\t <a class=\"gridLink\" href=\"javascript:viewMedication(\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\')\"><td class=\'";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\' style=\'BACKGROUND-COLOR:";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 =";width:20px;height:20px;\' onclick =\"viewMedication(\'";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\')\" title=\'";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\'>";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="</td></a><!--IN038336 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\n\t\t\t<!--Added as part of IN033172-->\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\'></td>\n\t\t\t<!-- Commented as part of IN033172 fix</td> -->\n\t\t\t";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n\t\t<!--end here-->\n\t\t<!--IN063816 start-->\n\t\t";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n\t\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\'><input type=checkbox name=\'chk_barcode";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\' id=\'chk_barcode";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\'  value=\"N\" onClick=\"clickLine_barcode(this,";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 =")\"></td>\n\t\t";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\'>&nbsp;<input type=checkbox name=\'chk_barcode";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 =")\" style=\'display:none\'></td>\n\t\t\t";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\t\t\n\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\'><input type=\'checkbox\' name=\'chk_prn_reg_label";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\' id=\'chk_prn_reg_label";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\' value=\"N\" onClick=\"chkPrnRegLabel(this,";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\'>&nbsp;</td>\t\n\t\t";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\n\t\t<input type=hidden name=\'order_line_num";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\' id=\'order_line_num";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\' value=\'";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\'><!--IN063816-->\n\t\t<input type=hidden name=\'order_catalog_code";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\' id=\'order_catalog_code";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\'><!--IN063816-->\n\t\t<!--IN063816 end-->\n\t\t<!-- 19112 Start.-->\n\t\t";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\t\t\n<td class=\'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\'> \n<img onclick=\"callCApage(\'../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=EXTERNAL_REQ_FORM&locale=";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="&patient_id=";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="&encounter_id=";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="&patient_class=";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="&order_id=";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="&ord_typ_code=";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="&facility_id=";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="&orderStatusCodeHdr=";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="&title=Record External Requisition Form\')\" id=\"CLINICAL_NOTES1\" alt=\"Record External Requisition Form\"  style=\'cursor:pointer\' src=\"../../eCA/images/external_requisition_form.png\">\n</td>\n";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\t\n<td class=\'";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\n<td class=\'";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\'>&nbsp;</td>\n\n";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 =" <!-- // end 68801 -->\n";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\'> <input type=checkbox name=\'chk";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\' id=\'chk";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\'  value=\"N\" onClick=\'clickLine(this)\' ";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="></td>\n\t\t";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\n\t</tr>\n\t<input type=hidden name=\'priority";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\' id=\'priority";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\'>\n    ";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\n\t<input type=hidden name=\'ord_status";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\' id=\'ord_status";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\'>\n\n\n";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\n</table>\n</div>\n<input type=\'hidden\' name=\'source_type\' id=\'source_type\' value=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\">\n\n<input type=hidden name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\'>\n<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\'>\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\">\n\n<input type=hidden name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\'>\n<input type=hidden name=\'pract_reln_id\' id=\'pract_reln_id\' value=\'";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\'>\n<input type=hidden name=\'location_type\' id=\'location_type\' value=\'";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\'>\n<input type=hidden name=\'location_code\' id=\'location_code\' value=\'";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\'>\n<input type=hidden name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\'>\n<input type=hidden name=\'function_from\' id=\'function_from\' value=\'";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\'>\n\n<input type=hidden name=\'p_called_from_ca\' id=\'p_called_from_ca\' value=\'";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\'>\n<input type=hidden name=\'sex\' id=\'sex\' value=\'";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\'>\n<input type=hidden name=\'age\' id=\'age\' value=\'";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\'>\n<input type=hidden name=\'dob\' id=\'dob\' value=\'";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\'>\n<input type=hidden name=\'visit_adm_date\' id=\'visit_adm_date\' value=\'";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\'>\n<!-- <input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\'> [IN036674] -->\n<input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\'>\n<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\'>\n<input type=\'hidden\' name=\'encntr_id\' id=\'encntr_id\' value=\'";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\'>\n<input type=\'hidden\' name=\'relationship_id\' id=\'relationship_id\' value=\'";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\'>\n<input type=\'hidden\' name=\'ord_status\' id=\'ord_status\' value=\'";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\'>\n<input type=\'hidden\' name=\'order_by\' id=\'order_by\' value=\'";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\'>\n<input type=\'hidden\' name=\'catalog\' id=\'catalog\' value=\'";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\'>\n<input type=\'hidden\' name=\'order_type\' id=\'order_type\' value=\'";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\'>\n<input type=\'hidden\' name=\'view\' id=\'view\' value=\'";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\'>\n<input type=\'hidden\' name=\'priority\' id=\'priority\' value=\'";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\'>\n<input type=\'hidden\' name=\'date_from\' id=\'date_from\' value=\'";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\'>\n<input type=\'hidden\' name=\'date_to\' id=\'date_to\' value=\'";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\'>\n<input type=\'hidden\' name=\'order_category\' id=\'order_category\' value=\'";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\'>\n<input type=\'hidden\' name=\'view_by\' id=\'view_by\' value=\'";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\'>\n<input type=\'hidden\' name=\'search_criteria\' id=\'search_criteria\' value=\'";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\'>\n<input type=\'hidden\' name=\'cosign\' id=\'cosign\' value=\'";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\'>\n<input type=\'hidden\' name=\'activity_type\' id=\'activity_type\' value=\'";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\'>\n<input type=\'hidden\' name=\'curr_sys_date\' id=\'curr_sys_date\' value=\'";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\'>\n<input type=\'hidden\' name=\'start_date_obj\' id=\'start_date_obj\' value=\'\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\'>\n<input type=\'hidden\' name=\'elapsed_orders\' id=\'elapsed_orders\' value=\'";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\'>\n<input type=\'hidden\' name=\'sys_cancelled_orders\' id=\'sys_cancelled_orders\' value=\'";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\'>\n\n\t\n<!-- For Next & previous -->\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\'>\n<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\'>\n<!-- IN030279 Start -->\n<input type=\"hidden\" name=\"deceased_yn\" id=\"deceased_yn\" value=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\">\n<input type=\"hidden\" name=\"medico_legal_yn\" id=\"medico_legal_yn\" value=\"";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\">\n<input type=\"hidden\" name=\"postmortem_status\" id=\"postmortem_status\" value=\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\">\n<input type=\"hidden\" name=\"body_part_yn\" id=\"body_part_yn\" value=\"";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\">\n<input type=\"hidden\" name=\"registration_no\" id=\"registration_no\" value=\"";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\"> \n<input type=\"hidden\" name=\"callingFrom\" id=\"callingFrom\" value=\"";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\">\n<input type=\"hidden\" name=\"recordConsentWithOrder\" id=\"recordConsentWithOrder\" value=\"";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\">  <!-- IN057196 -->\n<input type=\"hidden\" name=\"cnsnt_with_order_yn\" id=\"cnsnt_with_order_yn\" value=\"";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\">  <!-- IN057196 -->\n<!-- IN030279 End. -->\n<input type=hidden name=\'total_recs_barcode\' id=\'total_recs_barcode\' value=\'";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\'><!--IN063816-->\n<input type=hidden name=\'call_from_barcode_btn\' id=\'call_from_barcode_btn\' value=\'N\'><!--IN063816-->\n<input type=hidden name=\'pract_type\' id=\'pract_type\' value=\'";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\'><!--IN065942-->\n\n <!-- For Next & previous -->\n\n\t<script>\n\t\t\t//if(parent.parent.ExistingOrderHeader.document.getElementById(\"tableheader\")==null)\n\t\t\t//{\n\t\t\t\t//setTimeout(\"alignHeading(\'\');\",300);\n\t\t\t//}\n\t\t\t//else \n\t\t\t\t//alignHeading(\'\');\n\t</script>\n\n</form>\n\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\"position: absolute; width: 12%; visibility: visible; left: 451px; top: 40px; background-color: #808080; z-index: 1000;\"\">\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t<!-- </td> -->\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n</body>\n<script>\nvar function_from_ =document.forms[0].function_from.value;\nif(function_from_ != \"MO\"){  //IN030279\nif(parent.parent.ExistingOrderSearch)\n{\n\tparent.parent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;\n   // parent.parent.ExistingOrderHeader.document.existing_order_hdg.select_all.disabled = false;\n   if(document.getElementById(\"select_all\"))\n\t{\n\t   document.getElementById(\"select_all\").disabled = false;\n\t}\n}\nelse if(parent.ExistingOrderSearch.document.existing_order_search)\n{\n\tparent.ExistingOrderSearch.document.existing_order_search.search.disabled = false;\n\t//parent.ExistingOrderHeader.document.existing_order_hdg.select_all.disabled = false;\n\tif(document.getElementById(\"select_all\"))\n\t{\n\t   document.getElementById(\"select_all\").disabled = false;\n\t}\n}\n} //IN030279\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );
	
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

/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/* 
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
26/06/2012    IN033488      Chowminya G     Incident No: IN033488 -  Error Marking - Result completed indicator> 
23/07/2012    IN033472		Nijitha S		System does not display Appointment Reschedule Reason in Existing orders.
25/09/2012	  IN030279		Ramesh G		Bru-HIMS-CRF-160
19/10/2012    IN033061      Chowminya G     System doesnt display menu cancel/discontinue if the orders are IV Fluid ,IV Fluid+Drug, IV Fluid+Drug(Frequency). 
17/12/2012	  IN036674		Ramesh G		In Existing Orders there is no option to print the Order Sheet but there is option to select the order.
20/02/2012	  IN037398		Chowminya G		System displays as "Consent Required"
18/04/2013    IN038336      Chowminya G     In the Existing Order, there are yellow box that which not reflecting with any colour coding in the legend.
05/06/2013    IN029948		Nijitha  S      Bru-HIMS-CRF-082
06/06/2013    IN040198.1    Chowminya G     Reopen - Status of the Order Catalog is displayed wrongly
22/07/2013    IN041421      Chowminya G     special characters - record consent "Internal Server Error" is displayed
07/08/2013	  IN042100      Chowminya G		Ph Category  -  Hold Order Option line level with MAR status P
06/05/2014	  IN048935		Nijitha S		ML-BRU-SCF-1318	- In the existing order tab, once a drug has been discontinued, the order status changes to Discontinued However the MAR status in the existing order still remains as In Progress
20/05/2014	  IN049203		Chowminya		Existing order - Discontinue reason details not populated
13/08/2014	  IN049419		Ramesh G		An Audit Trail for Additional Information Amendment of Order	
03/06/2015	  IN054720		Vijayakumar K	ML-BRU-SCF-1580 [IN:054720]
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
09/10/2015	IN055910		Karthi L										From Clinician Access, modified result shall be identified by include ?!? in Blue color
21/10/2015	IN057196		Ramesh G		Recording Of Consent Form
21/10/2015	  IN058125		Karthi L												Modified icon is showing for Registration Status.	
08/03/2016	IN059490		Karthi L										After placing orders, in Existing order ? keeping the Status as active and click search takes more than 1 minute to display the ordered details.[AAKH-SCF-0252]							
10/05/2017	IN064215		Krishna Gowtham J	10/05/2017	Ramesh G		PMG2017-SH-CRF-0001							
12/05/2017	IN063781		Krishna Gowtham J	12/05/2017		Ramesh G		ML-MMOH-CRF-0804					
09/06/2017	IN063816		Krishna Gowtham J	09/06/2017		Ramesh G		GHL-CRF-0445.1
10/07/2017	IN061903		Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555
28/08/2017	IN065091		Krishna Gowtham J 	29/08/2017		Ramesh G		GHL-CRF-0440.1					
15/12/2017	IN065942		Dinesh T		15/12/2017		Ramesh G		In Nuclear medicine  department we required the 																				barcode functionality at the time of 																						Registration of order,required patient 																						Id,patient name,age,sex,register date and name 																				of study.
20/03/2018      IN066414		Sharanraj		13/04/2018		Ramesh G		ML-MMOH-CRF-1071
06/06/2018  	IN08078			Sharanraj		12/06/2018		Ramesh G		ML-MMOH-SCF-1011
23/07/2018	IN64543			Dinesh T		23/07/2018		Ramesh G		ML-MMOH-CRF-0776
18/07/2018   	IN061961		sivabagyam M    	18/07/2018		Ramesh G		GHL-CRF-0433
16/10/2018	IN066709		Prakash C		16/10/2018		Ramesh G 		ML-MMOH-CRF-1101
17/10/2018	IN067817		sivabagyam	 17/10/2018	        Ramesh G       ML-MMOH-CRF-1198	
05/11/2018	IN068986		Ramya Maddena		05/11/2018		Ramesh G		MO-CRF-20137.1
9/11/2018	IN068994		sivabagyam	 09/11/2018	        Ramesh G       CA-Common-Existing order-Print
28/1/2019	IN069597 		sivabagyam	 28/1/2019	        Ramesh G       CA-Common-Multi Facility Orders
14/10/2019  IN071315	    Nijitha S   	14/10/2019  	Ramesh G		GHL-CRF-0607
06/07/2020	IN072654	Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
04/08/2020	IN073565	Nijitha S	04/08/2020	Remesh G	MMS-KH-CRF-0029.4/03
24/09/2020	IN074110	Nijitha S	24/09/2020	Remesh G	MMS-KH-CRF-0029.4/05
14/10/2020	IN072542		SIVABAGYAM M	14/10/2020	RAMESH G	CA-GHL-CRF-0558.1-US003/02- View Chart Summary
16/08/2021	19112			Ramesh												NMC-JD-CRF-0106
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

try
{
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = "1";

	String patient_id	= request.getParameter("patientId");
	String encounter_id	= request.getParameter("encntr_id");
	
	String bean_id 		= "@existingorderbean"+patient_id+encounter_id;
 
	//String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";

	
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");

	String pract_reln_id = request.getParameter("pract_reln_id")==null?"":request.getParameter("pract_reln_id");
	
	String practitioner_type  	= (String) session.getValue("practitioner_type");

	if(practitioner_type== null)practitioner_type = "";
	if(resp_id== null)resp_id = "";
	String episode_id ="";
	String episode_visit_num ="";
	String rd_install	= "N";
	String ot_install	= "N";
 	String old_category	 = "";
	String order_set_expln_txt="View Order Set Detail";

	ArrayList PrEncounterDtls		= null;
 	ArrayList allValues = new ArrayList();
	ArrayList ErrStatusChk		= null;//--[IN033488]


	/* Initialize Function specific start */
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;

    bean.setLanguageId(localeName);

	if(!bean.checkForNull(encounter_id,"").equals(""))
	{
		PrEncounterDtls  = bean.getPREncounterDetails(facility_id,encounter_id); 		
		if(PrEncounterDtls!=null)
		{
			for(int j=0; j<PrEncounterDtls.size(); j++)
			{
				String[] record 						= (String[])PrEncounterDtls.get(j);
				episode_id					= bean.checkForNull(record[3],"");
				episode_visit_num		= bean.checkForNull(record[4],"");
			}
		}
 	}  // End of function_from != "CP" 
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;

 	int start	 = Integer.parseInt(from);
	int end		= Integer.parseInt(to);

// THESE ARE THE PARAMS FOR AMMEND FUNCTION

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
	

// THESE ARE THE PARAMS FOR AMMEND FUNCTION - END

            _bw.write(_wl_block1Bytes, _wl_block1);
  	
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
	String order_category	= request.getParameter( "order_category" ) ;
	String order_type		= request.getParameter( "order_type" ) ;
	String view_by			= request.getParameter( "view_by" ) ;
	String search_criteria	= request.getParameter( "search_criteria" ) ;
	String cosign			= request.getParameter("cosign") ;
	String activity_type			= request.getParameter("activity_type") ;
	String elapsed_orders			= request.getParameter("elapsed_orders") ;
	String sys_cancelled_orders			= request.getParameter("sys_cancelled_orders") ;
	String curr_sys_date    = "";
	String action_type    = "";//--[IN033488]
	String action_date_time    = "";
	String action_by_id    = "";
	String recordConsentWithOrder = bean.getRecordConsetFormWithOrderYN();  //IN057196
	String cnsnt_with_order_yn = bean.checkForNull(request.getParameter("cnsnt_with_order_yn"),"N");  //IN057196
	//IN030279 Start.
		String function_from = ((String)request.getParameter("function_from"))==null ? "" : (String)request.getParameter("function_from");
		String existing_order_called_from_new = ((String)request.getParameter("existing_order_called_from_new"))==null ? "" : (String)request.getParameter("existing_order_called_from_new");//IN074110
		String deceased_yn = ((String)request.getParameter("deceased_yn"))==null ? "" : (String)request.getParameter("deceased_yn");
		String medico_legal_yn = ((String)request.getParameter("medico_legal_yn"))==null ? "" : (String)request.getParameter("medico_legal_yn");
		String postmortem_status = ((String)request.getParameter("postmortem_status"))==null ? "" : (String)request.getParameter("postmortem_status");
		String body_part_yn = ((String)request.getParameter("body_part_yn"))==null ? "" : (String)request.getParameter("body_part_yn");
		String registration_no = ((String)request.getParameter("registration_no"))==null ? "" : (String)request.getParameter("registration_no");
		String callingFrom = ((String)request.getParameter("callingFrom"))==null ? "" : (String)request.getParameter("callingFrom");
	//IN030279 End.
	String queryString = ((String)request.getParameter("queryString"))==null ? (String)request.getQueryString() : (String)request.getParameter("queryString");   //[IN036674]
	String lv_neonate_spec_yn	= "";//31792
	String Appt_can_reason	= "";//ML-MMOH-CRF-1617.1
	String Appt_can_remarks	= "";//ML-MMOH-CRF-1617.1
	String Appt_resched_remarks	= "";//ML-MMOH-CRF-1617.1
	
	//68801 start
	String existexternalReqFormYN="";
	String locale = request.getParameter("locale")==null?"":request.getParameter("locale") ;
	String visit_Id = request.getParameter("visit_Id")==null?"":request.getParameter("visit_Id") ;
	String Patient_ID = request.getParameter("Patient_ID")==null?"":request.getParameter("Patient_ID") ;
	//68801 end 
	
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
	if(elapsed_orders != null )elapsed_orders = elapsed_orders.trim();				else elapsed_orders = "";
	if(sys_cancelled_orders != null )sys_cancelled_orders = sys_cancelled_orders.trim();				else sys_cancelled_orders = "";
	

	rd_install = bean.getRadiology(facility_id);
	if(rd_install==null) rd_install = "N";

	ot_install = bean.getOTModule(facility_id);
	if(ot_install==null) ot_install = "N";
	
	//IN063816 start
	String barcodeSiteSpecificYN = "";

	boolean isSiteSpecific = false;
	boolean isSiteSpecificBTColor = false;//IN065091
	Connection connection =  null;
	
	boolean isSiteSpecificBillStatus = false; //19112
	boolean isSiteSpecificNeonatalMotherSpecimen=false;//31792
try{
	connection = ConnectionManager.getConnection(request); 
	isSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","GHL_BARCODE_LABEL_REPORT");
	isSiteSpecificBillStatus = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BILL_STATUS_DISPLAY");//19112
	isSiteSpecificNeonatalMotherSpecimen = eCommon.Common.CommonBean.isSiteSpecific(connection,"OR","NEONATAL_MOTHER_SPECIMEN");//31792
	if(isSiteSpecific)
	{
		barcodeSiteSpecificYN = "Y";
	}
	else
	{
		barcodeSiteSpecificYN = "N";
	}
	//IN063816 ends
	//IN065091 starts
	
	String BTColorYN = "";
	isSiteSpecificBTColor = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BLOOD_ORDERS_ACK");
	if(isSiteSpecificBTColor){
		BTColorYN = "Y";
	}
	else{
		BTColorYN = "N";
	}
}
catch(Exception e){
	out.println("Exception@1: "+e);
}
finally
{
	if(connection!=null)	ConnectionManager.returnConnection(connection,request);
}
	//IN065091 ends
	// Get the date Sysdate  (IF Appointment is there, and start_date_time is less than sysdate, then have to pass the sysdate
	ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
	for(int i=0;i<sysdate.size();i++){
		curr_sys_date	= (String)sysdate.get(0);
 	}
	//allValues		= bean.getSearchDetails(view,patientId,encntr_id,order_status,order_by,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, activity_type, practitioner_type,elapsed_orders,sys_cancelled_orders,start,end,(String)session.getAttribute("responsibility_id"),(String)session.getAttribute("ca_practitioner_id"),pract_reln_id);
	allValues		= bean.getSearchDetails(view,patientId,encntr_id,order_status,order_by,catalog,date_from,date_to,order_category,order_type,search_criteria,priority,view_by, activity_type, practitioner_type,elapsed_orders,sys_cancelled_orders,start,end,(String)session.getAttribute("responsibility_id"),(String)session.getAttribute("ca_practitioner_id"),pract_reln_id,(String)session.getValue("login_user"));//IN072542
	if(allValues.size() == 0){

            _bw.write(_wl_block8Bytes, _wl_block8);
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
if (view_by.equals("L")) {
            _bw.write(_wl_block10Bytes, _wl_block10);
if (called_from.equals(""))
		{
            _bw.write(_wl_block11Bytes, _wl_block11);

		//IN065091 Start
		if(isSiteSpecificBTColor)
		{
		
            _bw.write(_wl_block12Bytes, _wl_block12);

		}//IN065091 ends
		
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
} else {
            _bw.write(_wl_block10Bytes, _wl_block10);
if (called_from.equals(""))
		{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if (view_by.equals("L")) {
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
} else {
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
if((order_category.equals("PH")|| order_category.equals(""))&&view_by.equals("L")){ 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);

		if("L".equals(view_by) && "Y".equals(barcodeSiteSpecificYN))
		{
		
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
		
            _bw.write(_wl_block26Bytes, _wl_block26);

		//IN065942, starts
		if("L".equals(view_by))
		{
		
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
		//IN065942, ends	
		//19112 Start.
		if(isSiteSpecificBillStatus && "L".equals(view_by)){
			
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

		}
		//19112 End.
		
            _bw.write(_wl_block30Bytes, _wl_block30);
if (called_from.equals("")){ if (!function_from.equals("MO")){ //[IN036674] 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
 }} 
            _bw.write(_wl_block32Bytes, _wl_block32);

	String slClassValue = "";
	String src_type = request.getParameter("source_type");
	if(src_type==null) src_type= "";

	String fontValue = "";

	String cont_order_ind = "";


	String[] existing_details = null;
	String can_reason = null;
	String consent_req_Yn = null;
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
	String bt_ack_YN = ""; //IN065091

	/*String line_menu_security1	= (String)bean.getMenu("CANCEL_ORDER",resp_id,pract_reln_id);
	String line_menu_security2	= (String)bean.getMenu("DISCONTINUE",resp_id,pract_reln_id);
	String menu_security1		= (String)bean.getMenu("AMEND_ORDER",resp_id,pract_reln_id);
	String menu_security_hold	= (String)bean.getMenu("HOLD",resp_id,pract_reln_id);
	String menu_security_resume = (String)bean.getMenu("RESUME",resp_id,pract_reln_id);*/
	String order_catalog_nature	= null;
	String display_appt_yn		= "N";
	String notify_yn			= "N";
	String [] colorString = {"X","X","X","X"};
	String color_string = "X,X,X,X";
	String appt_disabled = "";
	String allow_cancel_yn = "";

	StringTokenizer menu_options = null;
	int i = 0;
	//Added by Uma on 2/11/2010 for package billing
    String billing_package_ref = "";
	//	Added by Sridhar Reddy on 11/11/2008 for Displaytooltip
		StringBuffer strOrderCtl = new StringBuffer();		
	// end
	String lb_rslt_mod_status = ""; //HSA-CRF-0257.1 - IN055910 - Start
	String isResultModified = ""; //HSA-CRF-0257.1-02 IN058125	
	ArrayList specList = null; //HSA-CRF-0257.1-02 IN058125	
	for(int k=0; k<allValues.size(); k++){
		String billingStatus = ""; //19112
		if(strOrderCtl.length() > 0)
			strOrderCtl = strOrderCtl.delete(0,strOrderCtl.length());

		existing_details = (String[])allValues.get(k);
        if(existing_details[0] == null) existing_details[0] = "";
        if(existing_details[1] == null) existing_details[1] = "";
        if(existing_details[2] == null) existing_details[2] = "";
        if(existing_details[3] == null) existing_details[3] = "";
		//added by jayashree
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
		/*Added by Uma on 4/15/2010 for package billing*/
		
		if(view_by.trim().equals("H"))
		{
			if(existing_details[55] == null) existing_details[55] = "";
			if(existing_details[56] == null) existing_details[56] = "";
			if(existing_details[64] == null) existing_details[64] = "";//31792
			
		}
		/*Ends Here*/
		slClassValue="gridData";
		if(view_by.trim().equals("L"))
		{
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
			/*Added by Uma on 4/15/2010 for package billing*/
			if(existing_details[67] == null) existing_details[67] = "";
			if(existing_details[68] == null) existing_details[68] = "";
			if(existing_details[69] == null) existing_details[69] = "";
			/*Ends Here*/
			if(existing_details[71] == null) existing_details[71] = "";
			if(existing_details[72] == null) existing_details[72] = ""; //IN063816
			if(existing_details[73] == null) existing_details[73] = ""; //IN065091
			if(existing_details[74] == null) existing_details[74] = ""; //IN065942
			if(existing_details[75] == null) existing_details[75] = "";//IN64543
			if(existing_details[76] == null) existing_details[76] = ""; //IN061961
			
			if(existing_details[79] == null) existing_details[79] = ""; //19112
			if(existing_details[81] == null) existing_details[81] = ""; //31792
			if(existing_details[82] == null) existing_details[82] = ""; //ML-MMOH-CRF-1617.1
			if(existing_details[83] == null) existing_details[83] = ""; //ML-MMOH-CRF-1617.1
			if(existing_details[84] == null) existing_details[84] = ""; //ML-MMOH-CRF-1617.1
			
			//IN066709 Starts	
			if(resp_id.equals("MO") && ("Y".equals(existing_details[60]))){
				cnsnt_with_order_yn="Y";
			}
			//IN066709 Ends	
			
			menu_options			= new StringTokenizer(existing_details[15],"|");
			
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
				/*Added by Uma on 2/11/2010 for CRF 712 package billing*/
				existing_details[68] = menu_options.nextToken();  //REPLACE FOR PACKAGE BILLING
				/*Ends Here*/
				existing_details[65] = menu_options.nextToken();  //VIEW_REPLACED_ORDER
				existing_details[66] = menu_options.nextToken();  //VIEW_ORIGINAL_ORDER				
				
			}
			
			//IN063781 starts
			if("PF".equals(existing_details[14]) && !("RD".equals(existing_details[0]) && "Y".equals(existing_details[17])))
			{
				existing_details[17] = "N";
			}
			//IN063781 ends
			cont_order_ind			= existing_details[21];
			color_string			= existing_details[36];
			can_reason				= existing_details[37];
			can_pract_id			= existing_details[38];
			can_date_time			= existing_details[39];
			disc_pract_id			= existing_details[40];
			disc_date_time			= existing_details[41];
			//hold_pract_id			= existing_details[42];
			//hold_date_time			= existing_details[43];
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
			//Added by Uma on 2/11/2010 for package billing CRF 712*/
			billing_package_ref		= existing_details[67];
			bt_ack_YN				= existing_details[73];//IN065091
			if(existing_details[64] == null || existing_details.equals("")) existing_details[64] = "";					 
			//IN068986 Start.
			/*if(existing_details[77] != null)//IN061961
				total_query_records		= existing_details[77];//IN061961 */
			/* if(existing_details[78] != null)//IN061961
				total_query_records		= existing_details[78];//IN061961 IN073562*/
			//IN068986 Ends.
			//19112 Start.
			//if(existing_details[79] != null)//IN073562
			//total_query_records		= existing_details[79];//IN073562
			if("B".equals(existing_details[79]))
				billingStatus	= "Billed&nbsp;<img src='../../eOR/images/Billed.png' border='0'  title='Billed'/>";
			else if("U".equals(existing_details[79]))
				billingStatus	= "Unbilled&nbsp;<img src='../../eOR/images/Unbilled.png' border='0'  title='Unbilled'/>";
			else
				billingStatus	=existing_details[79];
			
			if("DC".equals(existing_details[14]) || "CN".equals(existing_details[14]) )
				billingStatus="";
			if(existing_details[80] != null)//IN073562
			total_query_records		= existing_details[80];//IN073562
			
			lv_neonate_spec_yn =existing_details[81];//31792
			Appt_can_reason=existing_details[82];//ML-MMOH-CRF-1617.1
			Appt_can_remarks=existing_details[83];//ML-MMOH-CRF-1617.1
			Appt_resched_remarks=existing_details[84];//ML-MMOH-CRF-1617.1
			
			//19112 End.
		} 
		else 
		{
			if(existing_details[25] == null || existing_details.equals("")) existing_details[25] = "X,X,X,X";
			if(existing_details[46] == null || existing_details.equals("")) existing_details[46] = "N";
			if(existing_details[49] == null || existing_details.equals("")) existing_details[49] = "0";
			if(existing_details[50] == null || existing_details.equals("")) existing_details[50] = "";
			if(existing_details[51] == null || existing_details.equals("")) existing_details[51] = "";			
			if(existing_details[52] == null || existing_details.equals("")) existing_details[52] = "";			
			if(existing_details[53] == null || existing_details.equals("")) existing_details[53] = "";			
			if(existing_details[54] == null || existing_details.equals("")) existing_details[54] = "";	
			if(existing_details[62] == null || existing_details.equals("")) existing_details[62] = "";//IN066414
			if(existing_details[63] == null || existing_details.equals("")) existing_details[63] = "";//IN067817
			color_string			= existing_details[25];

			menu_options			= new StringTokenizer(existing_details[12],"|");
							
			if(menu_options.hasMoreTokens())
			{
				existing_details[12] =	menu_options.nextToken();  //AMEND_CANCEL
				allow_cancel_yn= menu_options.nextToken();    // CANCEL_ORDER Added by Sridhar for MO-CRF-0033
				existing_details[15] =	menu_options.nextToken();  //DISCONTINUE 
				existing_details[20] =	menu_options.nextToken();  //HOLD 
				existing_details[21] =	menu_options.nextToken();  //RESUME 
				existing_details[23] =	menu_options.nextToken();  //RENEW 
				existing_details[14] =	menu_options.nextToken();  //RESULT_HYPER_LINK 
				existing_details[52] =  menu_options.nextToken();  //LINK_TO_CURRENT_ENCOUNTER  
				/*Added by Uma on 2/11/2010 for CRF 712 package billing*/
				existing_details[56] =  menu_options.nextToken();  //REPLACE FOR PACKAGE BILLING
				/*Ends Here*/
				existing_details[53] =  menu_options.nextToken();  //VIEW_REPLACED_ORDER  
				existing_details[54] =  menu_options.nextToken();  //VIEW_ORIGINAL_ORDER  
				
			}
			// Start of lines to be commented
			can_reason				= existing_details[26];
			can_pract_id			= existing_details[27];
			can_date_time			= existing_details[28];
			disc_pract_id			= existing_details[29];
			disc_date_time			= existing_details[30];
			//hold_pract_id			= existing_details[31];
			//hold_date_time			= existing_details[32];
			last_action_reason_desc	= existing_details[33];	
			appt_date				= existing_details[34];
			appt_ref_num			= existing_details[35];
			order_catalog_nature	= existing_details[36];
			sec_order_yn			= existing_details[37];
			pri_order_id			= existing_details[38];

			appt_locn				= existing_details[39];
			appt_resched_yn			= existing_details[40];
			appt_resched_reason		= existing_details[41];
			no_of_reschedules		= existing_details[42];
			appt_reqd_yn			= existing_details[43];
			notify_yn				= existing_details[46];
			display_appt_yn			= existing_details[12];  //display_popupmen

			last_action_type		= existing_details[47];
			accession_num			= existing_details[48];
			consent_req_Yn			= existing_details[50];
			/*Added by Uma on 2/11/2010 for package billing CRF 712*/
			billing_package_ref			= existing_details[55];
			
			// end of lines to be commented
			if(existing_details[58] != null)//Menaka
				total_query_records		= bean.checkForNull(existing_details[58],"0");//Menaka
				
			//IN063781 starts
			if("PF".equals(existing_details[13]) && !("RD".equals(existing_details[0]) && "Y".equals(existing_details[14])))
			{
				existing_details[14] = "N";
			}
			//IN063781 ends
			lv_neonate_spec_yn=existing_details[64];//31792
	}

		//HSA-CRF-0257.1 - IN055910 - Start 
		if(existing_details[0].equals("LB")) {
			//isResultModified = bean.getResultStatFromStatusAppl(view_by, existing_details[9], existing_details[11]); //HSA-CRF-0257.1-02 [IN058125]  // commented for PERF ISSUE - Karthi
			isResultModified = bean.getResultStatFromStatusAppl(view_by, existing_details[9], existing_details[11], patientId); // modified for PERF ISSUE - Karthi
			if(isResultModified == null) isResultModified = ""; //HSA-CRF-0257.1-02 [IN058125]
			if("Y".equals(isResultModified)) { //AAKH-SCF-0252
				//specList = bean.getIntervalTestSpecNos(existing_details[9]); // commented for PERF ISSUE - Karthi
				specList = bean.getIntervalTestSpecNos(existing_details[9], patientId); // modified for PERF ISSUE - Karthi
				if(specList != null && specList.size()>1){
					//lb_rslt_mod_status = bean.getLBModStatForIntTest(specList);	// commented for PERF ISSUE - Karthi
					lb_rslt_mod_status = bean.getLBModStatForIntTest(specList, patientId);	// modified for PERF ISSUE - Karthi
				}
				else {
					//lb_rslt_mod_status =  bean.getLabOrderStatusBySpecNo(accession_num, view_by, existing_details[12]);	// commented for PERF ISSUE - Karthi
					lb_rslt_mod_status =  bean.getLabOrderStatusBySpecNo(accession_num, view_by, existing_details[12], patientId);	// modified for PERF ISSUE - Karthi
				}
				if(lb_rslt_mod_status == null) lb_rslt_mod_status ="";
			}	//AAKH-SCF-0252
			//isResultModified = bean.getResultStatFromStatusAppl(view_by, existing_details[9], existing_details[11]); //HSA-CRF-0257.1-02 [IN058125] - AAKH-SCF-0252
			//if(isResultModified == null) isResultModified = ""; //HSA-CRF-0257.1-02 [IN058125] - AAKH-SCF-0252
		}
		//HSA-CRF-0257.1 - IN055910 - End
	if(k==0) { 

            _bw.write(_wl_block33Bytes, _wl_block33);
if((Integer.parseInt(total_query_records)>0) || (start>1)){
            _bw.write(_wl_block34Bytes, _wl_block34);

	if("L".equals(view_by) && "Y".equals(barcodeSiteSpecificYN))
	{
		//IN065091 start
		if("L".equals(view_by) && isSiteSpecificBTColor){
		
            _bw.write(_wl_block35Bytes, _wl_block35);

		}else{
	
            _bw.write(_wl_block36Bytes, _wl_block36);

		}
	}else if("L".equals(view_by) && isSiteSpecificBTColor){	
	
            _bw.write(_wl_block36Bytes, _wl_block36);
}
	else{
	
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("chk")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("existing_order_dtl")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
		}  

	if(!existing_details[0].equals(old_category) && order_by.equals("O")) 
	{ 
	
            _bw.write(_wl_block45Bytes, _wl_block45);
if(view_by.trim().equals("L")){ out.println("colspan='12'"); } else{ out.println("colspan='11'"); } 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block47Bytes, _wl_block47);
 } 

            _bw.write(_wl_block48Bytes, _wl_block48);
//if(view_by.trim().equals("L")){

			
//        if (existing_details[9].equals("PH"))
{
           //  color_string = bean.getColorCodings(facility_id,existing_details[9],existing_details[12],existing_details[11]);
            StringTokenizer colorTokenizer = new StringTokenizer(color_string,",");
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
 					/*{if(order_status.equals("A"))
						colorString[index] = "QRY1";
					if(order_status.equals("F"))
						colorString[index] = "QRY7"; 
					if(order_status.equals("P"))
						colorString[index] = "QRY5"; 
					if(order_status.equals("D"))
						colorString[index] = "QRY2"; }*/
				index++;
            }  
        }
	  
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(((colorString[0].equals("X"))?slClassValue:colorString[0])));
            _bw.write(_wl_block50Bytes, _wl_block50);
 if(view_by.trim().equals("L")){
		   
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(((colorString[2].equals("X"))?slClassValue:colorString[2])));
            _bw.write(_wl_block52Bytes, _wl_block52);

		if(sec_order_yn.equals("Y"))// && pri_order_id.equals(""))
		 {
		
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block55Bytes, _wl_block55);

		 }
		if(!(existing_details[61].equals("")))
		{
			order_set_expln_txt=bean.getMessage(localeName,"ORDER_SET_EXPLN_TEXT","OR");
			if(!(view_by.trim().equals("L")))
			{
		
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(existing_details[61]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block58Bytes, _wl_block58);
}else
			{
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(existing_details[61]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[9]));
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block58Bytes, _wl_block58);
}
		}
		
            _bw.write(_wl_block59Bytes, _wl_block59);

		//IN065091 start
		if(isSiteSpecificBTColor){
			if("Y".equals(bt_ack_YN)){
			
            _bw.write(_wl_block60Bytes, _wl_block60);

			}
			else
			{
			
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
	
			}
		}
		//IN065091 ends
	}
	else
	{
		
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(((colorString[2].equals("X"))?slClassValue:colorString[2])));
            _bw.write(_wl_block64Bytes, _wl_block64);

		
		if(sec_order_yn.equals("Y")) //&& pri_order_id.equals(""))
		{ 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
	if(!(existing_details[51].equals("")))
	{
		order_set_expln_txt=bean.getMessage(localeName,"ORDER_SET_EXPLN_TEXT","OR");

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(existing_details[51]));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block68Bytes, _wl_block68);

	}
            _bw.write(_wl_block69Bytes, _wl_block69);
}
		if(view_by.trim().equals("L")){

			//out.println("<script>alert('"+existing_details[7]+"')</script>");
		  // System.err.println("INTEH L"+view_by.trim());

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(existing_details[27],"DMYHM","en",localeName)));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
if(!(existing_details[4].equalsIgnoreCase("MS")&&existing_details[0].equalsIgnoreCase("PH"))){out.println(com.ehis.util.DateUtils.convertDate(existing_details[28],"DMYHM","en",localeName));}
            _bw.write(_wl_block73Bytes, _wl_block73);
} else {
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(existing_details[7],"DMYHM","en",localeName)));
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block64Bytes, _wl_block64);

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

		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fontValue));
            out.print( String.valueOf(existing_details[2]));
            _bw.write(_wl_block74Bytes, _wl_block74);
if(view_by.trim().equals("L")){
			//if(existing_details[11] == null) existing_details[11] = "";
			//if(existing_details[12] == null) existing_details[12] = "";
			//if(existing_details[13] == null) existing_details[13] = "";
			//if(existing_details[24] == null) existing_details[24] = "";
        	//if(existing_details[25] == null) existing_details[25] = "";
        	//if(existing_details[26] == null) existing_details[26] = "N";
        	//if(existing_details[27] == null) existing_details[27] = "";
        	//if(existing_details[28] == null) existing_details[28] = "";
			//cont_order_ind = existing_details[21];
		
 		
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[27]));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[13]));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[19]));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[20]));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[30]));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[18]));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[81]));
            _bw.write(_wl_block96Bytes, _wl_block96);
}else{
			cont_order_ind = existing_details[19];
		
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[45]));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[44]));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[17]));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[18]));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[24]));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[16]));
            _bw.write(_wl_block100Bytes, _wl_block100);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[62]));
            _bw.write(_wl_block102Bytes, _wl_block102);
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block103Bytes, _wl_block103);



		  }
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[8]));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block112Bytes, _wl_block112);
	
			
		
		if((view_by.trim()).equals("H")) 
		{					
			
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(existing_details[64]));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(existing_details[8]));
            _bw.write(_wl_block115Bytes, _wl_block115);

					strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' class='gridDataBlue' ");
					//existing_details[23] = "Y";
					

					if (existing_details[22]==null)existing_details[22] = "";
					if (existing_details[23].equals("")) existing_details[23] = "N";
					/*if(existing_details[9]!=null){
					order_catalog_nature=bean.checkForNull(bean.getCatalogNature(existing_details[9].trim()));	
					}*/
			
					if((existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) || (order_catalog_nature!=null && order_catalog_nature.equals("S")) ) 
					{ // only care set (order set) orders
				
						strOrderCtl.append(" onClick=\"showCareSetResults('"+existing_details[9]+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
						
					}
					else  // For other categories Normal 
					{
						if((existing_details[12].trim().equals("Y") && allow_cancel_yn.trim().equals("Y"))&&((existing_details[0].equalsIgnoreCase("PH"))&&(existing_details[4].equalsIgnoreCase("MS")||existing_details[22].equalsIgnoreCase("6"))||(!(existing_details[55].equalsIgnoreCase("")))))
						{

							strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,,,,"+((existing_details[52].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[53].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[54].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+",','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"','"+existing_details[4]+"','"+existing_details[45]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
						
						}else if((existing_details[12].trim().equals("Y") && allow_cancel_yn.trim().equals("N"))&&((existing_details[0].equalsIgnoreCase("PH"))&&(existing_details[4].equalsIgnoreCase("MS")||(existing_details[22].equalsIgnoreCase("6")))||(!(existing_details[55].equalsIgnoreCase("")))))
						{
							strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',,,"+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+",,,"+((existing_details[52].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[53].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[54].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+",','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"','"+existing_details[4]+"','"+existing_details[45]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
							
						}
						else
						{
							strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[12].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[20].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[21].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[52].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[53].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[54].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+",','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"','"+existing_details[4]+"','"+existing_details[45]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+existing_order_called_from_new+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN072654//Added existing_order_called_from_new for IN074110
							//strOrderCtl.append("  onClick=\"displayToolTip(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[12].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[20].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[21].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[52].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[53].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[54].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+","+((null!=existing_details[64] && Integer.valueOf(existing_details[64]) > 0)? "'+getLabel('eOR.InteractionDtls.label','OR')+'" : "")+",','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','"+patientId+"','"+encounter_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+cont_order_ind+"','"+existing_details[13]+"','"+existing_details[22]+"','"+existing_details[4]+"','"+existing_details[45]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN072654
							
						}			
		} // else of the order_category 'CS'
			//	out.println("<a href='javascript: dummy()' onClick=\"displayToolTip('View,,,Discontinue,,,','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"')\"  onMouseOver='hideToolTip()'>");

	
            _bw.write(_wl_block116Bytes, _wl_block116);
	}	
	else if((view_by.trim()).equals("L")) {
		if(ext_appl_accession_num != null && !ext_appl_accession_num.equals(""))
			accession_num_tooltip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExternalApplicationAccessionNo.label","or_labels")+" "+ext_appl_accession_num;
		else
			accession_num_tooltip = "";
		
		
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(existing_details[8]));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block119Bytes, _wl_block119);
		
		strOrderCtl.append("<td width='' nowrap id='orderctl"+i+"' style='cursor:pointer' title='"+accession_num_tooltip+"' class='gridDataBlue'");
		if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) 
		{ // only care set (order set) orders
			
 				strOrderCtl.append("onClick=\"showCareSetResults('"+existing_details[9]+"')\"  onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
				
		}
		else 
		{ // For other categories normal one

					if(((existing_details[0].equalsIgnoreCase("PH"))&&((existing_details[4].equalsIgnoreCase("MS"))||(existing_details[25].equalsIgnoreCase("6"))))||(!(existing_details[67].equalsIgnoreCase(""))))
					{
							//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
							//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">"); //IN042100//IN64543
							strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+",,'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,,,,"+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"','"+existing_details[75]+"')\">"); //IN042100//IN64543
							
					}else
					{	
							//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[23].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");
							//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN042100
							//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+existing_details[75]+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN64543
						//strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+existing_details[75]+"','"+view_by+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN061961//IN072654
					
						strOrderCtl.append("  onClick=\"displayToolTip1(''+getLabel('Common.view.label','Common')+',"+((allow_cancel_yn.trim().equals("Y"))?"'+getLabel('Common.cancel.label','Common')+'":"")+","+((existing_details[15].trim().equals("Y"))?"'+getLabel('Common.Amend.label','Common')+'":"")+",'+getLabel('eOR.Preps.label','OR')+','+getLabel('Common.Comments.label','Common')+','+getLabel('Common.Instructions.label','Common')+',,"+((existing_details[16].trim().equals("Y"))?"'+getLabel('Common.Discontinue.label','Common')+'":"")+","+((existing_details[22].trim().equals("Y"))?"'+getLabel('Common.Hold.label','Common')+'":"")+","+((existing_details[23].trim().equals("Y"))?"'+getLabel('eOR.Resume.label','OR')+'":"")+","+((existing_details[63].trim().equals("Y"))?"'+getLabel('eOR.Linktocurrentencounter.label','OR')+'":"")+","+((existing_details[68].trim().equals("Y"))?"'+getLabel('eOR.Replace.label','OR')+'":"")+","+((existing_details[65].trim().equals("Y"))?"'+getLabel('eOR.ViewReplacedOrder.label','OR')+'":"")+","+((existing_details[66].trim().equals("Y"))?"'+getLabel('eOR.ViewOriginalOrder.label','OR')+'":"")+","+((existing_details[26].trim().equals("Y"))? "'+getLabel('eOR.Renew.label','OR')+'" : "")+","+((!"EXTERNAL_ORDER".equals(existing_order_called_from_new) && null!=existing_details[78] && Integer.valueOf(existing_details[78]) > 0)? "'+getLabel('eOR.InteractionDtls.label','OR')+'" : "")+"','"+existing_details[0]+"','"+existing_details[1]+"','"+existing_details[9]+"','CN','"+existing_details[11]+"','"+existing_details[12]+"','"+i+"','"+patientId+"','"+encntr_id+"','"+pract_reln_id+"','"+location_type+"','"+location_code+"','"+patient_class+"','"+p_called_from_ca+"','"+cont_order_ind+"','"+existing_details[14]+"','"+sex+"','"+age+"','"+dob+"','"+visit_adm_date+"','"+existing_details[25]+"','"+existing_details[4]+"','"+episode_id+"','"+episode_visit_num+"',this,'imgArrow"+i+"','"+existing_details[75]+"','"+view_by+"','"+existing_order_called_from_new+"')\" onMouseOver=\"hideToolTip(this,'imgArrow"+i+"','"+i+"')\">");//IN061961//IN072654//IN073565//Added existing_order_called_from_new for IN074110
						
						}
		}
		/*if(existing_details[0].equals("PH"))
		{
		String tradename=bean.checkForNull(bean.getTradeName(existing_details[9],existing_details[11]),"");
		if(!tradename.equals("**"))
		existing_details[3]=existing_details[3]+"["+tradename+"]";
		}*/
	} // End of else category 'CS'
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
		//if(existing_details[0].equalsIgnoreCase("PH"))
		//strOrderCtl.append("<input type='button' value='SS' onclick=showSlidingDetails('PHOP00000068461')>");  //used for the sliding scale function(new CRF)
		
		strOrderCtl.append(existing_details[3]);
		if(notify_yn!=null && notify_yn.equals("Y")) {
			strOrderCtl.append("<img height='15' width='15' src=\"../images/Alert.gif\">");
		} 
		//IN029948 Starts
		
		if( (view_by.trim()).equals("L") && existing_details[0].equalsIgnoreCase("PH") && "Y".equals(existing_details[70]))
		{
			strOrderCtl.append("<a href='javascript: dummy()' onClick=\"showDetailsPH('"+patient_id+"','"+existing_details[9]+"','"+existing_details[11]+"','"+existing_details[14]+"')\">");
			strOrderCtl.append("<img width='20' height='20' src='../../ePH/images/altenate.jpg'/>");
			strOrderCtl.append("</a>");				
		} 
			//IN029948 Ends
		//31792 starts
		if((view_by.trim()).equals("L") && isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){					
			strOrderCtl.append("&nbsp;&nbsp;<img style='cursor:pointer;' src='../../eCA/images/MotherBlood.png' onClick=\"NeonatalMotherSpecimenDetails1('"+existing_details[9]+"','"+existing_details[11]+"','"+existing_details[0]+"','"+existing_details[62]+"','"+existing_details[57]+"',null,null)\">");
		}else if ((view_by.trim()).equals("H") && isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){					
			strOrderCtl.append("&nbsp;&nbsp;<img style='cursor:pointer;' src='../../eCA/images/MotherBlood.png' onClick=\"NeonatalMotherSpecimenDetails1('"+existing_details[9]+"','"+existing_details[11]+"','"+existing_details[0]+"','"+existing_details[60]+"','"+existing_details[48]+"',null,null)\">");
		}
		//31792 End.
		if(!(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")))
		{
			strOrderCtl.append("<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+i+"' id='imgArrow"+i+"'></td>");
		}

		out.println(strOrderCtl.toString());
	
	

            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(existing_details[5]));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(((colorString[3].equals("X"))?slClassValue:colorString[3])));
            _bw.write(_wl_block124Bytes, _wl_block124);
	
	//  This added For MultipleConsent
				
	

 			/*AppointmentDetails = bean.getOrderApptDetails(existing_details[9]);
 			for(int k=0;k<AppointmentDetails.size();k++) {
				String[] record = (String [])AppointmentDetails.get(k);
				appt_ref_num 	= record[0];
				appt_date		= record[1];
				if(appt_ref_num==null) appt_ref_num= "";
				if(appt_date==null) appt_date= "";
			}*/


            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block130Bytes, _wl_block130);

		if((view_by.trim().equals("L")))
		{
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(existing_details[62]));
            _bw.write(_wl_block130Bytes, _wl_block130);

		}
		else
		{
		
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(i));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(existing_details[60]));
            _bw.write(_wl_block135Bytes, _wl_block135);

		}
		
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(appt_locn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(appt_resched_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(appt_resched_reason));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(no_of_reschedules));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block148Bytes, _wl_block148);
if(!(view_by.trim().equals("L")))
		{
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(order_set_expln_txt));
            _bw.write(_wl_block130Bytes, _wl_block130);

		}else
		{
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(existing_details[9]));
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(existing_details[9]));
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(order_set_expln_txt));
            _bw.write(_wl_block130Bytes, _wl_block130);
}
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block152Bytes, _wl_block152);
	if(!(view_by.trim().equals("L"))){
			//printEnable = "N";
			//HSA-CRF-0257.1 - IN055910 - Start
				if(existing_details[0].equals("LB") &&  lb_rslt_mod_status.equals("C") && isResultModified.equals("Y"))
		
            _bw.write(_wl_block153Bytes, _wl_block153);
					
				//HSA-CRF-0257.1 - IN055910 - End
				if(existing_details[14].trim().equals("Y")){
					
					if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) { // only care set (order set) orders 

            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(existing_details[3]));
            _bw.write(_wl_block157Bytes, _wl_block157);
					}  else {  
            _bw.write(_wl_block158Bytes, _wl_block158);
 if(last_action_type!=null && last_action_type.equals("NT")) { 
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block163Bytes, _wl_block163);
 } else { 
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block163Bytes, _wl_block163);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);
					} 
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(existing_details[6]));
            _bw.write(_wl_block166Bytes, _wl_block166);

				}
				else{ 					
					//if((!appt_ref_num.equals("")) && (!appt_date.equals("")) && (existing_details[14].equals("AB"))) //IN066414
					if((!appt_ref_num.equals("")) && (!appt_date.equals("")) && (existing_details[13].equals("AB"))) //IN066414
					{
 						/*commented and added for IN08078 starts*/
						//if( (existing_details[0].equals("RD") && rd_install.equals("Y")) || (existing_details[0].equals("OT") && ot_install.equals("Y")) )
						if( (existing_details[0].equals("RD") ) || (existing_details[0].equals("OT") && ot_install.equals("Y")) )
						/*commented and added for IN08078 Ends*/
						{ 
						
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);

						}
						else 
						{ 
						
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);

							if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && !appt_ref_num.equals("") && !existing_details[0].equals("OT")  && display_appt_yn.equals("Y") ) 
							{ 
						
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(i));
            _bw.write(_wl_block173Bytes, _wl_block173);
 
							} 
							
            _bw.write(_wl_block174Bytes, _wl_block174);
					} 
					}
					if(appt_reqd_yn!=null && appt_reqd_yn.equals("Y") && appt_ref_num.equals("") && display_appt_yn.equals("Y")) //&& existing_details[10].equals("R")) Modified by Uma on 8/26/2009 for IN013477
					{ 
						if(!(existing_details[0].equals("RD") && rd_install.equals("Y")) && !(existing_details[0].equals("OT") && ot_install.equals("Y") && existing_details[13].equals("OS") ))
						{
							
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(i));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(i));
            _bw.write(_wl_block178Bytes, _wl_block178);
		} 
					}	
				out.println(existing_details[6]);
				out.println("</a>");
				 if(existing_details[50].equalsIgnoreCase("Y")){
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(k));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(k));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(k));
            _bw.write(_wl_block182Bytes, _wl_block182);
 					}
				}
				//IN057196 Start.
			//IN066709 Starts	
				if(existing_details[61].equalsIgnoreCase("N") && recordConsentWithOrder.equalsIgnoreCase("Y") && cnsnt_with_order_yn.equalsIgnoreCase("Y"))
				 {
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(k));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(k));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(k));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(k));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[27]));
            _bw.write(_wl_block187Bytes, _wl_block187);
 				
			//IN066709 ends		
				}
				//IN057196 End.
				//IN067817 STARTS
				 if((existing_details[6].equals("Resulted - Complete") ||existing_details[6].equals("Rejected")) && existing_details[63].equalsIgnoreCase("Y")){
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[60]));
            _bw.write(_wl_block189Bytes, _wl_block189);
}		
				//IN067817 ENDS
			
			}else if((view_by.trim().equals("L"))){
				//boolean isviewLineDtls = bean.isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
				//HSA-CRF-0257.1 - IN055910 - Start
				if(existing_details[0].equals("LB") && lb_rslt_mod_status.equals("C")  && isResultModified.equals("Y"))
				
            _bw.write(_wl_block190Bytes, _wl_block190);
					
				//HSA-CRF-0257.1 - IN055910 - End
				//IN061961 starts


				//IN061961 ends
				if(existing_details[17].trim().equals("Y")){
						//printEnable = "N";
						if(existing_details[9]!=null && (existing_details[9].trim().substring(0,2)).equals("CS")) { // only care set (order set) orders 
	
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(existing_details[3]));
            _bw.write(_wl_block192Bytes, _wl_block192);
					}  else {  
            _bw.write(_wl_block193Bytes, _wl_block193);
 if(last_action_type!=null && last_action_type.equals("NT")) { 
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[76]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block198Bytes, _wl_block198);
 } else { 
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[76]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block198Bytes, _wl_block198);
 }
            _bw.write(_wl_block13Bytes, _wl_block13);
					} 
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(existing_details[6]));
            _bw.write(_wl_block202Bytes, _wl_block202);
 if(existing_details[60].equalsIgnoreCase("Y")){
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(k));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(k));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(URLEncoder.encode(existing_details[59],"UTF-8")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(k));
            _bw.write(_wl_block205Bytes, _wl_block205);
				}
				}
				else
				{  
					if((!appt_ref_num.equals("")) && (!appt_date.equals("")) && (existing_details[14].equals("AB")) ) 
					{
						/*commented and added for IN08078 starts*/
						//if( (existing_details[0].equals("RD") && rd_install.equals("Y")) || (existing_details[0].equals("OT") && ot_install.equals("Y")) )
						if( (existing_details[0].equals("RD")) || (existing_details[0].equals("OT") && ot_install.equals("Y")) )//Sharanraj
						/*commented and added for IN08078 ends*/
						{ 
						
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);
		
						}
						else 
						{
							
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block206Bytes, _wl_block206);

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
							
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(appt_disabled));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(i));
            _bw.write(_wl_block206Bytes, _wl_block206);

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
							
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(appt_disabled));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(i));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(i));
            _bw.write(_wl_block173Bytes, _wl_block173);
		
							}
					}
					//IN068986 Start.
					if( (existing_details[0].equals("LB")) && "RG".equals(existing_details[14]) && "Y".equals(existing_details[77])){
					
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(existing_details[1]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[76]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[14]));
            _bw.write(_wl_block212Bytes, _wl_block212);

					}
					//IN068986 End.
					out.println(existing_details[6]);		
					out.println("</a>"); 
					//ML-MMOH-CRF-1617.1 START 
					if(existing_details[0].equalsIgnoreCase("RD")&&existing_details[6].equalsIgnoreCase("Ordered")&&(!Appt_can_remarks.equals("")||!Appt_can_reason.equals(""))){
				 
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(i));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_reason));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_date_time));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_pract_id));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(Appt_can_remarks));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(Appt_can_reason));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(existing_details[6]));
            _bw.write(_wl_block223Bytes, _wl_block223);
 }
					if(existing_details[60].equalsIgnoreCase("Y")){
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(k));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(k));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(URLEncoder.encode(existing_details[59],"UTF-8")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(k));
            _bw.write(_wl_block224Bytes, _wl_block224);
				}
				}
				//IN057196 Start.
			//IN066709 Starts
				if(existing_details[71].equalsIgnoreCase("N") && recordConsentWithOrder.equalsIgnoreCase("Y") && cnsnt_with_order_yn.equalsIgnoreCase("Y")){
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(k));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(k));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(k));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(k));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[27]));
            _bw.write(_wl_block227Bytes, _wl_block227);
//IN066709 Ends
			}
				//IN057196 End.
			}
   			if(  !(view_by.trim().equals("L"))){
 				 /*canReason = (String[]) bean.getHeaderLineCancelReason(existing_details[9]);Ordered 
                 can_pract_id 		= 	canReason[1];     can_date_time 		= 	canReason[2];  */
				if(existing_details[11].equals("")) {
                 	can_reason		= can_reason;
				}
				else can_reason = existing_details[11]; 
 				if((can_reason==null || can_reason.equals("")) && existing_details[13].equals("HD"))
					can_reason		= last_action_reason_desc;
				if(can_reason==null) can_reason ="";
				// If appointment reason (transfer) is there, put the reason 
				if(appt_resched_reason!=null && !appt_resched_reason.equals("")&&existing_details[6].equalsIgnoreCase("Appt Scheduled"))
					can_reason		= appt_resched_reason;
				if(can_reason!=null && !can_reason.equals(""))
					can_reason		= can_reason.replace('\"','\n');
 				if((existing_details[13].trim()).equals("DC")) { // For Discontinue
 					if(disc_pract_id !=null && !disc_pract_id.equals(""))//IN049203
 						can_pract_id 		= 	disc_pract_id; 
 					if(disc_date_time !=null && !disc_date_time.equals(""))//IN049203
                				can_date_time 		= 	disc_date_time; 
				}
				//IN061903 starts
				if((existing_details[13].trim()).equals("ND")) { // For Not Done
 					if(disc_pract_id !=null && !disc_pract_id.equals(""))
 						can_pract_id 		= 	disc_pract_id; 
 					if(disc_date_time !=null && !disc_date_time.equals(""))
                				can_date_time 		= 	disc_date_time; 
				}
				//IN061903 ends
				
				if(existing_details[13].equals("HC") || existing_details[13].equals("HD"))
					str_value = "Hold";
				else if(appt_resched_reason!=null && !appt_resched_reason.equals("")&& existing_details[6].equalsIgnoreCase("Appt Scheduled"))
					str_value = "Appointment Re-Schedule Reason";
				else if(existing_details[13].trim().equals("DC"))
					str_value = "Discontinue";
				//IN061903 starts
				else if(existing_details[13].trim().equals("ND"))
					str_value = "Not Done";
				//IN061903 ends
				else 
					str_value = "Cancel Reason";
			
				//IN061903 starts
   				//if(( ((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ") || (existing_details[13].trim()).equals("HD") ) || (!appt_resched_reason.equals("")) ) && (  (existing_details[11] != null && !existing_details[11].equals("")) || !can_reason.equals("") )){
				if(( ((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ") || (existing_details[13].trim()).equals("HD") || (existing_details[13].trim()).equals("ND") ) || (!appt_resched_reason.equals("")) ) && (  (existing_details[11] != null && !existing_details[11].equals("")) || !can_reason.equals("") )){
				//IN061903 ends
  				
		
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(i));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_reason));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(i));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_date_time));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(i));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_pract_id));
            _bw.write(_wl_block234Bytes, _wl_block234);
            _bw.write(_wl_block235Bytes, _wl_block235);
		//IN061903 starts
				//} else if( ((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ") || (existing_details[13].trim()).equals("HD") || (!appt_resched_reason.equals(""))) && !can_reason.equals("")) {
				} else if( ((existing_details[13].trim()).equals("CN") || (existing_details[13].trim()).equals("DC") || (existing_details[13].trim()).equals("RD") || (existing_details[13].trim()).equals("RJ") || (existing_details[13].trim()).equals("HD") || (existing_details[13].trim()).equals("ND") || (!appt_resched_reason.equals(""))) && !can_reason.equals("")) {
				//IN061903 ends
				
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(i));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_reason));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(i));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_date_time));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(i));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_pract_id));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(i));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(i));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[13]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block239Bytes, _wl_block239);
} 
			} else {
                //IN061903 starts
				//if (((existing_details[14].trim()).equals("CN") || (existing_details[14].trim().equals("DC")) || (existing_details[14].trim().equals("RD")) || (existing_details[14].trim().equals("RJ")) || (existing_details[14].trim().equals("HD")) ) || (appt_resched_reason!=null && !appt_resched_reason.equals("")) || ((existing_details[24] != null) && (!(existing_details[24]).equals("")))) {
				if (((existing_details[14].trim()).equals("CN") || (existing_details[14].trim().equals("DC")) || (existing_details[14].trim().equals("RD")) || (existing_details[14].trim().equals("RJ")) || (existing_details[14].trim().equals("HD")) || (existing_details[14].trim().equals("ND")) ) || (appt_resched_reason!=null && !appt_resched_reason.equals("")) || ((existing_details[24] != null) && (!(existing_details[24]).equals("")))) {
				//IN061903 ends
                   	can_reason = (existing_details[24]).replace('\"','\n');
					if((can_reason==null || can_reason.equals("")) && (existing_details[14].trim()).equals("HD"))
						can_reason = existing_details[35]; // LAST_ACTION_REASON_DESC
					// If appointment reason (transfer) is there, put the reason
					if(appt_resched_reason!=null && !appt_resched_reason.equals("")&&existing_details[6].equalsIgnoreCase("Appt Scheduled"))
						can_reason		= appt_resched_reason;
					if(can_reason!=null || !can_reason.equals("")) 
						can_reason = can_reason.replace('\"','\n');
  					//IN061903 start
					//if((existing_details[14].trim()).equals("DC")) {
					if((existing_details[14].trim()).equals("DC") || (existing_details[14].trim()).equals("ND")) {
					//IN061903 ends
  						if(existing_details[34] !=null && !existing_details[34].equals(""))//IN049203
							can_pract_id 		= 	existing_details[34]; //disc_pract_id
						if(existing_details[33] !=null && !existing_details[33].equals(""))//IN049203	
							can_date_time 		= 	existing_details[33]; //disc_date_time
					} else if (!appt_resched_reason.equals("")&& existing_details[6].equalsIgnoreCase("Appt Scheduled")) {
						can_date_time 		= 	"";
						can_pract_id 		= 	"";
					}else if(existing_details[14].equals("HC") || existing_details[14].equals("HD")){ //IN042100 new condition for hold
						can_date_time 		= 	existing_details[43];
						can_pract_id 		= 	existing_details[42];
					}else { // For cancel
						can_date_time 		= 	existing_details[31];
						can_pract_id 		= 	existing_details[32];
					}
					
					if(existing_details[14].equals("HC") || existing_details[14].equals("HD"))
						str_value = "Hold";
					else if(appt_resched_reason!=null && !appt_resched_reason.equals("")&& existing_details[6].equalsIgnoreCase("Appt Scheduled"))
						str_value = "Appointment Re-Schedule Reason";
					else if(existing_details[14].trim().equals("DC"))
						str_value = "Discontinue";
					else if(existing_details[14].trim().equals("RD"))
						str_value = "Replaced";
					else if(existing_details[14].trim().equals("RG"))
						str_value = "Registered";
	 				else if(existing_details[14].trim().equals("CN"))
						str_value = "Cancel Reason";
					//IN061903 starts
					else if(existing_details[14].trim().equals("ND"))
						str_value = "Not Done";
					//IN061903 ends
					else
						str_value = existing_details[6];		
							
						
            _bw.write(_wl_block38Bytes, _wl_block38);
 //ML-MMOH-CRF-1617.1 START  
            _bw.write(_wl_block240Bytes, _wl_block240);
 if(!existing_details[6].equalsIgnoreCase("Appt Scheduled")&&!existing_details[6].equalsIgnoreCase("Ordered")){
                 
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(i));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_reason));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_date_time));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_pract_id));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(existing_details[6]));
            _bw.write(_wl_block245Bytes, _wl_block245);
 }	else if(existing_details[0].equalsIgnoreCase("RD")&&existing_details[6].equalsIgnoreCase("Appt Scheduled")&&(!Appt_resched_remarks.equals("")||!appt_resched_reason.equals(""))){
		          	 
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(i));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_reason));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_date_time));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(can_pract_id));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(str_value));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(Appt_resched_remarks));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(existing_details[0]));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(i));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(existing_details[6]));
            _bw.write(_wl_block254Bytes, _wl_block254);
 }//ML-MMOH-CRF-1617.1 END
            _bw.write(_wl_block255Bytes, _wl_block255);
		}
			}
		//--[IN033488]
		StringBuffer error_desc=new StringBuffer();	
		error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
		error_desc.append(" ");
		error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
		error_desc.append(" ");
		
		if(existing_details[13].trim().equals("RM") ||existing_details[13].trim().equals("RS")||existing_details[14].trim().equals("RM") ||existing_details[14].trim().equals("RS")) 
		{
			ErrStatusChk  = bean.getRltNoteSts(existing_details[9],localeName); 		
			
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record 						= (String[])ErrStatusChk.get(j);
					action_type				= bean.checkForNull(record[2],"");
					action_date_time		= bean.checkForNull(record[1],"");
					action_by_id			= bean.checkForNull(record[0],"");
				}
			}
			
			if(action_type.equals("ER"))
			{
			
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(error_desc));
            out.print( String.valueOf(action_by_id));
            _bw.write(_wl_block257Bytes, _wl_block257);

			action_type = "";//IN040198.1
			}
		}
		
		//--[IN033488]
		
            _bw.write(_wl_block258Bytes, _wl_block258);

		if((order_category.equals("PH")|| order_category.equals(""))&&view_by.equals("L"))
		{
			String med_admin_status_imd="";
			String med_admin_status_title="";
			String med_admin_status_text="";
			String med_admin_status = bean.getMedAdminStatus(patientId,encntr_id,facility_id,existing_details[9],existing_details[11]);
			//if(med_admin_status.equals("P"))//IN048935
			//IN061903 starts
			//if(med_admin_status.equals("P") && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]))//IN048935
			if(med_admin_status.equals("P") && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]) && !"ND".equals(existing_details[14]))
			//IN061903 ends
			{
				//med_admin_status_imd="green";//Commentted IN038336
				med_admin_status_imd="yellow";//Changed colour to yellow - IN038336
				med_admin_status_title="In Progress";//Changed from progess to In Progress -IN038336
				med_admin_status_text="In Progress"; //IN038336 - to correct tooltip issue
			}
			//IN061903 starts
			//else if(med_admin_status.equals("C") && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]))//IN048935
			else if(med_admin_status.equals("C") && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]) && !"ND".equals(existing_details[14]))
			//IN061903 ends
			{
				//med_admin_status_imd="yellow"; //Commetted IN038336
				med_admin_status_imd="DarkGreen";//Changed colour to green -IN038336
				med_admin_status_title="Completed";
				med_admin_status_text="Completed";//IN038336
			}
			else
			{
				med_admin_status_imd="";
				med_admin_status_title="";
				med_admin_status_text="";//IN038336
			}
			
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block260Bytes, _wl_block260);

			 //IN061903 starts
			 //if(!med_admin_status.equals("N")&&(!med_admin_status.equals("")) && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]))//IN048935 
			 if(!med_admin_status.equals("N")&&(!med_admin_status.equals("")) && !"DC".equals(existing_details[14]) && !"CN".equals(existing_details[14]) && !"FC".equals(existing_details[14]) && !"ND".equals(existing_details[14]))
			//IN061903 ends
			{
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[7]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(med_admin_status_imd));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(existing_details[7]));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(med_admin_status_title));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(med_admin_status_text));
            _bw.write(_wl_block267Bytes, _wl_block267);
 
			} else {
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block269Bytes, _wl_block269);
      }
		}
            _bw.write(_wl_block270Bytes, _wl_block270);
		
		if (("L".equals(view_by)) && "Y".equals(barcodeSiteSpecificYN))
		{
			if(("Y".equals(existing_details[72])))
			{
		
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(i));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(i));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(i));
            _bw.write(_wl_block275Bytes, _wl_block275);

			}
			else
			{
			
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(i));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(i));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(i));
            _bw.write(_wl_block277Bytes, _wl_block277);

			}
		}
		//IN065942, starts
		if("L".equals(view_by) && "Y".equals(existing_details[74]) && "RG".equals(existing_details[14]))
		{
		
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(i));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(i));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(i));
            _bw.write(_wl_block275Bytes, _wl_block275);

		}
		//else if("L".equals(view_by) && "Y".equals(existing_details[74]) && !"RG".equals(existing_details[14]))
		else if("L".equals(view_by))
		{
		
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block282Bytes, _wl_block282);

		}
		//IN065942, ends
		
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(i));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(i));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(existing_details[11]));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(i));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(i));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(existing_details[12]));
            _bw.write(_wl_block288Bytes, _wl_block288);

		if("L".equals(view_by) && isSiteSpecificBillStatus && !"".equals(billingStatus))
		{
		
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(billingStatus));
            _bw.write(_wl_block59Bytes, _wl_block59);

		}else if("L".equals(view_by)&& isSiteSpecificBillStatus)
		{
		
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block282Bytes, _wl_block282);

		}
//start 68801
existexternalReqFormYN =bean.getExternalRequsitionFormYN(existing_details[9]);
if("H".equals(view_by) ){
if(existexternalReqFormYN.equals("Y")){  
if("H".equals(view_by) && !"RJ".equals(existing_details[13]) && !"PS".equals(existing_details[13]) && !"PO".equals(existing_details[13]) && !"PC".equals(existing_details[13]) && !"CN".equals(existing_details[13]))
{

            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(existing_details[9]));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(existing_details[4]));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(existing_details[13]));
            _bw.write(_wl_block299Bytes, _wl_block299);

}
else{

            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block301Bytes, _wl_block301);
 }
}else{

            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block303Bytes, _wl_block303);
 }
}


            _bw.write(_wl_block304Bytes, _wl_block304);

		if (!function_from.equals("MO")){ //[IN036674]
		
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(i));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(i));
            _bw.write(_wl_block307Bytes, _wl_block307);
//=(printEnable.equals("N"))?"disabled":""
            _bw.write(_wl_block308Bytes, _wl_block308);
}
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(i));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(i));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(existing_details[10]));
            _bw.write(_wl_block311Bytes, _wl_block311);
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(i));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(i));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf((!(view_by.trim().equals("L")))?existing_details[13]:existing_details[14]));
            _bw.write(_wl_block314Bytes, _wl_block314);
	
	src_type = existing_details[16];
	old_category = existing_details[0];
	
	i++;
	}

            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(src_type));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(i));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block322Bytes, _wl_block322);
//=bean.getFunctionId()
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(function_from ));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(p_called_from_ca));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(age));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(encntr_id));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(order_status));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(catalog));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(view));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(date_from));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(date_to));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(cosign));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(curr_sys_date));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(elapsed_orders));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(sys_cancelled_orders));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(from));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(to));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(medico_legal_yn));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(postmortem_status));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(body_part_yn));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(registration_no));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(callingFrom));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(recordConsentWithOrder));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(cnsnt_with_order_yn));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(i));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block368Bytes, _wl_block368);

	//	putObjectInBean(bean_id,bean,request);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderedAt.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderedBy.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MedAdmindetails.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.MARStatus.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BarcodePrint.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.RegisterLabel.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BillingStatus.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
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
}
