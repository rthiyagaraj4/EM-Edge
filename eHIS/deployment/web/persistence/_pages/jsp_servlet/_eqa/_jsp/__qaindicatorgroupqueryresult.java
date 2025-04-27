package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.URLEncoder;
import webbeans.eCommon.*;

public final class __qaindicatorgroupqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndicatorGroupQueryResult.jsp", 1742817544373L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></Script>\n<Script src=\"../../eQA/js/QAMessages.js\" language=\"JavaScript\"></Script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<p>\n<table align=\'right\'>\n<tr><td>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</td>\n</tr>\n</table>\n</p>\n<br><br>\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<th>Group Code</th>\n<th>Group Description</th>\n<th>Enabled</th>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</td></tr>\n</table>\n<br>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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

out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");
String whereClause    = request.getParameter("whereclause");
StringBuffer strbuff  = new StringBuffer();
String from           = request.getParameter( "from" ) ;
String to             = request.getParameter( "to" ) ;
if ( (whereClause == null || whereClause.equals("")) )
{
	String qind_group_id    = request.getParameter("qind_group_id")==null ?"":request.getParameter("qind_group_id");	
	String qind_group_desc  = request.getParameter("qind_group_desc")==null ?"":request.getParameter("qind_group_desc");	
	String eff_status       = request.getParameter("eff_status") == null ?"":request.getParameter("eff_status");
	int andCheck            = 0;
	qind_group_id=qind_group_id.toUpperCase();
	if ( !(qind_group_id == null || qind_group_id.equals("")) )
	{
		strbuff.append("where upper(qind_group_id) like upper('"+qind_group_id+"%')");
	    andCheck = 1;
	}
	if ( !(eff_status == null || eff_status.equals("")) )
	{
	   if ( eff_status.equals("E") )
	   {
		 if ( andCheck == 0 )
		 {	
			strbuff.append("where eff_status='E'");
			andCheck=1;
		 }
		 else
		 {	
			strbuff.append("and eff_status='E'");
		 }
	  }
	  if ( eff_status.equals("D") )
	  {
		if ( andCheck == 0 )
		{	
			strbuff.append(" where  eff_status='D'");
			andCheck=1;
		}
		else
		{
			strbuff.append(" and eff_status='D'");
		}
	  }
	}
	if ( !(qind_group_desc == null || qind_group_desc.equals("")) )
	{
	  if ( andCheck == 1 )
	  {
	   	strbuff.append(" and upper(qind_group_desc)  like upper('"+qind_group_desc+"%') ");
      }
	  else
	  {
		strbuff.append("where upper(qind_group_desc)  like upper('"+qind_group_desc+"%') ") ;
		andCheck = 1;
	  }
	}
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	if ( !(ord == null || ord .equals("")) )
	{
		strbuff.append(" order by ");
		for ( int i=0;i < ord.length;i++ )
	 	{
	 		if ( i == ord.length - 1 )
				strbuff.append(ord[i]);
			else
				strbuff.append(ord[i]+",");
		}
	}
} //end of where clause IF
else
{
	strbuff.append(whereClause);
}
int start = 0 ;
int end   = 0 ;
int i     = 1;
if ( from == null )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;
if ( to == null )
  	end = 14 ;
else
	end = Integer.parseInt( to ) ;

Statement stmt = null;
ResultSet rs   = null;
Connection conn = ConnectionManager.getConnection(request);
int maxRecord = 0;
try
{
	stmt = conn.createStatement();
	String strsql1="select count(*) as total from qa_qind_group "+strbuff.toString();
	rs = stmt.executeQuery(strsql1);
	if (rs.next())
	{
		maxRecord = rs.getInt("total");
	}if(rs!=null)	rs.close();
	 
	if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));history.go(-1);</script>");
	String strsql2="select * from qa_qind_group "+strbuff.toString();
	rs = stmt.executeQuery(strsql2);

            _bw.write(_wl_block3Bytes, _wl_block3);

if ( !(start <= 1) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(strbuff.toString())+"'"+" text-decoration='none'>Previous</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorGroupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(strbuff.toString())+"'"+" text-decoration='none'>Next</A>");


            _bw.write(_wl_block4Bytes, _wl_block4);

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
   String qind_group_id = rs.getString("qind_group_id");
   out.println("<a href='../../eQA/jsp/addModifyQAIndicatorGroup.jsp?qind_group_id="+ qind_group_id +"'target='f_query_add_mod' >");
   out.println(qind_group_id+"</a></td><td class='" + classValue + "'>");
   out.println( rs.getString("qind_group_desc") );
   out.println("</td><td class='" + classValue + "' align=center >");
   if ( rs.getString("eff_status").equals("E") )
   {
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
   }
   else
   {
	   out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");;
   }
   out.println("</td>");
   i++;
 }//endwhile
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
}catch(Exception e){
 out.print(e.toString());
}
finally   
{
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
