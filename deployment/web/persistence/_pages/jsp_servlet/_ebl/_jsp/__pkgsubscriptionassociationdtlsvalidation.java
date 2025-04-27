package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.itextpdf.text.log.SysoLogger;
import webbeans.eCommon.*;
import eBL.*;
import eBL.Common.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pkgsubscriptionassociationdtlsvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgSubscriptionAssociationDtlsValidation.jsp", 1732106598527L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	try {
		System.err.println("Inside PkgSubscriptionAssociationDtlsValidation.jsp");
		Connection con = ConnectionManager.getConnection();	
		request.setCharacterEncoding("UTF-8");	
		String action=request.getParameter("action");
		String pkgCode="";
		System.err.println("Inside PkgSubscriptionAssociationDtlsValidation.jsp action:"+action);
		if(action.equals("across_encounter_check")){
			
			String packageCodeList=request.getParameter("packageCodeList");
			boolean isAcrossEncounter=false;
			StringTokenizer stPackageDetails=new StringTokenizer(packageCodeList,"|"); 
			while(stPackageDetails.hasMoreTokens()){
				
				String acrossEncounterLogic="N";
				PreparedStatement pstmtChrg = con.prepareStatement("select ACROSS_ENCOUNTER_YN from bl_package where PACKAGE_CODE=?");
				pkgCode=stPackageDetails.nextToken();
				pstmtChrg.setString(1,pkgCode);
				ResultSet	rsChrg = pstmtChrg.executeQuery() ;
				if(rsChrg.next())	{ 
					
						acrossEncounterLogic = rsChrg.getString(1);
						if(acrossEncounterLogic==null){
							acrossEncounterLogic="N";
						}	
						
						if(acrossEncounterLogic.equals("N")){
							isAcrossEncounter=false;
							break;
						}						
						isAcrossEncounter=true;						
				}
				if (rsChrg != null) rsChrg.close();
				if (pstmtChrg != null) pstmtChrg.close();					
			}
			if(isAcrossEncounter==true){
			System.out.println("SUCCESS_ACROSS_ENCOUNTER PKG_CODE:"+pkgCode);
			out.println("SUCCESS_ACROSS_ENCOUNTER");
			}else{
			System.out.println("FAILURE_ACROSS_ENCOUNTER PKG_CODE:"+pkgCode);
			out.println("FAILURE_ACROSS_ENCOUNTER");
			}
		}
		if(action.equals("submit")){
				Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
				hash = (Hashtable) hash.get("SEARCH");
				int totalRecords=Integer.parseInt((String)hash.get("totalRecords"));
				String patientId=(String)hash.get("patientId");
				//Added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622 Starts
				String package_seq_no=(String)hash.get("package_seq_no");
				if(package_seq_no==null) package_seq_no="";
				String packageCodeList=(String)hash.get("packageCodeList");
				if(packageCodeList==null) packageCodeList="";
				String eff_from_date=(String)hash.get("eff_from_date");
				if(packageCodeList==null) packageCodeList="";
				String function_id=(String)hash.get("function_id");
				if(function_id==null) function_id="";
				//Added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  Ends
				ArrayList<String> encounterCombinationArray=new ArrayList<String>();
				HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters=new HashMap<String,ArrayList<String>>();
		
				String encounterCombinationString="";
				for(int i=0;i<totalRecords;i++){
				boolean boolEncounterSelected=Boolean.parseBoolean((String)hash.get("selectEncounter"+i));
				if(boolEncounterSelected==true){
				String patientClass=(String)hash.get("alPatientClass"+i);
				if(patientClass.equals("OP")){
					patientClass = "O";		
				}else if(patientClass.equals("IP")){
					patientClass = "I";		
				}else if(patientClass.equals("DC")){
					patientClass = "D";		
				}else{
					patientClass = "E";
				}
				encounterCombinationString=patientClass+"|"+(String)hash.get("alEncounterId"+i)+"|"+(String)hash.get("alEpisodeId"+i)+"|"+(String)hash.get("alVisitId"+i);
				/* Below code added by palaniNarayanan  FOR PMG-COMMON-CFR-00076 on V210622  STRATS */
				if(!function_id.equals("EBL_TRAN_PACKAGE_MAINTAIN") || function_id.equals("") )
				{
					encounterCombinationArray.add(encounterCombinationString);
					
				}
				else
				{
					encounterCombinationString=encounterCombinationString+"|"+package_seq_no+"|"+packageCodeList+"|"+eff_from_date;
					encounterCombinationArray.add(encounterCombinationString);
							
				}
						
				}	
			packageSubscriptionAssociationEncounters.put(patientId, encounterCombinationArray);
		}
				/*  PMG-COMMON-CFR-00076 on V210622  Ends */
	
		session.setAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS", packageSubscriptionAssociationEncounters);
		encounterCombinationString = encounterCombinationString.replace("|","~~");
		out.println(encounterCombinationString);
		}
		if(action.equals("count")){	
			
			
			
			String patientId=request.getParameter("patId");
			ArrayList<String> encounterListArray=new ArrayList<String>();
						
		 	if(session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS")!=null){
				HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters=new HashMap<String,ArrayList<String>>();
				ArrayList<String> encounterCombinationArray=new ArrayList<String>();
				packageSubscriptionAssociationEncounters=(HashMap<String,ArrayList<String>>)session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
				encounterCombinationArray=packageSubscriptionAssociationEncounters.get(patientId);	
			//	System.out.println("encounterCombinationArray/patientId"+encounterCombinationArray+"/"+patientId);
				if(encounterCombinationArray==null){
					encounterCombinationArray=new ArrayList<String>();
				}		
				for(int encCount=0;encCount<encounterCombinationArray.size();encCount++){
				StringTokenizer stEncList=new StringTokenizer(encounterCombinationArray.get(encCount),"|");					
				String headerEpisodeType=stEncList.nextToken();
				String encounterId=stEncList.nextToken();
				encounterListArray.add(encounterId);
				}
				
			 //	System.out.println("encounterCombinationArray.size()"+encounterCombinationArray.size());

			} 
		 	
		 	
		 //	System.out.println("encounterListArray-size"+encounterListArray.size());
		 	if(encounterListArray.size() > 1){
		 		out.println("MULTIPLE_ENCOUNTER_SUCCESS");
		 		
		 	}
		 	else{
		 		out.println("MULTIPLE_ENCOUNTER_FAILURE");
		 	}

		}
		
		if(action.equals("clearSession")){
			System.err.println("Inside clear session");
			session.removeAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
			out.println("SUCCESS");
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception from PkgSubscriptionAssociationDtlsValidation.jsp :"+ e);
	}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
