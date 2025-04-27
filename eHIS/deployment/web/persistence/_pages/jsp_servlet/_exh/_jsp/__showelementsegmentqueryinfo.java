package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import eXH.*;
import eXH.XHDBAdapter;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __showelementsegmentqueryinfo extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ShowElementSegmentQueryInfo.jsp", 1709122392209L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>Data Source Mapping ? Configname</title>\n<script language=\"javascript\">\n\nfunction getTables() \n{\n//\talert(\"getTables\");\n//\talert(\"getTables() Modl Val : \"+document.forms[0].module_name.value);\n\tvar m_name = document.forms[0].module_name.value;\tdocument.queryInfo.action=\'../../eXH/jsp/ShowElementSegmentQueryInfo.jsp?mdl_name=\"\'+m_name+\'\"\';\n\tdocument.queryInfo.submit();\n}\n\nfunction getColumns()\n{\n//\talert(\"getColumns\");\n//\talert(\"getCols() tabl Val : \"+document.forms[0].table_name.value);\n\tvar t_name = document.forms[0].table_name.value;\tdocument.queryInfo.action=\'../../eXH/jsp/ShowElementSegmentQueryInfo.jsp?tabl_name=\"\'+t_name+\'\"\';\n\tdocument.queryInfo.submit();\n}\t\t\t\t\t\t\t\t\t\t    \n\nvar flag = 0;\nvar sgmnt1 = \"\";\nvar colTxt = \"\";\nvar qryText = \"\";\nvar colcount =0;\n\nfunction addColumn()\n{\n//     alert(document.forms[0].segment_type.value);\n//\t var sgmnt_type = document.forms[0].segment_type.value;\n//\t sgmnt1 = \"SELECT \'\"+sgmnt_type+\"\'#\";\n\t var slctd_Col  = document.forms[0].column_name.value;\n\t var slctd_Cols = document.forms[0].selectedCols.value;\n\t colTxt = colTxt+\"#\"+slctd_Col;\n\t colcount++;\n//\t alert(\"slctd_Cols : \"+slctd_Cols);     \n\t document.forms[0].selectedCols.value = slctd_Cols+\",\"+slctd_Col;\n}\n\nfunction slctColumn()\n{\n //\t alert(document.forms[0].column_name.value);\n\t if(flag!=1){\n\t\t var slctd_Col  = document.forms[0].column_name.value;\n\t\t var slctd_Cols = document.forms[0].selectedCols.value;\n//\t\t alert(\"slctd_Cols : \"+slctd_Cols);\n\t\t flag = 1;\n\t     colcount++;\n\t\t document.forms[0].selectedCols.value = slctd_Col;\n\t\t colTxt = slctd_Col;\n\t }\n\t else{\n\t\t document.forms[0].add.disabled = false;\n\t }\n}\n\nfunction getQuery()\n{\n//\talert(\"getQuery\");\n\tvar slctdColumns  = document.forms[0].selectedCols.value;\n//\talert(\"slctdColumns : \"+slctdColumns);\n\tvar slctdtbl_name = document.forms[0].table_name.value;\n//\talert(\"slctdtbl_name : \"+slctdtbl_name);\n\tvar slctdwhrcol   = document.forms[0].whrcolumn_name.value;\n\tvar slctdwhrcond  = document.forms[0].where_cond.value;\n\tvar slctdwhrtxt   = document.forms[0].whr_text.value;\n\tvar whrclause\t  = \" \\nWHERE \"+slctdwhrcol+slctdwhrcond+\"\'\"+slctdwhrtxt+\"\'\";\n\tvar qryResult = \"SELECT \"+slctdColumns+\" \\nFROM \"+slctdtbl_name+whrclause;\n\talert(\"getQuery qryResult :\"+qryResult);\n\tdocument.forms[0].QueryResult.value = qryResult;\n    var sgmnt_type = document.forms[0].segment_type.value;\n\tsgmnt1 = \"SELECT \'\"+sgmnt_type+\"\'#\";\n\tqryText = sgmnt1+colTxt+\"\\nFROM \"+slctdtbl_name+whrclause;\t\n\talert(\"getQuery qryText : \"+qryText);\n}\n\nfunction validateQry()\n{  \n//\treturn qryText;\n\talert(\"qryText : \"+qryText);\n\talert(\"selected Col Count : \"+colcount);\n\tvar begnStr = \":PID[\";\n\tvar endStr1 = \"]\";\n\tvar endStr2 = \"|\";\n\tvar SystDefStructure = \"\";\n\tvar sgmnt  = \"\";\n\n\tfor(var i=1;i<=colcount;i++){\n\t\tif(i==1){\n\t\t\tsgmnt = begnStr+i+endStr1;\n\t\t}\n\t\telse{\n\t\t\tsgmnt = endStr2+begnStr+i+endStr1;\n\t\t}\n\t\tSystDefStructure = SystDefStructure+sgmnt;\n\t}\n\n\tvar qResult =  document.forms[0].QueryResult.value;\n\talert(\"qResult : \"+qResult);\n\t\n\talert(\"SystDefStructure : \"+SystDefStructure);\n\n/*\n\tdocument.forms[0].qryText.value = qryText;\n\tdocument.forms[0].SystDefStructure.value = SystDefStructure;\n\tdocument.queryInfo.submit();\n\n\t*/\n\n\t//document.queryInfo.action=\n\tlocation.href = \'../../eXH/jsp/ElementSegmentValidateQry.jsp?qResult=\'+qResult;\n\t\t\n\t//document.queryInfo.submit();\n\n\n//\tparent.Element_Segment_Configuaration.query_text.value = qryText;\n//\twindow.close();\n}\n\nfunction retVal(){\n\talert(\"Ret Val : \");\n}\n\n//function setValues\nfunction setValues()\n{    \n\talert(\"setValues\");\n\tvar qryResult = document.forms[0].qryResult.value;\n\talert(\"qryResult : \"+qryResult);\n\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n</head>\n<body>\n<!-- onLoad=\"setValues();\" -->\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\n<form name=\"queryInfo\" id=\"queryInfo\" >\n<table cellspacing=0 cellpadding=1 width=\'100%\' align=center>\n\t<tr>\n\t\t<td class=label>Domain Name </td>\n\t\t<td colspan=3 class=\'fields\'>\n\t\t\t<SELECT name=\"module_name\" id=\"module_name\" onChange=\'getTables();\' >\n\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="--------</option>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<option value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" > ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </option>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</SELECT>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=label>Entity Name </td>\n\t\t<td colspan=3 class=\'fields\'>\n\t\t\t<SELECT name=\"table_name\" id=\"table_name\" onChange=\'getColumns();\'>\n\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<!--\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="--------</option> -->\n\t\t\t   ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</SELECT>\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td class=label>Field  </td>\n\t\t<td class=\'fields\'>\n\t\t\t<SELECT name=\"column_name\" id=\"column_name\" onchange=\'slctColumn();\'>\n\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="--------</option>\n\t<!-- \t\t<option value=\'\'>ROWNUM</option> -->\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" > ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t</SELECT>\n\n\t\t</td>\n\n\t<td colspan=2 class=\'BUTTON\'>\n\t\t<input class=\'button\' type=\"button\" disabled name=\'add\' id=\'add\' value=\'Add Field\' onclick=\'addColumn();\' >\n\t</td>\n\n\t</tr>\n\n\t<tr>\n\t<td></td>\n\t<td colspan=3>\n\t<textarea name=\'selectedCols\' rows=5 cols=60 > </textarea>\n\t</td>\t\n\t</tr>\n\n\t<tr>\n\t\t<td class=label>Input </td>\n\t\t<td class=\'fields\'>\n\t\t\t<SELECT name=\"whrcolumn_name\" id=\"whrcolumn_name\" onchange=\'\'>\n\t\t\t\t<option value=\'\'>----------";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t</SELECT>\n\n\t\t</td>\n\n<td class=\'fields\'>\n<select class=\'select\' name=where_cond onChange=\'\' >\n\t<option value=\'\'>----------";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="--------</option>\n\t<option value=\'=\' >Equal To</option>\n\t<option value=\'<>\' >Not Equal To</option>\n\t<option value=\'LIKE\' >Like</option>\n\t<option value=\'BETWEEN\' >Between</option>\n</select>\t\n</td>\n\n<td class=\'fields\'>\n<input type=text name=whr_text size=20 value=\'\' >\n</td>\n\n\t</tr>\n\n\t<tr>\n\t<td colspan=3> </td>\n\t<td class=\'BUTTON\'>\n\t\t<input class=\'button\' type=\"button\"  name=\'Query\' id=\'Query\' value=\'Query\' onclick=\'getQuery();\' >\n\t</td>\n\t</tr>\n\n\t<tr>\n\t<td></td>\n\t<td colspan=3>\n\t<textarea name=\'QueryResult\' rows=8 cols=80 >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </textarea>\n\t</td>\t\n\t</tr>\n\n\n\t<tr>\n\t<td colspan=3> </td>\n\t<td class=\'BUTTON\'>\n\t\t<input class=\'button\' type=\"button\"  name=\'Validate\' id=\'Validate\' value=\'Validate\' onclick=\'validateQry();\' >\n\t</td>\n\t</tr>\n\n\t<tr>\n\t<td class=label>Query Error </td>\n\t<td colspan=3>\n\t<textarea name=\'qryError\' rows=4 cols=80 >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" </textarea>\n\t</td>\t\n\t</tr>\n\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t<input type=\"hidden\" name=\"tabl_name\" id=\"tabl_name\" value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t<input type=\"hidden\" name=\"mdl_name\" id=\"mdl_name\" value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t<input type=\"hidden\" name=\"segment_type\" id=\"segment_type\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t<input type=\"hidden\" name=\"qryText\" id=\"qryText\" value=\'\'>\n\t<input type=\"hidden\" name=\"SystDefStructure\" id=\"SystDefStructure\" value=\'\'>\n\t<input type=\"hidden\" name=\"qryResult\" id=\"qryResult\" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String qryError=XHDBAdapter.checkNull(request.getParameter("message"));
String qryResult=XHDBAdapter.checkNull(request.getParameter("QueryResult"));

Connection connection = null;
ResultSet resultSet = null;
ResultSet resultSet1 = null;
ResultSet resultSet2 = null;
//ResultSet resultSet3 = null;
Statement statement = null;
//ResultSet rs = null;
connection = ConnectionManager.getConnection(); 
String qryModules = "select 'CR' from dual union SELECT distinct module_id FROM sm_function";
String segment_type = XHDBAdapter.checkNull(request.getParameter("segment_type"));
statement = connection.createStatement();
//resultSet = statement.executeQuery(query);
resultSet1 = statement.executeQuery(qryModules);


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 
			String mdl_name = XHDBAdapter.checkNull(request.getParameter("module_name"));
			while(resultSet1.next())
			{
				String mod_name = (resultSet1.getString(1));
		//		System.out.println("Mod Name : "+mod_name);
				String selected = (String)(request.getParameter("module_name"));
				out.println("SELECTED "+selected);
				if(selected != null && selected.equalsIgnoreCase(mod_name))
					selected = "selected";
				else
					selected = ""; 
	
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mod_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( selected ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mod_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 
			
			String modParam = mdl_name+"%";
	//		System.out.println("Selected modParam Value "+modParam);

			if(mdl_name.equals("")){
					//System.out.println("Selected Mod_Name "+mdl_name);
				
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			   }
			   else{

String query = "select object_name from user_objects where object_type='Table'";
//System.out.println("modParam : "+modParam);
//String query = "select OBJECT_NAME from user_objects where object_name LIKE '"+modParam+"' and (object_type='TABLE' OR object_type='VIEW')";

//System.out.println("query : "+query);


  DatabaseMetaData dbmd = connection.getMetaData();
  //    resultSet2 = dbmd.getTables(null, null,"XH%", new String[]{"TABLE"});
  resultSet2 = dbmd.getTables(null, null,modParam, new String[]{"TABLE"});

  statement = connection.createStatement();
  resultSet = statement.executeQuery(query);
 
 // resultSet3 = statement.executeQuery(queryCols);

			while(resultSet2.next())
			{
				String tbl_name = (resultSet2.getObject(3)).toString();
		//		String tbl_name = resultSet2.getString(1);
		//		System.out.println("qry rslt tbl_name : "+tbl_name);
				String selected = (String)(request.getParameter("table_name"));
				out.println("SELECTED "+selected);
				if(selected != null && selected.equalsIgnoreCase(tbl_name))
					selected = "selected";
				else
					selected = "";
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tbl_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( selected ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(tbl_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
			   }
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 
			String tabl_name = XHDBAdapter.checkNull(request.getParameter("table_name"));
	//			List columnNames = null;
	//		    System.out.println("Selected Table_Name "+tabl_name);
			   if(tabl_name.equals("")){
	//				System.out.println("Selected Table_Name "+tabl_name);
				
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			   }
			   else{
			   String queryCols="SELECT * from "+tabl_name;
			
			   resultSet=statement.executeQuery(queryCols);

			   ResultSetMetaData rsmd = resultSet.getMetaData();
	           int col = rsmd.getColumnCount();
	
		    for (int i=1; i <= col; i++){
			  String col_name = rsmd.getColumnName(i);
			
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(col_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(col_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
			
			   }
		
			
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 
				String tabl_name2 = XHDBAdapter.checkNull(request.getParameter("table_name"));
			   if(tabl_name2.equals("")){
			
			   }
			   else{
			   String queryCols="SELECT * from "+tabl_name;
			
			   resultSet=statement.executeQuery(queryCols);

			   ResultSetMetaData rsmd = resultSet.getMetaData();
	           int col = rsmd.getColumnCount();
	
		    for (int i=1; i <= col; i++){
			  String col_name = rsmd.getColumnName(i);
	
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(col_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(col_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
			
			   }
		
			
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(qryResult));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(qryError));
            _bw.write(_wl_block25Bytes, _wl_block25);


	ConnectionManager.returnConnection(connection);
	if(statement != null) statement.close();
	if(resultSet1 != null) resultSet1.close();
	response.getWriter().write("Test Success");
	
	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(tabl_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mdl_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(qryResult));
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Select.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Select.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Select.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Select.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Select.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Select.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Select.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
