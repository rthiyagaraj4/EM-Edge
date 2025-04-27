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

public final class __displaydruginfoheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DisplayDrugInfoHeader.jsp", 1709120704083L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block3 ="\n\n\n<html>\n\t<head>\n\t\t<title>\n\t\t</title>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/FDBDrugInfo.js\"></SCRIPT><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t</head>\n\t<body topmargin=\"0\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t\t<table name=\"TblInteractions\" id=\"TblInteractions\"  width=\"100%\"  border=\"0\" height=\"100%\" > \n\t\t\t\t<TBODY     vALIGN =\"TOP\" >\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<Td   id=\"THEquiv\" name=\"THEquiv\"  style=\"BACKGROUND-COLOR:#FFFF99\"> \n\n\t\t\t\t\t\t\t<label id=\"LbDrugClaas\" onClick=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="><font class=\"hyperlink\">&nbsp;&nbsp;Drug Classification </font></label><br><br>\n\n\t\t\t\t\t\t\t<label id=\"LbDrugCommonOrd\" onClick=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="><font class=\"hyperlink\">&nbsp;&nbsp;Common Orders </font></label><br><br>\n\n\t\t\t\t\t\t\t<label id=\"LbDrugInt\" onClick=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="><font class=\"hyperlink\">&nbsp;&nbsp;Drug Interaction</font></label><br><br>\n\n\t\t\t\t\t\t\t<label id=\"LbDrugCont\" onClick=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="><font class=\"hyperlink\">&nbsp;&nbsp;Contraindications </font></label><br><br>\n\n\t\t\t\t\t\t\t<label id=\"LbDrugSide\" onClick=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="><font class=\"hyperlink\">&nbsp;&nbsp;Side Effects</font> </label><br><br>\n\n\t\t\t\t\t\t\t<label id=\"LbDrugPre\" onClick=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="><font class=\"hyperlink\">&nbsp;&nbsp;Precautions</font></label><br><br>\n\n\t\t\t\t\t\t\t<label id=\"LbDrugOverDose\" onClick=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="><font class=\"hyperlink\">&nbsp;&nbsp;Over Dose</font></label><br><br>\n\n\t\t\t\t\t\t   <label id=\"LbDrugFood\" onClick=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="><font class=\"hyperlink\">&nbsp;&nbsp;Drug-Food Interactions</font></label><br><br>\t\n\n\t\t\t\t\t\t\t<label id=\"LbDrugPatEdu\" onClick=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"><font class=\"hyperlink\">&nbsp;&nbsp;Patient-Education</font></label><br><br>\n\t\t\t\t\t\t</Td>\n\t\t\t\t\t</TR>\n\t\t\t\t</TBODY>\n\t\t\t</table>\n\n ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
	
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
        response.setHeader("Content-Type", "text/html;");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;");
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
            _bw.write(_wl_block3Bytes, _wl_block3);

//added By Himanshu Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

		String bean_id = "ExternalProductLinkBean" ;
		String bean_name = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean bean = (ExternalProductLinkBean)getBeanObject( bean_id, bean_name, request ) ;
		//Get data for food interactions
		String prodid=request.getParameter("extprodid");
		try{

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf("showTab('TblEquiv','LbDrugClaas','"+prodid+"')"));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf("showTab('TblInteractions','LbDrugCommonOrd','"+prodid+"')"));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf("showTab('TblIndications','LbDrugInt','"+prodid+"')"));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf("showTab('TblContra','LbDrugCont','"+prodid+"')"));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf("showTab('TblInfo','LbDrugSide','"+prodid+"')"));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf("showTab('TblPrecautions','LbDrugPre','"+prodid+"')"));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf("showTab('TblOverDose','LbDrugOverDose','"+prodid+"')"));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf("showTab('TblFood','LbDrugFood','"+prodid+"')"));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf("showTab('TblCounsel','LbDrugPatEdu','"+prodid+"')"));
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		catch (Exception e)
		{
			out.println("The External Database cannot be accessed!!!");
		}

            _bw.write(_wl_block16Bytes, _wl_block16);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
