package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.util.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentrypreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryPreview.jsp", 1709119822000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!--\n    New File Added to take care of the Line Level Order Format\n-->\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n    <head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<!--IN064543--><script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryPreview.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n \t\t<style></style>\n\t<script>\n\t// could not avoid to use the dialog Arguments...\n\t/*onLoad=\'doInit();\'function doInit()\n\t{\n\t\tvar txtArr \t= parent.parent.dialogArguments; \n\t\tvar str \t= \'\';\n\t\tfor (y=0;y<txtArr.length;y++)\n\t\t\tstr \t= str + txtArr[y]; \n\t\tdocument.write(str);\n\t}\t\n\t*/\n\t</script>\n\t</head>\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<table width=\'100%\' border=\'0\' cellspacing=\'2\' cellpadding=\'3\' align=center height=\'auto\'>\n\t<tr>\n\t\t<td class=\"BODYCOLORFILLED\"   colspan=5 width=\"auto\"><b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td>\n\t\t<td align=\"right\" class=\'BODYCOLORFILLED\'  width=\'auto\'><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td>\n\t</tr>\n\t<tr><td colspan=5 class=\'BODYCOLORFILLED\'  width=\'auto\'></td></tr>\n\t<tr><td colspan=5 class=\'BODYCOLORFILLED\'  width=\'auto\'></td></tr>\n\t\n\t\t<table CLASS=\"BOX\" width=\'100%\' border=\'0\' cellspacing=\'2\' cellpadding=\'3\' align=center height=\'auto\'>\n\t\t\t<tr><td colspan=4 class=\'PATQRED\'   width=\'auto\'><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></td></tr>\n\t\t\t<tr><td colspan=4 class=\'BODYCOLORFILLED\'><hr style=\'color=black\' size=\'1\'></td></tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'BODYCOLORFILLED\'  \twidth=\'auto\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b>\n\t\t\t\t</td>\n\t\t\t\t<!--<td  colspan=3 class=\'BODYCOLORFILLED\'  width=\'auto\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =",";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" \n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\t-->  <!--IN058811 removed colspan-->\n\t\t\t\t<td  class=\'BODYCOLORFILLED\'  width=\'auto\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</td>\n\t\t\t\t<!--IN058811 Starts -->\n\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td></b>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="     \n\t\t\t\t</td> \n\t\t\t\t<!--IN058811 End -->\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</b>\n\t\t\t\t</td>\n\t\t\t\t<td class=\'BODYCOLORFILLED\' width=\'auto\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td  class=\'BODYCOLORFILLED\'  width=\'auto\' valign=top nowrap><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b>\n\t\t\t\t</td>\n\t\t\t\t<td  colspan=3 class=\'BODYCOLORFILLED\'  width=\'auto\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=4 class=\'BODYCOLORFILLED\'><hr style=\'color=black\' size=\'1\'>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<table CLASS=\"BOX\" width=\'100%\' border=\'0\' cellspacing=\'2\' cellpadding=\'3\' align=center height=\'auto\'>\n\t\t<tr>\n\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</b></td>\n\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</b>\n\t\t\t</td>\n\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</b>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=5 class=\'BODYCOLORFILLED\'><hr style=\'color=black\' size=\'1\'>\n\t\t\t</td>\n\t\t</tr>\t\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<tr>\n\t\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" </b></td>\n\t\t\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' colspan=2>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'BODYCOLORFILLED\' colspan=2  width=\'auto\'>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\t\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'BODYCOLORFILLED\'  width=\'auto\' nowrap><b>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</b>\n\t\t\t\t\t</td>\n\t\t\t\t\t\t<!--IN064543 start-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t<td class=\'BODYCOLORFILLED\' colspan=4 width=\'auto\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t<td name=\"cat_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" class=\'BODYCOLORFILLED\' colspan=4 width=\'auto\'><a class=\"IMAGELINK\" href=\"javascript:showPreviewEditorInstrn(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\',\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\')\"><b>View</b></a></td><!--IN068445-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t<!--IN064543 end-->\t\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr><td colspan=5 class=\'BODYCOLORFILLED\'></td></tr>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t</table>\n\t\t<tr><td colspan=5 class=\'BODYCOLORFILLED\'><hr style=\'color=black\' size=\'1\'></td></tr>\n\t\t<br><br><br><br>\n\t</table>\n\t<!--IN068445 START-->\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<!--IN068445 END-->\t\t\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );
	
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



/*Added by Uma on 5/4/2010 for IN021062*/
private String decodeLocal(String field,String objVal,PageContext pageContext)
{
	String returntext="";
	if(objVal.trim().equalsIgnoreCase(""))
	{
		return	"";
	}
	if(field.equalsIgnoreCase("priority"))
	{
		if(objVal.equalsIgnoreCase("R"))
		{			
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");	
		}
		else if(objVal.equalsIgnoreCase("U"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		}
		else if(objVal.equalsIgnoreCase("S"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
		}
	}
	else if(field.equalsIgnoreCase("sex"))
	{
		if(objVal.equalsIgnoreCase("M"))
		{			
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");	
		}
		else if(objVal.equalsIgnoreCase("F"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}
		//IN039587 Starts
		else if(objVal.equalsIgnoreCase("U"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		//IN039587 Ends
	}
	else if(field.equalsIgnoreCase("duration"))
	{
		if(objVal.equalsIgnoreCase("M"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
		}
		else if(objVal.equalsIgnoreCase("H"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
		}
		else if(objVal.equalsIgnoreCase("D"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Day(s).label","or_labels");
		}
		else if(objVal.equalsIgnoreCase("W"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Week(s).label","or_labels");
		}
		else if(objVal.equalsIgnoreCase("L"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Month(s).label","or_labels");
		}
		else 
		{
			returntext = "";
		}
	}
	else
	{
		return "";
	}
	if((returntext.length()>0)&&(returntext!=null))
		return returntext;
	else
		return "";
}
/*Ends Here by Uma on 5/4/2010 for IN021062*/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
-------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
08/10/2013		IN041268 		Vijayakumar K	REGRESSION-Alpha-OR-System is displaying special character in the Order Preview Screen
24/3/2016		IN058811		Raja S			24/03/2016		Ramesh G		MO-CRF-20107 :National ID to be captured in any orderable (ALL 																				Order Categories) is a national requirement.
17/07/2018		IN064543		Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
22/07/2018		IN068445		Kamalakannan	22/07/2018		Ramesh G		ML-MMOH-CRF-0776				
-------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);


    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 		= request.getParameter("bean_id");
	String bean_name 	= request.getParameter("bean_name");
	/* Initialize Function specific start */
	//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);
	OrderEntryBean bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to 	the bean to get the connection if using the query bean and not the functional bean 
	//IN041268 starts
	//String facility_name 			= bean.checkForNull(request.getParameter("facility_name"),"");
	String facility_name 			= URLDecoder.decode(bean.checkForNull(request.getParameter("facility_name"),""), "utf-8");
	//IN041268 ends
	String sys_date 				= bean.checkForNull(request.getParameter("sys_date"),"");

	//System.err.println("sys_date==========================="+sys_date);
	String patient_id 				= bean.checkForNull(request.getParameter("patient_id"),"");
	String encounter_id 			= bean.checkForNull(request.getParameter("encounter_id"),"");
	String physician_name 			= bean.checkForNull(request.getParameter("physician_name"),"");
	String order_date_time 			= bean.checkForNull(request.getParameter("order_date_time"),"");
	String sex 						= bean.checkForNull(request.getParameter("sex"),"");
	String age 						= bean.checkForNull(request.getParameter("age"),"");
	String dob 						= bean.checkForNull(request.getParameter("dob"),"");
	String order_id 				= bean.checkForNull(request.getParameter("order_id"),"");
	String ammend_called_from 				= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String nationality			 = "";
   	String patient_name			 = "";
	String national_id			 = "";  //IN058811
	int cnt=0;//IN068445
	ArrayList Nationality  = bean.getNationality(patient_id);// Get the Nationality Desc
   	if(Nationality!=null && Nationality.size() > 0)
   	{
   	    nationality = (String)Nationality.get(0);
   	    patient_name     = (String)Nationality.get(1); // Get the patient_name
		national_id	     = (String)Nationality.get(2); //IN058811
   	}
	String location_type			 = bean.checkForNull(bean.getLocationType(),"");
   	String location_code			 = bean.checkForNull(bean.getLocationCode(),"");
   	String location_name			 = "";
	ArrayList locn_dtls			 = new ArrayList();
	locn_dtls			 = bean.getLocationName(location_type,location_code);
	if(locn_dtls.size()>0)
	{
		for(int dtls=0;dtls<locn_dtls.size();dtls++)
		{
			String location=(String)locn_dtls.get(dtls);
			dtls++;
			String source_type       =(String)locn_dtls.get(dtls);
			if(source_type.equalsIgnoreCase("C"))
			{								
				source_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(source_type.equalsIgnoreCase("N"))
			{
				source_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}else if(source_type.equalsIgnoreCase("R"))
			{
				source_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}
			else if(source_type.equalsIgnoreCase("D"))
			{
				source_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
			}
			location_name = source_type+" / "+location;
		}

	}

	//System.err.println("dob"+dob);
	//String nationality 				= bean.checkForNull(request.getParameter("nationality"),"");
		
//	String location_type 			= bean.checkForNull(request.getParameter("location_type"),"");
//	String location_code 			= bean.checkForNull(request.getParameter("location_code"),"");
	//String location_name 			= bean.checkForNull(request.getParameter("location_name"),"");
	//String patient_name 			= bean.checkForNull(request.getParameter("patient_name"),"");
	String priority 				= bean.checkForNull(request.getParameter("priority"),"");	
	/*Added by Uma on 5/4/2010 for IN021062*/
	//String order_id 				= bean.checkForNull(request.getParameter("order_id"),"");
	if(priority.equalsIgnoreCase("R")||priority.equalsIgnoreCase("U")||priority.equalsIgnoreCase("S"))
	{			
		priority = (String)decodeLocal("priority",priority,pageContext);
	}
	/*Ends Here by Uma on 5/4/2010 for IN021062*/
	int total_rows 					= Integer.parseInt(bean.checkForNull(request.getParameter("total_rows"),"0"));
	String order_category			= bean.checkForNull(request.getParameter("order_category"),"");
	StringBuffer comments 			= new StringBuffer();
	// From the bean for header level clinical comments
	if(ammend_called_from.equalsIgnoreCase("existing_order"))
	{		
		if(bean.getAmendClinicalComments().length() > 0 )
		{
			comments = new StringBuffer();
			comments.append(bean.getAmendClinicalComments());		
		}
		else
		{
			comments = new StringBuffer();
			comments.append(bean.getAmendComments(order_id));
		}
	}
	else
	{		
		comments				= (StringBuffer)orderEntryRecordBean.getOrderFormats(order_category+"_CLINICALCOMMENTS",order_category+"_CLINICALCOMMENTS_0");
	}
	if(comments==null)
	{		
		comments 				= new StringBuffer();
	}
   //Header level ccomments
	// Till here	

	// Multi Patient Logic
	int count_patient				= 1;
	String record[]					= null;
	String record_patient[]			= null;
//	String pat_id					= null;
	ArrayList multi_patient			= bean.getMultiPatientDetails();  // Get the Multi Patient Orders Details
	if(multi_patient!=null && multi_patient.size() > 0)			  // Only If it is for Multi Patients
		count_patient				= multi_patient.size();			  // Else it will be 1 patient by default
	// Till here Multi Patient Logic	
	String performing_arr[] 		= new String [total_rows];
	String order_type_arr[] 		= new String [total_rows];
	String priority_arr[] 			= new String [total_rows];
	String instrn_content_type[]	= new String [total_rows];//IN064543
	String frequency_arr[]	 		= new String [total_rows];
	String frequency_desc_arr[]		= new String [total_rows];
	String duration_value_arr[]		= new String [total_rows];
	String ord_spl_appr_arr[] 		= new String [total_rows];
	String performing_dept_arr[]	= new String [total_rows];
	String catalog_code_arr[]		= new String [total_rows];
	String start_date_arr[] 		= new String [total_rows];
	String catalog_desc_arr[] 		= new String [total_rows];
	String priority_desc_arr[]		= new String [total_rows];
	String end_date_time_arr[]		= new String [total_rows];
	String duration_desc_arr[]		= new String [total_rows];
	String order_type_desc_arr[]	= new String [total_rows];
	String line_comment_arr[]		= new String [total_rows];
	String specimen_type_arr[]		= new String [total_rows];
	String nurse_collect_arr[]		= new String [total_rows];
	String appt_reqd_arr[]			= new String [total_rows];
	String chart_result_type[]		= new String [total_rows];
			
	String grouping					= "";
	String tree_grouping 			= "";
	String line_comment				= "";
	String nurse_collect			= "";
	String specimen_type			= "";
	TreeMap sorted_group	 		= new TreeMap();
	HashMap	hash_map				= new HashMap();	
	Set sorted_set 					= null;
	Iterator itr_map 				= null;
	ArrayList arrSeqNo				= null;
	Hashtable template    			= new Hashtable(); //new java.util.Hashtable(); 
	ArrayList PatientDtls			= null;
	int count						= 1;
	int seq_num     		  		= 0, grouping_seq_no = 0;
	String split_grouping			= "";
	String priority_desc			= "";
	String duration_desc			= "";
	for(int i=0;i<total_rows;i++)
	{	
		performing_arr[i]			= bean.checkForNull(request.getParameter("performing_facility_id"+i),"");	
		order_type_arr[i]			= bean.checkForNull(request.getParameter("order_type_code"+i),"");	
		priority_arr[i]				= bean.checkForNull(request.getParameter("priority"+i),"");	
		instrn_content_type[i]				= bean.checkForNull(request.getParameter("instrn_content_type"+i),"T");	//IN064543
		/*Added by Uma on 5/4/2010 for IN021062*/
		priority_desc				= bean.checkForNull(request.getParameter("priority_desc"+i),"");
		if(priority_desc.equalsIgnoreCase("R")||priority_desc.equalsIgnoreCase("U")||priority_desc.equalsIgnoreCase("S"))
		{			
			priority_desc = (String)decodeLocal("priority",priority_desc,pageContext);
		}
		//priority_desc_arr[i]		= bean.checkForNull(request.getParameter("priority_desc"+i),"");	
		/*Ends Here by Uma on 5/4/2010 for IN021062*/
		priority_desc_arr[i]		= priority_desc;	
		ord_spl_appr_arr[i]			= bean.checkForNull(request.getParameter("ord_spl_appr_reqd_yn"+i),"");
		catalog_code_arr[i]			= bean.checkForNull(request.getParameter("catalog_code"+i),""); 	
		frequency_arr[i]			= bean.checkForNull(request.getParameter("frequency"+i),"");
		frequency_desc_arr[i]		= bean.checkForNull(request.getParameter("frequency_code_arr"+i),"");
		start_date_arr[i]			= bean.checkForNull(request.getParameter("start_date_time"+i),"");	
		duration_value_arr[i]		= bean.checkForNull(request.getParameter("duration_value"+i),"");	
		performing_dept_arr[i]		= bean.checkForNull(request.getParameter("performing_dept_loc_code"+i),"");
		catalog_desc_arr[i]			= bean.checkForNull(request.getParameter("cat_desc"+i),"");
		end_date_time_arr[i]		= bean.checkForNull(request.getParameter("end_date_time"+i),"");
		//duration_desc_arr[i]		= bean.checkForNull(request.getParameter("duration_desc"+i),"");
		duration_desc				= bean.checkForNull(request.getParameter("duration_desc"+i),"");
		if(duration_desc.equalsIgnoreCase("M")||duration_desc.equalsIgnoreCase("H")||duration_desc.equalsIgnoreCase("D")||duration_desc.equalsIgnoreCase("W")||duration_desc.equalsIgnoreCase("L"))
		{			
			duration_desc = (String)decodeLocal("duration",duration_desc,pageContext);
		}
		duration_desc_arr[i]		= duration_desc;
		order_type_desc_arr[i]		= bean.checkForNull(request.getParameter("order_type_desc"+i),"");
		appt_reqd_arr[i]			= bean.checkForNull(request.getParameter("appt_reqd_yn"+i),"");
		chart_result_type[i]		= bean.checkForNull(request.getParameter("chart_result_type"+i),"");		
		arrSeqNo					= (ArrayList) orderEntryRecordBean.getOrderFormats("Comments"+catalog_code_arr[i], catalog_code_arr[i]);
		if(arrSeqNo!=null && arrSeqNo.size()>0)
		{
		  		line_comment 		=  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
		}
		line_comment_arr[i]			= line_comment;
		
		nurse_collect				= "N"; specimen_type = "";
		arrSeqNo        			= (ArrayList) orderEntryRecordBean.getOrderFormats(catalog_code_arr[i], catalog_code_arr[i]+"_0");
		if(arrSeqNo!= null && arrSeqNo.size() >0)
		{
		   for(int k=0;k<arrSeqNo.size();k++)
		   {
		      seq_num   	 		= Integer.parseInt((String)arrSeqNo.get(k));//((Integer)arrSeqNo.get(k)).intValue(); // get the seq_num
		      template 				 = (Hashtable)  orderEntryRecordBean.getOrderFormats ( catalog_code_arr[i], (catalog_code_arr[i]+seq_num) );
		      if( template!=null && (((String) template.get("field_mnemonic")).equalsIgnoreCase("SPECIMEN_TYPE")) ) // System Defined cannot be changed
		      	specimen_type 		= bean.checkForNull((String) template.get("field_values"),"");
		      else if(template!=null && (((String) template.get("field_mnemonic")).equalsIgnoreCase("NURSE_COLLECT_YN")) ) // System Defined cannot be changed
		        nurse_collect 		= bean.checkForNull((String) template.get("field_values"),"N");
		  }  // End of for  
	  } // End of if called_from
 		if(appt_reqd_arr[i].equals("Y")) {
			grouping_seq_no++;
			split_grouping = bean.checkForNull(bean.splitGroupingOrders(grouping_seq_no),"000"); // call a method to get the split_grouping like "000" or "001" etc
		} else if(chart_result_type[i].equals("Y")) {
			grouping_seq_no++;
			split_grouping = bean.checkForNull(bean.splitGroupingOrders(grouping_seq_no),"000"); //call a method to get the split_grouping like "000" or "001" etc 
		} else split_grouping = "000";
 
	  specimen_type_arr[i]			= specimen_type;
	  nurse_collect_arr[i]			= nurse_collect;
 	 			grouping 			= performing_arr[i]+order_type_arr[i]+ priority_arr[i]+ord_spl_appr_arr[i]+specimen_type_arr[i]+nurse_collect_arr[i]+start_date_arr[i]+frequency_arr[i]+duration_value_arr[i]+performing_dept_arr[i]+split_grouping;
			    sorted_group.put(grouping,grouping);
 			    hash_map.put("ORDER_TYPE"+grouping,(String)order_type_desc_arr[i]);
			
	 } // End of total_rows

            _bw.write(_wl_block1Bytes, _wl_block1);

	for(int k=0;k<count_patient;k++)		// For the No of patients
	{ 
		if(multi_patient!=null && multi_patient.size() > 0)
		{
			record					= (String[]) multi_patient.get(k);
			patient_id				= bean.checkForNull(record[0],""); //patient_id
			encounter_id			= bean.checkForNull(record[1],""); //encounterid
			Nationality				= bean.getNationality(patient_id);
			if(Nationality!=null && Nationality.size() > 0)
		   	{
   				nationality			= (String)Nationality.get(0);
		   	    patient_name		= (String)Nationality.get(1); // Get the patient_name
				national_id			= (String)Nationality.get(2); //IN058811
   			}	
			PatientDtls				= beanQueryObj.getAgeSexDtls(properties, patient_id); // Get the sex,age and date_of_birth
			for(int i=0; i<PatientDtls.size(); i++)	// Only one record
			{	
				record_patient		= (String[])PatientDtls.get(i);
				sex	 				= record_patient[0];
				dob 	 			= record_patient[1];
				age 	 			= record_patient[2];
			}
		}  // End of multi_patient != null
	sex = (String)decodeLocal("sex",sex,pageContext);
	sorted_set 		= (Set)sorted_group.keySet();
	itr_map 		= (Iterator)sorted_set.iterator() ;
	while(itr_map.hasNext()){
		count		= 1;	
		tree_grouping = (String)itr_map.next();


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(hash_map.get("ORDER_TYPE"+tree_grouping)));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(order_date_time));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(physician_name));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(age));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(age));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dob,"DMY","en",localeName)));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(national_id));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(location_name));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(comments));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
		grouping_seq_no = 0;// reinitialize
		for(int i=0;i<total_rows;i++)
		{
			if(appt_reqd_arr[i].equals("Y")) {
				grouping_seq_no++;
				split_grouping = bean.checkForNull(bean.splitGroupingOrders(grouping_seq_no),"000"); // call a method to get the split_grouping like "000" or "001" etc
			} else if(chart_result_type[i].equals("Y")) {
				grouping_seq_no++;
				split_grouping = bean.checkForNull(bean.splitGroupingOrders(grouping_seq_no),"000"); // call a method to get the split_grouping like "000" or "001" etc
			} else split_grouping = "000";

			grouping 		= performing_arr[i]+order_type_arr[i]+ priority_arr[i]+ord_spl_appr_arr[i]+specimen_type_arr[i]+nurse_collect_arr[i]+start_date_arr[i]+frequency_arr[i]+duration_value_arr[i]+performing_dept_arr[i]+split_grouping;
 			if(grouping.equals(tree_grouping) )
			{

            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count++));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(catalog_desc_arr[i]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(priority_desc_arr[i]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(start_date_arr[i]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(end_date_time_arr[i]));
            _bw.write(_wl_block35Bytes, _wl_block35);
				if(!frequency_arr[i].equals("")) { 
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(frequency_desc_arr[i]));
            _bw.write(_wl_block38Bytes, _wl_block38);
					if(!duration_value_arr[i].equals("")) { 
						out.println(duration_value_arr[i]);
					}	
            _bw.write(_wl_block39Bytes, _wl_block39);
					if(!duration_desc_arr[i].equals("")) { 
						out.println(duration_desc_arr[i]);
					} 
            _bw.write(_wl_block40Bytes, _wl_block40);
				} 
            _bw.write(_wl_block41Bytes, _wl_block41);
				if(!line_comment_arr[i].equals("")) {  
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
if("T".equals(instrn_content_type[i])){ 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(line_comment_arr[i]));
            _bw.write(_wl_block45Bytes, _wl_block45);
}else if("E".equals(instrn_content_type[i])){ 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(catalog_code_arr[i]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(catalog_desc_arr[i]));
            _bw.write(_wl_block49Bytes, _wl_block49);
}
					} 
            _bw.write(_wl_block50Bytes, _wl_block50);
  
			cnt++;//IN068445
		} // End of if grouping	
	 }	
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block53Bytes, _wl_block53);
	} // End of while itr_map
} //  End of count_patient
	Nationality		= null;		// Nullifying the objects
	PatientDtls		= null;
	template		= null;
	hash_map		= null;
	sorted_set 		= null;
	itr_map 		= null;
	arrSeqNo 		= null;		// Nullifying the objects
	multi_patient	= null;
	sorted_group	= null;
	hash_map		= null;
	//comments.setLength(0);	

	// no need to set it back persistence
	//putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id,bean,request);	//IN068445

            _bw.write(_wl_block54Bytes, _wl_block54);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderRequestfor.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderNo.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Tobegenerated.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateofBirth.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NationalId.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderLocation.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SerialNo.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CatalogName.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startdatetime.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddatetime.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CatalogComments.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }
}
