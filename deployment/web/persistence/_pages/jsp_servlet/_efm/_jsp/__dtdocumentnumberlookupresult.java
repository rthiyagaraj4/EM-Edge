package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.util.StringTokenizer;
import java.util.*;
import com.ehis.util.*;

public final class __dtdocumentnumberlookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTDocumentNumberLookupResult.jsp", 1709116818013L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\" ></script>\n<script src=\"../../eFM/js/DTDocumentNumberLookup.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body onKeyDown = \'lockKey();\'>\n\t<form name=\"DocNumberLookupResult\" id=\"DocNumberLookupResult\" action=\"DTDocumentNumberLookupResult.jsp\" method=\"POST\">\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\tparent.lookup_head.document.forms[0].Search.disabled = false;\n\t\t\tparent.lookup_detail.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<table align=\'right\'><tr><td align =\'right\'>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =", ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =")\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</td></tr></table></p>\n\t\t\t<br><br>\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\" id=\'tb1\'>\n\t<tr>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<td class=\'columnheader\' onClick=\"orderResult(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');\" style=\"cursor:pointer\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;<img src=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' align=\'center\' id =\"img";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" height=\"9\" style=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"> </img></td>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t</tr>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<input type=\"Hidden\" name=\"return_value";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"return_value";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=\"\">\t\n\t\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" nowrap style=\"cursor:pointer;color:blue;\" onClick=\"closeWindow(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');\" name=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' onMouseOver=\"changeRowColor(this,";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =");\" >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" nowrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.getElementById(\"return_value\")";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =".value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t</table>\n\t\t<input type=\"Hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t<input type=\"Hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t<input type=\"Hidden\" name=\"sql\" id=\"sql\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t<input type=\"Hidden\" name=\"headArray\" id=\"headArray\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<input type=\"Hidden\" name=\"selectArray\" id=\"selectArray\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t<input type=\"Hidden\" name=\"link_field\" id=\"link_field\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\"Hidden\" name=\"searchBy\" id=\"searchBy\" value=\"\">\n\t\t<input type=\"Hidden\" name=\"headCountValue\" id=\"headCountValue\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\"Hidden\" name=\"src_value\" id=\"src_value\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<input type=\"Hidden\" name=\"prevNextClick\" id=\"prevNextClick\" value=\"Y\">\n\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<script>closeWindow(\'1\');</script>\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n<script>parent.lookup_head.document.getElementById(\"Search\").disabled\t= false;\t</script>\n</html>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );


public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}

public static boolean isNull(String inputString)
{
	return (((inputString == null) || (inputString.equals("null")) ) ? false : true);
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
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;
StringTokenizer strToken		=	null;	

String heading					=	"";
String data_value				=	"";
int start						=	0;
int end							=	0;
int record_count				=	0;

try
{
	String sqlString			=	checkForNull(request.getParameter("sql"));
	String headArray			=	checkForNull(request.getParameter("headArray"));
	String selectArray			=	checkForNull(request.getParameter("selectArray"));
	String search_text			=	checkForNull(request.getParameter("search_text"));
	String link_field			=	checkForNull(request.getParameter("link_field"));
	String from					=	checkForNull(request.getParameter("from"));
	String to					=	checkForNull(request.getParameter("to"));
	String searchBy				=	checkForNull(request.getParameter("searchBy"));
	String search_criteria		=	checkForNull(request.getParameter("search_criteria"));
	String headCountValue		=	checkForNull(request.getParameter("headCountValue"));
	String src_value			=	checkForNull(request.getParameter("src_value"));
	String prevNextClick		=	checkForNull(request.getParameter("prevNextClick"), "N");
	String class_value			=	"QRYEVEN";
	String visib				=	"";
	StringBuffer returnBuf		=	new StringBuffer();

	int index= search_text.indexOf("'");
	if(index != -1)
	{
	search_text = search_text.replace("'","''");
	}

	if (from.equals(""))
			start	=	1;
	else	start	=	Integer.parseInt(from);
	
	if (to.equals(""))
			end	=	18;
	else	end	=	Integer.parseInt(to);

	int headCntVal	=	-1;
	if (!headCountValue.equals("")) headCntVal = Integer.parseInt(headCountValue);

	connection					=	ConnectionManager.getConnection(request);

            _bw.write(_wl_block8Bytes, _wl_block8);


		if (!(search_text.trim()).equals(""))
		{
			/*Changed by vinod, to add a search criteria before 'order by' clause. - 7/26/2006 11:07 AM*/
			StringBuffer tempString	=	new StringBuffer();
			if (sqlString.indexOf(" ORDER BY") != -1)
				tempString.append(sqlString.substring(0, sqlString.indexOf(" ORDER BY")));
			else
				tempString.append(sqlString);
			if (sqlString.indexOf("where") != -1)
			{
				if (search_criteria.equals("S"))
				{
					tempString.append (" AND UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('");
					tempString.append(search_text);
					tempString.append("%')");
				}
				else if (search_criteria.equals("E"))
				{
					tempString.append(" AND UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('%");
					tempString.append(search_text);
					tempString.append("')");
				}

				else if (search_criteria.equals("C"))
				{
					tempString.append(" AND UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('%"); tempString.append(search_text);
					tempString.append("%')");
				}
			}
			else
			{
				if (search_criteria.equals("S"))
				{
					tempString.append(" WHERE UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('"); tempString.append(search_text);
					tempString.append("%')");
				}
				else if (search_criteria.equals("E"))
				{
					tempString.append(" WHERE UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('%"); tempString.append(search_text);
					tempString.append("')");
				}
				else if (search_criteria.equals("C"))
				{
					tempString.append(" WHERE UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('%"); tempString.append(search_text);
					tempString.append("%')");
				}
			}
			if (sqlString.indexOf(" ORDER BY") != -1)
			{
				tempString.append( sqlString.substring(sqlString.indexOf(" ORDER BY"),sqlString.length()));
			}
			sqlString = tempString.toString() ;
		}
	
		if (!searchBy.equals(""))
		{
			String tempString	=	"";
			if (sqlString.indexOf(" ORDER BY") != -1)
			{
				tempString	=	sqlString.substring((sqlString.lastIndexOf(" ORDER BY ")+10), sqlString.length());
				sqlString	=	sqlString.substring(0 , sqlString.indexOf(" ORDER BY "));
				if (tempString == null) tempString = "";
			}
			if (tempString.equalsIgnoreCase(searchBy))
				sqlString	=	sqlString + " ORDER BY "+ searchBy + " DESC ";
			else
				sqlString	=	sqlString + " ORDER BY "+ searchBy;
		}

		String subString	=	"";
		if (sqlString.indexOf("FROM") != -1) 
			subString	=	sqlString.substring(sqlString.indexOf("FROM"), sqlString.length());
		else if (sqlString.indexOf("from") != -1) 
			subString	=	sqlString.substring(sqlString.indexOf("from"), sqlString.length());
		subString	=	"SELECT COUNT(*) record_count " + subString;
		preStatement	=	connection.prepareStatement(subString);

		resultSet		=	preStatement.executeQuery();
		if ((resultSet != null) && (resultSet.next()))
			record_count	=	resultSet.getInt("record_count");
		if (record_count==0)
		{
		
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		else
		{
			if ((!(start <= 1)) || (!( (start+18) > record_count )))
			{
			
            _bw.write(_wl_block10Bytes, _wl_block10);

			if ( !(start <= 1) )
			{
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(start-18));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end-18));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
					
			if ( !( (start+11) > record_count ) )
			{
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((start+18)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end+18));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
			
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
		
            _bw.write(_wl_block16Bytes, _wl_block16);

		strToken				=	new StringTokenizer(headArray, ","); 
		int headCount			=	0;
		while (strToken.hasMoreTokens())
		{
			heading	=	strToken.nextToken();
			if (isNull(heading))
			{
				if (headCntVal==headCount)
				{
					visib		=	"Visibility : Visible";
					if (src_value.equals(""))
						src_value	=	"../../eAE/images/Ascending.gif";
					else if ((src_value.equals("../../eAE/images/Ascending.gif")) && (prevNextClick.equals("X")))
						src_value	=	"../../eAE/images/Descending.gif";
					else if (src_value.equals("../../eAE/images/Descending.gif") && (prevNextClick.equals("X")))
						src_value	=	"../../eAE/images/Ascending.gif";
				}
				else
					visib = "Visibility : Hidden";
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(headCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(heading));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(src_value));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(headCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(visib));
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
			headCount++;
		}
	
            _bw.write(_wl_block23Bytes, _wl_block23);


		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		preStatement	=	connection.prepareStatement(sqlString);
		resultSet		=	preStatement.executeQuery();
		int count		=	1;
		int tokenCount	=	0;
		int tdCount		=	1;
		if (resultSet != null)
		{
			if ( start != 1 )
				for( int j=1; j<start; count++,j++ )
					resultSet.next() ;
			while(resultSet.next() && count<=end)
			{
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
			
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(count));
            _bw.write(_wl_block26Bytes, _wl_block26);

				if (returnBuf.length()>0)
					returnBuf.delete(0, returnBuf.length());
				
				strToken				=	new StringTokenizer(selectArray, ",");
				tokenCount				=	strToken.countTokens();
				while (strToken.hasMoreTokens())
				{
					heading	=	strToken.nextToken();
					if (isNull(heading))
					{
						data_value	=	checkForNull(resultSet.getString(heading));
						if (link_field.equals(heading))
						{
						
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tdCount));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tokenCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(checkForNull(data_value, "&nbsp;")));
            _bw.write(_wl_block32Bytes, _wl_block32);

						}
						else
						{
						
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(checkForNull(data_value, "&nbsp;")));
            _bw.write(_wl_block32Bytes, _wl_block32);
	
						}
					} // End of If.
					if (returnBuf.length()>0)
						returnBuf.append("$$");
					returnBuf.append(data_value);
					
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(count));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(returnBuf.toString()));
            _bw.write(_wl_block36Bytes, _wl_block36);

				} // End of While
			
            _bw.write(_wl_block37Bytes, _wl_block37);

				count++;
				tdCount++;
			}
		}
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(from));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(to));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(sqlString));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(headArray));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(selectArray));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(link_field));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(headCountValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(src_value));
            _bw.write(_wl_block46Bytes, _wl_block46);

			if (record_count==1)
			{
			
            _bw.write(_wl_block47Bytes, _wl_block47);
		
			}
		}
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block48Bytes, _wl_block48);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
}
