package jsp_servlet._eca._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __camain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMain.jsp", 1741177500998L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\' />\n<script src=\'../../eCA/js/CAMenu.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<title> IBA Health </title>\n<script>//window.name=\'eHospital Information\'</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>\n    if(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" == \"N\"){\n        window.onbeforeunload =closeWindows\n\t}\n\telse\n\t{\n\t\t/**Modified by Parimala on 20/12/2003 for clearing the beans related to the arch*/\n\t\twindow.onbeforeunload = clearObjects ;\n\t\t/**Ends Here*/\n\t}\n</script>\n    <frameset border=\"0\" framespacing=0 rows=\'8%,*,5%,1%\' scrolling=\'auto\' id=\"mainFrameSet\">\n\t\t<frame name=\'CommonToolbar\' src=\'CAMainTitle.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&reln_req_yn=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&fromNewFunction=Y\' noresize  frameborder=\"0\" marginheight=0 marginwidth=0 SCROLLING=\'no\' noresize>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n\t\t\t<frameset border=\"0\" framespacing=0 cols=\"0%,0%,*,0%\" scrolling=\'yes\' id=\'workArea\' name=\'workArea\'>\n\t\t\t\t<frame name=\'menuFrame\' id=\'menuFrame\' src=\'../../eCommon/html/blank.html\' frameborder=1  marginheight=0 marginwidth=0 SCROLLING=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' BORDERCOLOR=\'red\' noresize>\n\t\t\t\t<frame name=\'matFrame\' id=\'matFrame\' src=\'../../eCommon/html/blank.html\' frameborder=1  marginheight=0 marginwidth=0 SCROLLING=\'yes\' BORDERCOLOR=\'red\'>\n\t\t\t<!-- \t<frame name=\'subMenuFrame\' src=\'../../eOH/jsp/OHDentalChartTabSearch.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=1  marginheight=0 marginwidth=0 SCROLLING=\'yes\' BORDERCOLOR=\'red\'> -->\n\t\t\t\t<frame name=\'workAreaFrame\' id=\'workAreaFrame\' src=\'../../eCommon/html/blank.html\'   frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'no\' BORDERCOLOR=\'green\' noresize>\n\t\t\t\t<frame name=\'lookupMenuFrame\' id=\'lookupMenuFrame\' src=\'../../eCommon/html/blank.html\'   frameborder=1  marginheight=1 marginwidth=1 SCROLLING=\'auto\' BORDERCOLOR=\'red\'>\n\t\t\t</frameset>\n\t\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \t\t\t\n\t\t\t<frameset frameborder=0 framespacing=0 rows=\"5%,5%,*,5%\" scrolling=\'no\' id=\'workArea\' name=\'workArea\'>\n\t\t\t\t<frame name=\'Options1\' id=\'Options1\' src=\'../../eCA/jsp/CAMainOptions1.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'no\'>\n\t\t\t\t<frame name=\'Options2\' id=\'Options2\' src=\'../../eCommon/html/blank.html\' frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'no\'>\n\t\t\t\t<frame name=\'workAreaFrame\' id=\'workAreaFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'no\'>\n\t\t\t\t<frame name=\'Options3\' id=\'Options3\' src=\'../../eCommon/html/blank.html\' frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'no\'>\n\t\t\t</frameset>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \n        <frame name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'auto\' noresize> \n         \n\t</frameset>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n<script>\n\n\twindow.focus();\n\t//IN048704 Starts\n\tif((\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"==\"Y\") && (\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"==\"AC\"))\n\t\t\t\t{\n\t\t\t\t\tvar features   = \'dialogTop:72;dialogHeight:41;dialogWidth:65;status=no\';\n\t\t\t\t\tvar arguments  = \'\' ;\t\t\n\t\t\t\t\twindow.showModalDialog(\"../../eIP/jsp/PaintReferralPatientDetails.jsp?encounterId=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&patientid=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&called_from=CA&call_function=BedSideReferral&referralID=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\",arguments,features);\n\t\t\t\t\t\n\t\t\t\t}\n\t//IN048704 Ends\t\t\t\n</script>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
 
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
	?			100				?				?			?			?
06/04/2015		IN048704		Nijitha S							HSA-CRF-0175
-------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            eCA._ca_license_rights keyGen= null;{
                keyGen=(eCA._ca_license_rights)pageContext.getAttribute("keyGen");
                if(keyGen==null){
                    keyGen=new eCA._ca_license_rights();
                    pageContext.setAttribute("keyGen",keyGen);
                    _bw.write(_wl_block6Bytes, _wl_block6);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con = null;
PreparedStatement stmt=null,stmt1=null; 
ResultSet rset =null,rs=null,rset1=null;
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");

PreparedStatement pstmt = null;
String menu_Active = "N";
String reln_req_yn = "N";
String from_service_yn = request.getParameter("from_service_yn")==null?"N":request.getParameter("from_service_yn");
StringBuffer sql_reln = new StringBuffer();

String relnid ="";
String scrollbars = "No";
//String lookupFileName = request.getParameter("lookupFileName")==null?"":request.getParameter("lookupFileName");
//IN048704 Starts
String referral_id 	=	request.getParameter("referral_id")==null?"":request.getParameter("referral_id");
String assign_confirm_referral_yn	=	request.getParameter("assign_confirm_referral_yn")==null?"":request.getParameter("assign_confirm_referral_yn");
String assignorConfirmKey	=	request.getParameter("assignorConfirmKey")==null?"":request.getParameter("assignorConfirmKey");
String patient_id ="";	
String episode_id ="";	
//IN048704 Ends
try{

	con =  ConnectionManager.getConnection(request);
    
    String login_user=(String)session.getValue("login_user");
	if(login_user == null)
		login_user = "";
	String sql= "select func_role_id, AM_GET_DESC.AM_PRACTITIONER(a.func_role_id,?,'1') practitioner_name, pract_type,'N' TAB_MENU_YN , (select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) reln_req_yn from sm_appl_user a, am_practitioner b where b.practitioner_id=a.func_role_id and appl_user_id = ? and func_role ='P' ";
    String func_role_id="",practitioner_name="",pract_type="";

	
	
	stmt=con.prepareStatement(sql);
	stmt.setString(1,locale);
	stmt.setString(2,login_user);
	
    rset=stmt.executeQuery();
	
    if(rset !=null && rset.next())
    {
			
		func_role_id=rset.getString("func_role_id");
		if(func_role_id == null) func_role_id="";

		practitioner_name=rset.getString("practitioner_name");
		if(practitioner_name == null) practitioner_name="";

		pract_type = rset.getString("pract_type");
		if(pract_type == null) pract_type="";

		menu_Active = rset.getString("TAB_MENU_YN");
		if (menu_Active==null) menu_Active="Y";

		//out.println("<script>alert('menu_Active   :   "+menu_Active+"')</script>");

		reln_req_yn = rset.getString("reln_req_yn");
		//if (reln_req_yn==null) reln_req_yn="N";	
		
		

    session.putValue("ca_practitioner_id",func_role_id);
    session.putValue("practitioner_name",practitioner_name);
    session.putValue("practitioner_type",pract_type);


    String query_string = request.getQueryString() == null? "" :request.getQueryString();
	patient_id =request.getParameter("patient_id") ;//IN048704
	episode_id =request.getParameter("episode_id") ;//IN048704



	if (patient_id == null) patient_id= "";

	if(!patient_id.equals(""))
		scrollbars = "Yes";
  
    String limit_function_id = request.getParameter("limit_function_id")== null?"":request.getParameter("limit_function_id");
	String chartTitle = request.getParameter("chartTitle")== null?"":request.getParameter("chartTitle");
    String child_window = "N";
    String resp_id = (String) session.getValue("responsibility_id");
	if(resp_id == null)
		resp_id = "";

    String facility_id = (String) session.getValue("facility_id");
	if(facility_id == null)
		facility_id = "";
	
	if(!patient_id.equals(""))
		 child_window = "Y";

    query_string=query_string + "&child_window="+child_window+"&limit_function_id="+limit_function_id+"&chartTitle="+chartTitle;



    String respid=(String) session.getValue("responsibility_id");
	
	if(respid == null)
		respid = "";

	String resp_name="";
	String qry = "select resp_name from sm_resp_lang_Vw where resp_id=? AND LANGUAGE_ID = ? ";
	pstmt	=	con.prepareStatement(qry);
	pstmt.setString(1,respid);
	pstmt.setString(2,locale);

	rs=pstmt.executeQuery();
	if(rs.next())
		resp_name = rs.getString(1)==null?"":rs.getString(1);
	
	session.putValue("resp_name",resp_name);
	rs.close();
	pstmt.close();

	if(!patient_id.equals("")&&reln_req_yn.equals("Y"))
	{
		//out.println("<script>alert('patient_id   :   "+patient_id+"')</script>");	
		sql_reln.append("Select PRACT_RELN_ID PHYS_PROV_RELN_ID from CA_ENCNTR_PRACT_RELN Where FACILITY_ID = ? AND NVL(ENCOUNTER_ID,0) = NVL(?,0) AND PRACTITIONER_ID=? AND PATIENT_ID=? AND STATUS ='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY'))AND BEGIN_DATE_TIME<=SYSDATE+.0006 ");	
			
			
			stmt1 = con.prepareStatement(sql_reln.toString());
			stmt1.setString(1,facility_id);
			stmt1.setString(2,episode_id);
			stmt1.setString(3,func_role_id);
			stmt1.setString(4,patient_id);
			
			/*if(!(episodeid == null || episodeid.equals(""))){
				stmt.setString(4,episodeid);
			}*/
			
			rset1 = stmt1.executeQuery();

            if(rset1!=null && rset1.next())
            {
				relnid = rset1.getString("PHYS_PROV_RELN_ID")==null?"":rset1.getString("PHYS_PROV_RELN_ID");
							}
			if(rset1!=null)      rset1.close();
			if(stmt1!=null)  stmt1.close();

		

	} 

	if(!patient_id.equals(""))
	{
	
		query_string = query_string + "&relationship_id="+relnid; 
	}
  
	String titleFrameSize = "8%";
	if(patient_id !=""){
		titleFrameSize= "50%";
	}else{
		titleFrameSize= "8%";
	}

	if ( reln_req_yn !=null && reln_req_yn.length() >0);
		else{
			out.println("<script>alert(getMessage('MISSING_ENC_PARAM','CA'));</script>");
			out.println("<script>window.history.go(-1)</script>");
			return;			
		}


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(child_window));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(reln_req_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);

		if(menu_Active.equals("N"))
		{
			//out.println("<script>alert('in If : "+menu_Active+"')</script>");	
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(scrollbars));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else if(menu_Active.equals("Y")){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(reln_req_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

}// E.O.F if cond
else
{
    out.println("<script>alert(getMessage('INVALID_CA_USER','CA'));</script>");
	
	if(from_service_yn.equals("Y")){
	    out.println("<script>parent.window.close();</script>");	
	}else{
	   out.println("<script>location.href='../../eCommon/jsp/dmenu.jsp'</script>");
	}
}

}
    catch(Exception e){
		e.printStackTrace();
		//out.println("Exception in CAMain.jsp"+e.toString());//COMMON-ICN-0181
    }
    finally{
        if (rset !=null) rset.close();
		if (stmt!=null) stmt.close();
        if (con !=null) ConnectionManager.returnConnection(con,request);
		

    }

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(assign_confirm_referral_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(assignorConfirmKey));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
