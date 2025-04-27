package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import com.ehis.eslp.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recordpatientadverseevent4 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecordPatientAdverseEvent4.jsp", 1740388206687L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n\t<head>\n\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"></link>\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/messages.js\' ></script>\n\t\t\t<!-- <script language=\'javascript\' src=\'../../eMR/js/eMRmessages.js\' ></script> -->\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n\t\t\t<script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t\t<script language=\'javascript\' src=\"../../eMR/js/RecordPatientAdverseEvent.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../../ePH/js/DrugNameCommonLookup.js\'></script>\n\t\t\t<script language=\"javascript\" src=\"../../eMP/js/PatEncBanner.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t<script>\n\t\t\tfunction display_records(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date){\n\t\t\t\tparent.frames[1].document.getElementById(\'detail\'+obj).innerHTML=\"<a href=\\\"javascript:display_records1(\'\"+obj+\"\',\'\"+PatientId+\"\',\'\"+causative_code+\"\',\'\"+adv_event_type_ind_code+\"\',\'\"+adv_event_type_code+\"\',\'\"+reaction_date1+\"\',\'\"+status+\"\',\'\"+error_status+\"\',\'\"+onset_date+\"\')\\\"><font color=\'black\' bgcolor=\'#FF9933\'>-</font></a>\";\n\t\t\t\t/* var xmlDoc=new ActiveXObject(\"Microsoft.XMLDom\")\n\t\t\t\tvar xmlHttp = new XMLHttpRequest()  */\n\t\t\t\tvar xmlDoc = \"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\txmlStr =\"<root><SEARCH PatientId=\\\"\"+PatientId+\"\\\"  adv_event_type_ind_code=\\\"\"+adv_event_type_ind_code+\"\\\" adv_event_type_code=\\\"\"+adv_event_type_code+\"\\\" causative_code=\\\"\"+causative_code+\"\\\"\treaction_date1=\\\"\"+reaction_date1+\"\\\"  cnt=\\\"\"+obj+\"\\\" status=\\\"\"+status+\"\\\" error_status=\\\"\"+error_status+\"\\\" onset_date=\\\"\"+onset_date+\"\\\"  det=\'add\' steps=\'6\'/></root>\"\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",\"AdverseEventType.jsp\",false);\n\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\tresponseText=xmlHttp.responseText\n\t\t\t\tresponseText = trimString(responseText)\n\t\t\t\teval(responseText)\n\t\t\t}\n\t\t\tfunction display_records1(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date){\n\t\t\t\tparent.frames[1].document.getElementById(\'detail\'+obj).innerHTML=\"<a href=\\\"javascript:display_records(\'\"+obj+\"\',\'\"+PatientId+\"\',\'\"+causative_code+\"\',\'\"+adv_event_type_ind_code+\"\',\'\"+adv_event_type_code+\"\',\'\"+reaction_date1+\"\',\'\"+status+\"\',\'\"+error_status+\"\',\'\"+onset_date+\"\')\\\"><font color=\'black\'>+</font></a>\";\n\n\t\t\t\t//var xmlDoc=new ActiveXObject(\"Microsoft.XMLDom\")\n\t\t\t\t//var xmlHttp = new XMLHttpRequest() \n\t\t\t\tvar xmlDoc = \"\";\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\txmlStr =\"<root><SEARCH PatientId=\\\"\"+PatientId+\"\\\"  adv_event_type_ind_code=\\\"\"+adv_event_type_ind_code+\"\\\" adv_event_type_code=\\\"\"+adv_event_type_code+\"\\\" causative_code=\\\"\"+causative_code+\"\\\"\treaction_date1=\\\"\"+reaction_date1+\"\\\"  cnt=\\\"\"+obj+\"\\\" det=\'sub\' status=\\\"\"+status+\"\\\" error_status=\\\"\"+error_status+\"\\\"  onset_date=\\\"\"+onset_date+\"\\\"  steps=\'6\'/></root>\"\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\")\n\t\t\t\txmlHttp.open(\"POST\",\"AdverseEventType.jsp\",false)\n\t\t\t\txmlHttp.send(xmlDoc)\n\t\t\t\tresponseText=xmlHttp.responseText\n\t\t\t\tresponseText = trimString(responseText);\n\t\t\t\n\t\t\t\teval(responseText);\n\t\t\t}\n\t\t\tfunction callonload(){\n\t\t\t\tvar tot_allr=document.forms[0].rowcolor.value;\n\t\t\t\t//parent.frames[0].document.forms[0].all.third1.style.display=\'inline\';\n\t\t\t\t//\tparent.frames[0].document.forms[0].all.third1.style.display=\'visible\';\n\t\t\t}\n\t\t\t</script>\n\t</head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onLoad=\'load_header();\' ><!--onscroll=\'scrollTitle1()-->\n\t\t\t\t<form name = \'chk_val\' id=\'chk_val\'>\n\t\t\t\t\t<table cellpadding=\'0\'  border=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' >\n\t\t\t\t\t\t<th align=\'left\' nowrap colspan=\'5\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&nbsp;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t\t</table>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<table cellpadding=\'0\'  border=\'1\' cellspacing=\'0\' width=\'100%\'  id=\'record\'><!--Modified by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"comment";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" id=\"comment";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t\t\t\t<input type=\'hidden\' name=\"causative_substanc";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"causative_substanc";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t<tr id = \'header_part\' >\n\t\t\t\t\t\t\t\t\t<th width=\'4%\'><div  id=\'head1\'  class=\'myClass\' nowrap >&nbsp;&nbsp;</div></th>\n\t\t\t\t\t\t\t\t\t<th width=\'15%\'><div  id=\'head2\' class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</div></th>\n\t\t\t\t\t\t\t\t\t<th width=\'15%\'><div  id=\'head3\' class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</div></th>\n\t\t\t\t\t\t\t\t\t<th width=\'15%\'><div  id=\'head4\' class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div></th>\n\t\t\t\t\t\t\t\t\t<!--Following condition included for the incident 33466 Bru-HIMS-CRF-292 -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t<th width=\'30%\' colspan=\'2\'><div  id=\'head5\' class=\'myClass\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div></th>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<th width=\'2%\'><div  id=\'head5\' class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</div></th><!--Added \'colspan\' on 3rd Jan 2018 against ML-MMOH-CRF-0751-->\n\t\t\t\t\t\t\t\t\t<th width=\'15%\'><div  id=\'head6\' class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr id=\'first\' >\n\t\t\t\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' nowrap id=\'detail";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'><a href=\"javascript:onclick=display_records1(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')\">&nbsp;-&nbsp;</a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' name=\'detail";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' width = \'3%\'>\n\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:onclick=display_records1(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\">&nbsp;-&nbsp;</a>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' nowrap width= \'15%\' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t<td   class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' nowrap id=\'header\'  width= \'15%\'>\n\t\t\t\t\t\t\t\t\t\t<!--Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column added) Start-->\n\t\t\t\t\t\t\t\t\t\t<!--<a href=\"javascript:onclick=display_header(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\')\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="-->\n                                     <!--Below lines onset_type,comments added by venkatesh.S against ML-MMOH-CRF-0366 -->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:onclick=display_header(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\')\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</a><!--Modified by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751--> <!--adv_event_dtl_srl_no Added by Ashwini on 30-Nov-2020 for SKR-SCF-1499-->\n                                   \n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' nowrap width= \'15%\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<input type = \'image\' id=\'clock\'  src=\'../../eCommon/images/mc_history.gif\' ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" BORDER=\'0\' style=\'visibility:hidden\' ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="disabled></td>\n\t\t\t\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\t\t\t<img  id=\'clock\' src=\'../../eCA/images/mc_history.gif\' BORDER=\'0\' style=\'visibility:hidden\'>\n\t\t\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' colspan=\'2\' nowrap width= \'15%\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="(";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =")<img src=\'../../eCommon/images/mandatory.gif\' ></img></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<!--End-->\n\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t<tr id=\'third";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' Style=\"visibility:visible\">\n\t\t\t\t\t\t\t\t\t<th  class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' nowrap >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<th class=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="  nowrap>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</th>\n\t\t\t\t\t\t\t\t\t<th class=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" colspan=\'2\' nowrap>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</th>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\t\t\n\t\t\t\t\t\t\t\t\t<tr id=\'second";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' Style=\"visibility:visible\" >\n\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' nowrap >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' nowrap >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' style = \'text-align:justify;word-break:break-all;\' >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' colspan=\'2\' style = \'text-align:justify;word-break:break-all;\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td><!--modified for the incident 33466 Bru-HIMS-CRF-292 -->\n\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t<tr id=\'third";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' Style=\"display:none;visibility:hidden\" >\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' nowrap >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" align=center nowrap>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" align=center nowrap >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" colspan=\'2\' align=center nowrap>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr id=\'second";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' Style=\"visibility:visible\" >\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' nowrap >&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' colspan=\'2\' style = \'text-align:justify;word-break:break-all;\' >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</table>\n\t\t\t\t\t\t<div id=\'allergenLink\' style=\'position:absolute; visibility:hidden;overflow:none\'></div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t<input type=\"hidden\" name=\"detail\" id=\"detail\" value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"rowcolor\" id=\"rowcolor\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"cnt\" id=\"cnt\" value=\"\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"flag\" id=\"flag\" VALUE=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"flag1\" id=\"flag1\" VALUE=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"modeResult1\" id=\"modeResult1\" VALUE=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"PatientId\" id=\"PatientId\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"Encounter_Id\" id=\"Encounter_Id\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"Allergen\" id=\"Allergen\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"reaction_date\" id=\"reaction_date\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"onset_date\" id=\"onset_date\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"reaction_desc\" id=\"reaction_desc\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"internalStr\" id=\"internalStr\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"max_record\" id=\"max_record\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"active_date\" id=\"active_date\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"adv_event_type_code\" id=\"adv_event_type_code\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"adv_event_type_ind_code\" id=\"adv_event_type_ind_code\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"final_reac_code_val\" id=\"final_reac_code_val\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"causative_substance\" id=\"causative_substance\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"causative_code\" id=\"causative_code\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" >\n\t\t\t\t\t<input type=\"hidden\" name=\"severity\" id=\"severity\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\n\t\t\t\t\t<!--       -->\n\t\t\t\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:5%; visibility:visible;\' bgcolor=\'blue\'>\n\t\t\t\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t<!--       -->\n\t\t\t\t</form>\n\t\t\t</body>\n\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n</html>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n<!--\n<script>\nfunction \tdisplay_header(patient_id,adv_event_type_ind_code,adv_event_type_code,causative_code,adv_event_dtl_srl_no)\n{\n\n/*alert(\"patient_id===\"+patient_id)\nalert(\"adv_event_type_ind_code===\"+adv_event_type_ind_code)\nalert(\"adv_event_type_code===\"+adv_event_type_code)\nalert(\"causative_code===\"+causative_code)\nalert(\"adv_event_dtl_srl_no===\"+adv_event_dtl_srl_no)*/\n\n\nparent.PatAlertQueryResult.location.href=\'PatAlertQueryResult.jsp?patient_id=\'+patient_id+\'&call_from=allergy&ADV_EVENT_TYPE_IND=\'+adv_event_type_ind_code+\'&ADV_EVENT_TYPE=\'+adv_event_type_code+\'&ALLERGEN_CODE=\'+causative_code+\'&ADV_EVENT_SRL_NO=\'+adv_event_dtl_srl_no; \n\n\n\n\n}\n</script>\n-->\n\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

public static String checkForNull(String inputString){
return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String locale = (String)session.getAttribute("LOCALE");
	Connection con = ConnectionManager.getConnection(request);
	ResultSet rs = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	Statement stmt1 = null;
	String allergen1="",allergen2="",allergen="",adv_event_type="",Certainity="",onset_date="",status="",causative_code="",adv_event_type_ind_code="",adv_event_type_code="",severity_main="",classValue="",classValue1="",adv_event_dtl_srl_no="",reaction_date_prev="",reaction_date1="",causative_substance="",route_of_exposure="",severity_two="",adv_reac_code="",reac_desc="",diagnosis_code="",severity_code="",active_date="",final_reac_code_val="",reaction_site="",onset_date_disply="",reaction_date1_disply="",others_reaction="",adv_event_type_code1="",term_code="",reac_date="",reac_date_disply="",source_of_info="",estimated_duration="",inerror_date="",resolved_date="",since_date="",error_status="",status1="",adv_event_type_ind_code1="",onset_date_disply1="",onset_date1="",status_pass="",cnt_recurring="";
	
	String drug_code	= "";//Added By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155]

		String onset_type="";
		String comments="";
	/*Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start*/
	Boolean isOthAllergenAppl	= false;
	String advEventSrlNo		= "";
	/*End*/
	StringBuffer where_criteria=new StringBuffer(); 
	String norecord					= checkForNull(request.getParameter("norecord"));
	String rs_mode					= checkForNull(request.getParameter("modeResult"));
	
	String rs_reaction_code	= checkForNull(request.getParameter("reac_code_val"));
	String rs_eventType			= checkForNull(request.getParameter("eventType_val"));
	String rs_allergen_code		= checkForNull(request.getParameter("allergen_val"));
	String rs_status					= checkForNull(request.getParameter("status_val"));
	String rs_load					= checkForNull(request.getParameter("load"));
	String error_remark=""; // added for the incident 33466	Bru-HIMS-CRF-292
	if(rs_status != null && !rs_status.equals("")){
		if(rs_status.equals("L")){
			where_criteria.append("AND  UPPER(a.status) IN('A','E','R')");
		}else{
			where_criteria.append("AND nvl(a.status,'X')=nvl('"+rs_status+"',nvl(a.status,'X'))");
		}
	}

	String internalStr="";
	int rowCount=0;
	int max_record=0;
	try {
			isOthAllergenAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","OTH_ALLERGEN_FREE_TXT");//Added by Thamizh selvi on 22nd Dec 2017 for ML-MMOH-CRF-0751
			String PatientId=request.getParameter("PatientId");
			if(PatientId ==null) PatientId="";
			String Encounter_Id=request.getParameter("Encounter_Id");
			if(Encounter_Id==null) Encounter_Id="";
			
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

					stmt1=con.createStatement();
					int rowcolor=0,m=0;
					String sql=" ";
					//Modified against TTM-SCF-0107 - The below sql is modified to get the generic desc from mr_allergen_lang_vw/ph_generic_name_lang_vw based on the PH installation ::
					String sPhInstalled_YN = request.getParameter("sPhInstalled_YN"); 
					String sAllergen ="";
					if("Y".equals(sPhInstalled_YN))
						/*Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start*/
						if(isOthAllergenAppl)
							sAllergen = "( DECODE (a.allergen_code, 'Oth', a.other_allergen, DECODE (a.adv_event_type, 'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id = '"+locale+"'), (SELECT long_desc FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = '"+locale+"'))) )";
						else/*End*/
							sAllergen = "(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"'))) ";
					else
						/*Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start*/
						if(isOthAllergenAppl)
							sAllergen = "( DECODE (a.allergen_code, 'Oth', a.other_allergen, (SELECT long_desc FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = '"+locale+"')) )";
						else/*End*/
							sAllergen = "(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"') ";
						
					if(rs_mode==null){
						//sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no,  f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"'))) END  allergen,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') ADV_EVENT_TYPE_IND_desc,  MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1') adv_event_type_desc ,a.certainty certainty,a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy ') onset_date,  DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code , TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d, pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g,mr_allergen b WHERE a.patient_id = '"+PatientId+"' AND  a.status = 'A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.allergen_code = b.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.ADV_EVENT_TYPE_IND, a.allergen_code, a.onset_date, f.reaction_date";
						
						/*Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column added) Start*/
						
						//sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no,  f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN /*(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"')))*/ "+sAllergen+" END  allergen,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') ADV_EVENT_TYPE_IND_desc,  MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1') adv_event_type_desc ,a.certainty certainty,a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date,  DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),   e.causative_substance) causative_substance,  e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code , TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d, pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+PatientId+"' AND  a.status = 'A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+)  ORDER BY a.ADV_EVENT_TYPE_IND, a.allergen_code, a.onset_date, f.reaction_date";//column error_remarks included for the incident 33466 Bru-HIMS-CRF-292
					 /*Below lines onset_type ,comments added by venkatesh.S against ML-MMOH-CRF-0366 */
						sql="SELECT ( decode( a.allergen_code, 'Oth', 0, (SELECT COUNT (*) FROM pr_allergy_sensitivity WHERE patient_id = a.patient_id AND adv_event_type_ind = a.adv_event_type_ind AND adv_event_type = a.adv_event_type AND allergen_code = a.allergen_code AND status NOT LIKE 'A') ) )COUNT,a.onset_type,a.comments,f.adv_reac_code, f.adv_event_srl_no,  f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN /*(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"')))*/ "+sAllergen+" END  allergen,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') ADV_EVENT_TYPE_IND_desc,  MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1') adv_event_type_desc ,a.certainty certainty,a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date,  DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),   e.causative_substance) causative_substance, DECODE (e.adv_event_type,'DA', (SELECT drug_code FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id = 'en'), e.drug_code ) drug_code, e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code , TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d, pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+PatientId+"' AND  a.status = 'A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+)  ORDER BY a.ADV_EVENT_TYPE_IND, a.allergen_code,a.other_allergen, a.onset_date, f.reaction_date";//column error_remarks included for the incident 33466 Bru-HIMS-CRF-292
						//Modified above query against ML-MMOH-CRF-0751 by Thamizh selvi on 2nd Jan 2018  - "COUNT" value '0' for 'Oth' code
						/*Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column added) End*/
											}else if(rs_mode.equals("result")){

						//sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type AND ALLERGEN_CODE=a.allergen_code and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'en','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code,a.adv_event_type_ind, a.adv_event_type, a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='en'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='en'))) END allergen,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'en','1') ADV_EVENT_TYPE_IND_desc,MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'en','1')adv_event_type_desc ,a.certainty certainty,a.status status,TO_CHAR(a.onset_date, 'dd/mm/yyyy')onset_date,  DECODE (e.adv_event_type,'DA',(SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='en'),e.causative_substance) causative_substance,e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,To_Char(a.ACTIVE_DATE ,'dd/mm/yyyy')active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE ,f.OTHERS_REACTION , a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,  pr_adverse_event e,pr_adverse_event_reaction f,am_reaction g,mr_allergen b WHERE a.patient_id = '"+PatientId+"' AND nvl(a.status,'X') =nvl('"+rs_status+"',nvl(a.status,'X')) AND nvl(b.short_desc,'X')=nvl('"+rs_allergen_desc_val+"',nvl(b.short_desc,'X') ) AND NVL(a.ADV_EVENT_TYPE,'X')=nvl('"+rs_eventType+"',NVL(a.ADV_EVENT_TYPE,'X') )AND NVL(g.short_desc,'X')=nvl('"+rs_reaction_desc+"',NVL(g.short_desc,'X') )AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code  AND a.allergen_code = b.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code  AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.ADV_EVENT_TYPE_IND, a.allergen_code, a.onset_date, f.reaction_date";

						/*Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column added) Start*/
						//sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type AND ALLERGEN_CODE=a.allergen_code and status not like 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code,a.adv_event_type_ind, a.adv_event_type, a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN /*(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"')))*/ "+ sAllergen + " END allergen /*NVL((SELECT long_desc FROM mr_allergen  WHERE allergen_code = a.allergen_code),(SELECT generic_name FROM ph_generic_name WHERE generic_id = a.allergen_code)) allergen*/,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') ADV_EVENT_TYPE_IND_desc,MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1')adv_event_type_desc ,a.certainty certainty,a.status status,TO_CHAR(a.onset_date, 'dd/mm/yyyy hh24:mi:ss')onset_date,  DECODE (e.adv_event_type,'DA',(SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),e.causative_substance) causative_substance,e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,To_Char(a.ACTIVE_DATE ,'dd/mm/yyyy')active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE ,f.OTHERS_REACTION , a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,  pr_adverse_event e,pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+PatientId+"' "+where_criteria.toString()+ " AND nvl(a.allergen_code,'X')=nvl('"+rs_allergen_code+"',nvl(a.allergen_code,'X') ) AND NVL(a.ADV_EVENT_TYPE,'X')=nvl('"+rs_eventType+"',NVL(a.ADV_EVENT_TYPE,'X') )AND NVL(g.reaction_code,'X')=nvl('"+rs_reaction_code+"',NVL(g.reaction_code,'X') )AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code  AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code  /*and f.status='A'*/  and  f.adv_reac_code = g.reaction_code (+)  ORDER BY a.onset_date,a.ADV_EVENT_TYPE_IND, a.allergen_code, f.reaction_date ";//column error_remark included for the incident 33466 Bru-HIMS-CRF-292

 
						sql="SELECT (decode( a.allergen_code, 'Oth', 0, (SELECT COUNT (*) FROM pr_allergy_sensitivity WHERE patient_id = a.patient_id AND adv_event_type_ind = a.adv_event_type_ind AND adv_event_type = a.adv_event_type AND allergen_code = a.allergen_code AND status NOT LIKE 'A') ) )COUNT,a.onset_type,a.comments,f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code,a.adv_event_type_ind, a.adv_event_type, a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN /*(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"')))*/ "+ sAllergen + " END allergen /*NVL((SELECT long_desc FROM mr_allergen  WHERE allergen_code = a.allergen_code),(SELECT generic_name FROM ph_generic_name WHERE generic_id = a.allergen_code)) allergen*/,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') ADV_EVENT_TYPE_IND_desc,MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1')adv_event_type_desc ,a.certainty certainty,a.status status,TO_CHAR(a.onset_date, 'dd/mm/yyyy hh24:mi:ss')onset_date,  DECODE (e.adv_event_type,'DA',(SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),e.causative_substance) causative_substance,DECODE (e.adv_event_type,'DA', (SELECT drug_code FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id = 'en'), e.drug_code ) drug_code, e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,To_Char(a.ACTIVE_DATE ,'dd/mm/yyyy')active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE ,f.OTHERS_REACTION , a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,  pr_adverse_event e,pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+PatientId+"' "+where_criteria.toString()+ " AND nvl(a.allergen_code,'X')=nvl('"+rs_allergen_code+"',nvl(a.allergen_code,'X') ) AND NVL(a.ADV_EVENT_TYPE,'X')=nvl('"+rs_eventType+"',NVL(a.ADV_EVENT_TYPE,'X') )AND NVL(g.reaction_code,'X')=nvl('"+rs_reaction_code+"',NVL(g.reaction_code,'X') )AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code  AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code  /*and f.status='A'*/  and  f.adv_reac_code = g.reaction_code (+)  ORDER BY a.onset_date,a.ADV_EVENT_TYPE_IND, a.allergen_code, a.other_allergen,f.reaction_date ";//column error_remark included for the incident 33466 Bru-HIMS-CRF-292
						/*Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column end)*/
						//Modified above query against ML-MMOH-CRF-0751 by Thamizh selvi on 2nd Jan 2018  - "COUNT" value '0' for 'Oth' code		
					}
					/*stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					rs 	= stmt.executeQuery(sql.toString());
					rs.last();
					max_record = rs.getRow();
					rs.beforeFirst();*/   

                				
					pstmt=con.prepareStatement(sql.toString());
					rs 	= pstmt.executeQuery();
					if(rs !=null){
            _bw.write(_wl_block10Bytes, _wl_block10);

						while(rs.next()){
							classValue = "QRYEVENSMALL";
							causative_code=rs.getString("allergen_code");
							adv_event_type_ind_code=rs.getString("ADV_EVENT_TYPE_IND");
							adv_event_type_code=rs.getString("ADV_EVENT_TYPE");
							allergen=rs.getString("allergen");
							if(allergen ==null) allergen="";
							adv_event_type=rs.getString("adv_event_type_desc");
							Certainity=rs.getString("CERTAINTY");
							onset_date=rs.getString("ONSET_DATE");
							if(onset_date ==null) onset_date="";
							status=rs.getString("STATUS");
							severity_main=rs.getString("severity1");
							if(severity_main==null) severity_main="";
							adv_event_dtl_srl_no=rs.getString("adv_event_dtl_srl_no");
							if(adv_event_dtl_srl_no ==null) adv_event_dtl_srl_no="";
							causative_substance=rs.getString("causative_substance");
							if(causative_substance ==null) causative_substance="";
							/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
							onset_type=rs.getString("onset_type");
								if(onset_type ==null) onset_type="";
								
							comments=rs.getString("comments");
							if(comments ==null) comments="";
							/*end ML-MMOH-CRF-0366 */
							
							/*Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start*/
														advEventSrlNo = rs.getString("adv_event_srl_no");
							if(advEventSrlNo == null) advEventSrlNo="";/*End*/
							
										comments=comments.replaceAll("'","`");
									
							
							
							drug_code = (rs.getString("drug_code")==null || rs.getString("drug_code")== "") ? "" : rs.getString("drug_code");//Added By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155]

							

							route_of_exposure=rs.getString("route_of_exposure");
							if(route_of_exposure ==null) route_of_exposure="";
							severity_two=rs.getString("severity_two");
							if(severity_two ==null) severity_two="&nbsp;";
							adv_reac_code=rs.getString("adv_reac_code");
							if(adv_reac_code ==null) adv_reac_code="";
							reaction_date1 =rs.getString("reaction_date");
							if(reaction_date1 ==null) reaction_date1="";
							reac_desc=rs.getString("reac_desc");
							if(reac_desc ==null) reac_desc="";
							term_code=rs.getString("TERM_SET_ID");
							if(term_code ==null) term_code="";
							if(reac_desc ==null) reac_desc="";
							severity_code=rs.getString("severity_code");
							if(severity_code ==null)severity_code="";
							diagnosis_code=rs.getString("diagnosis_code");
							if(diagnosis_code==null)diagnosis_code="";
							active_date=rs.getString("active_date");
							if(active_date ==null) active_date="";
							error_status = rs.getString("error_status");
							if(error_status == null) error_status = "A";
							inerror_date=rs.getString("inerror_date");
							if(inerror_date ==null) inerror_date="";
							resolved_date=rs.getString("resolved_date");
							if(resolved_date ==null) resolved_date="";

							if(status.equals("A"))
							since_date=active_date;
							else if(status.equals("R"))
							since_date=resolved_date;
							else if(status.equals("I"))
							since_date=inerror_date;
							final_reac_code_val=rs.getString("REACTION_CODE_VALUES");
							if(final_reac_code_val ==null || final_reac_code_val.equals("THR")) final_reac_code_val="";
							reaction_site=rs.getString("reaction_site");
							if(reaction_site ==null) reaction_site="&nbsp;";
							others_reaction=rs.getString("OTHERS_REACTION");
							if(others_reaction ==null) others_reaction="";
							cnt_recurring=rs.getString("COUNT");
							estimated_duration = rs.getString("estimated_duration");
							/*Following lines included for the incident 33466 Bru-HIMS-CRF-292*/	
							error_remark=rs.getString("error_remark");
							if(error_remark == null) error_remark="&nbsp;";
							if(rowCount==0){
								internalStr=causative_code+adv_event_type_code+"&&"+allergen+"&&"+onset_date+"&&"+reaction_date1+"&&"+reac_desc+"&&"+severity_two;
							}else{
								internalStr=internalStr+"||"+causative_code+adv_event_type_code+"&&"+allergen+"&&"+onset_date+"&&"+reaction_date1+"&&"+reac_desc+"&&"+severity_two;
							}
							source_of_info = rs.getString("source_of_info");
							if(source_of_info.equals("P")){
								//source_of_info = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PatientObservation.label","mr_labels");
								source_of_info = "P";
							}
							if(source_of_info.equals("A")){
								//source_of_info = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AllergyTestResult.label","mr_labels");
								source_of_info = "A";
							}
							if(source_of_info.equals("S")){
								//source_of_info = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StaffObservation.label","mr_labels");
								source_of_info = "S";
							}
							//										
							if(adv_event_type_ind_code.equals("01")){
								classValue1="MRALLERGY";
							}else if(adv_event_type_ind_code.equals("02"))
							{
							classValue1="MRHYPERII";
							}else if(adv_event_type_ind_code.equals("03")){
								classValue1="MRHEADER";
							}else if(adv_event_type_ind_code.equals("04")){
								classValue1="ORBROWN";
							}
							if(severity_main.equals("U")){
								severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
							}else if(severity_main.equals("M")){
								severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
							}else if(severity_main.equals("O")){
								severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
							}else if(severity_main.equals("S")){
								severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
							}
							if(Certainity.equals("D")){
								Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Definitive.label","common_labels");
							}else if(Certainity.equals("P")){
								Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Probable.label","common_labels");
							}
							status_pass = status;
							if(status.equals("A"))	{
								status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
							}else if(status.equals("R")){
								status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
							}else if(status.equals("E"))	{
								status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
							}
							/*if(route_of_exposure.equals("1")){
								route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Ingestion.label","mr_labels");
							}else if(route_of_exposure.equals("2")){
								route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Inhalation.label","mr_labels");
							}else if(route_of_exposure.equals("3")){
								route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Injection.label","mr_labels");
							}else if(route_of_exposure.equals("4")){
								route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Tropical.label","mr_labels");
							}*/
							if(severity_two.equals("U")){
								severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
							}else if(severity_two.equals("M"))	{
								severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
							}else if(severity_two.equals("O")){
								severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
							}else if(severity_two.equals("S")){
								severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
							}
							onset_date_disply=DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
							reaction_date1_disply=DateUtils.convertDate(reaction_date1,"DMYHM","en",locale);
							reac_date_disply  = DateUtils.convertDate(reac_date,"DMY","en",locale);
							if((!adv_event_type_code.equals(adv_event_type_code1) || !causative_code.equals(allergen1) || !allergen.equals(allergen2) || !status.equals(status1) || !adv_event_type_ind_code.equals(adv_event_type_ind_code1) || !onset_date_disply.equals(onset_date_disply1))){ 
							
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(m));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(m));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(comments));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(m));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(m));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(causative_substance));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if(!status_pass.equals("E")){
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(m));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(m));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(adv_event_type_ind_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(adv_event_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(reaction_date1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(m));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(m));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(m));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(adv_event_type_ind_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(adv_event_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(reaction_date1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(status_pass));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(error_status));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(adv_event_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
/*causative_substance variable Added encode() method by Senthil on 21-Nov-2011 [IN:026962]*/
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(java.net.URLEncoder.encode(Encounter_Id)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(PatientId)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(causative_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(adv_event_type_ind_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(adv_event_type_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(Certainity)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(severity_main)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(onset_date)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagnosis_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(severity_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(active_date)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(final_reac_code_val)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(causative_substance)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(term_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(since_date)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(status_pass)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(source_of_info)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(route_of_exposure)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(estimated_duration)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(resolved_date)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(inerror_date)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(others_reaction)));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(allergen));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(m));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(Encounter_Id)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(PatientId)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(causative_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(adv_event_type_ind_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(adv_event_type_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(Certainity)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(severity_main)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(onset_date)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(diagnosis_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(severity_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(active_date)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(final_reac_code_val)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(term_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(since_date)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(status_pass)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(source_of_info)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(route_of_exposure)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(estimated_duration)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(resolved_date)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(inerror_date)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(others_reaction)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(drug_code)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(onset_type)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(cnt_recurring)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(advEventSrlNo));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(adv_event_dtl_srl_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(allergen));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(onset_date_disply));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(estimated_duration.equals("N")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
if(!status_pass.equals("E")){//Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751
										if(cnt_recurring.equals("0") ){ 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(status));
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(status));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cnt_recurring));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
									//following condition included for the incident 33466 Bru-HIMS-CRF-292
									}else if(status_pass.equals("E")){
										/*Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751 Start*/
										if(cnt_recurring.equals("0") ){ 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(status));
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(status));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(cnt_recurring));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(error_remark));
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(m));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
if(!error_status.equals("E")){
								
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(m));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(reaction_date1_disply));
            _bw.write(_wl_block46Bytes, _wl_block46);
 if(adv_reac_code.equals("Oth")) { 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(others_reaction));
            _bw.write(_wl_block46Bytes, _wl_block46);
} else { 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(reac_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(severity_two));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(reaction_site));
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);

							}else{
								if(!error_status.equals("E")){
								
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(m));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(m));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(reaction_date1_disply));
            _bw.write(_wl_block79Bytes, _wl_block79);
 if(adv_reac_code.equals("Oth"))	{ 
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(others_reaction));
            _bw.write(_wl_block79Bytes, _wl_block79);
}else{
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(reac_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(severity_two));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(reaction_site));
            _bw.write(_wl_block83Bytes, _wl_block83);

								}
							}
							allergen1=rs.getString("allergen_code");
								allergen2=rs.getString("allergen");
							reaction_date_prev =rs.getString("reaction_date");
							adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");
							status1 = rs.getString("status");
							adv_event_type_ind_code1 = rs.getString("adv_event_type_ind");
							onset_date1 = rs.getString("onset_date");
							onset_date_disply1=DateUtils.convertDate(onset_date1,"DMYHMS","en",locale);
							if(status1.equals("A")){
							status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
							}
							else if(status1.equals("R")){
							status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
							}else if(status1.equals("E")){
							status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
							}
							rowcolor ++;
							m++;
							rowCount++;
						}
						if(!(rs_load.equals("load"))){
							if((norecord.equals("noreords"))){
								if(m==0){
								out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
								}
							}
						}
						
            _bw.write(_wl_block84Bytes, _wl_block84);

					}
					
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(rowcolor));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(allergen));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(reaction_date_prev));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(onset_date_disply));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(reac_desc));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(internalStr));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(max_record));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(active_date));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(adv_event_type_code));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(adv_event_type_ind_code));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(final_reac_code_val));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(causative_substance));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(causative_code));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(severity_two));
            _bw.write(_wl_block101Bytes, _wl_block101);

	} catch(Exception e) {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		e.printStackTrace();
		//out.println("in RecordPatientAdverseEvent4.jsp @ :"+e);
	}
	finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block102Bytes, _wl_block102);
            _bw.write(_wl_block103Bytes, _wl_block103);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Assessment.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.Allergen.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReactionDate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.reactiondesc.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SiteOfReaction.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReactionDate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.reactiondesc.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Severity.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.SiteOfReaction.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
