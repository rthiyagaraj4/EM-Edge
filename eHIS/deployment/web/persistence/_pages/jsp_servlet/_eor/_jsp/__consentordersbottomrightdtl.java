package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import java.net.URLEncoder;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __consentordersbottomrightdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ConsentOrdersBottomRightDtl.jsp", 1734000156000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name            Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?               created\n02/11/2011    IN29375       Menaka      \tCA >> Record consent\n\t\t\t\t\t\t\t\t\t\t\tFunction pending consent is show code of clinic but system should be show the clinic name same as register order function.\n20/09/2012    IN034888      Chowminya G     CRF-CA- Bru-HIMS-CRF-121/01-Only One Orderable is displayed\n24/09/2012    IN034904      Chowminya G     CRF-CA- Bru-HIMS-CRF-121/03-The Order is not Cancelled after we Record Refusal\n24/04/2013\t  IN029323\t\tKarthi L\t\tSystem displays External order details as \"null\" and unable to Record the Result for that order.\t\n22/07/2013    IN041421      Chowminya G     Special characters - While record consent \"Internal Server Error\" is displayed\n20/08/2013\t  IN038797\t   Karthi L\t\tTo include the field (Filter) of \"Speciality\" in the function of \"Pending Consent\" in Practitioner\'s homepage\n19/12/2013    IN045800\t    Dinesh T\t\tCA>Chart Summary>Orders>Place a radiology order which requires consent to be recorded>Pending/Record Consent>Click on \'Radiology\' category>System throws an error message.\n21/10/2015    IN057196\t    Ramesh G\t\tRecording Of Consent Form\n---------------------------------------------------------------------------------------------------------------\n--> \n ";
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

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../js/ConsentOrder.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryToolTip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\tfunction hideToolTip(obj,imgObj,row)\t\n\t{\n\t\tdynamichide(obj, window.event,row);\n\t  /*document.getElementById(\"tooltiplayer\").style.visibility = \'hidden\'\n\t   if (obj != null)\n\t  {\n\t\t\tobj.className = \'gridDataBlue\';\n\t\t\teval(\"document.all.\"+imgObj).src = \"../../eCommon/images/inactiveArrow.gif\";\n\t  }*/\t\n\t}\n\n\tfunction callMouseOver(obj)\t\n\t{\n\t\tcurrClass = obj.className ;\n\t\tobj.className = \'selectedcontextMenuItem\';\n\t}\n\n\tfunction callOnMouseOut(obj)\n\t{\n\t\tobj.className = \'contextMenuItem\';\n\t}\n\n\tfunction resizeWindow(orderctlHDR)\n\t{\n\t\tvar orderctlHDR1 = orderctlHDR.id;\n\t\tvar wdth = document.getElementById(orderctlHDR1).offsetWidth;\n\t\tvar hght1 = document.getElementById(orderctlHDR1).offsetHeight;\t\t\t\t\n\t\tvar wdth1 = getPos(orderctlHDR).x +wdth;\n\t\tvar hght = getPos(orderctlHDR).y ;\t\n\t\tbodwidth  = document.body.offsetWidth\n\t\tbodheight = document.body.offsetHeight\t\t\n\t\tvar z = bodwidth- (event.x + wdth);\t\t\t\t\n\t\tvar x \t  = event.x;\n\t\tvar y \t  = event.y;\t\n\t\tx \t  = x + (document.getElementById(\"tooltiplayer\").offsetWidth);\n\t\ty \t  = hght + (document.getElementById(\"tooltiplayer\").offsetHeight);\n\t\tif(x<bodwidth)\n\t\t{\n\t\t\tx= wdth1;\t\t\t\n\t\t}\n\t\telse\n\t\t{\t\t\t\n\t\t\tx = getPos(orderctlHDR).x;\n\t\t}\n\t\tif(y<bodheight)\n\t\t{\t\t\t\n\t\t\ty = hght;\t\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight*2) + hght1 ;\t\n\t\t}\t\n\t\ty += 65;\n\t\tdocument.getElementById(\"tooltiplayer\").style.posLeft= x+\"px\";\n\t\tdocument.getElementById(\"tooltiplayer\").style.posTop = y+\"px\";\n\t\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'visible\'\n\t}\n\t//--[IN034904]\t- passing p/m consentLinenum\n\tfunction displayToolTip(val,val1,orderId,sex,patient_id,patient_class,source_type,source_code,encounter_id, order_type_code,location_type,location_code,priority,ord_line_num,orderctlHDR,imgObj,consentLinenum) \n\t{\t\t\t\n\t\tcallMouseOverOnTD(orderctlHDR,imgObj);\n\t\tbuildTable (val,val1,orderId,sex,patient_id,patient_class,source_type,source_code,encounter_id,order_type_code,location_type,location_code,priority,ord_line_num,consentLinenum)\n\t\tresizeWindow(orderctlHDR)\n\t}\n\n\tfunction buildTable(val,val1,orderId,sex,patient_id,patient_class,source_type,source_code,encounter_id,order_type_code,location_type,location_code,priority,ord_line_num,consentLinenum) \n\t{\n\t\tvar rowval   = val.split (\",\");\n\t\tvar row      = (\"View,Refusal,\");\n\t\trowval1      = row.split(\",\");\n\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n\t\tfor( var i=0; i<rowval.length; i++ ) \n\t\t{\n\t\t\tvar colval  = rowval[i]\n\t\t\tvar colval1 = rowval1[i];\n\t\t\tif (colval != \"\")\n\t\t\t{\n\t\t\t\ttab_dat     += \"<tr>\"\n\t\t\t\tif(colval1 == \"Reprint\")\n\t\t\t\t{\n\t\t\t\t\t//tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:callAmmendFunctions(\'\"+orderId+\"\',\'\"+patient_id+\"\',\'\"+encntr_id+\"\',\'\"+pract_reln_id+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+patient_class+\"\',\'\"+p_called_from_ca+\"\',\'\"+sex+\"\',\'\"+age+\"\',\'\"+dob+\"\',\'\"+escape(visit_adm_date)+\"\',\'\"+iv_prep_yn+\"\')><B>\"+colval+\" </B></a></td>\"\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a  class= \'contextMenuLink\' href=javascript:callReprinting(\'\"+orderId+\"\',\'\"+patient_class+\"\',\'\"+source_type+\"\',\'\"+source_code+\"\')>\"+colval+\" </a></td>\"\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+sex+\"\',\'\"+patient_id+\"\',\'\"+encounter_id+\"\',\'\"+patient_class+\"\',\'\"+order_type_code+\"\',\'\"+location_type+\"\',\'\"+location_code+\"\',\'\"+priority+\"\',\'\"+ord_line_num+\"\',\'\"+consentLinenum+\"\')>\"+colval+\" </a></td>\"\n\t\t\t\t}\n\t\t\t\ttab_dat     += \"</tr> \"\n\t\t\t}\n\t\t}\n\t\ttab_dat     += \"</table> \"\n\t\tdocument.getElementById(\"t\").innerHTML = tab_dat;\n\t}\t\n\n\tfunction moveFrame()\n\t{\n\t\tparent.ConsentOrdersBottomRight0.document.body.scrollLeft= document.body.scrollLeft;\n\t}\n\n\tfunction alignHeading()\n\t{\n\t\tif(parent.ConsentOrdersBottomRight0)\n\t\t{\n\t\t\tif(parent.ConsentOrdersBottomRight0.document.getElementById(\"TitleTab\") != null) \n\t\t\t{\n\t\t\t\t\n\t\t\t\tparent.ConsentOrdersBottomRight0.document.getElementById(\"TitleTab\").width =\teval(document.getElementById(\"consent_table\").offsetWidth);\n\t\t\t\t\n\t\t\t\tvar last_row = eval(document.getElementById(\"consent_table\").rows.length)-1;\n\t\t\t\tfor (j=0; j < document.getElementById(\"consent_table\").rows[last_row].cells.length; j++) \n\t\t\t\t{\n\t\t\t\t\tvar wid=eval(document.getElementById(\"consent_table\").rows[last_row].cells[j].offsetWidth);\n\t\t\t\t\tif(parent.ConsentOrdersBottomRight0.document.getElementById(\"TitleTab\").rows[0].cells[j] != null)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.ConsentOrdersBottomRight0.document.getElementById(\"TitleTab\").rows[0].cells[j].width=wid;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tsetTimeout(\"alignHeading();\",300);\n\t\t\t}\n\t\t}\n\t}\n\t</script>\n\t<STYLE TYPE=\"text/css\">\n\tA:link\n\t {\n\t\t COLOR: blue;\n\t }\n\tA:visited\n\t {\n\t\t COLOR: blue ;\n\t }\n\tA:active\n\t {\n\t\t COLOR: red;\n\t }\n   TD.TDHEADER\n\t{\n\t   BACKGROUND-COLOR: #404040;\n\t   COLOR: white ;\n\t   FONT-SIZE: 8pt;\n\t   FONT-WEIGHT: bolder;\n\t}\n\t</STYLE>\n \t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n</head>\n<body  onscroll=\'processScroll()\' onload=\'FocusFirstElement();alignHeading()\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form name=\'consent_order_dtl\' id=\'consent_order_dtl\'  action=\"../../eOR/jsp/ConsentOrdersBottomRightDtl.jsp\" method=\"post\" >\n<div id=\"divHeadSep\" style=\"position: absolute;\">\n\t<table cellpadding=0 cellspacing=0 border=1 width=\"100%\" id=\'consent_table\' class=\"grid\">\n\t\t<tr id=\"heading\">\n\t\t   <th width=\'3%\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;&nbsp;</th><!-- added for multi consent on 04/05/2007 -->\n\t\t\t<td class=COLUMNHEADER width=\'17%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td class=COLUMNHEADER  width=\'10%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td><!-- added for multi consent on 04/05/2007 -->\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<td class=COLUMNHEADER width=\'15%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<td class=COLUMNHEADER width=\'18%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td class=COLUMNHEADER width=\'20%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td class=COLUMNHEADER width=\'30%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\t\n\t\t\t\t\t<tr align=\"right\">\n\t\t\t\t\t\t<td colspan=\"11\">\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' width=\'3%\'><label class=\'label\'><B>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =".</B>&nbsp;</label></td>\n\t\t\t\t<input type=\"hidden\" name=\"consent_form_list";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"consent_form_list";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t\t\t<td  width=\'17%\' id=\"status";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'><font size=\"1\">\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:showConsentReview(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\', \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\')\" title=\'Recorded  Consent\' style=\"COLOR:#CC3300;\"><B>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =".";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</B></A><BR>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<!-- <script>consented_array[\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"] = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";</script> -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t<A class=\"gridLink\"  HREF=\"javascript:showConsentReview(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</B></A><BR>\t\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- <script>consented_array[\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"recd_consent_id";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"recd_consent_id";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" value=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="><input type=checkbox name=\'chk";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'chk";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' value=\'\' onClick=\"noPermission1(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\"><A  class=\'gridLink\' id=\'details";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'style=\"visibility:hidden\" HREF=\"javascript:displayDetails(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',true)\" title=\"Preview Consent Form for ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"><font size=\"1\"><!-- Details --><B>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</B></A><label id=\'multi_consent";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' class=\'label\'><font size=1 color=\'\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"recd_consent_id";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' value=\'\' onClick=\"displayDetails(";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =",false)\"><A  class=\'gridLink\' id=\'details";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="<BR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="  \n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"consent_stage";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"consent_stage";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" value=\"\">\n\t\t\t\t\t\t\t<select style=\'font-size:8pt\' name=\'consent_form_id";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'consent_form_id";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onChange=\"chkConsented(this,\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\');clearConsents(\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\',\'Select\');\"><option value=\"\">--- ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" ---</option>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<option style=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</option>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:noPermission()\" title=\'Consent to be Recorded\'>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</A>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:displayDetails(\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\',true)\" title=\'Consent to be Recorded\'>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"consent_form_id";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"consent_form_id";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"consent_stage";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:noPermission()\" title=\'Consent to be Recorded\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</A>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\t\n\t\t\t\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:displayDetails(\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"consent_form_id";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"consent_stage";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:noPermission()\" title=\'Consent to be Recorded\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</A>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:displayDetails(\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"consent_form_id";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"consent_stage";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"consent_stage";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\');reccheck(this,\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\',\'Select\');\">\n\t\t\t\t\t\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" ---</option>\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t\t\t<option style=\'background-color:#FFA8A8;color:#000000\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t\t\t<option style=\'background-color:LightGrey;color:#000000\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t\t\t\t<option style=\'\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</option>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t\t\t\t<option style=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</option>\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:noPermission()\" title=\'Consent to be Recorded\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</A>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:displayDetails(\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</A>";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"consent_form_id";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">  \n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"consent_stage";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:noPermission()\" title=\'Consent to be Recorded\'>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</A>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:displayDetails(\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\"noteligible_consent_id";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" id=\"noteligible_consent_id";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t\t\t\t\t\t</label>\n\t\t\t\t\t\t<!-- <div ALIGN=\'right\' CLASS=\'label\' id=\'link_consent";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' title=\'Link Consent\' style=\"visibility:";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"> uncomment when link consent link is required nd remove teh below line-->\n\t\t\t\t\t\t<div ALIGN=\'right\' CLASS=\'label\' id=\'link_consent";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' title=\'Link Consent\' style=\"visibility:hidden\">\n\t\t\t\t\t\t\t<A class=\"gridLink\" HREF=\"javascript:linkConsents(\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\')\"><FONT SIZE=\"1\" >";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</A>\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<!-- <A  id=\'details";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\')\" title=\"Preview Consent Form\"><FONT SIZE=\"1\">Details</FONT></A> --></td>  <!-- ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="- kept for testing the status DR/CR/DO/CO -->\n\t\t\t\t\t\t\t<!-- Details() -->\n\t\t\t\t\t\t<td width=\'10%\' class=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'><font color=\"#000099\"><B>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="<BR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t\t\t\t\t\t&nbsp;&nbsp;";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="&nbsp;(";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="/";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =")<BR>&nbsp;&nbsp;";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =":&nbsp;(";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =")\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t\t\t\t\t\t\t<BR><BR><A class=\'gridLink\' id=\'multi_label";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' HREF=\"javascript:callMultipleConsents(\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\',\'\',\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\')\">";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</A> <!-- IN041421 -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t\t</B>\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t\t<td width=\'13%\' class=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t\t<td width=\'13%\' class=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td> <!--  data of ordered AT -->\n\t\t\t\t<!--<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\')\"  >";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</a></td>-->\n\t\t\t\t\t<!--  data of ordered Catalogs -->\n\t\t\t\t<!-- <td width=\'20%\' nowrap id=\'orderctl";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\' class=\'gridDataBlue\' style=\'cursor:pointer\' onClick=\"displayToolTip(\'\'+getLabel(\'Common.view.label\',\'Common\')+\',\'+getLabel(\'eOR.Refusal.label\',\'OR\')+\'\',\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\',this,\'imgArrow";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\')\"  onMouseOver=\"hideToolTip(this,\'imgArrow";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\')\" >\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="<img align=\'right\' src=\"../../eCommon/images/inactiveArrow.gif\" name=\"imgArrow";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\"> -->\n<td width=\'20%\' nowrap id=\'orderctl";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\')\" onmouseover=\"hideToolTip(this,\'imgArrow";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\')\">\n  <a href=\"javascript:displayToolTip(\'\'+getLabel(\'Common.view.label\',\'Common\')+\',\'+getLabel(\'eOR.Refusal.label\',\'OR\')+\'\',\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\')\"  \n     >\n    ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n    <img align=\'right\' src=\"../../eCommon/images/inactiveArrow.gif\" name=\"imgArrow";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" id=\"imgArrow";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n  </a>\t\t\t\t\n</td><!--  data of ordered Catalogs //added consentLinenum --[IN034904]-->\n\t\t\t\t<td width=\'30%\' class=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="<BR>";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</td><!--  data of ordering locn details -->\n\t\t\t\t\n\t\t\t\t<input type=hidden name=\'patient_name";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' id=\'patient_name";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t\t\t\t<input type=hidden name=\'ord_typ_code";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' id=\'ord_typ_code";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t\t\t\t<input type=hidden name=\'ord_status";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' id=\'ord_status";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t\t\t\t<input type=hidden name=\'ord_consent_yn";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' id=\'ord_consent_yn";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t\t\t\t<input type=hidden name=\'ord_id";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' id=\'ord_id";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t\t\t\t<input type=hidden name=\'ord_line_num";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' id=\'ord_line_num";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t\t\t\t<input type=hidden name=\'appt_reqd_yn";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' id=\'appt_reqd_yn";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t\t\t\t<input type=hidden name=\'order_pract_name";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' id=\'order_pract_name";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t\t\t\t<input type=hidden name=\'cont_order_ind";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' id=\'cont_order_ind";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ord_appr_by_user_id";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" id=\"ord_appr_by_user_id";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ord_appr_reqd_yn";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" id=\"ord_appr_reqd_yn";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ord_consent_by_id";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\" id=\"ord_consent_by_id";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"ord_consent_reqd_yn";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" id=\"ord_consent_reqd_yn";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"order_catalog_code";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" id=\"order_catalog_code";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\t\t\t\t\n\t\t\t\t<input type=hidden name=\'patientdetails";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' id=\'patientdetails";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t\t\t\t<input type=hidden name=\'order_category";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' id=\'order_category";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'>\n\t\t\t\t<input type=hidden name=\'ord_catalog_desc";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' id=\'ord_catalog_desc";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'>\n\t\t\t\t<input type=hidden name=\'pat_class";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\' id=\'pat_class";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'>\n\t\t\t\t<input type=hidden name=\'pat_id";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\' id=\'pat_id";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'>\n\t\t\t\t<input type=hidden name=\'priority";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\' id=\'priority";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'>\n\t\t\t\t<input type=hidden name=\'location_type";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\' id=\'location_type";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\'>\n\t\t\t\t<input type=hidden name=\'location_code";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\' id=\'location_code";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\'>\n\t\t\t\t<input type=hidden name=\'encount_id";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\' id=\'encount_id";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'>\n\t\t\t\t<input type=hidden name=\'ord_auth_reqd_yn";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\' id=\'ord_auth_reqd_yn";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\'>\n\t\t\t\t<input type=hidden name=\'ord_auth_by_pract_id";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\' id=\'ord_auth_by_pract_id";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>\n\t\t\t\t<input type=\"hidden\" name=\"link_ref_no";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\" id=\"link_ref_no";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"link_ref";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\" id=\"link_ref";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"link_ref_det";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\" id=\"link_ref_det";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\" value=\"\">\n\t\t\t\t<input type=hidden name=\'con_bo_cnt";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\' id=\'con_bo_cnt";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t\t\t\t<input type=hidden name=\'con_br_cnt";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\' id=\'con_br_cnt";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n\t\t\t\t<!-- <input type=hidden name=\'con_rbo_cnt";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\' id=\'con_rbo_cnt";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\"> -->\n\t\t\t\t<input type=hidden name=\'con_rbo_cnt";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\n\t\t\t\t<!-- <input type=hidden name=\'con_rbr_cnt";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\' id=\'con_rbr_cnt";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n\t\t\t\t --><input type=hidden name=\'con_rbr_cnt";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n\t\t\t\t<input type=\'hidden\' name=\"con_id";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" id=\"con_id";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\">\n\t\t\t\t<input type=\'hidden\' name=\"con_stage";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\" id=\"con_stage";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\">\n\t\t\t\t<input type=\'hidden\' name=\"order_set_id";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" id=\"order_set_id";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n\t\t\t\t<!--<input type=hidden name=\'pat_name";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\' id=\'pat_name";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\' value=\'\'>\n\t\t\t\t<input type=hidden name=\'Practioner_name";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\' id=\'Practioner_name";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\' value=\'\'>\n\t\t\t\t<input type=hidden name=\'dat_time";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\' id=\'dat_time";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\' value=\'\'>\n\t\t\t\t<input type=hidden name=\'remarks";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\' id=\'remarks";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\' value=\'\'>\n\t\t\t\t<input type=hidden name=\'ord_pract";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\' id=\'ord_pract";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\' value=\'\'>\n\t\t\t\t<input type=hidden name=\'Consent_detail";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\' id=\'Consent_detail";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\' value=\'\'>\n\t\t\t\t<input type=hidden name=\'self";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\' id=\'self";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\' value=\'\'>\n\t\t\t\t<input type=hidden name=\'relation";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\' id=\'relation";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\' value=\'\'>\n\t\t\t\t<input type=hidden name=\'relation_text";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\' id=\'relation_text";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\' value=\'\'>\n\t\t\t\t<input type=hidden name=\'orderable_val";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\' id=\'orderable_val";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\' value=\'\'>-->\n\t\t\t</tr>\n\t\t\t<SCRIPT>\n\t\t\t\tdefaultSelect(\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\");\n\t\t\t</SCRIPT>\n\t\t";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n</table>\n<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\">\n<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\">\n <input type=hidden name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\'>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\">\n<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n<input type=\"hidden\" name=\"practitioner_name\" id=\"practitioner_name\" value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\">\n<input type=\"hidden\" name=\"security_level\" id=\"security_level\" value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\">\n<input type=\"hidden\" name=\"curr_sys_date\" id=\"curr_sys_date\" value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\">\n<!--<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"\">--><!--returned frm modal window-->\n<input type=\"hidden\" name=\"source_type\" id=\"source_type\" value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\">\n<input type=\"hidden\" name=\"source_code\" id=\"source_code\" value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\">\n<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\">\n<input type=\"hidden\" name=\"ord_cat\" id=\"ord_cat\" value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\">\n<input type=\"hidden\" name=\"order_by\" id=\"order_by\" value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\">\n<input type=\"hidden\" name=\"ord_cat_desc\" id=\"ord_cat_desc\" value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\">\n<input type=\"hidden\" name=\"priority_desc\" id=\"priority_desc\" value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\">\n<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\">\n<input type=\"hidden\" name=\"period_from\" id=\"period_from\" value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\">\n<input type=\"hidden\" name=\"period_to\" id=\"period_to\" value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\">\n<!-- Added by kishore kumar N on 30-Oct-09  for CRF 15741 -->\n<input type=\"hidden\" name=\"qryString\" id=\"qryString\" value=\"";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\">\n<!-- ends here. -->\n<!-- <input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\"> -->\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute;left:77%;top:42%; width:10%; visibility:hidden;\' bgcolor=\'blue\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div>\n</form>\n</body>\n<script>\n\tparent.parent.parent.ConsentOrderTop.document.consent_order.search_btn.disabled = false;\n</script>\n</html>\n";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);

	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */

	try
	{
	 /*Added by kishore kumar N on 30-Oct-09  for CRF 15741*/
	String qryString = request.getQueryString()== null?"":request.getQueryString();
	/* ends here.*/
	
	String mode	   = "1" ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";	//String disabled = "" ;
//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String practitioner_name = (String)session.getValue("practitioner_name");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String practitioner_type = (String)session.getValue("practitioner_type");
	String patientdetails="";
	//String[] allsess_vals = (String[])session.getValueNames();
//	for(int i=0; i<allsess_vals.length; i++)
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	String security_level = "";
	security_level = (String)session.getValue("security_level");
	if(security_level == null)
		security_level  = "1"; // needs to be replaced with session values	
	String source_type		= request.getParameter( "source_type" ) ;
	String source_code		= request.getParameter( "source_code" ) ;
	String priority			= request.getParameter( "priority" ) ;
	String ord_cat			= request.getParameter( "ord_cat" ) ;
	String order_by			= request.getParameter( "order_by" ) ;
	String ord_cat_desc		= request.getParameter( "ord_cat_desc" ) ;
	String priority_desc	= request.getParameter( "priority_desc" ) ;
	String total_recs		= request.getParameter( "total_recs" ) ;
	String patientId		= request.getParameter( "patientId" );
	String period_from		= request.getParameter( "period_from" );
	String period_to		= request.getParameter( "period_to" );
	String consentRec_order_id = request.getParameter("consentRec_order_id")== null?"":request.getParameter("consentRec_order_id"); //IN057196
	String speciality_code  = request.getParameter( "speciality_code" )== null?"":request.getParameter( "speciality_code" ); //added for BRU-HIMS-CRF-359 [IN038797]
	String total_query_records  = "0";
	String function_id		= request.getParameter("function_id");
	StringBuffer con_id=new StringBuffer();
	StringBuffer con_stage=new StringBuffer();
	String encounter_dtls="";
	String consent_req_bef_order="";
	String consent_req_bef_regn="";
	String consentLinenum = "";//--[IN034904]

 	//int total_records = 0;
	if(function_id == null) function_id =""; else function_id = function_id.trim();
	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =" "; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =" "; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =" "; else period_to = period_to.trim();
	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
	if(total_recs== null) total_recs="" ;

	ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id, bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(localeName);
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to);
 	//if(from!=null && from.equals("1")) {
 	bean.clear() ;
	//}
	bean.setMode( mode ) ;
	bean.clearHash();	 
	String slClassValue = "";
	//String classValue = "";
	//int total = 0;
//	ArrayList StatusDetail = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,resp_id,priority,ord_cat,order_by,patientId) ;

	ArrayList StatusDetail = new ArrayList();
//	if(from!=null && from.equals("1")){
	//StatusDetail		   = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type) ; //commented for BRU-HIMS-CRF-359 [IN038797]	
	//IN057196 Start.
			//StatusDetail		   = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type, speciality_code) ; //added for BRU-HIMS-CRF-359 [IN038797]
			StatusDetail		   = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type, speciality_code, consentRec_order_id) ;
	//IN057196 End.				
	//bean.setDetails(StatusDetail);
	//}else{
	//StatusDetail=bean.getDetails();
	//}
	 ArrayList multiConsentList = new ArrayList();
	 ArrayList multiNonAssConsentList = new ArrayList();
	String[] multiConsentDtls = null;
	String order_catalog_code ="";
	String checkcolor="";	
	String curr_sys_date ="";
	//String last_week_date ="";
	//String curr_week_date ="";
	ArrayList sysdate = (ArrayList)bean.getSysDateTime();
	for(int i=0;i<sysdate.size();i++)
	{
		//last_week_date =  (String)sysdate.get(0);
		//curr_week_date =  (String)sysdate.get(1);
		curr_sys_date=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName);
	}

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			if((order_by.equals(" ")||(order_by.equals("P"))) && ord_cat_desc.equals(""))
			{
			
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
			if((order_by.equals(" ")||(order_by.equals("O"))) && priority_desc.equals(""))
			{	
			
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
			
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

		String tmp_ord_cat = "";
		String tmp_pat_id = "";
		String tmp_urgency = "";
		String fontValue ="";
		String cont_order_ind = "";
		String ord_appr_by_user_id = "";
		String ord_appr_reqd_yn = "";
		String ord_consent_reqd_yn = "";
		String ord_consent_by_id = "";
		String location="";//IN29375
		StringBuffer recd_consent_id = null;
		int i= 0;
		int bo_cnt,br_cnt= 0;
		int con_bo_cnt,con_br_cnt= 0;
		int scon_bo_cnt,scon_br_cnt= 0;
		String stage_label = "";
		//String define_label = "Define";
		String define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Define.label","common_labels");	
		boolean stage_label_count = false;
		String tdClassValue = "";
		StringBuffer noteligible_consent_id = null;
		//ArrayList consentedList = new ArrayList();
		/*if(StatusDetail.size() < 7 || end > StatusDetail.size()) {
			end = StatusDetail.size();
		}	*/
		//for( int i=0 ; i< StatusDetail.size() ; i++ ) {
		for( int k=0 ; k< StatusDetail.size() ; k++ ) 
		{
			slClassValue="gridData";
			String slClassValueTmp = slClassValue;
			String[] record = (String[])StatusDetail.get(k);
			if(record[2].compareTo("R")==0)
			{
				record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			}
			else if(record[2].compareTo("U")==0)
			{		 
				record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");	
			}
			else if(record[2].compareTo("S")==0)
			{
				record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
			}	
			if(k==0)
			{
				if(record[30] != null)//IN29375
					total_query_records = bean.checkForNull((String)record[30],"0");//IN29375
				if((Integer.parseInt(total_query_records)>0) || (start>1))
				{
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("chk")},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("qryString"), weblogic.utils.StringUtils.valueOf(qryString
                        )},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("consent_order_dtl")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block23Bytes, _wl_block23);

				}				
				if(!priority.equals(" ") || !ord_cat.equals(" ") )
				{
					if(!(priority.equals(" ")))
					{
						if(priority.equals("U"))
						{
							out.println("<tr><td align=left class='ORRED' colspan=7>"+priority_desc+"</td>");
						}else if(priority.equals("S"))
						{
							out.println("<tr><td align=left class='ORBROWN' colspan=7>"+priority_desc+"</td>");
						}else if(priority.equals("R"))
						{
							out.println("<tr><th align=left colspan=7>"+priority_desc+"</td>");
						}
					}
					if(!(ord_cat.equals(" ")))
					{
						out.println("<tr><th align=left colspan=7>"+ord_cat_desc+"</td>");
					}					
				}
			}
			//String[] record = (String[])StatusDetail.get(i);
			cont_order_ind = (String)record[14];
			String sex1;
			sex1="";
			if (record[19].equalsIgnoreCase("M"))
			  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		  else if(record[19].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			patientdetails=record[20]+","+sex1+"/"+record[27]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[6];
			//IN29375 Starts
			if(record[10].equalsIgnoreCase("C"))
			{
						location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(record[10].equalsIgnoreCase("N"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}
			else if(record[10].equalsIgnoreCase("R"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}
			else if(record[10].equalsIgnoreCase("E"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
			}
			// added for IN029323 - Start
			if(record[7] == null )
			{
				record[7] = "";
			}
			if(record[29] == null )
			{
				record[29] = "";
			}
			//IN029323 - End
			//encounter_dtls=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+record[7]+","+record[10]+"/"+record[11];
			encounter_dtls=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+record[7]+","+location+"/"+record[29];
			System.out.println("424 encounter_dtls===="+encounter_dtls);
			//IN29375 Ends
			//patientdetails=(String)record[11];
			//the following 2 if conditions are used to display in "group BY"
			if(patientId.trim().equals("") && !(tmp_pat_id.equals(record[6])))
			{
				if(!ord_cat.equals(" ") || !priority.equals(" ") )
					out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan=7 align=left><B> "+patientdetails+"</B></td></tr>");
				else
				out.println("<tr><th  colspan=7 style='border-right:0px' align=left><B> "+patientdetails+"</B></th>");
				tmp_pat_id = record[6];
				tmp_ord_cat="";tmp_urgency="";
			}
			if(patientId.trim().equals(""))
				tdClassValue = "CAHIGHERLEVELCOLOR" ;
			else
				tdClassValue = "TDHEADER" ;
			//format of order category or urgency
			if(!(tmp_ord_cat.equals(record[1])) && (!(order_by.equals(" ") ||(order_by.equals("P")))))
			{
				out.println("<tr><td class='"+tdClassValue+"' colspan=7 style='border-right:0px' align=left>"+record[1]+"</td>");
				tmp_ord_cat = record[1];				
			}
			if(!(tmp_urgency.equals(record[2])) && (!(order_by.equals(" ") ||(order_by.equals("O")))))
			{	
				out.println("<tr><td class='"+tdClassValue+"'  colspan=7 style='border-right:0px' align=left>"+record[2]+"</td>");
				tmp_urgency = record[2];				
			}
			ord_appr_by_user_id	 = (String)record[16];
			ord_appr_reqd_yn	 = (String)record[15];
			ord_consent_reqd_yn	 = (String)record[17];
			ord_consent_by_id	 = (String)record[18];
			//order_catalog_code	 ="MULTICONSE";// (String)record[29];
			order_catalog_code	=(String)record[24];
			stage_label			 = "";
			recd_consent_id		 = new StringBuffer();
			noteligible_consent_id = new StringBuffer();
		//	noteligible_consent_id = "";
			bo_cnt				 = 0;con_bo_cnt = 0;scon_bo_cnt=0;
			br_cnt				 = 0;con_br_cnt = 0;scon_br_cnt=0;
			stage_label_count	 = false;
			define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Define.label","common_labels");
			/*********SRR20056-SCF-2009  Id:  3736 *****start***05/06/2008****/
			String multiConsentLine[] = new String[4];
			multiConsentLine=bean.MultiListConsentsLine((String)record[5],(String)record[25]);	consent_req_bef_order = (String) multiConsentLine[2];
			consent_req_bef_regn = (String) multiConsentLine[3];	/*********SRR20056-SCF-2009  Id:  3736 *****end***05/06/2008****/

			multiConsentDtls	 = bean.MultiListDtls(order_catalog_code, practitioner_id);

			
			multiConsentList	 = bean.MultiListConsentsdtl(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);
			if(multiConsentList.size()==0)
			{
				multiConsentList	 = bean.MultiListConsents(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);
			}
			multiNonAssConsentList = bean.MultiListConsentsNotAssociated(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);			
			
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multiConsentDtls[0]));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(multiConsentDtls != null && multiConsentList.size() > 0 )
					{
						int srl =0;
						for(int j=0;j<multiConsentList.size();j++)
						{
							String[] consentedarray = (String[])multiConsentList.get(j);
							if(consentedarray[10].equals("Y"))
							{
								//if(consentedarray[3].equals("A"))con_bo_cnt++;
								//if(consentedarray[3].equals("R"))con_br_cnt++;
								recd_consent_id.append(consentedarray[1]);
								recd_consent_id.append("~");
								//recd_consent_id += consentedarray[1] +"~" ;
								
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(consentedarray[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(consentedarray[2]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(consentedarray[11]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(++srl));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(consentedarray[2]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(consentedarray[1]));
            _bw.write(_wl_block39Bytes, _wl_block39);
	
							}
						}
					}else if(multiNonAssConsentList != null && multiNonAssConsentList.size() > 0 )
					{
						int srl =0;
						for(int j=0;j<multiNonAssConsentList.size();j++)
						{
							String[] consentedarray = (String[])multiNonAssConsentList.get(j);
							if(consentedarray[10].equals("Y"))
							{
								if(consentedarray[3].equals("A"))con_bo_cnt++;
								if(consentedarray[3].equals("R"))con_br_cnt++;

								recd_consent_id.append(consentedarray[1]);
								recd_consent_id.append("~");
								//recd_consent_id += consentedarray[1] +"~" ;
								
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(consentedarray[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(consentedarray[2]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(consentedarray[11]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(++srl));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(consentedarray[2]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(consentedarray[1]));
            _bw.write(_wl_block39Bytes, _wl_block39);
 
							}
						}
					}
					if(multiConsentDtls[6].equals("N"))
					{
					
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(recd_consent_id.toString()));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((record[9].substring(1,(record[9].length()-1)))));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);

					}
					else
					{
					
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(recd_consent_id.toString()));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((record[9].substring(1,(record[9].length()-1)))));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);

					}
					
            _bw.write(_wl_block57Bytes, _wl_block57);
if(multiConsentDtls != null && multiConsentDtls.length >0 )
					{
						stage_label = multiConsentDtls[4];					
						////if( multiConsentDtls[0].equals("F") && ( (Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1) || (Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2]) > 1) ) ){//changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008
						if( multiConsentDtls[0].equals("F") && ( (Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1) || (Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn) > 1) ) )
						{
							stage_label_count = true;
							
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
	
							if(multiConsentList.size() > 0)
							{
								for(int j=0;j<multiConsentList.size();j++)
								{
									String[] multiConsentValues = (String[])multiConsentList.get(j);									
									if(multiConsentValues[10].equals("Y"))
									{
										if(multiConsentValues[3].equals("A"))con_bo_cnt++;
										if(multiConsentValues[3].equals("R"))con_br_cnt++;
									}
									if(multiConsentValues[12].equals("N"))
									{
										//noteligible_consent_id  += multiConsentValues[1] +"~" ;
										noteligible_consent_id.append(multiConsentValues[1]);
										noteligible_consent_id.append("~");
									}
									//	if(multiConsentValues[9].equals("Y"))
									{
											if(multiConsentValues[3].equals("A"))bo_cnt++;
											if(multiConsentValues[3].equals("R"))br_cnt++;								
									
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(((multiConsentValues[10].equals("Y"))? "background-color:#FFA8A8;color:#000000":"")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf((multiConsentValues[12].equals("N"))? "  (*)":""));
            _bw.write(_wl_block69Bytes, _wl_block69);
			
										//define_label = "View Consents";
										define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewConsents.label","or_labels");
									}
								}if(!(bo_cnt >0 || br_cnt >0))
								{
									out.println("<script>document.getElementById('consent_form_id'+i).style.visibility = 'hidden';</script>");
								}
							}
							else
							{
								out.println("<script>document.getElementById('consent_form_id'+i).style.visibility = 'hidden';</script>");
							}
							
            _bw.write(_wl_block70Bytes, _wl_block70);

						}
						else if( multiConsentDtls[0].equals("F"))
						{ 
							if(!multiConsentDtls[5].equals("") && !multiConsentDtls[3].equals(""))
							{ 
								define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewConsents.label","or_labels");
								if(multiConsentDtls[6].equals("N"))
								{
									//noteligible_consent_id  += multiConsentDtls[3] +"~" ;
									noteligible_consent_id.append(multiConsentDtls[3]);
									noteligible_consent_id.append("~");
								}
								if(multiConsentDtls[6].equals("N"))
								{
								
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(multiConsentDtls[5]));
            out.print( String.valueOf(multiConsentDtls[6].equals("N")?"(*)":""));
            _bw.write(_wl_block72Bytes, _wl_block72);

								}
								else
								{
								
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(multiConsentDtls[5]));
            out.print( String.valueOf(multiConsentDtls[6].equals("N")?"(*)":""));
            _bw.write(_wl_block72Bytes, _wl_block72);

								}
								
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multiConsentDtls[3]));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multiConsentDtls[4]));
            _bw.write(_wl_block78Bytes, _wl_block78);
	
							}else if(multiConsentList.size() > 0)
							{
								for(int j=0;j<multiConsentList.size();j++)
								{
									String[] multiConsentValues = (String[])multiConsentList.get(j);											
									if(multiConsentValues[9].equals("Y") && !multiConsentValues[9].equals("Y"))
									{
										//define_label = "Redefine";
										define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Redefine.label","or_labels");
										if(multiConsentValues[12].equals("N"))
										{
											//	noteligible_consent_id  += multiConsentValues[1] +"~" ;
											noteligible_consent_id.append(multiConsentValues[1]);
											noteligible_consent_id.append("~");
										}
										if(multiConsentDtls[6].equals("N"))
										{
										
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(multiConsentDtls[5]));
            out.print( String.valueOf(multiConsentDtls[6].equals("N")?"(*)":""));
            _bw.write(_wl_block80Bytes, _wl_block80);

										}
										else if(multiConsentValues[12].equals("N"))
										{
										
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf(multiConsentValues[12].equals("N")?"(*)":""));
            _bw.write(_wl_block80Bytes, _wl_block80);

										}
										else
										{
										
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf((multiConsentValues[12].equals("N"))? "(*)":""));
            _bw.write(_wl_block80Bytes, _wl_block80);

										}
										
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block84Bytes, _wl_block84);

									}
									else
									{
										if(multiConsentList.size() == 1)
										{
											multiConsentValues = (String[])multiConsentList.get(0);
											if(!multiConsentValues[1].equals("")&&!multiConsentValues[2].equals(""))
											{ 
												define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ViewConsents.label","or_labels");
												if(multiConsentValues[12].equals("N"))
												{
													//noteligible_consent_id  += multiConsentDtls[3] +"~" ;
													noteligible_consent_id.append(multiConsentValues[1]);
													noteligible_consent_id.append("~");
												}
												if(multiConsentValues[12].equals("N"))
												{
												
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf(multiConsentValues[12].equals("N")?"(*)":""));
            _bw.write(_wl_block86Bytes, _wl_block86);

												}
												else
												{
												
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf(multiConsentValues[12].equals("N")?"(*)":""));
            _bw.write(_wl_block86Bytes, _wl_block86);

												}
												
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multiConsentValues[2]));
            _bw.write(_wl_block90Bytes, _wl_block90);
	
											}
										}
									}
								}	
							}
						}
						else if(multiConsentDtls[0].equals("V") &&( (Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1) || (Integer.parseInt(consent_req_bef_order) + Integer.parseInt(consent_req_bef_regn) > 1) ))
						{//changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008							
						
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
	
							if(multiConsentList.size() > 0)
							{
								stage_label_count = true;	
								for(int j=0;j<multiConsentList.size();j++)
								{
									String[] multiConsentValues1 = (String[])multiConsentList.get(j);										
									if(multiConsentValues1[10].equals("Y"))
									{
											if(multiConsentValues1[3].equals("A"))scon_bo_cnt++;
											if(multiConsentValues1[3].equals("R"))scon_br_cnt++;
									}
								}
								/*if(scon_bo_cnt==Integer.parseInt(multiConsentDtls[1]))
								{
									 checkcolor="color";
								}
								if(scon_br_cnt==Integer.parseInt(multiConsentDtls[2]))
								{
									 checkcolor="color";
								}*/
								for(int j=0;j<multiConsentList.size();j++)
								{
									checkcolor="";
									String[] multiConsentValues = (String[])multiConsentList.get(j);
								
									if(multiConsentValues[10].equals("Y")){
										if(multiConsentValues[3].equals("A"))con_bo_cnt++;
										if(multiConsentValues[3].equals("R"))con_br_cnt++;
									}
									else
									{
										if(multiConsentValues[3].equals("A"))
										{
										////if(scon_bo_cnt==Integer.parseInt(multiConsentDtls[1]))////changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008
											if(scon_bo_cnt==Integer.parseInt(consent_req_bef_order))
											{
												checkcolor="color";
											}
										}
										if(multiConsentValues[3].equals("R"))
										{
											////if(scon_br_cnt==Integer.parseInt(multiConsentDtls[2]))////changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008
											if(scon_br_cnt==Integer.parseInt(consent_req_bef_regn))
											{
												checkcolor="color";
											}
										}
									}
									if(multiConsentValues[9].equals("Y"))
									{
										if(multiConsentValues[3].equals("A"))bo_cnt++;
										if(multiConsentValues[3].equals("R"))br_cnt++;
										if(multiConsentValues[12].equals("N"))
										{
											//noteligible_consent_id  += multiConsentValues[1] +"~" ;
											noteligible_consent_id.append(multiConsentValues[1]);
											noteligible_consent_id.append("~");
										}
										con_id.append(multiConsentValues[1]).append("~");
										con_stage.append(multiConsentValues[3]).append("~");					
										if(multiConsentValues[10].equals("Y"))	
										{
										
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf((multiConsentValues[12].equals("N"))? "(*)":""));
            _bw.write(_wl_block96Bytes, _wl_block96);

										}
										else if(checkcolor.equals("color"))
										{
										
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf((multiConsentValues[12].equals("N"))? "(*)":""));
            _bw.write(_wl_block98Bytes, _wl_block98);

										}
										else
										{
										
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf((multiConsentValues[12].equals("N"))? "(*)":""));
            _bw.write(_wl_block100Bytes, _wl_block100);

										}
											define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Redefine.label","or_labels");
									}
								}
								if(!(bo_cnt >0 || br_cnt >0))
								{
									out.println("<script>document.getElementById('consent_form_id'+i).style.visibility = 'hidden';</script>");
								}
							}
							else
							{
								//define_label = "";
								//	stage_label_count = true;														
								for(int j=0;j<multiNonAssConsentList.size();j++)
								{
									String[] multiConsentValues = (String[])multiNonAssConsentList.get(j);
									bo_cnt++;define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Redefine.label","or_labels");
									if(multiConsentValues[12].equals("N"))
									{
										//noteligible_consent_id  += multiConsentValues[1] +"~" ;
										noteligible_consent_id.append(multiConsentValues[1]);
										noteligible_consent_id.append("~");
									}
							
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(multiConsentValues[10].equals("Y")? "background-color:#FFA8A0;color:#000000":""));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf((multiConsentValues[12].equals("N"))? "(*)":""));
            _bw.write(_wl_block103Bytes, _wl_block103);
	}
								if( !(bo_cnt >0) )
								{
									out.println("<script>document.getElementById('consent_form_id'+i).style.visibility = 'hidden';</script>");
								}
							}
						
            _bw.write(_wl_block104Bytes, _wl_block104);
 
						}
						else if( multiConsentDtls[0].equals("V"))
						{ 
							//if(!multiConsentDtls[5].equals("") && !multiConsentDtls[3].equals("")){
							if(multiNonAssConsentList.size()>0)
							{
								for(int j=0;j<multiNonAssConsentList.size();j++)
								{
									String[] multiConsentValues = (String[])multiNonAssConsentList.get(j);
									define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Redefine.label","or_labels");
									if(multiConsentValues[12].equals("N"))
									{
										//	noteligible_consent_id  += multiConsentValues[1] +"~" ;
										noteligible_consent_id.append(multiConsentValues[1]);
										noteligible_consent_id.append("~");
									}
									if(	multiConsentDtls[6].equals("N"))
									{
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(multiConsentDtls[5]));
            out.print( String.valueOf(multiConsentDtls[6].equals("N")?"(*)":""));
            _bw.write(_wl_block106Bytes, _wl_block106);

									}
									else
									{
									
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
//=multiConsentDtls[5]
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf((multiConsentValues[12].equals("N"))? "(*)":""));
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
//=multiConsentDtls[3]
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block111Bytes, _wl_block111);
			}
								}
								else if(multiConsentList.size() > 0)	
								{
									for(int j=0;j<multiConsentList.size();j++)
									{
										String[] multiConsentValues = (String[])multiConsentList.get(j);											
										if(multiConsentValues[9].equals("Y") && !multiConsentValues[10].equals("Y") )
										{
											define_label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Redefine.label","or_labels");
											if(multiConsentValues[12].equals("N"))
											{
												//noteligible_consent_id  += multiConsentValues[1] +"~" ;
												noteligible_consent_id.append(multiConsentValues[1]);
												noteligible_consent_id.append("~");
											}
											if(	multiConsentDtls[6].equals("N"))
											{
											
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(multiConsentDtls[5]));
            out.print( String.valueOf(multiConsentDtls[6].equals("N")?"(*)":""));
            _bw.write(_wl_block113Bytes, _wl_block113);

											}
											else
											{
											
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(multiConsentValues[2]));
            out.print( String.valueOf((multiConsentValues[12].equals("N"))? "(*)":""));
            _bw.write(_wl_block113Bytes, _wl_block113);

											}
											
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multiConsentValues[1]));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multiConsentValues[3]));
            _bw.write(_wl_block90Bytes, _wl_block90);

											}
										}
									}
								}
							}
						
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(noteligible_consent_id.toString()));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(define_label.equals("Define")?"hidden":"visible"));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(cont_order_ind ));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf((multiConsentDtls != null && !multiConsentDtls[0].equals(""))?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BeforeOrder.label","or_labels"):""));
            _bw.write(_wl_block126Bytes, _wl_block126);
//if(stage_label.equals("") && multiConsentDtls != null){
						////	if(multiConsentDtls != null && ( ( Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1 ) || ( Integer.parseInt(multiConsentDtls[1]) + Integer.parseInt(multiConsentDtls[2]) > 1 ) )){//changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008
						if(multiConsentDtls != null && ( ( Integer.parseInt(consent_req_bef_order) > 1 || Integer.parseInt(consent_req_bef_regn) > 1 ) || ( Integer.parseInt(consent_req_bef_order) + Integer.parseInt(consent_req_bef_regn) > 1 ) ))
						{
							/**changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008	*start**/				
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(con_bo_cnt));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(consent_req_bef_order));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(con_br_cnt));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(consent_req_bef_regn));
            _bw.write(_wl_block132Bytes, _wl_block132);

						/**changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008	*end**/		
						}
						else
						{
						
            _bw.write(_wl_block133Bytes, _wl_block133);
//=stage_label
            out.print( String.valueOf((multiConsentDtls != null && !multiConsentDtls[0].equals(""))?stage_label:""));
            _bw.write(_wl_block134Bytes, _wl_block134);

						}
						//if( multiConsentDtls != null || consentedList.size() != ( Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2]) ) && ( Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2]) > 0 ) ){
						if( multiConsentDtls != null &&( multiConsentDtls[0].equals("V") || ( Integer.parseInt(consent_req_bef_order)+Integer.parseInt(consent_req_bef_regn) > 0 )))
						{
							//--[IN034888] - Start
							if(record[9].indexOf("!~!")!=-1)
							{
								record[9] = record[9].replace("!~!",",");
								consentLinenum = bean.getOrderLineNum(record[5]); //--[IN034904]
							}
							//--[IN034888] - End
						
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(i));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(record[24]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(URLEncoder.encode(record[9],"UTF-8")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block138Bytes, _wl_block138);
//=define_label?"Redefine":"Define"
            out.print( String.valueOf(define_label));
            _bw.write(_wl_block139Bytes, _wl_block139);

						}
						
            _bw.write(_wl_block140Bytes, _wl_block140);

					if((order_by.equals(" ")||(order_by.equals("P"))) && ord_cat_desc.equals(""))
					{
					
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block142Bytes, _wl_block142);

					}
					if(record[2].equals("U"))
					{
						fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
					}
					else if(record[2].equals("S"))
					{
						fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
					}
					else
					{
						fontValue = "<font size=1 color=black><b>";
					}
					if((order_by.equals(" ")||(order_by.equals("O"))) && priority_desc.equals(""))
					{  
					
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(fontValue));
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block142Bytes, _wl_block142);

					}
					slClassValue = slClassValueTmp;
					int detailSize = record[9].length();//IN45800
					if(record[9].indexOf("$$RD##")!=-1)
					{
						String[] str = (String[])record[9].split("!~!");
						//String order_detail ="";
						String order_detail ="(";//IN45800
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
								//strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";//IN45800
								//strtitle[0] = "(<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";//IN45800
								strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";//IN45800
								//order_detail = order_detail+strtitle[0]+strtitle[2]+", ";//IN45800
								order_detail = order_detail + strtitle[2]+", ";//IN45800
							}
							else
							{
								order_detail = order_detail+str[s]+", ";
							}
						}
						record[9] = order_detail;
						
						//if(record[9].lastIndexOf(",") ==((record[9].length())-2))//IN45800
						if(record[9].lastIndexOf(",") == detailSize-2)//IN45800
						{
							//record[9] = record[10] .substring(0,((record[9].length())-2));//IN45800
							record[9] = record[10] .substring(0,detailSize-2);//IN45800
						}
					}
					if(record[9].indexOf("!~!")!=-1)
					{
						record[9] = record[9].replace("!~!",",");
					}
				
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(record[8],"DMYHM","en",localeName)));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[19]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(record[9]));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[19]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[12]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(consentLinenum));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(record[9]));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[19]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[12]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(consentLinenum));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[19]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[12]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(consentLinenum));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(record[9]));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(patientdetails));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(encounter_dtls));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(i));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(record[20]));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(record[12]));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(i));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(record[13]));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(record[17]));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(i));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(record[25]));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(i));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(record[26]));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(i));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(record[21]));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(cont_order_ind));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ord_appr_by_user_id));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ord_appr_reqd_yn));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(i));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ord_consent_by_id));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(i));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(ord_consent_reqd_yn));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(record[24]));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(i));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(patientdetails));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(i));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record[9]));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(i));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(i));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(i));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(i));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(i));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(i));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(i));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record[22]));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(i));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(record[23]));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(i));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(i));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(i));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(i));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(i));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(i));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(i));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(con_bo_cnt));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(i));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(con_br_cnt));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(i));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(multiConsentDtls[1]));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(i));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(consent_req_bef_order));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(i));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(multiConsentDtls[2]));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(i));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(i));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(consent_req_bef_regn));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(i));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(con_id.toString()));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(i));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(con_stage.toString()));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(i));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean.checkForNull(record[28],"")));
            _bw.write(_wl_block235Bytes, _wl_block235);
con_id.setLength(0);
				con_stage.setLength(0);
								
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(i));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(i));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(i));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(i));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(i));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(i));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(i));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(i));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(i));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(i));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(i));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(i));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(i));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(i));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(i));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(i));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(i));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(i));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(i));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(i));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(i));
            _bw.write(_wl_block257Bytes, _wl_block257);

			i++;
		}
		
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(from));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(to));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(i));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf( practitioner_id));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf( practitioner_name));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(security_level));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(curr_sys_date));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(ord_cat_desc));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(priority_desc));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(qryString));
            _bw.write(_wl_block281Bytes, _wl_block281);
//=bean.getFunctionId()
            _bw.write(_wl_block282Bytes, _wl_block282);

putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e)
	{
		System.err.println("ConsentOrdersBottomRightDtl.jsp,1108,message=>"+e.getMessage());
		e.printStackTrace();
	}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.SNO.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Consent.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.required.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderedAt.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderCatalogs.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDetails.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.LinkConsent.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Release.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Registration.label", java.lang.String .class,"key"));
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
}
