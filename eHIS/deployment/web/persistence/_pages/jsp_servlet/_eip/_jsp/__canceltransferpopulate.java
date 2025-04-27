package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import java.util.*;

public final class __canceltransferpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/CancelTransferPopulate.jsp", 1742369139010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script>\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'Common\'));\t\t\t\t\t\t\tparent.frames[1].document.forms[0].fr_bed_no.select(); \n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].fr_bed_no.focus(); \t\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].cont.value=\"N\";\n\t\t\t\t\t\t\t</script>\t\t\t\t\t\t\t\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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

		request.setCharacterEncoding("UTF-8");
		String strFacilityId			=	(String)session.getValue("facility_id");
		String strNursingCode    =	 request.getParameter("hdnNursingUnit") ;     
		String strFrBedno	   		 = request.getParameter("hdnBedNo"); 
		String	strRoomNo = "";
		Connection			con			=	null;
		Statement			stmt		=	null;
		ResultSet			rset		=	null;
		con					=	ConnectionManager.getConnection(request);
		String sql="";
		try
		{		
		if(!strFrBedno.equals(""))
			{
				sql		=	"select a.room_no, a.bed_type_code,b.bed_class_code,b.short_desc,a.specialty_code,a.CURRENT_STATUS from ip_nursing_unit_bed a,ip_bed_class b where a.nursing_unit_code = '"+strNursingCode+"' and a.bed_no='"+strFrBedno+"' and a.facility_id = '"+strFacilityId+"'AND a.bed_class_code = b.bed_class_code  ";

				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql);

				if(rset != null)
				{
					if(rset.next())
					{
						strRoomNo					=	rset.getString("room_no");
						String bedShortDesc	=	rset.getString("short_desc");
						String strStatus			=  rset.getString("CURRENT_STATUS");
						if(strStatus.equals("A"))
						{
						out.println("<script>	 	parent.frames[1].document.getElementById('frroomno').innerHTML='"+strRoomNo+"';parent.frames[1].document.getElementById('frbedclass').innerHTML='"+bedShortDesc+"';</script>");
						}
						else
						{
							out.println("<script>alert(getMessage('OCCUPIED_BED','IP')); parent.frames[1].document.forms[0].cont.value=\"N\";parent.frames[1].document.forms[0].fr_bed_no.select();  parent.frames[1].document.forms[0].fr_bed_no.focus();</script>");
						}
					}				
					else
					{

            _bw.write(_wl_block1Bytes, _wl_block1);

					}
				}
			if(rset != null)rset.close();
			if(stmt != null)stmt.close();
			}
			}catch(Exception e){
		out.print("Exception :"+e);
		}
	finally {
			if(rset != null)rset.close();
			if(stmt != null)stmt.close();
			ConnectionManager.returnConnection(con,request);
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
