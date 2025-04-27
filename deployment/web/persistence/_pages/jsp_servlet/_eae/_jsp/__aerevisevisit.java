package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aerevisevisit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEReviseVisit.jsp", 1725961468518L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eAE/js/AEReviseVisit.js\'></script>\n    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:7vh;width:100vw\' ></iframe>\n\t\t\t\t\t\t\t\t<iframe name=\'searchCriteria\' id=\'searchCriteria\' frameborder=no scrolling=\'no\' src=\'../../eAE/jsp/AESearchVisitQueryCriteria.jsp?p_mode=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Patient_Id_Length=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&params=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&functionname=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' style=\'height:18vh;width:100vw\'></iframe><iframe name=\'PatientLine\' id=\'PatientLine\'   src=\'../../eCommon/html/blank.html\'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'no\' style=\'height:6vh;width:100vw\'></iframe> <iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\'   src=\'../../eCommon/html/blank.html\'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'yes\' style=\'height:60vh;width:100vw\'></iframe><iframe name=\'messageFrame\' id=\'messageFrame\'\t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t         ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\t\t\talert(getMessage(\'AE_REVISIT_NOT_ALL_OPERSTN\',\'AE\'));\n\t\t\t\t\t\t\tparent.content.location.href = \'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection			con			=	null;
  try{
	    request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    con=ConnectionManager.getConnection(request);
        PreparedStatement	pstmt		=	null;
		ResultSet			rset		=	null;

		String url						=	"../../eCommon/jsp/commonToolbar.jsp?" ;
		String params					=	request.getQueryString() ;
		String source					=	url + params ;
		String facilityId    			=	(String) session.getValue("facility_id" ) ;
		String userId					=	(String) session.getValue("login_user");
		String StartDate				=	"";
		String sys_date					=	"";
		String RevCanceldays			=	"";
		String max_days_allow_update	=	"";
		String start_date               =	"";
		String OsVal					=	"";
		String Patient_Id_Length	  	=	"";
		String p_mode					=	"REVISEVISIT";
		StringBuffer sqlAEParam			=	new  StringBuffer(); 
		String  function_name=request.getParameter("function_name");
		String five_level_triage_appl_yn	= "N";//Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
// Tuesday, May 18, 2010 venkat s PE_EXE
		// sqlAEParam.append("select to_char(sysdate - a.MAX_DAYS_ALLOW_UPDATE,'dd/mm/yyyy hh24:mi') startdate,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date,to_char(sysdate-a.MAX_DAYS_ALLOW_UPDATE,'dd/mm/yyyy hh24:mi')sys_1date,a.MAX_DAYS_ALLOW_UPDATE,TO_CHAR(SYSDATE-(DECODE(a.VISIT_BACKDATING_ALLOWED_YN,		  'Y',a.MAX_HOURS_ALLOW_INSERT,0)*60)/1440,'dd/mm/yyyy hh24:mi')  start_date,(AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+userId+"','C','','REVISE_VISIT_YN')) osval,(select patient_id_length from mp_param where module_id='MP') Patient_Id_Length  from dual,ae_param a where a.operating_facility_id= ?");
 		// five_level_triage_appl_yn Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
		sqlAEParam.append("select to_char(sysdate - a.MAX_DAYS_ALLOW_UPDATE,'dd/mm/yyyy hh24:mi') startdate,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date,to_char(sysdate-a.MAX_DAYS_ALLOW_UPDATE,'dd/mm/yyyy hh24:mi')sys_1date,a.MAX_DAYS_ALLOW_UPDATE,TO_CHAR(SYSDATE-(DECODE(a.VISIT_BACKDATING_ALLOWED_YN,		  'Y',a.MAX_HOURS_ALLOW_INSERT,0)*60)/1440,'dd/mm/yyyy hh24:mi')  start_date,(AM_OPER_STN_ACCESS_CHECK('"+facilityId+"','"+userId+"','C','','REVISE_VISIT_YN')) osval,(select patient_id_length from mp_param where module_id='MP') Patient_Id_Length,five_level_triage_appl_yn  from dual,ae_param a where a.operating_facility_id= ?");
		 pstmt = con.prepareStatement(sqlAEParam.toString());
		 pstmt.setString(1, facilityId);
		 rset = pstmt.executeQuery();
				 if (rset != null && rset.next())
				  {
								  
					  StartDate=rset.getString("startdate");
					  params  = params+"&StartDate="+StartDate ;
					  sys_date = rset.getString("sys_date");
					  params  = params+"&sys_date="+sys_date ;
					  RevCanceldays=rset.getString("sys_1date");
					  params  = params+"&RevCanceldays="+RevCanceldays ;
					  max_days_allow_update =rset.getString("MAX_DAYS_ALLOW_UPDATE");
					  params  = params+"&max_days_allow_update="+max_days_allow_update ;
					  start_date = rset.getString("start_date");
					  params  = params+"&start_date="+start_date ;
					  OsVal = rset.getString("osval");
					  Patient_Id_Length = rset.getString("Patient_Id_Length");
					 /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014 Start*/
					  five_level_triage_appl_yn			=	(rset.getString("five_level_triage_appl_yn")==null || rset.getString("five_level_triage_appl_yn")=="")?"N":rset.getString("five_level_triage_appl_yn");
					  params  = params+"&five_level_triage_appl_yn="+five_level_triage_appl_yn ;
					  /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014 End*/
					 /**********   Added new for Oper Stn Check    ***********/
					

			  		if(OsVal.equals("1"))
					{
						out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else if(OsVal.equals("2"))
					{
						out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("3"))
					{
						out.print(" <script>alert(getMessage('AE_REVISIT_NOT_ALL_OPERSTN','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("4"))
					{
						out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("5"))
					{
						out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
					else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4"))  && (!OsVal.equals("5")))
					{
							params = params+"&oper_stn_id="+OsVal;

					
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_mode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(function_name,"UTF-8")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);

				  }
			      else
			      {
					
            _bw.write(_wl_block15Bytes, _wl_block15);

					} 	
					}else{
							out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
					}
								
				 if(rset!=null)	rset.close();
				 if(pstmt!=null)	pstmt.close();
				// end of else
				 if((sqlAEParam != null) && (sqlAEParam.length() > 0))
					{
						sqlAEParam.delete(0,sqlAEParam.length());
					} 
}
catch(Exception e)
{
	e.printStackTrace();
}
finally{
		ConnectionManager.returnConnection(con,request);
       }

            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
