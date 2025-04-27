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

public final class __recclinicalnotespopulatenotegroup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesPopulateNoteGroup.jsp", 1709116179372L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html><head>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script>\nvar note_type_obj = \"\";\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\nif (\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" == \"Header\")\n{\t\n\tnote_type_obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type;\n}else if (\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" == \"Prev_Notes\")\n{\t\n\tnote_type_obj = parent.RecClinicalNotesPrevNotesSearchCriteriaFrame.document.RecClinicalNotesPrevNotesCriteriaForm.note_type;\n\tvar filter = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\t\n}\nvar element ;\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</script></head><body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'MESSAGE\'></body></html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
?           100				?	         	?				?				created
02/06/2014	IN037701		Nijitha											SKR-CRF-0036
------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
String		call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getParameter("filter_by")));
            _bw.write(_wl_block11Bytes, _wl_block11);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String practitioner_id		=	(String)session.getValue("ca_practitioner_id");
	String		note_group = request.getParameter("note_group")==null?"":request.getParameter("note_group");
	String		patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String		appl_task_id = request.getParameter("appl_task_id")==null?"":request.getParameter("appl_task_id");
	String		filter_by = request.getParameter("filter_by")==null?"":request.getParameter("filter_by");
	String		speciality_list = request.getParameter("speciality_list")==null?"":request.getParameter("speciality_list");	
	String		resp_id			=	(String)		session.getValue("responsibility_id");
	String		note_type	=	"",		note_type_desc	=	"";
	String		facility_id				=	(String)session.getValue("facility_id");
	//IN037701 Starts
	String p_event_class_widget = request.getParameter("p_event_class_widget") == null ? "" : request.getParameter("p_event_class_widget");
	//IN037701 Ends
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer note_group_query = new StringBuffer();

	try
	{
		con = ConnectionManager.getConnection(request);		
//int count = 0;
		//out.println("alert('" + note_group + "=" + appl_task_id +  "');");
		/*StringBuffer note_group_query = new StringBuffer("Select note_type, replace(note_type_desc,'''','') note_type_desc from ca_note_type_for_resp_view where resp_id = ? and privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN)='Y' ");
		if(note_group.equals(""))
			note_group_query.append(" AND NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)");
		else
			note_group_query.append(" and note_group_id=? ");

		note_group_query.append(" order by 2"); */
		//

		

		if (filter_by.equals("R"))
		{
			note_group_query.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc1 from ca_note_type_for_resp a, ca_note_type_lang_vw c  where a.resp_id = ?  and a.note_type = c.note_type and c.language_id = ?  and a.privilege_type != '5' and decode(?,'IP',c.inpatient_yn,'OP',c.outpatient_yn,'DC',c.DAYCARE_YN,'EM',c.EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' ");
			if(note_group.equals(""))
				note_group_query.append(" AND C.NOTE_GROUP_ID IN ( SELECT NOTE_GROUP FROM CA_NOTE_GROUP  WHERE APPL_TASK_ID=?)");
			else
				note_group_query.append(" and c.note_group_id=? ");
			//IN037701 Starts
			if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
			{
				note_group_query.append(" 	AND c.EVENT_CLASS= ? ");
			}
			//IN037701 Starts
			if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
				note_group_query.append(" AND  (EXISTS (SELECT 1 FROM CA_PMR_FOR_PRACTITIONER WHERE NOTE_TYPE_ID=A.NOTE_TYPE AND PRACTITIONER_ID=? AND FACILITY_ID=? ) OR (EXISTS (SELECT 1 FROM  CA_PMR_FOR_SPECIALITY WHERE NOTE_TYPE_ID=A.NOTE_TYPE  AND FACILITY_ID=? AND SPECIALITY_CODE IN  (SELECT  PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?))))");
				
				
				
				note_group_query.append(" order by 2");	
		}else if (filter_by.equals("P") ) 
		{		 
			note_group_query.append("Select a.note_type_id note_type, replace(c.note_type_desc,'''','') note_type_desc1 from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? and a.RESOURCE_CODE = ?  and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )    ");
			if(note_group.equals(""))
				note_group_query.append(" AND C.NOTE_GROUP_ID IN ( SELECT NOTE_GROUP FROM CA_NOTE_GROUP  WHERE APPL_TASK_ID=?)");
			else
				note_group_query.append(" and c.note_group_id=? ");
			//IN037701 Starts
			if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
			{
				note_group_query.append(" 	AND c.EVENT_CLASS= ? ");
			}
			//IN037701 Starts
			note_group_query.append(" order by 2");	
		}
		else if (filter_by.equals("S")) 
		{		 
			note_group_query.append("Select a.note_type_id note_type, replace(c.note_type_desc,'''','') note_type_desc1 from ca_note_type_for_resource a , ca_note_type_lang_vw c where a.resource_type=? ");
		   if (!(speciality_list.equals("")))
				note_group_query.append(" and a.RESOURCE_CODE = ?  ");
		   else
	  			  note_group_query.append(" and a.RESOURCE_CODE in (SELECT PRIMARY_SPECIALITY_CODE FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? UNION SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE PRACTITIONER_ID= ?)  ");
			note_group_query.append(" and a.note_type_id = c.note_type and c.language_id =? and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and EFF_STATUS='E' AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp WHERE note_type = a.note_type_id   AND resp_id = ?  AND privilege_type != '5' )    ");
			if(note_group.equals(""))
				note_group_query.append(" AND C.NOTE_GROUP_ID IN ( SELECT NOTE_GROUP FROM CA_NOTE_GROUP  WHERE APPL_TASK_ID=?)");
			else
				note_group_query.append(" and c.note_group_id=? ");
			//IN037701 Starts
			if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
			{
				note_group_query.append(" 	AND c.EVENT_CLASS= ? ");
			}
			//IN037701 Starts
			note_group_query.append(" order by 2");	
		}else if (filter_by.equals(""))
		{
			note_group_query.append("Select a.note_type, replace(c.note_type_desc,'''','') note_type_desc1 from ca_note_type_for_resp a, sm_resp b,ca_note_type_lang_vw c  where b.resp_id = ?  and b.resp_id = a.resp_id and a.note_type = c.note_type and c.language_id = ?  and a.privilege_type != '5' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and c.EFF_STATUS='E' ");
			if(note_group.equals(""))
				note_group_query.append(" AND C.NOTE_GROUP_ID IN ( SELECT NOTE_GROUP FROM CA_NOTE_GROUP  WHERE APPL_TASK_ID=?)");
			else
				note_group_query.append(" and c.note_group_id=? ");
			//IN037701 Starts
			if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
			{
				note_group_query.append(" 	AND c.EVENT_CLASS= ? ");
			}
			//IN037701 Starts
				note_group_query.append(" order by 2");	
		}


		pstmt = con.prepareStatement(note_group_query.toString());
			
		if (filter_by.equals("R"))
		{
			pstmt.setString(1, resp_id);
			pstmt.setString(2, locale);
			pstmt.setString(3, patient_class);
			if(note_group.equals(""))
				pstmt.setString(4, appl_task_id);
			else
				pstmt.setString(4, note_group);
			//IN037701 Starts
			if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
			{
				//p_event_class_widget
				 pstmt.setString(5,p_event_class_widget);
			}
			//IN037701 Starts
			if (appl_task_id.equals("PAT_MEDICAL_REPORT"))
			{
				 pstmt.setString(5,practitioner_id);
				 pstmt.setString(6,facility_id);
				 pstmt.setString(7,facility_id);
				 pstmt.setString(8,practitioner_id);
				 pstmt.setString(9,practitioner_id);
			}
		}
		else if (filter_by.equals("P"))
		{
			pstmt.setString(1,"P");
			pstmt.setString(2,practitioner_id);
			pstmt.setString(3,locale);
			pstmt.setString(4,patient_class);
			pstmt.setString(5,resp_id);
			if(note_group.equals(""))
				pstmt.setString(6, appl_task_id);
			else
				pstmt.setString(6, note_group);
			//IN037701 Starts
			if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
			{
				//p_event_class_widget
				 pstmt.setString(7,p_event_class_widget);
			}
			//IN037701 Ends
		}
		 else  if (filter_by.equals("S"))
		 {
			pstmt.setString(1,"S");
			if (!(speciality_list.equals("")))
			{
				pstmt.setString(2,speciality_list);
				pstmt.setString(3,locale);
				pstmt.setString(4,patient_class);
				pstmt.setString(5,resp_id);
				if(note_group.equals(""))
					pstmt.setString(6, appl_task_id);
				else
					pstmt.setString(6, note_group);
				//IN037701 Starts
				if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
				{
					//p_event_class_widget
					 pstmt.setString(7,p_event_class_widget);
				}
				//IN037701 Ends
			}
			else
			 {
				pstmt.setString(2,practitioner_id);
				pstmt.setString(3,practitioner_id);
				pstmt.setString(4,locale);
				pstmt.setString(5,patient_class);
				pstmt.setString(6,resp_id);
				if(note_group.equals(""))
					pstmt.setString(7, appl_task_id);
				else
					pstmt.setString(7, note_group);
				//IN037701 Starts
				if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
				{
					//p_event_class_widget
					 pstmt.setString(8,p_event_class_widget);
				}
				//IN037701 Ends
			 }

		}if (filter_by.equals(""))
		{
			pstmt.setString(1, resp_id);
			pstmt.setString(2, locale);
			pstmt.setString(3, patient_class);
			if(note_group.equals(""))
				pstmt.setString(4, appl_task_id);
			else
				pstmt.setString(4, note_group);
			//IN037701 Starts
			if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
			{
				//p_event_class_widget
				 pstmt.setString(5,p_event_class_widget);
			}
			//IN037701 Ends
		}

		rs = pstmt.executeQuery();			
		while(rs.next())
		{
			note_type			= rs.getString("note_type");
			note_type_desc	= rs.getString("note_type_desc1");
			out.println("element = document.createElement('OPTION');");
			out.println("element.text = '" +  note_type_desc + "';");
			out.println("element.value = '" + note_type + "';");
			out.println("note_type_obj.add(element);");

		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception Caught in RecClinicalNotesPopulateNoteGroup.jsp   <BR>" + e);//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
