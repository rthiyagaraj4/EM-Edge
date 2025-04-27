package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcreditcardinterfacevalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCreditCardInterfaceValidate.jsp", 1709114473852L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\t\t<script>\t\t\t\t\t\n\t\t\t\t\t\tvar v_error = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\talert(v_error);\t\t\t\t \t\t\t\t\t\t\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t\t <script>\n\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'BL\'));\n\t\t\t\t\t//\talert(\"Invalid Credit Card Number\");\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].instref.select();\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<script>\n\t\t\t\t\t\tparent.frames[1].document.forms[0].sale_draft_reqd_yn.value=\"\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].payer_name_reqd_yn.value=\"\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].payer_ref_reqd_yn.value=\"\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].batch_no_reqd_yn.value=\"\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].slmt_doc_ref_date_reqd_yn.value=\"\";\n\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.frames[1].document.forms[0].sale_draft_reqd_yn.value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].payer_name_reqd_yn.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].payer_ref_reqd_yn.value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].batch_no_reqd_yn.value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].slmt_doc_ref_date_reqd_yn.value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n<script>\n\tfunction validate()\n\t{\n\tparent.frames[5].location.href=\'../../eCommon/jsp/error.jsp\';\n\t\tvar mess_const_for_cc_mc=document.forms[0].mess_const_for_cc_mc.value;\n\t\t//alert(\"Message Constructed for CC Machine:\"+mess_const_for_cc_mc);\n\t\tvar v_cc_trx_approved_YN=CreditCardInterface.writeData(mess_const_for_cc_mc,\'Y\');\t\t\n\t\talert(getMessage(\"BL1008\",\"BL\"));\n\n\t\tif(v_cc_trx_approved_YN == 0 || v_cc_trx_approved_YN == 2)\n\t\t{\n\t\t\tdocument.forms[0].cc_trx_approved_YN.value=\"Y\";\n\t\t}\n\t\telse if(v_cc_trx_approved_YN == 1)\n\t\t{\n\t\t\tdocument.forms[0].port_nt_open.value=\"Y\";\n\t\t}\n\t\t/*else if(v_cc_trx_approved_YN == 2)\n\t\t{\n\t\t\tdocument.forms[0].err_in_port_conn.value=\"Y\";\n\t\t}*/\n\t\t\n\t\tif(document.forms[0].port_nt_open.value == \"Y\")\n\t\t{\n\t\t\t//alert(\"Port Not Opened\");\n\t\t\talert(getMessage(\"BL9872\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\n\t\tif(document.forms[0].err_in_port_conn.value == \"Y\")\n\t\t{\n\t\t\t//alert(\"Error in Port Connection\");\n\t\t\talert(getMessage(\"BL9873\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\n\t\tif(document.forms[0].port_nt_open.value == \"N\" && document.forms[0].err_in_port_conn.value == \"N\" && document.forms[0].cc_trx_approved_YN.value == \"Y\")\n\t\t{\n\t\t\tvar mesg_frm_cc_mc=CreditCardInterface.readData();\n\t\t\t//var mesg_frm_cc_mc=\"APPROVAL|00|12345|GET WELL|TIN001|MC001|VISA|1234567821345768|15/07|BT001|20070725|011000|RR001|VISA|ALLEN\";\n\t\t\t//alert(\"Message from CC Machine\"+mesg_frm_cc_mc);\n\t\t\tif(mesg_frm_cc_mc == null) mesg_frm_cc_mc=\"\";\n\t\t\tif(mesg_frm_cc_mc==\"\")\t\t\t\t\n\t\t\t{\n\t\t\t\t//alert(\"No Data from CC Machine\");\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND\",\"common\"));\n\t\t\t\treturn false;\n\t\t\t}\n\n\t\t\tdocument.forms[0].mesg_frm_cc_mc.value=mesg_frm_cc_mc;\n\t\t\tparent.frames[0].document.forms[0].cc_trx_approved_YN.value=document.forms[0].cc_trx_approved_YN.value;\n\t\t\tparent.frames[0].document.forms[0].mesg_frm_cc_mc.value=mesg_frm_cc_mc;\n\t\t\tparent.frames[0].document.forms[0].submit();\n\n\n\t\t}\n\t}\n</script>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<OBJECT classid = \"clsid:A453F6AF-CCF8-490A-905E-A5963B743D2C\" name=\"CreditCardInterface\"></OBJECT>\n\t<BODY onLoad=\'validate()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<form>\n\t<input type=\'hidden\' name=\'billslmtamt\' id=\'billslmtamt\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t<input type=\'hidden\' name=\'mess_const_for_cc_mc\' id=\'mess_const_for_cc_mc\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t<input type=\'hidden\' name=\'cc_trx_approved_YN\' id=\'cc_trx_approved_YN\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t<input type=\'hidden\' name=\'port_nt_open\' id=\'port_nt_open\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t<input type=\'hidden\' name=\'err_in_port_conn\' id=\'err_in_port_conn\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t<input type=\'hidden\' name=\'mesg_frm_cc_mc\' id=\'mesg_frm_cc_mc\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\t\n</form>\n</BODY>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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
request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con=null ;
	//Statement stmt=null;
	//ResultSet rs=null;
	CallableStatement call = null;
	con = ConnectionManager.getConnection(request);
	
	String billslmtamt="",mess_const_for_cc_mc="",cc_trx_approved_YN="N";
	String port_nt_open="N",err_in_port_conn="N";
	String mesg_frm_cc_mc="";
	String caldFormanualcc="",slmt_type_code="",credit_card_num="",sale_draft_reqd_yn="",payer_name_reqd_yn="",payer_ref_reqd_yn="",error_level="",sys_message_id="",error_text="";
//	String locale			= (String)session.getAttribute("LOCALE");


	String batch_no_reqd_yn="",slmt_doc_ref_date_reqd_yn="";

		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try
	{
		billslmtamt=request.getParameter("billslmtamt");
		if(billslmtamt == null) billslmtamt="";

		mess_const_for_cc_mc=request.getParameter("mess_const_for_cc_mc");
		if(mess_const_for_cc_mc == null) mess_const_for_cc_mc="";
//		System.out.println("mess_const_for_cc_mc:"+mess_const_for_cc_mc);

		caldFormanualcc=request.getParameter("caldFormanualcc");
		if(caldFormanualcc == null) caldFormanualcc="";
		slmt_type_code=request.getParameter("slmt_type_code");
		if(slmt_type_code == null) slmt_type_code="";
		credit_card_num=request.getParameter("credit_card_num");
		if(credit_card_num == null) credit_card_num="";
		
		try{
			String strqry = "{ call BLCORE.VALIDATE_CREDIT_CARD_DTLS(?,?,?,?,?,?,?,?,?,?) }";
//			System.out.println("strqry @@"+strqry);
			  call = con.prepareCall(strqry);
		//	CallableStatement  call = con.prepareCall("{ call BLCORE.VALIDATE_CREDIT_CARD_DTLS(?,?,?,?,?,?,?,?) }");	
			call.setString(1,slmt_type_code);
			call.setString(2,credit_card_num);
			call.registerOutParameter(3,java.sql.Types.VARCHAR);
			call.registerOutParameter(4,java.sql.Types.VARCHAR);
			call.registerOutParameter(5,java.sql.Types.VARCHAR);
			call.registerOutParameter(6,java.sql.Types.VARCHAR);
			call.registerOutParameter(7,java.sql.Types.VARCHAR);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);
			call.registerOutParameter(9,java.sql.Types.VARCHAR);
			call.registerOutParameter(10,java.sql.Types.VARCHAR);

			call.execute();
			sale_draft_reqd_yn=call.getString(3);
			if(sale_draft_reqd_yn == null) sale_draft_reqd_yn="";
			payer_name_reqd_yn=call.getString(4);
			if(payer_name_reqd_yn == null) payer_name_reqd_yn="";
			payer_ref_reqd_yn=call.getString(5);
			if(payer_ref_reqd_yn == null) payer_ref_reqd_yn="";			
/***  Added against CRF  AAKH-CRF-0014   37864				*/
			batch_no_reqd_yn=call.getString(6);	
			if(batch_no_reqd_yn == null) batch_no_reqd_yn="";			
  
			slmt_doc_ref_date_reqd_yn=call.getString(7);
			if(slmt_doc_ref_date_reqd_yn == null) slmt_doc_ref_date_reqd_yn="";			

/***  end  AAKH-CRF-0014   37864				*/
			error_level=call.getString(8);
			if(error_level == null) error_level="";
			sys_message_id=call.getString(9);
			if(sys_message_id == null) sys_message_id="";
			error_text=call.getString(10);
			if(error_text == null) error_text="";		
			 call.close();	
			if ((error_level.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))
			{
				if (error_level.equals("10") ||(!error_text.equals("")))
				{
//					System.out.println("2 val");				

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(error_text));
            _bw.write(_wl_block9Bytes, _wl_block9);
				}					
				if(!sys_message_id.equals(""))
				{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sys_message_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
				}
					
            _bw.write(_wl_block12Bytes, _wl_block12);

			}else{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sale_draft_reqd_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(payer_name_reqd_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(payer_ref_reqd_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(batch_no_reqd_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slmt_doc_ref_date_reqd_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
			}


		}catch(Exception e)
		{
			System.out.println("Proc Exception:"+e);
		}

            _bw.write(_wl_block19Bytes, _wl_block19);

	if(caldFormanualcc.equals("MANUALCC"))
	{

            _bw.write(_wl_block20Bytes, _wl_block20);

	}else
		{

            _bw.write(_wl_block21Bytes, _wl_block21);
		}

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(billslmtamt));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(mess_const_for_cc_mc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cc_trx_approved_YN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(port_nt_open));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(err_in_port_conn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mesg_frm_cc_mc));
            _bw.write(_wl_block28Bytes, _wl_block28);

	}
	catch(Exception e)
	{
		System.out.println("Main Exception in CC Interface Test Page:"+e);
	}
	finally{					
					if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
			}

            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
