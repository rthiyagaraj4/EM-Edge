package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __openchartwrapperpatlistgetvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/OpenChartWrapperPatListGetValues.jsp", 1709115972779L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=javascript src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=javascript src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=MESSAGE OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n</body>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar a = confirm(getMessage(\"PAT_UNASSIGN\",\"CA\"));\n\t\t\t\t\tvar teamid = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n//\t\t\t\t\talert(teamid);\n\t\t\t\t\tif(a) \n\t\t\t\t\t{\n\t\t\t\t\t\tvar HTMLVal = \"<html><head><link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'></link></head>\";\n\t\t\t\t\t\tHTMLVal += \"<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'><form name=\'OpenChartForm\' id=\'OpenChartForm\' action=\'../../servlet/eCA.CAMainFrameValidateServlet?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' method = \'post\'>\";\n\t\t\t\t\t\tHTMLVal += \"<input type=hidden name=medical_team value=\'\" + teamid + \"\'\";\n\t\t\t\t\t\tHTMLVal += \"<input type=hidden name=insert_op value=\'Y\'\";\n\t\t\t\t\t\tHTMLVal += \"</form>\";\n\t\t\t\t\t\tHTMLVal += \"</body></html>\";\n\t\t\t\t\t\ttop.content.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\t\ttop.content.messageFrame.document.OpenChartForm.submit();\t\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar episodeid = \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'; \n\t\t\t\t\tvar retVal = \tnew String();\n\t\t\t\t\tvar dialogHeight = \"8\";\n\t\t\t\t\tvar dialogWidth  = \"22\";\n\t\t\t\t\tvar dialogTop    = \"250\";\n\t\t\t\t\tvar dialogLeft   = \"190\";\n\t\t\t\t\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status=no; scroll=no; \" ;\n\t\t\t\t\tvar arguments    = \"\" ;\t\t\n\t\t\t\t\tretVal \t \t = window.showModalDialog(\"../../eCA/jsp/PatListSelectMedTeam.jsp?episode_id=\"+episodeid,arguments,features);\n\t\t\t\t\tif(retVal != null)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar HTMLVal = \"<html><head><link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' type=\'text/css\'></link></link></head>\";\n\t\t\t\t\t\tHTMLVal += \"<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'><form name=\'OpenChartForm\' id=\'OpenChartForm\' action=\'../../servlet/eCA.CAMainFrameValidateServlet?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' method = \'post\'>\";\n\t\t\t\t\t\tHTMLVal += \"<input type=hidden name=medical_team value=\'\" + retVal + \"\'\";\n\t\t\t\t\t\tHTMLVal += \"<input type=hidden name=insert_op value=\'Y\'\";\n\t\t\t\t\t\tHTMLVal += \"</form>\";\n\t\t\t\t\t\tHTMLVal += \"</body></html>\";\n\t\t\t\t\t\ttop.content.messageFrame.document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\t\t\t\t\t\ttop.content.messageFrame.document.OpenChartForm.submit();\t\n\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</html>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con =null;
try
{
	
	String facility_id =  (String) session.getValue("facility_id") ;
	String login_pract = (String) session.getValue("ca_practitioner_id");
	con = ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
		String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		
		String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String physicianid="";
		String chkphysicianid = "select practitioner_id from op_patient_queue where facility_id = ?  and encounter_id = ?  and locn_type =? and locn_code = ?";
		
		stmt = con.prepareStatement(chkphysicianid);
		stmt.setString(1,facility_id);
		stmt.setString(2,episodeid);
		stmt.setString(3,location_type);
		stmt.setString(4,location_code);
		rs = stmt.executeQuery();
		while(rs!=null && rs.next())
		{
			physicianid = rs.getString("practitioner_id")==null?"":rs.getString("practitioner_id");
		}
		if(physicianid.equals("*ALL"))
		{
			String sql_query= "Select Team_Id from Am_Pract_For_Team_Vw where Facility_Id = ? and Practitioner_Id = ? and Appl_for_op_yn = 'Y' and Speciality_Code = (select specialty_code from pr_encounter where facility_id = ? and encounter_id = ?)";
			String team_id ="";
			int rowCount = 0;	
			if (rs!=null) rs.close();
			if(stmt != null)stmt.close();
			stmt = con.prepareStatement(sql_query);
			stmt.setString(1,facility_id);
			stmt.setString(2,login_pract);
			stmt.setString(3,facility_id);
			stmt.setString(4,episodeid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				team_id = rs.getString(1);
				rowCount++;
			}
			if(team_id == null) team_id = "";
//			out.println("<script>alert('" + rowCount + "')</script>");
			if(rowCount <= 1)
			{
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(team_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
			else if (rowCount > 1)
			{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(episodeid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
		}
		
	
	
            _bw.write(_wl_block16Bytes, _wl_block16);

		if(rs!=null) rs.close();
		if(stmt != null) stmt.close();
}
catch ( Exception e) 
{
	//out.println("Exception @ try "+e.toString());//COMMON-ICN-0181
       e.printStackTrace();//COMMON-ICN-0181
}
finally 
{
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
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
