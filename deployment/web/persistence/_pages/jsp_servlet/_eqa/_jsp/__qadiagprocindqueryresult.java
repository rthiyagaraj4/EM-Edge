package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __qadiagprocindqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QADiagProcIndQueryResult.jsp", 1742817543182L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="   \n    \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<p>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</td>\n</tr>\n</table>\n</p>\n<br>\n<br>\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<th>Indicator ID</th>\n<th>Diag/Procedure</th>\n<th>Scheme Type</th>\n<th>Diag/Procedure Code</th>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n</td></tr>\n</table>\n<br><center>\n</center>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );
 
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);

out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()'  class='CONTENT' onKeyDown = 'lockKey()' >");

	String whereClause = request.getParameter("whereclause");

	//String sql ;
	StringBuffer sql		= new StringBuffer();
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
	//sql="";
	if (sql.length() > 0) sql.delete(0,sql.length());
	String qind_clind_id 	= request.getParameter("qind_clind_id");
	if(qind_clind_id==null) qind_clind_id="";
	
	String qind_clind_desc 	= request.getParameter("qind_clind_desc");
	if(qind_clind_desc==null) qind_clind_desc	="";
		
	String scheme_type 	= request.getParameter("scheme_type");	
	if(scheme_type==null||scheme_type.equals("A")) scheme_type="";
   String diag_proc_ind 	= request.getParameter("diag_proc_ind");	
	if(diag_proc_ind==null||diag_proc_ind.equals("A")) diag_proc_ind="";

String 	diag_proc_code 	= request.getParameter("diag_proc_code");	
	if(	diag_proc_code==null) 	diag_proc_code="";

	
	int andCheck = 0;

	qind_clind_id=qind_clind_id.toUpperCase();
	
	if ( !(qind_clind_id == null || qind_clind_id.equals("")) )
	{
		if (sql.length() > 0) sql.delete(0,sql.length());
		sql.append("where qind_clind_id like '"+qind_clind_id+"%'");
		andCheck = 1;
	}
	
	
	if ( !(qind_clind_desc == null || qind_clind_desc.equals("")) )
	{
		if (sql.length() > 0) sql.delete(0,sql.length());
		sql.append("where qind_clind_desc like '"+qind_clind_desc+"%'");
		andCheck = 1;
	}
	
	if ( !(scheme_type == null || scheme_type.equals("")) )
		{
			if ( andCheck == 1 )
			 {	
				sql.append(" and ");
				sql.append("upper(scheme_type) like  upper('"+scheme_type+"%')" );
			 }
			else
			 {
				if (sql.length() > 0) sql.delete(0,sql.length());
				sql.append("where upper(scheme_type) like upper('"+scheme_type+"%')" );
				andCheck = 1;
			 }
		}
		

	if ( !(diag_proc_ind == null || diag_proc_ind.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append("upper(diag_proc_ind) like  upper('"+diag_proc_ind+"%')" );
		}
		else
		{
			if (sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where upper(diag_proc_ind) like upper('"+diag_proc_ind+"%')" );
			andCheck = 1;
		}
	}
	if ( !(diag_proc_code == null || diag_proc_code.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and ");
			sql.append("upper(diag_proc_code) like  upper('"+diag_proc_code+"%')" );
		}
		else
		{
			if (sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where upper(diag_proc_code) like upper('"+diag_proc_code+"%')" );
			andCheck = 1;
		}
	}
		//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql.append(ord[i]);
		else
			{
			sql.append(ord[i]);
			sql.append(",");
			}
		}
	}
} //end of where clause IF
	else 
	{
		sql.append(whereClause);
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

Connection conn = null;
Statement stmt=null;
//ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;

try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();

StringBuffer strsql1		= new StringBuffer();
strsql1.append("select count(*) as total from qa_qind_clind_diag_proc_vw ");
	
strsql1.append(sql.toString());

rs = stmt.executeQuery(strsql1.toString());
rs.next();
maxRecord = rs.getInt("total");

if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");

if(stmt!=null) 	stmt.close();
StringBuffer strsql2		= new StringBuffer();
strsql2.append("select  * from qa_qind_clind_diag_proc_vw ");
strsql2.append(sql.toString());
//out.println(strsql2);
System.err.println("Line 171-->"+strsql2);
stmt = conn.createStatement();
rs = stmt.executeQuery(strsql2.toString()); 


            _bw.write(_wl_block4Bytes, _wl_block4);

if ( !(start <= 1) )
	out.println("<A HREF='../../eQA/jsp/QADiagProcIndQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>Previous</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eQA/jsp/QADiagProcIndQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>Next</A>");


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
	  

//MODIFIED BY YADAV
	out.println("<tr><td class='" + classValue + "' >");
	String qind_clind_id 	= rs.getString("qind_clind_id");
	String diag_proc_ind_code	= checkForNull(rs.getString("diag_proc_ind"));
	String diag_proc_ind_desc	= checkForNull(rs.getString("diag_proc_ind_desc"));
	String scheme_type_code	= checkForNull(rs.getString("scheme_type"));
	String scheme_type_desc	= checkForNull(rs.getString("scheme_type_desc"));
	String diag_proc_code	= checkForNull(rs.getString("diag_proc_code"));
//******************
		
	out.println("<a href='../../eQA/jsp/addModifyDiagProcForIndicator.jsp?qind_clind_id="+qind_clind_id+"&diag_proc_ind_code="+java.net.URLEncoder.encode(diag_proc_ind_code)+"&scheme_type_code="+java.net.URLEncoder.encode(scheme_type_code)+"&mode=U"+"&diag_proc_code="+java.net.URLEncoder.encode(diag_proc_code)+"' target='f_query_add_mod' >");
	out.println(qind_clind_id +"</a></td><td class='" + classValue + "' >");
	out.println(diag_proc_ind_desc+"</td><td class='" + classValue + "' >");
	out.println(scheme_type_desc+"</td><td class='" + classValue + "' >");
	out.println(diag_proc_code+"</td><td class='" + classValue + "' >");
		
	i++;

  }//endwhile
  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
}catch(Exception e){
		e.toString();
}
	finally   {
	if(rs!=null) 	rs.close();
	if(stmt!=null) 	stmt.close();
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
