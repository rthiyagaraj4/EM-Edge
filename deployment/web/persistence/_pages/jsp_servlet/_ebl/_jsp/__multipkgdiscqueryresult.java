package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __multipkgdiscqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MultiPkgDiscQueryResult.jsp", 1709114678053L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<form name=\'QueryResult\' id=\'QueryResult\'>\n\t<P>\n\t<table align=\'right\'>\n\t<tr>\n\t<td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\t\t<td class=\"columnheadercenter\" > \n\t\t\tBilling Group Code\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" > \n\t\t\tCustomer Group Code\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" > \n\t\t\tCustomer Code\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" > \n\t\t\tPolicy Type Code\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" > \n\t\t\tFacility Id\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" nowrap> \n\t\t\tValid From\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" nowrap> \n\t\t\tValid To\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" > \n\t\t\tApplicable For\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" > \n\t\t\tMulti Package Discount\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" > \n\t\t\tMulti Package Discount YN\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" > \n\t\t\tPackage/Customer Discount YN\n\t\t</td>\n\t\t<td class=\"columnheadercenter\" > \n\t\t\tAdhoc Discount YN\n\t\t</td>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n</td></tr>\n</table>\n</center>\n<br><center>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</center>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

	private String checkForNull(String inputString) {
	if(inputString == null || "null".equals(inputString)){
		inputString = "";
		}
		return inputString;
	}


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
 request.setCharacterEncoding("UTF-8");
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facility_id = (String)session.getAttribute("facility_id");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
	
    String blngGroup = request.getParameter("billingGrpCode")==null?"":request.getParameter( "billingGrpCode" ).trim().toUpperCase();
    String payerGroup =request.getParameter("payerGrpCode")==null?"":request.getParameter( "payerGrpCode" ).trim().toUpperCase();
    String payer =request.getParameter("payerCode")==null?"":request.getParameter( "payerCode" ).trim().toUpperCase();
	String policyType =request.getParameter("policyTypeCode")==null?"":request.getParameter( "policyTypeCode" ).trim().toUpperCase();

	String validFrom =request.getParameter("validFrom")==null?"":request.getParameter( "validFrom" ).trim().toUpperCase();
	String oprFacId =request.getParameter("facility")==null?"":request.getParameter( "facility" ).trim().toUpperCase();
	String validTo =request.getParameter("validTo")==null?"":request.getParameter( "validTo" ).trim().toUpperCase();
	String applInd =request.getParameter("applInd")==null?"":request.getParameter( "applInd" ).trim().toUpperCase();
	String alwMultiPkgYN =request.getParameter("alwMultiPkgYN")==null?"":request.getParameter( "alwMultiPkgYN" ).trim().toUpperCase();
	String alwPkgCustYN =request.getParameter("alwPkgCustYN")==null?"":request.getParameter( "alwPkgCustYN" ).trim().toUpperCase();
	String alwAdhocPkgYN =request.getParameter("alwAdhocPkgYN")==null?"":request.getParameter( "alwAdhocPkgYN" ).trim().toUpperCase();
	String discPerc =request.getParameter("discPerc")==null?"":request.getParameter( "discPerc" ).trim().toUpperCase();	
	
	if ( (whereClause == null || whereClause.equals("")) )
    {
		int cnt=0;
        if ( !(blngGroup == null || blngGroup.equals("")) ){
	        sql = sql + " and upper(hdr.BLNG_GRP_ID) like upper('"+blngGroup +"%')";
			cnt++;
        }
        if ( !(payerGroup == null || payerGroup.equals("")) ){
				sql=sql+" and upper(hdr.CUST_GROUP_CODE) like '"+payerGroup+"%'";
				cnt=1;
        }        
        if ( !(payer == null || payer.equals("")) ){
				sql=sql+" and upper(hdr.CUST_CODE) like '"+payer+"%'";
				cnt=2;
        }
        if ( !(policyType == null || policyType.equals("")) ){
			sql=sql+" and upper(hdr.POLICY_TYPE_CODE) like '"+policyType+"%'";
			cnt=2;
         }	 

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
	{
		sql=sql+" order by ";
		for ( int i=0;i < ord.length;i++ )
		{
		if ( i == ord.length - 1 )
			sql=sql+ord[i];
		else
			sql=sql+ord[i]+",";
		}
	}
    } //end of where clause IF
    else{
            sql = whereClause;
    }

    int start = 0;
    int end = 0;
    int i=1;

    if ( from == null )
        start = 1;
    else
        start = Integer.parseInt( from );

    if ( to == null )
        end = 14;
    else
        end = Integer.parseInt( to );

	Connection conn  =  ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;

	try{		
		String strsql= "SELECT count(*) as total FROM BL_MULTI_PKG_DISCOUNT hdr where hdr.operating_facility_id = '"+facility_id+"' "+sql ;

		String strsql1="SELECT OPERATING_FACILITY_ID,BLNG_GRP_ID,CUST_GROUP_CODE,CUST_CODE,POLICY_TYPE_CODE, TO_CHAR(VALID_FROM_DATE,'dd/mm/yyyy') VALID_FROM_DATE,TO_CHAR(VALID_TO_DATE,'dd/mm/yyyy') VALID_TO_DATE,APPLICABILITY_IND,ALW_MULTI_PKG_DISC,ALW_CUST_PKG_DISC,ALW_ADHOC_PKG_DISC,DISC_PERC FROM "+
				" BL_MULTI_PKG_DISCOUNT hdr where hdr.operating_facility_id = '"+facility_id+"'  "+sql;
		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			System.out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();		
	}catch(Exception e){
		System.out.println("exception occurred "+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block8Bytes, _wl_block8);

	if ( !(start <= 1) )
		out.println("<A HREF='../../eBL/jsp/MultiPkgDiscQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF='../../eBL/jsp/MultiPkgDiscQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block9Bytes, _wl_block9);
             org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            __tag0.setValue(locale 
);
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

	int mOrder = 0;
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rset.next();
	String classValue= " ";
    while ( rset.next() && i<=end  )
	{
		if ( i % 2 == 0 )
           classValue = "gridData";  
          else
            classValue = "gridData";  
		out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");    
   
		blngGroup=rset.getString("BLNG_GRP_ID");
		payerGroup=rset.getString("CUST_GROUP_CODE");
		payer=checkForNull(rset.getString("CUST_CODE"));
		validFrom=rset.getString("VALID_FROM_DATE");
		policyType=checkForNull(rset.getString("POLICY_TYPE_CODE"));   
		oprFacId=rset.getString("OPERATING_FACILITY_ID");   
		validTo=checkForNull(rset.getString("VALID_TO_DATE"));   
		applInd=checkForNull(rset.getString("APPLICABILITY_IND"));   
		alwMultiPkgYN=checkForNull(rset.getString("ALW_MULTI_PKG_DISC"));   
		alwPkgCustYN=checkForNull(rset.getString("ALW_CUST_PKG_DISC"));   
		alwAdhocPkgYN=checkForNull(rset.getString("ALW_ADHOC_PKG_DISC"));   
		discPerc=checkForNull(rset.getString("DISC_PERC"));    
		
		String mode="modify";
		
		out.println("<a href='../../eBL/jsp/MultiPkgDiscCreate.jsp?mode=modify&blngGroup="+ blngGroup+"&payerGroup="+payerGroup+"&payer="+payer+"&validFrom="+validFrom+"&policyType="+policyType+"&oprFacId="+oprFacId+"&validTo="+validTo+"&applInd="+applInd+"&alwMultiPkgYN="+alwMultiPkgYN+"&alwPkgCustYN="+alwPkgCustYN+"&alwAdhocPkgYN="+alwAdhocPkgYN+"&discPerc="+discPerc+" ' target='MultiPkgDiscCreate' >");	
		
		if("E".equals(applInd)){		
			applInd="All Packages Except High Cost ";		
		}
		
		else if("H".equals(applInd)){		
			applInd="Only High Cost Packages";		
		}
		
		else if("L".equals(applInd)){		
			applInd="Only Low Cost Packages";		
		}
		
		out.println(blngGroup+"</a></td>");
		out.println("<td class='" + classValue+"' nowrap>"+payerGroup+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+payer+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+policyType+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+oprFacId+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+validFrom+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+validTo+"</td>");
		out.println("<td class='" + classValue+"' nowrap >"+applInd+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+discPerc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+alwMultiPkgYN+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+alwPkgCustYN+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+alwAdhocPkgYN+"</td>");    
		i++;
	} 

            _bw.write(_wl_block11Bytes, _wl_block11);

		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
	}
	catch(Exception e)
	{
		//out.println("here "+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setBasename(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDSN.resources.Labels", java.lang.String .class,"basename"));
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("dl_labels", java.lang.String .class,"var"));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
}
