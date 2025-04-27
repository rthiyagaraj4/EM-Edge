package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public final class __patientvaluables extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PatientValuables.jsp", 1710353650721L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'</link>\n\t<script language=\'javascript\' src=\'../js/CancelAdmission.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n<script>\n   function reset()\n   {\n\t\tframes[1].document.forms[0].reset();\n\t\tif (frames[1].document.forms[0].searchby != null)\n\t    {\n\t\t\tif (frames[1].document.forms[0].soundex.value!=\'\')\n\t\t\t{\n\t\t\t\tframes[1].document.forms[0].searchby.value=\"\";\n\t\t\t\tframes[1].document.forms[0].searchby.disabled=true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tframes[1].document.forms[0].searchby.disabled=false;\n\t\t\t\tframes[1].document.forms[0].searchby.value=\"S\";\n\t\t\t}\n\t    }\n\t\tframes[2].location.href = \'../../eCommon/html/blank.html\';\n   }\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t src=\'../jsp/InpatientLookupCriteria.jsp?jsp_name=PatientValuablesMain.jsp&win_height=30&dialogTop=120&win_width=49&call_function=CancelAdmission&wherecondn=CANC_ADMISSION_YN\' frameborder=0 scrolling=\'no\' noresize style=\'height:180%;width:100vw\'></iframe>\n\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' \t src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize style=\'height:80vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' \t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' noresize style=\'height:45%;width:100vw\'></iframe>\n\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n\t\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

	// By Annadurai 2/4/2004., to Handle NullPointerException.,
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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);


	StringBuffer strBuffer	=	new StringBuffer();
	strBuffer.append("../../eCommon/jsp/commonToolbar.jsp?");
	strBuffer.append(request.getQueryString());

	String source				=	strBuffer.toString();
	String facility				=	checkForNull((String) session.getValue("facility_id"));
	String loginUser			=	checkForNull((String)session.getValue("login_user"));
	String canceladmissionyn	=	"";
	String oper_stn_id			=	"";
	
	Connection connection		=	null;
	ResultSet resultSet 		=	null; 
	Statement statement 		=	null;
	Statement stmt_opr		= null;
	Statement stmt_clinic	= null;
	ResultSet rset_opr 		= null;
	ResultSet rset_clinic	= null;
	boolean result 	= true;

	try{
		connection = ConnectionManager.getConnection(request);
		statement = connection.createStatement();

		resultSet = statement.executeQuery("select 1 from ip_param where facility_id='"+facility+"' ") ;
		if(resultSet.next())
		{


		 //Added by Devang For Operator Station & Clinic  Check
				String operSql =" SELECT a.oper_stn_id  OPER_STN_ID FROM am_oper_stn a, am_user_for_oper_stn b  "+
						" WHERE a.facility_id='"+facility+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id "+
							" AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  "+
						" nvl(b.eff_date_to,trunc(sysdate)) ";
						
				stmt_opr = connection.createStatement();
				rset_opr  = stmt_opr.executeQuery(operSql);
				if(rset_opr!=null)
				{
					
					if(rset_opr.next())
					{
						oper_stn_id = rset_opr.getString("OPER_STN_ID");
						if(oper_stn_id == null) oper_stn_id ="";			
					}	
					else
					{
						 out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						 result = false;
					}

				}

				if (!oper_stn_id.equals("") && result)
			   {
				 try
				{
				  String sql = "select a.nursing_unit_code from ip_nursing_unit a, am_locn_for_oper_stn b where a.facility_id = '"+facility+"' and a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E'";
				  
				  stmt_clinic  = connection.createStatement();
				  rset_clinic = stmt_clinic.executeQuery(sql);
				 
				  if (!rset_clinic.next())
				  {
					  out.println(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					  result = false;
				   }
				}
				   catch(Exception e) { result = false; out.println(e.toString());}
				   finally 
				 {
					if (rset_clinic != null)   rset_clinic.close();
				 }
			  } 
		String sqlcan = "select canc_admission_yn from am_oper_stn "+
				" where facility_id = '"+facility+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn  "+ 
				" where facility_id='"+facility+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) ";

		resultSet = statement.executeQuery(sqlcan);
		if(resultSet!= null)
		{
			if(resultSet.next())
			{
				canceladmissionyn = resultSet.getString("canc_admission_yn");
				if(canceladmissionyn == null) canceladmissionyn ="";
				
			}
		}

	
if(canceladmissionyn.equals("Y"))
{		

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block5Bytes, _wl_block5);
}
else
{
	out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
	out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
}

}else
  out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	
	finally
	{
		if(statement!=null) statement.close();
		if(resultSet!=null) resultSet.close();
		if(rset_opr!=null)		rset_opr.close();
		if(rset_clinic!=null)	rset_clinic.close();
		if(stmt_opr!=null) 		stmt_opr.close();
		if(stmt_clinic!=null) 	stmt_clinic.close();
		ConnectionManager.returnConnection(connection,request);
	}


            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
