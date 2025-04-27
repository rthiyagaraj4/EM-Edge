package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aetriageframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AETriageFrameset.jsp", 1724657968162L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n\n<html>\n<head> \n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eAE/js/AETriageDetails.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script> \n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<frameset rows=\'1%,*,6%\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n           <frameset rows=\'8%,*,1%\' >\t\n\t    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t   <frameset rows=\'0%,*,4%,5%\' >\n        ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n         <frameset rows=\'8%,*,6%\' >\t\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<frameset rows=\'8%,*,4%,5%\' >\t\n    ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<!--Modified by Ashwini on 04-Apr-2017 for GDOH-CFR-0004.3-->\n\t<frame name=\'mainFrame\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" src=\"../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&Facility_Id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" src=\"\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" frameborder=0 scrolling=\'no\' noresize>\n\t<frameset cols=\'19%,80%\' > \n\t   <frame name=\'view\' src=\"../../eAE/jsp/ViewSecondaryTriage.jsp?";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&functionid=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&page_name=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" frameborder=0  noresize>\n\t   <frame name=\'f_query_add_mod\' src=\'../../eAE/jsp/AESecondaryTriage.jsp?";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&call_function=TRIAGE\' frameborder=0 scrolling=\'auto\' noresize>\n\t</frameset>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<frame name=\'TriageButtonsFrame\' src=\'../../eAE/jsp/SecondaryTriageButtons.jsp?";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' frameborder=0 noresize scrolling=\'no\'>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<frame name=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\'><!--Modified scrolling to \'auto\' for ML-MMOH-CRF-0645 by Thamizh selvi-->\n</frameset> \n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n</html>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
 
        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    String locale			= (String)session.getAttribute("LOCALE");
 

		Connection con				=	null;
		PreparedStatement pstmt		=	null;
		ResultSet rs				=	null;
		String params		 = request.getQueryString() ;
		
		String strOpenToAllPract = "";
		String strOpenToallPractForClinic = "";
		String clinic_code = "";
		String clinic_type = ""; 
		String p_clinic_desc = "";
		String treatment_area_code = "";
		String orig_tmt_area_code = "";
		String practitioner_id = "";
		String speciality_code = "";
		String treatment_area_desc = "";
		String queue_status = "";		
        String modify_flag="N";
		String sys_date_time="";
		String sys_date_time1 ="";
		String facility_id	 =(String)session.getValue("facility_id");
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String called_from = checkForNull(request.getParameter("called_from"));
		String RepDb	   = checkForNull(request.getParameter("RepDb"));
		String clob_data   = checkForNull(request.getParameter("clob_data"));
		if(called_from.equals("CDR"))
			facility_id	= checkForNull(request.getParameter("facility_id"));
		params  = params+"&facility_id="+facility_id ;
		params  = params+"&called_from="+called_from ;
		params  = params+"&RepDb="+RepDb ;
		params  = params+"&clob_data="+clob_data ;
		/*End*/
		String encounter_id	 = checkForNull(request.getParameter("encounter_id"));
		String function_id	 = checkForNull(request.getParameter("function_id"));
		
		//11-11-2009 15198
		String functionid	 = checkForNull(request.getParameter("functionid"));	
		
		String page_name	 = checkForNull(request.getParameter("page_name"));//Added by santhosh for ML-MMOH-SCF-2384
		
		String referral_id="";
		if (function_id.equals("query"))
		{
		modify_flag="Y";
		params  = params+"&function_id="+function_id ;
		params  = params+"&modify_flag="+modify_flag ;
		}
		String priority_zone	 = checkForNull(request.getParameter("priority_zone"));
		String brought_dead	 = request.getParameter("brought_dead")==null?"N":request.getParameter("brought_dead");

		String strCA		 = request.getParameter("called_from_ca");
		if ((strCA==null) || strCA.equals("null"))
		 strCA = "";
		StringBuffer sqlTriage = new StringBuffer();
		sqlTriage.append("select a.locn_code, c.long_desc locn_desc, a.locn_type, a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, c.open_to_all_pract_yn,a.practitioner_id,TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi') sys_date_time1,a.queue_status,NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic ##REPDB## WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn ,REFERRAL_ID, a.speciality_code  from  ae_current_patient ##REPDB## a, op_clinic_lang_vw ##REPDB## c  where a.facility_id = ?  and a.encounter_id=?  and c.language_id = '"+locale+"'  and a.facility_id = c.facility_id and a.locn_code = c.clinic_code  ");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
		
		if(!strCA.equals("Y"))
		{
			if(encounter_id=="")
			{
				encounter_id = request.getParameter("episode_id");
				params  = params+"&encounter_id="+encounter_id ;
			}
			try{
	        con=ConnectionManager.getConnection(request);	
			/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
			String sqlFinal = sqlTriage.toString();
			sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
			/*End*/
		    pstmt		=	con.prepareStatement(sqlFinal);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	encounter_id		);
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				strOpenToAllPract = checkForNull(rs.getString("open_to_all_pract_yn"));;
				params  = params+"&open_to_all_pract_yn="+strOpenToAllPract ;

				strOpenToallPractForClinic  =checkForNull( rs.getString("open_to_all_prac_for_clinic_yn"));
				params  = params+"&open_to_all_prac_for_clinic_yn="+strOpenToallPractForClinic ;


				clinic_code	=	checkForNull(rs.getString("locn_code"));	
				params = params+"&clinic_code="+clinic_code ;
				
				clinic_type			=	checkForNull(rs.getString("locn_type"));	
				params = params+"&clinic_type="+clinic_type ;

				p_clinic_desc			=	checkForNull(rs.getString("locn_desc"));	
				params = params+"&clinic_desc="+URLEncoder.encode(p_clinic_desc );

				orig_tmt_area_code  = checkForNull(rs.getString("treatment_area_code"));	
				params = params+"&orig_tmt_area_code="+orig_tmt_area_code ;

				treatment_area_code		=	checkForNull(rs.getString("treatment_area_code"));	
				params = params+"&treatment_area_code="+treatment_area_code ;
				
				treatment_area_desc		=	checkForNull(rs.getString("treatment_area_desc"));	
				params = params+"&treatment_area_desc="+treatment_area_desc  ;

				practitioner_id			=	checkForNull(rs.getString("practitioner_id"));
				params = params+"&practitioner_id="+practitioner_id ;

				speciality_code			=	checkForNull(rs.getString("speciality_code"));
				params = params+"&speciality_code="+speciality_code ;

				
              
				queue_status			=	checkForNull(rs.getString("queue_status"));	
				sys_date_time           =	checkForNull(rs.getString("sys_date_time"));
				sys_date_time1          =	checkForNull(rs.getString("sys_date_time1"));
				referral_id             =	checkForNull(rs.getString("referral_id"));
	 
				params = params+"&queue_status="+queue_status ;
				params  = params+"&priority_zone="+priority_zone ;
				params  = params+"&brought_dead="+brought_dead ;
				params  = params+"&sys_date_time="+sys_date_time ;
				params  = params+"&sys_date_time1="+sys_date_time1 ;
				params  = params+"&referral_id="+referral_id ;
			}
			if(rs!=null) rs.close();
			if(pstmt!=null)	pstmt.close();
			if((sqlTriage != null) && (sqlTriage.length() > 0))
					 {
						sqlTriage.delete(0,sqlTriage.length());
					 }
			}catch(Exception e1)
			{
				e1.printStackTrace();
			} 
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}
		} 

  if(called_from.equals("CDR")){//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
	
            _bw.write(_wl_block9Bytes, _wl_block9);

  }else if(strCA .equals("Y")) 
	{
		if (function_id.equals("query"))
		{
		
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
        
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
	}
	else if (function_id.equals("query"))
	{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
}	else {
    
            _bw.write(_wl_block13Bytes, _wl_block13);

	}	

            _bw.write(_wl_block14Bytes, _wl_block14);
 if(!called_from.equals("CDR")){ 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
 }else{ 
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(params));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(functionid));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(page_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(params));
            _bw.write(_wl_block23Bytes, _wl_block23);

	if (!function_id.equals("query") )
	{
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(params));
            _bw.write(_wl_block25Bytes, _wl_block25);
 }
	
            _bw.write(_wl_block26Bytes, _wl_block26);
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.SecondaryTriage.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
