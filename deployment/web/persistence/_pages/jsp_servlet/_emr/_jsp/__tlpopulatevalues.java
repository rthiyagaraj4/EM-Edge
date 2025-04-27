package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __tlpopulatevalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TLPopulateValues.jsp", 1709119131207L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t<script>\n\tparent.frames[1].frames[0].document.forms[0].serialvalue.value=";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\tparent.frames[1].frames[0].document.getElementById(\"fetchdata\").innerText=\' ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'\n\t\t\n\t</script>\n\n\n\t\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'\n\t\t\n\t</script>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 
	request.setCharacterEncoding("UTF-8");
    Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
 try
  {
	
	con	= ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	

	String report_gr_id=checkForNull(request.getParameter("report_gr_id"));
    String sub_group_code=checkForNull(request.getParameter("sub_group_code"));
    String main_group=checkForNull(request.getParameter("main_group"));
	String master=checkForNull(request.getParameter("master"));
    String levelcode=checkForNull(request.getParameter("levelcode"));
	String master_table_reference=checkForNull(request.getParameter("master_table_reference1"));
	
	String sql="";
	//Below line modified for this CRF PER-RH-206
	//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
	if(report_gr_id.equals("MRIPCSMB") || report_gr_id.equals("MRDCCSMB") || report_gr_id.equals("MROPCSMB"))
	{   
	    sql="select ORDER_BY_SRL_NO from mr_report_grouping  where   report_id='"+report_gr_id +"'  and MAST_TABLE_NAME_REFERENCE='TL'  and SUBGROUP_CODE='"+main_group+"' and GROUP_CODE='"+levelcode +"' and LEVEL3_CODE='"+sub_group_code+"'";
	 	
	int ordersrlno=0;
	rs=stmt.executeQuery(sql);
	if(rs.next())
	{
		ordersrlno=rs.getInt(1);
	}
	if(rs!=null) rs.close();
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(ordersrlno));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(ordersrlno));
            _bw.write(_wl_block4Bytes, _wl_block4);
 }
    else if(report_gr_id.equals("MRBRADEX") || report_gr_id.equals("MRBLABRG") || report_gr_id.equals("MRIPCSBD") || report_gr_id.equals("MRIPCSOBD"))
     {   //Above line modified for this CRF PER-PD-209A
		  sql="select ORDER_BY_SRL_NO from mr_report_grouping  where   report_id='"+report_gr_id +"'  and MAST_TABLE_NAME_REFERENCE='"+master+"'  and SUBGROUP_CODE='"+main_group+"' and GROUP_CODE='"+levelcode+"'";
	      int ordersrlno=0;
	rs=stmt.executeQuery(sql);
	if(rs.next())
	{
		ordersrlno=rs.getInt(1);
	}
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(ordersrlno));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(ordersrlno));
            _bw.write(_wl_block5Bytes, _wl_block5);

	 }
	 else
	 {
		  sql="select ORDER_BY_SRL_NO from mr_report_grouping  where   report_id='"+report_gr_id +"'  and MAST_TABLE_NAME_REFERENCE='"+master_table_reference+"'  and GROUP_CODE='"+main_group+"'";
	      int ordersrlno=0;
	if(rs!=null) rs.close();
	rs=stmt.executeQuery(sql);
	if(rs.next())
	{
		ordersrlno=rs.getInt(1);
	}
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(ordersrlno));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(ordersrlno));
            _bw.write(_wl_block5Bytes, _wl_block5);

	 }
 if(stmt!=null) stmt.close();
 if(rs!=null) rs.close();}
  catch(Exception e)
   {
	   //out.println("Exception in File SSPopulateValues"+e.toString());
	   e.printStackTrace();
   }
   finally
   {
    ConnectionManager.returnConnection(con,request);
   }

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
