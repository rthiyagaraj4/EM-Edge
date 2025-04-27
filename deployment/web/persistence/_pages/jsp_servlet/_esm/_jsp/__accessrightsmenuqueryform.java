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
import java.util.*;
import com.ehis.util.*;

public final class __accessrightsmenuqueryform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/AccessRightsMenuQueryForm.jsp", 1730788011500L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n<title> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eSM/js/AccessRightsMenuFunc.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction  PopVal()\n{\n\tparent.frames[1].location.href= \'../eSM/jsp/InpatientLookupQueryResult.jsp\'\t\t\n}\n\nasync function showSubfunctions(menuval,moduleval,funcid,funcval,rownum)\n{\n\t\tvar subfuncval = eval(\"document.forms[0].subfunctionvalues\"+rownum+\".value\");\n\t\t\n\t\t var dialogHeight= \"15\" ;\n\t\t var dialogWidth = \"40\" ;\n\t\t var dialogTop = \"300\" ;\n\t\t var dialogLeft = \"155\" ;\n\t\t var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";dialogTop:\" + dialogTop+\";dialogLeft:\" + dialogLeft+\";status=no;scroll=no\" ;\n         var arguments   = \"\" ;\n\t     var retVal = await window.showModalDialog(\"../../eSM/jsp/AccessRightsMenuSubFunc.jsp?MenuID=\"+menuval+\"&ModuleID=\"+moduleval+\"&FunctionID=\"+funcid+\"&FunctionVal=\"+funcval+\"&SubFunctionValues=\"+subfuncval,arguments,features);\n\n\t\tif(retVal != null)\t\n\t\t\teval(\"document.forms[0].subfunctionvalues\"+rownum).value = retVal;\n\t\telse\n\t\t\teval(\"document.forms[0].subfunctionvalues\"+rownum).value = \"\";\n}\n</script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"AccessRightsMenuQuery_Form\" id=\"AccessRightsMenuQuery_Form\" method=post  action=\'../../servlet/eSM.AccessRightsMenuFuncServlet\' target=\'messageFrame\' >\n\n<table border=\'1\' width=\'102%\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' >\n\t <tr>\n\t\t<th align=\'left\' width=\'45%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t<th align=\'center\' width=\'10%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\t\n\t </tr> \n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t   \n\t\t\t<tr>\n\t\t\t<td width = \'45%\' class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'><a href=\"javascript:showSubfunctions(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></td>\t  \n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<tr>\n\t\t\t<td width = \'45%\' class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\t  \n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<td width = \'10%\' class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' align=center><input type = \'checkbox\' name = \'ins";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value = \'Y\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="></td>\n\t\t<td width = \'10%\' class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' align=center><input type = \'checkbox\' name = \'upd";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' align=center><input type = \'checkbox\' name = \'del";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="></td>\t   \n\t\t<td width = \'10%\' class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' align=center><input type = \'checkbox\' name = \'qry";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' align=center><input type = \'checkbox\' name = \'prn";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="></td>\n\t\t\n\t\t<input type = \'hidden\' name = \'optionsequenceno";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value = \'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t<input type = \'hidden\' name = \'functionid";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t<input type = \'hidden\' name = \'menuid";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' \t   value = \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<input type = \'hidden\' name = \'subfunctionvalues";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value = \'\'>\n\t</tr>\t\t\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n</table>\t\t\t\n<input type = \'hidden\' name = \'Pval\' value = \'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n</form>\n</body>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</html>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

    Connection con=null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs=null;
	ResultSet rs1=null;

	try
	{
		request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		String menuVal 	 = request.getParameter("menuVal");		if(menuVal == null) menuVal = "";
		String moduleVal = request.getParameter("moduleVal");	if(moduleVal == null) moduleVal = "";
		String funcVal 	 = request.getParameter("funcVal");		if(funcVal == null) funcVal = "";
		String menuId    = request.getParameter("menuId"); 		if(menuId == null) menuId = "";

		String 	insertyn = "";
		String 	deleteyn = "";
		String 	queryyn  = "";
		String 	printyn  = "";
		String 	updateyn = "";		
	    int countdata=0;
		String 	insertyn1 = "";
		String 	deleteyn1 = "";
		String 	queryyn1  = "";
		String 	printyn1  = "";
		String 	updateyn1 = "";		
		
		String insert_disabled="disabled";
		String update_disabled="disabled";
		String delete_disabled="disabled";
		String query_disabled="disabled";
		String print_disabled="disabled";

		String insert_checked="checked";
		String update_checked="checked";
		String delete_checked="checked";
		String query_checked="checked";
		String print_checked="checked";

		String  functionVal = "";
		String 	menuid	 = "";
		String  module_id = "";
		String  optionsequenceno = "";
		String  functionid = "";
		String  classValue = "";
		StringBuffer  sql=new StringBuffer();
		String  subfunction_yn = "N";
		int p = 0;
		int rec_cnt = 0;

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	try
	{
		 if (!(funcVal.equals("")))
		 {
				if (!moduleVal.equals(""))
				{
					sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id, ");
					sql.append(" a.module_id,a.function_name,a.insert_access_yn,a.update_access_yn,");
					sql.append(" a.delete_access_yn,a.print_access_yn,a.query_only_access_yn, ");
					sql.append(" b.insert_access_yn,b.update_access_yn,b.delete_access_yn, ");
					sql.append(" b.print_access_yn,b.query_only_access_yn ");
					sql.append(" from sm_menu_dtl_vw a, sm_function b where 	");
					sql.append(" a.function_id=b.function_id and ");
					sql.append(" a.module_id = '"+ moduleVal+"' ");
					sql.append(" and a.menu_id = '"+menuId+"' 	");
					sql.append(" and upper(a.FUNCTION_NAME) like upper(('"+funcVal+"%') )");
				}
				else if (moduleVal.equals(""))
				{
					sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id, ");
					 sql.append(" a.module_id,a.function_name,a.insert_access_yn,a.update_access_yn,");
					 sql.append(" a.delete_access_yn,a.print_access_yn,a.query_only_access_yn, ");
					 sql.append(" b.insert_access_yn,b.update_access_yn,b.delete_access_yn, ");
					 sql.append(" b.print_access_yn,b.query_only_access_yn ");
					 sql.append(" from sm_menu_dtl_vw a, sm_function b where 	");
					 sql.append(" a.function_id=b.function_id  ");
					 sql.append(" and a.menu_id = '"+menuId+"' 	");
					 sql.append(" and upper(a.FUNCTION_NAME) like upper(('"+funcVal+"%') )");
				 }
		 }
		 else if(funcVal.equals(""))
		{
				if (!moduleVal.equals(""))
				{
					 sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id, ");
					 sql.append(" a.module_id,a.function_name,a.insert_access_yn,a.update_access_yn,");
					 sql.append(" a.delete_access_yn,a.print_access_yn,a.query_only_access_yn, ");
					 sql.append(" b.insert_access_yn,b.update_access_yn,b.delete_access_yn, ");
					 sql.append(" b.print_access_yn,b.query_only_access_yn ");
					 sql.append(" from sm_menu_dtl_vw a, sm_function b where 	");
					 sql.append(" a.function_id=b.function_id and ");
					 sql.append(" a.module_id = '"+ moduleVal+"' ");
					 sql.append(" and a.menu_id = '"+menuId+"' 	");
				}
				else
				{
					sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id, ");
					sql.append(" a.module_id,a.function_name,a.insert_access_yn,a.update_access_yn,");
					sql.append(" a.delete_access_yn,a.print_access_yn,a.query_only_access_yn, ");
					sql.append(" b.insert_access_yn,b.update_access_yn,b.delete_access_yn, ");
					sql.append(" b.print_access_yn,b.query_only_access_yn ");
					sql.append(" from sm_menu_dtl_vw a, sm_function b where 	");
					sql.append(" a.function_id=b.function_id  ");
					sql.append(" and a.menu_id = '"+menuId+"' 	");
				}
		}

		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();

		pstmt1 = con.prepareStatement("Select count(*) from SM_MENU_SFUNC_DTL WHERE MODULE_ID = '"+module_id+"' and MENU_ID = '"+menuid+"' and OPTION_SEQUENCE_NO = '"+optionsequenceno+"' and FUNCTION_ID= '"+functionid+"' ");	
			rs1 = pstmt1.executeQuery();
		int  i = 1;
		if(rs!=null)
		{
			out.println("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AccessRightsForMenuFunctions.label","sm_labels")+"</b>");
		   while(rs.next())
		   {countdata=1;
				p++;
				if ( i%2 == 0 )
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
				
				menuid	 = rs.getString(1);
				if(menuid  == null) menuid = "";
				
				optionsequenceno = rs.getString(2);
				if(optionsequenceno == null) optionsequenceno ="";	
				
				functionid = rs.getString(3);
				  if(functionid == null ) functionid ="";
			   
				module_id = rs.getString(4);
				  if(module_id == null ) module_id ="";

				functionVal = rs.getString(5);
				  if(functionVal  == null ) functionVal = "";
	   	  
			  insertyn    = rs.getString(6);
				if(insertyn  == null ) insertyn = "";
				else if(insertyn.equals("Y")) insert_checked="checked";
				else if(insertyn.equals("N")) insert_checked="";

				updateyn    = rs.getString(7);
				  if(updateyn  == null ) updateyn = "";
				  else if(updateyn.equals("Y")) update_checked="checked";
				  else if(updateyn.equals("N")) update_checked="";
				  
				deleteyn    = rs.getString(8);
				  if(deleteyn  == null ) deleteyn = "";
				  else if(deleteyn.equals("Y")) delete_checked="checked";
				  else if(deleteyn.equals("N")) delete_checked="";
				  
				printyn     = rs.getString(9);
				  if(printyn  == null ) printyn = "";
				  else if(printyn.equals("Y")) print_checked="checked";
				  else if(printyn.equals("N")) print_checked="";
				  
				queryyn     = rs.getString(10);
				  if(queryyn  == null ) queryyn = ""; 
				  else if(queryyn.equals("Y")) query_checked="checked";
				  else if(queryyn.equals("N")) query_checked="";

				insertyn1    = rs.getString(11);
				  if(insertyn1  == null ) insertyn1 = "";
				  else if(insertyn1.equals("Y")) insert_disabled="";
				  
				updateyn1    = rs.getString(12);
				  if(updateyn1  == null ) updateyn1 = "";
				  else if(updateyn1.equals("Y")) update_disabled="";
				  
				deleteyn1    = rs.getString(13);
				  if(deleteyn1  == null ) deleteyn1 = "";
				  else if(deleteyn1.equals("Y")) delete_disabled="";
				  
				printyn1     = rs.getString(14);
				  if(printyn1  == null ) printyn1 = "";
				  else if(printyn1.equals("Y")) print_disabled="";
				  
				queryyn1     = rs.getString(15);
				  if(queryyn1  == null ) queryyn1 = ""; 
				  else if(queryyn1.equals("Y")) query_disabled="";

			

			if(rs1.next())
				rec_cnt = rs1.getInt(1);

			if(rec_cnt > 0)
				subfunction_yn = "Y";
			else
				subfunction_yn = "N";

		if(subfunction_yn.equals("Y"))
		{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(menuid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(functionid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(functionVal));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(functionVal));
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
		else
		{
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(functionVal));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(insert_checked));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(insert_disabled));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(update_checked));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(update_disabled));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(delete_checked));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(delete_disabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(query_checked));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(query_disabled));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(print_checked));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(print_disabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(optionsequenceno ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(functionid));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(menuid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p));
            _bw.write(_wl_block36Bytes, _wl_block36);
		
		i++;
		insert_disabled="disabled";
		update_disabled="disabled";
		delete_disabled="disabled";
		query_disabled="disabled";	
		print_disabled="disabled";
		}
		}
		if(countdata==0)
		{
	 	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[1].document.location.href='../../eCommon/html/blank.html'</script>");
		}

	}catch(Exception e ){//out.println("Error "+e   );
		e.printStackTrace();
	}

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(p));
            _bw.write(_wl_block38Bytes, _wl_block38);


	if(rs != null)		rs.close();
	if(rs1 != null)		rs1.close();
	if(pstmt != null)	pstmt.close();
	if(pstmt1 != null)	pstmt1.close();


}catch(Exception e){//out.println(e);
	e.printStackTrace();
}
finally 
{ 
if(con != null)
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block39Bytes, _wl_block39);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.AccessRightsforMenu.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FunctionName.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Insert.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Update.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.query.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.print.label", java.lang.String .class,"key"));
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
}
