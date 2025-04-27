package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __momanagedeceasedallowedoperationmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MOManageDeceasedAllowedOperationMain.jsp", 1726636151143L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n      <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eMO/js/MOManageDeceased.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n<!-- <frameset rows=\'100%,0%\' > -->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t<!--Below Parameter Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t<iframe name=\'AEMPAllowedOperationsFrame\' id=\'AEMPAllowedOperationsFrame\' src=\'../../eMO/jsp/MOManageDeceasedAllowedOperations.jsp?selection_mode=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&select_registration=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&select_name=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&select_sex=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&select_area_desc=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&select_pmyn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&assign_area_code=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&select_pmstatus=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&area_type=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&patient_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&or_installyn=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&order_catalog_code=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&encounterId=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&CLAIMANT_TYPE=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&RELEASE_TO_FACILITY=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' frameborder=0 scrolling=\'no\' style=\'height:95vh;width:99vw\'></iframe>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t<!--Parameter Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t<iframe name=\'AEMPAssignAreaFrame\' id=\'AEMPAssignAreaFrame\' src=\'../../eMO/jsp/MOAssignAreaFrameset.jsp?function_id=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&selection_mode=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&bed_no=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t<iframe name=\'AEMPStartConsultationFrame\' id=\'AEMPStartConsultationFrame\' src=\'../../eMO/jsp/MOManageDeceasedAllowedOperations.jsp?&selection_mode=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<iframe name=\'AEMPAllowedOperationsFrame\' id=\'AEMPAllowedOperationsFrame\' src=\'../../eMO/jsp/MOManageDeceasedAllowedOperations.jsp?&selection_mode=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t<!--Parameter Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg-->\n\t<iframe name=\'AEMPAllowedOperationsFrame\' id=\'AEMPAllowedOperationsFrame\' src=\'../../eMO/jsp/MOManageDeceasedAllowedOperations.jsp?function_id=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 scrolling=\'no\' style=\'height:0vh;width:0vw\'></iframe>\n</frameset>\t\t\n</html>\n\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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

    request.setCharacterEncoding("UTF-8");
	String	selection_mode		=  "",		modal_title			=	"";
	String	select_registration	=  "";
	String	select_name			=  "";
	String	select_sex			=  "";
	String	select_area_desc	=  "";
	String select_pmyn			=  ""; 	
	String assign_area_code		=  "";
	String select_pmstatus		=  "";
	String area_type			=  "";
	String bed_no               =  "";
    String patient_id           =  "";
	String or_installyn         ="";
	String order_catalog_code="";
	String function_id="";
	String encounterId=	(request.getParameter("encounterId")==null)? "" : request.getParameter("encounterId");
	selection_mode		=	(request.getParameter("selection_mode")==null)? "" : request.getParameter("selection_mode");
	select_registration	=	request.getParameter("select_registration");
	select_name			=	request.getParameter("select_name");
	select_sex			=	request.getParameter("select_sex");
	select_area_desc	=	request.getParameter("select_area_desc");
	select_pmyn			=	request.getParameter("select_pmyn");
	assign_area_code	=	request.getParameter("assign_area_code");
	select_pmstatus		=	request.getParameter("select_pmstatus");
	select_pmyn			=	((select_pmyn==null) || (select_pmyn.equals(""))) ? "" : select_pmyn;
	select_pmstatus		=	((select_pmstatus==null) || (select_pmstatus.equals(""))) ? "" : select_pmstatus;
	assign_area_code	=	((assign_area_code==null) || (assign_area_code.equals(""))) ? "" : assign_area_code;
	area_type			=	request.getParameter("area_type")==null?"":request.getParameter("area_type");
	bed_no				=	request.getParameter("bed_no")==null?"":request.getParameter("bed_no");
	patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	function_id			=	request.getParameter("function_id")==null?"":request.getParameter("function_id");
 	order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
	or_installyn=request.getParameter("or_installyn")==null?"":request.getParameter("or_installyn");
	String CLAIMANT_TYPE=	(request.getParameter("CLAIMANT_TYPE")==null)? "" : request.getParameter("CLAIMANT_TYPE"); // Bru-HIMS-CRF-366 [IN-039612]
	String RELEASE_TO_FACILITY=	(request.getParameter("RELEASE_TO_FACILITY")==null)? "" : request.getParameter("RELEASE_TO_FACILITY"); // Bru-HIMS-CRF-366 [IN-039612]
	modal_title			=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ManageDeceasedPatients.label","mo_labels");//	"Manage Deceased Patients";

	if(selection_mode.equals("AssignArea"))			
	modal_title		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.assignarea.label","common_labels"); //"Assign Area";

	if(selection_mode.equals("PostmortemRequest"))			
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemRequest.label","mo_labels");	//"Postmortem Request";
	
	if(selection_mode.equals("starAtpm"))			
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StartPM.label","mo_labels");//	"Start PM";

	if(selection_mode.equals("endpm"))				
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.EndPM.label","mo_labels"); //	"End PM";

	if(selection_mode.equals("reldec"))		
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseDeceased.label","mo_labels"); //	"Release Deceased";

	if(selection_mode.equals("expdoc"))
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ExportationDocument.label","mo_labels");//	"Exportation Document";

	if(selection_mode.equals("ReassignArea"))
	modal_title		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReassignArea.label","mo_labels");	//"Reassign Area";

	if(selection_mode.equals("StartConsultation"))
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StartConsult.label","common_labels"); //	"Start Consultation";

	if(selection_mode.equals("UnAssignArea"))
	modal_title		=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.UnAssignLocation.label","mo_labels");//	"UnAssign Location";

	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(modal_title));
            _bw.write(_wl_block7Bytes, _wl_block7);

     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
  //Condition Changed Against Bru-HIMS-CRF-366 [IN-039612]
	if(selection_mode.equals("a"))
	{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(java.net.URLEncoder.encode(selection_mode)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_registration)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_name)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_sex)  ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_area_desc)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmyn)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmstatus)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(area_type)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_id)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterId)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}
//Condition Changed Against Bru-HIMS-CRF-366 [IN-039612]
	else if(selection_mode.equals("AssignArea")||selection_mode.equals("ReassignArea"))
	{	

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(selection_mode)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_registration)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_name)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_sex)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_area_desc)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmyn)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmstatus)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(area_type)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(java.net.URLEncoder.encode(bed_no)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_id)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block25Bytes, _wl_block25);
} 
	else if(selection_mode.equals("startpm"))
	{
	
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(selection_mode)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_registration)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_name)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_sex)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_area_desc)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmyn)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmstatus)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(area_type)));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}
	else if(selection_mode.equals("p"))
	{		
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(selection_mode)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_registration)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_name)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_sex)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_area_desc)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmyn)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmstatus)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(area_type)));
            _bw.write(_wl_block25Bytes, _wl_block25);

	} else if(selection_mode.equals("bs") || selection_mode.equals("pam"))
	{

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(java.net.URLEncoder.encode(selection_mode)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_registration)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_name)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_sex)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_area_desc)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmyn)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmstatus)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(area_type)));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else if(selection_mode.equals("b")) 
{

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(java.net.URLEncoder.encode(selection_mode)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_registration)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_name)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_sex)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_area_desc)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmyn)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(assign_area_code)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(select_pmstatus)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(area_type)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(or_installyn)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(order_catalog_code)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterId)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(patient_id)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(java.net.URLEncoder.encode(CLAIMANT_TYPE)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(java.net.URLEncoder.encode(RELEASE_TO_FACILITY)));
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
