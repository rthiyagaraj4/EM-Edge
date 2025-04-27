package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __ipadvbedmgmtnursingunitfloorlayout extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPAdvBedMgmtNursingUnitFloorLayout.jsp", 1738425881040L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html> \n\t<head>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eIP/html/JQuery/base/jquery.ui.resizable.css\"/>\n\t\t<link type=\"text/css\" rel=\"stylesheet\" href=\"../../eIP/html/IPAdvBedMgmtSetupStyle.css\"/>\n\t\t<script src=\'../../eIP/js/IPAdvBedMgmtSetup.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n\t\t<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.min.js\"></script>\n\t\t\n\t\t<script type=\"text/javascript\">\n\t\t\t$(document).ready(function(){\n\t\t\t\t$(\'.floorsetup\').resizable({\n\t\t\t\t\thandles:  \'e,s\'\n\t\t\t\t});\n\t\t\t});\n\t\t\twindow.onresize=function(){\n\t\t\t\t//alert(document.documentElement.clientWidth)\n\t\t\t\tif(document.documentElement.clientWidth > 1160){\n\t\t\t\t\t$(\'#floorWrapper\').width(1160);\n\t\t\t\t}else{\n\t\t\t\t\t$(\'#floorWrapper\').width(document.documentElement.clientWidth-10);\n\t\t\t\t}\n\t\t\t\tif(document.documentElement.clientHeight > 600){\n\t\t\t\t\t$(\'#floorWrapper\').height(600);\n\t\t\t\t}else{\n\t\t\t\t\t$(\'#floorWrapper\').height(document.documentElement.clientHeight-10);\n\t\t\t\t}\t\t\t\t\n\t\t\t};\n\t\t\tfunction submitFloorLayout(){ \n\t\t\t\tif($(\"#countId\").val()>0 && ($(\"#floorWidthId\").val()>$(\'#floor\').width()||$(\"#floorHeightId\").val()>$(\'#floor\').height())){\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\"ROOMS_CONF_FLOOR_REDUCE\",\"IP\"));\t\t\t\t\t//parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"ROOMS_CONF_FLOOR_REDUCE\",\"IP\")+\"&err_value=1\";\n\t\t\t\t\t//parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"RECORD_MODIFIED\",\"SM\")+\"&err_value=0\";\n\t\t\t\t}else{\n\t\t\t\t\t$.post(\"../../servlet/eIP.IPAdvBedMgmtSetupServlet\",\n\t\t\t\t\t{\n\t\t\t\t\t\toperation: \"floorLayout\",\n\t\t\t\t\t\tfloorWidth:$(\"#floor\").width(),\n\t\t\t\t\t\tfloorHeight:$(\"#floor\").height(),\n\t\t\t\t\t\tnursingUnit:parent.blank.bedMgmtSetupForm.nursing_unit.value\n\t\t\t\t\t},\n\t\t\t\t\tfunction(data, textStatus)\n\t\t\t\t\t{\n\t\t\t\t\t\t//alert(\"APP-SM0069 Operation Completed Successfully ....\");\n\t\t\t\t\t\tparent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+getMessage(\"RECORD_MODIFIED\",\"SM\")+\"&err_value=0\";\n\t\t\t\t\t\tparent.blank.location.href=\"../../eIP/jsp/IPAdvBedMgmtCriteria.jsp\";\n\t\t\t\t\t\tlocation.href = \"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t);\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown = \"lockKey()\">\n\t\t<form name=\'floorLayOutMgmt\' id=\'floorLayOutMgmt\' method=\'post\'>\n\t\t\t<div id=\'floorsetupMain\' class=\'floorsetupMain\'>\n\t\t\t<div class=\'floorWrappersetup\' id=\"floorWrapper\">\n\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t<div class=\"floorsetup\" id=\"floor\">\n\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t<div class=\"floorsetup\" id=\"floor\" style=\"width:";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="px; height:";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="px;\">\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t\t\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div>\n\t\t\t<input type=\'hidden\' id=\'floorWidthId\' name=\'floorWidth\' id=\'floorWidth\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t<input type=\'hidden\' id=\'floorHeightId\' name=\'floorHeight\' id=\'floorHeight\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t<input type=\'hidden\' id=\'countId\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t</form>\n\t</body>\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String nursingUnit=request.getParameter("nursingUnit")==null?"":request.getParameter("nursingUnit");
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	String facility_id		= (String)session.getAttribute("facility_id");

            _bw.write(_wl_block2Bytes, _wl_block2);

		HashMap floorLayoutmap=new HashMap();
		String floorWidth="0";
		String floorHeight="0";
		String count="0";
			try{
				con=ConnectionManager.getConnection(request);
				floorLayoutmap=eIP.IPAdvBedMgmtConfigBean.getFloorLayout(con,facility_id,nursingUnit);
				floorWidth=(String)floorLayoutmap.get("floor_width");
				floorHeight=(String)floorLayoutmap.get("floor_height");
				count=(String)floorLayoutmap.get("count"); 
				floorLayoutmap.clear();
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if(con != null)  ConnectionManager.returnConnection(con,request);
			}
		
            _bw.write(_wl_block3Bytes, _wl_block3);
if(floorWidth.equals("0") || floorHeight.equals("0")){
            _bw.write(_wl_block4Bytes, _wl_block4);
}else{
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(floorWidth));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(floorHeight));
            _bw.write(_wl_block7Bytes, _wl_block7);
}
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(floorWidth));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(floorHeight));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(count));
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
