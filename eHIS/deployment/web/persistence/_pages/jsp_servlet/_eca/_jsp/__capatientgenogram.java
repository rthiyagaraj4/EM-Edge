package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import javax.naming.NamingEnumeration;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __capatientgenogram extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAPatientGenogram.jsp", 1709115172977L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<head> \n<meta http-equiv=\'cache-control\' content=\'no-cache\'>\n<meta http-equiv=\'expires\' content=\'0\'>\n<meta http-equiv=\'pragma\' content=\'no-cache\'>\n<title>Genogram</title>\n<script>\nfunction patHistory(val,val1){\n\tvar dialogHeight =\'45\' ;\n\tvar dialogWidth = \'88\' ;\n\tvar dialogTop\t= \'10\';\n\tvar dialogLeft = \'10\' ;\n\tvar screen_width=screen.width;\n\n\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\';dialogTop:\'+dialogTop+\';dialogLeft:\'+dialogLeft+\'; scroll=yes; status=no\';\n\tvar arguments\t= \"\";\n\tif(val!=\'\'){\n\t\twindow.showModalDialog(\"../../eCA/jsp/CAMainChart.jsp?lookupFileName=../../eCA/jsp/FlowSheet.jsp?option_id=FLOW_SHEET&locale=en&patient_id=\"+val+\"&Patient_ID=\"+val+\"&PGeno_Name=\"+val1+\"&Genotitle=Y&function_display_name=Clinical Event History\",arguments,features);\t\t\n\t}\n\t\n}\n</script> \n<style type=\"text/css\" media=\"print\">\n\n@media print {\n  body {\n    width: 1280\n    height: 800\n  }\n  /* etc */\n}\n</style>\n\n\n</head> \n<body > \n<TABLE align=center border=\"0\" width = \'100%\'>\n\t<TR>\n\t\t<TD align=\"center\">\n\t\t\t <!--<DIV style=\"height: 100%;width: 100%;overflow: auto;\"  > -->\n\t\t\t <DIV style=\"height: 100%;width: 100%;\">\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\n\t\t\t<applet code=\"CAGenogramApplet\" codebase=\"../Genogram/\" archive=\"CAGenogramApplet.jar\" width=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" height=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" >\n\t\t\t\t<param name=\"classloader_cache\" value=\"false\">\n\t\t\t\t\n\t\t\t\t<!-- 4th Generation-->\n\t\t\t\t<param name=\"patFFGrandFatherId\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t\t<param name=\"patFFGrandMotherId\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t<param name=\"patFMGrandFatherId\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t<param name=\"patFMGrandMotherId\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t<param name=\"patMFGrandFatherId\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t<param name=\"patMFGrandMotherId\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t<param name=\"patMMGrandFatherId\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t<param name=\"patMMGrandMotherId\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\n\t\t\t\t<param name=\"patFFGrandFatherAndHisWife_Relation\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\t\t\t\t\n\t\t\t\t<param name=\"patFMGrandFatherAndHisWife_Relation\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\t\t\t\t\n\t\t\t\t<param name=\"patMFGrandFatherAndHisWife_Relation\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\t\t\t\t\n\t\t\t\t<param name=\"patMMGrandFatherAndHisWife_Relation\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\n\t\t\t\t<!-- 3rd Generation-->\t\t\t\t\n\t\t\t\t<param name=\"patFGrandFatherId\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t<param name=\"patFGrandMotherId\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t<param name=\"patMGrandFatherId\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t<param name=\"patMGrandMotherId\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\t\t\t\t\n\t\t\t\t\n\t\t\t\t<param name=\"patFGrandFatherFather_Childs\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t\t<param name=\"patFGrandMotherFather_Childs\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t<param name=\"patMGrandFatherFather_Childs\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t<param name=\"patMGrandMotherFather_Childs\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t\t\n\t\t\t\t<param name=\"patFFather_Mother_Relation\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t<param name=\"patMFather_Mother_Relation\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t\n\t\t\t\t<!-- 2nd Generation-->\t\t\t\t\n\t\t\t\t<param name=\"patFatherId\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t\t<param name=\"patMotherId\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\t\t\t\t\n\t\t\t\t<param name=\"patFGrandFather_Childs\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t<param name=\"patMGrandFather_Childs\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\t\t\t\t\n\t\t\t\t<param name=\"patFather_Mother_Relation\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t\t\t\n\t\t\t\t<!-- Current Generation.-->\n\t\t\t\t<param name=\"patient_id\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t\t<param name=\"patFather_Childs\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t<param name=\"patientFamily_Details\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t<param name=\"patientFamily_Relations\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t\t\t\n\t\t\t\t<param name=\"patientChilds\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t\t\n\t\t\t\t<param name=\"patientsDetails\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t\t<param name=\"esiDetails\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t<param name=\"mhDetails\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">  <!--  IN043482 -->\n\t\t\t</applet>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\n\t\t\t</DIV>\n\t\t</TD>\n\t</TR>\n<TABLE>\n<script>\n\t\tfunction assignTransBtnPage(){\n\t\t\tparent.patientGenogramTranBtn.location.href=\'../../eCA/jsp/CAPatientGenogramTranBtn.jsp?patient_id=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&drawRelationString=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\';\n\t\t}\n\t\t//call after page loaded\n\t\twindow.onload=assignTransBtnPage ; \n\t\t</script>\n</body> \n</html> \n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );
	
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
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
20/09/2013  IN043482		Ramesh G		The added Medical History is not displayed in Genogram
--------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block6Bytes, _wl_block6);

			// Current Generation
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale					=	(String) p.getProperty("LOCALE");
			
			int screenHeight=500;
			int screenWidth=1000;
			
			
			//4th Generation Details
				String patFFGrandFatherId	=	"";
				String patFFGrandMotherId	=	"";
				String patFMGrandFatherId	=	"";
				String patFMGrandMotherId	=	"";
				String patMFGrandFatherId	=	"";
				String patMFGrandMotherId	=	"";
				String patMMGrandFatherId	=	"";
				String patMMGrandMotherId	=	"";
				
			//4th Generations  Relation
				
				String patFFGrandFatherId_Wife_Relation	=	"";				
				String patFMGrandFatherId_Wife_Relation	=	"";				
				String patMFGrandFatherId_Wife_Relation	=	"";				
				String patMMGrandFatherId_Wife_Relation	=	""; 
				
			//3rd Generation				
				String patFGrandFatherId	= 	"";
				String patFGrandMotherId	=	"";
				String patMGrandFatherId	=	"";
				String patMGrandMotherId	=	"";	
			//3rd Generation  Details
				String patFGrandFatherFather_Childs	= 	"";
				String patFGrandMotherFather_Childs	=	"";
				String patMGrandFatherFather_Childs	=	"";
				String patMGrandMotherFather_Childs	=	"";
			//3rd Generations  Relation
				String patFFather_Mother_Relation	=	"";
				String patMFather_Mother_Relation	=	"";
				
			//2nd Generation	
				String patFatherId			=	"";
				String patMotherId 			=	"";
			//2nd Generation Details
				String patFGrandFather_Childs	= 	"";
				String patMGrandFather_Childs	=	"";
			//2nd Generation Relation
				String patFather_Mother_Relation	=	"";
			
			// Current Generation Details
				String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
				String patient_id_ = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");				
				//patient_id = "A07";
				String patFather_Childs			=	"";
				String patientFamily_Details	=	"";
				String patientFamily_Relations	=	"";
				
				String patientChilds		=	"";
				String patientTotalChilds	=	"";
				
			StringBuffer patientsDetails = new StringBuffer();			
			String patients_Details ="";
			StringBuffer esiRelationDetails = new StringBuffer();
			String esi_Details ="";
			StringBuffer mhRelationDetails = new StringBuffer();  //IN043482
			String mh_Details ="";								//IN043482
			ArrayList<String> draw_relations= new ArrayList<String>();
			StringBuffer draw_relationsDetails = new StringBuffer();  
			String drawRelationsDetails ="";								
			Connection conn=null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			  
			PreparedStatement pst1 = null;
			ResultSet rs1 = null;
			  
			PreparedStatement pst2 = null;
			ResultSet rs2 = null;
			
			try{
				conn = ConnectionManager.getConnection(request);				
				pst = conn.prepareStatement("SELECT NON_PATIENT_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE PATIENT_ID=?");//NEW
				pst.setString(1,patient_id);
				rs = pst.executeQuery();
				if(rs.next()){
				  patient_id	=	rs.getString("NON_PATIENT_ID")==null?"":(String)rs.getString("NON_PATIENT_ID");
				}else{
					patient_id="";
				}
				if(rs!=null)rs.close();
				if(pst!=null)pst.close();
				
				if(!"".equals(patient_id)){
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1,patient_id);
					rs = pst.executeQuery();
					if(rs.next()){
					  patFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
					
					
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patFatherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patFGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patFGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
					
					
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patMotherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patMGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patMGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
					
					
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patFGrandFatherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patFFGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patFFGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();

					
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patFGrandMotherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patFMGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patFMGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();

					
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patMGrandFatherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patMFGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patMFGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();

				
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patMGrandMotherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patMMGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patMMGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
			//4th Genaration Reltion Details
					if((!"".equals(patFFGrandFatherId)) && (!"".equals(patFFGrandMotherId))){						
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patFFGrandFatherId);
						pst.setString(2, patFFGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patFFGrandFatherId_Wife_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");						
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					if((!"".equals(patFMGrandFatherId))&&(!"".equals(patFMGrandMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patFMGrandFatherId);
						pst.setString(2, patFMGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patFMGrandFatherId_Wife_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					if((!"".equals(patMFGrandFatherId))&&(!"".equals(patMFGrandMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patMFGrandFatherId);
						pst.setString(2, patMFGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patMFGrandFatherId_Wife_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");						
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					if((!"".equals(patMMGrandFatherId))&&(!"".equals(patMMGrandMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patMMGrandFatherId);
						pst.setString(2, patMMGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patMMGrandFatherId_Wife_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");						
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
			//3rd Generation Details
					if(!"".equals(patFGrandFatherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patFGrandFatherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patFGrandFatherFather_Childs)){
												patFGrandFatherFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patFGrandFatherFather_Childs =patFGrandFatherFather_Childs +"|"+ rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									patFGrandFatherFather_Childs =patFGrandFatherId;
								}							
							}
							if(rs!=null)rs.close();
							if(pst!=null)pst.close();
						}
					}
					
					if(!"".equals(patFGrandMotherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patFGrandMotherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID  CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patFGrandMotherFather_Childs)){
												patFGrandMotherFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patFGrandMotherFather_Childs = patFGrandMotherFather_Childs + "|" + (rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID"));
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									
									patFGrandMotherFather_Childs =patFGrandMotherId;
								}
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					
					if(!"".equals(patMGrandFatherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patMGrandFatherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID  CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patMGrandFatherFather_Childs)){
												patMGrandFatherFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patMGrandFatherFather_Childs =patMGrandFatherFather_Childs +"|"+ rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									patMGrandFatherFather_Childs =patMGrandFatherId;
								}
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					
					if(!"".equals(patMGrandMotherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patMGrandMotherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patMGrandMotherFather_Childs)){
												patMGrandMotherFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patMGrandMotherFather_Childs =patMGrandMotherFather_Childs +"|"+ rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									patMGrandMotherFather_Childs =patMGrandMotherId;
								}
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					
			//3rd Generation Relation Ship
					
					if((!"".equals(patFGrandFatherId))&&(!"".equals(patFGrandMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patFGrandFatherId);
						pst.setString(2, patFGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patFFather_Mother_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					
					if((!"".equals(patMGrandFatherId))&&(!"".equals(patMGrandMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patMGrandFatherId);
						pst.setString(2, patMGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patMFather_Mother_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
			
			//2nd Generation Details
					if(!"".equals(patFatherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patFatherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patFGrandFather_Childs)){
												patFGrandFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patFGrandFather_Childs =patFGrandFather_Childs +"|"+ (rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID"));
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									patFGrandFather_Childs =patFatherId;
								}
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					if(!"".equals(patMotherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patMotherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patMGrandFather_Childs)){
												patMGrandFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patMGrandFather_Childs =patMGrandFather_Childs +"|"+ (rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID"));
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									patMGrandFather_Childs =patMotherId;
								}
							}
							if(rs!=null)rs.close();
							if(pst!=null)pst.close();
						}
					}
			//2nd Generation Relation
					if((!"".equals(patFatherId))&&(!"".equals(patMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patFatherId);
						pst.setString(2, patMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patFather_Mother_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
			//Current Generation
					if(patFatherId!=null && !"".equals(patFatherId) && !"".equals(patMotherId) && patMotherId!=null){
						pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
						pst1.setString(1, patFatherId);
						pst1.setString(2, patMotherId);
						rs1 = pst1.executeQuery();
						if(rs1 !=null){
							while(rs1.next()){
								if("".equals(patFather_Childs)){
									patFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
								}else{
									patFather_Childs =patFather_Childs +"|"+ (rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID"));
								}
							}
						}
						if(rs1!=null)rs1.close();
						if(pst1!=null)pst1.close();
					}else{
						patFather_Childs =patMotherId;
					}
					
					
					pst = conn.prepareStatement("SELECT TO_GENOID,DECODE(RELATION_ID,'MA','0','1') SRLNO, RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? ORDER BY SRLNO"); 
					pst.setString(1, patient_id);
					rs = pst.executeQuery();
					int pfamilCount=0;
					if(rs !=null){
						while(rs.next()){
							if("".equals(patientFamily_Details)){
								patientFamily_Details = rs.getString("TO_GENOID")==null?"":(String)rs.getString("TO_GENOID"); 
							}else{
								patientFamily_Details =patientFamily_Details +"|"+ (rs.getString("TO_GENOID")==null?"":(String)rs.getString("TO_GENOID")); 
							}						
							
														
							if("".equals(patientFamily_Relations)){
								patientFamily_Relations = (String)rs.getString("RELATION_ID"); 
								draw_relations.add((String)rs.getString("RELATION_ID"));
							}else{
								patientFamily_Relations =patientFamily_Relations +"|"+ (String)rs.getString("RELATION_ID"); 
								draw_relations.add((String)rs.getString("RELATION_ID"));
							}	
							pfamilCount++;
							
							
							pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?) ORDER BY SIBLNG_POS"); 
							pst1.setString(1, patient_id);
							pst1.setString(2, (String)rs.getString("TO_GENOID")); 
							rs1 = pst1.executeQuery();
							String vicChild_="";
							if(rs1 !=null){
								while(rs1.next()){
									if("".equals(vicChild_)){
										vicChild_ = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
									}else{
										vicChild_ =vicChild_ +"|"+ (rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID"));
									}
								}
								if("".equals(patientTotalChilds)){
									patientTotalChilds = vicChild_;
								}else{
									patientTotalChilds	= patientTotalChilds+"|"+vicChild_;
								}
								if(!"".equals(vicChild_)){
									if("".equals(patientChilds)){
										patientChilds = patient_id+"-"+(String)rs.getString("TO_GENOID")+"~"+vicChild_;
									}else{
										patientChilds =patientChilds +"^"+ patient_id+"-"+(String)rs.getString("TO_GENOID")+"~"+vicChild_;
									}
								}
							}
							if(rs1!=null)rs1.close();
							if(pst1!=null)pst1.close();
							
							
						}
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
					
					screenHeight = screenHeight+(150*(pfamilCount-1));
					ArrayList totalList = new ArrayList();
					if(!"".equals(patient_id))
						totalList.add(patient_id);
					if(!"".equals(patFFGrandFatherId))
						totalList.add(patFFGrandFatherId);
					if(!"".equals(patFFGrandMotherId))
						totalList.add(patFFGrandMotherId);
					if(!"".equals(patFMGrandFatherId))
						totalList.add(patFMGrandFatherId);
					if(!"".equals(patFMGrandMotherId))
						totalList.add(patFMGrandMotherId);
					if(!"".equals(patMFGrandFatherId))
						totalList.add(patMFGrandFatherId);
					if(!"".equals(patMFGrandMotherId))
						totalList.add(patMFGrandMotherId);
					if(!"".equals(patMMGrandFatherId))
						totalList.add(patMMGrandFatherId);
					if(!"".equals(patMMGrandMotherId))
						totalList.add(patMMGrandMotherId);
					ArrayList childArraylist = new ArrayList();
						if(!"".equals(patFGrandFatherFather_Childs))
							childArraylist.add(patFGrandFatherFather_Childs);
						if(!"".equals(patFGrandMotherFather_Childs))
							childArraylist.add(patFGrandMotherFather_Childs);
						if(!"".equals(patMGrandFatherFather_Childs))
							childArraylist.add(patMGrandFatherFather_Childs);
						if(!"".equals(patMGrandMotherFather_Childs))
							childArraylist.add(patMGrandMotherFather_Childs);
						if(!"".equals(patFGrandFather_Childs))
							childArraylist.add(patFGrandFather_Childs);
						if(!"".equals(patMGrandFather_Childs))
							childArraylist.add(patMGrandFather_Childs);
						if(!"".equals(patFather_Childs))
							childArraylist.add(patFather_Childs);
						if(!"".equals(patientFamily_Details))
							childArraylist.add(patientFamily_Details);
						if(!"".equals(patientTotalChilds))
							childArraylist.add(patientTotalChilds);
						//childArraylist.add();
						//childArraylist.add();
					if(!"".equals(patFFGrandFatherId_Wife_Relation))
							draw_relations.add(patFFGrandFatherId_Wife_Relation);
					if(!"".equals(patFMGrandFatherId_Wife_Relation))
							draw_relations.add(patFMGrandFatherId_Wife_Relation);
					if(!"".equals(patMFGrandFatherId_Wife_Relation))
							draw_relations.add(patMFGrandFatherId_Wife_Relation);
					if(!"".equals(patMMGrandFatherId_Wife_Relation))
							draw_relations.add(patMMGrandFatherId_Wife_Relation);
					if(!"".equals(patFFather_Mother_Relation))
							draw_relations.add(patFFather_Mother_Relation);
					if(!"".equals(patMFather_Mother_Relation))
							draw_relations.add(patMFather_Mother_Relation);
					if(!"".equals(patFather_Mother_Relation))
							draw_relations.add(patFather_Mother_Relation);
			
					for(int i=0;i<childArraylist.size();i++){					
						String[] tempChildIds = ((String)childArraylist.get(i)).split("\\|");
						for(int j=0;j<tempChildIds.length;j++){						
							totalList.add(tempChildIds[j]);
						}
					}
					StringBuffer totalListbf= new StringBuffer();
					for(int k=0;k<totalList.size();k++){
						totalListbf.append("'"+((String)totalList.get(k))+"'");
						if(k!=(totalList.size())-1)
							totalListbf.append(",");
					}
					
					if(!"".equals(totalListbf.toString())){
						//pst = conn.prepareStatement("SELECT PATIENT_ID,PATIENT_NAME,SEX,SM_CONVERT_DATE_2T(DATE_OF_BIRTH,?) DATE_OF_BIRTH,DECESED_YN,MARRIED_YN,FATHER_ID,MOTHER_ID FROM CA_GNO_PATIENT_DTL WHERE PATIENT_ID IN ("+totalListbf.toString()+")");//OLD					
						pst = conn.prepareStatement("SELECT PATIENT_ID,NON_PATIENT_ID,PATIENT_NAME,SEX,SM_CONVERT_DATE_2T(DATE_OF_BIRTH,?) DATE_OF_BIRTH,DECEASED_YN,COUPLE_RELN_YN,FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID IN ("+totalListbf.toString()+")");//NEW					
						pst.setString(1, locale);
						
						rs = pst.executeQuery();	
						
						if(rs!=null){						
							while(rs.next()){
								if(!"".equals(patientsDetails.toString()))
									patientsDetails.append("|");
								patientsDetails.append(rs.getString("NON_PATIENT_ID")==null?"":(String)rs.getString("NON_PATIENT_ID"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("PATIENT_NAME")==null?"":(String)rs.getString("PATIENT_NAME"));	
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("DATE_OF_BIRTH")==null?"":(String)rs.getString("DATE_OF_BIRTH"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("DECEASED_YN")==null?"":(String)rs.getString("DECEASED_YN"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("COUPLE_RELN_YN")==null?"":(String)rs.getString("COUPLE_RELN_YN"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("PATIENT_ID")==null?"":(String)rs.getString("PATIENT_ID"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("SEX")==null?"":(String)rs.getString("SEX"));
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					patients_Details	= patientsDetails.toString();
					//Emotional/Social/Interpersonal Relations.
					if(!"".equals(totalListbf.toString())){
						pst = conn.prepareStatement("SELECT A.TO_GENOID||'~'||(SELECT SEX FROM CA_GENOGRAM_ATTRIBUTE WHERE NON_PATIENT_ID=A.TO_GENOID)||'~'||A.FROM_GENOID||'~'||(SELECT SEX FROM CA_GENOGRAM_ATTRIBUTE WHERE NON_PATIENT_ID=A.FROM_GENOID)||'~'||A.RELATION_ID ESIRELATION,A.RELATION_ID RELATION_ID FROM CA_GENOGRAM_RELATION A WHERE A.RELATION_TYPE_ID IN ('EMOTION','SOCIAL','INTER') AND A.TO_GENOID IN ("+totalListbf.toString()+")");				
						rs = pst.executeQuery();						
						if(rs!=null){						
							while(rs.next()){
								if(!"".equals(esiRelationDetails.toString()))
									esiRelationDetails.append("|");
								esiRelationDetails.append(rs.getString("ESIRELATION")==null?"":(String)rs.getString("ESIRELATION"));								
								draw_relations.add((String)rs.getString("RELATION_ID"));
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					esi_Details	= esiRelationDetails.toString();
					//IN043482 Start.
					//Medical History.
					if(!"".equals(totalListbf.toString())){
						pst = conn.prepareStatement("SELECT A.FROM_GENOID||'~'||(SELECT SEX FROM CA_GENOGRAM_ATTRIBUTE WHERE NON_PATIENT_ID=A.FROM_GENOID)||'~'||A.RELATION_ID MHRELATION, A.RELATION_ID RELATION_ID FROM CA_GENOGRAM_RELATION A WHERE A.RELATION_TYPE_ID='MH' AND A.FROM_GENOID IN("+totalListbf.toString()+")");				
						rs = pst.executeQuery();						
						if(rs!=null){						
							while(rs.next()){
								if(!"".equals(mhRelationDetails.toString()))
									mhRelationDetails.append("|");
								mhRelationDetails.append(rs.getString("MHRELATION")==null?"":(String)rs.getString("MHRELATION"));								
								draw_relations.add((String)rs.getString("RELATION_ID"));
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					mh_Details	= mhRelationDetails.toString();
					//IN043482 End.
					//Draw Relations
					for(int i=0;i<draw_relations.size();i++){
							if(!"".equals(draw_relationsDetails.toString()))
									draw_relationsDetails.append("|");
							draw_relationsDetails.append((String)draw_relations.get(i));						
					}
					
					drawRelationsDetails=draw_relationsDetails.toString();
			
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(screenWidth));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(screenHeight));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patFFGrandFatherId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patFFGrandMotherId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patFMGrandFatherId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patFMGrandMotherId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patMFGrandFatherId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patMFGrandMotherId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patMMGrandFatherId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patMMGrandMotherId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patFFGrandFatherId_Wife_Relation));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patFMGrandFatherId_Wife_Relation));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patMFGrandFatherId_Wife_Relation));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patMMGrandFatherId_Wife_Relation));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patFGrandFatherId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patFGrandMotherId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patMGrandFatherId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patMGrandMotherId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patFGrandFatherFather_Childs));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patFGrandMotherFather_Childs));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patMGrandFatherFather_Childs));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(patMGrandMotherFather_Childs));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patFFather_Mother_Relation));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(patMFather_Mother_Relation));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patFatherId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patMotherId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patFGrandFather_Childs));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patMGrandFather_Childs));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patFather_Mother_Relation));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patFather_Childs));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patientFamily_Details));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patientFamily_Relations));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patientChilds));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patients_Details));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(esi_Details));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(mh_Details));
            _bw.write(_wl_block44Bytes, _wl_block44);

				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{				
				if(conn != null) ConnectionManager.returnConnection(conn,request);
			}
			
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_id_));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(drawRelationsDetails));
            _bw.write(_wl_block47Bytes, _wl_block47);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
