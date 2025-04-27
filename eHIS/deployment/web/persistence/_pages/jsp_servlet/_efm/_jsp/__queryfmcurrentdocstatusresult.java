package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.text.*;
import java.sql.Date;
import java.util.*;
import com.ehis.util.*;

public final class __queryfmcurrentdocstatusresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryFMCurrentDocStatusResult.jsp", 1709116882125L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  <!-- Developed By\t   :-\tPrashant Bhalsingh\n\t Created on   \t   :\t21/06/2001\n\t Module Name \t   :\tFM\\File current storage location\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/QueryFMCurrentFileStatus.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n <head>\n\n <BODY onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n <form name=\"QueryFMSearchResult\" id=\"QueryFMSearchResult\" action=\"../../eFM/jsp/QueryFMCurrentDocStatusResult.jsp\" method=\"post\" \t>\n\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\tparent.searchResultFrame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<br>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"98%\" border=0>\n\t<tr>\n\t\t<td colspan=\'4\' class=\'PATIENTLINECOLOR\'>\n\t<font size=1 color=\'white\'><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;</b></font>\t\n\t\t</td>\n\t\n\t</tr>\n</table>\n<br>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\"98%\" style=\"border:1x solid black\">\t\t\n\t\t<td class=\'columnheader\' width=\"2%\" style=\"background:#1E3F64\">&nbsp;</td>\n\t\t<td class=\'columnheader\' width=100% colspan=\'2\' style=\"background:#1E3F64\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td class=\'columnheader\' width=100% colspan=\'1\' style=\"background:#1E3F64\"> ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t<tr>\n\t\t<td  width=\"18%\" height=\"20\" class=\'label\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td width=\"2%\">&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t   \t<td  width=\"40%\" height=\"20\" class=\'label\' >&nbsp;<b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t   \t<td  width=\"40%\" height=\"20\"  class=\'label\' >&nbsp;<b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t</tr>\n\t\t<tr><td  colspan=\"4\" height=\"2\" ></td></tr>\n\t\t<tr>\n\t\t<td  width=\"18%\" height=\"20\" class=\'label\'>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t<td width=\"2%\">&nbsp;</td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;<b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<tr>\n\t\t<td  width=\"18%\" height=\"20\" class=\'label\'>&nbsp;</td>\n\t\t<td width=\"2%\">&nbsp;</td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td  width=\"18%\" height=\"20\"  class=\'label\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&nbsp;<b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;<b>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t</tr>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<tr><td  colspan=\"4\" height=\"2\" class=\'label\'></td></tr>\n\t\t<tr>\n\t\t<td  width=\"18%\" height=\"20\" class=\'label\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t\t<tr><td  colspan=\"4\" height=\"2\" ></td></tr>\n\t\t<tr>\n\t\t<td  width=\"18%\" height=\"20\" class=\'label\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t<td width=\"2%\">&nbsp;</td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;<B>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;</td>\n\t\t</tr>\n\t\t<tr><td  colspan=\"4\" height=\"2\" ></td></tr>\n\t\t<tr><td  colspan=\"4\" height=\"2\" ></td></tr>\n\t\t<tr>\n\t\t<td  width=\"18%\" height=\"20\"  class=\'label\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;<B>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t</tr>\n\t\t<tr>\n\t\t<td  width=\"18%\" height=\"20\" class=\'label\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t</tr>\t\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t<tr>\n\t\t<td  width=\"18%\" height=\"20\" class=\'label\'>&nbsp;</td>\n\t\t<td width=\"2%\">&nbsp;</td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;\n\t   <a href=\'javascript:GetShowRemarks(\"ReqComm";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\",\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\",\"R\")\'>Requestor Remarks</a></font></td>\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'>&nbsp;</td>\n\t\t </tr>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<tr>\n\t\t<td  width=\"18%\" height=\"20\" class=\'label\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp-&nbsp";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\t\t\n\t\t<td  width=\"40%\" height=\"20\" class=\'label\'></td>\n\t\t</tr> \n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<tr><td  colspan=\"4\" height=\"2\" ></td></tr>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\t\t\n\n\t\t<tr><td  colspan=\"4\" height=\"5\" ></td></tr>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t</table>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n<script>\n\t//parent.frames[1].document.forms[0].search[1].disabled=false;\n</script>\n  <input type=\'hidden\' name=\'criteria\' id=\'criteria\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' >\n  <input type=\'hidden\' name=\'facility\' id=\'facility\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' >\n  <input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" >\n  <input type=\'hidden\' name=\'currStatDesc\' id=\'currStatDesc\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n  <input type=\'hidden\' name=\'currIdDesc\' id=\'currIdDesc\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n  <input type=\'hidden\' name=\'Curr_locn_desc\' id=\'Curr_locn_desc\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n  <input type=\'hidden\' name=\'sappointmentDays\' id=\'sappointmentDays\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n  <input type=\'hidden\' name=\'bookingDays\' id=\'bookingDays\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection con				= ConnectionManager.getConnection(request);
		java.sql.Statement stmt		= null;
		ResultSet rset				= null;
		java.sql.Statement stmt1	= null;
		ResultSet rset1				= null;
		java.sql.Statement stmt2	= null;
		ResultSet rs				= null;

	//	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy") ;

		String fcy_id = (String) session.getValue("facility_id");
		String queryCriteria	= (request.getParameter("criteria")==null)?"":request.getParameter("criteria") ;
		String volume_no	= (request.getParameter("volume_no")==null)?"":request.getParameter("volume_no") ;
		String facility			= (request.getParameter("facility")==null)?"":request.getParameter("facility") ;
		String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;
		String currStatDesc		= (request.getParameter("currStatDesc")==null)?"":request.getParameter("currStatDesc") ;
		String currIdDesc		= (request.getParameter("currIdDesc")==null)?"":request.getParameter("currIdDesc") ;
		String Curr_locn_desc		= (request.getParameter("Curr_locn_desc")==null)?"":request.getParameter("Curr_locn_desc") ;
		String appointmentDays		= (request.getParameter("appointmentDays")==null)?"":request.getParameter("appointmentDays") ;
		String bookingDays		= (request.getParameter("bookingDays")==null)?"":request.getParameter("bookingDays") ;

		String sql				= "" ;		
 
            _bw.write(_wl_block8Bytes, _wl_block8);
try{
            _bw.write(_wl_block9Bytes, _wl_block9);


	 String p_nursing_unit 		= "";
	 String p_room_num		= "";
	 String p_bed_num		= "";
	 int p_count			= 0;
	 int count			    = 0;
	 int appt_count  = 0;

	 stmt2 = con.createStatement();

	 sql = "select count(1) from oa_appt where patient_id='"+patientid+"' and facility_id ='"+fcy_id+"' and trunc(appt_date)>=trunc(sysdate) and nvl(appt_status,1) != 'A'";
	 rs = stmt2.executeQuery(sql);
	 if (rs.next())
	  {
		 appt_count = rs.getInt(1);
	  }
	 if(rs!=null)  rs.close();
		
	if (appt_count==0)
    {
		sql="select count(1) from ip_booking_list_vw where patient_id is not null and patient_id='"+patientid+"' and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1";

		if(stmt2!=null)  stmt2.close();
		stmt2=con.createStatement();
		rs=stmt2.executeQuery(sql);
		 if (rs.next())
			 appt_count = rs.getInt(1);
	}
	if(rs!=null) rs.close();	
	sql = "select count(*) rec_cnt from sm_module where module_id='IP' ";
    rs = stmt2.executeQuery(sql);
	 while (rs.next())
	 {
	 	p_count = rs.getInt("rec_cnt");
	 }if(rs!=null) rs.close();
	 if (p_count == 1)
	 {
		 sql = "select a.nursing_unit_short_desc,nvl(a.room_no,'&nbsp;')room_no,nvl(a.bed_no,'&nbsp;')bed_no from ip_open_encounter_vw a, fm_curr_locn_vw b where a.facility_id=b.curr_facility_id and a.patient_id=b.patient_id and b.facility_id='"+facility+"' and b.file_no='"+queryCriteria+"' ";

		rs = stmt2.executeQuery(sql);
  		while (rs.next())
		{
		p_nursing_unit	=
		(rs.getString("nursing_unit_short_desc")==null)?"":rs.getString("nursing_unit_short_desc");
		p_room_num	=(rs.getString("room_no")==null)?"":rs.getString("room_no");
		p_bed_num	=(rs.getString("bed_no")==null)?"":rs.getString("bed_no");
			++count ;
		 }
		 if(rs!=null)	rs.close();

	 //This logic to adjust the length
		if(count >= 1)
			{
					int add = 0;
					int len = p_nursing_unit.length();

					add = 18 -len ;

					for(int i=0;i<add;i++)
						p_nursing_unit = p_nursing_unit +  "&nbsp;"	;

					len=0;
					add=0;

					len = p_room_num.length();

					add = 8 -len ;

					for(int k=0;k<add;k++)
						p_room_num = p_room_num +  "&nbsp;"	;


		  	}

	}
	int record_count = 0;

	sql = "SELECT COUNT(*) record_count FROM fm_curr_locn_vw a,fm_transit_file b,fm_storage_locn c, fm_storage_locn d, sm_appl_user e, sm_appl_user f, fm_storage_locn g, sm_appl_user h WHERE a.facility_id='"+ facility + "' And a.file_no='" + queryCriteria + "'  And  a.volume_no="+volume_no+" AND a.facility_id = b.facility_id(+) AND a.file_no = b.file_no(+) AND b.facility_id = c.facility_id(+)    AND b.dest_fs_locn_code = c.fs_locn_code(+) AND a.curr_facility_id = d.facility_id AND a.curr_fs_locn_code = d.fs_locn_code AND c.holder_name = e.appl_user_id(+) AND d.holder_name = f.appl_user_id(+) AND a.prev_fs_locn_code = g.fs_locn_code(+) AND g.holder_name = h.appl_user_id(+)";
	stmt			= con.createStatement();
	rset		 	= stmt.executeQuery(sql) ;
	if ((rset!=null) && (rset.next()))
		record_count = rset.getInt("record_count");
	if (stmt != null) stmt.close();
	if (rset != null) rset.close();

	if (record_count==0)
	{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	else
	{
	sql = " SELECT a.file_no,get_patient_line(a.patient_id,'"+localeName+"') patient_line,a.curr_fs_locn_code, a.CURR_FS_LOCN_SHORT_DESC,a.prev_fs_locn_code, a.prev_fs_locn_desc,h.appl_user_name prev_holder_name,g.holder_phone_no prev_phone_no ,DECODE(a.curr_fs_locn_identity,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External' ,'E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity,DECODE (a.prev_fs_locn_identity, 'D', 'Department', 'T', 'Practitioner', 'C', 'Clinic', 'N', 'Nursing Unit', 'E', 'External' ) prev_fs_locn_identity,a.curr_file_status file_status, DECODE(a.curr_file_status,'I','Inside','O','Outside','L','Lost','T','Issued-InTransit','R','Returned-InTransit' ,'A','Archived','E','Other Facility')curr_file_status,(CASE WHEN a.curr_file_status='T' THEN ' / ' || c.short_desc || ' (' || DECODE(c.locn_identity,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','E','Procedure Unit','Y','Daycare Unit') ||')' ELSE ' ' END)dest_locn, TO_CHAR(a.iss_date_time,'dd/mm/rrrr hh24:mi') iss_date_time, TO_CHAR(a.return_date_time,'dd/mm/rrrr hh24:mi') return_date_time, (CASE WHEN a.facility_id<>a.curr_facility_id THEN ' / ' || curr_facility_name ELSE ' ' END)curr_facility_name,(CASE WHEN a.facility_id <> a.prev_facility_id THEN ' / ' || prev_facility_name ELSE ' ' END ) prev_facility_name,(CASE WHEN a.curr_file_status='T' THEN e.appl_user_name ELSE f.appl_user_name END)HOLDER_NAME,(CASE WHEN a.curr_file_status = 'T' THEN c.holder_phone_no ELSE d.holder_phone_no END ) holder_phone_no, a.req_remarks,(case when (a.curr_facility_id = a.facility_id and a.curr_fs_locn_code=a.mr_pat_fs_locn_code and a.curr_file_status='I') then 'Y' else 'N' end ) owner_locn_yn, a.curr_locn_id, c.locn_identity, A.DOC_FOLDER_ID, A.DOC_FOLDER_NAME,A.DOC_TYPE_NAME, I.PATIENT_ID, I.FROM_PERIOD, I.TO_PERIOD, I.PATIENT_PERIOD_SPECIFIC,(CASE WHEN I.PATIENT_PERIOD_SPECIFIC='D' THEN ', ' || TO_CHAR(I.FROM_PERIOD,'DD/MM/YYYY ') || ' - ' || TO_CHAR(I.TO_PERIOD,'DD/MM/YYYY ')  ELSE ', ' || GET_PATIENT_LINE(I.PATIENT_ID) END)DOC_TYPE,j.TRANSPORT_MODE ,j.carried_by_name, k.long_desc transport_desc FROM fm_curr_locn_vw a,fm_transit_file b,fm_storage_locn c, fm_storage_locn d, sm_appl_user e, sm_appl_user f, fm_storage_locn g, sm_appl_user h, fm_doc_folder i,  fm_movement_log j, am_transport_mode k WHERE a.facility_id='"+ facility + "' And a.file_no='" + queryCriteria + "'  And  a.volume_no="+volume_no+" AND a.facility_id = b.facility_id(+) AND a.file_no = b.file_no(+) AND b.facility_id = c.facility_id(+)    AND b.dest_fs_locn_code = c.fs_locn_code(+) AND a.curr_facility_id = d.facility_id AND a.curr_fs_locn_code = d.fs_locn_code AND c.holder_name = e.appl_user_id(+) AND d.holder_name = f.appl_user_id(+) AND a.prev_fs_locn_code = g.fs_locn_code(+) AND g.holder_name = h.appl_user_id(+) and a.DOC_FOLDER_ID = i.DOC_FOLDER_ID(+) AND a.FACILITY_ID = i.FACILITY_ID AND a.ISS_DATE_TIME = j.sent_date_time(+) AND a.file_no = j.file_no(+) AND a.volume_no = j.volume_no(+) AND a.facility_id = j.facility_id(+) AND j.TRANSPORT_MODE = k.TRANSPORT_MODE(+)" ;	
		stmt			= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                     ResultSet.CONCUR_UPDATABLE);
    	rset		 	= stmt.executeQuery(sql) ;
	String location_identity = "";
	String current_locn		 = "";
	String sqlString		 = "";	
	String location_desc	 = "";	
	String doc_folder_id	 = "";
	String doc_folder_name	 = "";
	String doc_type	 = "";



            _bw.write(_wl_block11Bytes, _wl_block11);

		int i = 0;
		String p_req_remarks = "", p_owner_locn_yn="", p_owner_phone_yn="";
		if(rset.next())
		{
			doc_folder_id = rset.getString("doc_folder_id")==null?"&nbsp;":rset.getString("doc_folder_id");
			doc_folder_name = rset.getString("doc_folder_name")==null?"&nbsp;":rset.getString("doc_folder_name");
			doc_type = 
			rset.getString("doc_type")==null?"&nbsp;":rset.getString("doc_type");
			


			p_req_remarks = rset.getString("req_remarks");
			p_owner_locn_yn = rset.getString("owner_locn_yn");
			if (p_owner_locn_yn.trim().equals("Y"))
			{
				p_owner_locn_yn="Holder Name";
				p_owner_phone_yn="Holder Phone No.";
			}
			else
			{
				p_owner_locn_yn="Requestor Name";
				p_owner_phone_yn="Requestor Phone No.";
			}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(doc_folder_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(doc_type));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

			String identity = 			(rset.getString("curr_fs_locn_identity")==null)?"&nbsp":rset.getString("curr_fs_locn_identity");
			String prev_identity = 			(rset.getString("prev_fs_locn_identity")==null)?"&nbsp":rset.getString("prev_fs_locn_identity");
			location_identity	= rset.getString("locn_identity");
			current_locn		= rset.getString("curr_locn_id");
			if ((location_identity==null) || (location_identity.equals("null")))
				location_identity = "";
			if ((current_locn==null) || (current_locn.equals("null")))
				current_locn = "";
			if (location_identity.equals("N"))
				sqlString	=	"SELECT long_desc short_desc FROM ip_nursing_unit WHERE nursing_unit_code = '"+current_locn+"'  AND facility_id = '"+facility+"' AND eff_status = 'E' ";
			else if (location_identity.equals("C"))
				sqlString	=	"SELECT long_desc short_desc FROM op_clinic WHERE clinic_code = '"+current_locn+"' AND facility_id = '"+facility+"' AND eff_status = 'E' ";
			else if (location_identity.equals("T"))
				sqlString	=	"SELECT practitioner_name short_desc FROM am_practitioner WHERE practitioner_id = '"+current_locn+"' AND eff_status = 'E' ";
			if (!sqlString.equals(""))
			{
				if(stmt2!=null)	stmt2.close();
				stmt2 = con.createStatement();
				rs = stmt2.executeQuery(sqlString);
				if ((rs!=null) && (rs.next()))
					location_desc = rs.getString("short_desc");
				location_desc = ((location_desc==null) || (location_desc.equals("null"))) ? "&nbsp;" : (" / ("+location_desc+") ");
			}
			
		
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((rset.getString("CURR_FS_LOCN_SHORT_DESC")==null)?"&nbsp":rset.getString("CURR_FS_LOCN_SHORT_DESC") + "(" + identity + ")"));
            out.print( String.valueOf(rset.getString("curr_facility_name")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((rset.getString("prev_fs_locn_desc")==null)?"&nbsp":rset.getString("prev_fs_locn_desc") + "(" + prev_identity + ")"));
            out.print( String.valueOf(rset.getString("prev_facility_name")));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((rset.getString("curr_file_status")==null)?"&nbsp":rset.getString("curr_file_status")));
            out.print( String.valueOf(location_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);

		if(count >= 1){

            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_nursing_unit));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_room_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_bed_num));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_nursing_unit));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_room_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_bed_num));
            _bw.write(_wl_block31Bytes, _wl_block31);

		}

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((rset.getString("iss_date_time")==null)?"&nbsp":rset.getString("iss_date_time")));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((rset.getString("return_date_time")==null)?"&nbsp":rset.getString("return_date_time")));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_owner_locn_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((rset.getString("HOLDER_NAME")==null)?"&nbsp":rset.getString("HOLDER_NAME")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((rset.getString("prev_holder_name")==null)?"&nbsp":rset.getString("prev_holder_name")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(p_owner_phone_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((rset.getString("holder_phone_no")==null)?"&nbsp":rset.getString("holder_phone_no")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((rset.getString("prev_phone_no")==null)?"&nbsp":rset.getString("prev_phone_no")));
            _bw.write(_wl_block38Bytes, _wl_block38);

	if (p_req_remarks!=null)
	{

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(p_req_remarks));
            _bw.write(_wl_block41Bytes, _wl_block41);

	}
	String file_status = rset.getString("file_status")==null?"":rset.getString("file_status");
		if(file_status.equals("T") || file_status.equals("R"))
	   {

            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((rset.getString("transport_desc")==null)?"&nbsp":rset.getString("transport_desc")));
 
		if(!(rset.getString("carried_by_name")==null)){			
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((rset.getString("carried_by_name")==null)?"&nbsp":rset.getString("carried_by_name")));
 } 
            _bw.write(_wl_block44Bytes, _wl_block44);
	   }

            _bw.write(_wl_block45Bytes, _wl_block45);

			String flag="true"	;
			String p_rec_cnt_flag = "" ;
			sql="SELECT 'X' total_records FROM oa_appt_mr_list_vw WHERE facility_id='" + facility + "' AND  " +				 "patient_id='" + patientid  + "'  AND TRUNC(appt_date)<= SYSDATE+" + appointmentDays ;
			//out.println(sql);
			stmt1			= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                   ResultSet.CONCUR_UPDATABLE);
			rset1		 	= stmt1.executeQuery(sql) ;
			while (rset1.next())
			{
				p_rec_cnt_flag = rset1.getString("total_records");
			}
			if(p_rec_cnt_flag.equals("X"))
			flag = "enabled" ;
			else
			flag = "disabled";

            _bw.write(_wl_block46Bytes, _wl_block46);
		}

            _bw.write(_wl_block47Bytes, _wl_block47);

		}
	if(rset!=null)	rset.close();
	if(rset1!=null)	rset1.close();
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(stmt2!=null)	stmt2.close();
	}catch(Exception e){
	out.println("Exception while fetching connection :" + e ) ;
	}finally{
	ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(queryCriteria));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(currStatDesc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(currIdDesc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Curr_locn_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(appointmentDays));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(bookingDays));
            _bw.write(_wl_block56Bytes, _wl_block56);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentDocumentStatus.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.PreviousDocumentStatus.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentFSLocation.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DocumentStatus.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FromNursingUnit.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FromNursingUnit.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Bed.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.InpatientDetails.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.issueddatetime.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReturnDueDateTime.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.TransportDetail.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }
}
