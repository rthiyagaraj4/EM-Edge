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

public final class __progressnotesopenprogression extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ProgressNotesOpenProgression.jsp", 1709116079356L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head> \n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n\t<script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCA/js/ProgressNotes.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script> \n</head>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t<script language=javascript>\n\t\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\t\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\t\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\t\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\t\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\t\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\t\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<FORM METHOD=POST ACTION=\"\" name=\"matconsscycle\" id=\"matconsscycle\"  >\n<!-- Below table width is modified by Archana Dhal on 4/28/2010 for IN020883. -->\n\t<TABLE width=\'100%\' align=\'left\' border=0 cellspacing=0>\n\t\t<BR><BR><BR>\n\t\t<TR>\n\t\t\t<td class=\'label\'  WIDTH=\'20%\' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" </td>\n\t\t\t<td class=\'field\' width=\'30%\'>\n\t\t\t\t<select name=\"speciality\" id=\"speciality\" onchange=\'\'>\n\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="----</option>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t</select></td>\n\t\t\t\t<td class=\'label\'  WIDTH=\'20%\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t<td class=\'field\' width=\'30%\'>\n\t\t\t\t\t<select name=\"ProgressNotes\" id=\"ProgressNotes\" onchange=\'\'>\n\t\t\t\t\t\t<option value=\'\'>----";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>&nbsp;&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;</option>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<input type=\"button\" class=\"BUTTON\" name=\"Record\" id=\"Record\" onclick=\'recordProgression()\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' ></td>\n\n\t<input type=hidden name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t<input type=hidden name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t<input type=hidden name=\'splty_event_code\' id=\'splty_event_code\' value=\'\'>\n\t<input type=hidden name=\'mode\' id=\'mode\' value=\'\'>\n\t<input type=hidden name=\'progression_no\' id=\'progression_no\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t<input type=hidden name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t<input type=hidden name=\'NewEvent\' id=\'NewEvent\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t</FORM>\n</BODY>\n</TABLE>\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
String encounter_id =  request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
String appl_task_id =  request.getParameter("appl_task_id") == null ? "" : request.getParameter("appl_task_id");
String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
//String p_event_title=request.getParameter("p_event_title") == null ? "" : request.getParameter("p_event_title");
String new_cycle=request.getParameter("new_cycle") == null ? "" : request.getParameter("new_cycle");
String NewEvent=request.getParameter("NewEvent") == null ? "" : request.getParameter("NewEvent");
//String dob=request.getParameter("Dob") == null ? "" : request.getParameter("Dob");
//String sex=request.getParameter("Sex") == null ? "" : request.getParameter("Sex");
String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");
String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
String note_group = request.getParameter("note_group") == null ? "" : request.getParameter("note_group");
Connection con = null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;
ResultSet rs = null;
ResultSet rs1 = null;

String enc_specialty_code = "";
String sel = "";
String resp_id = (String)session.getValue("responsibility_id");
int cycle_no=Integer.parseInt(request.getParameter("p_cycle_no"));
String cycle_status=request.getParameter("cycle_status");

if(cycle_status.equals("C") || (new_cycle.equals("N") && !NewEvent.equals("NewEvent")))
cycle_no=cycle_no+1;

/*
StringBuffer SQL1 = new StringBuffer("SELECT a.SPLTY_EVENT_CODE,a.SPLTY_EVENT_DESC FROM CA_SPLTY_EVENT_LANG_VW a WHERE a.MODULE_ID=? AND a.LANGUAGE_ID=? AND a.EFF_STATUS='E' and (a.AGE_GROUP_CODE is null or EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA  WHERE IA.AGE_GROUP_CODE=a.AGE_GROUP_CODE AND   TRUNC(SYSDATE)-to_date(?,'dd/mm/yyyy') BETWEEN         DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,?)=? )) ");
if(NewEvent.equals("NewEvent"))
	SQL1.append(" and SPLTY_EVENT_CODE in('MCE005','MCE006') and not exists (select 1 from CA_PAT_SPLTY_EPISODE_EVENT where patient_id=? and MODULE_ID=? and CYCLE_NO =? and SPLTY_EVENT_CODE = a.SPLTY_EVENT_CODE )");
SQL1.append(" ORDER BY 2");
*/
	
	String enc_spl_qry = " select f.SPECIALTY_CODE from pr_encounter F where f.ENCOUNTER_ID = ? ";
	
	String spl_qry     = " select SPECIALITY_CODE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) SHORT_DESC from  am_speciality where EFF_STATUS = 'E'  order by  SHORT_DESC ";

	StringBuffer prgNote_qry	= new StringBuffer("select NOTE_TYPE,CA_GET_DESC.CA_NOTE_TYPE(NOTE_TYPE,?,2) NOTE_TYPE_DESC from CA_NOTE_TYPE S where EFF_STATUS='E' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' and s.NOTE_GROUP_ID in (select D.NOTE_GROUP from CA_NOTE_GROUP D  where d.APPL_TASK_ID= ? )  and NOTE_TYPE in (select NOTE_TYPE from CA_NOTE_TYPE_FOR_RESP A where A.RESP_ID = ?) ");

	if(called_from.equals("OH_TREATMENT"))
	{
		prgNote_qry.append(" and NOTE_GROUP_ID = ?");
	}


	
	
	
	try
	{
		con = ConnectionManager.getConnection(request);
	}
	catch(Exception e)
	{

		e.printStackTrace() ;
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		
					
					try
					{
						pstmt = con.prepareStatement(enc_spl_qry);
						pstmt.setString(1,encounter_id);
						rs	= pstmt.executeQuery();
						while(rs.next())
						{
							enc_specialty_code=rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");

						}
						if(rs!=null)		rs.close();
						if(pstmt!=null) 	pstmt.close();

						pstmt1=con.prepareStatement(spl_qry);
						pstmt1.setString(1,locale);
						rs1	 =pstmt1.executeQuery();
						while(rs1.next())
						{
							if(rs1.getString(1).equals(enc_specialty_code))
							{
								sel ="selected";
							}
							else
							{
								sel ="";
							}
				

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rs1.getString(1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rs1.getString(2)));
            _bw.write(_wl_block15Bytes, _wl_block15);
						}
			
						if(rs1!=null) 		rs1.close();
						if(pstmt1!=null)	pstmt1.close();
		
					}	
					catch(Exception e)
					{
						e.printStackTrace() ;
				
					} 

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	
				try
				{
					pstmt1=con.prepareStatement(prgNote_qry.toString());  
					pstmt1.setString(1,locale);
					pstmt1.setString(2,patient_class);
					pstmt1.setString(3,appl_task_id);
					pstmt1.setString(4,resp_id);

					if(called_from.equals("OH_TREATMENT"))
					{
						pstmt1.setString(5,note_group);
					}

					rs1	 =pstmt1.executeQuery();
					while(rs1.next())
					{

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs1.getString(1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs1.getString(2)));
            _bw.write(_wl_block20Bytes, _wl_block20);
					}
	
					if(rs1!=null) 		rs1.close();
					if(pstmt1!=null)	pstmt1.close();
	
				}	
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
				finally
				{
					try
					{
						if(con!= null) ConnectionManager.returnConnection(con,request);
					}
					catch(Exception e)
					{
						out.println("Exception in CAMainMenu.jsp"+e.toString());
					}
				}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Go.label","common_labels")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(NewEvent));
            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ProgressNotes.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
