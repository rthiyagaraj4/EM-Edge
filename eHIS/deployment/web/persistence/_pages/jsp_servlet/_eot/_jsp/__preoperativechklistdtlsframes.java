package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __preoperativechklistdtlsframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PreOperativeChkListDtlsFrames.jsp", 1709615152000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<iframe name=\'RecordFrame\' id=\'RecordFrame\' SRC=\'../../eOT/jsp/ChkListOperationRecord.jsp?";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'  scrolling=\'no\' noresize=\'no\' style=\'height:56vh;width:100vw;border:0\'></iframe>\n\t\t<iframe name=\'DetailFrame\' id=\'DetailFrame\' SRC=\'../../eOT/jsp/ChkListOperationDtls.jsp?";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' scrolling=\'no\' noresize=\'auto\'  style=\'height:44vh;width:100vw;border:0\'></iframe>\n\t\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<iframe name=\'DetailFrame\' id=\'DetailFrame\' SRC=\'../../eOT/jsp/ChkListOperationDtls.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' scrolling=\'no\' noresize=\'no\' style=\'height:100vh;width:100vw;border:0\'></iframe>\n\t\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</HTML>\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
 
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
 //@page  import="java.sql.*, java.util.*,java.io.*" contentType=" text/html;charset=" 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
//@ page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean"  
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String params = request.getQueryString();
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	/* Below Procedure newly added by sathish.k on 09-01-2009 for disabling billing part while unchecked bl_interface_flag 
	Note: if any billing part is calling in PreOperChkListHdr.jsp(Hdr part of ChkecIn) pls call this procedure in OTChekIn.jsp*/
	String facility_id	= (String) session.getValue("facility_id");
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;
	CallableStatement cstmt = null;
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	boolean bill_flag = false;
	try{
		connection	= ConnectionManager.getConnection(request);
		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=connection.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,facility_id );
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.registerOutParameter(6,Types.VARCHAR);
		cstmt.registerOutParameter(7,Types.VARCHAR);
		cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		if(!checkForNull(cstmt.getString(5)).equals("Y")){
			bl_installed=cstmt.getString(3);
			bl_interface=cstmt.getString(4);
			bill_flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
		}else
		{
			//err_text = cstmt.getString(7);
			err_text = cstmt.getString(8);
		}
	}catch(Exception e){
		e.printStackTrace();
	    	System.err.println("Error PreOperativeChkListDtlsFrames.jsp:"+e);
   }finally{
		try{
			//if(rst!=null)rst.close();
			if(cstmt!=null)cstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){
			e.printStackTrace();
		    	System.err.println("Finally Block PreOperativeChkListDtlsFrames.jsp:"+e);
		}
    }
	 params=params+"&bill_flag="+bill_flag;

            _bw.write(_wl_block2Bytes, _wl_block2);

		if(called_from.equals("OT_MENU")){

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(params));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(params));
            _bw.write(_wl_block6Bytes, _wl_block6);

		}else if(called_from.equals("OT_SLATE") || called_from.equals("BOOKING") ){

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(params));
            _bw.write(_wl_block8Bytes, _wl_block8);

			}

            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
