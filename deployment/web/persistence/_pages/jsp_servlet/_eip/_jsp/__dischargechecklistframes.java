package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

public final class __dischargechecklistframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeCheckListFrames.jsp", 1729588291144L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<!DOCTYPE html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title>&nbsp;";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&nbsp;</title>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eIP/js/DischargeCheckList.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\t\n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<iframe name=\'pline\' id=\'pline\' src=\"../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&Facility_Id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" frameborder=0 scrolling=no style=\'height:8vh; width:97vw\'></iframe>\n\t\t\t\t\n\t\t\t\t<iframe name=\'DischargeCheckList_frame1\' id=\'DischargeCheckList_frame1\' src=\'../../eIP/jsp/DischargeCheckListMain.jsp?encounter_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&patient_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&call_function=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:4vh;width:97vw\'></iframe>\n\t\t\t\t\t\n\t\t\t\t<iframe name=\'DischargeCheckList_frame2\' id=\'DischargeCheckList_frame2\' src=\'../../eIP/jsp/DischargeCheckListTab1Frames.jsp?encounter_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=0 noresize style=\'height:70vh;width:97vw\' scrolling=\'auto\'></iframe>\n\t\t\t\t\n\t\t\t\t<iframe name=\'DischargeCheckList_frame3\' id=\'DischargeCheckList_frame3\' src=\'../../eIP/jsp/DischargeCheckListButton.jsp?call_function=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&disable_print=Disabled\' frameborder=0 scrolling=\'no\' noresize style=\'height:9vh;width:97vw\'></iframe>\n\t\t\t\t\n\t\t\t\t<iframe name=\'submitFrame\' id=\'submitFrame\' src=\'../../eCommon/jsp/MstCodeError.jsp\' frameborder=0 scrolling=no noresize style=\'height:8vh;width:98vw\'></iframe>\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<iframe name=\'pline\' id=\'pline\' \t\t\tsrc=\"../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" frameborder=\'0\' scrolling=\'no\' style=\'height:8vh;width:97vw\'></iframe>\n\t\t\n\t\t<iframe name=\'DischargeCheckList_frame1\' id=\'DischargeCheckList_frame1\' src=\'../../eIP/jsp/DischargeCheckListMain.jsp?encounter_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:4vh;width:97vw\'></iframe>\n\t\t\n\t\t<iframe name=\'DischargeCheckList_frame2\' id=\'DischargeCheckList_frame2\' src=\'../../eIP/jsp/DischargeCheckListTab1Frames.jsp?encounter_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' frameborder=0 noresize style=\'height:70vh;width:97vw\' scrolling=\'auto\'></iframe>\n\t\t\n\t\t<iframe name=\'DischargeCheckList_frame3\' id=\'DischargeCheckList_frame3\' src=\'../../eIP/jsp/DischargeCheckListButton.jsp?call_function=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:9vh;width:97vw\'></iframe>\n\t\n\t\t<iframe name=\'submitFrame\' id=\'submitFrame\' src=\'../../eCommon/jsp/MstCodeError.jsp\' frameborder=0 scrolling=no noresize style=\'height:8vh;width:98vw\'></iframe>\n\t\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	Connection con		= null;
	ResultSet rs 		= null;
	Statement stmt 		= null;

	try
	{
		con = ConnectionManager.getConnection(request);
		String facilityId		= (String)session.getValue("facility_id");
		String patient_id		= checkForNull(request.getParameter("patientId"));
		String encounter_id		= checkForNull(request.getParameter("encounterId"));
		String call_function	= checkForNull(request.getParameter("menu_id"));
		String disc_from_date	= checkForNull(request.getParameter("disc_from_date"));
		String disc_to_date		= checkForNull(request.getParameter("disc_to_date"));

		if((!disc_from_date.equals(""))&&(disc_from_date!=null))
			disc_from_date = disc_from_date;

		if((!disc_to_date.equals(""))&&(disc_to_date!=null))
			disc_to_date = disc_to_date;


		if(disc_from_date!=null && !disc_from_date.equals("") && disc_to_date!=null && !disc_to_date.equals("") && !call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
		{
				stmt = con.createStatement();
				rs = stmt.executeQuery(" SELECT 1 FROM IP_PATIENT_LAST_ENCOUNTER a, IP_PARAM b WHERE SYSDATE BETWEEN a.DISCHARGE_DATE_TIME AND DECODE(b.DISC_CHKLST_EXP_PER_UNIT,'D', a.DISCHARGE_DATE_TIME + b.DISC_CHKLST_EXP_PERIOD, 'H', a.DISCHARGE_DATE_TIME + b.DISC_CHKLST_EXP_PERIOD/24) AND a.facility_id = '"+facilityId+"' and a.ENCOUNTER_ID = '"+encounter_id+"' and a.facility_id = b.facility_id");
				if(!rs.next())
				{
				 out.println("<script>alert(getMessage('CHECKLIST_PARAM_EXCEEDED','IP'));window.close();</script>");
				}	
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		else
		{	
			if(call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
			{
			  stmt  = con.createStatement();
			  rs = stmt.executeQuery("select 1 from IP_DISCHARGE_CHECKLIST where facility_id='"+facilityId+"' and encounter_id = '"+encounter_id+"' ");

				if(rs.next())
				{
				}
				else
				{
			       out.println("<script>alert(getMessage('CHECKLIST_NOT_PREPARED','IP'));window.close();</script>");
				}
			}

			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

			
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block20Bytes, _wl_block20);
	}

		if(rs	!= null)    rs.close();
		if(stmt  != null)   stmt.close();	

	}catch(Exception e)
	{
		out.println("Exception in tryCatch : "+ e.toString());
	}	
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeCheckList.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
