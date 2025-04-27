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

public final class __chartsummarycareplanstatus extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryCarePlanStatus.jsp", 1709115695887L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n29/11/2012  IN035950      Nijitha        CHL Hospital suggested that the presentation of the Clinician desktop be changed and \n\t\t\t\t\t more appealing. Keeping the display of information more clear and visible.\n26/02/2013\tIN035924\t  Karthi L\t \tCA View chart summary ?RESULT WIDGET? should come blank if patient visit hospital after 6 month or time interval defined by customer(CHL-CRF-018)\n13/03/2013  IN038713\t Nijitha S\t\t\t\tCRF-CA- CHL-CRF-0018/04- Scope for Data to be displayed in Widget defined->Other facility->we get exception error\n---------------------------------------------------------------------------------------------------------\nDate       \tEdit History   \tName        \tRev.Date\tRev.Name\tDescription\n---------------------------------------------------------------------------------------------------------\n28/06/2018\tIN065341\tPrakash C\t29/06/2018\tRamesh G\tMMS-DM-CRF-0115\n---------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" <!-- added eCA.* IN035924 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>   \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!--<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\' /> IN035950-->\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\' />\n<!--[IN035950] Ends-->\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<head>\n\t<!--<title>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</title>-->\n\t<title>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</title>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\n\t\t<form name=\'CAViewPatientAllergyForm\' id=\'CAViewPatientAllergyForm\' method=\'post\'>\n\t\t<table  width=\'100%\' class=\'grid\'>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td valign=top CLASS=\'gridData\'  colspan=\"1\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<td CLASS=\'gridData\'  colspan=\"2\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td valign=top CLASS=\'gridData\'  colspan=\"1\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</table>\n\t\t\t\t</form>\n\t\t\t\n\t\t</body>\n\t\t</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}



            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sessionStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(title));
            _bw.write(_wl_block13Bytes, _wl_block13);
  String care_plan_id = "", effective_date = "", care_plan_status = "",encounter_id	=	"",classValue = "";
			String status = "",  md_care_plan_id = "",facility_id ="";
			String term_set_desc="", prev_term_set_desc="",term_code_desc="",cp_term_dtl = "";
			int i=0, termcode_seq_no=0;
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			
			//facility_id=(String) session.getValue("facility_id"); // moved for CHL-CRF-018 IN035924 //commented for IN065341
			String P_patient_id = request.getParameter("patient_id"); // added for CHL-CRF-018 IN035924
			//IN065341 starts
			String scope_disp="D";
			int no_of_days=0;
			String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
			String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");//IN065341
			if(called_from.equals("CDR")){
				encounter_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
				facility_id = request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
			}else{//IN065341 ends
			   encounter_id = request.getParameter("encounter_id"); // IN035924
			   facility_id=(String) session.getValue("facility_id"); // moved for CHL-CRF-018 IN035924 
			}//IN065341
			// added below lines for CHL-CRF-018 IN035924 - START 
			StringBuffer encListBuf = new StringBuffer();
			ArrayList encounterList = null;
		//IN065341 starts
			if(!called_from.equals("CDR")){
			CAEncounterList oEncounterList = new CAEncounterList();
			HashMap encounterMap = oEncounterList.getPatEncounterList(P_patient_id, facility_id, content_ID);
			//String scope_disp = (String)encounterMap.get("SCOPE_DISP");//IN065341
			scope_disp = (String)encounterMap.get("SCOPE_DISP");//IN065341
			Integer no_of_days_before = (Integer)encounterMap.get("NO_OF_DAYS");
			//int no_of_days = no_of_days_before.intValue();
			no_of_days = no_of_days_before.intValue();	
			encounterList = (ArrayList)encounterMap.get("ENC_LIST");
			
			if( no_of_days >= 1  &&  scope_disp.equalsIgnoreCase("P"))
			{
				Iterator iterator = encounterList.iterator();
				int index = 0;
				
				while(iterator.hasNext())
				{	
					index++;
					encListBuf.append("'");
					encListBuf.append(iterator.next());
					if(encounterList.size() >= index )
					{
						encListBuf.append("'");
					}
					
					if(encounterList.size() != index )
					{
						encListBuf.append(",");
					}
				}
			}
			else if(scope_disp.equalsIgnoreCase("P"))
			{
				encListBuf.append("'");
				encListBuf.append(encounter_id);
				encListBuf.append("'");
			}	
			//CHL-CRF-018 IN035924 - END
			//IN038713 Starts
			if(encListBuf.equals("") || null==encListBuf || encounter_id==null || encounter_id.equals(""))
			encListBuf.append("''");
			//IN038713 Ends
			}//IN065341
			Connection con = null;
			PreparedStatement pstmt = null,pstmt1 = null;;
			ResultSet	rs = null,rs1 = null;
		
			try	{
				//encounter_id = request.getParameter("encounter_id"); // moved for CHL-CRF-018 IN035924
				if (encounter_id==null) encounter_id="";
				//facility_id=(String) session.getValue("facility_id"); commented for CHL-CRF-018 IN035924
				if(scope_disp.equalsIgnoreCase("D")) // condition added for CHL-CRF-018 IN035924
				{
					//care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID=? ORDER BY OA.CARE_PLAN_START_DATE desc ";
					care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN ##REPDB## oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID=? ORDER BY OA.CARE_PLAN_START_DATE desc ";//IN065341
				}	
				else if(scope_disp.equalsIgnoreCase("P")) 
				{
					//care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID in ("+encListBuf+") ORDER BY OA.CARE_PLAN_START_DATE desc ";
					//IN065341 starts
					if(called_from.equals("CDR")){
						care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN ##REPDB## oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID in ("+encounter_id+") ORDER BY OA.CARE_PLAN_START_DATE desc ";//IN065341
					}else{//IN065341 ends
						care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN ##REPDB## oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID in ("+encListBuf+") ORDER BY OA.CARE_PLAN_START_DATE desc ";
					}
				}
				else if(scope_disp.equalsIgnoreCase("C"))
				{
					//care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID = ? AND oa.CARE_PLAN_START_DATE between (sysdate - ?) and sysdate  ORDER BY OA.CARE_PLAN_START_DATE desc ";
					care_plan_status = " select  oa.CARE_PLAN_ID ,TO_CHAR(oa.CARE_PLAN_START_DATE,'DD/MM/YYYY') EFFECTIVE_DATE , DECODE(oa.CURRENT_STATUS,'C','Closed','D','Discontinued','O','Open') status , oa.MD_CARE_PLAN_ID from CP_PAT_CARE_PLAN ##REPDB## oa where CURRENT_facility_id=?    AND CURRENT_ENCOUNTER_ID = ? AND oa.CARE_PLAN_START_DATE between (sysdate - ?) and sysdate  ORDER BY OA.CARE_PLAN_START_DATE desc ";//IN065341
				}
				// condition added/modified for CHL-CRF-018 IN035924 - END
				
				//cp_term_dtl = " SELECT DISTINCT B.TERM_SET_DESC , C.SHORT_DESC TERM_CODE_DESC FROM CP_PAT_CARE_PLAN_TERM_CODE A, MR_TERM_SET B, MR_TERM_CODE C WHERE A.MD_CARE_PLAN_ID=? AND A.CARE_PLAN_ID=? AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE =A.TERM_CODE  order by 1,2 ";
				cp_term_dtl = " SELECT DISTINCT B.TERM_SET_DESC , C.SHORT_DESC TERM_CODE_DESC FROM CP_PAT_CARE_PLAN_TERM_CODE ##REPDB## A, MR_TERM_SET ##REPDB## B, MR_TERM_CODE ##REPDB## C WHERE A.MD_CARE_PLAN_ID=? AND A.CARE_PLAN_ID=? AND B.TERM_SET_ID=A.TERM_SET_ID AND C.TERM_CODE =A.TERM_CODE  order by 1,2 ";//IN065341
				care_plan_status=care_plan_status.replaceAll("##REPDB##",RepDb);//IN065341
				cp_term_dtl=cp_term_dtl.replaceAll("##REPDB##",RepDb);//IN065341

				con = ConnectionManager.getConnection(request);
				pstmt	=	con.prepareStatement(care_plan_status);
				pstmt1  =	con.prepareStatement(cp_term_dtl);
				pstmt.setString(1,facility_id);
				if(scope_disp.equalsIgnoreCase("D") || scope_disp.equalsIgnoreCase("C")) //condition added for CHL-CRF-018 IN035924
				{	
					pstmt.setString(2,encounter_id);
				}
				if(scope_disp.equalsIgnoreCase("C")) // added for CHL-CRF-018 IN035924
				{	
					pstmt.setInt(3,no_of_days);	
				}		
				rs = pstmt.executeQuery();

				while(rs.next()){
					i++;
					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";
					
					care_plan_id			=	rs.getString("CARE_PLAN_ID")== null ? "" : rs.getString("CARE_PLAN_ID");
					effective_date			=	rs.getString("EFFECTIVE_DATE")== null ? "" : rs.getString("EFFECTIVE_DATE");

					effective_date			=	com.ehis.util.DateUtils.convertDate(effective_date,"DMY","en",locale);
					status	=	rs.getString("status") == null ? "" : rs.getString("status");
					md_care_plan_id	=	rs.getString("MD_CARE_PLAN_ID") == null ? "" : rs.getString("MD_CARE_PLAN_ID");
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(effective_date));
            _bw.write(_wl_block15Bytes, _wl_block15);

					try	{
						pstmt1.setString(1,md_care_plan_id);
						pstmt1.setString(2,care_plan_id);
						rs1 = pstmt1.executeQuery();
						prev_term_set_desc="*";
						
						term_code_desc="";

						while(rs1.next())
						{
							
							term_set_desc	=	rs1.getString("term_set_desc") == null ? "" : rs1.getString("term_set_desc");
							if (prev_term_set_desc.equals("*"))
							{
								term_code_desc="<B>"+term_set_desc+"</B>";
								termcode_seq_no=1;
							}
							else if(!prev_term_set_desc.equals(term_set_desc))
							{
								term_code_desc = term_code_desc + "<BR><B>"+term_set_desc+"</B>";
								termcode_seq_no=1;
							}
							prev_term_set_desc=term_set_desc;
							term_code_desc	= term_code_desc +	rs1.getString("term_code_desc") == null ? "" : "<BR><I>"+termcode_seq_no +".</I>"+rs1.getString("term_code_desc");
							termcode_seq_no++;
						
						}

						if(rs1 != null) rs1.close();
						//if(pstmt1!=null) pstmt1.close();
					}
					catch(Exception e)
					{
							//out.println("Exception@in : "+e.getMessage());//COMMON-ICN-0181
							e.printStackTrace();//COMMON-ICN-0181
					}  
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(status));
            _bw.write(_wl_block18Bytes, _wl_block18);
	
					}
					//IN035950  Starts
					if(i==0)
					{
					out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
					}
					//IN035950  Ends
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(rs1!=null) rs1.close();
					if(pstmt1 != null) pstmt1.close();
					}catch(Exception e){
						//out.println("Exception@1 : "+e.getMessage());//COMMON-ICN-0181
						  e.printStackTrace();//COMMON-ICN-0181
					}finally
					{

						if(con!=null)ConnectionManager.returnConnection(con,request);
					}  	
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CARE_PEND_SCH.label", java.lang.String .class,"key"));
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
