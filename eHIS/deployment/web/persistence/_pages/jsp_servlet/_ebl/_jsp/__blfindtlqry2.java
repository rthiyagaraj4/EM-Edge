package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.util.*;
import com.ehis.util.*;

public final class __blfindtlqry2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFinDtlQry2.jsp", 1737442772207L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script>\n/* karthik added the below function to provide the link for RecordApproval for insurance cases - starts*/\nasync function callRecordApprovalPolicyDetails(patientId,payerGroup,payer,policy,startDate,endDate,visitId,acctSeq,priority,policyNo,episodeType,episodeId){\n\n\tvar dialogHeight= \"70vh\" ;\n\tvar dialogWidth\t= \"80vw\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status: \" + status + \"; scroll=auto; \";\n\tvar arguments\t= \"\" ;\t\n\t\n\t/*var queryParams=\'mode=modify&patinetId=\'+patientId+\'&payergroupCode=\'+ payerGroup+\n\t\'&payerCode=\'+payer+\'&policyCode=\'+policy+\'&startDate=\'+startDate+\'&endDate=\'+endDate+\'&visitId=\'+visitId+\'&acctSeq=\'+acctSeq+\'&priority=\'+priority+\n\t\'&policyNo=\'+policyNo+\'&episodeType=\'+episodeType+\'&episodeId=\'+episodeId+\'&auth=N\';*/\n\t\n\tvar queryParams=\'mode=modify&patinetId=\'+patientId+\'&payergroupCode=\'+ payerGroup+\n\t\'&payerCode=\'+payer+\'&policyCode=\'+policy+\'&startDate=\'+startDate+\'&endDate=\'+endDate+\'&visitId=\'+visitId+\'&acctSeq=&priority=\'+priority+\n\t\'&policyNo=\'+policyNo+\'&episodeType=\'+episodeType+\'&episodeId=\'+episodeId+\'&auth=N\';\n\t\n\tvar retVal = await top.window.showModalDialog(\'../../eBL/jsp/RcrdApprovalPolicyDefinitionMainFrame.jsp?\'+queryParams,arguments,features);\n}\n/* karthik added the below function to provide the link for RecordApproval - ends*/\n</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!--\n\t\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script> -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<head>\n<STYLE TYPE=\"text/CSS\">\n\n/* This style is used for locking the table\'s heading  */\n\ndiv#tbl-container {\n/* width: 1020px; */\nheight: 200px;\noverflow: auto;\n}\n\nthead th, thead th.locked\t{\nposition:relative;\n}\n\nthead th {\ntop: expression(document.getElementById(\"tbl-container\").scrollTop-2); \nz-index: 20;\n}\n\ndiv#tbl-container table#tbl th#payer_id {\nwidth: 28px;\n}\n\ndiv#tbl-container table#tbl th#priority_id {\nwidth: 8px;\n}\n\ndiv#tbl-container table#tbl th#policy_id {\nwidth: 30px;\n}\n\ndiv#tbl-container table#tbl th#pol_no_id {\nwidth: 20px;\n}\n\ndiv#tbl-container table#tbl th#strt_date_id {\nwidth: 8px;\n}\n\ndiv#tbl-container table#tbl th#exp_date_id {\nwidth: 8px;\n}\n\ndiv#tbl-container table#tbl th#cred_auth_id {\nwidth: 30px;\n}\n\ndiv#tbl-container table#tbl th#cred_auth_date_id {\nwidth: 8px;\n}\n\ndiv#tbl-container table#tbl th#appr_amt_id {\nwidth: 10px;\n}\n\ndiv#tbl-container table#tbl th#appr_days_id {\nwidth: 10px;\n}\n\ndiv#tbl-container table#tbl th#eff_frm_id {\nwidth: 8px;\n}\n\ndiv#tbl-container table#tbl th#eff_to_id {\nwidth: 8px;\n}\n</STYLE>\n<SCRIPT>\nfunction displayToolTip(ref_src_main_desc,ref_src_sub_desc)\n{\t\t\n\tbuildTable(ref_src_main_desc,ref_src_sub_desc);\n\tresizeWindow();\n}\n\n\nfunction buildTable(ref_src_main_desc,ref_src_sub_desc)\n{\n\tvar ref_src_main_label=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\tvar ref_src_sub_label=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\n\tvar tab_dat  = \"<table id=\'tooltiptable1\' cellpadding=3 cellspacing=0 border=\'1\'   class=\'columnHeader\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n\n\ttab_dat\t\t+= \"<td class=\'columnHeader\' width=\'50%\'>\"+ref_src_main_label+\"</td>\";\n\ttab_dat\t\t+= \"<td class=\'columnHeader\' width=\'50%\'>\"+ref_src_sub_label+\"</td>\";\n\n\ttab_dat     += \"<tr>\";\n\n\t//tab_dat     += \"<td class=\'fields\' width=\'20%\'>\"+strDepAdjust+\"</td>\";\n\ttab_dat     += \"<td class=\'fields\' width=\'50%\'>\"+ref_src_main_desc+\"</td>\";\n\ttab_dat     += \"<td class=\'fields\' width=\'50%\'>\"+ref_src_sub_desc+\"</td>\";\n\ttab_dat     += \"</tr> \";\n\ttab_dat     += \"</table> \";\n\tdocument.getElementById(\"t\").innerHTML = tab_dat;\n}\n\nfunction resizeWindow()\n{\n\tbodwidth = parent.frames[0].document.body.offsetWidth;\n\tbodheight = parent.frames[0].document.body.offsetHeight;\n\n\tvar x =event.x;\n\tvar y =event.y;\n\n\tx = x + (document.getElementById(\"tooltiplayer\").offsetWidth);\n\ty = y + (document.getElementById(\"tooltiplayer\").offsetHeight);\n\n\tif(x<bodwidth)\n\t{\n\t\tx =event.x;\n\t}\n\telse\n\t{\n\t\tx = x - (document.getElementById(\"tooltiplayer\").offsetWidth);\n\t}\n\n\tif(y<bodheight)\n\t{\n\t\t y =event.y;\n\t}\n\telse\n\t{\n\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight);\n\t}\n\t\n\ty+=document.body.scrollTop;\n\tx+=document.body.scrollLeft;\n\n\n\tdocument.getElementById(\"tooltiplayer\").style.posLeft= x+20;\n\tdocument.getElementById(\"tooltiplayer\").style.posTop = y-220;\n\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'visible\';\n}\n\nfunction hideToolTip()\t\n{\n\t  document.getElementById(\"tooltiplayer\").style.visibility = \'hidden\'\n}\n\n\t\n</script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<form>\n<div id=\'tbl-container\'>\n<table cellpadding=3 cellspacing=0  width=\"100%\" align=\'left\' id=\'ins_data\' border=1>\n<thead>\n<tr>\n\t<th class=\'COLUMNHEADER\' colspan=\'20\' align=\'left\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n</tr>\n\n<tr >\n<!--\n\t<td class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n-->\n\t<th class=\'COLUMNHEADER\' id=\'payer_id\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" / ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<th class=\'COLUMNHEADER\' id=\'priority_id\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t<th class=\'COLUMNHEADER\' id=\'policy_id\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<th class=\'COLUMNHEADER\' id=\'pol_no_id\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t<th class=\'COLUMNHEADER\' id=\'strt_date_id\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<th class=\'COLUMNHEADER\' id=\'exp_date_id\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<th class=\'COLUMNHEADER\' id=\'cred_auth_id\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<th class=\'COLUMNHEADER\' id=\'cred_auth_date_id\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t<th class=\'COLUMNHEADER\' id=\'appr_amt_id\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" </td>\n\t<th class=\'COLUMNHEADER\' id=\'appr_days_id\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </td>\n\t<th class=\'COLUMNHEADER\' id=\'eff_frm_id\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t<th class=\'COLUMNHEADER\' id=\'eff_to_id\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n</tr>\n</thead>\n<tbody>\n<!--</table>\n<table cellpadding=3 cellspacing=0  width=\"100%\" align=\'left\' id=\'ins_data\' border=1>-->\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n<tr>\n\t\t\t<td class=\'PATIENTLINECOLOR\' colspan=2>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t<td class=\'PATIENTLINECOLOR\' colspan=2>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\n\t\t\t<td class=\'PATIENTLINECOLOR\' colspan=2>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t<td class=\'PATIENTLINECOLOR\' colspan=2>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;<img src=\'../../eCommon/images/more.gif\' style=\"visibility:inline\" alt=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</td>\n\t\t\t<td class=\'PATIENTLINECOLOR\' colspan=2>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\n\t\t\t</td>\n</tr>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<tr id=row";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">\n<!--\n\t\t\t<td class=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" ><a href=\'#\' onMouseOver=\'displayToolTip(\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\",\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\")\' onMouseOut=\'hideToolTip()\' onFocus=\'displayToolTip(\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\")\'\n\t\t\tonBlur=\'hideToolTip()\' >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</a></td>\n-->\n\t\t\t<input type=hidden name=\'blng_grp_id";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'blng_grp_id";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t<td class=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t<input type=hidden name=\'cust_3";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' id=\'cust_3";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' value=\'\'><input type=hidden name=\'cust_3_group_name";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'cust_3_group_name";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t<td class=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="  ><!-- Karthik added link here -->\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t</a>\n\t\t\t</td>\n\t\t\t<input type=hidden name=\'policy_type_code";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'policy_type_code";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" \n\t\t\t<a name=\'\' href=\"#\" onClick=\"callRecordApprovalPolicyDetails(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\',\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\">\n\t\t\t(dtls)\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t\t<td  class=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n</tr>\n\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n</tbody>\n</table>\n</div>\t\n</table>\n\n\n<input type= \'hidden\' name=\"strBillGrp\" id=\"strBillGrp\"  value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<input type=\'hidden\' name=\'strFamIn\' id=\'strFamIn\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<input type=\'hidden\' name=\'NoDep\' id=\'NoDep\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n<input type=\'hidden\' name=\'strPatRel\' id=\'strPatRel\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<input type=\'hidden\' name=\'strGLHol\' id=\'strGLHol\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<input type=\'hidden\' name=\'strResPay\' id=\'strResPay\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<input type=\'hidden\' name=\'strPatRelGL\' id=\'strPatRelGL\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<input type=\'hidden\' name=\'strAdmFlag\' id=\'strAdmFlag\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n<input type=\'hidden\' name=\'strCrdDocRef\' id=\'strCrdDocRef\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<input type=\'hidden\' name=\'strSetInd\' id=\'strSetInd\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n<input type=\'hidden\' name=\'strFamAss\' id=\'strFamAss\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n<input type=\'hidden\' name=\'strNonInsBlGrId\' id=\'strNonInsBlGrId\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n<input type=\'hidden\' name=\'strNonInsCustCode\' id=\'strNonInsCustCode\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n<input type=\'hidden\' name=\'strCrDocRefStDate\' id=\'strCrDocRefStDate\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n<input type=\'hidden\' name=\'strCrDocRefEndDate\' id=\'strCrDocRefEndDate\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:relative; width:75%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t<table id=\'tooltiptable\' cellpadding=3 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n</form>\n</body>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n</html>\n\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	HttpSession httpSession = request.getSession(false);  
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String locale	= (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	Connection con = ConnectionManager.getConnection(request);
	CallableStatement call =null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;ResultSet rs3 = null;

	String facility_id = "";
	String login_user = "";
	String strepisodetype=""; 
	String strepisodeid ="";
	String strvisitid="";
	String strpatientid=""; 
//Unused Var's
/*
	String gross_amt="";
	String serv_disc_amt="";
	String other_disc_amt="";
	String unbilled_amt = "";
	String outst_amt =  "";
	String deposit_amt =  "";
	String prepay_amt =  "";
	String refundable_deposit_amt =  "";
	String surgery_deposit_amt =  "";
	String pkg_deposit_amt =  "";
	String strAllParam = "";
*/
	String strSetInd = "";
	String strAdmFlag = "";
	String strFamIn = "";
	String strFamAss  = "";
	String strNoDep = "";
	String strNonInsBlGrId = "";
	String strNonInsCustCode = "";
	String strGLHol  = "";
	String strPatRel  = "";
	String strBillGrp = "";
	String strPatRelGL = "";
	String strCrdDocRef = "";
	String strCrDocRefStDate = "";
	String strCrDocRefEndDate = "";
	String strResPay  = "";
	String strPatRelnRespPers=""; 	 
	
//	int intNoDep=0;
//	String short_desc="";
//	String customerid="";
//	String customergroup="";
	String blng_grp_id="";
	String blng_grp_desc="";
	String cust_group_code= "";
	String cust_group_desc= "";
    String cust_code ="";
	String customer_name = "";
	String priority = "";
	String policy_type_code = "";
	String policy_type_desc = "";
	String policy_number = "";
	String policy_start_date = "";
	String policy_expiry_date = "";
	String credit_auth_ref = "";
	String credit_auth_date = "";
	String effective_from = "";
	String effective_to = "";
	String approved_amt = "";
	String approved_days = "";
	String adj_rule_ind = "";
	String adj_rule_desc = "";
	String adj_perc_amt_ind = "";
	String adj_perc_amt_ind2 = "";
	String adj_perc_amt_value = "";
	String pmnt_diff_adj_int = "";
	String drg_pmnt_diff_adj_int= "";
	String spl_srv_pmnt_diff_adj_int = "";
	String ins_ref_src_main_code="",ins_ref_src_main_desc="",ins_ref_src_sub_code="",ins_ref_src_sub_desc="";
	String ins_referral_source_code_flag="N";

	String ins_ref_src_main_lng_name="", ins_ref_src_sub_lng_name="";
//	String non_ins_customer_name ="";
//	String strnoninsbillinggroup ="";
//	String strnoninsbillinggroup1 = "";
	String strCurrAcctSeqNo="";
	int noofdecimal = 2;
	String classval="";
	int i=0;
	String desc="", tempDesc="";

	String  strCharge_logic="";
//	String sql1="";
//	String sqlnoncust="";
	String sqlpayerdet="";

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		if(facility_id==null) facility_id="";

		login_user =  p.getProperty("login_user");
		if(login_user==null) login_user="";
		
		strepisodetype = request.getParameter("episodetype");
		if(strepisodetype==null) strepisodetype="";
		
		strepisodeid  = request.getParameter("episodeid");
		if(strepisodeid==null) strepisodeid="";
		
		strvisitid = request.getParameter("visitid");
		if(strvisitid==null) strvisitid="";
		
		strpatientid= request.getParameter("patientid");
		if(strpatientid==null) strpatientid="";
		
		strBillGrp =	request.getParameter("strBillGrp");		
		if(strBillGrp==null) strBillGrp="";
		
		strSetInd =	request.getParameter("strSetInd");	
		if(strSetInd==null) strSetInd="";
		
		strAdmFlag =	request.getParameter("strAdmFlag");	
		if(strAdmFlag==null) strAdmFlag="";
		
		strFamIn =	request.getParameter("strFamIn");	
		if(strFamIn==null) strFamIn="";
		
		strFamAss =	request.getParameter("strFamAss");	
		if(strFamAss==null) strFamAss="";
		
		strNoDep =	request.getParameter("strNoDep");	
		if(strNoDep==null) strNoDep="0";
		
		strNonInsBlGrId =	request.getParameter("strNonInsBlGrId");	
		if(strNonInsBlGrId==null) strNonInsBlGrId="";
		
		strNonInsCustCode =	request.getParameter("strNonInsCustCode");	
		if(strNonInsCustCode==null) strNonInsCustCode="";
		
		strGLHol =	request.getParameter("strGLHol");
		if(strGLHol==null) strGLHol="";
		
		strPatRel =	request.getParameter("strPatRel");	
		if(strPatRel==null) strPatRel="";
		
		strPatRelGL =	request.getParameter("strPatRelGL");	
		if(strPatRelGL==null) strPatRelGL="";
		
		strCrdDocRef =	request.getParameter("strCrdDocRef");
		if(strCrdDocRef==null) strCrdDocRef="";
		
		strCrDocRefStDate =	request.getParameter("strCrDocRefStDate");
		if(strCrDocRefStDate==null) strCrDocRefStDate="";
		
		strCrDocRefEndDate =	request.getParameter("strCrDocRefEndDate");
		if(strCrDocRefEndDate==null) strCrDocRefEndDate="";
		
		strResPay =	request.getParameter("strResPay");
		if(strResPay==null) strResPay="";
		
		strPatRelnRespPers =	request.getParameter("strPatRelnRespPers");
		if(strPatRelnRespPers==null) strPatRelnRespPers="";

		strCurrAcctSeqNo=request.getParameter("strCurrAcctSeqNo");
		if(strCurrAcctSeqNo==null) strCurrAcctSeqNo="";
		
//		intNoDep=Integer.parseInt(strNoDep);		

/*		
		try
		{
			if(!strNonInsBlGrId.equals(""))
			{
				sql1="SELECT short_desc non_ins_billing_group, "+
				" a.settlement_ind non_ins_billing_group1, "+      		
				" b.adm_rec_flag non_ins_adm_rec_flag,	"+
				" FROM bl_blng_grp_lang_vw  "+
				" WHERE blng_grp_id = '"+strNonInsBlGrId+"' "+
				" AND language_id = '"+locale+"' ";

				pstmt = con.prepareStatement(sql1);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					strnoninsbillinggroup = rs.getString(1);
					strnoninsbillinggroup1 = rs.getString(2);
				}
			}//closing if
		}//try
		catch(Exception e)
		{
			System.out.println("Exception in Non ins blng_grp Query:"+e.toString());
		}
*/		
		//to get non ins cust code
/*
		try
		{
			if (!strNonInsCustCode.equals(""))
			{
				sqlnoncust="SELECT short_name non_ins_customer_name "+
					" FROM ar_customer_lang_vw "+
					" WHERE cust_code = '"+strNonInsCustCode+"' "+
					" AND language_id = '"+locale+"' ";
 
				pstmt = con.prepareStatement(sqlnoncust);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					non_ins_customer_name = rs.getString(1);	
				}
			}//closing if
		}//closing try 
		catch(Exception e)
		{
			System.out.println("Exception in non_ins_cust_code query:"+e.toString());
		}
*/
/*
		try
		{
			if (!strNonInsBlGrId.equals(""))
			{
				sqlpayerdet="SELECT a.cust_code cust_code,    "+                                          
				" b.short_name customer_name, "+
				" a.priority priority,          "+                                     
				" a.policy_type_code policy_type_code, "+                                       
				" c.short_desc policy_type_desc, "+
				" a.policy_number policy_number,   "+ 
				" TO_CHAR(a.policy_start_date,'DD/MM/YYYY') policy_start_date , "+ 
				" TO_CHAR(a.policy_expiry_date,'DD/MM/YYYY') policy_expiry_date , "+ 
				" a.credit_auth_ref credit_auth_ref,   "+                               
				" TO_CHAR(a.credit_auth_date,'DD/MM/YYYY') credit_auth_date,  "+  
				" TO_CHAR(a.effective_from,'DD/MM/YYYY') effective_from,     "+     
				" TO_CHAR(a.effective_to,'DD/MM/YYYY') effective_to,         "+    
				" a.approved_amt approved_amt,     "+  
				" a.approved_days approved_days,   "+                      
				" a.adj_rule_ind adj_rule_ind,  "+                   
				" DECODE(a.adj_rule_ind,'A','Automatic','Not Applicable') adj_rule_desc,"+      
			    " a.adj_perc_amt_ind adj_perc_amt_ind,  "+	 
				" DECODE(a.adj_perc_amt_ind,'A','Amount','P','Percentage') adj_perc_amt_ind, "+    
				" a.adj_perc_amt_value adj_perc_amt_value,        "+
				" a.pmnt_diff_adj_int pmnt_diff_adj_int,             "+
				" a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,        "+  
				" a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int  "+   
				" FROM bl_encounter_payer_priority a, "+
				" ar_customer_lang_vw b, "+
				" bl_ins_policy_types_lang_vw c "+
				" WHERE a.operating_facility_id = '"+facility_id+"'  "+
				 " AND a.episode_type = '"+strepisodetype+"'  "+
				 " AND ((a.patient_id = '"+strpatientid+"' AND a.episode_type = 'R') OR "+
				 " (a.episode_id = '"+strepisodeid +"' AND a.visit_id = '"+strvisitid+"' AND a.episode_type IN ('O','E')) OR "+
				" (a.episode_id = '"+strepisodeid +"' AND a.episode_type IN ('I','D'))) "+
				 " AND b.cust_code = a.cust_code "+
				 " AND b.language_id = '"+locale+"' "+
				" AND c.operating_facility_id = a.operating_facility_id "+
				" AND c.policy_type_code = a.policy_type_code "+
				 " AND c.language_id = '"+locale+"' ";
				pstmt = con.prepareStatement(sqlpayerdet);
				rs = pstmt.executeQuery() ;
				while(rs.next())
				{
					cust_code = rs.getString(1);
					customer_name = rs.getString(2);
					priority = rs.getString(3);
					policy_type_code = rs.getString(4);
					policy_type_desc = rs.getString(5);
					policy_number = rs.getString(6);
					policy_start_date = rs.getString(7);
					policy_expiry_date = rs.getString(8);
					credit_auth_ref = rs.getString(9);
					credit_auth_date = rs.getString(10);
					effective_from = rs.getString(11);
					effective_to = rs.getString(12);
					approved_amt = rs.getString(13);
					approved_days = rs.getString(14);
					adj_rule_ind = rs.getString(15);
					adj_rule_desc = rs.getString(16);
					adj_perc_amt_ind = rs.getString(17);
					adj_perc_amt_ind2 = rs.getString(18);	
					adj_perc_amt_value = rs.getString(19);
					pmnt_diff_adj_int = rs.getString(20);
					drg_pmnt_diff_adj_int= rs.getString(21);
					spl_srv_pmnt_diff_adj_int = rs.getString(22);
				}
				if (cust_code == null) cust_code = "";
				if (customer_name == null) customer_name = "";
				if (priority == null) priority = "";
				if (policy_type_code == null) policy_type_code = "";
				if (policy_type_desc == null) policy_type_desc = "";
				if (policy_number == null) policy_number = "";
				if (policy_start_date == null) policy_start_date = "";
				if (customer_name == null) customer_name = "";
				if (priority == null) priority = "";
				if (policy_expiry_date == null) policy_expiry_date = "";
				if (credit_auth_ref == null) credit_auth_ref = "";
				if (credit_auth_date == null) credit_auth_date = "";
				if (effective_from == null) effective_from = "";
				if (effective_to == null) effective_to = "";
				if (priority == null) priority = "";
				if (approved_amt == null) approved_amt = "";
				if (approved_days == null) approved_days = "";
				if (adj_rule_desc == null) adj_rule_desc = "";
				if (adj_perc_amt_ind == null) adj_perc_amt_ind = "";
				if (adj_perc_amt_ind2 == null) adj_perc_amt_ind2 = "";
				if (adj_perc_amt_value == null) adj_perc_amt_value = "";
				if (pmnt_diff_adj_int == null) pmnt_diff_adj_int = "";
				if (drg_pmnt_diff_adj_int == null) drg_pmnt_diff_adj_int = "";
				if (spl_srv_pmnt_diff_adj_int == null) spl_srv_pmnt_diff_adj_int = "";

			}	//closing if
		}	//closing try
		catch(Exception e)
		{
			System.out.println("3="+e.toString());
		}
*/
		

            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
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

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);


		if (!strNonInsBlGrId.equals(""))
		{		
			
			try
			{
			String policyValidQry="select NVL(charge_logic_yn,'N') from bl_parameters  where operating_facility_id ='"+facility_id+"'";

			
				pstmt = con.prepareStatement(policyValidQry);
				rs=pstmt.executeQuery();
				if( rs != null ) 
				{
					while(rs.next())
					{
						strCharge_logic=rs.getString(1);					
						
					}
				}
				if(rs != null) rs.close();		if(pstmt != null) pstmt.close();
			}catch(Exception ee)	{}
			
			
			sqlpayerdet="SELECT a.blng_grp_id blng_grp_id,"+
						"d.long_desc long_desc,    "+                                          
						"a.cust_code cust_code,    "+                                          
						" b.short_name customer_name, "+
						" a.priority priority,          "+                                     
						" a.policy_type_code policy_type_code, "+                                       
						" c.short_desc policy_type_desc, "+
						" a.policy_number policy_number,   "+ 
						" TO_CHAR(a.policy_start_date,'DD/MM/YYYY') policy_start_date , "+ 
						" TO_CHAR(a.policy_expiry_date,'DD/MM/YYYY') policy_expiry_date , "+ 
						" a.credit_auth_ref credit_auth_ref,   "+                               
						" TO_CHAR(a.credit_auth_date,'DD/MM/YYYY') credit_auth_date,  "+  
						" TO_CHAR(a.effective_from,'DD/MM/YYYY') effective_from,     "+     
						" TO_CHAR(a.effective_to,'DD/MM/YYYY') effective_to,         "+    
						" a.approved_amt approved_amt,     "+  
						" a.approved_days approved_days,   "+                      
						" a.adj_rule_ind adj_rule_ind,  "+                   
						" DECODE(a.adj_rule_ind,'A','Automatic','Not Applicable') adj_rule_desc,"+      
					    " a.adj_perc_amt_ind adj_perc_amt_ind,  "+	 
						" DECODE(a.adj_perc_amt_ind,'A','Amount','P','Percentage') adj_perc_amt_ind, "+    
						" a.adj_perc_amt_value adj_perc_amt_value,        "+
						" a.pmnt_diff_adj_int pmnt_diff_adj_int,             "+
						" a.drg_pmnt_diff_adj_int drg_pmnt_diff_adj_int,        "+  
						" a.spl_srv_pmnt_diff_adj_int spl_srv_pmnt_diff_adj_int,  "+ 
						" a.referral_source_code_main referral_source_code_main,  "+ 
						" a.referral_source_code_sub referral_source_code_sub,  "+ 
						" a.cust_group_code cust_group_code,  "+ 
						" e.short_desc cust_group_desc "+
						" FROM bl_encounter_payer_priority a, "+
						" ar_customer_lang_vw b, "+
						" bl_ins_policy_types_lang_vw c, "+
						" bl_blng_grp_lang_vw d, "+
						" ar_cust_group_lang_vw e "+
						" WHERE a.operating_facility_id = '"+facility_id+"'  "+
						" AND a.episode_type = '"+strepisodetype+"'  ";
						if(!strpatientid.equals(""))
						{
							sqlpayerdet=sqlpayerdet+" AND a.patient_id = '"+strpatientid+"'";
						}
						sqlpayerdet=sqlpayerdet+" AND ((a.patient_id = '"+strpatientid+"' AND a.episode_type = 'R') OR "+
						" (a.episode_id = '"+strepisodeid +"' AND a.visit_id = '"+strvisitid+"' AND a.episode_type IN ('O','E')) OR "+
						" (a.episode_id = '"+strepisodeid +"' AND a.episode_type IN ('I','D'))) "+
						" AND a.blng_grp_id = d.blng_grp_id "+
						" AND b.cust_code = a.cust_code "+
						" AND a.cust_group_code = e.cust_group_code "+
						" AND b.language_id = '"+locale+"' "+
						" AND a.ACCT_SEQ_NO = '"+strCurrAcctSeqNo+"' "+
						" AND c.operating_facility_id = a.operating_facility_id "+
						" AND c.policy_type_code = a.policy_type_code "+
						" AND c.language_id = '"+locale+"'"+
						" AND d.language_id = '"+locale+"'"+
						" AND e.language_id = '"+locale+"'"+
						" ORDER BY priority ";
			
//			System.out.println("sqlpayerdet;"+sqlpayerdet);
			pstmt = con.prepareStatement(sqlpayerdet);
			rs = pstmt.executeQuery() ;
			
			while(rs.next())
			{
				blng_grp_id=rs.getString(1);
				blng_grp_desc=rs.getString(2);
				cust_code = rs.getString(3);
				customer_name = rs.getString(4);
				priority = rs.getString(5);
				policy_type_code = rs.getString(6);
				policy_type_desc = rs.getString(7);
				policy_number = rs.getString(8);

				policy_start_date = rs.getString(9);
				if(policy_start_date==null) policy_start_date="";
				if(!policy_start_date.equals(""))
					policy_start_date=com.ehis.util.DateUtils.convertDate(policy_start_date,"DMY","en",locale);

				policy_expiry_date = rs.getString(10);
				if(policy_expiry_date==null) policy_expiry_date="";
				if(!policy_expiry_date.equals(""))
					policy_expiry_date=com.ehis.util.DateUtils.convertDate(policy_expiry_date,"DMY","en",locale);

				credit_auth_ref = rs.getString(11);
				
				credit_auth_date = rs.getString(12);
				if(credit_auth_date==null) credit_auth_date="";
				if(!credit_auth_date.equals(""))
					credit_auth_date=com.ehis.util.DateUtils.convertDate(credit_auth_date,"DMY","en",locale);
		
				effective_from = rs.getString(13);
				if(effective_from==null) effective_from="";
				if(!effective_from.equals(""))
					effective_from=com.ehis.util.DateUtils.convertDate(effective_from,"DMY","en",locale);
				
				effective_to = rs.getString(14);
				if(effective_to==null) effective_to="";
				if(!effective_to.equals(""))
					effective_to=com.ehis.util.DateUtils.convertDate(effective_to,"DMY","en",locale);

				approved_amt = rs.getString(15);
				approved_days = rs.getString(16);
				adj_rule_ind = rs.getString(17);
				adj_rule_desc = rs.getString(18);
				adj_perc_amt_ind = rs.getString(19);
				adj_perc_amt_ind2 = rs.getString(20);	
				adj_perc_amt_value = rs.getString(21);
				pmnt_diff_adj_int = rs.getString(22);
				drg_pmnt_diff_adj_int= rs.getString(23);
				spl_srv_pmnt_diff_adj_int = rs.getString(24);

				ins_ref_src_main_code= rs.getString(25);
				ins_ref_src_sub_code= rs.getString(26);

				cust_group_code = rs.getString(27);
				cust_group_desc = rs.getString(28);

				if(blng_grp_id == null) blng_grp_id="";
				if(blng_grp_desc == null) blng_grp_desc="";
				if (cust_code == null) cust_code = "";
				if (customer_name == null) customer_name = "";
				if (priority == null) priority = "";
				if (policy_type_code == null) policy_type_code = "";
				if (policy_type_desc == null) policy_type_desc = "";
				if (policy_number == null) policy_number = "";
				if (policy_start_date == null) policy_start_date = "";
				if (customer_name == null) customer_name = "";
				if (priority == null) priority = "";
				if (policy_expiry_date == null) policy_expiry_date = "";

				if (credit_auth_ref == null || credit_auth_ref.equals("")) credit_auth_ref = "&nbsp;";
				if (credit_auth_date == null || credit_auth_date.equals("")) credit_auth_date = "&nbsp;";
				if (effective_from == null) effective_from = "";
				if (effective_to == null || effective_to.equals("")) effective_to = "&nbsp;";
				if (priority == null) priority = "";
				if (approved_amt == null || approved_amt.equals("")) approved_amt = "&nbsp;";
				if (approved_days == null || approved_days.equals("")) approved_days = "&nbsp;";
				if (adj_rule_desc == null) adj_rule_desc = "";
				if (adj_perc_amt_ind == null) adj_perc_amt_ind = "";
				if (adj_perc_amt_ind2 == null) adj_perc_amt_ind2 = "";
				if (adj_perc_amt_value == null) adj_perc_amt_value = "";
				if (pmnt_diff_adj_int == null) pmnt_diff_adj_int = "";
				if (drg_pmnt_diff_adj_int == null) drg_pmnt_diff_adj_int = "";
				if (spl_srv_pmnt_diff_adj_int == null) spl_srv_pmnt_diff_adj_int = "";
				if (ins_ref_src_main_code == null) ins_ref_src_main_code = "";
				if (ins_ref_src_main_desc == null) ins_ref_src_main_desc = "";
				if (ins_ref_src_sub_code == null) ins_ref_src_sub_code = "";
				if (ins_ref_src_sub_desc == null) ins_ref_src_sub_desc = "";
				if (cust_group_code == null) cust_group_code = "";
				if (cust_group_desc == null) cust_group_desc = "";

				desc = blng_grp_desc;

				if(!ins_ref_src_main_code.equals(""))
				{
					call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
					call.registerOutParameter(1,java.sql.Types.VARCHAR);

					call.setString(2,ins_ref_src_main_code);
					call.setString(3,locale);
					call.setString(4,"1");

					call.execute();							
					ins_ref_src_main_desc = call.getString(1);				
					call.close();
					if ( ins_ref_src_main_desc == null ) ins_ref_src_main_desc = "&nbsp;";

					call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
					call.registerOutParameter(1,java.sql.Types.VARCHAR);

					call.setString(2,ins_ref_src_main_code);
					call.setString(3,locale);
					call.setString(4,"3");

					call.execute();							
					ins_ref_src_main_lng_name = call.getString(1);				
					call.close();
					if ( ins_ref_src_main_lng_name == null ) ins_ref_src_main_lng_name = "";
				}
				else
				{
					ins_ref_src_main_desc = "&nbsp;";
					ins_ref_src_main_lng_name = "";
				}

				if(!ins_ref_src_sub_code.equals(""))
				{
					call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
					call.registerOutParameter(1,java.sql.Types.VARCHAR);

					call.setString(2,ins_ref_src_sub_code);
					call.setString(3,locale);
					call.setString(4,"1");

					call.execute();							
					ins_ref_src_sub_desc = call.getString(1);				
					call.close();
					if ( ins_ref_src_sub_desc == null ) ins_ref_src_sub_desc = "&nbsp;";

					call = con.prepareCall("{ ? = call  am_get_desc.AM_REFERRAL(?,?,?)}");
					call.registerOutParameter(1,java.sql.Types.VARCHAR);

					call.setString(2,ins_ref_src_sub_code);
					call.setString(3,locale);
					call.setString(4,"3");

					call.execute();							
					ins_ref_src_sub_lng_name = call.getString(1);				
					call.close();
					if ( ins_ref_src_sub_lng_name == null ) ins_ref_src_sub_lng_name = "";
				}
				else
				{
					ins_ref_src_sub_desc = "&nbsp;";
					ins_ref_src_sub_lng_name = "";
				}

				String ins_ref_src_code_valid_qry="select nvl(CAPTURE_REF_SOURCE_DTL_YN,'N') from bl_blng_grp where BLNG_GRP_ID='"+blng_grp_id+"'";
		
				try
				{
					pstmt = con.prepareStatement(ins_ref_src_code_valid_qry);
					rs3 = pstmt.executeQuery() ;
					if( rs3 != null ) 
					{	
						while( rs3.next() )
						{  
							ins_referral_source_code_flag = rs3.getString(1);
						}
					}
					if (rs3 != null) rs3.close();
					pstmt.close();	
				}
				catch(Exception e)
				{
					System.out.println("Exception in ref_src_code_valid_qry:"+e);
				}
				if(ins_referral_source_code_flag == null) ins_referral_source_code_flag="N";

				if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}

				try
				{
					pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
					rs3		= pstmt.executeQuery();	
					while(rs3.next())
					{
						noofdecimal  =  rs3.getInt(1);		
					}
					rs3.close();
					pstmt.close();
		
					CurrencyFormat cf = new CurrencyFormat();
					if(!approved_amt.equals("") && !approved_amt.equals("&nbsp;"))
					{
						approved_amt = cf.formatCurrency(approved_amt, noofdecimal);
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception in currency format query:"+e.toString());
				}

	if((!desc.equals("") && tempDesc.equals("")) || (!desc.equals(tempDesc)))
	{

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

			if(!ins_ref_src_main_lng_name.equals(""))
			{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ins_ref_src_main_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ins_ref_src_main_lng_name));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
			else
			{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ins_ref_src_main_desc));
            _bw.write(_wl_block1Bytes, _wl_block1);

			}

            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

			if(!ins_ref_src_sub_lng_name.equals(""))
			{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ins_ref_src_sub_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(ins_ref_src_sub_lng_name));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
			else
			{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ins_ref_src_sub_desc));
            _bw.write(_wl_block1Bytes, _wl_block1);

			}


            _bw.write(_wl_block34Bytes, _wl_block34);

	}

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ins_ref_src_main_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ins_ref_src_sub_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ins_ref_src_main_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ins_ref_src_sub_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(blng_grp_desc.equals("null")?"":blng_grp_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(cust_group_desc.equals("null")?"":cust_group_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(customer_name.equals("null")?"":customer_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(customer_name.equals("null")?"":customer_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(priority.equals("null")?"":priority));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(policy_type_desc.equals("null")?"":policy_type_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(policy_type_code.equals("null")?"":policy_type_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(policy_number.equals("null")?"":policy_number));
            _bw.write(_wl_block54Bytes, _wl_block54);
if(strCharge_logic.equals("Y")){ 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(cust_group_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(policy_type_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(effective_from));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(effective_to));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strCurrAcctSeqNo));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(policy_number));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block57Bytes, _wl_block57);
} 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(policy_start_date.equals("null")?"":policy_start_date));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(policy_expiry_date.equals("null")?"":policy_expiry_date));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(credit_auth_ref.equals("null")?"":credit_auth_ref));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(credit_auth_date.equals("null")?"":credit_auth_date));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(approved_amt.equals("null")?"":approved_amt));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(approved_days.equals("null")?"":approved_days));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(effective_from.equals("null")?"":effective_from));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(effective_to.equals("null")?"":effective_to));
            _bw.write(_wl_block60Bytes, _wl_block60);

				i++;
				tempDesc=desc;
			}//closing WHILE
			rs.close();
			pstmt.close();
	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strBillGrp));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(strFamIn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strNoDep));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(strPatRel));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(strGLHol));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(strResPay));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(strPatRelGL));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(strAdmFlag));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(strCrdDocRef));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strSetInd));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(strFamAss));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(strNonInsBlGrId));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(strNonInsCustCode));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(strCrDocRefStDate));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(strCrDocRefEndDate));
            _bw.write(_wl_block76Bytes, _wl_block76);

		}
	}
	catch(Exception eX)
	{
			System.out.println("Error in Qry2.jsp= "+eX);
	}
	finally
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

            _bw.write(_wl_block77Bytes, _wl_block77);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PMY_REF_SRC.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEC_REF_SRC.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INS_DTL_DOC_REF.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_NO.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_AUTH.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_AUTH_DATE.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_AMT.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVED_DAY.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveTo.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PMY_REF_SRC.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SEC_REF_SRC.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
