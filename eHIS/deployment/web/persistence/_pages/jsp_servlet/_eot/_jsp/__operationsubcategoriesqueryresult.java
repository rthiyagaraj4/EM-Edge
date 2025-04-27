package jsp_servlet._eot._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __operationsubcategoriesqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperationSubCategoriesQueryResult.jsp", 1721119564000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<P>\n<form name=\'QueryResult\' id=\'QueryResult\'>\n\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n<th class=\'columnheadercenter\' nowrap > <!-- changed by yadav -->\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</th>\n<th class=\'columnheadercenter\' nowrap > <!-- changed by yadav -->\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</th>\n<th class=\'columnheadercenter\'  nowrap > <!-- changed by yadav -->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</th>\n<th class=\'columnheadercenter\' nowrap> <!-- changed by yadav -->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th> \n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</center>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
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
 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(	String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	String whereClause = checkForNull(request.getParameter("whereclause"));
    String from = checkForNull(request.getParameter( "from" )) ;
    String to = checkForNull(request.getParameter( "to" )) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
    int end =  ( to.equals("") )?14:Integer.parseInt(to);
    String oper_group_code= checkForNull(request.getParameter( "oper_group_code" ));
	String oper_cat_code =checkForNull(request.getParameter( "oper_cat_code" ));
	String oper_sub_cat_code =checkForNull(request.getParameter( "oper_sub_cat_code" ));
	String long_desc =checkForNull(request.getParameter( "long_desc" ));
	String enabled = checkForNull(request.getParameter( "status"),"E");
	String enable_img = "<img src='../../eCommon/images/enabled.gif'></img>";
	String disable_img = "<img src='../../eCommon/images/RRnwd.gif'></img>";
	String status_img ="";
	//String speciality_desc="";
	//String oper_cat_desc="";
	String sql = " ";
	StringBuffer sbr=new StringBuffer();
	String classValue="";

	
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=1;

		if ( !(oper_group_code == null || oper_group_code.equals("")) ){

	       // sql = sql + " and upper(c.oper_group_code ) like '"+oper_group_code +"%' ";
	        sql = sql + " and upper(a.oper_group_code ) like '"+oper_group_code +"%' ";
			cnt++;
        }

		if ( !(oper_cat_code == null || oper_cat_code.equals("")) ){

			if(cnt>0)
			//	sql = sql + " and c.oper_cat_code like '"+oper_cat_code+"%' ";
				sql = sql + " and a.oper_cat_code like '"+oper_cat_code+"%' ";

        }

        if ( !(oper_sub_cat_code == null || oper_sub_cat_code.equals("")) ){

			if(cnt>0)
				//sql = sql + " and upper(c.oper_sub_cat_code) like upper('"+oper_sub_cat_code+"%') ";
				sql = sql + " and upper(a.oper_sub_cat_code) like upper('"+oper_sub_cat_code+"%') ";

        }
		 if ( !(long_desc == null || long_desc.equals("")) ){

			if(cnt>0)
				//sql = sql + " and upper(c.long_desc) like upper('"+long_desc+"%')";
				sql = sql + " and upper(a.long_desc) like upper('"+long_desc+"%')";
			else{
				sql=sql+" where upper(long_desc) like upper('"+long_desc+"%')";
				cnt=1;
			}
        }
		
	 

	
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			  // sql = sql+" and nvl(c.status,'E')='E'";
			   sql = sql+" and nvl(a.status,'E')='E'";
			else{
				//sql=sql+ " where  nvl(c.status,'E')='E'";
				sql=sql+ " where  nvl(a.status,'E')='E'";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			//   sql = sql+" and c.status='D'";
			   sql = sql+" and a.status='D'";
			else
				//sql=sql+ "where  c.status='D'";
				sql=sql+ "where  a.status='D'";
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
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
    else
            sql = whereClause;

		//String strsql="select c.oper_group_code,b.short_desc speciality_desc, c.oper_cat_code,a.long_desc oper_cat_desc, c.oper_sub_cat_code, c.long_desc, nvl(c.status,'E') status from  OT_OPER_CATEGORY a, am_speciality b, OT_OPER_SUB_CATEGORY c where c.oper_group_code = b.speciality_code and c.oper_cat_code = a.oper_cat_code"+sql;
		//String strsql="select c.oper_group_code,b.short_desc speciality_desc, c.oper_cat_code,a.long_desc oper_cat_desc, c.oper_sub_cat_code, c.long_desc, nvl(c.status,'E') status from  OT_OPER_CATEGORY a, am_speciality b, OT_OPER_SUB_CATEGORY_LANG_VW c where c.oper_group_code = b.speciality_code and c.oper_cat_code = a.oper_cat_code AND c.LANGUAGE_ID=? "+sql;

		//String strsql="SELECT a.oper_group_code,get_desc(?,'AM_SPECIALITY_LANG_VW','long_desc','SPECIALITY_CODE',a.oper_group_code) speciality_desc, a.oper_cat_code, get_desc(?,'OT_OPER_CATEGORY_LANG_VW','long_desc','OPER_CAT_CODE',a.oper_cat_code) OPER_CAT_DESC, c.oper_sub_cat_code, get_desc(?,'OT_OPER_SUB_CATEGORY_LANG_VW','long_desc','OPER_SUB_CAT_CODE',  c.oper_sub_cat_code) OPER_SUB_CAT_DESC, NVL(c.status,'E') status FROM  OT_OPER_CATEGORY a, AM_SPECIALITY b,  OT_OPER_SUB_CATEGORY c where c.oper_group_code = b.speciality_code and c.oper_cat_code = a.oper_cat_code"+sql;
	//String strsql="SELECT A.OPER_GROUP_CODE, C.LONG_DESC SPECIALITY_DESC, A.OPER_CAT_CODE, B.LONG_DESC OPER_CAT_DESC,   A.OPER_SUB_CAT_CODE, A.LONG_DESC OPER_SUB_CAT_DESC, NVL(A.STATUS,'E') STATUS FROM OT_OPER_SUB_CATEGORY_LANG_VW A, OT_OPER_CATEGORY_LANG_VW B, AM_SPECIALITY_LANG_VW C WHERE A.OPER_GROUP_CODE  = C.SPECIALITY_CODE AND  A.OPER_CAT_CODE  = B.OPER_CAT_CODE AND  A.LANGUAGE_ID =  ? AND   A.LANGUAGE_ID= B.LANGUAGE_ID AND  A.LANGUAGE_ID= C.LANGUAGE_ID "+ sql;

	String strsql="SELECT A.OPER_GROUP_CODE, C.LONG_DESC SPECIALITY_DESC, A.OPER_CAT_CODE, B.LONG_DESC OPER_CAT_DESC,   A.OPER_SUB_CAT_CODE, A.LONG_DESC OPER_SUB_CAT_DESC, NVL(A.STATUS,'E') STATUS FROM OT_OPER_SUB_CATEGORY_LANG_VW A, OT_OPER_CATEGORY_LANG_VW B, AM_SPECIALITY_LANG_VW C WHERE A.OPER_GROUP_CODE  = C.SPECIALITY_CODE AND A.OPER_GROUP_CODE = B.OPER_GROUP_CODE AND  A.OPER_CAT_CODE  = B.OPER_CAT_CODE AND  A.LANGUAGE_ID =  ? AND   A.LANGUAGE_ID= B.LANGUAGE_ID AND  A.LANGUAGE_ID= C.LANGUAGE_ID "+ sql;
	
	Connection conn  =  null;
	PreparedStatement pstmt = null;
	ResultSet rst=null;
	int maxRecord = 0;
//	int i=0;
	try{
		conn  =  ConnectionManager.getConnection(request);	
		pstmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		pstmt.setString(1,locale);
	//	pstmt.setString(2,locale);
	//	pstmt.setString(3,locale);
		rst = pstmt.executeQuery();
		//getting maximum record
	    rst.last();	maxRecord = rst.getRow();
	    if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			
		}
		//again move the resultset pointer to initial position
		rst.beforeFirst();

            _bw.write(_wl_block7Bytes, _wl_block7);

if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/OperationSubCategoriesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/OperationSubCategoriesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

   
    /*oper_group_code = rset.getString(1);
    speciality_desc = rset.getString(2);
	oper_cat_code=rset.getString(3);
    oper_cat_desc=rset.getString(4);
	oper_sub_cat_code=rset.getString(5);
    long_desc= rset.getString(6);
	enabled = rset.getString(7);
	*/


	if ( start!= 1 ) rst.absolute(start-1);
	int i=start;

	while ( rst.next() && i<=end  ){
		classValue = ( i % 2 == 0 )?"gridData":"gridData" ; // changed by yadav
		sbr.append("<tr>");

			//sbr.append("<td class='"+classValue+"'><a href='../../eOT/jsp/OperationSubCategoriesAddModify.jsp?mode=modify&speciality_code="+rst.getString(1)+"&speciality_desc="+rst.getString(2)+"&oper_cat_code="+rst.getString(3)+"&oper_cat_desc="+rst.getString(4)+"&oper_sub_cat_code="+rst.getString(5)+"&oper_sub_cat_desc="+rst.getString(6)+" ' target='f_query_add_mod' >"+rst.getString(2)+"</a></td>");
			sbr.append("<td class='"+classValue+"'><a href='../../eOT/jsp/OperationSubCategoriesAddModify.jsp?mode=modify&speciality_code="+rst.getString(1)+"&oper_cat_code="+rst.getString(3)+"&oper_cat_desc="+rst.getString(4)+"&oper_sub_cat_code="+rst.getString(5)+"&oper_sub_cat_desc="+rst.getString(6)+" ' target='f_query_add_mod' >"+rst.getString(2)+"</a></td>");
			
			sbr.append("<td class='"+classValue+"'>"+rst.getString(4)+"</td>");
			sbr.append("<td class='"+classValue+"'>"+rst.getString(5)+"</td>");
			sbr.append("<td class='"+classValue+"'>"+checkForNull(rst.getString(6))+"</td>");
			status_img = "E".equals(checkForNull(rst.getString(7)))?enable_img:disable_img;
			sbr.append("<td class='"+classValue+"'>"+status_img+"</td>");
			sbr.append("</tr>");

	//String mode="modify";
	//out.println("<a href='../../eOT/jsp/OperationSubCategoriesAddModify.jsp?mode="+mode+"&oper_group_code="+oper_group_code+"&oper_cat_code="+oper_cat_code+"&oper_sub_cat_code="+oper_sub_cat_code+"' target='f_query_add_mod' >");
	

   // out.println(speciality_desc+"</a></td>");

    //out.println("<td class='" + classValue+"'>"+oper_cat_desc+"</td>");
    //out.println("<td class='" + classValue+"'>"+oper_sub_cat_code+"</td>");
    //out.println("<td class='" + classValue+"'>"+long_desc+"</td>");

	/*out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("status").equals("E") || rset.getString("status").equals("null"))
	    out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else 
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	//out.println("<td class='" + classValue + "' align='center'>"); */
	
	i++;
	} 
	out.println(sbr.toString());
	}catch(Exception e){
	e.printStackTrace();
	//System.err.println("Err Msg From OperationSubCategoriesQueryResult-->"+e);
}finally{
		try{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(conn,request);
			sbr.setLength(0);
		}catch(Exception e){e.printStackTrace();}
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SubCategory.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
