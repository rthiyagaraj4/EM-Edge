package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __dtissuefileoutstandinglist2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTIssueFileOutstandingList2.jsp", 1709116819716L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\" ></script>\n\t<script src=\'../../eFM/js/FMIssueFiles.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<script>\n\tfunction OnSelect(locations,s_file_no,no_of_days,facid,strLocn, s_file_type, s_volume_no)\n\t{\n\t\tparent.frames[2].location.href = \"../../eFM/jsp/DTIssueFileOutstandingHeader.jsp?Locations=\"+locations+\"&s_file_no=\"+s_file_no+\"&no_of_days=\"+no_of_days+\"&facid=\"+facid+\"&issueLocn=\"+strLocn+\"&s_file_type=\"+s_file_type+\"&s_volume_no=\"+s_volume_no;\n\t\tparent.frames[3].location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.frames[4].location.href = \"../../eCommon/html/blank.html\";\n\t}\n</script>\n\n<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n<form name=\'IssueFilesOutstandingList2_form\' id=\'IssueFilesOutstandingList2_form\'>\n  \t<table id=\'tb1\' border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\'100%\'>\n\t<th><font size=\'1\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</font></th>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</table>\n</form>\n<script>\n\tif(parent.frames[0].document.forms[0].noofrecs.value == 1)\n\t\tOnSelect(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\', \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection conn = ConnectionManager.getConnection(request);
		String facility_id = (String) session.getValue("facility_id");
		String user_id = (String) session.getValue("login_user");
		String userSecurity = request.getParameter("userSecurity");
		String strLocn = request.getParameter("strLocn");
		String s_file_no			= request.getParameter("s_file_no");
		String s_fs_locn_code		= request.getParameter("s_fs_locn_code");
		String s_fs_narration		= request.getParameter("s_fs_narration");
		String s_request_date		= request.getParameter("s_request_date");
		String s_request_by_id		= request.getParameter("s_request_by_id");
		String s_file_type			= request.getParameter("s_file_type");
		String s_volume_no			= request.getParameter("s_volume_no");
		String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
		s_file_type	=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
		s_file_type	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;


		PreparedStatement pstmt		= null;
		ResultSet rs1=null;			

		int ReqnoList2 = 0;
		
		String facname = "";
		String locations = "";
		String locnname = "";		
		String no_of_days = "";
		String prevfacility = "";
		String fac_id = "";			

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();

		int i=1;
		int rowid=2;

		try {
			if(userSecurity.equals("Y")) {
				

				if (access_all.equals("*ALL")) {
					SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, COUNT(A.FILE_NO) CNT FROM FM_REQ_DTL A, FM_REQ_HDR_VW B WHERE	A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID != A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.CANCEL_YN = 'N' ");
				}
				else {
					SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, COUNT(A.FILE_NO) CNT FROM FM_REQ_DTL A, FM_REQ_HDR_VW B, FM_USER_ACCESS_RIGHTS C WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID != A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND C.FACILITY_ID = A.REQ_TO_FACILITY_ID AND C.APPL_USER_ID = '"+user_id+"' AND C.FS_LOCN_CODE = A.REQ_TO_FS_LOCN_CODE AND C.ISS_ACROSS_FACILITIES_YN = 'Y' AND A.CANCEL_YN = 'N' ");
				}
			}
			else {
				SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, COUNT(A.FILE_NO) CNT FROM FM_REQ_DTL A, FM_REQ_HDR_VW B WHERE	A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID != A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.CANCEL_YN = 'N' ");
			}

			if (!(s_file_no.equals("null") || s_file_no.equals("") ))
				SelectSqlBuffer.append("AND A.FILE_NO = '"+s_file_no+"' ");

			if (!(s_file_type.equals("null") || s_file_type.equals("") ))
				SelectSqlBuffer.append("AND A.FILE_TYPE_CODE = '"+s_file_type+"' ");

			if (!(s_volume_no.equals("null") || s_volume_no.equals("") ))
				SelectSqlBuffer.append("AND A.VOLUME_NO = '"+s_volume_no+"' ");

			if (!(s_fs_locn_code.equals("null") || s_fs_locn_code.equals("") ))
				SelectSqlBuffer.append("AND B.REQ_FS_LOCN_CODE = '"+s_fs_locn_code+"' ");

			if (!(s_request_by_id.equals("null") || s_request_by_id.equals("") ))
				SelectSqlBuffer.append("AND B.REQ_BY = '"+s_request_by_id+"' ");

			if (!(s_fs_narration.equals("null") || s_fs_narration.equals("") ))
				SelectSqlBuffer.append("AND B.NARRATION_CODE = '"+s_fs_narration+"' ");

			if (!(s_request_date.equals("null") || s_request_date.equals("") ))
				SelectSqlBuffer.append("AND TO_DATE(TO_CHAR(TRUNC(B.ADDED_DATE),'dd/mm/yyyy'),'dd/mm/yyyy') = TO_DATE('"+s_request_date+"','dd/mm/yyyy') ");


			SelectSqlBuffer.append("GROUP BY B.REQ_FACILITY_ID, B.REQ_FACILITY_NAME, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, A.REQ_TO_FS_LOCN_CODE ");

		pstmt = conn.prepareStatement(SelectSqlBuffer.toString());
		rs1    = pstmt.executeQuery();

		i=1;
		
		if(rs1 != null)
		{
			while ( rs1.next() )
			{				

				fac_id		= rs1.getString("REQ_FACILITY_ID");
				facname		= rs1.getString("REQ_FACILITY_NAME");
				locations	= rs1.getString("REQ_FS_LOCN_CODE");
				locnname	= rs1.getString("FS_LOCN_SHORT_DESC");
				no_of_days	= rs1.getString("NO_OF_DAYS_TO_RETURN");
				ReqnoList2  = rs1.getInt("CNT");

				if(no_of_days == null || no_of_days.equals("null"))
					no_of_days = "";

				if(i == 1)
				{
					out.println("<tr><td class=QRYODD><b><font size='1'>");
					out.println(facname+"</b></font></td></tr>");
					prevfacility = facname;
				}

				if(!(prevfacility.equals(facname)))
				{
					out.println("<tr><td class=QRYODD><b><font size='1'>");
					out.println(facname+"</b></font></td></tr>");
					prevfacility = facname;
					rowid++;
				}

				if(ReqnoList2 > 0)
				{
					out.println("<tr><td class=QRYEVEN><font size='1'>&nbsp;&nbsp;&nbsp;&nbsp;");
					out.println("<a name='"+rowid+"' onClick='changeRowColor(this,1)' href=\"javascript:OnSelect('"+locations+"','"+s_file_no+"','"+no_of_days+"','"+fac_id+"','"+strLocn+"', '"+s_file_type+"', '"+s_volume_no+"')\">");
					out.println(locnname+"</a> ("+ReqnoList2+")</font></td></tr>");
					i++;
					rowid++;
				}
			}
		}
	if(rs1	 !=null)	rs1.close();
	if(pstmt !=null)	pstmt.close();	
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(locations));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(s_file_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(s_file_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(s_volume_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FromOtherFacilities.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
