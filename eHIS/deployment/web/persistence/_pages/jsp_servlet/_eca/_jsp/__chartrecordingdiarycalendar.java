package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecordingdiarycalendar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecordingDiaryCalendar.jsp", 1709115664637L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCA/html/IeStyle.css\"> \n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> -->\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCA/js/ChartRecording.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'chartRecordingDiaryCalendarForm\' id=\'chartRecordingDiaryCalendarForm\'>\n<table width=\'100%\' cellspacing=\'0\' cellpadding=\'3\' border=\'1\' bordercolor=\'#FFFFFF\'>\n<tr>\n<!-- <td class=\'columnHeader\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n<td class=\'columnHeader\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td> -->\n<td width=\'2\' class=\'columnHeader\'>Sun</td>\n<td width=\'2\' class=\'columnHeader\'>Mon</td>\n<td width=\'2\' class=\'columnHeader\'>Tue</td>\n<td width=\'2\' class=\'columnHeader\'>Wed</td>\n<td width=\'2\' class=\'columnHeader\'>Thu</td>\n<td width=\'2\' class=\'columnHeader\'>Fri</td>\n<td width=\'2\' class=\'columnHeader\'>Sun</td>\n</tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script>\nvar fromDate = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\nvar toDate = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\nvar currentDate = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\nif(fromDate == \"\" && toDate == \"\")\n{\n\t\t\tvar adm_date = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\".split(\" \");\n\t\t\tvar currentDate = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\tvar admArray = adm_date[0].split(\"/\");\n\t\t\tvar currArray = \tcurrentDate.split(\"/\");\n\t\t\tif(currArray[2] == admArray[2])\t\n\t\t\t\t{\n\t\t\t\t\tif(currArray[1] == admArray[1])\t\n\t\t\t\t\t\t{\n\t\t\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false\n\t\t\t\t\t}\n\t\t\t\t}\n\t\tvar sysdate = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\".split(\"/\");\n\n\t\tif(currArray[2] == sysdate[2])\n\t\t{\n\t\t\tif(currArray[1] == sysdate[1])\t\n\t\t\t\t\t\t{\n\t\t\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false\n\t\t\t\t\t\t}\n\t\t}\n\t\telse if(parseInt(currArray[2]) < parseInt(sysdate[2]))\n\t\t\t{\n\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false\n\n\t\t\t}\n\t\telse if(parseInt(currArray[2]) > parseInt( admArray[2]))\n\t\t{\n\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false\n\t\t}\n\n\n}\nif(!fromDate == \"\" && !toDate == \"\")\n{\n\n\tvar fromArray = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\".split(\" \");\n\tvar toArray =  \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\".split(\" \");\n\tvar currArray = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\".split(\"/\");\n\tvar toDateArray = toArray[0].split(\"/\");\n\tvar fromDateArray = fromArray[0].split(\"/\");\n\tif(fromDateArray[2] == currArray[2] )\n\t{\n\t\tif(currArray[1] == fromDateArray[1] )\n\t\t{\n\t\t\t\n\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true\n\n\t\t}\n\t\telse\n\t\t{\n\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false\n\t\t}\n\n\t}\nif(toDateArray[2] == currArray[2] )\n\t{\n\t\t\n\t\tif(currArray[1] == toDateArray[1] )\n\t\t{\n\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false\n\t\t}\n\n\t}\n\tif(parseInt(toDateArray[2]) > parseInt(currArray[2]))\n\t{\n\t\t\n\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false\n\t}\n\tif(parseInt(fromDateArray[2]) < parseInt(currArray[2]))\n\t{\n\t\t\n\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false\n\n\t}\n\n}\nelse\n{\n\tif(!fromDate == \"\")\n\t{\n\t\tvar sysdate = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\".split(\"/\");\n\t\tvar fromArray = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\".split(\" \");\n\t\tvar fromDateArray = fromArray[0].split(\"/\");\n\t\tvar currArray = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\".split(\"/\");\n\t\tif(currArray[2] == fromDateArray[2])\n\t\t{\n\t\t\tif(fromDateArray[1] == currArray[1] )\n\t\t\t{\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false\n\t\t\t}\n\t\t}\n\t\tif(fromDateArray[2] > sysdate[2]) \n\t\t{\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true\n\t\t}\n\t\tif(currArray[2] == sysdate[2])\n\t\t{\n\t\t\tif(currArray[1] == sysdate[1])\n\t\t\t{\n\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false\n\t\t\t}\n\t\t}\n\t\tif(currArray[2]  < sysdate[2])\n\t\t{\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false\n\t\t}\n\t\tif(currArray[2]  > fromDateArray[2])\n\t\t{\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false\n\t\t}\n\t\tif(currArray[2]  < fromDateArray[2])\n\t\t{\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false\n\t\t}\n\n\n\t}\n\tif(!toDate == \"\")\n\t{\n\t\tvar adm_date = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\".split(\" \");\n\t\tvar admArray = adm_date[0].split(\"/\");\n\t\tvar toArray = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\".split(\" \");\n\t\tvar toDateArray = toArray[0].split(\"/\");\n\t\tvar currArray = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\".split(\"/\");\n\t\tvar sysdate = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\".split(\"/\");\n\t\tif(parseInt(toDateArray[2]) <= parseInt(sysdate[2]))\n\t\t{\n\t\t\t//parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true\n\t\t\t//parent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true\n\t\t}\n\t\tif(currArray[2] == admArray[2])\n\t\t{\n\t\t\tif(currArray[1] == admArray[1])\n\t\t\t{\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = true\n\t\t\t}\n\t\t\telse \n\t\t\t{\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false\n\t\t\t}\n\t\t}\n\t\tif(currArray[2] == toDateArray[2])\n\t\t{\n\t\t\t\tif(currArray[1] == toDateArray[1])\n\t\t\t\t{\n\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = true\n\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t{\n\t\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false\n\t\t\t\t}\n\t\t}\n\t\tif(currArray[2] < toDateArray[2])\n\t\t{\n\t\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonNextDate.disabled = false\n\t\t}\n\tif(currArray[2] > admArray[2])\n\t\t{\n\t\t\tparent.ChartRecordingDiaryCalendarFrameTop.ChartRecordingDiaryTopForm.buttonPrevDate.disabled = false\n\t\t}\n\n\n\t}\n}\n\n</script>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

	Connection con = null;
	ResultSet rs= null;
	PreparedStatement pstmt = null;
	StringBuffer sql = new StringBuffer();
	StringTokenizer tokenPipe = null;
	StringTokenizer tokenTilde = null;
	String sysdate = "";
	String facility_id  = session.getValue("facility_id")==null ? "" :(String)session.getValue("facility_id");
	
	String encounterId = request.getParameter("encounterId")==null ? "" :  request.getParameter("encounterId");

	String chart_id = request.getParameter("chartId")==null ? "" :  request.getParameter("chartId");

	String adm_date =  request.getParameter("adm_date")==null ? "" :  request.getParameter("adm_date");
	String date =  request.getParameter("currentDate")==null ? "" :  request.getParameter("currentDate");
	String prevDate = "";
	String fromDate=request.getParameter("fromDate")==null ? "" :  request.getParameter("fromDate");
	String toDate=request.getParameter("toDate")==null ? "" :  request.getParameter("toDate");
	StringTokenizer tokenDollar = null;
//String prevDate1="";
	String detailSelect = request.getParameter("detailSelect")==null?"":request.getParameter("detailSelect");

	try
	{
		con= ConnectionManager.getConnection(request);
		sql.append("select to_char(sysdate,'dd/mm/yyyy') current_date,CA_Get_Stay_Calendar_string(?,?,?,?,? ");
		if(fromDate.equals("") && toDate.equals(""))
		{
			sql.append( " ) from dual ");
		}
		else if(!(fromDate.equals("") && toDate.equals("")))
		{
				sql.append( ",?,?) from dual "); 
		}
		else 
		{
			if(!fromDate.equals(""))
			{
				sql.append( ",? "); 
			}
			if(!toDate.equals(""))
			{
				sql.append( ",? ");
			}
			sql.append( " ) from dual ");
		}


		pstmt= con.prepareStatement(sql.toString());	
		pstmt.setString(1,facility_id);
		pstmt.setString(2,encounterId);
		pstmt.setString(4,date);
		pstmt.setString(3,chart_id);
		pstmt.setString(5,detailSelect);
		if(!(fromDate.equals("") && toDate.equals("")))
		{
				//pstmt.setString(6,fromDate);
				pstmt.setString(6,toDate);
				pstmt.setString(7,fromDate);
		}
		if(!fromDate.equals(""))
		{
					//pstmt.setString(6,fromDate);
					pstmt.setString(7,fromDate);
		}
		if(!toDate.equals(""))
		{
					//pstmt.setString(6,toDate);
					pstmt.setString(6,toDate);
		}
		rs= pstmt.executeQuery();
		prevDate =date;
		while(rs.next())
		{
			date = rs.getString(2) == null ? "" :  rs.getString(2);
			sysdate= rs.getString(1) == null ? "" :  rs.getString(1);
		}
		int count =0;

		if(!date.equals(""))
		{
			
			if(date.indexOf("$") !=-1)
			{
				tokenDollar = new StringTokenizer(date,"$");
				//prevDate1 = tokenDollar.nextToken();
				tokenDollar.nextToken();
				date  = tokenDollar.nextToken();
			}
			if(date.indexOf("|") != -1)
			{
				tokenPipe = new StringTokenizer(date,"|");
				out.println("<tr>");
				String tempString = "";
				String toolTip = "";
				String checkUpDate = "";
				String classValue="";
				while(tokenPipe.hasMoreTokens())
					{
					count++;
					tempString = tokenPipe.nextToken();
					toolTip = "";
					checkUpDate = "";
					if(tempString.equals("0")) 
						tempString="&nbsp;";
					else if(tempString.indexOf("~") != -1)
					{
						tokenTilde = new StringTokenizer(tempString,"~");
						
							tempString = tokenTilde.nextToken(); 
							checkUpDate = tokenTilde.nextToken(); 
							if(tokenTilde.countTokens() != 0)
							toolTip =  tokenTilde.nextToken(); 
					}
					if(checkUpDate.equals(""))
					{
						if(count % 2 == 0)	
								classValue="QRYEVEN";
							else 
								classValue="QRYODD";
					}
					else
					{
							classValue="CAGREENSMALL";
					}
					if(checkUpDate.equals(""))	
					{					
						out.println("<td width='2' class='"+classValue+"' title='"+toolTip+"'>"+tempString+"</td>");
					}
					else
					{
						out.println("<td width='2' class='"+classValue+"' title='"+toolTip+"' OnClick='getDetailDate(\""+tempString+"\",\""+prevDate+"\")'>"+tempString+"</td>");
					}

					if(count==7)
					{
						out.println("</tr>");	
						//out.println("<tr>");
						count=0;
					}
				}
			}
		}
		if(rs !=null)  rs.close();
		if(pstmt != null)pstmt.close();	


            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(prevDate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(adm_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(prevDate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(prevDate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(prevDate));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(adm_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(prevDate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block26Bytes, _wl_block26);

}
catch(Exception ee)
{
	//out.println("Error fromChartRecordingDiaryBottom jsp :"+ee.toString());//COMMON-ICN-0181
	ee.printStackTrace();
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
}

            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.sun.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.mon.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.tue.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.wed.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.thu.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fri.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.sat.label", java.lang.String .class,"key"));
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
