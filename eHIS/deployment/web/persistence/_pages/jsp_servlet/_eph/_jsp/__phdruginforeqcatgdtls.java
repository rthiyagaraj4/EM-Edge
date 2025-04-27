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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __phdruginforeqcatgdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PhDrugInfoReqCatgDtls.jsp", 1723554182987L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n\t <link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t <script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n \t<script LANGUAGE=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/dchk.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/dchk.js\"></SCRIPT>\n\t<script LANGUAGE=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t<script LANGUAGE=\"javascript\" src=\"../js/PhCommon.js\"></script>\n\t <script language=\"JavaScript\" src=\"../../ePH/js/PhDrugInfo.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!-- <body> -->\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n<form name=\'PhDrugInfoReqCatgDtlsForm\' id=\'PhDrugInfoReqCatgDtlsForm\'>\n\n<TABLE cellpadding=0 cellspacing=0 width=\"100%\"  align=\"center\" border=\"0\" >\n\t\n\t\t<TR >\n\t\t\t\t<TH colspan=\'6\' height=\'15\' width=\'100%\'>&nbsp;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</TH>\n\t\t\t</TR>\n\t\t\t\t<TR><TD class=\'label\' colspan=\'6\'>&nbsp;&nbsp;&nbsp;</TD>\n\t\t\t</TR>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" <TR>\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<TD class=\"label\" width=\"23%\" colspan=\'1\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;&nbsp;<TD class=\"label\" width=\"10%\" colspan=\'1\' ><input type=checkbox value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' name=\'chk";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="></TD>\n\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<TD class=\"label\" width=\"23%\" colspan=\'1\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;&nbsp;\n\t\t\t\t<TD class=\"label\" width=\"10%\" colspan=\'1\'><input type=checkbox name=\'chk";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'chk";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'></TD>\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<TD class=\"label\" width=\"35%\" colspan=\'2\'>&nbsp;&nbsp;</TD>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'></TD>\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</TR>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\n\t\t\n\t\t\t<TR><TD class=\'label\' colspan=\'6\'>&nbsp;&nbsp;&nbsp;</TD></TR>\n</TABLE>\n\n\t\n\t\n\t\n\t<INPUT TYPE=\"hidden\" name=\"no_of_records\" id=\"no_of_records\" VALUE=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"chkBox\" id=\"chkBox\" VALUE=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n</form>\n\t\n\n</body>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");	
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

ArrayList Reqcatg = null;
ArrayList Enq_Dtl = null;
String check	="";
String dis="";
String replied_by="";
String login_by_name= (String)session.getValue( "login_user" );

String mode	= request.getParameter( "mode" ) ;
if(mode==null) mode="";
String Enq_num	= request.getParameter("Enq_num") ;
if(Enq_num==null) Enq_num="";
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	//if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
	//return ;
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	ArrayList RequestCatg= bean.getRequestCatg();
	int no_of_req=0;
		if(!Enq_num.equals("")){
		
		Reqcatg =bean.getReqCatgDetails();
		Enq_Dtl =bean.getEnquirerDetails();
		replied_by=(String)Enq_Dtl.get(39);
		if(replied_by==null) replied_by="";
		if(!replied_by.equals("")) dis="disabled";
	no_of_req=Reqcatg.size();
	}
String check_records="";

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

			StringTokenizer st=null;
			String sys_def	="";
			String req_cag_code1="";
			int i=0;
			int j=0;
			String req_cag_code="";
			int k=(int)RequestCatg.size();
			int no_of_records=(int)k/2;
			int count=0;
				
				if(RequestCatg.size()>0){
					while(i<k) {
					
            _bw.write(_wl_block10Bytes, _wl_block10);

						
				req_cag_code = (String)RequestCatg.get(i);
				st=new StringTokenizer(req_cag_code,"**");
				while(st.hasMoreTokens()){
				     req_cag_code1=st.nextToken();
					  sys_def=st.nextToken();
					
				}
				if(no_of_req >0){
					check="";
					for(int s=0; s<no_of_req; s++){
						check_records=(String)Reqcatg.get(s);
						
						if(check_records.equals(req_cag_code1))
							check="checked";
						
						
					}
				}
				if(j+1<=k){
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(req_cag_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(RequestCatg.get(i+=1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(req_cag_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(++count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(check));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block17Bytes, _wl_block17);
check="";
					j=i;
				}
				if(j+1<k){
					req_cag_code = (String)RequestCatg.get(i+=1);
					st=new StringTokenizer(req_cag_code,"**");
				while(st.hasMoreTokens()){
				     req_cag_code1=st.nextToken();
					  sys_def=st.nextToken();
					
				}
					if(no_of_req >0){
					for(int s=0; s<no_of_req; s++){
						check_records = (String)Reqcatg.get(s);
						if(check_records.equals(req_cag_code1))
							check="checked";
						
						
					}
				}
				
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(req_cag_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(RequestCatg.get(i+=1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(++count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(check));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(req_cag_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
	
					check="";
				j=i;
				}
				else{
            _bw.write(_wl_block23Bytes, _wl_block23);
} if(j+1<k){
					req_cag_code = (String)RequestCatg.get(i+=1);	
					st=new StringTokenizer(req_cag_code,"**");
						while(st.hasMoreTokens()){
				     req_cag_code1=st.nextToken();
					  sys_def=st.nextToken();
					
				}
					if(no_of_req >0){
					for(int s=0; s<no_of_req; s++){
						check_records = (String)Reqcatg.get(s);
						if(check_records.equals(req_cag_code1))
							check="checked";
						
					}
				}
				
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(req_cag_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(RequestCatg.get(i+=1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(++count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(check));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(req_cag_code));
            _bw.write(_wl_block24Bytes, _wl_block24);

					check="";
				j=i;	
				}else{
            _bw.write(_wl_block23Bytes, _wl_block23);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);

					i=j+1;
				}
				}
				
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(no_of_records));
            _bw.write(_wl_block28Bytes, _wl_block28);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block29Bytes, _wl_block29);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RequestCategoryDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
