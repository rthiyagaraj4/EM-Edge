package jsp_servlet._ecp._jsp;

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
import eCommon.XSSRequestWrapper;

public final class __positionformdcpqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/PositionForMDCPQueryResult.jsp", 1709116608058L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teCP\n*\tPurpose \t\t:\n*\tCreated By\t\t:\tSuchilagna Panigrahi\n*\tCreated On\t\t:\t27 Dec 2004\n-->\n\n<!-- PositionForMDCPQueryResult.jsp-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link><Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></Script>\n<script language=\"javascript\" src=\"../js/CpMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n\n</html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<form name=\'PositionForMDCPQueryResult\' id=\'PositionForMDCPQueryResult\'>\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</td>\n</tr>\n</table>\n</P>\n<br><br>\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\n\t<tr>\n\t\t<th rowspan=\"2\"><fmt:message key=\"Common.FacilityID.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/></th>\n\t\t<th rowspan=\"2\"><fmt:message key=\"Common.FacilityName.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></th>\n\t\t<th rowspan=\"2\">Position Code</th>\n\t\t<th rowspan=\"2\">Position Description</th>\n\t\t<th rowspan=\"2\"><fmt:message key=\"Common.practitionertype.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/></th>\n\t</tr>\n\t<tr>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<tr>\n\t\t\t<td align=\"left\" class=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td align=\"left\" class=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\n\t\t</tr>\n\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t  </table>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);


	String whereClause = request.getParameter("whereclause")==null?"":request.getParameter("whereclause");
	String sql="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String qryWhere = "";

	String facility_id = "";
	String facility_name = "";
	String position_code = "";
	String position_desc = "";
	String pract_type_desc = "";

	String classValue = "" ;
	String sqlCount ="";
	String strsql ="";

	String qry_facility_id = request.getParameter("facility_id")==null ? "":request.getParameter("facility_id");
	String qry_facility_name = request.getParameter("facility_name")==null ? "":request.getParameter("facility_name");
	String qry_position_code = request.getParameter("position_code")==null ? "":request.getParameter("position_code");
	String qry_position_desc = request.getParameter("position_desc")==null ? "":request.getParameter("position_desc");
	String qry_pract_type = request.getParameter("pract_type")==null ? "":request.getParameter("pract_type");

	Connection conn = null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	if (whereClause == null || whereClause.equals(""))
		{
			qryWhere = "and upper(a.facility_id) like upper('"+qry_facility_id+"%') and upper(b.facility_name) like upper('"+qry_facility_name+"%') and upper(a.position_code) like upper('"+qry_position_code+"%') and  upper(c.position_desc) like upper('"+qry_position_desc+"%') and  ('"+qry_pract_type+"'"+" is null or d.pract_type='"+qry_pract_type+"')";


			sql = qryWhere;

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
		}
	else
			sql = whereClause;
		
			
			

try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
sqlCount = "select count(*) from cp_position_for_mdcp a, sm_facility_param b,am_position c, am_pract_type d where upper(a.facility_id) like upper('"+qry_facility_id+"%') and upper(b.facility_name) like upper('"+qry_facility_name+"%') and upper(a.position_code) like upper('"+qry_position_code+"%') and  upper(c.position_desc) like upper('"+qry_position_desc+"%') and  a.facility_id=b.facility_id and a.position_code=c.position_code and ('"+qry_pract_type+"'"+" is null or d.pract_type='"+qry_pract_type+"')and d.pract_type(+) = c.staff_type";
strsql = "SELECT a.facility_id,  b.facility_name,  a.position_code,c.position_desc, d.desc_userdef pract_type_desc FROM  cp_position_for_mdcp a, sm_facility_param b,am_position c, am_pract_type d where a.facility_id=b.facility_id and a.position_code=c.position_code and d.pract_type(+) = c.staff_type "+ sql;

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

rs = stmt.executeQuery(sqlCount);

if(rs.next())
{
	maxRecord = rs.getInt(1);
}
if(stmt!=null) 	stmt.close();

	if(maxRecord == 0)
		
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));history.go(-1);</script>");



            _bw.write(_wl_block4Bytes, _wl_block4);

if ( !(start <= 1) )
	out.println("<A HREF='PositionForMDCPQueryResult.jsp?facility_id="+qry_facility_id+"&facility_name="+qry_facility_name+"&position_code="+qry_position_code+"&position_desc="+qry_position_desc+"&pract_type="+qry_pract_type+"&from="+(start-13)+"&to="+(end-13)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='PositionForMDCPQueryResult.jsp?facility_id="+qry_facility_id+"&facility_name="+qry_facility_name+"&position_code="+qry_position_code+"&position_desc="+qry_position_desc+"&pract_type="+qry_pract_type+"&from="+(start+13)+"&to="+(end+13)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);

	stmt = conn.createStatement();
	rs = stmt.executeQuery(strsql);

	if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }
	while ( rs.next() && i<end)
	{

	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

    facility_id = rs.getString("facility_id")==null ? "":rs.getString("facility_id");
	facility_name  = rs.getString("facility_name")==null ? "":rs.getString("facility_name");
	position_code = rs.getString("position_code")==null ? "":rs.getString("position_code");
	position_desc = rs.getString("position_desc")==null ? "":rs.getString("position_desc");
	pract_type_desc = rs.getString("pract_type_desc")==null ? "":rs.getString("pract_type_desc");
	if(pract_type_desc.equals("")) pract_type_desc = "&nbsp;";
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(position_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pract_type_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);

	i++;

  }
  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
  
            _bw.write(_wl_block13Bytes, _wl_block13);

}catch(Exception e)
{
	//out.println(e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();
}
finally {
	  if (rs != null)   rs.close();
	  if (stmt != null) stmt.close();
	  ConnectionManager.returnConnection(conn,request);
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
}
