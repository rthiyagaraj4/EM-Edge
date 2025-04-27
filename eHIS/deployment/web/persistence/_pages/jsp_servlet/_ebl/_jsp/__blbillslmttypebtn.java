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
import eBL.BLCashSlmtRestriction;

public final class __blbillslmttypebtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtTypeBtn.jsp", 1740639796873L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\tDeveloper Name\n-----------------------------------------------------------------------------------------------\n1            V210113             8157          NMC-JD-CRF-0072               Shikha Seth\n2            V210211             8157          NMC-JD-CRF-0072               Shikha Seth\n3            V210211.1           13526         MOHE-CRF-0060 \t             Shikha Seth\n4            V210224             8157          NMC-JD-CRF-0072               Shikha Seth\n5                                15771         NMC-JD-SCF-0164               Sethuraman D\n6            V220110             25938         GHL-CRF-0646                  Nandhini M\n7            V220517                           KDAH-SCF-0773/AMS-SCF-1014    MohanapriyaK\n8\t\t\t V220517\t\t\t\t\t\t   MMS-ICN-00129-TF\t\t\t\tMohanapriyaK\n9 \t\t     V220711\t\t     32529\t\t   KDAH-SCF-0786-TF\t\t\t\tManivel N\n-----------------------------------------------------------------------------------------------\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5_0 ="\n\n<html>\n\t<head>\n\t\t<script>\n\t\tvar totalRecords=\"\";\n\t\tvar count=\"\";\n\t\tvar formObj=\"\";\n\t\tvar classval=\"\";\n\t\t//Added for KDAH-CRF-0339.2\n\t\tvar Cash_checklimit=0;\n\t\tasync function addBillSlmt()\n\t\t{\t\t\n\t\t\tdocument.forms[0].doc_amt.value=\"\";\n\t\t\t\n\t\t\tvar query_string=document.forms[0].query_string.value;\n\t\t\tvar formObj = parent.frames[2].document.forms[0];\n\t\t\ttotal_records=formObj.total_records.value;\n\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\t\ttemp.checked=false;\n\t\t\t}\n\t\t\tvar isCCTerminalIdEnable = formObj.cc_terminal_id_enable.value; \t\t<!--Added by Monika for NMC-JD-CRF-0199 on 04/08/2023 -->\n\t\t\tvar retVal = new Array();\n\t\t\tvar billdoctype=document.forms[0].billdoctype.value;\n\t\t\tvar billdocnum=document.forms[0].billdocnum.value;\n\t\t\tvar blnggrp=document.forms[0].blnggrp.value;\n\t\t\tvar total_amt_payable=document.forms[0].total_amt_payable.value;\t\n\t\t\tvar total_settled_amt=document.forms[0].total_settled_amt.value;\t\n\t\t\tvar function_id=document.forms[0].function_id.value;\t\n\t\t\tvar rec_ref=\"\";\n\t\t\tif(function_id==\'rcpt_rfnd\' ){\n\t\t\t\tvar rec_ref=parent.frames[1].document.forms[0].recpt_refund_ind.value;\n\t\t\t}\n\t\t\t\n\t\t\t//if(function_id==\'rcpt_rfnd\') \n\t\t\tif(function_id==\'rcpt_rfnd\' || function_id==\'PKG_BILLING\' )\n\t\t\t{\n\t\t\tvar settled_amt_det=parent.frames[1].document.forms[0].stlmt_amount.value;\n\t\t\t}else{\n\t\t\t\tvar settled_amt_det=parent.frames[0].document.forms[0].billslmtamtdet.value;\n\t\t\t}\n\n\t\n//\tvar tot_curr_stlmt=parent.frames[1].document.forms[0].tot_curr_stlmt.value;\n/*\n\tif(parseFloat(tot_curr_stlmt)!=parseFloat(settled_amt_det))\n\t{\n\t\t alert(getMessage(\"BL9659\",\"BL\"));\n\t\t//alert(\"Allocated Amt Must Be Equal To Settled Amt\");\n\t\treturn false;\n\t}\n*/\n\t\tvar action=\"add\";\t\n\t\tif(settled_amt_det==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\treturn;               \n\t\t}\t\t\n\t\tif(eval(settled_amt_det)==0 && eval(total_settled_amt)==0)\n\t\t{\n\t\t\talert(getMessage(\"BL9796\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif(parseFloat(settled_amt_det)==parseFloat(total_settled_amt))\n\t\t{\t\t\n\t\t\talert(getMessage(\"BL9637\",\"BL\"));\n\t\t\treturn;\n\t\t}\n\t/*if(total_amt_payable==total_settled_amt)\n\t{\n\t\t//alert(\"Amount Settled\");\n\t\talert(getMessage(\"BL9614\",\"BL\"));\n\t\treturn;\n\t}\n\ttotal_amt_payable=parseFloat(total_amt_payable)-parseFloat(total_settled_amt);\n\tif(total_amt_payable<0)\n\t{\n\t\ttotal_amt_payable=\'0.00\';\n\t}*/\n\t//Added for KDAH-CRF-0339.2\t\n\tvar restrictEligibility = document.forms[0].restrictEligibility.value;\n\tCash_checklimit = 0;\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\t//Added V060618-Subha/IN67859\n\t\tif(eval(\"parent.frames[2]\").value != \"undefined\" && eval(\"parent.frames[2]\").value != undefined) { \n\t\t\tif(eval(\"parent.frames[2].document.forms[0].Cash_check\"+j).value == \'Y\'){\n\t\t\t\tvar Cash_slmtAmt=eval(\"parent.frames[2].document.forms[0].billslmtamt\"+j).value;\n\t\t\t\tCash_checklimit = parseFloat(Cash_checklimit)+parseFloat(Cash_slmtAmt);\n\t\t\t}\t\t\t\n\t\t}\n\t}\t\n\t//Added for KDAH-CRF-0339.2\t\n\tvar center=\'1\';\n\tvar dialogTop = \"0vh\";\n\tvar dialogHeight = \"65vh\" ;\n\tvar dialogWidth = \"58vw\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\t\n\tvar title=encodeURIComponent(getLabel(\"eBL.ADD_BILL_SLMT_DTL.label\",\"BL\"));\n\t//title=encodeURIComponent(title);\t\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\t\n//\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billdoctypecode=\"+billdoctype+\"&\"+\"billdocnum=\"+billdocnum+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"total_amt_payable=\"+total_amt_payable+\"&\"+\"action=\"+action+\"&\"+\"settled_amt_det=\"+settled_amt_det+\"&\"+\"total_settled_amt=\"+total_settled_amt;\n\n\t//Appended Cash Limit for KDAH-CRF-0339.2\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"blnggrp=\"+blnggrp+\"&\"+\"total_amt_payable=\"+total_amt_payable+\"&\"+\"action=\"+action+\"&\"+\"settled_amt_det=\"+settled_amt_det+\"&\"+\"total_settled_amt=\"+total_settled_amt+\"&\"+query_string+\"&\"+\"rec_ref=\"+rec_ref+\"&\"+\"Cash_checklimit=\"+Cash_checklimit+\"&\"+\"restrictEligibility=\"+restrictEligibility;\n\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLBillSlmtMain2.jsp?\"+param,arguments,features);\t\n\tif(retVal!=null)\n\t{\n\t\tformObj = parent.frames[2].document.forms[0];\n\t\ttotalRecords =eval(formObj.total_records.value);\n\t\tcount =totalRecords + 1; \n\t\tvar record_select=count;\n\t\tvar arr=new Array();\t\n\t\tif(retVal == null) retVal=\'\';\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\t\t\t\n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\t\t\t\n\t\t\t\tarr=retVal.split(\"::\");\t\n\t\t\t\tvar billdoctype=arr[0];\n\t\t\t\tif(billdoctype==\" \")billdoctype=\"\";\n\t\t\t\tvar billdocnum=arr[1];\n\t\t\t\tif(billdocnum==\" \")billdocnum=\"\";\n\t\t\t\tvar billpayableamt=arr[2];\n\t\t\t\tif(billpayableamt==\" \")billpayableamt=\"\";\n\t\t\t\tvar billslmtamt=arr[3];\n\t\t\t\tif(billslmtamt==\" \")billslmtamt=\"\";\n\t\t\t\tvar slmttype=arr[4];\n\t\t\t\tif(slmttype==\" \")slmttype=\"\";\t\n\t\t\t\tvar payername=arr[5];\n\t\t\t\tif(payername==\" \")payername=\"\";\t\t\t\t\n\t\t\t\tvar recrefidno=arr[6];\n\t\t\t\tif(recrefidno==\" \")recrefidno=\"\";\n\t\t\t\tvar ext_acc_interface_yn=arr[7];\n\t\t\t\tif(ext_acc_interface_yn==\" \")ext_acc_interface_yn=\"\";\t\t\t\t\n\t\t\t\tvar ext_acc_fac_id=arr[8];\n\t\t\t\tif(ext_acc_fac_id==\" \")ext_acc_fac_id=\"\";\n\t\t\t\tvar instref=arr[9];\n\t\t\t\tif(instref==\" \")instref=\"\";\n\t\t\t\tvar instdate=arr[10];\n\t\t\t\tif(instdate==\" \")instdate=\"\";\n\t\t\t\tvar instremark=arr[11];\n\t\t\t\tif(instremark==\" \")instremark=\"\";\n\t\t\t\tvar instbranch=arr[12];\n\t\t\t\tif(instbranch==\" \")instbranch=\"\";\n\t\t\t\tvar onlineapproval=arr[13];\t\t\t\t\t\n\t\t\t\tif(onlineapproval==\" \")onlineapproval=\"\";\t\t\t\t\n\t\t\t\tvar batchno=arr[14];\n\t\t\t\tif(batchno==\" \")batchno=\"\";\n\t\t\t\tvar apprrefno=arr[15];\n\t\t\t\tif(apprrefno==\" \")apprrefno=\"\";\n\t\t\t\tvar saledraftno=arr[16];\n\t\t\t\tif(saledraftno==\" \")saledraftno=\"\";\n\t\t\t\tvar cashslmtflag=arr[17];\n\t\t\t\tif(cashslmtflag==\" \")cashslmtflag=\"\";\t\t\t\t\n\t\t\t\tvar instbankname=arr[18];\n\t\t\t\tif(instbankname==\" \")instbankname=\"\";\n\t\t\t\tvar cash_given=arr[19];\n\t\t\t\tif(cash_given==\" \")cash_given=\"\";\n\t\t\t\tvar cash_return=arr[20];\n\t\t\t\tif(cash_return==\" \")cash_return=\"\";\n\t\t\t\tvar short_desc=arr[21];\n\t\t\t\tif(short_desc==\" \")short_desc=\"\";\n\t\t\t\tvar instremarkcode=arr[22];\n\t\t\t\tif(instremarkcode==\" \")instremarkcode=\"\";\n\n\t\t\t\tvar credit_card_machine_int_yn = arr[24];\n\t\t\t\tif(credit_card_machine_int_yn == \" \") credit_card_machine_int_yn=\"\";\n\t\t\t\t\n\t\t\t\t//Added for KDAH-CRF-0339.2\n\t\t\t\tvar Cash_check = arr[25];\n\t\t\t\tif(Cash_check == \" \") Cash_check=\"\";\n\t\t\t\t\n\t\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\n\t\t\t\tvar term_id_num = arr[26];\n\t\t\t\tif(term_id_num == \" \") term_id_num=\"\";\n\n\t\t\t\tvar trx_date_time = arr[27];\n\t\t\t\tif(trx_date_time == \" \") trx_date_time=\"\";\n\t\t\t\t//V210113 start\n\t\t\t\tvar couponcode = arr[28];\n\t\t\t\tif(couponcode == \"\") couponcode =\"\";\n\t\t\t\t\n\t\t\t\tvar patMembershipID = arr[29];\n\t\t\t\tif(patMembershipID == \"\") patMembershipID =\"\";\n\t\t\t\tdocument.forms[0].patMembershipID.value = patMembershipID;\n\n\t\t\t\tvar couponAndAmt = arr[30];\n\t\t\t\tif(couponAndAmt == \"\") couponAndAmt =\"\";\n\t\t\t\t//V210113 end\n\t\t\t\t\n\t\t\t\t//Added by Monika for NMC-JD-CRF-0199\n\t\t\t\tvar cc_term_id_num = arr[26];\n\t\t\t\tif(cc_term_id_num == \"\") cc_term_id_num =\"\";\n\t\t\t\t//alert(\"cc_term_id_num : \"+cc_term_id_num);\n\t\t\t}\n\t\t}\n\t\tvar record_select=count;\n\t\tfor(var j=totalRecords;j<count;j++ )\n\t\t{\n\t\t\tif(j % 2 == 0 )\n\t\t\t{\n\t\t\t\tclassval\t=\t\"QRYEVEN\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tclassval\t=\t\"QRYODD\";\n\t\t\t}\n\t\t\tcurr_row\t=\tparent.frames[2].document.getElementById(\'bill_slmt_data\').insertRow();\n\t\t\tcurr_row.id= \"row\"+eval(totalRecords+1);\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[0].className\t= classval;\n\t\t\tcurr_row.cells[0].WIDTH\t= \"6%\";\n\t\t\tcurr_row.cells[0].insertAdjacentHTML(\"beforeend\", \"<input type=\'checkbox\'  name=\'selected_row\"+j+\"\' id=\'selected_row\"+j+\"\' style=\'text-align:right\'  value=\'\' onClick=\'selected(\"+j+\");\' >\");\n\t\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[1].className\t= classval;\n\t\t\tcurr_row.cells[1].WIDTH\t= \"6%\";\n\t\t\tcurr_row.cells[1].insertAdjacentHTML(\"beforeend\", \"<input maxlength=\'30\' size=\'10\' type=text readonly name=\'billslmtamt\"+j+\"\' id=\'billslmtamt\"+j+\"\'  value=\'\"+billslmtamt+\"\' readonly style=\'text-align:right\'  >\");\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[2].className\t=classval;\n\t\t\tcurr_row.cells[2].WIDTH\t= \"6%\";\n\t\t\tcurr_row.cells[2].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'40\' size=\'20\' readonly name=\'shortdesc\"+j+\"\' id=\'shortdesc\"+j+\"\'   value=\'\"+short_desc+\"\'  > <input type=hidden name=\'slmttype\"+j+\"\' id=\'slmttype\"+j+\"\' value=\'\"+slmttype+\"\' > <input type=hidden name=\'couponcode\"+j+\"\' id=\'couponcode\"+j+\"\' value=\'\"+couponcode+\"\' > <input type=hidden name=\'couponAndAmt\"+j+\"\' id=\'couponAndAmt\"+j+\"\' value=\'\"+couponAndAmt+\"\' > <input type=hidden name=\'cc_trx_date_time\"+j+\"\' id=\'cc_trx_date_time\"+j+\"\' value=\'\"+trx_date_time+\"\' >\"); //V210113\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[3].className\t=classval;\n\t\t\tcurr_row.cells[3].WIDTH\t= \"6%\";\n\t\t\tcurr_row.cells[3].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'cash_given\"+j+\"\' id=\'cash_given\"+j+\"\'   value=\'\"+cash_given+\"\' style=\'text-align:right\'  > \");\n\t\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[4].className\t=classval;\n\t\t\tcurr_row.cells[4].WIDTH\t= \"6%\";\n\t\t\tcurr_row.cells[4].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'cash_return\"+j+\"\' id=\'cash_return\"+j+\"\'   value=\'\"+cash_return+\"\' style=\'text-align:right\'  > \");\n\t\t\t\n\t\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[5].className\t=classval;\n\t\t\tcurr_row.cells[5].WIDTH\t= \"6%\";\n\t\t\tcurr_row.cells[5].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'instref\"+j+\"\' id=\'instref\"+j+\"\'   value=\'\"+instref+\"\'  >\");\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[6].className\t=classval;\n\t\t\tcurr_row.cells[6].WIDTH\t= \"6%\";\n\t\t\tcurr_row.cells[6].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'instdate\"+j+\"\' id=\'instdate\"+j+\"\'   value=\'\"+instdate+\"\'  >\");\n\t\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[7].className\t=classval;\n\t\t\tcurr_row.cells[7].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[7].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'creditcardco\"+j+\"\' id=\'creditcardco\"+j+\"\'   value=\'\"+instremark+\"\'  >\");\n\t\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[8].className\t=classval;\n\t\t\tcurr_row.cells[8].WIDTH\t= \"10%\";\n\t\t\tcurr_row.cells[8].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'instbankname\"+j+\"\' id=\'instbankname\"+j+\"\'   value=\'\"+instbankname+\"\'  ><input type=hidden name=\'instremarkcode\"+j+\"\' id=\'instremarkcode\"+j+\"\' value=\'\"+instremarkcode+\"\' >\");\n\t\n\t\t\tc";
    private final static byte[]  _wl_block5_0Bytes = _getBytes( _wl_block5_0 );

    private final static java.lang.String  _wl_block5_1 ="ell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[9].className\t=classval;\n\t\t\tcurr_row.cells[9].WIDTH\t= \"6%\";\n\t\t\tcurr_row.cells[9].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'10\' readonly name=\'instbranch\"+j+\"\' id=\'instbranch\"+j+\"\'   value=\'\"+instbranch+\"\'  >\");\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[10].className\t=classval;\n\t\t\tcurr_row.cells[10].WIDTH\t= \"4%\";\n\t\t\tcurr_row.cells[10].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'10\' size=\'10\' readonly name=\'batchno\"+j+\"\' id=\'batchno\"+j+\"\'   value=\'\"+batchno+\"\'  >\");\n\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[11].className\t=classval;\n\t\t\tcurr_row.cells[11].WIDTH\t= \"5%\";\n\t\t\tcurr_row.cells[11].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'10\' size=\'10\' readonly name=\'apprrefno\"+j+\"\' id=\'apprrefno\"+j+\"\'   value=\'\"+apprrefno+\"\'  >\");\n\t\t\t\n\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\tcurr_row.cells[12].className\t=classval;\n\t\t\tcurr_row.cells[12].WIDTH\t= \"5%\";\n\t\t\tcurr_row.cells[12].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'10\' size=\'10\' readonly name=\'saledraftno\"+j+\"\' id=\'saledraftno\"+j+\"\'   value=\'\"+saledraftno+\"\'  >\");\n\t\t\t<!--Added by Monika for NMC-JD-CRF-0199 on 04/08/2023 -->\t\n\t\t\tif(isCCTerminalIdEnable == \"true\"){\n\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\t\tcurr_row.cells[13].className\t=classval;\n\t\t\t\tcurr_row.cells[13].WIDTH\t= \"5%\";\n\t\t\t\tcurr_row.cells[13].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'10\' size=\'10\' readonly name=\'cc_term_id_num\"+j+\"\' id=\'cc_term_id_num\"+j+\"\'   value=\'\"+cc_term_id_num+\"\'  >\");\n\t\t\t\t\n\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\t\tcurr_row.cells[14].className\t=classval;\n\t\t\t\tcurr_row.cells[14].WIDTH\t= \"6%\";\n\t\t\t\t//Appended Cash Limit as Hidden for KDAH-CRF-0339.2\n\t\t\t\t//Commented by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\t\t//curr_row.cells[14].insertAdjacentHTML(\"BeforeEnd\", \'<input type=\"text\" maxlength=\"15\" size=\"20\" readonly name=\"payername\'+j+\'\" id=\"payername\'+j+\'\"   value=\"\'+payername+\'\" ><input type=hidden name=\"ext_acc_interface_yn\'+j+\'\" id=\"ext_acc_interface_yn\'+j+\'\" value=\"\'+ext_acc_interface_yn+\'\"><input type=hidden name=\"credit_card_machine_int_yn\'+j+\'\" id=\"credit_card_machine_int_yn\'+j+\'\" value=\"\'+credit_card_machine_int_yn+\'\" ><input type=hidden name=\"Cash_check\'+j+\'\" id=\"Cash_check\'+j+\'\" value=\"\'+Cash_check+\'\" > \');\n\t\t\n\t\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\t\t//Appended cc_term_id_num, cc_trx_date_time as Hidden fields for GHL-SCF-1545\n\t\t\t\tcurr_row.cells[14].insertAdjacentHTML(\"beforeend\",\' <input type=hidden name=\"cc_trx_date_time\'+j+\'\" id=\"cc_trx_date_time\'+j+\'\" value=\"\'+trx_date_time+\'\" ><input type=\"text\" maxlength=\"15\" size=\"20\" readonly name=\"payername\'+j+\'\" id=\"payername\'+j+\'\"   value=\"\'+payername+\'\" ><input type=hidden name=\"ext_acc_interface_yn\'+j+\'\" id=\"ext_acc_interface_yn\'+j+\'\" value=\"\'+ext_acc_interface_yn+\'\"><input type=hidden name=\"credit_card_machine_int_yn\'+j+\'\" id=\"credit_card_machine_int_yn\'+j+\'\" value=\"\'+credit_card_machine_int_yn+\'\" ><input type=hidden name=\"Cash_check\'+j+\'\" id=\"Cash_check\'+j+\'\" value=\"\'+Cash_check+\'\" >\');\n\t\t\t\t\n\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\t\tcurr_row.cells[15].className\t=classval;\n\t\t\t\tcurr_row.cells[15].WIDTH\t= \"6%\";\n\t\t\t\tcurr_row.cells[15].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'20\' readonly name=\'recrefidno\"+j+\"\' id=\'recrefidno\"+j+\"\'   value=\'\"+recrefidno+\"\'  ><input type=hidden name=\'ext_acc_fac_id\"+j+\"\' id=\'ext_acc_fac_id\"+j+\"\' value=\'\"+ext_acc_fac_id+\"\' >\");\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\t\tcurr_row.cells[16].className\t=classval;\n\t\t\t\tcurr_row.cells[16].WIDTH\t= \"6%\";\n\t\t\t\tcurr_row.cells[16].insertAdjacentHTML(\"beforeend\", \"<input type=\'checkbox\' maxlength=\'30\' size=\'10\'   \"+onlineapproval+\" name=\'onlineapproval\"+j+\"\' id=\'onlineapproval\"+j+\"\' value=\'\"+onlineapproval+\"\' readonly onclick=\'check_box(\"+j+\")\'>\");\n\t\t\t}else{\n\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\t\tcurr_row.cells[13].className\t=classval;\n\t\t\t\tcurr_row.cells[13].WIDTH\t= \"6%\";\n\t\t\t\t//Appended Cash Limit as Hidden for KDAH-CRF-0339.2\n\t\t\t\t//Commented by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\t\t//curr_row.cells[13].insertAdjacentHTML(\"BeforeEnd\", \'<input type=\"text\" maxlength=\"15\" size=\"20\" readonly name=\"payername\'+j+\'\" id=\"payername\'+j+\'\"   value=\"\'+payername+\'\" ><input type=hidden name=\"ext_acc_interface_yn\'+j+\'\" id=\"ext_acc_interface_yn\'+j+\'\" value=\"\'+ext_acc_interface_yn+\'\"><input type=hidden name=\"credit_card_machine_int_yn\'+j+\'\" id=\"credit_card_machine_int_yn\'+j+\'\" value=\"\'+credit_card_machine_int_yn+\'\" ><input type=hidden name=\"Cash_check\'+j+\'\" id=\"Cash_check\'+j+\'\" value=\"\'+Cash_check+\'\" > \');\n\t\n\t\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\t\t//Appended cc_term_id_num, cc_trx_date_time as Hidden fields for GHL-SCF-1545\n\t\t\t\tcurr_row.cells[13].insertAdjacentHTML(\"beforeend\",\' <input type=hidden name=\"cc_trx_date_time\'+j+\'\" id=\"cc_trx_date_time\'+j+\'\" value=\"\'+trx_date_time+\'\" ><input type=\"text\" maxlength=\"15\" size=\"20\" readonly name=\"payername\'+j+\'\" id=\"payername\'+j+\'\"   value=\"\'+payername+\'\" ><input type=hidden name=\"ext_acc_interface_yn\'+j+\'\" id=\"ext_acc_interface_yn\'+j+\'\" value=\"\'+ext_acc_interface_yn+\'\"><input type=hidden name=\"credit_card_machine_int_yn\'+j+\'\" id=\"credit_card_machine_int_yn\'+j+\'\" value=\"\'+credit_card_machine_int_yn+\'\" ><input type=hidden name=\"Cash_check\'+j+\'\" id=\"Cash_check\'+j+\'\" value=\"\'+Cash_check+\'\" > <input type=hidden name=\"cc_term_id_num\'+j+\'\" id=\"cc_term_id_num\'+j+\'\" value=\"\'+term_id_num+\'\" >\');\n\t\t\t\t\n\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\t\tcurr_row.cells[14].className\t=classval;\n\t\t\t\tcurr_row.cells[14].WIDTH\t= \"6%\";\n\t\t\t\tcurr_row.cells[14].insertAdjacentHTML(\"beforeend\", \"<input type=\'text\' maxlength=\'15\' size=\'20\' readonly name=\'recrefidno\"+j+\"\' id=\'recrefidno\"+j+\"\'   value=\'\"+recrefidno+\"\'  ><input type=hidden name=\'ext_acc_fac_id\"+j+\"\' id=\'ext_acc_fac_id\"+j+\"\' value=\'\"+ext_acc_fac_id+\"\' >\");\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tcell\t=\tcurr_row.insertCell();\n\t\t\t\tcurr_row.cells[15].className\t=classval;\n\t\t\t\tcurr_row.cells[15].WIDTH\t= \"6%\";\n\t\t\t\tcurr_row.cells[15].insertAdjacentHTML(\"beforeend\", \"<input type=\'checkbox\' maxlength=\'30\' size=\'10\'   \"+onlineapproval+\" name=\'onlineapproval\"+j+\"\' id=\'onlineapproval\"+j+\"\' value=\'\"+onlineapproval+\"\' readonly onclick=\'check_box(\"+j+\")\'>\");\n\t\t\t}\n\t\t\trecord_select++;\n\t\t}\n\t\tformObj.total_records.value=count;\n\t\ttot_setld_amt();\n\t\t\t\n\t}\n}\n\nasync function modifyBillSlmt()\n{\n\tdocument.forms[0].doc_amt.value=\"\";\n\tvar checked_row=parent.BillSlmtTypeFrame.document.forms[0].checked_row.value;\n\tvar billdoctype=document.forms[0].billdoctype.value;\n\tvar total_amt_payable=document.forms[0].total_amt_payable.value;\n\tvar billdocnum=document.forms[0].billdocnum.value;\n\tvar blnggrp=document.forms[0].blnggrp.value;\n\tvar total_records=\"\";\n\tvar function_id=document.forms[0].function_id.value;\n\t//if(function_id==\'rcpt_rfnd\')\n\tif(function_id==\'rcpt_rfnd\' || function_id==\'PKG_BILLING\')\n\t{\n\tvar total_settled_amt=\"\";//document.forms[0].total_settled_amt.value;\n\tvar settled_amt_det=\"\";//parent.frames[0].document.forms[0].billslmtamtdet.value;\n\tvar tot_curr_stlmt=\"\";//parent.frames[1].document.forms[0].tot_curr_stlmt.value;\n\t}\n\telse{\n\t\tvar total_settled_amt=document.forms[0].total_settled_amt.value;\n\t\tvar settled_amt_det=parent.frames[0].document.forms[0].billslmtamtdet.value;\t\n\t\tvar tot_curr_stlmt=parent.frames[1].document.forms[0].tot_curr_stlmt.value;\n\t   }\n\ttotal_amt_payable=parseFloat(total_amt_payable)-parseFloat(total_settled_amt);\t\n\ttotal_records=parent.frames[2].document.forms[0].total_records.value;\t\n\n\tvar query_string=document.forms[0].query_string.value;\n\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\n\tif(total_amt_payable<0)\n\t{\n\t\ttotal_amt_payable=\'0.00\';\n\t}\n\tif(checked_row==\"\")\n\t{\t\t\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\t\t\n\telse\n\t{\n\t\tvar billslmtamt1=eval(\"parent.frames[2].document.forms[0].billslmtamt\"+checked_row);\n\t\tvar billslmtamt=billslmtamt1.value;\t\t\n\t\ttotal_amt_payable=parseFloat(total_amt_payable)+parseFloat(billslmtamt);\t\n\n\t\tvar shortdesc1=eval(\"parent.frames[2].document.forms[0].shortdesc\"+checked_row);\n\t\tvar shortdesc=shortdesc1.value;\t\t\t\n\n\t\tvar slmttype1=eval(\"parent.frames[2].document.forms[0].slmttype\"+checked_row);\n\t\tvar slmttype=slmttype1.value;\t\n\t\tvar couponcode1 = eval(\"parent.frames[2].document.forms[0].couponcode\"+checked_row); //V210113\n\t\tvar couponcode=couponcode1.value; //V210113\n\t\tvar couponAndAmt1 = eval(\"parent.frames[2].document.forms[0].couponAndAmt\"+checked_row); //V210224\n\t\tvar couponAndAmt=couponAndAmt1.value; //V210224\t\t\n\t\t/*if(slmttype==\'CCA\')\n\t\t{\n\t\t\talert(\"credit card transaction can not modify\");\n\t\t\treturn false;\n\t\t}*/\n\t\t\n\t\t\n\t\tvar cash_given1=eval(\"parent.frames[2].document.forms[0].cash_given\"+checked_row);\n\t\tvar cash_given=cash_given1.value;\t\t\n\n\t\tvar cash_return1=eval(\"parent.frames[2].document.forms[0].cash_return\"+checked_row);\n\t\tvar cash_return=cash_return1.value;\t\t\n\n\t\tvar instref1=eval(\"parent.frames[2].document.forms[0].instref\"+checked_row);\n\t\tvar instref=instref1.value;\t\t\t\n\n\t\tvar instdate1=eval(\"parent.frames[2].document.forms[0].instdate\"+checked_row);\n\t\tvar instdate=instdate1.value;\t\t\n\n\t\tvar creditcardco1=eval(\"parent.frames[2].document.forms[0].creditcardco\"+checked_row);\n\t\tvar creditcardco=creditcardco1.value;\t\t\n\t\t\n\t\tvar instbankname1=eval(\"parent.frames[2].document.forms[0].instbankname\"+checked_row);\n\t\tvar instbankname=instbankname1.value;\t\n\t\t\n\t\tvar instbranch1=eval(\"parent.frames[2].document.forms[0].instbranch\"+checked_row);\n\t\tvar instbranch=instbranch1.value;\t\n\t\tinstbranch = encodeURIComponent(instbranch);\n\t\t\n\t\tvar instremarkcode1=\teval(\"parent.frames[2].document.forms[0].instremarkcode\"+checked_row);\n\t\tvar instremarkcode=instremarkcode1.value;\t\t\t\n\n\t\tvar batchno1=eval(\"parent.frames[2].document.forms[0].batchno\"+checked_row);\n\t\tvar batchno=batchno1.value;\t\t\t\n\n\t\tvar apprrefno1=eval(\"parent.frames[2].document.forms[0].apprrefno\"+checked_row);\n\t\tvar apprrefno=apprrefno1.value;\t\t\t\n\n\t\tvar saledraftno1=eval(\"parent.frames[2].document.forms[0].saledraftno\"+checked_row);\n\t\tvar saledraftno=saledraftno1.value;\t\t\t\t\t\n\n\t\tvar payername1=eval(\"parent.frames[2].document.forms[0].payername\"+checked_row);\n\t\tvar payername=payername1.value;\t\t\t\t\n\n\t\tvar recrefidno1=eval(\"parent.frames[2].document.forms[0].recrefidno\"+checked_row);\n\t\tvar recrefidno=recrefidno1.value;\t\t\t\n\n\t\tvar onlineapproval1=eval(\"parent.frames[2].document.forms[0].onlineapproval\"+checked_row);\n\t\tvar onlineapproval=\"\";\n\n\t\tvar credit_card_machine_int_yn = eval(\"parent.frames[2].document.forms[0].credit_card_machine_int_yn\"+checked_row);\n\n\t\t//Added for KDAH-CRF-0339.2\n\t\tvar Cash_check = eval(\"parent.frames[2].document.forms[0].Cash_check\"+checked_row);\n\t\tif(onlineapproval1.checked)\n\t\t{\t\t\t\n\t\t\tonlineap";
    private final static byte[]  _wl_block5_1Bytes = _getBytes( _wl_block5_1 );

    private final static java.lang.String  _wl_block5_2 ="proval=\"checked\";\n\t\t\t//alert(\"cc transaction can not be modified\");\n\t\t\tif(credit_card_machine_int_yn.value == \"Y\")\n\t\t\t{\n\t\t\t\talert(getMessage(\"BL9888\",\"BL\"));\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\t\t\t\n\t\t\tonlineapproval=\"\";\n\t\t}\n\t\t \n\t\tvar ext_acc_interface_yn1=eval(\"parent.frames[2].document.forms[0].ext_acc_interface_yn\"+checked_row);\n\t\tvar ext_acc_interface_yn=ext_acc_interface_yn1.value;\t\t\t\n\n\t\tvar ext_acc_fac_id1=eval(\"parent.frames[2].document.forms[0].ext_acc_fac_id\"+checked_row);\n\t\tvar ext_acc_fac_id=ext_acc_fac_id1.value;\t\t\n\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t\t\t\t\t\n\t\tvar term_id_num1=eval(\"parent.frames[2].document.forms[0].cc_term_id_num\"+checked_row);\n\t\tvar term_id_num=term_id_num1.value;\t\t\n\t\t\t\t\t\n\t\tvar trx_date_time1=eval(\"parent.frames[2].document.forms[0].cc_trx_date_time\"+checked_row);\n\t\tvar trx_date_time=trx_date_time1.value;\t\n\t/*Added by Rajesh for KDAH-CRF-0339.2*/\n\tvar restrictEligibility = document.forms[0].restrictEligibility.value;\n\tCash_checklimit = 0;\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tif(eval(\"parent.frames[2].document.forms[0].Cash_check\"+j).value == \'Y\' && j!=checked_row){\n\t\t\tvar Cash_slmtAmt=eval(\"parent.frames[2].document.forms[0].billslmtamt\"+j).value;\n\t\t\tCash_checklimit = parseFloat(Cash_checklimit)+parseFloat(Cash_slmtAmt);\n\t\t}\t\t\t\n\t}\t\n\t/*Added by Rajesh for KDAH-CRF-0339.2*/\n\tvar action=\"modify\";\n\tvar retVal\t\t\t= new String();\n\tvar center=\'1\';\n\tvar dialogTop = \"0vh\";\n\tvar dialogHeight = \"65vh\" ;\n\tvar dialogWidth = \"58vw\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar title=encodeURIComponent(getLabel(\"eBL.MODI_BILL_SLMT_DTL.label\",\"BL\"));\n\t//title=encodeURIComponent(title);\t\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\t//var param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billslmtamt=\"+billslmtamt+\"&\"+\"shortdesc=\"+shortdesc+\"&\"+\"slmttype=\"+slmttype+\"&\"+\"cash_given=\"+cash_given+\"&\"+\"cash_return=\"+cash_return+\"&\"+\"instref=\"+instref+\"&\"+\"instdate=\"+instdate+\"&\"+\"creditcardco=\"+creditcardco+\"&\"+\"instbankname=\"+instbankname+\"&\"+\"instbranch=\"+instbranch+\"&\"+\"batchno=\"+batchno+\"&\"+\"apprrefno=\"+apprrefno+\"&\"+\"saledraftno=\"+saledraftno+\"&\"+\"payername=\"+encodeURIComponent(payername)+\"&\"+\"recrefidno=\"+recrefidno+\"&\"+\"onlineapproval=\"+onlineapproval+\"&\"+\"action=\"+action+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"instremarkcode=\"+instremarkcode+\"&\"+\"total_amt_payable=\"+total_amt_payable+\"&\"+\"settled_amt_det=\"+settled_amt_det+\"&\"+\"total_settled_amt=\"+total_settled_amt+\"&\"+\"ext_acc_interface_yn=\"+ext_acc_interface_yn+\"&\"+\"ext_acc_fac_id=\"+ext_acc_fac_id+\"&\"+\"Cash_checklimit=\"+Cash_checklimit+\"&\"+\"restrictEligibility=\"+restrictEligibility+\"&\"+query_string+\"&couponcode=\"+couponcode; //V210113\n\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billslmtamt=\"+billslmtamt+\"&\"+\"shortdesc=\"+shortdesc+\"&\"+\"slmttype=\"+slmttype+\"&\"+\"cash_given=\"+cash_given+\"&\"+\"cash_return=\"+cash_return+\"&\"+\"instref=\"+instref+\"&\"+\"instdate=\"+instdate+\"&\"+\"creditcardco=\"+creditcardco+\"&\"+\"instbankname=\"+instbankname+\"&\"+\"instbranch=\"+instbranch+\"&\"+\"batchno=\"+batchno+\"&\"+\"apprrefno=\"+apprrefno+\"&\"+\"saledraftno=\"+saledraftno+\"&\"+\"payername=\"+encodeURIComponent(payername)+\"&\"+\"recrefidno=\"+recrefidno+\"&\"+\"onlineapproval=\"+onlineapproval+\"&\"+\"action=\"+action+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"instremarkcode=\"+instremarkcode+\"&\"+\"total_amt_payable=\"+total_amt_payable+\"&\"+\"settled_amt_det=\"+settled_amt_det+\"&\"+\"total_settled_amt=\"+total_settled_amt+\"&\"+\"ext_acc_interface_yn=\"+ext_acc_interface_yn+\"&\"+\"ext_acc_fac_id=\"+ext_acc_fac_id+\"&\"+\"Cash_checklimit=\"+Cash_checklimit+\"&\"+\"restrictEligibility=\"+restrictEligibility+\"&\"+\"cc_term_id_num=\"+term_id_num+\"&\"+\"cc_trx_date_time=\"+trx_date_time+\"&\"+query_string+\"&couponcode=\"+couponcode+\"&couponAndAmt=\"+couponAndAmt; //V210113//V210224\n\t\n\tretVal= await window.showModalDialog(\"../../eBL/jsp/BLBillSlmtMain2.jsp?\"+param,arguments,features);\n\t\tvar formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;\n\t\ttotal_records=formObj.total_records.value;\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\n\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\ttemp.checked=false;\n\t\t}\n\t\tif(retVal!=null)\n\t\t{\n\t\tvar arr=new Array();\n\t\tif(retVal == null) retVal=\'\';\n\t\tif (retVal != null || retVal!=\"\")\n\t\t{\n\t\t\tvar retVal=unescape(retVal);\t\t\t\t\t  \n\t\t\tif(retVal != null && retVal.length>0)\n\t\t\t{\n\t\t\t\t//var formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;\n\t\t\t\tarr=retVal.split(\"::\");\t\n\t\t\t\tvar billslmtamt1=eval(\"parent.frames[2].document.forms[0].billslmtamt\"+checked_row);\n\t\t\t\tif(arr[3]==\" \")arr[3]=\"\";\n\t\t\t\tbillslmtamt1.value=arr[3];\n\t\t\t\tvar shortdesc1=eval(\"parent.frames[2].document.forms[0].shortdesc\"+checked_row);\n\t\t\t\tif(arr[21]==\" \")arr[21]=\"\";\n\t\t\t\tshortdesc1.value=arr[21];\n\t\t\t\tvar slmttype1=eval(\"parent.frames[2].document.forms[0].slmttype\"+checked_row);\n\t\t\t\tif(arr[4]==\" \")arr[4]=\"\";\n\t\t\t\tslmttype1.value=arr[4];\n\t\t\t\tvar instref1=eval(\"parent.frames[2].document.forms[0].instref\"+checked_row);\n\t\t\t\tif(arr[9]==\" \")arr[9]=\"\";\n\t\t\t\tinstref1.value=arr[9];\n\t\t\t\tvar instdate1=eval(\"parent.frames[2].document.forms[0].instdate\"+checked_row);\n\t\t\t\tif(arr[10]==\" \")arr[10]=\"\";\n\t\t\t\tinstdate1.value=arr[10];\t\n\n\t\t\t\tvar creditcardco1=eval(\"parent.frames[2].document.forms[0].creditcardco\"+checked_row);\n\t\t\t\tif(arr[11]==\" \")arr[11]=\"\";\n\t\t\t\tcreditcardco1.value=arr[11];\n\n\t\t\t\tvar instbankname1=eval(\"parent.frames[2].document.forms[0].instbankname\"+checked_row);\n\t\t\t\tif(arr[18]==\" \")arr[18]=\"\";\n\t\t\t\tinstbankname1.value=arr[18];\n\t\t\t\t\n\t\t\t\t//added by nandhini against ghl-scf-1600\n\t\t\t\tvar instbranch=eval(\"parent.frames[2].document.forms[0].instbranch\"+checked_row);\n\t\t\t\tif(arr[12]==\" \")arr[12]=\"\";\n\t\t\t\tinstbranch.value=arr[12];\n\n\t\t\t\tvar batchno1=eval(\"parent.frames[2].document.forms[0].batchno\"+checked_row);\n\t\t\t\tif(arr[14]==\" \")arr[14]=\"\";\n\t\t\t\tbatchno1.value=arr[14];\n\t\t\t\t\n\t\t\t\tvar apprrefno1=eval(\"parent.frames[2].document.forms[0].apprrefno\"+checked_row);\n\t\t\t\tif(arr[15]==\" \")arr[15]=\"\";\n\t\t\t\tapprrefno1.value=arr[15];\n\n\t\t\t\tvar saledraftno1=eval(\"parent.frames[2].document.forms[0].saledraftno\"+checked_row);\n\t\t\t\tif(arr[16]==\" \")arr[16]=\"\";\n\t\t\t\tsaledraftno1.value=arr[16];\n\n\n\t\t\t\tvar instremarkcode1=eval(\"parent.frames[2].document.forms[0].instremarkcode\"+checked_row);\n\t\t\t\tif(arr[22]==\" \")arr[22]=\"\";\n\t\t\t\tinstremarkcode1.value=arr[22];\n\t\t\t\t\n\t\t\t\tvar payername1=eval(\"parent.frames[2].document.forms[0].payername\"+checked_row);\n\t\t\t\tif(arr[5]==\" \")arr[5]=\"\";\n\t\t\t\tpayername1.value=arr[5];\n\n\t\t\t\tvar recrefidno1=eval(\"parent.frames[2].document.forms[0].recrefidno\"+checked_row);\n\t\t\t\tif(arr[6]==\" \")arr[6]=\"\";\n\t\t\t\trecrefidno1.value=arr[6];\n\t\t\t\t\n\t\t\t\tvar cash_given1=eval(\"parent.frames[2].document.forms[0].cash_given\"+checked_row);\n\t\t\t\tif(arr[19]==\" \")arr[19]=\"\";\n\t\t\t\tcash_given1.value=arr[19];\t\t\t\n\n\t\t\t\tvar cash_return1=eval(\"parent.frames[2].document.forms[0].cash_return\"+checked_row);\n\t\t\t\tif(arr[20]==\" \")arr[20]=\"\";\n\t\t\t\tcash_return1.value=arr[20];\t\n\t\t\t\t\n\t\t\t\tvar onlineapproval1=eval(\"parent.frames[2].document.forms[0].onlineapproval\"+checked_row);\n\t\t\t\tif(arr[13]==\" \")arr[13]=\"\";\n\t\t\t\tonlineapproval1.value=arr[13];\t\t\t\t\t\n\t\t\t\tvar ckcbflag=arr[13];\n\t\t\t\tif(ckcbflag==\"checked\")\n\t\t\t\t{\t\n\t\t\t\t\tonlineapproval1.checked=true;\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\tonlineapproval1.checked=false;\n\t\t\t\t}\n\n\t\t\t\tvar ext_acc_interface_yn1=eval(\"parent.frames[2].document.forms[0].ext_acc_interface_yn\"+checked_row);\n\t\t\t\tif(arr[7]==\" \")arr[7]=\"\";\n\t\t\t\text_acc_interface_yn1.value=arr[7];\t\n\n\t\t\t\tvar ext_acc_fac_id1=eval(\"parent.frames[2].document.forms[0].ext_acc_fac_id\"+checked_row);\n\t\t\t\tif(arr[8]==\" \")arr[8]=\"\";\n\t\t\t\text_acc_fac_id1.value=arr[8];\t\n\t\t\t\t\n\t\t\t\tvar credit_card_machine_int_yn = eval(\"parent.frames[2].document.forms[0].credit_card_machine_int_yn\"+checked_row);\n\t\t\t\tif(arr[24] == \" \") arr[24]=\"\";\n\t\t\t\tcredit_card_machine_int_yn.value = arr[24];\n\t\t\t\t\n\t\t\t\t//Added for KDAH-CRF-0339.2\n\t\t\t\tvar Cash_check = eval(\"parent.frames[2].document.forms[0].Cash_check\"+checked_row);\n\t\t\t\tif(arr[25] == \" \") arr[25]=\"\";\n\t\t\t\tCash_check.value = arr[25];\n\t\t\t\t\n\t\t\t\t//Added by Sethu for GHL-SCF-1545 on 11/01/2021-->\n\n\t\t\t\tvar term_id_num = eval(\"parent.frames[2].document.forms[0].cc_term_id_num\"+checked_row);\n\t\t\t\tif(arr[26] == \" \") arr[26]=\"\";\n\t\t\t\tterm_id_num.value = arr[26];\n\n\t\t\t\tvar trx_date_time = eval(\"parent.frames[2].document.forms[0].cc_trx_date_time\"+checked_row);\n\t\t\t\tif(arr[27] == \" \") arr[27]=\"\";\n\t\t\t\ttrx_date_time.value = arr[27];\n\n\t\t\t\t//V210113 start\n\t\t\t\tvar couponcode = eval(\"parent.frames[2].document.forms[0].couponcode\"+checked_row);\n\t\t\t\tif(arr[28] == \"\") arr[28]=\"\";\n\t\t\t\tcouponcode.value = arr[28];\n\t\t\t\t//V210113 end\n\t\t\t\t\n\t\t\t\t//V210224 start\n\t\t\t\tvar patMembershipID = document.forms[0].patMembershipID.value;\n\t\t\t\tif(arr[29] == \"\") arr[29] =\"\";\n\t\t\t\tpatMembershipID.value = arr[29];\n\t\t\t\t\n\t\t\t\tvar couponAndAmt = eval(\"parent.frames[2].document.forms[0].couponAndAmt\"+checked_row);\n\t\t\t\tif(arr[30] == \"\") arr[30] =\"\";\t\n\t\t\t\tcouponAndAmt.value = arr[30];\n\t\t\t\t//V210224 end\n\t\t\t}\n\t\t}\n\t\t}\n\t\t\ttot_setld_amt();\n\t}\n\tparent.frames[2].document.forms[0].checked_row.value=\"\";\n}\n\nfunction tot_setld_amt()\n{\n\tvar total_settled=0.0;\t\n\tvar tot_setl=\"\";\n\tvar a1=new Array();\n\tvar\ttotalRecords =parent.frames[2].document.forms[0].total_records.value;\n\tvar decimal=document.forms[0].noofdecimal.value;\n\tfor(var i=0;i<totalRecords;i++)\n\t{\n\t  tot_setl=eval(\"parent.frames[2].document.forms[0].billslmtamt\"+i);\n\t  a1[i]=tot_setl.value;\n\t  if(a1[i]==\"\"){a1[i]=\"0.0\";}\n\t  total_settled=parseFloat(total_settled) + parseFloat(a1[i]);\t  \n\t}\t\n\n/*\n\ttotal_settled = Math.round(total_settled*Math.pow(10,decimal))/Math.pow(10,decimal);\n\tdocument.forms[0].total_settled_amt.value=total_settled;\n*/\n\n//\ttotal_settled = roundNumber(total_settled,decimal);\n\ttotal_settled = total_settled.toFixed(decimal);\n\tif(document.forms[0].doc_amt.value!=\"\")\n\t{\t\t\n\t\tdocument.forms[0].total_settled_amt.value=document.forms[0].doc_amt.value;\t\n\t}else{\n\tdocument.forms[0].total_settled_amt.value=total_settled;\n\t}\n\n\tvar temp_total_settled=eval(\"document.forms[0].total_settled_amt\");\n\tputdeci(temp_total_settled);\n\t/*var v_set_amt=parent.frames[0].document.forms[0].billslmtamtdet.value;\n\tif(parseFloat(temp_total_settled.value)==parseFloat(v_set_amt))\n\t{\n\t\tparent.frames[0].document.forms[0].billslmtamtdet.readOnly=true;\n\t}*/\n}\n\nfunction putdeci(object)\n{\t\n\tif(object.value!=\'\')\n\t{\n\tvar decimal=document.forms[0].noofdecimal.value;\n\tputDecimal(object,17,decimal);\n\t}\n}\n\nfunction removeBillSlmt()\n{\n\t\n\n\tvar checked_row=parent.BillSlmtTypeFrame.document.forms[0].checked_row.v";
    private final static byte[]  _wl_block5_2Bytes = _getBytes( _wl_block5_2 );

    private final static java.lang.String  _wl_block5_3 ="alue;\t\n\t\n\t\t\t\t// \tGHL-CRF-0366.1 Karthik added the below code for Credit Card Integration \t\n\tvar credit_card_payment_suceeded = eval(\"parent.frames[2].document.forms[0].credit_card_machine_int_yn\"+checked_row);\n\tif(credit_card_payment_suceeded!=null && credit_card_payment_suceeded.value == \"Y\")\n\t\t{\n\t\t\talert(\" Credit Card Transcation Suceeded. Record Cannot be Deleted\");\n\t\t\treturn false;\n\t\t}\n\t\t\t\t//\tGHL-CRF-0366.1 Karthik added the below code for Credit Card Integration \n\t\n\t\n\tvar billdoctype=document.forms[0].billdoctype.value;\n\tvar billdocnum=document.forms[0].billdocnum.value;\n\tvar blnggrp=document.forms[0].blnggrp.value;\n\tvar query_string=document.forms[0].query_string.value;\n\tvar formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;\n\tvar total_records=\"\";\n\t//total_records=parent.frames[2].document.forms[0].total_records.value;\t\n\ttotal_records=formObj.total_records.value;\t\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\tif(checked_row==\"\")\n\t{\t\t\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\n\telse\n\t{\n\t\tif(confirm(getMessage(\"DELETE_RECORD\",\"common\"))) //BL9760\n\t\t{  \n\t\t\t//V210113 start\n\t\t\tvar patientID =document.forms[0].strpatientid.value;\n\t\t\tvar LoggedUser =document.forms[0].struser.value;\n\t\t\tvar clientIpAddress =document.forms[0].strClientIpAddress.value;\n\t\t\tvar couponobj =parent.frames[3].document.forms[0].couponcode;\n\t\t\tvar coupon = couponobj.value;\n\t\t\tvar transactionid=\'\';\t\n\t\t\t//V210211 modified\t\t\t\t\n\t\t\tif (coupon != \"undefined\" && coupon != undefined && coupon != \"\" ) {\n\t\t\t\tif(confirm(getMessage(\"BL0924\",\"BLEXT\"))) //BL9760\n\t\t\t\t{\t\n\t\t\t\t\tvar NuhdeekResponse = NuhdeekTransactions(\'RELEASE\',patientID,coupon,transactionid, LoggedUser, clientIpAddress);\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar NuhdeekResponseArr = NuhdeekResponse.split(\"$!^\");\t\t\n\t\t\t\t\tif (NuhdeekResponseArr[0] == \'S\') {\t\t\t\t\t\t\t\n\t\t\t\t\t} else if (NuhdeekResponseArr[0]==\'E\') {\n\t\t\t\t\t\t\talert(NuhdeekResponseArr[4]);\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t} //V210113 end\n\t\t\t\t}else {\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\ttotalRecords =eval(formObj.total_records.value);\n\t\t\tparent.frames[2].document.forms[0].action=\"../../eBL/jsp/BLBillSlmtType.jsp?remove_check=remove&\"+\"&checked_row=\"+checked_row+\"&total_records=\"+totalRecords+\"&\"+query_string;\n\t\t\tparent.frames[2].document.forms[0].submit();\t\n\t\t\t//V210211 end\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\t\t\t\n\t\t}\n\t}\n\tfor(var j=0;j<total_records;j++)\n\t{\n\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\ttemp.checked=false;\n\t}\n\tparent.frames[2].document.forms[0].checked_row.value=\"\";\n}\n\n\n/*function removeBillSlmt()\n{\n\tvar \n\tchecked_row=parent.BillSlmtTypeFrame.document.forms[0].checked_row.value;\n\tvar billdoctype=document.forms[0].billdoctype.value;\n\tvar billdocnum=document.forms[0].billdocnum.value;\n\tvar blnggrp=document.forms[0].blnggrp.value;\n\tvar query_string=document.forms[0].query_string.value;\n\tvar total_records=\"\";\n\ttotal_records=parent.frames[2].document.forms[0].total_records.value;\t\n\tif(total_records==0)\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\treturn false;\n\t}\n\tif(checked_row==\"\")\n\t{\t\t\n\t\talert(getMessage(\"ATLEAST_ONE_SELECTED\",\"common\"));\n\t}\t\t\n\telse\n\t{\n\t\tvar billslmtamt1=eval(\"parent.frames[2].document.forms[0].billslmtamt\"+checked_row);\n\t\tvar billslmtamt=billslmtamt1.value;\t\t\n\t\t\n\t\tvar shortdesc1=eval(\"parent.frames[2].document.forms[0].shortdesc\"+checked_row);\n\t\tvar shortdesc=shortdesc1.value;\t\t\t\n\n\t\tvar slmttype1=eval(\"parent.frames[2].document.forms[0].slmttype\"+checked_row);\n\t\tvar slmttype=slmttype1.value;\t\t\t\n\t\t\n\t\tvar cash_given1=eval(\"parent.frames[2].document.forms[0].cash_given\"+checked_row);\n\t\tvar cash_given=cash_given1.value;\t\t\n\n\t\tvar cash_return1=eval(\"parent.frames[2].document.forms[0].cash_return\"+checked_row);\n\t\tvar cash_return=cash_return1.value;\t\t\n\n\t\tvar instref1=eval(\"parent.frames[2].document.forms[0].instref\"+checked_row);\n\t\tvar instref=instref1.value;\t\t\t\n\n\t\tvar instdate1=eval(\"parent.frames[2].document.forms[0].instdate\"+checked_row);\n\t\tvar instdate=instdate1.value;\t\t\n\n\t\tvar creditcardco1=eval(\"parent.frames[2].document.forms[0].creditcardco\"+checked_row);\n\t\tvar creditcardco=creditcardco1.value;\t\t\n\t\t\n\t\tvar instbankname1=eval(\"parent.frames[2].document.forms[0].instbankname\"+checked_row);\n\t\tvar instbankname=instbankname1.value;\t\n\t\t\n\t\tvar instbranch1=eval(\"parent.frames[2].document.forms[0].instbranch\"+checked_row);\n\t\tvar instbranch=instbranch1.value;\t\n\t\t\n\t\tvar instremarkcode1=\teval(\"parent.frames[2].document.forms[0].instremarkcode\"+checked_row);\n\t\tvar instremarkcode=instremarkcode1.value;\t\t\t\n\n\t\tvar batchno1=eval(\"parent.frames[2].document.forms[0].batchno\"+checked_row);\n\t\tvar batchno=batchno1.value;\t\t\t\t\n\n\t\tvar apprrefno1=eval(\"parent.frames[2].document.forms[0].apprrefno\"+checked_row);\n\t\tvar apprrefno=apprrefno1.value;\t\t\t\n\n\t\tvar saledraftno1=eval(\"parent.frames[2].document.forms[0].saledraftno\"+checked_row);\n\t\tvar saledraftno=saledraftno1.value;\t\t\t\n\n\t\tvar payername1=eval(\"parent.frames[2].document.forms[0].payername\"+checked_row);\n\t\tvar payername=payername1.value;\t\t\t\t\n\n\t\tvar recrefidno1=eval(\"parent.frames[2].document.forms[0].recrefidno\"+checked_row);\n\t\tvar recrefidno=recrefidno1.value;\t\t\t\n\n\t\tvar onlineapproval1=eval(\"parent.frames[2].document.forms[0].onlineapproval\"+checked_row);\n\t\tvar onlineapproval=\"\";\n\t\tif(onlineapproval1.checked)\n\t\t{\n\t\tonlineapproval=\"checked\";\n\t\t}else{\n\t\t\tonlineapproval=\"\";\n\t\t }\n\n\t\t  var ext_acc_interface_yn1=eval(\"parent.frames[2].document.forms[0].ext_acc_interface_yn\"+checked_row);\n\t\tvar ext_acc_interface_yn=ext_acc_interface_yn1.value;\t\t\t\n\n\t\tvar ext_acc_fac_id1=eval(\"parent.frames[2].document.forms[0].ext_acc_fac_id\"+checked_row);\n\t\tvar ext_acc_fac_id=ext_acc_fac_id1.value;\t\n\t\t\n\t\tvar action=\"remove\";\n\t\tvar retVal\t\t\t= new String();\n\t\tvar center=\'1\';\n\t\tvar dialogTop = \"200\";\n\t\tvar dialogHeight = \"18\" ;\n\t\tvar dialogWidth = \"50\" ;\n\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar title=encodeURIComponent(getLabel(\"eBL.REMOVE_BILL_SLMT_DTL.label\",\"BL\"));\n\t\t//title=encodeURIComponent(title);\t\n\t\tvar arguments = \"\" ;\n\t\tvar column_sizes = escape(\"\");               \n\t\tvar column_descriptions =\"\";\t\n\n\t\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billslmtamt=\"+billslmtamt+\"&\"+\"shortdesc=\"+shortdesc+\"&\"+\"slmttype=\"+slmttype+\"&\"+\"cash_given=\"+cash_given+\"&\"+\"cash_return=\"+cash_return+\"&\"+\"instref=\"+instref+\"&\"+\"instdate=\"+instdate+\"&\"+\"creditcardco=\"+creditcardco+\"&\"+\"instbankname=\"+instbankname+\"&\"+\"instbranch=\"+instbranch+\"&\"+\"batchno=\"+batchno+\"&\"+\"apprrefno=\"+apprrefno+\"&\"+\"saledraftno=\"+saledraftno+\"&\"+\"payername=\"+encodeURIComponent(payername)+\"&\"+\"recrefidno=\"+recrefidno+\"&\"+\"onlineapproval=\"+onlineapproval+\"&\"+\"blnggrp=\"+blnggrp+\"&\"+\"instremarkcode=\"+instremarkcode+\"&\"+\"action=\"+action+\"&\"+\"ext_acc_interface_yn=\"+ext_acc_interface_yn+\"&\"+\"ext_acc_interface_yn=\"+ext_acc_interface_yn+\"&\"+query_string;\n\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLBillSlmtMain2.jsp?\"+param,arguments,features);\n\t\tvar formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;\n\t\t\ttotal_records=formObj.total_records.value;\n\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t\tvar temp=eval(\"formObj.selected_row\"+j);\n\t\t\t\ttemp.checked=false;\n\t\t\t}\n\t\n\t\t\tif(\tretVal!=null)\n\t\t\t{\n\t\t\t\tvar ret_val=retVal;\n\t\t\t\tif(ret_val==\"remove\")\n\t\t\t\t{\t\n\t\t\t\t\t\ttotalRecords =eval(formObj.total_records.value);\t\t\t\t\tparent.frames[2].document.forms[0].action=\"../../eBL/jsp/BLBillSlmtType.jsp?remove_check=remove&\"+\"&checked_row=\"+checked_row+\"&total_records=\"+totalRecords+\"&\"+query_string;\n\t\t\t\t\t\tparent.frames[2].document.forms[0].submit();\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\t//alert(\"closed\");\n\t\t\t}\n\t\t}\n\t\tparent.frames[2].document.forms[0].checked_row.value=\"\";\n\t}*/\n\nfunction billslmtprocess1()\n{\n\tvar v_services_tot_records=parent.frames[1].document.forms[0].total_records.value;\n\tvar rtnArray1=\"\";\n\tvar rtnArray2=\"\";\n\tvar rtnArrayDt=\"\";\n\tvar rtnArrayDocref=\"\";\n\tvar rtnArrayDocrefLine=\"\";\n\tvar rtnArrayDocrefSeq=\"\";\n\tvar rtnBlngServCode=\"\";\n\tvar roundingamt=\"\";\n\tvar rtnUpdNetChrgAmt=\"\";\n\tvar rtnUpdGrossChrgAmt=\"\";\n\tvar rtnPrtGrpLineCode=\"\";\n\tvar rtnPrtGrpHdrCode=\"\";\n\tvar rtnTrxDate=\"\";\n\n\tvar a1=new Array();\n\tvar a2=new Array();\n\tvar a3=new Array();\n\tvar a4=new Array();\n\tvar a5=new Array();\n\tvar a6=new Array();\n\tvar a7=new Array();\n\tvar a8=new Array();\n\tvar a9=new Array();\n\tvar a10=new Array();\n\tvar a11=new Array();\n\tvar a12=new Array();\n\tvar tot_rec_for_serv_insert=0;\n\t//alert(\"v_services_tot_records:\"+v_services_tot_records);\n\tfor(var i=0;i<v_services_tot_records;i++)\n\t {\t\t\t\t\n\t\t\n\t\tvar v_curr_slmt=eval(\"parent.frames[1].document.forms[0].curr_set\"+i);\n\t\tif(v_curr_slmt.value!=0 )\n\t\t {\n\t\t\ttot_rec_for_serv_insert=eval(tot_rec_for_serv_insert)+1;\n\t\t\ta1[i]=v_curr_slmt.value;\n\t\t\tif(a1[i]==\"\")a1[i]=\" \";\n\t\t\trtnArray1=rtnArray1+a1[i]+\"|\";\n\t\t\t//alert(rtnArray1);\n\t\t\tvar v_pend_amt=eval(\"parent.frames[1].document.forms[0].pend_set\"+i);\t\t\t\t\t\t\t\t\t\n\t\t\ta2[i]=v_pend_amt.value;\n\t\t\tif(a2[i]==\"\")a2[i]=\" \";\t\t\t\t\t\n\t\t\trtnArray2=rtnArray2+a2[i]+\"|\";\n\t\t\t//alert(rtnArray2);\n\t\t\tvar v_service_date=eval(\"parent.frames[1].document.forms[0].service_date\"+i);\n\t\t\ta3[i]=v_service_date.value;\n\t\t\tif(a3[i]==\"\")a3[i]=\" \";\t\t\t\t\t\n\t\t\trtnArrayDt=rtnArrayDt+a3[i]+\"|\";\n\t\t\t//alert(rtnArrayDt);\n\t\t\tvar v_trx_doc_ref=eval(\"parent.frames[1].document.forms[0].trx_doc_ref\"+i);\n\t\t\ta4[i]=v_trx_doc_ref.value;\n\t\t\tif(a4[i]==\"\")a4[i]=\" \";\t\t\t\t\t\n\t\t\trtnArrayDocref=rtnArrayDocref+a4[i]+\"|\";\n\t\t\tvar v_trx_doc_ref_line_num=eval(\"parent.frames[1].document.forms[0].trx_doc_ref_line_num\"+i);\n\t\t\ta5[i]=v_trx_doc_ref_line_num.value;\n\t\t\tif(a5[i]==\"\")a5[i]=\" \";\t\t\t\t\t\n\t\t\trtnArrayDocrefLine=rtnArrayDocrefLine+a5[i]+\"|\";\n\t\t\tvar v_trx_doc_ref_seq_num=eval(\"parent.frames[1].document.forms[0].trx_doc_ref_seq_num\"+i);\n\t\t\ta6[i]=v_trx_doc_ref_seq_num.value;\n\t\t\tif(a6[i]==\"\")a6[i]=\" \";\t\t\t\t\t\n\t\t\trtnArrayDocrefSeq=rtnArrayDocrefSeq+a6[i]+\"|\";\n\t\t\tvar v_billing_service_code=eval(\"parent.frames[1].document.forms[0].billing_service\"+i);\n\t\t\ta7[i]=v_billing_service_code.value;\n\t\t\tif(a7[i]==\"\")a7[i]=\" \";\t\t\t\t\t\n\t\t\trtnBlngServCode=rtnBlngServCode+a7[i]+\"|\";\n\t\t\tvar v_trx_date=eval(\"parent.frames[1].document.forms[0].trx_date\"+i);\n\t\t\ta8[i]=v_trx_date.value;\n\t\t\tif(a8[i]==\"\")a8[i]=\" \";\t\t\t\t\t\n\t\t\trtnTrxDate=rtnTrxDate+a8[i]+\"|\";\n\t\t\tvar v_prt_grp_hdr_code=eval(\"parent.frames[1].document.forms[0].prt_grp_hdr_code\"+i);\n\t\t\ta9[i]=v_prt_grp_hdr_code.value;\n\t\t\tif(a9[i]==\"\")a9[i]=\" \";\t\t\t\t\t\n\t\t\trtnPrtGrpHdrCode=rtnPrtGrpHdrCode+a9[i]+\"|\";\n\t\t\tvar v_prt_grp_line_code=eval(\"parent.frames[1].document.forms[0].prt_grp_line_code\"+i);\n\t\t\ta10[i]=v_prt_grp_line_code.value;\n\t\t\tif(a10[i]==\"\")a10[i]=\" \";\t\t\t\t\t\n\t\t\trtnPrtGrpLineCode=rtnPrtGrpLineCode+a10[i]+\"|\";\n\t\t\tvar v_upd_net_charge_amt=eval(\"parent.frames[";
    private final static byte[]  _wl_block5_3Bytes = _getBytes( _wl_block5_3 );

    private final static java.lang.String  _wl_block5_4 ="1].document.forms[0].upd_net_charge_amt\"+i);\n\t\t\ta12[i]=v_upd_net_charge_amt.value;\n\t\t\tif(a12[i]==\"\")a12[i]=\" \";\t\t\t\t\t\n\t\t\trtnUpdNetChrgAmt=rtnUpdNetChrgAmt+a12[i]+\"|\";\n\t\t\tvar v_upd_gross_charge_amt=eval(\"parent.frames[1].document.forms[0].upd_gross_charge_amt\"+i);\n\t\t\ta11[i]=v_upd_gross_charge_amt.value;\n\t\t\tif(a11[i]==\"\")a11[i]=\" \";\t\t\t\t\t\n\t\t\trtnUpdGrossChrgAmt=rtnUpdGrossChrgAmt+a11[i]+\"|\";\n\t\t}\n\t}\n\t\tvar v_roundingamt = eval(\"parent.frames[1].document.forms[0].round_off\");\n\t\troundingamt = v_roundingamt.value;\n\n\n\tparent.frames[2].document.forms[0].rtnCurrSlmt.value=rtnArray1;\n\n\tparent.frames[2].document.forms[0].rtnCurrSlmtBAL.value=rtnArray1;\n\n\tparent.frames[2].document.forms[0].rtnPendSlmt.value=rtnArray2;\n\tparent.frames[2].document.forms[0].rtnArrayDt.value=rtnArrayDt;\n\tparent.frames[2].document.forms[0].rtnArrayDocref.value=rtnArrayDocref;\n\tparent.frames[2].document.forms[0].rtnArrayDocrefLine.value=rtnArrayDocrefLine;\n\tparent.frames[2].document.forms[0].rtnArrayDocrefSeq.value=rtnArrayDocrefSeq;\n\tparent.frames[2].document.forms[0].services_tot_records.value=v_services_tot_records;\t\t\n\tparent.frames[2].document.forms[0].rtnBlngServCode.value=rtnBlngServCode;\t\t\n\tparent.frames[2].document.forms[0].rtnTrxDate.value=rtnTrxDate;\t\t\n\tparent.frames[2].document.forms[0].rtnPrtGrpHdrCode.value=rtnPrtGrpHdrCode;\t\t\n\tparent.frames[2].document.forms[0].rtnPrtGrpLineCode.value=rtnPrtGrpLineCode;\t\t\n\tparent.frames[2].document.forms[0].rtnUpdGrossChrgAmt.value=rtnUpdGrossChrgAmt;\t\t\n\tparent.frames[2].document.forms[0].rtnUpdNetChrgAmt.value=rtnUpdNetChrgAmt;\t\t\n\n\tparent.frames[2].document.forms[0].tot_rec_for_serv_insert.value=tot_rec_for_serv_insert;\t\t\n\n\n\tparent.frames[2].document.forms[0].roundingamt.value=roundingamt;\t\t\n\tbillslmtprocess();\n}\n\nfunction billslmtprocess()\n\t\t\t{\n\t\t\t\tvar v_slmttype\t\t= \"\";\n\t\t\t\tvar v_cashslmtflag\t= \"\";\n\t\t\t\tvar v_instref\t\t= \"\";\n\t\t\t\tvar v_instdate\t\t= \"\";\n\t\t\t\tvar v_instremark\t= \"\";\n\t\t\t\tvar v_slmtidno\t\t= \"\";\n\t\t\t\tvar v_slmtpayername = \"\";\n\t\t\t\tvar v_billslmtamt = \"\";\t\n\t\t\t\tvar v_slmtapprrefno = \"\";\n\n\t\t\t\tvar v_rectype =\"\";\n\t\t\t\tvar v_ext_acc_facility_id = \"\";\n\t\t\t\tvar v_ext_acc_code = \"\";\n\t\t\t\tvar v_ext_acc_dept = \"\";\n\t\t\t\tvar v_online_approval = \"\";\n\t\t\t\tvar v_batch_no = \"\";\n\t\t\t\tvar v_sale_draft_no = \"\";\n\t\t\t\tvar v_ext_acc_interface_yn = \"\";\n\t\t\t\tvar v_ext_acc_fac_id=\"\";\n\t\t\t\tvar v_ext_acc_dept=\"\";\n\t\t\t\tvar v_ext_acc_code=\"\";\n\t\t\t\tvar v_bill_slmt_amtdet=\"\";\n\t\t\t\tvar v_bill_payable_amt=\"\";\n\t\t\t\tv_total_settled_amt=\"\";\n\t\t\t\tvar strroundingamt=\"\";\n\t\t\t\tv_bill_slmt_amtdet=parent.frames[0].document.forms[0].billslmtamtdet.value;//new\n\t\t\t\tv_bill_payable_amt=parent.frames[0].document.forms[0].billpayableamt.value;//new\n\n\t\t\t\t//Added by muthu against 33900 on 8/18/2012 \n\t\t\t\tif(v_bill_payable_amt!==\"\" && (v_bill_slmt_amtdet==\"\" || v_bill_slmt_amtdet==0))\n\t\t\t\t{\n\t\t\t\t\tif(v_bill_slmt_amtdet==\"\" && v_bill_payable_amt!==\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamtdet.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\t//if(eval(v_bill_slmt_amtdet)==0 && eval(v_bill_payable_amt)==0)//Commented for 33900\n\t\t\t\t\tif(eval(parseInt(v_bill_slmt_amtdet))==0 && eval(parseInt(v_bill_payable_amt))==0)\n\t\t\t\t\t{\t\n\t\t\t\t\t\talert(getMessage(\"BL9796\",\"BL\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//Added by muthu against 33900 on 8/18/2012 \n\n\t\t\t\t//if(v_bill_slmt_amtdet > 0 || v_bill_slmt_amtdet == 00.00){//newly added\n\t\t\t\tif(v_bill_slmt_amtdet != 0){\t//Added by muthu against 33900 on 8/18/2012\n\t\t\t\tv_ext_acc_fac_id=parent.frames[0].document.forms[0].str_ext_acc_facility_id.value;\t\t\t\t\n\t\t\t\t//v_bill_slmt_amtdet=parent.frames[0].document.forms[0].billslmtamtdet.value;\n\t\t\t\t//v_bill_payable_amt=parent.frames[0].document.forms[0].billpayableamt.value;\t\n\t\t\t\tv_total_settled_amt=document.forms[0].total_settled_amt.value;\t\n\t\t\t\tstrroundingamt=parent.frames[0].document.forms[0].strroundingamt.value;\t\n\t\t\t\tparent.frames[0].document.forms[0].pagecloseind.value = \"0\";\n\t\t\t\tvar v_tot_curr_stlmt=parent.frames[1].document.forms[0].tot_curr_stlmt.value;\n\t\t\t\tvar v_tot_curr_stlmt_no_roundoff=parent.frames[1].document.forms[0].tot_curr_stlmt_no_roundoff.value;//karthik SCF 272\t\n\t\t\t\tvar v_net_total=parent.frames[1].document.forms[0].net_total.value;\n\t\t\t\tvar bill_amt = document.forms[0].bill_amt.value;\n\t\t\t\t//Added by lakshmi\n\t\t\t\tvar rec_print_format_enabled_yn = document.forms[0].rec_print_format_enabled_yn.value;//muthu\n\t\t\t\t/* Commented by muthu for testing\n\t\t\t\tif(v_bill_payable_amt!==\"\" && (v_bill_slmt_amtdet==\"\" || v_bill_slmt_amtdet==0))\n\t\t\t\t{\n\t\t\t\t\tif(v_bill_slmt_amtdet==\"\" && v_bill_payable_amt!==\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BL9523\",\"BL\"));\n\t\t\t\t\t\tparent.frames[0].document.forms[0].billslmtamtdet.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\tif(eval(v_bill_slmt_amtdet)==0 && eval(v_bill_payable_amt)==0)\n\t\t\t\t\t{\t\n\t\t\t\t\t\talert(getMessage(\"BL9796\",\"BL\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}*/\n\t\t\t\t/*if (parent.frames[2].document.forms[0].onlineapproval.checked)\n\t\t\t\t\tv_online_approval = \'Y\';\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tv_online_approval = \'N\';*/\n\t\t\t\t\tv_net_total = parseFloat(v_net_total) + parseFloat(strroundingamt);\n\t\t\t\t\tif(parseFloat(v_net_total) == parseFloat(v_bill_slmt_amtdet))\n\t\t\t\t\t{\n\t\t\t\t\t\tif(parseFloat(v_tot_curr_stlmt) != parseFloat(v_bill_slmt_amtdet))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tv_tot_curr_stlmt = parseFloat(v_tot_curr_stlmt) + parseFloat(strroundingamt);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tv_tot_curr_stlmt=v_tot_curr_stlmt;\n\t\t\t\t\t}\n\t\t\t\tif((v_total_settled_amt!=v_bill_slmt_amtdet) || (v_tot_curr_stlmt!=v_bill_slmt_amtdet))\n\t\t\t\t{\n\t\t\t\t\tif(!(v_bill_slmt_amtdet < 0 &&  v_tot_curr_stlmt == 0 && eval(bill_amt) >= 0))\n\t\t\t\t\t{\n\t\t\t\t\t\t/* if(v_tot_curr_stlmt!=v_bill_slmt_amtdet)\t\t\tKarthik Commented for SCF 272\t\t\t\t\t\t\t\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(getMessage(\"BL9621\",\"BL\"));\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t} */\n\t\t\t\t\t\t/* Karthik added below logic for SCF 272 */\n\t\t\t\t\t\t/* The Summed up Settlement value without Round off and the Bill Settlement Value is checked for Negligible difference of 2\n\t\t\t\t\t\t   If difference exceeds 2, then we throw Error*/\n\t\t\t\t\t\tvar negligible_difference= parseFloat(v_bill_slmt_amtdet)-parseFloat(v_tot_curr_stlmt_no_roundoff);\n\t\t\t\t\t\tif(Math.abs(negligible_difference)>2){\n\t\t\t\t\t\t\talert(getMessage(\"BL9621\",\"BL\"));\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t\t\tif(v_total_settled_amt!=v_bill_slmt_amtdet)\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"BL9782\",\"BL\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t//if(v_bill_slmt_amtdet!=v_total_settled_amt)\n\t\t\t\t//{\n\t\t\t\t//\talert(getMessage(\"BL7085\",\"BL\"));\n\t\t\t\t//\treturn false;\n\t\t\t\t//}\n\n\t\t\t\t/*if(v_tot_curr_stlmt!=v_total_settled_amt)\n\t\t\t\t{\n\t\t\t\t\talert(\"Total  Amount Should be equal to Settled Amount\");\n\t\t\t\t\treturn false;\n\n\t\t\t\t}*/\n\t\t\t\tvar v_ext_acc_interface_yn=parent.frames[0].document.forms[0].ext_acc_interface_yn.value;\n\t\t\t\t\n\t\t\t\tif(v_ext_acc_interface_yn== \"Y\")\n\t\t\t\t{\n\t\t\t\t\tv_rectype = parent.frames[0].document.forms[0].rectype.value;\n\t\t\t\t\tv_ext_acc_dept=parent.frames[0].document.forms[0].dept.value;\n\t\t\t\t\tv_ext_acc_code=parent.frames[0].document.forms[0].acccode.value;\t\t\t\n\n\t\t\t\tif ( v_rectype == \"\")\n\t\t\t\t\t{\t\t\t\t\t\n//\t\t\t\t\t\talert(\"Receipt Type cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9524\",\"BL\"));\n\t\t\t\t\t\tparent.frames[0].document.forms[0].rectype.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\tif ( v_ext_acc_code == \"\")\n\t\t\t\t\t{\n//\t\t\t\t\t\talert(\"Account code cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9525\",\"BL\"));\n\t\t\t\t\t\tparent.frames[0].document.forms[0].acccode.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\n\t\t\t\t\tif ( v_ext_acc_dept == \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t\t//alert(\"Accounting department cannot be blank\");\n\t\t\t\t\t\talert(getMessage(\"BL9526\",\"BL\"));\n\t\t\t\t\t\tparent.frames[0].document.forms[0].dept.focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\t\tvar genmesg = getMessage(\"BL9537\",\"BL\");\n\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5_4Bytes = _getBytes( _wl_block5_4 );

    private final static java.lang.String  _wl_block6 ="\ndocument.forms[0].ok_button.disabled=true;\nparent.frames[2].document.forms[0].target=\'BillSlmtSubmitFrame\';\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n//Added by lakshmi\nparent.frames[2].document.forms[0].action=\'../../eBL/jsp/BLBillSlmtValidation.jsp?billdoctypecode=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&billdocnum=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&billpayableamt=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&facilityid=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&loggeduser=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&patientid=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&episodetype=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&episodeid=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&visitid=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&encounterid=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&moduleid=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&slmtamt=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&slmtidno=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&encounterFacilityId=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&rectype=\'+v_rectype+\'&ext_acc_code=\'+v_ext_acc_code+\'&ext_acc_dept=\'+v_ext_acc_dept+\'&rec_print_format_enabled_yn=\'+rec_print_format_enabled_yn+\'&ext_acc_fac_id=\'+v_ext_acc_fac_id+\'&genmesg=\'+genmesg+\'&bill_slmt_amtdet=\'+v_bill_slmt_amtdet+\"&called_frm=\"+document.forms[0].called_frm.value+\"&alw_co_wit_bl_slmt_yn=\"+document.forms[0].alw_co_wit_bl_slmt_yn.value+\"&cal_frm_multi_bil_slmt=\"+document.forms[0].cal_frm_multi_bil_slmt.value+\"&cash_counter_code=\"+document.forms[0].cash_counter_code.value+\"&billAlreadyPrinted=\"+parent.BillSlmtEntryFrame.document.forms[0].billAlreadyPrinted.value+\"&patMembershipID=\"+document.forms[0].patMembershipID.value; //V210113 //V210211.1\n//\"&str_rec_print_format_enabled_yn=\"+rec_print_format_enabled_yn;\nparent.frames[2].document.forms[0].submit();\n/*Added by muthu 8/16/2012 against 33900\n\t\t\t\tif(v_bill_slmt_amtdet == 0.0)\n\t\t\t\t{\n\t\t\t\t\talert(\"Testing v_bill_slmt_amtdet by muthu \"+v_bill_slmt_amtdet);\n\t\t\t\t\tcancel();\n\t\t\t\t}\nAdded by muthu 8/16/2012 against 33900*/\n\t\t\t\t}\t//Added by muthu against 33900 on 8/18/2012 Starts here\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tcancel();\n\t\t\t\t}\n\t\t//Added by muthu against 33900 on 8/18/2012 Ends here \n}\nfunction cancel()\n{\n\t/*IN038081 Added by Karthik on May-10-2013 to bring in Confirmation window before cancel*/\n\tvar r=confirm(\"Are you sure you want to Cancel Bill Settlement ?\");\n\tif (r==true)\n\t{\n\tvar called_frm = document.forms[0].called_frm.value;\n\tvar alw_co_wit_bl_slmt_yn = document.forms[0].alw_co_wit_bl_slmt_yn.value;\n\tvar episode_type = document.forms[0].episode_type.value;\n\tvar cal_frm_multi_bil_slmt = document.forms[0].cal_frm_multi_bil_slmt.value;\n\tvar bill_print_format_enabled_yn = document.forms[0].bill_print_format_enabled_yn.value;\n\t//var rec_print_format_enabled_yn = document.forms[0].rec_print_format_enabled_yn.value;//muthu\n\n\tif(called_frm == \"CHECKOUT_VISIT\" && alw_co_wit_bl_slmt_yn == \"Y\" && episode_type == \"E\" && cal_frm_multi_bil_slmt != \"Y\")\n\t{\n\t\talert(getMessage(\"BL7284\",\"BL\"));\n\t\treturn false;\n\t}\n\n\tif(bill_print_format_enabled_yn == \'Y\')\n\t{\n\t\tparent.frames[2].document.forms[0].target=\'BillSlmtSubmitFrame\';\n\t\tparent.frames[2].document.forms[0].action=\"../../eBL/jsp/BLBillSlmtValidation.jsp?bill_print_format_enabled_yn=\"+bill_print_format_enabled_yn+\"&billAlreadyPrinted=\"+parent.BillSlmtEntryFrame.document.forms[0].billAlreadyPrinted.value+\"&billdoctypecode=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&called_frm_cancel=Y\";\n\t\tparent.frames[2].document.forms[0].submit();\t\t\t\n\t}\n\telse\n\t{ //V210113 start\n\t\tvar patientID =document.forms[0].strpatientid.value;\n\t\tvar LoggedUser =document.forms[0].struser.value;\n\t\tvar clientIpAddress =document.forms[0].strClientIpAddress.value;\t\t\t\t\t\t\n\t\tvar transactionid=\'\';\t\t\t\t\t\n\t\ttotalRecords =eval(formObj.total_records.value);\t\t\n\t\tfor(var j=0;j<total_records;j++)\n\t\t{\t\t\t\n\t\t\tvar couponobj = eval(\"parent.frames[2].document.forms[0].couponcode\"+j);\n\t\t\tvar coupon = couponobj.value;\t\n\t\t\tif (coupon != \"undefined\" && coupon != undefined && coupon != \"\" ) {\n\t\t\t//V210211 added\n\t\t\t\tif(confirm(getMessage(\"BL0924\",\"BLEXT\"))) //BL9760\n\t\t\t\t{\t\n\t\t\t\t\tvar NuhdeekResponse = NuhdeekTransactions(\'RELEASE\',patientID,coupon,transactionid, LoggedUser, clientIpAddress);\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar NuhdeekResponseArr = NuhdeekResponse.split(\"$!^\");\t\t\n\t\t\t\t\tif (NuhdeekResponseArr[0] == \'S\') {\t\t\t\t\t\t\t\n\t\t\t\t\t} else if (NuhdeekResponseArr[0]==\'E\') {\n\t\t\t\t\t\t\talert(NuhdeekResponseArr[4]);\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}else{ //V210211 \n\t\t\t\t\treturn false;\t\n\t\t\t\t}\n\t\t\t}\n\t\t} \n\t\t//V210113 end\n\t\tparent.window.returnValue = \"N\";\n\t\tparent.window.close();\n\t}\n\t}\n}\n/*\nfunction chkForDfltSlmtType()\n{\n\tdocument.forms[0].add_bill_stlmt_button.click();\n}\n*/\n</script>\n\t\t\t<title>\t\t\t\n\t\t\t</title>\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n-->\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eBL/js/AddModifyPatFinDetails.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\n\t\t</head>\n\n\t\t<body onLoad=\'tot_setld_amt();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<form>\n<table cellpadding=3 cellspacing=0  width=\"100%\">\t\n<tr>\n\t<td width=\'25%\' class=\'label\'><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b>\n\t\n\t<input type=\'text\' name=\'total_settled_amt\' id=\'total_settled_amt\' size=\'10\' maxlength=\'25\' style=\'text-align:right\' readonly value=\'\'></td>\t\n\n\t<td class=\"label\" width=\"25%\"></td>\n\t<td width=\"25%\"  class=\'labels\'>\t<input type=\'button\' class=\'button\' onclick=\'addBillSlmt()\' name=\'add_bill_stlmt_button\' id=\'add_bill_stlmt_button\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\n\t<input type=\'button\' class=\'button\' onclick=\'modifyBillSlmt()\' name=\'modify_serv_button\' id=\'modify_serv_button\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t<input type=\'button\' class=\'button\' onclick=\'removeBillSlmt()\' name=\"remove_button\" id=\"remove_button\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" ></td>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\n\t<td width=\"25%\"  class=\'labels\'><INPUT TYPE=\"button\"  class=\"BUTTON\" name=\'ok_button\' id=\'ok_button\' VALUE=\"    ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="    \" onClick=\'billslmtprocess1()\' ><input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" class=\'button\' onClick=\'cancel()\'></td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</td>\n</tr>\n\n</table>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<input type= hidden name=\"query_string\" id=\"query_string\"  value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<INPUT TYPE=\"HIDDEN\" name=\"blnggrp\" id=\"blnggrp\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\t\t\n\t<INPUT TYPE=\"HIDDEN\" name=\"billdoctype\" id=\"billdoctype\" SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' >\t \t\n\t<INPUT TYPE=\"HIDDEN\" name=\"billdocnum\" id=\"billdocnum\"\t   SIZE=\"20\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'> \n\t<INPUT TYPE=\"HIDDEN\" name=\"total_amt_payable\" id=\"total_amt_payable\"   SIZE=\"50\" MAXLENGTH=\"100\" \tVALUE=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' >\n\t<input type=\'hidden\' name=\'strdfltslmttypecode\' id=\'strdfltslmttypecode\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' >\n\t<input type=\'hidden\' name=\'called_frm\' id=\'called_frm\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >\n\t<input type=\'hidden\' name=\'GHL_site_spec\' id=\'GHL_site_spec\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' > <!--ghl-crf-0646 V220110-->\n\t<input type=\"hidden\" name=\"result\" id=\"result\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\"hidden\" name=\"strBlrblprt\" id=\"strBlrblprt\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\"hidden\" name=\"p_login_user\" id=\"p_login_user\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\" id=\"user_id\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" \tname=\"report\" id=\"report\"\t\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\"\tname=\"reportserver\" id=\"reportserver\"\tvalue=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" \tname=\"userid\" id=\"userid\"\t\tvalue=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\"\tname=\"server\" id=\"server\"\t\tvalue=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"report_server\" id=\"report_server\" id=\"report_server\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\"\tname=\"desformat\" id=\"desformat\"\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"destype\" id=\"destype\"\t\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"desname\" id=\"desname\"\t\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"copies\" id=\"copies\"\t\tvalue=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\"\tname=\"params\" id=\"params\"\t\tvalue=\"\">\n\t<input type=\"hidden\"\tname=\"queue_name\" id=\"queue_name\"\tvalue=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\"\tname=\"message\" id=\"message\"\t\tvalue=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\"\tname=\"view\" id=\"view\"\t\tvalue=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\n\t<input type=\"hidden\"\tname=\"self_submit\" id=\"self_submit\"\tvalue=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\"\tname=\"p_module_id\" id=\"p_module_id\"\tvalue=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\"hidden\"\tname=\"p_report_id\" id=\"p_report_id\"\tvalue=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\"hidden\"\tname=\"dest_locn_type\" id=\"dest_locn_type\"\tvalue=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\"hidden\"\tname=\"dest_locn_code\" id=\"dest_locn_code\"\tvalue=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\"hidden\"\tname=\"languageID\" id=\"languageID\"\tvalue=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\"hidden\"\tname=\"locale\" id=\"locale\"\tvalue=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\"hidden\"\tname=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type=\"hidden\"\tname=\"filePath\" id=\"filePath\"\tvalue=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type=\"hidden\"\tname=\"fileName\" id=\"fileName\"\tvalue=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\"hidden\"\tname=\"rep_server_key\" id=\"rep_server_key\"\tvalue=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t<!--ends for GHL-CRF-0646 V220110-->\n\t<input type=\'hidden\' name=\'alw_co_wit_bl_slmt_yn\' id=\'alw_co_wit_bl_slmt_yn\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' >\n\t<input type=\'hidden\' name=\'cal_frm_multi_bil_slmt\' id=\'cal_frm_multi_bil_slmt\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' >\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' >\n\t<input type=\'hidden\' name=\'cash_counter_code\' id=\'cash_counter_code\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' >\n\t<input type=\'hidden\' name=\'bill_amt\' id=\'bill_amt\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' >\n\t<input type=\'hidden\' name=\'doc_amt\' id=\'doc_amt\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' >\n\t<input type=\'hidden\' name=\'bill_print_format_enabled_yn\' id=\'bill_print_format_enabled_yn\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' >\n\t<input type=\'hidden\' name=\'rec_print_format_enabled_yn\' id=\'rec_print_format_enabled_yn\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' >\n\t<input type=\'hidden\' name=\'rec_ref\' id=\'rec_ref\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' >\n\t<input type=\'hidden\' name=\'restrictEligibility\' id=\'restrictEligibility\' id =\'restrictEligibility\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' />\n\t<input type=\'hidden\' name=\'couponcode\' id=\'couponcode\' id =\'couponcode\' value=\'\' />\n\t<input type=\'hidden\' name=\'patMembershipID\' id=\'patMembershipID\' id =\'patMembershipID\' value=\'\' />\n\t<input type=\'hidden\' name=\'struser\' id=\'struser\' id =\'struser\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' />\n\t<input type=\'hidden\' name=\'strpatientid\' id=\'strpatientid\' id =\'strpatientid\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' />\n\t<input type=\'hidden\' name=\'strClientIpAddress\' id=\'strClientIpAddress\' id =\'strClientIpAddress\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' />\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);


	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	Connection con = null; 
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	ResultSet rscurr=null;
	//added for ghl-crf-0646
	CallableStatement cstmt = null;
	//ResultSet rs = null;
	ResultSet  rstMt =  null;
	PreparedStatement pstmtRpt = null;
	//added against GHL-CRF-0646 V220110
	String GHL_site_spec ="";
	String strBlrblprt="";
	System.err.println("qrystring,blbillslmttypebtn.jsp-"+request.getQueryString());
	String     called_moduleId=(String)session.getAttribute("called_module_id"); 
	System.err.println("called_moduleId-"+called_moduleId);
	if ( called_moduleId == null ) called_moduleId = "";
	boolean GHLsite=false;
	CallableStatement call = null;
	CallableStatement cs = null;
	String str_error_level = "", str_error_text = "", str_sysmesage_id = "", str_error_code;
	String str_bill_gen_yn = "", str_bill_doc_type = "", str_bill_doc_number = "", str_slmt_reqd_yn = "",
			strFinalMessage = "";
	String view="";
	String  result="", fileName = "", path = "";
	String reportServer	= (String) session.getValue( "report_server" );
	String userid		= (String) session.getValue( "report_connect_string" );
	String self_submit	= request.getParameter( "self_submit" );
	PreparedStatement pstmt1 = null ;
	ResultSet rs1 =null;
		String jdbc_username="";
		String jdbc_password="";
		String report_server="";
		String reoprt_connect_string="";
		String user_id="";
		
		String report		= "";
		String server		= "";
		String copies		= "";
		String queue_name	= "";
		String message		= "";
		
		String module_id		= request.getParameter( "module_id" );
		System.err.println("called_moduleId,blbillslmttypebtn.jsp-"+module_id);
		String report_id		= request.getParameter( "p_report_id" );
		String dest_locn_type	= request.getParameter( "dest_locn_type" );
		String dest_locn_code	= request.getParameter( "dest_locn_code" );

		String facility_id	= (String) session.getValue( "facility_id" );
		String ws_no		= (String) p.getProperty( "client_ip_address" );
		String report_option = request.getParameter( "report_option" );
		String languageID	= request.getParameter( "p_language_id" )==null?"": request.getParameter( "p_language_id" );
		/*String	strbilldoctypecode = request.getParameter("billdoctypecode");
		System.err.println("btn,strbilldoctypecode--->"+strbilldoctypecode);
		String	strbilldocnum = request.getParameter("billdocnum");
		System.err.println("btn,strbilldocnum--->"+strbilldocnum);*/
		String locale = "";
		String app_server_ip	= "", rep_server_key	= "";

		if ( report_option	== null ) report_option = "F";
		//Added against GHL-CRF-0646 V220110
	String restrictEligibility="";
	String strfacilityid="";	String p_login_user="";
	String query_string=""; 	String strblnggrpid="";
	String strbilldoctypecode="";	String strbilldocnum ="";
/*	String retrnValue = "Y";
	String	strslmtamt = request.getParameter("bill_slmt_amtdet");	
	String  strpayableAmt = request.getParameter("billpayableamt");  //newly added for  partial settlment case from PH
*/ //V220517
	String strbillpayableamt=""; String strpatientid  ="";String strepisodetype="",strmoduleid="";
	String strepisodeid =""; String strvisitid ="";String strencounterid="";String strslmtpayername=""; 
	String struser ="";String strslmtidno = "";	int noofdecimal=2;String strdfltslmttypecode = "",function_id="",called_frm="",alw_co_wit_bl_slmt_yn="N",cal_frm_multi_bil_slmt="N",cash_counter_code="";
	String recpt_refund_ind ="";
	String str_bill_amt = "0";
	String doc_amt="";
	double d_bill_amt = 0;
	String str_bill_print_format_enabled_yn = "N";
	String strClientIpAddress =""; //V210113
	//Added by muthu against 33868 - Receipt Print on 13-7-12
	String str_rec_print_format_enabled_yn = "N";
	request.setCharacterEncoding("UTF-8");
	String encounterFacilityId = request.getParameter("encounterFacilityId"); //V210211.1
	try
	{
		con	=	ConnectionManager.getConnection(request);
		query_string=request.getQueryString();
		strpatientid  = request.getParameter("patientid");	
		System.err.println("103,query_string"+query_string);
		if (strpatientid == null || strpatientid.equalsIgnoreCase("null")) 
		{strpatientid = "";}	
		System.err.println("strpatientid,106->"+strpatientid);
	 	strepisodetype = request.getParameter("episodetype");	
		if (strepisodetype == null || strepisodetype.equalsIgnoreCase("null")) 
		{strepisodetype = "";}	
		System.err.println("strepisodetype-"+strepisodetype);
		strmoduleid= request.getParameter("moduleid");	
		if (strmoduleid == null || strmoduleid.equalsIgnoreCase("null")) 
		{strmoduleid = "";}	
		System.err.println("strmoduleid-"+strmoduleid);
		strepisodeid = request.getParameter("episodeid");
		if (strepisodeid == null || strepisodeid.equalsIgnoreCase("null")) 
		{strepisodeid = "";}	
		System.err.println("strepisodeid-"+strepisodeid);
		strvisitid = request.getParameter("visitid");
		if (strvisitid == null || strvisitid.equalsIgnoreCase("null")) 
		{strvisitid = "";}
		System.err.println("strvisitid-"+strvisitid);
		strencounterid = request.getParameter("encounterid");
		if (strencounterid == null || strencounterid.equalsIgnoreCase("null")) 
		{strencounterid = "";}
			System.err.println("strencounterid-"+strencounterid);
		strslmtpayername = request.getParameter("slmtpayername");	
		if (strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null")) 
		{strslmtpayername = "";}
		System.err.println("strslmtpayername-"+strslmtpayername);
		struser = request.getParameter("loggeduser");
		if (struser == null || struser.equalsIgnoreCase("null")) 
		{struser = "";}			
		System.err.println("struser-"+struser);
		strslmtidno = request.getParameter("slmtidno");
		System.err.println("strslmtidno-"+strslmtidno);
		strfacilityid = (String)httpSession.getValue("facility_id");
		System.err.println("strfacilityid-"+strfacilityid);
		strClientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
		System.err.println("140,blbillslmttypebtn");
		BLCashSlmtRestriction billRestr = new BLCashSlmtRestriction();
		 restrictEligibility = billRestr.checkCashRestrictionEligibility(strfacilityid);
		System.err.println("restrictEligibility @@@@@@@@@@@@@@@@@@@@@-- >"+restrictEligibility);
		
		p_login_user =  p.getProperty("login_user");
		strblnggrpid = request.getParameter("strblnggrpid");	
		if (strblnggrpid == null || strblnggrpid.equalsIgnoreCase("null")) 
		{strblnggrpid = "";}	
	System.err.println("140,strblnggrpid"+strblnggrpid);
		strbilldoctypecode = request.getParameter("billdoctypecode");
		if (strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
		{strbilldoctypecode = "";}	
	System.err.println("140,strbilldoctypecode"+strbilldoctypecode);
		strbilldocnum = request.getParameter("billdocnum");
		if (strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
		{strbilldocnum = "";}	
		System.err.println("140,strbilldocnum"+strbilldocnum);
		strbillpayableamt = request.getParameter("billpayableamt");
		if (strbillpayableamt == null || strbillpayableamt.equalsIgnoreCase("null")) 
		{strbillpayableamt = "";}	
		System.err.println("140,strbillpayableamt"+strbillpayableamt);
		function_id = request.getParameter("function_id");
		if(function_id==null) function_id="";	
		System.err.println("140,function_id"+function_id);
	
		called_frm= request.getParameter("called_frm");
		if(called_frm==null) called_frm="";	
		System.err.println("140,called_frm"+called_frm);
		alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
		if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";
		System.err.println("140,alw_co_wit_bl_slmt_yn"+alw_co_wit_bl_slmt_yn);
		cal_frm_multi_bil_slmt = request.getParameter("cal_frm_multi_bil_slmt");
		if(cal_frm_multi_bil_slmt == null) cal_frm_multi_bil_slmt="N";		
		System.err.println("140,cal_frm_multi_bil_slmt "+cal_frm_multi_bil_slmt);
		cash_counter_code = request.getParameter("cashcounter");
		if(cash_counter_code == null) cash_counter_code="";	
		System.err.println("140,cash_counter_code "+cash_counter_code);
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
			e.printStackTrace();
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
			System.out.println("4 btn="+e.toString());
			e.printStackTrace();
		}

		try
		{		
			pstmt = con.prepareStatement( " select nvl(bill_amt,0) from bl_bill_hdr where DOC_TYPE_CODE = ? and DOC_NUM=? ");
			pstmt.setString(1,strbilldoctypecode);
			pstmt.setString(2,strbilldocnum);
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
			System.out.println("5 btn="+e.toString());
			e.printStackTrace();
		}
			
		//added against GHL-CRF-0646 V220110
		
		try
		{
		GHLsite = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BILL_PRINT_SAVED");				
		}catch(Exception e)
		{
			System.out.println("6 btn="+e.toString());
			e.printStackTrace();
		}
		if(GHLsite){
			GHL_site_spec="Y";
		}
		else{
			GHL_site_spec="N";
		}
		//ends GHL-CRF-0646 V220110
	//added for GHL-CRF-0646 V220110
	
	//Added below code for GST-GHL-CRF-0477
	String custId = BLReportIdMapper.getCustomerId();
	String gstApplicableYN = "N";
	String printOrientation = "P";
	try{
		pstmtRpt = con.prepareStatement("Select bladdlchg.is_gst_applicable_yn('BL', 'BL_BILL_PRINT_ORIENTATION') gst_applicable from dual");
		rstMt = pstmtRpt.executeQuery();
		if(rstMt != null && rstMt.next()){
			gstApplicableYN = rstMt.getString("gst_applicable");
		}
		System.err.println("gstApplicableYN in BLBillSlmtTypeBtn.jsp:"+gstApplicableYN);
		if("Y".equals(gstApplicableYN)){
		/*	String printOrientationSql = "Select NVL (default_bill_print_orientation, 'P') default_bill_print_orientation "+
										"FROM bl_parameters "+
										"WHERE operating_facility_id = ?";
			
			pstmtRpt = con.prepareStatement(printOrientationSql);
			pstmtRpt.setString(1, strfacilityid);
			rstMt = pstmtRpt.executeQuery();
			
			if(rstMt != null && rstMt.next()){
				printOrientation = rstMt.getString("default_bill_print_orientation");
			}		*/	
		//ADDED FOR KDAH-CRF-0546 on 15-May-20
		try{ 				
				cstmt = con.prepareCall("{ call BLCOMMON.get_report_id_for_3t(?,?,?,?) }");
				cstmt.setString(1,strfacilityid);
				cstmt.setString(2,strepisodetype);				
				cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
				cstmt.execute();
				printOrientation = cstmt.getString(3);
				strBlrblprt = cstmt.getString(4);	
				System.out.println("264-- printOrientation===>"+printOrientation);
				System.out.println("265-- strBlrblprt===>"+strBlrblprt);
			}
			catch(Exception e){
				printOrientation = "P";
				System.err.println("Exception in getting BLBillSlmtValidation.jsp, 1"+e);
				e.printStackTrace();
			}
			finally{
				try
				{
					if (cstmt !=null) cstmt.close();
				}
				catch(Exception ee1) 
				{
					System.err.println("Exception in getting BLBillSlmtValidation.jsp, 2"+ee1);
					ee1.printStackTrace();
				}
			}
			//ADDED FOR KDAH-CRF-0546 on 15-May-20
		}
	}
	catch(Exception e){
		printOrientation = "P";
		System.err.println("Exception in getting printOrientation, 1"+e);
		e.printStackTrace();
	}
	finally{
		try
		{
			if(rstMt != null)  rstMt.close();	
			if (pstmtRpt !=null) pstmtRpt.close();
		}
		catch(Exception ee1) 
		{
			System.err.println("Exception in getting printOrientation, 2"+ee1);
			ee1.printStackTrace();
		}
	}
	
			System.err.println("356");	
	/* Added V200116-MuthuN/GHL-CRF-0611/Starts */
	String printFormatSql = "SELECT NVL(PRINT_A5_FORMAT,'N') PRINT_A5_FORMAT FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID = '"+strfacilityid+"'";
	pstmtRpt = con.prepareStatement(printFormatSql);
	rstMt = pstmtRpt.executeQuery();
	String printFormat = "N";
	while(rstMt.next()) {
		printFormat = rstMt.getString("PRINT_A5_FORMAT");
		System.err.println("printFormat-"+printFormat);	
	}
	pstmtRpt.close();
	rstMt.close();
	/* Added V200116-MuthuN/GHL-CRF-0611/Ends */
	System.err.println("printOrientation-"+printOrientation);	
	
	/* V220711 Only if the client is MC, the below code should be executed. Otherwise the else part will override the strBlrblprt assigned from above logics. Hence moved the if else loop inside MC client condition */
	System.err.println("In SlmtBtn.jsp strBlrblprt:"+strBlrblprt);
	if("MC".equalsIgnoreCase(custId)){
		if("Y".equals(printFormat)  && "P".equals(printOrientation)) {//Added V200116-MuthuN/GHL-CRF-0611
			strBlrblprt = "BLRBLPRT_GHL";
		} else {
			strBlrblprt  ="BLRBLPRT";
		}
	}
	System.err.println("In SlmtBtn.jsp strBlrblprt1:"+strBlrblprt);

	/*Added by Karthik for Report Rerint called from */
	if(called_moduleId.equals("")){
		String moduleCalledFromReportReprint=(String)session.getAttribute("BL_MODULE_CALLED_FROM_REPORT_REPRINT");
		if(moduleCalledFromReportReprint==null) moduleCalledFromReportReprint="";
		
		if(moduleCalledFromReportReprint.equals("")==false){
			called_moduleId=moduleCalledFromReportReprint;	
		}
		session.removeAttribute("BL_MODULE_CALLED_FROM_REPORT_REPRINT");			
	}
			//retrnValue ="Y";
	if(called_moduleId.equals("PH") || called_moduleId.equals("ST"))
		{
			System.err.println("388 inside st module loop");
	/*		if(strpayableAmt.length()>0 &&strslmtamt.length() >0 && Float.parseFloat(strpayableAmt)  > Float.parseFloat(strslmtamt))
		{											
			retrnValue = "P";
		}
*///V220517
	try{		
		String qryStmt="select report_id  from  bl_bill_reports where OPERATING_FACILITY_ID = '"+strfacilityid+"'  and bill_type='PH-BILL'";				

		 pstmtRpt = con.prepareStatement(qryStmt);							
		 rstMt = pstmtRpt.executeQuery();
		while (rstMt!=null && rstMt.next())
		{	
			strBlrblprt  =  rstMt.getString(1);
		}
		}catch(Exception ee)
		{
		if("Y".equals(printFormat)) {//Added V200116-MuthuN/GHL-CRF-0611
			strBlrblprt = "BLRBLPRT_GHL";
		} else {
			strBlrblprt  ="BLRBLPRT";
		}
		}
		finally
		{
			try
			{
				if(rstMt != null)  rstMt.close();	
				if (pstmtRpt !=null) pstmtRpt.close();
			}catch(Exception ee1) 
			{
				ee1.printStackTrace();
			}
			}								 
		}

		//Added By Rajesh V - RUT-CRF0095
		//String custId = BLReportIdMapper.getCustomerId();
		String strBlrRecpt = "";
		System.err.println("428,custId "+custId);
		if("RTN".equalsIgnoreCase(custId)){
			String billTypeId = BLReportIdMapper.getBillType(strepisodetype,called_frm,called_moduleId);
			strBlrblprt = BLReportIdMapper.getBlrBlPrtReportId(strfacilityid, billTypeId);
			if(strBlrblprt == null || "".equals(strBlrblprt)){
				if("Y".equals(printFormat)) {//Added V200116-MuthuN/GHL-CRF-0611
				strBlrblprt = "BLRBLPRT_GHL";
				} else {
				strBlrblprt  ="BLRBLPRT";
				}
			}	
		}
		// Added By Rajesh V - RUT-CRF0095
			
		try {
			/* BLReportIdMapper.getReportId function used in other modules also
			 * eAE - AEManagePatientServlet.java, AERegisterAttnServlet.java
			 * eBL - BLAdhocDiscSubmit.jsp, BLBillSlmtValidation.jsp, BLPatRegValidation.jsp, BLReprintReportHdr.jsp, BLStoreBillSlmtMain.jsp
			 * eMP - PatientRegistrationServlet.java
			 * eOP - PatCheckoutServlet.java, QmgmtRe_AssignPractServlet.java, ReviseVisitServlet.java, VisitRegistrationServlet.java
			 */
			strBlrblprt = BLReportIdMapper.getReportId(con, locale,strBlrblprt, strfacilityid); //Added strfacilityid by subha for MMS-DM-CRF-131.1
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Exception in BLBillSlmtValidation for reportID "+ e);
			}				
	
	if(("L".equals(printOrientation)) && ("BLRBLPRT".equals(strBlrblprt) || "BLRBLPRT_PH".equals(strBlrblprt))){
			strBlrblprt = "BLRBLPRL";
		}
		//Added below code for GST-GHL-CRF-0477
	//END
		
		if("Y".equals(GHL_site_spec)){
			System.err.println("inside GHL_site_spec====>");
			call = con.prepareCall("{ call proc_billprintsaved (?,?,?,?,?,?,?)}");	
							call.setString(1, facility_id); //V210211
							System.err.println("41,facility_id-->"+facility_id);
							call.setString(2,strbilldoctypecode);
							System.err.println("42,strbilldoctypecode-->"+strbilldoctypecode);
							call.setString(3,strbilldocnum);
							System.err.println("43,strbilldocnum-->"+strbilldocnum);
							call.registerOutParameter(4,java.sql.Types.VARCHAR);	
							call.registerOutParameter(5,java.sql.Types.VARCHAR);	
							call.registerOutParameter(6,java.sql.Types.VARCHAR);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.execute();									
							result	 = call.getString(4);
							System.err.println("btn,1244,result---->"+result);							
							fileName  	     = call.getString(5);
							System.err.println("btn,1246,fileName---->"+fileName);
							path=call.getString(6);	
							view = call.getString(7);
							System.err.println("btn,282,view===>"+view);
							System.err.println("btn,1248,path---->"+path);
							
								 System.err.println("6222222222222222====>");
								 locale=(String)session.getAttribute("LOCALE");
								System.err.println("1395,locale-->"+locale);
								
								if ( reportServer		== null ) reportServer	= "";
								if ( userid			== null ) userid		= "";
								//if ( params 		== null ) params 		= "";
								if ( self_submit		== null ) self_submit	= "";

								if ( module_id		== null ) module_id 	= "";
								if ( report_id		== null ) report_id 	= "";
								if ( dest_locn_type 	== null ) dest_locn_type= "";
								if ( dest_locn_code	== null ) dest_locn_code= "";
								if ( facility_id		== null ) facility_id	= "";
								if ( ws_no			== null ) ws_no		= "";
								if ( report_option	== null ) report_option = "F";
								
								//Connection conn=null;
								try{
									System.err.println("btn,inside try---->>");
									 //conn = ConnectionManager.getConnection(request);
									 cs = con.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }" );
									 System.err.println("111111111");
									cs.setString( 1,	"BL" );
									cs.setString( 2,	strBlrblprt );
									cs.setString( 3,	dest_locn_type );
									System.err.println("314,dest_locn_type==>"+dest_locn_type);
									cs.setString( 4,	dest_locn_code );
									System.err.println("315,dest_locn_code==>"+dest_locn_code);
									cs.setString( 5,	facility_id );
									System.err.println("316,facility_id==>"+facility_id);
									cs.setString( 6,	ws_no );
									System.err.println("317,ws_no===>"+ws_no);
									cs.setString( 7,	report_option );
									System.err.println("318,report_option===>"+report_option);
									cs.registerOutParameter( 8,  Types.VARCHAR );
									cs.registerOutParameter( 9,  Types.VARCHAR );
									cs.registerOutParameter( 10, Types.VARCHAR );
									cs.registerOutParameter( 11, Types.VARCHAR );
									cs.registerOutParameter( 12, Types.VARCHAR );
									cs.registerOutParameter( 13, Types.VARCHAR );
									cs.registerOutParameter( 14, Types.VARCHAR );
									cs.registerOutParameter( 15, Types.VARCHAR );
									cs.registerOutParameter( 16, Types.VARCHAR );
									cs.registerOutParameter( 17, Types.VARCHAR );
									cs.execute() ;
									System.err.println("103===>");
									report	= cs.getString( 8 );
									server	= cs.getString( 9 );
									copies	= cs.getString( 10 );
									if(copies==null || copies.equals("null") || copies.equals("")) copies="1";
									queue_name	= cs.getString( 12 );
									message	= cs.getString( 15 );
									if (message==null) message="";
									app_server_ip = cs.getString( 16 );
									rep_server_key= cs.getString( 17 );
									if (rep_server_key==null) rep_server_key="";
									System.err.println("btn,346,reportServer===>"+reportServer);
									reportServer = "http://" + app_server_ip + reportServer;
									System.err.println("btn,347,app_server_ip===>"+app_server_ip);
									System.err.println("btn,348,reportServer===>"+reportServer);
									System.err.println("btn,348,report===>"+report);
									System.err.println("btn,349,server===>"+server);
									if(cs !=null)cs.close();
									System.err.println("118====>");
									
								String sql1="select USER_ID,app_password.decrypt(password),REPORT_SERVER,REPORT_CONNECT_STRING  from sm_db_info";
									
								pstmt1=con.prepareStatement(sql1);
								rs1=pstmt1.executeQuery();
								System.err.println("132====>");
								while(rs1.next())
								{
									jdbc_username	=rs1.getString(1);	
									jdbc_password	=rs1.getString(2);
									report_server =rs1.getString(3);
									reoprt_connect_string =rs1.getString(4);	
								}
								user_id = jdbc_username+"/"+jdbc_password+"@"+reoprt_connect_string;
								System.err.println("135=======>");								
							
								}
								
								catch(Exception e){
									System.err.println("139=======>");
									//out.println(e);
									e.printStackTrace();
									}
									
								finally {
								//ConnectionManager.returnConnection(con,request);
								System.err.println("146=======>");
								}
							
		}

            _bw.write(_wl_block5_0Bytes, _wl_block5_0);
            _bw.write(_wl_block5_1Bytes, _wl_block5_1);
            _bw.write(_wl_block5_2Bytes, _wl_block5_2);
            _bw.write(_wl_block5_3Bytes, _wl_block5_3);
            _bw.write(_wl_block5_4Bytes, _wl_block5_4);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(struser));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strencounterid));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strmoduleid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounterFacilityId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block22Bytes, _wl_block22);
	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);

	//if(!function_id.equals("rcpt_rfnd"))
	/**********added  function_id.equals("PKG_BILLING") for packag billing**************/
	if(!function_id.equals("rcpt_rfnd") && !function_id.equals("PKG_BILLING"))
		{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block31Bytes, _wl_block31);

		}

            _bw.write(_wl_block32Bytes, _wl_block32);

	}catch(Exception e) {System.out.println("btn="+e.toString()); e.printStackTrace();}
finally
		{			
			ConnectionManager.returnConnection(con, request);
		}		


            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strblnggrpid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strdfltslmttypecode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(GHL_site_spec));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(result));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strBlrblprt));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(p_login_user));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(report));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(reportServer));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(server));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(report_server));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(copies));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(queue_name));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(message));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(view));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(self_submit));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(dest_locn_type));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(dest_locn_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(languageID));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(path));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(fileName));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(rep_server_key));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(cal_frm_multi_bil_slmt));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(str_bill_amt));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(doc_amt));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(str_bill_print_format_enabled_yn));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(str_rec_print_format_enabled_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(recpt_refund_ind));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(restrictEligibility ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(struser ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(strpatientid ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strClientIpAddress ));
            _bw.write(_wl_block80Bytes, _wl_block80);
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
