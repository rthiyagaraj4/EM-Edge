package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import eCommon.*;
import eOT.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __otinstrumentframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OTInstrumentFrame.jsp", 1709120290000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Added by Rajesh 30-8-12 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!-- Added by Rajesh 30-8-12 -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n<!-- Added by Rajesh 30-8-12 -->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!-- Added by Rajesh 30-8-12 -->\n<html>\n<head>\n\n<!-- Added by Rajesh 30-8-12 -->\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<!-- Added by Rajesh 30-8-12 -->\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/AdministrativeFunctionforAllCharges.js\"></Script>\n<!-- Added by Rajesh 30-8-12 -->\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<!-- Added by Rajesh 30-8-12 -->\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n   \n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"OTInstrumentFrame\" id=\"OTInstrumentFrame\">\n<table  cellpadding=\'0\' cellspacing=\'0\'>\n<tr>\n\t\t<td  width=\"25%\"  class=\'label\'>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\n\t\t</td>\n\t\t<td class=\"fields\" width=\"25%\">\n\t\t<input type=\'text\' name=\'instr_desc\' id=\'instr_desc\'  size=\'30\' value= \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t</td>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<td>\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   \n<a class =\'gridlink\' href=\"javascript:openDialogWindow_image(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\">  \n\t<img src=\'../../eOT/images/camera_1.gif\'> </a>\n </td>\n <td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t </td>\n</tr>\n\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<br>\n\t<tr>\n\t\t<th class =\'columnheader\'> ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t<th class =\'columnheader\'> ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t</tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t<tr>\n\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"> ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t<td class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t<a class =\'gridlink\' href=\"javascript:openDialogWindow_image_component(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\">  <img src=\'../../eOT/images/camera_1.gif\'> </a></td>\n\t<td class=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\t<!--RUT-CRF-091 -->\n\t\t</tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<input type=\'hidden\' name=\'instr_code\' id=\'instr_code\' value =\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=\'hidden\' name=\'instr_desc\' id=\'instr_desc\' value =\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\'hidden\' name=\'item_code\' id=\'item_code\' value =\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t<input type=\'hidden\' name=\'item_desc\' id=\'item_desc\' value =\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type=\'hidden\' name=\'image_file\' id=\'image_file\' value =\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t<input type=\'hidden\' name=\'ic_location\' id=\'ic_location\' value =\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t<input type=\'hidden\' name=\'sql_cssd_image_flag\' id=\'sql_cssd_image_flag\' value =\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t</div>\n\t</table>\n\t</body>\t\n\t</form>\n<script>\n\tfunction openDialogWindow_image(image_file,st_location){\n\t\t//Modified by Rajesh for CRF-0057 to restrict image display\n\t\tif(!image_file == \"\"){\n\t\t\tvar dialogHeight \t\t= \"20\";\n\t\t\tvar dialogWidth  \t\t= \"30\";\n\t\t\tvar dialogTop   \t\t= \"50\";\n\t\t\tvar dialogLeft   \t\t= \"50\";\n\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\t\tvar arguments\t\t\t= \"\";\n\t\t\tvar\tparam=\"sql_image_flag=\"+image_file;\t\n\t\t\tparam=param+\"&st_location=\"+st_location;\n\t\t\tretVal=window.showModalDialog(\"../../eOT/jsp/AdminInstrumentImageFrame.jsp?\"+param,arguments,features);\t\t\n\t\t}\n\t\telse{\n\t\t\talert(getMessage(\"NO_RECORD_FOUND\",\"Common\"));\n\t\t}\n\t\t//Modified by Rajesh for CRF-0057 to restrict image display\n\t}\n\n//Added newly by MuthuN against CRF-091\n\tfunction openDialogWindow_image_component(image_file,st_location,item_code){\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\"/></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\txmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=check_Image_flag_Admin_component&item_code=\"+item_code,false);\n\txmlHttp.send(xmlDoc);\n\tvar obj = trimString(xmlHttp.responseText);\n\tvar cp_location_array=obj.split(\"~BR~\");\n\tloc_cp=encodeURIComponent(cp_location_array[0]);\n\timage_cp=cp_location_array[1];\n\t\tif(!image_file == \"\"){\n\t\t\tvar dialogHeight \t\t= \"20\";\n\t\t\tvar dialogWidth  \t\t= \"30\";\n\t\t\tvar dialogTop   \t\t= \"50\";\n\t\t\tvar dialogLeft   \t\t= \"50\";\n\t\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\t\tvar arguments\t\t\t= \"\";\n\t\t\tvar\tparam=\"sql_image_flag=\"+image_file;\t\n\t\t\tparam=param+\"&st_location=\"+loc_cp;\n\t\t\tretVal=window.showModalDialog(\"../../eOT/jsp/AdminInstrumentImageFrame.jsp?\"+param,arguments,features);\t\n\t\t}\n\t\telse{\n\t\t\talert(getMessage(\"NO_RECORD_FOUND\",\"Common\"));\n\t\t}\n\t}\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

 String instr_code =  checkForNull(request.getParameter("instr_code"));
 String instr_desc =  checkForNull(request.getParameter("instr_desc"));
 String item_code = "";
 String item_desc= "";
 String image_file="";
 String st_location ="";//RUT-CRF-091
 String	qryVal="";
 //Added by Rajesh 30-8-12
 Connection con=null;
 String locale = (String)session.getAttribute("LOCALE"); 
 PreparedStatement pstmt=null;
 PreparedStatement pstmt_image_ic=null;
 ResultSet rst_image_ic=null;
 //Added by Rajesh 30-8-12
 String sql_cssd_image_flag = request.getParameter("sql_cssd_image_flag"); 
// sql_cssd_image_flag = "../../eOT/images/"+sql_cssd_image_flag;
//RUT-CRF-0091 by MuthuN Starts Here
 String ic_image = request.getParameter("image"); 
 String ic_location = request.getParameter("location"); 
//RUT-CRF-0091 by MuthuN Ends Here
  
	
  
 ResultSet rst = null;	
try{
		con = ConnectionManager.getConnection(request);
 String sql_ic_image= "select image_file from OT_INSTRUMENT where instr_code=?";

// String sql_ic="SELECT A.ITEM_CODE CODE, A.ITEM_DESC DESCR, A.IMAGE_FILE IMAGE FROM OT_SS_COMPONENTS_LANG_VW A,OT_INSTRUMENT_COMPONENTS B WHERE B.INSTR_CODE=? AND A.ITEM_CODE=B.ITEM_CODE ";	

 //String sql_ic="SELECT A.ITEM_CODE CODE, A.ITEM_DESC DESCR, A.IMAGE_FILE IMAGE, B.STLOCATION LOCATION FROM OT_SS_COMPONENTS_LANG_VW A,OT_INSTRUMENT_COMPONENTS B WHERE B.INSTR_CODE=? AND LANGUAGE_ID='"+locale+"' AND A.ITEM_CODE=B.ITEM_CODE ";	
 String sql_ic="SELECT A.ITEM_CODE CODE, A.ITEM_DESC DESCR, A.IMAGE_FILE IMAGE, a.location LOCATION FROM OT_SS_COMPONENTS A,OT_INSTRUMENT_COMPONENTS B WHERE B.INSTR_CODE=? AND A.ITEM_CODE=B.ITEM_CODE ";	


		pstmt = con.prepareStatement(sql_ic);
		pstmt_image_ic = con.prepareStatement(sql_ic_image);
		pstmt.setString(1,instr_code);
		pstmt_image_ic.setString(1,instr_code);
		rst = pstmt.executeQuery();
		rst_image_ic = pstmt_image_ic.executeQuery();
		int index=0;
		String strVal="";

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(instr_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

	while(rst_image_ic.next()){
	 	image_file=checkForNull(rst_image_ic.getString(1));
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(image_file));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ic_location));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ic_location));
            _bw.write(_wl_block15Bytes, _wl_block15);

				}
			 
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	while(rst.next()){				
		 qryVal=(index%2==0)?"gridData":"gridData";
		 ++index;		   
		 item_code = checkForNull(rst.getString(1));
		 item_desc = checkForNull(rst.getString(2));
		 image_file = checkForNull(rst.getString(3));
		 st_location = checkForNull(rst.getString(4));//RUT-CRF-091

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(qryVal));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(qryVal));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(qryVal));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(image_file));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(st_location));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(qryVal));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(st_location));
            _bw.write(_wl_block24Bytes, _wl_block24);

		}	
	/*System.out.println("index"+index);//lakshmi
		if(index==null || index==""){
		out.println("<script>callNoRecords();</script>");
	}	*/
	}catch(Exception e){
		e.printStackTrace();
		 System.err.println("Err Msg in OTInstrumentFrame.jsp"+e.getMessage());
	}finally{
		try{
		
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(rst_image_ic!=null)rst_image_ic.close();
			if(pstmt_image_ic!=null)pstmt_image_ic.close();
			
			if(con!=null)
			{
		
			ConnectionManager.returnConnection(con,request);
		
			}
		}catch(Exception e)
		{e.printStackTrace();}
	}

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(instr_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(instr_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(image_file));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(ic_location));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(sql_cssd_image_flag));
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Instrument.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ImageDescription.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
}
