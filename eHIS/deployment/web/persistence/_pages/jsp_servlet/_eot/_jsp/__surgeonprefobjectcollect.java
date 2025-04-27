package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __surgeonprefobjectcollect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SurgeonPrefObjectCollect.jsp", 1709120378000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\t\t                      \n<script language=\"javascript\">\n\tvar rows_for_consumables = new Array();\n\tvar rows_for_equipments = new Array();\n\tvar rows_for_instruments = new Array();\n\tvar rows_for_prosthesis = new Array();\n\tvar rows_for_personnel = new Array();\n</script>\n<script language=\"javascript\">\n\tfunction createXMLHeader(){\n\t\tvar formObj=parent.frames[0].document.forms[0];\n\t\tvar  header = \"\";\n\t    header+=\"surgeon_code=\\\"\"+formObj.surgeon_code.value+\"\\\"\"+\" \";\n\t\theader+=\"appl_desc=\\\"\"+formObj.appl_desc.value+\"\\\"\"+\" \";\n\t\theader+=\"speciality_code=\\\"\"+formObj.speciality_code.value+\"\\\"\"+\" \";\n\t\theader+=\"category_code=\\\"\"+formObj.category_code.value+\"\\\"\"+\" \";\n\t\theader+=\"subCategory_code=\\\"\"+formObj.subCategory_code.value+\"\\\"\"+\" \";\n\t\theader+=\"operation_code=\\\"\"+formObj.operation_code.value+\"\\\"\"+\" \";\n\t\treturn  header;\n\n\t}\n\tfunction createXMLDetails(rows){\n\t\tvar table_name=\"OT_OPER_DR_PREFERENCE\";\n\t\tvar xmlString=\"\";\n\t\tvar header = createXMLHeader();\n\t\tfor(j in rows){\n\t\t\tif(rows[j].mode!=\'L\'){\n\t\t\txmlString+=\"<OT_OPER_DR_PREFERENCE\"+j+\" \";\n\t\t\txmlString+=header;\n\t\t\tswitch(rows[j].type){\n\t\t\t\tcase \'E\':\n\t\t\t\t\txmlString+=\"code=\\\"\"+rows[j].equipment_code+\"\\\"\"+\" \";\n\t\t\t\t\txmlString+=\"units=\\\"\"+rows[j].no_Of_Units+\"\\\"\"+\" \";\n\t\t\t\t\tbreak;\n\t\t\t\tcase \'I\': \n\t\t\t\t\txmlString+=\"code=\\\"\"+rows[j].instr_code+\"\\\"\"+\" \";\n\t\t\t\t\txmlString+=\"units=\\\"\"+rows[j].no_Of_Units+\"\\\"\"+\" \";\t\t\t\t\n\t\t\t\t\tbreak;\n\t\t\t\tcase \'P\': \n\t\t\t\t\txmlString+=\"code=\\\"\"+rows[j].packs_code+\"\\\"\"+\" \";\n\t\t\t\t\txmlString+=\"units=\\\"\"+rows[j].no_Of_Units+\"\\\"\"+\" \";\n\t\t\t\t\tbreak;\n\t\t\t\tcase\'R\': \n\t\t\t\t\txmlString+=\"code=\\\"\"+rows[j].role_id+\"\\\"\"+\" \";\n\t\t\t\t\txmlString+=\"units=\\\"\"+rows[j].no_Of_Persons+\"\\\"\"+\" \";\n\t\t\t\t\tbreak;\n\t\t\t\tcase \'S\': \n\t\t\t\t\txmlString+=\"code=\\\"\"+rows[j].prosthesis_code+\"\\\"\"+\" \";\n\t\t\t\t\txmlString+=\"units=\\\"\"+rows[j].no_Of_Units+\"\\\"\"+\" \";\n\t\t\t\t\tbreak;\n\t\t\t}\n\t\t\txmlString+=\"type=\\\"\"+rows[j].type+\"\\\"\"+\" \";\n\t\t\txmlString+=\"mode=\\\"\"+rows[j].mode+\"\\\"\"+\" \";\n\t\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t }\n\t\t}\n\t\t return xmlString;\n\t}\n\n\tfunction formXMLString(){\n\t\t var xmlString = \"\";\n\t\t xmlString+=(rows_for_consumables.length>0)?createXMLDetails(rows_for_consumables):\"\";\n\t\t xmlString+=(rows_for_equipments.length>0)?createXMLDetails(rows_for_equipments):\"\";\n\t\t xmlString+=(rows_for_prosthesis.length>0)?createXMLDetails(rows_for_prosthesis):\"\";\n\t\t xmlString+=(rows_for_instruments.length>0)?createXMLDetails(rows_for_instruments):\"\";\n\t\t xmlString+=(rows_for_personnel.length>0)?createXMLDetails(rows_for_personnel):\"\";\n\t\t return xmlString;\n\t\t\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"ObjectCollectForm\" id=\"ObjectCollectForm\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
