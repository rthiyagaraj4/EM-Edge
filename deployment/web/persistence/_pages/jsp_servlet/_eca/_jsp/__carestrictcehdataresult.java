package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCA.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __carestrictcehdataresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CARestrictCEHDataResult.jsp", 1731061316919L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\t\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\'javascript\' src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\'javascript\' src=\"../../eCA/js/CARestrictCEHData.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\n\t</head>\n\t<body  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown =\'lockKey()\'>\n\t\t<form name=\"CARestrictCEHDataResultForm\" id=\"CARestrictCEHDataResultForm\" action=\"../../servlet/eCA.CARestrictCEHDataServlet\" method=\"post\" target=\"messageFrame\">\n\t\t\t<BR><BR>\n\t\t\t<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'60%\' align=\'center\'>\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<tr align=\"left\">\t\t\n\t\t\t\t\t\t<th class=\'COLUMNHEADER\' width=\'80%\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t</th>\n\t\t\t\t\t\t<th class=\'COLUMNHEADER\' width=\'20%\'>\n\t\t\t\t\t\t\tSelect All &nbsp;&nbsp; <input type=\"checkbox\" name=\"totalHCheck\" id=\"totalHCheck\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" Checked ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" onclick=\"checkAll(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'H\',\'\',this)\" />&nbsp;\n\t\t\t\t\t\t</th>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' width=\'80%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t<td class=\'gridData\' width=\'20%\'>\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"  onclick=\"checkedObj(this);\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="Checked";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/>\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<tr align=\"left\">\t\t\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'80%\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>\n\t\t\t\t\t\t\tSelect All &nbsp;&nbsp; <input type=\"checkbox\" name=\"totalECheck\" id=\"totalECheck\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'E\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',this)\" />&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\t\t\t\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"restrictId\" id=\"restrictId\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t\t\t<input type=\"hidden\" name=\"restrictDesc\" id=\"restrictDesc\" value=\"\"/>\n\t\t\t<input type=\"hidden\" name=\"histFunction\" id=\"histFunction\" value=\"\"/>\n\t\t\t<input type=\"hidden\"  id=\"restrictData\" name=\"restrictData\" id=\"restrictData\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n\t\t\t<input type=\"hidden\"  id=\"restrictDataType\" name=\"restrictDataType\" id=\"restrictDataType\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"/>\n\t\t\t<input type=\"hidden\"  id=\"selectall_H\" name=\"selectall_H\" id=\"selectall_H\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"/>\n\t\t\t<input type=\"hidden\"  id=\"selectall_E\" name=\"selectall_E\" id=\"selectall_E\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"/>\n\t\t\t<input type=\"hidden\"  id=\"count_hash_event\" name=\"count_hash_event\" id=\"count_hash_event\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/>\n\t\t\t<input type=\"hidden\"  id=\"count_hash_hist\" name=\"count_hash_hist\" id=\"count_hash_hist\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"/>\n\t\t</form>\n\t\t<script>\n\t\tif(";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="==0 && document.getElementById(\"restrictDataType\").value==\"H\" && document.getElementById(\"count_hash_hist\").value!=0)\n\t\t\tdocument.getElementById(\"totalHCheck\").checked=true;\n\t\t if(";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="==0 && document.getElementById(\"restrictDataType\").value==\"E\" && document.getElementById(\"count_hash_event\").value!=0)\n\t\t\tdocument.getElementById(\"totalECheck\").checked=true;\n\t\t\n\t\t</script>\n\t</body>\n</html>\t\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
	
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/10/2019	IN069242		Sivabagyam			22/10/2019	Ramesh Goli			GHL-CRF-0567							
------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		session = request.getSession(false);
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String restrictId		= "",value="";
		String restrictDataType	= "";		
		String recHistType		= "";
			String selectall_H= "";
		String selectall_E= "";
		int selectallHcheck=0;
		int selectallEcheck=0;
		String bean_id			= "@CARestrictCEHDataBean";
		String bean_name		= "eCA.CARestrictCEHDataBean";
		ArrayList histRecTypes = new ArrayList();
		ArrayList eventClassTypes = new ArrayList();
		restrictDataType	= request.getParameter("restrictDataType")==null?"H":request.getParameter("restrictDataType");
		recHistType			= request.getParameter("recHistType")==null?"":request.getParameter("recHistType");
		restrictId			= request.getParameter("restrictId");		
		CARestrictCEHDataBean bean	= (CARestrictCEHDataBean)getObjectFromBean( bean_id, bean_name , session) ; 
		HashMap<String,String> restrictData = bean.getRestrictData();		
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
if("H".equals(restrictDataType)){
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selectall_H ));
            _bw.write(_wl_block10Bytes, _wl_block10);
if("Y".equals(selectall_H)){
            _bw.write(_wl_block11Bytes, _wl_block11);
} 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(restrictId));
            _bw.write(_wl_block13Bytes, _wl_block13);

					histRecTypes = (ArrayList)bean.getHistRecType(locale);
						for(int i=0;i<histRecTypes.size();i++){
						String[] histList  = (String[])histRecTypes.get(i);
						String check=restrictData.get(restrictId+"|"+restrictDataType+"|"+histList[0]+"|*ALL");
						if(check==null)
							check="N";
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(histList[1]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(restrictId+"|"+restrictDataType+"|"+histList[0]+"|*ALL"));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(restrictId+"|"+restrictDataType+"|"+histList[0]+"|*ALL"));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(check));
            _bw.write(_wl_block18Bytes, _wl_block18);
if("Y".equals(check)){
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{selectallHcheck++;}
            _bw.write(_wl_block20Bytes, _wl_block20);

					}
				}else if("E".equals(restrictDataType)){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(selectall_E ));
            _bw.write(_wl_block10Bytes, _wl_block10);
if("Y".equals(selectall_E)){
            _bw.write(_wl_block19Bytes, _wl_block19);
} 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(restrictId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(recHistType));
            _bw.write(_wl_block24Bytes, _wl_block24);

					eventClassTypes = (ArrayList)bean.getEventClass(recHistType,locale);
					for(int i=0;i<eventClassTypes.size();i++){
					String[] eventClass  = (String[])eventClassTypes.get(i);
					String check=restrictData.get(restrictId+"|"+restrictDataType+"|"+recHistType+"|"+eventClass[0]);
						if(check==null)
							check="N";
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eventClass[1]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(restrictId+"|"+restrictDataType+"|"+recHistType+"|"+eventClass[0]));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(restrictId+"|"+restrictDataType+"|"+recHistType+"|"+eventClass[0]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(check));
            _bw.write(_wl_block18Bytes, _wl_block18);
if("Y".equals(check)){
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{selectallEcheck++;}
            _bw.write(_wl_block25Bytes, _wl_block25);

					}	
				}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(restrictId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(restrictData));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(restrictDataType));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(selectall_H));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(selectall_E));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(eventClassTypes.size()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(histRecTypes.size()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(selectallHcheck));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(selectallEcheck));
            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.HistoryRecordTypes.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EventClassType.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
