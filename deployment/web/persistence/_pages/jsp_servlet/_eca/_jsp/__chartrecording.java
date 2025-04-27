package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartrecording extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartRecording.jsp", 1741072241000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tfunction getMessageFrame()\n\t\t{\n\t\t\tif(\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" !=\"CP\")\n\t\t\t{\n\t\t\tif(top.content!=null){\n\t\t\t\treturn top.content.messageFrame;\n\t\t\t}else{\n\t\t\t\treturn parent.ChartRecordingIntermediateFrame;\n\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\t\n\t\t\t\treturn parent.ChartRecordingIntermediateFrame;\n\t\t\t}\n\t\t}\n\t\tvar messageFrameReference = getMessageFrame();\n\t\tfunction removeObjectsFromSession()\n\t\t{\n\t\t\t\n\t\t\t//IN047838 included AE condition\n\t\t\t\tif(\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" != \"CP\" && \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" != \"SECONDARY_TRIAGE\" && \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" != \"AE\")\n\t\t\ttop.content.messageFrame.location.href=\"../../eCA/jsp/ChartRecordingRemoveObjects.jsp?\"+\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\telse\n\t\t\t\t{\n\t\t\t\tvar dialogFrame = top.document.getElementById(\'dialog-body\') ? top.document.querySelectorAll(\'#dialog-body\')[ top.document.querySelectorAll(\'#dialog-body\').length - 1].contentWindow : parent ;\n\t\t\t\tdialogFrame.ChartRecordingIntermediateFrame.location.href=\"../../eCA/jsp/ChartRecordingRemoveObjects.jsp?\"+\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t}\n\t\t}\n</script>\n<head>\n<title>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</title>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></SCRIPT>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n</head>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<frameset rows=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' id =\'chartRecordingFrameSet\' frameborder=0 onUnload=\'removeObjectsFromSession()\' >\n\t\t<!-- IN054842 starts -->\n\t\t<!--<frame name=\"ChartRecordingCriteriaFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/ChartRecordingCriteria.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&Chart_Id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></frame>-->\n\t\t<frame name=\"ChartRecordingCriteriaFrame\" id=\"ChartRecordingCriteriaFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/ChartRecordingCriteria.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></frame>\n\t\t<!-- IN054842 ends -->\n\t\t<frameset cols=\'40%,60%\' frameborder=0 id=\'AEID\'>\n\t\t\t<frame name=\"ChartRecordingDetailFrame\" id=\"ChartRecordingDetailFrame\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n\t\t\t<frame name=\"ChartRecordingListFrame\" id=\"ChartRecordingListFrame\" frameborder=\"0\" scrolling=\"auto\"  src=\"../../eCommon/html/blank.html\"></frame>\t\t\n\t\t</frameset>\n\t\t<frameset cols=\'40%,60%\' frameborder=0 id=\'colBarID\'>\n\t\t\t<frame name=\"ChartRecordingToolBarFrame\" id=\"ChartRecordingToolBarFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n\t\t\t<frame name=\"ChartRecordingControlsFrame\" id=\"ChartRecordingControlsFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n\t\t</frameset>\n\t\t<frame name=\"ChartRecordingColorFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" style=\"layout:fixed\"></frame>\n\t\t\n\t\t<frame name=\"ChartRecordingIntermediateFrame\" id=\"ChartRecordingIntermediateFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n\t\t<frame name=\"ChartRecordingAddToGrpFrame\" id=\"ChartRecordingAddToGrpFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<frame name=\"messageFrame\" id=\"messageFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/jsp/error.jsp\"></frame>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\t</frameset>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<frameset rows=\'*,5%,7%,0%,10%\' id =\'chartRecordingFrameSet\' frameborder=0 onUnload=\'removeObjectsFromSession()\' >\n\t\t<frameset cols=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'AEID\'>\n\t\t\t<frame name=\"ChartRecordingDetailFrame\" id=\"ChartRecordingDetailFrame\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n\t\t\t<frame name=\"ChartRecordingListFrame\" id=\"ChartRecordingListFrame\" frameborder=\"0\" scrolling=\"auto\"  src=\"../../eCommon/html/blank.html\"></frame>\n\t\t</frameset>\t\t\n\t\t<frame name=\"ChartRecordingToolBarFrame\" id=\"ChartRecordingToolBarFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\"></frame>\n\t\t<frame name=\"ChartRecordingColorFrame\" id=\"ChartRecordingColorFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" style=\"layout:fixed\"></frame>\n\t\t<frame name=\"ChartRecordingIntermediateFrame\" id=\"ChartRecordingIntermediateFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/ChartRecordingIntermediate.jsp?qs=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&chartId=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&function_from=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&dateDefault=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&result=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&encounter_id=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"></frame>\n\t\t<frame name=\"messageFrame\" id=\"messageFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/jsp/error.jsp\"></frame>\n\t</frameset>\n";
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
28/03/2014	    IN047838		Chowminya											AAKH-CRF-0010.1/01 - Chart cannot be recorded	
11/05/2015		IN054842		Vijayakumar K		11/05/2015		Dinesh T		ML-BRU-SCF-1586 [IN:054842
12/06/2020		IN073152		Durga Natarajan		12/06/2020		Ramesh G  		SKR-SCF-1332         		        		             		          		        		                 
---------------------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

String function_from = request.getParameter("function_from") == null ? "" :  request.getParameter("function_from");

String chart_id = request.getParameter("Chart_Id") == null ? "" :  request.getParameter("Chart_Id");
String dateDefault = request.getParameter("p_start_date_time") == null ? "" :  request.getParameter("p_start_date_time");
if(!dateDefault.equals(""))
{	
	StringTokenizer dateToken = null;
	StringTokenizer secondsToken = null;

	dateToken = new StringTokenizer(dateDefault," ");
	String actualDate = dateToken.nextToken();
	String tempDate = dateToken.nextToken();
	secondsToken = new StringTokenizer(tempDate,":");
	String dateHrMin = actualDate + " " +secondsToken.nextToken() + ":" + secondsToken.nextToken();

	dateDefault = dateHrMin;
}


String encounter_id = request.getParameter("encounter_id") == null ? "0" : request.getParameter("encounter_id");
if(encounter_id.equals("")) encounter_id = "0";
String fac_id = (String) session.getAttribute("facility_id");
String patient_class= request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
String location_code  =  request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String qs = request.getQueryString();
String cols = "";
String title = "";

if(function_from.equals("SECONDARY_TRIAGE"))
{
	title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assessment.label","common_labels");
}
else
{
	title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels") ;
}

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(title));
            _bw.write(_wl_block12Bytes, _wl_block12);

	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement getLocnPstmt = null;
	ResultSet res = null;
	ResultSet resLocn = null;
	String result = "";

	String sql ="select 1  from CA_ENCNTR_DISCR_MSR a where  ENCOUNTER_ID=? and FACILITY_ID=? and CHART_ID =? and  TEST_OBSERV_DT_TM  = to_date(?,'dd/mm/yyyy hh24:mi')";

	String sqlChartId = "select a.CHART_ID from ca_chart a where a.eff_status='E' and  EXISTS (select 1 from ca_chart_section_comp where CHART_ID = A.chart_id) AND  A.CHART_ID IN (select CHART_ID from ca_chart_applicablity where  PATIENT_CLASS=? and  LOCN_CODE=? ";

	String ageGroupCriteria = " and EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA, MP_PATIENT IB   WHERE IA.AGE_GROUP_CODE=CA_CHART_APPLICABLITY.AGE_GROUP_CODE AND  IB.PATIENT_ID=? AND TRUNC(SYSDATE)-IB.DATE_OF_BIRTH BETWEEN               DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,IB.SEX)=IB.SEX) ";
	
	//IN054842 starts
	String visit_adm_date_time_sql = "SELECT TO_CHAR(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM PR_ENCOUNTER WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ?";
	//String visit_adm_date_time = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");//IN073152 commented
	String visit_adm_date_time ="";//IN073152
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	//IN054842 ends
	if(function_from.equals("SECONDARY_TRIAGE"))
	{
		try
		{
			con = ConnectionManager.getConnection(request);

			ps = con.prepareStatement(sqlChartId+ageGroupCriteria+" )  AND ROWNUM=1 ");
			
			if (location_code.equals(""))
			{
				String getLocnSql ="Select ASSIGN_CARE_LOCN_CODE from pr_encounter where facility_id=? and encounter_id=? ";
				getLocnPstmt = con.prepareStatement(getLocnSql);
				getLocnPstmt.setString(1,fac_id);
				getLocnPstmt.setString(2,encounter_id);
				resLocn = getLocnPstmt.executeQuery();
				while(resLocn.next())
				{
					location_code = resLocn.getString("ASSIGN_CARE_LOCN_CODE");
				}
				
				if(resLocn != null) resLocn.close();
				if(getLocnPstmt != null) getLocnPstmt.close();
			}
			ps.setString(1,patient_class);
			ps.setString(2,location_code);
			ps.setString(3,patient_id);

			res = ps.executeQuery();
			
			if(res.next())
			{
				chart_id = res.getString(1);
			}
			else 
			{
				if(res != null) res.close();
				if(ps != null) ps.close();
				ps = con.prepareStatement(sqlChartId+" and AGE_GROUP_CODE='*ALL')  AND ROWNUM=1 ");
				ps.setString(1,patient_class);
				ps.setString(2,location_code);


				res = ps.executeQuery();
				if(res.next())
				{
					//out.println("<script>alert('222"+chart_id+"');</script>");
					chart_id = res.getString(1);
				}
				else
				{
					out.println("<script>alert(getMessage('NO_CHART_FOR_CLINIC','CA'));window.close();</script>");
				}
			}
			if(res != null) res.close();
			if(ps != null) ps.close();

			ps = con.prepareStatement(sql);
			ps.setString(1,encounter_id);
			ps.setString(2,fac_id);
			ps.setString(3,chart_id);
			ps.setString(4,dateDefault);
			

			res = ps.executeQuery();
			if(res.next())
			{
				result = res.getString(1);
				
			}
			
			if(res != null) res.close();
			if(ps != null) ps.close();
			
		}
		catch(Exception e)
		{
			out.println("Exception in ChartRecording.jsp "+e.toString());
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con, request);
		}
	}
	//IN054842 starts
	String queryString = request.getQueryString();
	
	if("".equals(visit_adm_date_time))
	{
		try
		{
			con = ConnectionManager.getConnection(request);
			ps = con.prepareStatement(visit_adm_date_time_sql);
			ps.setString(1,fac_id);
			ps.setString(2,encounter_id);
			res = ps.executeQuery();
			if(res.next())
			{
				visit_adm_date_time = res.getString(1);
				
			}
			if(res != null) res.close();
			if(ps != null) ps.close();
			
			queryString +=  "&visit_adm_date1="+com.ehis.util.DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);//IN073152
		}		
		catch(Exception evstdt)
		{
			//out.println("Exception in ChartRecording.jsp "+evstdt.toString());//common-icn-0181
		        evstdt.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con, request);
		}
	}
	
	//IN054842 ends

            _bw.write(_wl_block1Bytes, _wl_block1);

	if(!function_from.equals("SECONDARY_TRIAGE"))
	{		
			String tempRows = "12%,*%,7%,4%,0%,0%";
			//IN047838 included AE condition
			if(function_from.equals("CP") || function_from.equals("AE"))			
				tempRows = "33%,*%,7%,4%,0%,0%,0%,5%";


            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tempRows));
            _bw.write(_wl_block14Bytes, _wl_block14);
 //=request.getQueryString()
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(chart_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(chart_id));
            _bw.write(_wl_block17Bytes, _wl_block17);

		//IN047838 included AE condition
		if(function_from.equals("CP") || function_from.equals("AE"))
		{

            _bw.write(_wl_block18Bytes, _wl_block18);

		}

            _bw.write(_wl_block19Bytes, _wl_block19);

	}
	else if(function_from.equals("SECONDARY_TRIAGE"))
	{
		
		if(result.equals(""))
		{
			cols = "100%,0%";
		}
		else
		{
			cols = "50%,50%";
		}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cols));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(qs)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chart_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dateDefault));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(result));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block27Bytes, _wl_block27);

	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
