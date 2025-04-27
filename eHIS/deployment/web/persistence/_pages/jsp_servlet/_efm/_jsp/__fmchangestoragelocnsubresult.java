package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmchangestoragelocnsubresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMChangeStorageLocnSubResult.jsp", 1726738324477L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tPrakash.S\n\tCreated on \t\t:\t10/06/2002\n\tModule\t\t\t:\tFM - Change File Store Location\n\tFunction\t\t:\tThis function is used for Search Sub Result.\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<html>\n\t\t<head>\n\t\t\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eFM/js/FMChangeStorageLocn.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n\t\t<form name=\'FMChngStrLocnSubResultForm\' id=\'FMChngStrLocnSubResultForm\' action=\'\' method=\'\'>\n\t\t<table cellpadding=\'2\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\n\t\t\t<tr><td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t<td width=\'75%\' class=\'fields\'><select name=\'locn_code\' id=\'locn_code\' onChange=\'checkAll(this,\"onchnge\")\'>\n\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="----</option>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\n\t\t</select></td></tr>\n\t\t<input type=\'hidden\' name=\'fm_cnt\' id=\'fm_cnt\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'to_cnt\' id=\'to_cnt\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'CBValStr\' id=\'CBValStr\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'LocnValStr\' id=\'LocnValStr\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'sel_all\' id=\'sel_all\' value=\'false\'>\n        <input type=\'hidden\' name=\'fs_locn\' id=\'fs_locn\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n\t\t<input type=\'hidden\' name=\'maintain_doc_or_file\' id=\'maintain_doc_or_file\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n\t\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" >\n\t\t<input type=\'hidden\' name=\'whereClause\' id=\'whereClause\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"\" >\n\t</table>\n</form>\n<script>\n\tvar maintain_doc_or_file = document.forms[0].maintain_doc_or_file.value;\n\tvar whereClause = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\tvar whereClause1 = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\tvar fs_locn = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\tvar patient_id = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\tvar file_type_code = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";\n\tvar file_type_appl_yn = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\tvar volume_no = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\tvar file_no = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\tvar storage_locn = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\tvar terminaldigit  = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\tvar added_temp_code = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\tif(maintain_doc_or_file == \'D\')\n\t{\n\t\t\n\t\t\n\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eFM/jsp/DTChangeStorageLocnMainResult.jsp\' target=\'FMChngStrLocnMainResultFrame\'><input name=\'whereClause\' id=\'whereClause\' type=\'hidden\' value=\\\"\"+whereClause+\"\\\"><input name=\'whereClause1\' id=\'whereClause1\' type=\'hidden\' value=\\\"\"+whereClause1+\"\\\"><input name=\'patient_id\' id=\'patient_id\' type=\'hidden\' value=\"+patient_id+\"><input name=\'file_type_code\' id=\'file_type_code\' type=\'hidden\' value=\"+file_type_code+\"><input name=\'terminaldigit\' id=\'terminaldigit\' type=\'hidden\' value=\"+terminaldigit+\"><input name=\'added_temp_code\' id=\'added_temp_code\' type=\'hidden\' value=\"+added_temp_code+\"></form></BODY></HTML>\";\n\n\t\tparent.parent.frames[2].document.write(HTMLVal);\n\t\tparent.parent.frames[2].document.form1.submit();\n\t}\n\telse\n\t{\n\t\t//parent.FMChngStrLocnMainResultFrame.location.href=\"../../eFM/jsp/FMChangeStorageLocnMainResult.jsp?file_type_appl_yn=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&whereClause=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&fs_locn=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&file_no=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&volume_no=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\n\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eFM/jsp/FMChangeStorageLocnMainResult.jsp\' target=\'FMChngStrLocnMainResultFrame\'><input name=\'whereClause\' id=\'whereClause\' type=\'hidden\' value=\\\"\"+whereClause+\"\\\"><input name=\'whereClause1\' id=\'whereClause1\' type=\'hidden\' value=\\\"\"+whereClause1+\"\\\"><input name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' type=\'hidden\' value=\"+file_type_appl_yn+\"><input name=\'fs_locn\' id=\'fs_locn\' type=\'hidden\' value=\"+fs_locn+\"><input name=\'file_no\' id=\'file_no\' type=\'hidden\' value=\"+file_no+\"><input name=\'patient_id\' id=\'patient_id\' type=\'hidden\' value=\"+patient_id+\"><input name=\'file_type_code\' id=\'file_type_code\' type=\'hidden\' value=\"+file_type_code+\"><input name=\'volume_no\' id=\'volume_no\' type=\'hidden\' value=\"+volume_no+\"><input name=\'storage_locn\' id=\'storage_locn\' type=\'hidden\' value=\"+storage_locn+\"><input name=\'terminaldigit\' id=\'terminaldigit\' type=\'hidden\' value=\"+terminaldigit+\"><input name=\'added_temp_code\' id=\'added_temp_code\' type=\'hidden\' value=\"+added_temp_code+\"></form></BODY></HTML>\";\n\t\t//alert(HTMLVal);\n\n\t\tparent.parent.frames[2].document.write(HTMLVal);\n\t\tparent.parent.frames[2].document.form1.submit();\n\n\t}\n\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp\';\n</script>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String fs_locn_code	= "", fs_desc = "", fs_locn = "";
	String facility_id	=	(String)session.getValue("facility_id");
	String sql_query ="";
    String added_temp_code=request.getParameter("added_temp_code");
	String patient_id			=   request.getParameter("patient_id");
	String file_type_code		=   request.getParameter("file_type_code");
	String file_no				=   request.getParameter("file_no");
	String volume_no			=   request.getParameter("volume_no");
	String whereClause			=   request.getParameter("whereClause");
	String whereClause1			=   request.getParameter("whereClause1");
	String file_type_appl_yn	=	request.getParameter("file_type_appl_yn");
	String maintain_doc_or_file	=	request.getParameter("maintain_doc_or_file");
	String storage_locn             =request.getParameter("storage_locn");
	fs_locn						    =	request.getParameter("fs_locn");
	String terminaldigit        =	request.getParameter("terminaldigit");
	if(terminaldigit == null || terminaldigit.equals("null"))
		terminaldigit = "";
		if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null"))
		maintain_doc_or_file = "";
	if(patient_id == null || patient_id.equals("null"))
		patient_id = "";
	if(file_type_code == null || file_type_code.equals("null"))
		file_type_code = "";
	if(file_type_appl_yn == null || file_type_appl_yn.equals("null"))
		file_type_appl_yn = "";
	if(whereClause == null || whereClause.equals("null"))
		whereClause = "";
	if(fs_locn==null || fs_locn.equals("null")) fs_locn = "P";
   if(added_temp_code==null || added_temp_code.equals("null")) added_temp_code = "";
	try
	{
		con	 =	ConnectionManager.getConnection(request);

            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

	stmt			= con.createStatement();
/*	Properties prop	= new Properties();
	prop.put("Statement",stmt);
	prop.put("facility_id",facility_id);
	prop.put("fs_locn",fs_locn);
	rs	=	eFM.FMUtilities.getStorageLocn(prop);*/
			
			if(fs_locn.equals("C"))
				{
					//sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and eff_status='E' order by short_desc";
					sql_query = "SELECT fs_Locn_Code  ,fm_Get_desc.Fm_storage_locn('"+facility_id+"',fs_Locn_Code,'"+localeName+"',2) Short_desc FROM FM_STORAGE_LOCN WHERE Facility_Id = '"+facility_id+"'     AND eff_Status = 'E' ORDER BY Short_desc";

				}
				else
				{
							sql_query = "SELECT fs_Locn_Code ,fm_Get_desc.Fm_storage_locn('"+facility_id+"',fs_Locn_Code,'"+localeName+"',2) Short_desc FROM  FM_STORAGE_LOCN WHERE Facility_Id = '"+facility_id+"'    AND Permanent_File_Area_yn = 'Y'  AND eff_Status = 'E'   ORDER BY Short_desc";

				}

				rs		=	stmt.executeQuery(sql_query);
			
			
				while(rs != null && rs.next())
	{
		fs_locn_code	= rs.getString("fs_locn_code");
		fs_desc			= rs.getString("short_desc");
		out.println("<option value="+fs_locn_code+">"+fs_desc+"</option>");
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(whereClause));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(whereClause1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(storage_locn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(terminaldigit));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(added_temp_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(whereClause));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block29Bytes, _wl_block29);

if(rs !=null)	 rs.close();
if(stmt != null) stmt.close();
}
catch(Exception e)
{
	out.println("Exception while fetching connection"+e);
	e.printStackTrace();
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FSLocation.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
