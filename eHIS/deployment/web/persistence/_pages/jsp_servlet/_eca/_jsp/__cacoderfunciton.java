package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __cacoderfunciton extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CACoderFunciton.jsp", 1709115490716L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title>\nCoder Function\n</title>\n<script language=\'javascript\' src=\'../js/CoderFunciton.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script> \n<script src=\"../../eMR/js/MRCoderDiagDtls.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!--frame size changed for AAKH-CRF-0153-->\n<!--<frameset rows=\"78*,130*,127*,77*,0,0\" cols=\"*\" >-->\n<frameset rows=\"70*,138*,127*,77*,0,0\" cols=\"*\" >\n\t<frame src=\"../../eMR/jsp/MRCoderPatDemographicDtls.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&session_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" frameborder=\"0\">\n\t<frame src=\"../../eMR/jsp/MRCoderDiagDtls.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" frameborder=\"0\">\n\t<frame src=\"../../eBL/jsp/BLCoderFunction.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"  frameborder=\"0\">\n\t<frame src=\"../../eCA/jsp/CACoderFunctionButtons.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" frameborder=\"0\">\n\t<frame src=\"../../eCommon/html/blank.html\" frameborder=\"0\">\n\t<frame name=\"dummyFrame\" id=\"dummyFrame\"  src=\"../../eCommon/html/blank.html\" frameborder=\"0\">\n</frameset><noframes></noframes>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
03/06/2020 	  		Ramesh Goli											AAKH-CRF-0122.2
01/07/2020 	  		Chandrashekar											AAKH-CRF-0122.2
31/10/2022          Kamatchi S                                              TH-KW-CRF-0143
-------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String params = request.getQueryString() ;
	String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	String p_error_text         = "";
	String proceed_yn           = "";
	String transction_status    = "";
	String dischared_date       = "";
	String facility_id          = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String encounter_id         = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	HashMap blling_params       = new HashMap();
	String locale				= (String)session.getAttribute("LOCALE");
	String session_id           = "";
	//Added by Kamatchi S for TH-KW-CRF-0143
	Connection con	= null;
	con = ConnectionManager.getConnection(request);
	Boolean siteSpecServiceCode = false;
	siteSpecServiceCode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_SERVICE_CODE_REQD");
//V230330
	Boolean siteSpecPatPayable = false;
	siteSpecPatPayable =  eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ALLOW_CASH_PAT_IN_CODER_FN");//V230222
	
     CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ; 
	 dischared_date = bean.getPatientDischargedDate(encounter_id);
	 //Added by Kamatchi S for TH-KW-CRF-0143
	 System.err.println("siteSpecPatPayable From CA  "+siteSpecPatPayable);
	if(siteSpecServiceCode ){//V230405
		blling_params =bean.getBillingValidation(encounter_id,locale);
         if(blling_params !=null){
			 p_error_text       =   (String)blling_params.get("p_error_text")==null?"":(String)blling_params.get("p_error_text");
			 transction_status  =   (String)blling_params.get("transction_status");
			 session_id         =   (String)blling_params.get("session_id")==null?"":(String)blling_params.get("session_id");
			 System.err.println("blling_params p_error_text From CA  "+p_error_text);
			 System.err.println("blling_params transction_status From CA  "+transction_status);
			 System.err.println("blling_params session_id From CA  "+session_id);
			 if(transction_status.equals("S"))
				        proceed_yn ="Y";
			 else if (p_error_text != null && transction_status.equals("E"))
                        proceed_yn ="N";
		 }

	}
	else{
	 if(!dischared_date.equals("")){
          blling_params =bean.getBillingValidation(encounter_id,locale);
         if(blling_params !=null){
			 p_error_text       =   (String)blling_params.get("p_error_text")==null?"":(String)blling_params.get("p_error_text");
			 transction_status  =   (String)blling_params.get("transction_status");
			 session_id         =   (String)blling_params.get("session_id")==null?"":(String)blling_params.get("session_id");
			 System.err.println("p_error_text From CA  "+p_error_text);
			 System.err.println("transction_status From CA  "+transction_status);
			 System.err.println("session_id From CA  "+session_id);
			 if(transction_status.equals("S"))
				        proceed_yn ="Y";
			 else if (p_error_text != null && transction_status.equals("E"))
                        proceed_yn ="N";

		 }
	 }else{
		     proceed_yn ="N";
	 }
	}
	 System.err.println("proceed_yn From CA  "+proceed_yn);
	  System.err.println("p_error_text From CA  "+p_error_text);
		
     if(proceed_yn.equals("N") && !p_error_text.equals("")){
		  System.err.println("95,p_error_text From CA  "+p_error_text);
		 out.println("<script>alert('"+p_error_text+"')</script>");
         }else if(proceed_yn.equals("N")){
			 if(siteSpecPatPayable){
				 out.println("<script>alert('This function is applicable for patients who are Discharged/Checked Out')</script>");//V230330
			 }else{
				out.println("<script>alert('This function is applicable for insurance patients who are Discharged/Checked Out')</script>");
			 }
	   }
	  
   if(proceed_yn.equals("Y")){

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(params));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(params));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}

            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
