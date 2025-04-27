package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __mopostmortemcase extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOPostmortemCase.jsp", 1709118413775L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\n\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\' > </script>\n<Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\t\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../js/MOPostmortemCase.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<script>\nfunction validDateObj(date, format, locale){\n\tif (date.value != \'\')\n\t{\n\t\tif ( !validDate(date.value, format, locale) )\n\t\t{\t\n\t\t\t\n\t\t\tif(format==\'YY\')\n\t\t\t{\n\t\t\t\tif(top.header != null)\n\t\t\t\talert(top.header.getMessage(\"INVALID_YEAR_FMT\", \"SM\"));\n\t\t\t\telse\n\t\t\t\talert(getMessage(\"INVALID_YEAR_FMT\", \"SM\"));\n\t\t\t}\n\t\t\telse\n\t\t\tif(format==\'DMY\'){\n\t\t\tif(top.header != null)\n\t\t\t\talert(top.header.getMessage(\"INVALID_DATE_FMT\", \"SM\"));\n\t\t\telse\n\t\t\t\talert(getMessage(\"INVALID_DATE_FMT\", \"SM\"));\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(top.header != null)\n\t\t\t\talert(top.header.getMessage(\"MONTH_YEAR_INVALID\", \"SM\"));\n\t\t\telse\n\t\t\t\talert(getMessage(\"MONTH_YEAR_INVALID\", \"SM\"));\n\t\t\t\t\n\t\t\t}\n\t\t\tdate.value=\"\";\n\t\t\tdate.select();\n\t\t\tdate.focus();\n\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t\treturn true;\n\t}\n}\nfunction compare_date1(from,to,localeName)\n{\n\t\n\tif(from.value !=\"\" && to.value !=\"\" )\n\t\t\tif(isBefore(from.value,to.value,\"DMY\",\"en\")==false) \n\t\t\t\t{\n\t\t\t\t\tvar invaldt = getMessage(\"TO_DT_GR_EQ_FM_DT\",\"SM\") ;\n\t\t\t\t\talert(invaldt);\n\t\t\t\t\tto.value=\"\";\n\t\t\t\t\tto.focus();\n\t\t\t\t\tto.select();\n\t\t\t\t}\n\t\n}\nfunction compare_date2(from,to,localeName)\n{\n\tif(from.value !=\"\" && to.value !=\"\" )\n\t\t\tif(isBefore(from.value,to.value,\"MY\",\"en\")==false) \n\t\t\t\t{\n\t\t\t\t\tvar invaldt = getMessage(\"REMARKS_MUST_GR_EQUAL\",\"COMMON\") ;\n\t\t\t\t\tvar to_year=getLabel(\"Common.to.label\",\"Common\")+\" \"+getLabel(\"Common.month.label\",\"Common\")+\"/\"+getLabel(\"Common.year.label\",\"Common\");\n\t\t\t\t\tvar from_year=getLabel(\"Common.month.label\",\"Common\")+\"/\"+getLabel(\"Common.year.label\",\"Common\");\n\t\t\t\t\tinvaldt = invaldt.replace(\'$\',to_year);\n\t\t\t\t\tinvaldt = invaldt.replace(\'#\',from_year);\n\t\t\t\t\talert(invaldt);\n\t\t\t\t\tto.value=\"\";\n\t\t\t\t\tto.focus();\n\t\t\t\t\tto.select();\n\t\t\t\t}\n\t\n}\n\n\nfunction compare_date(from,to,localeName)\n{\n\tvar from_val = convertDate(from.value,\'YY\',localeName,\'en\');\n\tvar to_val = convertDate(to.value,\'YY\',localeName,\'en\');\n\tif(from.value !=\"\" && to.value !=\"\" )\n\t\t\tif(to_val < from_val) \n\t\t\t\t{\n\t\t\t\t\tvar invaldt = getMessage(\"REMARKS_MUST_GR_EQUAL\",\"COMMON\") ;\n\t\t\t\t\tvar to_year=getLabel(\"Common.to.label\",\"Common\")+\" \"+getLabel(\"Common.year.label\",\"Common\");\n\t\t\t\t\tvar from_year=getLabel(\"Common.year.label\",\"Common\");\n\t\t\t\t\tinvaldt = invaldt.replace(\'$\',to_year);\n\t\t\t\t\tinvaldt = invaldt.replace(\'#\',from_year);\n\t\t\t\t\talert(invaldt);\n\t\t\t\t\tto.value=\"\";\n\t\t\t\t\tto.focus();\n\t\t\t\t\tto.select();\n\t\t\t\t}\n\t\n}\nfunction validate_date1(obj)\n{\n\t\t\tvar from = convertDate(obj.value,\'DMY\',localeName,\'en\');\n\t\t\tvar to  = convertDate(document.forms[0].CurrentDate1.value,\'DMY\',localeName,\'en\');\n\t\t\tif(from !=\"\")\n\t\t\tif(isBefore(from,to,\"DMY\",\"en\")==false) \n\t\t\t\t{\n\t\t\t\t\tvar invaldt = getMessage(\"START_DATE_GREATER_SYSDATE\",\"COMMON\") ;\n\t\t\t\t\talert(invaldt);\n\t\t\t\t\tobj.value=\"\";\n\t\t\t\t\tobj.focus();\n\t\t\t\t\tobj.select();\n\t\t\t\t}\n\t\n}\nfunction validate_date(obj) \n\t\t{\n\t\t\tvar from = convertDate(obj.value,\'YY\',localeName,\'en\');\n\t\t\tvar to   = convertDate(document.forms[0].CurrentDate.value,\'YY\',localeName,\'en\');\n\t\t\t\tif(to < from) \n\t\t\t\t{\n\t\t\t\t\tvar invaldt = getMessage(\"CAN_NOT_GREAT_CURR_YR\",\"IP\") ;\n\t\t\t\t\tvar stat_year=getLabel(\"Common.year.label\",\"Common\");\n\t\t\t\t\tinvaldt = invaldt.replace(\'$\',stat_year);\n\t\t\t\t\talert(invaldt);\n\t\t\t\t\tobj.value=\"\";\n\t\t\t\t\tobj.focus();\n\t\t\t\t\tobj.select();\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t\n\t\t}\nfunction validate_date_mon_year(obj) \n\t\t{ \n\t\t\t\t\n\t\tvar from = obj.value;\n\t\n\t\tvar to   = document.forms[0].CurrentDate1.value;\n        var fromarray;\n\t\tvar toarray;\n\t\tfromarray  = from.split(\"/\");\n\t\ttoarray    = to.split(\"/\");\n\n\t\tvar fromdt = new Date(fromarray[1],fromarray[0]);\n\t\tvar todt = new Date(toarray[1],toarray[0]);\n\n\t\tif (!isBeforeNow(obj.value,\"MY\",localeName)){\n\n\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) {\n\t\t\t\t \n\t\t\t\t\tvar invaldt\t\t = getMessage(\"REMARKS_SHOULD_LS_EQUAL\",\'common\') ;\n\t\t\t\t\tvar vis_adm_date = \"Month/Year\";\n\t\t\t\t\tvar currentDate  = \"Current Month/Year\";\n\t\t\t\t\tinvaldt=invaldt.replace(\'$\',vis_adm_date);\n\t\t\t\t\tinvaldt=invaldt.replace(\'#\',currentDate);\n\t\t\t\t\talert(invaldt);\n\t\t\t\t\tobj.value=\'\';\n\t\t\t\t\tobj.focus();\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t\n\t\t}\n\t\t\n</script>\n</head>\n<body  OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n<form name=\"menu_form\" id=\"menu_form\" action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\"  >\n<BR>\n\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"60%\" align=\'left\'>\n \n\n\n\n <tr>\n <td width=\"20%\"  class=\"label\"></td>\n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<td width=\"15%\"  class=\"label\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td width=\"7%\"  class=\"label\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'fields\' width=\"30%\"><input type=\'text\'  name=\'from_date\' id=\'from_date\'  onblur=\'validDateObj(this,\"DMY\",localeName);validate_date1(this);compare_date1(this,document.forms[0].to_date,localeName);\'  size=\"10\" maxlength=\"10\"   >&nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].from_date.select();return showCalendar(\'from_date\', null, null );\" style=\"cursor=\'hand\'\"><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\n\t <td width=\"5%\"  class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td class=\'fields\'><input type=\'text\'  name=\'to_date\' id=\'to_date\'  onblur=\'validDateObj(this,\"DMY\",localeName);validate_date1(this);compare_date1(document.forms[0].from_date,this,localeName);\'  size=\"10\" maxlength=\"10\"   >&nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].to_date.select();return showCalendar(\'to_date\', null, null );\" style=\"cursor=\'hand\'\"><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t   <td  class=\"fields\" width=\"30%\" ><input type=text  name=\'from_date\' id=\'from_date\' size=\"4\" maxlength=\"4\" align=\"center\"  onblur=\'validDateObj(this,\"YY\",localeName);validate_date(this);compare_date(this,document.forms[0].to_date,localeName);\'>&nbsp;<input type=\"image\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'from_date\',\'y\',null)\"><img  src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\n\t <td width=\"5%\"  class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<td  class=\"fields\" width=\"30%\" ><input type=text  name=\'to_date\' id=\'to_date\' size=\"4\" maxlength=\"4\" align=\"center\"  onblur=\'validDateObj(this,\"YY\",localeName);validate_date(this);compare_date(document.forms[0].from_date,this,localeName);\'>&nbsp;<input type=\"image\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'to_date\',\'y\',null)\"><img  src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\n\t   <td  class=\"fields\" width=\"30%\" ><input type=text  name=\'from_date\' id=\'from_date\' size=\"7\" maxlength=\"7\" align=\"center\"  onblur=\'validDateObj(this,\"MY\",localeName);validate_date_mon_year(this);compare_date2(this,document.forms[0].to_date,localeName);\'>&nbsp;<input type=\"image\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'from_date\',\'mm/y\',null)\"><img  src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\n\t <td width=\"5%\"  class=\"label\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t<td  class=\"fields\" width=\"30%\" ><input type=text  name=\'to_date\' id=\'to_date\' size=\"7\" maxlength=\"7\" align=\"center\"  onblur=\'validDateObj(this,\"MY\",localeName);validate_date_mon_year(this);compare_date2(document.forms[0].from_date,this,localeName);\'>&nbsp;<input type=\"image\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'to_date\',\'mm/y\',null)\"><img  src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\n    </tr>\n\t\n   \n   </table>\n    <input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\" \t\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name=\"CurrentDate\" id=\"CurrentDate\"\t\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name=\"CurrentDate1\" id=\"CurrentDate1\"\t\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\"hidden\" name=\"p_from_date\" id=\"p_from_date\" \t\tvalue=\"\">\n<input type=\"hidden\" name=\"p_to_date\" id=\"p_to_date\" \t\tvalue=\"\">\n\n</form>\n\n\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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

	Connection con =null;
	Statement stmt = null;
	ResultSet rs=null ;
	String strd="";
	String p_report_id="";
	String	facilityId 	= (String) session.getValue( "facility_id" ) ;
	String function_id = request.getParameter("function_id");
	String p_user_name			= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	String p_module_id="MO";
	String CurrentDate = "";
	String CurrentDate1="";
	if(function_id.equals("MO_MONTHLY_PM"))
		p_report_id="MOMPOSMC";
	else
	if(function_id.equals("MO_MONTHLY_INVESTIGATION_PM"))
		p_report_id="MOMIPMC";
	else
		p_report_id="MOMPMMLC";
	
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		String curr_date_qry ="select to_char(sysdate,'yyyy') CurrentDate,to_char(sysdate,'DD/MM/yyyy') CurrentDate1 from dual" ;
		
		rs = stmt.executeQuery(curr_date_qry);
		if(rs!=null && rs.next())
		{
			CurrentDate=rs.getString("CurrentDate");
			CurrentDate1=rs.getString("CurrentDate1");
			CurrentDate1=DateUtils.convertDate(CurrentDate1,"DMY","en",locale);
			CurrentDate = DateUtils.convertDate(CurrentDate,"YY","en",locale);
			
		}
	
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally 
	{ 
		if(rs != null)    rs.close();
		if(stmt != null)    stmt.close();
		ConnectionManager.returnConnection(con,request);
	}
		
		
	

            _bw.write(_wl_block6Bytes, _wl_block6);

     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	if(p_report_id.equals("MOMPOSMC"))
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else
	if(p_report_id.equals("MOMIPMC"))
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	else
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	}
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_module_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_report_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( CurrentDate ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( CurrentDate1 ));
            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.year.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.month.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.year.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
}
