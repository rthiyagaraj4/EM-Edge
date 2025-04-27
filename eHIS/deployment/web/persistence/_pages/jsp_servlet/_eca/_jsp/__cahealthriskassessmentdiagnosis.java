package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.io.*;
import java.net.*;
import eCA.*;
import java.text.*;
import org.jfree.ui.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.*;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.urls.*;
import org.jfree.data.*;
import org.jfree.data.time.*;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.*;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import javax.swing.JPanel;
import eCA.ChartComponentFormulaBean;
import java.text.SimpleDateFormat;
import org.jfree.data.category.DefaultCategoryDataset.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.block.*;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.*;
import org.jfree.chart.renderer.category.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.sql.*;
import java.net.*;
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
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __cahealthriskassessmentdiagnosis extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAHealthRiskAssessmentDiagnosis.jsp", 1709115532497L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\"JavaScript\" src=\"../../eCA/js/CAHealthRiskAssessment.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n<form name=\'CAHealthRiskAssessmentDiagnosisForm\' id=\'CAHealthRiskAssessmentDiagnosisForm\'>  \n\t<table class=\'grid\' cellpadding=\'1\' cellspacing=\'1\' border=\'0\' width=\'100%\' height=\'100%\' >\n\t\t\t\t\n\t\t<tr style=\"height:20px;\">\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<th class=\'columnHeadercenter\' nowrap width=\'55%\'>Diagnosis</th>\n\t\t\t\t<th class=\'columnHeadercenter\'  nowidth=\'20%\'>Risk Score</th>\n\t\t\t\t<!--<th class=\'columnHeadercenter\' nowrap width=\'21%\'>&nbsp;</th>-->\n\t\t\t\t<th class=\'columnHeadercenter\'  nowrap width=\'25%\'>View</th>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\n\t\t\t\t<th class=\'columnHeadercentericons";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' nowrap width=\'55%\'>Diagnosis</th>\n\t\t\t\t<th class=\'columnHeadercentericons";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'  nowidth=\'20%\'>Risk Score</th>\n\t\t\t\t<th class=\'columnHeadercentericons";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'  nowrap width=\'25%\'>View</th>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</tr>\t\n\t\t<tr>\n\t\t\t<td colspan=\"4\" valign=\"top\">\n\t\t\t\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t<tr style=\"height:30px;\">\n\t\t\t\t\t\t\t\t\t\t<td class=gridData width=\'60%\'>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=gridData width=\'20%\'>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="%\n\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<td class=gridData width=\'25%\'  align=\"center\" >\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"diagnosisChk\" id=\"diagnosisChk\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" onclick = \'getCatelogRiskFactorDetails();\'/>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t<input type=\"hidden\" name=\"reqString\" id=\"reqString\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>\n\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"/>\n\t</table>\n</form>\n\n<script>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\tparent.CAHealthRiskAssessmentOrderCatalogFrm.location.href=\"../../eCA/jsp/CAHealthRiskAssessmentOrderCatalogs.jsp?";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&TermSetCode=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\tparent.CAHealthRiskAssessmentGraphFrm.location.href=\"../../eCA/jsp/CAHealthRiskAssessmentGraph.jsp?bean_id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t//27788 Start.\n\t//parent.CAHealthRiskAssessmentHealthRiskFactorsFrm.location.href=\"../../eCA/jsp/CAHealthRiskAssessmentHealthRiskFactors.jsp?";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\tparent.CAHealthRiskAssessmentHealthRiskFactorsFrm.location.href=\"../../eCA/jsp/CAHealthRiskAssessmentHealthRiskFactors.jsp?";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&compressed=Y&TermSetCode=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t//27788 End.\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
	
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
/*  
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       			Edit History    	Name        	Description
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
15/03/2013			IN030469			Ramesh G		Continuous and opportunistic screening for diseases will be performed if the patient fits the criteria. 
														The general practitioner will be alerted if such patients attend the clinic.   								 
-------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------
28/06/2018	IN065341		Prakash C	29/06/2018		Ramesh G 		MMS-DM-CRF-0115
07/03/2022	27788			Ramesh Goli		07/03/2022		RAMESH G    	MMS-ME-SCF-0067
---------------------------------------------------------------------------------------------------------
*/
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String prefStyleSheet = request.getParameter("prefStyle");
String content_ID = request.getParameter("content_ID");
String reqString = request.getQueryString();
//IN065341 starts
	
	String patid="";
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	String encId="";
	if(called_from.equals("CDR")){
		encId = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		patid=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	}else{//IN065341 ends
		patid=request.getParameter("Patient_ID");
	   	encId = request.getParameter("encounter_id");
	}//IN065341
String defaultDiag = "";
String bean_id ="AssessmentBean"+patid+encId;

DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 

//27788 Start.
StringBuffer paramStringBuffer= new StringBuffer();
paramStringBuffer.append("prefStyle="+prefStyleSheet+"&content_ID="+content_ID);
if(request.getParameter("patient_id")!=null)
	paramStringBuffer.append("&patient_id="+new String(Base64.encodeBase64(((String)request.getParameter("patient_id")).getBytes())));
if(request.getParameter("Patient_ID")!=null)
	paramStringBuffer.append("&Patient_ID="+new String(Base64.encodeBase64(((String)request.getParameter("Patient_ID")).getBytes())));
if(request.getParameter("enc_id1")!=null)
	paramStringBuffer.append("&enc_id1="+new String(Base64.encodeBase64(((String)request.getParameter("enc_id1")).getBytes())));
if(request.getParameter("encounter_id")!=null)
	paramStringBuffer.append("&encounter_id="+new String(Base64.encodeBase64(((String)request.getParameter("encounter_id")).getBytes())));

paramStringBuffer.append("&called_from="+called_from+"&RepDb="+RepDb);
//27788 End.

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
if(sStyle.equals(prefStyleSheet) )
			{
            _bw.write(_wl_block8Bytes, _wl_block8);
}else{ 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

						String termSetCode 	= "";
						String termDesc 	= "";
						PreparedStatement pstmt = null;
						ResultSet rs = null;
						//String qry = "SELECT TERM_SET_ID, TERM_SET_CODE, TERM_DESC || '(' ||TERM_SET_CODE || ')'  TERM_DESC ,         round(((  SUM (risk_factor_score) / (select sum(risk_factor_score) from CA_RISK_FACTOR_DTL where RISK_FACTOR_TYPE in ((SELECT risk_factor FROM ca_diag_risk_factor WHERE risk_grp_type = 'I' and term_set_id =A.term_set_id and  term_set_code = A.term_set_code  UNION SELECT b.risk_factor_type risk_factor FROM ca_diag_risk_factor a,ca_group_risk_factor_dtl b WHERE risk_grp_type = 'G' AND a.risk_factor = risk_factor_group and term_set_id =A.term_set_id and  term_set_code = A.term_set_code ))) ) * 100 ),0) risk_score_perc    FROM (SELECT   A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC TERM_DESC,SUM (RISK_FACTOR_SCORE) RISK_FACTOR_SCORE, 'A' GRAND_TOTAL FROM CA_HEALTH_RISK_ASSMNT_VW A, MR_TERM_CODE B WHERE PATIENT_ID = ? AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_SET_CODE = B.TERM_CODE AND 'Y' = CA_RISK_FACTOR_GRP_APPL(A.PATIENT_ID,A.ENCOUNTER_ID,A.FACILITY_ID,A.TERM_SET_ID,A.TERM_SET_CODE,A.RISK_GRP_TYPE,A.RISK_FACTOR,A.RISK_FACT_GRP,A.FACTOR_MAND_YN) and rownum <=10 GROUP BY A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC) A GROUP BY TERM_SET_ID, TERM_SET_CODE, TERM_DESC, GRAND_TOTAL,RISK_FACTOR_SCORE ORDER BY 4 DESC ";
						//String qry = "SELECT TERM_SET_ID, TERM_SET_CODE, TERM_DESC || '(' ||TERM_SET_CODE || ')'  TERM_DESC ,         round(((  SUM (risk_factor_score) / (select sum(risk_factor_score) from CA_RISK_FACTOR_DTL ##REPDB## where RISK_FACTOR_TYPE in ((SELECT risk_factor FROM ca_diag_risk_factor ##REPDB## WHERE risk_grp_type = 'I' and term_set_id =A.term_set_id and  term_set_code = A.term_set_code  UNION SELECT b.risk_factor_type risk_factor FROM ca_diag_risk_factor ##REPDB## a,ca_group_risk_factor_dtl ##REPDB## b WHERE risk_grp_type = 'G' AND a.risk_factor = risk_factor_group and term_set_id =A.term_set_id and  term_set_code = A.term_set_code ))) ) * 100 ),0) risk_score_perc    FROM (SELECT   A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC TERM_DESC,SUM (RISK_FACTOR_SCORE) RISK_FACTOR_SCORE, 'A' GRAND_TOTAL FROM CA_HEALTH_RISK_ASSMNT_VW##CLOB## A, MR_TERM_CODE ##REPDB## B WHERE PATIENT_ID = ? AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_SET_CODE = B.TERM_CODE AND 'Y' = CA_RISK_FACTOR_GRP_APPL##REPDB## (A.PATIENT_ID,A.ENCOUNTER_ID,A.FACILITY_ID,A.TERM_SET_ID,A.TERM_SET_CODE,A.RISK_GRP_TYPE,A.RISK_FACTOR,A.RISK_FACT_GRP,A.FACTOR_MAND_YN) and rownum <=10 GROUP BY A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC) A GROUP BY TERM_SET_ID, TERM_SET_CODE, TERM_DESC, GRAND_TOTAL,RISK_FACTOR_SCORE ORDER BY 4 DESC ";//IN065341
												
						String qry ="";
						/*if(called_from.equals("CDR")){
							//qry = "SELECT A.TERM_SET_ID, A.TERM_SET_CODE, A.TERM_DESC, A.risk_score_perc  FROM ca_health_risk_assmnt_score_vw  ##REPDB## A WHERE A.PATIENT_ID = ?  ";
							qry ="SELECT   c.term_set_id, c.term_set_code,c.term_desc || '(' || c.term_set_code || ')' term_desc, ROUND((  (  SUM (c.risk_factor_score)/ (SELECT SUM (e.risk_factor_score) FROM ca_risk_factor_dtl##REPDB## e WHERE e.risk_factor_type IN ((SELECT g.risk_factor FROM ca_diag_risk_factor##REPDB## g WHERE g.risk_grp_type = 'I' AND g.term_set_id = c.term_set_id AND g.term_set_code = c.term_set_code UNION SELECT b.risk_factor_type risk_factor FROM ca_diag_risk_factor##REPDB## a,ca_group_risk_factor_dtl##REPDB## b WHERE a.risk_grp_type = 'G' AND a.risk_factor =b.risk_factor_group )))) * 100),0) risk_score_perc FROM (SELECT   a.term_set_id, a.term_set_code, b.short_desc term_desc,SUM (a.risk_factor_score) risk_factor_score,'A' grand_total FROM ca_health_risk_assmnt_vw##REPDB## a, mr_term_code##REPDB## b WHERE a.patient_id = ? AND a.term_set_id = b.term_set_id AND a.term_set_code = b.term_code AND 'Y' =ca_risk_factor_grp_appl##REPDB## (a.patient_id,a.encounter_id,a.facility_id,a.term_set_id,a.term_set_code,a.risk_grp_type,a.risk_factor,a.risk_fact_grp,a.factor_mand_yn)AND ROWNUM <= 10 GROUP BY a.term_set_id, a.term_set_code, b.short_desc) c GROUP BY c.term_set_id,c.term_set_code,c.term_desc,c.grand_total,c.risk_factor_score ORDER BY 4 DESC";
						}else{
							qry = "SELECT TERM_SET_ID, TERM_SET_CODE, TERM_DESC || '(' ||TERM_SET_CODE || ')'  TERM_DESC ,         round(((  SUM (risk_factor_score) / (select sum(risk_factor_score) from CA_RISK_FACTOR_DTL ##REPDB## where RISK_FACTOR_TYPE in ((SELECT risk_factor FROM ca_diag_risk_factor ##REPDB## g WHERE g.risk_grp_type = 'I' and g.term_set_id =A.term_set_id and  g.term_set_code = A.term_set_code  UNION SELECT b.risk_factor_type risk_factor FROM ca_diag_risk_factor ##REPDB## a,ca_group_risk_factor_dtl ##REPDB## b WHERE risk_grp_type = 'G' AND a.risk_factor = risk_factor_group and term_set_id =A.term_set_id and  term_set_code = A.term_set_code ))) ) * 100 ),0) risk_score_perc    FROM (SELECT   A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC TERM_DESC,SUM (RISK_FACTOR_SCORE) RISK_FACTOR_SCORE, 'A' GRAND_TOTAL FROM CA_HEALTH_RISK_ASSMNT_VW##CLOB## A, MR_TERM_CODE ##REPDB## B WHERE PATIENT_ID = ? AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_SET_CODE = B.TERM_CODE AND 'Y' = CA_RISK_FACTOR_GRP_APPL##REPDB## (A.PATIENT_ID,A.ENCOUNTER_ID,A.FACILITY_ID,A.TERM_SET_ID,A.TERM_SET_CODE,A.RISK_GRP_TYPE,A.RISK_FACTOR,A.RISK_FACT_GRP,A.FACTOR_MAND_YN) and rownum <=10 GROUP BY A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC) A GROUP BY TERM_SET_ID, TERM_SET_CODE, TERM_DESC, GRAND_TOTAL,RISK_FACTOR_SCORE ORDER BY 4 DESC ";
						}*/
						qry="SELECT   c.term_set_id, c.term_set_code, c.term_desc || '(' || c.term_set_code || ')' term_desc, ROUND ((( SUM (c.risk_factor_score) / (  NVL((SELECT SUM (e.risk_factor_score) FROM ca_risk_factor_dtl##REPDB## e  WHERE e.risk_factor_type IN ( (SELECT g.risk_factor FROM ca_diag_risk_factor##REPDB## g WHERE g.risk_grp_type = 'I' AND g.term_set_id = c.term_set_id  AND g.term_set_code = c.term_set_code))),0)  + NVL((SELECT SUM (z.risk_factor_score) FROM ca_risk_factor_dtl##REPDB## z WHERE z.risk_factor_type IN ( (SELECT b.risk_factor_type risk_factor FROM ca_diag_risk_factor##REPDB## y, ca_group_risk_factor_dtl##REPDB## b WHERE y.risk_grp_type = 'G' AND y.risk_factor = b.risk_factor_group))),0))) * 100), 0) risk_score_perc FROM (SELECT   a.term_set_id, a.term_set_code, b.short_desc term_desc,SUM (a.risk_factor_score) risk_factor_score,'A' grand_total  FROM ca_health_risk_assmnt_vw##REPDB## a, mr_term_code##REPDB## b WHERE a.patient_id = ? AND a.term_set_id = b.term_set_id AND a.term_set_code = b.term_code AND 'Y' = ca_risk_factor_grp_appl##REPDB## (a.patient_id, a.encounter_id,a.facility_id,a.term_set_id,a.term_set_code,a.risk_grp_type,a.risk_factor,a.risk_fact_grp,a.factor_mand_yn ) AND ROWNUM <= 10 GROUP BY a.term_set_id, a.term_set_code, b.short_desc) c GROUP BY c.term_set_id,c.term_set_code,c.term_desc,c.grand_total,c.risk_factor_score ORDER BY 4 DESC";
						Connection con = null;
						try{
							con = ConnectionManager.getConnection(request);	

							
							qry=qry.replaceAll("##REPDB##",RepDb);//IN065341
							qry=qry.replaceAll("##CLOB##",clob_data);//IN065341 ends
							pstmt = con.prepareStatement(qry);
							pstmt.setString(1,patid);
							rs = pstmt.executeQuery();
					
							int cnt = 0;
							String checked  = "";

							while(rs!=null && rs.next()){
								termDesc = rs.getString("TERM_DESC");
								termSetCode = rs.getString("TERM_SET_CODE");
								String riskScorePerc = rs.getString("RISK_SCORE_PERC");
								checked = "";
								cnt++;
								
								if(cnt <= 1)
								{
									checked = "checked";
									defaultDiag = termSetCode;
									//onLoadRiskFactorDesc = termDesc;
								}

								dataset.addValue(Integer.parseInt(riskScorePerc), "Diagnosis", termSetCode);
								
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(termDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(riskScorePerc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(termSetCode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block18Bytes, _wl_block18);
											
							}
						}catch(Exception e){
							e.printStackTrace();
						}finally{
							if(pstmt!=null)pstmt.close();			
							if(rs!=null)rs.close();
							if(con!=null)con.close();
						}
						session.setAttribute(bean_id, dataset);
					
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(reqString));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(!called_from.equals("CDR")){
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(reqString));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(defaultDiag));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(reqString));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(defaultDiag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(paramStringBuffer.toString()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(defaultDiag));
            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
