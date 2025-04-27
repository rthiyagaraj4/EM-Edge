package jsp_servlet._ess._jsp;

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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __kititemsearchqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/KitItemSearchQueryResult.jsp", 1709121810149L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title></title>\n<!-- \t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>\n -->\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<!--<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t\t<script language=\"Javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<!--<script language=\"javascript\" src=\"../../eST/js/StMessages.js\"></script> -->\n\t\t\t<script language=\"Javascript\" src=\"../../eST/js/ItemSearch.js\"> </script>\n\t\t\t<script language=\"Javascript\" src=\"../../eST/js/Item.js\"> </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<form name=ItemsearchForm>\n\t\t\t<div name=\'msg\' id=\'msg\' style=\"position:absolute;width: 0; height: 0; left: 201; top: 62\">\n\t\t\t</div>\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\"  align=center>\n\t\t\t<tr>\n\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  id=\'tb1\'>\n\t\t\t<td width=\'3%\'  class=\'CAGROUP_HEADING\'><b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td>\n\t\t\t<td width=\'3%\'  class=\'CAGROUP_HEADING\'><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></td>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>\n\t\t\t\t\tkitReturnVals(\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\",\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<tr onClick=\"kitReturnVals(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\" >\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"   onmouseover=\"changeCursor(this);\"   onMouseout=\"onMOut(msg);\" nowrap><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font></td>\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"   onclick=\"disableClick(event);\" nowrap >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t</tr> \n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"item_code\" id=\"item_code\" >\n\t\t\t<input type=\"hidden\" name=\"short_desc\" id=\"short_desc\" >\n\t\t\t<input type=\"hidden\" name=\"store_desc\" id=\"store_desc\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<input type=\"hidden\" name=\"alpha_code\" id=\"alpha_code\" >\n\t\t\t<input type=\"hidden\" name=\"machine_code\" id=\"machine_code\" >\n\t\t\t<input type=\"hidden\" name=\"spare_part_id\" id=\"spare_part_id\" >\n\t\t\t<input type=\"hidden\" name=\"start\" id=\"start\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<input type=\"hidden\" name=\"end\" id=\"end\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\"\t\tvalue=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t<input type=\"hidden\" name=\"displaySize\" id=\"displaySize\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t<input type=\"hidden\" name=\"count\" id=\"count\"\t\t\t\t value=\"1\">\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t <script>\n\t\t\t\t\t/*if(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'==\"IC\" && ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="==true){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tchangeRadVal();\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t*/\t\t\t\t\t\t\t\n\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t\t\t\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\tparent.qryCriteria.document.ItemSearchCriteria_Form.next.disabled=true;\t\t\t\t\t\t\n\t\t\t\t\t\tparent.qryCriteria.document.ItemSearchCriteria_Form.previous.disabled=true;\n\t\t\t\t\t//}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</body>\n</form>\n<script>activeLink();</script>\n</html>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );
	
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
		String changed			=		"";
        changed					=		 message.replaceAll("\n","\\n/");
		changed					=		 changed.replaceAll("\"","\\\"");
		changed					=		 changed.replaceAll("'","\\\\'");	
        return changed;
}
 /*/ Modified on 5/9/2006  as per TSG request
   public String replaceNewLineChar(String message) {
	StringBuffer sb= new StringBuffer();
    try
	{
        String spChar[]={"\n","\"","'"};
        String chChar[]={"\\n/","\\\"","\\\'"};
        sb= new StringBuffer(message);
        upper:  for(int i=0;i<sb.length();i++)
					{
                    for(int j=0;j<spChar.length;j++)
                    {
                        if(spChar[j].equals(String.valueOf(sb.charAt(i))))
                        {
                            sb.deleteCharAt(i);
                            sb.insert(i,chChar[j].toCharArray());
							i+=chChar[j].length();
							System.err.println("J="+j+" =="+sb);
                            continue upper;
                        }
                    }
System.err.println("i="+i+" =="+sb);
					}
	}
	catch(Exception e)
	{
		sb.append("Exception@replaceNewLineChar : "+e.toString());
	}
	System.err.println("Return string="+sb.toString());
        return sb.toString();
    } */


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
            _bw.write(_wl_block6Bytes, _wl_block6);

			 request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
	String kit_template_code			=			"";
	String classvalue					=			"";
/*String curr_supp_code				=			"";
	String uom_desc						=			"";
	String manufacture_desc				=			"";
	String min_stk_qty					=			"";
	String max_stk_qty					=			"";
	String long_desc					=			"";
	String ps_item_yn					=			"";
	String sole_source_yn				=			"";
	String manufacturer_id				=			"";
	String gen_uom_code					=			"";
	String unit_cost					=			"";
	String mfg_item_yn					=			"";
	String medical_item_yn				=			"";
	String abc_class_code				=			"";
	String machine_code					=			"";
	String spare_part_id				=			"";
	String trade_id_applicable_yn		=			"";
	String batch_id_applicable_yn		=			"";
	String expiryyn						=			"";
	String item_code					=			"";
	String item_name					=			"";
	String item_class					=			"";
	String alpha_code					=			"";
	String consignment					=			"";
	String preparation_type				=			"";
	String preparation_mode				=			"";
	String str_uom_code					=			"";
	String gen_uom_desc					=			"";*/

	int maxRec							=			0; 
	int start							=			0;
	int end								=			0;
	int displaySize						=			0;
	int count							=			0;

	String from							=			request.getParameter( "from" )==null?"":request.getParameter( "from" ) ;
	String to							=			request.getParameter( "to" )==null?"":request.getParameter( "to" ) ;
	String radioval						=			request.getParameter( "radioval" )==null?"IC":request.getParameter( "radioval" ) ;
	String bean_id						=			 "ItemSearchBean";
	String bean_name					=			 "eST.ItemSearchBean";
	ItemSearchBean bean					=			(ItemSearchBean) getBeanObject( bean_id,bean_name,request);
	
	String store_desc					=			CommonBean.checkForNull(bean.getStore_desc(),"");

	String store_code					=			CommonBean.checkForNull(bean.getStore_code(),"");
	//String item_class_code				=			CommonBean.checkForNull(bean.getItem_class(),"");
	
	
	store_desc							=			store_desc.equals("%")?"":store_desc;
	store_code							=			store_code.equals("%")?"":store_code;
	bean.setLanguageId(locale);
//String search_string					=			bean.getSearch_string();
	boolean search						=			bean.getSearch() ;
	
	//if(radioval=="IC")search			=			true;
	ArrayList result					=			new ArrayList();	
	HashMap dataList					=			null;
	try{
		result							=			bean.getKitDataList();
		//System.out.println("result@@==>"+result);
		maxRec							=			result.size();
		displaySize						=			Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
		displaySize						=			Integer.parseInt("12");
		if ( from == null || from =="" )
			start						=			0;
		else
			start						=			Integer.parseInt( from ) ;
		if ( to == null || to ==""){
			end							=			displaySize ;
		}
		else{
			end							=			 Integer.parseInt( to ) ;	
		}
		if(result.size() > 0 ){
		
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

			count	= start;
			int chkCount = 0;
			while ( count < maxRec && count < end)
			{
				dataList = (HashMap)result.get(count);
				if ( count % 2 == 0 )
					classvalue		=			"QRYEVEN" ;
				else
					classvalue		=			 "QRYODD" ;
	
				kit_template_code	=	CommonBean.checkForNull((String)dataList.get("KIT_TEMPLATE_CODE"),"");
				String kit = "kit";
				if(maxRec==1){
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(kit));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(kit_template_code));
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(kit));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kit_template_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)dataList.get("KIT_TEMPLATE_CODE")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((String)dataList.get("KIT_TEMPLATE_DESC")));
            _bw.write(_wl_block21Bytes, _wl_block21);

				count++;
			chkCount++;
			}
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bean.getStore_desc()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(start));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(end));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(result.size()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(displaySize));
            _bw.write(_wl_block27Bytes, _wl_block27);

			out.flush();
		} else{
		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(radioval));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(search));
            _bw.write(_wl_block30Bytes, _wl_block30);

		}
	} catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block31Bytes, _wl_block31);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.KitTemplateCode.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.KitTemplateDescription.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
