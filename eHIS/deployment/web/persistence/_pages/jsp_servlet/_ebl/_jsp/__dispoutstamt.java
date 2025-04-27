package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;

public final class __dispoutstamt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/dispOutstAmt.jsp", 1737518462972L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n <!-- Author - kumar: this jsp included as part of dispCreditAuth.jsp-->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" <!--,op.CurrencyFormat-->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar strErrorMessage = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\t\t\talert(strErrorMessage);\n\t\t\t\t\t//window.close();\n\t\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\t\tdialogBody.contentWindow.returnValue = returnArray;\n\t\t\t\t\tconst dialogTag = parent.parent.document.getElementById(\'dialog_tag\');    \n\t\t\t\t\tdialogTag.close();\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t   <script>\n\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'BL\'));\n\t\t\t\t\t//window.close();\n\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\tdialogBody.contentWindow.returnValue = returnArray;\n\t\t\t\tconst dialogTag = parent.parent.document.getElementById(\'dialog_tag\');    \n\t\t\t\tdialogTag.close();\t\t\t\t\t\n\t\t\t   </script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script>\t\n\tfunction confirmPasswd(obj)\n\t{\t\n\t\tvar usr_id=document.forms[0].user_id;\n\t\tvar pass_wd=document.forms[0].passwd;\n\t\tvar rmks=document.forms[0].remarks;\n\t\tif(usr_id.value==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9112\",\"BL\"));\n\t\t\tusr_id.focus();\n\t\t\treturn false;\n\t\t}\n\t\tif(pass_wd.value==\"\")\n\t\t{\n\t\t\talert(getMessage(\"BL9541\",\"BL\"));\n\t\t\tpass_wd.focus();\n\t\t\treturn false;\n\t\t}\n\t\n\t\tvar HTMLVal=\"<html><body><form name=\'BLConfirmPassWdForm\' id=\'BLConfirmPassWdForm\' method=\'post\' action=\'BLConfirmPassWd.jsp\'>\"+\n\t\t\"<input type=\'hidden\' name=\'usr_id\' id=\'usr_id\' value=\'\"+usr_id.value+\"\'>\"+\n\t\t\"<input type=\'hidden\' name=\'pass_wd\' id=\'pass_wd\' value=\'\"+pass_wd.value+\"\'>\"+\n\t\t\t\"<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\"+rmks.value+\"\'>\"+\n\t\t\"</form></body></html>\";\n\t\tparent.frames[1].document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\tparent.frames[1].document.BLConfirmPassWdForm.submit();\n\t\treturn true;\t\n\t}\n\n\tfunction confirmOK(obj)\n\t{\t\t\t\t\n\t\tvar HTMLVal=\"<html><body><form name=\'BLConfirmPassWdForm\' id=\'BLConfirmPassWdForm\' method=\'post\' action=\'BLConfirmPassWd.jsp\'>\"+\t\t\t\t\n\t\t\"</form></body></html>\";\n\t\tparent.frames[1].document.body.insertAdjacentHTML(\'afterbegin\', HTMLVal);\n\t\tparent.frames[1].document.BLConfirmPassWdForm.submit();\n\t\treturn true;\t\n\t}\n\n\tfunction retModal(obj)\n\t{\n\n\t\tvar returnArray = new Array (\"N\");\n\t\t//parent.window.returnValue = returnArray;\n\t\tvar dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\tdialogBody.contentWindow.returnValue = returnArray;\n\t}\n\n\tfunction retArray(obj)\n\t{ \n\t\tvar returnArray = new Array(\"1\");\n\t\tparent.parent.document.getElementById(\'dialog-body\').contentWindow.returnValue = returnArray;\n\t\tparent.parent.document.getElementById(\'dialog_tag\').close();  \n\t}\n\n\tfunction chkbox(obj)\n\t{\n\t\tif(obj.checked)\n\t\t{\n\t\t\tobj.checked = false;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tobj.checked = true;\n\t\t}\n\t}\n</script>\n</head>\n<style>\n\t\ttextarea \t{\n\t\t overflow-y: scroll;\n\t\tresize: none;\n\t\t}\n\t</style>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<center>\n\t<form name=\"pat_outst_amt\" id=\"pat_outst_amt\" method=post action=\"\">\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\t\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\"30%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td width=\"70%\" class=\"fields\">\n\t\t\t\t\t<input type=\"checkbox\"  name=\"unbill_cb\" id=\"unbill_cb\" value=\"\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" onclick =\"chkbox(this)\">\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<input type=\"text\" size=\'12\' name=\"unbilled_amt\" id=\"unbilled_amt\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" readonly>\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<input type=\"text\" size=\'12\'  name=\"unbilled_amt\" id=\"unbilled_amt\" value=\"\" readonly>\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\"30%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td> \t\n\t\t\t\t<td width=\"70%\" class=\"fields\" >\n\t\t\t\t\t<input type=\"checkbox\" name=\"tot_outstanding_cb\" id=\"tot_outstanding_cb\" value=\"\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<input type=\"text\" size=\'12\'  name=\"outstanding_amt\" id=\"outstanding_amt\" \tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<input type=\"text\" size=\'12\'  name=\"outstanding_amt\" id=\"outstanding_amt\" \tvalue=\"\" readonly>\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\"30%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td> \t\n\t\t\t\t<td width=\"70%\" class=\"fields\" >\n\t\t\t\t\t<input type=\"checkbox\"  name=\"write_off_cb\" id=\"write_off_cb\" value=\"\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<input type=\"text\" size=\'12\' name=\"write_off_amt\" id=\"write_off_amt\" \tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<input type=\"text\" size=\'12\' name=\"write_off_amt\" id=\"write_off_amt\" \tvalue=\"\" readonly>\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td> \t\n\t\t\t\t<td width=\"70%\" class=\"fields\" >\n\t\t\t\t\t<input type=\"checkbox\"  name=\"instL_due_cb\" id=\"instL_due_cb\" value=\"\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<input type=\"text\" size=\'12\'  name=\"instL_due_amt\" id=\"instL_due_amt\" \tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<input type=\"text\" size=\'12\'  name=\"instL_due_amt\" id=\"instL_due_amt\" \tvalue=\"\" readonly>\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\t\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\"30%\">Deposit Balance Amount</td> \t\n\t\t\t\t<td width=\"70%\" class=\"fields\" >\n\t\t\t\t\t<input type=\"checkbox\"  name=\"dep_amt_cb\" id=\"dep_amt_cb\" value=\"\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<input type=\"text\" size=\'12\'  name=\"dep_amount\" id=\"dep_amount\" \tvalue=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<input type=\"text\" size=\'12\'  name=\"dep_amount\" id=\"dep_amount\" \tvalue=\"\" readonly>\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\n\t</table>\n\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\t\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' width=\"30%\" >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td> \n\t\t\t\t<td class=\"fields\" width=\"70%\"><textarea name=\"\" rows=\"2\" cols=\"40\" readonly>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</textarea></td>\t\n\t\t\t</tr>\n<!--\t<tr>\n<!--\t\t<td align=\'right\' class=\'label\'>Outstanding Amount&nbsp;</td> \n\t\t\t<td class=\'label\' width=\"50%\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n\t\t\t<td class=\"fields\" width=\"50%\"><input type=\"text\" size=\'12\' style=\'text-align:right\' name=\"outst_amt\" id=\"outst_amt\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" readonly></td>\n\t\t</tr>-->\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<script>\n\t\t\t\tvar returnArray = new Array (\"1\");\n\t\t\t\t//parent.window.returnValue = returnArray;\n\t\t\t\t//parent.window.close();\n\t\t\t\tlet dialogBody = parent.parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\tdialogBody.contentWindow.returnValue = returnArray;\n\t\t\t\tconst dialogTag = parent.parent.parent.document.getElementById(\'dialog_tag\');    \n\t\t\t\tdialogTag.close();\n\t\t\t</script>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t</table>\n\t<table>\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="<tr><td width=\"100%\"  style=\'text-align:left\'>*Authorisation Required,Outstanding Amount exists</td></tr> \n\t\t</table>\n\t\t<table>\n\t\t<tr><td>\n\t\t<span style=\'padding-left: 20px;\'>\n\t\t<input type=\'button\' class=\'button\' value=\'Cancel\' id=\'close\' onClick=\'parent.window.close()\'>\n</span>\n</td>\n</tr>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n</table>\n</form>\n<center>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	PreparedStatement pstmt =null;
	ResultSet rs =null;	
	request.setCharacterEncoding("UTF-8");

	String ind_bal_available_YN = "";

	String Patient_id = request.getParameter("patient_id");
	if(Patient_id == null) Patient_id="";

	String v_episode_type = request.getParameter("v_episode_type");
	if(v_episode_type == null) v_episode_type="";

	String outst_amt	= request.getParameter("outst_amt");	
	if(outst_amt == null) outst_amt="0";
	
	String str_module_id = request.getParameter("calling_module_id");
	if(str_module_id == null) str_module_id="";
	if(str_module_id.equals("OP")) v_episode_type="O";
	if(str_module_id.equals("IP")) v_episode_type="I";
	if(str_module_id.equals("AE")) v_episode_type="E";
	if(str_module_id.equals("DC")) v_episode_type="D";
	
	//double	patient_outst_amt = Double.parseDouble(outst_amt);
//	double outst_amount_limit = 0;
//	double op_outst_amount_limit = 0, ae_outst_amount_limit = 0, ip_outst_amount_limit = 0, dc_outst_amount_limit = 0;
	int noofdecimal=0;
	CurrencyFormat cf = new CurrencyFormat();
	
	String patient_remarks ="";
	String facility_id  =  (String) session.getValue("facility_id");
//	String credit_auth_req_yn = "" ;
//	String op_credit_auth_req_yn = "", ae_credit_auth_req_yn = "", ip_credit_auth_req_yn = "", dc_credit_auth_req_yn = "";
	double tot_unbilled_amt=0, tot_installment_due=0, tot_outstanding_amt =0,tot_written_off_amt=0;//unbilled_amt=0,outstdg_amt=0,instl_due_amt=0,wo_amt=0;
	String credit_auth_reqd_yn="",unbld_disp_yn="", outst_disp_yn="",instl_disp_yn="",wo_disp_yn="";
//	outst_oper="",instl_oper="",wo_oper="",;
	String p_credit_auth_check_result_yn="";//str_tot_outstanding_amt="",str_tot_written_off_amt="",str_tot_unbilled_amt="",str_tot_installment_due="",
	//String str_unbilled_amt="",str_outstdg_amt="",str_instl_due_amt="",	str_wo_amt="";
//	String x_str="",str_temp="";		
	String p_unbilled_amt="",p_outstdg_amt="",p_instl_due_amt="",p_wo_amt="",p_error_level="",p_error_text="",p_sys_msg_id="";
	//boolean rec_found=false;
	String P_dep_amt="", dep_disp_yn="";//V231010-ML-MMOH-CRF-1614
	double tot_deposit_amt=0;//V231010
	try
	{				
		con	=	ConnectionManager.getConnection(request);	
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}	
			if(rscurr!=null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}
		//V231010 Starts
		boolean  depositShow= false;
		String depositShowYN = "N";	
		try {
			depositShow = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "DEPOSITAMT_IN_CREDIT_AUTH");
			if (depositShow)
				depositShowYN = "Y";
			else
				depositShowYN = "N";
		  } catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Exception in depositBalanceAmt ::" + ex);
		}
		//V231010 Ends -SA00003375
		try
		{			
			pstmt = con.prepareStatement("select patient_remarks from mp_patient_remarks where patient_id=?");		
			pstmt.setString(1, Patient_id);
			rs = pstmt.executeQuery();	
			if (rs!=null)
			{
				while (rs.next())
				{
					patient_remarks = rs.getString("patient_remarks");		  
					if (patient_remarks == null) patient_remarks = "";
				}
			}
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
		finally 
		{
			if (pstmt != null) pstmt.close();
			if (rs != null)   rs.close();
			//ConnectionManager.returnConnection(con, request);
		}
	
	  	/* commented on 31-03-09
		try
	    {		
			//con	=	ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement("select nvl(credit_auth_reqd_yn,'N'), nvl(AE_CREDIT_AUTH_REQD_YN,'N'), nvl(IP_CREDIT_AUTH_REQD_YN,'N'), nvl(DC_CREDIT_AUTH_REQD_YN,'N'), nvl(outst_amt_limit,0), nvl(ae_outst_amt_limit,0), nvl(ip_outst_amt_limit,0), nvl(dc_outst_amt_limit,0) from bl_parameters where operating_facility_id='"+facility_id+"'");		
	
			rs = pstmt.executeQuery();	
		
			if (rs!=null)
			{
				while (rs.next())
				{
					op_credit_auth_req_yn = rs.getString(1);
					ae_credit_auth_req_yn = rs.getString(2);
					ip_credit_auth_req_yn = rs.getString(3);
					dc_credit_auth_req_yn = rs.getString(4);
//					outst_amount_limit = rs.getDouble(2);
					op_outst_amount_limit = rs.getDouble(5);
					ae_outst_amount_limit = rs.getDouble(6);
					ip_outst_amount_limit = rs.getDouble(7);
					dc_outst_amount_limit = rs.getDouble(8);
				}
		  	}
			if(op_credit_auth_req_yn == null) op_credit_auth_req_yn="N";
			if(ae_credit_auth_req_yn == null) ae_credit_auth_req_yn="N";
			if(ip_credit_auth_req_yn == null) ip_credit_auth_req_yn="N";
			if(dc_credit_auth_req_yn == null) dc_credit_auth_req_yn="N";
		}
		catch(Exception e)
		{ 
			out.println("Error while executing bl_parameters query:"+ e.toString());
		}
		finally 
		{
			 if (pstmt != null) pstmt.close();
			 if (rs != null)   rs.close();
		//ConnectionManager.returnConnection(con, request);
		}*/
		//comment end
		try
	    {
			String chk_enc_crdt_auth="{ call BLCOMMON.CHECK_ENC_CREDIT_AUTH('"+facility_id+"','"+Patient_id+"','"+v_episode_type+"',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //Added 2 params -V231010
//			System.out.println("chk_enc_crdt_auth"+chk_enc_crdt_auth);
			CallableStatement call = con.prepareCall(chk_enc_crdt_auth);

			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.registerOutParameter(2,java.sql.Types.VARCHAR);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);
			call.registerOutParameter(11,java.sql.Types.VARCHAR);
			call.registerOutParameter(12,java.sql.Types.VARCHAR);
			call.registerOutParameter(13,java.sql.Types.VARCHAR);
			call.registerOutParameter(14,java.sql.Types.VARCHAR);
			call.registerOutParameter(15,java.sql.Types.VARCHAR);
			call.execute();
			credit_auth_reqd_yn=call.getString(1);
			p_credit_auth_check_result_yn=call.getString(2);
			p_unbilled_amt=call.getString(3);
			unbld_disp_yn=call.getString(4);
			p_outstdg_amt=call.getString(5);
			outst_disp_yn=call.getString(6);
			p_instl_due_amt=call.getString(7);
			instl_disp_yn=call.getString(8);
			p_wo_amt=call.getString(9);
			wo_disp_yn=call.getString(10);
			P_dep_amt=call.getString(11);//V231010
			dep_disp_yn=call.getString(12);//V231010
			
			p_error_level=call.getString(13);
			p_sys_msg_id=call.getString(14);
			p_error_text=call.getString(15);

			if(credit_auth_reqd_yn==null) credit_auth_reqd_yn="";
			if(p_credit_auth_check_result_yn==null) p_credit_auth_check_result_yn="";
			if(p_unbilled_amt==null) p_unbilled_amt="0";
			if(unbld_disp_yn==null) unbld_disp_yn="";
			if(p_outstdg_amt==null) p_outstdg_amt="0";
			if(outst_disp_yn==null) outst_disp_yn="";
			if(p_instl_due_amt==null) p_instl_due_amt="0";
			if(instl_disp_yn==null) instl_disp_yn="";
			if(p_wo_amt==null) p_wo_amt="0";
			if(wo_disp_yn==null) wo_disp_yn="";
			if(P_dep_amt==null) P_dep_amt="0";//V231010
			if(dep_disp_yn==null) dep_disp_yn="";//V231010
			if(p_error_level==null) p_error_level="";
			if(p_sys_msg_id==null) p_sys_msg_id="";
			if(p_error_text==null) p_error_text="";	
			System.err.println("credit_auth_reqd_yn "+credit_auth_reqd_yn +"p_credit_auth_check_result_yn "+p_credit_auth_check_result_yn);

			tot_outstanding_amt = Double.parseDouble(p_outstdg_amt);
			tot_written_off_amt = Double.parseDouble(p_wo_amt);
			tot_unbilled_amt = Double.parseDouble(p_unbilled_amt);
			tot_installment_due = Double.parseDouble(p_instl_due_amt);
			tot_deposit_amt = Double.parseDouble(P_dep_amt);//V231010

			p_outstdg_amt= cf.formatCurrency(p_outstdg_amt, noofdecimal);
			p_wo_amt= cf.formatCurrency(p_wo_amt, noofdecimal);
			p_unbilled_amt= cf.formatCurrency(p_unbilled_amt, noofdecimal);
			p_instl_due_amt= cf.formatCurrency(p_instl_due_amt, noofdecimal);
			P_dep_amt=cf.formatCurrency(P_dep_amt, noofdecimal);//V231010
			System.err.println("tot_deposit_amt "+tot_deposit_amt);
			call.close();
		}
		catch(Exception e)
		{ 
			out.println("Error while executing bl_parameters query:"+ e.toString());
		}
		finally 
		{
			 if (pstmt != null) pstmt.close();
			 if (rs != null)   rs.close();		
		}
		
		if((p_error_level.equals("10") && !p_error_level.equals("")) || !p_sys_msg_id.equals(""))
		{
			if (p_error_level.equals("10") && !p_error_level.equals(""))
			{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_error_text));
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
			if(!p_sys_msg_id.equals(""))
			{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_sys_msg_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
			
			}	
		}

            _bw.write(_wl_block12Bytes, _wl_block12);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block14Bytes, _wl_block14);

		if(tot_unbilled_amt > 0 || tot_outstanding_amt > 0 || tot_written_off_amt > 0  || tot_installment_due > 0 || !patient_remarks.equals("") ||  tot_deposit_amt>0)
		{
			ind_bal_available_YN = ""; // To make the individual amount checkbox checked/not

			if(tot_unbilled_amt > 0)
			{
				ind_bal_available_YN = "CHECKED";
			}
			else
			{
				ind_bal_available_YN = "";
			}

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(ind_bal_available_YN));
            _bw.write(_wl_block17Bytes, _wl_block17);

				if(unbld_disp_yn.equals("Y") && !ind_bal_available_YN.equals(""))
				{

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_unbilled_amt));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
				}
				else if(unbld_disp_yn.equals("Y") && ind_bal_available_YN.equals(""))
				{

            _bw.write(_wl_block20Bytes, _wl_block20);
	
				}

			if(tot_outstanding_amt > 0)
			{
				ind_bal_available_YN = "CHECKED";
			}
			else
			{
				ind_bal_available_YN = "";
			}

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ind_bal_available_YN));
            _bw.write(_wl_block17Bytes, _wl_block17);

				
				if(outst_disp_yn.equals("Y") && !ind_bal_available_YN.equals(""))
				{

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_outstdg_amt));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
				}
				else if(outst_disp_yn.equals("Y") && ind_bal_available_YN.equals(""))
				{

            _bw.write(_wl_block24Bytes, _wl_block24);
	
				} 

			if(tot_written_off_amt > 0)
			{
				ind_bal_available_YN = "CHECKED";
			}
			else
			{
				ind_bal_available_YN = "";
			}

            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ind_bal_available_YN));
            _bw.write(_wl_block17Bytes, _wl_block17);

				if(wo_disp_yn.equals("Y") && !ind_bal_available_YN.equals(""))
				{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_wo_amt));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
				}
				else if(wo_disp_yn.equals("Y")&& ind_bal_available_YN.equals(""))
				{

            _bw.write(_wl_block28Bytes, _wl_block28);
	
				}

			if(tot_installment_due > 0)
			{
				ind_bal_available_YN = "CHECKED";
			}
			else
			{
				ind_bal_available_YN = "";
			}

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ind_bal_available_YN));
            _bw.write(_wl_block17Bytes, _wl_block17);

				if(instl_disp_yn.equals("Y") && !ind_bal_available_YN.equals(""))
				{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_instl_due_amt));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
				}
				else if(instl_disp_yn.equals("Y") && ind_bal_available_YN.equals(""))
				{

            _bw.write(_wl_block31Bytes, _wl_block31);
	
				}

            _bw.write(_wl_block32Bytes, _wl_block32);

			//V231010
			if(depositShowYN.equals("Y")){
				if(tot_deposit_amt > 0)
				{
					ind_bal_available_YN = "CHECKED";
				}
				else
				{
					ind_bal_available_YN = "";
				}
				
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(ind_bal_available_YN));
            _bw.write(_wl_block17Bytes, _wl_block17);

				if(dep_disp_yn.equals("Y") && !ind_bal_available_YN.equals(""))
				{

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(P_dep_amt));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
				}
				else if(dep_disp_yn.equals("Y") && ind_bal_available_YN.equals(""))
				{

            _bw.write(_wl_block35Bytes, _wl_block35);
	
				}

            _bw.write(_wl_block32Bytes, _wl_block32);
} 
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_remarks));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(outst_amt));
            _bw.write(_wl_block40Bytes, _wl_block40);

			if(!str_module_id.equals("MR")){
			if(p_credit_auth_check_result_yn.equals("Y") && credit_auth_reqd_yn.equals("Y"))
			{
/*			out.println("<tr> " +
			"<td align='right' class='label'>User ID&nbsp;</td> "+
			"<td align='left'><input type='text' size = '20' maxlength = '20' name='user_id' id='user_id' " +
			" onKeyPress='return makeUpperCase()'>&nbsp;" +
			"<img src='../../eCommon/images/mandatory.gif'></td>"+
			"</tr>" +
			"<tr>" +
			"<td align='right' class='label'>Pin No&nbsp;</td>"+
			"<td align='left'><input type='password' size = '20' maxlength = '64' name='passwd' id='passwd'>&nbsp;"+
			"<img src='../../eCommon/images/mandatory.gif'></td>"+
			"</tr>"+
			"<tr>"+
			"<td align='right' class='label'>Remarks&nbsp;</td>"+
			"<td align='left'><input type='text' size = '20' maxlength = '50' name='remarks' id='remarks'> </td>"+
			"</tr> ");	
			*/
			/*
			out.println("<td width='' "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</td>");
			*/
			
				out.println("<tr> " +
							"<td  class='label' width='30%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels")+"</td> "+
							"<td class='fields' width='70%' ><input type='text' size = '20' maxlength = '20' name='user_id' id='user_id' " +
							" onKeyPress='return makeUpperCase()'>" +
							"<img src='../../eCommon/images/mandatory.gif'></td>"+
							"</tr>" +
							"<tr>" +
							"<td class='label' width='30%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PIN.label","common_labels")+"</td>"+
							"<td class='fields' width='70%'><input type='password' size = '20' maxlength = '64' name='passwd' id='passwd'>"+
							"<img src='../../eCommon/images/mandatory.gif'></td>"+
							"</tr>"+
							"<tr>"+
							"<td class='label' width='30%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</td>"+
							"<td class='fields' width='70%'><input type='text' size = '20' maxlength = '50' name='remarks' id='remarks'> </td>"+
							"</tr> ");	
			
			}
			}
		if(!str_module_id.equals("MR")){
			if(p_credit_auth_check_result_yn.equals("Y") && credit_auth_reqd_yn.equals("Y")  )	 
			{
				out.println("<tr><td width='50%'></td><td width='50%'><input type='button' class='button' name='auth_ok' id='auth_ok' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")+"' "+
				"onClick ='return confirmPasswd(this);'>&nbsp;<input type='button'  " +
				"class='button' name='auth_cancel' id='auth_cancel'  value='Cancel' "+
				"onClick='parent.window.close(); return retModal(this);'></td><tr>");
				
			}
			else
			{
				out.println("<tr><td width='50%'></td><td width='50%'><input type='button' class='button' name='auth_ok' id='auth_ok' 	value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")+"' " +
				//"onClick='return retArray(this);'></td><tr>");
				"onClick='return retArray(this);'></td><tr>");
				
			}
		}
		}
		else
		{

            _bw.write(_wl_block41Bytes, _wl_block41);

		}

            _bw.write(_wl_block42Bytes, _wl_block42);

if(("MR").equalsIgnoreCase(str_module_id)){
		
            _bw.write(_wl_block43Bytes, _wl_block43);
			
		 }

            _bw.write(_wl_block44Bytes, _wl_block44);
	}
	catch(Exception ex)
	{ 
		out.println("ghfghf: "+ex.toString());
	}
	finally 
	{
		ConnectionManager.returnConnection(con, request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNBILLED_AMT.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outstandingamount.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.WRITOFF_AMT.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INSTLMT_DUE_AMT.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.generalRemarks.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outstandingamount.label", java.lang.String .class,"key"));
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
}
