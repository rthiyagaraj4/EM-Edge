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

public final class __recclinicalnoteslinkdocstree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkDocsTree.jsp", 1709116149685L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart3.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n<form name=\"documents_detail_form\" id=\"documents_detail_form\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<table cellspacing=0 cellpadding=\'3\' width=\'100%\' border=1 id=\'tb1\' align=\'center\' >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</table>\n<!-- <input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"> -->\n<input type=\"hidden\" name=\"hist_rec_type\" id=\"hist_rec_type\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<input type=\"hidden\" name=\"totalDateCount\" id=\"totalDateCount\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<input type=\"hidden\" name=\"totalEventClassCount\" id=\"totalEventClassCount\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<input type=\"hidden\" name=\"totalEventGroupCount\" id=\"totalEventGroupCount\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<input type=\"hidden\" name=\"totalEventCount\" id=\"totalEventCount\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\"hidden\" name=\"data_type\" id=\"data_type\" value=\"\">\n<input type=\"hidden\" name=\"selected_events\" id=\"selected_events\" value=\"\">\n</form>\n</body>\n</html>\n\n";
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con	= null;
	PreparedStatement stmt	= null;//con.createStatement();
	ResultSet rs			= null;

	//out.println("QUERY STRING " +request.getQueryString());

	String result_linked_rec_type	= request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	
	String patientid				= request.getParameter("patient_id")==null?"": request.getParameter("patient_id");
	String facility_id				= (String) session.getValue("facility_id");


	String preveventclassCode = "";
	String preveventgroupCode = "";

	String preveventdate = "";
	String prevNewEventGroup = "";

	String classValue = "";
	StringBuffer sql= new StringBuffer();
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id == null)resp_id ="";
	int i=0;
	int j=0;
	int k = 0;
	int l = 0;


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try
	{
		con	= ConnectionManager.getConnection(request);

	/*	sql.append(" Select a.EVENT_DATE ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') e_date");
		sql.append(",a.hist_rec_type hist_rec_type ");
		sql.append(" ,b.short_desc hist_rec_type_desc ");
		sql.append(" ,translate(a.event_class,'!@#$%^&*()','1234567890') event_class");
		sql.append(" ,a.event_class event_class_original");
		sql.append(" ,c.long_desc  event_class_desc ");
		sql.append(" ,translate(a.event_group,'!@#$%^&*()','1234567890') event_group");
		sql.append(" ,a.event_group event_group_original");
		sql.append(" ,e.long_desc  event_group_desc ");
		sql.append(" ,translate(a.event_code,'!@#$%^&*()','1234567890') event_code");
		sql.append(" ,a.event_code event_code_original");
		sql.append(" ,d.long_desc  event_code_desc ");
		sql.append(" ,hist_data_type,/*translate(a.accession_num,'!@#$%^&*()','1234567890')*//* a.accession_num");
		sql.append(" ,a.contr_sys_id, /*translate(a.contr_sys_event_code,'!@#$%^&*()','1234567890')*//* a.contr_sys_event_code ");
		sql.append(" ,count(*) rec_count ");
		sql.append(" From cr_encounter_detail a ");
		sql.append(" ,cr_hist_rec_type b ");
		sql.append(" ,cr_event_class   c ");
		sql.append(" ,cr_clin_event_mast d ");
		sql.append(" ,cr_clin_event_group e ");
		sql.append(" where b.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  c.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  c.event_class= a.event_class ");
		sql.append(" and  d.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  d.event_code=a.event_code ");
		sql.append(" and  e.hist_rec_type(+)=a.hist_rec_type ");
		sql.append(" and  e.event_group(+)=a.event_group ");
		sql.append( " and a.hist_rec_type = ? ");
		sql.append( " and a.patient_id =  and (nvl(PROTECTION_IND,'N')!='Z' OR						(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,NULL)='A')) and nvl(a.STATUS,'NYSE') not in ('S','E') ");
		sql.append(" group by a.EVENT_DATE, to_char(a.event_date,'dd/mm/yyyy hh24:mi'), a.hist_rec_type, b.short_desc ");
		sql.append(" ,a.event_class,c.long_desc,a.event_group ");
		sql.append(" ,d.long_desc,a.event_code,e.long_desc,hist_data_type,a.accession_num , a.contr_sys_id, a.contr_sys_event_code ");		*/
		
		sql.append(" Select a.EVENT_DATE ,to_char(a.event_date,'dd/mm/yyyy hh24:mi') e_date");
		sql.append(",a.hist_rec_type hist_rec_type ");
		sql.append(" ,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'2') hist_rec_type_desc ");
		sql.append(" ,translate(a.event_class,'!@#$%^&*()','1234567890') event_class");
		sql.append(" ,a.event_class event_class_original");
		sql.append(" ,c.long_desc  event_class_desc ");
		sql.append(" ,translate(a.event_group,'!@#$%^&*()','1234567890') event_group");
		sql.append(" ,a.event_group event_group_original");
		sql.append(" ,e.long_desc  event_group_desc ");
		sql.append(" ,translate(a.event_code,'!@#$%^&*()','1234567890') event_code");
		sql.append(" ,a.event_code event_code_original");
		sql.append(" ,d.long_desc  event_code_desc ");
		sql.append(" ,hist_data_type,/*translate(a.accession_num,'!@#$%^&*()','1234567890')*/ a.accession_num");
		sql.append(" ,a.contr_sys_id, /*translate(a.contr_sys_event_code,'!@#$%^&*()','1234567890')*/ a.contr_sys_event_code ");
		sql.append(" ,count(*) rec_count ");
		sql.append(" From cr_encounter_detail a ");
		sql.append(" ,CR_EVENT_CLASS_LANG_VW  c ");
		sql.append(" ,CR_CLN_EVT_MST_LANG_VW d ");
		sql.append(" ,CR_CLN_EVT_GRP_LANG_VW e ");
		sql.append(" where  c.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  c.event_class= a.event_class ");
		sql.append(" and  d.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  d.event_code=a.event_code ");
		sql.append(" and  c.language_id = ? and d.language_id = ? and e.language_id = ? ");
		sql.append(" and  e.hist_rec_type(+)=a.hist_rec_type ");
		sql.append(" and  e.event_group(+)=a.event_group ");
		sql.append( " and a.hist_rec_type = ? ");
		sql.append( " and a.patient_id =  and (nvl(PROTECTION_IND,'N')!='Z' OR						(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,NULL)='A')) and nvl(a.STATUS,'NYSE') not in ('S','E') ");
		sql.append(" group by a.EVENT_DATE, to_char(a.event_date,'dd/mm/yyyy hh24:mi'), a.hist_rec_type,  ");
		sql.append(" ,a.event_class,c.long_desc,a.event_group ");
		sql.append(" ,d.long_desc,a.event_code,e.long_desc,hist_data_type,a.accession_num , a.contr_sys_id, a.contr_sys_event_code ");

		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, locale);
		stmt.setString(2, locale); 
		stmt.setString(3, locale);
		stmt.setString(4, locale);
		stmt.setString(5, result_linked_rec_type);
		stmt.setString(6, patientid);
		stmt.setString(7, resp_id);

		rs = stmt.executeQuery();
		int counterForCode=0;
		int counterForCodeForNullGroup=0;
		int counterForGroup=0;
		int counterForClass=0;


		//String histtypedesc	= "";
		String eventclassdesc = "",eventclassdescPrev ="";
		String eventgroupdesc = "",eventgroupdescPrev="";
		String eventcodedesc = "",eventcodedescPrev="";
		
		String newEventClassCode = "",newEventClassCodePrev="";
		String eventgroupcode	= "",eventgroupcodePrev="";
		String newEventGroupCode = "",newEventGroupCodePrev="";
		StringBuffer value	= new StringBuffer();
		StringBuffer valuePrev = new StringBuffer();
		String eventdatetime = "";
		String eventdate = "",eventdatePrev="";
		String eventtime = "",eventtimePrev="";
		//String eventDateWithoutSlash="";
		//String eventTimeWithoutColon="";

		String eventClassOriginal="",eventClassOriginalPrev="";
		String eventGroupOriginal="",eventGroupOriginalPrev="";
		String eventCodeOriginal="",eventCodeOriginalPrev="";

		int recordCounter = 0;

		if(rs != null)
		{
			while (rs.next())
			{
				//histtypedesc	= rs.getString("hist_rec_type_desc")==null?"":rs.getString("hist_rec_type_desc");
				eventclassdesc	= rs.getString("event_class_desc")==null?"":"&nbsp;"+rs.getString("event_class_desc");
				eventgroupdesc	= rs.getString("event_group_desc")==null?"":"&nbsp;&nbsp;"+rs.getString("event_group_desc");
				eventcodedesc	= rs.getString("event_code_desc")==null?"":"&nbsp;&nbsp;&nbsp;"+rs.getString("event_code_desc");
				//eventclasscode	= rs.getString("event_class")==null?"":"&nbsp;"+rs.getString("event_class");
				newEventClassCode = rs.getString("event_class")==null?"":rs.getString("event_class");
				eventgroupcode	= rs.getString("event_group")==null?"":"&nbsp;&nbsp;"+rs.getString("event_group");
				newEventGroupCode = rs.getString("event_group")==null?"_":rs.getString("event_group");
				//eventcode	= rs.getString("event_code")==null?"":"&nbsp;&nbsp;&nbsp;"+rs.getString("event_code");
				//accessionnum = rs.getString("accession_num");
				//reccount	= "&nbsp;("+rs.getString("rec_count")+")";
				eventdatetime	= rs.getString("e_date")==null?"":rs.getString("e_date");
				eventClassOriginal = rs.getString("event_class_original")==null?"":rs.getString("event_class_original");
				eventGroupOriginal = rs.getString("event_group_original")==null?"":rs.getString("event_group_original");
				eventCodeOriginal  = rs.getString("event_code_original")==null?"":rs.getString("event_code_original");

				eventdate = eventdatetime.substring(0,eventdatetime.indexOf(" "));
				eventtime = eventdatetime.substring(eventdatetime.indexOf(" "));

				value.append(rs.getString("accession_num")+"~"+rs.getString("hist_data_type")+"~"+rs.getString("hist_rec_type")+"~"+rs.getString("contr_sys_id")+"~"+rs.getString("contr_sys_event_code")+"~");
				value.append(eventdatetime+"~");

				//eventDateWithoutSlash=eventdate.replace('/','k').trim();
				//eventTimeWithoutColon=eventtime.replace(':','c').trim();


				//******************************************************//
				//actual priniting of the tree starts from here
				//remember the printing is the record fetched prior to this record ie it is one fetch behind
				//this is done so as to get the next time of the recorded event
				if(recordCounter > 0)
				{
					if(!eventdatePrev.equals("") && !preveventdate.equals(eventdatePrev))
					{
						counterForCode=0;
						counterForGroup=0;
						counterForClass=0;
						counterForCodeForNullGroup=0;
						out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev.toString()+"','Heading','" + facility_id + "')\" class='COMMONTOOLBARFUNCTION'><font size=1>"+eventdatePrev+"</font></td></tr>");
						 
						 preveventclassCode = "";
						 preveventgroupCode = "";
						 i++;
					}
					valuePrev.append(eventClassOriginalPrev+"~");
					//if(!eventclassdesc.equals("") && (!preveventclassdesc.equals(eventclassdesc) ||!preveventdate.equals(eventdate)))
					if(!newEventClassCodePrev.equals("") && (!preveventclassCode.equals(newEventClassCodePrev) ||!preveventdate.equals(eventdatePrev)))
					{
						counterForCode=0;
						counterForGroup=0;
						counterForCodeForNullGroup=0;
						out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev.toString()+"','Heading','" + facility_id + "')\" class='CAGROUP'><font size=1>"+eventclassdescPrev+"</font></td></tr>");
						j++;
						
						counterForClass++;
					}
					valuePrev.append(eventGroupOriginalPrev+"~");

					if(!eventgroupcodePrev.equals("") && (!preveventgroupCode.equals(eventgroupcodePrev)||!preveventclassCode.equals(newEventClassCodePrev) ||(!preveventdate.equals(eventdatePrev))))
					{
						counterForCode=0;
						out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev.toString()+"','Heading','" + facility_id + "')\" class='CAFOURTHLEVELCOLOR'><font size=1>"+eventgroupdescPrev+"</font></td></tr>");
						k++;
						counterForGroup++;
					}
					valuePrev.append(eventCodeOriginalPrev);
					if(l%2==0)
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";

					if(!newEventGroupCodePrev.equals(prevNewEventGroup))
					{
						counterForCode=0;
					}
					if(newEventGroupCodePrev.equals("_"))
					{
						counterForCode = counterForCodeForNullGroup;
						counterForCodeForNullGroup++;
					}
					out.println("<tr id='tblrow_id"+l+"'><td onClick=\"javascript:showDetails('"+valuePrev.toString()+"','','" + eventcodedescPrev + "')\" class='"+classValue+"' style=cursor:pointer;><font size=1>"+"&nbsp;&nbsp;" + eventtimePrev + eventcodedescPrev + "</font></td></tr>");
					l++;
					counterForCode++;
					preveventdate = eventdatePrev ;

					preveventclassCode = newEventClassCodePrev;
					preveventgroupCode = eventgroupcodePrev;
					prevNewEventGroup = newEventGroupCodePrev;
				}
				//*****************************************************************/
				//histtypedescPrev = histtypedesc;
				eventclassdescPrev = eventclassdesc;
				eventgroupdescPrev = eventgroupdesc;
				eventcodedescPrev = eventcodedesc;

				newEventClassCodePrev = newEventClassCode;
				eventgroupcodePrev= eventgroupcode;
				newEventGroupCodePrev= newEventGroupCode;
				

				
				valuePrev.append(value.toString());

				eventdatePrev = eventdate;
				eventtimePrev = eventtime;
 

				eventClassOriginalPrev= eventClassOriginal;
				eventGroupOriginalPrev= eventGroupOriginal;
				eventCodeOriginalPrev= eventCodeOriginal;

				recordCounter++;
			}//end of while

			//**************************************************************//
			//printing the last record
			if(recordCounter>0)
			{
				if(!eventdatePrev.equals("") && !preveventdate.equals(eventdatePrev))
				{
					counterForCode=0;
					counterForGroup=0;
					counterForClass=0;
					counterForCodeForNullGroup=0;
					out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev.toString()+"','Heading','" + facility_id + "')\" class='COMMONTOOLBARFUNCTION'><font size=1>"+eventdatePrev+"</font></td></tr>");
		            
					preveventclassCode = "";
					preveventgroupCode = "";
                    i++;
				}
				valuePrev.append(eventClassOriginalPrev+"~");
				if(!newEventClassCodePrev.equals("") && (!preveventclassCode.equals(newEventClassCodePrev) ||!preveventdate.equals(eventdatePrev)))
				{
					counterForCode=0;
					counterForGroup=0;
					counterForCodeForNullGroup=0;
					out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev.toString()+"','Heading','" + facility_id + "')\" class='CAGROUP'><font size=1>"+eventclassdescPrev+"</font></td></tr>");
					j++;

					counterForClass++;
				}
				valuePrev.append(eventGroupOriginalPrev+"~");
				if(!eventgroupcodePrev.equals("") && (!preveventgroupCode.equals(eventgroupcodePrev)||!preveventclassCode.equals(newEventClassCodePrev) ||(!preveventdate.equals(eventdatePrev))))
				{
					counterForCode=0;
					//counterForGroup=0;
					out.println("<tr><td colspan=1 onClick=\"javascript:showDetails('"+valuePrev.toString()+"','Heading','" + facility_id + "')\" class='CAFOURTHLEVELCOLOR'><font size=1>"+eventgroupdescPrev+"</font></td></tr>");
					k++;
					counterForGroup++;
				}
				valuePrev.append(eventCodeOriginalPrev);
				if(l%2==0)
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";

				if(!newEventGroupCodePrev.equals(prevNewEventGroup))
				{
					counterForCode=0;
				}
				if(newEventGroupCodePrev.equals("_"))
				{
					counterForCode = counterForCodeForNullGroup;
					counterForCodeForNullGroup++;
				}
				out.println("<tr id='tblrow_id"+l+"'><td onClick = \"javascript:showDetails('"+valuePrev.toString()+"','','" + eventcodedescPrev + "')\" class='"+classValue+"' style=cursor:pointer;><font size=1>"+"&nbsp;&nbsp;"+ eventtimePrev + eventcodedescPrev + "</font></td></tr>");
				l++;
			}
		//*****************************************************************/
		}
	
	
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	}	catch(Exception e){
		out.println(e);
	}
	finally
	{
		if(con!=null)		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(result_linked_rec_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(j));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(k));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(l));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
