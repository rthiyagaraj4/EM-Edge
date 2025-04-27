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

public final class __alertcategoryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AlertCategoryResult.jsp", 1709115449155L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n<body class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<form name =\'AlertCategoryResultForm\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<!-- <modified by Arvind  90 to 100 @10-12-08> -->\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\n<tr>\n<td class=\'white\' width=\'65%\' ></td> \n<td  align=\'right\' width=\'15%\' nowrap>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td></tr>\n</table>\n\n<table class=\'grid\' border=\'1\' width=\'100%\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' >\n\t\n\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\n\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\n</table>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</form>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");	
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			=	null ;
	String whereClause		=	"";
	String alert_categ_code ="";
	String alert_categ_desc ="";
	String mode ="";	
	StringBuffer sql = new  StringBuffer();
	PreparedStatement pstmt=null,pstmt1=null;
	int maxRecord =	 0;
	ResultSet rset=null;
	ResultSet rs = null;

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
	

	try	{
			mode="modify";
			whereClause= request.getParameter("whereclause");
			if(whereClause==null) whereClause="";

			String from = request.getParameter( "from" ) ;
		    String to = request.getParameter( "to" ) ;

			alert_categ_code=request.getParameter("alert_categ_code");
			if( alert_categ_code == null)
				alert_categ_code = "";
			
			alert_categ_desc=request.getParameter("alert_categ_desc");
			if( alert_categ_desc == null)
				alert_categ_desc = "";		



if ( (whereClause == null || whereClause.equals("null") || whereClause.equals("") ) )
{
		int cnt=0;
		if( !(alert_categ_code == null || alert_categ_code.equals("null") || alert_categ_code.equals("") ) )
		{
		    sql.append(" where upper(alert_categ_code) like upper('"+alert_categ_code+"%') ");
			cnt++;
		}

		if( !(alert_categ_desc == null  || alert_categ_desc.equals("null") || alert_categ_desc.equals("")) )
		{
			if(cnt>0)
			{
				sql.append( "and upper(alert_categ_desc) like upper('"+alert_categ_desc+"%')");
			}
			else
			{ sql=new StringBuffer();
				sql.append(" where upper(alert_categ_desc) like  upper('"+alert_categ_desc+"%')");
				cnt = 1;
			}
		}
	

		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null  || ord .equals("null") || ord .equals("")) )
		{
				sql.append(" order by ");
				for ( int i=0;i < ord.length;i++ )
				{
					if ( i == ord.length - 1 )
					{
						sql.append(ord[i]);
					}
					else
					{
						sql.append(ord[i]+",");
					}
				}			
		}//if ord

}// if of where clause

else
		{	
			sql=new StringBuffer();
			sql.append(whereClause);
		}

int start = 0 ;
    int end = 0 ;
    int i=1;

		if ( from == null)
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

	    if ( to == null)
		    end = pageCnt ;
		else
			end = Integer.parseInt( to ) ;	

	con  = ConnectionManager.getConnection(request);
	
	try
	{	// stmt = con.createStatement();	

	   
		String strsql= "select count(*) as total from CA_ALERT_CATEG"+sql.toString();
		pstmt=con.prepareStatement(strsql);
		
		String strsqll="select a.alert_categ_code,a.alert_categ_desc  from CA_ALERT_CATEG a ";
		//out.println("sql "+strsqll+sql);		
	
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		
		
		if(maxRecord == 0)
		{
			//out.println("<script>alert('NO RECORD FOUND FOR CRITERIA');history.go(-2);</script>");

			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		pstmt1=con.prepareStatement(strsqll+sql.toString());
		rset =pstmt1.executeQuery();
    }
	

	catch (Exception e)
	{
		//out.println("Exception :"+e.getMessage());//common-icn-181
		e.printStackTrace();//COMMON-ICN-0181
	}


            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) )
    out.println("<A class='gridLink' HREF='../../eCA/jsp/AlertCategoryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/AlertCategoryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
      {
          if ( i % 2 == 0 )
            classValue = "gridData" ;
            else
            classValue = "gridData" ;
		
	alert_categ_code	=(rset.getString(1)==null)?"":rset.getString(1);
	alert_categ_desc=(rset.getString(2)==null)?"":rset.getString(2); 
  
	//out.println("eff_status...."+eff_status);

	out.println("<tr><td class='" + classValue + "'>");
	out.println("<a class='gridLink' href='../../eCA/jsp/AlertCategAddModify.jsp?mode="+mode+"&alert_categ_code="+alert_categ_code+"' target='f_query_add_mod'>");    
    out.println(alert_categ_code+"</a></td>");

	out.println("<td class='" + classValue + "'>"+alert_categ_desc+"</td>");

	out.println("</tr>");

	i++;
	  }

            _bw.write(_wl_block12Bytes, _wl_block12);


	if( rs!=null) rs.close();
	if( rset!=null) rset.close();
	if (pstmt!=null)pstmt.close();
	if (pstmt1!=null) pstmt1.close();
}//end of 1st try block

	catch (Exception e)
	{
		//out.println("Exception :"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{	
		if(con!=null) ConnectionManager.returnConnection(con,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AlertCategoryCode.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AlertCategoryDescription.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
