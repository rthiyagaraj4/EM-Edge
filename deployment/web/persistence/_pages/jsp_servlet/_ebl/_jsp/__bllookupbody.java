package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

public final class __bllookupbody extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLLookupBody.jsp", 1742751891576L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n<title> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n <base target=\"_self\">\n <!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n-->\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<Script Language=\"JavaScript\" src=\"../../eBL/js/BLAmount.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script Language=\"JavaScript\">\n\n\tfunction funCurrencyFormat()\n\t{\n\t\ttry\n\t\t{\n\t\t\tvar ids = document.getElementById(\'currency_id\');\n\t\t\tif (ids.length ==\tnull)\n\t\t\t{\n\t\t\t\tcurrencyTableFormat(ids);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\n\t\t\t\tfor(i=0;i<ids.length;i++)\n\t\t\t\t{\n\t\t\t\t\tcurrencyTableFormat(ids[i]);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tcatch(e)\n\t\t{\n\t\t}\n\t}\n\tfunction submitFormN()\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from + maxval;\n\t\tdocument.forms[0].to.value = to + maxval;\n\t\tdocument.forms[0].submit();\n\t}\n\tfunction submitFormP(frm_to)\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from - maxval;\n\t\tdocument.forms[0].to.value = to - maxval;\n\t\tdocument.forms[0].submit();\n\t}\n\n\tfunction closew(row)\n\t{\n\t  \tvar row_val=row.value;\n\n  \t\t//while(row_val.indexOf(\"+\")!=-1)\n\t\t//\trow_val=row_val.replace(\'+\',\" \");\n  \t\twhile(row_val.indexOf(\"`\")!=-1)\n\t\t\trow_val=row_val.replace(\'`\',\"\'\");\n\n\t\twindow.returnValue = escape(row_val);\n\t\twindow.close();\t\n\t\t\n\t\t/* let dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    \tdialogBody.contentWindow.returnValue = escape(row_val);\n    \n    \tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    \tdialogTag.close();  */  \n\t\t\n\t\t//return(Dcode);\n\t}\n\n\tfunction record_found_check()\n\t{\n\t\tvar record_found_flag=document.getElementById(\"record_found_flag\").value;//\n\t  \tvar total_rec_fetched = document.forms[0].intTotalFetchedRecords.value;\n\t  \n\t  \tif(record_found_flag==\"N\")\n\t  \t{\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\t\n\t  \t}\n\t  \telse\n\t  \t{\n\t\t  \tif(total_rec_fetched == 1)\n\t\t  \t{\n\t\t\t\tdocument.getElementById(\"resulted_row\").click();\n\t\t  \t}\n\t  \t}\n\t}\n \n </script>\n\n\n</head>\n<body onLoad=\"record_found_check()\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<form name=\'form_query\' id=\'form_query\' method=\'post\' action=\'BLLookupBody.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'><!-- Added against MMS-DM-SCF-0729 -->\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t";
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

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\'hidden\' name=\'record_found_flag\' id=\'record_found_flag\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t<input type=\'hidden\' name=\'intFetchedRecords\' id=\'intFetchedRecords\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type=\'hidden\' name=\'col_show_hide\' id=\'col_show_hide\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<!-- //Added on 6/25/2008 ****-->\n\t\t<input type=\'hidden\' name=\'intTotalFetchedRecords\' id=\'intTotalFetchedRecords\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\t\t\n<!-- //Added on 6/25/2008 ****-->\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\t\t<script Language=\'JavaScript\'> funCurrencyFormat(); </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</form>\n</body>\n</html>\n\t\n\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
 
 String encode(String data)
 {
	  String outDat = replace(data); 
	  byte byteData[] = outDat.getBytes();
		outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
 }



	String replace(String data)
	{
		char strRep = '`';
		String strSpecial = "\f\n\r\t\'\"\\";
		char charArray[] = strSpecial.toCharArray();
		String strOutData = data;
		for (int i =0;i<charArray.length;i++)
		{
			strOutData = strOutData.replace(charArray[i],strRep);
		}
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V210420             16905        MOHE-SCF-0099      	Shikha Seth/Muthu
2			V230824							MMS-DM-SCF-0861					Mohanapriya
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( request.getParameter("title")));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String queryString=request.getQueryString();//Added against MMS-DM-SCF-0729
    
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block10Bytes, _wl_block10);

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//unused variable, commented on 09/06/05
		//ResultSet rs1=null;
		String locale			= (String)session.getAttribute("LOCALE");
		SimpleDateFormat format_date = new SimpleDateFormat("dd/MM/yyyy");

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
		String select_leg = common_labels.getString("Common.defaultSelect.label");
		String called_for1 = request.getParameter("called_for"); //Added against MMS-DM-SCF-0729
		if(called_for1 == null) called_for1 = "";
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
		String show_hide = "";
		String sqlData="";//V230824
		String record_found_flag="N";
		System.err.println("queryString    :"+request.getQueryString());
		String target = request.getParameter("target");
		if(target == null) target="";

		String col_show_hide = request.getParameter("col_show_hide");
		if(col_show_hide == null) col_show_hide="";
		System.err.println("col_show_hide  "+col_show_hide);
		System.err.println("col_show_hide length() "+col_show_hide.length());
		ArrayList col_show_hide_lst = new ArrayList();

		int tot_rec_count = 0;

		try
		{
			for(int i=0;i<col_show_hide.length();i++)
			{
				String temp_str = col_show_hide.substring(i,i+1);
				col_show_hide_lst.add(i,temp_str);
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in AL:"+e);
		}

		int max_records = 15;		
		int intTotalColumns = 0;
		int intGroupIndex = 0;
		int intGroupByIndex = 0;

		int j = 0;
		int i = 0;
		//Vector vectorColumnNames = new Vector();
		ArrayList arrListColumnNames = new ArrayList();
//		Vector vectorColumnSizes = new Vector();
		ArrayList arrListColumnSizes = new ArrayList();
//		Vector vectorColumnDescriptions = new Vector();
		ArrayList arrListColumnDescriptions = new ArrayList();
//		Vector vectorColumnTypes = new Vector();
		ArrayList arrListColumnTypes = new ArrayList();
//		Vector vectorHtmlData = new Vector();
		ArrayList arrListHtmlData  = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;int intTotalFetchedRecords=0;
		try
		{
			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ? 15:Integer.parseInt(request.getParameter("max_records"));

			String sql = request.getParameter("sql");

			sql = (sql == null) ? "":sql;
sql = java.net.URLDecoder.decode(sql,"UTF-8");//V231218
			sql=sql.replaceAll("@&","%");

			sqlData=sql;//V230824
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
//Added on 6/25/2008*****
			String strTotalFetchedRecords = request.getParameter("intTotalFetchedRecords");

			if(strTotalFetchedRecords == null) strTotalFetchedRecords="0";
//			System.out.println("strTotalFetchedRecords:"+strTotalFetchedRecords);
			intTotalFetchedRecords = Integer.parseInt(strTotalFetchedRecords);
//Added on 6/25/2008*****
	
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
			search_criteria = (search_criteria == null || search_criteria.equals("")) ? "":search_criteria;
			

			String search_by_index = request.getParameter("search_by_index");

			search_by_index = (search_by_index == null || search_by_index.equals("")) ? "0":search_by_index;
			int int_search_by_index = Integer.parseInt(search_by_index);

			String search_text = request.getParameter("search_text");
			search_text = (search_text == null || search_text.equals("") ) ? "%":search_text;

			String search_by = 	request.getParameter("search_by");
			search_by = (search_by == null || search_by.equals("")) ? "":search_by;

			String column_names = request.getParameter("column_names");
			column_names = (column_names == null || column_names.equals("")) ? "":column_names;
			

			String column_sizes = request.getParameter("column_sizes");
			column_sizes = (column_sizes == null || column_sizes.equals("")) ? "":column_sizes;
						


			String column_types = request.getParameter("column_types");
			column_types = (column_types == null || column_types.equals("")) ? "":column_types;

			String column_descriptions = request.getParameter("column_descriptions");
			column_descriptions = (column_descriptions == null || column_descriptions.equals("")) ? "":column_descriptions;
			

			StringTokenizer strTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
			i =0;


			while(strTokenizer.hasMoreTokens())
			{
				//vectorColumnNames.insertElementAt( " "+strTokenizer.nextToken(),i);
				arrListColumnNames.add(i," "+strTokenizer.nextToken());
				++i;
			}
			intTotalColumns = i;
			//System.err.println("arrListColumnNames in BLLookUp Body  3  :"+arrListColumnNames);


			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);

			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
//				vectorColumnSizes.insertElementAt( strTokenizer.nextToken(),i);
				arrListColumnSizes.add(i,strTokenizer.nextToken());
				++i;
			}

			strTokenizer = null;
			strTokenizer = new StringTokenizer(column_types,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
//				vectorColumnTypes.insertElementAt( strTokenizer.nextToken(),i);
				arrListColumnTypes.add(i,strTokenizer.nextToken());
				++i;
			}
			strTokenizer = null;

			strTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
//				vectorColumnDescriptions.insertElementAt( strTokenizer.nextToken(),i);
				arrListColumnDescriptions.add(i,strTokenizer.nextToken());
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
				
				intGroupIndex = SQL.lastIndexOf(" GROUP");
				
				//sqlGroupBy = " ";
				if (intGroupIndex > 0)
				{
					intGroupByIndex = SQL.indexOf(" BY",intGroupIndex);
					//debug("intGroupByIndex="+intGroupByIndex);
					if (intGroupByIndex >0)
					{
						//sqlGroupBy = sql.substring(intGroupIndex);
						//sql = sql.substring(0,intGroupIndex);
						
					}
				}
				//debug("sqlGroupBy="+sqlGroupBy);
				//debug("sql="+sql);
				j = SQL.lastIndexOf(" WHERE");//Modified V181118-Aravindh/AAKH-CRF-0103/indexOf -> lastIndexOf
				//debug("SQL="+SQL);
				//Starts for MOHE-CRF-0050.1
				String called = request.getParameter("Called");
				System.err.println("queryString    :"+request.getQueryString());
				if(called==null) called="";
				//Ends for MOHE-CRF-0050.1
				if(j <0)
				 sql= sql +" where (1=1) and ";
				if(j > 0)
				{		
					String sqlTemp = sql.substring(0,j+6);
					String sqlWhere = sql.substring(j+6);
					//Added Agaisnt MOHE-CRF-0050.1 Starts
					System.err.println("sqlTemp  :"+sqlTemp);
					System.err.println("called  :"+called);
					if(called.equals("IntermDraftFrm")){
						sqlWhere = " ( " + sqlWhere +" ) where ";
					}
					else{
					//MOHE-CRF-0050.1 Ends
					sqlWhere = " ( " + sqlWhere +" ) and ";
					// MOHE-CRF-0050.1 Starts 
					}
					// MOHE-CRF-0050.1 Ends
					sql = sqlTemp + sqlWhere;

				}
				
							
				i = 0;
				j = 0;
				i = SQL.indexOf("SELECT");
				j = SQL.indexOf(" FROM");
				//System.err.println("sql in BLLookUp Body  3  :"+SQL);
				//System.err.println("i in BLLookUp Body  3  :"+SQL);
				System.err.println("j in BLLookUp Body  3  :"+SQL);
				sqlWithColumnsOnly = SQL.substring(i+7,j);
				System.err.println("sqlWithColumnsOnly in BLLookUp Body  3  :"+sqlWithColumnsOnly);
				
				//sqlActualWithColumnsOnly = sql.substring(i+7,j);

					
				//debug("sqlWithColumnsOnly="+sqlWithColumnsOnly);
				//debug("int_search_by_index ="+int_search_by_index );
				

				if (int_search_by_index >0)
				{
				

//					String strTempSelectedColumn = (String)vectorColumnNames.elementAt(int_search_by_index);
					String strTempSelectedColumn = (String)arrListColumnNames.get(int_search_by_index);
					//debug("strTempSelectedColumn="+strTempSelectedColumn);
//					String strTempPreviousColumn = (String)vectorColumnNames.elementAt(int_search_by_index-1);
					String strTempPreviousColumn = (String)arrListColumnNames.get(int_search_by_index-1);
					//debug("strTempPreviousColumn ="+strTempPreviousColumn );
					int intTempSelectedIndex = sqlWithColumnsOnly.indexOf(strTempSelectedColumn);
					System.err.println("intTempSelectedIndex in BLLookUp Body 5   :"+intTempSelectedIndex);
					//debug("intTempSelectedIndex = "+intTempSelectedIndex);

					int intTempPreviousIndex = sqlWithColumnsOnly.indexOf(strTempPreviousColumn);
					//debug("intTempPreviousIndex = "+intTempPreviousIndex);
					int intCommaIndex = sqlWithColumnsOnly.indexOf(",",intTempPreviousIndex+1);
					//debug("intCommaIndex = "+intCommaIndex);
					
					if(intTempSelectedIndex != -1)//V210420
					strWhereColumn = sqlWithColumnsOnly.substring(intCommaIndex+1,intTempSelectedIndex);
					System.err.println("intTempPreviousIndex in BLLookUp Body 6   :"+intTempPreviousIndex);
					//debug("strWhereColumn = "+strWhereColumn);
				}
				else
				{
				
	
//					String strTempColumn = (String) vectorColumnNames.elementAt(int_search_by_index);
					
					
					String strTempColumn = (String)arrListColumnNames.get(int_search_by_index);

					System.err.println("strTempColumn in BLLookUp Body 7   :"+strTempColumn);
					System.err.println("sqlWithColumnsOnly in BLLookUp Body 7   :"+sqlWithColumnsOnly);
					int intTempIndex = sqlWithColumnsOnly.indexOf(strTempColumn );
					
					System.err.println("intTempIndex in BLLookUp Body 7   :"+intTempIndex);
					//debug("intTempIndex = "+intTempIndex);
					strWhereColumn = sqlWithColumnsOnly.substring(0,intTempIndex);
					System.err.println("strWhereColumn in BLLookUp Body 7   :"+strWhereColumn);
					//debug("strWhereColumn = "+strWhereColumn);
				}
				

				strWhereColumn = strWhereColumn.trim();

				System.err.println("strWhereColumn in BLLookUp Body 7   :"+strWhereColumn);
				int intTempWhereColumnLen = strWhereColumn.length();
				String strTempSpace = " ";
				String strTempQuote = "'";
				String strTempComma =",";
				i = 0;
				i = strWhereColumn.indexOf(strTempSpace);
				System.err.println("i in BLLookUp Body 7   :"+i);
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
//				strWhereColumnType = (String) vectorColumnTypes.get(int_search_by_index);
				strWhereColumnType = (String) arrListColumnTypes.get(int_search_by_index);
				

				System.err.println("strWhereColumnType in BLLookUp Body 7   :"+strWhereColumnType);
				//debug("strWhereColumnType = "+strWhereColumnType);
				if (strWhereColumnType.equalsIgnoreCase("VARCHAR2"))
				{
					if(search_criteria.equals("S"))
					{
						search_text = search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?) OR upper( "+strWhereColumn + ") is NULL";
					}
					else if(search_criteria.equals("E"))
					{
						search_text = "%" + search_text;
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?) OR upper( "+strWhereColumn + ") is NULL";
					}
					else if(search_criteria.equals("C"))
					{
						search_text = "%" + search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn + ") like upper(?) OR upper( "+strWhereColumn + ") is NULL";
					}
				}
				else if (strWhereColumnType.equalsIgnoreCase("DATE"))
				{
					if(search_criteria.equals("S"))
					{
						search_text = search_text + "%";
						userWhereClause = "( to_char( "+strWhereColumn + ",'DD/MM/YYYY HH:MI:SS') like upper(?) OR upper( "+strWhereColumn + ") is NULL";
					}
					else if(search_criteria.equals("E"))
					{
						search_text = "%" + search_text;
						userWhereClause = "( to_char( "+strWhereColumn + ",'DD/MM/YYYY HH:MI:SS') like upper(?) OR upper( "+strWhereColumn + ") is NULL";
					}
					else if(search_criteria.equals("C"))
					{
						search_text = "%" + search_text + "%";
						userWhereClause = "( to_char( "+strWhereColumn + ",'DD/MM/YYYY HH:MI:SS') like upper(?) OR upper( "+strWhereColumn + ") is NULL";
					}
				}
				else
				{
					//Added by Rajesh V to handle Search for Number Data Type
					if(search_criteria.equals("S"))
					{
						search_text = search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn+ ") like upper(?) OR "+strWhereColumn+ " is NULL";
					}
					else if(search_criteria.equals("E"))
					{
						search_text = "%" + search_text;
						userWhereClause = "( upper( "+strWhereColumn+ ") like upper(?) OR "+strWhereColumn+ " is NULL";
					}
					else if(search_criteria.equals("C"))
					{
						search_text = "%" + search_text + "%";
						userWhereClause = "( upper( "+strWhereColumn+ ") like upper(?) OR "+strWhereColumn+ " is NULL";
					}
					//Added by Rajesh V to handle Search for Number Data Type
				}

				System.err.println("sql 1 "+sql);
				sql = sql + userWhereClause;
				System.err.println("sql 2 "+sql);
				sql = sql + " )";
				System.err.println("sql 3 "+sql);
				System.err.println("userWhereClause 1 "+userWhereClause);
				sql_pass_back = sql;
				
				/* AAKH-SCF-0038 - Added by Karthik to sort based on clinic date descending */
				String called_for = request.getParameter("called_for");
				if(called_for==null) called_for="";
				
				if(called_for.equals("ENC_SPEC_EPISODE_LOOKUP")){
				sql_order_by = " order by EPISODE_ID desc,VISIT_ID desc"; // Modified by Gayathri  for MMS-ICN-00037
				} else if(called_for.equals("JOB_ID_LOOKUP")) {
					sql_order_by = " order by d.jobid desc"; //Modified V181118-Aravindh/AAKH-CRF-0103/
				}else if(called_for.equals("CASH_COUNTER_LOGINTIME")) {
					sql_order_by = " order by 1 desc"; //Modified V201201-PalaniNarayanan/MOHE-CRF-50.2 US-O6
				} else{
				sql_order_by = " order by "+(int_search_by_index+1);
				}
				
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
			
		
            _bw.write(_wl_block11Bytes, _wl_block11);

			try
			{
			
				String row = "<tr style='background-color:;' >";
				String evn = "<td class='QRYEVEN'";
				String odd = "<td class='QRYODD'";
				String strStartLink = "<a name='resulted_row' id='resulted_row' href=javascript:closew(";
				String strEndLink = ")>";
				String strHtmlData = "";
				String strData = "";
				String strLinkData = "";
				String strSpecialData = "";
				//String strNumberFormat = "";

				String strTempColumnType = "VARCHAR2";

				String strTempColumnName = "";
				String strIDCurrency = " id='currency_id' ";
				String strSpecialIDCurrency = " id='currency_id' ";
				String strAlign = "align = 'right'";
				String strSpecialAlign = "align = 'right'>";
				
				int intVectorTrace = 0;
				int intTempStart = start;
				//int intTempEnd = end;
				System.err.println("sql:"+sql);
				System.err.println("search_text:"+search_text);
				System.err.println("called_for1:"+called_for1);
				if(called_for1.equals("BankAndBranch")){
					sql=sqlData;
				}//V230822
				pstmt = conn.prepareStatement(sql);
		//Added against MMS-DM-SCF-0729
		if(called_for1.equals("INSPAYERLKUP")){			
			String valid_cust_check = "", valid_pol_check = "";

			String locale1 = request.getParameter("locale");
			if(locale1 == null) locale1 = "en";

			String module_id = request.getParameter("module_id");
			if(module_id == null) module_id = "";

			String episode_type = request.getParameter("episode_type");
			if(episode_type == null) episode_type = "";

			String auto_fin_chk = request.getParameter("auto_fin_chk");
			if(auto_fin_chk == null) auto_fin_chk = "";

			String cust_grp_code =request.getParameter("cust_grp_code");
			if(cust_grp_code == null) cust_grp_code = "";

			String class_code = request.getParameter("class_code");
			if(class_code == null) class_code = "";

			String blng_grp_id =request.getParameter("blng_grp_id");
			if(blng_grp_id == null) blng_grp_id = "";

			String search_by_items = request.getParameter("search_by_items");
			if(search_by_items == null) search_by_items = "";

			String search_code = request.getParameter("search_code");
			if(search_code == null) search_code = "";
			
			String facility_id = request.getParameter("facility_id");
			if(facility_id == null) facility_id = "";
			
			System.err.println("Called auto_fin_chk  "+auto_fin_chk);
			if(auto_fin_chk.equals("Y")){
				pstmt.setString(1,locale1);
				pstmt.setString(2,locale1);
				pstmt.setString(3,locale1);
				pstmt.setString(4,cust_grp_code);
				pstmt.setString(5,cust_grp_code);
				pstmt.setString(6,class_code);
				pstmt.setString(7,blng_grp_id);
				pstmt.setString(8,module_id);
				pstmt.setString(9,module_id);
				pstmt.setString(10,search_by_items);
				pstmt.setString(11,search_code);
				pstmt.setString(12,search_by_items);
				pstmt.setString(13,search_text);
			}else{
				pstmt.setString(1,locale1);
				pstmt.setString(2,locale1);
				pstmt.setString(3,facility_id);
				pstmt.setString(4,module_id);
				pstmt.setString(5,locale1);
				pstmt.setString(6,cust_grp_code);
				pstmt.setString(7,module_id);
				pstmt.setString(8,search_by_items);
				pstmt.setString(9,search_code);
				pstmt.setString(10,search_by_items);
				pstmt.setString(11,search_text);
			}
		}
		else if(called_for1.equals("BankAndBranch")){
			//V230824
			String param=request.getParameter("sqlData");
			String[] arr = param.split("::");
			String key = arr[0].substring(2,13);
			System.out.println("param BLLookupbody.jsp= "+param);
			System.out.println("BankAndBranch BLLookupbody.jsp= "+key);
			if(key.equals("INTERNALREP")){
				String lang=arr[2];
				String v_cash_slmt_flag=arr[3];
				String v_slmt_type_code=arr[4];
				String v_cheque_type_enabled=arr[5];
				System.out.println("locale BLLookupbody=>"+lang);
				System.out.println("v_cash_slmt_flag BLLookupbody=>"+v_cash_slmt_flag);
				System.out.println("v_slmt_type_code BLLookupbody=>"+v_slmt_type_code);
				System.out.println("v_cheque_type_enabled BLLookupbody=>"+v_cheque_type_enabled);
				pstmt.setString(1,lang);
				pstmt.setString(2,v_cash_slmt_flag);
				pstmt.setString(3,v_cash_slmt_flag);
				pstmt.setString(4,v_slmt_type_code);
				pstmt.setString(5,v_cheque_type_enabled);
				pstmt.setString(6,v_cheque_type_enabled);
				pstmt.setString(7,v_cash_slmt_flag);
				pstmt.setString(8,v_slmt_type_code);
				pstmt.setString(9,v_cheque_type_enabled);
				pstmt.setString(10,v_cheque_type_enabled);
				pstmt.setString(11,v_cash_slmt_flag);
				}
		}else{
				pstmt.setString(1,search_text);
		}//Added against MMS-DM-SCF-0729
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					tot_rec_count++;
				//System.err.println("tot_rec_count:"+tot_rec_count);
				}

				rs = pstmt.executeQuery();
//				vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1'>");
				arrListHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='1' id='tb1'>");
				//strNumberFormat = "";
				System.err.println("arrListHtmlData  "+arrListHtmlData);
				System.err.println("intTotalColumns  "+intTotalColumns);
				for (int l = 0;l<intTotalColumns ; l++ )
				{
//					strTempColumnType = (String) vectorColumnTypes.get(l);
					System.err.println("arrListColumnTypes Size  "+arrListColumnTypes.size());
					strTempColumnType = (String) arrListColumnTypes.get(l);
					System.err.println("strTempColumnType Size  "+strTempColumnType);
/* Newly added by Manivel N for hidding the columns which are not necessary for display */
					System.err.println("col_show_hide_lst Size  "+col_show_hide_lst.size());		
					String temp_var1 =(String) col_show_hide_lst.get(l);
					System.err.println("temp_var1   "+temp_var1);

					if(temp_var1.equals("Y"))
					{
						show_hide = "display";
					}
					else
					{
						show_hide = "display:none";
					}
/* ****************** */
					if (strTempColumnType.equalsIgnoreCase("VARCHAR2") || strTempColumnType.equalsIgnoreCase("DATE"))
					{
						strAlign = "align = 'left'";
					}
					else
					{
						strAlign = "align = 'right'";

					}

					if (l == int_search_by_index)
					{
						//strSpecialData = "<th width='"+(String)vectorColumnSizes.get(l)+"'  "+strAlign +" 				>"+(String)vectorColumnDescriptions.get(l)+"</th>";
						strSpecialData = "<th style='"+show_hide+"' width='"+(String)arrListColumnSizes.get(l)+"'  "+strAlign +" >"+(String)arrListColumnDescriptions.get(l)+"</th>";	

						 //strTokenizer.nextToken(),i);

					}
					else
					{
//						vectorHtmlData.add("<th width='"+(String)vectorColumnSizes.get(l)+"'  "+ strAlign +" >"+(String)vectorColumnDescriptions.get(l)+"</th>");

						arrListHtmlData.add("<th style='"+show_hide+"' width='"+(String)arrListColumnSizes.get(l)+"'  "+ strAlign +" >"+(String)arrListColumnDescriptions.get(l)+"</th>");
					}
				}	
				System.err.println("arrListHtmlData  "+arrListHtmlData);
//				vectorHtmlData.insertElementAt(strSpecialData,1);
				arrListHtmlData.add(1,strSpecialData);
				
				
				while(rs.next())
				{
					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
//Added on 6/25/2008 ****
					++intTotalFetchedRecords;
//Added on 6/25/2008 ****
//					vectorHtmlData.add(row);					
					arrListHtmlData.add(row);
//					intVectorTrace = vectorHtmlData.size();
					intVectorTrace = arrListHtmlData.size();	
					//System.err.println("intVectorTrace  "+intVectorTrace);
					for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace)
					{
//						strTempColumnType = (String) vectorColumnTypes.get(intTrace-1);
						strTempColumnType = (String) arrListColumnTypes.get(intTrace-1);
						
						//strTempColumnName = (String) vectorColumnNames.get(intTrace-1);
						strTempColumnName=(String)arrListColumnNames.get(intTrace-1);
						strTempColumnName = strTempColumnName.trim();
						if (strTempColumnName.indexOf("_$$")>0)
						{
							strIDCurrency = "  id='currency_id'  ";
						}
						else
						{
							strIDCurrency = "";
						}
						if (strTempColumnType.equalsIgnoreCase("VARCHAR2") || strTempColumnType.equalsIgnoreCase("DATE"))
						{
							strAlign = "align='left'>";
						}
						else
						{
							strAlign = "align='right'>";
						}
						
						strData = rs.getString(intTrace);
						
						if(strData != null)
						{
							if(strTempColumnType.equalsIgnoreCase("DATE"))
							{
								strData=format_date.format(rs.getDate(intTrace))+" "+rs.getTime(intTrace);
								strLinkData = strLinkData + strData+ "^~^" ;
								if(!locale.equals("en"))
								{
									if(!strData.equals(""))
										strData=com.ehis.util.DateUtils.convertDate(strData,"DMYHMS","en",locale);
								}
							}
							else
							{
								strData = rs.getString(intTrace);
								strLinkData = strLinkData + strData+ "^~^" ; 
							}
						}
						else
						{
							strLinkData = strLinkData + ""+ "^~^" ;
						}
						if(strData == null) strData="&nbsp;";
//						strLinkData = strLinkData + strData+ "::" ;
						System.err.println("strLinkData:  "+strLinkData);
/* Newly added by Manivel N for hidding the columns which are not necessary for display */						
						String temp_var1 =(String) col_show_hide_lst.get(intTrace-1);

						if(temp_var1.equals("Y"))
						{
							show_hide = "display";
						}
						else
						{
							show_hide = "display:none";
						}
/* ************ */
						if (intFetchedRecords%2 == 0)
						{
							strHtmlData =  evn +" style='"+show_hide+"' "+ strIDCurrency + strAlign + strData+"</td>";
						}
						else
						{
							strHtmlData = odd +" style='"+show_hide+"' "+ strIDCurrency + strAlign + strData+"</td>";
						}

						System.err.println("int_search_by_index:  "+int_search_by_index);
						if (intTrace == (int_search_by_index+1))
						{
							strSpecialData = strData;
							strSpecialAlign = strAlign;
							strSpecialIDCurrency = strIDCurrency;
							System.err.println("strSpecialData:  "+strSpecialData);
						}
						else
						{
//							vectorHtmlData.add(strHtmlData);
							arrListHtmlData.add(strHtmlData);
						}
					}
						System.err.println("arrListHtmlData:  727 "+arrListHtmlData);
					
					if (intFetchedRecords%2 == 0)
					{
						if(strSpecialData.equals("&nbsp;"))
							strSpecialData = "-"+select_leg+"-";
						strHtmlData = evn + strSpecialIDCurrency + 
						strSpecialAlign+strStartLink+"document.forms[0].row_value_"+intFetchedRecords+
						strEndLink+strSpecialData+"</a><input type=hidden name='row_value_"+intFetchedRecords+"' id='row_value_"+intFetchedRecords+"' value='"+strLinkData.replaceAll("'","`")+"'></td>"; // replace is added as ' in the string will be considered as the end of the value part, so replacing it to tilde by Manivel on 13th Nov 2007
					}
					else
					{
						if(strSpecialData.equals("&nbsp;"))
							strSpecialData = "-"+select_leg+"-";
						strHtmlData = odd+strSpecialIDCurrency+strSpecialAlign+strStartLink+"document.forms[0].row_value_"+intFetchedRecords+strEndLink+strSpecialData+"</a><input type=hidden name='row_value_"+intFetchedRecords+"' id='row_value_"+intFetchedRecords+"' value='"+strLinkData.replaceAll("'","`")+"'></td>"; // replace is added as ' in the string will be considered as the end of the value part, so replacing it to tilde by Manivel on 13th Nov 2007
					}
					System.err.println("strHtmlData:743  "+strHtmlData);
					strLinkData = "";
//					vectorHtmlData.insertElementAt(strHtmlData,intVectorTrace);
					arrListHtmlData.add(intVectorTrace,strHtmlData);
					
//					vectorHtmlData.add("</tr>");
					arrListHtmlData.add("</tr>");
					if (intFetchedRecords >= max_records)
					{
						break;
					}
					
					record_found_flag="Y";	
				}
			
				
//				vectorHtmlData.add("</table>");
				arrListHtmlData.add("</table>");
				if (rs != null) rs.close();
				pstmt.close();
				// commented in Bangalore on 13/10/2005
				//ConnectionManager.returnConnection(conn, request);
	
			}
			catch(Exception expSQL)
			{
				System.err.println("expSQL:769  "+expSQL);
				out.println("Error2="+expSQL);
			}
			finally{ // Added in Bangalore on 13/10/2005

				if(pstmt != null) 	pstmt.close(); 	
				if(conn!=null) {
					ConnectionManager.returnConnection(conn, request);
				}
			}

		
            _bw.write(_wl_block12Bytes, _wl_block12);

		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> Previous </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}

		System.err.println("intFetchedRecords="+intFetchedRecords);
		System.err.println("intTotalFetchedRecords="+intTotalFetchedRecords);
		System.err.println("max_records="+max_records);
		System.err.println("tot_rec_count="+tot_rec_count);

		if (intFetchedRecords>=max_records && tot_rec_count!=intFetchedRecords && (intTotalFetchedRecords != tot_rec_count))
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> Next </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		
            _bw.write(_wl_block13Bytes, _wl_block13);

			//vectorHtmlData
			for (int l=0;l<arrListHtmlData.size() ;++l)
			{
				out.println((String)arrListHtmlData.get(l));
			}
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
            out.print( String.valueOf(record_found_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(intFetchedRecords));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(col_show_hide));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(intTotalFetchedRecords));
            _bw.write(_wl_block31Bytes, _wl_block31);

		}
		catch(Exception exp)
		{
			System.out.println("Main Exception:"+exp);
		}
		finally
		{		
			if(pstmt != null) 	
				{
					pstmt.close(); 	
				}
			if(conn!=null)
				{
					ConnectionManager.returnConnection(conn, request);
				}
		}



            _bw.write(_wl_block32Bytes, _wl_block32);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
