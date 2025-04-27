package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blgeneralquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLGeneralQuery.jsp", 1716465227733L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<title> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n <base target=\"_self\">\n <!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n-->\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<!-- \n\tScript Language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></Script>\n-->\n<Script Language=\"JavaScript\" src=\"../../eBL/js/BLAmount.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script Language=\"JavaScript\">\n\tfunction funCurrencyFormat()\n\t{\n\n\t\ttry\n\t\t{\n\t\t\tvar ids = document.getElementById(\"currency_id\");\n\t\t\tif (ids.length ==\tnull)\n\t\t\t{\n\t\t\t\tcurrencyTableFormat(ids);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tfor(i=0;i<ids.length;i++)\n\t\t\t\t{\n\t\t\t\t\tcurrencyTableFormat(ids[i]);\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tcatch(e)\n\t\t{\n\t\t}\n\t}\n\tfunction submitFormN()\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from + maxval;\n\t\tdocument.forms[0].to.value = to + maxval;\n\t\tdocument.forms[0].submit();\n\t}\n\tfunction submitFormP()\n\t{\n\t\tvar from = new Number(document.forms[0].from.value );\n\t\tvar to = new Number(document.forms[0].to.value );\n\t\tvar maxval = new Number(document.forms[0].max_records.value );\n\t\tdocument.forms[0].from.value = from - maxval;\n\t\tdocument.forms[0].to.value = to - maxval;\n\t\tdocument.forms[0].submit();\n\t}\n\tfunction closew(){\n\t\t const dialogTag = parent.document.getElementById(\"dialog_tag\");    \n         dialogTag.close();\n\t}\n\n </script>\n\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<form name=\'form_query\' id=\'form_query\' method=\'post\' action=\'BLGeneralQuery.jsp\'>\n\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<table cellpadding=\'3\' align=\'center\' width=\'100%\'>\n\t\t<tr> \n\t\t<td class=\"button\" align=\'right\' ><input type=\'button\' name=\'close_butt\' id=\'close_butt\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" class=\'button\' onClick=\'closew()\'>\n\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td align=\'right\'>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\n\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\n\t\n\t\n\t\n\t\t\n\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\'hidden\' name=\'column_names\' id=\'column_names\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\'hidden\' name=\'column_sizes\' id=\'column_sizes\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\'hidden\' name=\'column_types\' id=\'column_types\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t<input type=\'hidden\' name=\'column_descriptions\' id=\'column_descriptions\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\t\t\n\t\t<input type=\'hidden\' name=\'sql\' id=\'sql\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=\'hidden\' name=\'max_records\' id=\'max_records\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=\'hidden\' name=\'title\' id=\'title\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<script Language=\'JavaScript\'> funCurrencyFormat(); </script>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n\n\n</form>\n</body>\n</html>\n\t\n\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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

request.setCharacterEncoding("UTF-8");

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

		//unused variable, commented on 09/06/05
		//ResultSet rs1=null;
		String strColumnDelimiter = ",";
		int max_records = 15;		
		int intTotalColumns = 0;

		//int j = 0;
		int i = 0;
/*		Vector vectorColumnNames = new Vector();
		Vector vectorColumnSizes = new Vector();
		Vector vectorColumnDescriptions = new Vector();
		Vector vectorColumnTypes = new Vector();
		Vector vectorHtmlData = new Vector();  */
		ArrayList arrListColumnNames = new ArrayList();
		ArrayList arrListColumnSizes  = new ArrayList();
		ArrayList arrListColumnDescriptions = new ArrayList();
		ArrayList arrListColumnTypes = new ArrayList();
		ArrayList arrListHtmlData = new ArrayList();
		
		request.setCharacterEncoding("UTF-8");
		


		int start = 0,end = 0;
		int intFetchedRecords = 0;
		try
		{
			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ? 15:Integer.parseInt(request.getParameter("max_records"));
			String column_names = request.getParameter("column_names");
			column_names = (column_names == null) ? "":column_names;
			String column_types = request.getParameter("column_types");
			column_types = (column_types == null) ? "":column_types;
			String sql = request.getParameter("sql");	
			
			//System.out.println("sql.....@...@"+sql);
		
			sql = (sql == null) ? "":sql;
			
			sql = URLDecoder.decode(sql,"UTF-8");
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
	
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

			String column_descriptions = request.getParameter("column_descriptions");
			column_descriptions = (column_descriptions == null) ? "":column_descriptions;

			String column_sizes = request.getParameter("column_sizes");
			column_sizes = (column_sizes == null) ? "":column_sizes;
			

			StringTokenizer strTokenizer = null;
			strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);

			i = 0;
			while(strTokenizer.hasMoreTokens())
			{
//				vectorColumnSizes.insertElementAt( strTokenizer.nextToken(),i);
				arrListColumnSizes.add(i, strTokenizer.nextToken());
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
		
			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";

			if (calling_from_main == true)
			{
				try
					{
						PreparedStatement prepareStatement = conn.prepareStatement(sql);
						prepareStatement.execute();
						ResultSetMetaData rmeta = prepareStatement.getMetaData();
						int intCount = rmeta.getColumnCount() ;
						intTotalColumns = intCount;
						String strTempColumnTypeName = "";
						i = 1;
						column_names = "";
						column_types = "";
						for (i=1;i<=intCount ;i++ )
						{
							column_names =  column_names + rmeta.getColumnName(i) + strColumnDelimiter;
//							vectorColumnNames.add(""+rmeta.getColumnName(i));
							arrListColumnNames.add(""+rmeta.getColumnName(i));
							strTempColumnTypeName = rmeta.getColumnTypeName(i);
							if (strTempColumnTypeName.equalsIgnoreCase("VARCHAR2") || strTempColumnTypeName.equalsIgnoreCase("VARCHAR") || strTempColumnTypeName.equalsIgnoreCase("CHAR"))
							{
								strTempColumnTypeName = "VARCHAR2";
							}
							column_types = column_types + rmeta.getColumnTypeName(i) + strColumnDelimiter;
//							vectorColumnTypes.add(""+rmeta.getColumnTypeName(i));
							arrListColumnTypes.add(""+rmeta.getColumnTypeName(i));
						}
							prepareStatement.close();
					}
					catch(Exception ex)
					{
							// Commented and added the below line Bangalore on 13/10/2005
							out.println(ex.toString());
							//ConnectionManager.returnConnection(conn, request);
					}			
				}
				else
				{
						i =0;
						strTokenizer = null;
						strTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
						while(strTokenizer.hasMoreTokens())
						{
//							vectorColumnNames.insertElementAt( " "+strTokenizer.nextToken(),i);
							arrListColumnNames.add(i, " "+strTokenizer.nextToken());
							++i;
						}
						intTotalColumns = i;
						strTokenizer = null;
						strTokenizer = new StringTokenizer(column_types,strColumnDelimiter);
						i = 0;
						while(strTokenizer.hasMoreTokens())
						{
//							vectorColumnTypes.insertElementAt( strTokenizer.nextToken(),i);
							arrListColumnTypes.add(i,strTokenizer.nextToken());
							
							++i;
						}
						strTokenizer = null;
				}
			try
			{
				String row = "<tr style='background-color:;'>";
				String evn = "<td class='QRYEVEN'";
				String odd = "<td class='QRYODD'";
				String strHtmlData = "";
				String strData = "";

				String strIDCurrency = " id='currency_id' ";
				String strAlign = "align = 'right'";

				String strTempColumnName = "";
				String strTempColumnType = "";
				int intTempStart = start;
				//int intTempEnd = end;


				pstmt = conn.prepareStatement(sql);				
				rs = pstmt.executeQuery();
				
//				vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='3' id='tb1'>");
				arrListHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='3' id='tb1'>");
				

				for (int l = 0;l<intTotalColumns ; l++ )
				{

//					strTempColumnType = (String) vectorColumnTypes.get(l);
strTempColumnType = (String) arrListColumnTypes.get(l);
					//debug("strTempColumnType="+strTempColumnType);
					if (strTempColumnType.equalsIgnoreCase("VARCHAR2"))
					{
						strAlign = "align = 'left'";
					}
					else
					{
						strAlign = "align = 'right'";
					}

//					vectorHtmlData.add("<td class='COLUMNHEADER' width='"+(String)vectorColumnSizes.get(l)+"'  "+ strAlign +" >"+(String)vectorColumnDescriptions.get(l)+"</td>");
					arrListHtmlData.add("<td class='COLUMNHEADER' width='"+(String)arrListColumnSizes.get(l)+"'  "+ strAlign +" >"+(String)arrListColumnDescriptions.get(l)+"</td>");
					
				}	
				while(rs.next())
				{
					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
					if (intFetchedRecords > max_records)
					{
						break;
					}
//					vectorHtmlData.add(row);					
					arrListHtmlData.add(row);					
					for (int intTrace = 1;intTrace<=intTotalColumns ; ++intTrace)
					{
						strData = rs.getString(intTrace);
// Added by Manivel on 31st Oct 2007						
						if(strData == null || strData.equals("") || strData.equals(" "))
						{
							strData="&nbsp;";
						}

//						strTempColumnType = (String) vectorColumnTypes.get(intTrace-1);
						strTempColumnType = (String) arrListColumnTypes.get(intTrace-1);
						
//						strTempColumnName = (String) vectorColumnNames.get(intTrace-1);
						strTempColumnName = (String) arrListColumnNames.get(intTrace-1);
						
						strTempColumnName = strTempColumnName.trim();
						//debug("strTempColumnName="+strTempColumnName);
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

//						vectorHtmlData.add(strHtmlData);
						arrListHtmlData.add(strHtmlData);	
					}
//					vectorHtmlData.add("</tr>");
					arrListHtmlData.add("</tr>");
					
				}
//				vectorHtmlData.add("</table>");
				arrListHtmlData.add("</table>");
				if (rs != null)   rs.close();
				pstmt.close();
				// Commented the below line Bangalore on 13/10/2005
 				// ConnectionManager.returnConnection(conn, request);
	
			}
			catch(Exception expSQL)
			{
				// Commented the below line Bangalore on 13/10/2005
				//ConnectionManager.returnConnection(conn, request);
				//debug(" sql Err = "+expSQL);
			}

			//debug("Final sql  = "+sql);
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
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
		if (intFetchedRecords > max_records)
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> Next </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		
            _bw.write(_wl_block12Bytes, _wl_block12);

			//debug("vectorHtmlData.size()="+vectorHtmlData.size() );
				//vectorHtmlData
			for (int l=0;l<arrListHtmlData.size() ;++l)
			{
				out.println((String)arrListHtmlData.get(l));
			}
				
			

	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(start));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(end));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(column_names));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(column_sizes));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(column_types));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(column_descriptions));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(URLEncoder.encode(sql)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(max_records));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(request.getParameter("title")));
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
		catch(Exception exp)
		{
		}

		finally {  // Added on Bangalore on 13/10/2005
			if (conn != null)
			{
				ConnectionManager.returnConnection(conn,request);	
			}
		}

	

            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
