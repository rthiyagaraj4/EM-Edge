package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __generalsearchresult1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/GeneralSearchResult1.jsp", 1709114658601L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n<head>\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\' />\n\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\tfunction closew(Dcode)\n\t  {\n\t\twhile(Dcode.indexOf(\"+\")!=-1)\n\t\tDcode=Dcode.replace(\'+\',\" \");\n\t\n\t\t\n\t\twindow.parent.parent.returnValue=escape(Dcode);\n\t\twindow.parent.parent.close();\n\t  }\n </script>\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</td>\n</tr>\n</table>\n<BR><BR>\n</P>\n\n\n\n\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'tb1\'>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<th width=\'60%\'>Description</th>\n\t<th width=\'40%\'>Code</th>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<th width=\'20%\'>Code</th>\n\t<th width=\'80%\'>Description</th>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<a href=javascript:closew(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\")>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</table>\n<input type=\'hidden\' name=\'searchtext\' id=\'searchtext\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" > \n</BODY>\n</html>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	String search_desc =request.getParameter("search_desc");
	String search_code =request.getParameter("search_code");
	String code="";
	String desc="";

            _bw.write(_wl_block4Bytes, _wl_block4);

Connection conn=null;
PreparedStatement stmt=null;
ResultSet rs=null;
ResultSet rs1=null;
String searchtext="";
int i=1;
String dispDescFirst =request.getParameter("dispDescFirst");
if(dispDescFirst == null) dispDescFirst="";

try{
	conn=ConnectionManager.getConnection(request);

String whereClause = request.getParameter("whereclause");
String sql="";
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
String searchcriteria=request.getParameter("search_criteria");
searchtext = request.getParameter("searchtext");
if(searchtext == null) searchtext="";

//out.println("searchcriteria "+ searchtext);

if ( (whereClause == null || whereClause.equals("")) )
{
 sql = request.getParameter("SQL");
sql = sql.replace('`','\'') ;
int j = sql.indexOf("where");
if(j == -1)
	 sql= sql +" where";
if(j > 0)
	 sql= sql + " and";


String l_where_clause="";
//String scheme=request.getParameter("s_scheme");
String searchby=request.getParameter("search_by"); 
 searchtext=request.getParameter("search_text");
String scode = searchtext.toUpperCase();


if(searchby.equals("D"))
{
	l_where_clause=" upper("+search_desc+") like ";
}
else
{
	l_where_clause=" upper("+search_code+") like ";
	searchtext = scode;
}

if(searchcriteria.equals("S"))
	{
		searchtext=searchtext+"%";
		l_where_clause=l_where_clause+"upper(?)";
	}
else if(searchcriteria.equals("E"))
{
		searchtext="%"+searchtext;
		l_where_clause=l_where_clause+"upper(?)";
}
else if(searchcriteria.equals("C"))
{
		searchtext="%"+searchtext+"%";
		l_where_clause=l_where_clause+"upper(?)";
}

if (searchby.equals("C"))
//sql+=" "+l_where_clause+ " order by "+search_code ;
sql=sql+" "+l_where_clause+ " order by "+search_code ;
else
//sql+=" "+l_where_clause+ " order by "+search_desc ;
sql=sql+" "+l_where_clause+ " order by "+search_desc ;

} 
else
	{
	sql = whereClause;
	searchtext =searchtext;
	}


//int maxRecord = 0;		
int start = 0 ;
int end = 0 ;
int k=0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;



try{
//System.out.println("SQL is:"+sql);
stmt = conn.prepareStatement(sql);
stmt.setString(1,searchtext);

rs1=stmt.executeQuery();
while(rs1.next())
{
	k++;

}

if(k == 0)
out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));document.location.href='../../eCommon/html/blank.html'</script>");


rs = stmt.executeQuery(sql);


            _bw.write(_wl_block5Bytes, _wl_block5);

if ( !(start <= 1) )
	out.println("<A HREF='../../eCommon/jsp/GeneralSearchResult.jsp?dispDescFirst="+dispDescFirst+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"&searchtext="+URLEncoder.encode(searchtext)+"' text-decoration='none'>Previous</A>");

if ( !( (start+14) > k ) )
	out.println("<A HREF='../../eCommon/jsp/GeneralSearchResult.jsp?dispDescFirst="+dispDescFirst+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"&searchtext="+URLEncoder.encode(searchtext)+"' text-decoration='none'>Next</A>");

            _bw.write(_wl_block6Bytes, _wl_block6);
if(dispDescFirst.equals("dispDescFirst")) {
            _bw.write(_wl_block7Bytes, _wl_block7);
} else {
            _bw.write(_wl_block8Bytes, _wl_block8);
} 
            _bw.write(_wl_block9Bytes, _wl_block9);

if(rs != null)
{
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rs.next() ;

	while(rs.next() && i<=end)
	{

            _bw.write(_wl_block10Bytes, _wl_block10);

	String rowclass = "" ;
	String me="";
//	String d="/";
		if ( i % 2 == 0 )
			rowclass = "QRYEVEN" ;
		else
			rowclass = "QRYODD" ;
	   code=rs.getString(1);
	   desc=rs.getString(2);
	    out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");
	
		
	
		//out.print(me);
		if(dispDescFirst.equals("dispDescFirst")) {
		me=desc+"::"+code;
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(me)));
            _bw.write(_wl_block12Bytes, _wl_block12);
	out.println(desc+"</a></td><td  class='"+rowclass+"'>");
		out.println( code+"</td></tr>" );
		}
		else
		{
		me=code;
		out.println("<a    href=\"javascript:closew('"+me+"')\">");
		out.println(code+"</a></td><td  class='"+rowclass+"'>");
		out.println( desc+"</td></tr>" );
		}
		i++;	  
	 }
  } 
}catch(Exception e) { out.println(e.toString());
}
	finally
	{
		if (stmt != null) stmt.close();
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(searchtext));
            _bw.write(_wl_block14Bytes, _wl_block14);

}catch(Exception e) { out.println(e.toString());
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
}
