package jsp_servlet._ebt._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __ebtlookupbody extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/EBTLookupBody.jsp", 1742377570278L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<title> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n <base target=\"_self\">\n\t  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<Script Language=\"JavaScript\" src=\"../../eBL/js/BLAmount.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script Language=\"JavaScript\">\n\tfunction funCurrencyFormat()\n\t{\n\t\ttry\n\t\t{\n\t\t\tvar ids = document.getElementById(\'currency_id\');\n\t\t\tif (ids.length ==\tnull)\n\t\t\t{\n\t\t\t\tcurrencyTableFormat(ids);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\n\t\t\t\tfor(i=0;i<ids.length;i++)\n\t\t\t\t{\n\t\t\t\t\tcurrencyTableFormat(ids[i]);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tcatch(e)\n\t\t{\n\t\t}\n\t}\n\tfunction submitFormN()\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from + maxval;\n\t\tdocument.forms[0].to.value = to + maxval;\n\t\tdocument.forms[0].submit();\n\t}\n\tfunction submitFormP()\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from - maxval;\n\t\tdocument.forms[0].to.value = to - maxval;\n\t\tdocument.forms[0].submit();\n\t}\n\n\t// 48569 Sandeep K Gujje 14-APR-2014\n\tfunction ReplaceAll(Source,stringToFind,stringToReplace)\n\t{\n\t\tvar temp = Source;\n\t\tvar index = temp.indexOf(stringToFind);\n\t\twhile(index != -1)\n\t\t{\n\t\t\ttemp = temp.replace(stringToFind,stringToReplace);\n\t\t\tindex = temp.indexOf(stringToFind);\n\t\t}\n\t\treturn temp;\n\t}\n\n\n\tfunction closew(Dcode)\n\t  {\n  \t\twhile(Dcode.indexOf(\"+\")!=-1)\n\t\t\tDcode=Dcode.replace(\'+\',\" \");\n\t\n\t\t// 48569 Sandeep K Gujje 14-APR-2014\n\t\tDcode=ReplaceAll(Dcode,\'~\',\' \'); \n\n\t\tparent.window.returnValue = Dcode;\n\t\tparent.window.close();\t\n\t\t//return(Dcode);\n\t  }\n </script>\n\n\n</head>\n<body>\n\n\n<form name=\'form_query\' id=\'form_query\' method=\'post\' action=\'EBTLookupBody.jsp\'>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<table align=\'center\' width=\'100%\'>\n\t\t<tr>\n\t\t<td align=\'right\'>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\n\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\n\t\n\t\n\t\t\n\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\'hidden\' name=\'search_criteria\' id=\'search_criteria\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\'hidden\' name=\'search_by_index\' id=\'search_by_index\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t<input type=\'hidden\' name=\'search_text\' id=\'search_text\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=\'hidden\' name=\'column_names\' id=\'column_names\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=\'hidden\' name=\'column_sizes\' id=\'column_sizes\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\'hidden\' name=\'column_types\' id=\'column_types\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=\'hidden\' name=\'column_descriptions\' id=\'column_descriptions\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\'hidden\' name=\'sql_pass_back\' id=\'sql_pass_back\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\'hidden\' name=\'max_records\' id=\'max_records\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=\'hidden\' name=\'sql_order_by\' id=\'sql_order_by\'  value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n</form>\n</body>\n</html>\n\t\n\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
 
 String encode(String data,String loc)
 {
	  
	  String outDat = replace(data,loc); 
	  byte byteData[] = outDat.getBytes();
		
   	if(loc.equals("en")==true)
	 {
		outDat = "";
	   for (int i=0; i<byteData.length; i++)
	  {
	
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
	 }

		return(outDat);
 }



	String replace(String data,String loc)
	{
		char strRep = '`';
		String strSpecial = "";

		// 48569 Sandeep K Gujje 14-APR-2014 // Commented and added strSpecial without any space
		strSpecial = "\f\n\r\t\'\"\\";
		/*
		   	if(loc.equals("en")==true)
					strSpecial = "\f\n\r\t\'\"\\";
			else 	
				strSpecial = " \f\n\r\t\'\"\\";
		*/

		char charArray[] = strSpecial.toCharArray();
		String strOutData = data;
		for (int i =0;i<charArray.length;i++)
		{
			strOutData = strOutData.replace(charArray[i],strRep);
		}

		// 48569 Sandeep K Gujje 14-APR-2014
		strOutData = strOutData.replace(' ', '~');

		return(strOutData);
	}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( request.getParameter("title")));
            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
 String locale = ((String)session.getAttribute("LOCALE"));
            _bw.write(_wl_block10Bytes, _wl_block10);

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String strColumnDelimiter = ",";
		String userWhereClause = "";
		String SQL = "";
		String sqlWithColumnsOnly = "";
		//String sqlActualWithColumnsOnly = "";
		String strWhereColumn = "";
		String strWhereColumnType = "";
		//String sqlFifteenRecords = "";
		//String sqlGroupBy = "";
		String sql_pass_back = "";
		String sql_order_by = "";

		int max_records = 15;		
		int intTotalColumns = 0;
		//int intGroupIndex = 0;
		//int intGroupByIndex = 0;

		int j = 0;
		int i = 0;
		ArrayList vectorColumnNames = new ArrayList();
		ArrayList vectorColumnSizes = new ArrayList();
		ArrayList vectorColumnDescriptions = new ArrayList();
		ArrayList vectorColumnTypes = new ArrayList();
		ArrayList vectorHtmlData = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;
		try
		{

			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ? 15:Integer.parseInt(request.getParameter("max_records"));

			String sql = request.getParameter("sql");
			sql = (sql == null) ? "":sql;

			//eBT.LogFile.log("BTDebugger","sql value"+sql,this);

			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;


//			eQA.LogFile.log("dhana",sql,this);		

	
			boolean calling_from_main =  true;
			if ( (from == null) && ( to == null) )
			{
				calling_from_main = true;
			}
			else
			{
				calling_from_main = false;
			}
			from = (from == null) ? "0":from;
			to = (to == null) ? max_records+"":to;

			String search_criteria = request.getParameter("search_criteria");
			search_criteria = (search_criteria == null) ? "":search_criteria;

			String search_by_index = request.getParameter("search_by_index");
			search_by_index = (search_by_index == null) ? "0":search_by_index;
			int int_search_by_index = Integer.parseInt(	search_by_index);
			
			String search_text = request.getParameter("search_text");
			search_text = (search_text == null) ? "%":search_text;

			String search_by = 	request.getParameter("search_by");
			search_by = (search_by == null) ? "":search_by;

			String column_names = request.getParameter("column_names");
			column_names = (column_names == null) ? "":column_names;

			String column_sizes = request.getParameter("column_sizes");
			column_sizes = (column_sizes == null) ? "":column_sizes;

			String column_types = request.getParameter("column_types");
			column_types = (column_types == null) ? "":column_types;

			String column_descriptions = request.getParameter("column_descriptions");
			column_descriptions = (column_descriptions == null) ? "":column_descriptions;

			StringTokenizer strTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
			i =0;

			try{
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnNames.add(i, " "+strTokenizer.nextToken());
				++i;
			}
			intTotalColumns = i;
			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);

			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnSizes.add(i, strTokenizer.nextToken());
				++i;
			}

			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_types,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnTypes.add(i, strTokenizer.nextToken());
				++i;
			}
			strTokenizer = null;

			strTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
				vectorColumnDescriptions.add(i, strTokenizer.nextToken());
				++i;
			}
			strTokenizer = null;
			SQL = sql.toUpperCase();
			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";
			
			//sqlFifteenRecords = " and rownum between "+from+" and  " +to +"";

			if(calling_from_main == true)
			{
				sql = sql.replace('`','\'') ;

				//intGroupIndex = SQL.lastIndexOf(" GROUP");
				
				//sqlGroupBy = " ";
				/*
				if (intGroupIndex > 0)
				{
					//intGroupByIndex = SQL.indexOf(" BY",intGroupIndex);
					//debug("intGroupByIndex="+intGroupByIndex);
					//if (intGroupByIndex >0)
					//{
						//sqlGroupBy = sql.substring(intGroupIndex);
						//sql = sql.substring(0,intGroupIndex);
						
					//}
				}
				*/
				//debug("sqlGroupBy="+sqlGroupBy);
				//debug("sql="+sql);
				j = SQL.indexOf(" WHERE");
				//debug("SQL="+SQL);
		
				if(j <0)
				 sql= sql +" where (1=1) and ";
				if(j > 0)
				{		
					String sqlTemp = sql.substring(0,j+6);
					String sqlWhere = sql.substring(j+6);
					sqlWhere = " ( " + sqlWhere +" ) and ";
					sql = sqlTemp + sqlWhere;
				}
				i = 0;
				j = 0;
				i = SQL.indexOf("SELECT");
				j = SQL.indexOf(" FROM");
				sqlWithColumnsOnly = SQL.substring(i+7,j);
				//sqlActualWithColumnsOnly = sql.substring(i+7,j);
				
			
		
				//debug("sqlWithColumnsOnly="+sqlWithColumnsOnly);
				//debug("int_search_by_index ="+int_search_by_index );
	

				if (int_search_by_index >0)
				{
					String strTempSelectedColumn = (String)vectorColumnNames.get(int_search_by_index);
					//debug("strTempSelectedColumn="+strTempSelectedColumn);
					String strTempPreviousColumn = (String)vectorColumnNames.get(int_search_by_index-1);
					//debug("strTempPreviousColumn ="+strTempPreviousColumn );
					int intTempSelectedIndex = sqlWithColumnsOnly.indexOf(strTempSelectedColumn);

					//debug("intTempSelectedIndex = "+intTempSelectedIndex);

					int intTempPreviousIndex = sqlWithColumnsOnly.indexOf(strTempPreviousColumn);
					//debug("intTempPreviousIndex = "+intTempPreviousIndex);
					int intCommaIndex = sqlWithColumnsOnly.indexOf(",",intTempPreviousIndex+1);
					//debug("intCommaIndex = "+intCommaIndex);

					strWhereColumn = sqlWithColumnsOnly.substring(intCommaIndex+1,intTempSelectedIndex);
					//debug("strWhereColumn = "+strWhereColumn);
				}
				else
				{
					String strTempColumn = (String) vectorColumnNames.get(int_search_by_index);
					//debug("strTempColumn = "+strTempColumn);
					int intTempIndex = sqlWithColumnsOnly.indexOf(strTempColumn );
					//debug("intTempIndex = "+intTempIndex);
					strWhereColumn = sqlWithColumnsOnly.substring(0,intTempIndex);
					//debug("strWhereColumn = "+strWhereColumn);
				}
				strWhereColumn = strWhereColumn.trim();
				int intTempWhereColumnLen = strWhereColumn.length();
				String strTempSpace = " ";
				String strTempQuote = "'";
				String strTempComma =",";
				i = 0;
				i = strWhereColumn.indexOf(strTempSpace);
				if ((i>0) && (int_search_by_index == 0))
				{
					j = 0;
					j = strWhereColumn.indexOf(strTempQuote);
					if (j<0)
					{
						j = strWhereColumn.indexOf(strTempComma);
						if (j<0)
						{
							strWhereColumn = strWhereColumn.substring(i,intTempWhereColumnLen);
						}
							
					}
					

				}

				strWhereColumnType = (String) vectorColumnTypes.get(int_search_by_index);
				//debug("strWhereColumnType = "+strWhereColumnType);
				if (strWhereColumnType.equalsIgnoreCase("VARCHAR2"))
				{
					if(search_criteria.equals("S"))
					{
						search_text = search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?) ";
					}
					else if(search_criteria.equals("E"))
					{
						search_text = "%" + search_text;
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?)";
					}
					else if(search_criteria.equals("C"))
					{
						search_text = "%" + search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?)";
					}
				}
				else
				{
					userWhereClause = "( ceil( "+strWhereColumn+ ") like ceil(?)";
				}
				sql = sql + userWhereClause;
				sql = sql + " )";
				sql_pass_back = sql;
				sql_order_by = " order by "+(int_search_by_index+1);
				for (int l = 1;l<=intTotalColumns ; l++ )
				{
					if (l != (int_search_by_index+1))
					{
						sql_order_by = sql_order_by +"," +l;
					}
				}
			}
			else
			{
				sql_pass_back = request.getParameter("sql_pass_back");
				sql_order_by = request.getParameter("sql_order_by");
				sql = sql_pass_back;
			}
			sql = sql+ " "+sql_order_by;
			//sqlFifteenRecords;
		//eBT.LogFile.log("BTDebugger","SQL debug1"+sql,this);
		}catch(Exception ee)
		{
			sql = request.getParameter("sql");	
			search_text="";
			//eBT.LogFile.log("BTDebugger","Exception "+ee,this);

		}




		
            _bw.write(_wl_block11Bytes, _wl_block11);

			try
			{
				String row = "<tr style='background-color:;'>";
				String evn = "<td class='QRYEVEN'";
				String odd = "<td class='QRYODD'";
				String strStartLink = "<a href=javascript:closew('";
				String strEndLink = "')>";
				String strHtmlData = "";
				String strData = "";
				String strLinkData = "";
				String strSpecialData = "";


				String strTempColumnType = "VARCHAR2";

				String strTempColumnName = "";
				String strIDCurrency = " id='currency_id' ";
				String strSpecialIDCurrency = " id='currency_id' ";
				String strAlign = "align = 'right'";
				String strSpecialAlign = "align = 'right'>";
				
				int intArrayListTrace = 0;
				int intTempStart = start;
				

				//eBT.LogFile.log("BTDebugger","SQL debug"+sql,this);

				pstmt = conn.prepareStatement(sql);
			if(search_text.length()!=0)
				pstmt.setString(1,search_text);
				rs = pstmt.executeQuery();
				
				vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1'>");

				

				for (int l = 0;l<intTotalColumns ; l++ )
				{

					strTempColumnType = (String) vectorColumnTypes.get(l);

					if (strTempColumnType.equalsIgnoreCase("VARCHAR2"))
					{
						strAlign = "align = 'left'";
					}
					else
					{
						strAlign = "align = 'right'";

					}

					if (l == int_search_by_index)
					{
						strSpecialData = "<td class='COLUMNHEADER' width='"+(String)vectorColumnSizes.get(l)+"'  "+strAlign +" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,""+(String)(String)vectorColumnDescriptions.get(l),"bt_labels")+"</td>";

					}
					else
					{
						vectorHtmlData.add("<td class='COLUMNHEADER' width='"+(String)vectorColumnSizes.get(l)+"'  "+ strAlign +" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,""+(String)(String)vectorColumnDescriptions.get(l),"bt_labels")+"</td>");
					}

				}	
				vectorHtmlData.add(1,strSpecialData);
			
				while(rs.next())
				{
					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
					vectorHtmlData.add(row);					
					intArrayListTrace = vectorHtmlData.size();
					for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace)
					{
						strData = rs.getString(intTrace);

						strLinkData = strLinkData + strData+ "::" ;

						strTempColumnType = (String) vectorColumnTypes.get(intTrace-1);
						strTempColumnName = (String) vectorColumnNames.get(intTrace-1);
						strTempColumnName = strTempColumnName.trim();
						if (strTempColumnName.indexOf("_$$")>0)
						{
							strIDCurrency = "  id='currency_id'  ";
						}
						else
						{
							strIDCurrency = "";
						}
						if (strTempColumnType.equalsIgnoreCase("VARCHAR2"))
						{
							strAlign = "align='left'>";
						}
						else
						{
							strAlign = "align='right'>";
						}


						if (intFetchedRecords%2 == 0)
						{
							strHtmlData =  evn + strIDCurrency + strAlign + strData+"</td>";
						}
						else
						{
							strHtmlData = odd + strIDCurrency + strAlign + strData+"</td>";
						}

						if (intTrace == (int_search_by_index+1))
						{
							strSpecialData = strData;
							strSpecialAlign = strAlign;
							strSpecialIDCurrency = strIDCurrency;
						}
						else
						{
							vectorHtmlData.add(strHtmlData);
						}

					}
					//if(locale.equals("en")==true)
						   strLinkData=encode(strLinkData,locale);

					if (intFetchedRecords%2 == 0)
					{
							
						strHtmlData = evn + strSpecialIDCurrency + 
						strSpecialAlign+strStartLink+strLinkData+
						strEndLink+strSpecialData+"</a></td>";
					}
					else
					{
						strHtmlData = odd+strSpecialIDCurrency+strSpecialAlign+strStartLink+strLinkData+strEndLink+strSpecialData+"</a></td>";
					}
					strLinkData = "";
					vectorHtmlData.add(intArrayListTrace,strHtmlData);
					vectorHtmlData.add("</tr>");
					if (intFetchedRecords >= max_records)
					{
						break;
					}
					
				}
				vectorHtmlData.add("</table>");
				rs.close();
				pstmt.close();
				ConnectionManager.returnConnection(conn, request);
	
			}
			catch(Exception expSQL)
			{
				out.println("Error="+expSQL);
				//debug(" sql Err = "+expSQL);
			}

			//debug("Final sql  = "+sql);
		
            _bw.write(_wl_block12Bytes, _wl_block12);

		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}

		//debug("intFetchedRecords="+intFetchedRecords);
		//debug("max_records="+max_records);
		if (intFetchedRecords>=max_records)
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		
            _bw.write(_wl_block13Bytes, _wl_block13);

			for (int l=0;l<vectorHtmlData.size() ;++l)
			{
				out.println((String)vectorHtmlData.get(l));
			}
	//  DhanasekarV Modified for  IN024221  05/10/2010  - ?Query caused no data to be retrieved?. Not like other practitioner search screen
			if (intFetchedRecords == 0)
			{
			out.println("<script language='javascript'>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

");
			}
    //  End  IN024221
			try
			{
				conn.close();
			}
			catch(Exception er)
			{
			}
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(start));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(search_by_index));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(search_text));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(column_names));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(column_sizes));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(column_types));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(column_descriptions));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sql_pass_back));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(max_records));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sql_order_by));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		catch(Exception exp)
		{
			//debug("Error = "+exp);
		}

		finally
		{
			ConnectionManager.returnConnection(conn,request);
		}

            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
