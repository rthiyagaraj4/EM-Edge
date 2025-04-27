package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmissuefilemanualdisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIssueFileManualDisplay.jsp", 1709116857735L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form name=\"Dispalyvals\" id=\"Dispalyvals\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t\tparent.frames[3].document.forms[0].currfilelocn.value\t= \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" (";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =")\';\n\t\t\tparent.frames[3].document.forms[0].filestat.value\t\t= \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\tparent.frames[3].document.forms[0].remarks.value\t\t= \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\tparent.frames[3].document.forms[0].Req_on.value\t\t\t= \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\tparent.frames[3].document.forms[0].Curr_facility_id.value\t= \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\tparent.frames[3].document.forms[0].Curr_locn_code.value\t\t= \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\tparent.frames[3].document.forms[0].Curr_locn_desc.value\t\t= \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\tparent.frames[3].document.forms[0].Curr_locn_iden.value\t\t= \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\tparent.frames[3].document.forms[0].Curr_locn_mr_locn.value\t= \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\t\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	ResultSet rs			= null;

	try
	{
		String currFacility = "";
		String currLocn		= "";
		String currDesc		= "";
		String currStatDesc = "";
		String currIden		= "";
		String currIdDesc	= "";
		String currMrLocn	= "";
		String remark		= "";
		String sysdate		= "";

		String facility_id = (String) session.getValue("facility_id");
		String FileNo = request.getParameter("FileNo");

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();

		//SelectSqlBuffer.append("Select CURR_FS_LOCN_CODE, CURR_FILE_STATUS, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN, CURR_FACILITY_ID,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , REMARKS, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW where FILE_NO = ? and FACILITY_ID = ?");
		SelectSqlBuffer.append("SELECT" );
		SelectSqlBuffer.append("  CURR_FS_LOCN_CODE" );
		SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
		SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
		SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
		SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
		SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
		SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
		SelectSqlBuffer.append("  , REMARKS" );
		SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
		SelectSqlBuffer.append("FROM" );
		SelectSqlBuffer.append("  FM_CURR_LOCN " );
		SelectSqlBuffer.append("WHERE FILE_NO = ? " );
		SelectSqlBuffer.append("  AND FACILITY_ID = ?" );
		
		pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		pstmt.setString(1,FileNo);
		pstmt.setString(2,facility_id);
		rs = pstmt.executeQuery();

		if(rs != null && rs.next())
		{
			currFacility	= rs.getString("CURR_FACILITY_ID");
			currLocn		= rs.getString("CURR_FS_LOCN_CODE");
			currMrLocn		= rs.getString("CURR_MR_LOCN_YN");
			currStatDesc	= rs.getString("FILE_STATUS_DESC"); 
			currDesc		= rs.getString("CURR_FS_LOCN_DESC");
			currIden		= rs.getString("CURR_FS_LOCN_IDENTITY");
			currIdDesc		= rs.getString("LOCN_IDENTITY_DESC");
			remark			= rs.getString("REMARKS");
			sysdate			= rs.getString("SYDATE");
		}

			if(!currStatDesc.equals(""))
			{
				switch(currStatDesc.charAt(0))
				{
					case 'T' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

					case 'E' : currStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherFacility.label","common_labels"); break;
			
				}
			}

		if(!currIdDesc.equals(""))
		{
			switch(currIdDesc.charAt(0))
			{
				case 'D' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : currIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}

		if(remark == null || remark.equals("null")) remark = "";

		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(currDesc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(currIdDesc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(currStatDesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(remark));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(currFacility));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(currLocn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(currDesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(currIden));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(currMrLocn));
            _bw.write(_wl_block18Bytes, _wl_block18);

	if (rs!=null) rs.close();
	if (pstmt!=null) pstmt.close();
	}catch(Exception e){out.println("In Exception :"+e.toString()); e.printStackTrace();}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
