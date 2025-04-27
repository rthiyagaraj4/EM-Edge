package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;

public final class __trmtcomplicationframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/TrmtComplicationFrames.jsp", 1709119374961L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--Created by sathish on 20-01-2010-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t<script src=\"../../eOH/js/TrmtComplicationDetails.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<iframe name=\"TrmtComplicationHeaderTitle\" id=\"TrmtComplicationHeaderTitle\" frameborder=\"0\" noresize src=\"../../eOH/jsp/TrmtComplicationHeaderTitle.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" scrolling=\'auto\' style=\'height:17%;width:100vw\'></iframe><iframe name=\"TrmtComplicationHeaderLabel\" id=\"TrmtComplicationHeaderLabel\" frameborder=\"0\" src=\"../../eOH/jsp/TrmtComplicationHeaderLabel.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" scrolling=\'auto\' noresize style=\'height:3%;width:100vw\'></iframe>\n\t\t<iframe name=\"TrmtComplicationHeader\" id=\"TrmtComplicationHeader\" frameborder=\"0\" src=\"../../eCommon/html/blank.html\" scrolling=\'auto\' noresize style=\'height:44%;width:100vw\'></iframe>\n\t\t<iframe name=\"TrmtComplicationDetails\" id=\"TrmtComplicationDetails\" frameborder=\"0\" src=\"../../eCommon/html/blank.html\" scrolling=\'auto\' noresize style=\'height:25%;width:100vw\'></iframe>\n\t\t<iframe name=\'hidden_frame\' id=\'hidden_frame\'\tframeborder=\"0\" src=\'../../eOH/jsp/CommonMasterObjectCollect.jsp\'  noresize style=\'height:0%;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:40%;width:100vw\'></iframe>\n\t<body  onKeyDown = \'lockKey();\'>\n\t\t<form name=\"TrmtComplicationFramesForm\" id=\"TrmtComplicationFramesForm\" >\n\t\t\t<input type=\'hidden\' name=\'task_cmplication_cmpl_yn\' id=\'task_cmplication_cmpl_yn\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >\n\t\t\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);

	String complication_title = "";
	String trmt_desc = "";
	String site_type=checkForNull(request.getParameter("site_type"));
	String display_tooth_no=checkForNull(request.getParameter("display_tooth_no"));
	String params = request.getQueryString();	
	String task_code_req = checkForNull(request.getParameter("task_code"));
	String task_cmplication_cmpl_yn="";
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
	String trmt_code=checkForNull(request.getParameter("trmt_code"));
	String task_desc=checkForNull(request.getParameter("task_desc"));
	String super_tooth_ref=checkForNull(request.getParameter("super_tooth_ref"));
	String super_key_num=checkForNull(request.getParameter("super_key_num"));
	String tooth_no=checkForNull(request.getParameter("tooth_no"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String area_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.area.label","common_labels");//Added by Sridevi Joshi on 5/17/2010 for IN021414 

    if(("undefined").equals(super_key_num))
	{
		super_key_num="";
	}
	

	Connection connection   = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
    try{
		connection  =  ConnectionManager.getConnection(request);
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		pstmt=connection.prepareStatement("SELECT TRMT_DESC FROM OH_TREATMENT  WHERE TRMT_CODE = ?");
		pstmt.setString(1,trmt_code);
		rs = pstmt.executeQuery();
		while(rs.next()){
			trmt_desc = rs.getString("TRMT_DESC");
		}

		if(super_tooth_ref.equals("RD")){
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			pstmt = connection.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = (SELECT MAPPED_TOOTH_NO FROM OH_TOOTH WHERE TOOTH_NO = ?) AND NUMBERING_SYSTEM = ?");
			pstmt.setString(1,tooth_no);
			pstmt.setString(2,tooth_numbering_system);
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				display_tooth_no = checkForNull(rs.getString("NS_TOOTH_NO"));
			}
		}
	}
	catch(Exception ee){
	System.err.println("Exception=="+ee);
	}
	finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(connection!=null) ConnectionManager.returnConnection(connection,request);
	 }catch(Exception es){es.printStackTrace();}
	}
		
	if(site_type.equals("ARCH") || site_type.equals("QUAD")){
		if(!task_code_req.equals("")){
			complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
			complication_title = complication_title+" "+trmt_desc+","+display_tooth_no;
			complication_title = complication_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			complication_title = complication_title+" "+task_desc;
		}
		else{
			complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
			complication_title = complication_title+" "+trmt_desc+","+display_tooth_no;
		}
	}
	else if(site_type.equals("MAXFS")){//Added by Sridevi Joshi on 5/17/2010 for IN021414 
		if(!task_code_req.equals("")){
			complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
			complication_title = complication_title+" "+trmt_desc+","+area_legend+" "+display_tooth_no;
			complication_title = complication_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			complication_title = complication_title+" "+task_desc;
		}
		else{
			complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
			complication_title = complication_title+" "+trmt_desc+","+area_legend+" "+display_tooth_no;
		}
	}
	else{
		if(!task_code_req.equals("")){
			if(display_tooth_no.equals("")){//Added by Sridevi Joshi on 5/17/2010 for IN021434 
				complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
				complication_title = complication_title+" "+trmt_desc;
			}
			else{
				complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
				complication_title = complication_title+" "+trmt_desc+",";
				if(("").equals(super_key_num) || super_tooth_ref.equals("RD")){
					complication_title = complication_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" ("+display_tooth_no+")";
				}else{
					complication_title = complication_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" "+super_key_num+"["+display_tooth_no+"]";
				}
			}
			complication_title = complication_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			complication_title = complication_title+" "+task_desc;
		}
		else{
			if(display_tooth_no.equals("")){//Added by Sridevi Joshi on 5/17/2010 for IN021434 
				complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
				complication_title = complication_title+" "+trmt_desc;
			}
			else{
				complication_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ComplicationDetailsFor.Label","oh_labels"); 
				complication_title = complication_title+" "+trmt_desc+",";
				if(("").equals(super_key_num) || super_tooth_ref.equals("RD")){
					complication_title = complication_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" ("+display_tooth_no+")";
				}else{
					complication_title = complication_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" "+super_key_num+"["+display_tooth_no+"]";
				}
			}
		}
	}

							

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(complication_title));
            _bw.write(_wl_block6Bytes, _wl_block6);
  
		try{
			  String sql_trmt_dtls= "SELECT TASK_CMPLICATION_CMPL_YN TASK_CMPLICATION_CMPL_YN1 FROM OH_RESTORATIVE_CHART_TASKS where PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE= ?";
			  connection	= ConnectionManager.getConnection(request);
			  pstmt=connection.prepareStatement(sql_trmt_dtls);
			  pstmt.setString(1,patient_id); 
			  pstmt.setString(2,chart_num); 
			  pstmt.setString(3,chart_line_num); 
			  pstmt.setString(4,trmt_code); 
			  rs=pstmt.executeQuery();
			  if(rs.next()){
				task_cmplication_cmpl_yn=checkForNull(rs.getString("TASK_CMPLICATION_CMPL_YN1"));
			  }
		}catch(Exception ee){
			System.err.println("Exception=="+ee);
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) ConnectionManager.returnConnection(connection,request);
			 }catch(Exception es){es.printStackTrace();}
		}
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( params ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( params ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(task_cmplication_cmpl_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
