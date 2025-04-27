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
import java.util.*;
import com.ehis.util.*;

public final class __manageworkscheduleframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleFrameset.jsp", 1709613247107L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" -- ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../eRS/js/ManageWorkSchedule.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n</head>\n<iframe name=\"frameManageWorkScheduleBtn\" id=\"frameManageWorkScheduleBtn\" src=\'../../eRS/jsp/ManageWorkScheduleBtn.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=0 scrolling=\"no\" noresize style=\'height:4vh;width:100vw\'></iframe>\n<iframe name=\"frameManageWorkScheduleHdr\" id=\"frameManageWorkScheduleHdr\" src=\'../../eCommon/html/blank.html\' frameborder=0  noresize style=\'height:38vh;width:100vw\'></iframe> \n<iframe name=\"frameManageWorkScheduleResult\" id=\"frameManageWorkScheduleResult\" src=\'../../eCommon/html/blank.html\' frameborder=0 noresize  style=\'height:58vh;width:100vw\'></iframe>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
*   File Name		:	ManageWorkSheduleFrameset.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	17-12-2004
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

String p_mode = request.getParameter("p_mode")==null?"":request.getParameter("p_mode");
String mode	  = request.getParameter("mode")==null?"":request.getParameter("mode");
String function_id = request.getParameter( "function_id") ==null?"":request.getParameter("function_id");
String queryString = request.getQueryString();
String workplace_desc="";

if(p_mode.equals("CA"))
{
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	PreparedStatement pstmt_currdate 	= null;

	ResultSet resultSet 		= null;
	ResultSet rs_currdate 		= null;

	String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String user_id = (String)session.getValue("login_user")==null?"":(String)session.getAttribute("login_user");
	String p_locn_type = request.getParameter( "p_locn_type") ==null?"":request.getParameter("p_locn_type");
	String p_locn_code = request.getParameter( "p_locn_code") ==null?"":request.getParameter("p_locn_code");
	String from_date="", to_date="";
	String sql_wrkplace="";
	String workplace_code="";
	boolean flag=false;

	//to get the wrkplace code
	if(p_locn_type.equals("IP") || p_locn_type.equals("DC")){
		sql_wrkplace="select workplace_code from rs_locn_for_workplace where facility_id = ? and locn_code = (select nursing_unit_code  from ip_nursing_unit	  where facility_id = ? and nursing_unit_code = ?)";
		flag=true;
	}
	else 
		if(p_locn_type.equals("OP") || p_locn_type.equals("EM")){
			sql_wrkplace="select workplace_code  from rs_locn_for_workplace where facility_id = ? and locn_code = (select clinic_code from op_clinic where facility_id = ? and clinic_code = ?)";
			flag=true;
	}
	conn = ConnectionManager.getConnection(request);
	try {
		if(flag){
			pstmt = conn.prepareStatement( sql_wrkplace);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,p_locn_code);
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()) {
				workplace_code = resultSet.getString("workplace_code")==null?"":resultSet.getString("workplace_code");
			}
			if(pstmt!=null)
				pstmt.close();
			if(resultSet!=null)
				resultSet.close();
		}
		//to get the workplace description
		if(!workplace_code.equals("")){
			//String sql_workplace_desc="select workplace_desc  from rs_workplace where facility_id = ? and workplace_code = ?";
			String sql_workplace_desc="select workplace_desc from rs_workplace_lang_vw where facility_id = ? and workplace_code = ? and language_id = ?";
			pstmt = conn.prepareStatement( sql_workplace_desc);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,workplace_code);
			pstmt.setString(3,locale);
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()) {
				workplace_desc = resultSet.getString("workplace_desc")==null?"":resultSet.getString("workplace_desc");
			}
			if(pstmt!=null)
				pstmt.close();
			if(resultSet!=null)
				resultSet.close();
		}
		pstmt_currdate=conn.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') from_date, to_char(trunc(sysdate)+30,'dd/mm/yyyy') to_date from dual ");
		rs_currdate=pstmt_currdate.executeQuery();
		rs_currdate.next();
		from_date = rs_currdate.getString("from_Date");
		to_date = rs_currdate.getString("to_date");
		if(pstmt_currdate!=null)
			pstmt_currdate.close();
		if(rs_currdate!=null)
			rs_currdate.close();
	}catch(Exception e){
		e.printStackTrace() ;
	}
	finally{
		pstmt_currdate.close();
		pstmt.close() ;

		resultSet.close() ;
		rs_currdate.close();
		ConnectionManager.returnConnection(conn,request);
	}	queryString="user_id="+user_id+"&locn_type="+p_locn_type+"&workplace_code="+workplace_code+"&workplace_desc="+workplace_desc+"&from_date="+from_date+"&to_date="+to_date+"&new_to_date="+to_date+"&new_from_date="+from_date+"&facility_id="+facility_id+"&p_mode="+p_mode+"&mode="+mode+"&function_id"+function_id+"&onclick_of=S"+"&producive_flag=W"+"&DAYS=14";
}
else
workplace_desc=request.getParameter("workplace_desc")==null?"":request.getParameter("workplace_desc");

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(workplace_desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block9Bytes, _wl_block9);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.ManageWorkSchedule.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
