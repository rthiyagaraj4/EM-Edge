package jsp_servlet._eam._jsp;

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

public final class __referralsourcelookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/ReferralSourceLookupResult.jsp", 1734409625147L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n<title> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n <base target=\"_self\">\n <!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n-->\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script Language=\"JavaScript\">\n\n\t\n\tfunction submitFormN()\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from + maxval;\n\t\tdocument.forms[0].to.value = to + maxval;\n\t\tdocument.forms[0].submit();\n\t}\n\tfunction submitFormP(frm_to)\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from - maxval;\n\t\tdocument.forms[0].to.value = to - maxval;\n\t\tdocument.forms[0].submit();\n\t}\n\n\tfunction closew(row)\n\t  {\n\t  var row_val=row.value;\n  \t\t//while(row_val.indexOf(\"+\")!=-1)\n\t\t\t//row_val=row_val.replace(\'+\',\" \");\n  \t\t//while(row_val.indexOf(\"`\")!=-1)\n\t\t\t//row_val=row_val.replace(\'`\',\"\'\");\n          let dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n            dialogBody.contentWindow.returnValue = row_val;\n    \n      const dialogTag = parent.parent.document.getElementById(\'dialog_tag\');    \n       dialogTag.close(); \n\t\tparent.window.returnValue = row_val;\n\t\t//parent.window.close();\t\n\t\t//return(Dcode);\n\t  }\n\n\t  function record_found_check()\n\t  {\n\t\t  var record_found_flag=document.forms[0].record_found_flag.value;\n\t\t  var total_rec_fetched = document.forms[0].intTotalFetchedRecords.value;\n\t\t  \n\t\t  if(record_found_flag==\"N\")\n\t\t  {\n\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\t\n\t\t\tparent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\n\n\t\t  }\n\t\t  else\n\t\t  {\n\t\t\t  if(total_rec_fetched == 1)\n\t\t\t  {\n\t\t\t\t document.getElementById(\'resulted_row\').click();\n\t\t\t  }\n\t\t  }\n\t  }\n \n\n </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<body onLoad=\"record_found_check()\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<form name=\'form_query\' id=\'form_query\' method=\'post\' action=\'ReferralSourceLookupResult.jsp\'>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<table align=\'center\' width=\'100%\'>\n\t\t<tr>\n\t\t<td align=\'right\'>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\n\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\n\t\n\t\n\t\t\n\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\'hidden\' name=\'search_criteria\' id=\'search_criteria\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\'hidden\' name=\'search_by_index\' id=\'search_by_index\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\'hidden\' name=\'search_text\' id=\'search_text\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t<input type=\'hidden\' name=\'search_by\' id=\'search_by\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t<input type=\'hidden\' name=\'column_names\' id=\'column_names\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=\'hidden\' name=\'column_sizes\' id=\'column_sizes\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=\'hidden\' name=\'column_types\' id=\'column_types\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\'hidden\' name=\'column_descriptions\' id=\'column_descriptions\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=\'hidden\' name=\'sql_pass_back\' id=\'sql_pass_back\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\'hidden\' name=\'max_records\' id=\'max_records\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\'hidden\' name=\'sql_order_by\' id=\'sql_order_by\'  value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=\'hidden\' name=\'record_found_flag\' id=\'record_found_flag\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\'hidden\' name=\'intFetchedRecords\' id=\'intFetchedRecords\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t<input type=\'hidden\' name=\'col_show_hide\' id=\'col_show_hide\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t<input type=\'hidden\' name=\'ref_type\' id=\'ref_type\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t<input type=\'hidden\' name=\'hcareType\' id=\'hcareType\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\n<!-- //Added on 6/25/2008 ****-->\n\t\t<input type=\'hidden\' name=\'intTotalFetchedRecords\' id=\'intTotalFetchedRecords\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\t\t\n<!-- //Added on 6/25/2008 ****-->\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n\n\n</form>\n\n</body>\n</html>\n\t\n\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( request.getParameter("title")));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String locale			= (String)session.getAttribute("LOCALE");		

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
		String select_leg = common_labels.getString("Common.defaultSelect.label");

		String strColumnDelimiter = ",";
		String userWhereClause = "";		
		String strWhereColumn = "";
		String sql_pass_back = "";
		String sql_order_by = "";
		String show_hide = "";

		String record_found_flag="N";
		String target = request.getParameter("target");
		if(target == null) target="";

		String col_show_hide = request.getParameter("col_show_hide");
		if(col_show_hide == null) col_show_hide="";

		ArrayList col_show_hide_lst = new ArrayList();


		String facilityid = request.getParameter( "facilityid");
		String ref_type = request.getParameter( "ref_type");
		String hcareType = request.getParameter( "hcareType");


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
			e.printStackTrace();
		}

		int max_records = 13;		
		int intTotalColumns = 0;		
		
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
			max_records = (request.getParameter("max_records")== null) ? 13:Integer.parseInt(request.getParameter("max_records"));

			String sql = request.getParameter("sql");



			//sql = (sql == null) ? "":sql;
			//sql=sql.replaceAll("@&","%");

			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
//Added on 6/25/2008*****
			String strTotalFetchedRecords = request.getParameter("intTotalFetchedRecords");

			if(strTotalFetchedRecords == null) strTotalFetchedRecords="0";
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
			
			//out.println("line 237");
			StringTokenizer strTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
			i =0;

			//out.println("line 241");
			while(strTokenizer.hasMoreTokens())
			{
				//vectorColumnNames.insertElementAt( " "+strTokenizer.nextToken(),i);
				arrListColumnNames.add(i," "+strTokenizer.nextToken());
				++i;
			}
			intTotalColumns = i;


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
			//out.println("line 281");
			strTokenizer = null;
			//out.println("line 281"+sql);
			//SQL = sql.toUpperCase();
		
			//out.println("line 281"+from);
			//out.println("line 281"+to);

			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";
			
			//sqlFifteenRecords = " and rownum between "+from+" and  " +to +"";
			//out.println("line 310 calling_from_main" + calling_from_main);
			//out.println("line 310 int_search_by_index" + int_search_by_index);
			if(calling_from_main == true)
			{
				

				if(ref_type.equals("X")){
					if(search_by.equals("0")){
						strWhereColumn="a.REFERRAL_CODE";
					}else if (search_by.equals("1")){
						strWhereColumn="a.short_desc";
					}else if (search_by.equals("2")){
						strWhereColumn="a.LONG_DESC";
					}else if (search_by.equals("3")){
						//strWhereColumn="a.contact_name";
						strWhereColumn="a.long_name";
						
					}
				}else{
					if(search_by.equals("0")){
						strWhereColumn="a.FACILITY_ID";
					}else if (search_by.equals("1")){
						strWhereColumn ="a.FACILITY_NAME";
					}
				}



				

				//out.println("search_criteria=====> " + search_criteria);
				//out.println("ref_type=====> 427" + ref_type);
				//out.println("search_by=====> 427" + search_by);
				//out.println("search_text=====> " + search_text);
				//out.println("strWhereColumn=====> 427" + strWhereColumn);
				

				if(search_criteria.equals("S") )	{
					
					search_text = search_text + "%";

					//userWhereClause = " and ( upper( "+strWhereColumn + ") like upper(?) OR upper( "+strWhereColumn + ") is NULL ";
					
					//userWhereClause = " and ( upper( "+strWhereColumn + ") like upper(?) OR ('"+search_text+"' = '%%' and upper( "+strWhereColumn + ") is NULL )";
					userWhereClause = " and  (upper(nvl( "+strWhereColumn + ", '-select-')) like upper(?) OR ('"+search_text+"' = '%%' and upper( "+strWhereColumn + ") is NULL )";

				}else if(search_criteria.equals("E")){
					search_text = "%" + search_text;
					//userWhereClause = "and ( upper( "+strWhereColumn + ") like upper(?) OR upper( "+strWhereColumn + ") is NULL";
					userWhereClause = " and  (upper(nvl( "+strWhereColumn + ", '-select-')) like upper(?) OR ('"+search_text+"' = '%%' and upper( "+strWhereColumn + ") is NULL )";

				}else if(search_criteria.equals("C")){
					search_text = "%" + search_text + "%";
					//userWhereClause = "and ( upper( "+strWhereColumn + ") like upper(?) OR upper( "+strWhereColumn + ") is NULL";
					userWhereClause = " and  (upper(nvl( "+strWhereColumn + ", '-select-')) like upper(?) OR ('"+search_text+"' = '%%' and upper( "+strWhereColumn + ") is NULL )";
				}


            //out.println("userWhereClause=====> " + userWhereClause);

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
		
            _bw.write(_wl_block10Bytes, _wl_block10);

			try
			{
			
				String row = "<tr style='background-color:;' >";
				String evn = "<td class='QRYEVEN'";
				String odd = "<td class='QRYODD'";
				String strStartLink = "<a name='resulted_row' href=javascript:closew(";
				String strEndLink = ")>";
				String strHtmlData = "";
				String strData = "";
				String strLinkData = "";
				String strSpecialData = "";
				//String strNumberFormat = "";

				String strTempColumnType = "VARCHAR2";

				String strTempColumnName = "";
				String strAlign = "align = 'right'";
				String strSpecialAlign = "align = 'right'>";
				
				int intVectorTrace = 0;
				int intTempStart = start;
				//int intTempEnd = end;

				pstmt = conn.prepareStatement(sql);

				if(ref_type.equals("L")){
					pstmt.setString(1,facilityid);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,facilityid);
					pstmt.setString(5,search_text);
				}else if (ref_type.equals("X")){
					pstmt.setString(1,hcareType);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,search_text);
				}else if (ref_type.equals("E")){
					pstmt.setString(1,facilityid);
					pstmt.setString(2,hcareType);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,search_text);
				}
				

				
				rs = pstmt.executeQuery();
				
				arrListHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='3' id='tb1'>");

				for (int l = 0;l<intTotalColumns ; l++ )
				{
					strTempColumnType = (String) arrListColumnTypes.get(l);
/* Newly added by Manivel N for hidding the columns which are not necessary for display */		
					String temp_var1 =(String) col_show_hide_lst.get(l);

					if(temp_var1.equals("Y"))
					{
						//show_hide = "display:inline";
						show_hide = "";
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

					for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace)
					{
//						strTempColumnType = (String) vectorColumnTypes.get(intTrace-1);
						strTempColumnType = (String) arrListColumnTypes.get(intTrace-1);
						
						//strTempColumnName = (String) vectorColumnNames.get(intTrace-1);
						strTempColumnName=(String)arrListColumnNames.get(intTrace-1);
						strTempColumnName = strTempColumnName.trim();
						//if (strTempColumnName.indexOf("_$$")>0)
						//{
							//strIDCurrency = "  id='currency_id'  ";
						//}
						//else
						//{
							//strIDCurrency = "";
						//}
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
							strData = rs.getString(intTrace);
							if(strData.equals("")){
								strLinkData = strLinkData + "^~^" ; 
							}else{
								strLinkData = strLinkData + strData+ "^~^" ; 
							}
							
						}
						else
						{
							strLinkData = strLinkData + ""+ "^~^" ;
						}
						if(strData == null) strData="&nbsp;";

						String temp_var1 =(String) col_show_hide_lst.get(intTrace-1);

						if(temp_var1.equals("Y"))
						{
							//show_hide = "display:inline";
							show_hide = "";
						}
						else
						{
							show_hide = "display:none";
						}
/* ************ */
						if (intFetchedRecords%2 == 0)
						{
							if(strData.equals("")){
								strHtmlData =  evn +" style='"+show_hide+"' "+ strAlign + "&nbsp;</td>";
							}else{
								strHtmlData =  evn +" style='"+show_hide+"' "+ strAlign + strData+"</td>";
							}

							
						}
						else
						{

							if(strData.equals("")){
								strHtmlData = odd +" style='"+show_hide+"' "+ strAlign + "&nbsp;</td>";
							}else{
								strHtmlData = odd +" style='"+show_hide+"' "+ strAlign + strData+"</td>";
							}
							
						}

						if (intTrace == (int_search_by_index+1))
						{
							strSpecialData = strData;
							strSpecialAlign = strAlign;
							//strSpecialIDCurrency = strIDCurrency;
						}
						else
						{
//							vectorHtmlData.add(strHtmlData);
							arrListHtmlData.add(strHtmlData);
						}
					}
					
					if (intFetchedRecords%2 == 0)
					{
						if(strSpecialData.equals("&nbsp;")){
							strSpecialData = "-"+select_leg+"-";
							//strSpecialData = "";
						}
						strHtmlData = evn + strSpecialAlign+strStartLink+"document.forms[0].row_value_"+intFetchedRecords+
						strEndLink+strSpecialData+"</a><input type=hidden name='row_value_"+intFetchedRecords+"' id='row_value_"+intFetchedRecords+"' value='"+strLinkData.replaceAll("'","`")+"'></td>"; // replace is added as ' in the string will be considered as the end of the value part, so replacing it to tilde by Manivel on 13th Nov 2007
					}
					else
					{
						if(strSpecialData.equals("&nbsp;")){
							strSpecialData = "-"+select_leg+"-";
							//strSpecialData = "&nbsp;";
						}
						strHtmlData = odd+strSpecialAlign+strStartLink+"document.forms[0].row_value_"+intFetchedRecords+strEndLink+strSpecialData+"</a><input type=hidden name='row_value_"+intFetchedRecords+"' id='row_value_"+intFetchedRecords+"' value='"+strLinkData.replaceAll("'","`")+"'></td>"; // replace is added as ' in the string will be considered as the end of the value part, so replacing it to tilde by Manivel on 13th Nov 2007
					}
					strLinkData = "";
//					vectorHtmlData.insertElementAt(strHtmlData,intVectorTrace);
					arrListHtmlData.add(intVectorTrace,strHtmlData);
					
//					vectorHtmlData.add("</tr>");
					arrListHtmlData.add("</tr>");
					if (intFetchedRecords > max_records)
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
				out.println("Error2="+expSQL);
				//debug(" sql Err = "+expSQL);
				expSQL.printStackTrace();
			}
			finally{ // Added in Bangalore on 13/10/2005

				if(pstmt != null) 	pstmt.close(); 	
				if(conn!=null) {
					ConnectionManager.returnConnection(conn, request);
				}
			}

			//debug("Final sql  = "+sql);
		
            _bw.write(_wl_block11Bytes, _wl_block11);

		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> Previous </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}

		//debug("intFetchedRecords="+intFetchedRecords);
		//debug("max_records="+max_records);
		if (intFetchedRecords>max_records)
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> Next </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		
            _bw.write(_wl_block12Bytes, _wl_block12);

			//vectorHtmlData
			for (int l=0;l<arrListHtmlData.size() ;++l)
			{
				out.println((String)arrListHtmlData.get(l));
			}
			try
			{
				//conn.close(); //Commented for checkstyle
				//Added for checkstyle for COMMON-ICN-0056
				if(conn!=null)
				ConnectionManager.returnConnection(conn, request);  
			}
			catch(Exception er)
			{
				er.printStackTrace();
			}
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(end));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(search_by_index));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(search_text));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(column_names));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(column_sizes));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(column_types));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(column_descriptions));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(sql_pass_back));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(max_records));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sql_order_by));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record_found_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(intFetchedRecords));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(col_show_hide));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ref_type));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(hcareType));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(intTotalFetchedRecords));
            _bw.write(_wl_block34Bytes, _wl_block34);

		}
		catch(Exception exp)
		{
			exp.printStackTrace();
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



            _bw.write(_wl_block35Bytes, _wl_block35);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
