package jsp_servlet._eqa._jsp;

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

public final class __qacomplicationsforindicatorqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAComplicationsForIndicatorQueryResult.jsp", 1742817542835L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link> -->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<p>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</td>\n</tr>\n</table>\n</p>\n<br><br>\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<th>Indicator Code</th>\n<th>Indicator Description</th>\n<th>Complication Code</th>\n<th>Description</th>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n</td></tr>\n</table>\n<br><center>\n\n\n</center>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	Statement stmt = null;
	ResultSet rs   = null;
	Connection conn= null;
	StringBuffer sb=null;
try
   {
	String whereClause = request.getParameter("whereclause");
    sb=new StringBuffer("");
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	
		String indicator_code    = request.getParameter("indicator_code")==null ?"":request.getParameter("indicator_code");	
		String indicator_desc	 = request.getParameter("indicator_desc")==null?"":request.getParameter("indicator_desc"); 
		String complication_code = request.getParameter("complication_code")==null ?"":request.getParameter("complication_code");	
		String complication_desc = request.getParameter("complication_desc") == null ?"":request.getParameter("complication_desc");
		int andCheck = 0;

		if ( !(indicator_code == null || indicator_code.equals("")) )
		{
		   sb.append("where upper(QIND_CLIND_ID) like upper('"+indicator_code+"%')");
		  
		   andCheck = 1;
		}
		if ( !(indicator_desc == null || indicator_desc.equals("")) )
	   	{
				   if ( andCheck == 1 )
				   {
				   	 sb.append(" and upper(QIND_CLIND_DESC)  like upper('"+indicator_desc+"%') ");
					
				   }
				   else
				   {
					if((sb != null) && (sb.length() > 0))
			       {
				   sb.delete(0,sb.length());
			       }
					sb.append("where upper(QIND_CLIND_DESC)  like upper('"+indicator_desc+"%')" );
					
					andCheck = 1;
				   }
		}
		if ( !(complication_code == null || complication_code.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sb.append(" and upper(COMPL_CODE)  like upper('"+complication_code+"%') ");
					

				   }
				   else
				   {
					if((sb != null) && (sb.length() > 0))
			       {
				   sb.delete(0,sb.length());
			       }
				   sb.append("where upper(COMPL_CODE)  like upper('"+complication_code+"%')" );
					
					andCheck = 1;
				   }
		}
		if ( !(complication_desc == null || complication_desc.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sb.append(" and upper(COMPL_DESCRIPTION)  like upper('"+complication_desc+"%') ");
					
				   }
				   else
				   {
					if((sb != null) && (sb.length() > 0))
			       {
				   sb.delete(0,sb.length());
			       }
					sb.append("where upper(COMPL_DESCRIPTION)  like upper('"+complication_desc+"%')" );
					
					andCheck = 1;
				   }
		}
		
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sb.append(" order by ");
		

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
		sb.append(ord[i]);	
		
		else
		sb.append(ord[i]+",");	
		
		}
	}
} //end of where clause IF
else
{
if((sb != null) && (sb.length() > 0))
			       {
				   sb.delete(0,sb.length());
			       }
				   sb.append(whereClause);

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



int maxRecord = 0;

conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
String strsql1="select count(*) as total from QA_QIND_CLIND_COMPL_VW "+sb.toString();
rs = stmt.executeQuery(strsql1);
if (rs.next())
	{
	maxRecord = rs.getInt("total");
	}
	if(rs!=null) rs.close();
	

	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");


String strsql2="select * from QA_QIND_CLIND_COMPL_VW "+sb.toString();
rs = stmt.executeQuery(strsql2);


            _bw.write(_wl_block4Bytes, _wl_block4);

if ( !(start <= 1) )
	out.println("<A HREF='../../eQA/jsp/QAComplicationsForIndicatorQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sb.toString())+"'"+" text-decoration='none'>Previous</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eQA/jsp/QAComplicationsForIndicatorQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sb.toString())+"'"+" text-decoration='none'>Next</A>");


            _bw.write(_wl_block5Bytes, _wl_block5);

 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue = "" ;
	  
while ( rs.next() && i<=end )
{
       if ( i % 2 == 0 )
       	  	classValue = "QRYEVEN" ;
       	  else
       	  	classValue = "QRYODD" ;
       	  
	out.println("<tr><td class='" + classValue + "'>");
	String indicator_code = rs.getString("QIND_CLIND_ID");
	String indicator_desc = rs.getString("QIND_CLIND_DESC");
	out.println("<a href='../../eQA/jsp/addModifyQAComplicationsForIndicator.jsp?indicator_code="+ indicator_code+"' target='f_query_add_mod' >");
	out.println(indicator_code+"</a></td><td class='" + classValue + "'>");
	out.println(indicator_desc);
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("COMPL_CODE"));
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("COMPL_DESCRIPTION"));

	
	i++;

  }//endwhile
    if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{
		out.print("Exception in File QAComplicationsForIndicatorQueryResult"+e.toString());
    }
	finally   
	{
	  ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
