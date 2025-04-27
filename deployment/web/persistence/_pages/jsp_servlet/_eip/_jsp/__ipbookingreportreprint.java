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
import java.util.*;
import java.sql.*;
import java.text.*;

public final class __ipbookingreportreprint extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPBookingReportReprint.jsp", 1710353972263L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language=\'javascript\' src=\'../js/AmendBooking.js\'></script>\n\t<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t <script>\n\t\t\t\t\talert(getMessage(\'IP_NO_OPER_STN_FOR_USER\',\'IP\'));\n\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t  <script>\n\t\t\t\t  alert(getMessage(\'NURS_UNIT_NOT_DEFINED\',\'IP\'));\n\t\t\t\t  document.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t  </script>\n\t\t\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<iframe name = \'commontoolbarFrame\'\tsrc = ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" frameborder=0 scrolling = \'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\"../jsp/BookingReferenceLookup.jsp?oper_stn_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&revise_booking_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&cancel_booking_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&confirm_booking_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&create_booking_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&create_booking_with_conf_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&call_function=BookingReport&bkg_grace_period=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  frameborder=0 scrolling=\'auto\' style=\'height:80vh;width:100vw\'></iframe><iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:12vh;width:100vw\'></iframe>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<script>\n\talert(getMessage(\'OPER_STN_FUNC_RESTRN\',\'IP\'))\n\tdocument.location.href =\'../../eCommon/jsp/dmenu.jsp\'\n\t</script>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n            <script>alert(getMessage(\'IP_PARAM_NOT_FOUND\',\'IP\'));\n\t\t\tdocument.location.href= \'../../eCommon/jsp/dmenu.jsp\'\n\t\t\t</script>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\n</html>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	String url			= "../../eCommon/jsp/commonToolbar.jsp?";
	String params		= request.getQueryString();
	String source		= url + params;
	String facilityId	= (String)session.getValue("facility_id");
	String loginUser	= (String)session.getValue("login_user");

	Connection con		= null;
	Statement stmt		= null;
	Statement stmt1		= null;
	ResultSet rs 		= null; 
	ResultSet rs1 		= null; 
	ResultSet rset 		= null;
	String oper_stn_id  = "";  
	boolean result 		= true;

	String revise_booking_yn	= "";
	String cancel_booking_yn	= "";
	String reject_admission_yn	= "";
	String confirm_booking_yn  = "";
	String create_booking_yn	= "";
	String create_booking_with_conf_yn = "";
	String bkg_grace_period = "";
	StringBuffer sbSql	= new StringBuffer();

	try{
		con = ConnectionManager.getConnection(request);		
		stmt = con.createStatement();		

		rs = stmt.executeQuery("select 1,bkg_grace_period from ip_param where facility_id='"+facilityId+"' ") ;
	   if(rs.next())
		{
			bkg_grace_period = rs.getString("bkg_grace_period");
		//Added By Devang for Operation & clinic Check
		sbSql.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b  ");
		sbSql.append(" WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id ");
		sbSql.append(" AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  ");
		sbSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");
				
		stmt1 = con.createStatement();
		rs1  = stmt1.executeQuery(sbSql.toString());
		if(rs1!=null)
		{
			if(rs1.next())
			{
			   	oper_stn_id = checkForNull(rs1.getString("OPER_STN_ID"));
			}	
			else
			{
            _bw.write(_wl_block9Bytes, _wl_block9);
	 result = false;
			}
		}
		if (sbSql.length() > 0)
		sbSql.delete(0, sbSql.length());	

		if (!oper_stn_id.equals("") && result)
	   {
	     try
		 {

			// This query is used for finding whether the nursing units are defined to operator station or not
			/*sbSql.append( "select a.nursing_unit_code from ip_nursing_unit a, am_locn_for_oper_stn b where a.facility_id = '"+facilityId+"' and ");
			sbSql.append( " a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E'");*/

			sbSql.append("SELECT distinct(locn_code) FROM am_locn_for_oper_stn WHERE facility_id = '"+facilityId+"' ");
			sbSql.append(" AND locn_type = 'N' AND eff_status = 'E' AND oper_stn_id = '"+oper_stn_id+"' ");

			  rset = stmt.executeQuery(sbSql.toString());
			  if (!rset.next())
			  { 
            _bw.write(_wl_block10Bytes, _wl_block10);
    result = false;
			   }
			}
	       catch(Exception e) { result = false; out.println(e.toString());}
	       finally 
			 {
				if (rset != null)   rset.close();
			 }
      } 

		if (sbSql.length() > 0)
		sbSql.delete(0, sbSql.length());	

		// This query is used for finding the access rights for user
		sbSql.append( "select revise_booking_yn ,canc_booking_yn ,reject_admission_yn,CONFIRM_BOOKING_YN,create_booking_yn,CREATE_BOOKING_WITH_CONF_YN from am_oper_stn ");
		sbSql.append(" where facility_id = '"+facilityId+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn  ");
		sbSql.append(" where facility_id='"+facilityId+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and  nvl(eff_date_to,trunc(sysdate))) ");
		
		rs = stmt.executeQuery(sbSql.toString());		
		if(rs!= null)
		{
			if(rs.next())			
			{
				revise_booking_yn   = checkForNull(rs.getString(1));
				cancel_booking_yn   = checkForNull(rs.getString(2));
				reject_admission_yn = checkForNull(rs.getString(3));
				confirm_booking_yn  = checkForNull(rs.getString(4));
				create_booking_yn	= checkForNull(rs.getString(5));
				create_booking_with_conf_yn = checkForNull(rs.getString(6));
			}
		}
		
if((revise_booking_yn.equals("Y")) || (cancel_booking_yn.equals("Y")) ||(reject_admission_yn.equals("Y")))
{	

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(source));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(revise_booking_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cancel_booking_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(confirm_booking_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(create_booking_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(create_booking_with_conf_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
else
{
            _bw.write(_wl_block20Bytes, _wl_block20);
}

}else 
            _bw.write(_wl_block21Bytes, _wl_block21);

	if(rset != null)	rset.close();
	if(rs != null)		rs.close();
	if(rs1 != null)		rs1.close();
	if(stmt != null)	stmt.close();
	if(stmt1 != null)	stmt1.close();

}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block22Bytes, _wl_block22);
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
