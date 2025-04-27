package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __aecancelvisit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AECancelVisit.jsp", 1726737563394L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \tFunction Name Cancel Visit \tCreated by M.Sathis Kumar on 28/02/2000 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n\t<head>\n    <meta http-equiv=\"Expires\" content=\"0\">  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n    <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n    <Script src=\"../../eOP/js/CancelVisit.js\" language=\"JavaScript\"></Script>\n    <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n    ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t <frameset rows=\'42,100,0,*,50\' id=frameSetId onKeyDown = \'lockKey()\' OnMouseDown=\"CodeArrest()\" >\n           <frame name=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" frameborder=0 scrolling=\'no\' noresize>\n           <frame name=\'searchCriteria\' frameborder=no scrolling=\'no\' src=\'../../eAE/jsp/AESearchVisitQueryCriteria.jsp?function_id=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&Patient_Id_Length=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&p_mode=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&params=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&function_name=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n           <frame name=\'PatientLine\'   src=\'../../eCommon/html/blank.html\'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'no\'>\n           <frame name=\'f_query_add_mod\'   src=\'../../eCommon/html/blank.html\'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=\'no\'>\n           <frame name=\'messageFrame\'\tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\'>\n     </frameset>\n\t\t\t\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String url						= "../../eCommon/jsp/commonToolbar.jsp?from_id=EM&" ;
		String params					= request.getQueryString() ;
		String source					= url + params ; 
		String fac_id    				= (String) session.getValue( "facility_id" ) ;
		String userid					= (String) session.getValue("login_user");
		String p_mode					=	"CANCELVISIT";
		String StartDate				=	"";
		String sys_date					=	"";
		String RevCanceldays			=	"";
		String max_days_allow_update	=	"";
		String OsVal					= "";
		String op_cnt					= "";
		String Patient_Id_Length					= "";
        String function_name=request.getParameter("function_name");
		String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
		
		PreparedStatement	pstmt		=	null;
		ResultSet			rset		=	null;
		Connection con=null;

        try
		{
 // Wednesday, May 12, 2010 venkat s PE_EXE 
				con=ConnectionManager.getConnection(request);
				StringBuffer sqlAEParam =	new  StringBuffer(); 
      			 sqlAEParam.append("select  to_char(sysdate - a.MAX_DAYS_ALLOW_UPDATE,");
				 sqlAEParam.append("'dd/mm/yyyy hh24:mi') startdate, ");
				 sqlAEParam.append(" to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date,");
				 sqlAEParam.append(" to_char(sysdate-a.MAX_DAYS_ALLOW_UPDATE,");
				 sqlAEParam.append(" 'dd/mm/yyyy hh24:mi')sys_1date,a.MAX_DAYS_ALLOW_UPDATE , (AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+userid+"','C','','CANCEL_VISIT_YN')) OsVal,(SELECT 1 FROM op_param WHERE operating_facility_id ='"+fac_id+"') op_cnt,(select patient_id_length from mp_param where module_id='MP') Patient_Id_Length from ");
				 sqlAEParam.append(" ae_param a where a.operating_facility_id= ? ");

				 pstmt = con.prepareStatement(sqlAEParam.toString());
				 pstmt.setString(1, fac_id);
				 rset = pstmt.executeQuery();
				 if (rset != null && rset.next())
				  {
				  					  
					  OsVal=rset.getString("OsVal");
					  StartDate=rset.getString("startdate");
					  params  = params+"&StartDate="+StartDate ;
					  sys_date = rset.getString("sys_date");
					  params  = params+"&sys_date="+sys_date ;
					  RevCanceldays=rset.getString("sys_1date");
					  params  = params+"&RevCanceldays="+RevCanceldays ;
					  max_days_allow_update =rset.getString("MAX_DAYS_ALLOW_UPDATE");
					  params  = params+"&max_days_allow_update="+max_days_allow_update ;
					  OsVal=rset.getString("OsVal");
					  op_cnt=rset.getString("op_cnt");
					  Patient_Id_Length=rset.getString("Patient_Id_Length");

					if(op_cnt.equals(""))
					  {
							out.println("<script>alert(getMessage('OP_PARAM_NOT_FOUND','OP'));window.location.href = '../../eCommon/jsp/dmenu.jsp' ;</script>");
					  }
					  else{
					if(OsVal.equals("1"))
					{
						out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else if(OsVal.equals("2"))
					{
						out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("3"))
					{
						out.print(" <script>alert(getMessage('CANCEL_VISIT_NOT_ALL_OPERSTN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("4"))
					{
						out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}else  if(OsVal.equals("5"))
					{
						out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					}
					else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
					{
					  params = params + "&oper_stn_id="+OsVal+"&" ;
					 
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Patient_Id_Length));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(params));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(java.net.URLEncoder.encode(function_name,"UTF-8")));
            _bw.write(_wl_block11Bytes, _wl_block11);

	 } 
	 } 
	 }
	 else
	{
		out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
	}
		 if(rset!=null)	rset.close();
		if(pstmt!=null)	pstmt.close();
		if((sqlAEParam!= null) && (sqlAEParam.length() > 0))
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

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
