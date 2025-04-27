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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __medpntredit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/MedPntredit.jsp", 1709119736000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n\t<head>\n\t\t<title>Drawing Tool</title>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/DrawingTool.js\"></script>\n \t</head>\n\n\t<!--onload=\"loadDrawingTool()\"-->\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onload=\"loadDrawingTool()\">\n \t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n<html>\n<head>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DrawingTool.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \n</head>\n \n \n<body class=\"message\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<FORM name=\"editor\" id=\"editor\" METHOD=\"POST\">  <!--ACTION=\"../servlet/SessJpgReader\"-->\n<INPUT TYPE=\"hidden\" name=\"image\" id=\"image\" value=\"\">\n<table border=\"0\" width=\"100%\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<tr>\n\t<td >\n\t\t<table border=\"0\" width=\"100%\">\n\t\t<tr>\n\t\t\t<td width=\"4%\"><applet code=\"Standard.class\" codebase=\"../../eCA/MediPainter/\" archive=\"medipainterapplet.jar\" width=\"48\" height=\"20\" align=\"top\" > </applet>\n\t\t\t</td>\n\t\t\t<td width=\"66%\"><applet code=\"Formatting.class\" codebase=\"../../eCA/MediPainter/\" archive=\"medipainterapplet.jar\" width=\"295\" height=\"20\" align=\"top\" > </applet>\n\t\t\t</td>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<td class=\"label\"><input type=\"button\" class=\"button\" name=\"zoom\" id=\"zoom\" value=\"ZOOM\" onClick=\"zoomWindow()\"></td>\n\t\t\t<td width = \"30%\" align = \"right\" class=\"Label\">\n\t\t\t\tAvailable Images:\n\t\t\t\t<select name=\"image_ref\" id=\"image_ref\" onChange=\"changeImage(this)\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t</select>\n\t\t\t</td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</tr>\n\t\t</table>\n\t</td>\n</tr>\n<tr>\n\t<td >\n\t\t<table border=\"0\" width=\"100%\">\n\t\t<tr>\n\t\t\t<td width=\"35%\" align=\"centre\">\n\t\t\t\t<!-- Tool Panel -->\t\n\t\t\t\t<applet code=\"ToolBox.class\" codebase=\"../../eCA/MediPainter/\" archive=\"medipainterapplet.jar\" width=\"275\" height=\"20\"> </applet>\n\t\t\t</td>\n\t\t\t<td width=\"65%\" align=\"left\">\n\t\t\t\t<!-- Pen Panel -->\n\t\t\t\t<applet code=\"Pens.class\" codebase=\"../../eCA/MediPainter/\" archive=\"medipainterapplet.jar\" width=\"160\" height=\"20\" > </applet>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<tr>\n\t<td>\n\t\t<table border=\"0\" cellpadding=\"1\" width = \"100%\">\n\t    <tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td valign=\"top\">\n\t\t\t\t<!-- Color Pallet -->\n\t\t\t\t<applet code=\"Pallet.class\" codebase=\"../../eCA/MediPainter/\" archive=\"medipainterapplet.jar\" width=\"75\" height=\"200\" > </applet>\n\t\t\t</td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<td bgcolor=\"#000000\">\n\t\t\t\t<applet name=\"drawing\" code=\"Drawing.class\" codebase=\"../../eCA/MediPainter/\"\n\t\t\t\t\tarchive=\"medipainterapplet.jar\" width=\"660\" height=\"360\" align=\"baseline\" >\n\t\t\t\t\t<param name=\"loadImage\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\t\n\t\t\t\t\t<param name=\"canDraw\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\t\n\t\t\t\t</applet>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t</td>\n</tr>\n</table>\n<textarea name=\"load_values\" style=\"visibility:hidden\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</textarea>\n<input type=\"hidden\" name=\"zoom_yn\" id=\"zoom_yn\" value=\"Y\"> <!-- By Default --> \n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</FORM>\n \n</body>\n</html>\n\n";
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
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

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		String bean_id1				= request.getParameter("bean_id");
		String bean_name1			= request.getParameter("bean_name");
		
		// This File is called from Order Entry, Result Entry and View order
		// When called from Order Entry --> called_from parameter will be "" (null)
		// When called from Result Entry --> called_from parameter will be "RESULT"  
		// When called from View (Fully Resulted)--> called_from parameter will be "RESULT_VIEW"  
		// When called from View Order --> called_from parameter will be "VIEW" 
		String called_from			= request.getParameter("called_from");
		if(called_from==null) called_from="";
		String encounter_id			= request.getParameter("encounter_id");
		String patient_id			= request.getParameter("patient_id");
		/* Initialize Function specific start */
		if(called_from.equals("")) {
			//OrderEntryBean bean		= (OrderEntryBean)mh.getBeanObject( bean_id1, request,  bean_name1 );
			OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id1, bean_name1, request ) ;

			patient_id				= bean.getPatientId();
			encounter_id			= bean.getEncounterId();

			// no need to set it
			//putObjectInBean(bean_id1,bean,request);
		} else if(called_from.equals("VIEW") || called_from.equals("RESULT_VIEW") ) {
 			//ExistingOrder bean1		= (ExistingOrder)mh.getBeanObject( bean_id1, request,  bean_name1 );
			ExistingOrder bean1			= (ExistingOrder)getBeanObject( bean_id1, bean_name1, request ) ;

			patient_id				= bean1.getPatientId();
			encounter_id			= bean1.getEncntrId();
			
			// no need to set it	
			//putObjectInBean(bean_id1,bean1,request);
		}
		// From View or Result or Result View, this parameter will be passed
 		String order_id				= request.getParameter("order_id");
		// Till here
  		String bean_id				= "@OrderEntryDrawingToolBean"+patient_id+encounter_id;
		String bean_name			= "eOR.OrderEntryDrawingToolBean";
		//OrderEntryDrawingToolBean beanObj = (OrderEntryDrawingToolBean)mh.getBeanObject( bean_id, request,  bean_name );
		OrderEntryDrawingToolBean beanObj = (OrderEntryDrawingToolBean)getBeanObject( bean_id, bean_name , request) ;
		// clear the bean
		beanObj.clear();
		  
		// From Order Entry, this parameters will be passed
		String catalog_code			= request.getParameter("catalog_code") ;
		String image_id				= request.getParameter("image_id") ;
		// Till here
  		//String image_ref_desc		=	"";
		//String default_yn			=	"";
		String default_image_url	=	"";
		ArrayList DrawingTools		= null;
		String record[]				= null;
		StringBuffer result_data	= new StringBuffer();

		if(called_from.equals("VIEW"))		//Only for view,
		{	
			result_data = beanObj.getImageClob(order_id);
		} else if(called_from.equals("RESULT") || called_from.equals("RESULT_VIEW") )
		{
			result_data = beanObj.getResultImageClob(order_id);
		}

            _bw.write(_wl_block5Bytes, _wl_block5);
 if(! (called_from.equals("VIEW") || called_from.equals("RESULT_VIEW")) ) { 
            _bw.write(_wl_block6Bytes, _wl_block6);
	if(!called_from.equals("RESULT")) { 
            _bw.write(_wl_block7Bytes, _wl_block7);
				DrawingTools	 =  beanObj.getImageRef(catalog_code, image_id);
 			    for(int i=0; i<DrawingTools.size(); i++)
			    {
					record	= (String[])DrawingTools.get(i);
 					out.println("<option value = '"+record[0]+"' > "+record[1]+" </option>");
					default_image_url = record[0];
					if(default_image_url==null) default_image_url="";
			    }

            _bw.write(_wl_block8Bytes, _wl_block8);
 } 
            _bw.write(_wl_block9Bytes, _wl_block9);
 } 
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(! (called_from.equals("VIEW") || called_from.equals("RESULT_VIEW")) ) { 
            _bw.write(_wl_block11Bytes, _wl_block11);
 } 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((default_image_url.equals("")?"":"../../eCA/MediPainter/images/"+default_image_url)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(((called_from.equals("") || called_from.equals("RESULT"))?"1":"0")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(result_data.toString()));
            _bw.write(_wl_block15Bytes, _wl_block15);

	//Nullifying the objects
	DrawingTools	= null;			record = null;
	result_data.setLength(0);		

	putObjectInBean(bean_id,beanObj,request);


            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
