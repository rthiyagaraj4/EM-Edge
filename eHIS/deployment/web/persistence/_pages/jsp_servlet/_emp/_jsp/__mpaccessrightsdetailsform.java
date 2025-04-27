package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.util.*;
import com.ehis.util.*;

public final class __mpaccessrightsdetailsform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/MpAccessRightsDetailsForm.jsp", 1709118630525L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 =" \n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script language=\'javascript\' src=\'../js/MpAccessRights.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<title>\n</title>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\n<body onKeyDown=\'lockKey()\'>\n<form name=\"MpAccessRightsDetailsForm\" id=\"MpAccessRightsDetailsForm\" action=\"../../eMP/jsp/MpAccessRightsDetailsForm.jsp\" target=\"messageFrame\" method=\"post\">\n<table cellpadding=0 cellspacing=0 border=1 width=100%>\n<tr>\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n<!--Below Modified for Regression-PAS-OP Transaction- Register Visit-->\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n<td class=\'columnheader\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n</tr>\n\n   \t\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n          \n            <tr>\n\t\t\t    <input type= \'hidden\' name=\'RespId";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' id=\'RespId";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n                <td class = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n                <td class = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' align=center>\n                <input type=\'checkbox\' name=\'viewpatphotoyn";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'viewpatphotoyn";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onclick=\'chkValue(this);\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="  > \n                </td>\n                <td class = \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' align=center>            \n\t\t\t\t<input type=\'checkbox\' name=\'viewpatfindtlsyn";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'viewpatfindtlsyn";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="  > \n\t\t\t\t</td>\n\n            </tr>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'COMMON\'));\n\t\tdocument.location.href=\"../../eCommon/html/blank.html\";\n\t\t</script>\n\n\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\t\t\n<input type=\'hidden\' name=\'maxRecords\' id=\'maxRecords\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\n</table>\n</form>\n</body>\n\n    \n\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n</html>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet accessRightRecSet= null;synchronized(session){
                accessRightRecSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightRecSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightRecSet==null){
                    accessRightRecSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightRecSet",accessRightRecSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet accessRightfinaRecSet= null;synchronized(session){
                accessRightfinaRecSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightfinaRecSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightfinaRecSet==null){
                    accessRightfinaRecSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightfinaRecSet",accessRightfinaRecSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	StringBuffer sblQry = new StringBuffer();
	Connection con=null;	
	Statement stmt=null;
	ResultSet rset=null;
	PreparedStatement pstmt = null;
	

	String classValue="";
	try{
		con = ConnectionManager.getConnection(request);
		String searchresp        = "";
		String searchcriteria    = "";
		String whereclause       = "";	
		String RespId            = "";
		String RespName          = "";
		String ViewPatPhotoYN    = "";
		String ViewPatFinDtlsYN  = "";
		String ViewPatPhotoYNChk  = "";
		String ViewPatFinDtlsYNChk  = "";
		/*Added by lakshmanan for security issue ID 174122693 on 31-08-2023 start */
		java.util.HashMap psthashmap		=	new java.util.HashMap() ;
		int psthmcount=0;
		/*Added by lakshmanan for security issue ID 174122693 on 31-08-2023 end */
		int maxRecord = 0;
		int counter= 0;

		searchresp=request.getParameter("searchresp")==null?"":request.getParameter("searchresp");
		String scode = searchresp.toUpperCase();
		searchcriteria=request.getParameter("searchcriteria");
		if(searchcriteria.equals("S"))
			psthashmap.put(++psthmcount,scode+"%");
			//whereclause = "('"+scode+"%')";
		if(searchcriteria.equals("E"))
			psthashmap.put(++psthmcount,"%"+scode);
			//whereclause = "('%"+scode+"')" ;
		if(searchcriteria.equals("C"))
			psthashmap.put(++psthmcount,"%"+scode+"%");
			//whereclause = "('%"+scode+"%')" ;
		try{

            sblQry.append("SELECT a.resp_id resp_id, b.resp_name resp_name, a.view_pat_photo_yn view_pat_photo_yn, a.view_pat_fin_dtls_yn view_pat_fin_dtls_yn ");
            sblQry.append("FROM MP_ACCESS_RIGHTS a, SM_RESP b ");
            sblQry.append("WHERE a.resp_id = b.resp_id and upper(b.resp_name) like upper(?)  ");
            sblQry.append("UNION " );
            sblQry.append("SELECT resp_id, resp_name, 'N' view_pat_photo_yn, 'N' view_pat_fin_dtls_yn FROM sm_resp ");
            sblQry.append("WHERE resp_id NOT IN(SELECT resp_id FROM mp_access_rights) and upper(resp_name) like upper(?) ");
            sblQry.append("ORDER BY resp_name");
            //stmt = con.createStatement();
            pstmt = con.prepareStatement(sblQry.toString());
            pstmt.setString(1,(String) psthashmap.get(1));
            pstmt.setString(2,(String) psthashmap.get(1));
            rset = pstmt.executeQuery();
            psthashmap.clear();
            maxRecord = rset.getRow();
   
          }
		catch(Exception e){
            //out.println("Error in select Query "+e);
			e.printStackTrace();
        }
		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 
	  int i = 1;
	  while(rset.next() )
		{
		  counter++;
            maxRecord = maxRecord + 1;
            RespId = rset.getString("resp_id");
            RespName = rset.getString("resp_name");
            ViewPatPhotoYN = rset.getString("view_pat_photo_yn");
            ViewPatFinDtlsYN = rset.getString("view_pat_fin_dtls_yn");

            if(RespId == null){ RespId = ""; }
            if(RespName == null){ RespName = ""; }
            if(ViewPatPhotoYN == null){ ViewPatPhotoYN = ""; }
            if(ViewPatFinDtlsYN == null){ ViewPatFinDtlsYN = ""; }
            if(counter%2==0)
			{
             classValue="QRYEVEN";
            }
			else
			{
		      classValue = "QRYODD";
            }
             if (ViewPatPhotoYN.equals("Y"))
			  {
                 ViewPatPhotoYNChk = "checked";
				
			  }
			  else
			  {
                 ViewPatPhotoYNChk = "";
			  }

			  if (ViewPatFinDtlsYN.equals("Y"))
			  {
                 ViewPatFinDtlsYNChk = "checked";
				
			  }
			  else
			  {
                ViewPatFinDtlsYNChk = "";
			  }
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(RespId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(RespName));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ViewPatPhotoYN ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ViewPatPhotoYNChk));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ViewPatFinDtlsYN ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(ViewPatFinDtlsYNChk));
            _bw.write(_wl_block26Bytes, _wl_block26);

				i++;
			}
			if(rset!=null) rset.close();
		   if(stmt!=null) stmt.close();
		
		if(maxRecord==0) 
		 {
		
            _bw.write(_wl_block27Bytes, _wl_block27);
}
	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block29Bytes, _wl_block29);

   	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} finally {
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block30Bytes, _wl_block30);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.responsibility.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ViewPatientPhoto.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ViewPatFinlDtls.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
