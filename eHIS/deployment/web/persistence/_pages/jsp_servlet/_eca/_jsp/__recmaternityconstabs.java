package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import org.w3c.dom.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __recmaternityconstabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecMaternityConsTabs.jsp", 1709116209668L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n\t<head>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script src=\'../../eCA/js/RecMaternityCons.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<form name=\'matConsTabsForm\' id=\'matConsTabsForm\'>\n\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'> <!-- onLoad =\"dfltTab()\" -->\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t\t<center>\n\t\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width= \"100%\" class=\"white\">\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n\t\t\t\t\t\t<!-- <ul id=\"tablist\" class=\"tablist\" >\n\t\t\t\t\t\t<li class=\"tablistitem\" title=\'\'> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t//alert(\'queryString...\'+\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\n\t\t\t\t\t\t\t\t\t\t\tparent.recMatConsDetailsFrame.location.href=\'../../eCA/jsp/RecMaternityConsView.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\n\t\t\t\t\t\t\t\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t  <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t<select name=\'OutCome\' id=\'OutCome\'onChange=\"chk_event_status()\">\n\t\t\t\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="--- &nbsp;&nbsp;&nbsp;&nbsp;</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' selected disabled >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t<option value=\'MCO001~~~H~\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t</select></td><td width=\'25%\'> </td> <td width=\'25%\'> </td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t  </table>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" \n\t\t\t\t\t</ul> ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</body>\n\t\t<input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t<input type=\'hidden\' name=\'prevSecHdgCode\' id=\'prevSecHdgCode\' value=\'\t\'>\n\t\t<input type=\'hidden\' name=\'prevSubSecHdgCode\' id=\'prevSubSecHdgCode\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'sec_hdg_code\' id=\'sec_hdg_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'sub_sec_hdg_code\' id=\'sub_sec_hdg_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'accessionNum\' id=\'accessionNum\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t<input type=\"hidden\" name=\"no_of_rows\" id=\"no_of_rows\" value=\"\">\n\t\t<input type=\"hidden\" name=\"count\" id=\"count\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=\"hidden\" name=\"modeValue\" id=\"modeValue\" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<input type=\"hidden\" name=\"sectionType\" id=\"sectionType\" value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t<input type=\"hidden\" name=\"close_episode_yn\" id=\"close_episode_yn\" value=\'\'>\n\t\t<input type=\"hidden\" name=\"outcome_event_code\" id=\"outcome_event_code\" value=\'\'>\n\t\t<input type=\"hidden\" name=\"splty_task_code\" id=\"splty_task_code\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t<input type=\"hidden\" name=\"outcome_code\" id=\"outcome_code\" value=\'\'>\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t<input type=\"hidden\" name=\"splty_event_code\" id=\"splty_event_code\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t<input type=\"hidden\" name=\"cycle_no\" id=\"cycle_no\" value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\n\t</form>\n</html>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String queryString = request.getQueryString() == null ? "" : request.getQueryString();
			String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			String accessionNum = request.getParameter("accessionNum") == null ? "" : request.getParameter("accessionNum");
			String encounterId = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
			String sec_hdg_code = request.getParameter("sec_hdg_code") == null ? "" : request.getParameter("sec_hdg_code");
			String subSecHdgCode1 = request.getParameter("sub_sec_hdg_code") == null ? "" : request.getParameter("sub_sec_hdg_code");
			//String prevSecHdgCode = request.getParameter("prevSecHdgCode") == null ? "" : request.getParameter("prevSecHdgCode");
			String sectionType = request.getParameter("sectionType") == null ? "" : request.getParameter("sectionType");
			String modeValue = request.getParameter("modeValue") == null ? "" : request.getParameter("modeValue");
			String splty_event_code = request.getParameter("splty_event_code") == null ? "" : request.getParameter("splty_event_code");
			String OCmode = request.getParameter("OCmode") == null ? "" : request.getParameter("OCmode");
			String cycle_no = request.getParameter("cycle_no") == null ? "" : request.getParameter("cycle_no");
			String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
			String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
			String hrmode = request.getParameter("HRmode") == null ? "" : request.getParameter("HRmode");
			String dob=request.getParameter("Dob") == null ? "" : request.getParameter("Dob");
			String sex=request.getParameter("Sex") == null ? "" : request.getParameter("Sex");

			//String prevSubSecHdgCode = request.getParameter("prevSubSecHdgCode") == null ? "" : request.getParameter("prevSubSecHdgCode");
			String subSecHdgCode = "";
			String firstSubSecHdgCode = "";
//			String SubSecHdgCode = "";
			String subSecHdgDesc= "";
			
			int cnt = 0;		
			
			String outcomeval		= "";
			String outcomecode		= "";
			String outcome_desc		= "";
			String action_type		= "";
			String action_code		= "";
			String close_episode_yn = "";
			String outcome_event_code = "";
			Connection con = null;
			PreparedStatement pstmt = null;
			PreparedStatement pstmt1 = null;
			ResultSet res = null;
			ResultSet res1 = null;
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
if(!sectionType.equals("OC")) {
            _bw.write(_wl_block8Bytes, _wl_block8);
	/* if(sectionType.equals("TG")&&modeValue.equals("V"))
					{  }
					else {
            _bw.write(_wl_block9Bytes, _wl_block9);
//} */
						try
						{
							con = ConnectionManager.getConnection(request);
							if ( sectionType.equals("TM") )
							{
									pstmt = con.prepareStatement("select SEC_HDG_DESC short_desc from CA_SECTION_HDG where SEC_HDG_CODE = ? ");
									pstmt.setString(1,sec_hdg_code);
									res = pstmt.executeQuery();
									if ((res!=null) && res.next())
									{

										subSecHdgDesc = res.getString("short_desc") == null ? "" : res.getString("short_desc");
										
										/*if(!splty_task_code.equals("MCT002"))
										{
											out.println("<a  onclick=\"loadMatDetailPage('"+sec_hdg_code+"','"+sec_hdg_code+"')\" class=\"tabClicked\"><span class='tabSpanclicked'>	<b>"+subSecHdgDesc+"</b></span></a> </li>");
										}*/
										if(splty_task_code.equals("MCT002"))
										{
											out.println("<a  onclick=\"loadMatDetailPage3('"+sec_hdg_code+"','"+sec_hdg_code+"','record_tab','"+splty_event_code+"')\" class=\"tabClicked\" id=\"record_tab\"><span class='tabSpanclicked' id='record_tabspan'>	<b>Record</b></span></a> </li>");

											out.println("<a  onclick=\"loadMatViewPage('"+sec_hdg_code+"','"+sec_hdg_code+"','view_tab')\" class=\"tabClicked\" id=\"view_tab\"><span class='tabSpanclicked' id='view_tabspan'>	<b>View</b></span></a> </li>");
										}
										if(!splty_task_code.equals("MCT002")&& !(modeValue.equals("V"))  )
										{
										
											out.println("<span class='tabSpanclicked'>	"+subSecHdgDesc+"</span></li>");
										}
										firstSubSecHdgCode=sec_hdg_code;
									}
									
								if(modeValue.equals("V"))
								{
									
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block12Bytes, _wl_block12);


								
								}



							}
							else if (sectionType.equals("TG"))
							{
								/* pstmt = con.prepareStatement("select count(*) from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = ? ");
								pstmt.setString(1,sec_hdg_code);
								res = pstmt.executeQuery();
								while(res.next())
								{
									cnt = res.getInt(1);
								}

								if(pstmt != null) pstmt.close();
								if(res != null) res.close();*/

								  //here
								if(modeValue.equals("V"))
								{
									
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block13Bytes, _wl_block13);


								
								}


								
								  if(!hrmode.equals("H"))
									  {

										pstmt = con.prepareStatement("select CHILD_SEC_HDG_CODE,CHILD_SEC_HDG_DESC from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = ? and CHILD_SEC_HDG_CODE = ? ");
									  }
									  else
									  {
										  pstmt = con.prepareStatement("select CHILD_SEC_HDG_CODE,CHILD_SEC_HDG_DESC from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = ? AND  CHILD_SEC_HDG_CODE ='MC03' ");
										
									  }
									pstmt.setString(1,sec_hdg_code);
									if(!hrmode.equals("H"))
									{
									pstmt.setString(2,subSecHdgCode1);
									}
									res = pstmt.executeQuery();
									while(res.next())
									{
										
										if(modeValue.equals("V"))
										{
										
											subSecHdgCode = res.getString("CHILD_SEC_HDG_CODE") == null ? "" : res.getString("CHILD_SEC_HDG_CODE");
											subSecHdgDesc = res.getString("CHILD_SEC_HDG_DESC") == null ? "" : res.getString("CHILD_SEC_HDG_DESC");
											
											//htmContent.append("<a href=\"#Mothercare Template 3\">Mothercare Template 3</a>");
											
											//out.println("<a href=\"../../eCA/jsp/RecMaternityConsView.jsp?"+queryString+"#"+subSecHdgDesc+"\" target=\"recMatConsDetailsFrame\"               >["+subSecHdgDesc+"]</a>"); // </li>
											
											//out.println("<a href=\"../../eCA/jsp/RecMaternityConsView.jsp#"+subSecHdgDesc+"\" target=\"recMatConsDetailsFrame\"  onclick=\"loadMatDetailPage2('"+sec_hdg_code+"','"+subSecHdgCode+"','"+cnt+"')\"             class=\"tabClicked\" id=\"sh_tab"+cnt+"\" ><span class='tabSpanclicked' id='sh_tabspan"+cnt+"'>	"+subSecHdgDesc+"</span></a></li>");


											//out.println("<a onclick=\"loadMatDetailPage1('"+sec_hdg_code+"','"+subSecHdgCode+"','"+cnt+"')\" class=\"tabClicked\" id=\"sh_tab"+cnt+"\" ><span class='tabSpanclicked' id='sh_tabspan"+cnt+"'>	"+subSecHdgDesc+"</span></a></li>");
											//out.println("<a href='javascript:' onclick=\"loadMatDetailPage('"+sec_hdg_code+"','"+subSecHdgCode+"')\" ><span class='tabSpanclicked'>	"+subSecHdgDesc+"</span></a></li>");
											cnt++;
											//if (cnt==1) firstSubSecHdgCode=sec_hdg_code ;
											if (cnt==1) firstSubSecHdgCode=subSecHdgCode ;

										}
										else 
										{
											
											subSecHdgCode = res.getString("CHILD_SEC_HDG_CODE") == null ? "" : res.getString("CHILD_SEC_HDG_CODE");
											subSecHdgDesc = res.getString("CHILD_SEC_HDG_DESC") == null ? "" : res.getString("CHILD_SEC_HDG_DESC");

											out.println("<a  class=\"tabClicked\" id=\"sh_tab"+cnt+"\" ><span class='tabSpanclicked' id='sh_tabspan"+cnt+"'>	"+subSecHdgDesc+"</span></a></li>");
											//out.println("<a href='javascript:' onclick=\"loadMatDetailPage('"+sec_hdg_code+"','"+subSecHdgCode+"')\" ><span class='tabSpanclicked'>	"+subSecHdgDesc+"</span></a></li>");
											cnt++;
											//if (cnt==1) firstSubSecHdgCode=sec_hdg_code ;
											if (cnt==1) firstSubSecHdgCode=subSecHdgCode ;
											
									    }
									}
								if(res!=null) res.close();
								if(pstmt!=null) pstmt.close();
								//if(con!=null) con.close();
								//if(con!=null) ConnectionManager.returnConnection(con,request);
								

							}
						}
		    
						catch(Exception e)
						{							
							e.printStackTrace();
						}finally{
							if(con!=null) ConnectionManager.returnConnection(con,request);
						}
													
					

				}//end if(sectionType.equals("OC") loadTemplate()
			else
			{ 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

					try{
						if(OCmode.equals("V")){

						String QueryOutcome1 ="SELECT ACTION_CODE,CA_GET_DESC.CA_SPLTY_OUTCOME(OUTCOME_CODE ,?,'1') outcome_desc FROM CA_SPLTY_EVENT_OUTCOME WHERE SPLTY_EVENT_CODE=? AND  ACTION_CODE =( select DISTINCT b.hdr_code from CA_PAT_SPLTY_EPISODE_TASK a, CA_PAT_SPLTY_TASK_DTL b  where a.patient_id = ? and a.module_id =?  and a.cycle_no = ? and a.ACCESSION_NUM = b.ACCESSION_NUM and a.SPLTY_EVENT_CODE = ? and b.XML_CONTENT is not null )";

						if(con==null)
						con = ConnectionManager.getConnection(request);
						
						pstmt1 = con.prepareStatement(QueryOutcome1);
						
						pstmt1.setString(1,locale);
						pstmt1.setString(2,splty_event_code);
						pstmt1.setString(3,patientId);
						pstmt1.setString(4,module_id);
						pstmt1.setString(5,cycle_no);
						pstmt1.setString(6,splty_event_code);
						res1 = pstmt1.executeQuery();
						while(res1.next())
							{
							action_code = res1.getString("ACTION_CODE") == null ? "" : res1.getString("ACTION_CODE");
							outcome_desc = res1.getString("outcome_desc") == null ? "" : res1.getString("outcome_desc");
							}
							
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(action_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(outcome_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

						if(res1!=null) res1.close();
						if(pstmt1!=null) pstmt1.close();
						}
						else
						{
						String QueryOutcome="select A.OUTCOME_CODE, CA_GET_DESC.CA_SPLTY_OUTCOME(A.OUTCOME_CODE ,?,'1') outcome_desc, A.ACTION_TYPE,A.ACTION_CODE ,A.CLOSE_EPISODE_YN,A.OUTCOME_EVENT_CODE from CA_SPLTY_EVENT_OUTCOME A,CA_SPLTY_OUTCOME B where A.OUTCOME_CODE=B.OUTCOME_CODE AND A.SPLTY_EVENT_CODE=? and not exists (select 1 from CA_PAT_SPLTY_EPISODE_EVENT where patient_id=? and MODULE_ID=? and CYCLE_NO =? and SPLTY_EVENT_CODE = nvl(A.OUTCOME_EVENT_CODE,'***') ) and (B.AGE_GROUP is null or EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA  WHERE IA.AGE_GROUP_CODE=B.AGE_GROUP AND   TRUNC(SYSDATE)-to_date(?,'dd/mm/yyyy') BETWEEN         DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,?)=? )) ORDER BY 2  ";
						if(con==null)
						con = ConnectionManager.getConnection(request);
						
								pstmt1 = con.prepareStatement(QueryOutcome);
								
						pstmt1.setString(1,locale);
						pstmt1.setString(2,splty_event_code);
						pstmt1.setString(3,patientId);
						pstmt1.setString(4,module_id);
						pstmt1.setString(5,cycle_no);
						pstmt1.setString(6,dob);
						pstmt1.setString(7,sex);
						pstmt1.setString(8,sex);
						res1 = pstmt1.executeQuery();
						
							while(res1.next())
							{
								
								outcomecode = res1.getString("OUTCOME_CODE") == null ? "" : res1.getString("OUTCOME_CODE");
								outcome_desc = res1.getString("outcome_desc") == null ? "" : res1.getString("outcome_desc");
								action_type = res1.getString("ACTION_TYPE") == null ? "" : res1.getString("ACTION_TYPE");
								action_code = res1.getString("ACTION_CODE") == null ? "" : res1.getString("ACTION_CODE");
								close_episode_yn = res1.getString("CLOSE_EPISODE_YN") == null ? "" : res1.getString("CLOSE_EPISODE_YN");
								outcome_event_code = res1.getString("OUTCOME_EVENT_CODE") == null ? "" : res1.getString("OUTCOME_EVENT_CODE");
								
								outcomeval= outcomecode+"~"+action_type+"~"+action_code+"~"+close_episode_yn+"~"+outcome_event_code;
								if(!splty_event_code.equals("MCE005") && !splty_event_code.equals("MCE006"))
								{
									
								
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(outcomeval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(outcome_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);

								}
								else if((splty_event_code.equals("MCE005") || splty_event_code.equals("MCE006")) && outcome_event_code.equals(""))
								{									
									
								
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(outcome_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);

								}																				
							}
						
						if(res1!=null) res1.close();
						if(pstmt1!=null) pstmt1.close();
						}
						}
						catch(Exception e)
						{							
							e.printStackTrace();
						}
						finally
						{
							if(con != null) ConnectionManager.returnConnection(con,request);
						}		

					
            _bw.write(_wl_block24Bytes, _wl_block24);
}		



					if(sectionType.equals("TG")&&modeValue.equals("V")){}
				else {
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(accessionNum));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(modeValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sectionType));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(splty_event_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block36Bytes, _wl_block36);

	
	webbeans.eCA.RecClinicalNotesSectionBean matBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("matBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	String strKey	=	"";
	strKey = patientId + "~"+ encounterId;
	strKey = strKey.trim();
	matBean.getPatientSection(strKey);
	if (!subSecHdgCode1.equals("")&&!sectionType.equals("OC"))
	{
		out.println("<script>loadMatDetailPage('"+sec_hdg_code+"','"+subSecHdgCode1+"');</script>");
		out.println("<script>top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';</script>");
	}
	if(sectionType.equals("OC")&&OCmode.equals("V")){
		out.println("<script>document.matConsTabsForm.OutCome.disabled=true;</script>");
		out.println("<script>parent.recMatConsDetailsFrame.location.href = '../../eCA/jsp/RecMaternityConsView.jsp?"+request.getQueryString()+"&sec_hdg_code="+action_code+"&accessionNum="+accessionNum+"';</script>");
		out.println("<script>top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';</script>");
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outcome.label", java.lang.String .class,"key"));
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
