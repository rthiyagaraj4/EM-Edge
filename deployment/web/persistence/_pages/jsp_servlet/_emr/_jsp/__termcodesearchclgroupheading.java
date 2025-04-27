package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __termcodesearchclgroupheading extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TermCodeSearchCLGroupHeading.jsp", 1709119105910L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\nvar prevClassName = \"\";\nvar prevRowObject = \"\";\n\nfunction changeRowColor(obj, changeClassName)\n{\n\tif( changeClassName==null )\tchangeClassName = \"ITEMSELECT\";\n\tif(\tprevClassName != \"\" )\n\t\tfor(i=0; i<prevRowObject.cells.length; i++)\n\t\t\tif(prevRowObject.cells(i).className==changeClassName)\n\t\t\t\tprevRowObject.cells(i).className = prevClassName;\n\n\tprevRowObject\t=\tobj;\n\tprevClassName\t=\tobj.cells(0).className;\n\n    for(i=0; i<obj.cells.length; i++)\n\t\tif(obj.cells(i).className==\"QRYODD\" || obj.cells(i).className == \"QRYEVEN\" ||  obj.cells(i).className == \"\" )\n\t\t\tobj.cells(i).className = changeClassName;\n}\n</script>\n\n</head>\n<body onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<table  border=\'1\' cellspacing=\'0\' cellpadding=\'0\' id=\'tb1\'>\n<tr>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</table>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
 Connection conn= null;
 PreparedStatement stmt=null;
 ResultSet rset=null;

 String queryString			= request.getQueryString();
 String facility_id			=	(String)session.getValue("facility_id");
 String practitioner_id		=	(String) session.getValue("ca_practitioner_id");
 practitioner_id				=	(practitioner_id==null)	?	""	:	practitioner_id;
 String Encounter_Id		= request.getParameter("Encounter_Id");
 if(Encounter_Id == null) Encounter_Id="0";	
 String Diag_groupcode	="";
 String Diag_groupdesc	="";
 String diagcode				=request.getParameter("p_diag_code");
 String diagdesc				=request.getParameter("p_diag_scheme_desc");
 String authorize			=request.getParameter("p_auth_yn");
 String cause_indicator	= request.getParameter("cause_indicator");
 String term_set_id	= request.getParameter("term_set_id");
 String speciality_code	= checkForNull(request.getParameter("speciality_code"));

StringBuffer sql = new StringBuffer();
 	if(diagcode == null)	diagcode  ="";
	if(diagdesc == null)	diagdesc  ="";
	if(authorize == null)	authorize  ="";
	if(cause_indicator == null)	cause_indicator  ="";

	//out.println("<script>alert(\"option_id 1 :"+speciality_code+"\");</script>");			

try
{

	conn = ConnectionManager.getConnection(request);
	

	sql.append( " select a.term_group_id diag_group_code , a.term_group_desc diag_group_desc from MR_TERM_GROUP_HDR a where a.term_set_id = '"+term_set_id+"' and ( a.index_type_yn = 'N' or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='P' and practitioner_id = '"+practitioner_id+"' ) or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='S' and speciality_code = '"+speciality_code+"' ");
		
		if (!Encounter_Id.equals("0")) 
			sql.append(" AND (speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id = '"+facility_id+"' and encounter_id = '"+Encounter_Id+"')) ");
				
		sql.append(" )) and eff_status='E' order by 2 ");

//out.println("<script>alert(\"option_id 1 :"+sql.toString()+"\");</script>");			
   stmt=conn.prepareStatement(sql.toString());
   //stmt.setString(1,practitioner_id);
   
   rset=stmt.executeQuery();

   //rset.next();

            _bw.write(_wl_block4Bytes, _wl_block4);
  
String classValue="";
int rowCount = 0;
	

	while(rset!=null && rset.next())
	{
			classValue	=	((rowCount%2)==0)	?	"QRYEVEN"	:	"QRYODD";
			Diag_groupcode=rset.getString("diag_group_code");
			Diag_groupdesc=rset.getString("diag_group_desc");
			
			out.println("<tr id=\"tbl_row"+rowCount+"\" style='background-color:;'><td valign='top' class='"+classValue+"'>");
			out.println("<li><a  href=\"TermCodeSearchCLFrames.jsp?"+queryString+"&Diag_code="+Diag_groupcode+"&Diag_desc="+java.net.URLEncoder.encode(Diag_groupdesc)+"\" onClick=\"changeRowColor(tbl_row"+rowCount+")\" target='code_description'>");
			out.println(Diag_groupdesc+"</a></td></tr>");
			
			rowCount++;
		}
		
	if (rset!=null) rset.close();
	if (stmt!=null) stmt.close();

	if(rowCount == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
	}

}
catch  (Exception e) {
	 e.printStackTrace();
}

finally
{
   if(conn!=null)
	   ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
