package jsp_servlet._eat._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __geneticmarkersdisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eat/jsp/GeneticMarkersDisplay.jsp", 1709114067694L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCA/js/ResearchPatient.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\tfunction ImmunizationDetails(){\n\t\tvar queryString = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";//document.refForm.queryString.value;\n\t\tvar dialogHeight= \"17\" ;\n\t\tvar dialogWidth\t= \"60\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=yes;  status:\" + status;\n\t\twindow.showModalDialog(\"../../eCA/jsp/Immunization.jsp?\"+queryString,arguments,features);\n\t\treturn false;\n\t}\n\n\tfunction researchPatient(){\n\t\tvar queryString = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";//document.refForm.queryString.value;\n\t\tvar dialogHeight= \"17\" ;\n\t\tvar dialogWidth\t= \"60\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=yes;  status:\" + status;\n\t\twindow.showModalDialog(\"../../eCA/jsp/ResearchPatient.jsp?\"+queryString,arguments,features);\n\t\treturn false;\n\t}\n\n\tfunction growthChart(chart_id,P_patient_id,sex){\n\t\tvar queryString = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";//document.refForm.queryString.value;\n\t\tvar dialogHeight= \"100\" ;\n\t\tvar dialogWidth\t= \"80\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=yes;  status:\" + status;\n\t\twindow.showModalDialog(\"../../eAT/jsp/ChartRecordingGroupGraphMain.jsp?splChartType=GR&chart_id=\"+chart_id+\"&patient_id=\"+P_patient_id+\"&Sex=\"+sex,arguments,features);\n\t\treturn false;\n\t}\n/*\tfunction TriageDetail(){\n\t\tvar queryString = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\tvar dialogHeight= \"26\" ;\n\t\tvar dialogWidth\t= \"60\" ;\n\t\tvar status = \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no;  status:\" + status;\n\t\twindow.showModalDialog(\"../../eCA/jsp/TriageDetail.jsp?\"+queryString,arguments,features);\n\t\treturn false;\n\t}*/\n\tfunction TriageDetail(patient_id,encounter_id,visit_adm_date_time)\n\t{\n\t     var retVal = \"\";\n\t\t\tvar function_id =\"query\";\n\t\t\tvar dialogHeight= \"32\" ;\n\t\t\tvar dialogWidth\t= \"50\" ;\n\t\t\tvar dialogTop =\"58\";\n\t\t\tvar status = \"no\";\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ;dialogTop:\" + dialogTop + \";scroll=no; status:\" + status;\n\t\t\tvar action_url\t\t=\t\"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id=\"+patient_id+\"&episode_id=\"+encounter_id+\"&visit_adm_date_time=\"+visit_adm_date_time+\"&function_id=\"+function_id;\n\t\t\tretVal = window.showModalDialog(action_url,arguments,features);\n\t}\n\t\n</script>\t\n</head>\n\n<body class=\'CONTENT\'  OnMouseDown=\"CodeArrest()\" onLoad=\"\">\n<form name=\'\' id=\'\' method=post target=\"messageFrame\">\n</form>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t<table  width=\'100%\' style=\"\" border=0 valign=\'top\' CELLSPACING=0 CELLPADDING=3 align=\'center\'>\n     <tr>\n        <td  width=\'40%\' style=\'CAENCOUNTERLINE\'><font size=\'-1\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<td  width=\'10%\' style=\'CAENCOUNTERLINE\'  style=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"><a href=\'#\' onClick=\'return ImmunizationDetails()\'><font size=\'2\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font></a></td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<td width=\'10%\' style=CAENCOUNTERLINE\' style=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"><a href=\'#\' onClick=\'return researchPatient()\'><font size=\'2\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font></a></td>\n\t\t<td  width=\'10%\' style=CAENCOUNTERLINE\' ALIGN=\'right\' style=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"><a href=\'#\' onClick=\"return growthChart(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\"><font size=\'2\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font>&nbsp;&nbsp;</font></a></td>\n\t\t\n\t\t<td  width=\'10%\' style=\'CAENCOUNTERLINE\'  style=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"><a href=\'#\' onClick=\"return TriageDetail(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font></a></td>\n\n\t\t<td  width = \'10%\' style=\'CAENCOUNTERLINE\' >\n\t\t<a href=\'javascript:refresh();\'><font size=\'2\'><U>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</U></font></a></td>\n      </tr>\n     </table>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);

	
	String P_patient_id = request.getParameter("patient_id");
	String sex = request.getParameter("Sex");
	String encounter_id = request.getParameter("encounter_id");
	if (encounter_id==null) encounter_id="";
	String visit_adm_date = request.getParameter("visit_adm_date");
	if (visit_adm_date==null) visit_adm_date="";
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	StringBuffer strBuff_display = new StringBuffer();
	strBuff_display.append("&nbsp;");
	//String display = "&nbsp;"; 
	String blood_grp ="";
	String rh_factor ="";

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");



	String research_pat_sql ="";
	String display_mode = "";
	String triage_display_mode = "display:none";
	int count = 0 ;

	String grChSql ="";
	String chart_id ="";
	String grChart_display_mode = "display:none";

	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null ;


	PreparedStatement res_pstmt=null;
	ResultSet res_rset=null ;
	if (patient_class.equals("EM") )
			triage_display_mode ="display:inline";
try
{
        con=ConnectionManager.getConnection(request);

		grChSql = "select CHART_ID from CA_SPL_CHART_PAT_REC_DTL where patient_id=? and rownum=1";
		res_pstmt=con.prepareStatement(grChSql);
		res_pstmt.setString(1,P_patient_id );

		res_rset=res_pstmt.executeQuery();

		while(res_rset.next())
		{
			chart_id = res_rset.getString("CHART_ID");
			grChart_display_mode = "display:inline";
		}
		if(res_rset != null)res_rset.close();
		if(res_pstmt != null)res_pstmt.close();	

		research_pat_sql = "SELECT COUNT(*) as total FROM CA_RESEARCH_PATIENT_DETAIL WHERE  PATIENT_ID=?";
		res_pstmt=con.prepareStatement(research_pat_sql);
		res_pstmt.setString(1,P_patient_id );

		res_rset=res_pstmt.executeQuery();

		while(res_rset.next())
		{
			count = res_rset.getInt("total");
		}
		if(res_rset != null)res_rset.close();
		if(res_pstmt != null)res_pstmt.close();
		
		if(count>0)
		  {
			display_mode="display:inline";
		  }
		  else
			{
			  display_mode="display:none";
		  }

		
		//String sql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A,     MR_RHESUS_FACTOR B, MR_BLOOD_GRP C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+)" ;

		String sql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A,     MR_RHESUS_FACTOR B, MR_BLOOD_GRP_LANG_VW C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+) AND C.LANGUAGE_ID = ?" ;

		

		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, P_patient_id );
		pstmt.setString(2, locale );

		rset=pstmt.executeQuery();

		while(rset.next())
		{
			blood_grp = rset.getString("blood_grp")	;
			rh_factor = rset.getString("rh_factor")	;
			
			
		}

		String space =  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" ;
		
		if(blood_grp != null )
		{	
			strBuff_display.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")+": <b>");
			strBuff_display.append(blood_grp);
			strBuff_display.append("</b>");
			
		}
		else
		{
			strBuff_display.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")+": ");
			strBuff_display.append(space);
			
		}

		if(rh_factor != null )
		{
			strBuff_display.append("&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RhFactor.label","common_labels")+": <b>");
			strBuff_display.append(rh_factor);
			strBuff_display.append("</b>");
			
		}
		else
		{
			strBuff_display.append("&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RhFactor.label","common_labels")+": ");
			strBuff_display.append(space);
			
		}
		//strBuff_display=null;
		String strsql2="";
		PreparedStatement pstmt1=null;
		ResultSet rs=null ;
		int count1=0;

			try
			{
				strsql2		=	" select  count(*) noofRecords from mr_med_event_log a, mr_med_event_type b where patient_id = ? and a.MED_EVENT_TYPE_CODE=b.MED_EVENT_TYPE_CODE  ";
				pstmt1		=	con.prepareStatement(strsql2);
				pstmt1.setString	(	1,	P_patient_id	);
				rs			=	pstmt1.executeQuery();

				while(rs.next())
				{
						count1=rs.getInt("noofRecords");
				}
			}
			catch(Exception e)
			{		
					out.println("Error in GeneticMarketDisplay"+e.toString());
			}
			finally
			{
					if(rs!=null) rs.close();
					if(pstmt1!=null) pstmt1.close();
			}
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strBuff_display.toString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
 	if (count1>0){
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(display_mode));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(display_mode));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(grChart_display_mode));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(chart_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(triage_display_mode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
 
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
		out.println(e.getMessage());
}
finally
{
		if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Immunization.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ResearchInfo.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.GrowthChart.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TriageDetail.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Refresh.label", java.lang.String .class,"key"));
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
}
