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

public final class __dtissuefileoutstandinglist1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTIssueFileOutstandingList1.jsp", 1709116819575L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\" ></script>\n\t<script src=\'../../eFM/js/FMIssueFiles.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<script>\n\tfunction OnSelect(locations,s_file_no,no_of_days,facid,noofrecs,resLocnIdentities,strLocn, s_file_type, s_volume_no)\n\t{\n\t\tparent.frames[2].location.href = \"../../eFM/jsp/DTIssueFileOutstandingHeader.jsp?Locations=\"+locations+\"&s_file_no=\"+s_file_no+\"&no_of_days=\"+no_of_days+\"&facid=\"+facid+\"&noofrecs=\"+noofrecs+\"&resLocnIdentities=\"+resLocnIdentities+\"&issueLocn=\"+strLocn+\"&s_file_type=\"+s_file_type+\"&s_volume_no=\"+s_volume_no;\n\t\tparent.frames[3].location.href = \"../../eCommon/html/blank.html\";\n\t\tparent.frames[4].location.href = \"../../eCommon/html/blank.html\";\n\t}\n</script>\n\n<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n<form name=\'IssueFilesOutstandingList1_form\' id=\'IssueFilesOutstandingList1_form\'>\n  \t<table id=\'tb1\' border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\'100%\'>\n\t<th><font size=\'1\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</font></th>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</table>\n<input type=\'hidden\' name=\'noofrecs\' id=\'noofrecs\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n</form>\n<SCRIPT>\n\tparent.frames[1].location.href = \"../../eFM/jsp/DTIssueFileOutstandingList2.jsp?userSecurity=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&access_all=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&resLocnIdentities=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&strLocn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&s_file_no=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&s_fs_locn_code=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&s_fs_narration=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&s_request_date=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&s_request_by_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&s_file_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&s_volume_no=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\tOnSelect(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\', \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\') ;\n\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n</SCRIPT>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
		String resLocnIdentities = request.getParameter("resLocnIdentities");
		String strLocn = request.getParameter("strLocn");
		String s_file_no			= request.getParameter("s_file_no");
		String s_fs_locn_code		= request.getParameter("s_fs_locn_code");
		String s_fs_narration		= request.getParameter("s_fs_narration");
		String s_request_date		= request.getParameter("s_request_date");
		String s_request_by_id		= request.getParameter("s_request_by_id");
		String s_fs_locn_identity	= request.getParameter("s_fs_locn_identity");

		String s_file_type			= request.getParameter("s_file_type");
		String s_volume_no			= request.getParameter("s_volume_no");
		String access_all			= request.getParameter("access_all")==null?"":request.getParameter("access_all");

		s_file_type	=	((s_file_type==null) || (s_file_type.equals("null"))) ? "" : s_file_type;
		s_volume_no	=	((s_volume_no==null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;


		if(strLocn == null || strLocn.equals("null"))
			strLocn = "SelectAll";

		PreparedStatement pstmt	= null;
		ResultSet rs1=null;			

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer			  = new StringBuffer();
		int ReqnoList1 = 0;
		int ReqnoList2 = 0;
		int indentity_cnt	=	0;		
		String identity		=	"";
		String identity_temp=	"";		
			
		String locations = "";
		String locnname = "";		
		String fac_id = "";
		String no_of_days = "";

		String firstLocn = "";
		String firstFacid = "";		

		int i=1;
		int rowid=1;

	try {
		if(userSecurity.equals("Y")) {
		

			if (access_all.equals("*ALL")) {
				SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, DECODE (b.req_fs_locn_identity, 'N', 'Nursing Unit', 'C', 'Clinic', 'D', 'Department', 'T', 'Practitioner','E','Procedure Unit','Y','Daycare Unit') identity, COUNT (a.file_no) cnt, SUM (COUNT (a.file_no)) OVER (PARTITION BY b.req_fs_locn_identity) indentity_cnt FROM FM_REQ_DTL A, FM_REQ_HDR_VW B WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID = A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.CANCEL_YN = 'N' and A.DOC_FOLDER_ID is not null ");
			}
			else {
				SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, DECODE (b.req_fs_locn_identity, 'N', 'Nursing Unit', 'C', 'Clinic', 'D', 'Department', 'T', 'Practitioner','E','Procedure Unit','Y','Daycare Unit') identity, COUNT (a.file_no) cnt, SUM (COUNT (a.file_no)) OVER (PARTITION BY b.req_fs_locn_identity) indentity_cnt FROM FM_REQ_DTL A, FM_REQ_HDR_VW B, FM_USER_ACCESS_RIGHTS C WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID = A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND C.FACILITY_ID = A.REQ_TO_FACILITY_ID AND C.APPL_USER_ID = '"+user_id+"' AND C.FS_LOCN_CODE = A.REQ_TO_FS_LOCN_CODE AND C.ISS_YN = 'Y' AND A.CANCEL_YN = 'N' and A.DOC_FOLDER_ID is not null ");
			}
		}
		else {
				SelectSqlBuffer.append("SELECT B.REQ_FACILITY_ID, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, DECODE (b.req_fs_locn_identity, 'N', 'Nursing Unit', 'C', 'Clinic', 'D', 'Department', 'T', 'Practitioner','E','Procedure Unit','Y','Daycare Unit') identity, COUNT (a.file_no) cnt, SUM (COUNT (a.file_no)) OVER (PARTITION BY b.req_fs_locn_identity) indentity_cnt FROM FM_REQ_DTL A, FM_REQ_HDR_VW B WHERE A.REQ_TO_FACILITY_ID = '"+facility_id+"' AND A.REQ_TO_FS_LOCN_CODE = '"+strLocn+"' AND A.ISS_YN = 'N' AND A.REQ_NO = B.REQ_NO AND B.REQ_FACILITY_ID = A.REQ_TO_FACILITY_ID AND B.ISS_COMPLETED_YN = 'N' AND A.CANCEL_YN = 'N' and A.DOC_FOLDER_ID is not null");
		}

		if (!(facility_id.equals("null") || facility_id.equals("") ))
			SelectSqlBuffer.append("AND B.REQ_FACILITY_ID='"+facility_id+"' ");

		if (!(s_file_no.equals("null") || s_file_no.equals("") ))
			SelectSqlBuffer.append("AND A.FILE_NO = '"+s_file_no+"' ");
		
		if ((!s_file_type.equals("")) && (!s_file_type.equals("null")))
			SelectSqlBuffer.append("AND A.DOC_TYPE_CODE = '"+s_file_type+"' ");

		if ((!s_volume_no.equals("")) && (!s_volume_no.equals("null")))
			SelectSqlBuffer.append("AND A.VOLUME_NO = '"+s_volume_no+"' ");

		if (!(s_fs_locn_code.equals("null") || s_fs_locn_code.equals("") ))
			SelectSqlBuffer.append("AND B.REQ_FS_LOCN_CODE = '"+s_fs_locn_code+"' ");

		if (!(s_request_by_id.equals("null") || s_request_by_id.equals("") ))
			SelectSqlBuffer.append("AND B.REQ_BY = '"+s_request_by_id+"' ");

		if (!(s_fs_narration.equals("null") || s_fs_narration.equals("") ))
			SelectSqlBuffer.append("AND B.NARRATION_CODE = '"+s_fs_narration+"' ");

		if (!(s_fs_locn_identity.equals("null") || s_fs_locn_identity.equals("") ))
			SelectSqlBuffer.append("AND B.REQ_FS_LOCN_IDENTITY = '"+s_fs_locn_identity+"' ");

		if (!(s_request_date.equals("null") || s_request_date.equals("") ))
			SelectSqlBuffer.append("AND TO_DATE(TO_CHAR(TRUNC(B.ADDED_DATE),'dd/mm/yyyy'),'dd/mm/yyyy') = TO_DATE('"+s_request_date+"','dd/mm/yyyy') ");

		SelectSqlBuffer.append("Group by B.REQ_FACILITY_ID, b.req_fs_locn_identity, B.REQ_FS_LOCN_CODE, B.FS_LOCN_SHORT_DESC, B.NO_OF_DAYS_TO_RETURN, A.REQ_TO_FS_LOCN_CODE ");
		
		i = 1;
	
		pstmt	= conn.prepareStatement(SelectSqlBuffer.toString());
		rs1		= pstmt.executeQuery();
		if(rs1 != null) {
			while ( rs1.next() ) {				

				fac_id		= rs1.getString("REQ_FACILITY_ID");
				locations	= rs1.getString("REQ_FS_LOCN_CODE");
				locnname	= rs1.getString("FS_LOCN_SHORT_DESC");
				no_of_days	= rs1.getString("NO_OF_DAYS_TO_RETURN");
				ReqnoList1  = rs1.getInt("CNT");
				identity	 = rs1.getString("identity");
				indentity_cnt = rs1.getInt("indentity_cnt");

				if(no_of_days == null || no_of_days.equals("null"))
					no_of_days = "";

				if(i == 1)
				{
					firstLocn = rs1.getString("REQ_FS_LOCN_CODE");
					firstFacid = rs1.getString("REQ_FACILITY_ID");
					ReqnoList2 = rs1.getInt("CNT");
				}

				if(ReqnoList1 > 0)
				{
				if (!identity_temp.equals(identity))
				{
				rowid++;
				out.println("<tr><td class=QRYEVEN><font size='1'><b>");
				out.println(identity+" ("+indentity_cnt+")</b></font></td></tr>");
				}				
				out.println("<tr><td class=QRYEVEN><font size='1'>");
				out.println("&nbsp;&nbsp;<a name='"+rowid+"' onClick='changeRowColor(this,1)' href=\"javascript:OnSelect('"+locations+"','"+s_file_no+"','"+no_of_days+"','"+fac_id+"','"+ReqnoList1+"','"+resLocnIdentities+"','"+strLocn+"','"+s_file_type+"', '"+s_volume_no+"')\">");
				out.println(locnname+"</a> ("+ReqnoList1+")</font></td></tr>");
				i++;
				rowid++;
				identity_temp = identity;
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
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(access_all));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(s_file_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(s_fs_locn_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s_fs_narration));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(s_request_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(s_request_by_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(s_file_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(s_volume_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(firstLocn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(s_file_no));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(firstFacid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ReqnoList2));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strLocn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(s_file_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(s_volume_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FromLoggedInFacility.label", java.lang.String .class,"key"));
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
