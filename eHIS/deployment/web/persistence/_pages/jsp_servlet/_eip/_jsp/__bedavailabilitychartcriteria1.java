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
import eCommon.XSSRequestWrapper;

public final class __bedavailabilitychartcriteria1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BedAvailabilityChartCriteria1.jsp", 1709117712598L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t\t</head>\n\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\tvar params = \"\";\n\t\t\t\tfrm = parent.criteria0.document.forms[0]\n\t\t\t\tvar bed_list = true ; \n\t\t\t\tif( frm.BedListinOrder1.value!=\"\" &&  frm.BedListinOrder2.value!=\"\" )\n\t\t\t\t{\n\t\t\t\t\tif ( frm.BedListinOrder1.value == frm.BedListinOrder2.value )\n\t\t\t\t\t\tbed_list = false\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tif ( frm.BedListinOrder3.value!=\"\"  )\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif ( frm.BedListinOrder1.value == frm.BedListinOrder3.value )\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tbed_list = false\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif( frm.BedListinOrder2.value == frm.BedListinOrder3.value )\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tbed_list = false;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t\tif(bed_list)\n\t\t\t\t{\n\t\t\t\t\tfor( var i=0; i<frm.elements.length; i++ )\n\t\t\t\t\t\tparams += frm.elements[i]. name + \"=\" + escape(frm.elements[i].value) +\"&\";\n\t\t\t\t\tvar bed_yn=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\n\t\t\t\t\tvar from_date = parent.criteria0.document.forms[0].from_date.value;\n\t\t\t\t\tvar to_date = parent.criteria0.document.forms[0].to_date.value;\n\t\t\t\t\tif(from_date!=null && from_date!=\'\')\n\t\t\t\t\t\tfrom_date = convertDate(from_date,\"DMYHM\",localeName,\"en\");\n\t\t\t\t\tif(to_date!=null && to_date!=\'\')\n\t\t\t\t\t\tto_date = convertDate(to_date,\"DMYHM\",localeName,\"en\");\n\n\n\t\t\t\t\tparent.result.location.href = \'../jsp/BedAvailabilityChartResult.jsp?\'+params+\"&ipparam_bed_yn=\"+bed_yn+\"&query_gender_type=\"+\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'+\"&from_date_converted=\"+from_date+\"&to_date_converted=\"+to_date;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.result.location.href = \'../../eCommon/html/blank.html\'\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.result.location.href = \'../../eCommon/html/blank.html\'\n\t\t\t\t</script>\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

// Added by Sridhar R on 2/23/2005... 
// This func will check for null values & return empty string if Null...
	private String checkForNull(String inputString)
	{
		return (inputString==null)? "" : inputString;
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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
	Statement stmt_oper	= null;
	ResultSet rs_oper	= null;

	String facility_id			= (String)session.getValue("facility_id");
	String loginUser			= (String)session.getValue("login_user");
	String calledoption			= checkForNull(request.getParameter("calledoption"));
	//String bed_available_date_yn= checkForNull(request.getParameter("bed_available_date_yn"));
	String nursing_unit_code	= checkForNull(request.getParameter("nursing_unit"));
	String pracitioner_id		= checkForNull(request.getParameter("practid"));
	String speciality_code		= checkForNull(request.getParameter("Splcode"));
	String bed_class_code		= checkForNull(request.getParameter("Bedcode"));
	String gender				= checkForNull(request.getParameter("gender"));
	String age_value			= checkForNull(request.getParameter("age_value"));
	String age					= checkForNull(request.getParameter("age"));
	String patient_class		= checkForNull(request.getParameter("patient_class"));
	String bed_type_code		= checkForNull(request.getParameter("bed_type_code"));
	String ipparam_bed_yn		= checkForNull(request.getParameter("ipparam_bed_yn"));
	String oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String query_gender_type	= checkForNull(request.getParameter("query_gender_type"));
	String wherecondn			= checkForNull(request.getParameter("wherecondn"));
	//String bed_booking_ref_no	= checkForNull(request.getParameter("bed_booking_ref_no"));
		if(wherecondn.equals("")) wherecondn = "ADMIT_PAT_YN";

	StringBuffer sql			= new StringBuffer();
	String operstn				= "";

	try
	{
		con = ConnectionManager.getConnection(request);
		if(oper_stn_id == null || oper_stn_id.equals(""))
		{
			StringBuffer operSql = new StringBuffer();
			operSql.append("select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b  where a.facility_id='"+facility_id+"' and a.facility_id=b.facility_id and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"' and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ");
			stmt_oper = con.createStatement();
			rs_oper = stmt_oper.executeQuery(operSql.toString());
			
			if (rs_oper.next())
			{
				operstn	 = checkForNull(rs_oper.getString("oper_stn_id"));
			}
			if (rs_oper != null) rs_oper.close();
			if (stmt_oper != null) stmt_oper.close();
		}
		else
		{
				operstn = oper_stn_id;
		}

		sql.append(" select a.nursing_unit_code, a.short_desc from ip_nursing_unit a, am_os_user_locn_access_vw b  ");
		sql.append(" where a.facility_id = '"+ facility_id +"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code "); 
		sql.append(" and a.locn_type=b.locn_type and b.locn_type = 'N' ");
		sql.append(" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "); 

		if(wherecondn.equals("CREATE_BOOKING_YN"))
			sql.append(" and (b.CREATE_BOOKING_YN='Y' or b.CREATE_BOOKING_WITH_CONF_YN = 'Y') ");
		else if(wherecondn.equals("ASSIGN_BED_YN"))
			sql.append(" and b.ASSIGN_BED_YN='Y' and a.appl_patient_class ='"+patient_class+"' ");
		else
			sql.append(" and b."+wherecondn+"='Y' ");
		
		sql.append(" and a.eff_status='E' ");

		if ( !nursing_unit_code. equals( "" ) )
			sql.append(" and nursing_unit_code = '"+ nursing_unit_code +"' ");

		if ( !pracitioner_id. equals("") )
		{
			sql.append(" and exists ( select '1' from ip_nursing_unit_for_pract b where facility_id = '"+facility_id+"'  ");
			sql.append(" and b.nursing_unit_code = a.nursing_unit_code and b.practitioner_id = '"+pracitioner_id +"'  ) ");
		}

		if ( !speciality_code. equals("") )
		{
			sql.append(" and exists ( select '1' from ip_nurs_unit_for_specialty c where c.facility_id = '"+facility_id+"'  ");
			sql.append(" and nursing_unit_code = a.nursing_unit_code and c.specialty_code = '"+speciality_code+"' ) ");
		}

		if ( (!bed_class_code. equals("")) ||(!bed_type_code.equals("")))
		{
			sql.append(" and exists(select '1' from ip_nursing_unit_bed d where d.facility_id = '"+facility_id+"' ");
			sql.append(" and d.nursing_unit_code = a.nursing_unit_code  ");
			if(!bed_class_code.equals(""))
			sql.append(" and d.bed_class_code = nvl( '"+bed_class_code+"', bed_class_code ) ");
			if(!bed_type_code.equals(""))
			{
			sql.append(" and d.bed_type_code = nvl( '"+bed_type_code+"', bed_type_code ) and rownum<2 ) ");
			} else{
  sql.append(" and rownum<2 ) ");

			}
		}

		if ( !gender. equals("") || !age_value. equals("") )
		{
			sql.append(" and  (( a.age_group_code is null ) or   ((a.age_group_code is not null ) and ");
			sql.append(" exists ( select age_group_code  from am_age_group  ");
			sql.append(" where age_group_code=a.age_group_code  ");

			if( !gender. equals("") )
			{
				sql.append(" and nvl( gender, '"+ gender +"' ) = '"+ gender +"' ");
			}

			if( !age_value. equals("") )
			{
				sql.append( " and decode('"+age+"' , 'Y', 365, 'M', 30, 1 ) * "+ age_value + "  ");
				sql.append( " between decode ( age_unit, 'Y', 365, 'M', 30, 1 ) * min_age and decode( age_unit, 'Y', 365, 'M', 30, 1 ) * max_age "); 
			}
			sql.append( " ))) ");
		}

		sql.append("  order by a.short_desc ");
	//	out.println("<script>alert(\""+sql+"\");</script>");
		stmt = con.createStatement();
		rs	= stmt.executeQuery(sql.toString());

	
            _bw.write(_wl_block7Bytes, _wl_block7);
	if(rs!=null)
		{
			int i=0;
			if(calledoption.equals("C"))
			i=1;
			i++;
			if( i>0 )
			{	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ipparam_bed_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(query_gender_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
			else
			{	
            _bw.write(_wl_block11Bytes, _wl_block11);
	}
		}

		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

	}catch(Exception e) 
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block12Bytes, _wl_block12);
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
