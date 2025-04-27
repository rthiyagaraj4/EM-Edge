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
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __trmtmatframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/TrmtMatFrames.jsp", 1709119375977L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\t<script src=\"../../eOH/js/TrmtMatDetails.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<iframe name=\"TrmtMatHeaderTitle\" id=\"TrmtMatHeaderTitle\" frameborder=\"0\" noresize src=\"../../eOH/jsp/TrmtMatHeaderTitle.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  style=\"height:20%;width:100vw\"></iframe><iframe name=\"TrmtMatHeaderLabel\" id=\"TrmtMatHeaderLabel\" frameborder=\"0\" src=\"../../eOH/jsp/TrmtMatHeaderLabel.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" noresize style=\"height:3%;width:100vw\"></iframe>\n\t\t<iframe name=\"TrmtMatHeader\" id=\"TrmtMatHeader\" frameborder=\"0\" src=\"../../eCommon/html/blank.html\" noresize style=\"height:45%;width:100vw\"></iframe>\n\t\t<iframe name=\"TrmtMatDetails\" id=\"TrmtMatDetails\" frameborder=\"0\" src=\"../../eCommon/html/blank.html\" noresize style=\"height:20%;width:100vw\"></iframe>\n\t\t<iframe name=\'hidden_frame\' id=\'hidden_frame\'\tframeborder=\"0\" src=\'../../eOH/jsp/CommonMasterObjectCollect.jsp\'  noresize style=\'height:0%;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:40%;width:100vw\'></iframe>\n\t<body  onKeyDown = \'lockKey();\'>\n\t\t<form name=\"TrmtMatFramesForm\" id=\"TrmtMatFramesForm\" >\n\t\t\t<input type=\'hidden\' name=\'trmt_dtls_entry_cmpl_yn\' id=\'trmt_dtls_entry_cmpl_yn\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n\t\t\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block5Bytes, _wl_block5);

	String locale = (String)session.getAttribute("LOCALE");
	String composition_title = "";
	String trmt_desc = "";
	String site_type=checkForNull(request.getParameter("site_type"));
	String display_tooth_no=checkForNull(request.getParameter("display_tooth_no"));
	String params = request.getQueryString();	
	String task_code_req = checkForNull(request.getParameter("task_code"));
	String trmt_dtls_entry_cmpl_yn="";
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
	String trmt_code=checkForNull(request.getParameter("trmt_code"));
	String task_desc=checkForNull(request.getParameter("task_desc"));
	
	String tooth_no=checkForNull(request.getParameter("tooth_no"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String super_tooth_ref=checkForNull(request.getParameter("super_tooth_ref"));//Added by Sridevi Joshi on 2/24/2010 for IN010894 
	String area_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.area.label","common_labels");//Added by Sridevi Joshi on 5/17/2010 for IN021414 
	Connection connection   = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	
	try{
	connection  =  ConnectionManager.getConnection(request);
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
	else if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !site_type.equals("MAXFS")){ //Added by Sridevi Joshi on 2/24/2010 for IN010894 
		display_tooth_no = super_tooth_ref+"["+display_tooth_no+"]";
	}

	
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();
	pstmt=connection.prepareStatement("SELECT TRMT_DESC FROM OH_TREATMENT_lang_vw  WHERE TRMT_CODE = ? and language_id=?");
	//pstmt=connection.prepareStatement("SELECT TRMT_DESC FROM OH_TREATMENT  WHERE TRMT_CODE = ?");
	pstmt.setString(1,trmt_code);
	pstmt.setString(2,locale);//Added by Sridevi Joshi on 8/16/2010 for 
	rs = pstmt.executeQuery();
	while(rs.next()){
		trmt_desc = rs.getString("TRMT_DESC");
	}
		
	if(site_type.equals("ARCH") || site_type.equals("QUAD")){
		if(!task_code_req.equals("")){
			composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
			composition_title = composition_title+" "+trmt_desc+","+display_tooth_no;
			composition_title = composition_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			composition_title = composition_title+" "+task_desc;
		}
		else{
			composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
			composition_title = composition_title+" "+trmt_desc+","+display_tooth_no;
		}
	}
	else if(site_type.equals("MAXFS")){//Added by Sridevi Joshi on 5/17/2010 for IN021414 
		if(!task_code_req.equals("")){
			composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
			composition_title = composition_title+" "+trmt_desc+","+area_legend+" "+display_tooth_no;
			composition_title = composition_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			composition_title = composition_title+" "+task_desc;
		}
		else{
			composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
			composition_title = composition_title+" "+trmt_desc+","+area_legend+" "+display_tooth_no;
		}
	}
	else{
		if(!task_code_req.equals("")){
			if(display_tooth_no.equals("")){//Added by Sridevi Joshi on 5/17/2010 for IN021434 
				composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
				composition_title = composition_title+" "+trmt_desc;
			}
			else{
				composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
				composition_title = composition_title+" "+trmt_desc+",";
				if(super_tooth_ref.equals("") || super_tooth_ref.equals("undefined")){
					composition_title = composition_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" ("+display_tooth_no+")";
				}
				else{
					composition_title = composition_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" "+display_tooth_no+"";
				}
			}
			composition_title = composition_title+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Task.Label","oh_labels");
			composition_title = composition_title+" "+task_desc;
		}
		else{
			if(display_tooth_no.equals("")){//Added by Sridevi Joshi on 5/17/2010 for IN021434 
				composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
				composition_title = composition_title+" "+trmt_desc;
			}
			else{
				composition_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.TreatmentDetailsFor.Label","oh_labels"); 
				composition_title = composition_title+" "+trmt_desc+",";
				if(super_tooth_ref.equals("") || super_tooth_ref.equals("undefined")){
					composition_title = composition_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" ("+display_tooth_no+")";
				}
				else{
					composition_title = composition_title+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothNo.Label","oh_labels")+" "+display_tooth_no+"";
				}
			}
		}
	}

							

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(composition_title));
            _bw.write(_wl_block7Bytes, _wl_block7);
  
		try{
			  String sql_trmt_dtls= "SELECT TRMT_DTLS_ENTRY_CMPL_YN TRMT_DTLS_ENTRY_CMPL_YN1 FROM OH_RESTORATIVE_CHART_TASKS where PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE= ?";
			  connection	= ConnectionManager.getConnection(request);
			  pstmt=connection.prepareStatement(sql_trmt_dtls);
			  pstmt.setString(1,patient_id); 
			  pstmt.setString(2,chart_num); 
			  pstmt.setString(3,chart_line_num); 
			  pstmt.setString(4,trmt_code); 
			  rs=pstmt.executeQuery();
			  if(rs.next()){
				trmt_dtls_entry_cmpl_yn=checkForNull(rs.getString("TRMT_DTLS_ENTRY_CMPL_YN1"));
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
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( params ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( params ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(trmt_dtls_entry_cmpl_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);

}catch(Exception e){
		connection.rollback();
		 System.err.println("Err Msg from TrmtMatFrames.jsp "+e);
	}
   finally{
		 if(rs!=null) rs.close();
		 if(pstmt!=null)pstmt.close();
		 if(connection!=null)
		 ConnectionManager.returnConnection(connection,request);
	}

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
