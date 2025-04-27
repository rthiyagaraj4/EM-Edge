package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifydoctypemodule extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/addModifyDocTypeModule.jsp", 1709121691104L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<head>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eSM/js/DocumentType.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\n\n\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey();\' >\n<form name=\"documenttype_form1\" id=\"documenttype_form1\" action=\"../../servlet/eSM.DocumentTypeServlet\" method=\"post\" target=\"messageFrame\">\n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n\t\n\n \n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'95%\' align=\'center\'>\n\t\t<tr>\n\t\t\n\t\t<th class=\'columnheader\' ><div   width=\'25%\'  class=\'myClass\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</div></th>\n       <th class=\'columnheader\' ><div   width=\'25%\'  class=\'myClass\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</div></th>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n\n\t\t\n</table>\n<input type=\"hidden\" name=\"sStyle\" id=\"sStyle\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n \n\n\t\t\n\t\t\n<input type=\'hidden\' name=\'insert_vals\' id=\'insert_vals\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'update_vals\' id=\'update_vals\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'delete_vals\' id=\'delete_vals\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'basedon\' id=\'basedon\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'doctype\' id=\'doctype\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'longdescription\' id=\'longdescription\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'shortdescription\' id=\'shortdescription\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'eff_status1\' id=\'eff_status1\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'startdocnum\' id=\'startdocnum\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'nextdoctype\' id=\'nextdoctype\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'entitymode\' id=\'entitymode\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'autoprint\' id=\'autoprint\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'cnt\' id=\'cnt\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t\t<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n\t\t\n</form>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet accessRightRecSet= null;synchronized(session){
                accessRightRecSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("accessRightRecSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(accessRightRecSet==null){
                    accessRightRecSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("accessRightRecSet",accessRightRecSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block2Bytes, _wl_block2);

Connection con =null;
Statement stmt = null;

PreparedStatement pstmt = null;
ResultSet rs=null;	
ResultSet rs1=null;	
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
try{
 
 con = ConnectionManager.getConnection(p);
 
	String doctype="";
	String modid="";
	String  modname="";
	
	String sql1="";
	String sql="";
	String SELECT_CHECK_BOX="";
	

	
	String chkAttribute = "";
  	
	String module_name="";
	String mode="";
	ArrayList select=new ArrayList();
	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
doctype=request.getParameter("DOC_TYPE_CODE")==null?"":request.getParameter("DOC_TYPE_CODE");
	String operation1		= request.getParameter("operation")==null?"":request.getParameter("operation");
	
if(!doctype.equals("")){
	mode="2";
	

 sql1 = "SELECT A.MODULE_ID module_id, B.MODULE_NAME module_name, 'Y' SELECT_CHECK_BOX FROM SY_DOC_TYPE_MASTER_DTL A, SM_MODULE B WHERE A.DOC_TYPE_CODE = '"+doctype+"' AND A.MODULE_ID=B.MODULE_ID UNION SELECT MODULE_ID, MODULE_NAME, 'N' SELECT_CHECK_BOX FROM SM_MODULE WHERE INSTALL_YN='Y' AND MODULE_ID NOT IN (SELECT MODULE_ID FROM SY_DOC_TYPE_MASTER_DTL WHERE DOC_TYPE_CODE = '"+doctype+"')order by 2";
 if(con!=null)
	{
	 
   pstmt = con.prepareStatement(sql1);
   rs1 = pstmt.executeQuery();
	while(rs1.next())
	{
		modid=rs1.getString("module_id"); 
		modname=rs1.getString("module_name");
		SELECT_CHECK_BOX=rs1.getString("SELECT_CHECK_BOX");
		
		select.add(SELECT_CHECK_BOX);
		
	}
	}
	
}
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);


		
	
	 
	 sql="select module_id,module_name from sm_module  where INSTALL_YN='Y' order by 2";

	

	
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);

	int i = 0;
	int cnt=1;

	
	
	while(rs.next())
	{
			
		 String mod =  rs.getString("module_id")==null?"":rs.getString("module_id");

		 if(accessRightRecSet.containsObject(mod))
			chkAttribute = "CHECKED";
		 else
			chkAttribute="";

		
		
		 String classValue = "" ;
		 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ; 
		module_name=rs.getString("module_name")==null ? "":rs.getString("module_name");
		out.println("<tr><td class='" + classValue + "'>");
		out.println(module_name);
		out.println("</td>");
		if(mode.equals("2"))
		{
		if(select.get(i).equals("Y"))
		{
		out.println("<td align='center' class='" + classValue + "'><input type='checkbox' "+chkAttribute+"  onClick='clickVal(this)' name='select"+i+"' id='select"+i+"' checked disabled>");
		}else
		{
			out.println("<td align='center' class='" + classValue + "'><input type='checkbox' "+chkAttribute+"  onClick='clickVal(this)' name='select"+i+"' id='select"+i+"'>");

		}
		}
		else
		{
			out.println("<td align='center' class='" + classValue + "'><input type='checkbox' "+chkAttribute+"  onClick='clickVal(this)' name='select"+i+"' id='select"+i+"'>");
		}

		out.println("<input type='hidden' name='module_id"+i+"' id='module_id"+i+"' value='"+mod+"'>");

		  out.println("</tr> ");
		i++;
		cnt++;
    
}

	 if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	} 
	
	 
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(operation1));
            _bw.write(_wl_block15Bytes, _wl_block15);



}

catch(Exception e)
	{
//	out.println(e.getMessage());
	e.printStackTrace();
	}


	finally
	{
	try
	{
	if (stmt != null) stmt.close();
	if (rs != null)   rs.close();
	ConnectionManager.returnConnection(con,request);
	}

	catch(Exception exp)
	{
		//out.println(exp.toString());
		exp.printStackTrace();
	}
	}		


            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ModuleName.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
