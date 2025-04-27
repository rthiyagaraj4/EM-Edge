package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __otpatline extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OTpatLine.jsp", 1709120292000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 =" \n<html>\n<head>\n<link rel=\'StyleSheet\' type=\'text/css\'  href=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' />\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n</head>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<div id=\'1\'>\n<table border=\"0\" cellpadding=3  cellspacing=\"0\" width=\"100%\">\n<tbody>\n<tr>\n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<td class=\'PATIENTLINECOLOR\' align=\"left\" title=\'Order ID/Ordered Date/Time\' >\n\t\t<font size=\'1\' style=\"font-weight:bold\">[";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="]</font>\t\n\t </td>\n ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t  <td class=\'PATIENTLINECOLOR\' align=\"left\">&nbsp;</td>\n ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n <td  class=\'PATIENTLINECOLOR\' align=\'center\' title=\'Speciality/Surgeon/Theatre\'>\n\t<font size=\'1\' style=\"font-weight:bold\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font>\n</td>\n\n  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<td class=\'PATIENTLINECOLOR\' align=\"center\" title=\'Booking No/Booking Date/Time\'>\n\t\t<font size=\'1\' style=\"font-weight:bold\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</td>\n ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t  <td class=\'PATIENTLINECOLOR\' align=\"center\">&nbsp;</td>\n ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n    \n  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<td class=\'PATIENTLINECOLOR\' align=\"right\" title=\'Oper No/Oper Date\'>\n\t\t\t<font size=\'1\' style=\"font-weight:bold\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font>\n\t\t</td>\t\n\t</td>\n ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t  <td class=\'PATIENTLINECOLOR\' align=\"right\" >&nbsp;</td>\n ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n </tr>\t\n </div> \n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\'hidden\' name=\'oper_date\' id=\'oper_date\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n</div>\n</tbody>\n</table>\n</body>\n<html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
 String locale = (String)session.getAttribute("LOCALE"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

    String patient_id = checkForNull(request.getParameter("patient_id")).intern();
    String ordering_facility_id = checkForNull((String)session.getValue("ordering_facility_id"));
	String facility_id = (String) session.getAttribute("facility_id");
	if(ordering_facility_id != null && ordering_facility_id.length() > 0)
	{
		facility_id = ordering_facility_id;
	}
	String booking_no = checkForNull(request.getParameter("booking_no"),checkForNull(request.getParameter("booking_num"))).intern();
	String parent_source_id = checkForNull(request.getParameter("parent_source_id")).intern(); // When invoked from Anaesthesia screens
	String source_order_id = checkForNull(request.getParameter("source_order_id")).intern(); // When invoked from Anaesthesia screens
	String order_id = checkForNull(request.getParameter("order_id"),checkForNull(request.getParameter("orderid"))).intern();
	String oper_num = checkForNull(request.getParameter("oper_num")).intern();
	String oper_date = checkForNull(request.getParameter("theatre_date"),request.getParameter("oper_date"));
	String theatre_desc=checkForNull(request.getParameter("roomDesc"));
	String surgeon_name=checkForNull(request.getParameter("surgeonName"));
	String speciality_desc=checkForNull(request.getParameter("speciality_desc"));
	Connection con = null;
//	Statement stmt	= null;
	PreparedStatement pstmt	= null;
	ResultSet rs = null;
	ResultSet rst = null;
	String empty = "".intern();
	if(parent_source_id!="" ) order_id = parent_source_id;
	if(source_order_id!="" )  	order_id = source_order_id;
	String booked_date="",start_time="",end_time="",encounter_id="",ordered_date_time = "",sql_book_dtls="";
	try{	
		con=ConnectionManager.getConnection(request);

		if( order_id!=empty && order_id!="0" ) {
			String SQL_ORDER_DATE = "SELECT TO_CHAR(ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') ORDER_DATE_TIME FROM OR_ORDER WHERE ORDER_ID = ?";
			pstmt = con.prepareStatement(SQL_ORDER_DATE);
			pstmt.setString(1,order_id);
			rs=pstmt.executeQuery();
			ordered_date_time = (rs.next()==true)?checkForNull(rs.getString(1)):"";
			ordered_date_time =com.ehis.util.DateUtils.convertDate(ordered_date_time,"DMYHM","en",locale); 
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();

			String patient_qry = "SELECT PATIENT_ID,ENCOUNTER_ID, B.SHORT_DESC, C.PRACTITIONER_NAME FROM OT_PENDING_ORDER A, AM_SPECIALITY B, AM_PRACTITIONER C WHERE PERFORMING_FACILITY_ID=? AND ORDER_ID=? AND A.SPECIALITY_CODE = B.SPECIALITY_CODE(+) AND A.PHYSICIAN_ID = C.PRACTITIONER_ID(+)";

			pstmt = con.prepareStatement(patient_qry);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,order_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				patient_id = checkForNull(rs.getString(1));
				encounter_id = checkForNull(rs.getString(2));
				surgeon_name = checkForNull(rs.getString(3));
				speciality_desc = checkForNull(rs.getString(4));
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(booking_no==empty){
				pstmt = con.prepareStatement("SELECT BOOKING_NUM FROM OT_BOOKING_HDR WHERE ORDER_ID = ? AND OPERATING_FACILITY_ID='"+facility_id+"'");
				pstmt.setString(1,order_id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					booking_no = rs.getString("BOOKING_NUM");
				}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	    	}
			
		 }
		 if(rs != null) rs.close(); //SS-007
		 if(pstmt != null) pstmt.close();//SS-007
			if(!booking_no.equals(""))
			{
			 sql_book_dtls="SELECT to_char(BOOKING_DATE,'dd/mm/yyyy') BOOKING_DATE1, to_char(BOOKING_START_TIME,'hh24:mi') BOOKING_START_TIME1, to_char(BOOKING_END_TIME,'hh24:mi') BOOKING_END_TIME1,ENCOUNTER_ID ENCOUNTER_ID1, THEATRE_DESC THEATRE_DESC1, SURGEON_NAME SURGEON_NAME1,SPECIALITY_DESC SPECIALITY_DESC1 FROM  OT_BOOKINGS_VW WHERE LANGUAGE_ID = ? AND OPERATING_FACILITY_ID = ?  AND BOOKING_NUM = ?";
			}else
			{
				if(!oper_num.equals("")){

					
					 sql_book_dtls="SELECT ENCOUNTER_ID ENCOUNTER_ID1,get_desc('"+locale+"','OT_OPER_ROOM_LANG_VW','LONG_DESC','OPER_ROOM_CODE',ot_post_oper_hdr.OPER_ROOM_CODE)  THEATRE_DESC1,GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',ot_post_oper_hdr.SPECIALITY_CODE),GET_DESC('"+locale+"','AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ot_post_oper_hdr.SURGEON_CODE) SURGEON_NAME1,OPER_NUM  FROM  ot_post_oper_hdr WHERE OPERATING_FACILITY_ID =?  AND  OPER_NUM = ?";
				}else{

					
					sql_book_dtls="SELECT ENCOUNTER_ID ENCOUNTER_ID1,get_desc('"+locale+"','OT_OPER_ROOM_LANG_VW','LONG_DESC','OPER_ROOM_CODE',ot_post_oper_hdr.OPER_ROOM_CODE)  THEATRE_DESC1,GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',ot_post_oper_hdr.SPECIALITY_CODE),GET_DESC('"+locale+"','AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ot_post_oper_hdr.SURGEON_CODE) SURGEON_NAME1,OPER_NUM  FROM  ot_post_oper_hdr WHERE OPERATING_FACILITY_ID =?  AND  ORDER_ID = ?";

				}
			}
  if(!booking_no.equals(""))
		{       
			pstmt = con.prepareStatement(sql_book_dtls);
			
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,booking_no);
		}else
			{
				if(!oper_num.equals("")){
					pstmt = con.prepareStatement(sql_book_dtls);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,oper_num);
				}else{
					pstmt = con.prepareStatement(sql_book_dtls);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,source_order_id);
				}
			}
			rst = pstmt.executeQuery();
			while(rst.next()){
				if(!booking_no.equals(""))
				{
					booked_date=checkForNull(rst.getString(1));
					booked_date =checkForNull(com.ehis.util.DateUtils.convertDate(booked_date,"DMY","en",locale));
					start_time=checkForNull(rst.getString(2));
					end_time=checkForNull(rst.getString(3));
					encounter_id=checkForNull(rst.getString(4));
					theatre_desc=checkForNull(rst.getString(5));
					surgeon_name=checkForNull(rst.getString(7));
					speciality_desc=checkForNull(rst.getString(6));
				}else
				{
					encounter_id=checkForNull(rst.getString(1));
					theatre_desc=checkForNull(rst.getString(2));
					speciality_desc=checkForNull(rst.getString(3));
					surgeon_name=checkForNull(rst.getString(4));
					oper_num=checkForNull(rst.getString(5));
				}
			}
		 if(rst != null) rst.close();
		 if(pstmt != null) pstmt.close();
	 if(oper_num!=empty){
			String oper_date_qry = "SELECT TO_CHAR(OPER_DATE,'DD/MM/YYYY') FROM OT_QUEUE WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";
			pstmt = con.prepareStatement(oper_date_qry);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,oper_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				oper_date =   checkForNull(rs.getString(1));
			}
		 }
		 if(rs != null) rs.close();
		 if(pstmt != null) pstmt.close();

	if(oper_num!=empty){
			String sql_theatre_desc="select  GET_DESC('"+locale+"',' ot_oper_room_lang_vw','LONG_DESC','OPER_ROOM_CODE',a.OPER_ROOM_CODE) theatre_desc	from ot_post_oper_hdr a where a.OPERATING_FACILITY_ID='"+facility_id+"' and a.OPER_NUM='"+oper_num+"'	";
			pstmt = con.prepareStatement(sql_theatre_desc);
			rst = pstmt.executeQuery();
			if(rst !=null && rst.next()){
				theatre_desc=checkForNull(rst.getString("theatre_desc"));
			}
	    }
		 if(rst != null) rst.close();
		 if(pstmt != null) pstmt.close();

	if(order_id==empty || order_id=="0"){
			String SQL_ORDER_ID = "SELECT ORDER_ID FROM OT_BOOKING_HDR WHERE BOOKING_NUM = ? AND OPERATING_FACILITY_ID='"+facility_id+"'";
	 		pstmt = con.prepareStatement(SQL_ORDER_ID);
			pstmt.setString(1,booking_no);
			rs=pstmt.executeQuery();
			order_id = (rs.next()==true)?checkForNull(rs.getString(1)):"";
			rs.close();
			pstmt.close();

			String SQL_ORDER_DATE = "SELECT TO_CHAR(ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') ORDER_DATE_TIME FROM OR_ORDER WHERE ORDER_ID = ?";
			pstmt = con.prepareStatement(SQL_ORDER_DATE);
			pstmt.setString(1,order_id);
			rs=pstmt.executeQuery();
			ordered_date_time = (rs.next()==true)?checkForNull(rs.getString(1)):"";
			ordered_date_time =com.ehis.util.DateUtils.convertDate(ordered_date_time,"DMYHM","en",locale); 
			 if(rs != null) rs.close();
			 if(pstmt != null) pstmt.close();
		}

     }catch(Exception e){
	   System.err .println("Error OTPatLine.jsp : "+e.toString());
	}finally{	
		try{
				//if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();				
				//Modified against SS-007
				if(rs != null) rs.close();
				if(rst != null) rst.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
		}catch(Exception e){System.err.println("CMG IN PAT LINE :" +e);}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
oper_date=com.ehis.util.DateUtils.convertDate(oper_date,"DMY","en",locale); 


            _bw.write(_wl_block8Bytes, _wl_block8);
 if(order_id!=empty){ 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ordered_date_time));
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(surgeon_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(theatre_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
 if(booking_no!=empty){ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(booking_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(booked_date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(start_time+"-"));
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(oper_num!=empty){ 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(oper_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oper_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
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
         org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("UTF-8", java.lang.String .class,"value"));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
         org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.LOCALE}",java.lang.Object.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("prefix", java.lang.String .class,"var"));
        __tag2.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${\'/eCommon/html/\'}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("sep", java.lang.String .class,"var"));
        __tag3.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${\'?\'}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("style", java.lang.String .class,"var"));
        __tag4.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${prefix}${sessionScope.PREFERRED_STYLE}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("locale", java.lang.String .class,"var"));
        __tag5.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.LOCALE}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
         org.apache.taglibs.standard.tag.rt.core.UrlTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.core.UrlTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setValue(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${style}",java.lang.String.class,pageContext,_jspx_fnmap));
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
