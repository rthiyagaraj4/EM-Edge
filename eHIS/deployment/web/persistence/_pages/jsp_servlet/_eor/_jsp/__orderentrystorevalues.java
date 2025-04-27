package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.util.Iterator;
import java.io.*;
import eOR.Common.*;
import eOR.*;
import eBL.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentrystorevalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryStoreValues.jsp", 1721997624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
----------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Description
----------------------------------------------------------------------------------------------------------------------------
?            100            ?           		created
13/06/2013	IN038776		Ramesh G			This is a child cr for  MMS-QH-CRF- 0042 to cover the Billing related changes
----------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try
	{
		
		String function_from = request.getParameter("function_from")==null?"":request.getParameter("function_from");//IN030469
		//IN030469, starts
		if(function_from.equals("STORE_ASSESS_CATALOG"))
		{
			Hashtable hash 		   = (Hashtable)XMLobj.parseXMLString( request ) ;
			hash 				   = (Hashtable)hash.get( "SEARCH" ) ;
			String check_box_value = (String)hash.get("CHECK_BOX_VALUE");
			String l_patientId = request.getParameter("l_patientId")==null?"":request.getParameter("l_patientId");
			String l_encounter_id = request.getParameter("l_encounter_id")==null?"":request.getParameter("l_encounter_id");
			session.putValue(l_patientId+l_encounter_id+"CHK_BOX",check_box_value);
			HashMap hashEntry = new HashMap();
				
			StringTokenizer strToken = new StringTokenizer(check_box_value,",");
			ArrayList tempArr = new ArrayList();

			while(strToken.hasMoreTokens())
			{
				tempArr.add(strToken.nextToken());	
			}

			String selectedValue = "";
			String selectedValueSub = "";

			for(int i=0;i<tempArr.size();i++)
			{
				if(hash.containsKey(tempArr.get(i)))
				{
					selectedValue = (String)tempArr.get(i);
					selectedValueSub = selectedValue.substring(2);
					hashEntry.put("h1"+selectedValueSub,hash.get("h1"+selectedValueSub));//h1 = Order Category
					hashEntry.put("h2"+selectedValueSub,hash.get("h2"+selectedValueSub));//h2 = Order Type
					hashEntry.put("ck"+selectedValueSub,hash.get("ck"+selectedValueSub));//ck = Checkbox
				}
			}

			session.putValue(l_patientId+l_encounter_id+"CHK_BOX_DTLS",hashEntry);
			System.out.println("OrderEntryStoreValues.jsp,49,check_box_value=>"+session.getValue(l_patientId+l_encounter_id+"CHK_BOX_DTLS"));

		}//IN030469
		//[IN038776]Start
		else if(function_from.equals("SCRENING_SERVICES"))
		{
			String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");//IN030469
			String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");//IN030469
			String key				= (patient_id+encounter_id); // Unique key to keep the Value in the Bean
			String beanId = "BLScreenServiceBean"; 
			String beanName = "eBL.BLScreenServiceBean"; 
			BLScreenServiceBean blScreenServiceBean         =  (BLScreenServiceBean)com.ehis.persist.PersistenceHelper.getBeanObject(beanId, beanName, request); 
			HashMap hashEntry = new HashMap();
			ArrayList  ar= new ArrayList();
			ar= (ArrayList)blScreenServiceBean.getSaveIdValueList();
			StringBuffer query_ = new StringBuffer();
			for(int i=0;i<ar.size();i++){
				query_.append("'"+ar.get(i)+"'");
				if(i!=((ar.size())-1))
					query_.append(",");
			}
			session.setAttribute(patient_id+"ScreeningServiceValues",query_.toString()); 
			String orderQuery = "select order_catalog_code occ,order_category oc,order_type_code otc from or_order_catalog_lang_vw where  language_id='en' and order_catalog_code in("+query_.toString()+")";
					
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(orderQuery);
			rs = pstmt.executeQuery();
			
			StringBuffer check_box_ = new StringBuffer();	
			int chb = 0;
			while(rs!=null && rs.next()){	
				if(chb!=0)
					check_box_.append(",");
				hashEntry.put("h1"+(String)rs.getString("occ"),(String)rs.getString("oc"));//h1 = Order Category
				hashEntry.put("h2"+(String)rs.getString("occ"),(String)rs.getString("otc"));//h2 = Order Type
				hashEntry.put("ck"+(String)rs.getString("occ"),"Y");//ck = Checkbox
				check_box_.append("ck"+(String)rs.getString("occ"));
				chb++;
			} 
			
			if(rs!=null)rs.close();
			if(pstmt!=null)rs.close();
			if(con!=null)con.close();
			
			String bean_id 			= request.getParameter( "bean_id" ) ;
			String bean_name 		= request.getParameter( "bean_name" ) ;		
			String localeName=request.getParameter("localeName");
			
			if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
				return ;
			
			OrderEntryBean	beanObj  = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
			beanObj.setLanguageId(localeName);
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
			String check_box_value	= beanObj.checkForNull(check_box_.toString(),"") ;
			
			if(session.getAttribute(patient_id+"Check_Boxs")!=null && !"".equals((String)session.getAttribute(patient_id+"Check_Boxs"))){		
				check_box_value = check_box_value+","+(String)session.getAttribute(patient_id+"Check_Boxs");
			}
			session.setAttribute(patient_id+"Check_Boxs",check_box_value);
			beanObj.setCatalogCodes(check_box_value); //Set the value in the bean after putting it into the Array List
			
			StringTokenizer tokenComma=null;
			String temp="";		
			ArrayList checked_catalogs=new ArrayList();
			boolean exists=false;
			tokenComma=new StringTokenizer(check_box_value,",");
			while(tokenComma.hasMoreTokens()){
				temp=tokenComma.nextToken();
				if(!checked_catalogs.contains(temp))
					checked_catalogs.add(temp);
			}
			
			String checkedValue 	= "";
			String checkedKey   	= "";
			String hid1Value		= "";		//Hidden Field For Order Category
			String hid2Value		= "";		//Hidden Field For Order Type Code
			String entryValue   	= null;
			String keyItems[]		= null;
			
			HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
			Set setValues			= null;
			Iterator iterator 		= null;
			if(previousValues!=null)		// Get the Previous Values from the Bean
			{
				setValues 			= previousValues.keySet();
				String order_category	= "";
				String order_type		= "";
				String chk_value="";
				iterator 				= setValues.iterator();
				for(int i=0;i<previousValues.size();i++)
				{
					entryValue 	 = ((String)iterator.next()) ;
					chk_value= (String)previousValues.get(entryValue);
					keyItems	 = orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
					if( keyItems[0].equals("ck"))     // If it is a check Box, then put the entry into a hashmap with the value as "Y"
					{
						if(!chk_value.equals("N"))
						{		
							if(checked_catalogs.contains(entryValue))
							{
								if(!hashEntry.containsKey(entryValue))
									hashEntry.put(entryValue,"Y");
							}
						}
					}
					else // If it is hidden Field
					{
						if( keyItems[0].equals("h1"))     // If it is a hidden (h1--denotes order_category)
						{
							order_category = (String)previousValues.get("h1"+keyItems[1]) ;
							if(!hashEntry.containsKey("h1"+keyItems[1]))
							{
								if(checked_catalogs.contains("ck"+keyItems[1]))
								{
									hashEntry.put("h1"+keyItems[1],order_category) ;
								}
							}
						}
						else if( keyItems[0].equals("h2"))  // If it is a hidden (h2--denotes order_type_code)
						{
							order_type     = (String)previousValues.get("h2"+keyItems[1]) ;
							if(!hashEntry.containsKey("h2"+keyItems[1]))
							{
								if(checked_catalogs.contains("ck"+keyItems[1]))
								{
									hashEntry.put("h2"+keyItems[1],order_type) ;
								}
							}
						}
					}
				} // End of previousValues.size() 
			}
			orderEntryRecordBean.setCheckedEntries(key, hashEntry);	
			putObjectInBean(bean_id,beanObj,request);
		} //[IN038776]End.
		else//IN030469
		{
			request.setCharacterEncoding("UTF-8");

			String bean_id 			= request.getParameter( "bean_id" ) ;
			String bean_name 		= request.getParameter( "bean_name" ) ;
			//String function_from 		= request.getParameter( "function_from" )==null?"":request.getParameter("function_from") ;//IN030469
			String localeName=request.getParameter("localeName");
		
			if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
				return ;
			// Dynamic Jsp when on click of the tab buttons or search or any other button to store the
			// values (checked) in the bean
			/* Initialize Function specific start */
			//OrderEntryBean beanObj = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
			OrderEntryBean	beanObj  = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
				beanObj.setLanguageId(localeName);
			/* Initialize Function specific end */
			Hashtable hash 		   = (Hashtable)XMLobj.parseXMLString( request ) ;
			hash 				   = (Hashtable)hash.get( "SEARCH" ) ;
			eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
			// If it is a new patient set it, other wise get the patient id
			//orderEntryRecordBean.getPatient(beanObj.getPatientId());
			/* Initialize Function specific start */


			// When pressing the Place Order Tab, this is to keep track of the code selected(by the order selected)
			String check_box_value	= beanObj.checkForNull(request.getParameter( "check_box_value" ),"") ;
			if(check_box_value.equals("")){
				check_box_value = beanObj.checkForNull((String)hash.get("CHECK_BOX_VALUE"),"");
			}
			beanObj.setCatalogCodes(check_box_value); //Set the value in the bean after putting it into the Array List
			//ArrayList arrCheck = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
			StringTokenizer tokenComma=null;
			String temp="";		
			ArrayList checked_catalogs=new ArrayList();
			boolean exists=false;
			tokenComma=new StringTokenizer(check_box_value,",");
			while(tokenComma.hasMoreTokens())
			{
				temp=tokenComma.nextToken();
				if(!checked_catalogs.contains(temp))
				checked_catalogs.add(temp);
			}				
			HashMap hashEntry 		= new HashMap();
			boolean status 			= false;
			String checkedValue 	= "";
			String checkedKey   	= "";
			String hid1Value		= "";		//Hidden Field For Order Category
			String hid2Value		= "";		//Hidden Field For Order Type Code
			String entryValue   	= null;
			String keyItems[]		= null;

			String key				= (beanObj.getPatientId()+beanObj.getEncounterId());  // Unique key to keep the Value in the Bean
				// Call the below method from the bean to check if any previous values are there in the bean
				// If any records are there, then fetch them and put it in the hashmap,
				// so that u can checked the existing entries (already)
				
			HashMap previousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
		//	(String)previousValues.get("h2"+records[0])).equals(orderTypeRecords[0])
			Set setValues			= null;
			Iterator iterator 		= null;
			if(previousValues!=null)		// Get the Previous Values from the Bean
			{
				setValues 			= previousValues.keySet();
				String order_category	= "";
				String order_type		= "";
				String chk_value="";
				iterator 				= setValues.iterator();
				for(int i=0;i<previousValues.size();i++)
				{
					entryValue 	 = ((String)iterator.next()) ;
					chk_value= (String)previousValues.get(entryValue);
					keyItems	 = orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
					if( keyItems[0].equals("ck"))     // If it is a check Box, then put the entry into a hashmap with the value as "Y"
					{
						if(!chk_value.equals("N"))
						{		
							if(checked_catalogs.contains(entryValue))
							{
								if(!hashEntry.containsKey(entryValue))
									hashEntry.put(entryValue,"Y");
							}
						}
					}
					else // If it is hidden Field
					{
						if( keyItems[0].equals("h1"))     // If it is a hidden (h1--denotes order_category)
						{
							order_category = (String)previousValues.get("h1"+keyItems[1]) ;
							if(!hashEntry.containsKey("h1"+keyItems[1]))
							{
								if(checked_catalogs.contains("ck"+keyItems[1]))
								{
									hashEntry.put("h1"+keyItems[1],order_category) ;
								}
							}
						}
						else if( keyItems[0].equals("h2"))  // If it is a hidden (h2--denotes order_type_code)
						{
							order_type     = (String)previousValues.get("h2"+keyItems[1]) ;
							if(!hashEntry.containsKey("h2"+keyItems[1]))
							{
								if(checked_catalogs.contains("ck"+keyItems[1]))
								{
									hashEntry.put("h2"+keyItems[1],order_type) ;
								}
							}
						}
					}
				} // End of previousValues.size() 
			}

			// When this dynamic jsp is called if any check box is checked or unchecked,
			// then it will come into this loop, get the values and it will set it into the bean

			for (Enumeration e = hash.keys() ; e.hasMoreElements();) 
			{
		 
				status 			= false;
				checkedKey  	= ((String) e.nextElement()); 		// To get the Key of the Element
				// This Method getKey() from the OrderEntryRecordBean will return a array with 2 values,
				// one containing that whether it is a checkbox or hidden field and the other one will give the code, When the Code or string is passed
				keyItems		= orderEntryRecordBean.getKey(checkedKey);
				if( keyItems[0].equals("ck") ) 
				{   // If it is a check Box
					checkedValue 	= ((String)hash.get(checkedKey)); 			// To get the Value for the Element (checkbox is checked)
					hid1Value 		= ((String)hash.get("h1"+keyItems[1])); 	// To get the Value for the Element (Order Category)
					hid2Value  		= ((String)hash.get("h2"+keyItems[1])); 	// To get the Value for the Element (Order Type Code)
					
					exists=checked_catalogs.contains(checkedKey);
					if(!exists)
					{
						orderEntryRecordBean.removeCheckedEntries (key,checkedKey);
						hashEntry.remove(checkedKey);
						hashEntry.remove("h1"+keyItems[1]);
						hashEntry.remove("h2"+keyItems[1]);
							
					}
					
					if(checkedValue.equals("Y"))	// If the check box value is set as "Y" (i.e checked)
					{
						// containKey method in OrderEntryRecordBean will return whether the entry is there in the bean or not
						status 		=  orderEntryRecordBean.containsValue(key,checkedKey);
						if(!status) 
						{ // If not found,put it in the bean
							hashEntry.put(checkedKey,checkedValue);          // Remove the Catalog Code (hashEntry.put(checkedKey,checkedValue);)
							hashEntry.put("h1"+keyItems[1],hid1Value);		 // Remove the Order Category
							hashEntry.put("h2"+keyItems[1],hid2Value);		 // Remove the Order Type Code

						}
					}
					else  // If the check box has not been checked
					{
						// containKey method in OrderEntryRecordBean will return whether the entry is there in the bean or not
						status 		=  orderEntryRecordBean.containsValue(key,checkedKey);
						if(status)  // true, then remove the value (If the entry is found in the bean but from the current page it may be unchecked, then we have to remove it from the bean)
						{
							// removeCheckedEntries method in the OrderEntryRecordBean will remove the entry from the bean
							orderEntryRecordBean.removeCheckedEntries (key,checkedKey);
							hashEntry.remove(checkedKey);
							hashEntry.remove("h1"+keyItems[1]);
							hashEntry.remove("h2"+keyItems[1]);
						}
					}
				}
			}
			// Then after iterating and getting the values in the hashmap, then set it into the bean with the key(patient_id+encounter_id)
			// setCheckedEntries method in the OrderEntryRecordBean will set the values in the bean
			//boolean statusVal = orderEntryRecordBean.setCheckedEntries(key, hashEntry);
		
			//[IN038776] Start.
			
			String query_=(String)session.getAttribute(beanObj.getPatientId()+"ScreeningServiceValues");  
			if(!"".equals(query_)){
				String orderQuery = "select order_catalog_code occ,order_category oc,order_type_code otc from or_order_catalog_lang_vw where  language_id='en' and order_catalog_code in("+query_+")";			
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(orderQuery);
				rs = pstmt.executeQuery();
				
				StringBuffer check_box_ = new StringBuffer();	
				int chb = 0;
				while(rs!=null && rs.next()){	
					if(chb!=0)
						check_box_.append(",");
					hashEntry.put("h1"+(String)rs.getString("occ"),(String)rs.getString("oc"));//h1 = Order Category
					hashEntry.put("h2"+(String)rs.getString("occ"),(String)rs.getString("otc"));//h2 = Order Type
					hashEntry.put("ck"+(String)rs.getString("occ"),"Y");//ck = Checkbox
					check_box_.append("ck"+(String)rs.getString("occ"));
					chb++;
				} 			
				if(rs!=null)rs.close();
				if(pstmt!=null)rs.close();
				if(con!=null)con.close();
				beanObj.setCatalogCodes(beanObj.checkForNull(request.getParameter( "check_box_value" ),"")+","+check_box_);	
				session.setAttribute(beanObj.getPatientId()+"Check_Boxs",beanObj.checkForNull(request.getParameter( "check_box_value" ),"")+","+check_box_);
			}else{
				session.setAttribute(beanObj.getPatientId()+"Check_Boxs",beanObj.checkForNull(request.getParameter( "check_box_value" ),""));
			}
			//[IN038776] End.	
		
			orderEntryRecordBean.setCheckedEntries(key, hashEntry);
			//java.util.HashMap val = (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
			//if(val!=null)	out.println( "alert(\"" + val.size()+ "\") ; " ) ;
			
			// Nullifying the objects
			hashEntry			= null;			hash		= null;		
			hashEntry 			= null;			keyItems	= null;	
			previousValues		= null;

			// set it back persistence
			putObjectInBean(bean_id,beanObj,request);
		}
	}//IN030469
	catch(Exception e)
	{e.printStackTrace();}


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
