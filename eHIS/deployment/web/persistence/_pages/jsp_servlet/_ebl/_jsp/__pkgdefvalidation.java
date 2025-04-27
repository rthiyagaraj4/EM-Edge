package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pkgdefvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgDefValidation.jsp", 1731483366895L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="   \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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


	private String checkForNull(String inputString) {
			return (inputString == null) ? "" : inputString;
		}
		
//V201010 Starts	
 private Hashtable parseXMLString1(String var1) {
      Hashtable var2 = new Hashtable();
      try {
		 Reader inputString = new StringReader(var1);
		 BufferedReader var3 = new BufferedReader(inputString);
         // BufferedReader var3 = var1.getReader();
         SAXBuilder var4 = new SAXBuilder();
         Document var5 = var4.build(var3);
         Element var6 = var5.getRootElement();
         ListIterator var7 = var6.getChildren().listIterator();

         while(var7.hasNext()) {
            Element var8 = (Element)var7.next();
            Hashtable var9 = new Hashtable();
            List var10 = var8.getAttributes();
            Iterator var11 = var10.iterator();
            while(var11.hasNext()) {
               Attribute var12 = (Attribute)var11.next();
               String var13 = var12.getValue().replace('"', '\n');
               var9.put(var12.getName(), var13);
            }
            var2.put(var8.getName(), var9);
         }
      } catch (Exception var14) {
		  System.err.println("error in parseXMLSStirng 1  "+var14.toString());
         var2.put("error", var14.toString());
      }
      return var2;
   }
//V201010Ends   


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

/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201010                         MMS-KH-SCF-108         Ram Kumar S
2			 V220331  						 GHL-SCF-1635			Nandhini
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	String bean_id		= "bl_PkgDefBean" ;
	String bean_name	= "eBL.PkgDefBean";
	PkgDefBean bean			= (PkgDefBean)getBeanObject( bean_id, bean_name, request ) ;

	String bean_id1		= "bl_PkgDefCustBean" ;
	String bean_name1	= "eBL.PkgDefCustBean";
	PkgDefCustBean bean1	= (PkgDefCustBean)getBeanObject( bean_id1, bean_name1, request ) ;	

	String bean_id2		= "bl_PkgDefDiscountBean" ;
	String bean_name2	= "eBL.PkgDefDiscountBean";
	PkgDefDiscountBean bean2 = (PkgDefDiscountBean)getBeanObject( bean_id2, bean_name2, request);
	//Added By Shikha For GHL-CRF-0520.1
	String bean_id3		= "bl_PkgDefBlngGrpBean" ;
	String bean_name3	= "eBL.PkgDefBlngGrpBean";
	PkgDefBlngGrpBean bean3= (PkgDefBlngGrpBean)getBeanObject( bean_id3, bean_name3, request ) ;	
	//Ended By Shikha For GHL-CRF-0520.1
	
	Connection con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	PreparedStatement pstmtVAT = null;//073588
	ResultSet rsVAT = null;//073588
	ResultSet rs = null;
	ResultSet rs1 = null;
	String splitReqdChk = ""; //Rajesh V - Split Reqd
	String includeHomeMedicationChk = ""; 
	String enableDisParam = "";
	String enableDisParamChk=""; //sarathkumar InclHmeMedi
try {
	request.setCharacterEncoding("UTF-8");
	//GHL-CRF-0502 Starts
	boolean SiteAgeSpecialty = false;
	SiteAgeSpecialty = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","AGE_SPECIALITY_APP_FOR_DISC");
	//GHL-CRF-0502 Ends
	String locale			= (String)session.getAttribute("LOCALE");
	String func_mode			= request.getParameter("func_mode");
//V201010 Starts
	String xmlValues=checkForNull(request.getParameter("xmlStr"));
	String mainParameters=checkForNull(request.getParameter("newMainParams"));
	System.err.println("pkgdefvalidation xmlValues=>"+xmlValues);
	System.err.println("pkgdefvalidation mainParameters=>"+mainParameters);
	
//V201010 Ends
	String event			= (request.getParameter("event")==null? "":request.getParameter("event"));
	//Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	Hashtable hash				= (Hashtable)parseXMLString1( xmlValues ) ;//V201010 Added
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	bean.setLanguageId(locale);	
	//V201010 Starts
	String paramName ="";
	String paramValue ="";
	if(mainParameters!= null && !mainParameters.equals("")){
		System.err.println("102, inside BLNG_GRP_PRICE");
	//String[] p=mainParameters.split("&");
	String[] p=mainParameters.split( "\" ");//added by Nandhini against GHL-SCF-1635
	for (String s: p) {    
		System.err.println("Splititng iterating &  "+s);	
		if(s!= null && !s.equals("")){
			String[] arrOfStr = s.split("=");		
			if(arrOfStr.length==2){
				paramName = arrOfStr[0];
				paramValue =arrOfStr[1];//.replace("\\|","");
				System.err.println("102, inside paramName "+paramName +" /paramValue=>"+paramValue);
				hash.put(paramName,paramValue);
			}else{
				paramName = arrOfStr[0];
				paramValue ="";
				System.err.println("116, inside paramName "+paramName +" /paramValue=>"+paramValue);
				hash.put(paramName,paramValue);
			}
		}
	}
	}
	//V201010 Ends
	/*Added By Dharma inserting all the parameters into the Hashtable variable hash to avoid system error in Javascript - MMS-KH-SCF-0051
	java.util.Enumeration params = request.getParameterNames();
	while(params.hasMoreElements()) {
		//String paramName = (String) params.nextElement();
		//String paramValue = request.getParameter(paramName);
		 paramName = (String) params.nextElement();
		 paramValue = request.getParameter(paramName);
		hash.put(paramName,paramValue);
	}
	//Added by Dharma against MMS-KH-SCF-051 on 16-Mar-20*/

	String	packageCode	= (String) hash.get( "packageCode" );	
	String  facilityId		= (String) session.getValue( "facility_id" ) ;
	String	loggedInUser	=  (String) session.getValue("login_user");	
	String	mode		= (String) hash.get( "mode" );	
	int count=0;
	System.err.println("func_mode-->"+func_mode);
	if(func_mode!= null && func_mode.equals("PACKAGE"))
	{
		String longDesc 		=	(String) hash.get( "longDesc");
		String shortDesc 		=	(String) hash.get( "shortDesc" );
		String effFromDate		=	(String) hash.get( "effFromDate" );
		String effToDate		=	(String) hash.get( "effToDate" );
		String applSexInd 		=	(String) hash.get( "applSexInd" );		
		String minAgeInYrs		=	(String) hash.get( "minAgeInYrs" );
		String minAgeInMths		=	(String) hash.get( "minAgeInMths" );
		String minAgeInDays		=	(String) hash.get( "minAgeInDays" );
		String maxAgeInYrs		=	(String) hash.get( "maxAgeInYrs" );
		String maxAgeInMths		=	(String) hash.get( "maxAgeInMths" );
		String maxAgeInDays		=	(String) hash.get( "maxAgeInDays" );
		String OpYn				=	(String) hash.get( "OpYn" );
		String EmYn				=	(String) hash.get( "EmYn" );
		String IpYn				=	(String) hash.get( "IpYn" );
		String DcYn				=	(String) hash.get( "DcYn" );
		String AllYn			=   (String) hash.get( "AllYn" );
		String orderAssociated  =   (String) hash.get( "orderAssociated" );
		String acrossEncounters =   (String) hash.get( "acrossEncounters" );
		String applicalbleTo	=   (String) hash.get( "applicalbleTo" );
		String auto				=   (String) hash.get( "auto" );
		String validDays		=	(String) hash.get( "validDays" );
		String approvedYN	    =   (String) hash.get( "approvedYN" );
		String approvedBy	    =   (String) hash.get( "approvedBy" );
		String approvedDate	    =   (String) hash.get( "approvedDate" );
		//Added V190325 Gayathri/KDAH-CRF-0503/Starts
		String master_childPack	 =  (String) hash.get( "mast_pack" );
		System.err.println("master_childPack1-->"+master_childPack);
		bean.setPackageCode(packageCode);
		bean.setLongDesc(longDesc);
		bean.setShortDesc(shortDesc);
		bean.setEffFromDate(effFromDate);
		bean.setEffToDate(effToDate);
		bean.setApplSexInd(applSexInd);
		bean.setMinAgeInYrs(minAgeInYrs);
		bean.setMinAgeInMths(minAgeInMths);
		bean.setMinAgeInDays(minAgeInDays);
		bean.setMaxAgeInYrs(maxAgeInYrs);
		bean.setMaxAgeInMths(maxAgeInMths);
		bean.setMaxAgeInDays(maxAgeInDays);
		bean.setOpYn(OpYn);
		bean.setEmYn(EmYn);
		bean.setIpYn(IpYn);
		bean.setDcYn(DcYn);
		bean.setAllYn(AllYn);
		bean.setOrderAssociated(orderAssociated);
		bean.setAcrossEncounters(acrossEncounters);
		bean.setApplicalbleTo(applicalbleTo);
		bean.setAuto(auto);
		bean.setValidDays(validDays);
		bean.setApprovedYN(approvedYN);
		bean.setApprovedBy(approvedBy);
		bean.setApprovedDate(approvedDate);
		bean.setIsMasterPkgYn(master_childPack);//Added V190325 Gayathri/KDAH-CRF-0503	
		System.err.println("193");
	}
	else if(func_mode!= null && func_mode.equals("CHILD_PACK"))
	{
		HashMap childPackages	     =	new HashMap();
		HashMap childPackdtl	     =	new HashMap();
		String totRec			= (String) hash.get( "totRec" );
		String fromDate 			= (String) hash.get( "fromDate" );
		int totalRec					= Integer.parseInt(totRec);
		ArrayList dtlsArray	     =	new ArrayList();
		
		ArrayList child_pkgcode 		=	new ArrayList();
		ArrayList child_pkgdesc 		=	new ArrayList();
		ArrayList child_effFromDate		=	new ArrayList();
		ArrayList child_effToDate		=	new ArrayList();
		ArrayList flag					= new ArrayList();
		String childPkgCode				= "";
		String childPkgdesc				= "";
		String childEffFrom				= "";
		String childEffTo	 			= "";
		String flagVal					= "";
			
		for(int i=0; i<totalRec; i++)
		{			
			childPkgCode=(String) hash.get( "childPackCode_"+i);
			childPkgdesc=(String) hash.get( "childPackDesc_"+i);
			childEffFrom=(String) hash.get( "fromDate_"+i);
			childEffTo  =(String) hash.get( "toDate_"+i);
			flagVal =(String) hash.get( "flag_"+i );
			if(flagVal == null) flagVal="insert";
			if(!(childEffFrom.trim().equals("")))
			{
				child_pkgcode.add(childPkgCode);
				child_pkgdesc.add(childPkgdesc);
				child_effFromDate.add(childEffFrom);
				child_effToDate.add(childEffTo);
				flag.add(flagVal);				
			}
		
			if(child_effFromDate !=null && child_effFromDate.size()>0)
			{
				dtlsArray.add(child_pkgcode);
				dtlsArray.add(child_pkgdesc);
				dtlsArray.add(child_effFromDate);
				dtlsArray.add(child_effToDate);
				dtlsArray.add(flag);
				childPackdtl.put(fromDate,dtlsArray);
				childPackages.put(packageCode,childPackdtl);
				bean.setChildPackages(childPackages);			
			}		
		}		
	}	
	else if(func_mode!= null && func_mode.equals("PACKAGE_DATE"))
	{
		HashMap baseDates	     =	new HashMap();
		ArrayList dtlsArray	     =	new ArrayList();
		ArrayList priceFromDate	 =	new ArrayList();
		ArrayList priceToDate	 =	new ArrayList();
		ArrayList pkgPClsCode	 =	new ArrayList();
		ArrayList pkgPClsDesc	 =	new ArrayList();
		ArrayList oPkgPClsCode	 =	new ArrayList();
		ArrayList oPkgPClsDesc	 =	new ArrayList();
		ArrayList flag			=	new ArrayList();
		ArrayList glSmryList	 =	new ArrayList();
		ArrayList glSmryDescList	 =	new ArrayList();
		ArrayList glSmryDiscList	 =	new ArrayList();
		ArrayList glSmryDiscDescList	 =	new ArrayList();
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
		ArrayList VATappList	 =	new ArrayList();
		ArrayList VATpercentList	 =	new ArrayList();
		ArrayList VATappList_old	 =	new ArrayList();
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
		//ArrayList statusToModify		=	new ArrayList();//unused variable.
		String fromDate					= "";
		String toDate					= "";
		String pkgPriceClsCode	 = "";
		String pkgPriceClsDesc	 = "";
		String oPkgPriceClsCode	 = "";
		String oPkgPriceClsDesc	 = "";
		String flagVal					= "";
		String glSmry					= "";
		String glSmryDesc					= "";
		String glSmryDisc					= "";
		String glSmryDiscDesc					= "";
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
		String VATapplicable="";
		String VATapplicable_old="";
		String VATpercent="";
		//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
		//String statToModify				= "";//unused variable
		String totRec			= (String) hash.get( "totRec" );

		int totalRec					= Integer.parseInt(totRec);
		//int recCount					=	totalRec; //unused variable   
		HashMap existingPkgDates	     =	new HashMap();
		if(packageCode == null){
			existingPkgDates = bean.getExistingPackageDates(bean.getPackageCode(),facilityId,locale);
		}
		else{
			existingPkgDates = bean.getExistingPackageDates(packageCode,facilityId,locale);
		}
		
		for(int i=0; i<totalRec; i++)
		{
			packageCode = bean.getPackageCode();
			fromDate = (String) hash.get( "fromDate_"+i );
			toDate		=(String) hash.get( "toDate_"+i );
			pkgPriceClsCode  =(String) hash.get( "pkgPriceClsCode_"+i );
			pkgPriceClsDesc  =(String) hash.get( "pkgPriceClsDesc_"+i );
			oPkgPriceClsCode =(String) hash.get( "oPkgPriceClsCode_"+i );
			oPkgPriceClsDesc =(String) hash.get( "oPkgPriceClsDesc_"+i );
			flagVal =(String) hash.get( "flag_"+i );
			glSmry =(String) hash.get( "glSmry"+i );
			glSmryDesc =(String) hash.get( "glSmryDesc"+i );
			glSmryDisc =(String) hash.get( "glSmryDisc"+i );
			glSmryDiscDesc =(String) hash.get( "glSmryDiscDesc"+i );
			//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
			VATapplicable=(String) hash.get( "VATapp"+i );
			VATpercent =(String) hash.get( "VATpercent"+i );
			VATapplicable_old =(String) hash.get( "VATapp1"+i );
			//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
			//statToModify =(String) hash.get( "statToModify_"+i );
			if(!(fromDate.trim().equals("")))
			{				
				priceFromDate.add(fromDate);
				priceToDate.add(toDate);
				pkgPClsCode.add(pkgPriceClsCode);
				pkgPClsDesc.add(pkgPriceClsDesc);
				oPkgPClsCode.add(oPkgPriceClsCode);
				oPkgPClsDesc.add(oPkgPriceClsDesc);
				flag.add(flagVal);
				glSmryList.add(glSmry);
				glSmryDescList.add(glSmryDesc);
				glSmryDiscList.add(glSmryDisc);
				glSmryDiscDescList.add(glSmryDiscDesc);
				//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
				VATappList.add(VATapplicable);
				VATpercentList.add(VATpercent);
				VATappList_old.add(VATapplicable_old);

				//statusToModify.add(statToModify);
			//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends
			}
		}
		if(priceFromDate !=null && priceFromDate.size()>0)
		{
			dtlsArray.add(priceFromDate);
			dtlsArray.add(priceToDate);
			dtlsArray.add(pkgPClsCode);
			dtlsArray.add(pkgPClsDesc);
			dtlsArray.add(oPkgPClsCode);
			dtlsArray.add(oPkgPClsDesc);
			dtlsArray.add(flag);
			dtlsArray.add(glSmryList);
			dtlsArray.add(glSmryDescList);
			dtlsArray.add(glSmryDiscList);
			dtlsArray.add(glSmryDiscDescList);
			dtlsArray.add(VATappList);
			dtlsArray.add(VATpercentList);
			dtlsArray.add(VATappList_old);
			//dtlsArray.add(statusToModify);
			baseDates.put(packageCode,dtlsArray);
			bean.setBaseDates(baseDates);
		}
	}
	else if(func_mode!= null && func_mode.equals("PACKAGE_PRICE"))
	{
		HashMap basePrice				= bean.getBasePrice();
		HashMap basePriceDtls			= new HashMap();
		ArrayList dtlsArray				= new ArrayList();
		ArrayList blgClsCodeGrp	        = new ArrayList();
		ArrayList blgClsDescGrp			= new ArrayList();
		ArrayList indicatorGrp			= new ArrayList();
		ArrayList price					= new ArrayList();
		ArrayList roundToGrp			= new ArrayList();
		ArrayList roundIndGrp			= new ArrayList();
		ArrayList factorApplGrp			= new ArrayList();
		ArrayList flag					= new ArrayList();
		ArrayList depositGrp			= new ArrayList();
		ArrayList partialDepGrp			= new ArrayList();
		ArrayList minDepAmtindGrp		= new ArrayList();
		ArrayList minDepAmtGrp			= new ArrayList();
		ArrayList factorforServiceRateGrp	 =	new ArrayList();//Added by muthu for Factor for service rate issue for KDAH 22-6-12
		 		   
		String blgClsCode		= "";
		String blgClsDesc		= "";
		String indicator		= "";
		String price1			= "";
		String roundTo			= "";
		String roundInd			= "";
		String factorAppl		= "";
		String flagVal			= "";
		String deposit			= "";
		String partialDeposit	= "";
		String minDepAmtind		= "";
		String minDepAmt		= "";
		String factorforServiceRate ="";//Added by muthu for Factor for service rate issue for KDAH on 22-6-12
		String	total_records	= (String) hash.get( "total_records" );
		String fromDate			= (String) hash.get( "fromDate" );
		String custCode = (String) hash.get( "custCode" );
		custCode = custCode == null ?"":custCode;
		int totalRec					= Integer.parseInt(total_records);
	//	int recCount					=	totalRec; //unused variable
		for(int i=0; i<totalRec; i++)
		{
			blgClsCode = (String) hash.get( "blgClsCode_"+i );
			blgClsDesc		=(String) hash.get( "blgClsDesc_"+i );
			indicator  =(String) hash.get( "indicator_"+i );
			price1  =(String) hash.get( "price_"+i );
			roundTo = (String) hash.get( "roundTo_"+i );

			roundInd		=(String) hash.get( "roundInd_"+i );
			factorAppl =(String) hash.get( "factorAppl_"+i );
			factorAppl = (factorAppl == null || factorAppl.equals("")) ? "N" : factorAppl;
			flagVal =(String) hash.get( "flag_"+i );

			deposit		=(String) hash.get( "deposit_"+i );
			partialDeposit		=(String) hash.get( "partialDeposit_"+i );
			minDepAmtind		=(String) hash.get( "minDepAmtind_"+i );
			minDepAmt		=(String) hash.get( "minDepAmt_"+i );
			factorforServiceRate =(String) hash.get( "factorforServiceRate"+i );//Added by muthu for Factor for service rate issue for KDAH on 22-6-12

			//statToModify =(String) hash.get( "statToModify_"+i );
			if(!(blgClsCode.trim().equals("") || price1.trim().equals("")))
			{				
				blgClsCodeGrp.add(blgClsCode);
				blgClsDescGrp.add(blgClsDesc);
				indicatorGrp.add(indicator);
				price.add(price1);
				roundToGrp.add(roundTo);
				roundIndGrp.add(roundInd);
				factorApplGrp.add(factorAppl);
				flag.add(flagVal);
				depositGrp.add(deposit);
				partialDepGrp.add(partialDeposit);
				minDepAmtindGrp.add(minDepAmtind);
				minDepAmtGrp.add(minDepAmt);
				factorforServiceRateGrp.add(factorforServiceRate);//Added by muthu for Factor for service rate issue for KDAH on 22-6-12
			}
		}
		if(blgClsCodeGrp.size()>0)
		{
			dtlsArray.add(blgClsCodeGrp);
			dtlsArray.add(blgClsDescGrp);
			dtlsArray.add(indicatorGrp);
			dtlsArray.add(price);
			dtlsArray.add(roundToGrp);
			dtlsArray.add(roundIndGrp);
			dtlsArray.add(factorApplGrp);
			dtlsArray.add(flag);
			dtlsArray.add(depositGrp);
			dtlsArray.add(partialDepGrp);
			dtlsArray.add(minDepAmtindGrp);
			dtlsArray.add(minDepAmtGrp);
			dtlsArray.add(factorforServiceRateGrp);//Added by muthu for Factor for service rate issue for KDAH on 22-6-12

			//dtlsArray.add(statusToModify);
			if(custCode.equals(""))
			{
				if(basePrice.containsKey(packageCode))
				{
					basePriceDtls = (HashMap)basePrice.get(packageCode);
					if(basePriceDtls.containsKey(fromDate))
						basePriceDtls.remove(fromDate);
				}
				basePriceDtls.put(fromDate,dtlsArray);
				basePrice.put(packageCode,basePriceDtls);
			}
			 else
			{
				if(basePrice.containsKey(custCode))
				{
					basePriceDtls = (HashMap)basePrice.get(custCode);
					if(basePriceDtls.containsKey(fromDate))
						basePriceDtls.remove(fromDate);
				}
				basePriceDtls.put(fromDate,dtlsArray);
				basePrice.put(custCode,basePriceDtls);
			}
			bean.setBasePrice(basePrice);
		}	
	}
	else if(func_mode != null && func_mode.equals("RATE_BASED" ) )
	{
		if(event.equals("delete"))	 bean.setDeletedStatusRB("Y");
		String fromDate 			=	(String) hash.get( "fromDate" );
		String closePkg = "N";
		ArrayList	type	    =	new ArrayList();
		ArrayList	service_code	    =	new ArrayList();
		ArrayList	service_desc	    =	new ArrayList();
		ArrayList	catalog_code		    =	new ArrayList();
		ArrayList	catalog_desc		    =	new ArrayList();
		ArrayList	ind		    =	new ArrayList();
		ArrayList	factorOrRate    =	new ArrayList();
		ArrayList	qty_limit    =	new ArrayList();
		ArrayList	amt_limit_ind    =	new ArrayList();
		ArrayList	amt_limit    =	new ArrayList();
		//ArrayList	unlimited    =	new ArrayList();
		ArrayList	replace    =	new ArrayList();
		ArrayList	replaceSrv_code    =	new ArrayList();
		ArrayList	replaceSrv_desc    =	new ArrayList();
		ArrayList	replaceSrv_cat_code    =	new ArrayList();
		ArrayList	replaceSrv_cat_desc    =	new ArrayList();
		ArrayList	refund    =	new ArrayList();
		ArrayList	refundAmt    =	new ArrayList();	
		ArrayList	factor_appl    =	new ArrayList();	
		ArrayList	service_limit    =	new ArrayList();
		ArrayList	auto_refund_list =	new ArrayList();
		ArrayList	roundTo_list  =	new ArrayList();
		ArrayList	roundInd_list  =	new ArrayList();
		ArrayList	closePkg_list    =	new ArrayList();
		HashMap includedItems_RB    =   new HashMap();
		HashMap includedItemsFD_RB    =   new HashMap();
		 //Rajesh V - Split Reqd
		ArrayList split_reqd_list = new ArrayList();
		//Rajesh V - Split Reqd		
		
		ArrayList includeHomeMedication_list = new ArrayList(); //sarathkumar InclHmeMedi
		ArrayList enableDisParam_list = new ArrayList(); //sarathkumar InclHmeMedi
		
		ArrayList dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		ArrayList dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		ArrayList serv_grp_limit_ind =	new ArrayList(); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020 
		includedItems_RB    =  bean.getIncludedItems_RB();
		
		String	totalRecords		=	(String) hash.get( "totalRecords" );
		HashMap excludedItems_RB    =   new HashMap();	
		HashMap excludedItemsFD_RB    =   new HashMap();
		excludedItems_RB = bean.getExcludedItems_RB();
		if(excludedItems_RB.size()>0)
		{
			excludedItemsFD_RB = (HashMap)excludedItems_RB.get(fromDate);
		}

		ArrayList includedItems_RBD =	new ArrayList();
		int totalRec				=	Integer.parseInt(totalRecords);
		String sCode = "";
		String replaceChk = "";
		for(int i=0;i<totalRec; i++)
		{
	   	   sCode = (String) hash.get( "service_code"+i );
		   if(sCode!=null && !sCode.equals(""))
		   {
			   type.add((String) hash.get( "type"+i ));
			   service_code.add((String) hash.get( "service_code"+i ));
			   service_desc.add((String) hash.get( "service_desc"+i ));
   			   catalog_code.add((String) hash.get( "catalog_code"+i ));
			   catalog_desc.add((String) hash.get( "catalog_desc"+i ));
			   ind.add((String) hash.get( "ind"+i ));
			   factorOrRate.add((String) hash.get( "factorOrRate"+i ));
			   qty_limit.add((String) hash.get( "qty_limit"+i ));
			   amt_limit_ind.add((String) hash.get( "amt_limit_ind"+i ));
			   amt_limit.add((String) hash.get( "perAmt_limit"+i ));
			   replace.add((String) hash.get( "replace"+i ));
			   replaceChk = (String) hash.get( "replace"+i );
			   if(replaceChk == null || replaceChk.equals("") || replaceChk.equals("N"))
			   {
					replaceSrv_code.add("");
					replaceSrv_desc.add("");
					replaceSrv_cat_code.add("");
					replaceSrv_cat_desc.add("");
			   }
			   else
			   {
					replaceSrv_code.add((String) hash.get( "replaceSrv_code"+i ));
					replaceSrv_desc.add((String) hash.get( "replaceSrv_desc"+i ));
					replaceSrv_cat_code.add((String) hash.get( "replaceSrv_cat_code"+i ));
					replaceSrv_cat_desc.add((String) hash.get( "replaceSrv_cat_desc"+i ));
			   }
			   refund.add((String) hash.get( "refund"+i ));
			   refundAmt.add(((String) hash.get( "refundAmt"+i ))==null?"":((String) hash.get( "refundAmt"+i )));
			   factor_appl.add((String) hash.get( "factor_appl"+i ));
			   service_limit.add((String) hash.get( "service_limit"+i ));
			   
			   auto_refund_list.add((String) hash.get( "autoRefund"+i ));
			   roundTo_list.add((String) (hash.get( "roundTo"+i )== null ?"":hash.get( "roundTo"+i) ));
			   roundInd_list.add((String) (hash.get( "roundInd"+i )==null ?"":hash.get( "roundInd"+i )));
			   closePkg	= (String) hash.get( "closePkg"+i );
			   closePkg = (closePkg.equals("off") || closePkg == null) ? "N" : (closePkg.equals("on") ? "Y" : closePkg );
			   closePkg_list.add(closePkg);
				//Rajesh V - Split Reqd
				
				splitReqdChk = (String) hash.get("split_reqd"+i);
				if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
					splitReqdChk = "Y";
				}
				else{
					splitReqdChk = "N";
				}
				split_reqd_list.add(splitReqdChk);
				//Rajesh V - Split Reqd
				
				 //sarathkumar InclHmeMedi
				includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
				if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
					includeHomeMedicationChk = "Y";
				}
				else{
					includeHomeMedicationChk = "N";
				}
				includeHomeMedication_list.add(includeHomeMedicationChk);
				
				 //sarathkumar InclHmeMedi
				enableDisParamChk = (String) hash.get("enableDisParam"+i);
				if("on".equals(enableDisParamChk) || "Y".equals(enableDisParamChk)){
					enableDisParamChk = "Y";
				}
				else{
					enableDisParamChk = "N";
				}
				enableDisParam_list.add(enableDisParamChk);
				
				/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
				String dailyLmtChk = (String) hash.get("dailyLmtChkBx"+i);
				if("on".equals(dailyLmtChk) || "Y".equals(dailyLmtChk)){
					dailyLmtChk = "Y";
				}
				else{
					dailyLmtChk = "N";
				}
				dailyLmtChkBxList.add(dailyLmtChk);
				dailyLmtAmtList.add((String) hash.get("dailyLmtAmt"+i));
				dailyLmtGrossNetList.add((String) hash.get("dailyLmtGrossNetList"+i));
				/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
				String dailyLmtIndicator = (String) hash.get("dailyLmtIndicator"+i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				if("*".equals(dailyLmtIndicator)){
					dailyLmtIndicator = "";
				}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				dailyLmtIndicatorList.add(dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				dailyLmtQtyList.add((String) hash.get("dailyLmtQty"+i));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				serv_grp_limit_ind.add((String) hash.get( "serv_grp_limit_ind"+i )); //Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
		   }
		}

		if(service_code.size()>0)
		{
			includedItems_RBD.add(type)	;
			includedItems_RBD.add(service_code);
			includedItems_RBD.add(service_desc)	;
			includedItems_RBD.add(catalog_code)	;
			includedItems_RBD.add(catalog_desc);
			includedItems_RBD.add(ind);
			includedItems_RBD.add(factorOrRate);
			includedItems_RBD.add(qty_limit);
			includedItems_RBD.add(amt_limit_ind);
			includedItems_RBD.add(amt_limit);
			includedItems_RBD.add(replace);			
			includedItems_RBD.add(replaceSrv_code);
			includedItems_RBD.add(replaceSrv_desc);
			includedItems_RBD.add(replaceSrv_cat_code);
			includedItems_RBD.add(replaceSrv_cat_desc);
			includedItems_RBD.add(refund);
			includedItems_RBD.add(refundAmt);
			includedItems_RBD.add(factor_appl);
			includedItems_RBD.add(service_limit);
			includedItems_RBD.add(auto_refund_list);
			includedItems_RBD.add(roundTo_list);
			includedItems_RBD.add(roundInd_list);
			includedItems_RBD.add(closePkg_list);
			//Rajesh V - Split Reqd
			includedItems_RBD.add(split_reqd_list);
			//Rajesh V - Split Reqd
			
			includedItems_RBD.add(includeHomeMedication_list); //sarathkumar InclHmeMedi
			includedItems_RBD.add(enableDisParam_list); //sarathkumar InclHmeMedi
			
			includedItems_RBD.add(dailyLmtChkBxList);//Added V190320-Aravindh/MMS-DM-CRF-0129
			includedItems_RBD.add(dailyLmtAmtList);//Added V190320-Aravindh/MMS-DM-CRF-0129
			includedItems_RBD.add(dailyLmtGrossNetList);//Added V190320-Aravindh/MMS-DM-CRF-0129
			includedItems_RBD.add(dailyLmtIndicatorList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			includedItems_RBD.add(dailyLmtQtyList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			includedItems_RBD.add(serv_grp_limit_ind);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
			if(includedItems_RB.containsKey(packageCode))
			{
				includedItemsFD_RB =(HashMap)includedItems_RB.get(packageCode);
				if(includedItemsFD_RB.size()>0 && includedItemsFD_RB.containsKey(fromDate))
				{
					ArrayList servicesDB =  new ArrayList();
					ArrayList serviceGroupDB =  new ArrayList();
					servicesDB =(ArrayList)includedItemsFD_RB.get(fromDate);
					if(servicesDB.size()>0)
					{
						serviceGroupDB		= (ArrayList)servicesDB.get(1);
						if(serviceGroupDB!= null && serviceGroupDB.size()>0)
						{
							for(int j=0; j<serviceGroupDB.size(); j++)
							{
								sCode = (String)serviceGroupDB.get(j); 
								if(!(service_code.contains(sCode)))
								{
									bean.setModifyRateBased("Y");
									if(mode !=null && mode.equals("modify") && (excludedItemsFD_RB == null || !excludedItemsFD_RB.containsKey(sCode)|| excludedItemsFD_RB.size()<=0) )
									{
										bean.setDBValues("SRVLIMIT_RATE_BASED",packageCode,locale,facilityId,sCode,"",fromDate);//set database values to bean.
									}
					
									if(excludedItemsFD_RB.size()>0 && (excludedItemsFD_RB.containsKey(sCode)))
									{
										bean.setModifyRateSrvLimits("Y");
										excludedItemsFD_RB.remove(sCode);
									}
								}
							}
							if(excludedItemsFD_RB.size()>0)
							excludedItems_RB.put(fromDate,excludedItemsFD_RB);		
						}
					}
				}
				includedItems_RB.remove(packageCode);
			}
			if(includedItems_RBD!=null && includedItems_RBD.size()>0)
			includedItemsFD_RB.put(fromDate,includedItems_RBD);
			else  includedItemsFD_RB.remove(fromDate);
			if(includedItemsFD_RB!=null && includedItemsFD_RB.size()>0)
			includedItems_RB.put(packageCode,includedItemsFD_RB);
			else  includedItems_RB.remove(packageCode);
			bean.setIncludedItems_RB(includedItems_RB);
			bean.setExcludedItems_RB(excludedItems_RB);
		}
		else  if(includedItems_RB.containsKey(packageCode))
		{
			includedItemsFD_RB =(HashMap)includedItems_RB.get(packageCode);
			if(includedItemsFD_RB.size()>0 && includedItemsFD_RB.containsKey(fromDate))
			{
				//ArrayList serviceGroup = new ArrayList();//unused variable
				ArrayList serviceCodeRB = new ArrayList();
				serviceCodeRB =(ArrayList)includedItemsFD_RB.get(fromDate);
				bean.setModifyRateBased("Y");
				includedItemsFD_RB.remove(fromDate);
				if(excludedItems_RB!=null && excludedItems_RB.containsKey(fromDate))
				{
					excludedItems_RB.remove(fromDate);
					bean.setModifyRateSrvLimits("Y");
				}
				if(includedItemsFD_RB.size()>0)
					includedItems_RB.put(packageCode,includedItemsFD_RB);
				else
					includedItems_RB.remove(packageCode);
			}
			bean.setExcludedItems_RB(excludedItems_RB);
			bean.setIncludedItems_RB(includedItems_RB);
		}
	}
	else if(func_mode != null && func_mode.equals("SRVLIMIT_RATE_BASED" ) )
	{
		if(event.equals("delete"))	 bean.setDeletedStatusRBLt("Y");
		bean.setModifyRateSrvLimits("Y");
		//String parent_type          = 	(String)hash.get("parent_type");//unused variable
		String parent_service_code  = 	(String)hash.get("parent_service_code");
		//String fromDate				=  	(String)hash.get("fromDateNew"); 
		
		String fromDate=request.getParameter("fromDateNew");
		if((fromDate==null || ("").equals(fromDate))){
			fromDate				=  	(String)hash.get("fromDate");  	
		}
		String newDate=request.getParameter("newDate");
		
		ArrayList	srvLimit_type	    =	new ArrayList();
		ArrayList	srvLimit_service_code	    =	new ArrayList();
		ArrayList	srvLimit_service_desc	    =	new ArrayList();
		ArrayList	exludeService		    =	new ArrayList();
		ArrayList	srvLimit_qty_limit		    =	new ArrayList();
		ArrayList	srvLimit_amt_limit    =	new ArrayList();
		ArrayList	srvLimit_factor_appl    =	new ArrayList();
		ArrayList   amt_limit_ind_list			=	new ArrayList();
		ArrayList	srvLimit_replace_list				=	new ArrayList();
		ArrayList	srvLimit_replaceSrv_code_list		=	new ArrayList();
		ArrayList   srvLimit_refund_list					=	new ArrayList();
		ArrayList   srvLimit_refundAmt_list				=	new ArrayList();
		ArrayList   srvLimit_auto_refund_list			=	new ArrayList();
		ArrayList	 srvLimit_roundTo_list  =	new ArrayList();
		ArrayList	 srvLimit_roundInd_list  =	new ArrayList();
		ArrayList	srvLimit_replaceSrv_desc_list		=	new ArrayList();
		//Rajesh V - Split Reqd
		ArrayList split_reqd_list = new ArrayList();
		//Rajesh V - Split Reqd
		
		ArrayList includeHomeMedication_list = new ArrayList(); //sarathkumar InclHmeMedi
		ArrayList enableDisParam_list = new ArrayList(); //sarathkumar InclHmeMedi
		ArrayList dailyLmtChkBxList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtAmtList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtGrossNetList = new ArrayList();//Added V190320-Aravindh/MMS-DM-CRF-0129
		ArrayList dailyLmtIndicatorList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		ArrayList dailyLmtQtyList = new ArrayList();//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		
		HashMap excludedItems_RB    =   new HashMap();			
		HashMap excludedItemsFD_RB  =   new HashMap();	
		excludedItems_RB = bean.getExcludedItems_RB();
	   	if(excludedItems_RB.get(fromDate)!=null)
		{
			excludedItemsFD_RB = (HashMap)excludedItems_RB.get(fromDate);
		}
		
		String	totalRecords		=	(String) hash.get( "totalRecords" );
		int totalRec				=	Integer.parseInt(totalRecords);
		ArrayList excludedItems_RBD =	new ArrayList();	
		String sCode = "";
		for(int i=0;i<totalRec; i++)
		{
		   sCode = (String) hash.get( "srvLimit_service_code"+i );
		   if(sCode!=null && !sCode.equals(""))
		   {
			   srvLimit_type.add((String) hash.get( "srvLimit_type"+i ));
			   srvLimit_service_code.add((String) hash.get( "srvLimit_service_code"+i ));
			   srvLimit_service_desc.add((String) hash.get( "srvLimit_service_desc"+i ));
	   		   exludeService.add((String) hash.get( "exludeService"+i ));
			   srvLimit_qty_limit.add((String) hash.get( "srvLimit_qty_limit"+i ));
			   srvLimit_amt_limit.add((String) hash.get( "srvLimit_amt_limit"+i ));	
			   srvLimit_factor_appl.add((String) hash.get( "srvLimit_factor_appl"+i ));	
			   amt_limit_ind_list.add((String) hash.get( "srvLimit_amt_limit_ind"+i ));			
			   srvLimit_replace_list.add((String) hash.get( "srvLimit_replace"+i ));				
			   srvLimit_replaceSrv_code_list.add((String) hash.get( "srvLimit_replaceSrv_code"+i ));		
				srvLimit_refund_list.add((String) hash.get( "srvLimit_refund"+i ));					
				srvLimit_refundAmt_list.add(((String) hash.get( "srvLimit_refundAmt"+i )==null?"":((String) hash.get( "srvLimit_refundAmt"+i ))));				
				srvLimit_auto_refund_list.add((String) hash.get( "srvLimit_autoRefund"+i ));	
				
				srvLimit_roundTo_list.add((String)( hash.get( "srvLimit_roundTo"+i )==null?"":hash.get( "srvLimit_roundTo"+i )));
							
			    srvLimit_roundInd_list.add((String) (hash.get( "srvLimit_roundInd"+i )==null?"":hash.get( "srvLimit_roundInd"+i )));
				srvLimit_replaceSrv_desc_list.add((String) hash.get( "srvLimit_replaceSrv_desc"+i ));	
				//Rajesh V - Split Reqd
				splitReqdChk = (String) hash.get("split_reqd"+i);
				if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
					splitReqdChk = "Y";
				}
				else{
					splitReqdChk = "N";
				}
				split_reqd_list.add(splitReqdChk);
				//Rajesh V - Split Reqd
				
				//sarathkumar InclHmeMedi
				includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
				if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
					includeHomeMedicationChk = "Y";
				}
				else{
					includeHomeMedicationChk = "N";
				}
				includeHomeMedication_list.add(includeHomeMedicationChk);				
				
				//sarathkumar InclHmeMedi
				enableDisParamChk = (String) hash.get("enableDisParam"+i);
				if("on".equals(enableDisParamChk) || "Y".equals(enableDisParamChk)){
					enableDisParamChk = "Y";
				}
				else{
					enableDisParamChk = "N";
				}
				enableDisParam_list.add(enableDisParamChk); 
				
			//Added V190320-Aravindh/MMS-DM-CRF-0129/Starts 
				String dailyLmtChk = (String) hash.get("dailyLmtChkBx"+i);
				if("on".equals(dailyLmtChk) || "Y".equals(dailyLmtChk)){
					dailyLmtChk = "Y";
				}
				else{
					dailyLmtChk = "N";
				}
				dailyLmtChkBxList.add(dailyLmtChk);
				dailyLmtAmtList.add((String) hash.get("dailyLmtAmt"+i));
				dailyLmtGrossNetList.add((String) hash.get("dailyLmtGrossNetList"+i));
				//Added V190320-Aravindh/MMS-DM-CRF-0129/Ends 
				String dailyLmtIndicator = (String) hash.get("dailyLmtIndicator"+i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				if("*".equals(dailyLmtIndicator)){
					dailyLmtIndicator = "Y";
				}//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				dailyLmtIndicatorList.add(dailyLmtIndicator);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				dailyLmtQtyList.add((String) hash.get("dailyLmtQty"+i));//Added V190626-Aravindh/MMS-DM-CRF-0129.1
		   }
		}		
		
		ArrayList serviceToChk = new ArrayList();
		if(excludedItemsFD_RB.size()>0)
		{			
			int recordCount = Integer.parseInt( (String)hash.get( "recordCount"));
			String sItem = "";
			
			//excludedItemsFD_RB = excludedItems_RB.get(fromDate); 
			java.util.Set serviceKey  =	(java.util.Set) excludedItemsFD_RB.keySet();
			for(int j=0; j<recordCount; j++)
			{
				serviceToChk.add((String) hash.get( "code_"+j ));
			}
		    Iterator Iter1 = serviceKey.iterator();
			while(Iter1.hasNext()) 
            {
				sItem = (java.lang.String)Iter1.next();
				if(!(serviceToChk.contains(sItem)))
					excludedItemsFD_RB.remove(sItem);
			}
		}
		
		
		if(srvLimit_service_code.size()>0)
		{
			excludedItems_RBD.add(srvLimit_type)	;
			excludedItems_RBD.add(srvLimit_service_code);
			excludedItems_RBD.add(srvLimit_service_desc);		
			excludedItems_RBD.add(exludeService);
			excludedItems_RBD.add(srvLimit_qty_limit);
			excludedItems_RBD.add(srvLimit_amt_limit);
			excludedItems_RBD.add(srvLimit_factor_appl);
			excludedItems_RBD.add(amt_limit_ind_list);
			excludedItems_RBD.add(srvLimit_replace_list);
			excludedItems_RBD.add(srvLimit_replaceSrv_code_list);
			excludedItems_RBD.add(srvLimit_refund_list);
			excludedItems_RBD.add(srvLimit_refundAmt_list);
			excludedItems_RBD.add(srvLimit_auto_refund_list);
			excludedItems_RBD.add(srvLimit_roundTo_list);
			excludedItems_RBD.add(srvLimit_roundInd_list);
			excludedItems_RBD.add(srvLimit_replaceSrv_desc_list);
			//Rajesh V - Split Reqd
			excludedItems_RBD.add(split_reqd_list);
			//Rajesh V - Split Reqd
			
			excludedItems_RBD.add(includeHomeMedication_list);//sarathkumar InclHmeMedi
			excludedItems_RBD.add(enableDisParam_list);//sarathkumar InclHmeMedi
			excludedItems_RBD.add(dailyLmtChkBxList);//Added V190320-Aravindh/MMS-DM-CRF-0129
			excludedItems_RBD.add(dailyLmtAmtList);//Added V190320-Aravindh/MMS-DM-CRF-0129
			excludedItems_RBD.add(dailyLmtGrossNetList);//Added V190320-Aravindh/MMS-DM-CRF-0129
			excludedItems_RBD.add(dailyLmtIndicatorList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			excludedItems_RBD.add(dailyLmtQtyList);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
			//if(excludedItemsFD_RB.containsKey(parent_service_code))
				//excludedItemsFD_RB.remove(parent_service_code);
			excludedItemsFD_RB.put(parent_service_code,excludedItems_RBD);
		}
		else if(excludedItemsFD_RB.containsKey(parent_service_code))
		{
			excludedItemsFD_RB.remove(parent_service_code);
		}
			
		if(excludedItemsFD_RB!=null && excludedItemsFD_RB.size()>0)
		{
			excludedItems_RB.put(fromDate,excludedItemsFD_RB);
		}
		else   excludedItems_RB.remove(fromDate);
			
			//excludedItems_RB.put(fromDate,excludedItemsFD_RB);
			bean.setExcludedItems_RB(excludedItems_RB);	
			bean.setNewDate(newDate);
	  		//System.out.println("new Date "+bean.getNewDate());
	}
	else if(func_mode != null && func_mode.equals("CHARGE_BASED" ) )
	{
		if(event.equals("delete"))	 bean.setDeletedStatusCB("Y");
		//String serviceCode          = 	(String)hash.get("serviceCode");
		ArrayList	charge_type_list  =	new ArrayList();//MuthuN against 28192
		ArrayList	serviceCode	    =	new ArrayList();
		ArrayList	serviceDesc	    =	new ArrayList();
		ArrayList	amtLmtInd		=	new ArrayList();
		ArrayList	amtLmt		    =	new ArrayList();
		//ArrayList	unlimited       =	new ArrayList();
		ArrayList	srvLmts         =	new ArrayList();
		ArrayList factorApplGroup	=	new ArrayList();
		ArrayList roundToGroup      =	new ArrayList();
		ArrayList roundIndGroup     =	new ArrayList();
		ArrayList	refund    =	new ArrayList();
		ArrayList	refundAmt    =	new ArrayList();	
		ArrayList	auto_refund_list =	new ArrayList();
		ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
		
		ArrayList 	includeHomeMedication_list = new ArrayList(); //sarathkumar InclHmeMedi
		ArrayList 	enableDisParam_list = new ArrayList(); //sarathkumar InclHmeMedi
		
		
		String 	 factorAppl = "N";
		HashMap includedItems_CB    =   new HashMap();
		String	total_records		=	(String) hash.get( "total_records" );
		String	fromDate		=	(String) hash.get( "fromDate" );
		includedItems_CB    =  bean.getIncludedItems_CB();
		HashMap includedItemsFD_CB =  new HashMap();
		HashMap excludedItems_CB    =   new HashMap();
		HashMap excludedItemsFD_CB    =   new HashMap();
		//HashMap excludedItemsSR_CB    =    new HashMap();
		excludedItems_CB = bean.getExcludedItems_CB();
		if(excludedItems_CB.size()>0)
		{
			excludedItemsFD_CB = (HashMap)excludedItems_CB.get(fromDate);
		}
		ArrayList includedItems_CBD =	new ArrayList();
		int totalRec				=	Integer.parseInt(total_records);
	  	String sCode = "";
		bean.setPackageCode(packageCode);
		for(int i=0;i<totalRec; i++)
		{
		   sCode = (String) hash.get( "cbCode_"+i );
		   if(sCode!=null && !sCode.equals(""))
		   {
			charge_type_list.add((String) hash.get( "charge_type"+i ));//MuthuN against 28192
			serviceCode.add((String) hash.get( "cbCode_"+i ));
			serviceDesc.add((String) hash.get( "cbDesc_"+i ));
   			amtLmtInd.add((String) hash.get( "amt_limit_ind"+i ));
			amtLmt.add((String) hash.get( "perAmt_limit"+i ));
			//unlimited.add((String) hash.get( "unlimited_"+i ));
			srvLmts.add((String) hash.get( "srvLmt_"+i ));
//			factorAppl =  (String) hash.get( "factorAppl_"+i );			
			factorAppl =  (String) hash.get( "factor_appl"+i );			
			factorAppl = (factorAppl==null || factorAppl.equals(""))? "N" :factorAppl;
			factorApplGroup.add(factorAppl);
			roundToGroup.add((String) hash.get( "roundTo_"+i ));
			roundIndGroup.add((String) hash.get( "roundInd_"+i ));
			refund.add((String) hash.get( "refund_"+i ));
			refundAmt.add((String) hash.get( "refundAmt_"+i ));
			auto_refund_list.add((String) hash.get( "autoRefund_"+i ));
			//Rajesh V - SPlit Reqd
			splitReqdChk = (String) hash.get("split_reqd"+i);
			if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
				splitReqdChk = "Y";
			}
			else{
				splitReqdChk = "N";
			}
			split_reqd_list.add(splitReqdChk);
			//Rajesh V - SPlit Reqd
			
			 //sarathkumar InclHmeMedi
			includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
			if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
				includeHomeMedicationChk = "Y";
			}
			else{
				includeHomeMedicationChk = "N";
			}
			includeHomeMedication_list.add(includeHomeMedicationChk); 
			
			//sarathkumar InclHmeMedi
			enableDisParamChk = (String) hash.get("enableDisParam"+i);
			if("on".equals(enableDisParamChk) || "Y".equals(enableDisParamChk)){
				enableDisParamChk = "Y";
			}
			else{
				enableDisParamChk = "N";
			}
			enableDisParam_list.add(enableDisParamChk); 
			
		  }
		}
		if(serviceCode.size()>0)
		{
			includedItems_CBD.add(charge_type_list)	;//MuthuN against 28192
			includedItems_CBD.add(serviceCode);
			includedItems_CBD.add(serviceDesc);
			includedItems_CBD.add(amtLmtInd);
			includedItems_CBD.add(amtLmt);
			//includedItems_CBD.add(unlimited);
			includedItems_CBD.add(srvLmts);
			includedItems_CBD.add(factorApplGroup);
			includedItems_CBD.add(roundToGroup);
			includedItems_CBD.add(roundIndGroup);
			includedItems_CBD.add(refund);
			includedItems_CBD.add(refundAmt);
			includedItems_CBD.add(auto_refund_list);
			includedItems_CBD.add(split_reqd_list);//Split Reqd 
			includedItems_CBD.add(includeHomeMedication_list); //sarathkumar InclHmeMedi
			includedItems_CBD.add(enableDisParam_list); //sarathkumar InclHmeMedi
			
			if(includedItems_CB.containsKey(packageCode))
			{
				includedItemsFD_CB = (HashMap)includedItems_CB.get(packageCode);
				if(includedItemsFD_CB.size()>0 && includedItemsFD_CB.containsKey(fromDate) )
				{		

				/* Removal logic  for excluded items */
				//String sItem = "";
				if(includedItemsFD_CB.size()>0)
				{			
					ArrayList servicesDB =  new ArrayList();
					ArrayList serviceGroupDB =  new ArrayList();
					servicesDB =(ArrayList)includedItemsFD_CB.get(fromDate);
					
					if(servicesDB.size()>0)
					{
						serviceGroupDB		= (ArrayList)servicesDB.get(0);
						if(serviceGroupDB!= null && serviceGroupDB.size()>0)
						{
							sCode = (String)serviceGroupDB.get(0); 
							if(!(serviceCode.contains(sCode)))
							{
								bean.setModifyChargeBased("Y");
								if(mode !=null && mode.equals("modify") && (excludedItemsFD_CB == null || !excludedItemsFD_CB.containsKey(sCode)|| excludedItemsFD_CB.size()<=0) )
								{
								System.out.println("Validation.jsp Charge_based 3");	bean.setDBValues("CHARGE_BASED_ITEM",packageCode,locale,facilityId,sCode,"",fromDate);//set database values to bean.
								}
					
								if(excludedItemsFD_CB.size()>0 && (excludedItemsFD_CB.containsKey(sCode)))
								{
									bean.setModifyChargeItems("Y");
									excludedItemsFD_CB.remove(sCode);
									excludedItems_CB.put(fromDate,excludedItemsFD_CB);
									//excludedItems_CB.put(fromDate,excludedItemsFD_CB);

								}
								bean.setExcludedItems_CB(excludedItems_CB);
							}
						}
					}
				}
				
				/* end Removal logic on modification */
				//includedItems_CB.remove(packageCode);
				includedItemsFD_CB.remove(fromDate);
				includedItemsFD_CB.put(fromDate,includedItems_CBD);
				includedItems_CB.put(packageCode,includedItemsFD_CB);
				bean.setIncludedItems_CB(includedItems_CB);				 
			} 
			else
				{
					includedItemsFD_CB.put(fromDate,includedItems_CBD);
					includedItems_CB.put(packageCode,includedItemsFD_CB);
				}
			}
			else
			{	 
				 includedItemsFD_CB.put(fromDate,includedItems_CBD);
				 includedItems_CB.put(packageCode,includedItemsFD_CB);
			}
		}
		else  if(includedItems_CB.containsKey(packageCode))
		{
			includedItemsFD_CB = (HashMap)includedItems_CB.get(packageCode);
			if(includedItemsFD_CB.size()>0 && includedItemsFD_CB.containsKey(fromDate) )
			{
				ArrayList serviceGroup = new ArrayList();
				ArrayList serviceCodes =(ArrayList)includedItemsFD_CB.get(fromDate);		  

		  if(serviceCodes.size()>0)
		  {
				serviceGroup	= (ArrayList)serviceCodes.get(1);
				//serviceGroup	= (ArrayList)serviceCodes.get(0);//Added by muthu
				sCode   		= (String)serviceGroup.get(0);
				bean.setModifyChargeBased("Y");
				if(mode !=null && mode.equals("modify") && (excludedItemsFD_CB == null || excludedItemsFD_CB.size()<=0 || !excludedItemsFD_CB.containsKey(sCode)) )
				{
					bean.setDBValues("CHARGE_BASED_ITEM",packageCode,locale,facilityId,sCode,"",fromDate);//set database values to bean.
				}
				if(excludedItemsFD_CB.size()>0 && (excludedItemsFD_CB.containsKey(sCode)))
				{
					bean.setModifyChargeItems("Y");
					excludedItemsFD_CB.remove(sCode);
					if(excludedItemsFD_CB.size()>0)
						excludedItems_CB.put(fromDate,excludedItemsFD_CB);
					else
						excludedItems_CB.remove(fromDate);					
				}
			 }
		  //includedItems_CB.remove(packageCode);
		  includedItemsFD_CB.remove(fromDate);
		  if(includedItemsFD_CB.size()>0)
		  includedItems_CB.put(packageCode,includedItemsFD_CB);
		  else
		   includedItems_CB.remove(packageCode);
		  bean.setExcludedItems_CB(excludedItems_CB);
		  bean.setIncludedItems_CB(includedItems_CB);
			}
		}
		
	   /*Deletion Logic for database operation  */ 	  /*
	   if(event!=null && event.equals("delete"))
	   {
			HashMap includSrvicesDB_CB =	bean.getIncludSrvicesDB_CB();
			HashMap includSrvicesDB_CBTemp =	includSrvicesDB_CB;
			String sItem = "";
			if(includSrvicesDB_CB!=null && includSrvicesDB_CB.size()>0)
			{
				java.util.Set serviceKey  =	(java.util.Set) includSrvicesDB_CBTemp.keySet();
				Iterator Iter1 = serviceKey.iterator();
				while(Iter1.hasNext()) 
				{
					sItem = (java.lang.String)Iter1.next();
					if(!(serviceCode.contains(sItem)))
					{
						includSrvicesDB_CB.remove(sItem);
						includSrvicesDB_CB.put(sItem,"delete");
					}
				}
				bean.setIncludSrvicesDB_CB(includSrvicesDB_CB);
			}
	   }  				*/
	   /*end Deletion Logic for database operation  */
	}
		
	else if(func_mode != null && func_mode.equals("CHARGE_BASED_ITEM" ) )
	{
		if(event.equals("delete"))	 bean.setDeletedStatusCBLt("Y");
		String serviceCode          =  (String)hash.get("serviceCode");
		ArrayList	itemCode	    =	new ArrayList();
		ArrayList	itemDesc	    =	new ArrayList();
		ArrayList	qtyLmt		    =	new ArrayList();
		ArrayList	amtLmt		    =	new ArrayList();

		ArrayList	inclExclFlag    =	new ArrayList();
		ArrayList 	split_reqd_list = new ArrayList();	//Rajesh V - Split reqd
		
		ArrayList 	includeHomeMedication_list = new ArrayList(); //sarathkumar InclHmeMedi
		ArrayList 	enableDisParam_list = new ArrayList(); //sarathkumar InclHmeMedi
		
		String sItem = "";
		String	fromDate		=	(String) hash.get( "fromDate" );
		/*String curDate			   =	(String) hash.get( "curDate" );

		if(curDate!=null && !(curDate.equals("")) && !curDate.equals(fromDate))
			fromDate = curDate;

		*/
		HashMap excludedItems_CB    =    new HashMap();
		HashMap excludedItemsFD_CB    =    new HashMap();
		//HashMap excludedItemsSR_CB    =    new HashMap();

		excludedItems_CB = bean.getExcludedItems_CB();
		
		if(excludedItems_CB.get(fromDate)!=null)
		{
			excludedItemsFD_CB = (HashMap)excludedItems_CB.get(fromDate);
		}
		
		//String	total_records		=	(String) hash.get( "total_records" );
		String	totalRecords		=	(String) hash.get( "totalRecords" );
		ArrayList excludedItems_CBD =	new ArrayList();
		int totalRec				=	Integer.parseInt(totalRecords);
		
	  	String sCode = "";

		for(int i=0;i<totalRec; i++)
		{
		   sCode = (String) hash.get( "cbCode_"+i );
		   if(sCode!=null && !sCode.equals(""))
		   {
				itemCode.add((String) hash.get( "cbCode_"+i ));
				itemDesc.add((String) hash.get( "cbDesc_"+i ));
				qtyLmt.add((String) hash.get( "quantityLimit_"+i ));
				amtLmt.add((String) hash.get( "amountLimit_"+i ));
				inclExclFlag.add((String) hash.get( "inEx_"+i ));
				//Rajesh V - Split Reqd
				splitReqdChk = (String) hash.get("split_reqd"+i);
				if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
					splitReqdChk = "Y";
				}
				else{
					splitReqdChk = "N";
				}
				split_reqd_list.add(splitReqdChk);
				//Rajesh V - Split Reqd				
				
				 //sarathkumar InclHmeMedi
				includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
				if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
					includeHomeMedicationChk = "Y";
				}
				else{
					includeHomeMedicationChk = "N";
				}
				includeHomeMedication_list.add(includeHomeMedicationChk); 
				
				//sarathkumar InclHmeMedi
				enableDisParamChk = (String) hash.get("enableDisParam"+i);
				if("on".equals(enableDisParamChk) || "Y".equals(enableDisParamChk)){
					enableDisParamChk = "Y";
				}
				else{
					enableDisParamChk = "N";
				}
				enableDisParam_list.add(enableDisParamChk);			
		   }
		}
		/*Removal Logic  */
		ArrayList serviceToChk = new ArrayList();
		if(excludedItemsFD_CB.size()>0)
		{
			
			int recordCount = Integer.parseInt( (String)hash.get( "recordCount"));			
			java.util.Set serviceKey  =	(java.util.Set) excludedItemsFD_CB.keySet();			

			for(int j=0; j<recordCount; j++)
			{
				serviceToChk.add((String) hash.get( "code_"+j ));
			}
		    Iterator Iter1 = serviceKey.iterator();
			while(Iter1.hasNext()) 
            {
				sItem = (java.lang.String)Iter1.next();
				if(!(serviceToChk.contains(sItem)))
				{
					excludedItemsFD_CB.remove(sItem);
					excludedItems_CB.put(fromDate,excludedItemsFD_CB);
				}
			}
		}
		/* End */
		if(itemCode.size()>0)
		{
			excludedItems_CBD.add(itemCode);
			excludedItems_CBD.add(itemDesc);
			excludedItems_CBD.add(qtyLmt);
			excludedItems_CBD.add(amtLmt);
			excludedItems_CBD.add(inclExclFlag);
			excludedItems_CBD.add(split_reqd_list);//Split Reqd
			
			excludedItems_CBD.add(includeHomeMedication_list); //sarathkumar InclHmeMedi
			
			excludedItems_CBD.add(enableDisParam_list); //sarathkumar InclHmeMedi
			
			//if(excludedItemsFD_CB!=null && excludedItemsFD_CB.containsKey(serviceCode))
			  // excludedItemsFD_CB.remove(serviceCode);
			excludedItemsFD_CB.put(serviceCode,excludedItems_CBD);
			//excludedItems_CB.put(fromDate,excludedItemsFD_CB);
			//bean.setExcludedItems_CB(excludedItems_CB);
		}
		else
		{
			excludedItemsFD_CB.remove(serviceCode);
			//excludedItems_CB.put(fromDate,excludedItemsFD_CB);
		}
		if(excludedItemsFD_CB!=null && excludedItemsFD_CB.size()>0)	 {
			excludedItems_CB.put(fromDate,excludedItemsFD_CB);
		}
		else
		 excludedItems_CB.remove(fromDate);

		 bean.setExcludedItems_CB(excludedItems_CB);

		/*Deletion logic for Charge based items  */	 /*
	   if(event!=null && event.equals("detele"))
	   {
			HashMap excludSrvicesDB_CB		=  bean.getExcludSrvicesDB_CB();
			HashMap excludItemsDB_CBTemp	=  new HashMap();
			HashMap excludItemsDB_CB		=  new HashMap();

		    if(excludSrvicesDB_CB!=null && excludSrvicesDB_CB.containsKey(serviceCode) && excludSrvicesDB_CB.size()>0)
		    {
				excludItemsDB_CB	  = (HashMap)excludSrvicesDB_CB.get(serviceCode);
				excludItemsDB_CBTemp  = excludItemsDB_CB;
				java.util.Set serviceKey  =	(java.util.Set) excludItemsDB_CBTemp.keySet();
				Iterator Iter1 = serviceKey.iterator();
				while(Iter1.hasNext()) 
				{
					sItem = (java.lang.String)Iter1.next();
					if(itemCode!=null && !(itemCode.contains(sItem)))
					{
						excludItemsDB_CB.remove(sItem);
						excludItemsDB_CB.put(sItem,"delete");
					}
				}
				excludSrvicesDB_CB.remove(serviceCode);
				excludSrvicesDB_CB.put(serviceCode,excludItemsDB_CB);
				bean.setExcludSrvicesDB_CB(excludSrvicesDB_CB);
			}
		}	*/
	

	  /*end Deletion logic for Charge based items   */
	  
	}
	else if(func_mode != null && func_mode.equals("CUSTOMER" ) )
	{
			HashMap cust_dtls=(HashMap)bean1.getCustDtls();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String cust_grp_code = "";
			String cust_code = "";
			for(int i=0;i<totalRec; i++)
			{
			   cust_grp_code = (String) hash.get( "cust_grp_code"+i );
			   cust_code = (String) hash.get( "cust_code"+i );
			   if(cust_grp_code!=null && !cust_grp_code.equals("") && cust_code!=null && !cust_code.equals(""))
			   {
					record=new String[5];
					record[0]=cust_grp_code;
					record[1]=(String)hash.get( "cust_grp_desc"+i );
					record[2]=cust_code;
					record[3]=(String)hash.get( "cust_desc"+i );
					record[4]=(String)hash.get( "pkg_valid_days"+i );				
					
					if(cust_dtls!=null && cust_dtls.size()>0 && cust_dtls.containsKey(record[0].trim()+"~~"+record[2].trim()))
						cust_dtls.remove(record[0].trim()+"~~"+record[2].trim());
						cust_dtls.put(record[0].trim()+"~~"+record[2].trim(),record);		
			   }
			}	
			bean1.setCustDtls(cust_dtls);	
	}	
	else if(func_mode != null && func_mode.equals("cust_discount" ) )
	{
			HashMap cust_discount_dtls=(HashMap)bean2.getCustDiscountDtls();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String cust_grp_code = "";
			String cust_code = "";
			String blng_class_code = "";
			String eff_from_date = "";
			//GHL-CRF-0502 Starts
			String age_group_code="";
			String specialty_code="";
			String hdn_age_group ="";
			String specialty_desc ="";
			//GHL-CRF-0502 Ends
			//ADDED FOR MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020
			String poly_code ="";
			String poly_desc ="";
			//ADDED FOR MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020
			
						
			for(int i=0;i<totalRec; i++)
			{
			   cust_grp_code =hash.get( "cust_grp_code"+i )==null?"": (String) hash.get( "cust_grp_code"+i );
			   cust_code = hash.get( "cust_code"+i )==null?"": (String) hash.get( "cust_code"+i );
			   blng_class_code = hash.get( "blng_class_code"+i )==null?"": (String) hash.get( "blng_class_code"+i );
			   eff_from_date = hash.get( "eff_from_date"+i )==null?"": (String) hash.get( "eff_from_date"+i );
			   //GHL-CRF-0502 Starts
			   age_group_code = hash.get( "age_group_code"+i )==null?"": (String) hash.get( "age_group_code"+i );
			   specialty_code = hash.get( "specialty_code"+i )==null?"": (String) hash.get( "specialty_code"+i );
			   //ADDED FOR MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020
			    poly_code=hash.get( "poly_code"+i )==null?"": (String) hash.get( "poly_code"+i );
			    poly_desc=hash.get( "poly_desc"+i )==null?"": (String) hash.get( "poly_desc"+i );
			    //ADDED FOR MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020 			  
			   
			   //GHL-CRF-0502 Ends
			   String siteAgeSpecialty = (String) hash.get("SiteAgeSpecialty");//Added V190409-Aravindh/GHL-CRF-0502
			   if(!"true".equals(siteAgeSpecialty)) {//Added V190409-Aravindh/GHL-CRF-0502
				   age_group_code = "**";
				   specialty_code = "**";
			   }
			  
			   if(cust_grp_code!=null && !cust_grp_code.equals("") && cust_code!=null && !cust_code.equals("") && blng_class_code!=null 
			   		&& !blng_class_code.equals("") && eff_from_date!=null && !eff_from_date.equals("") && !"".equals(age_group_code) && !"".equals(specialty_code))
			   {
					record=new String[16];//ADDED FOR MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020
					record[0]=cust_grp_code;
					record[1]=(String)hash.get( "cust_grp_desc"+i );
					record[2]=cust_code;
					record[3]=(String)hash.get( "cust_desc"+i );
					record[4]=(String)hash.get( "blng_class_code"+i );
					record[5]=(String)hash.get( "blng_class_desc"+i );
					record[6]=(String)hash.get( "eff_from_date"+i );
					record[7]=(String)hash.get( "eff_to_date"+i );
					record[8]=(String)hash.get( "discount_type"+i );				
					record[9]=(String)hash.get( "discount"+i );	
					//GHL-CRF-0502 Starts
					record[10]=age_group_code;	
					record[11]=(String)hash.get("hdn_age_group"+i);
					record[12]=specialty_code;
					record[13]=(String)hash.get("specialty_desc"+i);
					//ADDED FOR MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020
					record[14]=(String)hash.get("poly_code"+i);
					record[15]=(String)hash.get("poly_desc"+i);
					//ADDED FOR MMS-QH-CRF-128.1-US-7  PALANINARAYANAN 15/6/2020
					
					if(cust_discount_dtls!=null && cust_discount_dtls.size()>0 && cust_discount_dtls.containsKey(record[0].trim()+"~~"+record[2].trim()+"~~"+record[4].trim()+"~~"+record[6].trim()+"~~"+record[10].trim()+"~~"+record[12].trim()))
					cust_discount_dtls.remove(record[0].trim()+"~~"+record[2].trim()+"~~"+record[4].trim()+"~~"+record[6].trim()+"~~"+record[10].trim()+"~~"+record[12].trim());

					cust_discount_dtls.put(record[0].trim()+"~~"+record[2].trim()+"~~"+record[4].trim()+"~~"+record[6].trim()+"~~"+record[10].trim()+"~~"+record[12].trim(),record);//GHL-CRF-0502 Ends						
			   }
			}	
			bean2.setCustDiscountDtls(cust_discount_dtls);	
	}	
	else if(func_mode != null && func_mode.equals("blng_grp_discount" ) )
	{
			HashMap blng_grp_discount_dtls=(HashMap)bean2.getBlngGrpDiscountDtls();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String blng_grp_code = "";
			String blng_class_code = "";
			String eff_from_date = "";
			//GHL-CRF-0502 Starts
			String age_group_code="";
			String specialty_code="";
			String hdn_age_group ="";
			String specialty_desc ="";
			//GHL-CRF-0502 Ends
		
			for(int i=0;i<totalRec; i++)
			{
			   blng_grp_code =hash.get( "blng_grp_code"+i )==null?"": (String) hash.get( "blng_grp_code"+i );
			   blng_class_code = hash.get( "blng_class_code"+i )==null?"": (String) hash.get( "blng_class_code"+i );			   
			   eff_from_date = hash.get( "eff_from_date"+i )==null?"": (String) hash.get( "eff_from_date"+i );
			   //GHL-CRF-0502 Starts
			   age_group_code = hash.get( "age_group_code"+i )==null?"": (String) hash.get( "age_group_code"+i );
			   specialty_code = hash.get( "specialty_code"+i )==null?"": (String) hash.get( "specialty_code"+i );
			   //GHL-CRF-0502 Ends
			   String siteAgeSpecialty = (String) hash.get("SiteAgeSpecialty");//Added V190409-Aravindh/GHL-CRF-0502
			   if(!"true".equals(siteAgeSpecialty)) {//Added V190409-Aravindh/GHL-CRF-0502
				   age_group_code = "**";
				   specialty_code = "**";
			   }
			   
			   if(blng_grp_code!=null && !blng_grp_code.equals("") && blng_class_code!=null && !blng_class_code.equals("") && eff_from_date!=null && !eff_from_date.equals("")
					   && !"".equals(age_group_code) && !"".equals(specialty_code))
			   {
					record=new String[12];
					record[0]=blng_grp_code;
					record[1]=(String)hash.get( "blng_grp_desc"+i );
					record[2]=(String)hash.get( "blng_class_code"+i );
					record[3]=(String)hash.get( "blng_class_desc"+i );
					record[4]=(String)hash.get( "eff_from_date"+i );
					record[5]=(String)hash.get( "eff_to_date"+i );
					record[6]=(String)hash.get( "discount_type"+i );				
					record[7]=(String)hash.get( "discount"+i );
					//GHL-CRF-0502 Starts
					record[8]=age_group_code;
					record[9]=(String)hash.get("hdn_age_group"+i);
					record[10]=specialty_code;
					record[11]=(String)hash.get("specialty_desc"+i);				
					
					if(blng_grp_discount_dtls!=null && blng_grp_discount_dtls.size()>0 && blng_grp_discount_dtls.containsKey(record[0].trim()+"~~"+record[2].trim()+"~~"+record[4].trim()+"~~"+record[8].trim()+"~~"+record[10].trim()))
						blng_grp_discount_dtls.remove(record[0].trim()+"~~"+record[2].trim()+"~~"+record[4].trim()+"~~"+record[8].trim()+"~~"+record[10].trim());
						blng_grp_discount_dtls.put(record[0].trim()+"~~"+record[2].trim()+"~~"+record[4].trim()+"~~"+record[8].trim()+"~~"+record[10].trim(),record);
					//GHL-CRF-0502 Ends
			   }
			}	
			bean2.setBlngGrpDiscountDtls(blng_grp_discount_dtls);	
	}
	else if(func_mode!= null && func_mode.equals("delete_cust_discount")){
		int totalRec = Integer.parseInt((String) hash.get( "total_records"));
		String code="";
		HashMap cust_discount_dtls=bean2.getCustDiscountDtls();// for rate based services dtls	
		for(int i=0;i<totalRec;i++){
			code=((String)hash.get( "key"+i)).trim();
			if(cust_discount_dtls!=null && cust_discount_dtls.size()>0 && cust_discount_dtls.containsKey(code)){
				cust_discount_dtls.remove(code);
			}
		}	
		bean2.setCustDiscountDtls(cust_discount_dtls);	
	}	
	else if(func_mode!= null && func_mode.equals("delete_blng_grp_discount")){
		int totalRec = Integer.parseInt((String) hash.get( "total_records"));
		String code="";
		HashMap blng_grp_discount_dtls=bean2.getBlngGrpDiscountDtls();// for rate based services dtls	
		for(int i=0;i<totalRec;i++){
			code=((String)hash.get( "key"+i)).trim();
			if(blng_grp_discount_dtls!=null && blng_grp_discount_dtls.size()>0 && blng_grp_discount_dtls.containsKey(code)){
				blng_grp_discount_dtls.remove(code);
			}
		}	
		bean2.setBlngGrpDiscountDtls(blng_grp_discount_dtls);	
	}	
	else if(func_mode!= null && func_mode.equals("DUPLICATE_CHECK"))
	{  		
		//Duplicate check for package services
		ArrayList codes     = new ArrayList();
		int totRec		    = Integer.parseInt((String) hash.get( "total_records" ));
		int	index	    	= Integer.parseInt((String) hash.get( "index" ));	
		String functionId	= (String) hash.get( "functionId" );	
		String item	= (String) hash.get( "item" );	
		for(int i=0;i<totRec; i++)
		{
			if(i!=index)
			codes.add((String) hash.get( "code_"+i ));
		}
		
		if(codes.contains(item))
			out.println("duplicateAlert('"+index+"','"+functionId+"')");
		else
		{
		  if(functionId.equals("CHARGE_BASED"))
		  {
			  out.println("loadChargeBasedServiceLimit(document.forms[0].cbCode_"+index+".value,'"+index+"')");
			 // out.println("loadBalnk()");
		  }
		}
	}
	else if(func_mode != null && func_mode.equals("CLEAR_BEAN" ) )
	{
		bean.clearBean();
		packageCode = (String) hash.get( "packageCode");
		//session.setAttribute("packageCode",packageCode);
	}
	else if(func_mode!= null && func_mode.equals("VALIDATE_FACTOR"))
	{
		int totalRec = Integer.parseInt((String) hash.get( "total_records"));
		int index = Integer.parseInt((String) hash.get( "index"));
		int sIndex =Integer.parseInt((String) hash.get( "sIndex"));

		String dateToChkFrom = (String) hash.get("fromDate_"+index );
		dateToChkFrom = dateToChkFrom == null ? "" : dateToChkFrom;
		String dateToChkTo = (String) hash.get("toDate_"+index );
		dateToChkTo = dateToChkTo == null ? "" : dateToChkTo;
		String fromD = "";
		String toD = "";
		String sql = "";
		String flagfac = "false";
		String rIndexV = "";
		for(int i=0;i<totalRec; i++)
		{
			fromD = ((String) hash.get("fromDate_"+i )).trim();
			fromD = fromD == null ? "" : fromD;
			toD = ((String) hash.get("toDate_"+i )).trim();
			toD = toD == null ? "" : toD;
			rIndexV	= (String) hash.get("rIndex_"+i );			

			if(i!=sIndex)
			{	
				if(!(fromD.equals("") || toD.equals("")))			
				{  
					sql = "select 1 from dual where to_date(?,'dd/mm/yyyy') between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy')";
					if(!(dateToChkFrom.equals("") || dateToChkTo.equals("")))
					{
						try
						{ 
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,dateToChkFrom);
							pstmt.setString(2,fromD);
							pstmt.setString(3,toD);

							rs = pstmt.executeQuery() ;
							if(rs.next())
							{  
								if(rs.getString("1").equals("1"))
								{
									try
									{
										if(pstmt!=null) pstmt.close();
										if(rs!=null) rs.close();
										pstmt = con.prepareStatement(sql);
										pstmt.setString(1,dateToChkTo);
										pstmt.setString(2,fromD);
										pstmt.setString(3,toD);
										rs = pstmt.executeQuery() ;
										if(rs.next())
										{	
											if(rs.getString("1").equals("1"))
											{
												flagfac = "true";
												break;
											}
											else
											{
											  flagfac = "false";
											}
										}
									}
									catch(Exception e)
									{
										System.out.println("Exception from validate 2 :"+e);
										e.printStackTrace();
									}
									finally
									{
										if(pstmt!=null) pstmt.close();
										if(rs!=null) rs.close();
									}
								}
								else
								{
									flagfac = "false";
								}
							}
						}
						catch(Exception e)
						{
							System.out.println("Exception from validate 3 :"+e);	
							e.printStackTrace();
						}
						finally
						{
							if(pstmt!=null) pstmt.close();
							if(rs!=null) rs.close();
						}
					}
					else if(!dateToChkFrom.equals("") && dateToChkTo.equals(""))
					{
						try
						{ 
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,dateToChkFrom);
							pstmt.setString(2,fromD);
							pstmt.setString(3,toD);

							rs = pstmt.executeQuery() ;
							if(rs.next())
							{	
								if(rs.getString("1").equals("1"))
								{
									flagfac = "true";
									break;
								}
								else
									flagfac = "false";
							}
						}
						catch(Exception e)
						{
							System.out.println("Exception from validate 4 :"+e);	
							e.printStackTrace();
						}
						finally
						{
							if(pstmt!=null) pstmt.close();
							if(rs!=null) rs.close();
						}

					}
				}
				else if(!(fromD.equals("")) && toD.equals("") )
				{	  
					sql = "select 1 from dual where to_date(?,'dd/mm/yyyy')>= to_date(?,'dd/mm/yyyy')" ;
					try
					{ 
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1,dateToChkFrom);
						pstmt.setString(2,fromD);
						rs = pstmt.executeQuery() ;
						if(rs.next())
						{	 
							if(rs.getString("1").equals("1"))
							{
								if(dateToChkTo.equals(""))
								{
									flagfac = "true";
									break;
								}
							}
							else
							{
							   flagfac = "false";
							}
						}
					}
					catch(Exception e)
					{
						System.out.println("Exception from validate 4 :"+e);				
							e.printStackTrace();
					}						
					finally
					{
						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
					}
				}
			}
		}
		/*if(flagfac.equals("true"))
			 out.println("factrorCheck('"+flagfac+"','"+rIndexV+"')");	*/
		out.println(flagfac);
	}
	else if(func_mode!= null && func_mode.equals("delete_cust")){
		int totalRec = Integer.parseInt((String) hash.get( "total_records"));		
		String code="";
		HashMap cust_details=bean1.getCustDtls();
		HashMap cust_period=bean1.getCustPeriod();
		HashMap cust_base_price=bean1.getCustBasePrice();// for rate based services dtls	
		HashMap cust_rate_srv=bean1.getCustRateSrv();// for rate based services dtls
		HashMap cust_rate_srv_excl=bean1.getCustRateSrvExcl();// for rate based services dtls	
		HashMap cust_charge_srv=bean1.getCustChargeSrv();// for rate based services dtls
		HashMap cust_charge_srv_excl=bean1.getCustChargeSrvExcl();// for rate based services dtls
		Set<String> keySet;
		Iterator<String> iterator;
		String key="";
		for(int i=0;i<totalRec;i++){
			code=((String)hash.get( "key"+i)).trim();
			if(cust_details!=null && cust_details.size()>0){
				keySet=(Set<String>)cust_details.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_details.remove(key);				
					}
				}
			}
			if(cust_period!=null && cust_period.size()>0){
				keySet=(Set<String>)cust_period.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_period.remove(key);				
					}
				}
			}
			if(cust_base_price!=null && cust_base_price.size()>0){
				keySet=(Set<String>)cust_base_price.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_base_price.remove(key);				
					}
				}
			}
			if(cust_rate_srv!=null && cust_rate_srv.size()>0){
				keySet=(Set<String>)cust_rate_srv.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_rate_srv.remove(key);				
					}
				}
			}
			if(cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0){
				keySet=(Set<String>)cust_rate_srv_excl.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_rate_srv_excl.remove(key);				
					}
				}
			}
			if(cust_charge_srv!=null && cust_charge_srv.size()>0){
				keySet=(Set<String>)cust_charge_srv.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_charge_srv.remove(key);				
					}
				}
			}
			if(cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0){
				keySet=(Set<String>)cust_charge_srv_excl.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_charge_srv_excl.remove(key);				
					}
				}
			}
		}
		
		bean1.setCustDtls(cust_details);
		bean1.setCustPeriod(cust_period);
		bean1.setCustBasePrice(cust_base_price);
		bean1.setCustRateSrv(cust_rate_srv);
		bean1.setCustRateSrvExcl(cust_rate_srv_excl);
		bean1.setCustChargeSrv(cust_charge_srv);
		bean1.setCustChargeSrvExcl(cust_charge_srv_excl);
	}else if(func_mode!= null && func_mode.equals("delete_cust_period")){
		int totalRec = Integer.parseInt((String) hash.get( "total_records"));		
		String code="";
		HashMap cust_period=bean1.getCustPeriod();
		HashMap cust_base_price=bean1.getCustBasePrice();// for rate based services dtls	
		HashMap cust_rate_srv=bean1.getCustRateSrv();// for rate based services dtls
		HashMap cust_rate_srv_excl=bean1.getCustRateSrvExcl();// for rate based services dtls	
		HashMap cust_charge_srv=bean1.getCustChargeSrv();// for rate based services dtls
		HashMap cust_charge_srv_excl=bean1.getCustChargeSrvExcl();// for rate based services dtls
		/*	System.out.println("**** before ******");
		System.out.println("in delete_cust,bean1.getCustDtls="+((HashMap)bean1.getCustDtls()).toString());
		System.out.println("in delete_cust,bean1.getCustPeriod="+((HashMap)bean1.getCustPeriod()).toString());
		System.out.println("in delete_cust,bean1.getCustBasePrice="+((HashMap)bean1.getCustBasePrice()).toString());
		System.out.println("in delete_cust,bean1.getCustRateSrv="+((HashMap)bean1.getCustRateSrv()).toString());
		System.out.println("in delete_cust,bean1.getCustRateSrvExcl="+((HashMap)bean1.getCustRateSrvExcl()).toString());
		System.out.println("in delete_cust,bean1.getCustChargeSrv="+((HashMap)bean1.getCustChargeSrv()).toString());
		System.out.println("in delete_cust,bean1.getCustChargeSrvExcl="+((HashMap)bean1.getCustChargeSrvExcl()).toString());*/
		Set<String> keySet;
		Iterator<String> iterator;
		String key="";
		for(int i=0;i<totalRec;i++){
			code=((String)hash.get( "key"+i)).trim();
			if(cust_period!=null && cust_period.size()>0){
				keySet=(Set<String>)cust_period.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_period.remove(key);				
					}
				}
			}
			if(cust_base_price!=null && cust_base_price.size()>0){
				keySet=(Set<String>)cust_base_price.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_base_price.remove(key);				
					}
				}
			}
			if(cust_rate_srv!=null && cust_rate_srv.size()>0){
				keySet=(Set<String>)cust_rate_srv.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_rate_srv.remove(key);				
					}
				}
			}
			if(cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0){
				keySet=(Set<String>)cust_rate_srv_excl.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_rate_srv_excl.remove(key);				
					}
				}
			}
			if(cust_charge_srv!=null && cust_charge_srv.size()>0){
				keySet=(Set<String>)cust_charge_srv.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_charge_srv.remove(key);				
					}
				}
			}
			if(cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0){
				keySet=(Set<String>)cust_charge_srv_excl.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						cust_charge_srv_excl.remove(key);				
					}
				}
			}
		}
	
		bean1.setCustPeriod(cust_period);
		bean1.setCustBasePrice(cust_base_price);
		bean1.setCustRateSrv(cust_rate_srv);
		bean1.setCustRateSrvExcl(cust_rate_srv_excl);
		bean1.setCustChargeSrv(cust_charge_srv);
		bean1.setCustChargeSrvExcl(cust_charge_srv_excl);
	}else if(func_mode!= null && func_mode.equals("delete_cust_rate_based")){	
		int totalRec = Integer.parseInt((String) hash.get( "total_records"));
		String code="";
		HashMap cust_rate_srv_excl=bean1.getCustRateSrvExcl();// for rate based services dtls	
		for(int i=0;i<totalRec;i++){
			code=((String)hash.get( "key"+i)).trim();
			if(cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0 && cust_rate_srv_excl.containsKey(code)){
				cust_rate_srv_excl.remove(code);
			}
		}	
		bean1.setCustRateSrvExcl(cust_rate_srv_excl);	
	}else if(func_mode!= null && func_mode.equals("delete_cust_charge_based")){
		int totalRec = Integer.parseInt((String) hash.get( "total_records"));
		String code="";
		HashMap cust_charge_srv_excl=bean1.getCustChargeSrvExcl();// for rate based services dtls	
		for(int i=0;i<totalRec;i++){
			code=((String)hash.get( "key"+i)).trim();
			if(cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0 && cust_charge_srv_excl.containsKey(code)){
				cust_charge_srv_excl.remove(code);
			}
		}	
		bean1.setCustChargeSrvExcl(cust_charge_srv_excl);	
	}/*else if(func_mode!= null && func_mode.equals("rename_cust")){
		String currKey = (String) hash.get( "currKey");
		String oldKey =(String) hash.get( "oldKey");		
		String code="";
		ArrayList list=new ArrayList();
		HashMap cust_details=bean1.getCustDtls();
		HashMap cust_period=bean1.getCustPeriod();
		HashMap cust_base_price=bean1.getCustBasePrice();// for rate based services dtls	
		HashMap cust_rate_srv=bean1.getCustRateSrv();// for rate based services dtls
		HashMap cust_rate_srv_excl=bean1.getCustRateSrvExcl();// for rate based services dtls	
		HashMap cust_charge_srv=bean1.getCustChargeSrv();// for rate based services dtls
		HashMap cust_charge_srv_excl=bean1.getCustChargeSrvExcl();// for rate based services dtls
		Set<String> keySet;
		Iterator<String> iterator;
		String key="";
		if(cust_details!=null && cust_details.size()>0){
			keySet=(Set<String>)cust_details.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
				key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_details.get(key);
					cust_details.remove(key);	
					cust_details.put(currKey,list);
				}
			}
		}
		if(cust_period!=null && cust_period.size()>0){
				keySet=(Set<String>)cust_period.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
					key=(String)iterator.next();
					if(key.startsWith(oldKey)){
						currKey=key.replaceFirst(oldKey,currKey);
						list=(ArrayList)cust_period.get(key);
						cust_period.remove(key);	
						cust_period.put(currKey,list);
					}
				}
			}
			if(cust_base_price!=null && cust_base_price.size()>0){
				keySet=(Set<String>)cust_base_price.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(oldKey)){
						currKey=key.replaceFirst(oldKey,currKey);
						list=(ArrayList)cust_base_price.get(key);
						cust_base_price.remove(key);	
						cust_base_price.put(currKey,list);			
					}
				}
			}
			if(cust_rate_srv!=null && cust_rate_srv.size()>0){
				keySet=(Set<String>)cust_rate_srv.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(oldKey)){
						currKey=key.replaceFirst(oldKey,currKey);
						list=(ArrayList)cust_rate_srv.get(key);
						cust_rate_srv.remove(key);	
						cust_rate_srv.put(currKey,list);			
					}
				}
			}
			if(cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0){
				keySet=(Set<String>)cust_rate_srv_excl.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(oldKey)){
						currKey=key.replaceFirst(oldKey,currKey);
						list=(ArrayList)cust_rate_srv_excl.get(key);
						cust_rate_srv_excl.remove(key);	
						cust_rate_srv_excl.put(currKey,list);			
					}
				}
			}
			if(cust_charge_srv!=null && cust_charge_srv.size()>0){
				keySet=(Set<String>)cust_charge_srv.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(oldKey)){
						currKey=key.replaceFirst(oldKey,currKey);
						list=(ArrayList)cust_charge_srv.get(key);
						cust_charge_srv.remove(key);	
						cust_charge_srv.put(currKey,list);			
					}
				}
			}
			if(cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0){
				keySet=(Set<String>)cust_charge_srv_excl.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(oldKey)){
						currKey=key.replaceFirst(oldKey,currKey);
						list=(ArrayList)cust_charge_srv_excl.get(key);
						cust_charge_srv_excl.remove(key);	
						cust_charge_srv_excl.put(currKey,list);			
					}
				}
			}
		bean1.setCustDtls(cust_details);
		bean1.setCustPeriod(cust_period);
		bean1.setCustBasePrice(cust_base_price);
		bean1.setCustRateSrv(cust_rate_srv);
		bean1.setCustRateSrvExcl(cust_rate_srv_excl);
		bean1.setCustChargeSrv(cust_charge_srv);
		bean1.setCustChargeSrvExcl(cust_charge_srv_excl);
	}
	else if(func_mode!= null && func_mode.equals("rename_cust_period")){
		String currKey = (String) hash.get( "currKey");
		String oldKey =(String) hash.get( "oldKey");		
		String code="";
		ArrayList list=new ArrayList();
		HashMap cust_period=bean1.getCustPeriod();
		HashMap cust_base_price=bean1.getCustBasePrice();// for rate based services dtls	
		HashMap cust_rate_srv=bean1.getCustRateSrv();// for rate based services dtls
		HashMap cust_rate_srv_excl=bean1.getCustRateSrvExcl();// for rate based services dtls	
		HashMap cust_charge_srv=bean1.getCustChargeSrv();// for rate based services dtls
		HashMap cust_charge_srv_excl=bean1.getCustChargeSrvExcl();// for rate based services dtls
		Set<String> keySet;
		Iterator<String> iterator;
		String key="";
		if(cust_period!=null && cust_period.size()>0){
			keySet=(Set<String>)cust_period.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
				key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_period.get(key);
					cust_period.remove(key);	
					cust_period.put(currKey,list);
				}
			}
		}
		if(cust_base_price!=null && cust_base_price.size()>0){
			keySet=(Set<String>)cust_base_price.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
				key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_base_price.get(key);
					cust_base_price.remove(key);	
					cust_base_price.put(currKey,list);			
				}
			}
		}
		if(cust_rate_srv!=null && cust_rate_srv.size()>0){
			keySet=(Set<String>)cust_rate_srv.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
				key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_rate_srv.get(key);
					cust_rate_srv.remove(key);	
					cust_rate_srv.put(currKey,list);			
				}
			}
		}
		if(cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0){
			keySet=(Set<String>)cust_rate_srv_excl.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
				key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_rate_srv_excl.get(key);
					cust_rate_srv_excl.remove(key);	
					cust_rate_srv_excl.put(currKey,list);			
				}
			}
		}
		if(cust_charge_srv!=null && cust_charge_srv.size()>0){
			keySet=(Set<String>)cust_charge_srv.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
				key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_charge_srv.get(key);
					cust_charge_srv.remove(key);	
					cust_charge_srv.put(currKey,list);			
				}
			}
		}
		if(cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0){
			keySet=(Set<String>)cust_charge_srv_excl.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
				key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_charge_srv_excl.get(key);
					cust_charge_srv_excl.remove(key);	
					cust_charge_srv_excl.put(currKey,list);			
				}
			}
		}		
		bean1.setCustPeriod(cust_period);
		bean1.setCustBasePrice(cust_base_price);
		bean1.setCustRateSrv(cust_rate_srv);
		bean1.setCustRateSrvExcl(cust_rate_srv_excl);
		bean1.setCustChargeSrv(cust_charge_srv);
		bean1.setCustChargeSrvExcl(cust_charge_srv_excl);
	}else if(func_mode!= null && func_mode.equals("rename_cust_rate_based")){
		String currKey = (String) hash.get( "currKey");
		String oldKey =(String) hash.get( "oldKey");		
		String code="";
		ArrayList list=new ArrayList();		
		HashMap cust_rate_srv=bean1.getCustRateSrv();// for rate based services dtls
		HashMap cust_rate_srv_excl=bean1.getCustRateSrvExcl();// for rate based services dtls	
		
		Set<String> keySet;
		Iterator<String> iterator;
		String key="";
		if(cust_rate_srv!=null && cust_rate_srv.size()>0){
			keySet=(Set<String>)cust_rate_srv.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
			key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_rate_srv.get(key);
					cust_rate_srv.remove(key);	
					cust_rate_srv.put(currKey,list);			
				}
			}
		}
		if(cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0){
			keySet=(Set<String>)cust_rate_srv_excl.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
				key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_rate_srv_excl.get(key);
					cust_rate_srv_excl.remove(key);	
					cust_rate_srv_excl.put(currKey,list);			
				}
			}
		}
	
		bean1.setCustRateSrv(cust_rate_srv);
		bean1.setCustRateSrvExcl(cust_rate_srv_excl);
	
	}else if(func_mode!= null && func_mode.equals("rename_cust_charge_based")){
		String currKey = (String) hash.get( "currKey");
		String oldKey =(String) hash.get( "oldKey");		
		String code="";
		ArrayList list=new ArrayList();		
		HashMap cust_charge_srv=(HashMap)bean1.getCustChargeSrv();// for charge based services dtls
		HashMap cust_charge_srv_excl=(HashMap)bean1.getCustChargeSrvExcl();// for chage based services exsl	
		
		Set<String> keySet;
		Iterator<String> iterator;
		String key="";
		if(cust_charge_srv!=null && cust_charge_srv.size()>0){
			keySet=(Set<String>)cust_charge_srv.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
			key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_charge_srv.get(key);
					cust_charge_srv.remove(key);	
					cust_charge_srv.put(currKey,list);			
				}
			}
		}
		if(cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0){
			keySet=(Set<String>)cust_charge_srv_excl.keySet();
			iterator=keySet.iterator();
			while(iterator.hasNext()){
				key=(String)iterator.next();
				if(key.startsWith(oldKey)){
					currKey=key.replaceFirst(oldKey,currKey);
					list=(ArrayList)cust_charge_srv_excl.get(key);
					cust_charge_srv_excl.remove(key);	
					cust_charge_srv_excl.put(currKey,list);			
				}
			}
		}
	
		bean1.setCustChargeSrv(cust_charge_srv);
		bean1.setCustChargeSrvExcl(cust_charge_srv_excl);	
	}*/
	else if(func_mode!= null && func_mode.equals("custPeriod")){
			HashMap cust_period=(HashMap)bean1.getCustPeriod();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String cust_grp_code = "";
			String cust_code = "";
			String fromDate="";
			ArrayList cust_period_list=new ArrayList();
			for(int i=0;i<totalRec; i++)
			{
			   cust_grp_code = (String) hash.get( "cust_grp_code" );
			   cust_code = (String) hash.get( "cust_code" );
			   fromDate=hash.get( "fromDate_"+i )==null?"":(String)hash.get( "fromDate_"+i );
			   if(cust_grp_code!=null && !cust_grp_code.equals("") && cust_code!=null && !cust_code.equals("") && !fromDate.equals(""))
			   {
					record=new String[15];
					record[0]=fromDate;
					record[1]=(String)hash.get( "toDate_"+i );
					record[2]=(String)hash.get( "pkgPriceClsCode_"+i );
					record[3]=(String)hash.get( "pkgPriceClsDesc_"+i );
					record[4]=(String)hash.get( "oPkgPriceClsCode_"+i );
					record[5]=(String)hash.get( "oPkgPriceClsDesc_"+i );	
					record[6]=(String)hash.get( "glSmry"+i );	
					record[7]=(String)hash.get( "glSmryDesc"+i );	
					record[8]=(String)hash.get( "glSmryDisc"+i );	
					record[9]=(String)hash.get( "glSmryDiscDesc"+i );	
					//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
					record[10]=(String)hash.get( "VATapp"+i );	
					record[11]=(String)hash.get( "VATpercent"+i );	
					record[12]=(String)hash.get( "ruleCoverageInd"+i );	
					record[13]=(String)hash.get( "flagVal"+i );	
					record[14]=(String)hash.get( "VATapp1"+i );
					//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends		
					cust_period_list.add(record);									
			   }
			}	
			
			if(cust_period!=null && cust_period.size()>0 && cust_period.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()))
					cust_period.remove(cust_grp_code.trim()+"~~"+cust_code.trim());
			if(cust_period_list!=null && cust_period_list.size()>0 ){
				cust_period.put(cust_grp_code.trim()+"~~"+cust_code.trim(),cust_period_list);				
			}
			bean1.setCustPeriod(cust_period);	
		}else if(func_mode != null && func_mode.equals("CUST_PRICE" ) ){
			HashMap cust_base_price=(HashMap)bean1.getCustBasePrice();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String cust_grp_code = "";
			String cust_code = "";
			String fromDate = "";
			String blng_class_code = "";
			ArrayList cust_price_list=new ArrayList();
			for(int i=0;i<totalRec; i++)
			{
			   cust_grp_code = (String) hash.get( "cust_grp_code" );
			   cust_code = (String) hash.get( "cust_code" );
			   fromDate = (String) hash.get( "fromDate" );
			   blng_class_code =hash.get("blgClsCode_"+i )==null?"": (String) hash.get("blgClsCode_"+i );
			   if(cust_grp_code!=null && !cust_grp_code.equals("") && cust_code!=null && !cust_code.equals("") && fromDate!=null && !fromDate.equals("") && !blng_class_code.equals(""))
			   {
				record=new String[12];
				record[0]=blng_class_code;
				record[1]=(String)hash.get( "blgClsDesc_"+i );
				record[2]=(String)hash.get( "indicator_"+i );
				record[3]=(String)hash.get( "price_"+i );
				record[4]=(String)hash.get( "roundTo_"+i );
				record[5]=(String)hash.get( "roundInd_"+i );	
				record[6]=(String)hash.get( "factorAppl_"+i );	
				record[7]=(String)hash.get( "deposit_"+i );	
				record[8]=(String)hash.get( "partialDeposit_"+i );	
				record[9]=(String)hash.get( "minDepAmtind_"+i );	
				record[10]=(String)hash.get( "minDepAmt_"+i );	
				record[11]=(String)hash.get( "factorforServiceRate"+i );//Added by muthu for Factor for service rate issue for KDAH on 22-6-12

				cust_price_list.add(record);								 
			   }
			}	
	
			if(cust_base_price!=null && cust_base_price.size()>0 && cust_base_price.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()))
				cust_base_price.remove(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim());
			if(cust_price_list!=null && cust_price_list.size()>0 ){
				cust_base_price.put(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim(),cust_price_list);		
			}			
			bean1.setCustBasePrice(cust_base_price);	
					
		}else if(func_mode != null && func_mode.equals("CUST_RATE_BASED" ) ){
			System.out.println("Inside CUST_RATE_BASED validation");
			HashMap cust_rate_srv=(HashMap)bean1.getCustRateSrv();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			System.out.println("Inside CUST_RATE_BASED totalRec "+totalRec);
			String cust_grp_code = "";
			String cust_code = "";
			String fromDate = "";
			String service_code = "";
			//String closePkg = "";//unused variable
			ArrayList cust_rate_srv_list=new ArrayList();
			for(int i=0;i<totalRec; i++)
			{
			   cust_grp_code = (String) hash.get( "cust_grp_code" );
			   cust_code = (String) hash.get( "cust_code" );
			   fromDate = (String) hash.get( "fromDate" );			
			   service_code = hash.get( "service_code"+i  )==null?"":(String) hash.get( "service_code"+i  );	
				System.out.println("cust_grp_code=>"+cust_grp_code+"/"+"cust_code=>"+cust_code+"/"+"fromDate =>"+fromDate+"/"+"service_code=>"+service_code);			   
			   if(cust_grp_code!=null && !cust_grp_code.equals("") && cust_code!=null && !cust_code.equals("") && fromDate!=null && !fromDate.equals("") && !service_code.equals(""))
			   {			
			System.out.println("2363 CUST_RATE_BASED " );
				record=new String[31];//Rajesh V - Split Reqd
				record[0]=(String)hash.get( "type"+i );
				record[1]=(String)hash.get( "service_code"+i );
				record[2]=(String)hash.get( "service_desc"+i );
				record[3]=(String)hash.get( "catalog_code"+i );
				record[4]=(String)hash.get( "catalog_desc"+i );
				record[5]=(String)hash.get( "ind"+i );	
				record[6]=(String)hash.get( "factorOrRate"+i );	
				record[7]=(String)hash.get( "qty_limit"+i );	
				record[8]=(String)hash.get( "amt_limit_ind"+i );	
				record[9]=(String)hash.get( "perAmt_limit"+i );	
				record[10]=(String)hash.get( "replace"+i );	
				record[11]=(String)hash.get( "replaceSrv_code"+i );	
				record[12]=(String)hash.get( "replaceSrv_desc"+i );	
				record[13]=(String)hash.get( "replaceSrv_cat_code"+i );	
				record[14]=(String)hash.get( "replaceSrv_cat_desc"+i );	
				record[15]=(String)hash.get( "refund"+i );	
				record[16]=(hash.get( "refundAmt"+i )==null)?"":((String)hash.get( "refundAmt"+i ));	
				record[17]=(String)hash.get( "autoRefund"+i );	
				record[18]=(String)hash.get( "factor_appl"+i );	
				record[19]=(String) (hash.get( "roundTo"+i )== null ?"":hash.get( "roundTo"+i) );
				record[20]=(String) (hash.get( "roundInd"+i )==null ?"":hash.get( "roundInd"+i ));
				//closePkg = (closePkg.equals("off") || closePkg == null) ? "N" : (closePkg.equals("on") ? "Y" : closePkg );
				//record[21]=closePkg;
				record[21]=(String) (hash.get( "closePkg"+i )==null ?"N":hash.get( "closePkg"+i ));
				//Rajesh V - Split Reqd
				splitReqdChk = (String) hash.get("split_reqd"+i);
				if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
					splitReqdChk = "Y";
				}
				else{
					splitReqdChk = "N";
				}
				record[22]=splitReqdChk;
				//Rajesh V - Split Reqd
						
				includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
				if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
					includeHomeMedicationChk = "Y";
				}
				else{
					includeHomeMedicationChk = "N";
				}
				record[23]=includeHomeMedicationChk;
					
				enableDisParam = (String) hash.get("enableDisParam"+i);
				record[24]=enableDisParam;
				/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
				String dailyLmtChk = (String) hash.get("dailyLmtChkBx"+i);
				if("on".equals(dailyLmtChk) || "Y".equals(dailyLmtChk)){
					dailyLmtChk = "Y";
				}
				else{
					dailyLmtChk = "N";
				}
				record[25]=dailyLmtChk;
				record[26]=(String) hash.get("dailyLmtAmt"+i);
				record[27]=(String) hash.get("dailyLmtGrossNetList"+i);
				/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
				record[28]=(String) hash.get("dailyLmtIndicator"+i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				record[29]=(String) hash.get("dailyLmtQty"+i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				record[30]=(String) hash.get("serv_grp_limit_ind"+i);//Added By Shikha For MMS-QH-CRF-170 on 14-Jul-2020
				cust_rate_srv_list.add(record);					
			   }
			}	

			if(cust_rate_srv!=null && cust_rate_srv.size()>0 && cust_rate_srv.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim())){
			cust_rate_srv.remove(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim());
					}
		if(cust_rate_srv_list!=null && cust_rate_srv_list.size()>0 ){
			cust_rate_srv.put(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim(),cust_rate_srv_list);		
		}
		System.out.println("cust_rate_srv in validation  "+cust_rate_srv);
		bean1.setCustRateSrv(cust_rate_srv);	
		System.out.println("values from bean saveToBean= CUST RAte Based="+((HashMap)bean1.getCustRateSrv()).toString());
				
		}
		else if(func_mode != null && func_mode.equals("CUST_SRVLIMIT_RATE_BASED" ) ){			
			HashMap cust_rate_srv_excl=(HashMap)bean1.getCustRateSrvExcl();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String cust_grp_code = "";
			String cust_code = "";
			String fromDate = "";
			String service_code = "";
			String srvLimit_service_code = "";

					//System.out.println("save 'CUST_SRVLIMIT_RATE_BASED',hash="+hash.toString());
			ArrayList cust_rate_srv_exc_list=new ArrayList();
			//System.out.println("totalRec="+totalRec);
			for(int i=0;i<totalRec; i++)
			{
			   cust_grp_code = (String) hash.get( "cust_grp_code" );
			   cust_code = (String) hash.get( "cust_code" );
			   fromDate = (String) hash.get( "fromDate" );			
			   service_code = hash.get( "parent_service_code")==null?"":(String) hash.get( "parent_service_code");			
			   srvLimit_service_code = hash.get( "srvLimit_service_code"+i  )==null?"":(String) hash.get( "srvLimit_service_code"+i  );						
			   if(cust_grp_code!=null && !cust_grp_code.equals("") && cust_code!=null && !cust_code.equals("") && fromDate!=null && !fromDate.equals("") && !service_code.equals("") && !srvLimit_service_code.equals(""))
			   {			
		
				record=new String[24];//Split Reqd
				record[0]=(String)hash.get( "srvLimit_type"+i );
				record[1]=(String)hash.get( "srvLimit_service_code"+i );
				record[2]=(String)hash.get( "srvLimit_service_desc"+i );
				record[3]=(hash.get( "exludeService"+i )==null)?"N":(String)hash.get( "exludeService"+i );
				record[4]=(String)hash.get( "srvLimit_qty_limit"+i );
				record[5]=(String)hash.get( "srvLimit_amt_limit_ind"+i );	
				record[6]=(String)hash.get( "srvLimit_amt_limit"+i );	
				record[7]=(String)hash.get( "srvLimit_roundTo"+i );	
				record[8]=(String)hash.get( "srvLimit_roundInd"+i );	
				record[9]=(String)hash.get( "srvLimit_replace"+i );	
				record[10]=(String)hash.get( "srvLimit_replaceSrv_code"+i );	
				record[11]=(String)hash.get( "srvLimit_replaceSrv_desc"+i );	
				record[12]=(String)hash.get( "srvLimit_refund"+i );	
				record[13]=(hash.get( "srvLimit_refundAmt"+i )==null)?"":((String)hash.get( "srvLimit_refundAmt"+i ));	
				record[14]=(String)hash.get( "srvLimit_autoRefund"+i );	
				record[15]=(String)hash.get( "srvLimit_factor_appl"+i );	
				//Rajesh V - Split Reqd
				splitReqdChk = (String) hash.get("split_reqd"+i);
				if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
					splitReqdChk = "Y";
				}
				else{
					splitReqdChk = "N";
				}
				record[16]=splitReqdChk;
				//Rajesh V - Split Reqd
				includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
				if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
					includeHomeMedicationChk = "Y";
				}
				else{
					includeHomeMedicationChk = "N";
				}
				record[17]=includeHomeMedicationChk;
					
				enableDisParam = (String) hash.get("enableDisParam"+i);
				record[18]=enableDisParam;
				/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
				String dailyLmtChk = (String) hash.get("dailyLmtChkBx"+i);
				if("on".equals(dailyLmtChk) || "Y".equals(dailyLmtChk)){
					dailyLmtChk = "Y";
				}
				else{
					dailyLmtChk = "N";
				}
				record[19]=dailyLmtChk;
				record[20]=(String) hash.get("dailyLmtAmt"+i);
				record[21]=(String) hash.get("dailyLmtGrossNetList"+i);
				/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
				record[22]=(String) hash.get("dailyLmtIndicator"+i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				record[23]=(String) hash.get("dailyLmtQty"+i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
				cust_rate_srv_exc_list.add(record);				
			   }
			}	
			
			if(cust_rate_srv_excl!=null && cust_rate_srv_excl.size()>0 && cust_rate_srv_excl.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim()))
					cust_rate_srv_excl.remove(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim());
			if(cust_rate_srv_exc_list!=null && cust_rate_srv_exc_list.size()>0 ){
				cust_rate_srv_excl.put(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim(),cust_rate_srv_exc_list);	
			}				
			bean1.setCustRateSrvExcl(cust_rate_srv_excl);	
			
		}else if(func_mode != null && func_mode.equals("CUST_CHARGE_BASED" ) ){
			System.out.println("CUST_CHARGE_BASED in Validation.jsp ");
			HashMap cust_charge_srv=(HashMap)bean1.getCustChargeSrv();
			System.out.println("cust_charge_srv in Validation.jsp CUST_CHARGE_BASED "+cust_charge_srv);
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String cust_grp_code = "";
			String cust_code = "";
			String fromDate = "";
			String service_code = "";
			
			ArrayList cust_charge_srv_list=new ArrayList();
			System.out.println("cust_charge_srv_list in Validation.jsp CUST_CHARGE_BASED "+cust_charge_srv_list);
			for(int i=0;i<totalRec; i++)
			{
			   cust_grp_code = (String) hash.get( "cust_grp_code" );
			   cust_code = (String) hash.get( "cust_code" );
			   fromDate = (String) hash.get( "fromDate" );			
			   service_code = hash.get( "cbCode_"+i  )==null?"":(String) hash.get( "cbCode_"+i  );
			   //service_code = hash.get( "charge_type"+i  )==null?"":(String) hash.get( "charge_type"+i  );
			   System.out.println("cust_grp_code in Validation.jsp "+cust_grp_code);
			   System.out.println("cust_code in Validation.jsp "+cust_code);
			   System.out.println("fromDate in Validation.jsp "+fromDate);
			   System.out.println("service_code in Validation.jsp "+service_code);

			   if(cust_grp_code!=null && !cust_grp_code.equals("") && cust_code!=null && !cust_code.equals("") && fromDate!=null && !fromDate.equals("") && !service_code.equals(""))
			   {			
					record=new String[15];//Split reqd
					//record=new String[11];
					//record=new String[10];
					record[0]=(String)hash.get( "charge_type"+i );//Added by MuthuN against 28192 on 1-8-12
					System.out.println("charge_type in Validation.jsp "+record[0]);
					record[1]=(String)hash.get( "cbCode_"+i );
					record[2]=(String)hash.get( "cbDesc_"+i );
					record[3]=(String)hash.get( "amt_limit_ind"+i );
					record[4]=(String)hash.get( "perAmt_limit"+i );
					record[5]=(String)hash.get( "roundTo_"+i );
					record[6]=(String)hash.get( "roundInd_"+i );	
					record[7]=hash.get( "refund_"+i )==null?"N":(String)hash.get( "refund_"+i );	
					record[8]=hash.get( "refundAmt_"+i )==null?"0":(String)hash.get( "refundAmt_"+i );	
					record[9]=(String)hash.get( "autoRefund_"+i );	
					record[10]=hash.get( "factor_appl"+i )==null?"":((String)hash.get( "factor_appl"+i ));
					record[11]=hash.get( "srvLmt_"+i )==null?"":((String)hash.get( "srvLmt_"+i ));//muthu against 28192 on 8/24/2012
					//Rajesh V - Split Reqd
					splitReqdChk = (String) hash.get("split_reqd"+i);
					if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
						splitReqdChk = "Y";
					}
					else{
						splitReqdChk = "N";
					}
					record[12]=splitReqdChk;
					//Rajesh V - Split Reqd
					includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
					if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
						includeHomeMedicationChk = "Y";
					}
					else{
						includeHomeMedicationChk = "N";
					}
					record[13]=includeHomeMedicationChk;
					
					enableDisParam = (String) hash.get("enableDisParam"+i);
					record[14]=enableDisParam;
					cust_charge_srv_list.add(record);									
			   }
			}
			if(cust_charge_srv!=null && cust_charge_srv.size()>0 && cust_charge_srv.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim())){
				cust_charge_srv.remove(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim());
			}
			if(cust_charge_srv_list!=null && cust_charge_srv_list.size()>0 ){
				cust_charge_srv.put(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim(),cust_charge_srv_list);		
			}			
			bean1.setCustChargeSrv(cust_charge_srv);				
		}
		else if(func_mode != null && func_mode.equals("CUST_CHARGE_BASED_ITEM" ) ){
			HashMap cust_charge_srv_excl=(HashMap)bean1.getCustChargeSrvExcl();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String cust_grp_code = "";
			String cust_code = "";
			String fromDate = "";
			String service_code = "";
			String cbCode_ = "";

			ArrayList cust_charge_srv_excl_list=new ArrayList();
			for(int i=0;i<totalRec; i++)
			{
			   cust_grp_code = (String) hash.get( "cust_grp_code" );
			   cust_code = (String) hash.get( "cust_code" );
			   fromDate = (String) hash.get( "fromDate" );			
			   service_code = hash.get( "parent_service_code")==null?"":(String) hash.get( "parent_service_code");			
			   cbCode_ = hash.get( "cbCode_"+i  )==null?"":(String) hash.get( "cbCode_"+i  );						  
			   if(cust_grp_code!=null && !cust_grp_code.equals("") && cust_code!=null && !cust_code.equals("") && fromDate!=null && !fromDate.equals("") && !service_code.equals("") && !cbCode_.equals(""))
			   {
					record=new String[8];//Split Reqd
					record[0]=(String)hash.get( "cbCode_"+i );
					record[1]=(String)hash.get( "cbDesc_"+i );				
					record[2]=(hash.get( "inEx_"+i )==null)?"N":(String)hash.get( "inEx_"+i );
					record[3]=(String)hash.get( "quantityLimit_"+i );
					record[4]=(String)hash.get( "amountLimit_"+i );	
					//Rajesh V - Split Reqd
					splitReqdChk = (String) hash.get("split_reqd"+i);
					if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
						splitReqdChk = "Y";
					}
					else{
						splitReqdChk = "N";
					}
					record[5]=splitReqdChk;
					//Rajesh V - Split Reqd
						includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
						if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
							includeHomeMedicationChk = "Y";
						}
						else{
							includeHomeMedicationChk = "N";
						}
						record[6]=includeHomeMedicationChk;
						
						enableDisParam = (String) hash.get("enableDisParam"+i);
						record[7]=enableDisParam;
					cust_charge_srv_excl_list.add(record);					
			   }
			}	
			
			if(cust_charge_srv_excl!=null && cust_charge_srv_excl.size()>0 && cust_charge_srv_excl.containsKey(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim()))
					cust_charge_srv_excl.remove(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim());
			if(cust_charge_srv_excl_list!=null && cust_charge_srv_excl_list.size()>0 ){
				cust_charge_srv_excl.put(cust_grp_code.trim()+"~~"+cust_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim(),cust_charge_srv_excl_list);	
			}				
			bean1.setCustChargeSrvExcl(cust_charge_srv_excl);		
		}
		else if(func_mode != null && func_mode.equals("COPY_VALUES"))
		{
			String copyFrm_pkgCode = (String) hash.get( "copyFrm_pkgCode");
			facilityId = (String) hash.get( "facilityId");
			packageCode = (String) hash.get( "packageCode");
			String fromDate = (String) hash.get( "fromDate");
			bean.setDBValues("RATE_BASED",packageCode,locale,facilityId,"",copyFrm_pkgCode,fromDate);

		bean.setDBValues("SRVLIMIT_RATE_BASED",packageCode,locale,facilityId,"",copyFrm_pkgCode,fromDate);
		bean.setDBValues("CHARGE_BASED",packageCode,locale,facilityId,"",copyFrm_pkgCode,fromDate);
			
		bean.setDBValues("CHARGE_BASED_ITEM",packageCode,locale,facilityId,"",copyFrm_pkgCode,fromDate);//set database values to bean.
		}
		else if(func_mode != null && func_mode.equals("DATE_KEY_CHANGE"))
		{
			packageCode = (String) hash.get( "packageCode");
			String fromDate = (String) hash.get( "fromDate");
			String prevDate = (String) hash.get( "prevDate");

			HashMap includedItems_RB    =  bean.getIncludedItems_RB();
			HashMap excludedItems_RB    =  bean.getExcludedItems_RB();
			HashMap includedItems_CB    =  bean.getIncludedItems_CB();
			HashMap excludedItems_CB    =  bean.getExcludedItems_CB();
			HashMap basePrice		    =  bean.getBasePrice();
			if(basePrice!=null && basePrice.containsKey(packageCode))
			{
				HashMap basePriceDtls	= (HashMap)basePrice.get(packageCode);
				if(basePriceDtls.containsKey(prevDate))
				{
					ArrayList dtlsArray =(ArrayList)basePriceDtls.get(prevDate);
					basePriceDtls.remove(prevDate);
					basePriceDtls.put(fromDate,dtlsArray);
					basePrice.put(packageCode,basePriceDtls);
					bean.setBasePrice(basePrice);
				}
			}
			
			//ArrayList includedItems_RBD =	new ArrayList();

			if(includedItems_RB.size()>0 && includedItems_RB.containsKey(packageCode) )
			{
				HashMap includedItemsFD_RB =(HashMap)includedItems_RB.get(packageCode);
				if(includedItemsFD_RB.size()>0 && includedItemsFD_RB.containsKey(prevDate))
				{
					ArrayList rBServices =(ArrayList)includedItemsFD_RB.get(prevDate);
					includedItemsFD_RB.remove(prevDate);
					includedItemsFD_RB.put(fromDate,rBServices);
					includedItems_RB.put(packageCode,includedItemsFD_RB);
					bean.setIncludedItems_RB(includedItems_RB);	
				}
			}

		if(excludedItems_RB.size()>0 && excludedItems_RB.containsKey(prevDate))
		{
			HashMap excludedItemsFD_RB = (HashMap)excludedItems_RB.get(prevDate);
			excludedItems_RB.remove(prevDate);
			excludedItems_RB.put(fromDate,excludedItemsFD_RB);
			bean.setExcludedItems_RB(excludedItems_RB);	
		}

			//ArrayList includedItems_RBD =	new ArrayList();
			if(includedItems_CB.size()>0 && includedItems_CB.containsKey(packageCode) )
			{
				HashMap includedItemsFD_CB =(HashMap)includedItems_CB.get(packageCode);
				if(includedItemsFD_CB.size()>0 && includedItemsFD_CB.containsKey(prevDate))
				{
					ArrayList cBServices =(ArrayList)includedItemsFD_CB.get(prevDate);
					includedItemsFD_CB.remove(prevDate);
					includedItemsFD_CB.put(fromDate,cBServices);
					includedItems_CB.put(packageCode,includedItemsFD_CB);
					bean.setIncludedItems_CB(includedItems_CB);	
				}
			}
		if(excludedItems_CB.size()>0 && excludedItems_CB.containsKey(prevDate))
		{
			HashMap excludedItemsFD_CB = (HashMap)excludedItems_CB.get(prevDate);
			excludedItems_CB.remove(prevDate);
			excludedItems_CB.put(fromDate,excludedItemsFD_CB);
			bean.setExcludedItems_CB(excludedItems_CB);				
			}
		}
		else if(func_mode != null && func_mode.equals("CHECK_STATUS"))
		{
			boolean pkgCrtnStat = bean.packageCreationRight(loggedInUser,facilityId);
			boolean pkgAprvStat = bean.packageApprovalStatus(loggedInUser,facilityId);
			String isUserCanAcess =  (pkgCrtnStat || pkgAprvStat)? "Y" :"N";
			session.putValue("isUserCanAcess",isUserCanAcess);
			out.println(isUserCanAcess)	;
		}else if(func_mode != null && func_mode.equals("duplicatePackageCodeCheck"))
		{
	
			String packageCode1 = request.getParameter("packageCode");
			pstmt = con.prepareStatement("SELECT 1 tot_count FROM BL_PACKAGE WHERE PACKAGE_CODE = ?  and OPERATING_FACILITY_ID=? and Rownum=1");
		 	pstmt.setString(1, packageCode1); 	
			pstmt.setString(2, facilityId); 
			
			rs1  = pstmt.executeQuery();
					if(rs1 != null && rs1.next()){ 
						count=rs1.getInt(1);
					}
			out.println(count);
		}
	//Added By Shikha For GHL-CRF-0520.1
	else if(func_mode != null && func_mode.equals("BILLINGGROUP" ) )
	{
			HashMap blng_grp_dtls=(HashMap)bean3.getBlngGrpDtls();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String blng_grp_code = "";			
			for(int i=0;i<totalRec; i++)
			{
			   blng_grp_code = (String) hash.get( "blng_grp_code"+i );			   
			   if(blng_grp_code!=null && !blng_grp_code.equals("") )
			   {
					record=new String[3];
					record[0]=blng_grp_code;
					record[1]=(String)hash.get( "blng_grp_desc"+i );
					record[2]=(String)hash.get( "pkg_valid_days"+i );				
					
					if(blng_grp_dtls!=null && blng_grp_dtls.size()>0 && blng_grp_dtls.containsKey(record[0].trim()))
						blng_grp_dtls.remove(record[0].trim());
						blng_grp_dtls.put(record[0].trim(),record);		
			   }
			}
			System.out.println("in BILLINGGROUP="+blng_grp_dtls);
			bean3.setBlngGrpDtls(blng_grp_dtls);	
	}	else if(func_mode!= null && func_mode.equals("blngGrpPeriod")){
			HashMap blng_grp_period=(HashMap)bean3.getBlngGrpPeriod();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String blng_grp_code = "";			
			String fromDate="";
			ArrayList blng_grp_period_list=new ArrayList();
			for(int i=0;i<totalRec; i++)
			{
			   blng_grp_code = (String) hash.get( "blng_grp_code" );			   
			   fromDate=hash.get( "fromDate_"+i )==null?"":(String)hash.get( "fromDate_"+i );
			   if(blng_grp_code!=null && !blng_grp_code.equals("") && !fromDate.equals(""))
			   {
					record=new String[15];
					record[0]=fromDate;
					record[1]=(String)hash.get( "toDate_"+i );
					record[2]=(String)hash.get( "pkgPriceClsCode_"+i );
					record[3]=(String)hash.get( "pkgPriceClsDesc_"+i );
					record[4]=(String)hash.get( "oPkgPriceClsCode_"+i );
					record[5]=(String)hash.get( "oPkgPriceClsDesc_"+i );	
					record[6]=(String)hash.get( "glSmry"+i );	
					record[7]=(String)hash.get( "glSmryDesc"+i );	
					record[8]=(String)hash.get( "glSmryDisc"+i );	
					record[9]=(String)hash.get( "glSmryDiscDesc"+i );	
					//Added V180122-Gayathri/MMS-DM-CRF-0118/Starts
					record[10]=(String)hash.get( "VATapp"+i );	
					record[11]=(String)hash.get( "VATpercent"+i );	
					record[12]=(String)hash.get( "ruleCoverageInd"+i );	
					record[13]=(String)hash.get( "flagVal"+i );	
					record[14]=(String)hash.get( "VATapp1"+i );
					//Added V180122-Gayathri/MMS-DM-CRF-0118/Ends		
					blng_grp_period_list.add(record);									
			   }
			}	
			
			if(blng_grp_period!=null && blng_grp_period.size()>0 && blng_grp_period.containsKey(blng_grp_code.trim()))
					blng_grp_period.remove(blng_grp_code.trim());
			if(blng_grp_period_list!=null && blng_grp_period_list.size()>0 ){
				blng_grp_period.put(blng_grp_code.trim(),blng_grp_period_list);				
			}
			bean3.setBlngGrpPeriod(blng_grp_period);	
		}else if(func_mode != null && func_mode.equals("BLNG_GRP_PRICE" ) ){
			HashMap blng_grp_base_price=(HashMap)bean3.getBlngGrpBasePrice();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String blng_grp_code = "";			
			String fromDate = "";
			String blng_class_code = "";
			ArrayList blng_grp_price_list=new ArrayList();
			for(int i=0;i<totalRec; i++)
			{
			   blng_grp_code = (String) hash.get( "blng_grp_code" );			   
			   fromDate = (String) hash.get( "fromDate" );
			   blng_class_code =hash.get("blgClsCode_"+i )==null?"": (String) hash.get("blgClsCode_"+i );
			   if(blng_grp_code!=null && !blng_grp_code.equals("")  && fromDate!=null && !fromDate.equals("") && !blng_class_code.equals(""))
			   {
					record=new String[12];
					record[0]=blng_class_code;
					record[1]=(String)hash.get( "blgClsDesc_"+i );
					record[2]=(String)hash.get( "indicator_"+i );
					record[3]=(String)hash.get( "price_"+i );
					record[4]=(String)hash.get( "roundTo_"+i );
					record[5]=(String)hash.get( "roundInd_"+i );	
					record[6]=(String)hash.get( "factorAppl_"+i );	
					record[7]=(String)hash.get( "deposit_"+i );	
					record[8]=(String)hash.get( "partialDeposit_"+i );	
					record[9]=(String)hash.get( "minDepAmtind_"+i );	
					record[10]=(String)hash.get( "minDepAmt_"+i );	
					record[11]=(String)hash.get( "factorforServiceRate"+i );//Added by muthu for Factor for service rate issue for KDAH on 22-6-12

					blng_grp_price_list.add(record);								 
			   }
			}	
	
			if(blng_grp_base_price!=null && blng_grp_base_price.size()>0 && blng_grp_base_price.containsKey(blng_grp_code.trim()+"~~"+fromDate.trim()))
				blng_grp_base_price.remove(blng_grp_code.trim()+"~~"+fromDate.trim());
			if(blng_grp_price_list!=null && blng_grp_price_list.size()>0 ){
				blng_grp_base_price.put(blng_grp_code.trim()+"~~"+fromDate.trim(),blng_grp_price_list);		
			}			
			bean3.setBlngGrpBasePrice(blng_grp_base_price);	
					
		}else if(func_mode != null && func_mode.equals("BLNG_GRP_RATE_BASED" ) ){
			HashMap blng_grp_rate_srv=(HashMap)bean3.getBlngGrpRateSrv();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String blng_grp_code = "";			
			String fromDate = "";
			String service_code = "";
			//String closePkg = "";//unused variable
			ArrayList blng_grp_rate_srv_list=new ArrayList();
			for(int i=0;i<totalRec; i++)
			{
			   blng_grp_code = (String) hash.get( "blng_grp_code" );			   
			   fromDate = (String) hash.get( "fromDate" );			
			   service_code = hash.get( "service_code"+i  )==null?"":(String) hash.get( "service_code"+i  );			
			   if(blng_grp_code!=null && !blng_grp_code.equals("") && fromDate!=null && !fromDate.equals("") && !service_code.equals(""))
			   {			
					record=new String[30];//Rajesh V - Split Reqd
					record[0]=(String)hash.get( "type"+i );
					record[1]=(String)hash.get( "service_code"+i );
					record[2]=(String)hash.get( "service_desc"+i );
					record[3]=(String)hash.get( "catalog_code"+i );
					record[4]=(String)hash.get( "catalog_desc"+i );
					record[5]=(String)hash.get( "ind"+i );	
					record[6]=(String)hash.get( "factorOrRate"+i );	
					record[7]=(String)hash.get( "qty_limit"+i );	
					record[8]=(String)hash.get( "amt_limit_ind"+i );	
					record[9]=(String)hash.get( "perAmt_limit"+i );	
					record[10]=(String)hash.get( "replace"+i );	
					record[11]=(String)hash.get( "replaceSrv_code"+i );	
					record[12]=(String)hash.get( "replaceSrv_desc"+i );	
					record[13]=(String)hash.get( "replaceSrv_cat_code"+i );	
					record[14]=(String)hash.get( "replaceSrv_cat_desc"+i );	
					record[15]=(String)hash.get( "refund"+i );	
					record[16]=(hash.get( "refundAmt"+i )==null)?"":((String)hash.get( "refundAmt"+i ));	
					record[17]=(String)hash.get( "autoRefund"+i );	
					record[18]=(String)hash.get( "factor_appl"+i );	
					record[19]=(String) (hash.get( "roundTo"+i )== null ?"":hash.get( "roundTo"+i) );
					record[20]=(String) (hash.get( "roundInd"+i )==null ?"":hash.get( "roundInd"+i ));
					//closePkg = (closePkg.equals("off") || closePkg == null) ? "N" : (closePkg.equals("on") ? "Y" : closePkg );
					//record[21]=closePkg;
					record[21]=(String) (hash.get( "closePkg"+i )==null ?"N":hash.get( "closePkg"+i ));
					//Rajesh V - Split Reqd
					splitReqdChk = (String) hash.get("split_reqd"+i);
					if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
						splitReqdChk = "Y";
					}
					else{
						splitReqdChk = "N";
					}
					record[22]=splitReqdChk;
					//Rajesh V - Split Reqd
						
					includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
					if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
						includeHomeMedicationChk = "Y";
					}
					else{
						includeHomeMedicationChk = "N";
					}
					record[23]=includeHomeMedicationChk;
					
					enableDisParam = (String) hash.get("enableDisParam"+i);
					record[24]=enableDisParam;
					/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
					String dailyLmtChk = (String) hash.get("dailyLmtChkBx"+i);
					if("on".equals(dailyLmtChk) || "Y".equals(dailyLmtChk)){
						dailyLmtChk = "Y";
					}
					else{
						dailyLmtChk = "N";
					}
					record[25]=dailyLmtChk;
					record[26]=(String) hash.get("dailyLmtAmt"+i);
					record[27]=(String) hash.get("dailyLmtGrossNetList"+i);
					/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
					record[28]=(String) hash.get("dailyLmtIndicator"+i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					record[29]=(String) hash.get("dailyLmtQty"+i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					blng_grp_rate_srv_list.add(record);					
			   }
			}	

			if(blng_grp_rate_srv!=null && blng_grp_rate_srv.size()>0 && blng_grp_rate_srv.containsKey(blng_grp_code.trim()+"~~"+fromDate.trim())){
			blng_grp_rate_srv.remove(blng_grp_code.trim()+"~~"+fromDate.trim());
					}
		if(blng_grp_rate_srv_list!=null && blng_grp_rate_srv_list.size()>0 ){
			blng_grp_rate_srv.put(blng_grp_code.trim()+"~~"+fromDate.trim(),blng_grp_rate_srv_list);		
		}
		bean3.setBlngGrpRateSrv(blng_grp_rate_srv);	
		//System.out.println("values from bean saveToBean= BLNG_GRP RAte Based="+((HashMap)bean3.getBlngGrpRateSrv()).toString());
				
		}
		else if(func_mode != null && func_mode.equals("BLNG_GRP_SRVLIMIT_RATE_BASED" ) ){			
			HashMap blng_grp_rate_srv_excl=(HashMap)bean3.getBlngGrpRateSrvExcl();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String blng_grp_code = "";			
			String fromDate = "";
			String service_code = "";
			String srvLimit_service_code = "";

					System.out.println("save 'BLNG_GRP_SRVLIMIT_RATE_BASED',hash="+hash.toString());
			ArrayList blng_grp_rate_srv_exc_list=new ArrayList();
			System.out.println("totalRec="+totalRec);
			for(int i=0;i<totalRec; i++)
			{
			   blng_grp_code = (String) hash.get( "blng_grp_code" );			 
			   fromDate = (String) hash.get( "fromDate" );			
			   service_code = hash.get( "parent_service_code")==null?"":(String) hash.get( "parent_service_code");			
			   srvLimit_service_code = hash.get( "srvLimit_service_code"+i  )==null?"":(String) hash.get( "srvLimit_service_code"+i  );						
			   if(blng_grp_code!=null && !blng_grp_code.equals("")  && fromDate!=null && !fromDate.equals("") && !service_code.equals("") && !srvLimit_service_code.equals(""))
			   {			
		
					record=new String[24];//Split Reqd
					record[0]=(String)hash.get( "srvLimit_type"+i );
					record[1]=(String)hash.get( "srvLimit_service_code"+i );
					record[2]=(String)hash.get( "srvLimit_service_desc"+i );
					record[3]=(hash.get( "exludeService"+i )==null)?"N":(String)hash.get( "exludeService"+i );
					record[4]=(String)hash.get( "srvLimit_qty_limit"+i );
					record[5]=(String)hash.get( "srvLimit_amt_limit_ind"+i );	
					record[6]=(String)hash.get( "srvLimit_amt_limit"+i );	
					record[7]=(String)hash.get( "srvLimit_roundTo"+i );	
					record[8]=(String)hash.get( "srvLimit_roundInd"+i );	
					record[9]=(String)hash.get( "srvLimit_replace"+i );	
					record[10]=(String)hash.get( "srvLimit_replaceSrv_code"+i );	
					record[11]=(String)hash.get( "srvLimit_replaceSrv_desc"+i );	
					record[12]=(String)hash.get( "srvLimit_refund"+i );	
					record[13]=(hash.get( "srvLimit_refundAmt"+i )==null)?"":((String)hash.get( "srvLimit_refundAmt"+i ));	
					record[14]=(String)hash.get( "srvLimit_autoRefund"+i );	
					record[15]=(String)hash.get( "srvLimit_factor_appl"+i );	
					//Rajesh V - Split Reqd
					splitReqdChk = (String) hash.get("split_reqd"+i);
					if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
						splitReqdChk = "Y";
					}
					else{
						splitReqdChk = "N";
					}
					record[16]=splitReqdChk;
					//Rajesh V - Split Reqd
					includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
					if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
						includeHomeMedicationChk = "Y";
					}
					else{
						includeHomeMedicationChk = "N";
					}
					record[17]=includeHomeMedicationChk;
					
					enableDisParam = (String) hash.get("enableDisParam"+i);
					record[18]=enableDisParam;
					/* Added V190320-Aravindh/MMS-DM-CRF-0129/Starts */
					String dailyLmtChk = (String) hash.get("dailyLmtChkBx"+i);
					if("on".equals(dailyLmtChk) || "Y".equals(dailyLmtChk)){
						dailyLmtChk = "Y";
					}
					else{
						dailyLmtChk = "N";
					}
					record[19]=dailyLmtChk;
					record[20]=(String) hash.get("dailyLmtAmt"+i);
					record[21]=(String) hash.get("dailyLmtGrossNetList"+i);
					/* Added V190320-Aravindh/MMS-DM-CRF-0129/Ends */
					record[22]=(String) hash.get("dailyLmtIndicator"+i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					record[23]=(String) hash.get("dailyLmtQty"+i);//Added V190626-Aravindh/MMS-DM-CRF-0129.1
					blng_grp_rate_srv_exc_list.add(record);				
			   }
			}	
			
			if(blng_grp_rate_srv_excl!=null && blng_grp_rate_srv_excl.size()>0 && blng_grp_rate_srv_excl.containsKey(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim()))
					blng_grp_rate_srv_excl.remove(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim());
			if(blng_grp_rate_srv_exc_list!=null && blng_grp_rate_srv_exc_list.size()>0 ){
				blng_grp_rate_srv_excl.put(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim(),blng_grp_rate_srv_exc_list);	
			}				
			bean3.setBlngGrpRateSrvExcl(blng_grp_rate_srv_excl);	
			
		}else if(func_mode != null && func_mode.equals("BLNG_GRP_CHARGE_BASED" ) ){
			System.out.println("BLNG_GRP_CHARGE_BASED in Validation.jsp ");
			HashMap blng_grp_charge_srv=(HashMap)bean3.getBlngGrpChargeSrv();
			System.out.println("blng_grp_charge_srv in Validation.jsp "+blng_grp_charge_srv);
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String blng_grp_code = "";			
			String fromDate = "";
			String service_code = "";
			
			ArrayList blng_grp_charge_srv_list=new ArrayList();
			System.out.println("blng_grp_charge_srv_list in Validation.jsp "+blng_grp_charge_srv_list);
			for(int i=0;i<totalRec; i++)
			{
			   blng_grp_code = (String) hash.get( "blng_grp_code" );			   
			   fromDate = (String) hash.get( "fromDate" );			
			   service_code = hash.get( "cbCode_"+i  )==null?"":(String) hash.get( "cbCode_"+i  );
			   //service_code = hash.get( "charge_type"+i  )==null?"":(String) hash.get( "charge_type"+i  );
			   System.out.println("blng_grp_code in Validation.jsp "+blng_grp_code);			   
			   System.out.println("fromDate in Validation.jsp "+fromDate);
			   System.out.println("service_code in Validation.jsp "+service_code);

			   if(blng_grp_code!=null && !blng_grp_code.equals("")&& fromDate!=null && !fromDate.equals("") && !service_code.equals(""))
			   {			
					record=new String[15];//Split reqd
					//record=new String[11];
					//record=new String[10];
					record[0]=(String)hash.get( "charge_type"+i );//Added by MuthuN against 28192 on 1-8-12
					System.out.println("charge_type in Validation.jsp "+record[0]);
					record[1]=(String)hash.get( "cbCode_"+i );
					record[2]=(String)hash.get( "cbDesc_"+i );
					record[3]=(String)hash.get( "amt_limit_ind"+i );
					record[4]=(String)hash.get( "perAmt_limit"+i );
					record[5]=(String)hash.get( "roundTo_"+i );
					record[6]=(String)hash.get( "roundInd_"+i );	
					record[7]=hash.get( "refund_"+i )==null?"N":(String)hash.get( "refund_"+i );	
					record[8]=hash.get( "refundAmt_"+i )==null?"0":(String)hash.get( "refundAmt_"+i );	
					record[9]=(String)hash.get( "autoRefund_"+i );	
					record[10]=hash.get( "factor_appl"+i )==null?"":((String)hash.get( "factor_appl"+i ));
					record[11]=hash.get( "srvLmt_"+i )==null?"":((String)hash.get( "srvLmt_"+i ));//muthu against 28192 on 8/24/2012
					//Rajesh V - Split Reqd
					splitReqdChk = (String) hash.get("split_reqd"+i);
					if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
						splitReqdChk = "Y";
					}
					else{
						splitReqdChk = "N";
					}
					record[12]=splitReqdChk;
					//Rajesh V - Split Reqd
					includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
					if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
						includeHomeMedicationChk = "Y";
					}
					else{
						includeHomeMedicationChk = "N";
					}
					record[13]=includeHomeMedicationChk;
					
					enableDisParam = (String) hash.get("enableDisParam"+i);
					record[14]=enableDisParam;
					blng_grp_charge_srv_list.add(record);									
			   }
			}
			if(blng_grp_charge_srv!=null && blng_grp_charge_srv.size()>0 && blng_grp_charge_srv.containsKey(blng_grp_code.trim()+"~~"+fromDate.trim())){
				blng_grp_charge_srv.remove(blng_grp_code.trim()+"~~"+fromDate.trim());
			}
			if(blng_grp_charge_srv_list!=null && blng_grp_charge_srv_list.size()>0 ){
				blng_grp_charge_srv.put(blng_grp_code.trim()+"~~"+fromDate.trim(),blng_grp_charge_srv_list);		
			}			
			bean3.setBlngGrpChargeSrv(blng_grp_charge_srv);				
		}
		else if(func_mode != null && func_mode.equals("BLNG_GRP_CHARGE_BASED_ITEM" ) ){
			HashMap blng_grp_charge_srv_excl=(HashMap)bean3.getBlngGrpChargeSrvExcl();
			String	totalRecords		=	(String) hash.get( "totalRecords" );
			String[] record;
			int totalRec				=	Integer.parseInt(totalRecords);
			String blng_grp_code = "";			
			String fromDate = "";
			String service_code = "";
			String cbCode_ = "";

			ArrayList blng_grp_charge_srv_excl_list=new ArrayList();
			for(int i=0;i<totalRec; i++)
			{
			   blng_grp_code = (String) hash.get( "blng_grp_code" );			   
			   fromDate = (String) hash.get( "fromDate" );			
			   service_code = hash.get( "parent_service_code")==null?"":(String) hash.get( "parent_service_code");			
			   cbCode_ = hash.get( "cbCode_"+i  )==null?"":(String) hash.get( "cbCode_"+i  );						  
			   if(blng_grp_code!=null && !blng_grp_code.equals("") && fromDate!=null && !fromDate.equals("") && !service_code.equals("") && !cbCode_.equals(""))
			   {
					record=new String[8];//Split Reqd
					record[0]=(String)hash.get( "cbCode_"+i );
					record[1]=(String)hash.get( "cbDesc_"+i );				
					record[2]=(hash.get( "inEx_"+i )==null)?"N":(String)hash.get( "inEx_"+i );
					record[3]=(String)hash.get( "quantityLimit_"+i );
					record[4]=(String)hash.get( "amountLimit_"+i );	
					//Rajesh V - Split Reqd
					splitReqdChk = (String) hash.get("split_reqd"+i);
					if("on".equals(splitReqdChk) || "Y".equals(splitReqdChk)){
						splitReqdChk = "Y";
					}
					else{
						splitReqdChk = "N";
					}
					record[5]=splitReqdChk;
					//Rajesh V - Split Reqd
						includeHomeMedicationChk = (String) hash.get("includeHomeMedication"+i);
						if("on".equals(includeHomeMedicationChk) || "Y".equals(includeHomeMedicationChk)){
							includeHomeMedicationChk = "Y";
						}
						else{
							includeHomeMedicationChk = "N";
						}
						record[6]=includeHomeMedicationChk;
						
						enableDisParam = (String) hash.get("enableDisParam"+i);
						record[7]=enableDisParam;
					blng_grp_charge_srv_excl_list.add(record);					
			   }
			}	
			
			if(blng_grp_charge_srv_excl!=null && blng_grp_charge_srv_excl.size()>0 && blng_grp_charge_srv_excl.containsKey(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim()))
					blng_grp_charge_srv_excl.remove(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim());
			if(blng_grp_charge_srv_excl_list!=null && blng_grp_charge_srv_excl_list.size()>0 ){
				blng_grp_charge_srv_excl.put(blng_grp_code.trim()+"~~"+fromDate.trim()+"~~"+service_code.trim(),blng_grp_charge_srv_excl_list);	
			}				
			bean3.setBlngGrpChargeSrvExcl(blng_grp_charge_srv_excl);		
		}
		else if(func_mode!= null && func_mode.equals("delete_blng_grp")){
		int totalRec = Integer.parseInt((String) hash.get( "total_records"));		
		String code="";
		HashMap blng_grp_details=bean3.getBlngGrpDtls();
		HashMap blng_grp_period=bean3.getBlngGrpPeriod();
		HashMap blng_grp_base_price=bean3.getBlngGrpBasePrice();// for rate based services dtls	
		HashMap blng_grp_rate_srv=bean3.getBlngGrpRateSrv();// for rate based services dtls
		HashMap blng_grp_rate_srv_excl=bean3.getBlngGrpRateSrvExcl();// for rate based services dtls	
		HashMap blng_grp_charge_srv=bean3.getBlngGrpChargeSrv();// for rate based services dtls
		HashMap blng_grp_charge_srv_excl=bean3.getBlngGrpChargeSrvExcl();// for rate based services dtls
		Set<String> keySet;
		Iterator<String> iterator;
		String key="";
		for(int i=0;i<totalRec;i++){
			code=((String)hash.get( "key"+i)).trim();
			if(blng_grp_details!=null && blng_grp_details.size()>0){
				keySet=(Set<String>)blng_grp_details.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_details.remove(key);				
					}
				}
			}
			if(blng_grp_period!=null && blng_grp_period.size()>0){
				keySet=(Set<String>)blng_grp_period.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_period.remove(key);				
					}
				}
			}
			if(blng_grp_base_price!=null && blng_grp_base_price.size()>0){
				keySet=(Set<String>)blng_grp_base_price.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_base_price.remove(key);				
					}
				}
			}
			if(blng_grp_rate_srv!=null && blng_grp_rate_srv.size()>0){
				keySet=(Set<String>)blng_grp_rate_srv.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_rate_srv.remove(key);				
					}
				}
			}
			if(blng_grp_rate_srv_excl!=null && blng_grp_rate_srv_excl.size()>0){
				keySet=(Set<String>)blng_grp_rate_srv_excl.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_rate_srv_excl.remove(key);				
					}
				}
			}
			if(blng_grp_charge_srv!=null && blng_grp_charge_srv.size()>0){
				keySet=(Set<String>)blng_grp_charge_srv.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_charge_srv.remove(key);				
					}
				}
			}
			if(blng_grp_charge_srv_excl!=null && blng_grp_charge_srv_excl.size()>0){
				keySet=(Set<String>)blng_grp_charge_srv_excl.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_charge_srv_excl.remove(key);				
					}
				}
			}
		}
		
		bean3.setBlngGrpDtls(blng_grp_details);
		bean3.setBlngGrpPeriod(blng_grp_period);
		bean3.setBlngGrpBasePrice(blng_grp_base_price);
		bean3.setBlngGrpRateSrv(blng_grp_rate_srv);
		bean3.setBlngGrpRateSrvExcl(blng_grp_rate_srv_excl);
		bean3.setBlngGrpChargeSrv(blng_grp_charge_srv);
		bean3.setBlngGrpChargeSrvExcl(blng_grp_charge_srv_excl);
	}else if(func_mode!= null && func_mode.equals("delete_blng_grp_period")){
		int totalRec = Integer.parseInt((String) hash.get( "total_records"));		
		String code="";
		HashMap blng_grp_period=bean3.getBlngGrpPeriod();
		HashMap blng_grp_base_price=bean3.getBlngGrpBasePrice();// for rate based services dtls	
		HashMap blng_grp_rate_srv=bean3.getBlngGrpRateSrv();// for rate based services dtls
		HashMap blng_grp_rate_srv_excl=bean3.getBlngGrpRateSrvExcl();// for rate based services dtls	
		HashMap blng_grp_charge_srv=bean3.getBlngGrpChargeSrv();// for rate based services dtls
		HashMap blng_grp_charge_srv_excl=bean3.getBlngGrpChargeSrvExcl();// for rate based services dtls
		Set<String> keySet;
		Iterator<String> iterator;
		String key="";
		for(int i=0;i<totalRec;i++){
			code=((String)hash.get( "key"+i)).trim();
			if(blng_grp_period!=null && blng_grp_period.size()>0){
				keySet=(Set<String>)blng_grp_period.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_period.remove(key);				
					}
				}
			}
			if(blng_grp_base_price!=null && blng_grp_base_price.size()>0){
				keySet=(Set<String>)blng_grp_base_price.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_base_price.remove(key);				
					}
				}
			}
			if(blng_grp_rate_srv!=null && blng_grp_rate_srv.size()>0){
				keySet=(Set<String>)blng_grp_rate_srv.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_rate_srv.remove(key);				
					}
				}
			}
			if(blng_grp_rate_srv_excl!=null && blng_grp_rate_srv_excl.size()>0){
				keySet=(Set<String>)blng_grp_rate_srv_excl.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_rate_srv_excl.remove(key);				
					}
				}
			}
			if(blng_grp_charge_srv!=null && blng_grp_charge_srv.size()>0){
				keySet=(Set<String>)blng_grp_charge_srv.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_charge_srv.remove(key);				
					}
				}
			}
			if(blng_grp_charge_srv_excl!=null && blng_grp_charge_srv_excl.size()>0){
				keySet=(Set<String>)blng_grp_charge_srv_excl.keySet();
				iterator=keySet.iterator();
				while(iterator.hasNext()){
				key=(String)iterator.next();
					if(key.startsWith(code)){
						blng_grp_charge_srv_excl.remove(key);				
					}
				}
			}
		}
	
		bean3.setBlngGrpPeriod(blng_grp_period);
		bean3.setBlngGrpBasePrice(blng_grp_base_price);
		bean3.setBlngGrpRateSrv(blng_grp_rate_srv);
		bean3.setBlngGrpRateSrvExcl(blng_grp_rate_srv_excl);
		bean3.setBlngGrpChargeSrv(blng_grp_charge_srv);
		bean3.setBlngGrpChargeSrvExcl(blng_grp_charge_srv_excl);
		}else if(func_mode!= null && func_mode.equals("delete_blng_grp_rate_based")){	
			int totalRec = Integer.parseInt((String) hash.get( "total_records"));
			String code="";
			HashMap blng_grp_rate_srv_excl=bean3.getBlngGrpRateSrvExcl();// for rate based services dtls	
			for(int i=0;i<totalRec;i++){
				code=((String)hash.get( "key"+i)).trim();
				if(blng_grp_rate_srv_excl!=null && blng_grp_rate_srv_excl.size()>0 && blng_grp_rate_srv_excl.containsKey(code)){
					blng_grp_rate_srv_excl.remove(code);
				}
			}	
			bean3.setBlngGrpRateSrvExcl(blng_grp_rate_srv_excl);	
		}else if(func_mode!= null && func_mode.equals("delete_blng_grp_charge_based")){
			int totalRec = Integer.parseInt((String) hash.get( "total_records"));
			String code="";
			HashMap blng_grp_charge_srv_excl=bean3.getBlngGrpChargeSrvExcl();// for rate based services dtls	
			for(int i=0;i<totalRec;i++){
				code=((String)hash.get( "key"+i)).trim();
				if(blng_grp_charge_srv_excl!=null && blng_grp_charge_srv_excl.size()>0 && blng_grp_charge_srv_excl.containsKey(code)){
					blng_grp_charge_srv_excl.remove(code);
				}
			}	
			bean3.setBlngGrpChargeSrvExcl(blng_grp_charge_srv_excl);	
		}else if(func_mode!= null && func_mode.equals("chk_VAT_Eff_Date")){  // VAT related Date Validation Agaisnt Incident No - ATE-BL-MMS-73588
			SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
			String FacilityId=request.getParameter("facId");
			String ruleCode=request.getParameter("ruleCode");
			String fromdate=request.getParameter("fromdate");
			java.util.Date dateFrom = inputFormat.parse(fromdate);
			String effTo="";
			String effFrom="";
			String alertFlag="N";
			String vatQuery="SELECT  TO_CHAR (Min(EFF_DATE_FROM), 'dd/MM/yyyy') ,TO_CHAR (Min(EFF_DATE_TO), 'dd/MM/yyyy') FROM BL_ADDL_CHARGE_RULE WHERE RULE_CODE = ? AND FACILITY_ID = ?";
			pstmtVAT = con.prepareStatement(vatQuery);
			pstmtVAT.setString(1, ruleCode);
			pstmtVAT.setString(2, FacilityId);
			rsVAT = pstmtVAT.executeQuery();
			while(rsVAT.next()){
				effFrom=checkForNull(rsVAT.getString(1));
				effTo=checkForNull(rsVAT.getString(2));
			}
			rsVAT.close();
			pstmtVAT.close();
			if(!effFrom.equals("")){
				java.util.Date dateeffFrom = inputFormat.parse(effFrom);
				if(dateFrom.compareTo(dateeffFrom) < 0){
					alertFlag="Y";
				}
				if(!effTo.equals("")){
					java.util.Date dateeffTo = inputFormat.parse(effTo);
					if(dateFrom.compareTo(dateeffTo) > 0){
						alertFlag="Y";
					}
				}
			}
			if(alertFlag.equals("Y")){
				out.println("~E");
			}else{
				out.println("~S");
			}
		// VAT related Date Validation Agaisnt Incident No - ATE-BL-MMS-73588	
		}
		//Ended By Shikha For GHL-CRF-0520.1
}catch (Exception e) {
	e.printStackTrace();
	System.out.println("Exception from PkgDefValidation :"+e);
}
finally
{
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
	if(con!=null) ConnectionManager.returnConnection(con);
}
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean1,request);
	putObjectInBean(bean_id3,bean3,request); //Added By Shikha For GHL-CRF-0520.1

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
