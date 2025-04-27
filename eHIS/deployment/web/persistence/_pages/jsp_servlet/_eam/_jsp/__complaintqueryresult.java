package jsp_servlet._eam._jsp;

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
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __complaintqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/ComplaintqueryResult.jsp", 1710444380502L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<P>\n<table align=\'right\'>\n<tr >\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</tr>\n</table>\n\t<br><br>\n</P>\n\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<th>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n<th>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));history.go(-1);</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<script >\n\tif (document.getElementById(\'next\'))\n\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<script >\n\tif (document.getElementById(\'next\'))\n\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</td></tr>\n</table>\n<br><center>\n<!--%\nif ( !(start <= 1) )\n\tout.println(\"<A HREF=\'../../eAM/jsp/ComplaintqueryResult.jsp?from=\"+(start-14)+\"&to=\"+(end-14)+\"&whereclause=\"+URLEncoder.encode(sql)+\"\'\"+\" text-decoration=\'none\'><img src=\'../../eCommon/images/previous.gif\' alt=\'Previous\' border=\'0\'></A>\");\n\nif ( !( (start+14) > maxRecord ) )\n\tout.println(\"<A HREF=\'../../eAM/jsp/ComplaintqueryResult.jsp?from=\"+(start+14)+\"&to=\"+(end+14)+\"&whereclause=\"+URLEncoder.encode(sql)+\"\'\"+\" text-decoration=\'none\'><img src=\'../../eCommon/images/next.gif\' alt=\'Next\' border=\'0\'></A>\");\n%-->\n\n</center>\n</BODY>\n</HTML>\n\n";
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >");
	String whereClause = request.getParameter("whereclause");
//	String sql ;
StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
//	sql=" ";
	String cd    = request.getParameter("complaint_code")==null ?"":request.getParameter("complaint_code");
	String desc    = request.getParameter("complaint_desc")==null ?"":request.getParameter("complaint_desc");
	String enabled    = request.getParameter("nature")==null ?"":request.getParameter("nature");
/*
	String cd = request.getParameter("complaint_code");
	String desc = request.getParameter("complaint_desc");
	String enabled = request.getParameter("nature");
*/

	int andCheck = 0;

	if ( !(cd == null || cd.equals("")) )
			{
			cd=cd.toUpperCase();
			sbQuery.append("where upper(complaint_code) like upper('"+cd+"%')");
			//sql = "where upper(complaint_code) like upper('"+cd+"%')";
			andCheck = 1;
			}

		if ( !(desc == null || desc.equals("")) )
			{
				if ( andCheck == 1 )
				{	
					sbQuery.append(" and ");
					//sql = sql + " and ";
					sbQuery.append(" upper(complaint_desc)  like  upper('"+desc+"%') ");
					//sql = sql + " upper(complaint_desc)  like  upper('"+desc+"%') " ;
				}
				else
				{
					sbQuery.setLength(0);
					sbQuery.append("where upper(complaint_desc)  like upper('"+desc+"%') ");
					//sql = "where upper(complaint_desc)  like upper('"+desc+"%') " ;
					andCheck = 1;
				}
			}


		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
					{sbQuery.setLength(0);
				sbQuery.append("where eff_status='E'");}
				//sql = "where eff_status='E'";
			else
					{	sbQuery.append(" and eff_status='E'");}
				//sql = sql + " and eff_status='E'";
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
				{sbQuery.setLength(0);
				sbQuery.append(" where  eff_status='D'");}
				//sql = " where  eff_status='D'";
			else
				{sbQuery.append(" and eff_status='D'");}
				//sql = sql + " and eff_status='D'";
		}
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append(" order by ");
		//sql=sql+" order by ";

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
			//sql=sql+ord[i];
		else
			sbQuery.append(ord[i]+",");
			//sql=sql+ord[i]+",";
		}
	}
	} //end of where clause IF
	else {
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
		//sql = whereClause;

	}

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
Connection conn = null;
conn = ConnectionManager.getConnection(request);
Statement stmt=null;
//ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;

try{




String strsql2="select * from am_complaint "+sbQuery.toString();
stmt = conn.createStatement();
if(rs!=null)rs.close();
rs = stmt.executeQuery(strsql2);

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	while ( i<=end && rs.next() )
	{
		if(maxRecord==0)
		{

            _bw.write(_wl_block6Bytes, _wl_block6);

if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/ComplaintqueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/ComplaintqueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 }
 	
	  String classValue = "" ;

if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("complaint_code");


	out.println("<a href='../../eAM/jsp/addModifyComplaint.jsp?complaint_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "' wrap >");
	out.println( rs.getString("complaint_desc") );


	out.println("</td>");

	out.println("<td class='" + classValue + "' align='center' >");
	if ( rs.getString("eff_status").equals("E") )
		out.print("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
  }//endwhile

  if(maxRecord == 0)
{
            _bw.write(_wl_block10Bytes, _wl_block10);
}

if ( maxRecord < 14 || (!rs.next()) ) {

            _bw.write(_wl_block11Bytes, _wl_block11);

		} else {
            _bw.write(_wl_block12Bytes, _wl_block12);
}

    if(rs!=null)	rs.close();
    if(stmt!=null)	stmt.close();
  sbQuery.setLength(0);
}
catch(Exception e)
{
		e.toString();
}
finally 
{
	
	ConnectionManager.returnConnection(conn,request);
	

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
