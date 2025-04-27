package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import org.apache.commons.codec.binary.*;
import webbeans.eCommon.*;

public final class __viewpatientimage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ViewPatientImage.jsp", 1734584365707L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t\t\t<script language=\"JavaScript\">\n\t\t\t\talert(\"APPIMG004 - Invalid Patient ID ...\");\n\t\t\t</script>";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t<script language=\"JavaScript\">\n\t\t\t\t\talert(\"APPIMG002 - Patient Image Not Uploaded To The File System...\");\n\t\t\t\t\tparent.window.close();\n\t\t\t\t\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t<script language=\"JavaScript\">\n\t\t\t\t\talert(\"APPIMG003 - Patient Image Not Uploaded Into The Database...\");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t<script language=\"JavaScript\">\n\t\t\t\talert(\"APPIMG001 - Image Parameter In SM_DB_INFO Table Not Set...\");\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<html>\n<head>\n<script>\nvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\nfunction loadfun(){\t\n\t//document.title=getLabel(\"eMP.photo.label\",\"MP\" );\t \n\tvar patient_id = document.getElementById(\"patient_id\").value\n\tvar pat_photo_in_db_yn = document.getElementById(\"pat_photo_in_db_yn\").value\n\tvar pat_photo_http_path = document.getElementById(\"pat_photo_http_path\").value\t\n\tdocument.getElementById(\"PAT_PHOTO\").innerHTML=\"<img id=\'patient_photo\' src=\'../../eMP/jsp/PaintImage.jsp?patient_id=\"+patient_id+\"&pat_photo_in_db_yn=\"+pat_photo_in_db_yn+\"&pat_photo_http_path=\"+pat_photo_http_path+\"\' height = \'170\' width = \'180\' >\";\t\t\n}\n</script> \n<!-- <meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7\" />\n<meta name=\"Generator\" content=\"EditPlus\">\n<meta name=\"Author\" content=\"\">\n<meta name=\"Keywords\" content=\"\">\n<meta name=\"Description\" content=\"\"> -->\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \n <title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title> \n</head>\n<body onload=\"loadfun()\" onKeyDown=\'lockKey()\' marginwidth=\"0\" marginheight=\"0\" leftmargin=\"0\" topmargin=\"0\">\n<form  STYLE=\"margin: 0px; padding: 0px;\">\n<table align=center >\n<tr>\t\n\t<td align=\"center\" id=\"PAT_PHOTO\"></td>\n</tr>\n</table>\n<input type = \'hidden\' name = \'patient_id\' id=\'patient_id\' value = ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =">\n<input type = \'hidden\' name = \'pat_photo_http_path\' id =\'pat_photo_http_path\'  value = ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n<input type = \'hidden\' name = \'pat_photo_in_db_yn\' id=\'pat_photo_in_db_yn\' value = ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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

		String patient_id="";
		//int BrowserVersion=0;
		String pat_photo_in_db_yn = "" ;
		String pat_photo_http_path = "" ;
		Connection con = null;
		String locale = (String)(session.getAttribute("LOCALE")==null?"en":session.getAttribute("LOCALE"));
//		String height="";
	//	String width="";
		String title="";
	try
	{		
		request.setCharacterEncoding("UTF-8");
		//BrowserVersion = Integer.parseInt(request.getParameter("BrowserVersion")==null?"6":request.getParameter("BrowserVersion"));
		patient_id = request.getParameter("patient_id");
		patient_id = (patient_id == null)?"":patient_id;
		title = request.getParameter("title");
		 title = (title == null)?"":title;
		/*
			if(BrowserVersion<=6){
				height="250";
				width="250";
			}else{
				height="170";
				width="180";
			}			
		*/		
		if(patient_id.length() == 0){
            _bw.write(_wl_block2Bytes, _wl_block2);

			out.flush();
			return;
		}
		con = ConnectionManager.getConnection(request);
		java.sql.Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select pat_photo_os_path, pat_photo_http_path from sm_db_info");
		if(rs != null && rs.next()){			
			pat_photo_http_path = rs.getString("pat_photo_http_path");
		}
		rs.close();	
		rs = stmt.executeQuery("Select pat_photo_in_db_yn from mp_patient where patient_id = '"+patient_id+"'");
		if(rs != null && rs.next()){
			pat_photo_in_db_yn = rs.getString("pat_photo_in_db_yn");
		}
		rs.close();		
		boolean flag = true ;
		byte [] byteArr = null;			
		if(pat_photo_in_db_yn.equalsIgnoreCase("N")){			
			//String path = getServletConfig().getServletContext().getRealPath("/")+pat_photo_http_path+patient_id+".jpg";
			String path = pat_photo_http_path+patient_id+".jpg";
			File f = new File(path);				
			if(f.exists()){
				FileInputStream fis = new FileInputStream(f);
				byteArr = new byte[(int)f.length()];
				fis.read(byteArr,0,byteArr.length);
				fis.close();
			}else{
            _bw.write(_wl_block3Bytes, _wl_block3);

					flag = false;
			}
		}else if(pat_photo_in_db_yn.equalsIgnoreCase("Y")){			
			rs = stmt.executeQuery("Select PAT_PHOTO_BLOB from MP_PATIENT_PHOTO where PATIENT_ID='"+patient_id+"'");
			if(rs != null && rs.next()){
				Blob pat_photo_blob = rs.getBlob("PAT_PHOTO_BLOB");				
				byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());				
			}else{
				
            _bw.write(_wl_block4Bytes, _wl_block4);

					flag = false;
			}
			if(rs != null)rs.close();
		}else{
            _bw.write(_wl_block5Bytes, _wl_block5);

				flag = false;
		}			
		if(stmt != null)stmt.close();
		String encoded = "";		
		if(flag)
		encoded = new String((new Base64()).encode(byteArr));		

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(pat_photo_http_path));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pat_photo_in_db_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
}catch(Exception exc){
		exc.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
