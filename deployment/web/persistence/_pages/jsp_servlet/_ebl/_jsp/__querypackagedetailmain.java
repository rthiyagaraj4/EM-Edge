package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __querypackagedetailmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/QueryPackageDetailMain.jsp", 1709114771692L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n <!-- Author - kumar: Included as part of dispPackageDetails.jsp-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" <!--,op.CurrencyFormat-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<!--\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t-->\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!--\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>\n-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"package_dtls\" id=\"package_dtls\" method=post action=\"\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;	

	String locale	= (String)session.getAttribute("LOCALE");

	try
	{
		//con	=	ConnectionManager.getConnection(request);
		con	=	ConnectionManager.getConnection(request);
		int pkg_bill_num = 0;
		request.setCharacterEncoding("UTF-8");	
		String patient_id = request.getParameter("patient_id");
		if (patient_id==null) patient_id="";
		String pkg_bill_type = request.getParameter("pkg_bill_type") == null ? "" : request.getParameter("pkg_bill_type");
		String pkg_bill_no = request.getParameter("pkg_bill_no");
		if (pkg_bill_no == null) pkg_bill_no="0";
		if (pkg_bill_no.equals("")) pkg_bill_no="0";

		try
		{
			//out.println("pkg_bill_no : "+pkg_bill_no);
			pkg_bill_num=Integer.parseInt(pkg_bill_no);
		}
		catch(Exception e)
		{
			out.println("Exception Caught : "+e);
		}		
	
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String class_val = "QRYEVEN";
	String blng_serv_code = "";
	String short_desc = "";
	String apply_to = "";
	String service_price = "";
	String qv_ind = "";
	String qv_val = "";
	String qv_availed = "";
	String addl_serv_price = "";
	String addl_qty = "";
	String apply_ref_yn = "";
	//String addl_qty_flag = "";

	String sql  = "select a.blng_serv_code, b.short_desc, apply_to, service_price, decode(qv_ind,'Q','Quantity','V','Value') qv_ind, qv_val, qv_availed, addl_serv_price, addl_qty, apply_ref_yn, addl_qty_flag from bl_package_trn_dtl a, bl_blng_serv_lang_vw b 	where b.language_id='"+locale+"' and a.patient_id = 	'"+patient_id+"' and 	a.package_bill_doc_type = '"+pkg_bill_type+"' and a.package_bill_doc_num = 									"+pkg_bill_num+" and a.blng_serv_code = b.blng_serv_code";
		
		
	out.println(" <table cellspacing=0 cellpadding=3 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
	out.println("<tr>");
/*	
		out.println("<th>Blng<BR>Serv<br>Code</th>");
		out.println("<th>Description</th>");
		out.println("<th>IP/OP</th>");
		out.println("<th>Service<br>Price</th>");
		out.println("<th>Indicator</th>");
		out.println("<th>Pkg<br>Value/Qty</th>");
		out.println("<th>Apply<br>Refund</th>");
		out.println("<th>Availed</th>");
		out.println("<th>Addl<br>Service<br>Price</th>");
		out.println("<th>Addl<br>Serv<br>Qty</th>");

*/
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BLNG_SERV_CODE.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label" ,"common_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IPOP.label" ,"common_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SERV_PRICE.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.INDICATOR.label" ,"common_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PKG_VAL_QTY.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.APPLY_REFUND.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.AVAILED.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.ADD_SERV_PRICE.label" ,"bl_labels")+"</td>");
		out.println("<td class='COLUMNHEADER'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.ADD_SERV_QTY.label" ,"bl_labels")+"</td>");
	out.println("</tr>"); 
	
		stmt = con.createStatement();
		rs= stmt. executeQuery(sql);
		if(rs!=null)
		{
			CurrencyFormat cf = new CurrencyFormat();
			while(rs.next())
			{			
				blng_serv_code = rs.getString("blng_serv_code") == null ? "" : rs.getString("blng_serv_code");
				short_desc = rs.getString("short_desc") == null ? "" : rs.getString("short_desc");
				apply_to = rs.getString("apply_to") == null ? "" : rs.getString("apply_to");
				service_price = rs.getString("service_price");
				if ((service_price==null) || (service_price.equals(""))) service_price ="0";
				service_price = cf.formatCurrency(service_price, 2);
				qv_ind = rs.getString("qv_ind") == null ? "" : rs.getString("qv_ind");
				qv_val = rs.getString("qv_val");
				if ((qv_val==null) || (qv_val.equals(""))) qv_val ="0";
				qv_val = cf.formatCurrency(qv_val, 2);
				qv_availed = rs.getString("qv_availed");
				if ((qv_availed==null) || (qv_availed.equals(""))) qv_availed ="0";
				qv_availed = cf.formatCurrency(qv_availed, 2);
				addl_serv_price = rs.getString("addl_serv_price");
				if ((addl_serv_price==null) || (addl_serv_price.equals(""))) addl_serv_price ="0";
				addl_serv_price = cf.formatCurrency(addl_serv_price, 2);
				addl_qty = rs.getString("addl_qty");
				if ((addl_qty==null) || (addl_qty.equals(""))) addl_qty ="0";
				apply_ref_yn = rs.getString("apply_ref_yn") == null ? "" : rs.getString("apply_ref_yn");
				//addl_qty_flag = rs.getString("addl_qty_flag") == null ? "" : rs.getString("addl_qty_flag");			
				addl_qty = cf.formatCurrency(addl_qty, 2);
				if(class_val.equals("QRYEVEN"))
					class_val = "QRYODD";
				else
					class_val = "QRYEVEN";
						
				out.println("<tr>");
				//out.println("<td class='"+class_val+"'> ");
				out.println("<td class='"+class_val+"'>"+blng_serv_code+"</td>");
				out.println("<td class='"+class_val+"'>"+short_desc+"</td>");
				out.println("<td align='center' class='"+class_val+"'>"+apply_to+"</td>");
				out.println("<td align='right' class='"+class_val+"'>"+service_price+"</td>");
				out.println("<td class='"+class_val+"'>"+qv_ind+"</td>");
				out.println("<td align='right' class='"+class_val+"'>"+qv_val+"</td>");			
				//out.println("<td class='"+class_val+"'>"+apply_ref_yn+"</td>");
				out.println("</td><td align='center' class='" + class_val + "'>");
				if ( apply_ref_yn.equals("Y") )
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				out.println("</td>");
				out.println("<td align='right' class='"+class_val+"'>"+qv_availed+"</td>");
				out.println("<td align='right' class='"+class_val+"'>"+addl_serv_price+"</td>");
				out.println("<td align='right' class='"+class_val+"'>"+addl_qty+"</td>");
				out.println("</tr>");
			}
		}
	}
	catch(Exception e) { out.println(e.toString());}
	finally 
	{
		 if (rs != null)   rs.close();
		 if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	out.println("</table>");	

            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
