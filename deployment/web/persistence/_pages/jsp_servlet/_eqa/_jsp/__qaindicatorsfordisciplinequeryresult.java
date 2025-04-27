package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.net.*;
import java.text.*;

public final class __qaindicatorsfordisciplinequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndicatorsForDisciplineQueryResult.jsp", 1742817545099L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<p>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</td>\n</tr>\n</table>\n</p>\n<br>\n<br>\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<th>Discipline Code</th>\n<th>Discipline Description</th>\n<th>Indicator ID</th>\n<th>Serial No</th>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</td></tr>\n</table>\n<br><center>\n</center>\n</BODY>\n</HTML>\n\n";
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

	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()'  class='CONTENT' onKeyDown = 'lockKey()' >");
    Connection conn  = null;
    Statement  stmt  = null;
    ResultSet  rs    = null;
	StringBuffer sb=null;
	try{
	String whereClause = request.getParameter("whereclause");
    sb=new StringBuffer("");
	
	
	String from = request.getParameter( "from" ) ;
	String to   = request.getParameter( "to" ) ;

    	if ( (whereClause == null || whereClause.equals("")) )
	{
	
	String qind_discipline_id 	= request.getParameter("qind_discipline_id");	
	if(qind_discipline_id==null) qind_discipline_id="";
	String qind_discipline_desc 	= request.getParameter("qind_discipline_desc");	
	if(qind_discipline_desc==null) qind_discipline_desc="";


	String qind_clind_id 	= request.getParameter("qind_clind_id");
	if(qind_clind_id==null) qind_clind_id="";
	
	String qind_clind_desc 	= request.getParameter("qind_clind_desc");
	if(qind_clind_desc==null) qind_clind_desc	="";
		
	String qind_slno 	= request.getParameter("qind_slno");	
	if(qind_slno==null||qind_slno.equals("S")) qind_slno="";

	
	int andCheck = 0;

	qind_discipline_id=qind_discipline_id.toUpperCase();
	
	if ( !(qind_discipline_id == null || qind_discipline_id.equals("")) )
	{
		sb.append("where qind_discipline_id like '"+qind_discipline_id+"%'");
		
		
		andCheck = 1;
	}
	if ( !(qind_discipline_desc == null || qind_discipline_desc.equals("")) )
	{
		if((sb != null) && (sb.length() > 0))
			{
				sb.delete(0,sb.length());
			}
		 sb.append(" where qind_discipline_desc like '"+qind_discipline_desc+"%'");
		
		
		andCheck = 1;
	}
	
	if ( !(qind_clind_desc == null || qind_clind_desc.equals("")) )
	{
		sb.append(" where qind_clind_desc like '"+qind_clind_desc+"%'");
		
		
		andCheck = 1;
	}
	if ( !(qind_clind_id == null || qind_clind_id.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sb.append(" and ");
            sb.append(" qind_clind_id like  upper('"+qind_clind_id+"%') ");
		}
		else
		{
			if((sb != null) && (sb.length() > 0))
			{
				sb.delete(0,sb.length());
			}
			sb.append("where qind_clind_id like upper('"+qind_clind_id+"%') ");
			
			
			andCheck = 1;
		}
	}
	
	if ( !(qind_slno == null || qind_slno.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sb.append(" and upper(qind_slno) like  upper('"+qind_slno+"%')");
		}
		else
		{
			if((sb != null) && (sb.length() > 0))
			{
				sb.delete(0,sb.length());
			}
			sb.append("where upper(QIND_SLNO) like upper('"+qind_slno+"%')");
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
	else {
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
String strsql1="select count(*) as total from qa_qind_discipline_clind_vw "+sb.toString();

rs = stmt.executeQuery(strsql1);
rs.next();
maxRecord = rs.getInt("total");

if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");

if(stmt!=null) 	stmt.close();
if(rs!=null) rs.close();
String strsql2="select * from qa_qind_discipline_clind_vw "+sb.toString();
stmt = conn.createStatement();
rs = stmt.executeQuery(strsql2);

            _bw.write(_wl_block3Bytes, _wl_block3);

if ( !(start <= 1) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorsForDisciplineQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sb.toString())+"'"+" text-decoration='none'>Previous</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorsForDisciplineQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sb.toString())+"'"+" text-decoration='none'>Next</A>");

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

	out.println("<tr><td class='" + classValue + "' >");
	String qind_discipline_id 	= rs.getString("qind_discipline_id");
	String qind_clind_id	= rs.getString("qind_clind_id");
	String qind_discipline_desc	= rs.getString("qind_discipline_desc");
	String qind_slno 	= rs.getString("qind_slno");	
		
	out.println("<a href='../../eQA/jsp/QAModifyIndicatorsForDiscipline.jsp?qind_discipline_id="+qind_discipline_id+"&qind_clind_id="+qind_clind_id+"' target='f_query_add_mod' >");
	out.println(qind_discipline_id +"</a></td><td class='" + classValue + "' >");
	out.println(qind_discipline_desc+"</td><td class='" + classValue + "' >");
	out.println(qind_clind_id+"</td><td class='" + classValue + "' >");
	out.println(qind_slno+"</td><td class='" + classValue + "' >");
	i++;
  }//endwhile
  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
  if((sb != null) && (sb.length() > 0))
	{
		sb.delete(0,sb.length());
	}
}catch(Exception e)
{
		out.println("Exception in File QAIndicatorsForDisciplineQueryResult"+e.toString());
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
