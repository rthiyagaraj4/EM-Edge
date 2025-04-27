package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __capersonalizedresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAPersonalizedResult.jsp", 1709115576636L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script language=javascript src=\'../../eCA/js/CAPersonalizedHomePage.js\'></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<HTML>\n\t<head>\n\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<!-- Added by Arvind @ 08-12-08 -->\n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\t\n\n</head>\n<body  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n<br>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n<td class=\'white\' width=\'88%\'></td> \n<td  align=\'right\' width=\'12%\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n\n<table class=\'grid\' border=\'1\' width=\"100%\"  align=\'center\'>\n<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n<td class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</table>\n</center>\n\n<br><center>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</center>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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

		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection conn  = null;
PreparedStatement pstmt1 = null;
PreparedStatement pstmt2 = null;
PreparedStatement pstmt  = null;
ResultSet rset = null;
ResultSet rset1 = null;
ResultSet rset2 = null;
ResultSet rset3 = null;
ResultSet rs = null;

try{
	String practDesc="";
	String practName="";
	String sumDesc="";
	String sqlStr="";
	conn  =  ConnectionManager.getConnection(request);
	String whereClause = request.getParameter("whereclause");	
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql =new StringBuffer();
    int andCheck = 0;
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

    
    String pract_type  = request.getParameter("pract_type");
    	if(pract_type == null) pract_type ="";

    	
    String qry_sub = request.getParameter("practitioner_id");
    	if(qry_sub == null) qry_sub ="";

		
    	
    String desk_sub = request.getParameter("DESKTOP_SUMMARY_ID");
    	if(desk_sub == null) desk_sub ="";    	
    
    pract_type   = pract_type.toUpperCase();
    qry_sub  = qry_sub.toUpperCase();
    desk_sub = desk_sub.toUpperCase();
	
	        
    if ( (whereClause == null || whereClause.equals("")) )
    {
	if ( !(pract_type == null || pract_type.equals("")) )
	{
		//sql = sql + " where text_blk_id like '"+text_blk_id+"%'";
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" where pract_type like ?");
		pract_type = pract_type+"%";
		andCheck = 1;
	}
	
	if ( !(qry_sub == null || qry_sub.equals("")) )
	{
		if ( andCheck == 1 )
		{
			sql.append(" and ");
			sql.append("PRACTITIONER_ID like  ? ");
			qry_sub = qry_sub+"%";
		}
		else
		{
			sql.append(" where PRACTITIONER_ID like ? ");
			qry_sub = qry_sub+"%";
			andCheck = 1;
		}
	}
	if ( !(desk_sub == null || desk_sub.equals("")) )
	{
		if ( andCheck == 1 )
		{
			sql.append(" and ");
			sql.append("DESKTOP_SUMMARY_ID like  ?");
			desk_sub = desk_sub+"%";
		}
		else
		{
			sql.append(" where DESKTOP_SUMMARY_ID like ?" );
			desk_sub = desk_sub+"%";
			andCheck = 1;
		}
 	}

   //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append(" Order by ");
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql.append(ord[i]);
        else
            sql.append(ord[i]+",");
        }
    }

    } //end of where clause IF
    else
            sql.append(whereClause);

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



	int maxRecord = 0;



StringBuffer strsql=new StringBuffer();
strsql.append("select count(*) as total from SM_PERSONALIZED_HOME_PAGE ");
strsql.append(sql.toString());

//out.println("strsql ="+strsql.toString()+"=");
//out.println("qry_sub ="+qry_sub+"=");
//out.println("desk_sub ="+desk_sub+"=");

StringBuffer strsql1=new StringBuffer();
strsql1.append("select * from  SM_PERSONALIZED_HOME_PAGE  ");
//strsql1.append("SELECT a.PRACT_TYPE,NVL (d.DESC_USERDEF,d.DESC_SYSDEF)PRACT_TYPE_DESC,a.PRACTITIONER_ID,c.PRACTITIONER_NAME,a.DESKTOP_SUMMARY_ID, b.DESKTOP_SUMMARY_NAME  FROM SM_PERSONALIZED_HOME_PAGE a,SM_DESKTOP_SUM_HDR b,AM_PRACTITIONER c,AM_PRACT_TYPE d WHERE a.DESKTOP_SUMMARY_ID=b.DESKTOP_SUMMARY_ID AND a.PRACTITIONER_ID=c.PRACTITIONER_ID AND a.PRACT_TYPE=d.PRACT_TYPE");
strsql1.append(sql.toString());
pstmt	      = conn.prepareStatement(strsql.toString());

int colIndex = 0;
String sqlstr	=sql.toString();	
sqlstr=sqlstr.toLowerCase();
whereClause	=	sqlstr;
sqlstr = sqlstr.substring(0,sqlstr.indexOf("order by"));

if(sqlstr.indexOf("pract_type")!=-1)
	pstmt.setString(++colIndex,pract_type) ;
if(sqlstr.indexOf("practitioner_id")!=-1)
	pstmt.setString(++colIndex,qry_sub);
if(sqlstr.indexOf("desktop_summary_id")!=-1)
	pstmt.setString(++colIndex,desk_sub);

rs  = pstmt.executeQuery();

rs.next();

maxRecord = rs.getInt("total");              

if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
}

colIndex = 0;

pstmt1	      = conn.prepareStatement(strsql1.toString());

if(sqlstr.indexOf("pract_type")!=-1)
	pstmt1.setString(++colIndex,pract_type) ;
if(sqlstr.indexOf("practitioner_id")!=-1)
	pstmt1.setString(++colIndex,qry_sub);
if(sqlstr.indexOf("desktop_summary_id")!=-1)
	pstmt1.setString(++colIndex,desk_sub);   


rset = pstmt1.executeQuery();


            _bw.write(_wl_block8Bytes, _wl_block8);

	
if ( !(start <= 1) )
    out.println("<A class='gridLink'  href='../../eCA/jsp/CAPersonalizedResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(whereClause) + "'" + " text-decoration='none'>Prev</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/CAPersonalizedResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+" text-decoration='none'>Next</A>");

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
    
    		out.println("<tr><td class='" + classValue + "'>");
	
    		pract_type 	= rset.getString("PRACT_TYPE");
    			if(pract_type == null) pract_type ="";
    		qry_sub	= rset.getString("PRACTITIONER_ID");
			
    			if(qry_sub == null) qry_sub ="&nbsp;";
    		desk_sub	= rset.getString("DESKTOP_SUMMARY_ID");
    			if(desk_sub == null) desk_sub ="&nbsp;";

			sqlStr="SELECT PRACT_TYPE,NVL (DESC_USERDEF,DESC_SYSDEF) PRACT_TYPE_DESC FROM AM_PRACT_TYPE WHERE PRACT_TYPE=?";
			pstmt2 = conn.prepareStatement(sqlStr);
			pstmt2.setString(1,pract_type);
			rset1 = pstmt2.executeQuery();
			if(rset1.next())
				practDesc=rset1.getString("PRACT_TYPE_DESC");
			if(practDesc == null) practDesc ="";
			
			if(pstmt2!=null)pstmt2.close();
			if(rset1!=null)rset1.close();
			if(qry_sub.equals("*ALL")){
				practName="ALL";			
			}
			else
			{
				sqlStr="SELECT PRACTITIONER_ID,PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?";
				pstmt2 = conn.prepareStatement(sqlStr);
				pstmt2.setString(1,qry_sub);
				rset2 = pstmt2.executeQuery();
				if(rset2.next())
					practName=rset2.getString("PRACTITIONER_NAME");
			}
				if(practName == null) practName ="&nbsp;";
				if(pstmt2!= null) pstmt2.close();
			
				sqlStr="SELECT DESKTOP_SUMMARY_ID, DESKTOP_SUMMARY_NAME FROM SM_DESKTOP_SUM_HDR WHERE DESKTOP_SUMMARY_ID=?";
				pstmt2 = conn.prepareStatement(sqlStr);
				pstmt2.setString(1,desk_sub);
				rset3 = pstmt2.executeQuery();
				if(rset3.next())
					sumDesc=rset3.getString("DESKTOP_SUMMARY_NAME");
				if(sumDesc == null) sumDesc ="&nbsp;";
				if(pstmt2!= null) pstmt2.close();
			    if(rset3!= null) rset3.close();	
				
		out.println("<a class='gridLink'  href='../../eCA/jsp/CAPersonalizedPractLookup.jsp?pract_type="+ pract_type+"&pract_id="+qry_sub+"' target='frame3' >");
    		out.println(practDesc+"</a></td><td class='" + classValue + "'>");
    		out.println(practName+"</td><td class='" + classValue + "'>");
		out.println(sumDesc+"</td>");
		i++;
	}
	
	

            _bw.write(_wl_block13Bytes, _wl_block13);

	if(rs!= null) rs.close();
	if(rset!= null) rset.close();	
	if(rset2!= null) rset2.close();	
	if(pstmt!= null) pstmt.close();
	if(pstmt1!= null) pstmt1.close();
}
catch(Exception e)
{
	//out.println("err"+e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(conn!=null)ConnectionManager.returnConnection(conn,request);
}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionertype.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Desktop.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
