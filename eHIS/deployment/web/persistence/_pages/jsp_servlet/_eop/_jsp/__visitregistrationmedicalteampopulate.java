package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;
import javax.servlet.jsp.JspWriter;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __visitregistrationmedicalteampopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/VisitRegistrationMedicalTeamPopulate.jsp", 1731301942100L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n    <head>\n\t   ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n        <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n        <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n\t</head>\n\n    <body CLASS=\'MESSAGE\' onKeyDown =\'lockKey()\'>\n        <form name=\"DynamicFile\" id=\"DynamicFile\">\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\n\t\t\tif (\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" == \"Y\")\n\t\t\t{\n\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"team_prompt\").innerHTML=\"\";\n\t\t\t\tparent.parent.parent.frames[0].document.getElementById(\"team_desc\").innerHTML=\"\";\n\t\t\t\tparent.parent.parent.frames[0].document.forms[0].team_code.value=\"\";          \n\t\t\t}\n\t\t\telse\n\t\t    {\n\t\t\t\tparent.frames[1].frames[1].frames[0].document.getElementById(\"team_prompt\").innerHTML=\"\";\n\t\t\t\tparent.frames[1].frames[1].frames[0].document.getElementById(\"team_desc\").innerHTML=\"\";\n\t\t\t\tparent.frames[1].frames[1].frames[0].document.forms[0].team_code.value=\"\";          \n\t\t    }\n\t\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script>\n\t\t\tif (\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" == \"Y\")\n\t\t\t{\n\t\t\t   parent.parent.parent.frames[0].document.getElementById(\'team_prompt\').innerHTML=getLabel(\"Common.medicalteam.label\",\"Common\");\n\t\t\t   parent.parent.parent.frames[0].document.getElementById(\'team_desc\').innerHTML=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.frames[1].frames[1].frames[0].document.getElementById(\"team_prompt\").innerHTML=getLabel(\"Common.medicalteam.label\",\"Common\");\n\t\t\t\tparent.frames[1].frames[1].frames[0].document.getElementById(\"team_desc\").innerHTML=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t}\n\t\t\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" == \"Y\")\n\t\t\t{\n\t\t\t  parent.parent.parent.frames[0].document.getElementById(\"team_prompt\").innerHTML=getLabel(\"Common.medicalteam.label\",\"Common\");\n\t\t\t  parent.parent.parent.frames[0].document.getElementById(\"team_desc\").innerHTML=\"<b>\"+\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t  parent.parent.parent.frames[0].document.forms[0].team_code.value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";   \n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t  parent.frames[1].frames[1].frames[0].document.getElementById(\"team_prompt\").innerHTML=getLabel(\"Common.medicalteam.label\",\"Common\");\n\t\t\t  parent.frames[1].frames[1].frames[0].document.getElementById(\"team_desc\").innerHTML=\"<b>\"+\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t  parent.frames[1].frames[1].frames[0].document.forms[0].team_code.value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\";   \n\t\t\t}\n\t\t\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		  Connection con = null ;		  
		  PreparedStatement   pstmt = null;
		  PreparedStatement   pstmt01 = null;
		  ResultSet     rs	 = null;
		  ResultSet     rs01 = null;
		  String facility_id       = (String) session.getValue("facility_id");

		  String practitioner	= request.getParameter("attend_ptactitioner_id") ;
		  String locationcode	= request.getParameter("location_code") ;
		  String callFromMPQuery= request.getParameter("callFromMPQuery") ;
		  if(callFromMPQuery == null || callFromMPQuery.equals("null")) callFromMPQuery = "";		 
		  
     try
       {
	        con = ConnectionManager.getConnection(request);		
				
			pstmt01   = con.prepareStatement("Select Team_Id, Team_Short_Desc from Am_Pract_For_Team_Vw where Facility_Id = '"+facility_id+"' and Practitioner_Id = '"+practitioner+"' and Appl_for_op_yn = 'Y' and Speciality_Code = (Select SPECIALITY_CODE From OP_CLINIC Where FACILITY_ID = '"+facility_id+"' and CLINIC_CODE = '"+locationcode+"') ");
			rs01 = pstmt01.executeQuery();

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(callFromMPQuery));
            _bw.write(_wl_block9Bytes, _wl_block9);

			String teamCode02 = "";
			String teamDesc02 = "";
			String str02 = "<option value=''>&nbsp;&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;&nbsp;</option>";
			
			int count02 = 0;

	      if( rs01 != null )
		  {
			while( rs01.next() )
			{
				teamCode02 = rs01.getString( "Team_Id" );
				teamDesc02 = rs01.getString( "Team_Short_Desc" );
				str02 = str02 + "<option value='"+teamCode02+"'>"+teamDesc02+"</option>";
				count02++;
	        }
			

		    if(count02 > 1)
			{	
			  String vals = "<select   name=team_id id=team_id onChange='assignTeamValue(this);'>"+str02+"</select>";

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(callFromMPQuery));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(vals));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(vals));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
			else if(count02 == 1)
			{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(callFromMPQuery));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(teamDesc02));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(teamCode02));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(teamDesc02));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(teamCode02));
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
		  } 
	   }
        catch(Exception e){out.println(e);}
        finally
        {
            if(rs != null)		rs.close() ;
            if(rs01 != null)    rs01.close() ;
            if(pstmt != null)   pstmt.close() ;
			if(pstmt01 != null) pstmt01.close() ;
            if(con!=null) ConnectionManager.returnConnection(con,request);
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
