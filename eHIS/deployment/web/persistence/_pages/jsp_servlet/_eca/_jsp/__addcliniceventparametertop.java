package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __addcliniceventparametertop extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/addClinicEventParameterTop.jsp", 1743657391634L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- addClinicEventParameterTop.jsp -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<title></title>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\n\t<style>\n\t#maintable  td,th,tr \n\t{border-bottom: 1px solid #d5e2e5;\n\t}\n\t</style>\n\t\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/ClinicEventParameter.js\'></script>\t\t\n\t<SCRIPT LANGUAGE=\"JavaScript\">\n\tvar prevObjID;\n\tvar prevImgObj;\n\tvar disappeardelay= 250;\n\tfunction legendHide()\n\t{\n\t\tvar e=window.event;\n\t\tif (!e.target) \n\t\t\te.target=e.srcElement;\n\t\tif(e.target)\n\t\t{\t\t\t\t\n\t\t\tif(!(e.target.id==\'icon0\'||e.target.id==\'icon1\'||e.target.id==\'icon4\'||e.target.id==\'icon5\'||e.target.id==\'mouse\'||e.target.id==\'tooltiptable1\'||e.target.id==\'tooltipimage\'||e.target.id==\'symbol0\'||e.target.id==\'symbol1\'||e.target.id==\'symbol4\'||e.target.id==\'symbol5\'||e.target.id==\'selectsymbol0\'||e.target.id==\'selectsymbol1\'||e.target.id==\'selectsymbol4\'||e.target.id==\'selectsymbol5\'))\n\t\t\t{\t\n\t\t\t\thidemenu();\n\t\t\t}\n\t\t}\n\t}\n\tfunction resizeWindow(orderctlHDR)\n\t{\t\t\n\t\tvar orderctlHDR1 = orderctlHDR.id;\t\n\t\t\n\t\tvar wdth = document.getElementById(orderctlHDR1).offsetWidth;\n\t\tvar hght1 = document.getElementById(orderctlHDR1).offsetHeight;\t\t\n\t\t\n\t\tvar wdth1 = getPos(orderctlHDR).x +wdth;\n\t\tvar hght = getPos(orderctlHDR).y ;\t\n\n\t\tbodwidth  = document.body.offsetWidth\n\t\tbodheight = document.body.offsetHeight\n\t\n\t\tvar z = bodwidth- (event.x + wdth);\t\n\t\t\n\t\tvar x \t  = event.x;\n\t\tvar y \t  = event.y;\t\n\n\t\tx \t  = x + (document.getElementById(\"tooltiplayer\").offsetWidth);\n\t\ty \t  = hght + (document.getElementById(\"tooltiplayer\").offsetHeight);\t\n\t\t\n\t\tif(x<bodwidth){\n\t\t\tx= wdth1;\t\t\t\n\t\t}else{\t\t\t\n\t\t\tx = getPos(orderctlHDR).x;\n\t\t}\n\t\tif(y<bodheight){\t\t\t\n\t\t\ty = hght;\n\t\t\t\n\t\t}else\n\t\t{\n\t\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight*2) + hght1 ;\t\n\t\t}\n\t\tvar framecols=parent.parent.contentFrameset.cols\n\t\tvar tempframe=framecols.split(\",\");\n\t\tif(tempframe[0]==\"0\")\n\t\t{\n\t\t\tx=x-20;\n\t\t\ty=y+21;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tx=x-35;\n\t\t\ty=y+21;\n\t\t}\n\t\t\n\n\t\tdocument.getElementById(\"tooltiplayer\").style.left= x+\"px\";\t\t\n\t\tdocument.getElementById(\"tooltiplayer\").style.top = y+\"px\";\n\t\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'visible\';\n\t}\n\n\tfunction displayToolTip(orderctlHD,imgObject,objcount) \n\t{\t\n\t\tvar orderctlHDR=document.getElementById(orderctlHD);\n\t\tvar imgObj=imgObject.id;\n\t\tcallMouseOverOnTD(orderctlHDR,imgObj);\n\t\tbuildTable(orderctlHDR,objcount);\n\t\tresizeWindow(orderctlHDR);\n\t}\n\t\n\tfunction callMouseOverOnTD(obj,imgObj){\t\t\t\n\t\t if (prevObjID != null && prevObjID != obj.id)\n\t\t {\t\t\t \n\t\t\t document.getElementById(prevObjID).className = \'gridData\';\n\t\t\t document.getElementById(prevImgObj).src = \"../../eCommon/images/down.gif\";\t\t\t \n\t\t }\t\t \n\t\tobj.className = \'gridData\';\n\t\tdocument.getElementById(imgObj).src = \"../../eCommon/images/down.gif\";\n\t\tprevObjID = obj.id;\n\t\tprevImgObj = imgObj;\t\t\n\t}\n\t\n\tfunction getPos(inputElement) {\n    var coords =  new Object();\n    coords.x = 0;\n    coords.y = 0;\n    try {\n\t\t\ttargetElement = inputElement;\n\t\t\tif(targetElement.x && targetElement.y) {\n\t\t\t\tcoords.x = targetElement.x;\n\t\t\t\tcoords.y = targetElement.y;\n\t\t\t} else {\n\t\t\t\t\tif(targetElement.offsetParent) {\n\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t\twhile(targetElement = targetElement.offsetParent) {\n\t\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t\t}\n\t\t\t\t} else {\n\t\t\t\t\t//alert(\"Could not find any reference for coordinate positioning.\");\n\t\t\t\t}\n\t\t\t}\n\t\t\t return coords;\n       } catch(error) {\n        //alert(error.msg);\n        return coords;\n       }\n    }\n\n\tfunction hidemenu()\n\t{\t\t\n\t\tdocument.getElementById(\"tooltiplayer\").style.visibility = \'hidden\';\n\t}\n\n\tfunction buildTable(orderctlHDR,objcount) \n\t{\n\t\tvar click_id;\t\t\n\t\tvar objectid= orderctlHDR.id;\n\t\tvar click_id= objectid.substring(objectid.length-1);\n\t\t\n\t\tvar row      = (\"../../eCA/images/NI_High.gif,../../eCA/images/NI_Low.gif,../../eCA/images/NI_CriticallyHigh.gif,../../eCA/images/NI_CriticallyLow.gif,../../eCA/images/NI_Normal.gif\");\n\t\trowval1      = row.split(\",\");\n\t\tvar objcount1=objcount;\n\t\tvar tab_dat  = \"<table  class=\'grid\' id=\'tooltiptable1\'  width=\'\' height=\'100%\' align=\'center\'>\"\n \t\tfor( var i=0; i<rowval1.length; i++ ) {\n\t\t\tvar colval1 = rowval1[i];\t\t\t\n\t\t\tif (colval1 != \"\" )\n\t\t\t{\n\t\t\t\ttab_dat   =  tab_dat+\"<tr>\" ;\t\t\t\t\t\t\t\t\n\n\t\t\t\ttab_dat    = tab_dat+ \"<td class = \'contextMenuItem\'   style=\'padding-left:10px;padding-right:10px\' nowrap id=\'mouse\' ><img src=\'\"+colval1+\"\' id=\'tooltipimage\' onclick=\'dispImage(this,\"+objcount1+\",\"+click_id+\")\'  ></img> </td>\" ;\n\t\t\t\ttab_dat     =tab_dat+ \"</tr> \" ;\n\t\t\t}\n\t\t}\n\t\t\ttab_dat     =tab_dat+ \"</table> \";\t\t\n\t\t\tconsole.log(document.getElementById(\"t\"))\n\t\tdocument.getElementById(\"t\").innerHTML = tab_dat;\t\n\t}\n\n\n\tfunction dispImage(obj,objcount,click_id)\n\t{\n\t\tvar temp=obj.src;\n\t\turl=temp.split(\"/\");\n\t\tvar t=url[url.length-1];\n\t\tvar tempurl=\"../../eCA/images/\"+t;\n\t\tif(click_id==\"0\")\t\t\n\t\t\tdocument.getElementById(\"symbol0\").src=tempurl;\n\t\telse if(click_id==\"1\")\n\t\t\tdocument.getElementById(\"symbol1\").src=tempurl;\t\n\t\telse if(click_id==\"4\")\n\t\t\tdocument.getElementById(\"symbol4\").src=tempurl;\n\t\telse if(click_id==\"5\")\n\t\t\tdocument.getElementById(\"symbol5\").src=tempurl;\n\t\tdocument.getElementById(\"tooltiplayer\").style.visibility = \'hidden\';\t\t\t\t\n\t}\t\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown =\'lockKey()\' onMouseOver=\'legendHide()\' onLoad=\"FocusFirstElement()\" >\n<form name=\'clinic_event_param_form_top\' id=\'clinic_event_param_form_top\' action=\'../../servlet/eCA.ClinicEventParamServlet\' method=\'post\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<table class=\'grid\' width=\'90%\' align=center  id=\'maintable\'  >\n\n<tr>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'24%\'></td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'10%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'20%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'15%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'11%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\t\n</tr>\n<tr>\n\t<td  class=\"gridData\" width=\'24%\' id=\'label0\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td  class=\"gridData\" width=\'10%\'><input type=\'text\' name=\'high_value\' id=\'high_value\' size=\'1\' maxlength=\'1\' onBlur=\'ChangeUpperCase(this)\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n    <td  class=\"gridData\" width=\'20%\'><input type=\'text\' name=\'high_value_desc\' id=\'high_value_desc\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\'value0\' onBlur=\'chkDescAndColor(this,0,\"high\")\' size=25 maxlength=30><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td  class=\"gridData\" width=\'15%\' ><input type=\'text\' name=\'high_value_color\' id=\'high_value_color\' id=\'color0\' size=\'1\' maxlength=\'1\' STYLE=\"background-color:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" readOnly><img src=\'../../eIP/images/showColor.gif\' onClick=\'getColor(\"high\");\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="></img></td>\n\t<td class=\"gridData\"  style=\'text-align:center\' width=\'11%\' id=\"icon0\"><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\"symbol0\" name=\"symbolicobj0\"></img>&nbsp;<img id=\'selectsymbol0\' src=\'../../eCommon/images/down.gif\' onClick=\'displayToolTip(\"icon0\",this,";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =")\' ></img></td>\t\n</tr>\n<tr>\n\t<td  class=\"gridData\" width=\'24%\' id=\'label1\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<td  class=\"gridData\" width=\'10%\'><input type=\'text\' name=\'low_value\' id=\'low_value\' size=\'1\' maxlength=\'1\' onBlur=\'ChangeUpperCase(this)\'  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td  class=\"gridData\" width=\'20%\'><input type=\'text\' name=\'low_value_desc\' id=\'low_value_desc\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"  id=\'value1\' onBlur=\'chkDescAndColor(this,1,\"low\")\' size=25 maxlength=30><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td width=\'15%\' class=\'gridData\' ><input type=\'text\' name=\'low_value_color\' id=\'low_value_color\'  id=\'color1\' size=\'1\' maxlength=\'1\' STYLE=\"background-color:";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" readOnly><img src=\'../../eIP/images/showColor.gif\' onClick=\'getColor(\"low\");\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="></img></td>\n\t<td class=\"gridData\" style=\'text-align:center\' width=\'11%\' id=\"icon1\"><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\"symbol1\" name=\"symbolicobj1\"></img>&nbsp;<img id=\'selectsymbol1\' src=\'../../eCommon/images/down.gif\' onClick=\'displayToolTip(\"icon1\",this,";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =")\' ></img></td>\n</tr>\n<tr>\n\t<td  class=\"gridData\" width=\'24%\' id=\'label2\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t<td  class=\"gridData\" width=\'10%\'><input type=\'text\' name=\'abnml_value\' id=\'abnml_value\' size=\'1\' maxlength=\'1\' onBlur=\'ChangeUpperCase(this)\'  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n    <td  class=\"gridData\" width=\'20%\'><input type=\'text\' name=\'abnml_value_desc\' id=\'abnml_value_desc\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  id=\'value2\' onBlur=\'chkDescAndColor(this,2,\"abnml\")\' size=25 maxlength=30><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td width=\'15%\' class=\'gridData\' ><input type=\'text\' name=\'abnml_value_color\' id=\'abnml_value_color\'  id=\'color2\' size=\'1\' maxlength=\'1\' STYLE=\"background-color:";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" readOnly><img src=\'../../eIP/images/showColor.gif\' onClick=\'getColor(\"abnormal\");\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="></img></td>\n\t<td class=\"gridData\" style=\'text-align:center\' width=\'11%\'  id=\"icon2\"><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\"symbol2\" name=\"symbolicobj2\"></img>&nbsp;&nbsp;&nbsp;</td>\n</tr>\n<tr>\n\t<td  class=\"gridData\" width=\'24%\' id=\'label3\' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t<td  class=\"gridData\" width=\'10%\' ><input type=\'text\' name=\'crtcl_value\' id=\'crtcl_value\' size=\'1\'  maxlength=\'1\' onBlur=\'ChangeUpperCase(this)\'  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td  class=\"gridData\" width=\'20%\'><input type=\'text\' name=\'crtcl_value_desc\' id=\'crtcl_value_desc\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"  id=\'value3\'  onBlur=\'chkDescAndColor(this,3,\"crtcl\")\' size=25 maxlength=30><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td width=\'15%\' class=\'gridData\' ><input type=\'text\' name=\'crtcl_value_color\' id=\'crtcl_value_color\' id=\'color3\' size=\'1\' maxlength=\'1\' STYLE=\"background-color:";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" readOnly><img src=\'../../eIP/images/showColor.gif\' onClick=\'getColor(\"critical\");\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="></img></td>\n\t<td class=\"gridData\" style=\'text-align:center\' width=\'11%\'  id=\"icon3\" ><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\"symbol3\" name=\"symbolicobj3\"></img>&nbsp;&nbsp;&nbsp;</td>\n</tr>\n<tr>\n\t<td  class=\"gridData\" width=\'24%\' id=\'label4\' >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t<td  class=\"gridData\" width=\'10%\'><input type=\'text\' name=\'crtcl_low_value\' id=\'crtcl_low_value\' size=\'1\' maxlength=\'1\' onBlur=\'ChangeUpperCase(this)\'  ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td  class=\"gridData\" width=\'20%\'><input type=\'text\' name=\'crtcl_low_value_desc\' id=\'crtcl_low_value_desc\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"  id=\'value4\'  onBlur=\'chkDescAndColor(this,4,\"crtcl_low\")\' size=25 maxlength=30><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td width=\'15%\' class=\'gridData\' ><input type=\'text\' name=\'crtcl_low_value_color\' id=\'crtcl_low_value_color\'  id=\'color4\' size=\'1\' maxlength=\'1\' STYLE=\"background-color:";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" readOnly><img src=\'../../eIP/images/showColor.gif\' onClick=\'getColor(\"criticallow\");\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="></img></td>\n\t<td class=\"gridData\" style=\'text-align:center\' width=\'11%\' id=\"icon4\"><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\"symbol4\" name=\"symbolicobj4\"></img>&nbsp;<img  onClick=\'displayToolTip(\"icon4\",this,";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =")\' id=\'selectsymbol4\' src=\'../../eCommon/images/down.gif\'  ></img></td>\n</tr>\n<tr>\n\t<td  class=\"gridData\" width=\'24%\' id=\'label5\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t<td  class=\"gridData\" width=\'10%\'><input type=\'text\' name=\'crtcl_high_value\' id=\'crtcl_high_value\' size=\'1\'  maxlength=\'1\' onBlur=\'ChangeUpperCase(this)\'  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td  class=\"gridData\" width=\'20%\'><input type=\'text\' name=\'crtcl_high_value_desc\' id=\'crtcl_high_value_desc\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\"  id=\'value5\'  onBlur=\'chkDescAndColor(this,5,\"crtcl_high\")\'size=25 maxlength=30><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td width=\'15%\' class=\'gridData\' ><input type=\'text\' name=\'crtcl_high_value_color\' id=\'crtcl_high_value_color\'  id=\'color5\' size=\'1\' maxlength=\'1\' STYLE=\"background-color:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" readOnly><img src=\'../../eIP/images/showColor.gif\' onClick=\'getColor(\"criticalhigh\");\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="></img></td>\n\t<td class=\"gridData\" style=\'text-align:center\' width=\'11%\' id=\"icon5\"><img src=\'../../eCA/images/";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\"symbol5\" name=\"symbolicobj5\"></img>&nbsp;<img src=\'../../eCommon/images/down.gif\'  id=\'selectsymbol5\' onClick=\'displayToolTip(\"icon5\",this,";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =")\'></img></td>\n</tr>\n<tr>\n\t<td  class=\"gridData\" width=\'24%\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t<td  class=\"gridData\" width=\'10%\'><input type=\'text\' name=\'delta_value\' id=\'delta_value\' size=\'1\' maxlength=\'1\' onBlur=\'ChangeUpperCase(this)\'  value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="><MAP NAME=\"\"><AREA SHAPE=\"\" HREF=\"\" COORDS=\"\" ALT=\"\"></MAP></td>\n\t<td  class=\"gridData\" width=\'20%\' >&nbsp;</td>\n\t<td  class=\"gridData\" width=\'15%\' >&nbsp;</td>\n\t<td  class=\"gridNumericData\" width=\'11%\'>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n</tr>\n</table>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div>\n\n<table  width=\'90%\' align=center id=\'symcolortbl\'>\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" \n\t\t<td class=\'gridData\' style=\'border: none;\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&nbsp;&nbsp;<input type=radio name=sym_color value=\'S\' checked  >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&nbsp;&nbsp;<input type=radio name=sym_color value=\'C\'  >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t<td class=\'gridData\' style=\'border: none;\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&nbsp;&nbsp;<input type=radio name=sym_color value=\'S\'   >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&nbsp;&nbsp;<input type=radio name=sym_color value=\'C\' checked >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t</tr>\n</table>\n</form>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	int count=0;
	

            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");	
	String sStyle =
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

conlCon = ConnectionManager.getConnection(request);
try
{
StringBuffer sblQry		= new StringBuffer();
String high_value		= "";
String low_value		= "";
String abnml_value		= "";
String crtcl_value		= "";
String crtcl_high_value = "";
String crtcl_low_value  = "";
String deltaValue = "";
String status="";
String high_value_desc ="High";
String high_value_color ="#FFDAB9";
String low_value_desc ="Low";
String low_value_color ="#F0FFFF";
String abnml_value_desc		= "Abnormal";
String abnml_value_color		= "#FFF8DC";
String crtcl_value_desc		= "Critical";
String crtcl_value_color		= "#D2B48C";
String crtcl_low_value_desc		= "Critical Low";
String crtcl_low_value_color		= "#D8BFD8";
String crtcl_high_value_desc		= "Critical High";
String crtcl_high_value_color		= "#F4A460";
String high_value_imageurl="NI_High.gif";
String low_value_imageurl="NI_Low.gif";
String abnormal_value_imageurl="NI_Abnormal.gif";
String critical_value_imageurl="NI_Critical.gif";
String critical_lowvalue_imageurl="NI_CriticallyLow.gif";
String criticalhigh_sym_imageurl="NI_CriticallyHigh.gif";
String legendValue="";


sblQry.append("SELECT high_str, low_str, abn_str, crit_str, crit_high_str, crit_low_str,high_str_desc,high_color_code,low_str_desc,low_color_code,abn_str_desc,abn_color_code,crit_str_desc,crit_color_code,crit_high_str_desc,crit_high_color_code,crit_low_str_desc,crit_low_color_code,DELTA_FAIL_STR,HIGH_SYMBOL_ICON,LOW_SYMBOL_ICON,ABN_SYMBOL_ICON, CRIT_SYMBOL_ICON,CRIT_LOW_SYMBOL_ICON,CRIT_HIGH_SYMBOL_ICON,LEGEND_TYPE FROM cr_clin_event_param");
pstmt = conlCon.prepareStatement(sblQry.toString());
rslRst = pstmt.executeQuery();
if(rslRst.next())
{
		high_value			= rslRst.getString("high_str");
		if(high_value == null || high_value.equals("")) high_value = "";
		low_value			= rslRst.getString("low_str");
		if(low_value == null || low_value.equals("")) low_value = "";
		abnml_value			= rslRst.getString("abn_str");
		if(abnml_value == null || abnml_value.equals("")) abnml_value = "";
		crtcl_value			= rslRst.getString("crit_str");
		if(crtcl_value == null || crtcl_value.equals("")) crtcl_value = "";
		crtcl_high_value	= rslRst.getString("crit_high_str");
		if(crtcl_high_value == null || crtcl_high_value.equals("")) crtcl_high_value = "";
		crtcl_low_value		= rslRst.getString("crit_low_str");
		if(crtcl_low_value == null || crtcl_low_value.equals("")) crtcl_low_value = "";
	
	high_value_imageurl			= rslRst.getString("HIGH_SYMBOL_ICON");	
	if(high_value_imageurl == null || high_value_imageurl.equals("")) high_value_imageurl = "NI_High.gif";
	low_value_imageurl			= rslRst.getString("LOW_SYMBOL_ICON");	
	if(low_value_imageurl == null || low_value_imageurl.equals("")) low_value_imageurl = "NI_Low.gif";
	abnormal_value_imageurl			= rslRst.getString("ABN_SYMBOL_ICON");	
	if(abnormal_value_imageurl == null || abnormal_value_imageurl.equals("")) abnormal_value_imageurl = "NI_Abnormal.gif";
	critical_value_imageurl			= rslRst.getString("CRIT_SYMBOL_ICON");
	if(critical_value_imageurl == null || critical_value_imageurl.equals("")) critical_value_imageurl = "NI_Critical.gif";	
	critical_lowvalue_imageurl			= rslRst.getString("CRIT_LOW_SYMBOL_ICON");
	if(critical_lowvalue_imageurl == null || critical_lowvalue_imageurl.equals("")) critical_lowvalue_imageurl = "NI_CriticallyLow.gif";	
	criticalhigh_sym_imageurl = rslRst.getString("CRIT_HIGH_SYMBOL_ICON");
	if(criticalhigh_sym_imageurl == null || criticalhigh_sym_imageurl.equals("")) criticalhigh_sym_imageurl = "NI_CriticallyHigh.gif";
	legendValue = rslRst.getString("LEGEND_TYPE");
	if(legendValue == null || legendValue.equals("")) legendValue = "S";

    high_value_desc			= rslRst.getString("high_str_desc");
	if(high_value_desc == null || high_value_desc.equals("")) high_value_desc = "High";
	high_value_color			= rslRst.getString("high_color_code");

	if(high_value_color == null || high_value_color.equals("")) high_value_color = "#FFDAB9";

	low_value_desc			= rslRst.getString("low_str_desc");
	if(low_value_desc == null || low_value_desc.equals("")) low_value_desc = "Low";
	low_value_color			= rslRst.getString("low_color_code");
	if(low_value_color == null || low_value_color.equals("")) low_value_color = "#F0FFFF";

	abnml_value_desc			= rslRst.getString("abn_str_desc");
	if(abnml_value_desc == null || abnml_value_desc.equals("")) abnml_value_desc = "Abnormal";
	abnml_value_color			= rslRst.getString("abn_color_code");
	if(abnml_value_color == null || abnml_value_color.equals("")) abnml_value_color = "#FFF8DC";

	crtcl_value_desc			= rslRst.getString("crit_str_desc");
	if(crtcl_value_desc == null || crtcl_value_desc.equals("")) crtcl_value_desc = "Critical";
	crtcl_value_color			= rslRst.getString("crit_color_code");
	if(crtcl_value_color == null || crtcl_value_color.equals("")) crtcl_value_color = "#D2B48C";

	crtcl_high_value_desc			= rslRst.getString("crit_high_str_desc");
	if(crtcl_high_value_desc == null || crtcl_high_value_desc.equals("")) crtcl_high_value_desc = "Critical High";
	crtcl_high_value_color			= rslRst.getString("crit_high_color_code");
	if(crtcl_high_value_color == null || crtcl_high_value_color.equals("")) crtcl_high_value_color = "#F4A460";
	
	crtcl_low_value_desc			= rslRst.getString("crit_low_str_desc");
	if(crtcl_low_value_desc == null || crtcl_low_value_desc.equals("")) crtcl_low_value_desc = "Critical Low";
	crtcl_low_value_color			= rslRst.getString("crit_low_color_code");
	if(crtcl_low_value_color == null || crtcl_low_value_color.equals("")) crtcl_low_value_color = "#D8BFD8";

		deltaValue		= rslRst.getString("DELTA_FAIL_STR");
		if(deltaValue == null || deltaValue.equals("")) deltaValue = "";
		
			out.println("<input type=hidden name='mode' id='mode' value='update'>");
}
else
{
			out.println("<input type=hidden name='mode' id='mode' value='insert'>");
}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
 if(!(high_value == null || high_value.equals(""))) {out.println("value = '"+high_value+"' readonly");}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(high_value_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(high_value_color));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(status));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(high_value_imageurl));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(!(low_value == null || low_value.equals(""))){out.println("value = '"+low_value+"' readonly");}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(low_value_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(low_value_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(low_value_imageurl));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
 if(!(abnml_value == null || abnml_value.equals(""))) {out.println("value = '"+abnml_value+"' readonly");}
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(abnml_value_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(abnml_value_color));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(status));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(abnormal_value_imageurl));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(!(crtcl_value == null || crtcl_value.equals(""))) {out.println("value = '"+crtcl_value+"' readonly");}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(crtcl_value_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(crtcl_value_color));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(critical_value_imageurl));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
 if(!(crtcl_low_value == null || crtcl_low_value.equals(""))) {out.println("value = '"+crtcl_low_value+"' readonly");}
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(crtcl_low_value_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(crtcl_low_value_color));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(status));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(critical_lowvalue_imageurl));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
 if(!(crtcl_high_value == null || crtcl_high_value.equals(""))) {out.println("value = '"+crtcl_high_value+"' readonly");}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(crtcl_high_value_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(crtcl_high_value_color));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(status));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(criticalhigh_sym_imageurl));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(count));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(deltaValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
if(!deltaValue.equals("")) out.println("readOnly");
            _bw.write(_wl_block55Bytes, _wl_block55);
count++;
            _bw.write(_wl_block56Bytes, _wl_block56);
if(legendValue.equals("S")) {
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
}else{
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block64Bytes, _wl_block64);

	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in addClinicEventParameterTop.jsp"+e.toString());//COMMON-ICN-0181
         e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(conlCon !=null)ConnectionManager.returnConnection(conlCon,request);
}

            _bw.write(_wl_block65Bytes, _wl_block65);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.INDICATOR.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Color.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SymbolicLegends.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HighValue.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LowValue.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AbnormalValue.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CriticalValue.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CriticalLowValue.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CriticalHighValue.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DeltaValue.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NormalcyIndicator.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Symboliclegends.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Colourlegends.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NormalcyIndicator.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Symboliclegends.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Colourlegends.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
