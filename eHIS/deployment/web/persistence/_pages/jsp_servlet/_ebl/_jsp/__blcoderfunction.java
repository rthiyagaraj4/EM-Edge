package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eCommon.Common.*;
import org.json.simple.*;
import java.util.Map.Entry;
import java.util.Set;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eBL.*;
import eBL.resources.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcoderfunction extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCoderFunction.jsp", 1743575744934L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\";\n\t\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n\t\t\tdummyDoc.dummy_frm.submit();\n\t\t\t},\n\t\t\t error: function(data){\n\t\t\t\t alert(data);\n\t\t  }\n\t});\t\t\n\t}\n}\n\nfunction trim(str) {\n\tif(str != \"\"){\n\t\treturn str.replace(/^\\s+|\\s+$/g,\'\');\n\t}\n\treturn \"\";\n} \n\nfunction onLoadServiceEdit() {\n\tvar currentdate = new Date(); \n\tvar minutes=currentdate.getMinutes();\n\tif(minutes.length==1){\n\t\tminutes=\"0\"+minutes;\n\t}\n\tvar datetime = currentdate.getDate() + \"/\"\n\t\t\t\t\t+ (currentdate.getMonth()+1)  + \"/\" \n\t\t\t\t\t+ currentdate.getFullYear() + \" \"  \n\t\t\t\t\t+ currentdate.getHours() + \":\"  \n\t\t\t\t\t+ minutes;\n\t//Making Editable Functionlaity bas ed on billable check box\n\ttry{\n\t\t\tvar table = document.getElementById(\'serviceTable1\');\n\t\t\tvar rowCount = table.rows.length;\n\t\t\tif(rowCount>25){\n\t\t\t\trowCount=25;\n\t\t\t}\n        // var i=1 to start after header\n\t\t\tfor(var j=1; j<rowCount; j++) {\n\t\t\tvar colCount = table.rows[j].cells.length;\n\t\t\t//Disabling all service\n\t\t\t\tfor(var k=0; k<colCount; k++){\n\t\t\t\t\t\tvar str=table.rows[j].cells[k].innerHTML;\n\t\t\t\t\t\tvar res;\n\t\t\t\t\t\tif(str.indexOf(\"<INPUT\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<INPUT\", \"<INPUT disabled\");\n\t\t\t\t\t\t\tif(res.indexOf(\"<IMG\")==0){\n\t\t\t\t\t\t\tres = str.replace(\"<IMG\", \"<IMG disabled\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse if(str.indexOf(\"<SELECT\")==0 ){\n\t\t\t\t\t\t\tres = str.replace(\"<SELECT\", \"<SELECT disabled\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\ttable.rows[j].cells[k].innerHTML=res;\n\t\t\t\t}\n\t\t\t}\n\t}catch(e){\n\t\t\talert(\"Exception in Editable functionality against billable checkbox Row \"+e);\n\t\t}\n}\n\nfunction GenerateBill(){\n\t//Calling gen Bill Function\n\tvar facilityId =  $(\'#facilityId\').val();\n\tvar patientId = $(\'#PatientID\').val();\n\tvar encounter_id =  $(\'#encounter_id\').val();\n\tvar ServiceSessionId =  $(\'#ServiceSessionId\').val();\t\n\tvar localeLang =  $(\'#localeLang\').val();\t\n\tvar WS_NO =  $(\'#WS_NO\').val();\t\t\n\tvar loginUser =  $(\'#loginUser\').val();\t\n\tvar EpisodeType =  $(\'#EpisodeType\').val();\t\n\tvar params=\"&facilityId=\"+facilityId+\"&encounter_id=\"+encounter_id+\"&ServiceSessionId=\"+ServiceSessionId+\"&localeLang=\"+localeLang+\"&WS_NO=\"+WS_NO+\"&loginUser=\"+loginUser+\"&EpisodeType=\"+EpisodeType+\"&patientId=\"+patientId;\n\tvar temp_jsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=GenBill\"+params;\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\t\t\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(\"\");\n\tvar responseText=xmlHttp.responseText;\n\tresponseText = trimString(responseText);\n\tvar n1 = responseText.indexOf(\"~\");\n\tvar res1 = responseText.substr(n1+1);\n\tres1 = res1.split(\"~\");\n\tif(res1[0]==\"E\"){\n\tvar msgText=getMessage(res1[1],\'BL\');\n\t\tif(msgText==\"\" || msgText==null){\n\t\t\tvar tempJsp=\"../../eBL/jsp/BLCoderFunServiceValidations.jsp?CalledFor=getMsgFromDB&msgId=\"+res1[1];\n\t\t\tvar xmlDoc = \"\";\n\t\t\tvar xmlHttp = new XMLHttpRequest();\t\t\n\t\t\txmlHttp.open(\"POST\",tempJsp,false);\n\t\t\txmlHttp.send(\"\");\n\t\t\tvar resText=xmlHttp.responseText;\n\t\t\tresText = trimString(resText);\n\t\t\tvar nFin = resText.indexOf(\"~\");\n\t\t\tvar resFin = resText.substr(nFin+1);\n\t\t\tif(resFin==\"\" || resFin==null){\n\t\t\t\talert(\"Error at server end..\");\n\t\t\t}else{\n\t\t\t\talert(resFin);\n\t\t\t}\n\t\t}else{\n\t\t\talert(msgText);\n\t\t}\n\t}else if(res1[0]==\"Err\"){\n\t\talert(res1[1]);\n\t}else if(res1[0]==\"S\"){\n\t\tif(res1.length==2){\n\t\t\talert(res1[1]);\n\t\t}\n\t\telse if(res1.length==3){\n\t\t\talert(res1[1]);\n\t\t\talert(res1[2]);\n\t\t}\n\t}else{\n\t\talert(res1[1]);\n\t}\n\tlocation.reload();\n\tparent.frames[3].location.reload();//V230222/AAKH-CRF-0172\n}\n\nfunction EditService(){\n\tvar ServiceSessionId = $(\'#ServiceSessionId\').val();\n\tvar ServiceEncounterId = $(\'#encounter_id\').val();\n\t//V201015 Starts\n\tvar patientId = $(\'#PatientID\').val();\n\tvar EpisodeType = $(\'#EpisodeType\').val();\n\tvar EpisodeID = $(\'#EpisodeID\').val();\n\tvar visit_Id = $(\'#visit_Id\').val();//Added by Kamatchi S for TH-KW-CRF-0143\n\tvar siteSpecPatPayable = $(\'#siteSpecPatPayable\').val();//V230222/AAKH-CRF-0172\n\tvar siteSpecSearch = $(\'#siteSpecSearch\').val();//V230529/AAKH-CRF-0153\n\t//V201015 Ends\n\t//document.forms[0].ServiceSessionId.value;\n\tvar param=\"ServiceSessionId=\"+ServiceSessionId+\"&ServiceEncounterId=\"+ServiceEncounterId+\"&patientId=\"+patientId+\"&episode_type=\"+EpisodeType+\"&episode_id=\"+EpisodeID+\"&visit_Id=\"+visit_Id+\"&siteSpecPatPayable=\"+siteSpecPatPayable+\"&siteSpecSearch=\"+siteSpecSearch; //V201015 Modified //Modified by Kamatchi S TH-KW-CRF-0143 //V230222\n\tvar dialogUrl       = \"../../eBL/jsp/BLCoderEditService.jsp?\"+param;\n\tvar dialogFeatures  = \"dialogHeight:\" + \"100\" + \"; dialogWidth:\" + \"100\" +\" ; scroll=auto; \";\n\t/*var returnVal = window.showModalDialog(dialogUrl,null,dialogFeatures);\n\tif(returnVal==\"Close\"){\n\t\tlocation.reload();\n\t}*/\n\t//if(openFlag){\n\t//openFlag=false;\n\tdocument.getElementById(\"GenBill\").disabled = true;\n\tdocument.getElementById(\"EditService\").disabled = true;\n\tvar retValue=window.open(dialogUrl, \"\", \"directories=no,fullscreen=yes,titlebar=no,toolbar=no,menubar=no,resizable=yes, top=0, left=0,scrollbars=yes\");\n\t//}\n}\n\nfunction setValue(val){\n\t//openFlag=val;\n\tdocument.getElementById(\"GenBill\").disabled = false;\n\tdocument.getElementById(\"EditService\").disabled = false;\n\tlocation.reload();\n}\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<body onload=\"onLoadServiceEdit()\" onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\">\n<center>\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n  <tr>\n    <td>\n    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n    \t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"2\">\n\t      <tr >\n\t      \t <td class=\"BOLD\">Services</td>\n\t\t\t <td width=\"40%\"></td>&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t      \t  <td style=\"align:center\">\n\t\t\t\t<input type=\"text\" name=\"searchCPT\" id=\"searchCPT\" id=\"searchCPT\" placeholder=\"CPT Code Search\" title=\"search CPT Code\"> \n\t\t\t\t<img alt=\"search\" src=\"..\\..\\eBL\\images\\search.png\" onclick=\"searchCptCode(searchCPT)\">\n\t\t\t  </td> \n\t\t\t ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t      </tr>\n      </table>\n      <tr>\n        <td><table width=\'100%\' align=\"center\" cellpadding=\"4\" cellspacing=\"0\" class=\'grid\' id=\"serviceTable1\" name=\'serviceTable1\' id=\'serviceTable1\'>\n          <tr>\n            <td class=\'COLUMNHEADER\' >Date &amp; Time</td>\n            <td class=\'COLUMNHEADER\' >Drug/Non drug </td>\n            <td class=\'COLUMNHEADER\' >Service Type</td>\n            <td class=\'COLUMNHEADER\' >Service Code(CPT)</td>\n            <td class=\'COLUMNHEADER\' >Service Description</td>\n\t\t\t<!--Added by Kamatchi S for TH-KW-CRF-0143-->\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<td class=\'COLUMNHEADER\' >Billing Service Code</td>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n            <td class=\'COLUMNHEADER\' >Ordering Clinician </td>\n            <td class=\'COLUMNHEADER\' >Performing Clinician</td>\n            <td class=\'COLUMNHEADER\' >Quantity</td>\n            <td class=\'COLUMNHEADER\' >Modifier/ Adjuster</td>\n            <td class=\'COLUMNHEADER\' >Zero Price</td>\n            <td class=\'COLUMNHEADER\' >Approval No.</td>\n            <td class=\'COLUMNHEADER\' >Approval Date </td>\n            <td class=\'COLUMNHEADER\' >Service Price</td>\n\t\t\t<!--Added by Kamatchi S for TH-KW-CRF-0143-->\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n            <td class=\'COLUMNHEADER\' >Ins/Cash Price</td>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<td class=\'COLUMNHEADER\' >Ins.Price</td>\t\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' >Patient Payable</td>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n            <td class=\'COLUMNHEADER\' >Billable</td>\n            <td class=\'COLUMNHEADER\' >Add Row</td>\n            <td class=\'COLUMNHEADER\' >Cancel Services</td>\n            <td style=\"display:none;\">BillDocTypeCode</td>\n            <td style=\"display:none;\">BillDocNo</td>\n            <td style=\"display:none;\">CustGrpCode</td>\n            <td style=\"display:none;\">CustCode</td>\n            <td style=\"display:none;\">TrxDocRef</td>\n            <td style=\"display:none;\">TrxDocRefLineNo</td>\n            <td style=\"display:none;\">TrxDocRefSeqNoNo</td>\n            <td style=\"display:none;\">TrxDate</td>\n            <td style=\"display:none;\">SettlementInd</td>\n            <td style=\"display:none;\">PatientAmt</td>\n            <td style=\"display:none;\">Key Value</td>\n            </tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<tr id=\'serviceRow";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' disabled>\n            <td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"><input type=\"text\" onblur=\"validateDateTime(this)\" class=\"gridDataInputMore ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" name=\"serviceDate";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"serviceDate";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" size=\"18\" maxlength=\"18\"><img src=\"../../eCommon/images/CommonCalendar.gif\"></td>\n            <td class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n            \t<select name=\"servicetype";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"servicetype";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onchange=\"DrugTypeChange(this)\">       \n\t\t\t\t\t<option value=\"Select\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">-Select-</option>\n              \t\t<option value=\"Service\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">Service</option>\n              \t\t<option value=\"Drug\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">Drug</option>\n             \t </select>\n            </td>\n            <td class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"><input class=\"gridDataInputLess ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" maxlength=\"100\" type=\"text\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"></td>\n            <td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"><input class=\"gridDataInput ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" style=\"width: 100px;\" type=\"text\" name=\"cptCode";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onblur=\"validateCPTCode(this)\" id=\"cptCode";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" ><input class=\"gridDataInput\" type=\"hidden\" name=\"serviceCode";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"serviceCode";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" ></td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" type=\"text\" name=\"serviceDesc";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"serviceDesc";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"  title=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"></td>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="<!--Added by Kamatchi S for TH-KW-CRF-0143-->\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" type=\"text\" name=\"serviceCode";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n            <td class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" type=\"text\" name=\"orderClinic";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"orderClinic";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" ></td>\n            <td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" type=\"text\" name=\"performClinic";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"performClinic";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" type=\"text\" name=\"serviceQty";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"serviceQty";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" onblur=\"validateServQty(this)\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"  ><input style=\"display:none;\" type=\"text\" id=\"serviceRateCharge";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" value=\"\" ></td>\n            <td class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" type=\"text\" maxlength=\"30\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"><input type=\"checkbox\" name=\"checkbox";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"checkbox";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" onclick=\"zeroPriceClick(this)\"  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="/></td>\n            <td class=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" type=\"text\" name=\"ApproveNum";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"ApproveNum";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" onchange=\"ModAppNo(this)\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" ><input style=\"display:none;\" type=\"text\" id=\"serviceModAppNo";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" value=\"N\" ></td>\n            <td class=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"><input class=\"gridDataInputMore ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" type=\"text\" name=\"ApproveDate";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"ApproveDate";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" onchange=\"ModAppNo(this)\"  value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" ><img src=\"../../eCommon/images/CommonCalendar.gif\"></td>\n            <td class=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" type=\"text\" name=\"ServPrice";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"ServPrice";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" type=\"text\" name=\"InsAmt";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"InsAmt";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" ></td>\n\t\t\t<!--V230222-->\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" \n\t\t\t <td class=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t \t<input class=\"gridDataInput ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" type=\"text\" name=\"patPay";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"patPay";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" >\n\t\t\t </td>\n\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n            \t<input type=\"checkbox\" name=\"checkboxBill";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"checkboxBill";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"  onclick=\"billClick(this)\" ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="/>\n            \t<input style=\"display:none;\" type=\"text\" id=\"serviceBillCheck";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" >\n            </td>\n            <td class=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"><input type=\"button\" name=\"AddBTn";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"AddBTn";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"  value=\"+\" onclick=\"addRow(this)\" id=\"AddBTn";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n            \t<input style=\"display:none;\" type=\"text\" id=\"serviceAddRow";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" value=\"\" >\n            </td>\n            <td class=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"><input type=\"checkbox\" name=\"Cancelcheck";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"Cancelcheck";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" value=\"\" id=\"Cancelcheck";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" onclick=\"CancelClick(this)\" ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" /><input style=\"display:none;\" type=\"text\" id=\"serviceCancelRow";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" value=\"\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" ></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"></td>\n            <td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" ></td>\n\t\t\t<td style=\"display:none;\"><input type=\"text\" style=\"display:none;\"  value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" ></td>\n\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t<td style=\"display:none;\"><input type=\"hidden\" name=\"isbilled";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" id=\"isbilled";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"></td>\n\t\t\t<td style=\"display:none;\"><input type=\"hidden\" name=\"boldYN";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" id=\"boldYN";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t  </table></td>\n\t</tr>\n  <tr>\n  \t<td>\n  \t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\n  \t\t\t<tr>\n\t\t\t\t<td style=\"text-align:left\"><input type=\"submit\" name=\"EditService\" id=\"EditService\" id=\"EditService\" value=\"Details / Edit\" onclick=\"EditService()\"/></td>\n\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="<!-- Modified by Kamatchi S for TH-KW-CRF-0143-->\n\t\t\t\t<td style=\"text-align:left\"><input type=\"submit\" name=\"Generate Bill\" id=\"Generate Bill\" id=\"GenBill\" disabled value=\"Generate Bill\" onclick=\"GenerateBill()\"/></td>\n\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t<td style=\"text-align:left\"><input type=\"submit\" name=\"Generate Bill\" id=\"Generate Bill\" id=\"GenBill\" value=\"Generate Bill\" onclick=\"GenerateBill()\"/></td>\n\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n  \t\t\t</tr>\n  \t\t</table>\n  \t</td> \n  </tr>\n  </table></td>\n  </tr>\n  <tr>\n    <td ><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\n\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n      <tr>\n        <td colspan=\"5\" class=\"BOLD\">Financial Status</td>\n      </tr>\n      <tr>\n        <td >Patient Share</td>\n        <td><input type=\'text\' class=\"gridDataInputMore\" style=\"width: 200px;font-weight:bold;\"  value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" onfocus=\"this.blur()\" readonly=\"readonly\" ></td><!-- V201222 Modified --> \n        <td >&nbsp;</td>\n        <td >Patient Paid</td>\n        <td><input type=\'text\' class=\"gridDataInputMore\" style=\"width: 200px;font-weight:bold;\"  value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" onfocus=\"this.blur()\" readonly=\"readonly\"></td><!-- V201222 Modified --> \n        </tr>\n      <tr>\n        <td >Patient Outstanding</td> <!-- V201222 Modified --> \n        <td><input type=\'text\' class=\"gridDataInputMore\" style=\"width: 200px;font-weight:bold;\"  value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" onfocus=\"this.blur()\" readonly=\"readonly\"></td><!-- V201222 Modified --> \n        <td >&nbsp;</td>\n        <td >Gross Amount</td>\n        <td><input type=\'text\' class=\"gridDataInputMore\" style=\"width: 200px;font-weight:bold;\"  value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\" onfocus=\"this.blur()\" readonly=\"readonly\"></td><!-- V201222 Modified --> \n        </tr>\n        <tr>\n        <td >Deposit Amount</td>\n        <td><input type=\'text\' class=\"gridDataInputMore\" style=\"width: 200px;font-weight:bold;\"  value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" onfocus=\"this.blur()\" readonly=\"readonly\"></td><!-- V201222 Modified --> \n        <td >&nbsp;</td>\n        <td class=\"BOLD\" >Net Claim Amount</td>\n        <td><input type=\'text\' class=\"gridDataInputMore\" id=\"netClaimAmt\" style=\"width: 200px;color:red;font-weight:bold;\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\" onfocus=\"this.blur()\" readonly=\"readonly\"></td><!-- V201222 Modified --> \n        </tr>\n    </table></td>\n  </tr>\n  <tr>\n\t<td>\n\t\t<input type=\"button\" name=\"visitGenBill\" id=\"visitGenBill\" id=\"visitGenBill\" value=\"Encounter - Generated Bills\" onclick=\"rePrintAllBill()\"/></td>\n\t</td>\n  </tr>\n</table>\n\t</center>\n\t<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"> \n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"> \n\t<input type=\"hidden\" name=\"ServiceSessionId\" id=\"ServiceSessionId\" id=\"ServiceSessionId\" value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"> \n\t<input type=\"hidden\" name=\"localeLang\" id=\"localeLang\" id=\"localeLang\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"> \n\t<input type=\"hidden\" name=\"WS_NO\" id=\"WS_NO\" id=\"WS_NO\" value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">  \n\t<input type=\"hidden\" name=\"loginUser\" id=\"loginUser\" id=\"loginUser\" value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t<input type=\"hidden\" name=\"EpisodeType\" id=\"EpisodeType\" id=\"EpisodeType\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" > \n\t<input type=\"hidden\" name=\"logInWSno\" id=\"logInWSno\" id=\"logInWSno\" value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\"> \n\t<input type=\"hidden\" name=\"logInUserId\" id=\"logInUserId\" id=\"logInUserId\" value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\"> \n\t<input type=\"hidden\" name=\"PatientID\" id=\"PatientID\" id=\"PatientID\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"> \t\n\t<input type=\"hidden\" name=\"EpisodeID\" id=\"EpisodeID\" id=\"EpisodeID\" value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\t\t\t\n\t<input type=\"hidden\" name=\"VisitID\" id=\"VisitID\" id=\"VisitID\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"> \n\t<input type=\"hidden\" name=\"siteSpecPatPayable\" id=\"siteSpecPatPayable\" id=\"siteSpecPatPayable\" value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\"> <!--V230222-->\n\t<input type=\"hidden\" name=\"siteSpecSearch\" id=\"siteSpecSearch\" id=\"siteSpecSearch\" value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"> <!--V230529-->\n\t<input type=\"hidden\" name=\"visit_Id\" id=\"visit_Id\" id=\"visit_Id\" value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\"> <!-- Added by Kamatchi S for TH-KW-CRF-0143-->\n\t<input type=\"hidden\" name=\"limit\" id=\"limit\" id=\"limit\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"> \n\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );
	
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Version     	Developer Name		Rev.Date		Rev.Name		SCF/CRF
-------------------------------------------------------------------------------------------------------------------------------------
09/06/2020 	  		         Ram kumar S									  AAKH-CRF-0122
15/10/2020 	 V201015	     Ram kumar S									  AAKH-SCF-0458
22/12/2020 	 V201222	     Ram kumar S									  AAKH-SCF-0479
29/09/2022                   Kamatchi S                                       TH-KW-CRF-0143
V230516						Mohanapriya										  AAKH-CRF-0153
-------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	Connection con= null;
	Connection conSession = null;
	PreparedStatement pstmtSession = null ;
	ResultSet rsSession = null;
	String facilityId			= (String) session.getValue("facility_id");
	String encounter_id			= request.getParameter("encounter_id");
	String loginUser			= (String) session.getValue("login_user");
	String SessionId            = request.getParameter("session_id");
	String User					=	"";
	String bean_id				=	"";
	String bean_name			=	"";
	String KeyValue="";
	String EpisodeType=request.getParameter("episode_type");
	String EpisodeID=request.getParameter("episode_id");
	String PatientID= request.getParameter("patient_id");
	String VisitID="";
	String visit_Id = request.getParameter("visit_Id");//Added by Kamatchi S for TH-KW-CRF-0143
	java.util.Properties p=null;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String WS_NO           =p.getProperty("client_ip_address");
	bean_id					= 	"BLCoderPatServiceBean" ;
	bean_name				= 	"eBL.BLCoderPatServiceBean"; 
	LinkedHashMap 	blCoderpatServices	=	null;
	BLCoderPatServiceBean blCoderPatServiceBean = 	null;
	BLCoderPatService	blCoderPatService = null;	
	Boolean siteSpecServiceCode = false;//Added by Kamatchi S for TH-KW-CRF-0143
	Boolean siteSpecPatPayable=false;//V230222
	Boolean siteSpecSearch=false;//V230529
	blCoderpatServices	=	new LinkedHashMap();
	blCoderPatServiceBean	= 	(BLCoderPatServiceBean)PersistenceHelper.getBeanObject( bean_id, bean_name, request );
		
	//Getting Loaded Hashmap with Services
	String localeLang			= (String)session.getAttribute("LOCALE");
	String logInUserId="";
	String logInWSno="";
	blCoderPatServiceBean.clearBean();
	blCoderPatServiceBean.getDBValues(SessionId,facilityId,encounter_id);
	//SimpleDateFormat serviceIPSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
	//SimpleDateFormat serviceOPSdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	int limit=0;
	int limitId=1;
	blCoderpatServices	= 	(LinkedHashMap)blCoderPatServiceBean.getBLCoderPatSearchValues(); 
	con = ConnectionManager.getConnection(request);//Modified by Kamatchi S for TH-KW-CRF-0143
	siteSpecServiceCode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_SERVICE_CODE_REQD");//Added by Kamatchi S for TH-KW-CRF-0143
	siteSpecPatPayable =  eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ALLOW_CASH_PAT_IN_CODER_FN");//V230222
	siteSpecSearch =  eCommon.Common.CommonBean.isSiteSpecific(con, "BL","AAKH_BL_SCREEN_CHANGES");//V230529
	System.err.println("siteSpecSearch "+siteSpecSearch);


            _bw.write(_wl_block6Bytes, _wl_block6);
if(siteSpecSearch){
            _bw.write(_wl_block7Bytes, _wl_block7);
 } 
            _bw.write(_wl_block8Bytes, _wl_block8);
 if(siteSpecServiceCode){
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(siteSpecServiceCode){
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
if(siteSpecPatPayable){
            _bw.write(_wl_block14Bytes, _wl_block14);
} //V230222/AAKH-CRF-0172
			
            _bw.write(_wl_block15Bytes, _wl_block15);
	
	
	if(blCoderpatServices.size()>25){
		limit=25;
	}else{
		limit=blCoderpatServices.size();
	}
	if(!blCoderpatServices.isEmpty()) {
         Iterator it = blCoderpatServices.entrySet().iterator();
		 int s=0;
			//for(int s=0;s<limit;s++){
         while(it.hasNext()&& s<limit) {
			 s++;
				Map.Entry obj = (Entry)it.next();
				blCoderPatService=(BLCoderPatService)obj.getValue();
				KeyValue=(String)obj.getKey();
		   if(blCoderPatService!=null){
			   //Login User ID
			   logInUserId= blCoderPatService.getlogInID();
				logInUserId=(logInUserId==null?"":logInUserId);
				//Login WS No ID
			   logInWSno= blCoderPatService.getlogInWSNo();
				logInWSno=(logInWSno==null?"":logInWSno);
			   //Bill Doc type code
			   String BillDocTypeCode= blCoderPatService.getBillDocTypeCode();
				BillDocTypeCode=(BillDocTypeCode==null?"":BillDocTypeCode);
			   //Bill Doc Number
			   String BillDocNo= blCoderPatService.getBillDocNum();
				BillDocNo=(BillDocNo==null?"":BillDocNo);
			   //Customer Group Code
			   String CustGrpCode= blCoderPatService.getCustGroupCode();
				CustGrpCode=(CustGrpCode==null?"":CustGrpCode);
			   //Customer Code
			   String CustCode= blCoderPatService.getCustCode();
				CustCode=(CustCode==null?"":CustCode);
			   //TRX Doc Ref
			   String TrxDocRef= blCoderPatService.getTrxDocRef();
				TrxDocRef=(TrxDocRef==null?"":TrxDocRef);
			   //TRX Doc Ref Line No
			   String TrxDocRefLineNo= blCoderPatService.getTrxDocRefLineNum();
				TrxDocRefLineNo=(TrxDocRefLineNo==null?"":TrxDocRefLineNo);
			   //TRX Doc Ref Seq No
			   String TrxDocRefSeqNo= blCoderPatService.getTrxDocRefSeqNum();
				TrxDocRefSeqNo=(TrxDocRefSeqNo==null?"":TrxDocRefSeqNo);
			   //TRX Date
			   String TrxDate= blCoderPatService.getTrxDate();
				TrxDate=(TrxDate==null?"":TrxDate);
				/*if(!TrxDate.equals("")){
					java.util.Date servdateTime3 = serviceIPSdf.parse(TrxDate);
					TrxDate = serviceOPSdf.format(servdateTime3);
				}*/
			   //Episode Type
			    EpisodeType= blCoderPatService.getEpisodeType();
				EpisodeType=(EpisodeType==null?"":EpisodeType);
			   //Episode Id
			    EpisodeID= blCoderPatService.getEpisodeId();
				EpisodeID=(EpisodeID==null?"":EpisodeID);
			   //Visit Id
			    VisitID= blCoderPatService.getVisitId();
				VisitID=(VisitID==null?"":VisitID);
			   //Settlement Ind
			   String SettlementInd= blCoderPatService.getSettlementInd();
				SettlementInd=(SettlementInd==null?"":SettlementInd);
			   //Patient Amount
			   String PatientAmt= blCoderPatService.getPatientAmount();
				PatientAmt=(PatientAmt==null?"":PatientAmt);
			   //Date and Time
				String Service_Date=  blCoderPatService.getServiceDate();
				Service_Date=(Service_Date==null?"":Service_Date);
				/*if(!Service_Date.equals("")){
					java.util.Date servdateTime2 = serviceIPSdf.parse(Service_Date);
					Service_Date = serviceOPSdf.format(servdateTime2);
				}*/
			   // Drug-NonDrug
				String Service_Type_Ind=  blCoderPatService.getServTypeInd();
				Service_Type_Ind=(Service_Type_Ind==null?"":Service_Type_Ind);
				String opt1="";
				String opt2="";
				String opt3="";
				if(Service_Type_Ind.equals("S") || Service_Type_Ind.equals("")){
					Service_Type_Ind="Service";
					opt1="";
					opt2="selected";
					opt3="";
				}else if(Service_Type_Ind.equals("I")){
					Service_Type_Ind="Drug";
					opt1="";
					opt2="";
					opt3="selected";
				}else{
					Service_Type_Ind="Drug";
					opt1="selected";
					opt2="";
					opt3="";
				}
			   // Service Type
				String Service_Type=  blCoderPatService.getServTypeDesc();
				Service_Type=(Service_Type==null?"":Service_Type);
				// CPT Code
				String CPT_Code=  blCoderPatService.getcptCode();
				CPT_Code=(CPT_Code==null?"":CPT_Code);
			   // Service Code
				String Service_Code=  blCoderPatService.getServItemCode();
				Service_Code=(Service_Code==null?"":Service_Code);
			   // Service Description
				String Service_Desc=  blCoderPatService.getServItemDesc();
				Service_Desc=(Service_Desc==null?"":Service_Desc);
			   // Ordering Clinician
				String Ordering_Clinician=  blCoderPatService.getOrderingPhysicianName();
				Ordering_Clinician=(Ordering_Clinician==null?"":Ordering_Clinician);
			   // Performing Clinician
				String Perform_Clinician=  blCoderPatService.getPerformPhysicianName();
				Perform_Clinician=(Perform_Clinician==null?"":Perform_Clinician);
			   // Quantity
				String Quantity=  blCoderPatService.getServQty();
			   // Modifier/Adjuster
				String Mod_Adjus=  blCoderPatService.getModifierAdjusterId();
				Mod_Adjus=(Mod_Adjus==null?"":Mod_Adjus);
			   // Zero Price
				String Zero_Price=  blCoderPatService.getZeroPriceYN();
				Zero_Price=(Zero_Price==null?"":Zero_Price);
				if(Zero_Price.equals("Y")){
					Zero_Price="checked";
				}else{
					Zero_Price="";
				}					
			   // Approval Number
				String Approval_No=  blCoderPatService.getCDRApprovalNo();
				Approval_No=(Approval_No==null?"":Approval_No);
			   // Approval Date
				String Approval_Date=  blCoderPatService.getCDRApprovalDate();
				Approval_Date=(Approval_Date==null?"":Approval_Date);
				/*if(!Approval_Date.equals("")){
				java.util.Date servdateTime4 = serviceIPSdf.parse(Approval_Date);
				Approval_Date = serviceOPSdf.format(servdateTime4);
			    System.err.println("Approval Date From Bean  "+Approval_Date);
				}*/
			   // Service Price
				String Service_Price=  blCoderPatService.getServiceAmount();
				Float servicePrice=Float.parseFloat(Service_Price);
				DecimalFormat df = new DecimalFormat("0.00");
				Service_Price = df.format(servicePrice);
			   // Insurance Amount
				String Ins_Amt=  blCoderPatService.getInsuranceAmount();
				Float insAmt=Float.parseFloat(Ins_Amt);
				Ins_Amt = df.format(insAmt);
				//V230222
				String pat_payable=  blCoderPatService.getPatientPayable();
				Float pat_pay=Float.parseFloat(pat_payable);
				pat_payable = df.format(pat_pay);
				//V230222
			   // Billable CheckBox
				String Billable_Check=  blCoderPatService.getBillableYN();
				Billable_Check=(Billable_Check==null?"":Billable_Check);
				if(Billable_Check.equals("Y")){
					Billable_Check="checked";
				}else{
					Billable_Check="unchecked";
				}
				//BillYN
				String  isbilled="";//V230516
				String boldYN="";//V230516
				String	Bill_YN=blCoderPatService.getBillYN();
				if(Bill_YN.equals("Y")){
					Bill_YN="checked";
					if(siteSpecSearch){
						isbilled="";
						boldYN="";
					}
				}else{
					Bill_YN="unchecked";
					if(siteSpecSearch){
						isbilled="unbilled";//V230516-AAKH-CRF-0153
						boldYN="bolder";
					}
				}			
			   // Add Row
				String AddRow=  blCoderPatService.getAddRowYN();
				AddRow=(AddRow==null?"":AddRow);
				if(AddRow.equals("Y")){
					AddRow="disabled";
				}else{
					AddRow="";
				}
			   // Cancel Services
				String Cancel_Services=  blCoderPatService.getCancelRowYN();
				Cancel_Services=(Cancel_Services==null?"":Cancel_Services);
				if(Cancel_Services.equals("Y")){
					Cancel_Services="checked";
				}else{
					Cancel_Services="unchecked";
				}
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(opt1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(opt2));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(opt3));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Service_Type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(CPT_Code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(Service_Desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(siteSpecServiceCode){
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Code));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Ordering_Clinician));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Perform_Clinician));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(Quantity));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Mod_Adjus));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Zero_Price));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Zero_Price));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(Approval_No));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(Approval_Date));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Service_Price));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Ins_Amt));
            _bw.write(_wl_block74Bytes, _wl_block74);
 if(siteSpecPatPayable){
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pat_payable ));
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Billable_Check));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(Billable_Check));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Bill_YN));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(Cancel_Services));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(BillDocTypeCode));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(BillDocNo));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(CustGrpCode));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(CustCode));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(TrxDocRef));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(TrxDocRefLineNo));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(TrxDocRefSeqNo));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(TrxDate));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(SettlementInd));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(PatientAmt));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(KeyValue));
            _bw.write(_wl_block99Bytes, _wl_block99);
if(siteSpecSearch || siteSpecPatPayable){
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(isbilled));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(boldYN));
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block104Bytes, _wl_block104);
				
				} 
				limitId++;	   
         }
      }	

            _bw.write(_wl_block105Bytes, _wl_block105);
if(siteSpecServiceCode){
            _bw.write(_wl_block106Bytes, _wl_block106);
}else{
            _bw.write(_wl_block107Bytes, _wl_block107);
}
            _bw.write(_wl_block108Bytes, _wl_block108);

		// Populating Financial Details 
		double patShareAmt=0.0d;
		double patPaidAmt=0.0d;
		double grossAmt=0.0d;
		double outStandAmt=0.0d;
		double depositAmt=0.0d;
		String pat_ShareAmt1="";
		String pat_PaidAmt1 ="";
		String gross_Amt1   ="";
		String outStandAmt1 ="";
		String netClaim_Amt1="";
		String depositAmt1="";
		String sessioStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		try	{
				//con = ConnectionManager.getConnection(request);//Commented for TH-KW-CRF-0143 by Kamatchi S
				String Query_Populate_Fin_Dtls = "{ call bl_coders.get_fin_dtls('"+facilityId+"','"+SessionId+"','"+encounter_id+"','"+localeLang+"','"+loginUser+"',?,?,?,?,?,?) }";
				CallableStatement call = con.prepareCall(Query_Populate_Fin_Dtls);		
					
				call.registerOutParameter(1,java.sql.Types.DOUBLE);
				call.registerOutParameter(2,java.sql.Types.DOUBLE);
				call.registerOutParameter(3,java.sql.Types.DOUBLE);
				call.registerOutParameter(4,java.sql.Types.DOUBLE);
				call.registerOutParameter(5,java.sql.Types.VARCHAR);// V201222 Modified 
				call.registerOutParameter(6,java.sql.Types.DOUBLE);
				call.execute();
				DecimalFormat df1 = new DecimalFormat("#.00");
				patShareAmt = call.getDouble(1);
				patPaidAmt = call.getDouble(2);
				grossAmt = call.getDouble(3);
				outStandAmt = call.getDouble(4);
				netClaim_Amt1 = call.getString(5); // V201222 Modified 
				depositAmt = call.getDouble(6);
				pat_ShareAmt1 =  String.format("%,.2f", patShareAmt);
				pat_PaidAmt1  =  String.format("%,.2f", patPaidAmt);
				gross_Amt1    =  String.format("%,.2f", grossAmt);
				outStandAmt1  =  String.format("%,.2f", outStandAmt);
				depositAmt1   =  String.format("%,.2f", depositAmt);
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception Occured in Procedure Call Coder Function Services  "+e);
		}
	
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(pat_ShareAmt1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(pat_PaidAmt1));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(outStandAmt1));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(gross_Amt1));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(depositAmt1));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(netClaim_Amt1 ));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(SessionId));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(localeLang));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(WS_NO));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(EpisodeType));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(logInWSno));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(logInUserId));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(PatientID));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(EpisodeID));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(VisitID));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(siteSpecPatPayable));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(siteSpecSearch));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(visit_Id));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(limitId));
            _bw.write(_wl_block131Bytes, _wl_block131);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
