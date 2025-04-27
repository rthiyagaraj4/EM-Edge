package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __surgicalaccessoriesobjectcollect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SurgicalAccessoriesObjectCollect.jsp", 1709120388000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="                                 \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3_0 ="\n<html>\n<head>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\t\t\n<script language=\"javascript\">\n\tvar rows_for_consumables = new Array();\n\tvar rows_for_equipments = new Array();\n\tvar rows_for_instruments = new Array();\n\tvar rows_for_prosthesis = new Array();\n\tvar rows_for_personnel = new Array();\n</script>\n<script language=\"javascript\">\n\nfunction createXMLForOT_OPER_PACKAGE(){\n//function createXMLForPackage(){\n\t var rows=window.parent.frames[1].rows_for_consumables;\n     var masterFrame=window.parent.frames[0];\n\t var formObj=masterFrame.document.forms[0];\n\t var len = rows.length;\n\t var table_name = \"OT_OPER_PACKAGE\";\n\t var xmlString =\"\";\n\t var header =\"\";\n\t for(i in rows){\n\t\t\tif(rows[i].mode!=\'L\'){\n  //  for(var i=0;i<len;i++){\n//\t  if(rows[i]!=null && rows[i].mode!=\'L\' ){\n\t\t//alert(\"in the createXMLForOT_OPER_PACKAGE function\");\n\t\tif(rows[i].mode==\'D\'){\n\t\t\tif(formObj.appl_desc.value==\'AOPR\')\n                rows[i].mode=\'D1\';\n\t\t\telse if(formObj.appl_desc.value==\'SSPL\')\n\t\t\t\trows[i].mode=\'D2\';\n\t\t\telse if(formObj.appl_desc.value==\'SCAT\')\n\t\t\t\trows[i].mode=\'D3\';\n\t\t\telse if(formObj.appl_desc.value==\'SSUB\')\n\t\t\t\trows[i].mode=\"D4\";\n\t\t\telse if(formObj.appl_desc.value==\'SOPR\')\n\t\t\t\trows[i].mode=\'D5\';\n\t\t}else if(rows[i].mode==\'U\'){\n\t\t\tif(formObj.appl_desc.value==\'AOPR\')\n                rows[i].mode=\'U1\';\n\t\t\telse if(formObj.appl_desc.value==\'SSPL\')\n\t\t\t\trows[i].mode=\'U2\';\n\t\t\telse if(formObj.appl_desc.value==\'SCAT\')\n\t\t\t\trows[i].mode=\'U3\';\n\t\t\telse if(formObj.appl_desc.value==\'SSUB\')\n\t\t\t\trows[i].mode=\"U4\";\n\t\t\telse if(formObj.appl_desc.value==\'SOPR\')\n\t\t\t\trows[i].mode=\'U5\';\n\t\t}\n\t\txmlString+=\"<OPER_PACKAGE\"+i+\" \";\n\t\txmlString+=\"appl_desc=\\\"\"+formObj.appl_desc.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+formObj.speciality_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"category_code=\\\"\"+formObj.category_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"subCategory_code=\\\"\"+formObj.subCategory_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"operation_code=\\\"\"+formObj.operation_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"package_code=\\\"\"+rows[i].packs_code+\"\\\"\"+\" \";\n\t\txmlString+=\"package_qty=\\\"\"+rows[i].no_Of_Units+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t }\n }\n\t\treturn xmlString;\n}\n\nfunction createXMLForOT_OPER_EQUIPMENT(){\n//function createXMLForEquipment(){\n  var rows=window.parent.frames[1].rows_for_equipments;\n  var masterFrame=window.parent.parent.frames[1].frames[0];\n  var formObj=masterFrame.document.forms[0];\n  var len = rows.length;\n  var table_name = \"OT_OPER_EQUIPMENT\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t  if(rows[i]!=null && rows[i].mode!=\'L\' ){\n\t\t//alert(\"in the createXMLForOT_OPER_EQUIPMENT function\");\n\t\t//alert(\"rows[i].mode====\"+rows[i].mode);\n\t\tif(rows[i].mode==\'D\'){\n\t\t\tif(formObj.appl_desc.value==\'AOPR\')\n                rows[i].mode=\'D1\';\n\t\t\telse if(formObj.appl_desc.value==\'SSPL\')\n\t\t\t\trows[i].mode=\'D2\';\n\t\t\telse if(formObj.appl_desc.value==\'SCAT\')\n\t\t\t\trows[i].mode=\'D3\';\n\t\t\telse if(formObj.appl_desc.value==\'SSUB\')\n\t\t\t\trows[i].mode=\"D4\";\n\t\t\telse if(formObj.appl_desc.value==\'SOPR\')\n\t\t\t\trows[i].mode=\'D5\';\n\t\t}else if(rows[i].mode==\'U\'){\n\t\t\tif(formObj.appl_desc.value==\'AOPR\')\n                rows[i].mode=\'U1\';\n\t\t\telse if(formObj.appl_desc.value==\'SSPL\')\n\t\t\t\trows[i].mode=\'U2\';\n\t\t\telse if(formObj.appl_desc.value==\'SCAT\')\n\t\t\t\trows[i].mode=\'U3\';\n\t\t\telse if(formObj.appl_desc.value==\'SSUB\')\n\t\t\t\trows[i].mode=\"U4\";\n\t\t\telse if(formObj.appl_desc.value==\'SOPR\')\n\t\t\t\trows[i].mode=\'U5\';\n\t\t}\n\t\txmlString+=\"<OPER_EQUIPMENT\"+i+\" \";\n\t\txmlString+=\"appl_desc=\\\"\"+formObj.appl_desc.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+formObj.speciality_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"category_code=\\\"\"+formObj.category_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"subCategory_code=\\\"\"+formObj.subCategory_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"operation_code=\\\"\"+formObj.operation_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"equipment_code=\\\"\"+rows[i].equipment_code+\"\\\"\"+\" \";\n\t\txmlString+=\"no_Of_Units=\\\"\"+rows[i].no_Of_Units+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t}\n\n\n\t }\n  \n return xmlString;\n}\n\nfunction createXMLForOT_OPER_INSTRUMENT(){\n//function createXMLForInstrument(){\n\t//alert(\"inside createXMLForOT_OPER_INSTRUMENT\");\n  var rows=window.parent.frames[1].rows_for_instruments;\n  var masterFrame=window.parent.parent.frames[1].frames[0];\n  var formObj=masterFrame.document.forms[0];\n  var len = rows.length;\n  var table_name = \"OT_OPER_INSTRUMENT\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t  if(rows[i]!=null && rows[i].mode!=\'L\' ){\n\t\t//alert(\"in the createXMLForOT_OPER_INSTRUMENT function\");\n\t\t//alert(\"rows[i].mode====\"+rows[i].mode);\n\t\tif(rows[i].mode==\'D\'){\n\t\t\tif(formObj.appl_desc.value==\'AOPR\')\n                rows[i].mode=\'D1\';\n\t\t\telse if(formObj.appl_desc.value==\'SSPL\')\n\t\t\t\trows[i].mode=\'D2\';\n\t\t\telse if(formObj.appl_desc.value==\'SCAT\')\n\t\t\t\trows[i].mode=\'D3\';\n\t\t\telse if(formObj.appl_desc.value==\'SSUB\')\n\t\t\t\trows[i].mode=\"D4\";\n\t\t\telse if(formObj.appl_desc.value==\'SOPR\')\n\t\t\t\trows[i].mode=\'D5\';\n\t\t}else if(rows[i].mode==\'U\'){\n\t\t\tif(formObj.appl_desc.value==\'AOPR\')\n                rows[i].mode=\'U1\';\n\t\t\telse if(formObj.appl_desc.value==\'SSPL\')\n\t\t\t\trows[i].mode=\'U2\';\n\t\t\telse if(formObj.appl_desc.value==\'SCAT\')\n\t\t\t\trows[i].mode=\'U3\';\n\t\t\telse if(formObj.appl_desc.value==\'SSUB\')\n\t\t\t\trows[i].mode=\"U4\";\n\t\t\telse if(formObj.appl_desc.value==\'SOPR\')\n\t\t\t\trows[i].mode=\'U5\';\n\t\t}\n\t\txmlString+=\"<OPER_INSTRUMENT\"+i+\" \";\n\t\txmlString+=\"appl_desc=\\\"\"+formObj.appl_desc.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+formObj.speciality_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"category_code=\\\"\"+formObj.category_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"subCategory_code=\\\"\"+formObj.subCategory_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"operation_code=\\\"\"+formObj.operation_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"instr_code=\\\"\"+rows[i].instr_code+\"\\\"\"+\" \";\n\t\txmlString+=\"no_Of_Units=\\\"\"+rows[i].no_Of_Units+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t//alert(\"xmlString==\"+xmlString);\n\t\t\n\t\t}\n\n\n\t }\n  \n return xmlString;\n}\n\nfunction createXMLForOT_OPER_PROSTHESIS(){\n//function createXMLForpProsthesis(){\n\t//alert(\"inside createXMLForOT_OPER_PROSTHESIS\");\n  var rows=window.parent.frames[1].rows_for_prosthesis;\n  var masterFrame=window.parent.parent.frames[1].frames[0];\n  var formObj=masterFrame.document.forms[0];\n  var len = rows.length;\n  var table_name = \"OT_OPER_PROSTHESIS\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t  if(rows[i]!=null && rows[i].mode!=\'L\' ){\n\t\t//alert(\"in the createXMLForOT_OPER_PROSTHESIS function\");\n\t\t//alert(\"rows[i].mode====\"+rows[i].mode);\n\t\tif(rows[i].mode==\'D\'){\n\t\t\tif(formObj.appl_desc.value==\'AOPR\')\n                rows[i].mode=\'D1\';\n\t\t\telse if(formObj.appl_desc.value==\'SSPL\')\n\t\t\t\trows[i].mode=\'D2\';\n\t\t\telse if(formObj.appl_desc.value==\'SCAT\')\n\t\t\t\trows[i].mode=\'D3\';\n\t\t\telse if(formObj.appl_desc.value==\'SSUB\')\n\t\t\t\trows[i].mode=\"D4\";\n\t\t\telse if(formObj.appl_desc.value==\'SOPR\')\n\t\t\t\trows[i].mode=\'D5\';\n\t\t}else if(rows[i].mode==\'U\'){\n\t\t\tif(formObj.appl_desc.value==\'AOPR\')\n                rows[i].mode=\'U1\';\n\t\t\telse if(formObj.appl_desc.value==\'SSPL\')\n\t\t\t\trows[i].mode=\'U2\';\n\t\t\telse if(formObj.appl_desc.value==\'SCAT\')\n\t\t\t\trows[i].mode=\'U3\';\n\t\t\telse if(formObj.appl_desc.value==\'SSUB\')\n\t\t\t\trows[i].mode=\"U4\";\n\t\t\telse if(formObj.appl_desc.value==\'SOPR\')\n\t\t\t\trows[i].mode=\'U5\';\n\t\t}\n\t\txmlString+=\"<OPER_PROSTHESIS\"+i+\" \";\n\t\txmlString+=\"appl_desc=\\\"\"+formObj.appl_desc.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+formObj.speciality_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"category_code=\\\"\"+formObj.category_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"subCategory_code=\\\"\"+formObj.subCategory_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"operation_code=\\\"\"+formObj.operation_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"prosthesis_code=\\\"\"+rows[i].prosthesis_code+\"\\\"\"+\" \";\n\t\txmlString+=\"no_Of_Units=\\\"\"+rows[i].no_Of_Units+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t//alert(\"xmlString==\"+xmlString);\n\t\t\n\t\t}\n\n\n\t }\n  \n return xmlString;\n}\n\nfunction createXMLForOT_OPER_PERSONNEL_REQD(){\n\t//alert(\"inside createXMLForOT_OPER_PERSONNEL_REQD\");\n  var rows=window.parent.frames[1].rows_for_personnel;\n  var masterFrame=window.parent.frames[0];\n  var formObj=masterFrame.document.forms[0];\n  var len = rows.length;\n  var table_name = \"OT_OPER_PERSONNEL_REQD\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t  if(rows[i]!=null && rows[i].mode!=\'L\' ){\n\t\t//alert(\"in the createXMLForOT_OPER_PERSONNEL_REQD function\");\n\t\t//alert(\"rows[i].mode====\"+rows[i].mode);\n\t\tif(rows[i].mode==\'D\'){\n\t\t\tif(formObj.appl_desc.value==\'AOPR\')\n                rows[i].mode=\'D1\';\n\t\t\telse if(formObj.appl_desc.value==\'SSPL\')\n\t\t\t\trows[i].mode=\'D2\';\n\t\t\telse if(formObj.appl_desc.value==\'SCAT\')\n\t\t\t\trows[i].mode=\'D3\';\n\t\t\telse if(formObj.appl_desc.value==\'SSUB\')\n\t\t\t\trows[i].mode=\"D4\";\n\t\t\telse if(formObj.appl_desc.value==\'SOPR\')\n\t\t\t\trows[i].mode=\'D5\';\n\t\t}else if(rows[i].mode==\'U\'){\n\t\t\tif(formObj.appl_desc.value==\'AOPR\')\n                rows[i].mode=\'U1\';\n\t\t\telse if(formObj.appl_desc.value==\'SSPL\')\n\t\t\t\trows[i].mode=\'U2\';\n\t\t\telse if(formObj.appl_desc.value==\'SCAT\')\n\t\t\t\trows[i].mode=\'U3\';\n\t\t\telse if(formObj.appl_desc.value==\'SSUB\')\n\t\t\t\trows[i].mode=\"U4\";\n\t\t\telse if(formObj.appl_desc.value==\'SOPR\')\n\t\t\t\trows[i].mode=\'U5\';\n\t\t}\n\t\txmlString+=\"<OPER_PERSONNEL_REQUIRED\"+i+\" \";\n\t\txmlString+=\"appl_desc=\\\"\"+formObj.appl_desc.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+formObj.speciality_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"category_code=\\\"\"+formObj.category_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"subCategory_code=\\\"\"+formObj.subCategory_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"operation_code=\\\"\"+formObj.operation_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"role_id=\\\"\"+rows[i].role_id+\"\\\"\"+\" \";\n\t\txmlString+=\"no_Of_Persons=\\\"\"+rows[i].no_Of_Persons+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t//alert(\"xmlString==\"+xmlString);\n\t\t\n\t\t}\n\n\n\t }\n  \n return xmlString;\n}\n\nfunction createXMLForOT_OPER_SURGICAL_ACCESSORIES(){\n  //alert(\"inside createXMLForOT_OPER_SURGICAL_ACCESSORIES\");\n  var masterFrame=window.parent.frames[0];\n  var formObj=masterFrame.document.forms[0];\n  var table_name = \"OT_OPER_SURGICAL_ACCESSORIES\";\n  var mode = formObj.mode.value;\n  var xmlString =\"\";\n  var header =\"\";\n\t//\talert(\"in the createXMLForOT_OPER_SURGICAL_ACCESSORIES function\");\n\t\txmlString+=\"<OPER_SURGICAL_ACCESSORIES\"+\" \";\n\t\t//xmlString+=\"surgeon_code=\\\"\"+formObj.surgeon_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"appl_desc=\\\"\"+formObj.appl_desc.value+\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+formObj.speciality_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"category_code=";
    private final static byte[]  _wl_block3_0Bytes = _getBytes( _wl_block3_0 );

    private final static java.lang.String  _wl_block3_1 ="\\\"\"+formObj.category_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"subCategory_code=\\\"\"+formObj.subCategory_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"operation_code=\\\"\"+formObj.operation_code.value+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+mode.toUpperCase()+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\n\n\t   header= createXMLForOT_OPER_PACKAGE();\n\tif (header.indexOf(\"/>\")!=-1){\n\t\t    xmlString+=header;\n\t\t\t// return xmlString;\n\t   }\n\t var header_1= createXMLForOT_OPER_EQUIPMENT();\n\t\tif (header_1.indexOf(\"/>\")!=-1){\n\t\t\t\n\t\t     xmlString+=header_1;\n\t\t\t// return xmlString;\n\t   }\n\tvar instrument=createXMLForOT_OPER_INSTRUMENT();\n\tif (instrument.indexOf(\"/>\")!=-1){\n\t\t\t\t\n\t\t     xmlString+=instrument;\n\t\t\t// return xmlString;\n\t   }\n\t  var prosthesis=createXMLForOT_OPER_PROSTHESIS();\n\t  if (prosthesis.indexOf(\"/>\")!=-1){\n\t\t\t\n\t\t     xmlString+=prosthesis;\n\t\t\t// return xmlString;\n\t   }\n\t   var reqd=createXMLForOT_OPER_PERSONNEL_REQD();\n\t    if (reqd.indexOf(\"/>\")!=-1){\n\t\t\t\t\n\t\t     xmlString+=reqd;\n\t\t\t //return xmlString;\n\t   }\n\t   \t return xmlString;\n\n}\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"ObjectCollectForm\" id=\"ObjectCollectForm\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block3_1Bytes = _getBytes( _wl_block3_1 );

    private final static java.lang.String  _wl_block4 ="\">\n</form>\n</body>\n</html>\n//OT_OPER_PERSONNEL_REQD ----personnel required\n//OT_OPER_PACKAGE ----consumables\n//OT_OPER_EQUIPMENT --equipments\n//OT_OPER_INSTRUMENT===instruments\n//OT_OPER_PROSTHESIS====prosthesis\n\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block3_0Bytes, _wl_block3_0);
            _bw.write(_wl_block3_1Bytes, _wl_block3_1);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
