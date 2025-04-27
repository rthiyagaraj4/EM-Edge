package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifyinsupldimgpayerdata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyInsUpldImgPayerData.jsp", 1709114323707L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Policy Details</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\'../js/InsUpldImage.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n</head>\n<body>\n\t<br>\n\t<br>\n\t<table class=\'grid\' border=\'1\' width=\'95%\' align=\"center\">\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<tr>\n\t\t\t<td>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<a href=\"javascript:retuenPayerData(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\n\t\t\t\t\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\t\t\t\n\t\t\t\t<a href=\"javascript:retuenPayerData(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</table>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );
 private String checkForNull(String inputString)
	{
		//return (inputString == null) ? "0000" :	inputString;
		return (inputString == null) ? "" :	inputString;	//Modified Against ICN:10055
	} 

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sql = ""; 
	String inParam = checkForNull(request.getParameter("inParam"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String episode_type = checkForNull(request.getParameter("episode_type"));
	String episode_id = checkForNull(request.getParameter("episode_id"));
	String facility_id = checkForNull(request.getParameter("facility_id"));

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	//GHL- CRF-0550 --- PALANI NARAYANAN - STARTS
	boolean siteSpecUploadDocAll = false;

try {
	con	=	ConnectionManager.getConnection(request);
	siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_UPLOAD_DOC_ALL");
	/*
	} catch(Exception ex) {
		System.err.println("AddModifyInsUpldImgPayerData.jsp:"+ex);
		ex.printStackTrace();
	} */ //Commented V211018
	if(siteSpecUploadDocAll)
	{
	if(("I".equals(episode_type)) || ("D".equals(episode_type)) || ("O".equals(episode_type)) || ("E".equals(episode_type))){
		if(episode_id.length() > 0){		
		sql = 	"Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
			"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date "+
			"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust "+
			"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And upper(Bl.Episode_Id) Like upper('%"+episode_id+"%') "+
			"And Bl.Cust_Code Is Not Null "+
			"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
			"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id";
	}
	else{
		if(("I".equals(episode_type)) || ("D".equals(episode_type))) {
		//Added by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020 query modified added union for credit
		sql = "SELECT NVL (bl.encounter_id,bl.episode_id || LPAD (bl.visit_id, 4, 0)) episode_id1,bl.cust_group_code, grp.long_desc payer_group, bl.cust_code, cust.long_name payer, bl.policy_type_code,"+ 
			       " 'CREDIT' policy_type,bl.policy_number, TO_CHAR (bl.policy_start_date, 'dd/mm/yyyy') policy_start_date, TO_CHAR (bl.policy_expiry_date, 'dd/mm/yyyy') policy_expiry_date, a.short_desc short_desc "+
					  " FROM bl_encounter_payer_priority bl,ar_cust_group grp,ar_customer cust,bl_blng_grp a,bl_episode_fin_dtls b "+
			 		" WHERE bl.patient_id ='"+patient_id+"' AND bl.episode_type = '"+episode_type+"' AND bl.cust_code IS NOT NULL AND bl.operating_facility_id = '"+facility_id+"' AND bl.cust_group_code = grp.cust_group_code AND bl.cust_code = cust.cust_code "+   
			   		" AND a.blng_grp_id = bl.blng_grp_id AND bl.patient_id = b.patient_id AND bl.episode_type = b.episode_type AND bl.episode_id = b.episode_id AND bl.SETTLEMENT_IND = b.SETTLEMENT_IND and B.SETTLEMENT_IND = 'R' "+
					" UNION " + 
				"Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
				"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date,A.SHORT_DESC short_desc "+
				"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust,bl_BLNG_GRP A ,bl_episode_fin_dtls b "+
				"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
				"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
				"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id AND A.BLNG_GRP_ID = BL.BLNG_GRP_ID "+
				"And bl.patient_id=b.patient_id and bl.episode_type=b.episode_type and bl.episode_id=b.episode_id "+
				" UNION "+
	            "select nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,' ' Cust_Group_Code,'CASH' payer_group,' ' Cust_Code,' ' payer,' ' Policy_Type_Code,'CASH' policy_type,' ' Policy_Number,' ' Policy_Start_Date,' ' Policy_Expiry_Date ,' ' short_desc "+ 
				" From Bl_Encounter_Payer_Priority BL , bl_episode_fin_dtls b where bl.patient_id='"+patient_id+"' and bl.settlement_ind='C' "+
	            "and bl.patient_id=b.patient_id and bl.episode_type=b.episode_type and bl.episode_id=b.episode_id and b.settlement_ind='C' And Bl.Episode_Type ='"+episode_type+"'";
		}
		else{
		//Added by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020 query modified added union for credit
		sql = 	"SELECT NVL (bl.encounter_id,bl.episode_id || LPAD (bl.visit_id, 4, 0)) episode_id1,bl.cust_group_code, grp.long_desc payer_group, bl.cust_code,"+
		       " cust.long_name payer, bl.policy_type_code, 'CREDIT' policy_type,bl.policy_number, TO_CHAR (bl.policy_start_date, 'dd/mm/yyyy') policy_start_date, TO_CHAR (bl.policy_expiry_date, 'dd/mm/yyyy') policy_expiry_date, a.short_desc short_desc "+
				  " FROM bl_encounter_payer_priority bl,ar_cust_group grp,ar_customer cust,bl_blng_grp a,bl_visit_fin_dtls b "+
		 		" WHERE bl.patient_id ='"+patient_id+"' AND bl.episode_type = '"+episode_type+"' AND bl.cust_code IS NOT NULL AND bl.operating_facility_id = '"+facility_id+"' AND bl.cust_group_code = grp.cust_group_code AND bl.cust_code = cust.cust_code "+   
		   		" AND a.blng_grp_id = bl.blng_grp_id AND bl.patient_id = b.patient_id AND bl.episode_type = b.episode_type AND bl.episode_id = b.episode_id AND bl.visit_id = b.visit_id AND bl.SETTLEMENT_IND = b.SETTLEMENT_IND and B.SETTLEMENT_IND = 'R' "+
				" UNION " + 
				"Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
					"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date,A.SHORT_DESC short_desc "+
					"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust,bl_BLNG_GRP A ,bl_visit_fin_dtls b "+
					"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
					"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
					"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id AND A.BLNG_GRP_ID = BL.BLNG_GRP_ID "+
					"And bl.patient_id=b.patient_id and bl.episode_type=b.episode_type and bl.episode_id=b.episode_id and bl.visit_id=b.visit_id "+
					" UNION "+
		            "select nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,' ' Cust_Group_Code,'CASH' payer_group,' ' Cust_Code,' ' payer,' ' Policy_Type_Code,'CASH' policy_type,' ' Policy_Number,' ' Policy_Start_Date,' ' Policy_Expiry_Date ,' ' short_desc "+ 
					" From Bl_Encounter_Payer_Priority BL , bl_visit_fin_dtls b where bl.patient_id='"+patient_id+"' and bl.settlement_ind='C' "+
		            "and bl.patient_id=b.patient_id and bl.episode_type=b.episode_type and bl.episode_id=b.episode_id and bl.visit_id=b.visit_id and b.settlement_ind='C' And Bl.Episode_Type ='"+episode_type+"'";
		}
	}
	}
	else if("R".equals(episode_type)){
		/*	sql = "select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
					"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date  "+
					"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust "+
					"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
					"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
					"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id ";*/
		//Added by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020 query modified added union for credit
		sql = "SELECT NVL (bl.encounter_id,bl.episode_id || LPAD (bl.visit_id, 4, 0)) episode_id1,bl.cust_group_code, grp.long_desc payer_group, bl.cust_code,"+
	       " cust.long_name payer, bl.policy_type_code, 'CREDIT' policy_type,bl.policy_number, TO_CHAR (bl.policy_start_date, 'dd/mm/yyyy') policy_start_date, TO_CHAR (bl.policy_expiry_date, 'dd/mm/yyyy') policy_expiry_date, a.short_desc short_desc "+
			  " FROM bl_encounter_payer_priority bl,ar_cust_group grp,ar_customer cust,bl_blng_grp a,bl_patient_fin_dtls b "+
	 		" WHERE bl.patient_id ='"+patient_id+"' AND bl.episode_type = '"+episode_type+"' AND bl.cust_code IS NOT NULL AND bl.operating_facility_id = '"+facility_id+"' AND bl.cust_group_code = grp.cust_group_code AND bl.cust_code = cust.cust_code "+   
	   		" AND a.blng_grp_id = bl.blng_grp_id AND bl.patient_id = b.patient_id AND  bl.SETTLEMENT_IND = b.SETTLEMENT_IND and B.SETTLEMENT_IND = 'R' "+
			" UNION " + 
		"Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
		"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date,A.SHORT_DESC short_desc "+
		"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust,bl_BLNG_GRP A ,bl_patient_fin_dtls b "+
		"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
		"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
		"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id AND A.BLNG_GRP_ID = BL.BLNG_GRP_ID "+
		"And bl.patient_id=b.patient_id  "+
		" UNION "+
	        "select nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,' ' Cust_Group_Code,'CASH' payer_group,' ' Cust_Code,' ' payer,' ' Policy_Type_Code,'CASH' policy_type,' ' Policy_Number,' ' Policy_Start_Date,' ' Policy_Expiry_Date ,' ' short_desc "+ 
			" From Bl_Encounter_Payer_Priority BL , bl_patient_fin_dtls b where bl.patient_id='"+patient_id+"' and bl.settlement_ind='C' "+
	        "and bl.patient_id=b.patient_id and b.settlement_ind='C' And Bl.Episode_Type ='"+episode_type+"'";	
	}
	}
//GHL- CRF-0550 --- PALANI NARAYANAN - ENDS
else
{	
	if(("I".equals(episode_type)) || ("D".equals(episode_type)) || ("O".equals(episode_type)) || ("E".equals(episode_type))){
		if(episode_id.length() > 0){
			sql =	"Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
					"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date "+
					"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust "+
					"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And upper(Bl.Episode_Id) Like upper('%"+episode_id+"%') "+
					"And Bl.Cust_Code Is Not Null "+
					"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
					"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id";
		}
		else{
			sql = "Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
					"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date "+
					"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust "+
					"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
					"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
					"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id";

		}		
	}
	else if("R".equals(episode_type)){
		sql = "Select  nvl(Bl.Encounter_Id,Bl.Episode_Id||lpad(Bl.visit_id,4,0)) episode_id1,Bl.Cust_Group_Code,grp.long_desc payer_group,Bl.Cust_Code,cust.long_name payer,Bl.Policy_Type_Code, "+
				"pol.long_desc policy_type,Bl.Policy_Number,to_char(bl.Policy_Start_Date,'dd/mm/yyyy') Policy_Start_Date,to_char(bl.Policy_Expiry_Date,'dd/mm/yyyy') Policy_Expiry_Date "+
				"From Bl_Encounter_Payer_Priority bl,bl_ins_policy_types pol,Ar_Cust_Group Grp,Ar_Customer Cust "+
				"Where Bl.Patient_Id = '"+patient_id+"' And Bl.Episode_Type ='"+episode_type+"' And Bl.Cust_Code Is Not Null "+
				"And Bl.Operating_Facility_Id = '"+facility_id+"' AND Bl.cust_group_code = grp.cust_group_code AND Bl.cust_code = cust.cust_code "+
				"And Bl.Policy_Type_Code  = Pol.Policy_Type_Code AND Bl.operating_facility_id  = pol.operating_facility_id";
			
	}
}


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

	try{
		int rsCnt = 0;
		//con = ConnectionManager.getConnection(request);			
		
		pstmt = con.prepareStatement(sql);
		if("Y".equals(inParam)){
			pstmt.setString(1,episode_id);
		}
		rst = pstmt.executeQuery();
		if(rst != null){
		while(rst.next()){
		rsCnt++;
		
            _bw.write(_wl_block11Bytes, _wl_block11);
 
			if(siteSpecUploadDocAll)
			{ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(checkForNull(rst.getString("Episode_Id1")) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rst.getString("Cust_Group_Code")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("payer_group")) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rst.getString("Cust_Code")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("payer")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("Policy_Type_Code")) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rst.getString("policy_type")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("Policy_Number")) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rst.getString("Policy_Start_Date")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("Policy_Expiry_Date"))));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("short_desc"))));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rst.getString("policy_type") ));
            _bw.write(_wl_block16Bytes, _wl_block16);
 } else{ 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checkForNull(rst.getString("Episode_Id1")) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rst.getString("Cust_Group_Code")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("payer_group")) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rst.getString("Cust_Code")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("payer")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("Policy_Type_Code")) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rst.getString("policy_type")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("Policy_Number")) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rst.getString("Policy_Start_Date")) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rst.getString("Policy_Expiry_Date"))));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rst.getString("policy_type") ));
            _bw.write(_wl_block18Bytes, _wl_block18);
 }
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rst.getString("payer_group") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rst.getString("payer") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(checkForNull(rst.getString("Episode_Id1")) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
		}
		if(rsCnt<1){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Exception in AddModifyInsUpldImgPayerData -> "+e);
		}
		finally{
			//ConnectionManager.returnConnection(con);//Commented V211018
			pstmt = null;
			rst = null;
		}
	} catch(Exception ex) {   //V211018
		System.err.println("AddModifyInsUpldImgPayerData.jsp Exception:::"+ex);
		ex.printStackTrace();
	}  
	finally{
		ConnectionManager.returnConnection(con);
	} //V211018
	
	
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
