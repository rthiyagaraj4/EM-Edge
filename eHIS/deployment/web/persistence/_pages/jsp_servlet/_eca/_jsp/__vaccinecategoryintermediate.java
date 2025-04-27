package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __vaccinecategoryintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/VaccineCategoryIntermediate.jsp", 1718796263922L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");				
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String description = "";
	String sql = "";
//	int count =0;
	int min_age = 0;
	int max_age = 0;
	String age_unit = "";
	String age_unit_max = "";
	int appl_age_years = 0;
	int appl_age_months = 0;
	int appl_age_days = 0;
	int sch_freq_days = 0;
	int min_appl_age = 0;
	int max_appl_age = 0;
	String message = "";
	String age_group_code = "";
	String vacc_categ_id = "";
	String age_group_old = "";
	try
	{
			Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
			hash = (Hashtable)hash.get( "SEARCH" ) ;	
			String callFrom =(String) hash.get("CALLFROM");					
		if(callFrom.equals("AGE_GRP_APPL"))
		{	
			vacc_categ_id =(String) hash.get("VACC_CATEG_ID");
			age_group_code =(String) hash.get("AGE_GROUP_NEW");
			age_group_old =(String) hash.get("AGE_GROUP_OLD");
			
			con = ConnectionManager.getConnection(request);
			description = request.getParameter("categoryCode") == null ? "" : request.getParameter("categoryCode");
		
			sql = "Select AGE_GROUP_CODE,MIN_AGE, MAX_AGE, AGE_UNIT, AGE_UNIT_MAX from AM_AGE_GROUP where AGE_GROUP_CODE=? AND eff_status='E' ";
	
			ps = con.prepareStatement(sql);
			ps.setString(1,age_group_code);
			rs = ps.executeQuery();
			if(rs.next())
			{
				min_age  = rs.getString("MIN_AGE")==null?0:rs.getInt("MIN_AGE");
				max_age  = rs.getString("MAX_AGE")==null?0:rs.getInt("MAX_AGE");
				age_unit  = rs.getString("AGE_UNIT")==null?"":rs.getString("AGE_UNIT");
				age_unit_max  = rs.getString("AGE_UNIT_MAX")==null?"":rs.getString("AGE_UNIT_MAX");
				if(age_unit.equals("Y"))
				{
					min_appl_age = min_age*365;
				}else if(age_unit.equals("M"))
				{
					min_appl_age = min_age*30;
				}else if(age_unit.equals("D"))
				{
					min_appl_age = min_age*1;
				}else if(age_unit.equals("H"))
				{
					min_appl_age = min_age*1/24;
				}else if(age_unit.equals("N"))
				{
					min_appl_age = min_age*1/24*60;
				}

				if(age_unit_max.equals("Y"))
				{
					max_appl_age = max_age*365;
				}else if(age_unit_max.equals("M"))
				{
					max_appl_age = max_age*30;
				}else if(age_unit_max.equals("D"))
				{
					max_appl_age = max_age*1;
				}else if(age_unit_max.equals("H"))
				{
					max_appl_age = max_age*1/24;
				}else if(age_unit_max.equals("N"))
				{
					max_appl_age = max_age*1/24*60;
				}
			}			
			if(rs != null) rs.close();									
			if(ps != null) ps.close();

			sql = "SELECT VACCINE_ID,DOSE_NO, APPL_AGE_YEARS, APPL_AGE_MONTHS, APPL_AGE_DAYS,DUE_BEFORE, DUE_BEFORE_TYPE, ELAPSED_AFTER, ELAPSED_AFTER_TYPE FROM CA_IM_VAC_SCH_FOR_CATEG WHERE VACC_CATEG_ID=? ORDER BY VACCINE_ID,DOSE_NO";
	
			ps = con.prepareStatement(sql);
			ps.setString(1,vacc_categ_id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				appl_age_years  = rs.getString("APPL_AGE_YEARS")==null?0:rs.getInt("APPL_AGE_YEARS");
				appl_age_months  = rs.getString("APPL_AGE_MONTHS")==null?0:rs.getInt("APPL_AGE_MONTHS");
				appl_age_days  = rs.getString("APPL_AGE_DAYS")==null?0:rs.getInt("APPL_AGE_DAYS");
				
				sch_freq_days = appl_age_years*365+appl_age_months*30+appl_age_days;
				
				if (min_appl_age > sch_freq_days || max_appl_age < sch_freq_days )
				{
					message= "AGE_GRP_LINK";
					break;
				}			
			}			
			if(rs != null) rs.close();									
			if(ps != null) ps.close();
			
			if(message.equals("AGE_GRP_LINK")){
				out.println("alert(getMessage('"+message+"','CA'))");			
				out.println("document.getElementById('age_group').value='"+age_group_old+"'");			
			}
		}
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
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
}
