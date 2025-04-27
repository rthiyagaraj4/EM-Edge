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

public final class __fmissuefileoutstandingheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIssueFileOutstandingHeader.jsp", 1709116859219L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMIssueFiles.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/rowcolor.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n\t<form name=\'IssueOutstandingHeader\' id=\'IssueOutstandingHeader\'>\n\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\'100%\'>\n\t\t\t<tr><td id=\'rowtitle\' class=\'label\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b></td><tr>\n\t\t\t</table>\n\t\t\t<table id=\'tb1\' border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\'100%\'>\n\t\t\t<tr><th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th></tr>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</table>\n\t\n\t<script> \n\t\tdocument.getElementById(\"rowtitle\").innerHTML=\"<b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b>\"; </script>\n\t<!--  <script> submitAllDetails1(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\", \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\") </script>\n\t\n\t-->\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con				= ConnectionManager.getConnection(request);
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	
	String Title				= "";
	String Firreqon				= "";
	String Firreqno				= "";
	String Firreqfacilityid		= "";
	String Firreqfacilityname	= "";
	String Firreqfslocncode		= "";
	String Firreqfslocndesc		= "";
	String Firreqfslocnidentity	= "";
	String Firreqlocnismrlocnyn	= "";
	String Firreqby				= "";
	String Firreqbyname			= "";
	String Firnarrationcode		= "";
	String Firnarrationdesc		= "";
	String classValue			= "";
	String facility_id			= "";
	String resLocnIdentities	= "";
	String Locations			= "";
	String no_of_days			= "";
	String fac_id				= "";
	String no_of_recs			= "";
	String issueLocn			= "";
	String s_file_no			= "";
	String s_file_type			= "";
	String s_volume_no			= "";
	String file_type_yn			= "";
	String reqfslocnidendesc	= "";
	String Reqfslocnid			= "";

	StringBuffer SelectSqlBuffer = null;
	SelectSqlBuffer				 = new StringBuffer();	
	
	int reccount	= 0;
	int i			= 1;
	int rowid		= 1;

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Title));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	try
	{
		facility_id			= (String) session.getValue("facility_id");
		String userSecurity			= checkForNull(request.getParameter("userSecurity"));
		String strLocn				= checkForNull(request.getParameter("strLocn"));

		
		String access_all			= request.getParameter("access_all")==null?"":request.getParameter("access_all");

		resLocnIdentities	= request.getParameter("resLocnIdentities");
		Locations			= request.getParameter("Locations");
		no_of_days			= request.getParameter("no_of_days");
		fac_id				= request.getParameter("facid");
		no_of_recs			= request.getParameter("noofrecs");
		issueLocn			= request.getParameter("issueLocn");
		s_file_no			= request.getParameter("s_file_no");
		s_file_type			= request.getParameter("s_file_type");
		s_volume_no			= request.getParameter("s_volume_no");
		file_type_yn		= request.getParameter("file_type_yn");
		
		s_file_type	= ((s_file_type == null) || (s_file_type.equals("null"))) ? "" : s_file_type;
		s_volume_no	= ((s_volume_no == null) || (s_volume_no.equals("null"))) ? "" : s_volume_no;

	
		SelectSqlBuffer.append("Select to_char(A.ADDED_DATE,'DD/MM/YYYY HH24:MI') REQ_ON, A.REQ_NO, A.REQ_FACILITY_ID, A.REQ_FACILITY_NAME, A.REQ_FS_LOCN_CODE, A.REQ_FS_LOCN_DESC, A.REQ_BY, A.REQ_BY_NAME, A.NARRATION_CODE, A.NARRATION_DESC, DECODE(A.req_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') IDENTITY, A.req_fs_LOCN_IDENTITY LOCN_IDENTITY, A.MR_LOCN_YN, Count(C.FILE_NO) CNT, A.REQUESTING_FROM_DESC, A.REQUESTING_FROM,C.FILE_NO,C.VOLUME_NO from FM_REQ_HDR_VW A, FM_REQ_DTL C, FM_CURR_LOCN D WHERE A.REQ_FACILITY_ID = ? AND A.REQ_FS_LOCN_CODE = ? AND A.ISS_COMPLETED_YN = 'N' AND A.REQ_NO = C.REQ_NO AND C.FILE_NO = D.FILE_NO AND C.VOLUME_NO = D.VOLUME_NO AND C.REQ_TO_FACILITY_ID = ? AND  C.REQ_TO_FS_LOCN_CODE = ? AND C.ISS_YN = 'N' AND C.DOC_TYPE_CODE is null  AND C.CANCEL_YN='N' AND A.REQ_FS_LOCN_CODE != D.CURR_FS_LOCN_CODE ");
		
		if(!(s_file_no.equals("null") || s_file_no.equals("")))
			SelectSqlBuffer.append("AND C.FILE_NO = '"+s_file_no+"' ");
		
		if((!s_volume_no.equals("")) && (!s_volume_no.equals("null")))
			SelectSqlBuffer.append("AND C.VOLUME_NO = '"+s_volume_no+"' ");
	
		SelectSqlBuffer.append("GROUP BY A.ADDED_DATE, A.REQ_NO, A.REQ_FACILITY_ID, A.REQ_FACILITY_NAME, A.REQ_FS_LOCN_CODE, A.REQ_FS_LOCN_DESC, A.REQ_BY, A.REQ_BY_NAME, A.NARRATION_CODE, A.NARRATION_DESC, A.req_fs_LOCN_IDENTITY, A.MR_LOCN_YN, A.REQUESTING_FROM_DESC,A.REQUESTING_FROM,C.FILE_NO,C.VOLUME_NO ORDER BY A.ADDED_DATE DESC");
		
		pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		
		pstmt.setString(1,fac_id);
		pstmt.setString(2,Locations);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,issueLocn);
		
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			if(i % 2 == 0) classValue = "QRYEVEN" ;
			else classValue = "QRYODD" ;

				if(i == 1)
				{
					Firreqon				= rs.getString("REQ_ON");
					Firreqno				= rs.getString("REQ_NO");
					Firreqfacilityid		= rs.getString("REQ_FACILITY_ID");
					Firreqfacilityname		= rs.getString("REQ_FACILITY_NAME");
					Firreqfslocncode		= rs.getString("REQ_FS_LOCN_CODE");
					Firreqfslocndesc		= rs.getString("REQ_FS_LOCN_DESC");
					Firreqfslocnidentity	= rs.getString("LOCN_IDENTITY");
					Firreqlocnismrlocnyn	= rs.getString("MR_LOCN_YN");
					Firreqby				= rs.getString("REQ_BY");
					Firreqbyname			= rs.getString("REQ_BY_NAME");
					Firnarrationcode		= rs.getString("NARRATION_CODE");
					Firnarrationdesc		= rs.getString("NARRATION_DESC");
					Reqfslocnid				= rs.getString("REQUESTING_FROM");
					
				}

				String reqon				= rs.getString("REQ_ON");
				String reqno				= rs.getString("REQ_NO");
				String reqfacilityid		= rs.getString("REQ_FACILITY_ID");
				String reqfacilityname		= rs.getString("REQ_FACILITY_NAME");
				String reqfslocncode		= rs.getString("REQ_FS_LOCN_CODE");
				String reqfslocndesc		= rs.getString("REQ_FS_LOCN_DESC");
				String reqfslocnidentity	= rs.getString("LOCN_IDENTITY");
				reqfslocnidendesc	= rs.getString("REQUESTING_FROM_DESC");	
				String reqlocnismrlocnyn	= rs.getString("MR_LOCN_YN");
				String reqby				= rs.getString("REQ_BY");
				String reqbyname			= rs.getString("REQ_BY_NAME");
				String narrationcode		= rs.getString("NARRATION_CODE");
				String narrationdesc		= rs.getString("NARRATION_DESC");
				String Reqlocnid			= rs.getString("REQUESTING_FROM");
				reccount					= rs.getInt("CNT");
				s_file_no					= rs.getString("FILE_NO"); 

				if(narrationdesc == null) narrationdesc = "&nbsp;";
				if(reqfslocndesc == null) reqfslocndesc = "";
				if((reqfslocnidendesc == null) || (reqfslocnidendesc.equals("null"))) 						reqfslocnidendesc = "&nbsp;";
				if(reqbyname == null) reqbyname = "";
				if(reqfacilityname == null) reqfacilityname = "";
				if(Reqfslocnid == null) Reqfslocnid = "";
				if(Reqlocnid == null) Reqlocnid = "";

				Title = "Request of File(s) From : "+reqfacilityname+" - "+reqfslocndesc+" ("+reqfslocnidendesc+")";

				if(reccount > 0)
				{
					out.println("<tr><td class='"+classValue+"'><font size='1'>");
					out.println("<a name='"+rowid+"' onClick='changeRowColor(this,6)'	href='javascript:submitAllDetails1(\""+userSecurity+"\",\""+access_all+"\",\""+resLocnIdentities+"\",\""+strLocn+"\",\""+reqon+"\",\""+reqno+"\",\""+reqfacilityid+"\",\""+java.net.URLEncoder.encode(reqfacilityname)+"\", \""+reqfslocncode+"\",\""+java.net.URLEncoder.encode(reqfslocndesc)+"\",\""+reqfslocnidentity+"\",\""+reqlocnismrlocnyn+"\",\""+java.net.URLEncoder.encode(reqby)+"\",\""+java.net.URLEncoder.encode(reqbyname)+"\",\""+narrationcode+"\",\""+java.net.URLEncoder.encode(narrationdesc)+"\",\""+s_file_no+"\",\""+no_of_days+"\",\""+no_of_recs+"\",\""+resLocnIdentities+"\",\""+issueLocn+"\",\""+s_file_type+"\", \""+s_volume_no+"\", \""+file_type_yn+"\",\""+Reqlocnid+"\")'>");
					out.println(reqon);
					out.println("</a></font></td><td align='right' class='"+classValue+"'><font size='1'>");
					out.println(reccount);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");
					out.println(reqfslocnidendesc);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");
					out.println(reqbyname);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");
					out.println(reqno);
					out.println("</font></td><td class='"+classValue+"'><font size='1'>");

					if(narrationdesc == null || narrationdesc.equals("null")) narrationdesc = "&nbsp;";
					out.println(narrationdesc);
					out.println("</font></td></tr>");

					i++;
					rowid++;
				}
			}

			if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
			{
				SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
			}
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
		}catch(Exception e){out.println(e);}
		finally
		{			
			ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Title));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Firreqon));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firreqno));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firreqfacilityid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firreqfacilityname));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firreqfslocncode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firreqfslocndesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firreqfslocnidentity));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firreqlocnismrlocnyn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firreqby));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firreqbyname));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firnarrationcode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Firnarrationdesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(s_file_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(no_of_recs));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(resLocnIdentities));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(issueLocn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(s_file_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(s_volume_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(file_type_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Reqfslocnid));
            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestedOn.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.NoofFiles.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.RequestedFrom.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestedBy.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestNo.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.ReasonForBorrowing.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
