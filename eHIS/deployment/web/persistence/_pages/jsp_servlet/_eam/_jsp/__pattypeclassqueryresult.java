package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import java.lang.*;
import webbeans.eCommon.*;

public final class __pattypeclassqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/PatTypeClassQueryResult.jsp", 1709114026429L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<p>\n<table align=\'right\'>\n<tr >\n<td>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</td>\n</tr>\n</table>\n\t<br><br>\n</p>\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<td class=\'columnheader\'><fmt:message key=\"Common.patienttype.label\" bundle=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"/> <fmt:message key=\"Common.code.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/></td>\n<td class=\'columnheader\'><fmt:message key=\"Common.patienttype.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/> <fmt:message key=\"Common.description.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/></td>\n<td class=\'columnheader\'><fmt:message key=\"Common.patientclass.label\" bundle=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/></td>\n<td class=\'columnheader\'><fmt:message key=\"eAM.PatientClassDesc.label\" bundle=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/></td>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n</tr>\n</table>\n<br>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY   OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >");
request.setCharacterEncoding("UTF-8");	

	String whereClause = request.getParameter("whereclause");

	String sql ;
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;
	

	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql="";

		String pat_type    = request.getParameter("patient_type")==null ?"":request.getParameter("patient_type");
		String pattypedesc    = request.getParameter("pat_type_desc")==null ?"":request.getParameter("pat_type_desc");
		String pat_class    = request.getParameter("patient_class")==null ?"":request.getParameter("patient_class");
		String patclassdesc    = request.getParameter("pat_class_desc")==null ?"":request.getParameter("pat_class_desc");
		
		int andCheck 		= 0;
		pat_type		=pat_type.toUpperCase();
		pat_class 		=pat_class.toUpperCase();

		if ( !(pat_type == null || pat_type.equals("")) )
		{
			sql = " where upper(patient_type) like upper('"+pat_type+"%')";
			andCheck = 1;
		}

		if ( !(pat_class == null || pat_class.equals("")) )
		{
			sql = " where upper(patient_class)   like upper('"+pat_class+"%') ";
			andCheck = 1;
		}

		if ( !(pattypedesc == null || pattypedesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql = sql + " and ";
					sql = sql + " upper(patient_type_short_desc)  like  upper('"+pattypedesc+"%') " ;
				}
				else
				{
					sql = " where upper(patient_type_short_desc)  like upper('"+pattypedesc+"%') " ;
					andCheck = 1;
				}
		}

		if ( !(patclassdesc == null || patclassdesc.equals("")) )
			{
				if ( andCheck == 1 )
				{	sql = sql + " and ";
					sql = sql + " upper(patient_class_short_desc)  like  upper('"+patclassdesc+"%') " ;
				}
				else
				{
					sql = " where upper(patient_class_short_desc)  like upper('"+patclassdesc+"%') " ;
					andCheck = 1;
				}
		}

		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord.equals("")) )
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

	else{
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

Connection conn = null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
String strsql1="select count(*) as total from am_patient_type_class_vw "+sql;
rs = stmt.executeQuery(strsql1);

rs.next();
maxRecord = rs.getInt("total");
		if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
if(stmt!=null) 	stmt.close();
String strsql2="select * from am_patient_type_class_vw"+sql;
stmt = conn.createStatement();
rs = stmt.executeQuery(strsql2);

            _bw.write(_wl_block3Bytes, _wl_block3);

if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/PatTypeClassQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/PatTypeClassQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);

 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue="";
while ( rs.next() && i<=end )
{
	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");

	String pat_type 	= rs.getString("patient_type");
	String pat_class 	= rs.getString("patient_class");
	String pattypedesc 	= rs.getString("patient_type_short_desc");
	String patclassdesc 	= rs.getString("patient_class_short_desc");
	
	out.println("<a href='../../eAM/jsp/AddModifyPatTypeClass.jsp?mode=QUERY&patient_type="+pat_type+"&patient_class="+pat_class+"' target='f_query_add_mod' >");
	out.println(pat_type+"</td><td class='" + classValue + "'>");
	out.println(pattypedesc+"</td><td class='" + classValue + "'>");
	out.println("<a href='../../eAM/jsp/AddModifyPatTypeClass.jsp?mode=QUERY&patient_type="+pat_type+"&patient_class="+pat_class+"' target='f_query_add_mod' >");
	out.println(pat_class+"</td><td class='" + classValue + "'>");
	out.println(patclassdesc+"</td>");

	i++;

  }//endwhile
  if(rs!=null) 		rs.close();
  if(stmt!=null) 		stmt.close();
}
catch(Exception e){
		e.toString();
}
finally   {
	if(rs!=null) 		rs.close();
	if(stmt!=null) 		stmt.close();
	ConnectionManager.returnConnection(conn,request);

}

            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
