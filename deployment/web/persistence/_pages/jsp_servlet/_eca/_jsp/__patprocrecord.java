package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patprocrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatProcRecord.jsp", 1742464379928L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n<title>Procedures</title>\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t <script>\n\t\t\talert(getMessage(\"CA_DIAG_PROCEDURE\",\"CA\"));\n\t\t\twindow.close();\n\t\t </script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n <frameset rows=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<frame name=\'frame0\' id=\'frame0\' \tsrc=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 >\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<frame name=\'frame1\' id=\'frame1\' \tsrc=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<frame name=\'frame2\' id=\'frame2\' \tsrc=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=0 noresize scrolling=\'yes\' >\n\t<frame name=\'frame3\' id=\'frame3\' \tsrc=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' frameborder=0 noresize scrolling=\'no\' >\n\t<frame name=\'blankFrameIntermediate\' id=\'blankFrameIntermediate\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\' >\n\t\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<frame name=\'messageFrame\' id=\'messageFrame\' \tsrc=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'yes\' >\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</frameset>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con				= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	boolean func_appl_yn		= true;

	String past_visit="", firstFrameSrc	="", secondFrameSrc	= "", thirdFrameSrc="";
	String facility_id = (String) session.getValue("facility_id");
	String P_pat_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String P_patient_id = request.getParameter("patient_id");
	String P_encounter_id = request.getParameter("episode_id");
	String P_clinic_code = request.getParameter("location_code");
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
	String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String query_string = request.getQueryString() == null? "" :request.getQueryString();
	query_string = query_string + "&Encounter_Id="+P_encounter_id+"&Clinic_Code="+P_clinic_code+"&Patient_Id="+P_patient_id;
	query_string = query_string + "&p_called_from_widget="+p_called_from_widget ; 	//CHL-CRF [IN035950]
	
	String rows="";
	try
	{
		con	=	ConnectionManager.getConnection(request);
  	    pstmt = con.prepareStatement("select ca_get_func_appl_past_visit(?,?,?,?,?) from dual");
		pstmt.setString(1,facility_id);		// facid
        pstmt.setString(2,"PROCEDURE");		// p_function
        pstmt.setString(3,P_encounter_id);  // p_episode_id
        pstmt.setString(4,P_pat_class);     // p_episode_type
        pstmt.setString(5,P_patient_id);

		rs = pstmt.executeQuery();
        while(rs!=null && rs.next())
        {
          past_visit = rs.getString(1);
        }
        if(rs!=null) rs.close();
        if(pstmt!=null) pstmt.close();

       if(past_visit!=null && past_visit.equalsIgnoreCase("FALSE"))
       {
         func_appl_yn = false;
		 
            _bw.write(_wl_block7Bytes, _wl_block7);

       }
		if(rs!=null) rs.close();
		if(pstmt != null)pstmt.close();
	}
	catch(Exception e)
	{
	//	out.println("Execption in main try"+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181

	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
	if(func_appl_yn)
	{
		firstFrameSrc	=	"ProcQueryResult.jsp?"+query_string+"";
		secondFrameSrc	=	"AddModifyOPProc.jsp?"+query_string+"";
		thirdFrameSrc	=	"PatProcQueryTools.jsp?"+query_string+"";
	}
	else
	{
		firstFrameSrc	=	"../../eCommon/html/blank.html";
		secondFrameSrc	=	"../../eCommon/html/blank.html";
		thirdFrameSrc=	"../../eCommon/html/blank.html";
	}
	
	if(modal_yn.equals("Y"))
	{
		if(mode.equals("OR"))
		{
			rows="9%,*,8%,0%,6%";
		}
		else
		{
			rows="10%,20%,*,6%,0%,6%";
		}
	}else if(!p_called_from_widget.equals("")){  	//CHL-CRF [IN035950]
		rows="20%,66%,6%,0%,8%";					//CHL-CRF [IN035950]
	}else
	{
		rows="20%,70%,8%,0%";
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rows));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(modal_yn.equals("Y")){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
if(!mode.equals("OR")){
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(firstFrameSrc));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(secondFrameSrc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(thirdFrameSrc));
            _bw.write(_wl_block16Bytes, _wl_block16);
	
	//if(modal_yn.equals("Y")){												//CHL-CRF [IN035950]
	if(modal_yn.equals("Y")|| !p_called_from_widget.equals("")){			//CHL-CRF [IN035950]
	
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
