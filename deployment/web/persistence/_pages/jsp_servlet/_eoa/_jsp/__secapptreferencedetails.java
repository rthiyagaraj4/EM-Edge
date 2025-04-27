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
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __secapptreferencedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/SecApptReferenceDetails.jsp", 1742298752067L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n ";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n <table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'102%\' align=\'center\' >\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'102%\' align=\'center\' >\n\t\t\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t <tr>\n\t\t\t <td  class=\'PATIENTLINECOLOROTHLANG\'  nowrap width=\'30%\' align=\'left\' colspan=\'2\'><font size=\'-1\'><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></font></td>\n\t\t\t <td  class=\'PATIENTLINECOLOROTHLANG\'  width=\'50%\' nowrap align=\'left\' colspan=\'2\'><b>&nbsp;</b></td> \n\t\t\t <td width=\'5%\' align=\'right\' width=\'30%\' class=\'PATIENTLINECOLOROTHLANG\' colspan=\'2\' align=\'right\' nowrap ><font size=\'-1\'><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></font></td>\n\t\t\t <td  class=\'PATIENTLINECOLOROTHLANG\'  width=\'30%\' nowrap align=\'left\' colspan=\'1\'><font size=\'-1\'><b>&nbsp;&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</b></font></td>\n\t\t</tr>\n\t\n\t\t<tr>\n\t\t\t <td  class=\'PATIENTLINECOLOROTHLANG\'  nowrap align=\'left\' colspan=\'2\'><font size=\'-1\'><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></font></td>\n\t\t\t <td  class=\'PATIENTLINECOLOROTHLANG\'  nowrap align=\'left\' colspan=\'2\'><b></b></td> \n\t\t\t \n\t\t\t <td  class=\'PATIENTLINECOLOROTHLANG\'  nowrap align=\'right\' colspan=\'2\'><font size=\'-1\'><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b>&nbsp;</font></td>\n\t\t\t \n\t\t\t <td  class=\'PATIENTLINECOLOROTHLANG\'  nowrap align=\'left\' colspan=\'1\'><font size=\'-1\'><b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;|";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</b></font></td>\n\t\t </tr>\n\t\t\n</table>\n\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'102%\' align=\'center\' >\n\t<tr>\n\t\t\t<td class=\'COLUMNHEADER\'  width=\'30%\' nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\'  width=\'28%\' nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\'  width=\'25%\' nowrap><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</b></td>\n\t\t\t<td class=\'COLUMNHEADER\'  width=\'25%\' nowrap><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<tr>\n\t\t<td  class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  nowrap >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t<td  class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t</tr> \n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\nwindow.close();</script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t</table>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</table>\n</body>\n</html> \n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		Connection con = null;
		Statement	stmt		=null;
		ResultSet	rs			=null;
		PreparedStatement pstmt=null;
		Statement	stmt1		=null;
		Statement stmt3 =null;
		
		ResultSet	rs1			=null;
		ResultSet   rs2			=null;	
		request.setCharacterEncoding("UTF-8");

		String appt_no2	= request.getParameter("appt_no2");
		String fac_id2	= request.getParameter("fac_id2");
		String called_from	= request.getParameter("called_from")==null?"":request.getParameter("called_from");//Added for the CRF - Bru-HIMS-CRF-0198
		String classValue		="";
		String appt_time	="";
		String appt_time1	="";
		String str1="";
		String resource_class	="";
		String resource_id		="";
		String sql4="";
		String sql5="";
		String RESOURCE_ID="";
		String RESOURCE_CLASS="";
		String res_description="";
		String name	="";
		String gender	="";
		String pat_id	="";
		String age	="";
		String clinic_name	="";
		String pat_short_name	="";
		String appt_ref	="";
		String appt_date1="";
		//String resc_desc="";
		int i=0;
					String locale=(String)session.getAttribute("LOCALE");

try{

	con = ConnectionManager.getConnection(request);
	stmt1					=con.createStatement();
	stmt=con.createStatement();
	stmt3=con.createStatement();
	if(called_from.equals("")){
		//sql4="select APPT_REF_NO,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(RESOURCE_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, RESOURCE_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, RESOURCE_ID,'"+locale+"','2')) RESOURCE_DESC,RESOURCE_ID,RESOURCE_CLASS,to_char(APPT_DATE,'dd/mm/yyyy')Apptdate,to_char(APPT_SLAB_FROM_TIME,'hh24:mi')Appttime, to_char(APPT_SLAB_TO_TIME,'hh24:mi')Appttime1 from OA_RESOURCE_FOR_APPT  where appt_ref_no = nvl('"+appt_no2+"',appt_ref_no)  and FACILITY_ID='"+fac_id2+"' ORDER by  APPTDATE,APPTTIME";
		sql4="select APPT_REF_NO,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(RESOURCE_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, RESOURCE_ID,?,'2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, RESOURCE_ID,?,'2')) RESOURCE_DESC,RESOURCE_ID,RESOURCE_CLASS,to_char(APPT_DATE,'dd/mm/yyyy')Apptdate,to_char(APPT_SLAB_FROM_TIME,'hh24:mi')Appttime, to_char(APPT_SLAB_TO_TIME,'hh24:mi')Appttime1 from OA_RESOURCE_FOR_APPT  where appt_ref_no = nvl(?,appt_ref_no)  and FACILITY_ID=? ORDER by  APPTDATE,APPTTIME";
	}else{
		//sql4="select APPT_REF_NO,AM_GET_DESC.AM_PRACTITIONER(RESOURCE_ID,'"+locale+"','1') RESOURCE_DESC,RESOURCE_ID,RESOURCE_CLASS,to_char(APPT_DATE,'dd/mm/yyyy')Apptdate,to_char(APPT_SLAB_FROM_TIME,'hh24:mi')Appttime, to_char(APPT_SLAB_TO_TIME,'hh24:mi')Appttime1 from OA_RESOURCE_FOR_APPT  where appt_ref_no = nvl('"+appt_no2+"',appt_ref_no)  and FACILITY_ID='"+fac_id2+"' and resource_class='P' ORDER by  APPTDATE,APPTTIME";//Added for the CRf - Bru-HIMS-CRF-0198		
		sql4="select APPT_REF_NO,AM_GET_DESC.AM_PRACTITIONER(RESOURCE_ID,?,'1') RESOURCE_DESC,RESOURCE_ID,RESOURCE_CLASS,to_char(APPT_DATE,'dd/mm/yyyy')Apptdate,to_char(APPT_SLAB_FROM_TIME,'hh24:mi')Appttime, to_char(APPT_SLAB_TO_TIME,'hh24:mi')Appttime1 from OA_RESOURCE_FOR_APPT  where appt_ref_no = nvl(?,appt_ref_no)  and FACILITY_ID=? and resource_class='P' ORDER by  APPTDATE,APPTTIME";//Added for the CRf - Bru-HIMS-CRF-0198		
	}

		//rs = stmt.executeQuery(sql4);
		pstmt = con.prepareStatement(sql4);
		pstmt.setString(1,locale);
		if(called_from.equals("")){
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,appt_no2);
		pstmt.setString(5,fac_id2);
		}else{
		pstmt.setString(2,appt_no2);
		pstmt.setString(3,fac_id2);
		}
		rs = pstmt.executeQuery();
		if ( rs != null )
		{  
			 
            _bw.write(_wl_block10Bytes, _wl_block10);
 
//sql5="select APPT_REF_NO, PATIENT_ID, APPT_TIME, PATIENT_NAME, GENDER, get_age(date_of_birth) age, AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,'"+locale+"','1')CARE_LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) PRACTITIONER_SHORT_NAME, to_char(APPT_DATE,'dd/mm/yyyy')Apptdate from oa_appt where appt_ref_no = nvl('"+appt_no2+"',appt_ref_no) and FACILITY_ID='"+fac_id2+"'";
			 sql5="select APPT_REF_NO, PATIENT_ID, APPT_TIME, PATIENT_NAME, GENDER, get_age(date_of_birth) age, AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,?,'1')CARE_LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,?,'1') CLINIC_SHORT_DESC, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) PRACTITIONER_SHORT_NAME, to_char(APPT_DATE,'dd/mm/yyyy')Apptdate from oa_appt where appt_ref_no = nvl(?,appt_ref_no) and FACILITY_ID=?";
			//rs1 = stmt1.executeQuery(sql5);
			
			pstmt = con.prepareStatement(sql5);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,locale);
			pstmt.setString(6,appt_no2);
			pstmt.setString(7,fac_id2);
			rs1 = pstmt.executeQuery();
			if ( rs1 != null )
			while(rs1.next())
			{	
				name=rs1.getString("PATIENT_NAME");
				gender=rs1.getString("GENDER");
				pat_id=rs1.getString("PATIENT_ID");
				age=rs1.getString("age");
				clinic_name=rs1.getString("CLINIC_SHORT_DESC");
				pat_short_name=rs1.getString("PRACTITIONER_SHORT_NAME");
				appt_ref=rs1.getString("APPT_REF_NO");
				appt_date1=rs1.getString("Apptdate");
				if(appt_date1==null) appt_date1="";

				String appt_date1_disply=DateUtils.convertDate(appt_date1,"DMY","en",locale);

				if(age==null) age="";
				if(name==null) name="";
				if(pat_id==null) pat_id="";
				if(appt_ref==null) appt_ref="";
				if(pat_short_name==null) pat_short_name="";
				if(gender==null) gender="";
				if(clinic_name==null) clinic_name="";
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(age));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clinic_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_short_name));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(appt_ref));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(appt_date1_disply));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 } //end of while
		
		while(rs.next())
		{	
			if ( i % 2 == 0 )
			  classValue = "QRYEVEN" ;
		   else
			  classValue = "QRYODD" ;
		
				appt_no2=rs.getString("APPT_REF_NO");
			
				
			




				resource_id=rs.getString("RESOURCE_DESC");
				if(resource_id==null){
				resource_id="&nbsp;";
				}
			
				RESOURCE_ID=rs.getString("RESOURCE_ID");
				if(RESOURCE_ID==null) {
					RESOURCE_ID="&nbsp;";
				}
				RESOURCE_CLASS=rs.getString("RESOURCE_CLASS");
				if(RESOURCE_CLASS==null) {
					RESOURCE_CLASS="&nbsp;";
				}

				if(RESOURCE_CLASS.equals("P"))
				{
				resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(RESOURCE_CLASS.equals("R"))
				{
				resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(RESOURCE_CLASS.equals("E"))
				{
				resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(RESOURCE_CLASS.equals("O"))
				{
				resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
				}

				appt_time=rs.getString("Appttime");
				if(appt_time==null){
				appt_time="&nbsp;";
				}
				appt_time1=rs.getString("Appttime1");
				if(appt_time1==null){
				appt_time1="&nbsp;";
				}
				if(RESOURCE_CLASS.equals("P"))
				{
						//str1  = "select a.pract_type res_type, a.short_name descrip, b.desc_sysdef res_desc from am_practitioner_lang_vw a, am_pract_type_lang_vw b where nvl(a.practitioner_id,'x')=nvl('"+RESOURCE_ID+"','x') and b.pract_type=a.pract_type and a.language_id = '"+locale+"' and a.language_id = b.language_id " ;
				        str1 = "SELECT a.pract_type res_type, a.short_name descrip, b.desc_sysdef res_desc " + "FROM am_practitioner_lang_vw a, am_pract_type_lang_vw b " + "WHERE NVL(a.practitioner_id, 'x') = NVL(?, 'x') " + "AND b.pract_type = a.pract_type " + "AND a.language_id = ? " + "AND a.language_id = b.language_id"; //MODIFIED FOR PREPARED STATEMENT ISSUE
				}else if(RESOURCE_CLASS.equals("R"))
				{
						//str1  = "select a.room_type res_type, a.short_desc descrip, b.short_desc res_desc from am_facility_room_lang_vw a, am_care_locn_type_lang_vw b where nvl(a.room_num,'x')=nvl('"+RESOURCE_ID+"','x') and a.OPERATING_FACILITY_ID='"+fac_id2+"' and a.room_type=b.LOCN_TYPE and a.language_id = '"+locale+"' and a.language_id = b.language_id" ;
						str1 = "SELECT a.room_type res_type, a.short_desc descrip, b.short_desc res_desc " + "FROM am_facility_room_lang_vw a, am_care_locn_type_lang_vw b " + "WHERE NVL(a.room_num, 'x') = NVL(?, 'x') " + "AND a.operating_facility_id = ? " + "AND a.room_type = b.locn_type " + "AND a.language_id = ? " + "AND a.language_id = b.language_id"; //MODIFIED FOR PREPARED STATEMENT ISSUE
				}else{
						//str1  = "select a.resource_type res_type, a.short_desc descrip, b.short_desc res_desc from am_resource_lang_vw a, am_resource_type_lang_vw b where nvl(a.resource_id,'x')=nvl('"+RESOURCE_ID+"','x') and a.facility_id= '"+fac_id2+"' and a.resource_Class='"+RESOURCE_CLASS+"' and a.resource_type=b.resource_type and a.language_id = '"+locale+"' and a.language_id = b.language_id" ;
						str1 = "SELECT a.resource_type res_type, a.short_desc descrip, b.short_desc res_desc " + "FROM am_resource_lang_vw a, am_resource_type_lang_vw b " + "WHERE NVL(a.resource_id, 'x') = NVL(?, 'x') " + "AND a.facility_id = ? " + "AND a.resource_Class = ? " +"AND a.resource_type = b.resource_type " + "AND a.language_id = ? " + "AND a.language_id = b.language_id"; /*MODIFIED FOR ML-MMOH-SCF-3103-TF*/
				}

					//rs2=stmt3.executeQuery(str1);
					pstmt = con.prepareStatement(str1);
					pstmt.setString(1,RESOURCE_ID);
					if(RESOURCE_CLASS.equals("P")){
					pstmt.setString(2,locale);
					}else if(RESOURCE_CLASS.equals("R")){
					pstmt.setString(2,fac_id2);
					pstmt.setString(3,locale);
					}else{
					pstmt.setString(2,fac_id2);
					pstmt.setString(3,RESOURCE_CLASS);
					pstmt.setString(4,locale);
					}
					rs2 = pstmt.executeQuery();

					res_description="";
					if(rs2 !=null )
					{
						while(rs2.next())
						{
						res_description=rs2.getString("res_desc");
						}
					}
					if(rs2 !=null)rs2.close();


		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(res_description));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(resource_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(appt_time));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(appt_time1));
            _bw.write(_wl_block29Bytes, _wl_block29);
	
			i++;
		
	}//end of while
			
  } 

  if(i == 0)
{
            _bw.write(_wl_block30Bytes, _wl_block30);
}


  if(rs !=null) rs.close();
		
            _bw.write(_wl_block31Bytes, _wl_block31);

	if (rs != null) rs.close();
	if (rs1 != null) rs1.close();
	if(rs2 !=null)rs2.close();
	if (stmt != null) stmt.close();
	if (stmt1 != null) stmt1.close();
	if (stmt3 != null) stmt3.close();

}
catch(Exception e)
	{
	//out.println("one L :" +e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourceclass.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcetype.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcename.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
}
