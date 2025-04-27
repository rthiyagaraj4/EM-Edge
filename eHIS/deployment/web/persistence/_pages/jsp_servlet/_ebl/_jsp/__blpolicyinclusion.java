package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blpolicyinclusion extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPolicyInclusion.jsp", 1709114576634L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\t\n<head>\n<!--\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t-->\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!--\n\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>\n-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!--\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n-->\n<P>\n<!-- <table align=\'right\'> -->\n\t<table cellpadding=\"3\" align=\'center\'>\n\t<tr>\n\t<td>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t</td>\n\t</tr>\n\t</table>\n\t<br><br>\n\t</P>\n\n\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\'  width=\'100%\'>\n<!--\n\t<th>Service</th>\n\t<th>Co-Pay Indicator</th>\n\t<th>Co-Pay Value</th>\n\t<th>Pre.App Yn</th>\n-->\n\t<td class=\"COLUMNHEADERCENTER\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\"COLUMNHEADERCENTER\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</table>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null ;
	
	PreparedStatement pstmt2 = null ;
	Statement stmt=null ;
	ResultSet rs2 = null ;
	ResultSet rs4 = null ;

	try
	{
	
	con	=	ConnectionManager.getConnection(request);
	//con = (Connection) session.getValue("connection" );

	//String from1 = request.getParameter( "from1" ) ;
	//String to1 = request.getParameter( "to1" ) ;
	request.setCharacterEncoding("UTF-8");
	String from2 = request.getParameter( "from2" ) ;
	String to2 = request.getParameter( "to2" ) ;
	int maxRecord2  = 0;
	int start2 = 0 ;
	int end2 = 0 ;

	//String cust_name="", policy_name="";
	String cust_code="";
	String policy_code="";
	//String whereClause="";
	String whereClause = request.getParameter("whereclause");
	
	if ((whereClause == null || whereClause.equals("")) )
	{
		cust_code=request.getParameter("cust_code");
		policy_code=request.getParameter("policy_code");
		if(cust_code==null)cust_code="";
		if(policy_code==null)policy_code="";
		cust_code=cust_code.trim();
		policy_code=policy_code.trim();
		//policy_code = java.net.URLEncoder.encode(policy_code);
	
	}
	else
	{
		//out.println()
		cust_code=request.getParameter("P_cust_code");
		policy_code=request.getParameter("P_policy_code");
		if(cust_code==null)cust_code="";
		if(policy_code==null)policy_code="";
		cust_code=cust_code.trim();
		policy_code=policy_code.trim();
		//policy_code = java.net.URLEncoder.encode(policy_code);

	}
		

	if ( from2 == null )
		start2 = 1 ;
	else
		start2 = Integer.parseInt( from2 ) ;

	if ( to2 == null )
	  	end2 = 7 ;
	else
		end2 = Integer.parseInt( to2 ) ;

	

	String query_serv_inclu="select c.blng_serv_code, /*--decode(c.copay_ind,'P','Percentage','F','Fixed','R','Rate')--*/c.copay_ind, c.copay_val, c.pre_approval_yn from bl_blng_serv a, bl_ins_policy_type_hdr b, bl_ins_policy_type_dtl c where a.blng_serv_code=c.blng_serv_code and b.policy_type_code=nvl('"+policy_code+"',b.policy_type_code) and b.cust_code=nvl('"+cust_code+"',b.cust_code) and b.policy_type_code=c.policy_type_code and b.cust_code=c.cust_code and c.excl_incl_ind='I'";

	//out.println("query_serv_inclu :"+query_serv_inclu);

	String query_serv_inclu_count="select count(*) as total from bl_blng_serv a, bl_ins_policy_type_hdr b, bl_ins_policy_type_dtl c where a.blng_serv_code=c.blng_serv_code and b.policy_type_code=nvl('"+policy_code+"',b.policy_type_code) and b.cust_code=nvl('"+cust_code+"',b.cust_code) and b.policy_type_code=c.policy_type_code and b.cust_code=c.cust_code and c.excl_incl_ind='I'";

	//out.println("query_serv_inclu_count :"+query_serv_inclu_count);

	stmt=con.createStatement();
	rs4=stmt.executeQuery(query_serv_inclu_count);
	rs4.next();
	maxRecord2 = rs4.getInt("total");

	if (rs4 != null)   rs4.close();

            _bw.write(_wl_block1Bytes, _wl_block1);

policy_code = java.net.URLEncoder.encode(policy_code);
cust_code = java.net.URLEncoder.encode(cust_code);

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(maxRecord2));
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(policy_code));
            _bw.write(_wl_block9Bytes, _wl_block9);

	int i2=1;
	if ( !(start2 <= 1) )
	{
		out.println("<A HREF='BLPolicyInclusion.jsp?P_cust_code="+cust_code+"&P_policy_code="+policy_code+"&from2="+(start2-7)+"&to2="+(end2-7)+"&whereclause="+URLEncoder.encode(query_serv_inclu)+"'"+" text-decoration='none'>Previous</A>");
	}

	if ( !( (start2+7) > maxRecord2 ) )
	{
		out.println("<A HREF='BLPolicyInclusion.jsp?P_cust_code="+cust_code+"&P_policy_code="+policy_code+"&from2="+(start2+7)+"&to2="+(end2+7)+"&whereclause="+URLEncoder.encode(query_serv_inclu)+"'"+" text-decoration='none'>Next</A>");
	}
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	try
	{
		pstmt2 = con.prepareStatement(query_serv_inclu);
		rs2 = pstmt2.executeQuery() ;
		if ( start2 != 1 )
		for( int j2=1; j2<start2; i2++,j2++ )
		{
		  rs2.next() ;
		}
		 String classValue = "" ;
		while ( rs2.next() && i2<=end2 )
		{
			if ( i2 % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
		
			String blng_serv_code1=rs2.getString("blng_serv_code");
			String copay_ind=rs2.getString("copay_ind");
			String copay_val=rs2.getString("copay_val");
			String pre_approval_yn=rs2.getString("pre_approval_yn");
			if(pre_approval_yn==null || pre_approval_yn.equals("null"))pre_approval_yn="&nbsp;";
			if(copay_ind.equals("P")) copay_ind="Percentage";
			else if(copay_ind.equals("F")) copay_ind="Fixed";
			else if(copay_ind.equals("R")) copay_ind="Rate";
			if(copay_val==null || copay_val.equals("null"))copay_val="0.00";
			CurrencyFormat cf1 = new CurrencyFormat();
			copay_val = cf1.formatCurrency(copay_val, 2);

			out.println("<tr>");
			out.println("<td  class='" + classValue + "' align='center'>"+blng_serv_code1+"</td>");
			out.println("<td  class='" + classValue + "' align='left'>"+copay_ind+"</td>");
			out.println("<td  class='" + classValue + "' align='right'>"+copay_val+"</td>");
			if(pre_approval_yn.equals("Y"))
			{
				out.println("<td  class='" + classValue + "' align='center'> <img src='../../eCommon/images/enabled.gif'></img> </td>");
			}
			else
			{
				out.println("<td  class='" + classValue + "' align='center'><img src='../../eCommon/images/RRnwd.gif'></img></td>");
			}
			out.println("</tr>");
			i2++;
		}
		if (rs2 != null) rs2.close();
		pstmt2.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in "+e);
		e.printStackTrace();
	}
}
catch(Exception ee)
{
	//out.println("Exception in main try"+ee);
	ee.printStackTrace();
}
finally
{
	if(stmt != null)stmt.close();
	if(pstmt2  != null)pstmt2.close();
	ConnectionManager.returnConnection(con, request);
}



            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.COPAY_INDICATOR.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.COPAY_VALUE.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PRE_APP_YN.label", java.lang.String .class,"key"));
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
}
