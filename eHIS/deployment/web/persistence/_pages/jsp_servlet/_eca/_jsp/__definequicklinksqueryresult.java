package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __definequicklinksqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/DefineQuickLinksQueryResult.jsp", 1731747282178L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n<HTML>\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <!-- Added by Arvind @ 08-12-08 -->\n\t\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n</head>\n\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t<tr>\n\t\t<td class=\'white\' width=\'88%\'></td> \n\t\t<td nowrap  width=\'12%\' align=\'right\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</td>\n\t</tr>\n</table>\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t<tr>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'20%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'30%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'20%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td></tr>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</table>\n</center>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</BODY>\n</HTML> \n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
 
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
---------------------------------------------------------------------------------------------------------------
*/

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
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
    
	StringBuffer sql = new StringBuffer();
	
	String ql_type= (request.getParameter("ql_type")==null)?"":request.getParameter("ql_type");
	//String ql_type  = request.getParameter("ql_type");
	String function_name  = request.getParameter("function_name");
    String desc = request.getParameter("desc");
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	if(desc == null)
		desc = "";
	else
		desc = desc.toUpperCase();
    String scope = request.getParameter("scope");
	String eff_status = request.getParameter("eff_status");

//	out.println("whereClause   :**"+whereClause+"**<br/>");

	if( (whereClause == null || whereClause.equals("")) )
    {
		sql = new StringBuffer();
		StringBuffer sqlTemp = new StringBuffer();



		if( !(ql_type == null || ql_type.equals("")) )
        {
			sqlTemp.append("and t.QUICK_LINK_TYPE like '"+ql_type +"%' ");
        }

        if( !(function_name == null || function_name.equals("")) )
        {
			sqlTemp.append("and upper(t.SYS_OPTION_DESC) like UPPER('"+function_name+"%') ");
        }
		if ( !(desc == null || desc.equals("")) )
        {
			sqlTemp.append("and UPPER(t.QUICK_LINK_DESCRIPTION) like UPPER('"+desc+"%') ");
        }
		if( !(scope == null || scope.equals("")) )
		{
			if(scope.equals("F") )
			{
				sqlTemp.append("and t.FUNCTION_SPEC_YN='Y' ");
			}
			else if(scope.equals("G") )
			{
				 sqlTemp.append("and t.GLOBAL_YN='Y' ");
			}
		}
		if( !(eff_status == null || eff_status.equals("")) )
		{
			if(eff_status.equals("E"))
			{
				sqlTemp.append("and t.EFF_STATUS='E' ");
			}
			else if( eff_status.equals("D"))
			{
				sqlTemp.append("and t.EFF_STATUS='D' ");
			}
		}
		// Modified by Sridhar Reddy on 06/04/2010 issue form site (If defined quicklink for only External application not fetching data in query mode )
		if(sqlTemp.length() > 0){
			sql.append(" WHERE ");
			//out.println(sqlTemp.indexOf("and"));
			if(sqlTemp.indexOf("and") == 0)
				sqlTemp.delete(0,3);

			sql.append(sqlTemp);
		}
		// End
		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ )
			{
				if ( i == ord.length - 1 )
				{
					if(ord[i].equals("t.SYS_OPTION_DESC"))
						sql.append(ord[i]);
					else
						sql.append("t."+ord[i]);
				}
				else
				{
					if(ord[i].equals("t.SYS_OPTION_DESC"))
						sql.append(ord[i]+",");
					else
						sql.append("t."+ord[i]+",");
				}
			}
		}
    } //end of where clause IF
    else
	{
		sql = new StringBuffer();
		// Modified by Sridhar Reddy on 06/04/2010 issue form site (If defined quicklink for only External application not fetching data in query mode )
		if (whereClause != null && !whereClause.equals("")) 
			sql.append(whereClause);

		//End
	}

    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;

	Connection conn  =  ConnectionManager.getConnection(request);

	PreparedStatement stmt;
	int maxRecord = 0;
	ResultSet rs = null;

	//String strsql1="select a.QUICK_LINK_TYPE, a.OPTION_ID, B.SYS_OPTION_DESC, a.QUICK_LINK_DESCRIPTION, a.FUNCTION_SPEC_YN, a.GLOBAL_YN, a.EFF_STATUS from SM_QUICK_LINK_LIST a, SM_QUICK_LINK_OPTION B WHERE B.OPTION_ID(+)=a.OPTION_ID  "+sql.toString();
	//String strsql1="select  distinct t.QUICK_LINK_REF, t.QUICK_LINK_TYPE,t.OPTION_ID,t.SYS_OPTION_DESC,t.QUICK_LINK_DESCRIPTION,t.FUNCTION_SPEC_YN,t.GLOBAL_YN, t.EFF_STATUS from SM_QUICK_LINK_LIST_VW t,SM_QUICK_LINK_LIST a, SM_QUICK_LINK_OPTION B WHERE B.OPTION_ID =a.OPTION_ID "+sql.toString();

	// Modified by Sridhar Reddy on 06/04/2010 issue form site (If defined quicklink for only External application not fetching data in query mode )
	String strsql1="select  distinct t.QUICK_LINK_REF, t.QUICK_LINK_TYPE,t.OPTION_ID,t.SYS_OPTION_DESC,t.QUICK_LINK_DESCRIPTION,t.FUNCTION_SPEC_YN,t.GLOBAL_YN, t.EFF_STATUS from SM_QUICK_LINK_LIST_VW t "+sql.toString();

	// End

	//out.println(strsql1);
	try
	{
		stmt = conn.prepareStatement(strsql1);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			maxRecord++;
		}
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		stmt=conn.prepareStatement(strsql1);
		rs = stmt.executeQuery();

            _bw.write(_wl_block8Bytes, _wl_block8);

		if ( !(start <= 1) )
			out.println("<A class='gridLink' HREF='../../eCA/jsp/DefineQuickLinksQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if ( !( (start+pageCnt) > maxRecord ) )
			out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/DefineQuickLinksQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
		  rs.next() ;
		String classValue= " ";
		while ( rs.next() && i<=end  )
		{
			if ( i % 2 == 0 )
				classValue = "gridData" ;
			else
				classValue = "gridData" ;
			
			if(i==end)
				out.println("<tr style='border-bottom: 2px solid grey;'><td align=='left' class='" + classValue + "'>");
			else 
				out.println("<tr ><td align=='left' class='" + classValue + "'>");
			String ql_ref1			= rs.getString("QUICK_LINK_REF") == null ? "" : rs.getString("QUICK_LINK_REF");
			String ql_type1			= rs.getString("QUICK_LINK_TYPE") == null ? "" : rs.getString("QUICK_LINK_TYPE");
			//String function_id		= rs.getString("OPTION_ID") == null ? "" : rs.getString("OPTION_ID");
			String function_name1	= rs.getString("SYS_OPTION_DESC") == null ? "&nbsp;" : rs.getString("SYS_OPTION_DESC");
			String desc1			= rs.getString("QUICK_LINK_DESCRIPTION") == null ? "" : rs.getString("QUICK_LINK_DESCRIPTION");
			String function_spec_yn	= rs.getString("FUNCTION_SPEC_YN") == null ? "N" : rs.getString("FUNCTION_SPEC_YN");
			String global_yn		= rs.getString("GLOBAL_YN") == null ? "N" : rs.getString("GLOBAL_YN");
			String eff_status1		= rs.getString("EFF_STATUS") == null ? "" : rs.getString("EFF_STATUS");

			if(ql_type1.equals("QF")) ql_type1="Query Filter";
			else if(ql_type1.equals("AF")) ql_type1="Actual Function";
			else if(ql_type1.equals("EX")) ql_type1="External Application";
			else if(ql_type1.equals("AM")) ql_type1="Adaptive Menu";
			else  ql_type1 ="";
			
			String scope1 = "";
			if(function_spec_yn.equals("Y") && global_yn.equals("Y")){
				//scope1 = "Both";
				scope1 = "Global,Function Specific";
			}
			else if(function_spec_yn.equals("Y"))
				scope1 = "Function Specific";
			else if(global_yn.equals("Y"))
				scope1 = "Global";
			else
				scope1 = "&nbsp;";

			out.println(ql_type1);
			out.println("</td><td class='" + classValue + "'>");

			/*if(ql_type.equals("AM")){
			out.println("<a class='gridLink' href='../../eCA/jsp/DefineQuickLinksAddModify.jsp?mode=update&description="+ URLEncoder.encode(desc1)+"' target='f_query_add_mod' >");
			out.println(desc1);
			out.println("</td><td class='" + classValue + "'>");
			out.println("<a class='gridLink' href='../../eCA/jsp/DefineQuickLinksAddModify.jsp?mode=update&description="+ URLEncoder.encode(desc1)+"' target='f_query_add_mod' >");
			out.println("");

			}

			else{*/		
				
			if(ql_type1.equals("Adaptive Menu")){
				out.println("</td><td class='" + classValue + "'>");
				out.println(desc1);
				
			}
			else{
			out.println(function_name1);
			out.println("</td><td class='" + classValue + "'>");
			out.println("<a class='gridLink' href='../../eCA/jsp/DefineQuickLinksAddModify.jsp?ql_ref1="+ql_ref1+"&mode=update&description="+ URLEncoder.encode(desc1,"UTF-8")+"' target='f_query_add_mod' >");
			out.println(desc1);
			}
			out.println("</a></td><td class='" + classValue + "'>");
			out.println(scope1);
			out.println("</td><td class='" + classValue + "' >");
			if ( eff_status1.equalsIgnoreCase("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
			out.println("</td>");
			out.println("</tr>");
			i++;
		} 

            _bw.write(_wl_block14Bytes, _wl_block14);

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception @ 3333"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}	


            _bw.write(_wl_block15Bytes, _wl_block15);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.QuickLinkType.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Scope.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
}
