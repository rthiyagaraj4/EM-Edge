package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __relatedpatientnoteresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RelatedPatientNoteResult.jsp", 1709116245090L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML><head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n</head>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RelatedPatientHist.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table cellpadding=\'3\' align=\'center\' width=\'100%\'>\n<tr >\n<td width=\'100%\' class=\'white\' ></td>\n<td nowrap width=\'10%\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n<table  width=\"100%\" class=\'grid\'>\n<td class=\'columnheader\' width=\'25%\'  nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n<td class=\'columnheader\' width=\'20%\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\n<td class=\'columnheader\' width=\'5%\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n<td class=\'columnheader\' width=\'5%\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n<td class=\'columnheader\' width=\'5%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td></tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n</BODY>\n</HTML>\n\n\n";
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
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


out.println("<BODY  class='CONTENT' onLoad=\"parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num= ';\" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>");
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	StringBuffer sql = new StringBuffer();
	//String sqlbuild="";
	//String orderby="";  
	//String faci = (rs.getString("Facility")==null)?"":rs.getString("Facility");
	//String	facilityId 	= (String) session.getValue( "facility_id" )==null ? "" : (String) session.getValue( "facility_id" ) ;
	//String	patientId 	= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	//String  practitioner_id=(String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");	
	String from 					= request.getParameter("from") ;
	
	String to 						= request.getParameter("to") ;
	//String view			= (request.getParameter("view")==null)?"":request.getParameter("view");
    //String spl			= (request.getParameter("spl")==null)?"":request.getParameter("spl");
	//String rest			= (request.getParameter("rest")==null)?"":request.getParameter("rest");
	String from_date	= (request.getParameter("from_date")==null)?"":request.getParameter("from_date");
	String to_date		= (request.getParameter("to_date")==null)?"":request.getParameter("to_date");	
	from_date			=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
	to_date				=	com.ehis.util.DateUtils.convertDate(to_date,"DMY",locale,"en");
	String search_word		= request.getParameter("docName")==null?"":request.getParameter("docName");
	//out.println("search_word :"+search_word);	
	
	//String note_type		= request.getParameter("note_type")==null?"":request.getParameter("note_type");
	//out.println("note_type :"+note_type);		

	//String b_year		= request.getParameter("b_year");
	//String b_months     = request.getParameter("b_months");
	//String b_days		= request.getParameter("b_days");
	//String b_year2		= request.getParameter("b_year2");
	//String b_months2    = request.getParameter("b_months2");
	//String b_days2      = request.getParameter("b_days2");
 	//String sex		    = request.getParameter("sex");
 	//String status		= request.getParameter("status");
 	//String group		= request.getParameter("group");
 	//String term_set_id		= request.getParameter("term_set_id");

	//String fr_age="",to_age="";
	//String whereClause				= request.getParameter("whereclause");
			 
/*	if ( (whereClause == null || whereClause.equals("")) )
	{
		if(view.equals("S"))
			sqlbuild=sqlbuild+" and exists(select 1 from ca_encntr_pract_reln where FACILITY_ID=a.onset_facility_id and ENCOUNTER_ID=a.onset_encounter_id and PRACTITIONER_ID='"+practitioner_id+"')";

	    if( !(spl == null || spl.equals("")) )
			sqlbuild=sqlbuild+" and c.SPECIALTY_CODE='"+spl+"' ";
	
		if(rest.equals("F") || rest.equals("E"))
			sqlbuild=sqlbuild+" and c.facility_id='"+facilityId+"' ";

		if( !(from_date == null || from_date.equals("")) )
			sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME>=to_date('"+from_date+"' ,'dd/mm/yyyy')";
	
		if( !(to_date == null || to_date.equals("")) )
			sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME<=to_date('"+to_date+"' ,'dd/mm/yyyy')+.99 ";

		if(!(sex == null || sex.equals("")))
			sqlbuild=sqlbuild+" and b.sex='"+sex+"'";

		if(status.equals("D"))
			sqlbuild=sqlbuild+" and EXISTS (select  1 from AM_DISPOSITION_TYPE where DECEASED_YN='Y' AND  disp_type=C.DISPOSITION_TYPE) ";
		else if(status.equals("D"))
			sqlbuild=sqlbuild+" and (C.DISPOSITION_TYPE is null or EXISTS (select  1 from AM_DISPOSITION_TYPE where DECEASED_YN='N' AND  disp_type= nvl(C.DISPOSITION_TYPE,'xxx'))) ";
    
		if ((!b_year.equals("")) ||(!b_months.equals(""))||(!b_days.equals("")))
		{  
			if (b_year.equals(""))
			  b_year="0";
			if (b_months.equals(""))
			  b_months="0";
			if	(b_days.equals(""))
			  b_days="0";
			fr_age="("+b_year+"*365+"+b_months+"*30+"+b_days+")";
			 sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME-b.date_of_birth>"+fr_age+" ";
		}
	
		if ((!b_year2.equals("")) ||(!b_months2.equals(""))||(!b_days2.equals("")))
		{  
			if (b_year2.equals(""))
			  b_year2="0";
			else
			   b_year2="("+b_year2+"+1)";
			if (b_months2.equals(""))
			  b_months2="0";
			else
			   b_months2="("+b_months2+"+1)";
			if	(b_days2.equals(""))
			  b_days2="0";
			else
			   b_days2="("+b_days2+"+1)";
			to_age="("+b_year2+"*365+"+b_months2+"*30+"+b_days2+")";
			 sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME-b.date_of_birth<="+to_age+" ";
		}
	}
	else
		sqlbuild=whereClause;   */


	
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try
		{
			StringBuffer sqlQuery =  new StringBuffer("SELECT  count(*) total_records FROM ca_encntr_note a , ca_note_type_lang_vw b  , mp_patient c WHERE     b.LANGUAGE_ID  =? AND b.note_type=a.note_type   AND c.patient_id=a.patient_id   ");  
			if(!search_word.equals(""))
			{
			 sqlQuery.append(" and contains(NOTE_CONTENT,?)>0");	
			}
			con =  ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlQuery.toString());
			pstmt.setString(1,locale);
			if(!search_word.equals(""))
			{
			pstmt.setString(2,search_word);
			}
			
		    rs = pstmt.executeQuery();		
			if(rs.next())
			{
				maxRecord = rs.getInt("total_records");
			}
			
			if (rs != null)
				rs.close();

			if (pstmt != null)
				pstmt.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		

            _bw.write(_wl_block8Bytes, _wl_block8);

if ( !(start <= 1) )
	out.println("<A HREF='../../eCA/jsp/RelatedPatientNoteResult.jsp?from="+(start-14)+"&to="+(end-14)+"&docName="+search_word+"'"+" text-decoration='none'    class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if ( !( (start+14) >= maxRecord ) )
	{
		out.println("<A HREF='../../eCA/jsp/RelatedPatientNoteResult.jsp?from="+(start+14)+"&to="+(end+14)+"&docName="+search_word+"'"+" text-decoration='none' class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
	

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	try
	{
      
		sql.append("SELECT  b.NOTE_TYPE_DESC 	,TO_CHAR(EVENT_DATE_TIME,'dd/mm/yyyy hh24:mi') event_date_time_str ,a.patient_id,REPLACE(DECODE('',?,c.PATIENT_NAME,NVL(c.PATIENT_NAME_LOC_LANG,c.PATIENT_NAME)),'''','') 	patient_name,get_age (c.date_of_birth,NVL (c.deceased_date, SYSDATE) ) age	,c.sex sex	,a.note_type        ,a.FACILITY_ID 	,a.ACCESSION_NUM FROM ca_encntr_note a , ca_note_type_lang_vw b  , mp_patient c WHERE     b.LANGUAGE_ID  =? AND b.note_type=a.note_type   AND c.patient_id=a.patient_id ");
		
		if(!search_word.equals(""))
		{
		  sql.append(" and contains(NOTE_CONTENT,?)>0");	
		}
   
	 /*if (!note_type.equals(""))
		sql.append(" and a.note_type=? "); 

		 sql.append(" CONTAINS (a.note_content,?) >0") ;

		 if (!patientId.equals(""))
		  sql.append(" and a.patient_id != ? ");
		 //out.println("patientId :"+patientId);
		 // sql.append(sqlbuild);	
			 pstmt = con.prepareStatement(sql.toString());
			  pstmt.setString(1,locale);
			  pstmt.setString(2,locale);
			   if (!note_type.equals("")){
					pstmt.setString(3,note_type);
					pstmt.setString(4,search_word);
			   }else{
					pstmt.setString(3,search_word);
			   }

			   if (!note_type.equals("") && !patientId.equals(""))
					pstmt.setString(5,patientId);
			   else if (!patientId.equals(""))
					pstmt.setString(4,patientId);*/

		 //out.println("sql  :   "+sql);
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		if(!search_word.equals(""))
		{
		pstmt.setString(3,search_word);
		}
	    rs = pstmt.executeQuery();		
	

	 
		
            _bw.write(_wl_block15Bytes, _wl_block15);
	
		 if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  rs.next() ;

	   while(rs!=null && rs.next() && i<=end)
		{
		  String note_type_desc = (rs.getString("NOTE_TYPE_DESC")==null)?"":rs.getString("NOTE_TYPE_DESC");
		  String date_time = (rs.getString("EVENT_DATE_TIME_STR")==null)?"":rs.getString("EVENT_DATE_TIME_STR");  	  
		  String pat_id = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
		  String pat_name = (rs.getString("PATIENT_NAME")==null)?"":rs.getString("PATIENT_NAME");		
		 String age = (rs.getString("AGE")==null)?"":rs.getString("AGE");		 
		 String PAT_sex = (rs.getString("SEX")==null)?"":rs.getString("SEX");
		 String ACCE_NUM = (rs.getString("ACCESSION_NUM")==null)?"":rs.getString("ACCESSION_NUM");
		 
		// out.println(ACCE_NUM);
		 out.println("<tr ><td  class='gridData' align=left ><font  size=2>"+note_type_desc+"</font></td>");		
		out.println("<td   class='gridData'><font  size=2>"+date_time+"</td></font>");
		out.println("<td   nowrap class='gridData'><font  size=2>"+pat_id+"</td></font>");
		out.println("<td   class='gridData'><font  size=2>"+pat_name+"</td></font>");
		out.println("<td nowrap  class='gridData'><font  size=2>"+age+"</td></font>");
		out.println("<td nowrap  class='gridData'><font  size=2>"+PAT_sex+"</td></font>");
		out.println("<td><img id='textimg' src='../../eCA/images/flow_text.gif' onClick=\"javascript:populateDocument('"+ACCE_NUM+"')\"></td></tr>");
	  
		  //maxRecord = rs.getInt("total");}*/
		  i++;
        } 
		
 
	}catch(Exception e)
     {
        e.printStackTrace();
		e.toString();
		//out.println(e.toString());//common-icn-0181
     }
	finally   
	{
		 if(pstmt!=null)pstmt.close();
		 if(rs!=null)rs.close();
		 if(con!=null)
			 ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NoteDescription.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.EventDateTime.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
