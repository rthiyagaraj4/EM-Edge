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

public final class __recclinicalnotesprevnotessearchdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesPrevNotesSearchDetail.jsp", 1737447124801L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script Language=\"JavaScript\" src=\'../../eCA/js/RecClinicalNotesFileUpload.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart4.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onscroll=\'scrollTitle()\' class=\'CONTENT\'>\n<center>\n<form name=\'RecClinicalNotesPrevNotesResultForm\' id=\'RecClinicalNotesPrevNotesResultForm\' action = \"../../eCA/jsp/RecClinicalNotesPrevNotesSearchDetail.jsp\" method=post>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<div id=\'divTitleTable\'>\n\t<table cellspacing=0 cellpadding=3 width=\'100%\' border=1 id=\'titleTable\' align=\'center\'>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\'><a class=\'gridLink\' name=1 href=\"javascript:callForOrderBy(\'DT\');\" onclick=\'changeColor(this);\' style=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a></td>\n\t</tr>\n\t</table>\n\t</div>\n\n\t<table class=\'grid\'width=\'100%\' id=\'tb1\'>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<tr id=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' VALIGN=top ><a  class=\'gridLink\' href=\"javascript:call_notes(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\');\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<tr style=\"visibility:hidden\">\n\t<td class=\'columnheader\'><a class=\'gridLink\' name=1 href=\"javascript:callForOrderBy(\'DT\');\" onclick=\'changeColor(this);\' style=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a></td>\n</tr>\n</table>\n<input type=hidden name=orderBy value=\"\"></input>\n<input type=hidden name=reOrder value=\"\"></input>\n<input type=hidden name=patient_id value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></input>\n<input type=hidden name=encounter_id value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></input>\n<input type=hidden name=status value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"></input>\n<input type=hidden name=from_date_time value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></input>\n<input type=hidden name=to_date_time value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></input>\n<input type=hidden name=note_type value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></input>\n<input type=hidden name=appl_task_id value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"></input>\n</form>\n</center>\n</body>\n<!-- <script>alignUnitsAndData();</script> -->\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<script>call_notes(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');</script>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
18/12/2013	IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality
03/02/2020		IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
---------------------------------------------------------------------------------------------------------------

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

	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	StringBuffer query_notes_detail	=	new StringBuffer();
	StringBuffer whereClause		=	new StringBuffer();

	
	String	classValue			=	"";
	String	note_type			=	"";
	String	temp_note_type			=	"";
	String	note_group			=	"",		appl_task_id		=	"";
	String	event_date_time		=	"";
	String	tblrow_id			=	"";
	String	login_user_id		=	"",		clinician_id		=	"";
	String	resp_id				=	"";
	String	patient_id			=	"",		encounter_id			=	"";
	String	from_date_time		=	"",		to_date_time		=	"";
	String  from_date_time_en	=	"",		to_date_time_en		=	"";
	String event_status         =   "";
	String accession_num         =   "";
	String ext_image_appl_id         =   "";
	String fileUploadImage         =   "";
	String first_accession_num         =   "";


	
	int		rowCnt				=	0, colIndex = 0;

	patient_id		=	(request.getParameter("patient_id")==null) ?	""	:	request.getParameter("patient_id");
	encounter_id		=	(request.getParameter("encounter_id")==null) ?	""	:	request.getParameter("encounter_id");
	event_status	=	((request.getParameter("status")==null)||(request.getParameter("status")=="")) ?	"0"	:	request.getParameter("status");
	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	
	from_date_time_en	=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time_en		=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");

	note_type = (request.getParameter("note_type")==null)?"":request.getParameter("note_type");
	note_group = (request.getParameter("note_group")==null)?"":request.getParameter("note_group");
	appl_task_id = (request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");

//for Sorting feature in the Header
	String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
	String colorForDate = "color:pink";
	String colorForEvent = "color:white";
	if(orderBy.equals("PB"))
	{
		if(reOrder.equals("1"))
		{
			colorForEvent = "color:pink";
		}
		else
		{
			colorForEvent = "color:yellow";
		}
		colorForDate = "color:white";
	}
	else
	{
		if(reOrder.equals("1"))
			colorForDate = "color:pink";
		else
			colorForDate = "color:yellow";
	}
//----- 
	try
	{
		con				=	ConnectionManager.getConnection(request);
		boolean restrict_rd	=false;	//IN071561
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
		login_user_id	=	(String)		session.getValue("login_user");
		resp_id			=	(String)		session.getValue("responsibility_id");
		clinician_id	=	(String)		session.getValue("ca_practitioner_id");

		//IN042552 Start.
		whereClause.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");
		//IN042552 End.
		if(restrict_rd)
		whereClause.append(" AND RD_PEER_NOTE_RESULT_HIDE_YN(a.facility_id,a.CONTR_MOD_ACCESSION_NUM,'"+login_user_id+"')='N'");
		
		if(!(from_date_time.equals("")))
			whereClause.append(" and a.event_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");

		if(!(to_date_time.equals("")))
			whereClause.append(" and a.event_date_time <= to_date( ?,'dd/mm/yyyy hh24:mi' ) ");

		if(!(event_status.equals("0")))
			whereClause.append(" and a.event_status = ? ");

		if(!note_type.equals(""))
		{
			whereClause.append(" and a.note_type=? " );
		}

		if (!note_group.equals(""))
		{
			whereClause.append(" and b.note_group_id=? " );
		}
		else
		{
			whereClause.append(" and b.NOTE_GROUP_ID IN (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  " );
		}
	

		query_notes_detail.append("select to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.accession_num, a.ext_image_appl_id, a.note_type from ca_encntr_note a, ca_note_type b, am_service c, am_practitioner d, am_practitioner e where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? )  is not null and b.note_type=a.note_type  and  c.service_code=a.service_code  and  d.practitioner_id = a.performed_by_id  and  e.practitioner_id(+) = a.authorized_by_id and a.patient_id = ? and a.event_status in ('1','2','3','4','5') ");
		query_notes_detail.append(whereClause.toString());
		 /*and a.encounter_id = ? */
		String desc="";
		
		if(reOrder.equals("2"))
		{
			desc=" desc";
		}
		if(!orderBy.equals(""))
		{
			if(orderBy.equals("DT"))
			{
				query_notes_detail.append(" order by event_date_time "+desc);
			}
			else if(orderBy.equals("PB"))
			{
				query_notes_detail.append(" order by d.practitioner_name "+desc);
			}
		}
		else
		{
			query_notes_detail.append(" order by event_date_time desc");
		}
		pstmt			=	con.prepareStatement(query_notes_detail.toString());


		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	clinician_id	);
		pstmt.setString( ++colIndex,	login_user_id	);

		pstmt.setString( ++colIndex,	patient_id		);
		//pstmt.setString( ++colIndex,	encounter_id		);

		if(!(from_date_time.equals(""))){
			pstmt.setString	(	++colIndex,	from_date_time_en	);
		}

		if(!(to_date_time.equals(""))){
			pstmt.setString	(	++colIndex,	to_date_time_en	);
		}

		if(!(event_status.equals("0")))
			pstmt.setString	(	++colIndex,	event_status	);

		/*if(!categoryId.equals(""))
		{
		      pstmt.setString	(	++colIndex,	categoryId	);
		}*/
		if(!note_type.equals(""))
		{
			pstmt.setString	(	++colIndex,	note_type	);
		}
		
		if (!note_group.equals(""))
		{
			pstmt.setString	(	++colIndex,	note_group	);
		}
		else
		{
			pstmt.setString	(	++colIndex,	appl_task_id	);
		}
	


		rs				=	pstmt.executeQuery();

	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(colorForDate));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);


		//if(startIndex>1)
			//rs.absolute((startIndex-1));
		classValue	= "gridData";
		while(rs.next())
		{
			rowCnt++;

			/*if( (rowCnt%2)==0 )
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";*/
		

			event_date_time		=	rs.getString("event_date_time1");
			event_date_time		=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);
			
			accession_num	=	rs.getString("accession_num");
			ext_image_appl_id	=	rs.getString("ext_image_appl_id") == null ? "" : rs.getString("ext_image_appl_id");
			if(note_type.equals(""))
				temp_note_type = rs.getString("note_type") == null ? "" : rs.getString("note_type");
			else
				temp_note_type = note_type;
	
			if(rowCnt == 1)
				first_accession_num = accession_num;

			if(!ext_image_appl_id.equals(""))
			{
				fileUploadImage ="<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accession_num+"\",\""+temp_note_type+"\")' height='20' title='FileUpload...' ></img>";
			}
			else
			{
				fileUploadImage = "";
			}
		
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(event_date_time));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fileUploadImage));
            _bw.write(_wl_block16Bytes, _wl_block16);


		}
		if(rowCnt == 0)
		{
			out.println("<script>parent.RecClinicalNotesPrevNotesSearchNotesDetailFrame.location.href='../../eCommon/html/blank.html';</script>");
			out.println("<script>alert(getMessage('NO_RECORD_FOUND','Common'));</script>");
		}
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(colorForDate));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(from_date_time));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block26Bytes, _wl_block26);

if(rowCnt > 0){

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(first_accession_num));
            _bw.write(_wl_block28Bytes, _wl_block28);

}

            _bw.write(_wl_block29Bytes, _wl_block29);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
