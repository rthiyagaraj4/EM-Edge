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
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __statusdescriptionsqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/StatusDescriptionsQueryResult.jsp", 1721309280000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eOT/js/StatusDescriptions.js\'></script>\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'QueryResult\' id=\'QueryResult\'>\n<P>\n<table align=\'right\'>\n<tr><td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td></tr>\n</table>\n<br><br>\n</p>\n\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n<th class=\"columnHeader\" nowrap>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</th>\n<th class=\"columnHeader\" nowrap>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</th>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</td></tr>\n</table>\n</center>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String whereClause = checkForNull(request.getParameter("whereclause"));
	String from = checkForNull(request.getParameter( "from" ) );
    String to = checkForNull(request.getParameter( "to" ) );
	int start = ( "".equals(from) )?1:Integer.parseInt(from);
    int end =  ( "".equals(to) )?14:Integer.parseInt(to);
    String status_code = checkForNull(request.getParameter( "status_code" ));
	String status_desc_sysdef = checkForNull(request.getParameter( "status_desc_sysdef" ));
	String status_desc = checkForNull(request.getParameter( "status_desc" ));
	String color_ind = checkForNull(request.getParameter( "color_ind"));
	String text_color= checkForNull(request.getParameter( "text_color"));
	String sql = " ";
	StringBuffer sbr = new StringBuffer();

	//Labels Picking up from MessageBundle
    String black	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Black.Label","ot_labels");
	String white	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.White.Label","ot_labels");
	String blue	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Blue.Label","ot_labels");
	String lightblue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LightBlue.Label","ot_labels");
	String darkblue	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkBlue.Label","ot_labels");
	String green	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Green.label","common_labels");
	String lightgreen =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LightGreen.Label","ot_labels");
	String darkgreen =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkGreen.Label","ot_labels");
	String yellow	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Yellow.label","common_labels");
	String red		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Red.label","common_labels");
	String darkred	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkRed.Label","ot_labels");
	String magenta	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Magenta.Label","ot_labels");
	String brown	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Brown.Label","ot_labels");
	String violet	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Violet.Label","ot_labels");
	String indigo	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Indigo.Label","ot_labels");
	String orange	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Orange.Label","ot_labels");
	String pink		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Pink.Label","ot_labels");
	String grey		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Gray.Label","ot_labels");
	String cyan		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Cyan.Label","ot_labels");
	String darkcyan	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.DarkCyan.Label","ot_labels");
	String purple	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Purple.Label","ot_labels");
	StringBuffer bgcolor = new StringBuffer();
	bgcolor.append("decode(color_ind,'BLUE','").append(blue).append("',");
	bgcolor.append("'LIGHTBLUE','").append(lightblue).append("',");
	bgcolor.append("'DARKBLUE','").append(darkblue).append("',");
	bgcolor.append("'GREEN','").append(green).append("',");
	bgcolor.append("'LIGHTGREEN','").append(lightgreen).append("',");
	bgcolor.append("'DARKGREEN','").append(darkgreen).append("',");
	bgcolor.append("'YELLOW','").append(yellow).append("',");
	bgcolor.append("'RED','").append(red).append("',");
	bgcolor.append("'DARKRED','").append(darkred).append("',");
	bgcolor.append("'MAGENTA','").append(magenta).append("',");
	bgcolor.append("'BROWN','").append(brown).append("',");
	bgcolor.append("'VIOLET','").append(violet).append("',");
	bgcolor.append("'INDIGO','").append(indigo).append("',");
	bgcolor.append("'ORANGE','").append(orange).append("',");
	bgcolor.append("'PINK','").append(pink).append("',");
	bgcolor.append("'GREY','").append(grey).append("',");
	bgcolor.append("'CYAN','").append(cyan).append("',");
	bgcolor.append("'DARKCYAN','").append(darkcyan).append("',");
	bgcolor.append("'PURPLE','").append(purple).append("') color_ind, DECODE(text_color,");
	bgcolor.append("'WHITE','").append(white).append("',");
	bgcolor.append("'BLACK','").append(black).append("') text_color");
	String textcolor = bgcolor.toString();
	int cnt = 0  ;
   if ( (whereClause == null || whereClause.equals("")) )
    {
	// cnt=0;

		if ( !(status_code == null || status_code.equals("")) ){
	        sql = sql + " where upper(status_code ) like upper('"+status_code +"%')";
			cnt++;
        }

        if ( !(status_desc_sysdef == null || status_desc_sysdef.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(status_desc_sysdef) like upper('"+status_desc_sysdef+"%')";
			else{
				sql=sql+" where upper(status_desc_sysdef) like upper('"+status_desc_sysdef+"%')";
				cnt=1;
			}

        }
	   if ( !(status_desc == null || status_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(status_desc) like upper('"+status_desc+"%')";
			else{
				sql=sql+" where upper(status_desc) like upper('"+status_desc+"%')";
				cnt=1;
			}

        }
	
	if ( !(color_ind == null || color_ind.equals("all")) ){
			if(cnt>0)
				sql = sql + " and color_ind like '"+color_ind+"%'";
			else{
				sql=sql+" where color_ind like '"+color_ind +"%'";

				cnt =1;
			}
        } 
	if ( !(text_color == null || text_color.equals("all")) ){
			if(cnt>0)
				sql = sql + " and text_color like '"+text_color+"%'";
			else{
				sql=sql+" where text_color like '"+text_color +"%'";

				cnt =1;
			}
        } 
   
    }

	if(cnt>0)
		sql = sql+" and LANGUAGE_ID = '"+locale+"' ";
	else
		sql = sql+" where LANGUAGE_ID = '"+locale+"' ";
	cnt=1;


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

    //end of where clause IF
    else
            sql = whereClause;

	
	Connection conn  =  null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;
	int maxRecord = 0;
	int i=1;
	// String strsql="select count(*) as total from OT_Status "+sql;
	// String strsql1="select status_code,status_desc_sysdef, status_desc,decode(color_ind,'BLUE','Blue','LIGHTBLUE','Light Blue','DARKBLUE','Dark Blue','GREEN','Green','LIGHTGREEN','Light Green','DARKGREEN','Dark Green','YELLOW','Yellow','RED','Red','DARKRED','Dark  Red','MAGENTA','Magenta','BROWN','Brown','VIOLET','Violet','INDIGO','Indigo','ORANGE','Orange','PINK','Pink','GREY','Grey','CYAN','Cyan','DARKCYAN','Dark Cyan','PURPLE','Purple') color_ind ,DECODE(text_color, 'WHITE','White','BLACK','Black') text_color from  OT_STATUS "+sql;
	//out.println("Where Clause : "+whereClause);
	//String strsql="select count(*) as total from OT_STATUS "+whereClause;
	String strsql1="select status_code,status_desc_sysdef, status_desc,"+textcolor+" from  OT_STATUS_LANG_VW "+sql;
	try{
		conn  =  ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rset = pstmt.executeQuery();
		//getting maximum record
		rset.last();	maxRecord = rset.getRow();
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		//again move the resultset pointer to initial position
		rset.beforeFirst();

            _bw.write(_wl_block8Bytes, _wl_block8);

	if ( !(start <= 1) )
		out.println("<A HREF='../../eOT/jsp/StatusDescriptionsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF='../../eOT/jsp/StatusDescriptionsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	if ( start != 1 ) rset.absolute(start-1);
	i=start;
	String classValue= " ";
    while ( rset.next() && i<=end  ){
		classValue = ( i % 2 == 0 )?"gridData":"gridData";
		status_code = checkForNull(rset.getString(1));
		status_desc_sysdef=checkForNull(rset.getString(2));
		status_desc= checkForNull(rset.getString(3));
		color_ind =  checkForNull(rset.getString(4));
		text_color = checkForNull(rset.getString(5));
		sbr.append("<tr><td  class='" + classValue + "' nowrap>");
		sbr.append("<a href='../../eOT/jsp/StatusDescriptionsModify.jsp?mode=modify&status_code="+status_code+"' target='f_query_add_mod' >");
		sbr.append(checkForNull(rset.getString(1))+"</a></td>");
		sbr.append("<td class='" + classValue+"' nowrap>"+checkForNull(rset.getString(2))+"</td>");
		sbr.append("<td class='" + classValue+"' nowrap>"+status_desc+"</td>");
		sbr.append("<td class='" + classValue+"' nowrap>"+color_ind+"</td>");
		sbr.append("<td class='" + classValue+"' nowrap>"+text_color+"</td>");
		i++;
	} 
	out.println(sbr.toString());
	if(pstmt!=null)	pstmt.close();
	if(rset!=null) rset.close();
	ConnectionManager.returnConnection(conn,request);
}catch(Exception e){
	e.printStackTrace();
	//System.err.println("Err StatusDescriptionsQueryResult" +e);
}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(locale));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SystemDefinedDescription.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Color.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TextColor.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
