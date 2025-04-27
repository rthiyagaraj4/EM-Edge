package jsp_servlet._datadictionary._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public final class __components extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/datadictionary/jsp/Components.jsp", 1709113757051L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<style>\n.moduleStripStyle {\n\theight: 33px;\n\tbackground-color: #007cb9; /* Old browsers */\n\tborder-top: 1px solid #00a3cf;\n}\n</style>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<link rel=\"stylesheet\" href=\"../css/style.css\"/> \n<script type=\"text/javascript\">\nfunction showModuleDetails(moduleId,moduleName){\n\t//parent.REPWINDOW.location.href = \"ModuleDetails.jsp?moduleId=\"+moduleId+\"&moduleName=\"+moduleName;\n\t//parent.REPWINDOW.location.href = \"ModuleDetailsMain.jsp?moduleId=\"+moduleId+\"&moduleName=\"+moduleName;\n\tparent.REPWINDOW.location.href = \"ModuleDetailsMain.jsp?moduleId=\"+moduleId+\"&moduleName=\"+moduleName+\"&hdnAssociateClicked=&hdnAttributeClicked=&hdnModuleName=\";\n\t//parent.ATTRWINDOW.location.href = \"../html/blank.html\";\n\tvar hdnSelectedModuleNameComp = document.getElementById(\"hdnSelectedModuleName\");\n\tvar prevSelectedModuleName=\"\";\n\tif(hdnSelectedModuleNameComp){\n\t\tprevSelectedModuleName = hdnSelectedModuleNameComp.value;\n\t}\n\t\n\tvar hdnSelectedModuleIdComp = document.getElementById(\"hdnSelectedModuleId\");\n\tvar prevSelectedModuleId=\"\";\n\tif(hdnSelectedModuleIdComp){\n\t\tprevSelectedModuleId = hdnSelectedModuleIdComp.value;\n\t}\n\t\n\tvar prevImagetd = document.getElementById(\'img\'+prevSelectedModuleName+prevSelectedModuleId);\n\tif(prevImagetd){\n\t\tprevImagetd.style.display = \"none\";\n\t\t//prevImagetd.src = \"\";\n\t}\n\t\n\tvar imagetd = document.getElementById(\'img\'+moduleName+moduleId);\n\tif(imagetd){\n\t\timagetd.style.display = \"block\";\n\t\t//imagetd.src = \"../images/SelectArrow.PNG\";\n\t}\n\t\n\tif(hdnSelectedModuleNameComp){\n\t\thdnSelectedModuleNameComp.value = moduleName;\n\t}\n\t\n\tif(hdnSelectedModuleIdComp){\n\t\thdnSelectedModuleIdComp.value = moduleId;\n\t}\n\t\n}\n\nfunction autocompleteForModule(textObj){\n\tvar inputValue = textObj.value;\n\tvar hdnCompleteModuleNameComp = document.getElementById(\"hdnCompleteModuleName\");\n\tvar completeModuleName = \"\";\n\tif(hdnCompleteModuleNameComp){\n\t\tcompleteModuleName = hdnCompleteModuleNameComp.value;\n\t}\n\t\n\tvar hdnCompleteModuleIdComp = document.getElementById(\"hdnCompleteModuleId\");\n\tvar completeModuleId = \"\";\n\tif(hdnCompleteModuleIdComp){\n\t\tcompleteModuleId = hdnCompleteModuleIdComp.value;\n\t}\n\t\n\t\n\tvar moduleNamesArr = completeModuleName.split(\";\");\n\tvar moduleIdArr = completeModuleId.split(\";\");\n\tvar moduleNamesLen = moduleNamesArr.length;\n\tif(moduleIdArr.length != moduleNamesLen){\n\t\talert(\"Internal System Error - Cannot filter the modules\");\n\t}\n\tfor(var count=0;count<moduleNamesLen;count++){\n\t\tvar trElem = document.getElementById(\"tr\"+moduleNamesArr[count]+moduleIdArr[count]);\n\t\tvar matchIndex = moduleNamesArr[count].toLowerCase().indexOf(inputValue.toLowerCase());\n\t\tif(matchIndex == 0){\n\t\t\tif(trElem){\n\t\t\t\ttrElem.style.display = \"block\";\n\t\t\t}\n\t\t}else{\n\t\t\tif(trElem){\n\t\t\t\ttrElem.style.display = \"none\";\n\t\t\t}\n\t\t}\n\t}\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body BGCOLOR=#000000>\n<TABLE height=\"110px\" width=\"221px\" style=\"background-image: url(\'../images/HeaderBg.png\');\" border=0 cellpadding=\"0\" cellspacing=\"0\">\n<TR>\n<TD ALIGN=\"Center\" width=\"100%\" valign=\"bottom\">\n<span class=\"eMTitleStyle\">eM</span>\n</TD>\n</TR>\n<tr>\n<td align=\"center\" valign=\"top\">\n<span class=\"moduleHeaderStyle\">Health View Model</span>\n</td>\n</tr>\n</TABLE>\n\n<table width=\"215px\" border=0 style=\"height:33px;margin-left: 7px;background-image: url(\'../images/HeaderBg.png\');background-repeat: repeat-x;\">\n<tr style=\"background-image: url(\'../images/MenuHeaderBg.png\');background-repeat: repeat-x;\">\n<td ALIGN=\"center\" style=\"margin-left: 8px;\" >\n <span class =\"modulespanStyle\">Module</span> \n</td>\n</tr>\n</table>\n\n<table class=\"autocompleteTableStyle\" style=\"background-image: url(\'../images/MenuBg.png\');\" border=0>\n<tr>\n<td width=\"100%\"  ALIGN=\"LEFT\" style=\"padding-left: 8px;\" >\n<input type=\"text\" class=\"autocompleteTextStyle\" onkeyup=\"autocompleteForModule(this)\"/>\n</td>\n</tr>\n</table>\n\n<div id=\"moduleTableDiv\">\n<table width=\"100%\" style=\"background-image: url(\'../images/MenuBg.png\');background-repeat:repeat-y;\" cellpadding=\"0\" cellspacing=\"0\">\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\n\t\t\t<TR id=\"tr";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" style=\"display: block;padding-top: 5px;padding-bottom: 5px;padding-left: 5px;\" width=\"100%\">\t\t\n\t\t\t<TD style=\"padding-left: 10px;\" align=\"left\" valign=\"middle\">\n\t\t\t<img src=\"../images/Arrow.PNG\"/>\n\t\t\t</TD>\n\t\t\t<TD style=\"padding-left: 5px;\" align=\"left\" valign=\"middle\">\n\t\t\t<A class=\"componentAnchor\" href = \"javascript:showModuleDetails(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\',\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\');\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t</TD>\n\t\t\t<TD align=\"right\" valign=\"middle\" >\n\t\t\t\t<table id=\"img";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  style=\"display:none;\" border=0>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\"right\">\n\t\t\t\t\t\t\t<img src=\"../images/SelectArrow.PNG\"/>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</TD>\n\t\t\t</TR>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\t\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\n</TABLE>\n\n<input type=\"hidden\" id=\"hdnCompleteModuleName\" name=\"hdnCompleteModuleName\" id=\"hdnCompleteModuleName\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"> \n<input type=\"hidden\" id=\"hdnCompleteModuleId\" name=\"hdnCompleteModuleId\" id=\"hdnCompleteModuleId\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<input type=\"hidden\" id=\"hdnSelectedModuleName\" name=\"hdnSelectedModuleName\" id=\"hdnSelectedModuleName\" value=\"\"/>\n<input type=\"hidden\" id=\"hdnSelectedModuleId\" name=\"hdnSelectedModuleId\" id=\"hdnSelectedModuleId\" value=\"\"/>\n \n</div>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	PreparedStatement prepStmt = null;
	Connection conn = null;
	try {
		conn = ConnectionManager.getConnection(request);
	} catch (Exception e) {
		out.println("Could not get connection. Error Message ="
				+ e.getMessage());
		return;
	}

	// safe approach
	if (conn == null) {
		out.println("Error in showing the details as connection to the database was not obtained");
		return;
	}

	String query = "Select * from SM_Module order by upper(Module_name)";
	ResultSet rs = null;
	StringBuffer completeModuleName = new StringBuffer("");
	StringBuffer completeModuleId = new StringBuffer("");
	try {
		prepStmt = conn.prepareStatement(query);
		rs = prepStmt.executeQuery();
		if (rs != null) {

            _bw.write(_wl_block3Bytes, _wl_block3);

		String moduleName = "";
				String moduleId = "";
				int rowCounter = 0;
				
				while (rs.next()) {
					moduleId = rs.getString("MODULE_ID");
					moduleName = rs.getString("MODULE_NAME");
					completeModuleName.append(moduleName);
					completeModuleName.append(";");
					completeModuleId.append(moduleId);
					completeModuleId.append(";");
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(moduleName));
            out.print( String.valueOf(moduleId ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(moduleId));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(moduleName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(moduleName));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(moduleName));
            out.print( String.valueOf(moduleId ));
            _bw.write(_wl_block9Bytes, _wl_block9);

			}

			if (completeModuleName.length() > 0) {
				completeModuleName.delete(
						completeModuleName.length() - 1,
						completeModuleName.length());
			}
			
			if (completeModuleId.length() > 0) {
				completeModuleId.delete(
						completeModuleId.length() - 1,
						completeModuleId.length());
			}
		
            _bw.write(_wl_block10Bytes, _wl_block10);

		}
	} catch (Exception ex) {
		out.println("Could not get the list of modules. Error Message ="
				+ ex.getMessage());
		return;
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {

			}
		}

		if (prepStmt != null) {
			try {
				prepStmt.close();
			} catch (Exception ex) {

			}
		}
		ConnectionManager.returnConnection(conn, request);
	}
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(completeModuleName.toString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(completeModuleId.toString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
