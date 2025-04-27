package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifyholidayresultbydate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/AddModifyHolidayResultBydate.jsp", 1709119216491L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tSuman\n\tCreated on \t:\t19/04/2006\n\tModule\t\t:\tOA\n-->\n\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eOA/js/Holiday.js\' language=\'javascript\'></SCRIPT>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t\t<form name=\'Holiday_result\' id=\'Holiday_result\' action=\'\' method=\'post\' target=\'\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\n\t\t\t\t\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\n\t<table width=\'80%\' border=0 align=\'center\' >\n\t\t<tr>\n\t\t<td align=\'right\' class=\'NONURGENT\'>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<a href=\'javascript:submitPrevNext1(";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =",";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")\' id=\'prev\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =")\' id=\'next\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a><input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\n\t</td>\n\t </tr>\n\t\t\t\t\t\t\n\t\t</table>\n\n\n\t\t\t<!-- <div id=\'header\' style=\"visibility:visible;backgroundColor:white;overflow:scroll\">\n\t\t\t\t<table border=\"1\" width=\"80%\" bgColor=white align=\'center\' cellspacing=\'0\' cellpadding=\'0\' id=\'result_locn1\'>\n\t\t\t\t<th align=\'center\'  width=\'22%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t\t<th align=\'center\'  width=\'23%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t\t\t<th align=\'center\'  width=\'28%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;<img id=\'image\' align=center src=\'../../eCommon/images/mandatory.gif\'></img></th>\n\t\t\t\t<th align=\'center\'  width=\'18%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t\t\t\t</table></div> -->\n\t\t\t\t<table border=\"1\" width=\"80%\" align=\'center\' bgColor=white cellspacing=\'0\' cellpadding=\'0\' id=\'result_locn2\'>\n\t\t\t\t<th align=\'center\'  width=\'22%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\n\t\t\t<tr>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" width=\'22%\'  nowrap align=\'left\' > &nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;&nbsp;</td>\n\t     \t<td class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" width=\'23%\'  nowrap align=\'left\' > &nbsp;";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;&nbsp;&nbsp;</td>\n\t\t\t<input type=\'hidden\' name=\'holiday_date";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'holiday_date";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\n\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"  width=\'28%\' nowrap >&nbsp;<input type=\'Text\' name=\'reason_for_holiday";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'reason_for_holiday";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' size=\'32\' maxlength=\'25\' onblur=\"chk_value_reason(this,";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =")\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" nowrap style\n\t\t\t=\'align:center\'>\n\t\t\t<input type=\'checkbox\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="  name=\'select_yn";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'  width=\'18%\'\tOnclick=\"change_val(this,";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =",\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\')\"  value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" \" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t><input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'removeCode";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' value=\"\"><input type=\'hidden\' name=\'Code";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'Code";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" ><input type=\'hidden\' name=\'val";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'val";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t\t</td>\n            </tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));history.go(-1);</script>\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t<script >\n\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t</table>\n\t<input type=\'hidden\' name=\'location_type\' id=\'location_type\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\'   value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t<input type=\'hidden\' name=\'b_clinic\' id=\'b_clinic\'   value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t<input type=\'hidden\' name=\'locationType\' id=\'locationType\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t<input type=\'hidden\' name=\'holiday_date\' id=\'holiday_date\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t<input type=\'hidden\' name=\'holiday_end_date\' id=\'holiday_end_date\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet holidayvaldate= null;synchronized(session){
                holidayvaldate=(webbeans.eCommon.RecordSet)pageContext.getAttribute("holidayvaldate",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(holidayvaldate==null){
                    holidayvaldate=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("holidayvaldate",holidayvaldate,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con =null;
Statement stmt=null;
ResultSet rSet=null;
ResultSet rs=null;
PreparedStatement pstmt=null;
String holiday_date_to_create_disply="";
String fnval = "insert";
String locale			= (String)session.getAttribute("LOCALE");
String facilityId = (String) session.getValue( "facility_id" ) ;
String holiday_date=request.getParameter("holiday_date")==null?"":request.getParameter("holiday_date");
String holiday_end_date=request.getParameter("holiday_end_date")==null?"":request.getParameter("holiday_end_date");

if(holiday_end_date =="" ) holiday_end_date=holiday_date;

holiday_date=DateUtils.convertDate(holiday_date,"DMY",locale,"en");
holiday_end_date=DateUtils.convertDate(holiday_end_date,"DMY",locale,"en");

String location_type=request.getParameter("location_type")==null?"":request.getParameter("location_type");

String clinic_code=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");

String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
int start = 0 ;
int end = 0 ;
int totrec=0;/*Added By Dharma on 3rd March 2015 against HSA-CRF-0184 [IN:049544]*/
int maxrecord=0;
int s=0;
StringBuffer sql2 = new StringBuffer();
StringBuffer sql3 = new StringBuffer();
String sqlmain1="";
String req_start    =   "", req_end     =   "", reason_code="";
String checkedOnes="";

req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
String removeCode		= "";

String flagSelect = request.getParameter("flagSelect");

String clinic_desc="";
String holiday_date_to_create="";
//String checked1="N";
String class_value	= "QRYEVEN";



	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;



try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);/*Added By Dharma on 3rd March 2015 against HSA-CRF-0184 [IN:049544]*/
		//stmt = con.createStatement();
		String  cp_type=location_type;//added  by Munisekhar for ML-BRU-SCF-1077 [IN:044018] 
		if(location_type.equals("D")){
				sql3.append(" AND A.CLINIC_TYPE = 'Y' ");
				cp_type="Y";//added  by Munisekhar for ML-BRU-SCF-1077 [IN:044018]
			}else{
				sql3.append(" AND A.CLINIC_TYPE = '"+location_type+"' ");
			}	

		if(!clinic_code.equals(""))
		{
			sql3.append(" AND A.CLINIC_CODE = '"+clinic_code+"'");
		}else
		{
			
				sql3.append(" AND A.EFF_STATUS = 'E' AND A.LEVEL_OF_CARE_IND = 'A' AND A.ALLOW_APPT_YN = 'Y' ");
			
		}

		sql3.append("AND A.CARE_LOCN_TYPE_IND = '"+location_type+"' ");
			
			

		if(flagSelect !=null)
		{
				holidayvaldate.clearAll();
			//holidayvaldate_reason.clearAll();
		}
		String checkedOnes1="";
		String reason_val="";
		String finalval="";
	//	String checkboxyn="";

		if(from != null && to != null)
		{
             
		 	 int j=0;
			 for( s=(Integer.parseInt(req_start)); s<=(Integer.parseInt(req_end)); s++)
			 {
				 if(request.getParameter("select_yn"+(s)) != null)
				 {
					 checkedOnes = request.getParameter("select_yn"+(s));
					 checkedOnes1 = request.getParameter("val"+(s));
				
                     reason_val=request.getParameter("reason_for_holiday"+(s));
								 
					 finalval=checkedOnes1+"|"+reason_val;
					// if(!(holidayvaldate.containsObject(checkedOnes1)))
					  if(!(holidayvaldate.containsObject(finalval)))
					 {
				    holidayvaldate.putObject(finalval);
					// holidayvaldate.putObject(checkedOnes1);
					// holidayvaldate_reason.putObject(finalval);
						 j++;
					 }
					 }
		/*	 if(select_yn1.equals("Y"))
                 checkboxyn="CHECKED";
                  else
                 checkboxyn="";*/

				
				removeCode = checkForNull(request.getParameter("removeCode"+(s)));
				if(removeCode.equals("Y"))
				{
					String Code = request.getParameter("Code"+(s));
					String str=null;
					for(int index=0;index<holidayvaldate.getSize();index++){
						str=(String)(holidayvaldate.getObject(index));
						if(str.contains(Code)){	
							holidayvaldate.removeObject(index);
						}
					}
					/*if((holidayvaldate.containsObject(Code)))
					{
						int removeCodeIndex = holidayvaldate.indexOfObject(Code);
							holidayvaldate.removeObject(removeCodeIndex);
							//holidayvaldate_reason.removeObject(removeCodeIndex);
					}*/
				}
			 }
			 

			 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
			 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+s+"'>");
		 }

		
		
            _bw.write(_wl_block8Bytes, _wl_block8);

		
//		sql2.append("select distinct a.clinic_code clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_val, b.holiday_date from op_clinic_lang_vw a, oa_holiday b where a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and b.holiday_date between to_date('"+holiday_date+"','dd/mm/yyyy') and to_date('"+holiday_end_date+"','dd/mm/yyyy') and a.EFF_STATUS='E'and (a.facility_id,a.clinic_code) not in (select facility_id,locn_code from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code) ");
		
		// sql2.append("select distinct a.clinic_code clinic_code, a.long_desc clinic_desc, to_char(to_date('"+holiday_date+"','dd/mm/yyyy'),'dd/mm/yyyy') holiday_val, to_char(to_date('"+holiday_end_date+"','dd/mm/yyyy') ,'dd/mm/yyyy') holiday_date from op_clinic_lang_vw a where a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E'and (a.facility_id,a.clinic_code) not in (select facility_id, locn_code from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code and holiday_date between to_date('"+holiday_date+"','dd/mm/yyyy') and to_date('"+holiday_end_date+"','dd/mm/yyyy')) ");
		
		/*Added By Dharma on 3rd March 2015 against HSA-CRF-0184 [IN:049544] Start*/
		sql2.append("select distinct a.clinic_code clinic_code, a.long_desc clinic_desc, to_char(b.holiday_date,'dd/mm/yyyy') holiday_val,b.holiday_date from op_clinic a, oa_holiday b where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and b.holiday_date between to_date('"+holiday_date+"','dd/mm/yyyy') and to_date('"+holiday_end_date+"','dd/mm/yyyy') and a.EFF_STATUS='E'and (a.facility_id,a.clinic_code) not in (select facility_id,locn_code from oa_holiday where facility_id=a.facility_id and locn_code=a.clinic_code) ");
		
		sqlmain1=sql2.toString()+sql3.toString()+" order by holiday_date";
		rSet = stmt.executeQuery(sqlmain1);
		rSet.last();
		totrec = rSet.getRow();
		rSet.beforeFirst();
		if(totrec==0) {
			if(rSet!=null)rSet.close();
			sql2.setLength(0);
			/*Added By Dharma on 3rd March 2015 against HSA-CRF-0184 [IN:049544] End*/

			sql2.append(" SELECT L1.CLINIC_CODE, L1.CLINIC_DESC, TO_CHAR(L2.TRN_DATE,'DD/MM/YYYY') HOLIDAY_VAL,L2.TRN_DATE TRN_HOL_DATE FROM ( SELECT A.CLINIC_CODE CLINIC_CODE, A.LONG_DESC CLINIC_DESC FROM OP_CLINIC_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND A.FACILITY_ID = '"+facilityId+"'  ");
			sql2.append(sql3.toString());
			 //modified  by Munisekhar for ML-BRU-SCF-1077 [IN:044018]
			sql2.append(" AND A.EFF_STATUS = 'E' AND (A.FACILITY_ID,A.CLINIC_CODE) NOT IN (SELECT FACILITY_ID, LOCN_CODE FROM OA_HOLIDAY WHERE FACILITY_ID = A.FACILITY_ID AND LOCN_CODE = A.CLINIC_CODE AND  A.CLINIC_TYPE='"+cp_type+"' AND A.CARE_LOCN_TYPE_IND='"+location_type+"' ) )L1, (SELECT TO_DATE('"+holiday_date+"','dd/mm/rrrr') + ROWNUM - 1 TRN_DATE FROM SM_FUNCTION WHERE ROWNUM <= TO_DATE('"+holiday_end_date+"','dd/mm/rrrr')+1 - TO_DATE('"+holiday_date+"','dd/mm/rrrr')) L2 ORDER BY TRN_HOL_DATE asc ");

			//sqlmain1=sql2.toString()+sql3.toString();
			sqlmain1=sql2.toString();
			rSet = stmt.executeQuery(sqlmain1);
			// out.println(sqlmain1);
			//out.println("RESULTSET"+rSet.getRow());

		}/*Added By Dharma on 3rd March 2015 against HSA-CRF-0184 [IN:049544]*/
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(start));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end));
            _bw.write(_wl_block13Bytes, _wl_block13);

			
				s=1;
				if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rSet.next() ;
				}

				String clinic_code1="";
				String chkAttribute="";
				String val2="";
				
			if(rSet !=null)
			{
				while ( s<=end && rSet.next() )
				{
					if(maxrecord==0)
					{
			
			
            _bw.write(_wl_block14Bytes, _wl_block14);

		if ( !(start <= 1)) {
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
//		if ( !((start+10) > maxrecord ))
			{
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
	
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
 } 
					
					clinic_code1=rSet.getString("clinic_code");
					holiday_date_to_create=rSet.getString("holiday_val");
					clinic_desc=rSet.getString("clinic_desc");

					int sch_cnt = 0;
					String flag_val="";
					//String sqlstr = "select count(1) cnt from oa_clinic_schedule where facility_id = '"+facilityId+"' and clinic_date = to_date('"+holiday_date_to_create+"','dd/mm/yyyy') and care_locn_type_ind='"+location_type+"' and clinic_code = '"+clinic_code1+"'";
					String sqlstr = "select count(1) cnt from oa_clinic_schedule where facility_id = ? and clinic_date = to_date(?,'dd/mm/yyyy') and care_locn_type_ind=? and clinic_code = ?";
					pstmt=con.prepareStatement(sqlstr);
					pstmt.setString(1,facilityId);
					pstmt.setString(2,holiday_date_to_create);
					pstmt.setString(3,location_type);
					pstmt.setString(4,clinic_code1);
					//out.println("sqlstr ==>"+sqlstr);
					rs=pstmt.executeQuery();
					if (rs!=null && rs.next()){
						
						sch_cnt=rs.getInt("cnt");
						
					}
			if (sch_cnt >0) 
				{
				flag_val="S";
				}else
				{
				flag_val="N";
				}

					val2=clinic_code1+"|"+holiday_date_to_create+"|"+flag_val;

					if(holidayvaldate.containsObject(val2))  
		
						chkAttribute = "CHECKED";
				 	else
						chkAttribute="";


					int recordIndex = holidayvaldate.indexOfObject(val2);
					if(recordIndex!=-1)
					if(chkAttribute.equals("CHECKED")) 
					{
					holidayvaldate.removeObject(recordIndex);
					//holidayvaldate_reason.removeObject(recordIndex);

					}

					if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
					else
					class_value = "QRYEVEN";

					holiday_date_to_create_disply=DateUtils.convertDate(holiday_date_to_create,"DMY","en",locale);

					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(holiday_date_to_create_disply));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(s));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(s));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(holiday_date_to_create));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(holiday_date_to_create));
            _bw.write(_wl_block35Bytes, _wl_block35);


				reason_code="";
					if(holidayvaldate.getSize() >0)
					{
						for(int m=0;m<holidayvaldate.getSize();m++)
						{
							String reason=(String)holidayvaldate.getObject(m);


							StringTokenizer token1=new StringTokenizer(reason,"|");
								while(token1.hasMoreTokens())
								{
											
								String clinic_code2=token1.nextToken();
								String date2=token1.nextToken();
								String chk2=token1.nextToken();
    							String fin_val=clinic_code2+"|"+date2+"|"+chk2;
								String reason2=token1.nextToken();
							
								if(val2.equals(fin_val))
								{
									reason_code=reason2;
									break;
								}

							}
						}
					}
				String chkAttribute1="";
				String reasonCode=reason_code;			
			  if(reasonCode!=null && !reasonCode.equals(""))
              chkAttribute1="CHECKED";
                 else
                chkAttribute1=""; 

										
			
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(s));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(s));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(s));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(reason_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
reason_code="";
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(s));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(s));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(flag_val));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(val2));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(chkAttribute1));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(s));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(s));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(s));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(s));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(val2));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(s));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(s));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(val2));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(val2));
            _bw.write(_wl_block56Bytes, _wl_block56);

					s++;
					maxrecord++;
				}//end of while
			}

		if(maxrecord == 0)
		{
            _bw.write(_wl_block57Bytes, _wl_block57);
}

		if ( maxrecord < 10 || (!rSet.next()) ) {
		
            _bw.write(_wl_block58Bytes, _wl_block58);
 
				} else {
            _bw.write(_wl_block59Bytes, _wl_block59);
}

	
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(holiday_date));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(holiday_end_date));
            _bw.write(_wl_block67Bytes, _wl_block67);

		if(stmt !=null) stmt.close();
		if(rSet !=null) rSet.close();

	}catch(Exception e)
	{
		//out.print(e);
		e.printStackTrace();
	}finally
	{
		 ConnectionManager.returnConnection(con,request);
		 session.setAttribute("holidayvaldate", holidayvaldate);
		// session.setAttribute("holidayvaldate_reason",holidayvaldate_reason);

	}

            _bw.write(_wl_block68Bytes, _wl_block68);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForHoliday.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForHoliday.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }
}
