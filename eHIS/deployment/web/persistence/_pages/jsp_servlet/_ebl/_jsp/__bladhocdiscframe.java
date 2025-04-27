package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __bladhocdiscframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAdhocDiscFrame.jsp", 1739956477719L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t<!-- <script language=\"javascript\" src=\"../../eBL/js/BLEnterServiceRequest.js\"></script>\t -->\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\n  <!-- <iframeSET rows=\'7%,40%,40%,10%,0%,3%\'> -->\n  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n <!--  <iframeSET rows=\'7%,40%,40%,10%,3%\'> -->\n    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n  \t\t\n\t\t<iframe name=\'pat_banner_frame\' id=\'pat_banner_frame\' SRC=\"../../eCommon/jsp/pline.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" frameborder=0 scrolling=\'no\' noresize style=\"height:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =";width:100vw;\"></iframe>\t\t\t\n\t\t<iframe name=\'details_frame\' id=\'details_frame\' SRC=\"../../eBL/jsp/BLAdhocDisc.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =";width:100vw;\"></iframe>\t\t\n\t\t<iframe SRC=\"../../eCommon/html/blank.html\"\t  NAME=\"payer_frame\" id=\"payer_frame\" frameborder=0 noresize scrolling=\'no\' style=\"height:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";width:100vw;\"></iframe>\t\t\t\n\n\t\t<iframe name=\'btn_frame\' SRC=\"../../eBL/jsp/BLAdhocDiscBtn.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =";width:100vw;\"></iframe>\n\n<!--\n\t\t<iframe SRC=\"../../eCommon/html/blank.html\"\t  NAME=\"btn_frame\" frameborder=0 noresize scrolling=\'yes\'>\t\t\t\t\n-->\n\t\t<iframe SRC=\"../../eCommon/html/blank.html\"\t  NAME=\"submit_frame\" id=\"submit_frame\" frameborder=0 noresize scrolling=\'no\' style=\"height:";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =";width:100vw;\"></iframe>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<iframe SRC=\"../../eBL/jsp/BLDiscColorBondInd.jsp\"\t  NAME=\"color_bond\" id=\"color_bond\" frameborder=0 noresize scrolling=\'no\' style=\"height:";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\n <!--   </FRAMESET>\t -->\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</HTML>\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

//Modified by MuthuN against 34961 on 13-9-12
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	PreparedStatement pstmt = null;
//Modified by MuthuN against 34961 on 13-9-12
	Connection con1	= null;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try
	{
			
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		String params = request.getQueryString();

		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";

		String patient_id = request.getParameter("patient_id");	
		if(patient_id==null) patient_id="";
		
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";
	
		String encounter_id = request.getParameter("encounter_id");	
		if(encounter_id==null) encounter_id="";

		String p_pract_id = request.getParameter("pract_id");	
		if(p_pract_id==null) p_pract_id="";

		String p_locn_code = request.getParameter("locn_code");	
		if(p_locn_code==null) p_locn_code="";

		String p_billgenlater = request.getParameter("billgenlater");	
		if(p_billgenlater==null) p_billgenlater="";

		String p_function_id = request.getParameter("function_id");	
		if(p_function_id==null) p_function_id="";

		String p_module_id = request.getParameter("module_id");	
		if(p_module_id==null) p_module_id="";

		String p_visit_type_code = request.getParameter("visit_type_code");	
		if(p_visit_type_code==null) p_visit_type_code="";

		String p_slmt_reqd_yn = request.getParameter("slmt_reqd_yn");	
		if(p_slmt_reqd_yn==null) p_slmt_reqd_yn="";
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		try {
			con1	=	ConnectionManager.getConnection(request);
			site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con1, "BL","3TIERALMOFEATURE");
			} catch(Exception ex) {
				System.err.println("Error in BLAdhocDiscFrame.jsp for getting site3TierAlmoFeature Connection: "+ex);
				ex.printStackTrace();
			}finally{
				if(con1!=null) {
					ConnectionManager.returnConnection(con1, request);
			}
		}
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		
		//Modified by MuthuN against 34961 on 13-9-12
		String str_reg_facility_id="";
		String str_custmr_id ="";

try	{
				con	=	ConnectionManager.getConnection(request);	
				String sql1="";
		
				sql1 = "select facility_id from pr_encounter where patient_id = ? and encounter_id = ? ";

		System.err.println("87, BLAdhocDiscFrame.jsp==sql1==> select facility_id from pr_encounter where patient_id = '"+patient_id+"' and encounter_id = '"+encounter_id+"'");

		//stmt = con.createStatement();
		/* Fixed SQL Injection for Common-ICN-0222 */
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1, patient_id);
		pstmt.setString(2, encounter_id);
		rs = pstmt.executeQuery();	

		while(rs.next())
		{
		   str_reg_facility_id  =  rs.getString(1);		
		   System.err.println("BLAdhocDiscFrame.jsp==str_reg_facility_id ==>"+str_reg_facility_id);
		}	
		rs.close();
		pstmt.close();			  
		if (str_reg_facility_id==null) str_reg_facility_id = "";
		System.err.println("str_reg_facility_id from query==>"+str_reg_facility_id); 

		sql1 = "select customer_id from sm_site_param ";

		System.err.println("104, BLAdhocDiscFrame.jsp==sql1==> select customer_id from sm_site_param");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql1);	

		while(rs.next())
		{
		   str_custmr_id  =  rs.getString(1);
		   System.err.println("BLAdhocDiscFrame.jsp==str_custmr_id ==>"+str_custmr_id);
		}	
		rs.close();
		stmt.close();			  
		if (str_custmr_id==null) str_custmr_id = "";				   
		params =params + "&customer_id="+str_custmr_id;
		System.err.println("117, BLAdhocDiscFrame.jsp== params==>"+params);
	}
	catch(Exception e)
	{    
		e.printStackTrace();
		System.err.println("Error while calling BLCOMMON.BL_VALIDATE_UPD_FIN_DTLS :"+e);
	}
	//String for_pline = "Facility_Id="+facilityid+"&Patient_Id="+patient_id+"&EncounterId="+encounter_id+"&visit_id="+visit_id;
	String for_pline ="Facility_Id="+str_reg_facility_id+"&Patient_Id="+patient_id+"&EncounterId="+encounter_id+"&visit_id="+visit_id;	
	//Modified by MuthuN against 34961 on 13-9-12

            _bw.write(_wl_block5Bytes, _wl_block5);
		/***********Added for ghl-crf-1.2******************************/
		String called_for_reg_chg = request.getParameter("called_for_reg_chg");
		if(called_for_reg_chg == null) called_for_reg_chg="N";
		/***************end*********************************************/
		if(called_for_reg_chg.equals("pat_reg_chr") || p_module_id.equals("MP"))
		{

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
		}else{

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
		} 
            _bw.write(_wl_block8Bytes, _wl_block8);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String height1 ="";
	String height2 ="";
	String height3 ="";
	String height4 ="";
	String height5 ="";
	String height6 ="";


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
	//if(str_custmr_id.equals ("ALMO"))
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	if(str_custmr_id.equals ("ALMO") || site3TierAlmoFeature == true) 
	{
		
		 height1 ="10vh";
		 height2 ="20vh";
		 height3 ="50vh";
		 height4 ="8vh";
		 height5 ="0vh";
		 height6 ="5vh";
		

            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
	  
	    height1 ="10vh";
		height2 ="20vh";
		height3 ="55vh";
		height4 ="20vh";
		height5 ="5vh";
	  
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(for_pline));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(height4));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(height5));
            _bw.write(_wl_block19Bytes, _wl_block19);
 //Added V200228 SHIKHA against AAKH-CRF-0112  & AAKH-SCF-0404.1
			if(str_custmr_id.equals ("ALMO") || site3TierAlmoFeature == true) { 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(height6));
            _bw.write(_wl_block19Bytes, _wl_block19);
} //Ended V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1 
            _bw.write(_wl_block21Bytes, _wl_block21);


	}
	catch(Exception ee)
	{
		ee.printStackTrace();
		out.println("Exception in BLAdhocDiscFrame.jsp:"+ee);
	}
	/*Added by karthik on 2-Jan-2013 for AMS-SCF-0170*/
	finally
	{
		session.setAttribute("str_default_reason_code","");
		session.setAttribute("str_default_reason_desc","");
		if(con!=null) {
			ConnectionManager.returnConnection(con, request);
		}
	}

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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISC_FOR_REG_CHARGE_DTLS.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISC_FOR_ENC_CHARGE_DTLS.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
