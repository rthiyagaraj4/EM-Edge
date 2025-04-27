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
import java.text.*;

public final class __nursingunitcomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/NursingUnitComponent.jsp", 1709117805322L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="<select name=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" id=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" width=\"15\" onChange=\'popDynamicValues(this)\'><option value=\'\' selected>--- ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ---";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t      \t\t\t\t\n\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<OPTION VALUE=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<!--OPTION VALUE=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="-->\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</select>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	 
	Connection con =null;
	Statement  stmt=null;
	PreparedStatement  pstmt=null;
	ResultSet  rs =null;
	String	   operstn = "";

	Statement stmt1=null;
	ResultSet rs1 =null;
	Statement stmt2=null;
	ResultSet rs2 =null;

	try
	{ 
		con = ConnectionManager.getConnection(request);
		String facilityID=(String)session.getValue("facility_id");
		String loginUser = (String)session.getValue("login_user");
		String wherecondn = request.getParameter("wherecondn");
		String patient_class = request.getParameter("patient_class");
		String specialitycode = request.getParameter("specialitycode");
		String med_service_grp = request.getParameter("med_service_grp");
		if(wherecondn == null) wherecondn ="";
		if(patient_class == null) patient_class ="";
		operstn = request.getParameter("oper_stn_id");
		if(operstn == null) operstn = "";
		if(operstn.equals(""))
		{
			String operSql = "select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b where a.facility_id='"+facilityID+"' and a.facility_id=b.facility_id	   and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"'   and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ";
			stmt1 = con.createStatement();
			rs1 = stmt1.executeQuery(operSql);

			if(rs1!=null)
			{
				while(rs1.next())
				{
					operstn	 = rs1.getString("oper_stn_id");
					if(operstn == null) operstn ="";
				}
			}

			if(rs1!=null)rs1.close();
			if(stmt1!=null)stmt1.close();
		}
		String name= request.getParameter("attribute");
		if(name==null)
		name = "nursing_unit";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(name));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(name));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
	
		stmt = con.createStatement();
		if(wherecondn.equals(""))
		{ 
			//String sql1=" Select short_desc, nursing_unit_code from IP_NURSING_UNIT_LANG_VW where language_id = '"+locale+"' and facility_id='"+facilityID+"' and locn_type = 'N' and eff_status='E' order by short_desc ";
			/*Wednesday, May 05, 2010 , modified for PE*/
			String sql1=" Select ip_get_desc.ip_nursing_unit(?,nursing_unit_code,?,2)short_desc, nursing_unit_code from IP_NURSING_UNIT where facility_id=? and locn_type = 'N' and eff_status='E' order by short_desc ";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,facilityID);
			pstmt.setString(2,locale);
			pstmt.setString(3,facilityID);
			rs = pstmt.executeQuery();

			if( rs != null )
			{
				while( rs.next() )
				{
					String classcode = rs.getString( "nursing_unit_code" ) ;
					if(classcode == null) classcode ="";
					String classname = rs.getString( "short_desc" ) ;
					if(classname == null) classname ="";
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( classcode ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( classname ));
            _bw.write(_wl_block12Bytes, _wl_block12);
	}
			}
			if(rs!=null) rs.close();	      	
			if(pstmt!=null) pstmt.close();	      	
			}
			else
			{
				/*Friday, May 07, 2010 , commnted for PE */
				/*
				String sql2 = "";
				if(wherecondn.equals("CREATE_BOOKING_YN"))
				{
					sql2=" Select 1 from IP_NURSING_UNIT a, AM_OS_USER_LOCN_ACCESS_VW b, IP_MED_SER_GRP_NURS_UT_TYPE c, IP_NURS_UNIT_FOR_SPECIALTY d  where a.facility_id='"+facilityID+"' and c.FACILITY_ID = A.FACILITY_ID AND c.MED_SER_GRP_CODE = '"+med_service_grp+"' AND c.NURSING_UNIT_TYPE_CODE = A.NURSING_UNIT_TYPE_CODE and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and a.appl_patient_class = 'IP' and b.locn_type =  'N' and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' and (b.CREATE_BOOKING_YN='Y' or b.CREATE_BOOKING_WITH_CONF_YN = 'Y' ) and a.eff_status='E' and d.FACILITY_ID = A.FACILITY_ID AND d.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND d.SPECIALTY_CODE = '"+specialitycode+"'   order by a.short_desc";

				}
				else if(wherecondn.equals("ASSIGN_BED_YN"))
				{
					sql2=" Select 1 from ip_nursing_unit a,      "+
					" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' and a.appl_patient_class= '"+patient_class+
					"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  "+
					" and a.locn_type=b.locn_type and b.locn_type =  'N' "+
					" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
					" and b."+wherecondn+"='Y' and a.eff_status='E' order by a.short_desc";

				}
				else if(wherecondn.equals("CHG_NURS_UNIT_IN_ASSIGN_BED_YN"))
				{
					sql2=" Select 1 from ip_nursing_unit a,      "+
					" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' and a.appl_patient_class= '"+patient_class+
					"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  "+
					" and a.locn_type=b.locn_type and b.locn_type =  'N' "+
					" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
					" and b.assign_bed_yn = 'Y' AND b."+wherecondn+" = 'Y' and a.eff_status='E' order by a.short_desc";

				}
				else if(wherecondn.equals("ADMIT_PAT_YN")&& !patient_class.equals(""))
				{
					sql2=" Select 1 from ip_nursing_unit a,      "+
					" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' and a.appl_patient_class= '"+patient_class+
					"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  "+
					" and a.locn_type=b.locn_type and b.locn_type =  'N' "+
					" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
					" and b."+wherecondn+"='Y' and a.eff_status='E' order by a.short_desc";
				}
				else
				{
					sql2=" Select 1 from ip_nursing_unit a,      "+
					" am_os_user_locn_access_vw b where a.facility_id='"+facilityID+"' 	   "+
					" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  "+
					" and a.locn_type=b.locn_type and b.locn_type =  'N' "+
					" and b.oper_stn_id='"+operstn+"' and b.appl_user_id='"+loginUser+"' "+ 
					" and b."+wherecondn+"='Y' and a.eff_status='E' order by a.short_desc";
				}
				rs = stmt.executeQuery(sql2);			

				if( rs != null )
				{
					if( rs.next() )
					{  */    	
						StringBuffer sql1 = new StringBuffer();
						if(wherecondn.equals("CREATE_BOOKING_YN"))
						{
							sql1.append(" Select IP_GET_DESC.IP_NURSING_UNIT(?, a.NURSING_UNIT_CODE, ?, 2)short_desc, a.nursing_unit_code nursing_unit_code from IP_NURSING_UNIT a,   ");
							sql1.append(" AM_OS_USER_LOCN_ACCESS_VW b, IP_MED_SER_GRP_NURS_UT_TYPE c, IP_NURS_UNIT_FOR_SPECIALTY d where a.facility_id=?   ");
							sql1.append(" and c.FACILITY_ID = A.FACILITY_ID AND c.MED_SER_GRP_CODE = ? AND c.NURSING_UNIT_TYPE_CODE = A.NURSING_UNIT_TYPE_CODE  "); 
							sql1.append(" and a.facility_id=b.facility_id and a.nursing_unit_code = b.locn_code "); 
							sql1.append(" and a.locn_type=b.locn_type and b.locn_type =  'N' ");
							sql1.append(" and d.FACILITY_ID = A.FACILITY_ID AND d.NURSING_UNIT_CODE = A.NURSING_UNIT_CODE AND d.SPECIALTY_CODE = ? and a.APPL_PATIENT_CLASS = 'IP' ");
							sql1.append(" and b.oper_stn_id=? and b.appl_user_id=? ");
							sql1.append(" and (b.CREATE_BOOKING_YN='Y' or b.CREATE_BOOKING_WITH_CONF_YN = 'Y') and a.eff_status='E' order by a.short_desc");	
						}
						else if(wherecondn.equals("ASSIGN_BED_YN") )
						{
							sql1.append(" Select IP_GET_DESC.IP_NURSING_UNIT(?, a.NURSING_UNIT_CODE, ?, 2) short_desc,a.nursing_unit_code nursing_unit_code from IP_NURSING_UNIT a,      ");
							sql1.append(" AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id=? and a.appl_patient_class= ? and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code ");
							sql1.append(" and a.locn_type=b.locn_type and b.locn_type =  'N' ");
							sql1.append(" and b.oper_stn_id=? and b.appl_user_id=? ");
							sql1.append(" and b."+wherecondn+"='Y' ");
							sql1.append(" and a.eff_status='E' order by a.short_desc");
						}
						/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if change nursing unit in assign bed is unchecked in AM->operator station restriction function*/
						else if(wherecondn.equals("CHG_NURS_UNIT_IN_ASSIGN_BED_YN") )
						{
							sql1.append(" Select IP_GET_DESC.IP_NURSING_UNIT(?, a.NURSING_UNIT_CODE, ?, 2) short_desc,a.nursing_unit_code nursing_unit_code from IP_NURSING_UNIT a,      ");
							sql1.append(" AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id=? and a.appl_patient_class= ? and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code ");
							sql1.append(" and a.locn_type=b.locn_type and b.locn_type =  'N' ");
							sql1.append(" and b.oper_stn_id=? and b.appl_user_id=? ");
							sql1.append(" and b.assign_bed_yn='Y' ");
							sql1.append(" AND b."+wherecondn+" = 'Y' ");
							sql1.append(" and a.eff_status='E' order by a.short_desc");
						}
						else if(wherecondn.equals("ADMIT_PAT_YN")&& !patient_class.equals(""))
						{
							sql1.append(" Select IP_GET_DESC.IP_NURSING_UNIT(?, a.NURSING_UNIT_CODE, ?, 2) short_desc,a.nursing_unit_code nursing_unit_code from IP_NURSING_UNIT a,      ");
							sql1.append(" AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id=? and a.appl_patient_class= ? and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code ");
							sql1.append(" and a.locn_type=b.locn_type and b.locn_type =  'N' ");
							sql1.append(" and b.oper_stn_id=? and b.appl_user_id=? "); 
							sql1.append(" and b."+wherecondn+"='Y' ");
							/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if admit patient with bed is unchecked in AM->operator station restriction function*/
							sql1.append(" AND b.admit_patient_with_bed_yn = 'Y' ");
							sql1.append(" and a.eff_status='E' order by a.short_desc");
						}
						else
						{
							

							sql1.append(" Select IP_GET_DESC.IP_NURSING_UNIT(?, a.NURSING_UNIT_CODE, ?, 2)short_desc, a.nursing_unit_code nursing_unit_code from IP_NURSING_UNIT a,      ");
							sql1.append(" am_os_user_locn_access_vw b where a.facility_id=? 	   ");
							sql1.append(" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code ");
							sql1.append(" and a.locn_type=b.locn_type and b.locn_type =  'N' ");
							sql1.append(" and b.oper_stn_id=? and b.appl_user_id=? ");
							sql1.append(" and b."+wherecondn+"='Y' and a.eff_status='E' order by a.short_desc");
						}



						pstmt = con.prepareStatement(sql1.toString());
							pstmt.setString(1,facilityID);
							pstmt.setString(2,locale);
							pstmt.setString(3,facilityID);
						if(wherecondn.equals("CREATE_BOOKING_YN"))
						{
							pstmt.setString(4,med_service_grp);
							pstmt.setString(5,specialitycode);
							pstmt.setString(6,operstn);
							pstmt.setString(7,loginUser);
						}else if(wherecondn.equals("ASSIGN_BED_YN") || wherecondn.equals("CHG_NURS_UNIT_IN_ASSIGN_BED_YN") || (wherecondn.equals("ADMIT_PAT_YN")&& !patient_class.equals(""))){
							pstmt.setString(4,patient_class);
							pstmt.setString(5,operstn);
							pstmt.setString(6,loginUser);
						}else{
							pstmt.setString(4,operstn);
							pstmt.setString(5,loginUser);
						}
						rs2 = pstmt.executeQuery();			
						if( rs2 != null )
						{
							while( rs2.next() )
							{
								String classcode = rs2.getString( "nursing_unit_code" ) ;
								String classname = rs2.getString( "short_desc" ) ;
							
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( classcode ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( classname ));
            _bw.write(_wl_block14Bytes, _wl_block14);
	}
						}else{
							String classcode = "";
							String classname = "";
							out.print("<option value=\""+classcode+"\">"+classname+"");
						}
					/*}
					else
					{
						String classcode = "";
						String classname = "";
						
            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block16Bytes, _wl_block16);
	/*}
				}*/
				if(rs!=null) rs.close();
			}//e.o.Else

	}catch(Exception e)	
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();
		if(rs1!=null) rs1.close();
		if(stmt1!=null) stmt1.close();
		if(stmt2!=null) stmt2.close();
		if(rs2!=null) rs2.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}	
            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
