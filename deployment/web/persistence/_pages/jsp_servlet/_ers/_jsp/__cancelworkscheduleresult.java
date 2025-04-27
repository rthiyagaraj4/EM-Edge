package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;

public final class __cancelworkscheduleresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/CancelWorkScheduleResult.jsp", 1709121632137L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script> -->\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../js/RSCommon.js\"></script>\n<script language=\"javascript\" src=\"../js/CancelWorkSchedule.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onload=\'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<form name=\'formCanWrkSchResult\' id=\'formCanWrkSchResult\' action=\'../../servlet/eRS.CancelWorkScheduleServlet\' method=\'POST\' target=\'messageFrame\'>\n\t\t\t<table cellpadding=0 cellspacing=0 border=1 width=\"100%\" id=\'detailTab\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<tr>\n\t <td colspan=\'8\' width=12% Align=\'left\' class =\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'><font size=2>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t <input type=\"hidden\" name=\"work_code";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" id=\"work_code";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" ></td>  \n\t \n\t <td colspan=\'6\' width=9% Align=\'left\' class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ><font size=2>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t <input type=\"hidden\" name=\"rol_type";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"rol_type";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" ></td> \n\t\t \n\t <td colspan=\'8\' width=20% Align=\'left\' class =\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t <input type=\"hidden\" name=\"staf_id";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"staf_id";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t <input type=\"hidden\" name=\"sch_date";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"sch_date";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" ></td>  \n\n\t<td colspan=\'8\' width=12% Align=\'left\' class =\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<input type=\"hidden\" name=\"shft_code";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"shft_code";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" ></td>\n\t \t \n\t <td colspan=\'6\' width=4% Align=\'left\' class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t <input type=\"hidden\" name=\"start_time";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"start_time";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" ></td>  \n\n\t<td colspan=\'8\' width=5% Align=\'left\' class =\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t <input type=\"hidden\" name=\"end_tyme";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"end_tyme";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" ></td>  \n\t \n\t<td  colspan=\'8\' width=6% Align=\'left\' class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t<input type=checkbox name=\'select_yn";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'select_yn";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' checked value=\'\' ></td> \n    \n</tr>  \n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n<input type=\'hidden\' name=\'totalRecords\' id=\'totalRecords\'  value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'> \n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\'  value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'reason_code\' id=\'reason_code\'  value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\'frm_dt\' id=\'frm_dt\'  value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'to_dt\' id=\'to_dt\'  value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'locn_type\' id=\'locn_type\'  value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\'hidden\' name=\'workplace_code\' id=\'workplace_code\'  value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'role_type\' id=\'role_type\'  value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'staff_type\' id=\'staff_type\'  value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'staff_id\' id=\'staff_id\'  value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=\'hidden\' name=\'position_code\' id=\'position_code\'  value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n</form>\n</table>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="   \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	CancelWorkSchedule.jsp
*	Purpose 			:
*	Created By		:	Sreenivasulu.Y
*	Created On		:	19 Nov 2004
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	 //String sql_show_details="Select a.FACILITY_ID facility_id, a.WORKPLACE_CODE workplace_code, f.workplace_desc workplace_desc, a.ROLE_TYPE role_type, a.STAFF_ID staff_id, nvl(b.practitioner_name, c.other_staff_name) staff_name, to_char(a.SCHEDULE_DATE,'dd/mm/yyyy') sch_date, a.SHIFT_CODE shift_code, a.SHIFT_MNEMONIC shift_mnemonic, d.short_desc shift_desc, to_char(a.SHIFT_START_TIME,'hh24:mi') shift_start_time, to_char(a.SHIFT_END_TIME,'hh24:mi') shift_end_time, a.LOCN_TYPE locn_type, a.ACTIVITY_LOG_ID activity_log_id from rs_work_schedule a, am_practitioner b, am_other_staff c, am_shift d, am_care_locn_type e, rs_workplace f where  a.facility_id = ? and  a.schedule_date between       to_date(?,'dd/mm/yyyy') and (to_Date(?,'dd/mm/yyyy') +1) and a.workplace_code = nvl(?,a.workplace_code) and ((? is null) or (? is not null and a.locn_type = ?)) and a.position_code = nvl(?,a.position_code) and a.role_type = nvl(?,a.role_type) and a.staff_id = nvl(?,a.staff_id) and a.staff_type = nvl(?,a.staff_type) and b.practitioner_id(+) = a.staff_id and c.other_staff_id(+) = a.staff_id and d.shift_code = a.shift_code and e.locn_type(+) = a.locn_type and f.facility_id = a.facility_id and f.workplace_code = a.workplace_code order by f.workplace_desc, a.role_type, staff_name, a.schedule_date";
	 String sql_show_details="Select a.FACILITY_ID facility_id, a.WORKPLACE_CODE workplace_code, f.workplace_desc workplace_desc, a.ROLE_TYPE role_type, a.STAFF_ID staff_id, nvl(b.practitioner_name, c.other_staff_name) staff_name, to_char(a.SCHEDULE_DATE,'dd/mm/yyyy') sch_date, a.SHIFT_CODE shift_code, a.SHIFT_MNEMONIC shift_mnemonic, d.short_desc shift_desc, to_char(a.SHIFT_START_TIME,'hh24:mi') shift_start_time, to_char(a.SHIFT_END_TIME,'hh24:mi') shift_end_time, a.LOCN_TYPE locn_type, a.ACTIVITY_LOG_ID activity_log_id from rs_work_schedule a, am_practitioner_lang_vw b, am_other_staff_lang_vw c, am_shift_lang_vw d, am_care_locn_type e, rs_workplace_lang_vw f where  a.facility_id = ? and  a.schedule_date between       to_date(?,'dd/mm/yyyy') and (to_Date(?,'dd/mm/yyyy') +1) and a.workplace_code = nvl(?,a.workplace_code) and ((? is null) or (? is not null and a.locn_type = ?)) and a.position_code = nvl(?,a.position_code) and a.role_type = nvl(?,a.role_type) and a.staff_id = nvl(?,a.staff_id) and a.staff_type = nvl(?,a.staff_type) and b.practitioner_id(+) = a.staff_id and c.other_staff_id(+) = a.staff_id and d.shift_code = a.shift_code and e.locn_type(+) = a.locn_type and f.facility_id = a.facility_id and f.workplace_code = a.workplace_code and b.language_id(+) = ? and c.language_id(+) = ? and d.language_id = ? and f.language_id = ? order by f.workplace_desc, a.role_type, staff_name, a.schedule_date";

	 ArrayList WorkSchedule_List		= new ArrayList();
	 String[] record				= null;

	 Connection conn 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet rs 		= null;
		
	String facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String frm_dt=request.getParameter("frm_dt")==null?"":request.getParameter("frm_dt");
	String to_dt=request.getParameter("to_dt")==null?"":request.getParameter("to_dt");
	String workplace_code=request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String locn_type=request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String position_code=request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String role_type=request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_id=request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String staff_type=request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
    String reason_code=request.getParameter("reason_code")==null?"":request.getParameter("reason_code");
 	String slClassValue="";

	try{
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement( sql_show_details );
		pstmt.setString(1,facility_id);
		pstmt.setString(2,frm_dt);
		pstmt.setString(3,to_dt);
		pstmt.setString(4,workplace_code);
		pstmt.setString(5,locn_type);
		pstmt.setString(6,locn_type);
		pstmt.setString(7,locn_type);
		pstmt.setString(8,position_code);
		pstmt.setString(9,role_type);
		pstmt.setString(10,staff_id);
		pstmt.setString(11,staff_type);
		pstmt.setString(12,locale);
		pstmt.setString(13,locale);
		pstmt.setString(14,locale);
		pstmt.setString(15,locale);
		rs = pstmt.executeQuery() ;
				
		while (rs != null && rs.next()) {

			record = new String[14];

			record[0] = rs.getString("facility_id");
			record[1] = rs.getString("workplace_code");
			record[2] = rs.getString("workplace_desc");
			record[3] = rs.getString("role_type");
			record[4] = rs.getString("staff_id");
			record[5] = rs.getString("staff_name");
			record[6] = rs.getString("sch_date");
			record[7] = rs.getString("shift_code");
			record[8] = rs.getString("shift_mnemonic");
			record[9] = rs.getString("shift_desc");
			record[10] = rs.getString("shift_start_time");
			record[11] = rs.getString("shift_end_time");
			record[12] = rs.getString("locn_type");
			record[13] = rs.getString("activity_log_id");

			WorkSchedule_List.add(record) ;
			
		}
		if(pstmt != null)
			pstmt.close();
		if(rs != null)
			rs.close();
	
		int totalRecords=WorkSchedule_List.size();

            _bw.write(_wl_block7Bytes, _wl_block7);

			for( int i=0 ; i< WorkSchedule_List.size() ; i++ ) {

				if(i % 2 == 0)
					slClassValue = "QRYEVEN";
				else
					slClassValue = "QRYODD";
				
				record = (String[])WorkSchedule_List.get(i);
				String rol="";

				 if(record[3].equalsIgnoreCase("P"))
					  rol="Practitioner";
				 
				 else if(record[3].equalsIgnoreCase("O"))
					  rol="Other Staff";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rol));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[3]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(record[5]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[4]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(record[6],"DMY","en",locale)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[6]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(record[9]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[7]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[10]));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[11]));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
 
		} 

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(reason_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(frm_dt));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(to_dt));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(workplace_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(role_type));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(staff_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(position_code));
            _bw.write(_wl_block46Bytes, _wl_block46);

	}catch(Exception e){
		out.println(e.getMessage());
		e.printStackTrace();
	 } 
	 finally{
		if (pstmt != null) pstmt.close();
		if (rs != null)   rs.close();
		ConnectionManager.returnConnection(conn,request);
	 }

            _bw.write(_wl_block47Bytes, _wl_block47);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
