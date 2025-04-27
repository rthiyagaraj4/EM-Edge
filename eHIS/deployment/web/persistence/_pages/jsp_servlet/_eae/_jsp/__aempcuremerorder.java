package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __aempcuremerorder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEMPCurEmerOrder.jsp", 1709113762504L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

	/* To fetch display order of fields in Result page
       :: Vinod Babu M V - 11/10/2009
	 */
	public String updateFieldOrder(Connection con,String facility_id,String loginUser,String fieldOrder) throws java.sql.SQLException 
	{  
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String [] fields = fieldOrder.split("~");
		int len = fields.length;
		int recCnt = 0;
		try {

			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from AE_CURR_EMERG_PAT_RESULT where Facility_id='"+facility_id+"' and User_id='"+loginUser+"'");

			if ((rs != null) && (rs.next()) )
			{
				recCnt = rs.getInt(1);
			}
		//System.out.println("recCnt : "+recCnt);
		if (recCnt == 0)
		{
			pstmt = con.prepareStatement("INSERT INTO AE_CURR_EMERG_PAT_RESULT ( FACILITY_ID, FIELD_NAME, FIELD_DESC, FIELD_ORDER, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,USER_ID) 	VALUES (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");
			for (int i=0; i<len; ++i )
			{ 
				String []fieldStr = fields[i].split("`");
				pstmt.setString(1,facility_id);
				pstmt.setString(2,fieldStr[0].toUpperCase());
				pstmt.setString(3,fieldStr[1].trim());
				pstmt.setInt(4,i+1);
				pstmt.setString(5,loginUser);
				pstmt.setString(6,loginUser);
				pstmt.setString(7,facility_id);
				pstmt.setString(8,loginUser);
				pstmt.setString(9,loginUser);
				pstmt.setString(10,facility_id);
				pstmt.setString(11,loginUser);
				pstmt.addBatch();
			}
		}
		else
		{
			pstmt = con.prepareStatement("UPDATE AE_CURR_EMERG_PAT_RESULT SET field_order = ?,  modified_by_id = ? , modified_date = sysdate , modified_at_ws_no = ?,MODIFIED_FACILITY_ID = ? where Field_name=? and Facility_id=? and User_id=?");
			for (int i=0; i<len; ++i )
			{ 
				String []fieldStr = fields[i].split("`");
				pstmt.setInt(1,i+1);
				pstmt.setString(2,loginUser);
				pstmt.setString(3,loginUser);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,fieldStr[0].toUpperCase());
				pstmt.setString(6,facility_id);
				pstmt.setString(7,loginUser);
				pstmt.addBatch();
			}
		}
			int[] batch_result = pstmt.executeBatch();
			for (int i=0; i<batch_result.length; ++i )
			con.commit();
		 }
		 catch(Exception e)
		 {
			 System.out.println("Exception : "+e);
			 e.printStackTrace();
			 con.rollback();
		 }
		 finally
		 {	
			if(pstmt!=null)	pstmt.close();
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs = null;
		 }
		//The fields are added to the list in the order of their display
		return fields[0];
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

	Connection con		= null ;
	try
	{
		String fieldOrder	=	(request.getParameter("fieldOrder")==null)	? "" : request.getParameter("fieldOrder");
//System.out.println("fieldOrder : "+fieldOrder);
		String facility_id  =	(String)session.getValue("facility_id");
		String loginUser = ((String)session.getValue("login_user")==null)?"":(String)session.getValue("login_user");
		con		=	(Connection)ConnectionManager.getConnection(request);
		out.print(updateFieldOrder(con,facility_id,loginUser,fieldOrder));
	}
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 finally
	 {	
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }

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
