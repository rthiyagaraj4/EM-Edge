package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ororderablesbysource extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OROrderablesBySource.jsp", 1709535380000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<HTML>   \n<HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/OrderablesBySource.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<!--<iframe name=\"orderCategoryFrame\" id=\"orderCategoryFrame\" SCROLLING=\"YES\" FRAMEBORDER=\"0\" NORESIZE SRC=\"OROrderablesBySourceCategory.jsp\" style=\"height:13vh;width:100vw\"></iframe><iframe name=\"orderTypeFrame\" id=\"orderTypeFrame\" SCROLLING=\"YES\" FRAMEBORDER=\"0\" NORESIZE SRC=\"OROrderablesBySourceType.jsp\" style=\"height:18vh;width:100vw\"></iframe><iframe name=\"orderCodeFrame\" id=\"orderCodeFrame\" SCROLLING=\"YES\" FRAMEBORDER=\"0\" NORESIZE SRC=\"OROrderablesBySourceCode.jsp\" style=\"height:18vh;width:100vw\"></iframe><iframe name=\"blankFrame\" id=\"blankFrame\" SCROLLING=\"NO\" FRAMEBORDER=\"0\" NORESIZE SRC=\"../../eCommon/html/blank.html\" style=\"height:86vh;width:100vw\"></iframe> -->\n</HEAD>\n<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<form name=\"frmOrderablesBySource\" id=\"frmOrderablesBySource\" ACTION=\"../../eCommon/jsp/report_options.jsp\" TARGET=\"messageFrame\">\n\t\n\t<br><br><br><br><br><br><br>\n\n\t\t<TABLE WIDTH=\"70%\" ALIGN=\"center\" CELLPADDING=\"0\" CELLSPACING=\"0\" BORDER=\"0\">\n\t\t\t<TR>\n\t\t\t<TD COLSPAN=\"3\">&nbsp</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD ALIGN=\"right\" WIDTH=\"30%\" CLASS=\"label\">Order Category &nbsp</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"25%\">\n\t\t\t\t<select name=\"p_order_category\" id=\"p_order_category\" onchange=\"javascript:OrderCategoryDesc()\">\n\t\t\t\t<option value=\"\"> All </option>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</select>\n\t\t\t</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"45%\">\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"3\">&nbsp</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD WIDTH=\"30%\">&nbsp</TD>\n\t\t\t<TD CLASS=\"label\" ALIGN=\"left\" WIDTH=\"25%\">From</TD>\n\t\t\t<TD CLASS=\"label\" ALIGN=\"left\" WIDTH=\"45%\">&nbsp To</TD>\n\t\t</TR>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<TR>\n\t\t\t<TD ALIGN=\"right\" WIDTH=\"30%\" CLASS=\"label\">Order Type &nbsp</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"25%\">\n\t\t\t\t<select name=\"p_fr_order_type_code\" id=\"p_fr_order_type_code\" onchange=\"\">\n\t\t\t\t<option value=\"\"> All </option>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t</select>\n\t\t\t</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"45%\">&nbsp\n\t\t\t\t<select name=\"p_to_order_type_code\" id=\"p_to_order_type_code\" onchange=\"\">\n\t\t\t\t<option value=\"\"> All </option>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</select>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"3\">&nbsp</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD ALIGN=\"right\" WIDTH=\"30%\" CLASS=\"label\">Source Type &nbsp</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"25%\">\n\t\t\t\t<select name=\"p_source_type\" id=\"p_source_type\" onchange=\"javascript:OrderCode()\">\n\t\t\t\t\t\t<option value=\"\"> ---Select---</option>\n\t\t\t\t\t\t<option value=\"C\"> Clinic</option>\n\t\t\t\t\t\t<option value=\"N\"> Nursing Unit</option>\n\t\t\t\t</select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" ></img>\n\t\t\t</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"45%\">\n\t\t\t\t\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"3\">&nbsp</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD ALIGN=\"right\" WIDTH=\"30%\" CLASS=\"label\">Source Code &nbsp</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"25%\">\n\t\t\t\t<select size=\"1\" name=\"p_fr_source_code\" id=\"p_fr_source_code\" onchange=\"\">\n\t\t\t\t\t<option value=\"\"> All</option>\n\t\t\t\t</select>\n\t\t\t</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"45%\">&nbsp\n\t\t\t\t<select size=\"1\" name=\"p_to_source_code\" id=\"p_to_source_code\" onchange=\"\">\n\t\t\t\t\t<option value=\"\"> All</option>\n\t\t\t\t</select>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"3\">&nbsp;</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD ALIGN=\"right\" WIDTH=\"30%\" CLASS=\"label\">Period &nbsp</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"25%\">\n\t\t\t\t<input type=text name=\"p_fr_date\" id=\"p_fr_date\" size=6 maxlength=7 onKeyPress=\'return CheckForSpecChars(event)\' onblur=\"javascript:checkDate(this)\"\n\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" > \n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t</TD>\n\t\t\t<TD ALIGN=\"left\" WIDTH=\"45%\">&nbsp\n\t\t\t\t<input type=text name=\"p_to_date\" id=\"p_to_date\" size=6 maxlength=7 onKeyPress=\'return CheckForSpecChars(event)\' onblur=\"javascript:checkDate(this)\"\n\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR>\n\t\t\t<TD COLSPAN=\"3\">&nbsp</TD>\n\t\t</TR>\n\t\t</TABLE>\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" value=\"OR\">\n\t\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"ORRORSOU\">\n\t\t<INPUT TYPE=\"hidden\" name=\"p_language_id\" id=\"p_language_id\" VALUE=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	Calendar calendar = new GregorianCalendar();
	String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
	int mon = Integer.parseInt(month);
	if(mon<10)
		month = "0"+month;
	String year = String.valueOf(calendar.get(Calendar.YEAR));
	String date = month + "/" + year;


	/* Mandatory checks start */
	String bean_id = "OROrderablesBySourceBean" ;
	String bean_name = "eOR.OROrderablesBySourceBean";

	/* Initialize Function specific start */
	OROrderablesBySourceBean bean = (OROrderablesBySourceBean)getBeanObject( bean_id, bean_name, request ) ;
	
	ArrayList masterList = bean.getCategoryList();

	Vector order_category = (Vector )masterList.get(0);
	Vector short_desc_category = (Vector )masterList.get(1);

            _bw.write(_wl_block10Bytes, _wl_block10);

				for(int i=0;i<short_desc_category.size();i++)
				{
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( (String )order_category.get(i) ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( (String )short_desc_category.get(i) ));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
				
            _bw.write(_wl_block14Bytes, _wl_block14);

	String str_order_category = "";
	ArrayList orderList = bean.getOrderTypeList(str_order_category);	
	Vector order_type_code = (Vector)orderList.get(0);
	Vector short_desc_type = (Vector)orderList.get(1);

            _bw.write(_wl_block15Bytes, _wl_block15);

				for(int i=0;i<short_desc_type.size();i++)
				{
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( (String)order_type_code.get(i) ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( (String )short_desc_type.get(i) ));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
				
            _bw.write(_wl_block18Bytes, _wl_block18);

				for(int i=0;i<short_desc_type.size();i++)
				{
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( (String )order_type_code.get(i) ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( (String )short_desc_type.get(i) ));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( date ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( date ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( (String)session.getValue("facility_id")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block25Bytes, _wl_block25);

		putObjectInBean(bean_id,bean,request);
 

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
