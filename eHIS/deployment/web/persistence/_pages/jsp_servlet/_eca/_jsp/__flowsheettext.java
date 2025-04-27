package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import eCA.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __flowsheettext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetText.jsp", 1709115891419L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n11/09/2013\t IN034512\t\tKarthi L\tA print Option existed next to Close Button in Clinical Event History.\t\t\n12/09/2013\t IN043274\t\tKarthi L  While printing a radiology resulted note from Clinical Event History>Flow sheet, it printed as empty \t\n24/09/2013\t IN043569\t\tKarthi L  \"Print\" option not displayed for notes recorded through Result Reporting\t\t\n--------------------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\tRev.Date\tRev.Name\tDescription\n--------------------------------------------------------------------------------------------------------------------\t\n01/12/2014\t IN052367\tChowminyaG \t\t\t\t\t\t\t\t\t\tSignature not published in Result linked clinical notes \t\t\t\t\t\t\t\t\t\t\t\t\n26/02/2018\t IN065834\tRaja S\t\t26/02/2018\tRamesh G\tPMG2017-KDAH-CRF-0002\t\t\t\n28/06/2018\tIN065341\tPrakash C\t29/06/2018\tRamesh G\tML-MMOH-CRF-0115\n--------------------------------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<form>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<frameset rows=\"90%,*\" border=0 frameborder=0>\n\t<!-- \t<frame src=\"../../eCA/jsp/FlowSheetTextMain.jsp?<//%=queryString%>\" name=\"FlowSheetTextMainFrame\"  scrolling=\"auto\" frameborder=\"0\" marginheight=0 marginwidth=0 /> IN043274 -->\n\t\t<!-- <frame src=\"../../eCA/jsp/FlowSheetTextMain.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" name=\"FlowSheetTextMainFrame\"  scrolling=\"auto\" frameborder=\"0\" marginheight=0 marginwidth=0 /> --> <!-- IN043274 -->\n\t\t<frame src=\"../../eCA/jsp/FlowSheetTextMain.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" name=\"FlowSheetTextMainFrame\"  scrolling=\"auto\" frameborder=\"0\" marginheight=0 marginwidth=0 /> <!-- IN052367 -->\n\t\n\t<frame src=\"../../eCA/jsp/FlowSheetTextToolbar.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" name=\"FlowsheetToolbarFrame\"  scrolling=\"auto\" frameborder=\"0\" marginheight=0 marginwidth=0 /> <!-- IN034512 -->\n\t</frameset>\n\t</form>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
  // added for IN043274 , IN043569 - Start
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");  
		//IN065341 starts
			String bean_id = "ca_CentralizedBean" ;
			String bean_name = "eCA.CentralizedBean";
			CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(localeName);
			bean.clear() ;
			bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
			String enc_id="";
			String fac_id="";
			String called_from=request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
			String RepDb=request.getParameter("RepDb") == null ? "" : request.getParameter("RepDb");
			String clob_data=request.getParameter("clob_data") == null ? "" : request.getParameter("clob_data");
			if(called_from.equals("CDR")){
				enc_id = request.getParameter("enc_id1") == null ? "" : request.getParameter("enc_id1");
				fac_id = request.getParameter("facility_id1") == null ? "" : request.getParameter("facility_id1");
			}else{
				enc_id = request.getParameter("enc_id") == null ? "" : request.getParameter("enc_id");
				fac_id = request.getParameter("fac_id") == null ? "" : request.getParameter("fac_id");
			}
			//IN065341 ends
		String Histrectype = request.getParameter("Histrectype") == null ? "" : request.getParameter("Histrectype");
		String Contrsysid = request.getParameter("Contrsysid") == null ? "" : request.getParameter("Contrsysid");
		String AccessionNum = request.getParameter("Accessionnum") == null ? "" : request.getParameter("Accessionnum");
		String Contrsyseventcode = request.getParameter("Contrsyseventcode") == null ? "" : request.getParameter("Contrsyseventcode");
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		//String enc_id = request.getParameter("enc_id") == null ? "" : request.getParameter("enc_id");commented for IN065341
		//String fac_id = request.getParameter("fac_id") == null ? "" : request.getParameter("fac_id");commented for IN065341
		String note_acc_num				=   AccessionNum;//IN052367
		String contr_mod_accession_num  =  "";//IN065834
		
		String noteHeaderDesc = "";
		String accNumQry  = "";
		Connection con = null;
		PreparedStatement pstmt =	null; 
		ResultSet rs =	null;
		PreparedStatement pstmt1 =	null; 
		ResultSet rs1 =	null;
		
		try{
			con = ConnectionManager.getConnection(request);
			if(called_from.equals("CDR")){
				bean.executeCDR(con,patient_id,enc_id,RepDb,"CA_ENCNTR_NOTE");
			}
		//IN065341 starts	
			//String sqlQuery = "SELECT (SELECT ib.REPORT_HEADER FROM ca_note_group_lang_vw ib, ca_note_type ia WHERE ib.note_group = ia.note_group_id AND ia.note_type = a.note_type AND ib.language_id = ?) note_header_desc FROM ca_encntr_note a WHERE a.accession_num = ?";		
			String sqlQuery = "SELECT (SELECT ib.REPORT_HEADER FROM ca_note_group_lang_vw ##REPDB## ib, ca_note_type ##REPDB## ia WHERE ib.note_group = ia.note_group_id AND ia.note_type = a.note_type AND ib.language_id = ?) note_header_desc FROM ca_encntr_note##CLOB## a WHERE a.accession_num = ?";		
		//IN065341 ends	
			sqlQuery=sqlQuery.replaceAll("##REPDB##",RepDb);
			sqlQuery=sqlQuery.replaceAll("##CLOB##",clob_data);
			pstmt = con.prepareStatement(sqlQuery);

			pstmt.setString(1,locale);
			pstmt.setString(2,AccessionNum);		
			rs = pstmt.executeQuery();
			while(rs.next()){
				noteHeaderDesc		=	rs.getString("note_header_desc")==null?"":rs.getString("note_header_desc") ;
			}

			if("".equals(noteHeaderDesc) || noteHeaderDesc == null){ //IN043274
				if(Contrsysid.equals("RD")){
					if(Character.isDigit(AccessionNum.charAt(0))) { //IN043274
						//accNumQry = "select accession_num from ca_encntr_note where patient_id=? and contr_mod_accession_num in (select OPERATING_FACILITY_ID || REQUEST_NUM || REQUEST_LINE_NUM from rd_exam_view_requested where EXT_APPL_ACCESSION_NUM=?)";//Commented query for IN065834
					//IN065341 starts
						//accNumQry = "select accession_num,contr_mod_accession_num from ca_encntr_note where patient_id=? and contr_mod_accession_num in (select OPERATING_FACILITY_ID || REQUEST_NUM || REQUEST_LINE_NUM from rd_exam_view_requested where EXT_APPL_ACCESSION_NUM=?)";//Modified query for IN065834
						accNumQry = "select accession_num,contr_mod_accession_num from ca_encntr_note##CLOB## where patient_id=? and contr_mod_accession_num in (select OPERATING_FACILITY_ID || REQUEST_NUM || REQUEST_LINE_NUM from rd_exam_view_requested ##REPDB## where EXT_APPL_ACCESSION_NUM=?)";//IN065341
						accNumQry=accNumQry.replaceAll("##CLOB##",clob_data);
						accNumQry=accNumQry.replaceAll("##REPDB##",RepDb);
					//IN065341 ends	
						pstmt1 = con.prepareStatement(accNumQry);

						pstmt1.setString(1,patient_id);
						pstmt1.setString(2,AccessionNum);	
						
						rs1 = pstmt1.executeQuery();
						while(rs1.next()){
							AccessionNum		=	rs1.getString("accession_num")==null?"":rs1.getString("accession_num") ;
							contr_mod_accession_num  =	rs1.getString("contr_mod_accession_num")==null?"":rs1.getString("contr_mod_accession_num") ;//IN065834
						}
					}
					else 
					{	
						int firstPos = AccessionNum.indexOf('@');
						AccessionNum = AccessionNum.substring(0, firstPos);
						//accNumQry = "SELECT ACCESSION_NUM FROM ca_encntr_note WHERE CONTR_MOD_ACCESSION_NUM  = (SELECT OPERATING_FACILITY_ID||REQUEST_NUM||REQUEST_LINE_NUM FROM rd_exam_view_requested WHERE 'F'||OPERATING_FACILITY_ID||'#'||REQUEST_NUM||'$'||REQUEST_LINE_NUM = ?)";//Commented query for IN065834
					//IN065341 starts
						//accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num FROM ca_encntr_note WHERE CONTR_MOD_ACCESSION_NUM  = (SELECT OPERATING_FACILITY_ID||REQUEST_NUM||REQUEST_LINE_NUM FROM rd_exam_view_requested WHERE 'F'||OPERATING_FACILITY_ID||'#'||REQUEST_NUM||'$'||REQUEST_LINE_NUM = ?)";//Modified query for IN065834
						accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num FROM ca_encntr_note##CLOB## WHERE CONTR_MOD_ACCESSION_NUM  = (SELECT OPERATING_FACILITY_ID||REQUEST_NUM||REQUEST_LINE_NUM FROM rd_exam_view_requested ##REPDB## WHERE 'F'||OPERATING_FACILITY_ID||'#'||REQUEST_NUM||'$'||REQUEST_LINE_NUM = ?)";//Modified query for IN065341
						accNumQry=accNumQry.replaceAll("##REPDB##",RepDb);
						accNumQry=accNumQry.replaceAll("##CLOB##",clob_data);
					//IN065341 ends
						pstmt1 = con.prepareStatement(accNumQry);

						pstmt1.setString(1,AccessionNum);
						rs1 = pstmt1.executeQuery();
						while(rs1.next()){
							AccessionNum =	rs1.getString("accession_num")==null?"":rs1.getString("accession_num") ;
							contr_mod_accession_num  =	rs1.getString("contr_mod_accession_num")==null?"":rs1.getString("contr_mod_accession_num") ;//IN065834
						}
					}
				}	
				else if(Histrectype.equals("LBIN") && Contrsysid.equals("LB")) {
					//accNumQry = "SELECT ACCESSION_NUM from ca_encntr_note WHERE CONTR_MOD_ACCESSION_NUM = (SELECT OPERATING_FACILITY_ID|| SPECIMEN_NO || TEST_CODE || SERIAL_NO FROM RL_OLE_RESULT_TEXT WHERE 'F'||OPERATING_FACILITY_ID || '#' || SPECIMEN_NO || '@' || TEST_CODE =?)";//Commented query for IN065834
				//IN065341 starts	
					//accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num from ca_encntr_note WHERE CONTR_MOD_ACCESSION_NUM = (SELECT OPERATING_FACILITY_ID|| SPECIMEN_NO || TEST_CODE || SERIAL_NO FROM RL_OLE_RESULT_TEXT WHERE 'F'||OPERATING_FACILITY_ID || '#' || SPECIMEN_NO || '@' || TEST_CODE =?)";//Modified query for IN065834
					accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num from ca_encntr_note##CLOB## WHERE CONTR_MOD_ACCESSION_NUM = (SELECT OPERATING_FACILITY_ID|| SPECIMEN_NO || TEST_CODE || SERIAL_NO FROM RL_OLE_RESULT_TEXT ##REPDB## WHERE 'F'||OPERATING_FACILITY_ID || '#' || SPECIMEN_NO || '@' || TEST_CODE =?)";//Modified query for IN065341
					accNumQry=accNumQry.replaceAll("##CLOB##",clob_data);
					accNumQry=accNumQry.replaceAll("##REPDB##",RepDb);
				//IN065341 ends
					pstmt1 = con.prepareStatement(accNumQry);
					pstmt1.setString(1,AccessionNum);
					rs1 = pstmt1.executeQuery();
					while(rs1.next()){
						AccessionNum		=	rs1.getString("ACCESSION_NUM")==null?"":rs1.getString("ACCESSION_NUM") ;
						contr_mod_accession_num  =	rs1.getString("contr_mod_accession_num")==null?"":rs1.getString("contr_mod_accession_num") ;//Added for IN065834
					}
				}
				else if(Contrsysid.equals("OT")) {
					int firstPos = AccessionNum.indexOf('$');
					AccessionNum = AccessionNum.substring(0, firstPos);
					//accNumQry = "SELECT ACCESSION_NUM FROM ca_encntr_note WHERE SUBSTR(CONTR_MOD_ACCESSION_NUM,1,LENGTH(CONTR_MOD_ACCESSION_NUM)-2) = (SELECT OPERATING_FACILITY_ID||OPER_NUM||SPECIALITY_CODE FROM ot_post_oper_hdr WHERE 'F'||OPERATING_FACILITY_ID||'#'||EPISODE_TYPE||EPISODE_ID||'#'||OPER_NUM = ? )";//Commented query for IN065834
				//IN065341 starts
					//accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num FROM ca_encntr_note WHERE SUBSTR(CONTR_MOD_ACCESSION_NUM,1,LENGTH(CONTR_MOD_ACCESSION_NUM)-2) = (SELECT OPERATING_FACILITY_ID||OPER_NUM||SPECIALITY_CODE FROM ot_post_oper_hdr WHERE 'F'||OPERATING_FACILITY_ID||'#'||EPISODE_TYPE||EPISODE_ID||'#'||OPER_NUM = ? )";//Modified query for IN065834
					accNumQry = "SELECT ACCESSION_NUM,contr_mod_accession_num FROM ca_encntr_note##CLOB## WHERE SUBSTR(CONTR_MOD_ACCESSION_NUM,1,LENGTH(CONTR_MOD_ACCESSION_NUM)-2) = (SELECT OPERATING_FACILITY_ID||OPER_NUM||SPECIALITY_CODE FROM ot_post_oper_hdr ##REPDB## WHERE 'F'||OPERATING_FACILITY_ID||'#'||EPISODE_TYPE||EPISODE_ID||'#'||OPER_NUM = ? )";//Modified query for IN065341
					accNumQry=accNumQry.replaceAll("##CLOB##",clob_data);
					accNumQry=accNumQry.replaceAll("##REPDB##",RepDb);
				//IN065341 ends	
					pstmt1 = con.prepareStatement(accNumQry);
					pstmt1.setString(1,AccessionNum);
					rs1 = pstmt1.executeQuery();
					while(rs1.next()){
						AccessionNum		=	rs1.getString("ACCESSION_NUM")==null?"":rs1.getString("ACCESSION_NUM") ;
						contr_mod_accession_num  =	rs1.getString("contr_mod_accession_num")==null?"":rs1.getString("contr_mod_accession_num") ;//Added for IN065834
					}
				}
				else {
					//accNumQry = "select linked_note_accession_num from OR_RESULT_DETAIL where ORDER_TYPE_CODE ||'!'|| order_id ||'!'|| REPORT_SRL_NO ||'!'|| LINE_SRL_NO ||'!'|| SRL_NO= ?";//Commented query for IN065834
				//IN065341 starts	
					//accNumQry = "select order_id,linked_note_accession_num from OR_RESULT_DETAIL where ORDER_TYPE_CODE ||'!'|| order_id ||'!'|| REPORT_SRL_NO ||'!'|| LINE_SRL_NO ||'!'|| SRL_NO= ?";//Modified query for IN065834
					accNumQry = "select order_id,linked_note_accession_num from OR_RESULT_DETAIL##REPDB## where ORDER_TYPE_CODE ||'!'|| order_id ||'!'|| REPORT_SRL_NO ||'!'|| LINE_SRL_NO ||'!'|| SRL_NO= ?";//Modified query for IN065341
					accNumQry=accNumQry.replaceAll("##REPDB##",RepDb);
				//IN065341 ends
					pstmt1 = con.prepareStatement(accNumQry);
					pstmt1.setString(1,AccessionNum);
					rs1 = pstmt1.executeQuery();
					while(rs1.next()){
						AccessionNum		=	rs1.getString("linked_note_accession_num")==null?"":rs1.getString("linked_note_accession_num") ;
						contr_mod_accession_num		=	rs1.getString("order_id")==null?"":rs1.getString("order_id") ;//IN065834
					}
				}	
			}	
		}
		catch(Exception ee)
		{
			//out.println(ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();
		}
		finally {
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();
			if(rs1!=null)	rs1.close();
			if(pstmt1!=null)	pstmt1.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}	
		// IN043569 End
		//String queryString = "Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+AccessionNum+"&Contrsyseventcode="+Contrsyseventcode+"&patient_id="+patient_id+"&enc_id="+enc_id+"&fac_id="+fac_id;  // commented for IN043274
		//String queryString = "Histrectype="+java.net.URLEncoder.encode(Histrectype,"UTF-8")+"&Contrsysid="+java.net.URLEncoder.encode(Contrsysid,"UTF-8")+"&Accessionnum="+java.net.URLEncoder.encode(note_acc_num,"UTF-8")+"&Contrsyseventcode="+java.net.URLEncoder.encode(Contrsyseventcode,"UTF-8")+"&patient_id="+java.net.URLEncoder.encode(patient_id,"UTF-8")+"&enc_id="+java.net.URLEncoder.encode(enc_id,"UTF-8")+"&fac_id="+java.net.URLEncoder.encode(fac_id,"UTF-8")+"&acc_num="+java.net.URLEncoder.encode(AccessionNum,"UTF-8"); // modified for IN043274
		//String queryString = "Histrectype="+java.net.URLEncoder.encode(Histrectype,"UTF-8")+"&Contrsysid="+java.net.URLEncoder.encode(Contrsysid,"UTF-8")+"&Accessionnum="+java.net.URLEncoder.encode(note_acc_num,"UTF-8")+"&Contrsyseventcode="+java.net.URLEncoder.encode(Contrsyseventcode,"UTF-8")+"&patient_id="+java.net.URLEncoder.encode(patient_id,"UTF-8")+"&enc_id="+java.net.URLEncoder.encode(enc_id,"UTF-8")+"&fac_id="+java.net.URLEncoder.encode(fac_id,"UTF-8")+"&acc_num="+java.net.URLEncoder.encode(AccessionNum,"UTF-8"); // IN052367	//Commented for IN065834	
		//String queryString = "Histrectype="+java.net.URLEncoder.encode(Histrectype,"UTF-8")+"&Contrsysid="+java.net.URLEncoder.encode(Contrsysid,"UTF-8")+"&Accessionnum="+java.net.URLEncoder.encode(note_acc_num,"UTF-8")+"&Contrsyseventcode="+java.net.URLEncoder.encode(Contrsyseventcode,"UTF-8")+"&patient_id="+java.net.URLEncoder.encode(patient_id,"UTF-8")+"&enc_id="+java.net.URLEncoder.encode(enc_id,"UTF-8")+"&fac_id="+java.net.URLEncoder.encode(fac_id,"UTF-8")+"&acc_num="+java.net.URLEncoder.encode(AccessionNum,"UTF-8")+"&contr_mod_accession_num="+java.net.URLEncoder.encode(contr_mod_accession_num,"UTF-8"); // IN052367	//Modified query for IN065834	
		String queryString = "Histrectype="+java.net.URLEncoder.encode(Histrectype,"UTF-8")+"&Contrsysid="+java.net.URLEncoder.encode(Contrsysid,"UTF-8")+"&Accessionnum="+java.net.URLEncoder.encode(note_acc_num,"UTF-8")+"&Contrsyseventcode="+java.net.URLEncoder.encode(Contrsyseventcode,"UTF-8")+"&patient_id="+java.net.URLEncoder.encode(patient_id,"UTF-8")+"&enc_id="+java.net.URLEncoder.encode(enc_id,"UTF-8")+"&fac_id="+java.net.URLEncoder.encode(fac_id,"UTF-8")+"&acc_num="+java.net.URLEncoder.encode(AccessionNum,"UTF-8")+"&contr_mod_accession_num="+java.net.URLEncoder.encode(contr_mod_accession_num,"UTF-8")+"&RepDb="+java.net.URLEncoder.encode(RepDb,"UTF-8")+"&clob_data="+java.net.URLEncoder.encode(clob_data,"UTF-8"); // IN065341	
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block11Bytes, _wl_block11);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventDetails.label", java.lang.String .class,"key"));
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
}
