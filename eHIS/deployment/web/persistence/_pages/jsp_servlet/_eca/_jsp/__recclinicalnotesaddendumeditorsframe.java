package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotesaddendumeditorsframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesAddendumEditorsFrame.jsp", 1739352676419L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t?           \tcreated\n18/07/2012\t\tIN034055\t\tMenaka V\t\tRecord Clinical Notes>A note is recorded>Modify>Addendum cannot \n\t\t\t\t\t\t\t\t\t\t\t\tbe added .\t\t\t\t\t\t\t\t\t\n20/07/2012\t\tIN033881\t\tDinesh T\t\tAddendum data is not appearing in the multifacility scenario\n25/07/2012\t\tIN034224\t\tDinesh T\t\tRecording and signing the addendum is not functioning properly\n25/07/2012\t\tIN033869\t\tDinesh T\t\tAddendum contents clears when we try to click the sections on the left in the \t\t\t\t\t\t\t\t\t\t\t\t\tmodify mode\n19/09/2012\t\tIN033677\t\tDinesh T\t\tCRF-Recording and signing the addendum with new free text editor \n27/12/2012\t\tIN034871\t\tRamesh G\t\tAddendum details are not displayed only for modification and hence the issue is happen some times.\n14/05/2019\t\tIN067862\t\tRamesh G\t\tML-BRU-CRF-0530\n21/10/2019\t\tIN071569\t\tRamesh G\t\tML-MMOH-SCF-1389 \n18/03/2020\t\tIN071264\t\tNijitha S\t\tGHL-CRF-0604\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="<!--IN071264-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<!--IN033869-->\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" </title>\n\t<META content=\"text/html; charset=UTF-8\" http-equiv=Content-Type>\n\t<META content=\"MSHTML 5.00.2920.0\" name=GENERATOR>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' />\n<!-- \t<script language=\'javascript\' src=\'../../eCA/js/prototype.js\'></script>  -->\n\t<SCRIPT language=\"javascript\" src=\"../../eCommon/js/RTEditor.js\"></SCRIPT>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<script language=\'JavaScript\'>\n\nvar HTMLContent = \"<html><body><form name=\\\'ImageRTEditorForm\\\' action = \\\'../../eCA/jsp/RTEditor.jsp\\\' method=\\\'post\\\'>\";\nHTMLContent += \"<textarea name = \\\'RTEText\\\' style = \\\'visibility:hidden\\\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</textarea>\";\nHTMLContent += \"<input type = hidden name = content_editable_yn value = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\";\nHTMLContent += \"<input type = hidden name = editor_param value = \'A\'>\";\nHTMLContent += \"</form></body></html>\";\n//parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.srl_no.value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\t//[IN033869]\nvar controller = parent.RecClinicalNotesSecControlFrame;\n//controller.document.body.innerHTML = \"\";\ncontroller.document.body.insertAdjacentHTML(\'beforeend\', HTMLContent);\n//parent.RecClinicalNotesHeaderFrame.document.getElementById(\"srl_no\").value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';//IN034055//IN034224\n</script>\n</head>\n<body>\n<FRAMESET  id = \"frameSetIDPainterEditor\" border=\"0\" >\n\t<iFRAME SRC=\"../../eCommon/html/blank.html\" NAME=\"RecClinicalNotesRTEditorFrame\" id=\"RecClinicalNotesRTEditorFrame\" noresize style=\"height:98vh;width:97vw;\"></iFRAME>\n</FRAMESET>\n\n<script language=\"JavaScript\">\n\ngetEditor(); \n\nfunction getEditor()\n{\n\tvar controller = parent.RecClinicalNotesSecControlFrame;\n\tcontroller.document.ImageRTEditorForm.target = parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame.name;\n\tcontroller.document.ImageRTEditorForm.submit();\n}\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);//IN033869
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);


String RTEText						=	"";
String strContentEditableYn			=	"";
String accessnum					= 	"";	//[IN033677]
String facility_id					=	""; //[IN033677]
String srl_no						=	"";

Connection			con				=	null;  //IN034871
PreparedStatement addendumTextPstmt = null; //IN034871
ResultSet addendumTextRs = null; //IN034871
strContentEditableYn		=	(request.getParameter("content_editable_yn")==null?"Y":request.getParameter("content_editable_yn"));


if(strContentEditableYn.equals("") )
	strContentEditableYn = "Y";
	
facility_id			= (String)session.getValue("facility_id"); //[IN033677]
accessnum			= (request.getParameter("accession_num")==null)?"":request.getParameter("accession_num");  //[IN033677]
String curr_sec_hdg_code			= (request.getParameter("curr_sec_hdg_code")==null)?"":request.getParameter("curr_sec_hdg_code");//IN033677
String curr_child_sec_hdg_code			= (request.getParameter("curr_child_sec_hdg_code")==null)?"":request.getParameter("curr_child_sec_hdg_code");//IN033677
String login_user_id = (String) session.getValue("login_user");
String patient_id			= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
String encounter_id			= (request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
String note_type			= (request.getParameter("encounter_id")==null)?"":request.getParameter("note_type");

//String strExistingContent = (String) sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");//IN033869//IN033677
String strExistingContent = "";

//IN071264 Starts
String addendum_text_temp = "";
String auto_save_yn ="N";
CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
//IN071264 Ends
//IN033677,starts
if( !(curr_sec_hdg_code.equals("")) )
{
	//IN071264 Starts
	//strExistingContent = (String) sectionBean.getAddendumText(curr_sec_hdg_code,curr_child_sec_hdg_code);
	  if("Y".equals(auto_save_yn)){
		 if(curr_sec_hdg_code.equals("*AmmendNotes*"))
			addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("*tempAmmendNotes*","*tempAmmendNotes*");
		 else	
			 addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("temp"+curr_sec_hdg_code,"temp"+curr_child_sec_hdg_code);
		}
if(null!=addendum_text_temp && !"".equals(addendum_text_temp)){
	strExistingContent = addendum_text_temp;
}
else{
	strExistingContent = (String) sectionBean.getAddendumText(curr_sec_hdg_code,curr_child_sec_hdg_code);
} 
//IN071264 Ends
}
else
{ 
	try{//IN071264
	con				=	ConnectionManager.getConnection(request); //IN071264
	//[IN034871] Start.
	//IN067862 Start.
	//String addendumTextSql = "SELECT srl_no, addendum_text, addendum_status FROM ca_encntr_note_addendum WHERE accession_num = ? AND addendum_status = 'R' and sec_hdg_code = ? and SUBSEC_HDG_CODE = ? ORDER BY srl_no";
	String addendumTextSql = "SELECT srl_no, addendum_text, addendum_status,addendum_clob,addendum_storage_type FROM ca_encntr_note_addendum WHERE accession_num = ? AND addendum_status = 'R' and sec_hdg_code = ? and SUBSEC_HDG_CODE = ? ORDER BY srl_no";
	//IN067862 End.
	String addendumTexttmp = "";//IN071264 Starts
	 if("Y".equals(auto_save_yn)){
		 
			addendumTextPstmt = con.prepareStatement("SELECT ADDENDUM_CLOB FROM CA_ENCNTR_NOTE_ADDENDUM_TMP WHERE PATIENT_ID=? AND ENCOUNTER_ID=? AND NOTE_TYPE=? AND ADDED_BY_ID=? AND SEC_HDG_CODE = ? and SUBSEC_HDG_CODE = ? ");
			addendumTextPstmt.setString(1,patient_id);
			addendumTextPstmt.setString(2,encounter_id);
			addendumTextPstmt.setString(3,note_type);
			addendumTextPstmt.setString(4,login_user_id);
			addendumTextPstmt.setString(5,"*AmmendNotes*");
			addendumTextPstmt.setString(6,"*AmmendNotes*");
			addendumTextRs	=	addendumTextPstmt.executeQuery();
			if(addendumTextRs.next())
			{
				addendumTexttmp = addendumTextRs.getString("ADDENDUM_CLOB");
			}
			sectionBean.setAddendumText("*tempAmmendNotes*","*tempAmmendNotes*",addendumTexttmp);
			addendum_text_temp = (java.lang.String) sectionBean.getAddendumText("*tempAmmendNotes*","*tempAmmendNotes*");
	 }
	if(null!=addendum_text_temp && !"".equals(addendum_text_temp))
	{
		strExistingContent =addendum_text_temp;
	}
	 else{//IN071264 Ends
	/* try{
		con				=	ConnectionManager.getConnection(request); *//* Commented for IN071264  */
		
		if(!accessnum.equals("&nbsp;") && !accessnum.equals(""))
		{
			addendumTextPstmt = con.prepareStatement(addendumTextSql);
			addendumTextPstmt.setString(1,accessnum);
			addendumTextPstmt.setString(2,"*AmmendNotes*");
			addendumTextPstmt.setString(3,"*AmmendNotes*");
			addendumTextRs				=	addendumTextPstmt.executeQuery();
			String addendumText = "";

			if(addendumTextRs.next())
			{
				//IN067862 Start.
				//addendumText = addendumTextRs.getString("addendum_text");
				if("CLOB".equals((String)addendumTextRs.getString("addendum_storage_type")))
					addendumText = addendumTextRs.getString("addendum_clob");
				else
					addendumText = addendumTextRs.getString("addendum_text");
				
				//IN067862 End.
			}			
			sectionBean.setAddendumText("*AmmendNotes*","*AmmendNotes*",addendumText);
		}
	
	
	//[IN034871] End.
	strExistingContent = (String) sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");
	 }//IN071264
 }catch(Exception e)
 {
 	//out.println("Exception@2: "+e);//COMMON-ICN-0181
 	e.printStackTrace();
 }
 finally
 {
 	if(addendumTextRs!=null) addendumTextRs.close();
 	if(addendumTextPstmt!=null) addendumTextPstmt.close();
 	if(con!=null)	ConnectionManager.returnConnection(con,request);
 }
}
//IN033677,ends

//System.out.println("RecClinicalNotesAddendumEditorsFrame.jsp,strExistingContent=>"+strExistingContent);
if(strExistingContent == null)//IN033677
	strExistingContent = "";
//strExistingContent			=	java.net.URLEncoder.encode(strExistingContent,"UTF-8");
RTEText = java.net.URLEncoder.encode(strExistingContent,"UTF-8");//IN033677

//Dinesh T on 9/14/2012,starts

//Dinesh T on 9/14/2012,ends

//IN033677,starts
/*if(strExistingContent.equals("") || strExistingContent.equals("<ADDRESS>&nbsp;</ADDRESS>"))//IN033869
{
	if(!accessnum.equals(""))
	{
		Connection			con			=	null;
		PreparedStatement	pstmt		=	null;
		ResultSet			rs			=	null;
		try{
			con				=	ConnectionManager.getConnection(request);
			//pstmt			=	con.prepareStatement("SELECT SRL_NO,ADDENDUM_TEXT FROM CA_ENCNTR_NOTE_ADDENDUM WHERE FACILITY_ID=? AND ACCESSION_NUM=? AND ADDENDUM_STATUS='R'");//IN033881
			//IN071569 Start.
			//pstmt			=	con.prepareStatement("SELECT SRL_NO,ADDENDUM_TEXT FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND ADDENDUM_STATUS='R'");//IN033881
			pstmt			=	con.prepareStatement("SELECT SRL_NO,ADDENDUM_TEXT,ADDENDUM_CLOB,ADDENDUM_STORAGE_TYPE FROM CA_ENCNTR_NOTE_ADDENDUM WHERE ACCESSION_NUM=? AND ADDENDUM_STATUS='R'");//IN033881
			//IN071569 End.
			//pstmt.setString(1, facility_id );
			pstmt.setString(1, accessnum);
			
			rs				=	pstmt.executeQuery();
			String  tem_text ="";
			if(rs.next())
			{
					srl_no	=rs.getString(1);
					//IN071569 Start.
					//tem_text =rs.getString(2);
					if("CLOB".equals((String)rs.getString(4)))
						tem_text =rs.getString(3);
					else
						tem_text =rs.getString(2);
					//IN071569 end.
					RTEText  =java.net.URLEncoder.encode(tem_text,"UTF-8");
			}
		}catch(Exception e){
			out.println("Exception@1 : "+e);
		}finally{			
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
}
else//IN033869,starts
{
	RTEText = java.net.URLEncoder.encode(strExistingContent,"UTF-8");
}//IN033869,ends
*/
//IN033677,ends

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(RTEText));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strContentEditableYn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RichTextEditorandMEDIPainter.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
