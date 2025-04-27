package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __accessrightsmenusubfuncresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/AccessRightsMenuSubFuncResult.jsp", 1713243105955L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\n<script>\nvar arrSubfuncins = new Array();\nvar arrSubfuncupd = new Array();\nvar arrSubfuncdel = new Array();\nvar arrSubfuncprn = new Array();\nvar arrSubfuncqry = new Array();\nvar cnt = 0;\n\n\tfunction setValues(Obj)\n\t{\n\t\tvar objname = Obj.name.substring(6,7);\n\t\tif(Obj.checked)\n\t\t{\n\t\t\tObj.value = \"Y\";\n\t\t\tif(arrSubfuncins[objname-1] == \"Y\") \n\t\t\t\teval(\"document.forms[0].subins\"+objname+\".disabled = false\");\n\t\t\tif(arrSubfuncupd[objname-1] == \"Y\") \n\t\t\t\teval(\"document.forms[0].subupd\"+objname+\".disabled = false\");\n\t\t\tif(arrSubfuncdel[objname-1] == \"Y\") \n\t\t\t\teval(\"document.forms[0].subdel\"+objname+\".disabled = false\");\n\t\t\tif(arrSubfuncqry[objname-1] == \"Y\") \n\t\t\t\teval(\"document.forms[0].subqry\"+objname+\".disabled = false\");\n\t\t\tif(arrSubfuncprn[objname-1] == \"Y\") \n\t\t\t\teval(\"document.forms[0].subprn\"+objname+\".disabled = false\");\n\t\t}\n\t\telse\n\t\t{\n\t\t\tObj.value = \"N\";\n\t\t\teval(\"document.forms[0].subins\"+objname+\".disabled = true\");\n\t\t\teval(\"document.forms[0].subupd\"+objname+\".disabled = true\");\n\t\t\teval(\"document.forms[0].subdel\"+objname+\".disabled = true\");\n\t\t\teval(\"document.forms[0].subqry\"+objname+\".disabled = true\");\n\t\t\teval(\"document.forms[0].subprn\"+objname+\".disabled = true\");\n\t\t}\n\t}\n\t\n\tfunction setInsVals(Obj)\n\t{\n\t\tif(Obj.checked)\n\t\t\tObj.value = \"Y\";\n\t\telse\n\t\t\tObj.value = \"N\";\n\t}\n\n\tfunction setUpdVals(Obj)\n\t{\n\t\tif(Obj.checked)\n\t\t\tObj.value = \"Y\";\n\t\telse\n\t\t\tObj.value = \"N\";\n\t}\n\n\tfunction setDelVals(Obj)\n\t{\n\t\tif(Obj.checked)\n\t\t\tObj.value = \"Y\";\n\t\telse\n\t\t\tObj.value = \"N\";\n\t}\n\n\tfunction setQryVals(Obj)\n\t{\n\t\tif(Obj.checked)\n\t\t\tObj.value = \"Y\";\n\t\telse\n\t\t\tObj.value = \"N\";\n\t}\n\n\tfunction setPrnVals(Obj)\n\t{\n\t\tif(Obj.checked)\n\t\t\tObj.value = \"Y\";\n\t\telse\n\t\t\tObj.value = \"N\";\n\t}\n\n\tfunction disabledValues()\n\t{\n\n\t}\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"AccessRightsMenuSubFuncResult_Form\" id=\"AccessRightsMenuSubFuncResult_Form\" method=post  action=\'../../servlet/eSM.AccessRightsMenuFuncServlet\' target=\'messageFrame\' >\n<b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" : ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b>\n<table border=\'1\' width=\'102%\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' >\n\t <tr>\n\t\t<th align=\'left\' width=\'40%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t<th align=\'center\' width=\'10%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\t\n\t </tr> \n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\tarrSubfuncins[cnt] = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\tarrSubfuncupd[cnt] = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\tarrSubfuncdel[cnt] = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\tarrSubfuncprn[cnt] = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\tarrSubfuncqry[cnt] = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\t\t\tcnt++;\n\t\t\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t   \n\n\t<tr>\n\t\t<td width = \'40%\' class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\t  \n\t\t<td width = \'10%\' class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' align=center><input type = \'checkbox\' name = \'subinc";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id = \'subinc";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value = \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" onClick=\"setValues(this);\"></td>\n\t\t<td width = \'10%\' class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' align=center><input type = \'checkbox\' name = \'subins";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id = \'subins";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onClick=\"setInsVals(this);\"></td>\n\t\t<td width = \'10%\' class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' align=center><input type = \'checkbox\' name = \'subupd";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id = \'subupd";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" value = \'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" onClick=\"setUpdVals(this);\"></td>\n\t\t<td width = \'10%\' class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' align=center><input type = \'checkbox\' name = \'subdel";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id = \'subdel";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" onClick=\"setDelVals(this);\"></td>\t   \n\t\t<td width = \'10%\' class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' align=center><input type = \'checkbox\' name = \'subqry";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id = \'subqry";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" onClick=\"setQryVals(this);\"></td>\n\t\t<td width = \'10%\' class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' align=center><input type = \'checkbox\' name = \'subprn";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id = \'subprn";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" onClick=\"setPrnVals(this);\"></td>\n\t\t<input type = \'hidden\' name = \'subfunctionid";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id = \'subfunctionid";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' value =\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t</tr>\t\n\t\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n</table>\t\t\t\n<input type = \'hidden\' name = \'Pval\' id = \'Pval\' value = \'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n</form>\n</body>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n</html>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rs= null;

	try
	{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		con = ConnectionManager.getConnection(request);
		StringBuffer sql	=new StringBuffer();
		
		
		String moduleId = request.getParameter("ModuleID");		if(moduleId == null) moduleId = "";
		String menuId   = request.getParameter("MenuID"); 		if(menuId == null) menuId = "";
		String funcId	= request.getParameter("FunctionID");	if(funcId == null) funcId = "";
		String functionVal = request.getParameter("FunctionVal");	
			if(functionVal == null) functionVal = "";

		String SubFunctionValues = request.getParameter("SubFunctionValues");	
			if(SubFunctionValues == null) SubFunctionValues = "";

		String 	insertyn = "";
		String 	deleteyn = "";
		String 	queryyn  = "";
		String 	printyn  = "";
		String 	updateyn = "";		
		
		String 	insertyn1 = "";
		String 	deleteyn1 = "";
		String 	queryyn1  = "";
		String 	printyn1  = "";
		String 	updateyn1 = "";		
		String  includeyn = "";
		
		String insert_disabled="disabled";
		String update_disabled="disabled";
		String delete_disabled="disabled";
		String query_disabled="disabled";
		String print_disabled="disabled";

		String include_checked="checked";
		String insert_checked="checked";
		String update_checked="checked";
		String delete_checked="checked";
		String query_checked="checked";
		String print_checked="checked";
		String disable_enable="";

		String 	menuid	 = "";
		String  optionsequenceno = "";
		String  functionid = "";
		String  subfunctionid = "";
		String  subfunctionVal = "";
		String  classValue = "";
		int p = 0;

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(functionVal));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

try
{
		 sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id, ");
		 sql.append(" a.module_id,a.insert_access_yn,a.update_access_yn,");
		 sql.append(" a.delete_access_yn,a.print_access_yn,a.query_only_access_yn, ");
		 sql.append(" a.subfunction_id, b.subfunction_name, a.incl_yn, ");
		 sql.append(" b.insert_access_yn, b.update_access_yn, ");
		 sql.append(" b.delete_access_yn, b.print_access_yn, b.query_only_access_yn ");
		 sql.append(" from sm_menu_sfunc_dtl a, sm_subfunction b where ");
		 sql.append(" a.module_id	=	b.parent_module_id and ");
		 sql.append(" a.function_id = b.parent_function_id and ");
		 sql.append(" a.subfunction_id = b.subfunction_id ");

	if (!(funcId.equals("")))
	{
		if (!moduleId.equals(""))
		{
			 sql.append(" and a.module_id = '"+moduleId+"' ");
			 sql.append(" and a.menu_id = '"+menuId+"' 	");
			 sql.append(" and a.function_id  = '"+funcId+"' ");
		}
		else if (moduleId.equals(""))
		{
			 sql.append(" and a.menu_id = '"+menuId+"' 	");
			 sql.append(" and a.function_id  = '"+funcId+"' ");
		}
	}

	pstmt = con.prepareStatement(sql.toString());
	rs = pstmt.executeQuery();
	int  i = 1;
	if(rs!=null)
	{
	   while(rs.next())
	   {
	   	p++;
	   	if ( i%2 == 0 )
			classValue="QRYEVEN";
		else
			classValue="QRYODD";
	   	
		menuid	 = rs.getString("menu_id");		
			if(menuid  == null) menuid = "";
		optionsequenceno = rs.getString("option_sequence_no");		
			if(optionsequenceno == null) optionsequenceno ="";	
	   	functionid = rs.getString("function_id");			
			if(functionid == null ) functionid ="";

		subfunctionid = rs.getString("subfunction_id");			
			if(subfunctionid  == null ) subfunctionid = "";
		subfunctionVal = rs.getString("subfunction_name");
			if(subfunctionVal  == null ) subfunctionVal = "";

			insertyn1    = rs.getString(13);
			  if(insertyn1  == null ) insertyn1 = "N";
			  else if(insertyn1.equals("Y")) insert_disabled="";
				  
			updateyn1    = rs.getString(14);
			  if(updateyn1  == null ) updateyn1 = "N";
			  else if(updateyn1.equals("Y")) update_disabled="";
				  
			deleteyn1    = rs.getString(15);
			  if(deleteyn1  == null ) deleteyn1 = "N";
			  else if(deleteyn1.equals("Y")) delete_disabled="";
				  
			printyn1     = rs.getString(16);
			  if(printyn1  == null ) printyn1 = "N";
			  else if(printyn1.equals("Y")) print_disabled="";
				  
			queryyn1     = rs.getString(17);
			  if(queryyn1  == null ) queryyn1 = "N"; 
			  else if(queryyn1.equals("Y")) query_disabled="";

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(insertyn1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(updateyn1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(deleteyn1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(printyn1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(queryyn1));
            _bw.write(_wl_block18Bytes, _wl_block18);

	if(SubFunctionValues.equals(""))
	{
		includeyn = rs.getString("incl_yn");
		  if(includeyn  == null ) includeyn = "N";
		  else if(includeyn.equals("Y")) { include_checked="checked";  disable_enable = "";   }
		  else if(includeyn.equals("N")) { include_checked="";  disable_enable = "Disabled";  }

		insertyn    = rs.getString(5);			
		  if(insertyn  == null ) insertyn = "N";
		  else if(insertyn.equals("Y")) insert_checked="checked";
		  else if(insertyn.equals("N")) insert_checked="";

	   	updateyn    = rs.getString(6);
	   	  if(updateyn  == null ) updateyn = "N";
		  else if(updateyn.equals("Y")) update_checked="checked";
		  else if(updateyn.equals("N")) update_checked="";
	   	  
	   	deleteyn    = rs.getString(7);
	   	  if(deleteyn  == null ) deleteyn = "N";
		  else if(deleteyn.equals("Y")) delete_checked="checked";
		  else if(deleteyn.equals("N")) delete_checked="";
	   	  
	   	printyn     = rs.getString(8);
	   	  if(printyn  == null ) printyn = "N";
		  else if(printyn.equals("Y")) print_checked="checked";
		  else if(printyn.equals("N")) print_checked="";
	   	  
	   	queryyn     = rs.getString(9);
	   	  if(queryyn  == null ) queryyn = "N"; 
		  else if(queryyn.equals("Y")) query_checked="checked";
		  else if(queryyn.equals("N")) query_checked="";
	}
	else
    {
			StringTokenizer stoken = new StringTokenizer(SubFunctionValues,"$");
			while(stoken.hasMoreTokens())
			{
				String subvalues = stoken.nextToken();
				StringTokenizer subtoken = new StringTokenizer(subvalues,"|");
				while(subtoken.hasMoreTokens())
				{
					 String subfunc = subtoken.nextToken();
					 if(subfunc.equals(subfunctionid))
					 {
						includeyn = subtoken.nextToken();
						  if(includeyn.equals("Y")) 
							  { include_checked="checked";  disable_enable = "";   }
						  else if(includeyn.equals("N")) 
							  { include_checked="";  disable_enable = "Disabled";  }

						insertyn = subtoken.nextToken();
						  if(insertyn.equals("Y")) insert_checked="checked";
						  else if(insertyn.equals("N")) insert_checked="";

						updateyn  = subtoken.nextToken();
						  if(updateyn.equals("Y")) update_checked="checked";
						  else if(updateyn.equals("N")) update_checked="";
						  
						deleteyn  = subtoken.nextToken();
						  if(deleteyn.equals("Y")) delete_checked="checked";
						  else if(deleteyn.equals("N")) delete_checked="";
						  
						queryyn   = subtoken.nextToken();
						  if(queryyn.equals("Y")) query_checked="checked";
						  else if(queryyn.equals("N")) query_checked="";

						printyn   = subtoken.nextToken();
						  if(printyn.equals("Y")) print_checked="checked";
						  else if(printyn.equals("N")) print_checked="";
					 }
				}
			}
    }
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(subfunctionVal));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(includeyn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(include_checked));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(insertyn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(insert_checked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_enable));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(insert_disabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(updateyn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(update_checked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_enable));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(update_disabled));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(p));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(deleteyn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(delete_checked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_enable));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(delete_disabled));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(p));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(p));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(queryyn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(query_checked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_enable));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(query_disabled));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(p));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(p));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(printyn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(print_checked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_enable));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(print_disabled));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(p));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(subfunctionid));
            _bw.write(_wl_block46Bytes, _wl_block46);
		
	i++;
	insert_disabled="disabled";
	update_disabled="disabled";
	delete_disabled="disabled";
	query_disabled="disabled";	
	print_disabled="disabled";
}
}      

}catch(Exception e ){out.println("Error "+e   );}

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(p));
            _bw.write(_wl_block48Bytes, _wl_block48);

}catch(Exception e){out.println(e);}
	finally 
	{ 
		if(rs != null)		rs.close();
		if(pstmt != null)	pstmt.close();

		if(con != null)
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block49Bytes, _wl_block49);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Function.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.SubFunctionName.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Include.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Insert.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Update.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.query.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.print.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
