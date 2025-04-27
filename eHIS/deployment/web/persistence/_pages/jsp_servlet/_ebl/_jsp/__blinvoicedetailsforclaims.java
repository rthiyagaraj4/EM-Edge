package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Date;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import java.math.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blinvoicedetailsforclaims extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLInvoiceDetailsForClaims.jsp", 1737916125421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident        SCF/CRF             Developer Name\n-----------------------------------------------------------------------------------\n1            V201125            8073        MOHE-CRF-0055           Nandhini M\n2\t\t\t V211020\t\t\t\t\t\t\t\t\t\t\tMohanapriya K\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\t\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/BLInvoiceDetailsForClaims.js\"></script> \n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nfunction setDefault(){\n\tvar date = new Date();\n\tvar mon= date.getMonth()+1; //added against 9861\n\tvar yr=date.getYear();\n\tdocument.getElementById(\"Month\").value=mon;\n\tdocument.getElementById(\"Year\").value=yr;\n}\n\nfunction processScroll(){\n\tif (headTop < 0)\n\t{\n\t\tsaveHeadPos();\n\t}\n\tif (headTop>0)\n\t{\n\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\ttheTop = document.documentElement.scrollTop;\n\t\telse if (document.body)\n\t\t\ttheTop = document.body.scrollTop;\n\n\t\tif (theTop>headTop)\n\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\telse\n\t\t\tFloatHead1.style.top = \'0px\';\n\t}\n}\n\nfunction saveHeadPos(){\n\tparTable = document.getElementById(\"divHeadSep\");\n\tif (parTable != null)\n\t{\n\t\theadTop = parTable.offsetTop + 3;\n\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\tFloatHead1.style.position = \"relative\";\n\t}\n}\n\nfunction lockbackSpace(){\n\tvar mode = document.mode.value;\n\tif(mode==\'modify\' && window.event.keyCode==8)\n\t{\n\t\t//return false;\n\t}\n}\n</script>\n\n</head>\n<style>\n\t\tthead td, thead td.locked { \n\t\tbackground-color: navy;\n\t\tcolor: white;\n\t\tposition:relative;}\t\n\t\tthead td {\n\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-4); \n\t\tz-index: 20;}\n\t\tthead td.locked {z-index: 30;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative; \n\t\tz-index: 10;}\n\t\t</style>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<BODY onScroll=\"processScroll()\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onLoad=\"setDefault()\" onSelect=\"codeArrestThruSelect();\" style=\"padding-left:10px;padding-right:10px;padding-top:5px;\">\n <form name=\"BLCollectionSummaryForm\" id=\"BLCollectionSummaryForm\" id=\"BLCollectionSummaryForm\"  action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\" > \n\n<TABLE width=\"100%\" CELLSPACING=\'0\' cellpadding=\'3\' align=\"center\" >\n\t<tr>\n\t\t<td  class=\"columnheader\" >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" </td>\n\t</tr>\t\n</TABLE>\n<br>\n<table cellpadding=\'10\' cellspacing=\'0\' width=\"100%\" align=\"center\" border=\'0\'>\t\n\t<tr>\n\t\t<td class=\"label\" style=\"width:10%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td class=\'fields\' style=\"width:10%\">\n\t\t\t<Select name=\'facility\' id=\'facility\' id=\"facility\" style=\"width: 100px;\">\n\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<option selected value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</option>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</Select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td  class=\"label\" width=\"10%\">\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</td>\n\t\t<td  class=\"fields\" style=\"width:20%\">\n\t\t\t\n\t\t\t<select name=\"Month\" id=\"Month\" id=\"Month\"  style=\"width: 100px;\">       \n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<option value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t </select>\t\n\t\t\t <select name=\"Year\" id=\"Year\" id=\"Year\" style=\"width: 100px;\">  \n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t</td>\n\t</tr>\t\n\t</table>\t\t\n\t\t\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' \t\tid=\'locale\'\t\t\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" id=\"p_module_id\" \tvalue=\"BL\"\t>\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" id=\"p_report_id\"\tvalue=\"BLRINVDC\" >\n\t<input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" \t\tid=\"pgm_id\"\t\t\tvalue=\"\"\t> \t\t\n\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\" \tid=\"p_facility_id\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"\t>\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\" \tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"p_episode_id\" id=\"p_episode_id\" \tvalue=\"\">\n\t<input type=\"hidden\" name=\"p_visit_id\" id=\"p_visit_id\" \tid=\"p_visit_id\"\t\tvalue=\"\" >\n\t<input type=\"hidden\" name=\"p_patient_id\" id=\"p_patient_id\"\tid=\"p_patient_id\" value=\"\"\t>\n\t<input type=\"hidden\" name=\"p_session_id\" id=\"p_session_id\" \tvalue=\"\">\t\n</form>\n</BODY>\n\t ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
	
		private String checkForNull(String inputString)
		{
			return (inputString == null) ? "" :	inputString;
		}
			
		public static String checkForNull(String inputString, String defaultValue)
		{
			return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String applyMode	=	new String();
	String locale		=	"";
	String p_user_name	= (String) session.getValue( "login_user" );
	String mode			=	"";
	String isUserCanAcess	=	"";
	Connection con = null;
	ResultSet rst = null;
	ResultSet rst2 = null;
	ResultSet rst3 = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	String facility_id = (String)session.getAttribute("facility_id");	

	try  
	{		 
		locale  = 	(String)session.getAttribute("LOCALE");
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));	

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
				
			try{
					String sqlFacility = "select facility_id, facility_name from Sm_Facility_Param where status = 'E'";
					con = ConnectionManager.getConnection();
					pstmt = con.prepareStatement(sqlFacility);
					rst = pstmt.executeQuery();
					if(rst != null){
						while(rst.next()){
							if(rst.getString("facility_id").equals(facility_id)){					
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rst.getString("facility_id") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rst.getString("facility_name") ));
            _bw.write(_wl_block12Bytes, _wl_block12);
			
					}else{			
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rst.getString("facility_id") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rst.getString("facility_name") ));
            _bw.write(_wl_block12Bytes, _wl_block12);
				}
						}
						rst.close();
					}
					pstmt.close();
				}
				catch(Exception e){
					System.err.println("Exception in Info Frame Load - "+e);
					e.printStackTrace();
				}
		
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			try{
				List<String> monthsList = new ArrayList<String>();
				String[] months = new DateFormatSymbols().getMonths();
				int length=months.length-1;
				for (int i = 0; i < length; i++) {
				String month = months[i];
				int j=i+1; //added against 9861
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(j));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(month));
            _bw.write(_wl_block12Bytes, _wl_block12);
 
				monthsList .add(months[i]);
				}
				}catch(Exception e){
					try{
						if(pstmt2!=null) pstmt2.close();
						if(rst2!=null) rst2.close();
						//ConnectionManager.returnConnection(con); //V211020
					}catch(Exception exp)
					{
						System.err.println("Exception in month Load - "+exp);
						exp.printStackTrace();
					}
			}	
		
            _bw.write(_wl_block18Bytes, _wl_block18);
 		 
			try{
					String sql3="select to_char(sysdate,'yyyy') from dual";
				//	con = ConnectionManager.getConnection(); //V211020
					pstmt3 = con.prepareStatement(sql3);
					rst3 = pstmt3.executeQuery();
					if(rst3 != null){
						while(rst3.next()){
						String strYr = rst3.getString(1);
					if(strYr!=null){
						int currentYear=Integer.parseInt(strYr);
					for(int i=currentYear;i>=2000;i--) {
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
			}
					}
				}
				}
				}
			catch(Exception e){
				try{
					if(pstmt3!=null) pstmt3.close();
					if(rst3!=null) rst3.close();
					ConnectionManager.returnConnection(con);
				}catch(Exception ex){
					System.err.println("Exception in Info Frame Load - "+ex);
					ex.printStackTrace();
				}
			}
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in BLCollectSumryReport.jsp::"+e);
		}
	 
            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ReportCriteria.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Invoices_month_yr.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
