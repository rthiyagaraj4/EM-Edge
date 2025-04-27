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

public final class __storesforoperatingroomqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/StoresforOperatingRoomQueryResult.jsp", 1725853574000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eOT/js/StoresforOperatingRoom.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\"QueryResult\" id=\"QueryResult\">\n\n<P>\n<form name=\"QueryResult\" id=\"QueryResult\">\n<table cellspacing=0 cellpadding=3  align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n\n<table class=\'grid\' border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=3 align=\'center\' >\n\n<tr>\n<th class=\"columnheadercenter\" nowrap>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</th>\n\n<th class=\"columnheadercenter\" nowrap >\n\tFacility Name\n</th>\n<th class=\"columnheadercenter\" nowrap> \n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\n</th>\n<th class=\"columnheadercenter\" nowrap> \n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\n</th>\n<th class=\"columnheadercenter\" nowrap > \n\tDefault Store\n</th>\n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</tr>\n</table>\n<br><center>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</center>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
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
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	try{
    String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
    String operating_room_code =request.getParameter("operating_room_code")==null?"":request.getParameter("operating_room_code" );
	String facility_name = request.getParameter("facility_name")==null?"":request.getParameter("facility_name");
	String store_desc = request.getParameter("store_desc")==null?"":request.getParameter("store_desc");
	String type_desc = request.getParameter("type_desc")==null?"":request.getParameter("type_desc");
	String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
	String sql="";
    //String speciality_desc="";
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=1;
	
	if ( !(operating_room_code == null || operating_room_code.equals("")) )
		{
			sql+= "AND  D.OPER_ROOM_CODE = '"+operating_room_code+"' ";
			//andCheck = 1;
			cnt++;
		}
	if ( !(facility_name == null || facility_name.equals("")) )
		{
		if(cnt>0)
			sql+= "AND  upper(D.STORE_FACILITY_ID) like upper('"+facility_name+"%')";
			//andCheck = 1;
			else{
				sql=sql+" AND upper(D.STORE_FACILITY_ID) like upper('"+facility_name+"%')";
				cnt=1;

		}
	} 
	 	
	if ( !(store_desc == null || store_desc.equals("")) )
		{
			if(cnt>0)
			sql+= "AND  upper(D.STORE_CODE) like upper('%"+store_desc+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" AND upper(D.STORE_CODE) like upper('%"+store_desc+"%')";
				cnt=1;
			}
		}
    if ( !(type_desc == null || type_desc.equals("")) )
		{
			if(cnt>0)
			sql+= "AND  upper(D.STORE_TYPE) like upper('%"+type_desc+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" AND upper(D.STORE_TYPE) like upper('%"+type_desc+"%')";
				cnt=1;
			}
		}
     if ( !(default_yn == null || default_yn.equals("")) )
		{
			if(cnt>0)
			sql+= "AND  upper(D.DEFAULT_YN) like upper('%"+default_yn+"%') ";
			//andCheck = 1;
			else{
				sql=sql+" AND upper(D.DEFAULT_YN) like upper('%"+default_yn+"%')";
				cnt=1;
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
	}//end of where clause IF

 else
    {
	sql = whereClause;
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

Connection 	conn = ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
ResultSet rs=null;
ResultSet rset=null;
int maxRecord = 0;
try{


//String strsql="SELECT D.OPER_ROOM_CODE,C.FACILITY_NAME,B.SHORT_DESC,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID ='"+locale+"' AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE  " +sql;
String strsql="SELECT E.SHORT_DESC,C.FACILITY_NAME,B.SHORT_DESC,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D,OT_OPER_ROOM_LANG E WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID  = E.LANGUAGE_ID AND B.LANGUAGE_ID ='"+locale+"' AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE AND D.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND D.OPER_ROOM_CODE = E.OPER_ROOM_CODE  " +sql;


//String strsql1="SELECT D.OPER_ROOM_CODE,C.FACILITY_NAME,B.SHORT_DESC,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID ='"+locale+"' AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE " +sql;
String strsql1="SELECT E.SHORT_DESC,C.FACILITY_NAME,B.SHORT_DESC,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D,OT_OPER_ROOM_LANG_VW E WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID  = E.LANGUAGE_ID AND B.LANGUAGE_ID ='"+locale+"' AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE AND D.OPERATING_FACILITY_ID = E.OPERATING_FACILITY_ID AND D.OPER_ROOM_CODE = E.OPER_ROOM_CODE " +sql;
   stmt = conn.prepareStatement(strsql);
   rs = stmt.executeQuery();
   int total=0;
		while(rs.next())
	{
		total++;

	}
	 maxRecord=total;
		if(maxRecord == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err MessageOrderTypesForSpecialityQueryResult ::" +e);
	}


            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/StoresforOperatingRoomQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/StoresforOperatingRoomQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

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
	 for(int j=1; j<start; i++,j++ )
	 {
	  rset.next() ;

	}
	String classValue = "" ;
	
while ( rset.next() && i<=end )
{
        if ( i % 2 == 0 )
			classValue = "gridData" ; // changed by yadav
		else
			classValue = "gridData" ; // changed by yadav
		

	out.println("<tr><td class='" + classValue + "' style='border: 1px solid black;'>");

	 operating_room_code = rset.getString(1);
	 facility_name = rset.getString(2);
	 store_desc = rset.getString(3);
	 type_desc = rset.getString(4);
	 default_yn = rset.getString(5);

	out.println(operating_room_code+"</td><td class='gridData' style='border: 1px solid black;'>"); 
	out.println(facility_name+"</td><td class='" + classValue + "' style='border: 1px solid black;'>");
	out.println(store_desc+"</td><td class='" + classValue + "' style='border: 1px solid black;'>");
	out.println(type_desc+"</td><td class='" + classValue + "' style='border: 1px solid black;'>");
	//out.println(default_yn);

    if ( default_yn.equals("Y") || default_yn.equals("null"))
	    out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else 
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
   	out.println("</td>");

	
	i++;

}


		

            _bw.write(_wl_block13Bytes, _wl_block13);

	if(stmt!=null)
			stmt.close();
		if(stmt1!=null)
			stmt1.close();
		if(rset!=null)
			rset.close();
		if(rs!=null)
			rs.close();
		ConnectionManager.returnConnection(conn,request);

		}
catch(Exception e)
{
	e.printStackTrace();
	//System.err.println("Err Message from StoresForOperatingRoomQueryResult.jsp ::" +e);
}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OperatingRoom.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
