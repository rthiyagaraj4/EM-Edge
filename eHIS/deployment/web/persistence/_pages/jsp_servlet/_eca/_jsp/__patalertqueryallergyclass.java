package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patalertqueryallergyclass extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatAlertQueryAllergyClass.jsp", 1731574081548L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           \tcreated\n25/09/2012    IN034975      Chowminya G     In Allergy List web page & View Alert web page ? system isn?t displaying the new field ?Reason? column \n01/02/2013    IN037367      Chowminya G     If patient have ADR recorded, in PH. Allergen not visible in CA veiw Alert.\n05/02/2018\t  IN066228\t\tKamalakannan G\tModified query for adding other allergen (ML-MMOH-CRF-0751)\n--------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<!-- ****  Modified by kishor kumar n on 04/12/2008 for crf0387 applied new css grid. **** -->\n\t\t\n\t\t\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n      \t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n      \t<script>\n\t\tvar srl_no_array = new Array();\n      \tvar prev1=0;\n\t\tvar prev=1\n      \tvar i=0;\n      \tfunction rfresh()\n      \t{\n\t\t\talert();\n\t\tvar remarks=document.forms[0].remarks.value;\n\t\tparent.PatAlertQueryResult.location.href=\"PatAlertQueryResult.jsp?&remarks=\"+remarks+\"&call_from=allergy&srl_no=\"+srl_no_array[prev1]+\"&patient_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n      \t\n\t\t}\n\n\n      \tfunction refer(ro,numofcols )\n      \t{\t  alert();\n\t\t\t\tprev1\t=ro.rowIndex\n\t\t\tfor (var i=0;i<numofcols;i++)\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"tb1\").rows[prev].cells[i].style.backgroundColor = ro.bgColor;\n\t\t\t}\n\n\t\t\tfor (var i=0;i<numofcols;i++)\n\t\t\t\tro.cells[i].style.backgroundColor=\"#B2B6D7\"\n\n\t\t\tprev\t=ro.rowIndex\n      \t}\n\n\t\t/*function changeWidth()  patient_id\n\t\t{\n\t\tparent.frames[0].document.getElementById(\"cw\").width=document.getElementById(\"id1\").width\n\t\tparent.frames[0].document.getElementById(\"h\").width=document.getElementById(\"id3\").width\n\t\t}*/\n      \t function display_records(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)\n{\n\t\t\tparent.frames[1].document.getElementById(\'detail\' + obj).innerHTML=\"<a  class=\'gridLink\' href=\\\"javascript:display_records1(\'\"+obj+\"\',\'\"+PatientId+\"\',\'\"+causative_code+\"\',\'\"+adv_event_type_ind_code+\"\',\'\"+adv_event_type_code+\"\',\'\"+reaction_date1+\"\',\'\"+status+\"\',\'\"+error_status+\"\',\'\"+onset_date+\"\')\\\"><font color=\'black\' bgcolor=\'#FF9933\'>-</font></a>\";\n\t/* var xmlDoc=new ActiveXObject(\"Microsoft.XMLDom\")\n\tvar xmlHttp = new XMLHttpRequest()  */\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\txmlStr =\"<root><SEARCH PatientId=\\\"\"+PatientId+\"\\\"  adv_event_type_ind_code=\\\"\"+adv_event_type_ind_code+\"\\\" adv_event_type_code=\\\"\"+adv_event_type_code+\"\\\" causative_code=\\\"\"+causative_code+\"\\\"\treaction_date1=\\\"\"+reaction_date1+\"\\\"  cnt=\\\"\"+obj+\"\\\"  status=\\\"\"+status+\"\\\" error_status=\\\"\"+error_status+\"\\\" onset_date=\\\"\"+onset_date+\"\\\" det=\'add\' steps=\'6\'/></root>\"\n\t\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\txmlHttp.open(\"POST\",\"../../eCA/jsp/AdverseEventType.jsp\",false)\t\t   \n\txmlHttp.send(xmlDoc)\n\tresponseText=xmlHttp.responseText\n\tresponseText = trimString(responseText)\n\teval(responseText)\n}\n\nfunction display_records1(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date)\n{\n\tparent.frames[1].document.getElementById(\'detail\' + obj).innerHTML=\"<a class=\'gridLink\' href=\\\"javascript:display_records(\'\"+obj+\"\',\'\"+PatientId+\"\',\'\"+causative_code+\"\',\'\"+adv_event_type_ind_code+\"\',\'\"+adv_event_type_code+\"\',\'\"+reaction_date1+\"\',\'\"+status+\"\',\'\"+error_status+\"\',\'\"+onset_date+\"\')\\\"><font color=\'black\'>+</font></a>\";\n\t\n\n\t/* var xmlDoc=new ActiveXObject(\"Microsoft.XMLDom\")\n\tvar xmlHttp = new XMLHttpRequest()  */\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\txmlStr =\"<root><SEARCH PatientId=\\\"\"+PatientId+\"\\\"  adv_event_type_ind_code=\\\"\"+adv_event_type_ind_code+\"\\\" adv_event_type_code=\\\"\"+adv_event_type_code+\"\\\" causative_code=\\\"\"+causative_code+\"\\\"\treaction_date1=\\\"\"+reaction_date1+\"\\\"  cnt=\\\"\"+obj+\"\\\" det=\'sub\' status=\\\"\"+status+\"\\\" error_status=\\\"\"+error_status+\"\\\" onset_date=\\\"\"+onset_date+\"\\\"  steps=\'6\'/></root>\"\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\txmlHttp.open(\"POST\",\"../../eCA/jsp/AdverseEventType.jsp\",false)\n\txmlHttp.send(xmlDoc)\n\tresponseText=xmlHttp.responseText\n\tresponseText = trimString(responseText)\n\teval(responseText)\n\t\n}\nfunction callonload()\n{\n\tvar tot_allr=document.forms[0].rowcolor.value;\n//parent.frames[0].document.forms[0].all.third1.style.display=\'inline\';\n//\tparent.frames[0].document.forms[0].all.third1.style.display=\'visible\';\n\n}\t\n\t\n</script>  \n</head>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >\n\t <form name = \'chk_val\'>\n\t<table class=\'grid\' width=\'100%\'  id=\'record\'>\n\t<tr>\n\t\t<th align=\'left\' nowrap colspan=\'6\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th></th>\n\t</tr>\n\t<tr>\n\t\t<th width=\'3%\'><div  id=\'head1\'  class=\'myClass\' nowrap width=\'3%\'>&nbsp;&nbsp;</div></th>\n\t\t<th width=\'15%\'><div  id=\'head2\' class=\'myClass\' nowrap width=\'24%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div></th>\n\t\t<th width=\'15%\'><div  id=\'head3\' class=\'myClass\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div></th>\n\t\t<th width=\'15%\'><div  id=\'head4\' class=\'myClass\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div></th>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<th width=\'15%\'><div  id=\'head5\' class=\'myClass\' nowrap width=\'23%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</div></th>\n\t\t<th width=\'15%\'><div  id=\'head6\' class=\'myClass\' nowrap width=\'23%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</tr>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\t\t\t<tr id=\'first\' >\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\t\t\t<td  class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' nowrap id=\'detail";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'><a class=\'classValue1\' href=\"javascript:onclick=display_records1(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\">&nbsp;-&nbsp;</a>\n\t\t\t</td>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\n\t\t\t\n\t\t<!--\t<td  class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>&nbsp;&nbsp;\n\t\t\t</td> -->\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n\n\t\t\t<td  class=\'gridData\' nowrap >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t<td   class=\'gridData\' nowrap id=\'header\'><a class=\'gridLink\' href=\"javascript:onclick=display_header(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\">\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t</td>\n\t\t\t<td  class=\'gridData\' nowrap >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<img src=\'../../eCA/images/mc_history.gif\' BORDER=\'0\' style=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'> </td>\n\t\t\t  \n\t\t\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<!-- added for IN066228 -->\n\t\t\t<td  class=\'gridData\' nowrap >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<td  class=\'gridData\' nowrap >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="(";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =")<img src=\'../../eCommon/images/mandatory.gif\' ></img></td>\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<td class=\'gridData\'  nowrap width= \'15%\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t\t\t<tr id=\'third";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' Style=\"visibility:visible\">\n\t\t\t<td  class=\'gridData\' nowrap >&nbsp;</td>\n\t\t\t<td class=gridData  nowrap><b>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</b></th>\n\t\t\t<td class=gridData  nowrap><b>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</b></th>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t<td class=\'gridData\'  nowrap width= \'15%\'> </td>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\n\t\t\t\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\n\t\t\t<tr id=\'second";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' Style=\"visibility:visible\" >\n\t\t\t<td  class=\'gridData\' nowrap >&nbsp;</td>\n\t\t\t<td  class=\'gridData\' nowrap >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\n\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t<td  class=\'gridData\' nowrap >";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t<td  class=\'gridData\' nowrap >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t<tr id=\'third";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' Style=\"display:none;visibility:hidden\" >\n\t\t\t<td  class=\'gridData\' nowrap >&nbsp;</td>\n\t\t\t<td class=gridData align=center nowrap>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t\t<td class=gridData align=center nowrap >";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t<td class=gridData align=center nowrap>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\n\t\t\t</tr>\n\t\t<tr id=\'second";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>  \n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\n\t\t\t</tr>\n\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</table>\n\t\t\t\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t<table id=\'tooltiptable\' class=\'grid\'  width=\'auto\' height=\'100%\' align=\'center\'>\n\t\t\t<tr><td width=\'100%\' id=\'t\'></td></tr>\n\t\t</table>\n\t</div>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n\t<input type=\"hidden\" name=\"detail\" id=\"detail\" value=\"\" >\n\t<input type=\"hidden\" name=\"rowcolor\" id=\"rowcolor\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t<input type=\"hidden\" name=\"cnt\" id=\"cnt\" value=\"\" >\n\t<input type=\"hidden\" name=\"flag1\" id=\"flag1\" VALUE=\"\">\n\n\t<input type=\"hidden\" name=\"PatientId\" id=\"PatientId\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t<input type=\"hidden\" name=\"Encounter_Id\" id=\"Encounter_Id\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n  </form>\n</body>\n\t ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t<script>\n\tfunction \tdisplay_header(patient_id,adv_event_type_ind_code,adv_event_type_code,causative_code,adv_event_dtl_srl_no)\n\t {\n\t \t \n\t\t/*alert(\"patient_id===\"+patient_id)\n\t\t alert(\"adv_event_type_ind_code===\"+adv_event_type_ind_code)\n\t\t alert(\"adv_event_type_code===\"+adv_event_type_code)\n\t\t alert(\"causative_code===\"+causative_code)\n\t\t alert(\"adv_event_dtl_srl_no===\"+adv_event_dtl_srl_no)*/\n\t\n\tif(\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" == \"Y\")\t{\n                     \n\tparent.PatAlertQueryResult.location.href=\'PatAlertQueryResult.jsp?patient_id=\'+patient_id+\'&call_from=allergy&ADV_EVENT_TYPE_IND=\'+adv_event_type_ind_code+\'&ADV_EVENT_TYPE=\'+adv_event_type_code+\'&ALLERGEN_CODE=\'+causative_code+\'&ADV_EVENT_SRL_NO=\'+adv_event_dtl_srl_no; \n\t\t\t\t\t\t\t\n\t}\n\telse\n\t\t {\n\t\t  parent.PatAlertQueryResult.location.href=\'PatAlertQueryResult.jsp?patient_id=\'+patient_id+\'&call_from=allergy&ADV_EVENT_TYPE_IND=\'+adv_event_type_ind_code+\'&ADV_EVENT_TYPE=\'+adv_event_type_code+\'&ALLERGEN_CODE=\'+causative_code+\'&ADV_EVENT_SRL_NO=\'+adv_event_dtl_srl_no;\n\n\t\t }\n\n}\n\t</script>\n</html>\n\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

      	String patient_id= request.getParameter("patient_id");
      	String called_from_ip= request.getParameter("called_from_ip");
      	String radio_par= request.getParameter("radio_par");
			if(radio_par==null || radio_par.equals(""))
			  radio_par="A";

		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
    	String locale = (String) p.getProperty("LOCALE");
			

      	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);

		//String locale = (String)session.getAttribute("LOCALE");
		Connection con = ConnectionManager.getConnection(request);
		ResultSet rs = null;
		PreparedStatement stmt	= null;
		//Statement stmt = null;
		String allergen1="",allergen="",adv_event_type="",Certainity="",onset_date="",status="",causative_code="",adv_event_type_ind_code="",adv_event_type_code="",severity_main="",classValue="",classValue1="",adv_event_dtl_srl_no="",reaction_date_prev="",reaction_date1="",causative_substance="",route_of_exposure="",severity_two="",adv_reac_code="",reac_desc="",diagnosis_code="",severity_code="",active_date="",cnt_recurring="",final_reac_code_val="",reaction_site="",onset_date_disply="",reaction_date1_disply="",others_reaction="",adv_event_type_code1="",StrSql1="",status1="",error_status="",adv_event_type_ind_code1="",onset_date_disply1="",onset_date1="",status_pass="" ,adv_event_srl_no ="",causative_code1="" ;

		String calculated_onset_date_yn="";
		String img_disp_yn="";
		String error_remark="";//--[IN034975]

		//String duration="",reac_desc_final="",adv_event_type_ind="";
	try 
	{
		//String PatientId=request.getParameter("PatientId");
		//if(PatientId ==null) PatientId="";
		String Encounter_Id=request.getParameter("Encounter_Id");
		if(Encounter_Id==null) Encounter_Id="";
	
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

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
 //--[IN034975] - Start 
		if(radio_par.equals("A")){
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
} //--[IN034975] - End
		
            _bw.write(_wl_block18Bytes, _wl_block18);

		//stmt=con.createStatement();
		int rowcolor=0,m=0;
		 	  if(radio_par.equals("A"))
				  StrSql1="a.status='A'";
				else if(radio_par.equals("O"))
				   StrSql1="a.status in('A','E','R')";
		/*	String sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code  and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, g.long_desc reac_desc,TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id, a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,   NVL((SELECT long_desc FROM mr_allergen  WHERE allergen_code = a.allergen_code),(SELECT generic_name FROM ph_generic_name WHERE generic_id = a.allergen_code)) allergen,c.adv_event_type_ind_desc, d.long_desc adv_event_type_desc,a.certainty certainty,a.status status,TO_CHAR (a.onset_date, 'dd/mm/yyyy') onset_date, DECODE (e.adv_event_type,'DA', (SELECT drug_desc FROM ph_drug WHERE drug_code = e.drug_code),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+patient_id+"' AND "+StrSql1+"   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.allergen_code, a.onset_date, f.reaction_date"; */
			
		/*String sql="SELECT   (SELECT COUNT (*) FROM pr_allergy_sensitivity WHERE patient_id = a.patient_id AND adv_event_type_ind = a.adv_event_type_ind AND adv_event_type = a.adv_event_type AND allergen_code = a.allergen_code AND status NOT LIKE 'A') COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no, f.adv_event_rxn_srl_no, am_get_desc.AM_REACTION(f.adv_reac_code,?,'1') reac_desc, TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date, a.patient_id, a.severity severity1, a.severity severity_code, a.adv_event_type_ind, a.adv_event_type, a.allergen_code, NVL(mr_get_desc.MR_ALLERGEN(a.allergen_code,?,'1'),(SELECT GENERIC_NAME FROM ph_generic_name_lang_vw WHERE GENERIC_ID=a.allergen_code AND LANGUAGE_ID=?) )allergen, mr_get_desc. MR_ADV_EVENT_TYPE_IND(a.adv_event_type_ind ,?,'1') adv_event_type_ind_desc , mr_get_desc.MR_ADV_EVENT_TYPE(a.adv_event_type,?,1) adv_event_type_desc, a.certainty certainty, a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy') onset_date, DECODE (e.adv_event_type, 'DA', (SELECT drug_desc FROM ph_drug_lang_vw WHERE drug_code = e.drug_code  AND LANGUAGE_ID= ? ), e.causative_substance ) causative_substance, e.route_of_exposure route_of_exposure, f.severity severity_two, e.adv_event_dtl_srl_no, a.diagnosis_code, TO_CHAR (a.active_date, 'dd/mm/yyyy') active_date, a.reaction_code_values, f.reaction_site, f.others_reaction,CALCULATED_ONSET_DATE_YN ,f.status error_status FROM pr_allergy_sensitivity a,pr_adverse_event e, pr_adverse_event_reaction f WHERE a.patient_id = ? AND "+StrSql1+" AND a.patient_id = e.patient_id  AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind  AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code  AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no   ORDER BY a.ADV_EVENT_TYPE_IND, a.allergen_code, a.onset_date/*, f.reaction_date";*/

		//String sql = "SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no,  f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,?,'1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id=?),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id=?))) END  allergen,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,?,'1') ADV_EVENT_TYPE_IND_desc,  MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,?,'1') adv_event_type_desc ,a.certainty certainty,a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date,  DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id=?),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code , TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d, pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = ? AND  "+StrSql1+"   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code,  f.reaction_date"; //Modified --[IN034975]


		
		//String sql = "SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no,  f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,?,'1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA',(SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id=?),'AD', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id=?),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id=?))) END allergen,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,?,'1') ADV_EVENT_TYPE_IND_desc,  MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,?,'1') adv_event_type_desc ,a.certainty certainty,a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date,  DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id=?),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code , TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d, pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = ? AND  "+StrSql1+"   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code,  f.reaction_date";//Modified --[IN037367] //commented for IN066228
		String sql = "SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no,  f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,?,'1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA',(SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id=?),'AD', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id=?),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id=?))) END allergen,a.OTHER_ALLERGEN,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,?,'1') ADV_EVENT_TYPE_IND_desc,  MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,?,'1') adv_event_type_desc ,a.certainty certainty,a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date,  DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id=?),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code , TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d, pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = ? AND  "+StrSql1+"   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.onset_date, a.ADV_EVENT_TYPE_IND, a.allergen_code, a.other_allergen ,  f.reaction_date";//added for IN066228
		stmt = con.prepareStatement(sql);

		stmt.setString(1, locale);
		stmt.setString(2, locale);
		stmt.setString(3, locale); //--[IN037367]
		stmt.setString(4, locale);
		stmt.setString(5, locale);
		stmt.setString(6, locale);
		stmt.setString(7, locale);
		stmt.setString(8, patient_id);

				
		rs=stmt.executeQuery();
		if(rs !=null)
		{
            _bw.write(_wl_block19Bytes, _wl_block19);
while(rs.next())
			  {

					causative_code=rs.getString("allergen_code");
					adv_event_type_ind_code=rs.getString("ADV_EVENT_TYPE_IND");

					adv_event_type_code=rs.getString("ADV_EVENT_TYPE");
					//allergen=rs.getString("allergen");//commented for IN066228
					allergen = (rs.getString("allergen")==""||rs.getString("allergen")==null)?rs.getString("OTHER_ALLERGEN"):rs.getString("allergen");//added for IN066228
					if(allergen ==null) allergen="&nbsp;";
					adv_event_type=rs.getString("adv_event_type_desc");
					Certainity=rs.getString("CERTAINTY");
					onset_date=rs.getString("ONSET_DATE");
					if(onset_date ==null) onset_date="&nbsp;";
					status=rs.getString("STATUS");
					severity_main=rs.getString("severity1");
					if(severity_main==null) severity_main="";
					adv_event_dtl_srl_no=rs.getString("adv_event_dtl_srl_no");
					if(adv_event_dtl_srl_no ==null) adv_event_dtl_srl_no=""; //display_header
					
					adv_event_srl_no=rs.getString("adv_event_srl_no");
					if(adv_event_srl_no ==null) adv_event_srl_no="";

					causative_substance=rs.getString("causative_substance");
					if(causative_substance ==null) causative_substance="";
					route_of_exposure=rs.getString("route_of_exposure");
					if(route_of_exposure ==null) route_of_exposure="";
					severity_two=rs.getString("severity_two");
					if(severity_two ==null) severity_two="&nbsp;";
					adv_reac_code=rs.getString("adv_reac_code");
					
					if(adv_reac_code ==null) adv_reac_code="";
					reaction_date1 =rs.getString("reaction_date");
					if(reaction_date1 ==null) reaction_date1="";
					reac_desc=rs.getString("reac_desc");

					if(reac_desc ==null) reac_desc="&nbsp;";
					severity_code=rs.getString("severity_code");
					if(severity_code ==null)severity_code="";
					diagnosis_code=rs.getString("diagnosis_code");
					if(diagnosis_code==null)diagnosis_code="";
					active_date=rs.getString("active_date");
					if(active_date ==null) active_date="";
					final_reac_code_val=rs.getString("REACTION_CODE_VALUES");
					if(final_reac_code_val ==null || final_reac_code_val.equals("THR")) final_reac_code_val="";
					reaction_site=rs.getString("reaction_site");
					if(reaction_site ==null) reaction_site="&nbsp;";
					
					others_reaction=rs.getString("OTHERS_REACTION");
					if(others_reaction ==null) others_reaction="&nbsp;";

					//calculated_onset_date_yn = rs.getString("CALCULATED_ONSET_DATE_YN");
					calculated_onset_date_yn = rs.getString("estimated_duration");
					if(calculated_onset_date_yn ==null) calculated_onset_date_yn="&nbsp;";

					error_status = rs.getString("error_status") == null ?"A":rs.getString("error_status");
					error_remark=rs.getString("error_remark");//--[IN034975]
					if(error_remark ==null) error_remark="&nbsp;";	
					if(calculated_onset_date_yn.equals("Y"))
					{
						img_disp_yn = "display:visible";
					}
					else
					{
						img_disp_yn = "display:none";
					}

					cnt_recurring=rs.getString("COUNT");
					if(adv_event_type_ind_code.equals("01"))
					{
						classValue1="MRALLERGY";
					}else if(adv_event_type_ind_code.equals("02"))
					{
						classValue1="MRHYPERII";
					}else if(adv_event_type_ind_code.equals("03"))
					{
						classValue1="MRHEADER";
					}else if(adv_event_type_ind_code.equals("04"))
					{
						classValue1="ORBROWN";
					}


					
					if(severity_main.equals("U"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					}else if(severity_main.equals("M"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
					}else if(severity_main.equals("O"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
					}else if(severity_main.equals("S"))
					{
					severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
					}


					if(Certainity.equals("D"))
					{
					Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Definitive.label","common_labels");
					}else if(Certainity.equals("P"))
					{
					Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Probable.label","common_labels");
					}

					status_pass = status;
					
					if(status.equals("A"))
					{
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
					}
					else if(status.equals("R"))
					{
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
					}else if(status.equals("E"))
					{
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
					}
						
				
					if(route_of_exposure.equals("1"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Ingestion.label","mr_labels");
					}else if(route_of_exposure.equals("2"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Inhalation.label","mr_labels");
					}else if(route_of_exposure.equals("3"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Injection.label","mr_labels");
					}else if(route_of_exposure.equals("4"))
					{
					route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Tropical.label","mr_labels");
					}
					

					if(severity_two.equals("U"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					}else if(severity_two.equals("M"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
					}else if(severity_two.equals("O"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
					}else if(severity_two.equals("S"))
					{
					severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
					}

					onset_date_disply=DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
					reaction_date1_disply=DateUtils.convertDate(reaction_date1,"DMYHM","en",locale);

				if((!adv_event_type_code.equals(adv_event_type_code1) || !causative_code.equals(causative_code1)|| !allergen.equals(allergen1)|| !status.equals(status1)|| !adv_event_type_ind_code.equals(adv_event_type_ind_code1)|| !onset_date_disply.equals(onset_date_disply1)))
				{
					if (classValue.equals("QRYODDSMALL"))
						classValue = "QRYEVENSMALL";
					else
						classValue = "QRYODDSMALL";
					
		
            _bw.write(_wl_block20Bytes, _wl_block20);
//if(!error_status.equals("E")){
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(m));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(m));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(adv_event_type_ind_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(adv_event_type_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(reaction_date1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(status_pass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(error_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block25Bytes, _wl_block25);
//}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(m));
            _bw.write(_wl_block27Bytes, _wl_block27);
//}
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(adv_event_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(adv_event_type_ind_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(adv_event_type_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(adv_event_srl_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(allergen));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(onset_date_disply));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(img_disp_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(cnt_recurring.equals("0")||causative_code.equals("Oth")){
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(status));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(cnt_recurring));
            _bw.write(_wl_block38Bytes, _wl_block38);
}//--[IN034975]
				if(status_pass.equals("E")||radio_par.equals("O")){
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(error_remark));
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);
//if(!error_status.equals("E")){
		
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(m));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
 //--[IN034975]
			if(status_pass.equals("E")||radio_par.equals("O")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
//}
            _bw.write(_wl_block48Bytes, _wl_block48);
if(!error_status.equals("E")){ 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(m));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(reaction_date1_disply));
            _bw.write(_wl_block51Bytes, _wl_block51);
 if(adv_reac_code.equals("Oth")) 
			{ 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(others_reaction));
            _bw.write(_wl_block53Bytes, _wl_block53);
} else { 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(reac_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(severity_two));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(reaction_site));
            _bw.write(_wl_block53Bytes, _wl_block53);
 //--[IN034975]
			if(status_pass.equals("E")||radio_par.equals("O")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
				
			 if(!error_status.equals("E")){	 
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(m));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
 //--[IN034975]
			if(status_pass.equals("E")||radio_par.equals("O")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(m));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(reaction_date1_disply));
            _bw.write(_wl_block61Bytes, _wl_block61);
 if(adv_reac_code.equals("Oth")) 
			{ 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(others_reaction));
            _bw.write(_wl_block62Bytes, _wl_block62);
} else { 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(reac_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(severity_two));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(reaction_site));
            _bw.write(_wl_block53Bytes, _wl_block53);
 //--[IN034975]
			if(status_pass.equals("E")||radio_par.equals("O")){
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block63Bytes, _wl_block63);

			 }
				}
				
            _bw.write(_wl_block64Bytes, _wl_block64);
	
				
					allergen1= (rs.getString("allergen")==""||rs.getString("allergen")==null)?rs.getString("OTHER_ALLERGEN"):rs.getString("allergen");
					causative_code1=rs.getString("allergen_code");
					reaction_date_prev =rs.getString("reaction_date");
					adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");
					
					adv_event_type_ind_code1 = rs.getString("adv_event_type_ind");
					onset_date1 = rs.getString("onset_date");
					onset_date_disply1=DateUtils.convertDate(onset_date1,"DMYHMS","en",locale);
					status1 = rs.getString("status");
					
					if(status1.equals("A")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
					}
					else if(status1.equals("R")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
					}else if(status1.equals("E")){
						status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
					}



				/*	
					if(status1.equals("A"))
					status1="Active";
					else if(status1.equals("R"))
						status1="Resolved";
					else if(status1.equals("E"))
						status1="In Error";	*/
					rowcolor ++;
					m++;
					//rowCount++;
				
				
				/*if(!(radio_par.equals("O"))){
					allergen1=rs.getString("allergen_code");
					reaction_date_prev =rs.getString("reaction_date");
					adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");
				
					rowcolor ++;
					m++;
					//rowCount++;
				  }
				  else{
					
					
					
					status1 = rs.getString("status");
					if(status.equals("A"))
					status1="Active";
					else if(status1.equals("R"))
						status1="Resolved";
					else if(status1.equals("E"))
						status1="In Error";			
						
									
					if(!(status1.equals(status))){
						allergen1=rs.getString("allergen_code");
						reaction_date_prev =rs.getString("reaction_date");
						adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");
						rowcolor ++;
						
						//rowCount++;
					}
					m++;
				  } */
				
				
				
				
				/*allergen1=rs.getString("allergen_code");
				reaction_date_prev =rs.getString("reaction_date");
				adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");
				rowcolor ++;
				m++; */
			
			}
			
            _bw.write(_wl_block65Bytes, _wl_block65);

		}
	

	
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rowcolor));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block69Bytes, _wl_block69);

     } catch(Exception e) {


		out.println("Exception @ try"+e.toString());
		e.printStackTrace();

         if (rs != null) rs.close();
         if (stmt != null) stmt.close();
    }
     finally {
         if (rs != null) rs.close();
         if (stmt != null) stmt.close();
		 ConnectionManager.returnConnection(con,request);
     }

            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block71Bytes, _wl_block71);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AdeverseEventsAllgSens.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Allergen.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReactionDate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.reactiondesc.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SiteOfReaction.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReactionDate.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.reactiondesc.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SiteOfReaction.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
