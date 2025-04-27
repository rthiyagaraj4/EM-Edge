package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.sql.*;
import webbeans.eCommon.*;

public final class __ambulancemanagementsystemload extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AmbulanceManagementSystemLoad.jsp", 1709113870568L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n\n<html>\n<head>\n\n<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/fonts-min.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/button.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/stdbutton.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/menu.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eAE/html/datatable.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="/eAE/html/AmbulanceManagementSystem.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/autocomplete.css\'></link>\n \t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/container.css\'></link>\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/container-skin.css\'></link> \n\t<link rel=\"stylesheet\" type =\"text/css\" href=\'../../eAE/html/skin.css\'></link> \n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eAE/html/keyboard.css\"> </link> \n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eAE/html/paginator.css\"> </link> \n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script type=\"text/javascript\" src=\"../../eAE/js/keyboard.js\" charset=\"UTF-8\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\t\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\" ></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/FieldFormatMethods.js\" ></Script>\n\t\n\t<script src=\'../../eAE/js/yahoo-dom-event.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/connection-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/element-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/container-min.js\' language=\'javascript\'></script>\n    <script src=\'../../eAE/js/menu-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/dragdrop-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/datasource-min.js\' language=\'javascript\'></script> \n\t<script src=\'../../eAE/js/datatable-min.js\' language=\'javascript\'></script>  \n  \t<script src=\'../../eAE/js/animation-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/autocomplete-min.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAE/js/button-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/paginator-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/json-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/event-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/yahoo-min.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eAE/js/get-min.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n\t\n\n\t\n <style>\n\t.yui-simple-dialog .bd span.warnicon {\n    background: url(\"../../eAE/images/warn16_1.gif\") no-repeat;\n\t}\n </style>\n\n\n \n\n\n</head>\n<body  class=\"yui-skin-sam\" OnMouseDown=\'CodeArrest()\' onkeydown=\"lockKey()\">\n<div id=\"alert\"></div>\n</body>\n</html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n   ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block2Bytes, _wl_block2);

	PreparedStatement pstmt 	= null;
	Connection con				= null;
	ResultSet rs                = null;

	String facility_id				=	(String)session.getValue("facility_id");
	String from_date				=	"";
	String to_date					=	"";
	boolean flag					=	false;
	String	msg						=  "APP-AE5001 AMS Parameter not defined";
	
	String query="Select to_char((sysdate- nvl(AMB_DFLT_DYS_BEHIND,0)),'DD/MM/YYYY')  DYS_BEHIND ,to_char((sysdate+ nvl(AMB_DFLT_DYS_AHEAD,0)),'DD/MM/YYYY')  DYS_AHEAD    from AE_AMB_PARAM_FOR_FACILITY where facility_id = ? ";


	try{
        con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(query); 
		pstmt.setString(1,facility_id);
		rs=pstmt.executeQuery();
		if(rs.next()){

			from_date=rs.getString(1);
			to_date=rs.getString(2);
			flag=true;
			
		}
   }catch(Exception e){
		e.printStackTrace();
		throw e;
	}

	finally {
		try{
			if(rs!=null) rs.close();
			if( pstmt!=null ) pstmt.close(); 
			if( con!=null )
				ConnectionManager.returnConnection(con, request);
			rs=null;
			pstmt=null;
			con=null;
		}catch(Exception e){
			e.printStackTrace();			
		}
	}

    if(flag){
	
	
            _bw.write(_wl_block3Bytes, _wl_block3);
            {java.lang.String __page = "AmbulanceManagementSystem.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("from_date"), weblogic.utils.StringUtils.valueOf(from_date
                        )},{ weblogic.utils.StringUtils.valueOf("to_date"), weblogic.utils.StringUtils.valueOf(to_date
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) {
                    __encoding = "ISO-8859-1";
                }
                if (__queryParams.length==0) {
                     pageContext.forward(__page);
                } else {
                    pageContext.forward(weblogic.utils.http.HttpParsing.makeURI(__page,__queryParams,__encoding));
                }if(true) return;
            }_bw.write(_wl_block5Bytes, _wl_block5);
}else{
   
	out.println("<script> var panel = new YAHOO.widget.SimpleDialog('alert',{fixedcenter: true, visible: true,modal: true,width: '400px',constraintoviewport: true, icon: YAHOO.widget.SimpleDialog.ICON_WARN,buttons: [{ text: 'OK', handler: function() {panel.hide();document.location.href='../../eCommon/jsp/CommonClearObjects.jsp';}, isDefault: true }]});panel.setHeader('Alert');panel.setBody('"+msg+"');panel.render('alert');</script>");
		//out.println("<script> var panel = new YAHOO.widget.SimpleDialog('alert',{fixedcenter: true, visible: true,modal: true,width: '400px',constraintoviewport: true, icon: YAHOO.widget.SimpleDialog.ICON_WARN,buttons: [{ text: 'OK', handler: function() {document.location.href='../../eCommon/jsp/CommonClearObjects.jsp';}, isDefault: true }]});panel.setHeader('Alert');panel.setBody('"+msg+"');panel.render('alert');</script>");
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
