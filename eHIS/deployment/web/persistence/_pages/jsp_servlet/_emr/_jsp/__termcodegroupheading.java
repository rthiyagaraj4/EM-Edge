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
import eCommon.XSSRequestWrapper;

public final class __termcodegroupheading extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TermCodeGroupHeading.jsp", 1709119102692L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- modified by arvind for adding search criteria on 27-07-2004 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nvar prevClassName = \"\";\nvar prevRowObject = \"\";\nfunction changeRowColor(obj, changeClassName)\n{\n\tif( changeClassName==null )\tchangeClassName = \"ITEMSELECT\";\n\tif(\tprevClassName != \"\" )\n\t\tfor(i=0; i<prevRowObject.cells.length; i++)\n\t\t\tif(prevRowObject.cells(i).className==changeClassName)\n\t\t\t\tprevRowObject.cells(i).className = prevClassName;\n\n\tprevRowObject\t=\tobj;\n\tprevClassName\t=\tobj.cells(0).className;\n\n    for(i=0; i<obj.cells.length; i++)\n\t\tif(obj.cells(i).className==\"QRYODD\" || obj.cells(i).className == \"QRYEVEN\" ||  obj.cells(i).className == \"\" )\n\t\t\tobj.cells(i).className = changeClassName;\n}\n</script>\n</head>\n<body onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<table  border=\'1\' cellspacing=\'0\' cellpadding=\'0\' id=\'tb1\'>\n<tr>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</table>\n</body>\n</html>\n";
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
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
 Connection conn= null; //(Connection)session.getValue("connection");
// Statement stmt=null;
 PreparedStatement stmt=null;
 ResultSet rset=null;

 String facility_id		=	(String)session.getValue("facility_id");
 String practitioner_id =	(String) session.getValue("ca_practitioner_id");
 practitioner_id		=	(practitioner_id==null)	?	""	:	practitioner_id;
 String Encounter_Id = request.getParameter("Encounter_Id");
 if(Encounter_Id == null) Encounter_Id="0";	
 String Diag_groupcode="";
 String Diag_groupdesc="";
 String diagcode=request.getParameter("p_diag_code");
 String diagdesc=request.getParameter("p_diag_scheme_desc");
 String authorize=request.getParameter("p_auth_yn");
 String cause_indicator = request.getParameter("cause_indicator");
 String code_indicator = (request.getParameter("code_indicator")==null)?"":request.getParameter("code_indicator");


 String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
 String sex =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");

 if(diagcode == null)	diagcode  ="";
 if(diagdesc == null)	diagdesc  ="";
 if(authorize == null)	authorize  ="";
 if(cause_indicator == null)	cause_indicator  ="";



try
{

conn = ConnectionManager.getConnection(request);

/*   	String sql = "SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE diag_code_scheme=( select DIAG_CODE_SCHEME from mr_parameter)  and  (practitioner_id = ? or practitioner_id is null) AND (speciality_code is null or speciality_code IN  (SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = nvl(?,practitioner_id) UNION SELECT speciality_code FROM am_pract_specialities WHERE facility_id = ? AND practitioner_id = ?) )";
*/
String sql = "SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE diag_code_scheme=( select DIAG_CODE_SCHEME from mr_parameter)  and  (practitioner_id = ? or practitioner_id is null) ";
if (!Encounter_Id.equals("0")) 
	sql = sql+" AND (speciality_code is null or speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?)) ";
sql =sql+" ORDER BY diag_group_desc ";


   stmt=conn.prepareStatement(sql);
   stmt.setString(1,practitioner_id);
   if (!Encounter_Id.equals("0")) 
	{
	   stmt.setString(2,facility_id);
	   stmt.setString(3,Encounter_Id);
	}
   rset=stmt.executeQuery();

   rset.next();

            _bw.write(_wl_block4Bytes, _wl_block4);

String classValue="";
int rowCount = 1;

if (rset!=null)
{
do

{
		classValue	=	((rowCount%2)==0)	?	"QRYEVEN"	:	"QRYODD";
		Diag_groupcode=rset.getString("diag_group_code");
		Diag_groupdesc=rset.getString("diag_group_desc");
		//class=\""+classValue+"\"
		  out.println("<tr id=\"tbl_row"+rowCount+"\" style='background-color:;'><td valign='top' class='"+classValue+"'>");
		  out.println("<li><a  href=\"TermCodeCustomFrames.jsp?Diag_code="+Diag_groupcode+"&Diag_desc="+java.net.URLEncoder.encode(Diag_groupdesc)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+java.net.URLEncoder.encode(diagdesc)+"&p_auth_yn="+authorize+"&cause_indicator="+cause_indicator+"&Dob=" + dob + "&Sex=" + sex +"&code_indicator=" + code_indicator    + "\"   onClick=\"changeRowColor(tbl_row"+rowCount+")\" target='code_description'>");
		  out.println(Diag_groupdesc+"</a></td></tr>");
			rowCount++;
 }while (rset.next());
}
 }
     catch  (Exception e) 
	{
		//out.print(e.toString());
		e.printStackTrace();
	}

     finally
     {
		   if (rset!=null) rset.close();
		   if (stmt!=null) stmt.close();
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
