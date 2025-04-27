package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __problemsframe1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/Problemsframe1.jsp", 1743758858169L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tRev.Date\t\tRev.Name\t\tDescription\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n24/01/2012\t  IN036001\t\tChowminya \t Record Diagnosis in Thai language screen.Data lang not changed\n06/08/2013\t  IN041797\t\tChowminya \t SKR-CRF-0020.1 - In Error legend included\n25/11/2013\t  IN045225\t\tChowminya    Record Diagnosis OTH Diagnosis desc should display the free text entered\t\n22/12/2014\t  IN053120\t\tVijayakumar K\t22/12/2014\t\tAkbar \t\t\tML-BRU-SCF-1519 [IN:053120]; \n30/01/2019\t  IN069327\t\tPrakash C   30/01/2019\t\tRamesh G \t\tML-MMOH-CRF-1281.1\n08/01/2020  \t   IN071908           SIVABAGYAM M   08/01/2020       Ramesh G     ML-MMOH-SCF-1427\n23/03/2023\t   38981        Krishna Pranay   23/03/2023     Ramesh G     ML-MMOH-CRF-1986\n30/03/2023     42995        Krishna Pranay   30/03/2023     Ramesh G    CA-ML-MMOH-CRF-1986\n--------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<!-- <modifeid by Arvind @03-12-2008> -->\n\n\t\t \n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCA/js/ProblemList.js\"></script>\n\t\t<script src=\'../js/rowcolor.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eMR/js/RecDiagnosis.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n      \t<script>\n\n\t\tvar srl_no_array = new Array();\n\t\tvar term_set_id_array = new Array();\n\t\tvar term_code_array = new Array();\n\n\t\tvar detailArray = new Array();\n\n\t\tvar prev=1;\n\t\tvar i=0;\n\t\tvar prev1=0;\n\t\tvar j=0;\n\t\tvar flag=false;\n\t\t\n\t\tfunction rfresh(obj)\n\t\t{\n\t\t\tvar index = eval(obj-1);\n\t\t\t//alert(srl_no_array[prev1]);\n\t\t\n\t\t\tif(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" == \"Y\"){\n\t\t\t\t//parent.problemsframe2.location.href=\"problemsframe2.jsp?&srl_no=\"+srl_no_array[prev1]+\"&Patient_Id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"\n\t\t\t\t\n\t\t\t\tparent.problemsdetails.location.href=\"ProblemsDetails.jsp?&srl_no=\"+srl_no_array[index]+\"&Patient_Id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&term_set_id=\"+term_set_id_array[index]+\"&term_code=\"+term_code_array[index];\n\t\t\t\tparent.problemsassessments.location.href=\"ProblemsAssessment.jsp?&srl_no=\"+srl_no_array[index]+\"&Patient_Id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&term_set_id=\"+term_set_id_array[index]+\"&term_code=\"+term_code_array[index];\n\t\t\t}else{\n\t\t\t\t//top.content.workAreaFrame.problemsframe2.location.href=\"problemsframe2.jsp?&srl_no=\"+srl_no_array[prev1]+\"&Patient_Id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"\n\t\t\ttop.content.workAreaFrame.problemsdetails.location.href=\"ProblemsDetails.jsp?&srl_no=\"+srl_no_array[index]+\"&Patient_Id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&term_set_id=\"+escape(term_set_id_array[index])+\"&term_code=\"+term_code_array[index];\n\n\t\t\ttop.content.workAreaFrame.problemsassessments.location.href=\"ProblemsAssessment.jsp?&srl_no=\"+srl_no_array[index]+\"&Patient_Id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&term_set_id=\"+escape(term_set_id_array[index])+\"&term_code=\"+term_code_array[index];\n\t\t\t}\n\t\t\t\n\t\t}\n\n\t/*function ShowSupportingDiag(associate_codes,title)\n\t{\n\t\t//alert(\" ss \"+associate_codes);\n\t\tvar dialogHeight= \"10\" ;\n\t\tvar dialogWidth = \"35\" ;\n\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\n\twindow.showModalDialog(\"../../eCA/jsp/ShowSupportDiagCodeFrames.jsp?associate_codes=\"+escape(associate_codes)+\"&title=\" + title,\"\",features);\n\t}*/\n\n\t\tfunction refer(ro,numofcols)\n\t\t{\n\t\t\t//prev=ro.rowIndex;\n\t\t\tif(!flag)//checking for whether check box is clicked, as we need not to change the color\n\t\t\t{\n\t\t\t\tprev1\t=ro.rowIndex\n\n\t\t\t\tfor (var i=0;i<numofcols;i++)\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"tb1\").rows[prev].cells[i].style.backgroundColor=ro.bgColor;\n\t\t\t\t}\n\n\t\t\t\tfor (var i=0;i<numofcols;i++)\n\t\t\t\t\tro.cells[i].style.backgroundColor=\"#B2B6D7\";\n\n\t\t\t\tprev\t=ro.rowIndex\n\t\t\t}\n\t\t\tflag=false;\n\t\t\t//alert(\"retete \"+prev);\n\n\t\t}\n\t\tfunction onCheck(obj)\n\t\t{\n\t\t\t\n\t\t\tflag=true;\n\t\t\tvar count=0;\n\t\t\tvar no_of_items = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\tif(no_of_items==null) no_of_items = 0;\n\t\t\tfor(i=1;i<=document.getElementById(\'tb1\').rows.length;i++)\n\t\t\t{\n\t\t\t\tif(document.getElementById(\'ch\'+i)!=null)\n\t\t\t\t{\n\t\t\t\t\tif(document.getElementById(\'ch\'+i).checked==true)\n\t\t\t\t\t{\n\t\t\t\t\t\tcount++;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(count > no_of_items){\n\t\t\t\tvar msg= getMessage(\"SEL_MAX_PROB_NA\",\'CA\' );\n\t\t\t\tmsg = msg.replace(\'$$\',no_of_items );\n\t\t\t\talert(msg);//yet to b added into messages\n\t\t\t\tobj.checked=false;\n\t\t\t}\n\t\t}\n\n\t\tfunction alignHeading()\n{\n\t\n\tif(parent.problemsframe0.document.getElementById(\'th1\') != null) \n\t{\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\tparent.problemsframe0.document.getElementById(\'th1\').width =\teval(document.getElementById(\'tb1\').offsetWidth);\n\t\t\t\t\n\t\t\t\tfor(j=0;j < document.getElementById(\'tb1\').rows(0).cells.length; j++) \n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tvar wid=eval(document.getElementById(\'tb1\').rows(0).cells(j).offsetWidth);\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tif(parent.problemsframe0.document.getElementById(\'th1\').rows(0).cells(j) != null)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t   parent.problemsframe0.document.getElementById(\'th1\').rows(0).cells(j).width=wid;\n\t\t\t\t\t\t}\n\t\t\t\t}\n\t}\n}\n\n\nfunction callMouseOverDiag(obj,index)\n\t{\n\t\tvar tabdata = \'<table class=\"grid\" cellpadding=0 cellspacing=0 border=1><tr><td class=columnHeadercenter nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;</td><td class=columnHeadercenter nowrap>&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;</td></tr>\';\n\n\t\t\ttabdata +=detailArray[index]+\"</table>\";\n\t\t\tdocument.getElementById(\'details\').innerHTML = tabdata;\n\n\t\t\t\tvar wdth \t  = obj.offsetWidth;\n\t\t\t\tvar hght1 \t  = obj.offsetHeight;\n\n\t\t\t\tvar wdth1 = getPos(obj).x - wdth;\n\t\t\t\tvar hght = getPos(obj).y + hght1;\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\'details\').style.posTop  = hght;\n\t\t\t\tdocument.getElementById(\'details\').style.posLeft  = wdth1;\n\t\t\t\tdocument.getElementById(\'details\').style.visibility = \'visible\' ;\n\t\t\t\t\t\n\n\t}\n\tfunction callOnMouseOutDiag(obj)\n\t{\n\t\tdocument.getElementById(\'details\').style.visibility=\'hidden\' ;\n\t}\n\n\tfunction getPos(inputElement)\n\t{\n\t\tvar coords =  new Object();\n\t\tcoords.x = 0;\n\t\tcoords.y = 0;\n\t\ttry\n\t\t{\n\t\t\ttargetElement = inputElement;\n\t\t\tif(targetElement.x && targetElement.y)\n\t\t\t{\n\t\t\t\tcoords.x = targetElement.x;\n\t\t\t\tcoords.y = targetElement.y;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(targetElement.offsetParent)\n\t\t\t\t{\n\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t\twhile(targetElement = targetElement.offsetParent)\n\t\t\t\t\t{\n\t\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//alert(\"Could not find any reference for coordinate positioning.\");\n\t\t\t\t}\n\t\t\t}\n\t\t\treturn coords;\n\t\t}\n\t\tcatch(error)\n\t\t{\n\t\t\treturn coords;\n\t\t}\n\t}\n\n\n\t\t\n      \t</script>\n   <!-- IN041797 Start -->   \t\n   <style type=\"text/css\">\n    .slink a:link {color: #0000FF;}\n    .slink a:focus {color: #000000}\n    .slink {}\n   </style>\n     <!-- IN041797 End -->  \n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\'scrollTitle()\'>\n\n<form name= \"fr\" >\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<!--\t<tr id=\"divTitleTable\">\n\t\t<th class=\'columnHeadercenter\' width=\"10%\"  id=\'x1\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th> \n\t\t<th class=\'columnHeadercenter\' width=\"10%\"  id=\'x\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th> \n\t\t<th class=\'columnHeadercenter\' width=\"20%\"  id=\'a\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t<th class=\'columnHeadercenter\' width=\"10%\"  id=\'a\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n\t\t<th class=\'columnHeadercenter\' width=\"10%\"  id=\'b\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t\t<th class=\'columnHeadercenter\' width=\"7%\"  id=\'c\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t<th class=\'columnHeadercenter\' width=\"10%\"  id=\'d\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</th>\n\t\t<th class=\'columnHeadercenter\' width=\'6%\' ID=\'h\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th>\n\t\t<th class=\'columnHeadercenter\'   id=\'z\' width=\"9%\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</th>\n\t\t<th class=\'columnHeadercenter\'  id=\'sc\' width=\"6%\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</th> \n\t\t ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \n\t\t\t <td class=\'columnHeader\' width=6%  >&nbsp;&nbsp;&nbsp;</td> \n\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" \n\t\t</tr>  -->\n\t\t<tr id=\"divTitleTable\">\n\t\t\t\t<th align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >&nbsp;</font></th>\n\t\t\t\t<th align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >&nbsp;</font></th>\n\t\t\t\t<th align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></th>\n\t\t\t\t<th align=\'center\'  wrap class=\'COLUMNHEADERCENTER\'><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="/";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font></th>\n\t\t\t\t<th align=\'center\'  nowrap class=\'COLUMNHEADERCENTER\'><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</font></th>\n\t\t\t\t<th class=\'columnHeadercenter\' width=\"10%\"  id=\'x1\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</th>\n\t\t\t\t<th class=\'columnHeadercenter\' width=\"10%\"  id=\'x\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</th>\n\t\t\t\t<th class=\'columnHeadercenter\' width=\'6%\' ID=\'h\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</th><!-- 38981--> \n\t\t\t\t<th class=\'columnHeadercenter\'   id=\'z\' width=\"9%\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</th>\n\t\t\t\t<th class=\'columnHeadercenter\'  id=\'sc\' width=\"6%\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</th> \n\t\t\t\t ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" \n\t\t\t\t\t <th class=\'columnHeader\' width=6%  >&nbsp;&nbsp;&nbsp;</th> \n\t\t\t\t ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" \n\t\t\t</tr>\n\n\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<tr><td class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' >&nbsp;</td><td class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>&nbsp;</td><td class=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'><img src=\'../../eCommon/images/Problems.gif\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td><td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' >&nbsp;</td>\n\n\t\t\t ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" \n\t\t\t\t\t <td class=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' width=6%  >&nbsp;</td> \n\t\t\t\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" \n\t\t\t\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t<!-- Added by Jeyachitra - ML-MMOH-CRF 1742 -->\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' ><font color=\'blue\' ><b>C</font></td>\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' >&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'><img src=\'../../eCommon/images/CurrentEncounter.gif\'></td>\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t<img src=\'../../eCommon/images/Differentials.gif\'></img>\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<!--<img src=\'../../eCommon/images/LinkView.gif\' align=\'right\' onclick=\'showProblem(\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\",\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\")\'> -->\n\t\t\t\t<img src=\'../../eCommon/images/LinkView.gif\' align=\'right\' onMouseOver=\'callMouseOverDiag(this,\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\")\' onMouseOut=\'callOnMouseOutDiag(this);\'>\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="<!--";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" -->";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="-->";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t<script>\n\t\t\t\tvar srl_no = ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =";\n\t\t\t\tvar termSetId = \'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\';\n\t\t\t\tvar termCode = \'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\';\n\t\t\t\tsrl_no_array[i] = srl_no;\n\t\t\t\tterm_set_id_array[i]= termSetId;\n\t\t\t\tterm_code_array[i]= termCode;\n\t\t\t\t//alert(\"QQ\"+srl_no_array[i]);\n\t\t\t\ti++;\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\n</table>\n</form>\n<!--<script>\n\t\t\n\t\tif(parent.problemsframe0.document.getElementById(\"th1\")==null)\n\t\t{\n\t\t\t\n\t\t\tsetTimeout(\"alignHeading();\",300);\n\t\t}\n\t\telse \n\t\t\talignHeading();\n</script> -->\n<div name=\'details\' id=\'details\' style=\'position:absolute; width:60%; visibility:hidden;\' bgcolor=\'blue\'>\n</body>\n</html>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection conn 	=	null;
	PreparedStatement stmt_in	=	null;
	PreparedStatement stmt1	=	null;
	PreparedStatement stmt2	=	null;
	PreparedStatement stmt3	=	null;
	PreparedStatement pstmt	=	null;
	ResultSet rs_in		=	null;
	ResultSet rs1		=	null;
	ResultSet rs2		=	null;
	ResultSet rs3		=	null;
	ResultSet res		=	null;
	PreparedStatement  pstmt_1 = null;
    ResultSet  rs_associatecodes = null;
	boolean isSiteSpecific=false;//IN069327
	boolean isDeceasedDiagClassDeathRegAppl = false; //Added by Jeyachitra - ML-MMOH-CRF 1742

try
{
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	conn 	=	ConnectionManager.getConnection(request);
	StringBuffer strBuff_sql = new StringBuffer();
	StringBuffer strsql_in = new StringBuffer();

	String facility_id= (String) session.getValue("facility_id");
	 isSiteSpecific = CommonBean.isSiteSpecific(conn, "MR","ALLOW_MULTI_DESC"); //IN069327
	 isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DECEASED_DIAG_CLASS_DEATH_REG"); //Added by Jeyachitra - ML-MMOH-CRF 1742

	int num_of_cols=4;
	//num_of_cols=num_of_cols;
	String diag_type="";
	int view_cnt = 0;
	//String occur_srl_no ="";checkstyle
	//String term_code_short_desc ="";checkstyle
	//String term_code			= ""; checkstyle

	int k=1;
	String prob_status	=	request.getParameter("probstatus");
	String sense_par	=	request.getParameter("pr");
	//String diagtype = request.getParameter("diag_type")==null?"": request.getParameter("diag_type");
	//****added for PH function usage
	String P_function_id=request.getParameter("P_function_id");
	

	//enchanced search
	String p_diag_code =request.getParameter("code")==null?"":request.getParameter("code");
	String encounter_id =request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	if (encounter_id.equals("0"))
			encounter_id="";
	String from_date =request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");

	from_date		=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
	to_date			=	com.ehis.util.DateUtils.convertDate(to_date,"DMY",locale,"en");
	//ends here

	String P_no_of_items=request.getParameter("P_no_of_items");
	if(P_no_of_items==null) P_no_of_items = "";
	String P_option_type=request.getParameter("P_option_type");
	String diag_stage="";
	//String orderBy=request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	//String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");

	String patientid	   = request.getParameter("Patient_Id");
	String context_value = request.getParameter("PQ");//request.getParameter("Context");
	if (context_value==null) context_value="Y";

	String modal_yn=request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	String strOnsetDate = "";

	String term_set_id = request.getParameter("term_set_id");
	if (term_set_id==null) term_set_id="";
	//out.println("<script>alert('@@@ term_set_id="+term_set_id+"@@@@');</script>");
	String support_exisist_yn = ""; //42995
	String short_desc = "";

	String oh_accession_num="";
	String curr_enc_yn="";
	String curr_accuracy_ind="";
	String diag_desc="";
	//String prob_cnt="";
	int prob_cnt=0;
	String complaint_id="";
    String complaint_desc="";
    String onset_datetime="";
	String classValue = "" ;
        String curr_remarks="";//38981
	String complaint_id_lyr ="";
	String complaint_desc_lyr ="";
	String onset_datetime_lyr ="";
	int index=0;
	StringBuffer layer = new StringBuffer();
	String diag_code_disp ="";
	String linkviewcnt_sql = "";
	String short_desc1 = "";//IN045225


            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

try
{

	if(prob_status == null){
		prob_status="A";
	}
	if (prob_status.equalsIgnoreCase("A")){
		strBuff_sql.append(" and A.CURR_STATUS ='A' ");
	}else{
		num_of_cols=5;
	}

	/*if(!diagtype.equals("")){
		strBuff_sql.append(" and DIAG_TYPE = '");
		strBuff_sql.append(diagtype);
		strBuff_sql.append("' ");
	}*/
	
	out.print("<table class='grid' align='center' name='tb1' id='tb1' border='1' width=100% cellspacing='0' cellpadding='3'>");
 
	
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
if(P_function_id.equals("PH")){
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
if(P_function_id.equals("PH")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
	
		if (sense_par==null){
			sense_par = "N";
		}

	/*	
		strsql_in.append("select srl_no,problem_status,decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') diag_scheme,diag_code_scheme,diag_code,diag_desc,nvl(sensitive_yn,'N') sensitive_yn,decode(DIAG_TYPE,'P','Provisional','D','Differential','F','Final') DIAG_TYPE,PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, to_char(CLOSE_DATE,'dd/mm/yyyy') CLOSE_DATE,DECODE(IP_DIAG_STAGE,'A','Admission','I','Intermediate','D','Discharge') diag_stage from pr_problem where patient_id=? "+strBuff_sql.toString()+" and NVL(error_yn,'N') !='Y' ");
		
		if(!encounter_id.equals(""))
			strsql_in.append(" and onset_encounter_id = ? ");
		strsql_in.append(" and   nvl(sensitive_yn,'N')=decode(?,'Y',nvl(sensitive_yn,'N'),'N') 		 AND DIAG_CODE = nvl(?,diag_code)	AND ONSET_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')  ");
//out.println(strsql_in);
			
			if (orderBy.equals("TYPE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by DIAG_TYPE desc ");
					}else{
							strsql_in.append(" order by DIAG_TYPE ");
					}
			}else if (orderBy.equals("ONDA")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by ONSET_DATE desc ");
					}else{
							strsql_in.append(" order by ONSET_DATE ");
					}
			}else if (orderBy.equals("DESC")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_desc desc ");
					}else{
							strsql_in.append(" order by diag_desc ");
					}
			}else if (orderBy.equals("STAG")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_stage desc ");
					}else{
							strsql_in.append(" order by diag_stage ");
					}
			}else if (orderBy.equals("CODE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_code desc ");
					}else{
							strsql_in.append(" order by diag_code ");
					}
			}else if (orderBy.equals("SCHE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_scheme desc ");
					}else{
							strsql_in.append(" order by diag_scheme ");
					}
			}else if (orderBy.equals("CLDA")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by CLOSE_DATE desc ");
					}else{
							strsql_in.append(" order by CLOSE_DATE ");
					}
			}else{
					strsql_in.append(" order by ONSET_DATE, diag_desc ");
			}
*/
		//strsql_in.append("select srl_no,problem_status,decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') diag_scheme,diag_code_scheme,diag_code,diag_desc,nvl(sensitive_yn,'N') sensitive_yn,DIAG_TYPE,PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, to_char(CLOSE_DATE,'dd/mm/yyyy') CLOSE_DATE,IP_DIAG_STAGE diag_stage from pr_problem where patient_id=? "+strBuff_sql.toString()+" and NVL(error_yn,'N') !='Y' ");
		
		//strsql_in.append("select A.OCCUR_SRL_NO srl_no,to_char(A.ADDED_DATE,'dd/mm/yyyy hh24:mi') rec_date,A.CURR_STATUS problem_status,C.TERM_SET_DESC diag_scheme,A.TERM_SET_ID diag_code_scheme,A.TERM_CODE diag_code,D.SHORT_DESC diag_desc1,a.TERM_CODE_SHORT_DESC diag_desc ,D.long_desc term_code_desc,D.sensitive_yn, 'D' DIAG_TYPE,'N' PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, DECODE(A.CURR_STATUS,'R',to_char(CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,");
		//strsql_in.append("select A.OCCUR_SRL_NO srl_no,to_char(A.ADDED_DATE,'dd/mm/yyyy hh24:mi') rec_date,A.CURR_STATUS problem_status,C.TERM_SET_DESC diag_scheme,A.TERM_SET_ID diag_code_scheme,A.TERM_CODE diag_code,D.SHORT_DESC diag_desc1,mr_get_desc.mr_term_code (a.term_set_id, a.term_code,'"+locale+"','2' ) diag_desc ,D.long_desc term_code_desc,D.sensitive_yn, 'D' DIAG_TYPE,'N' PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, DECODE(A.CURR_STATUS,'R',to_char(CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE, ");//IN036001 //Commentted IN045225
		//strsql_in.append("select A.OCCUR_SRL_NO srl_no,to_char(A.ADDED_DATE,'dd/mm/yyyy hh24:mi') rec_date,A.CURR_STATUS problem_status,C.TERM_SET_DESC diag_scheme,A.TERM_SET_ID diag_code_scheme,A.TERM_CODE diag_code,D.SHORT_DESC diag_desc1,mr_get_desc.mr_term_code (a.term_set_id, a.term_code,'"+locale+"','2' ) diag_desc ,D.long_desc term_code_desc,D.sensitive_yn, 'D' DIAG_TYPE,'N' PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, DECODE(A.CURR_STATUS,'R',to_char(CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,a.TERM_CODE_SHORT_DESC SHORT_DESC1, ");//IN045225
		strsql_in.append("select A.OCCUR_SRL_NO srl_no,to_char(A.ADDED_DATE,'dd/mm/yyyy hh24:mi') rec_date,A.CURR_STATUS problem_status,C.TERM_SET_DESC diag_scheme,A.TERM_SET_ID diag_code_scheme,A.TERM_CODE diag_code,D.SHORT_DESC diag_desc1,(case when a.term_code = '*OTH' then a.term_code_short_desc else mr_get_desc.mr_term_code (a.term_set_id, a.term_code,'"+locale+"','2' ) end) diag_desc ,D.long_desc term_code_desc,D.sensitive_yn, 'D' DIAG_TYPE,'N' PRIMARY_YN, to_char(ONSET_DATE,'dd/mm/yyyy') onset_date_str, DECODE(A.CURR_STATUS,'R',to_char(CURR_STATUS_DATE,'dd/mm/yyyy')) CLOSE_DATE,a.TERM_CODE_SHORT_DESC SHORT_DESC1, ");//IN045225//IN071908
		
		strsql_in.append("nvl((select enc_stage from pr_diagnosis_enc_dtl where patient_id = a.patient_id and term_set_id=a.TERM_SET_ID and term_code=a.TERM_CODE and facility_id=a.ONSET_FACILITY_ID "); 
		if(!encounter_id.equals(""))
		{
			strsql_in.append(" and encounter_id = ? ");
		}else{
			strsql_in.append(" and encounter_id = a.ONSET_ENCOUNTER_ID ");
		}
		strsql_in.append(" and rownum=1),'') diag_stage ");
		strsql_in.append(" , NVL((select 'Y' from PR_SUPPORT_DIAGNOSIS where patient_id = a.patient_id and term_set_id = a.term_set_id and term_code = a.term_code and occur_srl_no = a.occur_srl_no  and rownum = 1),'N') support_exisist_yn ");
		//added for GHL 41
		
	//	strsql_in.append(" ,(SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL g where g.TERM_SET_ID=A.TERM_SET_ID and (g.TERM_CODE=A.TERM_CODE OR g.TERM_CODE_SHORT_DESC=A.TERM_CODE_SHORT_DESC) AND  ENCOUNTER_ID=? AND  FACILITY_ID=? ) prob_cnt ,NVL((select 'Y' from PR_DIAGNOSIS_STATUS where patient_id =a.patient_id and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no and facility_id=? and encounter_id=? and rownum=1),'N')	curr_enc_yn ,a.accession_num,a.curr_accuracy_ind ");
		strsql_in.append(" ,(SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL g where g.TERM_SET_ID=A.TERM_SET_ID and (g.TERM_CODE=A.TERM_CODE OR g.TERM_CODE_SHORT_DESC=A.TERM_CODE_SHORT_DESC) AND  ENCOUNTER_ID=? AND  FACILITY_ID=? ) prob_cnt ,NVL((select 'Y' from PR_DIAGNOSIS_STATUS where patient_id =a.patient_id and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no and facility_id=? and encounter_id=? and rownum=1),'N')	curr_enc_yn ,a.accession_num,a.curr_accuracy_ind,a.curr_remarks");//38981

		//added for GHL 41 ends
		strsql_in.append(" from PR_Diagnosis A ,MR_TERM_CODE D,MR_TERM_SET C  where C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? "+strBuff_sql.toString());
		
		//IN053120 starts
			if(!encounter_id.equals(""))
				strsql_in.append("AND a.curr_encounter_id = ?");
		//IN053120 ends
		if(!encounter_id.equals(""))
			strsql_in.append(" and exists (select 1 from  pr_diagnosis_enc_dtl where PATIENT_ID=a.patient_id and TERM_SET_ID=A.TERM_SET_ID and TERM_CODE =A.TERM_CODE and FACILITY_ID=A.ONSET_FACILITY_ID and ENCOUNTER_ID= ? ) ");

		if(sense_par.equals("N"))
			strsql_in.append(" and nvl(D.sensitive_yn,'N') = 'N' ");

		strsql_in.append(" AND A.TERM_CODE = nvl(?,A.TERM_CODE)	AND A.ONSET_DATE BETWEEN TO_DATE(NVL(?,'1/1/1900'),'DD/MM/YYYY') and TO_DATE(NVL(?,'1/1/2500'),'DD/MM/YYYY')+.9999 and A.TERM_SET_ID=nvl(?,A.TERM_SET_ID) order by A.ONSET_DATE desc");

		
		String problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint a where a.facility_id= ? and a.encounter_id= ? and a.complaint_id not in (select b.complaint_id from PR_DIAGNOSIS_COMPL_ENC_DTL b where b.ENCOUNTER_ID= ? AND  b.FACILITY_ID=? ) order by a.onset_datetime";

		String linkDiagQry="select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text,to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and ( a.term_code = ? or  a.term_code_short_desc = ?) order by a.onset_date desc";

		stmt2 = conn.prepareStatement(linkDiagQry);

		stmt1 = conn.prepareStatement(problem_qry);
		stmt1.setString(1,facility_id);
		stmt1.setString(2,encounter_id);
		stmt1.setString(3,encounter_id);
		stmt1.setString(4,facility_id);
		/*out.println("facility_id = > "+facility_id);
		out.println("encounter_id = > "+encounter_id);
		out.println("encounter_id = > "+encounter_id);
		out.println("facility_id = > "+facility_id); */
		rs1 = stmt1.executeQuery();
		
		while(rs1.next())
		{

			complaint_id =rs1.getString("complaint_id")==null?"":rs1.getString("complaint_id");
			complaint_desc =rs1.getString("complaint_desc")==null?"":rs1.getString("complaint_desc");
			onset_datetime =rs1.getString("onset_datetime_str")==null?"":rs1.getString("onset_datetime_str");
			//Date Conversion is done by Archana Dhal on 10/7/2010 related to IN024213.
			onset_datetime	= com.ehis.util.DateUtils.convertDate(onset_datetime,"DMY","en",locale);

			classValue="gridData";
		
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(complaint_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(complaint_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(onset_datetime));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block51Bytes, _wl_block51);
if(P_function_id.equals("PH")){
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);


		}

		if(rs1 != null) rs1.close();
		if(stmt1 != null) stmt1.close();
		
		//out.println(strsql_in);
			
		/*	if (orderBy.equals("TYPE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by DIAG_TYPE desc ");
					}else{
							strsql_in.append(" order by DIAG_TYPE ");
					}
			}else if (orderBy.equals("ONDA")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by ONSET_DATE desc ");
					}else{
							strsql_in.append(" order by ONSET_DATE ");
					}
			}else if (orderBy.equals("DESC")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_desc desc ");
					}else{
							strsql_in.append(" order by diag_desc ");
					}
			}else if (orderBy.equals("STAG")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_stage desc ");
					}else{
							strsql_in.append(" order by diag_stage ");						}
			}else if (orderBy.equals("CODE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_code desc ");
					}else{
							strsql_in.append(" order by diag_code ");
					}
			}else if (orderBy.equals("SCHE")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by diag_scheme desc ");
					}else{
							strsql_in.append(" order by diag_scheme ");
					}
			}else if (orderBy.equals("CLDA")){
					if(reOrder.equals("1")){
							strsql_in.append(" order by CLOSE_DATE desc ");
					}else{
							strsql_in.append(" order by CLOSE_DATE ");
					}
			}else{
					strsql_in.append(" order by ONSET_DATE, diag_desc ");
			}*/

		String sense_yn = "N";
		//String srl_no ="";
		StringBuffer associate_codes = new StringBuffer();
		int count=0,i = 1;
		
		stmt_in = conn.prepareStatement(strsql_in.toString());
		if(!encounter_id.equals("")){
			stmt_in.setString(i++,encounter_id);
					//out.println("encounter_id = > "+encounter_id);
		}

		stmt_in.setString(i++,encounter_id);
				//out.println("encounter_id = > "+encounter_id);
		stmt_in.setString(i++,facility_id);
		stmt_in.setString(i++,facility_id);
		//out.println("facility_id = > "+facility_id);
		//out.println("facility_id = > "+facility_id);
		stmt_in.setString(i++,encounter_id);
			//out.println("encounter_id = > "+encounter_id);

		stmt_in.setString(i++,patientid);
		//out.println("patientid = > "+patientid);
		//IN053120 starts
			if(!encounter_id.equals(""))
				stmt_in.setString(i++,encounter_id);
		//IN053120 ends
		if(!encounter_id.equals("")){
			stmt_in.setString(i++,encounter_id);
			//out.println("encounter_id = > "+encounter_id);
		}
		//stmt_in.setString(i++,sense_par);
		stmt_in.setString(i++,p_diag_code);
		//out.println("p_diag_code = > "+p_diag_code);
		stmt_in.setString(i++,from_date);
		stmt_in.setString(i++,to_date);
		stmt_in.setString(i++,term_set_id);
		//out.println("from_date = > "+from_date);
		//out.println("to_date = > "+to_date);
		//out.println("term_set_id = > "+term_set_id);
		rs_in = stmt_in.executeQuery();

		if (rs_in != null)
		{
			while(rs_in.next())
			{
				String srl_no_associate_code = rs_in.getString("srl_no");
				String diag_code = rs_in.getString("diag_code");
				String diag_code_scheme = rs_in.getString("diag_code_scheme");
				String diag_scheme = rs_in.getString("diag_scheme");
//				String rec_date=rs_in.getString("rec_date");
				strOnsetDate	= rs_in.getString("onset_date_str");
				support_exisist_yn	= rs_in.getString("support_exisist_yn");
				short_desc	= rs_in.getString("term_code_desc");
				String stat_temp=rs_in.getString("problem_status");
	
				prob_cnt= rs_in.getInt("prob_cnt");
				curr_enc_yn= rs_in.getString("curr_enc_yn");
				oh_accession_num = rs_in.getString("accession_num")==null?"":rs_in.getString("accession_num");
				curr_accuracy_ind = rs_in.getString("curr_accuracy_ind")==null?"":rs_in.getString("curr_accuracy_ind");
				diag_desc = rs_in.getString("diag_desc")==null?"":rs_in.getString("diag_desc");//Added by Archana Dhal on 10/14/2010 related to incident no. IN024424.
				short_desc1	= rs_in.getString("SHORT_DESC1")==null?"":rs_in.getString("SHORT_DESC1");//IN045225
				
				strOnsetDate	= com.ehis.util.DateUtils.convertDate(strOnsetDate,"DMY","en",locale);
				curr_remarks	= rs_in.getString("curr_remarks")==null?"":rs_in.getString("curr_remarks");//38981

				/*added values */
			
				sense_yn = rs_in.getString("sensitive_yn");
				diag_type = rs_in.getString("DIAG_TYPE") == null ? "&nbsp;" : rs_in.getString("DIAG_TYPE");
	
				//if(diag_type == null || diag_type.equals("null"))diag_type="&nbsp";
				diag_stage = rs_in.getString("diag_stage");
				
				if(diag_stage == null || diag_stage.equals("null") || diag_stage.equals(""))diag_stage="&nbsp";
				if(!isSiteSpecific){//IN069327
					//IN045225 - Start
					if(!diag_code.equals("*OTH"))
						short_desc1 = diag_desc;
					//IN045225 - End
				}//IN069327
				diag_code_disp = diag_code;


				//out.println("<script>alert('"+sense_yn+"');</script>");
				if(diag_stage.equals ("A"))
				{				
				diag_stage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
				}	
				else if(diag_stage.equals("I"))
				{
				diag_stage =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				}	
				else if(diag_stage.equals("D"))
				{
				diag_stage =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
				}

				if(diag_type.equals ("P"))
				{				
				diag_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Provisional.label","common_labels");
				}	
				else if(diag_type.equals("D"))
				{
				diag_type =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Differential.label","common_labels");
				}	
				else if(diag_type.equals("F"))
				{
				diag_type =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");
				}

				
				String sql_assosicate_code = "select a.support_diag_code , b.short_desc, b.long_desc from pr_problem_detail a, mr_term_code b where a.patient_id =? and   a.srl_no =? and a.diag_code = ? and b.TERM_SET_ID = ? and b.term_code = a.support_diag_code" ;

				pstmt_1 = conn.prepareStatement(sql_assosicate_code);
				pstmt_1.setString(1, patientid);
				pstmt_1.setString(2, srl_no_associate_code);
				pstmt_1.setString(3, diag_code);
				pstmt_1.setString(4, diag_code_scheme);
				//out.println("<script>alert('"+patientid + "-" + srl_no_associate_code+ "-"+ diag_code+ "-"+diag_code_scheme+"');</script>");

				//out.println(sql_assosicate_code);

				rs_associatecodes = pstmt_1.executeQuery();
				int temp_associate_code = 0;
				while(rs_associatecodes.next())
				{
					String temp_supporting_code = rs_associatecodes.getString("support_diag_code");
					String temp_short_desc = rs_associatecodes.getString("short_desc");
					String long_desc_associatecode = rs_associatecodes.getString("long_desc");
					if(temp_associate_code == 0)
						associate_codes.append(temp_supporting_code + "~" + temp_short_desc+ "~" +long_desc_associatecode);
					else
						associate_codes.append("|" + temp_supporting_code + "~" + temp_short_desc+ "~" +long_desc_associatecode);	
					//out.println("<script>alert('"+associate_codes+"-- "+temp_supporting_code+"');</script>");
					temp_associate_code++;
				}
				
                if(rs_associatecodes!=null)	rs_associatecodes.close();
	            if(pstmt_1!=null) pstmt_1.close();
				
				
				String diagType="";

				String width="";
				if (prob_status.equals("O")) 
					width="28%";
				else 
					width="30%";
				
				if(sense_yn.equals("Y"))
					classValue = "PATQRED";
				else
					classValue = "gridData" ;
				
				diagType= rs_in.getString("DIAG_TYPE") == null ? "&nbsp;" : rs_in.getString("DIAG_TYPE");

				if( diagType.equals("Final"))
						diagType="<b>"+ diagType +"</b>";
				
				
				out.print("<tr>");
				//out.println("<td  class='" + classValue +"' width='10%'> <font size='1'>" + diagType  +"</font> </td>");
				
            _bw.write(_wl_block55Bytes, _wl_block55);
if(isDeceasedDiagClassDeathRegAppl)
			{
				try
				{
					pstmt = conn.prepareStatement("select * from mr_rec_diag_audit_trial where patient_id=? and encounter_id=? and term_code=? and occur_srl_no=? and facility_id=? and term_Set_id=?");
					pstmt.setString(1, patientid);
					pstmt.setString(2, encounter_id);
					pstmt.setString(3, diag_code);
					pstmt.setString(4, srl_no_associate_code);
					pstmt.setString(5, facility_id);
					pstmt.setString(6, diag_code_scheme);
					
					res= pstmt.executeQuery();
					
					if(res!=null && res.next())
					{
						out.println("<td class='" + classValue + "' nowrap><a href='javascript:displayAuditTrial(\"" + patientid + "\",\"" + diag_code + "\",\"" + diag_code_scheme + "\",\"" + encounter_id + "\",\"" + facility_id + "\",\"" + srl_no_associate_code + "\")'>Audit Trail</a></td>");
					}
					else
					{
						out.println("<td class='"+classValue+"' nowrap>&nbsp;</td>");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					if(res!=null) res.close();
					if(pstmt!=null) pstmt.close();		
				}
			}
			
            _bw.write(_wl_block56Bytes, _wl_block56);
 if(!oh_accession_num.equals("")){ 
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
}else{
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
if(curr_enc_yn.equals("Y")){
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
}else{
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(diag_scheme));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
 if(curr_accuracy_ind.equals("U")){
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(diag_code_disp));
            _bw.write(_wl_block56Bytes, _wl_block56);

			
			if(prob_cnt>0){
				
			stmt2.setString(1,locale);
			stmt2.setString(2,facility_id);
			stmt2.setString(3,encounter_id);
			stmt2.setString(4,diag_code_scheme);
			stmt2.setString(5,diag_code);
			stmt2.setString(6,short_desc);

			rs2 = stmt2.executeQuery();
			layer.setLength(0);
			while(rs2.next())
			{
								
				complaint_id_lyr =rs2.getString("complaint_id")==null?"":rs2.getString("complaint_id");
				complaint_desc_lyr =rs2.getString("complaint_text")==null?"":rs2.getString("complaint_text");
				onset_datetime_lyr =rs2.getString("onset_datetime_str")==null?"":rs2.getString("onset_datetime_str");
				//Date Conversion is done by Archana Dhal on 10/7/2010 related to IN024213.
				onset_datetime_lyr = com.ehis.util.DateUtils.convertDate(onset_datetime_lyr,"DMYHM","en",locale);
				
				layer.append("<tr><td class=gridData nowrap>"+complaint_id_lyr+"</td>"+
							"<td class=gridData>"+complaint_desc_lyr+"</td>"+
							"<td class=gridData>"+onset_datetime_lyr+"</td></tr>");
	

			}
			if(rs2 != null) rs2.close();

			out.println("<script>detailArray["+index+"]='"+layer.toString()+"';</script>");

			//Below if and else condition is added by Archana Dhal on 10/14/2010 related to incident no. IN024424.
			if(!diag_code.equals("*OTH"))
			{
					// linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND  TERM_CODE = '"+diag_code+"' and OCCUR_SRL_NO='"+srl_no_associate_code+"'";//common-icn-0180
					 linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID= ? AND  FACILITY_ID= ? AND  TERM_CODE = ? and OCCUR_SRL_NO=?";//common-icn-0180

					  stmt3=conn.prepareStatement(linkviewcnt_sql);
					//common-icn-0180 starts
					  stmt3.setString(1,encounter_id);
					  stmt3.setString(2,facility_id);
					  stmt3.setString(3,diag_code);
					  stmt3.setString(4,srl_no_associate_code);
					//common-icn-0180 ends
			}
           else
			{

			linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO='"+srl_no_associate_code+"'";//common-icn-0180
			linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID= ? AND  FACILITY_ID= ? AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO= ?";//common-icn-0180
					
			stmt3=conn.prepareStatement(linkviewcnt_sql);
			//common-icn-0180 starts
			stmt3.setString(1,encounter_id);
			stmt3.setString(2,facility_id);
			stmt3.setString(3,diag_desc);
			stmt3.setString(4,srl_no_associate_code);
			//common-icn-0180 ends 
			}
				
			rs3=stmt3.executeQuery();
			if(rs3 != null && rs3.next())
			  {
				view_cnt = rs3.getInt(1);
			  }
			if(stmt3 != null) stmt3.close();//checkstyle
			if(rs3 != null) rs3.close();//checkstyle
			
			if(view_cnt !=0 )
				{


			
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(diag_scheme));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(index));
            _bw.write(_wl_block68Bytes, _wl_block68);

				}
			 index++;
				}
			
            _bw.write(_wl_block56Bytes, _wl_block56);

					
				
				if (sense_yn.equalsIgnoreCase("Y"))
				{
					
					count++;
				//	out.print("<td class='PATQRED' class='"+classValue+"'  width='20%'> <a id='"+count+"' class='gridLink'  href='javascript:rfresh(\""+count+"\")'>"); //IN041797 Commented
					out.print("<td class='PATQRED' class='"+classValue+"'  width='20%'> <span class='slink'><a id='"+count+"' class='gridLink'  href='javascript:rfresh(\""+count+"\")'>"); //IN041797 
					//out.print("<font size=1>"+diag_desc);//'diag_desc' is passed instead of 'diag_desc1' modified by Archana Dhal on 10/14/2010 related to incident no. IN024424.//commentted IN045225
					out.print("<font size=1>"+short_desc1);// 'short_desc1' passed instead of diag_desc to handle *OTH value //IN045225
					if(rs_in.getString("PRIMARY_YN").equals("Y"))
					  out.print("&nbsp;&nbsp;<font color=RED><b>*</b></font>");
					
					//out.print("</font></a></td>");
					out.print("</font></a></span></td>"); //IN041797 
					
					//out.print("<td   class='"+classValue+"'  width='10%'>");

					out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>"+diag_stage+"</font> </td>");

					/*if(diagType.equals("A")){
					out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");*/
					
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
//out.println("</font> </td>");
					//}else if (diagType.equals("I")){
					//out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");
					
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
//out.println("</font> </td>");
					//}else if (diagType.equals("D")){
					//out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");
					
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
//out.println("</font> </td>");
					/*}
					else {
					out.println("<td  class='"+classValue+"' width='10%'> &nbsp;</td>");
							}*/
					/***************/
					
					//out.print("<td    class='"+classValue+"' width='10%'>");
					//out.print("<font size=1>"+diag_stage+"</font></td>");

					//out.print("<td   class='"+classValue+"' width='7%'>");
					//out.print("<font size=1>"+diag_code+"</font></td>");
					//out.print("<td  class='"+classValue+"' width='10%'>");
					//out.print("<font size=1>"+diag_scheme+"</font></td>");

					
					out.println("<td  class='"+classValue+"'  width='10%'> <font size='1'>" + strOnsetDate +"</font> </td>");
					if(prob_status.equals("O"))
					{
						out.print("<td class='"+classValue+"' width='6%'>");
						String stat=rs_in.getString("problem_status");

						if(stat.equals("A"))
								stat="Active";
						else if (stat.equals("E"))
							stat="In Error";
						else if (stat.equals("X"))
							stat="Revoked";
						else
								stat="Resolved";
						out.print("<font size=1>"+stat+"</font></td>");						
					}
					else if(prob_status.equals("A"))
					{
						out.print("<td class='"+classValue+"' width='6%'>");
						String stat = "Active";
						out.print("<font size=1>"+stat+"</font></td>");
					}

					//out.print("<font size=1>"+rec_date+"</font></td>");

					//***
					String c_date = rs_in.getString("close_date")==null?"&nbsp;":rs_in.getString("close_date");

					if(!c_date.equals("&nbsp;") )
						c_date = com.ehis.util.DateUtils.convertDate(c_date,"DMY","en",locale);

					out.println("<td  class='"+classValue+"' width='9%'> <font size='1'>" + c_date  +"</font> </td>");
					if(support_exisist_yn.equals("Y"))
					{
						out.println("<td class='"+classValue+"' width='8%'><font size=1>");
						out.println("<a class='gridLink'  href=\"javascript: ShowSupportingDiag('" + diag_code+"','"+srl_no_associate_code+"','"+patientid+"','"+diag_code_scheme+"','"+short_desc+"("+diag_code+")"+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
						out.println("</font></td>");
					}
					else
					{
						out.print("<td class='"+classValue+"'> &nbsp;</td>");
					}
					//***
					if(P_function_id.equals("PH")){
						if(P_option_type.equals("ALL"))
						{
							out.print("<td class='"+classValue+"' width='6%'>");
							out.print("<input type='checkbox' id='ch"+count+"'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+diag_desc+"' > </td>");
						}
						else if(P_option_type.equals("ACTIVE"))
						{
							if(rs_in.getString("problem_status").equals("A"))
							{
								out.print("<td class='"+classValue+"' width='6%' >");
								out.print("<input type='checkbox' id='ch"+count+"' onclick='onCheck(this)'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+diag_desc+"' ></td>");
							}
							else
							{
								out.print("<td class='"+classValue+"' width='6%' >&nbsp;</td>");
							}
						}
					}
					//***
					//aname++;

				}
				else if (sense_yn.equalsIgnoreCase("N"))
				{
					
					//onclick = '' changeRowColor(this,"+num_of_cols+");
					count++;
					//out.print("<td  class='"+classValue+"' width='20%'> <a id='"+count+"'  class='gridLink'  href='javascript:rfresh(\""+count+"\")'><font size='1'>");
					out.print("<td  class='"+classValue+"' width='20%'> <span class='slink'><a id='"+count+"'  class='gridLink'  href='javascript:rfresh(\""+count+"\")'><font size='1'>");//IN041797
					//out.print("<font size=1>"+diag_desc);//Commented IN045225
					out.print("<font size=1>"+short_desc1);//IN045225
					if(rs_in.getString("PRIMARY_YN").equals("Y"))
					  out.print("&nbsp;&nbsp; <font color=RED><b>*</b></font>");
					//out.print("</font></a></td>");
					out.print("</font></a> </span></td>");//IN041797
					out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>"+diag_stage+"</font> </td>");
					//if(diagType.equals("A")){
					//out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");
					
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
///out.println("</font> </td>");
					//}else if (diagType.equals("I")){
					//out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");
					
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
//out.println("</font> </td>");
					//}else if (diagType.equals("D")){
					//out.println("<td  class='"+classValue+"' width='10%'> <font size='1'>");
					
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
//out.println("</font> </td>");
					/*}
					else {
					out.println("<td  class='"+classValue+"' width='10%'> &nbsp;</td>");
							}*/
					/***************/
					out.println("<td  class='"+classValue+"'  width='10%'> <font size='1'>" + strOnsetDate +"</font> </td>");
					
					//out.print("<td  class='"+classValue+"' width='10%'>");
					//out.print("<font size=1>"+diag_stage+"</font></td>");
					//out.print("<td  class='"+classValue+"' width='7%'>");
					//out.print("<font size=1>"+rs_in.getString("diag_code")+"</font></td>");
					//out.print("<td  class='"+classValue+"' width='10%'>");
					//out.print("<font size=1>"+rs_in.getString("diag_scheme")+"</font></td>");

					if(prob_status.equals("O"))
					{
					String stat=rs_in.getString("problem_status");
						if (stat.equals("C")){		
							classValue="gray";
						}
						out.print("<td class='"+classValue+"' width='6%'>");

					
						if(stat.equals("A"))
								stat="Active";
						else if (stat.equals("B"))
								stat="Better";
						else if (stat.equals("W"))
								stat="Worse";
						else if (stat.equals("S"))
							stat="Same";
						else if (stat.equals("E"))
							stat="In Error";
						else if (stat.equals("X"))
							stat="Revoked";
						else {
							stat="Resolved";

						//classValue="";		//IN041797 commented
						}

					out.print("<font size=1>"+stat+"</font></td>");

					}
					else if(prob_status.equals("A"))
					{
						out.print("<td class='"+classValue+"' width='6%'>");
						String stat = "Active";
						out.print("<font size=1>"+stat+"</font></td>");
					}

				//	out.print("<td  class='"+classValue+"' width='10%'>");					
				//	out.print("<font size=1>"+rec_date+"</font></td>");
					//***
				/*	if(P_function_id.equals("PH")){

						if(P_option_type.equals("ALL"))
						{
							out.print("<td class='" + classValue + "' width='6%'>");
							out.print("<input type='checkbox' id='ch"+count+"'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+rs_in.getString("diag_desc")+"' ></td>");
						}
						else if(P_option_type.equals("ACTIVE"))
						{
							//if(rs_in.getString("probem_status").equals("A"))
							if(prob_status.equals("A"))
							{
								out.print("<td class='" + classValue + "' width='6%' >");
								out.print("<input type='checkbox' id='ch"+count+"'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+rs_in.getString("diag_desc")+"' ></td>");
							}
							else
							{
								out.print("<td class='" + classValue + "' width='6%' >&nbsp;</td>");
							}
						}
					}*/
					//***
					
				 	//38981 start
                 if(curr_remarks!="")
				  {
					  out.println("<td class='"+classValue+"' width='8%'><font size=1>");
                	//out.println("<a class='gridLink'  href=\"javascript: ShowRemarksDiag('" + curr_remarks+ "')\"             >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
			         out.println("<a class='gridLink'  href=\"javascript: ShowRemarksDiag('"+patientid+"','"+diag_code+"','"+diag_code_scheme+"','"+diag_scheme+"','"+srl_no_associate_code+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");//42995
					  out.println("</font></td>");
				  }
				else
				{
					out.print("<td class='"+classValue+"'> &nbsp;</td>");
				}
					//38981 end 
					String c_date = rs_in.getString("close_date")==null?"&nbsp;":rs_in.getString("close_date");
					if(!c_date.equals("&nbsp;") )
						c_date = com.ehis.util.DateUtils.convertDate(c_date,"DMY","en",locale);
				out.println("<td  class='"+classValue+"' width='9%'> <font size='1'>" + c_date  +"</font> </td>");
				//38981 start
				if(support_exisist_yn.equals("Y"))
				{
					out.println("<td class='"+classValue+"' width='8%'><font size=1>");
					out.println("<a href=\"javascript: ShowSupporting('" + diag_code+"','"+srl_no_associate_code+"','"+patientid+"','"+diag_code_scheme+"','"+(java.net.URLEncoder.encode(diag_desc))+"("+diag_code+")"+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
					out.println("</font></td>");
				}
				else
				{
					out.print("<td class='"+classValue+"'> &nbsp;</td>");
				}
				//38981 end

				// moved to here ---shaiju

				//***
					if(P_function_id.equals("PH")){

						if(P_option_type.equals("ALL"))
						{
							out.print("<td class='"+classValue+"' width='6%'>");
							out.print("<input type='checkbox' id='ch"+count+"'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+diag_desc+"' ></td>");
						}
						else if(P_option_type.equals("ACTIVE"))
						{
							
							//if(rs_in.getString("probem_status").equals("A"))
							
							/**Commented by Ambiga on 12/2/2009 at 3:11 PM for IN016795 ****/
							/*if(prob_status.equals("A"))
							{*/
							/***Commented by Ambiga on 12/2/2009 at 3:11 PM for IN016795 ***/
							if(!(stat_temp.equals("E")))//added by Ambiga for IN016795
							{
								out.print("<td class='"+classValue+"' width='6%' >");
								out.print("<input type='checkbox' id='ch"+count+"'  onclick='onCheck(this)'><input type='hidden' id='hid"+count+"' value='"+rs_in.getString("diag_code")+"|"+diag_desc+"' ></td>");
							
							/***Commented by Ambiga on 12/2/2009 at 3:11 PM for IN016795 ***/
							}
							else
							{
								out.print("<td class='"+classValue+"' width='6%' >&nbsp;</td>");
							}
							/***Commented by Ambiga on 12/2/2009 at 3:11 PM for IN016795 ***/
						}
					}
					//***




				// shaiju

				out.print("</tr>");
					//out.println("c_date :"+c_date);
					//aname++;

				}

					//out.print("<input type='hidden' name='srl_no' id='srl_no' value='"+rs_in.getString("srl_no")+"'>"+"</td></tr>");
					//srl_no = rs_in.getString("srl_no");
					//out.println("srl_no "+srl_no);

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rs_in.getString("srl_no")));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(rs_in.getString("diag_code_scheme")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(rs_in.getString("diag_code")));
            _bw.write(_wl_block75Bytes, _wl_block75);


			k++;
			associate_codes = new StringBuffer();
			}

		}
}catch(Exception e)
{
	//out.print(e.toString());//COMMON-ICN-0181
     e.printStackTrace() ;
		

}


            _bw.write(_wl_block76Bytes, _wl_block76);

}catch(Exception e){
	//out.println(e);//COMMON-ICN-0181
	e.printStackTrace();
}finally
{
	if(rs_in!=null)	rs_in.close();
	if(stmt_in!=null) stmt_in.close();
	if(stmt2!=null) stmt2.close();
	
	if(rs1 != null) rs1.close();//IN053120
	if(rs2 != null) rs2.close();//IN053120
	if(rs3 != null) rs3.close();//IN053120
	if(rs_associatecodes != null) rs_associatecodes.close();//IN053120
	if(pstmt_1!=null) pstmt_1.close();//IN053120
	if(stmt1 != null) stmt1.close();//IN053120
	if(stmt3 != null) stmt3.close();//IN053120
	if(conn != null)ConnectionManager.returnConnection(conn,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Complaint.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Complaint.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RecordedDateAndTime.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.scheme.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CloseDate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SupportingDiagCode.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Set.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Problem.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DiagnosisRemarks.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CloseDate.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SupportingDiagCode.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Intermediate.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discharge.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Intermediate.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discharge.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }
}
