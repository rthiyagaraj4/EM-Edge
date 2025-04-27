package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __facility extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/Facility.jsp", 1741326042094L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

    request.setCharacterEncoding("UTF-8");
	String function = request.getParameter("operation");

	Connection conn=null;
	try{
	conn = ConnectionManager.getConnection(request);
	java.sql.Statement stmt=conn.createStatement();
	java.sql.Statement stmt1=conn.createStatement();
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	ResultSet rs1=null;
	String sql ;
	String sql1="";

if ( function.equals("insert") )
{
	sql = "select facility_id,facility_name from sm_facility_param";
    rs = stmt.executeQuery(sql);
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><STYLE>.menuItem { font-family: sans-serif; font-size:8pt; width:100; padding-left:20; background-Color: blue;color:white; }  .highlightItem { font-family: sans-serif; font-size: 8pt; width: 100; padding-left: 20; background-Color: black; color: white; }  .clickableDiv { padding: 4; width: 500; background-Color: blue; color: white; border: 10px double blue; }  A:link { color: #003399; text-decoration: none; }  A:visited { color: #6699cc; text-decoration: none; }  A:hover { text-decoration: underline; }}</STYLE>");

	out.println("<script language='javascript' src='../../eCommon/js/common.js'></script>");
	out.println("</script>");
	out.println("<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>");

	out.println("<script language='javascript' src='../eSM/js/Facility.js'></script>Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body onKeyDown = 'lockKey()'>");

	out.println("<table name='facility_table' id='facility_table' id ='facility_table' width='100%'><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels")+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</th><tbody>");
	for ( int i=1;i<=5;i++)
	{
		out.println("<tr id='tr"+i+"'><td width='20%'><select name='f"+i+"' id='f"+i+"'>");
		out.println("<option>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.SelectFacility.label","sm_labels")+"</option>" );
		
		while ( rs.next() )
		{
		out.println("<option value='"+rs.getString("facility_id")+"'>"+rs.getString("facility_name")+"</option>");
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		out.println("</select></td>");
		out.println("<td width='80%'><textarea name='r"+i+"' rows='1' cols='60' maxlength='200' oncontextmenu='showMenu(this) ; return false;'></textarea></td></tr>");
	}
	out.println("</tbody></table>");


		rs = stmt.executeQuery(sql);
		out.println("<select name='facility_id_temp' id='facility_id_temp' style='{ display: none;}'>");
		out.println("<option>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.SelectFacility.label","sm_labels")+"</option>" );
		while ( rs.next() )
		{
		out.println("<option value='"+rs.getString("facility_id")+"'>"+rs.getString("facility_name")+"</option>");
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
	out.println("</select>");

	out.println("<DIV id='menu1' onclick='clickMenu()' onmouseover='toggleMenu()' onmouseout='toggleMenu()' oncontextmenu='contextTwice()' style='position:absolute;display:none;width:100;background-Color:white'> <DIV class='menuItem' id=mnuInsert>Insert Facility</DIV> <DIV class='menuItem' id=mnuDelete>Delete Facility</DIV><DIV class='menuItem' id=mnuClear>Clear Facility</DIV> </DIV> ");
	out.println("<input name='operation' id='operation' type='hidden' value='insert'></input>");

	out.println("</body></html>");
}
		// --------------- MODIFICATION ------------------------------
if ( function.equals("modify") )
{
	String respId = request.getParameter("resp_id");

	//sql = "select count(*) from sm_facility_for_resp where resp_id='"+respId+"'";
	//stmt1 =  conn.createStatement();
	//rs1 = stmt1.executeQuery(sql);
	
	sql = "select count(*) from sm_facility_for_resp where resp_id=?";
	pstmt   = conn.prepareStatement(sql);
	pstmt.setString	(	1,	respId		);
	rs1		 = pstmt.executeQuery();
	rs1.next();
		//to Redirect the URL if no Facility records are present
		if ( rs1.getInt(1) == 0 )
		{	response.sendRedirect("../eSM/jsp/Facility.jsp?operation=insert");
		}
		if(rs1!=null)rs1.close();
		if(stmt1!=null)stmt1.close();
		if(pstmt!=null)pstmt.close();


	sql = "select facility_id,remarks from sm_facility_for_resp where resp_id='"+respId+"'";
	rs = stmt.executeQuery(sql);



	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><STYLE>.menuItem { font-family: sans-serif; font-size:8pt; width:100; padding-left:20; background-Color: blue;color:white; }  .highlightItem { font-family: sans-serif; font-size: 8pt; width: 100; padding-left: 20; background-Color: black; color: white; }  .clickableDiv { padding: 4; width: 500; background-Color: blue; color: white; border: 10px double blue; }  A:link { color: #003399; text-decoration: none; }  A:visited { color: #6699cc; text-decoration: none; }  A:hover { text-decoration: underline; }}</STYLE>");

	out.println("<script language='javascript' src='../../eCommon/js/common.js'></script>");
	out.println("<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>");


	out.println("<script language='javascript' src='../eSM/js/Facility.js'></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body onKeyDown = 'lockKey()'>");

	out.println("<table name='facility_table' id='facility_table' id ='facility_table' width='100%'><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels")+"</th><th align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</th>");
	int i=1;

	sql1 = "select facility_name from sm_facility_param where facility_id='"+rs.getString("facility_id")+"'";

	stmt1 = conn.createStatement();
	rs1 = 	stmt1.executeQuery(sql1);
	while ( rs.next() )
	{
		out.println("<tr id='tr"+i+"'><td width='20%'><select name='f"+i+"' id='f"+i+"'>");

		rs1.next();
		out.println("<option value='"+rs.getString("facility_id")+"'>"+rs1.getString("facility_name") + "</option>");
		//this is to maintain the same length for all list items
		out.println("</select></td>");
		out.println("<td width='80%'><textarea name='r"+i+"' rows='1' cols='60' maxlength='200' oncontextmenu='showMenu(this) ; return false;'>" + rs.getString("remarks") + "</textarea></td></tr>");
		
	i++;
	}
	if(rs1!=null)rs1.close();
	if(stmt1!=null)stmt1.close();
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	if(pstmt!=null)pstmt.close();
	out.println("</table>");


		sql1 = "select facility_id,facility_name from sm_facility_param";
		rs1 = stmt.executeQuery(sql1);
		out.println("<select name='facility_id_temp' id='facility_id_temp' style='{ display: none;}'>");
		out.println("<option>----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option>" );
		while ( rs1.next() )
		{
		out.println("<option value='"+rs1.getString("facility_id")+"'>"+rs1.getString("facility_name")+"</option>");
		}
		if(rs1!=null)rs1.close();
		if(stmt1!=null)stmt1.close();
	out.println("</select>");

	out.println("<DIV id='menu1' onclick='clickMenu()' onmouseover='toggleMenu()' onmouseout='toggleMenu()' oncontextmenu='contextTwice()' style='position:absolute;display:none;width:100;background-Color:white'> <DIV class='menuItem' id=mnuInsert>Insert Facility</DIV> <DIV class='menuItem' id=mnuDelete>Delete Facility</DIV><DIV class='menuItem' id=mnuClear>Clear Facility</DIV> </DIV> ");
	out.println("</body></html>");

}

	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1.close();
	if(rs != null) rs.close();
	if(rs1 != null) rs1.close();


}catch(Exception e){out.println(e);}
finally { 
		ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
