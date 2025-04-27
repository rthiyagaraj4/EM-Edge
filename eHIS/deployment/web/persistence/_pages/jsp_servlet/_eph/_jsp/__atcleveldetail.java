package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __atcleveldetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ATCLevelDetail.jsp", 1721128216698L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'type=\'text/css\'></link>\n<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../js/ATCClassification.js\"></script>\n<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../ePH/js/PhMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n -->\n<style type=\"text/css\">\n*\n{\ncursor:pointer;\n}\n</style> \n</head>\n\n<!-- <body topmargin=\"0\" onMouseDown=\"CodeArrest()\" style=\"overflow-x:hidden;overflow-y:scroll\"> -->\n<body topmargin=\"0\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" style=\"overflow-x:hidden;overflow-y:scroll\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<table border=\"1\" align=\"center\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" id=\"desc_detail\">\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\n<tr onClick=\"javascript:changeRowColor(this,\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\" >\n\n<!-- Start - To Display + Symbol which has Child Records -->\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t<td class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" title=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onClick=\'hideToolTip(); showNextLevel(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\",\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\");\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n<!-- End -To Display + Symbol which has Child Records -->\n\n<!-- Start - To display - symbol in red color which has no child Record-->\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" style=\"color:red;\" id=\'nochild\' onClick=\'showNextLevel(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n<!-- End - to display - symbol in red color-->\n\n<!-- Start -To display the symbol + in normal Color-->\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onMouseOver=\"style.cursor=\'default\'\" onClick=\'showNextLevel(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n<!-- End -To display the symbol + in normal Color-->\n\n<!-- Description based on calling function -->\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" nowrap  title=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" style=\"cursor:auto;font-size:9;color:navy;\">&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" nowrap  onClick=\'displayToolTip(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\")\' title=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >&nbsp;\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<!----Description display ends -->\n\t</tr>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</table>\n<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n</table>\n</div>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"level_no\" id=\"level_no\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?

(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	/* Mandatory checks start */
	String mode			=	request.getParameter( "mode" ) ;
	String levelNo		=	request.getParameter("level_num");
	String bean_id		=	"PhATCClassification" ;
	String bean_name	=	 "ePH.ATCClassificationBean";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	ATCClassificationBean bean = (ATCClassificationBean)
getBeanObject(bean_id,bean_name ,request);
	if(levelNo.equals("1"))
	bean.clear() ;
	bean.setMode( mode ) ;
	/* Initialize Function specific end */

	/*Variable Declarations start*/
	bean.setLanguageId(locale);
	Vector	values				=	null;
	Vector  records				=	null;
	Enumeration elem_values		=	null;
	Enumeration elem_records	=	null;
	String		code			=	"";
	String		description		=	"";
	String		display_seqno	=	"";
	String		fullDesc		=	"";
	String		count			=	"0";
	String		classValue		=	"";
	String		symbol			=	"";
	String		title			=	"";
	String		prevLevelCode	=	"";
	String		prevLevelDesc	=	"";
	String		calling_func	=	"";
	int		row					=	1;
	int		recno				=	0;
	/*Variable Declarations end*/

	/* Bean method call start
	 Calls the corresponding beans method based on level number */
	prevLevelCode	=	request.getParameter("prev_lvl_code");
	prevLevelDesc	=	request.getParameter("prev_lvl_desc");
	calling_func	=	request.getParameter("called_from");
	if(levelNo.equals("1")) {
	values			=	bean.loadLevelValues(levelNo);
	elem_values	=	values.elements();
	}
	if(levelNo.equals("2") || levelNo.equals("3") || levelNo.equals("4") || levelNo.equals("5")) {
		if (mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) {
		bean.setLevelDetail(levelNo,prevLevelCode,prevLevelDesc); }

	values			=	bean.loadLevelValues(levelNo);
	elem_values		=	values.elements();
	}
/* Bean method calling ends */


	if(!calling_func.equals("generic_atc"))	{
	out.println("<script>showAddLink('"+levelNo+"');</script>");

		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && values.size()==0) {
			out.println("<script>refreshPreviousLevel('"+levelNo+"','"+calling_func+"')</script>");
			return;
		}
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

	if(elem_values !=null) {
	while(elem_values.hasMoreElements())
	{
		records			=	(Vector)elem_values.nextElement();

		elem_records	=	records.elements();

		if(elem_records.hasMoreElements())
		{
		code			=(String) elem_records.nextElement();
		description		=(String) elem_records.nextElement();
		display_seqno	=(String) elem_records.nextElement();

		if(! (levelNo.equals("5")) )
		count			=(String) elem_records.nextElement();
		fullDesc		=	description;
		if(description.length()>=40)
		description		=	description.substring(0,40);

		if(count.equals("0")){
				if(!levelNo.equals("5")) {
					symbol	=	"-";
					title	=(recno+1)+".  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ClicktoaddChildRecords.label","ph_labels");
				}
				else	{
					symbol	= "-";
					title	=(recno+1)+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NoChildRecord.label","ph_labels");
				}
		}
		else {
				symbol	=	"+";
				title	=(recno+1)+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Clicktoview.label","ph_labels")+" "+ count+ " "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ChildRecords.label","ph_labels");
		}

		if ( row % 2 == 0 )
			{
			classValue = "ATCQRYEVEN" ;
			}
		else
			{
			classValue = "ATCQRYODD" ;
			}


	if(calling_func.equals("generic_atc") ) {
			if(count.equals("0") )	{
				symbol = "-";
				title	=(recno+1) +" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NoChildRecord.label","ph_labels");
			}

            _bw.write(_wl_block10Bytes, _wl_block10);
 }	else	{ 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(row));
            _bw.write(_wl_block12Bytes, _wl_block12);
	}
	 if(symbol.equals("+") && !count.equals("0")) { 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(title));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(levelNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(code)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(fullDesc)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_func));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(symbol));
            _bw.write(_wl_block18Bytes, _wl_block18);
	} else if(count.equals("0") && (!calling_func.equals("generic_atc")) && (!levelNo.equals("5"))){ 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(title));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(levelNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(code)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(fullDesc)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_func));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(symbol));
            _bw.write(_wl_block21Bytes, _wl_block21);
	}	else {
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(title));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(levelNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(code)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(fullDesc)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_func));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(symbol));
            _bw.write(_wl_block23Bytes, _wl_block23);
	}	if(calling_func.equals("generic_atc") ) {	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fullDesc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(description));
            _bw.write(_wl_block26Bytes, _wl_block26);
 }	else	{	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(levelNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(code)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(fullDesc)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(display_seqno));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(calling_func));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(fullDesc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(description));
            _bw.write(_wl_block31Bytes, _wl_block31);
	}	
            _bw.write(_wl_block32Bytes, _wl_block32);

		row++;
		recno++;
	}
}

}

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(levelNo));
            _bw.write(_wl_block37Bytes, _wl_block37);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
