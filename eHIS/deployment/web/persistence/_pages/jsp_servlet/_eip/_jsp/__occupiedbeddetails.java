package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;

public final class __occupiedbeddetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/OccupiedBedDetails.jsp", 1742446783901L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t</head>\n\n\t\t<script>\n\t\t\tvar bodwidth=0\n\t\t\tvar bodheight=0\n\n\t\t\tfunction buildTable(val)\n\t\t\t{\n\t\t\t\tvar rowval = val.split (\"<br>\");\n\t\t\t\t\n\t\t\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\"\n\n\t\t\t\tfor( var i=0; i<rowval.length; i++ )\n\t\t\t\t{\n\t\t\t\t\tif(rowval.length > 6)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar tempValue = i/2;\n\n\t\t\t\t\t\tif(tempValue == 0 || tempValue == 1 || tempValue == 2 || tempValue == 3 || tempValue == 4 || tempValue == 5 || tempValue == 6)\n\t\t\t\t\t\t\ttab_dat += \"<tr class=\'TRNEW\'>\"\n\n\t\t\t\t\t\tvar colval = rowval[i].split(\"^^\")\n\t\t\t\t\t\t\n\t\t\t\t\t\ttab_dat += \"<td class = \'TDLABEL\' nowrap align= \'right\'> \"+ colval[0] +\": </td>\"\n\t\t\t\t\t\ttab_dat += \"<td class = \'TDDATA\' nowrap> \"+ colval[1] +\" </td>\"\n\n\t\t\t\t\t\tif(tempValue == 0.5 || tempValue == 1.5 || tempValue == 2.5 || tempValue == 3.5 || tempValue == 4.5 || tempValue == 5.5 || tempValue == 6.5)\n\t\t\t\t\t\t\ttab_dat += \"</tr> \"\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar colval = rowval[i].split(\"^^\")\n\t\t\t\t\t\ttab_dat += \"<tr class=\'TRNEW\'>\"\n\t\t\t\t\t\ttab_dat += \"<td class = \'TDLABEL\' nowrap align= \'right\'> \"+ colval[0] +\": </td>\"\n\t\t\t\t\t\ttab_dat += \"<td class = \'TDDATA\' nowrap> \"+ colval[1] +\" </td>\"\n\t\t\t\t\t\ttab_dat += \"</tr> \"\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\ttab_dat += \"</table> \"\n\t\t\t\tdocument.getElementById(\'t\').innerHTML = tab_dat\n\t\t\t}\n\n\t\t\tfunction displayToolTip(val,obj)\n\t\t\t{\n\t\t\t\tval = unescape(val)\n\t\t\t\tbuildTable (val)\n\t\t\t\tbodwidth = parent.frames[1].document.body.offsetWidth\n\t\t\t\tbodheight = parent.frames[1].document.body.offsetHeight\n\n\t\t\t\tvar x =event.x\n\t\t\t\tvar y =event.y;\n\n\t\t\t\tx = x + (document.getElementById(\'tooltiplayer\').offsetWidth)\n\t\t\t\ty = y + (document.getElementById(\'tooltiplayer\').offsetHeight)\n\n\t\t\t\tif(x<bodwidth)\n\t\t\t\t\tx =event.x \n\t\t\t\telse\n\t\t\t\t\tx = x - (document.getElementById(\'tooltiplayer\').offsetWidth*2)\n\n\t\t\t\tif(y<bodheight )\n\t\t\t\t\ty =event.y\n\t\t\t\telse if(event.y>bodheight)\n\t\t\t\t\ty = y - (document.getElementById(\'tooltiplayer\').offsetHeight)\n\t\t\t\telse\n\t\t\t\t\ty = y - (document.getElementById(\'tooltiplayer\').offsetHeight);\n\n\t\t\t\t\ty+=document.body.scrollTop\n\t\t\t\t\tx+=document.body.scrollLeft \n\t\t\t\t\tdocument.getElementById(\'tooltiplayer\').style.posLeft= x\n\n\t\t\t\t\tif(document.getElementById(\'tooltiplayer\').offsetWidth > 250)\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\'tooltiplayer\').style.posLeft = 45\t\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tdocument.getElementById(\'tooltiplayer\').style.posLeft = 275 \n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tdocument.getElementById(\'tooltiplayer\').style.posTop = y \n\t\t\t\t\tdocument.getElementById(\'tooltiplayer\').style.visibility=\'visible\'\n\t\t\t}\n\n\t\t\tfunction hideToolTip()\n\t\t\t{\n\t\t\t\t\tdocument.getElementById(\'tooltiplayer\').style.visibility=\'hidden\'\n\t\t\t}\n\t\t\t\n\t\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<body  id=\'b\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n\t\t<input type=\"hidden\" name=\"to_bed_no_value\" id=\"to_bed_no_value\" value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
  
			public String specialCharacter(String single)
			{
				/*int i=0;
				StringBuffer sb = new StringBuffer(single);
				for(int j = 0; single.indexOf('\'',i) != -1; j++)
				{
					i = single.indexOf('\'', i);
					sb.insert(i + j, "'");
					i++;
				}
					return (sb.toString());
					*/
					if(single == null) single = "";
					return single.replaceAll("'","''");
			}	
		

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection	con		= null;
		Statement	stmt	= null;
		ResultSet	rs		= null;
		Statement stmt_cnt	= null;
		ResultSet rs_cnt	= null;
		//PreparedStatement pstmt = null;

		//Added for Operator station restriction
		Statement	stmt_oper	= null;
		ResultSet	rs_oper		= null;
		String  operstn = "";
		String loginUser = checkForNull((String)session.getValue("login_user"));

		String nursing_unit_code		=  "";
		String facility_id				= checkForNull((String) session.getValue("facility_id"));
		String to_room_no				= checkForNull(request.getParameter("to_room_no"));
		String to_bed_no				= checkForNull(request.getParameter("to_bed_no"));
		String available_nursing_unit	= checkForNull(request.getParameter("available_nursing_unit"));
		nursing_unit_code				= checkForNull(available_nursing_unit);
		
		String bed_classification		= checkForNull(request.getParameter("bed_classification"));
		String bed_class_code			= checkForNull(request.getParameter("Bedcode"));
		String bed_type_code			= checkForNull(request.getParameter("bed_type_code"));
		String gender1					= checkForNull(request.getParameter("gender"));
		String pracitioner_id			= checkForNull(request.getParameter("practid"));
		String speciality_code			= checkForNull(request.getParameter("Splcode"));
		String age_value				= checkForNull(request.getParameter("age_value"));
		String age						= checkForNull(request.getParameter("age"));
		String release_hrs				= checkForNull(request.getParameter("release_hrs"));
		String privacy_level			= checkForNull(request.getParameter("privacy_level"));
		String smoking					= checkForNull(request.getParameter("smoking"));
		String infectious_disease		= checkForNull(request.getParameter("infectious_disease"));
		String BedListinOrder1			= checkForNull(request.getParameter("BedListinOrder1"));
		String BedListinOrder2			= checkForNull(request.getParameter("BedListinOrder2" ));
		String BedListinOrder3			= checkForNull(request.getParameter("BedListinOrder3"));
		String wherecondn				=  request.getParameter( "wherecondn" ) ;
		
		if (wherecondn==null || wherecondn.equals("") )  wherecondn= "EMERGENCY_TFR_YN";
		if (release_hrs==null || release_hrs.equals("")) release_hrs="7400";
		
		if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
		nursing_unit_code			= specialCharacter(nursing_unit_code);
		
		//New Condition added for displaying only vacant or occupied beds.
		String search_by_beds =  checkForNull(request.getParameter( "search_by_beds" ) );

		String	prev_group		= "" ;
		String	prev_group1		= "" ;
		String	prev_group2		= "" ;
		String	prev_group3		= "" ;

		String	group1 =  "";
		String	group2 =  "";
		String	group3 =  "";
		String	pseudo_bed_yn = "";
		String	p_nursing_unit_desc = "";

		int		bed_col_num		= 1;
	
            _bw.write(_wl_block8Bytes, _wl_block8);

			StringBuffer l_query_one = new StringBuffer();
			StringBuffer l_query = new StringBuffer();
			l_query_one.append("select ");
			l_query.append("");
try{
			con= ConnectionManager.getConnection(request);
			String operSql = "select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b "+
			 " where a.facility_id='"+facility_id+"' and a.facility_id=b.facility_id	   "+
			 " and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"'   "+
			 " and trunc(sysdate) between b.eff_date_from and 			   "+
			 " nvl(b.eff_date_to,trunc(sysdate)) ";



			stmt_oper = con.createStatement();
			rs_oper = stmt_oper.executeQuery(operSql);
			if (rs_oper.next())
			{
				operstn	 = rs_oper.getString("oper_stn_id");
				if(operstn == null) operstn ="";
			}
			if(rs_oper!=null)rs_oper.close();
			if(stmt_oper!=null)stmt_oper.close();


			if ( BedListinOrder1 !=null && !BedListinOrder1.equals(  "" ) )
				{
					BedListinOrder1 = specialCharacter(BedListinOrder1);
					l_query_one.append(BedListinOrder1 +" group1, ") ;
				}

			if ( BedListinOrder2 !=null && !BedListinOrder2.equals(  "" ) )
			{
				BedListinOrder2 = specialCharacter(BedListinOrder2);
				l_query_one.append(BedListinOrder2 +" group2, ") ;
			}

			if ( BedListinOrder3 !=null && !BedListinOrder3.equals(  "" ) )
			{	
				BedListinOrder3 = specialCharacter(BedListinOrder3);
				l_query_one.append(BedListinOrder3 +" group3, ") ;
			}

			l_query_one.append(" decode(a.pseudo_bed_yn,'Y','Pseudo Bed','N','Normal Bed')pseudo_bed_yn,a.nursing_unit_code, a.bed_no, a.bed_no || decode( a.sex_spec_ind, null, '', '/' || a.sex_spec_ind ) bed_no_label, a.bed_type_code, a.bed_class_code, ");

			l_query_one.append(" a.nursing_unit_short_desc, a.room_no, a.bed_class_short_desc, b.override_yn, ") ;
			l_query_one.append(" a.bed_type_short_desc, a.specialty_short_desc, a.specialty_code,  nvl(a.patient_id,b.bkg_patient_id) patient_id, a.encounter_id, nvl(a.patient_name,b.bkg_patient_name) patient_name, ") ;
			l_query_one.append(" nvl(a.gender,b.bkg_gender) gender,a.nationality_code,a.nationality_long_desc, get_age(nvl(a.date_of_birth,b.bgk_date_of_birth)) age, to_char( a.admission_date_time, 'dd/mm/rrrr hh24:mi') admission_date_time, ") ;
			l_query_one.append(" to_char( a.occupied_until_date_time, 'dd/mm/rrrr hh24:mi') exp_discharge_date_time,b.blocking_type_short_desc, ") ;
			l_query_one.append(" decode ( nvl( a.patient_id, 'X' ), 'X', nvl(b.booking_type, 'A'), 'O' ) bed_status,  ");
			l_query_one.append("	to_char(b.blocked_from,'dd/mm/rrrr hh24:mi') blocked_from ,to_char(b.blocked_until,'dd/mm/rrrr hh24:mi') blocked_until ");
			l_query_one.append("	, b.practitioner_name, b.bed_booking_ref_no,b.booking_date_time, b.blocking_type_code, b.blocking_remarks ");
			l_query_one.append(", a.service_code service_code , a.SERVICE_SHORT_DESC service_desc ,a.ANCILLARY_YN ancillary_yn,null dly_charge ");

			l_query.append(" from ip_nursing_unit_bed_lookup_vw a , am_os_user_locn_access_vw oper_restrn, ") ;

			l_query.append(" (select bkg.override_yn  , bkg.facility_id, booking_type, bed_booking_ref_no, ");
			l_query.append(" bkg.req_nursing_unit_code,bkg.req_bed_no ");
			l_query.append(" ,bkg.blocking_type_code ");
			l_query.append("  ,blktyp.short_desc blocking_type_short_desc ");
			l_query.append("   ,bkg.blocking_remarks ");
			l_query.append("   ,bkg.blocked_from_date_time blocked_from "); //booking
			l_query.append("   ,bkg.blocked_until_date_time blocked_until ");//booking
			l_query.append("   ,nvl(bkglst.patient_id , bkg.patient_id) bkg_patient_id");
			l_query.append("   ,decode(bkglst.patient_id, null , pat.patient_name, bkglst.patient_name) bkg_patient_name "); 
			l_query.append("   ,nvl(bkglst.gender,pat.sex) bkg_gender ");
			l_query.append("   ,nvl(bkglst.date_of_birth,pat.date_of_birth) bgk_date_of_birth ");
			l_query.append("   ,pract.practitioner_name practitioner_name ");
			l_query.append("   ,to_char(bkglst.booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time ");
			l_query.append("	 from  ip_bed_booking  bkg ");
			l_query.append("  ,ip_booking_list bkglst ");
			l_query.append("	  ,ip_blocking_type blktyp ");
			l_query.append("	  ,am_practitioner pract ");
			l_query.append("	  ,mp_patient pat ");
			l_query.append("	   where bkg.booking_status='0' ");
			l_query.append("   and sysdate between blocked_from_date_time and blocked_until_date_time ");
			l_query.append("   and bkg.booking_date_time=(select max (booking_date_time) ");
			l_query.append("   from ip_bed_booking where facility_id=bkg.facility_id ");
			l_query.append("	and req_nursing_unit_code=bkg.req_nursing_unit_code ");
			l_query.append("	 and req_bed_no=bkg.req_bed_no ");
			l_query.append("	 and booking_status='0' ");
			l_query.append("	 and sysdate between blocked_from_date_time and blocked_until_date_time ) ");
			l_query.append("	 and bkglst.bkg_lst_ref_no(+)=bkg.bed_booking_ref_no ");
			l_query.append("	 and blktyp.blocking_type_code(+)=bkg.blocking_type_code ");
			l_query.append("	 and pract.practitioner_id(+)=bkglst.practitioner_id ");
			l_query.append("	 and pat.patient_id(+) =bkglst.patient_id ) b, ");

			l_query.append(" am_facility_room C  where ") ;
			l_query.append(" a.facility_id = '"+ facility_id +"' and a.eff_status = 'E' ");

				
			if (search_by_beds.equals("V"))
			{
				l_query.append(" and (decode(nvl(a.patient_id,'X'), 'X', nvl(b.booking_type,'A'), 'O' ) in ('A','B','L','T') and nvl(b.override_yn,'Y')='Y') ");
			}
			else if (search_by_beds.equals("O"))
			{
				l_query.append(" and (decode(nvl(a.patient_id,'X'), 'X', nvl(b.booking_type,'A'), 'O' ) in ('O','B','L','T') and nvl(b.override_yn,'N')='N') ");
			}

			if ( nursing_unit_code !=null && nursing_unit_code != "")
			{
				l_query.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ") ;
			}


			if ( !pracitioner_id. equals("") )
			{
				l_query.append(" and exists ( select '1' from ip_nursing_unit_for_pract b where facility_id = '"+facility_id+"'  ");
				l_query.append("  and b.nursing_unit_code = a.nursing_unit_code and b.practitioner_id = '"+ pracitioner_id +"'  ) ");
			}

			if ( !speciality_code. equals("") )
			{
				l_query.append(" and exists ( select '1' from ip_nurs_unit_for_specialty c where c.facility_id = '"+ facility_id +"'  ");
				l_query.append(" and c.nursing_unit_code = a.nursing_unit_code and c.specialty_code = '"+ speciality_code +"' ) ");
			}

			if ( (!bed_class_code. equals("")) ||(!bed_type_code.equals("")))
			{
				l_query.append(" and exists ( select '1' from ip_nursing_unit_bed d where d.facility_id = '"+ facility_id +"'  ");
				l_query.append(" and d.nursing_unit_code = a.nursing_unit_code  ");
				l_query.append(" and d.bed_class_code = nvl( '"+bed_class_code+"', bed_class_code ) ");
				l_query.append(" and d.bed_type_code = nvl( '"+bed_type_code+"', bed_type_code ) and rownum<2 ) ");
			}
			
			if ( !gender1. equals("") || !age_value. equals("") )
			{
   			  l_query.append(" and  (( a.age_group_code is null ) or   ((a.age_group_code is not null ) and  ");
			  l_query.append(" exists ( select age_group_code      from am_age_group  ");
			  l_query.append(" where age_group_code=a.age_group_code  ");


				if( !gender1. equals("") )
				{
					l_query.append(" and nvl( gender, '"+ gender1 +"' ) = '"+ gender1 +"' ") ;
				}

				if( !age_value. equals("") )
				{
					l_query.append(" and decode('"+age+"', 'Y', 365, 'M', 30, 1 ) * "+ age_value + "  ");
					l_query.append(" between decode ( age_unit, 'Y', 365, 'M', 30, 1 ) * min_age and decode( age_unit, 'Y', 365, 'M', 30, 1 ) * max_age "); 
				}
				l_query.append("))) ") ;

			}


			if ( bed_class_code !=null && bed_class_code != "")
			{
				bed_class_code = specialCharacter(bed_class_code);
				l_query.append(" and a.bed_class_code = '"+ bed_class_code +"'  ");
			}

			if ( bed_type_code !=null && bed_type_code != "" && bed_type_code.length()!=0 )
			{
				bed_type_code = specialCharacter(bed_type_code);
				l_query.append(" and a.bed_type_code = '"+ bed_type_code +"'  ");
			}
	

			l_query.append(" and b.facility_id(+) = a.facility_id and b.req_nursing_unit_code (+) = a.nursing_unit_code ") ;
			l_query.append( " and b.req_nursing_unit_code(+) = a.nursing_unit_code and b.req_nursing_unit_code (+) = a.nursing_unit_code ") ;
			l_query.append(" and b.req_bed_no(+) = a.bed_no  ") ; 
			l_query.append(" and c.operating_facility_id = a.facility_id "); 
			l_query.append(" and c.room_num(+) = a.room_no ") ; 
			l_query.append(" and a.room_no = '") ; 
			l_query.append(to_room_no) ; 
			l_query.append("' and a.bed_no = '") ; 
			l_query.append(to_bed_no) ; 
			l_query.append("' ") ; 

			if (gender1!=null && !gender1.equals(  "" ))
			{
				gender1 = specialCharacter(gender1);
				l_query.append(" and SEX_SPEC_IND = '"+gender1+"' ");
			}	
			if ( privacy_level !=null && !privacy_level.equals(  "" ) )
			{
				privacy_level = specialCharacter(privacy_level);
				l_query.append(" and c.privacy_level(+) = '"+ privacy_level +"' ") ; 
			}

			if ( smoking !=null && !smoking.equals(  "" ) )
			{
				smoking = specialCharacter(smoking);
				l_query.append(" and c.smoking_yn(+) = '"+ smoking +"' ") ; 
			}

			if ( infectious_disease !=null && !infectious_disease.equals(  "" ) )
			{
				infectious_disease = specialCharacter(infectious_disease);
				l_query.append(" and c.inf_disease_yn(+) = '"+ infectious_disease +"' "); 
			}	
		    
			l_query.append(" and a.specialty_status = 'E' and a.nursing_unit_status = 'E' ");

			l_query.append(" and a.facility_id=oper_restrn.facility_id and a.nursing_unit_code=oper_restrn.locn_code and oper_restrn.locn_type = 'N' and oper_restrn.oper_stn_id='"+operstn+"' and oper_restrn.appl_user_id='"+loginUser+"' and oper_restrn."+wherecondn+" = 'Y' ");

			l_query.append(" and decode(a.CURRENT_STATUS,'O',nvl(a.occupied_until_date_time,sysdate+30)-("+release_hrs+"/24),decode(nvl(override_yn,'Y'),'N',nvl(b.blocked_until,sysdate-100)-("+release_hrs+"/24),sysdate-100)) < sysdate ");
			if(bed_classification!=null && bed_classification.equalsIgnoreCase("P"))
						l_query.append(" and a.PSEUDO_BED_YN = 'Y' ") ;

			else if(bed_classification!=null && bed_classification.equalsIgnoreCase("N"))
						l_query.append(" and a.PSEUDO_BED_YN = 'N' ");
		
			if( bed_classification!=null && (!bed_classification.equals("N")) && (wherecondn.equals("CREATE_BOOKING_YN") || wherecondn.equals("REVISE_BOOKING_YN")))
			{
					l_query.append(" and a.PSEUDO_BED_YN != 'Y' ");
			}

			/*String sqlCount = "Select count(1) "+l_query.toString();

		int max_count = 0;
		pstmt = con.prepareStatement(sqlCount);
		rs = pstmt.executeQuery();

		if(rs.next())
		{
			max_count = rs.getInt(1);
		}*/
			l_query.append(" order by a.nursing_unit_short_desc, ");
			if ( BedListinOrder1 !=null && !BedListinOrder1.equals( "" ) )
				l_query.append(" group1, ") ;

			if ( BedListinOrder2 !=null &&  !BedListinOrder2.equals( "" ) )
				l_query.append(" group2, ") ;

			if ( BedListinOrder3 !=null &&  !BedListinOrder3.equals( "" ) )
				l_query.append(" group3, ") ;

				l_query.append(" bed_no ") ;

			l_query_one.append(l_query.toString());
		//if(max_count !=0)
		//{
				stmt = con.createStatement() ;
				
				rs     = stmt.executeQuery(l_query_one.toString()) ;
				int count_buttn = 0 ;
				StringBuffer TableStr = new StringBuffer();



				if(rs!=null)
				{	
					String nursingunitcode = "";
					while(rs.next())
					{
						if (nursingunitcode != rs.getString("nursing_unit_code"))
						{
							String p_pseudo_bed_yn = "";
							nursingunitcode = rs.getString("nursing_unit_code");
							if((wherecondn.equalsIgnoreCase("CREATE_BOOKING_YN") || wherecondn.equalsIgnoreCase("REVISE_BOOKING_YN")))
							{
								p_pseudo_bed_yn="N";
							}
							else
							{
								if (bed_classification.equals("N"))
								{
									p_pseudo_bed_yn="N";
								}
								else if (bed_classification.equals("P"))
								{
									p_pseudo_bed_yn="Y";
								}
								else if (bed_classification.equals("B"))
								{
									p_pseudo_bed_yn="X";
								}

							}			
							String sqlCnt = "SELECT d.num_of_beds total, d.num_of_beds_occupied occupied, blocked_count, non_overridable_count FROM IP_NURSING_UNIT a, ( SELECT COUNT(DISTINCT req_bed_no) non_overridable_count FROM IP_BED_BOOKING WHERE booking_status='0' AND override_yn='N' AND SYSDATE BETWEEN blocked_from_date_time AND blocked_until_date_time AND facility_id='"+facility_id+"' AND req_nursing_unit_code='"+nursingunitcode+"') b, (SELECT COUNT(DISTINCT req_bed_no) blocked_count FROM IP_BED_BOOKING WHERE booking_status='0'  AND facility_id='"+facility_id+"' AND REQ_nursing_unit_code='"+nursingunitcode+"' AND SYSDATE BETWEEN blocked_from_date_time AND blocked_until_date_time) c, (SELECT COUNT(g.bed_no) num_of_beds,SUM(DECODE(LTRIM(RTRIM(g.patient_id)),NULL,0,1)) num_of_beds_occupied FROM IP_NURSING_UNIT_BED_LOOKUP_VW g WHERE g.facility_id ='"+facility_id+"' AND g.nursing_unit_code='"+nursingunitcode+"' AND g.pseudo_bed_yn=DECODE('"+p_pseudo_bed_yn+"','X',g.pseudo_bed_yn,'"+p_pseudo_bed_yn+"') AND g.EFF_STATUS='E' ) d WHERE A.facility_id='"+facility_id+"' AND A.nursing_unit_code='"+nursingunitcode+"'";
							stmt_cnt = con.createStatement();
							rs_cnt = stmt_cnt.executeQuery( sqlCnt );
							if(rs_cnt!=null)
							{
								if( rs_cnt.next() )
								{
								}
							}
							if (rs_cnt != null) rs_cnt.close();
							if (stmt_cnt != null) stmt_cnt.close();
						}
						bed_type_code		= rs.getString("bed_type_code") ;
						bed_class_code		= rs.getString("bed_class_code") ;
						String bed_status	= rs.getString("bed_status") ;
						String butt_color 	= "IP_GreenButton";
						String bed_status_value = "Vacant"; 
						String placeholder	= "";
						p_nursing_unit_desc = rs.getString("nursing_unit_short_desc");

						StringBuffer tip = new StringBuffer();
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+" ^^"	+rs.getString("bed_no") +"<br>" );
						placeholder = "";
						if(rs.getString( "nursing_unit_short_desc" )!=null)
						{
							placeholder = specialCharacter(rs.getString( "nursing_unit_short_desc" ));
						}	
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"^^"+placeholder+"<br>" );
						placeholder="";
						if(rs.getString( "room_no" )!=null)
							placeholder = specialCharacter(rs.getString( "room_no" ));
						
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoomCubicle.label","common_labels")+" ^^"	+placeholder+"<br>" );
						placeholder="";
						if(rs.getString( "bed_class_short_desc" )!=null)
							placeholder = specialCharacter(rs.getString( "bed_class_short_desc" ));
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+" ^^"	+placeholder+"<br>" );
						placeholder="";
						if(rs.getString( "bed_type_short_desc" )!=null)
							placeholder = specialCharacter(rs.getString( "bed_type_short_desc" ));
						tip.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+" ^^"+placeholder);
						
						if( bed_status.equals("O") )
						{
							butt_color	= "IP_RedButton";
							bed_status_value = "Occupied";
							if( String.valueOf( rs.getLong("encounter_id") ) == null || String.valueOf( rs.getLong("encounter_id") ).equals("0") )
								placeholder = " ";
							else
								placeholder = String.valueOf( rs.getLong("encounter_id") ) ;
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+" ^^ "		+ placeholder );
							if(rs.getString("patient_id")!=null)
								placeholder = specialCharacter(rs.getString("patient_id"));
							
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"^^ "+placeholder   );
							if(rs.getString("patient_name")!=null)
								placeholder = specialCharacter(rs.getString("patient_name"));
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"^^"+ placeholder );
							if(rs.getString("age")!=null)
								placeholder = specialCharacter(rs.getString("age"));
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"^^"+ placeholder );

							if(rs.getString("gender") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("gender");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"^^"+ placeholder );
							
							if(rs.getString("nationality_long_desc") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("nationality_long_desc");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels")+"^^"			+ placeholder );
							if(rs.getString("admission_date_time") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("admission_date_time");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" +	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AdmittedDate.label","ip_labels")+"^^ "		+ placeholder );

							if(rs.getString("exp_discharge_date_time") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("exp_discharge_date_time");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExpectedDischarge.label","ip_labels")+"^^"+ placeholder  );
						}


						if( bed_status.equals("B") || bed_status.equals("L") )
						{
							if( rs.getString( "override_yn" ).equals( "Y" ) )
							{
								butt_color	= "IP_YellowButton";
								bed_status_value = "Overridable";
							}
							else
							{
								butt_color	= "IP_BrownButton";
								bed_status_value = "Non-Overridable";
							}
						}
						
						if( bed_status.equals("D") )
						{
							butt_color	= "IP_BrownButton";
							bed_status_value = "Non-Overridable";
						}

						if( bed_status.equals("T") )
						{
							if( rs.getString( "override_yn" ).equals( "Y" ) )
							{
								butt_color	= "IP_YellowButton";
								bed_status_value = "Overridable";
							}
							else
							{
								butt_color	= "IP_BrownButton";
								bed_status_value = "Non-Overridable";
							}
						}
						
						if( bed_status.equals("L") )
						{
							if(rs.getString("patient_id") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("patient_id");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"^^ "+ placeholder  );

							if(rs.getString("patient_name") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("patient_name");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"^^"+ placeholder  );

							if(rs.getString("age") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("age");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"^^"+ placeholder  );

							if(rs.getString("gender") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("gender");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"^^"					+ placeholder  );

							if(rs.getString("practitioner_name") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("practitioner_name");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							
							tip.append("<br>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels")+"^^"	+placeholder  );

							if(rs.getString("blocked_from") ==null)
								placeholder = " ";
							else
								{placeholder = rs.getString("blocked_from");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookedFrom.label","ip_labels")+"^^"+ placeholder  );
							}
							

							if(rs.getString("blocked_until") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("blocked_until");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookedUntil.label","ip_labels")+"^^"				+ placeholder  );

							if(rs.getString("bed_booking_ref_no") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("bed_booking_ref_no");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingRefNo.label","common_labels")+"^^"+ placeholder ); 
						
						}

						if( bed_status.equals("B") )
						{
							if(rs.getString("blocking_type_code") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("blocking_type_short_desc");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedType.label","ip_labels")+"^^"+ placeholder  );

							if(rs.getString("blocking_remarks") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("blocking_remarks");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedRemarks.label","ip_labels")+"^^"	+ placeholder );
                                
							if(rs.getString("blocked_from") ==null)
								placeholder = " ";
							else
								placeholder = rs.getString("blocked_from");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockedFromDate.label","ip_labels")+"^^"		+ placeholder );
                        
							if(rs.getString("blocked_until") ==null)
								placeholder = " ";
							else 
								placeholder = rs.getString("blocked_until");
							if(placeholder!=null)
								placeholder = specialCharacter(placeholder);
							tip.append("<br>" +	"Blocked Until Date^^"		+ placeholder );
						}

							if(rs.getString("pseudo_bed_yn") ==null)
								pseudo_bed_yn = " ";
							else 
								pseudo_bed_yn = rs.getString("pseudo_bed_yn");
							if(pseudo_bed_yn!=null)
								pseudo_bed_yn = specialCharacter(pseudo_bed_yn);

							if(pseudo_bed_yn.equals("Pseudo Bed") && bed_status.equals("O"))
							{
								butt_color = "IP_LPinkButton";
								bed_status_value = "Pseudo-Occupied";
							}
							else if(pseudo_bed_yn.equals("Pseudo Bed"))
							{
								butt_color = "IP_LGreenButton";
								bed_status_value = "Pseudo-Vacant";
							}

							tip.append("<br>" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BedClassification.label","ip_labels")+"^^"+ pseudo_bed_yn );

						if( BedListinOrder1 !=null && !BedListinOrder1.equals("") )
						{
							group1  = rs.getString( "group1" ) ; 
							if( group1 == null )
								group1 = "&nbsp";
						}

						if( BedListinOrder2 !=null && !BedListinOrder2.equals("") )
							group2  = rs.getString( "group2" ) ; 

						if( BedListinOrder3 !=null && !BedListinOrder3.equals("") )
							group3  = rs.getString( "group3" ) ;

						if (!prev_group.equals(p_nursing_unit_desc))
						{							
							prev_group = p_nursing_unit_desc;
							bed_col_num = 1;
						}

						if( ( BedListinOrder1 !=null || !BedListinOrder1.equals("") ) && ( !prev_group1.equals(group1) ) || ( BedListinOrder2 !=null || !BedListinOrder2.equals("") ) && ( !prev_group2.equals(group2) ) || ( BedListinOrder3 !=null || !BedListinOrder3.equals("") ) && ( !prev_group3.equals(group3) ) )
						{														
								prev_group1 = group1 ; 

								if( BedListinOrder2  != null && !BedListinOrder2.equals( "" ) )
								{
									prev_group2 = group2 ; 
								}

								if( BedListinOrder3  != null && !BedListinOrder3.equals( "" ) )
								{
									prev_group3 = group3 ; 
								}
								bed_col_num = 1;								
						}
						if (!bed_status_value.equals("Vacant"))
						{
							TableStr.append("<script>var tips"+count_buttn+" = escape(\""+tip.toString()+"\")</script>");
							TableStr.append("<input type='button' name='bed_status_name' id='bed_status_name' value=\""+bed_status_value+"\" onMouseOver=\"displayToolTip(tips"+count_buttn+",this)\" class='"+butt_color+"' onMouseOut ='hideToolTip()' style='width:102;cursor:pointer;' > ");
						}
					if ( bed_col_num == 9)
					{
						bed_col_num = 0;
					}

					bed_col_num++ ;
					count_buttn++ ;
				}
			}
			out.print(TableStr.toString());
		//}
	}catch(Exception e) {out.println(e.toString());}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (rs_cnt != null) rs_cnt.close();
		if (stmt_cnt != null) stmt_cnt.close();
		//if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(to_bed_no));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
