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
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import eBL.BLReportIdMapper;
import java.util.*;
import com.ehis.util.*;

public final class __bladdlservchargedtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAddlServChargeDtls.jsp", 1709114387729L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<STYLE TYPE=\"text/CSS\">\n\n/* This style is used for locking the table\'s heading  */\n\ndiv#tbl-container {\nwidth: 474px;\nheight: 120px;\noverflow: auto;\n}\n\nthead td, thead td.locked\t{\nposition:relative;\n}\n\nthead td {\ntop: expression(document.getElementById(\"tbl-container\").scrollTop-2); \nz-index: 20;\n}\n\n</STYLE>\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLAdhocDisc.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<script>\n\n</script>\n\n<BODY onLoad=\"\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  onSelect=\"codeArrestThruSelect();\">\n<FORM name=\'BLAddlServChargeDtlsForm\' id=\'BLAddlServChargeDtlsForm\' action=\"\" method=\'\'>\t\n<div id=\'tbl-container\'>\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\t\n\t<thead>\n\t\t<tr>\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'70%\'>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\t\t\n\t\t</tr>\n\t</thead>\n\t<tbody>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<tr>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" width=\'70%\'><div id=\"rule_desc_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</div>\n\t\t\t\t<input type=\"hidden\" name=\"rule_code";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"rule_code";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></td>\n\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" width=\'30%\' ><div style=\'text-align:right\' id=\"addl_charge_amt";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div></td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="  \n\t</tbody>\n\t</table>\n\t<INPUT TYPE=\"hidden\" name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t<INPUT TYPE=\"hidden\" name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\n\t<INPUT TYPE=\"hidden\" name=\'total_addl_charge_for_payer\' id=\'total_addl_charge_for_payer\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n</form>\n<script>\n\tparent.frames[1].location.href=\"../../eBL/jsp/BLAddlServChargeDtlsBtn.jsp?total_addl_charge_for_payer=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n</script>\n\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	PreparedStatement pstmt1		= null ;
	Statement stmt = null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;	
	boolean siteSpecNMC=false;//Added V190821-MuthuN/NMC-JD-SCF-0015

	try
	{
		con	=	ConnectionManager.getConnection(request);
		siteSpecNMC = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_CMN_FUN_ME_YN");//Added V190821-MuthuN/NMC-JD-SCF-0015
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		CurrencyFormat cf = new CurrencyFormat();
		String query_string=request.getQueryString();

		String str_addl_charge_amt="", str_rule_code="", str_rule_desc="";
		int i=0,noofdecimal=2; 
		String classval="";

		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	

		String str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";
//		System.out.println("strloggeduser" +strloggeduser);

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
//		System.out.println("strclientip "+strclientip);

		String str_trx_doc_ref = request.getParameter("trx_doc_ref");	
		if(str_trx_doc_ref==null) str_trx_doc_ref="";
//		System.out.println("str_trx_doc_ref "+str_trx_doc_ref);

		String str_trx_doc_ref_line_num = request.getParameter("trx_doc_ref_line_no");	
		if(str_trx_doc_ref_line_num==null) str_trx_doc_ref_line_num="";	
//		System.out.println("str_trx_doc_ref_line_num "+str_trx_doc_ref_line_num);

		String str_trx_doc_ref_seq_num = request.getParameter("trx_doc_ref_seq_no");	
		if(str_trx_doc_ref_seq_num==null) str_trx_doc_ref_seq_num="";	
//		System.out.println("str_trx_doc_ref_seq_num "+str_trx_doc_ref_seq_num);

		String total_addl_charge_for_payer = request.getParameter("total_addl_charge_for_payer");	
		if(total_addl_charge_for_payer==null) total_addl_charge_for_payer="";	
//		System.out.println("total_addl_charge_for_payer "+total_addl_charge_for_payer);

		boolean amtRoundOff = true;//Added by Aravindh/10-05-2018/MMS-JU-SCF-0102

            _bw.write(_wl_block5Bytes, _wl_block5);
	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
if(siteSpecNMC){
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
} else {
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		try
		{
			try
			{		
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
				ResultSet rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					noofdecimal  =  rscurr.getInt(1);		
				}		
				rscurr.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("3="+e.toString());
			}
			
			//Added by Aravindh/10-05-2018/MMS-JU-SCF-0102 try
			ResultSet roundOffRS = null;
			try {
				pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
				
				roundOffRS = pstmt.executeQuery();	
				if (roundOffRS != null && roundOffRS.next())
				{
					if(roundOffRS.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
						amtRoundOff = false;
					}
				}
			} catch(Exception e) {   
				e.printStackTrace();
				System.out.println("4="+e.toString());
			} finally {
				if (roundOffRS != null)   roundOffRS.close();
				if (pstmt != null) pstmt.close();		 		
			}

			String strsql="select RULE_CODE, ADDL_CHARGE_AMT From BL_PAT_CHRG_FOLIO_ADDL_CHARGE Where OPERATING_FACILITY_ID='"+str_facility_id+"' and TRX_DOC_REF='"+str_trx_doc_ref+"' and TRX_DOC_REF_LINE_NUM='"+str_trx_doc_ref_line_num+"' and TRX_DOC_REF_SEQ_NUM='"+str_trx_doc_ref_seq_num+"'";
			
//			System.out.println("strsql "+strsql);	

			stmt = con.createStatement();
			rs = stmt.executeQuery(strsql) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  

					str_rule_code = rs.getString(1);
					if(str_rule_code == null) str_rule_code="";

					str_addl_charge_amt = rs.getString(2);
					if(str_addl_charge_amt == null) str_addl_charge_amt="0";

					//Added by Aravindh/10-05-2018/MMS-JU-SCF-0102 if-else condition
					if(amtRoundOff) {
						str_addl_charge_amt = cf.formatCurrency(str_addl_charge_amt, noofdecimal);
					} else {
						str_addl_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(str_addl_charge_amt, noofdecimal);
					}

					try
					{		
						pstmt1 = con.prepareStatement( " select long_desc from BL_ADDL_CHARGE_RULE_LANG_VW where FACILITY_ID='"+str_facility_id+"' and RULE_CODE='"+str_rule_code+"' and LANGUAGE_ID='"+locale+"'");

						rs1 = pstmt1.executeQuery();	
						while(rs1.next())
						{
							str_rule_desc  =  rs1.getString(1);		
							if(str_rule_desc == null) str_rule_desc="";
						}		
						rs1.close();
						pstmt1.close();
//						System.out.println("str_rule_desc:"+str_rule_desc);
					}
					catch(Exception e)
					{
						System.out.println("Rule Desc Qry:"+e.toString());
					}

					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(str_rule_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(str_rule_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(str_addl_charge_amt));
            _bw.write(_wl_block21Bytes, _wl_block21);
			
					i++;
				}//while		
			}//rs 
			stmt.close();
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in main qry :"+e);
		}

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(total_addl_charge_for_payer));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(total_addl_charge_for_payer));
            _bw.write(_wl_block26Bytes, _wl_block26);

	}
	catch(Exception ee)
	{
	  System.out.println("Error in BLAddlServChargeDtls.jsp " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Vat_Charges.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ADDL_CHARGE.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
}
