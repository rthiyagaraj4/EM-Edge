package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.ConnectionManager;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.*;
import com.ehis.util.*;

public final class __blpolicytypequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPolicyTypeQueryResult.jsp", 1729496822293L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident        SCF/CRF             Developer Name\n-----------------------------------------------------------------------------------\n1            V200904            72977         NMC-JD-CRF-0059       Mohana Priya K\n2            V201022            74289         NMC-JD-CRF-0059       Mohana Priya K\n3  \t\t\t V211020\t\t\t\t\t\t\t\t\t\t\tMohanapriya K\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<BODY class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<P>\n<form name=\"QueryResult\" id=\"QueryResult\">\n<table cellspacing=0 cellpadding=3  align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n<table width=\"99%\" cellspacing=\"0\" cellpadding=\"3\" align=\"center\" style=\"border: 1px solid black; border-collapse: collapse;\">\n    <tr>\n        <td class=\'COLUMNHEADERCENTER\' align=\"center\" nowrap> \n            ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n        </td>\n        <td class=\'COLUMNHEADERCENTER\' align=\"center\" nowrap>\n            ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n        </td>\n    </tr>\n\n    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</table>\n</center>\n<br><center>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</center>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection conn  = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	ResultSet rset=null;
	ResultSet rs = null;
	boolean siteSpec=false;
	String sitespecval="N";
	try{
		conn=ConnectionManager.getConnection(request);
		siteSpec = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_POLICY_TYPES");
		if(siteSpec){
			sitespecval="Y";
		}else{
			sitespecval="N";
		}
		}catch(Exception e)
		{
		out.println("Exception in sitespec is "+e);
		}
		finally{
			try{
				if(stmt!=null) stmt.close();
				if(rs!=null)rs.close();
				//ConnectionManager.returnConnection(conn); //V211020
			}catch(Exception e)
			{
				//out.println("Exception is "+e);
				e.printStackTrace();
			}
		}

	try
	{   
		String whereClause = request.getParameter("whereclause");
		if(whereClause==null) whereClause="";
		String from = checkForNull(request.getParameter( "from" ),"1") ;
		String to = checkForNull(request.getParameter( "to" ),"14" ) ;
		String sql = "";
   	 	String facility= (String) session.getValue( "facility_id" );
		String policy_type_code= request.getParameter("policy_type_code")==null?"":request.getParameter( "policy_type_code" );
		String short_desc =request.getParameter("short_desc")==null?"":request.getParameter( "short_desc" );
		String long_desc =request.getParameter("long_desc")==null?"":request.getParameter( "long_desc" );
		String gosi_yn = request.getParameter("gosipolicy")==null?"N":request.getParameter( "gosipolicy");
		if(request.getParameter("gosipolicy")==null || request.getParameter("gosipolicy")=="N"){
		   gosi_yn="N";
		}else{
			gosi_yn="Y";
		} 

		if ( (whereClause == null || whereClause.equals("")) )
		{
			int cnt=0;
		if ( !(policy_type_code == null || policy_type_code.equals("")) ){					
			sql = sql + "where  upper(policy_type_code ) like upper('"+policy_type_code +"%') ";
			cnt++;
		}

		if ( !(short_desc == null || short_desc.equals("")) ){
			if (sql.length() > 0)  sql =sql+"  and ";
			if(cnt>0)
				sql = sql + " upper(short_desc) like upper('"+short_desc+"%') ";
			else 
			{
				sql = " where upper(short_desc) like upper('"+short_desc+"%') ";
				cnt++;
			}
		}

		if ( !(long_desc == null || long_desc.equals("")) ){
			if (sql.length() > 0)  sql =sql+"  and ";
			if(cnt>0)
				sql = sql + " upper(long_desc) like upper('"+long_desc+"%')";
			else 
			{
				sql = " where upper(long_desc) like upper('"+long_desc+"%') ";
				cnt++;
			}
		}
		 if ( !(facility == null || facility.equals("")) ){   //V201022
			 if (sql.length() > 0)  sql =sql+"  and ";
			if(cnt>0)
				sql = sql + " upper(OPERATING_FACILITY_ID) like upper('"+facility+"%')";
			else 
				{
				  sql = " where upper(OPERATING_FACILITY_ID) like upper('"+facility+"%') ";
				  cnt++;
				}
        }//V201022
		if("Y".equals(sitespecval)){
			if ( !(gosi_yn == null || gosi_yn.equals("")) ){			
				if( gosi_yn.equals("Y") ){
				if (sql.length() > 0)  sql =sql+"  and ";
				if(cnt>0)
					sql = sql+"  nvl(GOSI_YN,'N')='Y'";
				else{
					sql=sql+ " where  nvl(GOSI_YN,'N')='Y'";
					cnt=1;
				}
		}
	
		if ( gosi_yn.equals("N") ){
			if (sql.length() > 0)  sql =sql+"  and ";
				if(cnt>0)
					sql = sql+"  nvl(GOSI_YN,'Y')='N'";
				else
					sql=sql+ "where  nvl(GOSI_YN,'Y')='N'";
			}
		}
		}

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
		} //end of where clause IF
		else{
				sql = whereClause;
			}
		}

		int start = 0;
		int end = 0;
		int i=1;
		start = Integer.parseInt( from );
		end = Integer.parseInt( to );

		//conn  =  ConnectionManager.getConnection(request); //V211020

	int maxRecord = 0;
	try{
			String strsql= "SELECT POLICY_TYPE_CODE,LONG_DESC,SHORT_DESC FROM BL_INS_POLICY_TYPES "+sql;
			String strsql1= "SELECT POLICY_TYPE_CODE,LONG_DESC,SHORT_DESC FROM BL_INS_POLICY_TYPES "+sql;			
			
			stmt = conn.prepareStatement(strsql);
			rs = stmt.executeQuery();
			int total=0;
			while(rs.next())
			{
				total++;
			}
			
			maxRecord = total;
			if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			}
			stmt1=conn.prepareStatement(strsql1);
			rset = stmt1.executeQuery();
			
		}catch(Exception e){
			e.printStackTrace();
			//out.println("sdfsadfs "+e);
		}

            _bw.write(_wl_block8Bytes, _wl_block8);

	if ( !(start <= 1) )
		out.println("<A HREF='../../eBL/jsp/BLPolicyTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF='../../eBL/jsp/BLPolicyTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

        if (start != 1)
            for (int j = 1; j < start; i++, j++)
                rset.next();

        String classValue = " ";
        while (rset.next() && i <= end) {
            classValue = (i % 2 == 0) ? "gridData" : "gridData"; 

            // Use a very light gray color for the row separator
            out.println("<tr style='border-bottom: 1px solid #e0e0e0;'>"); // Lighter gray
            out.println("<td align='left' class='" + classValue + "'>");
            
            policy_type_code = rset.getString(1);
            long_desc = rset.getString(2);
            short_desc = rset.getString(3);
            String mode = "modify"; 

            out.println("<a href='../../eBL/jsp/BLPolicyTypesAddModify.jsp?mode=" + mode + "&policy_type_code=" + policy_type_code + "' target='f_query_add_modify'>");
            out.println(policy_type_code + "</a></td>");
            out.println("<td class='" + classValue + "'>" + long_desc + "</td>");  
            out.println("<td class='" + classValue + "'>" + short_desc + "</td>");		 
            out.println("</tr>");
            i++;
        }
    
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	catch(Exception e)
	{
		//out.println("here "+e);
		e.printStackTrace();
	}
	finally
	{
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_TYPE_CODE.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.longdescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.shortdescription.label", java.lang.String .class,"key"));
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
