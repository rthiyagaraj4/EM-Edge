package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __medicaleventsdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MedicalEventsDetail.jsp", 1709184049647L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/dchk.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCA/js/MedicalEvents.js\' language=\'javascript\'></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n</head>\n\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<form name=\'MajorEventsAddModify\' id=\'MajorEventsAddModify\' method=\'post\' action=\'../../servlet/eCA.MajorMedicalEventsServlet\' target=\'messageFrame\'>\n<div align=\'left\'>\n<table border=0 cellspacing=0 cellpadding=3 align=center width=\'80%\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<tr>\n\t\t<td  class=label width=\'40%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<td class=\'fields\' width=\'60%\' ><select name=\"med_event_type_code\" id=\"med_event_type_code\">\n\t\t\t<option value=\"\">------------";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="-----------</option>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="> ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</select>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></td>\n\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=label  width=\'40%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td class=\'fields\' width=\'60%\'><input type=\"text\" name=\"event_sdate\" id=\"event_sdate\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" size=10 maxlength=10 onblur=\'CheckStartDate(this)\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'event_sdate\');\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="><img src=\"../../eCommon/images/mandatory.gif\" > </td>\n\t\t\t\t\n\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=label width=\'40%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t<td class=\'fields\' width=\'60%\'><input type=\"text\" name=\"event_edate\" id=\"event_edate\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" size=10 maxlength=10 onblur=\'CheckEndDate(this)\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'event_edate\');\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</td>\n\t\t\t\t\n\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=label width=\'40%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t<td class=\'fields\' width=\'60%\'><textarea name=\"event_details\" rows=\"3\" cols=\"50\" maxlength=\'2000\' onkeyPress=\'checkMaxLimit(this,2000)\'  onBlur=\"return makeValidString(this);checkMaxLimit(this,2000)\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</textarea><img src=\"../../eCommon/images/mandatory.gif\"  ></td>\n\t\t\t\t\n\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=label width=\'40%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t<td class=\'fields\' width=\'60%\'><input type=\"checkbox\" name=\"event_confirmed_flag\" id=\"event_confirmed_flag\" value=\'Y\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="  ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" ></td>\n\t\t\t\t\n\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td align=\'left\' class=\'white\'>\n\t\t\t<td  class=\'white\' align=right><input type=\"button\" class=button name=\"Record\" id=\"Record\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onclick=\"apply()\">&nbsp;<input type=\"button\" class=button name=\"Clear\" id=\"Clear\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onclick=\"clearme()\">&nbsp;<input type=\"button\" class=button name=Cancel value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onclick=\"cancelOperation()\"></td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n</table>\n<input type=\'hidden\' name=\'mode\' id=\'mode\'\t\tvalue=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\'\tvalue=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'\tvalue=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n<input type=\'hidden\' name=\'called_from\' id=\'called_from\'\tvalue=\"CA\">\n<input type=\'hidden\' name=\'dob\' id=\'dob\'\t\t\tvalue=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n<input type=\'hidden\' name=\'med_event_type_code1\' id=\'med_event_type_code1\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n<input type=\'hidden\' name=\'confirmed\' id=\'confirmed\'  >\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<script language=javascript>\n\t\t\t\ttop.content.messageFrame.location.href= \"../../eCommon/jsp/error.jsp\";\n\t\t</script>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

	public String checkForNull(String inputString)
	{
		return ((inputString==null)? "" : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	
	String	mode					=	"";
	String	patient_id				=	"";
	String  med_event_type_code		=	"";	
	String  event_sdate				=	"";
	String	event_edate				=	"";
	String  event_psdate			=	"";
	String	event_pedate			=	"";

	String	event_details			=	"";
	String	event_confirmed_flag	=	"";
	String	event_confirmed_checked	=	"";
	String	dob						=	"";
	String	display_prop			=	"";
	String	disable_prop			=	"";
	String	sys_date				=	"";
	String	tmp_med_event_type_code	=	"";
	String	tmp_med_event_type_desc	=	"";
	String	selected_prop			=	"";
	String	query_mr_med_event_type	=	"";
	StringBuffer	query_sys_date			=	new StringBuffer();
	StringBuffer	query_mr_med_event_log	=	new StringBuffer();
	

	int		log_count				=	0;

	try
	{

		con						=	ConnectionManager.getConnection(request);

		patient_id				=	checkForNull(request.getParameter("patient_id"));
		med_event_type_code		=	checkForNull(request.getParameter("med_event_type_code"));
		event_sdate				=	checkForNull(request.getParameter("event_sdate"));

		event_psdate			=	event_sdate;

		if(!event_psdate.equals("&nbsp;") )
			event_psdate	= com.ehis.util.DateUtils.convertDate(event_psdate,"DMY","en",locale);

		/*query_sys_date			=	" select to_char(date_of_birth,'dd/mm/yyyy') dob, "+
									" to_char(sysdate,'dd/mm/yyyy') sys_date "+
									" from mp_patient where patient_id = ? ";*/
		if(query_sys_date.length() > 0) query_sys_date.delete(0,query_sys_date.length());

		query_sys_date.append(" select to_char(date_of_birth,'dd/mm/yyyy') dob ");
		query_sys_date.append(" from mp_patient where patient_id = ? ");

		pstmt					=	con.prepareStatement(query_sys_date.toString());
		pstmt.setString	(1,	patient_id	);
		rs						=	pstmt.executeQuery();
		
		if(rs.next())
			dob					=	rs.getString("dob");
		
		sys_date		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		dob				= com.ehis.util.DateUtils.convertDate(dob,"DMY","en",locale);

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		if(med_event_type_code.equals(""))		mode = "insert";
		else
		{
			mode					=	"modify";
			if(query_mr_med_event_log.length() > 0) query_mr_med_event_log.delete(0,query_mr_med_event_log.length());
			query_mr_med_event_log.append(" select to_char(event_edate,'dd/mm/yyyy') event_edate1, ");
			query_mr_med_event_log.append(" event_details, event_confirmed_flag ");
			query_mr_med_event_log.append(" from mr_med_event_log");
			query_mr_med_event_log.append(" where patient_id = ? and  med_event_type_code= ? ");
			query_mr_med_event_log.append(" and to_char(event_sdate,'dd/mm/yyyy') = ?  "); 

			pstmt					=	con.prepareStatement(query_mr_med_event_log.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			pstmt.setString	(	1,	patient_id			);
			pstmt.setString	(	2,	med_event_type_code	);
			pstmt.setString	(	3,	event_sdate			);

			rs						=	pstmt.executeQuery();

			rs.last();

			log_count	=	rs.getRow();
			//out.println("<script>alert('log_count="+log_count+"')</script>");
			if (log_count==0)	mode		=	"insert";
			else				mode		=	"modify";

			rs.beforeFirst();

			while(rs.next())
			{
				event_edate				=	checkForNull(rs.getString("event_edate1"));
				event_details			=	checkForNull(rs.getString("event_details"));
				event_confirmed_flag	=	checkForNull(rs.getString("event_confirmed_flag"));

				if(event_confirmed_flag.equals("Y"))
				{
					event_confirmed_checked	=	" CHECKED ";
					disable_prop			=	" DISABLED ";
				}

				event_pedate			=	event_edate;

				if(!event_pedate.equals("&nbsp;") )
					event_pedate	= com.ehis.util.DateUtils.convertDate(event_pedate,"DMY","en",locale);

			}
		}
		
			if(mode.equals("modify"))	display_prop	=	"readOnly";

	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(display_prop.equals("readOnly"))
		{
			
			out.println("<td class='fields' width='60%' ><input type='text' name=\"med_event_type_code\" id=\"med_event_type_code\" value=\""+med_event_type_code+"\"  readonly>");
		}
		else
		{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			try
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				//query_mr_med_event_type	=	"Select med_event_type_code, short_desc from mr_med_event_type  where eff_status='E' order by 2";

				query_mr_med_event_type = "Select med_event_type_code, short_desc from mr_med_event_type_LANG_VW  a where a.eff_status='E' AND LANGUAGE_ID = ? order by 2 ";

				pstmt					=	con.prepareStatement(query_mr_med_event_type);
				pstmt.setString	( 1, locale );
				rs						=	pstmt.executeQuery();
				while(rs.next())
				{
					tmp_med_event_type_code	=	rs.getString(1);
					tmp_med_event_type_desc	=	rs.getString(2);

					if(tmp_med_event_type_code.equals(med_event_type_code))
						selected_prop		=	"selected";
					else
						selected_prop		=	"";
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(tmp_med_event_type_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(selected_prop));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tmp_med_event_type_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

				}
				if(rs!=null) rs.close();
				if(pstmt!=null)	pstmt.close();
			}
			catch( Exception e)
			{
				//out.println("Exception@1: "+e.toString());//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			
	
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(event_psdate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(display_prop));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_prop));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(event_pedate));
            _bw.write(_wl_block23Bytes, _wl_block23);
if((!event_edate.equals(""))&& disable_prop.equals("disabled")){out.println("readonly");}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
if(disable_prop.equals("disabled"))out.println("readonly");
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(event_details));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_prop));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(event_confirmed_checked));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block34Bytes, _wl_block34);
	
		
	}
	catch(Exception e)
	{
		out.println(" Exception @ MedicalEventsDetail " +e.toString());
	}
	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(med_event_type_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
if(mode.equals("modify")){ 
            _bw.write(_wl_block41Bytes, _wl_block41);
 } 
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventStartDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventEndDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventDetails.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirmed.label", java.lang.String .class,"key"));
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
}
