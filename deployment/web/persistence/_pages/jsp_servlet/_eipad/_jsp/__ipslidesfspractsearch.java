package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.HealthObjects.InPatientContext;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eIPAD.HealthObjects.*;
import eIPAD.sfs.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __ipslidesfspractsearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/IPSlideSFSPractSearch.jsp", 1709118028209L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n\n\n\n<script type=\"text/javascript\">\n\n</script>\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<!-- PR Content starts here-->\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"table\" id=\"listPR\" style=\"width:100%; height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t \t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row listItemPR listItemPR";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  data-pract=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" id=\"listItemPR";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" style=\"width:100%; height:45px;\" onclick=\"selectedPract(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'SlectedPract\')\" data-practcode=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" data-practdesc=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- border-bottom: 1px solid #f6f6f6; -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell slSfsViewItemTextPract slSfsViewItemTextPractTheme\" id=\"textPR";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<br>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"slSfsViewItemTextSmall slSfsViewItemTextSmallTheme\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsListTickPractTheme\"><div class=\"slSfsTickVisiblePR SLSfsCircleVisibleTheme\" id=\"slSfsTickPR";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" style=\"display:none;\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" id=\"listPR_NoResults\" style=\" height:100%;padding-left:10px;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"slSfsViewItemTextSmall slSfsViewItemTextSmallTheme\">No matches</span>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- PR Content ends here-->\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\n\t\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	InPatientContext objInPatientContext = new InPatientContext();
	objInPatientContext.setRequest(request);
	
	String locale = "en";
	String facilityId = "";
	String fSpecialityId = "";
	String fSpecialityName = "";
	String fNursingUnitId = "";
	String fNursingUnitName = "";
	String fPractitionerId = "";
	String fPractitionerName = ""; 
	String fSfsContext = "";
	String practSearchText = "";
	String noResultsStyle = "display:none;";

            _bw.write(_wl_block4Bytes, _wl_block4);

									SFSContext oSFSContext = new SFSContext();
									String sfacility_id = "";
									String sclinicianId = "";
									String sPractionerId = "";
									String selectedPractID = "";
									String specCode= "";
									String practCode = "";
									String nursingCode= "";
									String clinicianId = "";
									oSFSContext.setRequest(request);
									if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
									{
										sfacility_id = (String)session.getValue("facility_id");
										oSFSContext.setSfacility_id(sfacility_id);
									}
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
									{
										sclinicianId = (String)session.getValue("ca_practitioner_id");
										oSFSContext.setSclinicianId(sclinicianId);
									}
									/* if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId") != "")
									{
										sPractionerId = (String)request.getParameter("hdnPractitionerId");
										oSFSContext.setsPractionerId(sPractionerId);
									} */
									
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")	
									{
										sclinicianId = (String)session.getValue("ca_practitioner_id");
										oSFSContext.setsPractionerId(sclinicianId); //for Nursing Unit search alone always the practitioner ID is the login practitioner
									}
									if(request.getParameter("selectedPractID") != null){
										
										selectedPractID = (String)request.getParameter("selectedPractID");
										oSFSContext.setsPractionerId(selectedPractID);
									}
									
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
									{
										clinicianId = (String)session.getValue("ca_practitioner_id");
										objInPatientContext.setClinicianId(clinicianId);
									}
									
									if(request.getParameter("practSearchText") != null){
										
										practSearchText = (String)request.getParameter("practSearchText");
										oSFSContext.setsSearchText(practSearchText);
									}
									
									
										
												
									   int nRowCount = 1;		       			    
									   int nLoopCount = 0;
									   
									   int nListSizePR = 0;
									 
									   SFSDetails bean = new SFSDetails();
									   List<SFSUnit> objSfsDetailsPR = new ArrayList<SFSUnit>();
									   
									   int sfsContextTypePR = 4;
									
            _bw.write(_wl_block5Bytes, _wl_block5);

											
												oSFSContext.setType(sfsContextTypePR);  
												objSfsDetailsPR = bean.getSFSUnit(oSFSContext); 
							   					nListSizePR =  objSfsDetailsPR.size();
							   					SFSUnit sfsUnitPR = null;
							   					
							   						
											 
            _bw.write(_wl_block6Bytes, _wl_block6);

						   						
						   						if(nListSizePR >0 ){
										
            _bw.write(_wl_block7Bytes, _wl_block7);

																 	  		for(nLoopCount = 0 ; nLoopCount < nListSizePR; nLoopCount++)
																 	  			{
																 		 		sfsUnitPR = objSfsDetailsPR.get(nLoopCount);
																 		  		if(sfsUnitPR != null )
																		  			{
																 					 practCode = sfsUnitPR.getsCode();
															 		 		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(practCode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(practCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(practCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(practCode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sfsUnitPR.getsDescription()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(practCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sfsUnitPR.getsDescription()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(practCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sfsUnitPR.getsDescription()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sfsUnitPR.getsCode()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practCode));
            _bw.write(_wl_block19Bytes, _wl_block19);

																  					}
																  					nRowCount = nRowCount + 1;
																				} 
																 	 		
            _bw.write(_wl_block20Bytes, _wl_block20);

											
											}else{
											
												noResultsStyle = "display:block;";
											
											} 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(noResultsStyle));
            _bw.write(_wl_block22Bytes, _wl_block22);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
