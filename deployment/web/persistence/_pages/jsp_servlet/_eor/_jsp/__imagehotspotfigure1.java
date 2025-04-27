package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __imagehotspotfigure1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ImageHotspotFigure1.jsp", 1721658352000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n  <html>\n    <script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n\t<script language=\"JavaScript\" src=\"../../eOR/js/HotSpot.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n  <head>\n  <script>\n  var obj2;\n\tfunction changeColor(Obj){\n\t\tvar id=Obj.id;\n\t\t //alert(Obj.id);\n\t\tif( Obj.innerHTML.indexOf(\"<A href\") !=-1);\n\t\telse{\n\t\t\tif(obj2 == null)\n\t\t\tObj.innerHTML=\"<td    valign=\'center\'></td>\"\n\t\t\telse\n\t\t\tobj2.innerHTML=\"<td    valign=\'center\'></td>\"\n\n\t\t\tobj2=Obj;\n\t\t\tObj.innerHTML=\"<font color=\'red\'>*</font>\"\n\n\t\t\t present=1;\tparent.frames[1].location.href=\"ImageHotspotAddModify.jsp?image_id=\"+document.forms[0].image_id.value+\"&hotspot_pos=\"+id+\"&mode=\"+document.forms[0].mode.value+\"&status=insert&function_id=\"+function_id;\n\t\t}\n\t}\n\n  var val;\n\n  function aa(val) {\n\t\tparent.frames[1].location.href=\'../../eOR/jsp/ImageHotspotAddModify.jsp?hotspot_pos=\'+val+\'&image_id=\'+document.forms[0].image_id.value+\"&mode=2&status=modify&function_id=\"+function_id;\n  }\n  </script>\n\t<style>\n\tTD.DATA\n\t{\n\t COLOR:navy;\n\t  FONT-SIZE: 8pt;\n\t  FONT-WEIGHT: BOLDER\n\t  }\n\n    \tA:link {\n    \t\tCOLOR: blue;\n    \t\ttext-decoration : none ;\n\t  \t}\n    \tA:visited {\n    \t\tCOLOR:blue;\n    \t\ttext-decoration : none ;\n\t  \t}\n\t</style>\n\n\n  </head>\n  <body topmargin=0 bgcolor=\"#E6E6FA\" onload=\'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n   <form name=\'image_form_check\' id=\'image_form_check\'  method=\'post\' target=\'messageFrame\'>\n   <br><br>\n\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'  name=\'image_id\'>\n\t\t<input type=\"hidden\" name=mode value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n  <table  height = \'70%\'  width=\"100%\"  align=\'left\'   background=\"../../eOR/images/skeleton_front.gif\"   cellspacing=\"0\" cellpadding=\"0\" id=\'tb1\'  bgcolor=\'#E6E6FA\' border=0  >\n\n  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n  <table   height = \'70%\'  width=\"98%\"  align=\'left\' background=\"../../eOR/images/skeleton_back.gif\"   cellspacing=\"1\" cellpadding=\"1\" id=\'tb1\'  bgcolor=\'#E6E6FA\'  border=1>\n  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n  <tr>\n      <td  width=\"6%\"></td>\n      <td  width=\"6%\"  valign=\"bottom\"></td>\n      <td  width=\"6%\"  valign=\"center\"></td>\n      <td  width=\"6%\"  valign=\"center\"></td>\n      <td  width=\"3%\"  id=\"A1\" onClick=\'changeColor(this)\'></td>\n      <td  width=\"3%\"  id=\"A2\" onClick=\'changeColor(this)\'></td>\n      <td  width=\"3%\"  id=\"A3\" onClick=\'changeColor(this)\'></td>\n      <td  width=\"3%\"  id=\"A4\" onClick=\'changeColor(this)\'></td>\n\t<td  width=\"3%\"  id=\"A5\" onClick=\'changeColor(this)\'></td>\n      <td  width=\"3%\"  id=\"A6\" onClick=\'changeColor(this)\'></td>\n      <td  width=\"3%\"  id=\"A7\" onClick=\'changeColor(this)\'></td>\n      <td  width=\"3%\"  id=\"A8\" onClick=\'changeColor(this)\'></td>\n      <td  width=\"6%\"></td>\n      <td  width=\"6%\"></td>\n      <td  width=\"6%\"></td>\n   </tr>\n   <tr>\n       <td ></td>\n       <td ></td>\n       <td ></td>\n       <td ></td>\n       <td id=\"B1\" onClick=\'changeColor(this)\'></td>\n       <td id=\"B2\" onClick=\'changeColor(this)\'></td>\n       <td id=\"B3\" onClick=\'changeColor(this)\'></td>\n       <td id=\"B4\" onClick=\'changeColor(this)\'></td>\n       <td id=\"B5\" onClick=\'changeColor(this)\'></td>\n       <td id=\"B6\" onClick=\'changeColor(this)\'></td>\n       <td id=\"B7\" onClick=\'changeColor(this)\'></td>\n       <td id=\"B8\" onClick=\'changeColor(this)\'></td>\n       <td ></td>\n       <td ></td>\n       <td ></td>\n   </tr>\n   <tr>\n       <td ></td>\n       <td ></td>\n       <td ></td>\n       <td id=\"C1\" onClick=\'changeColor(this)\' ></td>\n       <td id=\"C2\"  onClick=\'changeColor(this)\' ></td>\n       <td id=\"C3\" onClick=\'changeColor(this)\' ></td>\n       <td id=\"C5\"  onClick=\'changeColor(this)\' ></td>\n       <td id=\"C6\"  onClick=\'changeColor(this)\' ></td>\n       <td id=\"C7\" onClick=\'changeColor(this)\' ></td>\n       <td ></td>\n       <td ></td>\n   </tr>\n   <tr>\n      <td ></td>\n      <td ></td>\n      <td  id=\"D1\" onClick=\'changeColor(this)\'></td>\n      <td  id=\"D2\" onClick=\'changeColor(this)\'></td>\n      <td  id=\"D3\" onClick=\'changeColor(this)\'></td>\n      <td  id=\"D4\" onClick=\'changeColor(this)\'></td>\n      <td  id=\"D5\" onClick=\'changeColor(this)\'></td>\n      <td  id=\"D6\" onClick=\'changeColor(this)\' ></td>\n      <td  id=\"D7\" onClick=\'changeColor(this)\'></td>\n      <td ></td>\n      <td ></td>\n    </tr>\n   <tr>\n      <td ></td>\n      <td ></td>\n      <td id=\"E1\"  onClick=\'changeColor(this)\'></td>\n      <td id=\"E2\"  onClick=\'changeColor(this)\'></td>\n      <td id=\"E3\"  onClick=\'changeColor(this)\'></td>\n      <td id=\"E4\"  onClick=\'changeColor(this)\'></td>\n      <td id=\"E5\"  onClick=\'changeColor(this)\'></td>\n      <td id=\"E6\"  onClick=\'changeColor(this)\' ></td>\n      <td id=\"E7\"  onClick=\'changeColor(this)\'></td>\n      <td ></td>\n      <td ></td>\n    </tr>\n   <tr>\n      <td ></td>\n      <td id=\"F1\"  onClick=\'changeColor(this)\'></td>\n      <td id=\"F2\"  onClick=\'changeColor(this)\'></td>\n      <td ></td>\n      <td id=\"F3\"  onClick=\'changeColor(this)\'></td>\n      <td id=\"F4\"  onClick=\'changeColor(this)\'></td>\n      <td id=\"F5\"  onClick=\'changeColor(this)\'></td>\n      <td id=\"F6\"  onClick=\'changeColor(this)\'></td>\n      <td ></td>\n      <td id=\"F7\"  ></td>\n      <td ></td>\n    </tr>\n     <tr>\n        <td id=\"G1\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"G2\"  onClick=\'changeColor(this)\'></td>\n        <td ></td>\n        <td id=\"G3\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"G4\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"G5\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"G6\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"G7\"  onClick=\'changeColor(this)\'></td>\n        <td ></td>\n        <td id=\"G8\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"G9\"  onClick=\'changeColor(this)\'></td>\n     </tr>\n      <tr>\n         <td id=\"H1\"  onClick=\'changeColor(this)\'></td>\n         <td id=\"H2\"  onClick=\'changeColor(this)\'></td>\n         <td ></td>\n         <td id=\"H3\" onClick=\'changeColor(this)\' ></td>\n         <td id=\"H4\"  onClick=\'changeColor(this)\'></td>\n         <td id=\"H5\"  onClick=\'changeColor(this)\'></td>\n         <td id=\"H6\"  onClick=\'changeColor(this)\'></td>\n         <td id=\"H7\"  onClick=\'changeColor(this)\'></td>\n         <td ></td>\n         <td id=\"H8\"  onClick=\'changeColor(this)\'></td>\n         <td id=\"H9\"  onClick=\'changeColor(this)\'></td>\n     </tr>\n      <tr>\n         <td ></td>\n         <td ></td>\n         <td ></td>\n         <td id=\"I1\"  onClick=\'changeColor(this)\'></td>\n         <td id=\"I2\"  onClick=\'changeColor(this)\'></td>\n         <td ></td>\n         <td id=\"I3\"  onClick=\'changeColor(this)\'></td>\n         <td id=\"I4\"  onClick=\'changeColor(this)\'></td>\n         <td ></td>\n         <td ></td>\n         <td ></td>\n    </tr>\n    <tr>\n        <td ></td>\n        <td ></td>\n        <td ></td>\n        <td id=\"J1\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"J2\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"J3\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"J4\"  onClick=\'changeColor(this)\'></td>\n        <td id=\'J5\'  onClick=\'changeColor(this)\'></td>\n        <td ></td>\n        <td ></td>\n        <td ></td>\n    </tr>\n    <tr>\n        <td ></td>\n        <td ></td>\n        <td ></td>\n        <td id=\"K1\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"K2\"  onClick=\'changeColor(this)\'></td>\n        <td ></td>\n        <td id=\"K3\"  onClick=\'changeColor(this)\'></td>\n        <td ></td>\n        <td ></td>\n        <td ></td>\n        <td ></td>\n    </tr>\n     <tr>\n        <td ></td>\n        <td ></td>\n        <td id=\"L1\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"L2\"  onClick=\'changeColor(this)\'></td>\n        <td id=\"L3\"  onClick=\'changeColor(this)\'></td>\n        <td ></td>\n        <td id=\"L4\"  onClick=\'changeColor(this)\'></td>\n        <td ></td>\n        <td ></td>\n        <td ></td>\n        <td ></td>\n   </tr>\n   <tr>\n       <td ></td>\n       <td ></td>\n       <td id=\"M1\"  onClick=\'changeColor(this)\'></td>\n       <td id=\"M2\"  onClick=\'changeColor(this)\'></td>\n       <td></td>\n       <td id=\"M3\"  onClick=\'changeColor(this)\'></td>\n       <td id=\"M4\"  onClick=\'changeColor(this)\'></td>\n       <td id=\"M5\"  onClick=\'changeColor(this)\'></td>\n       <td id=\"M6\"  onClick=\'changeColor(this)\'></td>\n       <td ></td>\n       <td ></td>\n   </tr>\n  </table>\n  <br><br>\n  <script>\n\tdocument.getElementById(\"tb1\").style.backgroundRepeat=\"no-repeat\";\n\n\tif(document.body.offsetWidth > 303)\n\t{\n\t\tdocument.getElementById(\"tb1\").height\t= \"65%\"\n\t\tdocument.getElementById(\"tb1\").width\t= \"65%\"\n\t}\n\n  </script>\n  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n  <script>\n\t\t\t\t\tvar t=eval(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\n\t\t\t\t\tval =\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\n\t\t\t\t\tt.innerHTML=\"<a href=\'javascript:aa(\\\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\\\")\'><font color=\'CHARTREUSE\'>*</font></a>\";\n\t\t\t\t\tt.title= \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n  </script>\n  ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n  </form>\n  </body>\n\n  </html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

  	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	String image_id				= request.getParameter("image_id");
	String mode					= request.getParameter( "mode" ) ;
	//String function_id			= request.getParameter( "function_id" ) ;
	String bean_id				= "Or_ImageHotSpot" ;
	String bean_name		    = "eOR.ImageHotSpotBean";
	//String readOnly				= "readOnly" ;


	String hotspot_pos     ="";
	String hotspot_name ="";
	//String hotspot_id        ="";

	////////////bean initialization start////////
	ImageHotSpotBean  bean = (ImageHotSpotBean)getBeanObject( bean_id,  bean_name, request ) ;


  ////////////bean initialization end////////

	ArrayList idList=new 	ArrayList();
	try{
			idList=(ArrayList)bean.getHotspotImage(image_id);
	}catch(Exception e)	{
		System.out.println("Ex. Here :"+e);
	}

   
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(image_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block10Bytes, _wl_block10);


  if(image_id.equals("RDFRNT") ||image_id.equals("RXFRNT")||image_id.equals("")) { 
            _bw.write(_wl_block11Bytes, _wl_block11);
 } else  if (image_id.equals("RDBACK") ||image_id.equals("RXBACK")){ 
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block13Bytes, _wl_block13);

  String [] hotspotPosition=null;
    for(int i=0;i<idList.size();i++)
  {
  hotspotPosition=(String [])idList.get(i);
 // hotspot_id=  hotspotPosition[0];
  hotspot_name = hotspotPosition[1];
  hotspot_pos = hotspotPosition[2];
  
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(hotspot_pos));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(hotspot_pos));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(hotspot_pos));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(hotspot_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
}idList=null;
            _bw.write(_wl_block19Bytes, _wl_block19);

		putObjectInBean(bean_id,bean,request);
 

            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
