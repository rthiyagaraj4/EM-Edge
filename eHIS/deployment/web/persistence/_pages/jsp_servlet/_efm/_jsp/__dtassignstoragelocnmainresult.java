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
import webbeans.eCommon.RecordSet;
import java.util.*;
import com.ehis.util.*;

public final class __dtassignstoragelocnmainresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTAssignStorageLocnMainResult.jsp", 1709116816560L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\\<!-- by Meghanath -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<html>\n\t<head>\n\t\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eFM/js/FMAssignStorageLocn.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body  onLoad=\'dispRecord(); loadCurrPage();\' onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n\t<form name=\'FMAssnStrLocnMainResultForm\' id=\'FMAssnStrLocnMainResultForm\' action=\'\' method=\'\'>\n\t<P>\n\t<table align=\'right\'>\n\t\t<tr>\n\t\t\t<td>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<A HREF=\'../jsp/FMAssignStorageLocnMainResult.jsp?from=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&to=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="mode=Previous\' onClick=\'checkVal();\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</A>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="mode=next\' onClick=\'checkVal();\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t<br><br>\n\t</P>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<script>\n\t\t\tvar msg =\tgetMessage(\'DOC_ALREADY_ASSIGNED\',\'FM\');\n\t\t\tif(msg!=\"\")\n\t\t\t{\n\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\n\t\t\tparent.FMAssnStrLocnSubResultFrame.document.forms[0].locn_code.disabled = \"true\";\n\t\t</script>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<script>\n\t\t\tvar msg =\tgetMessage(\'NO_RECORDS_FOUND\',\'FM\');\n\t\t\tif(msg!=\"\")\n\t\t\t{\nparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\nparent.FMAssnStrLocnSubResultFrame.document.forms[0].locn_code.disabled = \"true\";\n\t\t</script>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<table cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'100%\' >\n<td width=\'50%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n<td width=\'20%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n<td width=\'20%\' class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n<td width=\'10%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="?</td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<tr id=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t<td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'  width=\'50%\'><font size=\'1\'><B>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</B></font><BR>&nbsp;&nbsp;\n\t\t<font size=\'1\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font>\n\t\t<font size=\'1\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font></td>\n\t\t<TD class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  width=\'20%\'><font size=\'1\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font></TD>\n\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' align=\'center\' width=\'20%\'><select name=\'fs_locn_code";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'fs_locn_code";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' onChange=\'checkAssign(this, \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\");\'><option value=\'\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;------";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="-----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t</select></td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' align=\'center\' width=\'10%\'><input type=\'checkbox\' name=\'associate_yn";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'associate_yn";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" value=\'Y\' onClick=\'CBValue(this,\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\");\'></td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<script>\t\t\tparent.frames[0].document.forms[0].search_dtl.disabled=false;\n\t\t\tparent.frames[0].document.forms[0].reset1.disabled=false;\n\t\t\t</script>\t\t\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n</table>\n<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n</form>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );
int row_count=0;
	
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
            webbeans.eCommon.RecordSet recordSet= null;synchronized(session){
                recordSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("recordSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(recordSet==null){
                    recordSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("recordSet",recordSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection con	=	null;
	java.sql.Statement stmt	=	null;
//	java.sql.Statement stmt1	=	null;
	java.sql.Statement stmt2	=	null;
	ResultSet rs	=	null;
	ResultSet rs1	=	null;

	HashMap htRecord			=	new HashMap();
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();
	//	stmt1	=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
	//	int row_disp	=9;
		int start		= 0 ;
		int end			= 0 ;
		int fm_disp=0, to_disp=0;

		String file_no="", patient_id="", patient_name="", associate_yn="N",associate_yn_prop="", tblrow_id="",classValue="",fs_locn_code="",fs_desc="",fn_locn_code="";
		String locn_identity = "", narration_code="", holder_name="", str="";
		String result_query  = "";
		String check_sql     = "";
		
		String facility_id			=	(String)session.getValue("facility_id");
	//	String login_id				=	(String)session.getValue("login_user");
		String from					=	request.getParameter( "from" ) ;
		String to					=	request.getParameter( "to" ) ;
		String mode					=	request.getParameter("mode") ;
		String file_type_code       =   "";
		String sql_query = "";

		String doc_type_code	= "";
		String doc_type_name	= "";
		String doc_folder_id	= "";
		String doc_folder_name	= "";
		String docline			= "";
		
		if(mode == null || mode.equals("null")) mode="";
		
		if ( from == null )
			start = 1 ;
		    else
			start = Integer.parseInt( from );

		if ( to == null )
	  		end = 9 ;
		else
			end = Integer.parseInt( to ) ;

		if(mode.equals(""))
		{
			str=request.getParameter("whereClause");
			if(str==null)str="";
			if(!(str.equals(""))) recordSet.clearAll();
			if(str==null)str="";
			else str = str.replace('~','%');
						
			result_query="SELECT a.file_no,a.patient_id,a.doc_folder_id,b.doc_folder_name,a.doc_type_code,c.doc_type_name,(CASE WHEN b.patient_period_specific='D' THEN ' ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE  ', ' || GET_PATIENT_LINE(b.PATIENT_ID,'"+localeName+"') END)  docline, a.file_type_code FROM mr_pat_file_index a,fm_doc_folder b,fm_doc_type c WHERE a.fs_locn_code is null AND a.facility_id='"+facility_id+"' AND a.facility_id = b.facility_id(+) AND a.doc_folder_id = b.doc_folder_id(+) AND a.doc_type_code = c.doc_type_code(+) " + str;
			
			rs=stmt.executeQuery(result_query);
			associate_yn="N";
			while(rs != null && rs.next())
			{
					docline				=	rs.getString("docline");
					file_no				=	rs.getString("file_no");
					doc_type_code		=	rs.getString("doc_type_code");
					doc_type_name		=	rs.getString("doc_type_name");
					doc_folder_id		=	rs.getString("doc_folder_id");
					doc_folder_name		=	rs.getString("doc_folder_name");
					patient_id			=	rs.getString("patient_id");
					file_type_code		=	rs.getString("file_type_code");		
					
					if(file_no == null || file_no.equals("null")) file_no = "";
					if(doc_type_code == null || doc_type_code.equals("null")) doc_type_code = "";
					if(doc_type_name == null || doc_type_name.equals("null")) doc_type_name = "";
					if(doc_folder_id == null || doc_folder_id.equals("null")) doc_folder_id = "";
					if(doc_folder_name == null || doc_folder_name.equals("null")) doc_folder_name = "";
					if(patient_id == null || patient_id.equals("null")) patient_id = "";
					if(file_type_code == null || file_type_code.equals("null")) file_type_code = "";
					if(patient_name == null || patient_name.equals("null")) patient_name = "";
					if(docline == null || docline.equals("null")) docline = "";					
					
					htRecord.put("file_no"		  ,	file_no);
					htRecord.put("doc_folder_id"  ,	doc_folder_id);
					htRecord.put("doc_type_code"  ,	doc_type_code);
					htRecord.put("patient_id"	  ,	patient_id);
					htRecord.put("file_type_code" ,	file_type_code);
					htRecord.put("patient_name"	  ,	patient_name);				
					htRecord.put("associate_yn"	  ,	associate_yn);
					htRecord.put("fn_locn_code"	  ,	fn_locn_code);
					htRecord.put("locn_identity"  ,	locn_identity);
					htRecord.put("narration_code" ,	narration_code);
					htRecord.put("holder_name"	  ,	holder_name);
					htRecord.put("docline"	      ,	docline);
			
					recordSet.putObject(htRecord);
			}
			if(rs != null) rs.close();
			row_count				=	recordSet.getSize();
			htRecord.clear();

			fm_disp	=	0;
			to_disp	=	9;
			if(to_disp > (row_count-1))
					to_disp=(row_count-1);
		}
		fm_disp =	start-1;
		to_disp	=	end-1;
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

				if ( !(start <= 1) )
				{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start-9));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end-9));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
				if ( !( (start+9) > row_count ) )
				{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((start+9)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((end+9)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

				}

            _bw.write(_wl_block13Bytes, _wl_block13);

	if(row_count==0)
	{
		check_sql="select a.file_no,a.patient_id,a.doc_folder_id,b.doc_folder_name,a.doc_type_code,c.doc_type_name,(CASE WHEN b.patient_period_specific='D' THEN ' ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE b.patient_id END)  docline,a.file_type_code from mr_pat_file_index a,fm_doc_folder b,fm_doc_type c WHERE a.fs_locn_code is not null and a.facility_id='"+facility_id+"' AND a.facility_id = b.facility_id(+) AND a.doc_folder_id = b.doc_folder_id(+) AND a.doc_type_code = c.doc_type_code(+) "+ str;
	
	
	if(stmt  != null) stmt.close();
	stmt	=	con.createStatement();
	rs		=	stmt.executeQuery(check_sql);
	if(rs.next())
	{

            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	else
	{

            _bw.write(_wl_block15Bytes, _wl_block15);

	}

}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

try
{
/*	Properties prop	=	new Properties();
	prop.put("Statement",stmt1);
	prop.put("login_id",login_id);
	prop.put("facility_id",facility_id);
	rs1	=	eFM.FMUtilities.getStorageLocn(prop);
*/
	for(int i=fm_disp; i<=to_disp; i++)
	{
		classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		htRecord			=	(java.util.HashMap)	recordSet.getObject(i);

		file_no			=	(String)	htRecord.get("file_no");
		doc_folder_id	=	(String)	htRecord.get("doc_folder_id");
		doc_type_code	=	(String)	htRecord.get("doc_type_code");
		patient_id		=	(String)	htRecord.get("patient_id");
		file_type_code	=	(String)	htRecord.get("file_type_code");		
		associate_yn	=	(String)	htRecord.get("associate_yn");
		docline			=	(String)	htRecord.get("docline");

		tblrow_id	=	"tblrow_id"+i;

		if(associate_yn.equals("Y"))
			associate_yn_prop = " CHECKED ";
		else
			associate_yn_prop = " ";

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(((doc_folder_id.equals(""))?"&nbsp;":doc_folder_id)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(((doc_folder_name.equals(""))?"&nbsp;":doc_folder_name)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(((docline.equals(""))?"&nbsp;":docline)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(((doc_type_name.equals(""))?"&nbsp;":doc_type_name)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);


		stmt2	=	con.createStatement();			
						
			sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and permanent_file_area_yn ='Y' and eff_status='E' order by short_desc";				

			rs1		=	stmt2.executeQuery(sql_query);
			
			
				while(rs1 != null && rs1.next())
			{
					fs_locn_code	=	rs1.getString("fs_locn_code");
					fs_desc			=	rs1.getString("short_desc");
					out.println("<option value="+fs_locn_code+">"+fs_desc+"</option>");
			}
			if(rs1 != null) rs1.close();
			if(stmt2  != null) stmt2.close();
		

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(associate_yn_prop));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);

	}

            _bw.write(_wl_block40Bytes, _wl_block40);

	}
	catch(Exception e)
	{
		out.println("Exception@2: "+e);
	}
	//session.putValue("AssignRecordSet",recordSet);

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block44Bytes, _wl_block44);

if(rs != null) rs.close();
if(stmt  != null) stmt.close();
//if(stmt1 != null) stmt1 = null;
}
catch(Exception e)
{
	out.println("Exception :"+e.toString());
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block45Bytes, _wl_block45);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentdetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FSLocation.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.Assign.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
