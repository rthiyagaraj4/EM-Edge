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
import java.util.*;
import com.ehis.util.*;

public final class __aempallowedoperationmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEMPAllowedOperationMain.jsp", 1726462819615L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\n\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eAE/js/AEManagePatient.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="  <!-- <frameset rows=\'100%,0%\' > -->\n\t<iframe name=\'AEMPAllowedOperationsFrame\' id=\'AEMPAllowedOperationsFrame\' src=\'../../eAE/jsp/AEMPAllowedOperations.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";width:98vw\'></iframe>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<!-- <frameset rows=\'20%,130%,0%,0%\' > -->\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<!-- <frameset rows=\'20%,120%,0%\' > -->\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<iframe name=\'PatientLine\' id=\'PatientLine\' src=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&Facility_Id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' frameborder=no scrolling=\'no\' noresize style=\'height:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";width:98vw\'></iframe>\n\t<iframe name=\'AEMPAssignTreatmentAreaFrame\' id=\'AEMPAssignTreatmentAreaFrame\' src=\'../../eAE/jsp/AEMPAssignTreatmentArea.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&selection_mode=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&isStartConsultationAppl=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =";width:98vw\'></iframe><!--Modified by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623-->\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<iframe name=\'billingfr\' id=\'billingfr\' src=\'../../eBL/jsp/BLSessionValuesReset.jsp\' frameborder=0 noresize scrolling=\'no\' style=\'height:";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =";width:98vw\'></iframe>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" <!--  <frameset rows=\'100%,0%\' > -->\n\t<iframe name=\'AEMPStartConsultationFrame\' id=\'AEMPStartConsultationFrame\' src=\'../../eAE/jsp/AEMPStartConsultationMain.jsp?";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="  \n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 scrolling=\'no\' noresize style=\'height:";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =";width:98vw\'></iframe>\n<!-- </frameset>\t -->\t\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String	selection_mode	=	"",		modal_title			=	"";
	Boolean isStartConsultationAppl	= false;//Modified by Thamizh selvi on 10th Oct 2017 for ML-MMOH-CRF-0623
	Connection con 					= null;
	String bl_install_yn= (String) session.getValue( "bl_operational" ) ;

	selection_mode	=	(request.getParameter("selection_mode")==null)? "" : request.getParameter("selection_mode");
	String  encounter_id    =(request.getParameter("encounter_id")==null)? "" : request.getParameter("encounter_id");

	String	facilityId 			= (String) session.getValue( "facility_id" ) ;
		
	modal_title	                = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ManagePatQ.label","common_labels");
 
	if(selection_mode.equals("AssignTreatmentArea"))		
	        modal_title	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignTreatArea.label","ae_labels");	
	if(selection_mode.equals("AssignReassignPractitioner"))	
	        modal_title	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReassignPract.label","common_labels");
	if(selection_mode.equals("ReassignTreatmentArea"))		
	         modal_title	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.ReassignTreatArea.label","ae_labels");
	if(selection_mode.equals("StartConsultation"))			
	         modal_title	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StartConsult.label","common_labels");		 
	try
	{
		con						= ConnectionManager.getConnection(request);  
		isStartConsultationAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_START_CONSULTATION");//Added by Thamizh selvi on 3rd Oct 2017 for ML-MMOH-CRF-0623

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(modal_title));
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String height1="";
	String height2="";
	String height3="";
	String height4="";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	if(selection_mode.equals(""))
	{
		height1="80vh";
		height4="10vh";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(height1 ));
            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	else if(selection_mode.equals("AssignTreatmentArea") || selection_mode.equals("AssignReassignPractitioner") || selection_mode.equals("ReassignTreatmentArea"))
	{

		if(bl_install_yn.equals("Y")){
		 	
			height1="20vh";
			height2="60vh";
			height3="0vh";
			height4="10vh";		
		
            _bw.write(_wl_block12Bytes, _wl_block12);
}else{
			height1="20vh";
			height2="60vh";
			height4="10vh";
		
		
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(height1 ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(selection_mode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(isStartConsultationAppl));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(height2 ));
            _bw.write(_wl_block20Bytes, _wl_block20);

			if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(height3 ));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
	}
	else if(selection_mode.equals("StartConsultation"))
	{
		height1="80vh";
		height4="10vh";
		

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(height1 ));
            _bw.write(_wl_block11Bytes, _wl_block11);

	}

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(height4 ));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}catch(Exception e){ e.printStackTrace();}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
