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
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

public final class __ipbkgpatientinstructionsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPBkgPatientInstructionsMain.jsp", 1731775029064L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t</title>\n\t\t<script src=\'../../eIP/js/IPBkgPatientInstructions.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t</head>\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t <iframe name=\'patinsframe\' id=\'patinsframe\' src=\'../../eIP/jsp/IPBkgPatientInstructions.jsp?from_page=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nursing_unit_code=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&NUInsYN=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&patient_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&booking_ref_no=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' frameborder=0 noresize scrolling=\'auto\' marginheight=\'0\' marginwidth=\'0\' style=\'height:80vh;width:100vw\'></iframe><iframe name=\'patinsbuttonframe\' id=\'patinsbuttonframe\' src=\'../../eIP/jsp/IPBkgPatientInstructionsButtons.jsp?viewinsdtlsYN=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&from_page=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=0 noresize scrolling=\'no\' marginheight=\'0\' marginwidth=\'0\' style=\'height:10vh;width:100vw\'></iframe><iframe name=\'messageFrame\' id=\'messageFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 scrolling=\'auto\' style=\'height:10vh;width:100vw\'></iframe>\n\t";
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

	String locale=(String)session.getAttribute("LOCALE");
	String bkg_refno=request.getParameter("booking_ref_no")==null?"":request.getParameter("booking_ref_no");
	String NUInsYN=request.getParameter("NUInsYN")==null?"N":request.getParameter("NUInsYN");
	String from_page=request.getParameter("from_page")==null?"":request.getParameter("from_page");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String viewinsdtlsYN=request.getParameter("viewinsdtlsYN")==null?"N":request.getParameter("viewinsdtlsYN");
	String display_order_instn="";
	String instn_id="";
	String inst_desc="";
	String checkYN="";
	Integer dis_ord;
	String nursing_unit_code=request.getParameter("nursing_unit_code")==null?"":request.getParameter("nursing_unit_code");		
	Connection connection = null;
	Statement stmt = null;
	ResultSet rset = null;
	try{
			String removePatInstruction=request.getParameter("removePatInstruction")==null?"N":request.getParameter("removePatInstruction");
			
			if(removePatInstruction.equals("Y")){
				session.removeAttribute("ipPatInstructionsMap");
			}
			if(!from_page.equals("createBooking")){
				
				connection = ConnectionManager.getConnection(request);
				stmt=connection.createStatement();
				TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");
				if(patInstructionsMap==null){
				patInstructionsMap=new TreeMap();
				String bkg_pat_ins="select count(*) insCount from ip_booking_list where facility_id='"+facilityId+"' and bkg_lst_ref_no='"+bkg_refno+"'";

				if(nursing_unit_code != null)
				{
					if(nursing_unit_code.equals("")){
					bkg_pat_ins=bkg_pat_ins+" and nursing_unit_code is null";
					}
					else{
						bkg_pat_ins=bkg_pat_ins+" and nursing_unit_code ='"+nursing_unit_code+"'";
					}
				}
			
				rset=stmt.executeQuery(bkg_pat_ins);
				int insCount=0;
				while(rset!=null && rset.next()){
					insCount=rset.getInt("insCount");
				}
				if (rset != null)
					rset.close();
				if(stmt != null)
					stmt.close();
					
				if(insCount == 0){			
										
					bkg_pat_ins="SELECT instruction_id, display_order,am_get_desc.am_pat_instructions (instruction_id, '"+locale+"', 1) INSTRUCTION_DESC, DEFAULT_LINKED_YN FROM IP_NURS_PAT_INSTRUCTIONS where facility_id='"+facilityId+"'";
					if(nursing_unit_code != null)
					{
						if(nursing_unit_code.equals("")){
							bkg_pat_ins=bkg_pat_ins+" and nursing_unit_code is null";
						}
						else{
							bkg_pat_ins=bkg_pat_ins+" and nursing_unit_code ='"+nursing_unit_code+"'";
						}
					}
					}else{
						bkg_pat_ins="select INSTRUCTION_ID, INSTRUCTION_DESC, DISPLAY_ORDER,'Y' DEFAULT_LINKED_YN  from ip_bkg_pat_instructions where BKG_REF_NO='"+bkg_refno+"'";
					}
					
					stmt=connection.createStatement();
					rset=stmt.executeQuery(bkg_pat_ins);
					session.removeAttribute("ipPatInstructionsMap");
					while(rset.next()){
						display_order_instn=rset.getString("DISPLAY_ORDER");
						instn_id=rset.getString("INSTRUCTION_ID");
						inst_desc=rset.getString("INSTRUCTION_DESC");
						checkYN=rset.getString("DEFAULT_LINKED_YN");
						String instns=instn_id+"||"+inst_desc+"||"+checkYN;
						dis_ord=new Integer(Integer.parseInt(display_order_instn));
						patInstructionsMap.put(dis_ord,instns);
					}
					session.setAttribute("ipPatInstructionsMap",patInstructionsMap);					
				}	
			}				
				
			
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nursing_unit_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(NUInsYN));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bkg_refno));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(viewinsdtlsYN));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(NUInsYN));
            _bw.write(_wl_block15Bytes, _wl_block15);
}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(connection,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
