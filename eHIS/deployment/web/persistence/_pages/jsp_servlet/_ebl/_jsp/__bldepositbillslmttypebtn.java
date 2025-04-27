package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __bldepositbillslmttypebtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLDepositBillSlmtTypeBtn.jsp", 1743663812246L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6_0 ="\n\n<html>\n\t<head>\n\t\t<script>\n\t\tvar totalRecords=\"\";\n\t\tvar count=\"\";\n\t\tvar formObj=\"\";\n\t\tvar classval=\"\";\n\n\t\tfunction addBillSlmt()\n\t\t{\t\n\t\t\tdocument.forms[0].doc_amt.value=\"\";\n\t\t\t\n\t\t\tvar query_string=document.forms[0].query_string.value;\n\t\t\tvar formObj = parent.frames[2].document.forms[0];\n\t\t\ttotal_records=formObj.total_records.value;\n\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\t\ttemp.checked=false;\n\t\t\t}\n\t\t\tvar retVal = new Array();\n\t\t\tvar billdoctype=document.forms[0].billdoctype.value;\n\t\t\tvar billdocnum=document.forms[0].billdocnum.value;\n\t\t\tvar blnggrp=document.forms[0].blnggrp.value;\n\t\t\tvar total_amt_payable=document.forms[0].total_amt_payable.value;\t\n\t\t\tvar total_settled_amt=document.forms[0].total_settled_amt.value;\t\n\t\t\tvar function_id=document.forms[0].function_id.value;\t\n\t\t\t//if(function_id==\'rcpt_rfnd\') \n\t\t\tif(function_id==\'rcpt_rfnd\' || function_id==\'PKG_BILLING\' )\n\t\t\t{\n\t\t\tvar settled_amt_det=parent.frames[1].document.forms[0].stlmt_amount.value;\n\t\t\t}else{\n\t\t\t\tvar settled_amt_det=parent.frames[0].document.forms[0].billslmtamtdet.value;\n\t\t\t}\n\n\t\n//\tvar tot_curr_stlmt=parent.frames[1].document.forms[0].tot_curr_stlmt.value;\n/*\n\tif(parseFloat(tot_curr_stlmt)!=parseFloat(settled_amt_det))\n\t{\n\t\t alert(getMessage(\"BL9659\",\"BL\"));\n\t\t//alert(\"Allocated Amt Must Be Equal To Settled Amt\");\n\t\treturn false;\n\t}\n*/\n\t\tvar action=\"add\";\t\n\t\tif(settled_amt_det==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\treturn;               \n\t\t}\t\t\n\t\tif(eval(settled_amt_det)==0 && eval(total_settled_amt)==0)\n\t\t{\n\t\t\talert(getMessage(\"BL9796\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif(parseFloat(settled_amt_det)==parseFloat(total_settled_amt))\n\t\t{\t\t\n\t\t\talert(getMessage(\"BL9637\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t/*if(total_amt_payable==total_settled_amt)\n\t{\n\t\t//alert(\"Amount Settled\");\n\t\talert(getMessage(\"BL9614\",\"BL\"));\n\t\treturn;\n\t}\n\ttotal_amt_payable=parseFloat(total_amt_payable)-parseFloat(total_settled_amt);\n\tif(total_amt_payable<0)\n\t{\n\t\ttotal_amt_payable=\'0.00\';\n\t}*/\n\t\n\tvar center=\'1\';\n\tvar dialogTop = \"0vh\";\n\tvar dialogHeight = \"65vh\" ;\n\tvar dialogWidth = \"58vw\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\t\n\tvar title=encodeURIComponent(getLabel(\"eBL.ADD_BILL_SLMT_DTL.label\",\"BL\"));\n\t//title=encodeURIComponent(title);\t\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\t\n//\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billdoctypecode=\"+billdoctype+\"&\"+\"billdocnum=\"+billdocnum+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"total_amt_payable=\"+total_amt_payable+\"&\"+\"action=\"+action+\"&\"+\"settled_amt_det=\"+settled_amt_det+\"&\"+\"total_settled_amt=\"+total_settled_amt;\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"blnggrp=\"+blnggrp+\"&\"+\"total_amt_payable=\"+total_amt_payable+\"&\"+\"action=\"+action+\"&\"+\"settled_amt_det=\"+settled_amt_det+\"&\"+\"total_settled_amt=\"+total_settled_amt+\"&\"+query_string;\n\t\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLBillSlmtMain2.jsp?\"+param,arguments,features);\n//\talert(\"retVal from main2  -  1: \"+retVal)\t\n\tif(retVal!=null)\n\t{\t\n\t\tformObj = parent.frames[2].document.forms[0];\n\t\ttotalRecords =eval(formObj.total_records.value);\n\t\tcount =totalRecords + 1; \n\t\tvar record_select=count;\n\t\tvar arr=new Array();\t\n\t\tif(retVal == null) retVal=\'\';\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\t\t\t\n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\t\t\t\n\t\t\t\tarr=retVal.split(\"::\");\t\n\t\t\t\tvar billdoctype=arr[0];\n\t\t\t\tif(billdoctype==\" \")billdoctype=\"\";\n\t\t\t\tvar billdocnum=arr[1];\n\t\t\t\tif(billdocnum==\" \")billdocnum=\"\";\n\t\t\t\tvar billpayableamt=arr[2];\n\t\t\t\tif(billpayableamt==\" \")billpayableamt=\"\";\n\t\t\t\tvar billslmtamt=arr[3];\n\t\t\t\tif(billslmtamt==\" \")billslmtamt=\"\";\n\t\t\t\tvar slmttype=arr[4];\n\t\t\t\tif(slmttype==\" \")slmttype=\"\";\t\n\t\t\t\tvar payername=arr[5];\n\t\t\t\tif(payername==\" \")payername=\"\";\t\t\t\t\n\t\t\t\tvar recrefidno=arr[6];\n\t\t\t\tif(recrefidno==\" \")recrefidno=\"\";\n\t\t\t\tvar ext_acc_interface_yn=arr[7];\n\t\t\t\tif(ext_acc_interface_yn==\" \")ext_acc_interface_yn=\"\";\t\t\t\t\n\t\t\t\tvar ext_acc_fac_id=arr[8];\n\t\t\t\tif(ext_acc_fac_id==\" \")ext_acc_fac_id=\"\";\n\t\t\t\tvar instref=arr[9];\n\t\t\t\tif(instref==\" \")instref=\"\";\n\t\t\t\tvar instdate=arr[10];\n\t\t\t\tif(instdate==\" \")instdate=\"\";\n\t\t\t\tvar instremark=arr[11];\n\t\t\t\tif(instremark==\" \")instremark=\"\";\n\t\t\t\tvar instbranch=arr[12];\n\t\t\t\tif(instbranch==\" \")instbranch=\"\";\n\t\t\t\tvar onlineapproval=arr[13];\t\t\t\t\t\n\t\t\t\tif(onlineapproval==\" \")onlineapproval=\"\";\t\t\t\t\n\t\t\t\tvar batchno=arr[14];\n\t\t\t\tif(batchno==\" \")batchno=\"\";\n\t\t\t\tvar apprrefno=arr[15];\n\t\t\t\tif(apprrefno==\" \")apprrefno=\"\";\n\t\t\t\tvar saledraftno=arr[16];\n\t\t\t\tif(saledraftno==\" \")saledraftno=\"\";\n\t\t\t\tvar cashslmtflag=arr[17];\n\t\t\t\tif(cashslmtflag==\" \")cashslmtflag=\"\";\t\t\t\t\n\t\t\t\tvar instbankname=arr[18];\n\t\t\t\tif(instbankname==\" \")instbankname=\"\";\n\t\t\t\tvar cash_given=arr[19];\n\t\t\t\tif(cash_given==\" \")cash_given=\"\";\n\t\t\t\tvar outstanding_amount=arr[25];\n\t\t\t\tif(outstanding_amount==\" \")outstanding_amount=\"\";\n\t\t\t\tvar cash_return=arr[20];\n\t\t\t\tif(cash_return==\" \")cash_return=\"\";\n\t\t\t\tvar short_desc=arr[21];\n\t\t\t\tif(short_desc==\" \")short_desc=\"\";\n\t\t\t\tvar instremarkcode=arr[22];\n\t\t\t\tif(instremarkcode==\" \")instremarkcode=\"\";\n\n\t\t\t\tvar credit_card_machine_int_yn = arr[24];\n\t\t\t\tif(credit_card_machine_int_yn == \" \") credit_card_machine_int_yn=\"\";\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t\tvar record_select=count;\n\t\tfor(var j=totalRecords;j<count;j++ )\n\t\t{\n\t\t\tif(j % 2 == 0 )\n\t\t\t{\n\t\t\t\tclassval\t=\t\"QRYEVEN\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tclassval\t=\t\"QRYODD\";\n\t\t\t}\n\t\t\t\n\t\tcurr_row\t=\tformObj.bill_slmt_data.insertRow();\n\t\tcurr_row.id= \"row\"+eval(totalRecords+1);\t\t\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[0].className\t= classval;\n\t\tcurr_row.cells[0].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[0].insertAdjacentHTML(\"beforeend\", \"<input type=\'checkbox\'  name=\'selected_row\"+j+\"\' id=\'selected_row\"+j+\"\' style=\'text-align:right\'  value=\'\' onClick=\'selected(\"+j+\");\' >\");\n\n\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[1].className\t= classval;\n\t\tcurr_row.cells[1].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[1].insertAdjacentHTML(\"beforeend\", \"<input maxlength=\'30\' size=\'10\' type=text readonly name=\'billslmtamt\"+j+\"\' id=\'billslmtamt\"+j+\"\'  value=\'\"+billslmtamt+\"\' readonly style=\'text-align:right\'  >\");\n\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[2].className\t=classval;\n\t\tcurr_row.cells[2].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[2].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'40\' size=\'20\' readonly name=\'shortdesc\"+j+\"\' id=\'shortdesc\"+j+\"\'   value=\'\"+short_desc+\"\'  > <input type=hidden name=\'slmttype\"+j+\"\' id=\'slmttype\"+j+\"\' value=\'\"+slmttype+\"\' >\");\n\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[3].className\t=classval;\n\t\tcurr_row.cells[3].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[3].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'cash_given\"+j+\"\' id=\'cash_given\"+j+\"\'   value=\'\"+cash_given+\"\' style=\'text-align:right\'  > \");\n\t\t\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[4].className\t=classval;\n\t\tcurr_row.cells[4].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[4].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'outstanding_amount\"+j+\"\' id=\'outstanding_amount\"+j+\"\'   value=\'\"+outstanding_amount+\"\' style=\'text-align:right\'  > \");\n\t\t\n\t\t\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[5].className\t=classval;\n\t\tcurr_row.cells[5].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[5].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'cash_return\"+j+\"\' id=\'cash_return\"+j+\"\'   value=\'\"+cash_return+\"\' style=\'text-align:right\'  > \");\n\t\t\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[6].className\t=classval;\n\t\tcurr_row.cells[6].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[6].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'instref\"+j+\"\' id=\'instref\"+j+\"\'   value=\'\"+instref+\"\'  >\");\n\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[7].className\t=classval;\n\t\tcurr_row.cells[7].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[7].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'instdate\"+j+\"\' id=\'instdate\"+j+\"\'   value=\'\"+instdate+\"\'  >\");\n\t\t\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[8].className\t=classval;\n\t\tcurr_row.cells[8].WIDTH\t= \"10%\";\n\t\tcurr_row.cells[8].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'creditcardco\"+j+\"\' id=\'creditcardco\"+j+\"\'   value=\'\"+instremark+\"\'  >\");\n\t\t\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[9].className\t=classval;\n\t\tcurr_row.cells[9].WIDTH\t= \"10%\";\n\t\tcurr_row.cells[9].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'instbankname\"+j+\"\' id=\'instbankname\"+j+\"\'   value=\'\"+instbankname+\"\'  ><input type=hidden name=\'instremarkcode\"+j+\"\' id=\'instremarkcode\"+j+\"\' value=\'\"+instremarkcode+\"\' >\");\n\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[10].className\t=classval;\n\t\tcurr_row.cells[10].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[10].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'instbranch\"+j+\"\' id=\'instbranch\"+j+\"\'   value=\'\"+instbranch+\"\'  >\");\n\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[11].className\t=classval;\n\t\tcurr_row.cells[11].WIDTH\t= \"4%\";\n\t\tcurr_row.cells[11].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'10\' size=\'10\' readonly name=\'batchno\"+j+\"\' id=\'batchno\"+j+\"\'   value=\'\"+batchno+\"\'  >\");\n\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[12].className\t=classval;\n\t\tcurr_row.cells[12].WIDTH\t= \"5%\";\n\t\tcurr_row.cells[12].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'10\' size=\'10\' readonly name=\'apprrefno\"+j+\"\' id=\'apprrefno\"+j+\"\'   value=\'\"+apprrefno+\"\'  >\");\n\t\t\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[13].className\t=classval;\n\t\tcurr_row.cells[13].WIDTH\t= \"5%\";\n\t\tcurr_row.cells[13].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'10\' size=\'10\' readonly name=\'saledraftno\"+j+\"\' id=\'saledraftno\"+j+\"\'   value=\'\"+saledraftno+\"\'  >\");\n\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[14].className\t=classval;\n\t\tcurr_row.cells[14].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[14].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'20\' readonly name=\'payername\"+j+\"\' id=\'payername\"+j+\"\'   value=\'\"+payername+\"\'><input type=hidden name=\'ext_acc_interface_yn\"+j+\"\' id=\'ext_acc_interface_yn\"+j+\"\' value=\'\"+ext_acc_interface_yn+\"\'><input type=hidden name=\'credit_card_machine_int_yn\"+j+\"\' id=\'credit_card_machine_int_yn\"+j+\"\' value=\'\"+credit_card_machine_int_yn+\"\' > \");\n\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[15].className\t=classval;\n\t\tcurr_row.cells[15].WIDTH\t";
    private final static byte[]  _wl_block6_0Bytes = _getBytes( _wl_block6_0 );

    private final static java.lang.String  _wl_block6_1 ="= \"6%\";\n\t\tcurr_row.cells[15].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'20\' readonly name=\'recrefidno\"+j+\"\' id=\'recrefidno\"+j+\"\'   value=\'\"+recrefidno+\"\'  ><input type=hidden name=\'ext_acc_fac_id\"+j+\"\' id=\'ext_acc_fac_id\"+j+\"\' value=\'\"+ext_acc_fac_id+\"\' >\");\n\t\t\n\t\t\n\t\tcell\t=\tcurr_row.insertCell();\n\t\tcurr_row.cells[16].className\t=classval;\n\t\tcurr_row.cells[16].WIDTH\t= \"6%\";\n\t\tcurr_row.cells[16].insertAdjacentHTML(\"beforeend\", \"<input type=\'checkbox\' maxlength=\'30\' size=\'10\'   \"+onlineapproval+\" name=\'onlineapproval\"+j+\"\' id=\'onlineapproval\"+j+\"\' value=\'\"+onlineapproval+\"\' readonly onclick=\'check_box(\"+j+\")\'>\");\n\t\t\n\t\trecord_select++;\n\t\t}\n\t\tformObj.total_records.value=count;\n\n\t\ttot_setld_amt();\n\t\t\t\n\t\t\t}\n\t}\n\nfunction modifyBillSlmt()\n{\n\t\t\t\tdocument.forms[0].doc_amt.value=\"\";\n\tvar \n\tchecked_row=parent.BillSlmtTypeFrame.document.forms[0].checked_row.value;\n\tvar billdoctype=document.forms[0].billdoctype.value;\n\tvar total_amt_payable=document.forms[0].total_amt_payable.value;\n\tvar billdocnum=document.forms[0].billdocnum.value;\n\tvar blnggrp=document.forms[0].blnggrp.value;\n\tvar total_records=\"\";\n\tvar function_id=document.forms[0].function_id.value;\n\t//if(function_id==\'rcpt_rfnd\')\n\tif(function_id==\'rcpt_rfnd\' || function_id==\'PKG_BILLING\')\n\t{\n\tvar total_settled_amt=\"\";//document.forms[0].total_settled_amt.value;\n\tvar settled_amt_det=\"\";//parent.frames[0].document.forms[0].billslmtamtdet.value;\n\tvar tot_curr_stlmt=\"\";//parent.frames[1].document.forms[0].tot_curr_stlmt.value;\n\t}\n\telse{\n\t\tvar total_settled_amt=document.forms[0].total_settled_amt.value;\n\t\tvar settled_amt_det=parent.frames[0].document.forms[0].billslmtamtdet.value;\t\n\t\tvar tot_curr_stlmt=parent.frames[1].document.forms[0].tot_curr_stlmt.value;\n\t   }\n\ttotal_amt_payable=parseFloat(total_amt_payable)-parseFloat(total_settled_amt);\t\n\ttotal_records=parent.frames[2].document.forms[0].total_records.value;\t\n\n\tvar query_string=document.forms[0].query_string.value;\n\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\n\tif(total_amt_payable<0)\n\t{\n\t\ttotal_amt_payable=\'0.00\';\n\t}\n\tif(checked_row==\"\")\n\t{\t\t\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\t\t\n\telse\n\t{\n\t\tvar billslmtamt1=eval(\"parent.frames[2].document.forms[0].billslmtamt\"+checked_row);\n\t\tvar billslmtamt=billslmtamt1.value;\t\t\n\t\ttotal_amt_payable=parseFloat(total_amt_payable)+parseFloat(billslmtamt);\t\n\n\t\tvar shortdesc1=eval(\"parent.frames[2].document.forms[0].shortdesc\"+checked_row);\n\t\tvar shortdesc=shortdesc1.value;\t\t\t\n\n\t\tvar slmttype1=eval(\"parent.frames[2].document.forms[0].slmttype\"+checked_row);\n\t\tvar slmttype=slmttype1.value;\t\n\t\t\n\t\t/*if(slmttype==\'CCA\')\n\t\t{\n\t\t\talert(\"credit card transaction can not modify\");\n\t\t\treturn false;\n\t\t}*/\n\t\t\n\t\t\n\t\tvar cash_given1=eval(\"parent.frames[2].document.forms[0].cash_given\"+checked_row);\n\t\tvar cash_given=cash_given1.value;\t\t\n\t\tvar outstanding_amount1=eval(\"parent.frames[2].document.forms[0].outstanding_amount\"+checked_row);\n\t\tvar outstanding_amount=outstanding_amount1.value;\n\n\t\tvar cash_return1=eval(\"parent.frames[2].document.forms[0].cash_return\"+checked_row);\n\t\tvar cash_return=cash_return1.value;\t\t\n\n\t\tvar instref1=eval(\"parent.frames[2].document.forms[0].instref\"+checked_row);\n\t\tvar instref=instref1.value;\t\t\t\n\n\t\tvar instdate1=eval(\"parent.frames[2].document.forms[0].instdate\"+checked_row);\n\t\tvar instdate=instdate1.value;\t\t\n\n\t\tvar creditcardco1=eval(\"parent.frames[2].document.forms[0].creditcardco\"+checked_row);\n\t\tvar creditcardco=creditcardco1.value;\t\t\n\t\t\n\t\tvar instbankname1=eval(\"parent.frames[2].document.forms[0].instbankname\"+checked_row);\n\t\tvar instbankname=instbankname1.value;\t\n\t\t\n\t\tvar instbranch1=eval(\"parent.frames[2].document.forms[0].instbranch\"+checked_row);\n\t\tvar instbranch=instbranch1.value;\t\n\t\tinstbranch = encodeURIComponent(instbranch);\n\t\t\n\t\tvar instremarkcode1=\teval(\"parent.frames[2].document.forms[0].instremarkcode\"+checked_row);\n\t\tvar instremarkcode=instremarkcode1.value;\t\t\t\n\n\t\tvar batchno1=eval(\"parent.frames[2].document.forms[0].batchno\"+checked_row);\n\t\tvar batchno=batchno1.value;\t\t\t\n\n\t\tvar apprrefno1=eval(\"parent.frames[2].document.forms[0].apprrefno\"+checked_row);\n\t\tvar apprrefno=apprrefno1.value;\t\t\t\n\n\t\tvar saledraftno1=eval(\"parent.frames[2].document.forms[0].saledraftno\"+checked_row);\n\t\tvar saledraftno=saledraftno1.value;\t\t\t\n\n\t\tvar payername1=eval(\"parent.frames[2].document.forms[0].payername\"+checked_row);\n\t\tvar payername=payername1.value;\t\t\t\t\n\n\t\tvar recrefidno1=eval(\"parent.frames[2].document.forms[0].recrefidno\"+checked_row);\n\t\tvar recrefidno=recrefidno1.value;\t\t\t\n\n\t\tvar onlineapproval1=eval(\"parent.frames[2].document.forms[0].onlineapproval\"+checked_row);\n\t\tvar onlineapproval=\"\";\n\n\t\tvar credit_card_machine_int_yn = eval(\"parent.frames[2].document.forms[0].credit_card_machine_int_yn\"+checked_row);\n\n\t\tif(onlineapproval1.checked)\n\t\t{\t\t\t\n\t\t\tonlineapproval=\"checked\";\n\t\t\t//alert(\"cc transaction can not be modified\");\n\t\t\tif(credit_card_machine_int_yn.value == \"Y\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9888\",\"BL\"));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\t\t\t\n\t\t\tonlineapproval=\"\";\n\t\t}\n\t\t \n\t\tvar ext_acc_interface_yn1=eval(\"parent.frames[2].document.forms[0].ext_acc_interface_yn\"+checked_row);\n\t\tvar ext_acc_interface_yn=ext_acc_interface_yn1.value;\t\t\t\n\n\t\tvar ext_acc_fac_id1=eval(\"parent.frames[2].document.forms[0].ext_acc_fac_id\"+checked_row);\n\t\tvar ext_acc_fac_id=ext_acc_fac_id1.value;\t\t\t\n\tvar action=\"modify\";\n\tvar retVal\t\t\t= new String();\n\tvar center=\'1\';\n\tvar dialogTop = \"0vh\";\n\tvar dialogHeight = \"65vh\" ;\n\tvar dialogWidth = \"58vw\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar title=encodeURIComponent(getLabel(\"eBL.MODI_BILL_SLMT_DTL.label\",\"BL\"));\n\t//title=encodeURIComponent(title);\t\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billslmtamt=\"+billslmtamt+\"&\"+\"shortdesc=\"+shortdesc+\"&\"+\"slmttype=\"+slmttype+\"&\"+\"cash_given=\"+cash_given+\"&\"+\"outstanding_amount=\"+outstanding_amount+\"&\"+\"cash_return=\"+cash_return+\"&\"+\"instref=\"+instref+\"&\"+\"instdate=\"+instdate+\"&\"+\"creditcardco=\"+creditcardco+\"&\"+\"instbankname=\"+instbankname+\"&\"+\"instbranch=\"+instbranch+\"&\"+\"batchno=\"+batchno+\"&\"+\"apprrefno=\"+apprrefno+\"&\"+\"saledraftno=\"+saledraftno+\"&\"+\"payername=\"+encodeURIComponent(payername)+\"&\"+\"recrefidno=\"+recrefidno+\"&\"+\"onlineapproval=\"+onlineapproval+\"&\"+\"action=\"+action+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"instremarkcode=\"+instremarkcode+\"&\"+\"total_amt_payable=\"+total_amt_payable+\"&\"+\"settled_amt_det=\"+settled_amt_det+\"&\"+\"total_settled_amt=\"+total_settled_amt+\"&\"+\"ext_acc_interface_yn=\"+ext_acc_interface_yn+\"&\"+\"ext_acc_fac_id=\"+ext_acc_fac_id+\"&\"+query_string;\n\t\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLBillSlmtMain2.jsp?\"+param,arguments,features);\n//\talert(\"retVal from main2  -  2: \"+retVal)\t\n\t\tvar formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;\n\t\ttotal_records=formObj.total_records.value;\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n\t\tif(retVal!=null)\n\t\t{\n\t\tvar arr=new Array();\n\t\tif(retVal == null) retVal=\'\';\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\t\t\t\t\t  \n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\t//var formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;\n\t\t\t\tarr=retVal.split(\"::\");\t\n\t\t\t\tvar billslmtamt1=eval(\"parent.frames[2].document.forms[0].billslmtamt\"+checked_row);\n\t\t\t\tif(arr[3]==\" \")arr[3]=\"\";\n\t\t\t\tbillslmtamt1.value=arr[3];\n\t\t\t\tvar shortdesc1=eval(\"parent.frames[2].document.forms[0].shortdesc\"+checked_row);\n\t\t\t\tif(arr[21]==\" \")arr[21]=\"\";\n\t\t\t\tshortdesc1.value=arr[21];\n\t\t\t\tvar slmttype1=eval(\"parent.frames[2].document.forms[0].slmttype\"+checked_row);\n\t\t\t\tif(arr[4]==\" \")arr[4]=\"\";\n\t\t\t\tslmttype1.value=arr[4];\n\t\t\t\tvar instref1=eval(\"parent.frames[2].document.forms[0].instref\"+checked_row);\n\t\t\t\tif(arr[9]==\" \")arr[9]=\"\";\n\t\t\t\tinstref1.value=arr[9];\n\t\t\t\tvar instdate1=eval(\"parent.frames[2].document.forms[0].instdate\"+checked_row);\n\t\t\t\tif(arr[10]==\" \")arr[10]=\"\";\n\t\t\t\tinstdate1.value=arr[10];\t\n\n\t\t\t\tvar creditcardco1=eval(\"parent.frames[2].document.forms[0].creditcardco\"+checked_row);\n\t\t\t\tif(arr[11]==\" \")arr[11]=\"\";\n\t\t\t\tcreditcardco1.value=arr[11];\n\n\t\t\t\tvar instbankname1=eval(\"parent.frames[2].document.forms[0].instbankname\"+checked_row);\n\t\t\t\tif(arr[18]==\" \")arr[18]=\"\";\n\t\t\t\tinstbankname1.value=arr[18];\n\n\t\t\t\tvar batchno1=eval(\"parent.frames[2].document.forms[0].batchno\"+checked_row);\n\t\t\t\tif(arr[14]==\" \")arr[14]=\"\";\n\t\t\t\tbatchno1.value=arr[14];\n\t\t\t\t\n\t\t\t\tvar apprrefno1=eval(\"parent.frames[2].document.forms[0].apprrefno\"+checked_row);\n\t\t\t\tif(arr[15]==\" \")arr[15]=\"\";\n\t\t\t\tapprrefno1.value=arr[15];\n\n\t\t\t\tvar saledraftno1=eval(\"parent.frames[2].document.forms[0].saledraftno\"+checked_row);\n\t\t\t\tif(arr[16]==\" \")arr[16]=\"\";\n\t\t\t\tsaledraftno1.value=arr[16];\n\n\n\t\t\t\tvar instremarkcode1=eval(\"parent.frames[2].document.forms[0].instremarkcode\"+checked_row);\n\t\t\t\tif(arr[22]==\" \")arr[22]=\"\";\n\t\t\t\tinstremarkcode1.value=arr[22];\n\t\t\t\t\n\t\t\t\tvar payername1=eval(\"parent.frames[2].document.forms[0].payername\"+checked_row);\n\t\t\t\tif(arr[5]==\" \")arr[5]=\"\";\n\t\t\t\tpayername1.value=arr[5];\n\n\t\t\t\tvar recrefidno1=eval(\"parent.frames[2].document.forms[0].recrefidno\"+checked_row);\n\t\t\t\tif(arr[6]==\" \")arr[6]=\"\";\n\t\t\t\trecrefidno1.value=arr[6];\n\t\t\t\t\n\t\t\t\tvar cash_given1=eval(\"parent.frames[2].document.forms[0].cash_given\"+checked_row);\n\t\t\t\tif(arr[19]==\" \")arr[19]=\"\";\n\t\t\t\tcash_given1.value=arr[19];\t\n\t\t\t\t\n\t\t\t\tvar outstanding_amount1=eval(\"parent.frames[2].document.forms[0].outstanding_amount\"+checked_row);\n\t\t\t\tif(arr[25]==\" \")arr[25]=\"\";\n\t\t\t\toutstanding_amount1.value=arr[25];\n\t\t\t\t\n\t\t\t\t//System.out.println(\"=====outstanding_amount===2==\"+outstanding_amount1.value);\n\n\t\t\t\tvar cash_return1=eval(\"parent.frames[2].document.forms[0].cash_return\"+checked_row);\n\t\t\t\tif(arr[20]==\" \")arr[20]=\"\";\n\t\t\t\tcash_return1.value=arr[20];\t\n\t\t\t\t\n\t\t\t\tvar onlineapproval1=eval(\"parent.frames[2].document.forms[0].onlineapproval\"+checked_row);\n\t\t\t\tif(arr[13]==\" \")arr[13]=\"\";\n\t\t\t\tonlineapproval1.value=arr[13];\t\t\t\t\t\n\t\t\t\tvar ckcbflag=arr[13];\n\t\t\t\tif(ckcbflag==\"checked\")\n\t\t\t\t{\t\n\t\t\t\t\tonlineapproval1.checked=true;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tonlineapproval1.checked=false;\n\t\t\t\t}\n\n\t\t\t\tvar ext_acc_interface_yn1=eval(\"parent.frames[2].document.forms[0].ext_acc_interface_yn\"+checked_row);\n\t\t\t\tif(arr[7]==\" \")arr[7]=\"\";\n\t\t\t\text_acc_interface_yn1.value=arr[7];\t\n\n\t\t\t\tvar ext_acc_fac_id1=eval(\"parent.frames[2].document.forms[0].ext_acc_fac_id\"+checked_row);\n\t\t\t\tif(arr[8]==\" \")arr[8]=\"\";\n\t\t\t\text_acc_fac_id1.value=arr[8];\t\n\t\t\t\t\n\t\t\t\tvar credit_card";
    private final static byte[]  _wl_block6_1Bytes = _getBytes( _wl_block6_1 );

    private final static java.lang.String  _wl_block6_2 ="_machine_int_yn = eval(\"parent.frames[2].document.forms[0].credit_card_machine_int_yn\"+checked_row);\n\t\t\t\tif(arr[24] == \" \") arr[24]=\"\";\n\t\t\t\tcredit_card_machine_int_yn.value = arr[24];\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t\t}\n\t\t\ttot_setld_amt();\n\t}\n\tparent.frames[2].document.forms[0].checked_row.value=\"\";\n}\n\nfunction tot_setld_amt()\n{\n\tvar total_settled=0.0;\t\n\tvar tot_setl=\"\";\n\tvar a1=new Array();\n\tvar\ttotalRecords =parent.frames[2].document.forms[0].total_records.value;\n\tvar decimal=document.forms[0].noofdecimal.value;\n\n\tfor(var i=0;i<totalRecords;i++)\n\t{\n\t  tot_setl=eval(\"parent.frames[2].document.forms[0].billslmtamt\"+i);\n\t  a1[i]=tot_setl.value;\n\t  if(a1[i]==\"\"){a1[i]=\"0.0\";}\n\t  total_settled=parseFloat(total_settled) + parseFloat(a1[i]);\t  \n\t}\t\n\n/*\n\ttotal_settled = Math.round(total_settled*Math.pow(10,decimal))/Math.pow(10,decimal);\n\tdocument.forms[0].total_settled_amt.value=total_settled;\n*/\n\n//\ttotal_settled = roundNumber(total_settled,decimal);\n\ttotal_settled = total_settled.toFixed(decimal);\n\tif(document.forms[0].doc_amt.value!=\"\")\n\t{\t\t\n\t\tdocument.forms[0].total_settled_amt.value=document.forms[0].doc_amt.value;\t\n\t}else{\n\tdocument.forms[0].total_settled_amt.value=total_settled;\n\t}\n\n\tvar temp_total_settled=eval(\"document.forms[0].total_settled_amt\");\n\tputdeci(temp_total_settled);\n\t/*var v_set_amt=parent.frames[0].document.forms[0].billslmtamtdet.value;\n\tif(parseFloat(temp_total_settled.value)==parseFloat(v_set_amt))\n\t{\n\t\tparent.frames[0].document.forms[0].billslmtamtdet.readOnly=true;\n\t}*/\n}\n\nfunction putdeci(object)\n\t{\t\n\t\tif(object.value!=\'\')\n\t\t{\n\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\tputDecimal(object,17,decimal);\n\t\t}\n\t}\n\nfunction removeBillSlmt()\n{\n\tvar \n\tchecked_row=parent.BillSlmtTypeFrame.document.forms[0].checked_row.value;\t\n\tvar billdoctype=document.forms[0].billdoctype.value;\n\tvar billdocnum=document.forms[0].billdocnum.value;\n\tvar blnggrp=document.forms[0].blnggrp.value;\n\tvar query_string=document.forms[0].query_string.value;\n\tvar formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;\n\tvar total_records=\"\";\n\t//total_records=parent.frames[2].document.forms[0].total_records.value;\t\n\ttotal_records=formObj.total_records.value;\t\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\tif(checked_row==\"\")\n\t{\t\t\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\telse\n\t{\n\t\tif(confirm(getMessage(\"DELETE_RECORD\",\"common\"))) //BL9760\n\t\t{\n\t\t\ttotalRecords =eval(formObj.total_records.value);\t\t\tparent.frames[2].document.forms[0].action=\"../../eBL/jsp/BLBillSlmtType.jsp?remove_check=remove&\"+\"&checked_row=\"+checked_row+\"&total_records=\"+totalRecords+\"&\"+query_string;\n\t\t\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\t\t\t\n\t\t}\n\t}\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\ttemp.checked=false;\n\t}\n\tparent.frames[2].document.forms[0].checked_row.value=\"\";\n}\n\n\n/*function removeBillSlmt()\n{\n\tvar \n\tchecked_row=parent.BillSlmtTypeFrame.document.forms[0].checked_row.value;\n\tvar billdoctype=document.forms[0].billdoctype.value;\n\tvar billdocnum=document.forms[0].billdocnum.value;\n\tvar blnggrp=document.forms[0].blnggrp.value;\n\tvar query_string=document.forms[0].query_string.value;\n\tvar total_records=\"\";\n\ttotal_records=parent.frames[2].document.forms[0].total_records.value;\t\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\tif(checked_row==\"\")\n\t{\t\t\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\t\t\n\telse\n\t{\n\t\tvar billslmtamt1=eval(\"parent.frames[2].document.forms[0].billslmtamt\"+checked_row);\n\t\tvar billslmtamt=billslmtamt1.value;\t\t\n\t\t\n\t\tvar shortdesc1=eval(\"parent.frames[2].document.forms[0].shortdesc\"+checked_row);\n\t\tvar shortdesc=shortdesc1.value;\t\t\t\n\n\t\tvar slmttype1=eval(\"parent.frames[2].document.forms[0].slmttype\"+checked_row);\n\t\tvar slmttype=slmttype1.value;\t\t\t\n\t\t\n\t\tvar cash_given1=eval(\"parent.frames[2].document.forms[0].cash_given\"+checked_row);\n\t\tvar cash_given=cash_given1.value;\t\t\n\n\t\tvar cash_return1=eval(\"parent.frames[2].document.forms[0].cash_return\"+checked_row);\n\t\tvar cash_return=cash_return1.value;\t\t\n\n\t\tvar instref1=eval(\"parent.frames[2].document.forms[0].instref\"+checked_row);\n\t\tvar instref=instref1.value;\t\t\t\n\n\t\tvar instdate1=eval(\"parent.frames[2].document.forms[0].instdate\"+checked_row);\n\t\tvar instdate=instdate1.value;\t\t\n\n\t\tvar creditcardco1=eval(\"parent.frames[2].document.forms[0].creditcardco\"+checked_row);\n\t\tvar creditcardco=creditcardco1.value;\t\t\n\t\t\n\t\tvar instbankname1=eval(\"parent.frames[2].document.forms[0].instbankname\"+checked_row);\n\t\tvar instbankname=instbankname1.value;\t\n\t\t\n\t\tvar instbranch1=eval(\"parent.frames[2].document.forms[0].instbranch\"+checked_row);\n\t\tvar instbranch=instbranch1.value;\t\n\t\t\n\t\tvar instremarkcode1=\teval(\"parent.frames[2].document.forms[0].instremarkcode\"+checked_row);\n\t\tvar instremarkcode=instremarkcode1.value;\t\t\t\n\n\t\tvar batchno1=eval(\"parent.frames[2].document.forms[0].batchno\"+checked_row);\n\t\tvar batchno=batchno1.value;\t\t\t\t\n\n\t\tvar apprrefno1=eval(\"parent.frames[2].document.forms[0].apprrefno\"+checked_row);\n\t\tvar apprrefno=apprrefno1.value;\t\t\t\n\n\t\tvar saledraftno1=eval(\"parent.frames[2].document.forms[0].saledraftno\"+checked_row);\n\t\tvar saledraftno=saledraftno1.value;\t\t\t\n\n\t\tvar payername1=eval(\"parent.frames[2].document.forms[0].payername\"+checked_row);\n\t\tvar payername=payername1.value;\t\t\t\t\n\n\t\tvar recrefidno1=eval(\"parent.frames[2].document.forms[0].recrefidno\"+checked_row);\n\t\tvar recrefidno=recrefidno1.value;\t\t\t\n\n\t\tvar onlineapproval1=eval(\"parent.frames[2].document.forms[0].onlineapproval\"+checked_row);\n\t\tvar onlineapproval=\"\";\n\t\tif(onlineapproval1.checked)\n\t\t{\n\t\tonlineapproval=\"checked\";\n\t\t}else{\n\t\t\tonlineapproval=\"\";\n\t\t }\n\n\t\t  var ext_acc_interface_yn1=eval(\"parent.frames[2].document.forms[0].ext_acc_interface_yn\"+checked_row);\n\t\tvar ext_acc_interface_yn=ext_acc_interface_yn1.value;\t\t\t\n\n\t\tvar ext_acc_fac_id1=eval(\"parent.frames[2].document.forms[0].ext_acc_fac_id\"+checked_row);\n\t\tvar ext_acc_fac_id=ext_acc_fac_id1.value;\t\n\t\t\n\tvar action=\"remove\";\n\tvar retVal\t\t\t= new String();\n\tvar center=\'1\';\n\tvar dialogTop = \"200\";\n\tvar dialogHeight = \"18\" ;\n\tvar dialogWidth = \"50\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar title=encodeURIComponent(getLabel(\"eBL.REMOVE_BILL_SLMT_DTL.label\",\"BL\"));\n\t//title=encodeURIComponent(title);\t\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billslmtamt=\"+billslmtamt+\"&\"+\"shortdesc=\"+shortdesc+\"&\"+\"slmttype=\"+slmttype+\"&\"+\"cash_given=\"+cash_given+\"&\"+\"cash_return=\"+cash_return+\"&\"+\"instref=\"+instref+\"&\"+\"instdate=\"+instdate+\"&\"+\"creditcardco=\"+creditcardco+\"&\"+\"instbankname=\"+instbankname+\"&\"+\"instbranch=\"+instbranch+\"&\"+\"batchno=\"+batchno+\"&\"+\"apprrefno=\"+apprrefno+\"&\"+\"saledraftno=\"+saledraftno+\"&\"+\"payername=\"+encodeURIComponent(payername)+\"&\"+\"recrefidno=\"+recrefidno+\"&\"+\"onlineapproval=\"+onlineapproval+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"instremarkcode=\"+instremarkcode+\"&\"+\"action=\"+action+\"&\"+\"ext_acc_interface_yn=\"+ext_acc_interface_yn+\"&\"+\"ext_acc_interface_yn=\"+ext_acc_interface_yn+\"&\"+query_string;\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLBillSlmtMain2.jsp?\"+param,arguments,features);\n\tvar formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;\n\t\ttotal_records=formObj.total_records.value;\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n\t\n\t\tif(\tretVal!=null)\n\t\t{\n\t\t\tvar ret_val=retVal;\n\t\t\tif(ret_val==\"remove\")\n\t\t\t{\t\n\t\t\t\t\ttotalRecords =eval(formObj.total_records.value);\t\t\t\t\tparent.frames[2].document.forms[0].action=\"../../eBL/jsp/BLBillSlmtType.jsp?remove_check=remove&\"+\"&checked_row=\"+checked_row+\"&total_records=\"+totalRecords+\"&\"+query_string;\n\t\t\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//alert(\"closed\");\n\t\t}\n\t}\n\tparent.frames[2].document.forms[0].checked_row.value=\"\";\n}*/\n\nfunction billslmtprocess1()\n{\n\tvar v_services_tot_records=parent.frames[1].document.forms[0].total_records.value;\n\tvar rtnArray1=\"\";\n\tvar rtnArray2=\"\";\n\tvar rtnArrayDt=\"\";\n\tvar rtnArrayDocref=\"\";\n\tvar rtnArrayDocrefLine=\"\";\n\tvar rtnArrayDocrefSeq=\"\";\n\tvar rtnBlngServCode=\"\";\n\tvar roundingamt=\"\";\n\tvar rtnUpdNetChrgAmt=\"\";\n\tvar rtnUpdGrossChrgAmt=\"\";\n\tvar rtnPrtGrpLineCode=\"\";\n\tvar rtnPrtGrpHdrCode=\"\";\n\tvar rtnTrxDate=\"\";\n\n\tvar a1=new Array();\n\tvar a2=new Array();\n\tvar a3=new Array();\n\tvar a4=new Array();\n\tvar a5=new Array();\n\tvar a6=new Array();\n\tvar a7=new Array();\n\tvar a8=new Array();\n\tvar a9=new Array();\n\tvar a10=new Array();\n\tvar a11=new Array();\n\tvar a12=new Array();\n\tvar tot_rec_for_serv_insert=0;\n\t//alert(\"v_services_tot_records:\"+v_services_tot_records);\n\tfor(var i=0;i<v_services_tot_records;i++)\n\t {\t\t\t\t\n\t\t\n\t\tvar v_curr_slmt=eval(\"parent.frames[1].document.forms[0].curr_set\"+i);\n\t\tif(v_curr_slmt.value!=0 )\n\t\t {\n\t\t\ttot_rec_for_serv_insert=eval(tot_rec_for_serv_insert)+1;\n\t\t\ta1[i]=v_curr_slmt.value;\n\t\t\tif(a1[i]==\"\")a1[i]=\" \";\n\t\t\trtnArray1=rtnArray1+a1[i]+\"|\";\n\t\t\t//alert(rtnArray1);\n\t\t\tvar v_pend_amt=eval(\"parent.frames[1].document.forms[0].pend_set\"+i);\t\t\t\t\t\t\t\t\t\n\t\t\ta2[i]=v_pend_amt.value;\n\t\t\tif(a2[i]==\"\")a2[i]=\" \";\t\t\t\t\t\n\t\t\trtnArray2=rtnArray2+a2[i]+\"|\";\n\t\t\t//alert(rtnArray2);\n\t\t\tvar v_service_date=eval(\"parent.frames[1].document.forms[0].service_date\"+i);\n\t\t\ta3[i]=v_service_date.value;\n\t\t\tif(a3[i]==\"\")a3[i]=\" \";\t\t\t\t\t\n\t\t\trtnArrayDt=rtnArrayDt+a3[i]+\"|\";\n\t\t\t//alert(rtnArrayDt);\n\t\t\tvar v_trx_doc_ref=eval(\"parent.frames[1].document.forms[0].trx_doc_ref\"+i);\n\t\t\ta4[i]=v_trx_doc_ref.value;\n\t\t\tif(a4[i]==\"\")a4[i]=\" \";\t\t\t\t\t\n\t\t\trtnArrayDocref=rtnArrayDocref+a4[i]+\"|\";\n\t\t\tvar v_trx_doc_ref_line_num=eval(\"parent.frames[1].document.forms[0].trx_doc_ref_line_num\"+i);\n\t\t\ta5[i]=v_trx_doc_ref_line_num.value;\n\t\t\tif(a5[i]==\"\")a5[i]=\" \";\t\t\t\t\t\n\t\t\trtnArrayDocrefLine=rtnArrayDocrefLine+a5[i]+\"|\";\n\t\t\tvar v_trx_doc_ref_seq_num=eval(\"parent.frames[1].document.forms[0].trx_doc_ref_seq_num\"+i);\n\t\t\ta6[i]=v_trx_doc_ref_seq_num.value;\n\t\t\tif(a6[i]==\"\")a6[i]=\" \";\t\t\t\t\t\n\t\t\trtnArrayDocrefSeq=rtnArrayDocrefSeq+a6[i]+\"|\";\n\t\t\tvar v_billing_service_code=eval(\"parent.frames[1].document.forms[0].billing_service\"+i);\n\t\t\ta7[i]=v_billing_service_code.value;\n\t\t\tif(a7[i]==\"\")a7[i]=\" \";\t\t\t\t\t\n\t\t\trtnBlngServCode=rtnBlngServCode+a7[i]+\"|\";\n\t\t\tvar v_trx_date=eval(\"parent.frames[1].document.forms[0].trx_date\"+i);\n\t\t\ta8[i]=v_trx_date.value;\n\t\t\tif(a8[i]==\"\")a8[i]=\" \";\t\t\t\t\t\n\t\t\trtnTrxDate=rtnTrxDate+a8[i]+\"|\";\n\t\t\tvar v_prt_grp_hdr_code=eval(\"parent.frames[1].document.forms[0].prt_grp_hdr_code\"+i);\n\t\t\ta9[i]=v_prt_grp_hdr_code.val";
    private final static byte[]  _wl_block6_2Bytes = _getBytes( _wl_block6_2 );

    private final static java.lang.String  _wl_block6_3 ="ue;\n\t\t\tif(a9[i]==\"\")a9[i]=\" \";\t\t\t\t\t\n\t\t\trtnPrtGrpHdrCode=rtnPrtGrpHdrCode+a9[i]+\"|\";\n\t\t\tvar v_prt_grp_line_code=eval(\"parent.frames[1].document.forms[0].prt_grp_line_code\"+i);\n\t\t\ta10[i]=v_prt_grp_line_code.value;\n\t\t\tif(a10[i]==\"\")a10[i]=\" \";\t\t\t\t\t\n\t\t\trtnPrtGrpLineCode=rtnPrtGrpLineCode+a10[i]+\"|\";\n\t\t\tvar v_upd_net_charge_amt=eval(\"parent.frames[1].document.forms[0].upd_net_charge_amt\"+i);\n\t\t\ta12[i]=v_upd_net_charge_amt.value;\n\t\t\tif(a12[i]==\"\")a12[i]=\" \";\t\t\t\t\t\n\t\t\trtnUpdNetChrgAmt=rtnUpdNetChrgAmt+a12[i]+\"|\";\n\t\t\tvar v_upd_gross_charge_amt=eval(\"parent.frames[1].document.forms[0].upd_gross_charge_amt\"+i);\n\t\t\ta11[i]=v_upd_gross_charge_amt.value;\n\t\t\tif(a11[i]==\"\")a11[i]=\" \";\t\t\t\t\t\n\t\t\trtnUpdGrossChrgAmt=rtnUpdGrossChrgAmt+a11[i]+\"|\";\n\t\t}\n\t}\n\t\tvar v_roundingamt = eval(\"parent.frames[1].document.forms[0].round_off\");\n\t\troundingamt = v_roundingamt.value;\n\n\n\tparent.frames[2].document.forms[0].rtnCurrSlmt.value=rtnArray1;\n\n\tparent.frames[2].document.forms[0].rtnCurrSlmtBAL.value=rtnArray1;\n\n\tparent.frames[2].document.forms[0].rtnPendSlmt.value=rtnArray2;\n\tparent.frames[2].document.forms[0].rtnArrayDt.value=rtnArrayDt;\n\tparent.frames[2].document.forms[0].rtnArrayDocref.value=rtnArrayDocref;\n\tparent.frames[2].document.forms[0].rtnArrayDocrefLine.value=rtnArrayDocrefLine;\n\tparent.frames[2].document.forms[0].rtnArrayDocrefSeq.value=rtnArrayDocrefSeq;\n\tparent.frames[2].document.forms[0].services_tot_records.value=v_services_tot_records;\t\t\n\tparent.frames[2].document.forms[0].rtnBlngServCode.value=rtnBlngServCode;\t\t\n\tparent.frames[2].document.forms[0].rtnTrxDate.value=rtnTrxDate;\t\t\n\tparent.frames[2].document.forms[0].rtnPrtGrpHdrCode.value=rtnPrtGrpHdrCode;\t\t\n\tparent.frames[2].document.forms[0].rtnPrtGrpLineCode.value=rtnPrtGrpLineCode;\t\t\n\tparent.frames[2].document.forms[0].rtnUpdGrossChrgAmt.value=rtnUpdGrossChrgAmt;\t\t\n\tparent.frames[2].document.forms[0].rtnUpdNetChrgAmt.value=rtnUpdNetChrgAmt;\t\t\n\n\tparent.frames[2].document.forms[0].tot_rec_for_serv_insert.value=tot_rec_for_serv_insert;\t\t\n\n\n\tparent.frames[2].document.forms[0].roundingamt.value=roundingamt;\t\t\n\t\n\t//Added by Rajesh - V for CRf-0092\n\tvar extAcctBlngGrpAppl = \'N\';//parent.frames[0].document.forms[0].extAcctBlngGrpAppl.value;\n\tif(extAcctBlngGrpAppl == \'Y\'){\n\t\tvar patId = \'";
    private final static byte[]  _wl_block6_3Bytes = _getBytes( _wl_block6_3 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\tvar facId = \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\t\tvar epsdType = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\tvar epsdId = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\tvar visitId = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\tvar rcptTypeCode = \'\';\n\t\talert(parent.frames[0].document.forms[0].rectype.value)\n\t\tif(parent.frames[0].document.forms[0].rectype != \'undefined\'){\n\t\t\trcptTypeCode = parent.frames[0].document.forms[0].rectype.value;\n\t\t}\n\t\talert(patId+\'-\'+facId+\'-\'+epsdType+\'-\'+epsdId+\'-\'+visitId+\'-\'+rcptTypeCode);\n\t\t\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\n\t\tvar param=\"patient_id=\"+patId+\"&episode_type=\"+epsdType+\"&episode_id=\"+epsdId+\"&visit_id=\"+visitId+\"&rcpt_nat_code=BI\"+\"&rcpt_type_code=\"+rcptTypeCode;\n\n\t\tvar temp_jsp=\"../../eBL/jsp/BLEnterReceiptRefundValidation.jsp?\"+param;\n\t\talert(temp_jsp)\n\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",temp_jsp,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText=trimString(xmlHttp.responseText);\n\n\t\tvar retVal = responseText.split(\"&^&\");\n\t\tvar srch_status = retVal[0];\n\t\tif(srch_status == \'E\' || srch_status == \'M\'){\n\t\t\talert(retVal[1]);\n\t\t\treturn false;\n\t\t}\n\t}\n\t//Added by Rajesh - V for CRf-0092\n\t\n\t\n\tbillslmtprocess();\n}\n\nfunction billslmtprocess()\n\t\t\t{\n\t\n\t\t\t\tvar v_slmttype\t\t= \"\";\n\t\t\t\tvar v_cashslmtflag\t= \"\";\n\t\t\t\tvar v_instref\t\t= \"\";\n\t\t\t\tvar v_instdate\t\t= \"\";\n\t\t\t\tvar v_instremark\t= \"\";\n\t\t\t\tvar v_slmtidno\t\t= \"\";\n\t\t\t\tvar v_slmtpayername = \"\";\n\t\t\t\tvar v_billslmtamt = \"\";\t\n\t\t\t\tvar v_slmtapprrefno = \"\";\n\n\t\t\t\tvar v_rectype =\"\";\n\t\t\t\tvar v_ext_acc_facility_id = \"\";\n\t\t\t\tvar v_ext_acc_code = \"\";\n\t\t\t\tvar v_ext_acc_dept = \"\";\n\t\t\t\tvar v_online_approval = \"\";\n\t\t\t\tvar v_batch_no = \"\";\n\t\t\t\tvar v_sale_draft_no = \"\";\n\t\t\t\tvar v_ext_acc_interface_yn = \"\";\n\t\t\t\tvar v_ext_acc_fac_id=\"\";\n\t\t\t\tvar v_ext_acc_dept=\"\";\n\t\t\t\tvar v_ext_acc_code=\"\";\n\t\t\t\tvar v_bill_slmt_amtdet=\"\";\n\t\t\t\tvar v_bill_payable_amt=\"\";\n\t\t\t\tv_total_settled_amt=\"\";\n\t\t\t\tvar strroundingamt=\"\";\n\t\t\t\tv_bill_slmt_amtdet=parent.frames[0].document.forms[0].billslmtamtdet.value;//new\n\t\t\t\tv_bill_payable_amt=parent.frames[0].document.forms[0].billpayableamt.value;//new\n\n\t\t\t\t//Added by muthu against 33900 on 8/18/2012 \n\t\t\t\tif(v_bill_payable_amt!==\"\" && (v_bill_slmt_amtdet==\"\" || v_bill_slmt_amtdet==0))\n\t\t\t\t{\n\t\t\t\t\tif(v_bill_slmt_amtdet==\"\" && v_bill_payable_amt!==\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamtdet.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t//if(eval(v_bill_slmt_amtdet)==0 && eval(v_bill_payable_amt)==0)//Commented for 33900\n\t\t\t\t\tif(eval(parseInt(v_bill_slmt_amtdet))==0 && eval(parseInt(v_bill_payable_amt))==0)\n\t\t\t\t\t{\t\n\t\t\t\t\t\talert(getMessage(\"BL9796\",\"BL\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//Added by muthu against 33900 on 8/18/2012 \n\n\t\t\t\t//if(v_bill_slmt_amtdet > 0 || v_bill_slmt_amtdet == 00.00){//newly added\n\t\t\t\tif(v_bill_slmt_amtdet != 0){\t//Added by muthu against 33900 on 8/18/2012\n\t\t\t\tv_ext_acc_fac_id=parent.frames[0].document.forms[0].str_ext_acc_facility_id.value;\t\t\t\t\n\t\t\t\t//v_bill_slmt_amtdet=parent.frames[0].document.forms[0].billslmtamtdet.value;\n\t\t\t\t//v_bill_payable_amt=parent.frames[0].document.forms[0].billpayableamt.value;\t\n\t\t\t\tv_total_settled_amt=document.forms[0].total_settled_amt.value;\t\n\t\t\t\tstrroundingamt=parent.frames[0].document.forms[0].strroundingamt.value;\t\n\t\t\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"0\";\n\t\t\t\tvar v_tot_curr_stlmt=parent.frames[1].document.forms[0].tot_curr_stlmt.value;\n\t\t\t\tvar v_tot_curr_stlmt_no_roundoff=parent.frames[1].document.forms[0].tot_curr_stlmt_no_roundoff.value;\n\t\t\t\tvar v_net_total=parent.frames[1].document.forms[0].net_total.value;\n\t\t\t\tvar bill_amt = document.forms[0].bill_amt.value;\n\t\t\t\t//Added by lakshmi\n\t\t\t\tvar rec_print_format_enabled_yn = document.forms[0].rec_print_format_enabled_yn.value;//muthu\n\t\t\t\t/* Commented by muthu for testing\n\t\t\t\tif(v_bill_payable_amt!==\"\" && (v_bill_slmt_amtdet==\"\" || v_bill_slmt_amtdet==0))\n\t\t\t\t{\n\t\t\t\t\tif(v_bill_slmt_amtdet==\"\" && v_bill_payable_amt!==\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamtdet.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(v_bill_slmt_amtdet)==0 && eval(v_bill_payable_amt)==0)\n\t\t\t\t\t{\t\n\t\t\t\t\t\talert(getMessage(\"BL9796\",\"BL\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}*/\n\t\t\t\t/*if (parent.frames[2].document.forms[0].onlineapproval.checked)\n\t\t\t\t\tv_online_approval = \'Y\';\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tv_online_approval = \'N\';*/\t\t\t\t\t\t\t\n\t\t\t\t\tv_net_total = parseFloat(v_net_total) + parseFloat(strroundingamt);\n\t\t\t\t\tif(parseFloat(v_net_total) == parseFloat(v_bill_slmt_amtdet))\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parseFloat(v_tot_curr_stlmt) != parseFloat(v_bill_slmt_amtdet))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tv_tot_curr_stlmt = parseFloat(v_tot_curr_stlmt) + parseFloat(strroundingamt);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tv_tot_curr_stlmt=v_tot_curr_stlmt;\n\t\t\t\t\t}\n\t\t\t\tif((v_total_settled_amt!=v_bill_slmt_amtdet) || (v_tot_curr_stlmt!=v_bill_slmt_amtdet))\n\t\t\t\t{\n\t\t\t\t\tif(!(v_bill_slmt_amtdet < 0 &&  v_tot_curr_stlmt == 0 && eval(bill_amt) >= 0))\n\t\t\t\t\t{\n\t\t\t\t\t\t/* if(v_tot_curr_stlmt!=v_bill_slmt_amtdet)\t\t\tKarthik Commented for SCF 272\t\t\t\t\t\t\t\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(getMessage(\"BL9621\",\"BL\"));\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t} */\n\t\t\t\t\t\t/* Karthik added below logic for SCF 272 */\n\t\t\t\t\t\t/* The Summed up Settlement value without Round off and the Bill Settlement Value is checked for Negligible difference of 2\n\t\t\t\t\t\t   If difference exceeds 2, then we throw Error*/\n\t\t\t\t\t\tvar negligible_difference= parseFloat(v_bill_slmt_amtdet)-parseFloat(v_tot_curr_stlmt_no_roundoff);\n\t\t\t\t\t\tif(Math.abs(negligible_difference)>2){\n\t\t\t\t\t\t\talert(getMessage(\"BL9621\",\"BL\"));\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t\t\tif(v_total_settled_amt!=v_bill_slmt_amtdet)\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BL9782\",\"BL\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//if(v_bill_slmt_amtdet!=v_total_settled_amt)\n\t\t\t\t//{\n\t\t\t\t//\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t\t//\treturn false;\n\t\t\t\t//}\n\n\t\t\t\t/*if(v_tot_curr_stlmt!=v_total_settled_amt)\n\t\t\t\t{\n\t\t\t\t\talert(\"Total  Amount Should be equal to Settled Amount\");\n\t\t\t\t\treturn false;\n\n\t\t\t\t}*/\n\t\t\t\tvar v_ext_acc_interface_yn=parent.frames[0].document.forms[0].ext_acc_interface_yn.value;\n\t\t\t\t\n\t\t\t\tif(v_ext_acc_interface_yn== \"Y\")\n\t\t\t\t{\n\t\t\t\t\tv_rectype = parent.frames[0].document.forms[0].rectype.value;\n\t\t\t\t\tv_ext_acc_dept=parent.frames[0].document.forms[0].dept.value;\n\t\t\t\t\tv_ext_acc_code=parent.frames[0].document.forms[0].acccode.value;\t\t\t\n\n\t\t\t\tif ( v_rectype == \"\")\n\t\t\t\t\t{\t\t\t\t\t\n//\t\t\t\t\t\talert(\"Receipt Type cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9524\",\"BL\"));\n\t\t\t\t\t\tparent.frames[0].document.forms[0].rectype.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\tif ( v_ext_acc_code == \"\")\n\t\t\t\t\t{\n//\t\t\t\t\t\talert(\"Account code cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9525\",\"BL\"));\n\t\t\t\t\t\tparent.frames[0].document.forms[0].acccode.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\n\t\t\t\t\tif ( v_ext_acc_dept == \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t\t//alert(\"Accounting department cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9526\",\"BL\"));\n\t\t\t\t\t\tparent.frames[0].document.forms[0].dept.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\n\t\t\t\t}\n\n\t\t\t\t\tvar genmesg = getMessage(\"BL9537\",\"BL\");\n\t\t\t\t\t\t\t\t\t\t\t\n//\t\t\t\t\tparent.frames[3].location.href =  \'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&billdocnum=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&billpayableamt=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&facilityid=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&user=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&patientid=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&episodetype=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&episodeid=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&visitid=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&slmtamt=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&rectype=\'+v_rectype+\'&ext_acc_code=\'+v_ext_acc_code+\'&ext_acc_dept=\'+v_ext_acc_dept+\'&ext_acc_fac_id=\'+v_ext_acc_fac_id+\'&genmesg=\'+genmesg;\ndocument.forms[0].ok_button.disabled=true;\nparent.frames[2].document.forms[0].target=\'BillSlmtSubmitFrame\';\n/*parent.frames[2].document.forms[0].action=\'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&loggeduser=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&encounterid=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&moduleid=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&slmtidno=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&rectype=\'+v_rectype+\'&ext_acc_code=\'+v_ext_acc_code+\'&ext_acc_dept=\'+v_ext_acc_dept+\'&ext_acc_fac_id=\'+v_ext_acc_fac_id+\'&genmesg=\'+genmesg+\'&bill_slmt_amtdet=\'+v_bill_slmt_amtdet+\"&called_frm=\"+document.forms[0].called_frm.value+\"&alw_co_wit_bl_slmt_yn=\"+document.forms[0].alw_co_wit_bl_slmt_yn.value+\"&cal_frm_multi_bil_slmt=\"+document.forms[0].cal_frm_multi_bil_slmt.value+\"&cash_counter_code=\"+document.forms[0].cash_counter_code.value;*/\n//Added by lakshmi\nparent.frames[2].document.forms[0].action=\'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&rectype=\'+v_rectype+\'&ext_acc_code=\'+v_ext_acc_code+\'&ext_acc_dept=\'+v_ext_acc_dept+\'&rec_print_format_enabled_yn=\'+rec_print_format_enabled_yn+\'&ext_acc_fac_id=\'+v_ext_acc_fac_id+\'&genmesg=\'+genmesg+\'&bill_slmt_amtdet=\'+v_bill_slmt_amtdet+\"&called_frm=\"+document.forms[0].called_frm.value+\"&alw_co_wit_bl_slmt_yn=\"+document.forms[0].alw_co_wit_bl_slmt_yn.value+\"&cal_frm_multi_bil_slmt=\"+document.forms[0].cal_frm_multi_bil_slmt.value+\"&cash_counter_code=\"+document.forms[0].cash_counter_code.value; \n\n//\"&str_rec_print_format_enabled_yn=\"+rec_print_format_enabled_yn;\n\nparent.frames[2].document.forms[0].submit();\n\n\n/*Added by muthu 8/16/2012 against 33900\n\t\t\t\tif(v_bill_slmt_amtdet == 0.0)\n\t\t\t\t{\n\t\t\t\t\talert(\"Testing v_bill_slmt_amtdet by muthu \"+v_bill_slmt_amtdet);\n\t\t\t\t\tcancel();\n\t\t\t\t}\nAdded by muthu 8/16/2012 against 33900*/\n\t\t\t\t}\t//Added by muthu against 33900 on 8/18/2012 Starts here\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tcancel();\n\t\t\t\t}\n\t\t//Added by muthu against 33900 on 8/18/2012 Ends here \n}\nfunction cancel()\n{\n\t/*IN038081 Added by Karthik on May-10-2013 to bring in Confirmation window before cancel*/\n\tvar r=confirm(\"Are you sure you want to Cancel Bill Settlement ?\");\n\tif (r==true)\n\t{\n\tvar called_frm = document.forms[0].called_frm.value;\n\tvar alw_co_wit_bl_slmt_yn = document.forms[0].alw_co_wit_bl_slmt_yn.value;\n\tvar episode_type = document.forms[0].episode_type.value;\n\tvar cal_frm_multi_bil_slmt = document.forms[0].cal_frm_multi_bil_slmt.value;\n\tvar bill_print_format_enabled_yn = document.forms[0].bill_print_format_enabled_yn.value;\n\t//var rec_print_format_enabled_yn = document.forms[0].rec_print_format_enabled_yn.value;//muthu\n\n\tif(called_frm == \"CHECKOUT_VISIT\" && alw_co_wit_bl_slmt_yn == \"Y\" && episode_type == \"E\" && cal_frm_multi_bil_slmt != \"Y\")\n\t{\n\t\talert(getMessage(\"BL7284\",\"BL\"));\n\t\treturn false;\n\t}\n\n\tif(bill_print_format_enabled_yn == \'Y\')\n\t{\n\t\tparent.frames[2].document.forms[0].target=\'BillSlmtSubmitFrame\';\n\t    parent.frames[2].document.forms[0].action=\"../../eBL/jsp/BLBillSlmtValidation.jsp?bill_print_format_enabled_yn=\"+bill_print_format_enabled_yn+\"&billdoctypecode=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&called_frm_cancel=Y\";\n\t\tparent.frames[2].document.forms[0].submit();\t\t\t\n\t}\n\telse\n\t{\n\t\tparent.window.close();\n\t}\n\t}\n}\n/*\nfunction chkForDfltSlmtType()\n{\n\tdocument.forms[0].add_bill_stlmt_button.click();\n}\n*/\n</script>\n\t\t\t<title>\t\t\t\n\t\t\t</title>\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n-->\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eBL/js/AddModifyPatFinDetails.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\t\n\t\t</head>\n\n\t\t<body onLoad=\'tot_setld_amt();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<form>\n<table cellpadding=3 cellspacing=0  width=\"100%\">\t\n<tr>\n\t<td width=\'25%\' class=\'label\'><b>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</b>\n\t\n\t<input type=\'text\' name=\'total_settled_amt\' id=\'total_settled_amt\' size=\'10\' maxlength=\'25\' style=\'text-align:right\' readonly value=\'\'></td>\t\n\n\t<td class=\"label\" width=\"25%\"></td>\n\t<td width=\"25%\"  class=\'labels\'>\t<input type=\'button\' class=\'button\' onclick=\'addBillSlmt()\' name=\'add_bill_stlmt_button\' id=\'add_bill_stlmt_button\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t\n\n\t<input type=\'button\' class=\'button\' onclick=\'modifyBillSlmt()\' name=\'modify_serv_button\' id=\'modify_serv_button\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n\t<input type=\'button\' class=\'button\' onclick=\'removeBillSlmt()\' name=\"remove_button\" id=\"remove_button\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" ></td>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\n\t<td width=\"25%\"  class=\'labels\'><INPUT TYPE=\"button\"  class=\"BUTTON\" name=\'ok_button\' id=\'ok_button\' VALUE=\"    ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="    \" onClick=\'billslmtprocess1()\' ><input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" class=\'button\' onClick=\'cancel()\'></td>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\n\t\t\n\t</td>\n</tr>\n\n</table>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n<input type= hidden name=\"query_string\" id=\"query_string\"  value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<INPUT TYPE=\"HIDDEN\" name=\"blnggrp\" id=\"blnggrp\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\t\t\n<INPUT TYPE=\"HIDDEN\" name=\"billdoctype\" id=\"billdoctype\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >\t \t\n<INPUT TYPE=\"HIDDEN\" name=\"billdocnum\" id=\"billdocnum\"\t   SIZE=\"20\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'> \n<INPUT TYPE=\"HIDDEN\" name=\"total_amt_payable\" id=\"total_amt_payable\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' >\n<input type=\'hidden\' name=\'strdfltslmttypecode\' id=\'strdfltslmttypecode\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' >\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' >\n<input type=\'hidden\' name=\'called_frm\' id=\'called_frm\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' >\n<input type=\'hidden\' name=\'alw_co_wit_bl_slmt_yn\' id=\'alw_co_wit_bl_slmt_yn\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' >\n<input type=\'hidden\' name=\'cal_frm_multi_bil_slmt\' id=\'cal_frm_multi_bil_slmt\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' >\n<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' >\n<input type=\'hidden\' name=\'cash_counter_code\' id=\'cash_counter_code\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' >\n<input type=\'hidden\' name=\'bill_amt\' id=\'bill_amt\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' >\n<input type=\'hidden\' name=\'doc_amt\' id=\'doc_amt\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' >\n<input type=\'hidden\' name=\'bill_print_format_enabled_yn\' id=\'bill_print_format_enabled_yn\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' >\n<input type=\'hidden\' name=\'rec_print_format_enabled_yn\' id=\'rec_print_format_enabled_yn\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' >\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	Connection con = null; 
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	ResultSet rscurr=null;
	String strfacilityid="";	String p_login_user="";
	String query_string=""; 	String strblnggrpid="";
	String strbilldoctypecode="";	String strbilldocnum ="";
	String strbillpayableamt=""; String strpatientid  ="";String strepisodetype="",strmoduleid="";
	String strepisodeid =""; String strvisitid ="";String strencounterid="";String strslmtpayername=""; 
	String struser ="";String strslmtidno = "";	int noofdecimal=2;String strdfltslmttypecode = "",function_id="",called_frm="",alw_co_wit_bl_slmt_yn="N",cal_frm_multi_bil_slmt="N",cash_counter_code="";

	String str_bill_amt = "0";
	String doc_amt="";
	double d_bill_amt = 0;
	String str_bill_print_format_enabled_yn = "N";
	//Added by muthu against 33868 - Receipt Print on 13-7-12
	String str_rec_print_format_enabled_yn = "N";
	request.setCharacterEncoding("UTF-8");
	try
	{
		con	=	ConnectionManager.getConnection(request);
		query_string=request.getQueryString();
		strpatientid  = request.getParameter("patientid");	
		if (strpatientid == null || strpatientid.equalsIgnoreCase("null")) 
		{strpatientid = "";}	
	 	strepisodetype = request.getParameter("episodetype");	
		if (strepisodetype == null || strepisodetype.equalsIgnoreCase("null")) 
		{strepisodetype = "";}	
		strmoduleid= request.getParameter("moduleid");	
		if (strmoduleid == null || strmoduleid.equalsIgnoreCase("null")) 
		{strmoduleid = "";}	
		strepisodeid = request.getParameter("episodeid");
		if (strepisodeid == null || strepisodeid.equalsIgnoreCase("null")) 
		{strepisodeid = "";}	
		strvisitid = request.getParameter("visitid");
		if (strvisitid == null || strvisitid.equalsIgnoreCase("null")) 
		{strvisitid = "";}
		strencounterid = request.getParameter("encounterid");
		if (strencounterid == null || strencounterid.equalsIgnoreCase("null")) 
		{strencounterid = "";}
		
		strslmtpayername = request.getParameter("slmtpayername");	
		if (strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null")) 
		{strslmtpayername = "";}
		struser = request.getParameter("loggeduser");
		if (struser == null || struser.equalsIgnoreCase("null")) 
		{struser = "";}			
		strslmtidno = request.getParameter("slmtidno");
		strfacilityid = (String)httpSession.getValue("facility_id");
		p_login_user =  p.getProperty("login_user");
		strblnggrpid = request.getParameter("strblnggrpid");	
		if (strblnggrpid == null || strblnggrpid.equalsIgnoreCase("null")) 
		{strblnggrpid = "";}	
		strbilldoctypecode = request.getParameter("billdoctypecode");
		if (strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
		{strbilldoctypecode = "";}	
		strbilldocnum = request.getParameter("billdocnum");
		if (strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
		{strbilldocnum = "";}	
		
		strbillpayableamt = request.getParameter("billpayableamt");
		if (strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
		{strbillpayableamt = "";}	

		System.out.println("strbillpayableamt in BLDepositsmttypebtn"+strbillpayableamt);
		
		function_id = request.getParameter("function_id");
		if(function_id==null) function_id="";	

	
		called_frm= request.getParameter("called_frm");
		if(called_frm==null) called_frm="";	

		alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
		if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";

		cal_frm_multi_bil_slmt = request.getParameter("cal_frm_multi_bil_slmt");
		if(cal_frm_multi_bil_slmt == null) cal_frm_multi_bil_slmt="N";		

		cash_counter_code = request.getParameter("cashcounter");
		if(cash_counter_code == null) cash_counter_code="";	
	/****Added for Package Billing**********************starts*********/	
	if(function_id.equals("PKG_BILLING")){
		String remove_check = request.getParameter("remove_check");
		if(remove_check == null) remove_check="";	
		
		String bean_id1		= "PkgEnterReceptRefundBean" ;
		String bean_name1	= "eBL.PkgEnterReceptRefundBean";	

		PkgEnterReceptRefundBean bean1			= (PkgEnterReceptRefundBean)getBeanObject( bean_id1, bean_name1, request ) ;
		HashMap  support_data = bean1.getSupportData();		
		if(support_data!=null && support_data.size()>0)
		{				
			if(remove_check.equals(""))
			{
			doc_amt = (String)support_data.get("doc_amt");
			if(doc_amt==null) doc_amt="0";	
			}else{
				doc_amt="";
			}
		}
	}else{
		doc_amt="";
	}
	/****Added for Package Billing**********************ends*********/	

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);
			}
			rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("3 btn="+e.toString());
		}

		try
		{		
			//pstmt = con.prepareStatement( " SELECT NVL(BILL_PRINT_FORMAT_ENABLED_YN,'N') FROM BL_PARAMETERS WHERE operating_facility_id =  '"+strfacilityid+"'");
			pstmt = con.prepareStatement( " SELECT NVL(BILL_PRINT_FORMAT_ENABLED_YN,'N'), NVL(REC_PRINT_FORMAT_ENABLED_YN,'N') FROM BL_PARAMETERS WHERE operating_facility_id =  '"+strfacilityid+"'"); //lakshmi
			
			rs = pstmt.executeQuery();	

			while(rs.next())
			{
				str_bill_print_format_enabled_yn = rs.getString(1);
				str_rec_print_format_enabled_yn = rs.getString(2);//Added by Muthu on 13-7-12 against 33868
			}
			rs.close();
			pstmt.close();
			if(str_bill_print_format_enabled_yn == null) str_bill_print_format_enabled_yn="N";
			if(str_rec_print_format_enabled_yn == null) str_rec_print_format_enabled_yn="N";//Added by Muthu on 13-7-12 against 33868
		}
		catch(Exception e)
		{
			System.out.println("3 btn="+e.toString());
			e.printStackTrace();
		}

		try
		{		
			pstmt = con.prepareStatement( " select nvl(bill_amt,0) from bl_bill_hdr where DOC_TYPE_CODE = '"+strbilldoctypecode+"' and DOC_NUM='"+strbilldocnum+"'");
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				str_bill_amt = rs.getString(1);
			}
			rs.close();
			pstmt.close();
			if(str_bill_amt == null) str_bill_amt="0";
			d_bill_amt = Double.parseDouble(str_bill_amt);
		}
		catch(Exception e)
		{
			System.out.println("3 btn="+e.toString());
			e.printStackTrace();
		}	

            _bw.write(_wl_block6_0Bytes, _wl_block6_0);
            _bw.write(_wl_block6_1Bytes, _wl_block6_1);
            _bw.write(_wl_block6_2Bytes, _wl_block6_2);
            _bw.write(_wl_block6_3Bytes, _wl_block6_3);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strencounterid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strmoduleid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strencounterid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strmoduleid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block28Bytes, _wl_block28);
	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")));
            _bw.write(_wl_block34Bytes, _wl_block34);

	//if(!function_id.equals("rcpt_rfnd"))
	/**********added  function_id.equals("PKG_BILLING") for packag billing**************/
	if(!function_id.equals("rcpt_rfnd") && !function_id.equals("PKG_BILLING"))
		{

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block37Bytes, _wl_block37);

		}

            _bw.write(_wl_block38Bytes, _wl_block38);

	}catch(Exception e) {System.out.println("btn="+e.toString());}
finally
		{			
			ConnectionManager.returnConnection(con, request);
		}		


            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strblnggrpid));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strdfltslmttypecode));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(cal_frm_multi_bil_slmt));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_bill_amt));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(doc_amt));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(str_bill_print_format_enabled_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(str_rec_print_format_enabled_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
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
}
