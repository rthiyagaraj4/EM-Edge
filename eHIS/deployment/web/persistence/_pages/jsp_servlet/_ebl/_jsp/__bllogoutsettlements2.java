package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import com.google.gson.JsonObject;

public final class __bllogoutsettlements2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLLogoutSettlements2.jsp", 1737916169142L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script>\nfunction funSubmit()\n{\n\t//alert(\"close\");\n\tvar locale=document.forms[0].locale.value;\t\t\n\tvar dat1=getCurrentDate(\'DMYHMS\',locale);\n\tparent.top_frame.document.forms[0].logout_time.value=dat1;\n\tvar cashcounter = parent.top_frame.document.forms[0].cashcounter.value;\n\t\n\tvar login_time=$(parent.top_frame.document).find(\'#login_time\').val();\n\tvar logout_time=$(parent.top_frame.document).find(\'#logout_time\').val();\n\tvar cashcounter1=$(parent.top_frame.document).find(\'#cashcounter\').val();\n\tvar facility_id=$(\'#facility_id\').val();\n\tvar site_id = \'\';\n\tvar outst = \'\';\n\tvar billcount_KDAH = \'\';\n\tvar billcount_MC = \'\';\n\t\n//alert(\"close1\");\n\t$.ajax({\n\t\ttype : \'POST\',\n\t\turl : \"../jsp/BLLogoutSettlementAjax.jsp?cashcounter1=\"+cashcounter1+\"&login_time=\"+login_time+\"&logout_time=\"+logout_time+\"&facility_id=\"+facility_id,\n\t\tasync\t: false,\n\t\tdataType: \"json\",\n\t\tsuccess : function(data) {\n\t\t//\talert(\"inside the ajas call\");\n\t\t  site_id = data.site_id;\n\t\t  //alert(\"site_id: \"+site_id);\n\t\t outst =  data.outst;\t\n\t\t//\talert(\"outst: \"+outst);\t\t \n\t\t billcount_KDAH = data.billcount_KDAH;\n\t\t// alert(\"billcount_KDAH: \"+billcount_KDAH);\n\t\t billcount_MC = data.billcount_MC;\n\t\t// alert(\"billcount_MC: \"+billcount_MC);\n\t\t}\n\t}); \n\t\n\t//alert(\"close2\");\n\t//alert(\"3\");\n\t if( site_id ==\'KDAH\'){\n\t\t \n\t\t alert(\"close3\");\n\t\tif( outst ==\'Y\'){\n\t\t\tif(billcount_KDAH != \'0\'){\n\t\t\t\talert(getMessage(\"BL9099\",\"BL\"));\n\t\t\t\treturn;\n\t\t\t}\n\t\t}\n\t}\n\tif(site_id == \'MC\'){\n\t\t//alert(\"4\");\n\t\tif(outst == \'Y\'){\n\t\t\tif(billcount_MC != \'0\'){\t\n\t\t\t\talert(getMessage(\"BL9099\",\"BL\"));\n\t\t\t\treturn;\n\t\t\t}\n\t\t} \n\t}\n\t\n\tif ( (cashcounter == \'\') || (cashcounter == null) ||(cashcounter == \' \') )\t\n\t{\t\n//alert(\"5\");\n\t\talert(getMessage(\'BL9538\',\'BL\'));\n\t\treturn(false);\n\t}\n\t//document.forms[0].close_button.disabled = true;\n\tif (parent.detail_frame.funValidate()== true)\n\t{\t\n//alert(\"6\");\n\t\tparent.detail_frame.document.forms[0].submit();\t\n\t\t//setTimeout(\'call_frames()\',1000);\n//\t\tparent.parent.frames[1].location.href =\'../../eBL/jsp/BLLogoutCashCounterMain.jsp\';\t\n//\t\tparent.frames.top_frame.location.href=\'../../eBL/jsp/BLLogoutCashCounter.jsp\';\n\t\t//Added for MMS-ME-SCF-0014 \n\t\tdocument.getElementById(\"close_button\").disabled=true;\n\t\t//Added for MMS-ME-SCF-0014 \n\t}\n}\nfunction call_frames()\n{\n\tparent.parent.frames[1].location.href =\'../../eBL/jsp/BLLogoutCashCounterMain.jsp\';\t\n//\tparent.top_frame.location.href=\'../../eBL/jsp/BLLogoutCashCounter.jsp\';\n}\n/*function totDesAmt()\n{\n\tvar tot_des_amt = parent.detail_frame.document.forms[0].tot_dis.value;\n\tif(tot_des_amt != 0)\n\t{\n\t alert(getMessage(\'BL1288\',\'BL\'));\n\t \n\treturn ;\n\t}\n\t}*/\n\n\nfunction funClose()\n{\n\t\n\tvar called_frm = document.forms[0].called_frm.value;\n\t//parent.window.close();\n\tparent.parent.frames[1].location.href =\'../../eCommon/html/blank.html\' ;\n\tif(called_frm == \"DISC_FUN\")\n\t{\n\t\twindow.close();\n\t}\n\t\n}\nasync function funQry()\n{\n\t\n\tvar retVal = \tnew String();\n\tvar cashcounter = parent.top_frame.document.forms[0].cashcounter.value;\n\tvar login_time =  parent.top_frame.document.forms[0].login_time.value;\n\t\n\tvar dialogTop\t\t\t= \"195\";\n\tvar dialogHeight\t\t= \"400px\" ;\n\tvar dialogWidth\t\t\t= \"700px\" ;\n\tvar features\t\t\t=\"dialogTop:\"+dialogTop+\";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t=\"\";\n\tvar facility_id = document.forms[0].facility_id.value;\n//\tvar title=\"Cashier Settlements\";\n\n\tvar title=getLabel(\"eBL.CASHIER_SETTLEMENTS.label\",\"BL\");\n\n\tvar column_sizes = escape(\"15%,10%,5%,10%,10%,10%,5%,5%,5%,5%\");               \n\t\n//\tvar column_descriptions = escape(\"Receipt Time,Cash Counter,Shift,Doc. Type ,Doc. No,Doc. Amount,Type ,Nature,Slmt,Status\");\n\tvar receipttimelb=getLabel(\"eBL.RECEIPT_TIME.label\",\"BL\");\n\tvar cashcounterlb=getLabel(\"eBL.CASH_COUNTER.label\",\"BL\");\n\tvar shiftlb=getLabel(\"Common.SHIFT.label\",\"common\");\n\tvar doctypelb=getLabel(\"Common.documenttype.label\",\"common\");\n\tvar docnolb=getLabel(\"Common.DocumentNumber.label\",\"common\");\n\tvar docamtlb=getLabel(\"eBL.DOC_AMT.label\",\"BL\");\n\tvar typelb=getLabel(\"Common.type.label\",\"common\");\n\tvar naturelb=getLabel(\"Common.Nature.label\",\"common\");\n\tvar slmtlb=getLabel(\"eBL.SLMT.label\",\"BL\");\n\tvar statuslb=getLabel(\"Common.cancelled.label\",\"common\");\n\t\n\t\n\tvar column_descriptions =receipttimelb+\",\"+cashcounterlb+\",\"+shiftlb+\",\"+doctypelb +\",\"+docnolb+\",\"+docamtlb+\",\"+typelb+\",\"+naturelb+\",\"+slmtlb+\",\"+statuslb;\n\t\n\tvar sql = escape(\" select to_char(TRX_DATE_TIME,\'dd/mm/yyyy hh24:mi:ss\') TRX_DATE_TIME,CASH_COUNTER_CODE,SHIFT_ID,DOC_TYPE_CODE,DOC_NUMBER||\'/\'||DOC_SRNO,DOC_AMT DOC_AMT_$$ , \"+\n\t\" nvl(RECPT_TYPE_CODE,\' \') RECPT_TYPE_CODE,nvl(RECPT_NATURE_CODE,\' \') RECPT_NATURE_CODE,SLMT_TYPE_CODE SLMT_TYPE_CODE,nvl(CANCELLED_IND,\' \') CANCELLED_IND  from bl_receipt_refund_hdrdtl_vw \"+\n\t\" where operating_facility_id = \'\"+facility_id+\"\' AND \"+\n\t\" DOC_DATE BETWEEN to_date(\'\"+login_time+\"\',\'dd/mm/yyyy hh24:mi:ss\')\t \"+\n\t\" AND  sysdate\t \"+\n\t\" AND  CASH_COUNTER_CODE = \'\"+cashcounter+\"\' \"+ \n\t\" ORDER BY TRX_DATE_TIME \");\n\t\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"sql=\"+sql;\n\n\tretVal=await window.showModalDialog(\"../../eBL/jsp/BLGeneralQuery.jsp?\"+param,arguments,features);\n}\n</script>\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n-->\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\n\t\n\t\n\t<body>\n\t\t<form name=\'menu_form\' id=\'menu_form\' action=\'../../servlet/eBL.BLLogInCashCounterServlet\' method=\'post\' target=\'messageFrame\'>\t\t\t\n\t\t<form name=\'menu_form\' id=\'menu_form\' action=\'\' method=\'post\' target=\'messageFrame\'>\t\n\t\t<!-- sarathkumar added code to make as siteSpecific GDOH-CRF-0117 -->\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<div style=\"display: none;\"> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" >       \n\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t</table>\n\t\t<!-- sarathkumar added code to make as siteSpecific GDOH-CRF-0117 -->\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" >\n\t\t<tr >\n\t\t\t<td width=\"25%\" class=\'label\' ><b> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </b></td>\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\'  readonly style=\'text-align:right; font-weight:bold\'  name=\'tot_cash_bills_amt\' id=\'tot_cash_bills_amt\' size=\'15\' maxlength=\'20\' value=\'\' >\n\t\t\t&nbsp;&nbsp;<b  class=\'fields\' id=\'cash_bill_cnt1\' ></b>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t<td width=\"25%\" class=\'label\' ><b> ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\'  readonly style=\'text-align:right; font-weight:bold\' name=\'tot_credit_bills_amt\' id=\'tot_credit_bills_amt\' size=\'15\' maxlength=\'20\' value=\'\'>\n\t\t\t&nbsp;&nbsp;<b  class=\'fields\' id=\'credit_bill_cnt1\'></b>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"25%\" class=\'label\' nowrap><b> ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></td>\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\'  readonly style=\'text-align:right; font-weight:bold\' name=\'tot_opening_bal\' id=\'tot_opening_bal\' size=\'15\' maxlength=\'20\' value=\'\'></td>\n\t\t\t<td width=\"25%\" class=\'label\' ><b> ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></td>\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\'  readonly style=\'text-align:right; font-weight:bold\' name=\'tot_closing_bal\' id=\'tot_closing_bal\' size=\'15\' maxlength=\'20\' value=\'\'></td>\n\t\t</tr>\n<!--\n\t\t\t<tr>\n\t\t\t\t<td align=\'left\' class=\'label\' colspan=\'4\'>&nbsp;</td>\n\t\t\t</tr>\n-->\n\t\t\n\t\t\n\t\t<tr>\n\t\t\t<td width=\"25%\" class=\'label\'></td>\n\t\t\t<td width=\"25%\" align=\'left\'><input type=\'button\' class=\'button\'   \t \tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onClick=\'funQry()\'></td>\n\t\t\t<td width=\"25%\" align=\'left\'><input type=\'button\' class=\'button\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onClick=\'funClose()\'></td>\n\t\t\t<td width=\"25%\" align=\'left\'><input type=\'button\' class=\'button\' name=\'close_button\' id=\'close_button\' id=\'close_button\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onClick=\'funSubmit()\'  ></td>\n\t\t\t\n\t\t\t\n\n\t\t</tr>\n<!--\n\t\t<tr>\n\t\t\t\t<td align=\'left\' class=\'label\' colspan=\'4\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\'left\' class=\'label\' colspan=\'4\'>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td align=\'left\' class=\'label\' colspan=\'4\'></td>\n</tr>-->\t\n\t\t</table>\n\t\t<!-- sarathkumar added code to make as siteSpecific GDOH-CRF-0117 -->\n\t\t<table  border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\t\t<tr>\n\t\t\t<td  width=\"25%\" class=\'label\'></td>\n\t\t\t<td  width=\"25%\" class=\'label\'></td>\n\t\t\t<td width=\"25%\" align=\'left\'><input type=\'button\' class=\'button\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onClick=\'funClose()\'></td>\n\t\t\t<td width=\"25%\" align=\'left\'><input type=\'button\' class=\'button\' name=\'close_button\' id=\'close_button\'  value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onClick=\'funSubmit()\'  ></td>\n\t\t</tr>\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'cashcounter_array\' id=\'cashcounter_array\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type=\'hidden\' name=\'cash_bill_cnt\' id=\'cash_bill_cnt\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<input type=\'hidden\' name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\t\n\t\t<input type=\'hidden\' name=\'called_frm\' id=\'called_frm\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\t\t\t\n\n\t</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	String locale	= (String)session.getAttribute("LOCALE");
	String facility_id = (String)httpSession.getValue("facility_id");
	String login_user =  p.getProperty("login_user");
	String called_frm = request.getParameter("called_frm");
	if(called_frm == null) called_frm="";
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	Boolean SiteSpec=true;
	String site_id="";
	String outst="";
	String billcount_KDAH=" ";
	String billcount_MC=" ";
	String strCashCounterCode = " ";
	String strLogoutTime  = " ";
	String strLoginTime=" ";

	con=ConnectionManager.getConnection(request);

	//sarathkumar added code to make as siteSpecific GDOH-CRF-0117...
	String ssv=session.getAttribute("ssv").toString();
	Boolean ss=Boolean.parseBoolean(ssv);	
	
	//System.out.println("strLoginTime"+request.getParameter("login_time"));

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String cash_bill_cnt = request.getParameter("cash_bill_cnt");
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 if(ss){
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(ss){
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.VIEW_CASHIER_JOURNAL.label","bl_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.CLOSE_CASH_COUNTER.label","bl_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(!ss){
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.CLOSE_CASH_COUNTER.label","bl_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cash_bill_cnt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SLMT_CLOSING_DTL.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SELF_PAY_BILL_AMT.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NOS.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_PAYABLE_AMT.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NOS.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_OPENING_BALANCE.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_CLOSING_BALANCE.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
