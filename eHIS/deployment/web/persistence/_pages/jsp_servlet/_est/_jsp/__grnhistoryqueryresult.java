package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.lang.*;
import java.text.NumberFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __grnhistoryqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/GRNHistoryQueryResult.jsp", 1727695972937L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n<!-- \t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>\n -->\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- \t\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<script language=\"Javascript\" src=\"../../eST/js/StCommon.js\"></script>\n \t\t<!--<script language=\"javascript\" src=\"../../eST/js/StMessages.js\"></script> -->\n<!--\t\t<script language=\"Javascript\" src=\"../../eST/js/ItemMaster.js\"> </script>-->\n\t\t<script language=\"Javascript\" src=\"../../eST/js/GRNHistoy.js\"> </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<form name=\'GRNResultForm\' id=\'GRNResultForm\'>\n\t\t\t<div name=\'msg\' id=\'msg\' style=\"position:absolute;width: 0; height: 0; left: 201; top: 62\">\n\t\t\t</div>\n\t\t\t\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t<tr>\n\t\t\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'tb1\'>\n\t\t\t\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </th>\n\t\t\t\t<th colspan=6> In Purchase UOM </th>\n\t\t\t\t<th colspan=6> In Stock UOM </th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t<th colspan=2 nowrap>In Purchase UOM</th>\n\t\t\t\t<th colspan=2 nowrap>In Stock UOM</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>   <!-- //Added by Padmapriya -->\n\t\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>   <!-- //23925 -->\n\t\t\t<tr>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\n\t\t\t\t<th>UOM</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\n\t\t\t\t<th>UOM</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<th>UOM</th>\n\t\t\t<th>Batch Qty</th>\n\t\t\t<th>UOM</th>\n\t\t\t<th>Batch Qty</th>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\n\t\t\t<td class=\"ITEMSELECT\">&nbsp;</td>\t <!--  //23925  -->\t\t\n\t\t\t\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" \n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\tstyle=\"cursor:pointer\" onClick=\"displayPending(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\" style =\"color=blue\"\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t title= \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"   align=\"center\"><font align = \"center\" size = 1 ><B>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</B></font></td>\n\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t  style =\"color=blue ;cursor:pointer \"  title= \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onClick=\"displayRtvReplPending(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\"  align=\"left\"  style =\"color=blue\"\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t ><font align = \"center\" size = 1 >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;</B></font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"  align=\'left\' onclick=\"disableClick(event);\" nowrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;</td>\n\t\t\t\t<!-- \t\t\t\t\t\n\t\t\t\t\t\t* @Name - Priya\n\t\t\t\t\t\t* @Date - 19/02/2010\n\t\t\t\t\t\t* @Inc# - IN019466\n\t\t\t\t\t\t* @Desc - To right align Unit Cost, Normal Qty, Bonus Quantity, Sample Quantity, GRN Value.\t\t\t\t\n\t\t\t\t\t-->\n\n\t\t\t\t\t<!-- \n\n\t\t\t\t\t\t//Modified by Sakti against inc#49354 swapped item_quantity to item_qty_normal_pur_uom and vice versa\n\t\t\t\t\t-->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"   style=\"TEXT-ALIGN:right\" onclick=\"disableClick(event);\" nowrap>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"  style=\"TEXT-ALIGN:right\" onclick=\"disableClick(event);\" nowrap>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;</td>\n\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"   style=\"TEXT-ALIGN:right\" onclick=\"disableClick(event);\" nowrap title=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;</td><!--Modified by suresh.r on 06-08-2014 against MMS-SCF-0387 added title to display grn_unit_cost_in_stk_uom without fraction-->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp;</td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&nbsp;</td>\n\t\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>   <!-- Added by suresh.r 28-11-2013 against MMS-SCF-0166 -->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>   <!-- Added by suresh.r 28-11-2013 against MMS-SCF-0166 -->\n\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&nbsp;</td>   <!-- //Added by Padmapriya -->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;</td>  <!-- //Added by Padmapriya -->\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"  style=\"TEXT-ALIGN:center\" onclick=\"\" nowrap>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<a href=\"javascript:getFile(\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\')\">View</a>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;</td> <!-- //23925 -->\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t\t<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t<input type=\"hidden\" name=\"displaySize\" id=\"displaySize\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t\t<input type=\"hidden\" name=\"count\" id=\"count\" value=\"1\">\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t//history.go(-1);\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n</body>\n</form>\n<script>activeLink();</script>\n</html>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );
	
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



public String replaceNewLineChar(String message) {
		
		String changed = "";

        changed = message.replaceAll("\n","\\n/");
		changed = changed.replaceAll("\"","\\\"");
		changed = changed.replaceAll("'","\\\\'");	

        return changed;
}
 
   /*  Modified on 5/9/2006  as per TSG request

   public String replaceNewLineChar(String message) {

	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]={"\n","\"","'"};
        String chChar[]={"\\n/","\\\"","\\\'"};

        sb= new StringBuffer(message);
        upper:  for(int i=0;i<sb.length();i++)
                    for(int j=0;j<spChar.length;j++)
                    {
                        if(spChar[j].equals(String.valueOf(sb.charAt(i))))
                        {
                            sb.deleteCharAt(i);
                            sb.insert(i,chChar[j].toCharArray());
							i+=chChar[j].length();
                            continue upper;
                        }
                    }
	}
	catch(Exception e)
	{
		sb.append("Exception@replaceNewLineChar : "+e.toString());
	}
        return sb.toString();
    }*/


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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

23/04/2022	23925			Ramesh Goli		23/04/2022		RAMESH G    	MO-CRF-20171
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String doc_type_code="";
	String sap_doc_type_code="";
	String doc_no="";
	String sap_doc_no="";
	String doc_date="";
	String ext_doc_no = "";
	String po_no="";
	String supp_code="";
	String item_qty_normal="";
	String item_qty_sample="";
	String item_qty_bonus="";
	String replace_on_expiry_yn="";
	String grn_unit_cost_in_pur_uom="";
	String store_code="";
	String classvalue ="" ;      
	String batch_id ="" ;      
	String stlightgreen = "";
	String expiry_date_or_receipt_date = "";
	String grn_val = "";
	String item_code = "";
	String item_desc = "";
	String pur_uom_code = "";
	String item_code_temp = "";
	String doc_no_temp = "";
	String grn_rtv_cnt = "";
	int maxRec = 0;
	int displaySize = 0;
	int start  = 0;
	int end  = 0;
	int count   = 0;
	String sale_price="";   //Added by Padmapriya
	String sale_value="";   //Added by Padmapriya
	String pur_uom_desc = "";//Added by Rabbani #Inc no:43683(ML-BRU-SCF-1029) on 03-OCT-2013
	String batch_item_qty="";   //Added by suresh.r 28-11-2013 against MMS-SCF-0166
	//Added by sakti against EMR# 2390
	String grn_unit_cost_in_stk_uom = "";
	String stk_uom_desc = "";
	String item_qty_normal_pur_uom = "";
	String item_qty_bonus_pur_uom = "";
	String item_qty_sample_pur_uom = "";
	String grn_val_stk_uom  ="";
	String batch_item_qty_pur_uom = "";
	String batch_imageRef = ""; //23925
	String stk_uom_code = "";
	// Added ends
	
	String from			= request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String bean_id = "GRNHistoryBean";
	String bean_name = "eST.GRNHistoryBean";
	GRNHistoryBean bean = (GRNHistoryBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	ArrayList result=new ArrayList();	
	HashMap dataList	= null;
	try{
		/**
			* @Name - Priya
			* @Date - 11/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To display the no of digits after decimal point as given in entity parameter function 
		*/
		int no_of_decimals=bean.getNoOfDecimals();

		/**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
		 int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
	String site_id=bean.getCustomerID();
	String sap_legend="";
	if(site_id.equals("MC")){
		sap_legend="SAP " ;
	
	}

		result=bean.getDataList();
		maxRec=  result.size();
		displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize=Integer.parseInt("12");
		if ( from == null || from =="" )
			start = 0;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null || to ==""){
			end = displaySize ;
		}
		else{
			end = Integer.parseInt( to ) ;	
		}
		if(result.size() > 0 ){
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sap_legend));

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
			
			count	= start;
			int chkCount = 0;
			while ( count < maxRec && count < end)
			{
				dataList = (HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
				
				doc_type_code=CommonBean.checkForNull((String)dataList.get("DOC_TYPE_CODE"));
				doc_no=CommonBean.checkForNull((String)dataList.get("DOC_NO"),"");
				sap_doc_type_code=CommonBean.checkForNull((String)dataList.get("EXT_DOC_TYPE_CODE"),doc_type_code);
				sap_doc_no=CommonBean.checkForNull((String)dataList.get("EXT_DOC_NO"),doc_no);
				doc_date=CommonBean.checkForNull((String)dataList.get("DOC_DATE"));
				 ext_doc_no = CommonBean.checkForNull((String)dataList.get("EXT_DOC_NO"),"");
				po_no=CommonBean.checkForNull((String)dataList.get("PO_NO"),"");
				supp_code=CommonBean.checkForNull((String)dataList.get("SUPP_NAME"),"");
				item_qty_normal=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_NORMAL"),"");
				item_qty_sample=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_SAMPLE"),"");
				item_qty_bonus=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_BONUS"),"");
				replace_on_expiry_yn=CommonBean.checkForNull((String)dataList.get("REPLACE_ON_EXPIRY_YN"),"");
				sale_price=bean.setNumber(bean.checkForNull((String)dataList.get("SALE_PRICE"),"0"),noOfDecimalsForCost);  // Added by Padmapriya 
				sale_value=bean.setNumber(bean.checkForNull((String)dataList.get("SALE_VALUE"),"0"),noOfDecimalsForCost);  // Added by Padmapriya 
			 	batch_item_qty=CommonBean.checkForNull((String)dataList.get("GRN_ITEM_QTY"),"");   //Added by suresh.r 28-11-2013 against MMS-SCF-0166


		
				grn_unit_cost_in_pur_uom=bean.setNumber(bean.checkForNull((String)dataList.get("GRN_UNIT_COST_IN_PUR_UOM"),"0"),noOfDecimalsForCost);
				//Added by sakti unit cost changed to pur_uom cost to stk_uom cost against inc#48949	MMS-SCF-0337
				grn_unit_cost_in_stk_uom=bean.setNumber(bean.checkForNull((String)dataList.get("GRN_UNIT_COST_IN_STK_UOM"),"0"),noOfDecimalsForCost);
				store_code=CommonBean.checkForNull((String)dataList.get("STORE_DESC"),"");
				expiry_date_or_receipt_date=CommonBean.checkForNull((String)dataList.get("EXPIRY_DATE_OR_RECEIPT_DATE"),"");
				batch_id=CommonBean.checkForNull((String)dataList.get("BATCH_ID"),"");
				//grn_val=bean.setNumber(bean.checkForNull((String)dataList.get("GRN_VAL"),"0"),noOfDecimalsForCost);
				grn_val=bean.setNumber(bean.checkForNull((String)dataList.get("GRN_VAL_PUR_UOM"),"0"),noOfDecimalsForCost);
				item_code=CommonBean.checkForNull((String)dataList.get("ITEM_CODE"),"");
				item_desc=CommonBean.checkForNull((String)dataList.get("SHORT_DESC"),"");
				pur_uom_code=CommonBean.checkForNull((String)dataList.get("PUR_UOM_CODE"),"");
				grn_rtv_cnt=CommonBean.checkForNull((String)dataList.get("GRN_RTV_CNT"),"");
				pur_uom_desc = CommonBean.checkForNull((String)dataList.get("PUR_UOM_DESC"));//Added by Rabbani #Inc no:43683(ML-BRU-SCF-1029) on 01-OCT-2013
				//Added by sakti against EMR# 2390
				stk_uom_code = CommonBean.checkForNull((String)dataList.get("DEF_ISSUE_UOM"));
				stk_uom_desc = CommonBean.checkForNull((String)dataList.get("STK_UOM_DESC"));
				grn_val_stk_uom=bean.setNumber(bean.checkForNull((String)dataList.get("GRN_VAL_STK_UOM"),"0"),noOfDecimalsForCost);
				
				if(!pur_uom_code.equals(stk_uom_code)) {
					item_qty_normal_pur_uom=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_NORMAL_PUR_UOM"),"");
					item_qty_sample_pur_uom=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_SAMPLE_PUR_UOM"),"");
					item_qty_bonus_pur_uom=CommonBean.checkForNull((String)dataList.get("ITEM_QTY_BONUS_PUR_UOM"),"");
					batch_item_qty_pur_uom=CommonBean.checkForNull((String)dataList.get("GRN_ITEM_QTY_PUR_UOM"),"");
				}else{
					item_qty_normal_pur_uom = item_qty_normal;
					item_qty_sample_pur_uom = item_qty_sample;
					item_qty_bonus_pur_uom = item_qty_bonus;
					batch_item_qty_pur_uom = batch_item_qty;
				}
				batch_imageRef =CommonBean.checkForNull((String)dataList.get("IMAGE_REF"),""); //23925
				//Added ends
				if(!locale.equals("en"))
				{
				doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
				expiry_date_or_receipt_date=com.ehis.util.DateUtils.convertDate(expiry_date_or_receipt_date,"DMY","en",locale);
				}else 
				{
				doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
				expiry_date_or_receipt_date=com.ehis.util.DateUtils.convertDate(expiry_date_or_receipt_date,"DMY","en",locale);
				}
				
				stlightgreen = classvalue;
				String tool ="";
				String description = "";
				String finalized_yn = (String)dataList.get("FINALIZED_YN");
				String rtv_dtl = (String)dataList.get("RTV_DTL");
				int flag = 0;
				String dispflag = "";
				if ((finalized_yn).equals("Y")&& (rtv_dtl.equals("0"))) 
					{
							stlightgreen = "STLIGHTCREAM";
							tool = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalized.label","common_labels");
							description = "F";
				}
				else if (finalized_yn.equals("N"))
					{
						stlightgreen = "STLIGHTCREAM";
						tool =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnFinalized.label","common_labels");
						description ="U";												
					}				
				else if((finalized_yn).equals("Y") && (! rtv_dtl.equals("0")))
				{
						stlightgreen = "STLIGHTCREAM";
						tool =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.FinalizedandRTVExists.label","st_labels");
						description ="R";
						flag = 1;
				}
				dispflag = "N";
				if( !item_code_temp.equals((String)dataList.get("ITEM_CODE")))
				{
						item_code_temp = (String)dataList.get("ITEM_CODE") ;
						doc_no_temp = "";
						out.println("<tr><td class='ITEMSELECT' align='left' colspan='29' <th>Item Code :</th><b>"+item_code_temp+"</b>"+             com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels") +": <b>"+item_desc+"</b>  "+            com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")  +": <b>"+stk_uom_desc+"</b></td></tr>");
				}

				if( !doc_no_temp.equals((String)dataList.get("DOC_NO")))
				{
						dispflag = "Y";
						doc_no_temp = (String)dataList.get("DOC_NO") ;
				}
		
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(stlightgreen));
            _bw.write(_wl_block19Bytes, _wl_block19);
	String tool_tip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ReplacementGRN.label","st_labels");
					if (flag == 1) 
					{
					 if (dispflag.equals("Y"))
						{
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(doc_no));
            _bw.write(_wl_block22Bytes, _wl_block22);

						}}
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tool));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(description));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block19Bytes, _wl_block19);

					if (Integer.parseInt(grn_rtv_cnt)!=0) 
					{
				
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(tool_tip));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(doc_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
				
            _bw.write(_wl_block29Bytes, _wl_block29);
if(site_id.equals("MC")){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((dispflag=="Y"?sap_doc_type_code+"/"+sap_doc_no:"")));
            _bw.write(_wl_block31Bytes, _wl_block31);
 }else{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((dispflag=="Y"?doc_type_code+"/"+doc_no:"")));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((dispflag=="Y"?doc_date:"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((dispflag=="Y"?ext_doc_no:"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((dispflag=="Y"?po_no:"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((dispflag=="Y"?supp_code:"")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(pur_uom_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_normal,"0"),no_of_decimals):"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_bonus,"0"),no_of_decimals):"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_sample,"0"),no_of_decimals):"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((dispflag=="Y"?grn_unit_cost_in_pur_uom:"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((dispflag=="Y"?grn_val:"")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(stk_uom_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_normal_pur_uom,"0"),no_of_decimals):"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_bonus_pur_uom,"0"),no_of_decimals):"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((dispflag=="Y"?bean.setNumber(bean.checkForNull((String)item_qty_sample_pur_uom,"0"),no_of_decimals):"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( dataList.get("GRN_UNIT_COST_IN_STK_UOM")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((dispflag=="Y"?grn_unit_cost_in_stk_uom:"")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((dispflag=="Y"?grn_val_stk_uom:"")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((dispflag=="Y"?store_code:"")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(expiry_date_or_receipt_date));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(batch_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(replace_on_expiry_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(pur_uom_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(batch_item_qty));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(stk_uom_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(batch_item_qty_pur_uom));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sale_price));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sale_value));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block49Bytes, _wl_block49);
if(!"".equals(batch_imageRef)){
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(batch_imageRef));
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);

				count++;
			chkCount++;
			}
	
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(start));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(end));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(result.size()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(displaySize));
            _bw.write(_wl_block57Bytes, _wl_block57);

			out.flush();
		} else{
		
            _bw.write(_wl_block58Bytes, _wl_block58);

		}
} catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block59Bytes, _wl_block59);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.DocType/No.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ExtRefNo.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.PONo.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Supplier.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchID.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.Replonexpiry.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SalePrice.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SaleValue.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Document.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.NormalQty.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BonusQuantity.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SampleQuantity.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitCost.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.GRNValue.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.NormalQty.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.BonusQuantity.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.SampleQuantity.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UnitCost.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.GRNValue.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }
}
