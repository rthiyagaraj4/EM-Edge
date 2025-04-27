package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __imagehotspotaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ImageHotspotAddModify.jsp", 1725253148000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="<!-- IN072524 -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\n\t<script language=\"JavaScript\" src=\"../../eOR/js/HotSpot.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<!-- OnMouseDown=\"CodeArrest()\" > -->\n<body onload=\'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<form name=\"frm_img_hot_spot\" id=\"frm_img_hot_spot\" method=\"post\" \ttarget=\"messageFrame\">\n<table cellpadding=\"3\" cellspacing=\"0\" border=0 width=\'40%\' align=\"center\">\n\n\t\t\n\t\t<tr>\n\t\t\t<td class=\"label\"></td>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td class=\"fields\" colspan=\'2\'>\n\t\t\t\t<select name=\"image_id_list\" id=\"image_id_list\"  onChange=\"parent.parent.change(this)\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" >\n\t\t\t\t\t<option value=\"\"> --- ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" --- </option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="||";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \t>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t</select>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" id=\'id1\' name=\'id1\'></td>\n\t\t\t<td class=\"label\" id=\'idname\' name=\'idname\'>\n\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t<td colspan=\'2\'  class=\"fields\" id=\'idvalue\' name=\'idvalue\'>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t  <input type=\"text\"   name=\"hotspot_id\" id=\"hotspot_id\"  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="    size=\"7\"   maxLength=\"6\"   value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'  onBlur=\'ChangeUpperCase(this);\'  onkeypress=\'return CheckForSpecChars(event)\'><img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t</td>\n\t\t\t<td class=\"label\" id=\'id4\'></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" id=\'imagename1\' name=\'imagename1\'></td>\n\t\t\t<td class=\"label\" id=\'imagename\' name=\'imagename\'>\n\t\t\t\t ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td class=\"fields\"  colspan=\'2\' id=\'imagevalue\' name=\'imagevalue\'>\n\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\t\t<input type=\"text\" name=\"hotspot_name\" id=\"hotspot_name\"  size=\"30\" maxLength=\"30\" onBlur=\"makeValidString( this );\"  value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t   </td>\n\t\t\t<td class=\"label\"  id=\'imagename4\' ></td>\n\t\t</tr>\n\t\t<!-- //IN072524 Starts -->\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<tr>\n\t\t<td class=\"label\" id=\'fpp_yntd\' name=\'fpp_yntd\'></td>\n\t\t<td class=\"label\" id=\'fpp_yntd2\' name=\'fpp_yntd2\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t<td class=\"fields\"  colspan=\'2\' id=\'fpp_yntd3\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="<input type=\"checkbox\" name=\"fpp_yn\" id=\"fpp_yn\"  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" onclick=\"setFPPYN(this)\"  >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t</td>\n\t\t<td class=\"label\"  id=\'fpp_yntd4\' ></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \n\t\t<!-- //IN072524 Ends -->\n\t\t\n\t</table>\n\t<input type=\"hidden\" name=\"image_id\" id=\"image_id\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"Image_Hotspot\">\n\t<input type=\"hidden\" name=\"hotspot_pos\" id=\"hotspot_pos\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" name=\"x_pos\" id=\"x_pos\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\"hidden\" name=\"y_pos\" id=\"y_pos\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t</form>\n\n </body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
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

/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
---------------------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

  

	String mode				=	request.getParameter( "mode" ) ;
	//String function_id		=	request.getParameter( "function_id" ) ;

	String image_id         =	request.getParameter( "image_id" ) ;
	String hotspot_pos		=	request.getParameter( "hotspot_pos" ) ;
	String status			=	request.getParameter( "status" ) ;
	String x_pos			=	request.getParameter( "x_pos" ) ;
	String y_pos			=	request.getParameter( "y_pos" ) ;

	String bean_id			= "Or_ImageHotSpot" ;
	String bean_name		= "eOR.ImageHotSpotBean";
	String readOnly			= "" ;
	ArrayList imageList  =new ArrayList();

   String hotspot_id="";
   String hotspot_name="";
//out.println("<script>alert('"+request.getQueryString()+"')</script>");
	/*  variable dec end*/
	if(status==null||status.equals(""))
		status="";
	else
		status=status.trim();

	if(hotspot_pos==null||hotspot_pos.equals(""))
		hotspot_pos="A1";
	else
		hotspot_pos=hotspot_pos.trim();

	if((image_id==null)||image_id.equals(""))
		image_id="";
	else
		image_id=image_id.trim();
	// bean object instantiated
	ImageHotSpotBean  bean = (ImageHotSpotBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	bean.setMode(mode);
	// mandatory bean initial  operation 	 end
	//IN072524 Starts
    	Connection con=null ;
	Boolean isFPPApplicableyn =false;
	String fpp_yn ="";
	String fppchecked ="";
	String fppdisabled ="";
	//IN072524 Ends
	try{
		con = ConnectionManager.getConnection(request);
		isFPPApplicableyn = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","FPP_APPLICABLE_YN");//IN072524
	
	}catch(Exception e){
	System.out.println("Caught=" + e.getMessage());	
	}
	finally{
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con, request);
		 }catch(Exception e){System.out.println("exception"+e);
		 
		 }
	}
	//IN072524 Ends
	if(mode.equals("2")&&status.equals("modify")){
		readOnly="readOnly";
		
		try{
			//String[] ModifyLoadData=(String[]) bean.loadDataModify(image_id,hotspot_pos,x_pos,y_pos);
			String[] ModifyLoadData=(String[]) bean.loadDataModify(image_id,x_pos,y_pos);
			hotspot_name=(String)ModifyLoadData[0];
			hotspot_id=(String)ModifyLoadData[1];
			x_pos=(String)ModifyLoadData[2];
			y_pos=(String)ModifyLoadData[3];
			fpp_yn=(String)ModifyLoadData[4];//IN072524 Starts
		//	out.println("<script>alert('2==="+(String)ModifyLoadData[2]+"--3-"+(String)ModifyLoadData[3]+"--')</script>");
			ModifyLoadData=null;
		}catch(Exception e){
			System.out.println(e);
		}
	}else  if(!mode.equals("2")&&status.equals("insert")){
			 hotspot_id="";
			 hotspot_name="";
			 fpp_yn="";//IN072524 
			 fppdisabled="";//IN072524 
	} else{
			 hotspot_id="";
			 hotspot_pos="";
			 hotspot_name="";
			 image_id="";
	}
	//IN072524 Starts
	if("Y".equals(fpp_yn)){
		fppchecked ="checked";
	}
	if(mode.equals("2")){
		 fppdisabled = "disabled";
	}
	//IN072524 ENDS
  
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

							imageList = bean.getImageOnLoad();
							String[] record=null;
								for(int i=0; i<imageList.size() ; i++){
								record = (String []) imageList.get(i);
						
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(record[2]));
            _bw.write(_wl_block16Bytes, _wl_block16);
if(image_id.equals(record[0]))out.println("selected");
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block18Bytes, _wl_block18);
}	imageList=null;
            _bw.write(_wl_block19Bytes, _wl_block19);
	if(image_id.equals("")){out.println("");
				}else{
						out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels")+"");
				}
			
            _bw.write(_wl_block20Bytes, _wl_block20);

				if(image_id.equals("")){ out.println("");
				}else{
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(hotspot_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
	}
            _bw.write(_wl_block24Bytes, _wl_block24);
 if(!(image_id.trim().equals(""))){ 
				 out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels")+"");}
            _bw.write(_wl_block25Bytes, _wl_block25);
if(!(image_id.equals(""))){	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(hotspot_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
if(isFPPApplicableyn){ 
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(!(image_id.trim().equals(""))){ 
				 out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FPPPATIENT.label","common_labels")+"");}
            _bw.write(_wl_block30Bytes, _wl_block30);
if(!(image_id.equals(""))){	
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(fpp_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(fppchecked ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(fppdisabled ));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
} 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(image_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(hotspot_pos));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(x_pos));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(y_pos));
            _bw.write(_wl_block42Bytes, _wl_block42);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Image.label", java.lang.String .class,"key"));
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
