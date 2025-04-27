
 /*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
28/04/2020  				IN:071537       	 B Haribabu                                        			 GHL-CRF-0614
08/06/2020                  IN:072715            B Haribabu                                                  GHL-ICN-0071
28/10/2020                  IN:074177            B Haribabu                                                  GHL-ICN-0079
--------------------------------------------------------------------------------------------------------------------------------------------
*/  
package ePH ;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer ;
//import java.util.logging.Logger;// commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Element;   
//import javax.xml.xpath.*; // June - 2012

import javax.xml.xpath.XPath;					 //IN066787- Performance
import javax.xml.xpath.XPathConstants;			 //IN066787- Performance
import javax.xml.xpath.XPathExpression;			 //IN066787- Performance
import javax.xml.xpath.XPathExpressionException; //IN066787- Performance
import javax.xml.xpath.XPathFactory;			 //IN066787- Performance 

import javax.xml.transform.dom.DOMSource;// June - 2012
 // June - 2012
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory; 
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

// Till here - June - 2012

import org.xml.sax.InputSource;
import java.io.Serializable ;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import ePH.Common.PhAdapter;
//import com.cmpmedica.mims.poc.*;  // commented for // commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
//import org.jinterop.dcom.common.JISystem;  // commented for // commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
//import comcheck.CimsXMLNodec; // IN063877
import com.cims.xml.FilterQuery; //IN063877
import com.mims.cds.*;// Newly Added for // commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002

//import com.cims.xml.CimsXMLNode;    // IN063877
//import com.mims.poc.FastTrackConnectionPool;

public class CIMSExternalDataBaseBean extends PhAdapter implements Serializable{

	private static String host			= ""; // Server IP
	private static String domain		= ""; // Windows AD domain for
	private static String user			= ""; // Windows domain user for
	private static String pass			= ""; // Windows domain password
	private static String mrc			= ""; // Absolute
	private static String mrcPass		= "";
	//private static String result		= "";   //Removed for IN063877 // private String interaction_message= "";
	private static String debugMsg		= "";
	//static JFastTrack server			= null;

//	private ArrayList interactionMessage= new ArrayList();// commented for // commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
//private HashMap healthInteractionMessage = new HashMap();  /* Added in JUNE 2012 - New changes - Health Care Interaction */// commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
	private String age_years			= "", age_months = "", age_days = ""; //Added in Jan 2014 - Dosage
	private String gender				= ""; //Added in Jan 2014 - Dosage

//	private ArrayList<String> alInterDrugList	= new ArrayList<String>();// commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
//  private ArrayList<String> alInterDrugListTemp	= new ArrayList<String>();// commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
//	private String request				= "";
	private StringBuffer request		= new StringBuffer();  			 // uncommented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
//	private boolean mirror				= true;// commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002

	/* Constants Defined for CIMS */
	// In case of change, change this constants.
	//public static final boolean GGPI = "GGPI";
	/* Constants */
	 
	// j-interop defaults to verbose logging 
    // jiLogger.setLevel(java.util.logging.Level.parse("WARNING"));
//	private static java.util.logging.Logger  jiLogger =java.util.logging.Logger.getLogger("org.jinterop");

	static FastTrackDSM ft	=		null;
	
	static{


/* commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002

		//jiLogger.setLevel(java.util.logging.Level.parse("WARNING"));		//Log set to warning
		// Leo
		// Enable internal protocol logging to directory specified in java.io.tmpdir, file will be named j-InteropX.log, where X in {0,1,2,3,...}
		try{
			if(debugMsg.equals("Y")){
				JISystem.setInBuiltLogHandler(false);
				jiLogger.setLevel(java.util.logging.Level.parse("FINEST"));		//Log set to warning
				System.err.println("==java.io.tmpdir===Path=="+System.getProperty("java.io.tmpdir"));
			}
			else
				jiLogger.setLevel(java.util.logging.Level.parse("WARNING")); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
*/
		//System.err.println("=============Entererd into static method=================");
		// Leo
		loadInitializeCIMS() ;
	}
	
	// To get MIMS Instance and get the MIMS Connection. This method will be called when ever request comes to get MIMS Details.
	// Once it is initalized and connection taken next time onwards it will check if the instance is there it will give the same connection otherwise it will try to give the next connection
	public static void getMIMSInstance() {  // ICN-Feb-2022
		
		System.err.println("CIMS External Database Bean -->Before checking FT Obejct in getMIMSInstance -- "+ft+"System.currentTimeMillis()"+System.currentTimeMillis());   // ICN-Feb-2022	
		if(ft==null) {
		   	ft	=new FastTrackDSM(); // ICN-Feb-2022
		   	loadMIMSConnection();	
		}   	
		System.err.println("CIMS External Database Bean  -->After checking FT Obejct in getMIMSInstance -- "+ft+"System.currentTimeMillis()"+System.currentTimeMillis());   // ICN-Feb-2022
	}  // ICN-Feb-2022
	
	// To be called periodically through Job every night at 11:30 to release the connection through Job  
	public static void releaseMIMSConnection() {  // ICN-Feb-2022
	
		System.err.println("CIMS External Database Bean -->Before releaseMIMSConnection -- FT OBJECT "+ft+"System.currentTimeMillis()"+System.currentTimeMillis());   // ICN-Feb-2022	
		if(ft!=null) {     // FEB-ICN-2022
		   ft.release();   // FEB-ICN-2022
		   ft=null;        // FEB-ICN-2022
		}   
		System.err.println("CIMS External Database Bean -->After releaseMIMSConnection -- FT OBJECT "+ft+"System.currentTimeMillis()"+System.currentTimeMillis());  // ICN-Feb-2022
	} // ICN-Feb-2022

    private static void loadMIMSConnection() { // ICN-FEB-2022 
    	//FastTrackDSM ft	=new FastTrackDSM();
		
    	System.err.println("CIMS External Database Bean --> Before taking a MIMS connection in  loadMIMSConnection -- FT OBJECT -- "+ft+"System.currentTimeMillis()"+System.currentTimeMillis());   // ICN-Feb-2022
    	//Get the MIMS Instance
    	//getMIMSInstance();
    	// Only Once this MIMS connection to be open
		if (!ft.open(mrc, mrcPass)) { // ICN-Feb-2022	 
			System.err.println("Configuration Missing..(Not able to OPEN MIMS Database File). Please check Userid and Password of MIMS and FT Object exists or not and its connectivity -- mrc--"+mrc+"mrcPass--"+mrcPass);   // ICN-Feb-2022
		}
		else { // MIMS Connection is retrieved
			System.err.println("MIMS Connection is SUCCESSFUL and FT Objecct is having details == "+ ft+"System.currentTimeMillis()"+System.currentTimeMillis());
		}
    }  // ICN-FEB-2022 	
	
	private static void loadInitializeCIMS() {
		try {
				//System.err.println("=============Enter loadInitializeCIMS =================== ");
				CIMSLoginDetails cimsDetails	= new CIMSLoginDetails();
				host							= cimsDetails.getHost();     // once stabilized xml file and this can be removed - May 2018
				domain							= cimsDetails.getDomain();   // once stabilized xml file and this can be removed - May 2018
				user							= cimsDetails.getUser();     // once stabilized xml file and this can be removed - May 2018
				pass							= cimsDetails.getPass();     // once stabilized xml file and this can be removed  - May 2018
				mrcPass							= cimsDetails.getMrcPass();
				mrc								= cimsDetails.getMrcPath();	
				debugMsg						= cimsDetails.getDebugMsg();	
				//if( host!=null && !host.equals("") && user!=null && !user.equals("") && pass!=null && !pass.equals("") && mrc!=null && !mrc.equals("") && mrcPass!=null && !mrcPass.equals("")) {   // incase of file not there then come out and throw error , all these are mostly mandatory ones...   [IN:063558]
				if(mrc!=null && !mrc.equals("") && mrcPass!=null && !mrcPass.equals("")) {   // MRC & MRC Password is mandatory to take connection [IN:063558]  // only MRC, MRCPass required with this JAVA Library Changes  -  for HSA-ICN-0002 and PMG-2018COMN-CRF-002
				// Leo - create the connection pool using the information from cimDetails
				//FastTrackConnectionPool.init(host, domain, user, pass, mrc, mrcPass);    // commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
			     //loadMIMSConnection();		// ICN-FEB-2022 //Get MIMS Connection only once
					getMIMSInstance();  // ICN-FEB-2022 
				
			}else 	
				System.err.println("MIMS Configuration is NOT PROPER...will not be able to proceed. Please check Userid & Password - mrc"+mrc+"-mrcPass"+mrcPass);   // ICN-Feb-2022	

			
			
			/*server = new JFastTrack(host, domain, user, pass);
			if(debugMsg.equals("Y"))
				System.err.println("loadInitializeCIMS()===mrc="+mrc+" mrcPass="+mrcPass);
			result = server.initializeServer(mrc, mrcPass);
			if(debugMsg.equals("Y"))
				System.err.println("loadInitializeCIMS()===result="+result);*/
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage() + "\n" + e.getStackTrace());
		}
		/*try {
				result = server.releaseServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }

	public StringBuffer loadCIMSDetails(String patientid,String login_by_id,String login_at_ws_no) {	
		//System.err.println(" starting patient id loadCIMSDetails () in cims bean"+patientid+"login id"+login_by_id+"ws"+login_at_ws_no);
		// TODO Auto-generated method stub
		String xmlResult						= "";
		StringBuffer sbf						= new StringBuffer();
		//DocumentBuilderFactory docBuilderFactory= null; //Commented for COMMON-ICN-0048
		//DocumentBuilder docBuilder				= null; //Commented for COMMON-ICN-0048
		//Document doc; //Commented for COMMON-ICN-0048
		
		try {

//			if(server==null){
				if(debugMsg.equals("Y"))
					System.err.println("In loadCIMSDetails() - The FastTrack server has been released. Calling loadInitializeCIMS()");//added log for 7295
			//	loadInitializeCIMS();//EMR-ICN-8023
//			}	
			if(debugMsg.equals("Y"))
				//added for 7295 log HSA-SCF-0001
				System.err.println("In loadCIMSDetails() patientid==="+patientid+"login id="+login_by_id+"ws="+login_at_ws_no +"request="+request.toString());

				// Leo - Replace the try-catch block with requestXmlWithRetry
				xmlResult=requestXmlWithRetry(request.toString(), patientid, login_by_id, login_at_ws_no);// HSA-ICN-0011

			if(debugMsg.equals("Y"))
				System.err.println("In loadCIMSDetails() patientid==="+patientid+"login id="+login_by_id+"ws="+login_at_ws_no +" xmlResult="+xmlResult);//added log for 7295
			sbf = new StringBuffer(); //Added in June 2012
			if(xmlResult != null){
			    sbf.append(xmlResult);	  //Added in June 2012
			}

			

			//docBuilderFactory	= DocumentBuilderFactory.newInstance();
			//docBuilder			= docBuilderFactory.newDocumentBuilder();
			//doc					= docBuilder.parse(new InputSource(new StringReader(xmlResult)));
			//Node root			= doc.getDocumentElement();
			//checkInteractionNodes(root);
			//dispNodes(root, "Drug-Drug-Interaction");  //uncomment for NEW Added MIMS Coding 2018

			 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage() + "\n" + e.getStackTrace());
		} 
		finally {
			return sbf;					   // Added in June 2012
		}
	}
	
	// Leo
//	String requestXmlWithRetry(String req,){   //uncomment for NEW Added MIMS Coding 2018
	String requestXmlWithRetry(String req, String patientid, String login_by_id, String login_at_ws_no){   //uncomment for NEW Added MIMS Coding 2018//HSA-ICN-0011


		//JFastTrack svr	=	FastTrackConnectionPool.getSharedInstance().borrowConnection();  // commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
		//System.err.println("svr@@@@==="+svr);
		

		//boolean done	=	false;
		String result	=	null;
		//int count		=	0;
//System.err.println("========Initial req"+req);
		try {


				// FastTrackDSM ft	=new FastTrackDSM();  // added for HSA-ICN-0002 and PMG-2018COMN-CRF-002  // ICN-Feb-2022
				try{ // try block Added for HSA-ICN-0009 (Only try block not inside content)
					
					if(debugMsg.equals("Y")) //Added debug for Common-icn-0047
						System.err.println("In requestXmlWithRetry BEFORE TAKING CONNECTION patientid==="+patientid+"login id="+login_by_id+"ws="+login_at_ws_no +"mrc="+mrc+"ft="+ft+"System.currentTimeMillis()"+System.currentTimeMillis());

					System.err.println("In requestXmlWithRetry  --> FT OBJECT "+ft);   // ICN-Feb-2022
					
					//	if (!ft.open(mrc, mrcPass))  // ICN-Feb-2022

					//Get the MIMS Instance
					//loadMIMSConnection();
					getMIMSInstance();
					
					if(ft!=null) {// ICN-Feb-2022 // MIMS COnfired always it is will be having object after connection - discussed on 10th March 2022
											
						if(debugMsg.equals("Y")) //Added debug for Common-icn-0047
							System.err.println("In requestXmlWithRetry BEFORE MIMS REQUEST patientid==="+patientid+"login id="+login_by_id+"ws="+login_at_ws_no +"mrc="+mrc+"req=="+req+"System.currentTimeMillis()"+System.currentTimeMillis());
							
						result = ft.requestXml(req.toString());
						
							if(debugMsg.equals("Y")) //Added debug for Common-icn-0047
								System.err.println("In requestXmlWithRetry AFTER MIMS RESPONSE patientid==="+patientid+"login id="+login_by_id+"ws="+login_at_ws_no+"System.currentTimeMillis()"+System.currentTimeMillis());
//								System.err.println("RESULT - NEWLY ADDED MIMS req -- "+req+"result===="+result);
						
								if ( result !=null && ( (!(result.substring(0,7).trim()).equalsIgnoreCase("<Result")) ) ) {
								//IN066787- Performance

//System.err.println("@@@@ ENTER HERE -- 229 if result is not null"+result);
									if ( result !=null && ( (!(result.substring(0,30)).equalsIgnoreCase("The server threw an exception")) ) ) {
										if(debugMsg.equals("Y")) //Added debug for Common-icn-0047
											System.err.println("CIMS Result is not proper...check your GUI CODE being passed in the request...or check Configuration Missing...");
						
									}
								}
						}   // ICN-Feb-2022
				} // try block Added for HSA-ICN-0009 (Only try block not inside content)
				catch(Exception e){ // Added for HSA-ICN-0009 - Start
				     e.printStackTrace();
				}
				finally{  
				//  if(ft!=null){     // FEB-ICN-2022
				//    ft.release();   // FEB-ICN-2022
				    if(debugMsg.equals("Y")) //Added debug for Common-icn-0047
					  System.err.println("In requestXmlWithRetry AFTER RELEASE patientid==="+patientid+"login id="+login_by_id+"ws="+login_at_ws_no+"System.currentTimeMillis()"+System.currentTimeMillis());
				// }
				} // Added for HSA-ICN-0009 - End


			
				/*while (!done) {
					result = svr.requestXML(req.toString());

System.err.println("========Initial result"+result);
					if(svr)
						System.err.println("Configuration Missing.....or connection not able to connect");



					if(debugMsg.equals("Y"))
						System.err.println("count@@@result====="+result);
				
						// If we got a non-XML (error) response from FastTrack, we invalidate this connection and grab a new one
						//if ( result !=null && ((!result.startsWith("<Result ")) || (!result.startsWith("<ResultInformation ")) )  ){
						//if ( result !=null && ( (!(result.substring(0,7)).equalsIgnoreCase("<Result")) || (!(result).substring(0,17).equalsIgnoreCase("<ResultInformation")) ||  //(!result.startsWith("<Result ")) || (!result.startsWith("<ResultInformation ")))  ){
						if ( result !=null && ( (!(result.substring(0,7)).equalsIgnoreCase("<Result")) ) ) {
							//IN066787- Performance

							if ( result !=null && ( (!(result.substring(0,30)).equalsIgnoreCase("The server threw an exception")) ) ) {
								done=true;  //comeout
								System.err.println("CIMS Result is not proper...check your GUI CODE being passed in the request...or check Configuration Missing...");
						
							}
							else {
								FastTrackConnectionPool.getSharedInstance().invalidateConnection(svr);
								Thread.sleep(100);
								svr=FastTrackConnectionPool.getSharedInstance().borrowConnection();
								count++;
								if(debugMsg.equals("Y"))
									System.err.println("count@@@====="+count);
								if(count >= 15) { // IN066787- Performance Come out of the loop and it should not go infinite loop...max can try 250	 [IN:063558]
									done=true;
									System.err.println("Configuration Missing.....or connection not able to connect");
								} 
							}
						} 
						else {
							System.err.println("2222222   :");
							FastTrackConnectionPool.getSharedInstance().returnConnection(svr);
							done=true;
						}
				}*/
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
 
/*  comment for IN066787- Performance NEW Added MIMS Coding 2018
public void dispNodes(Node root, String mode) throws Exception {
		NodeList childRoots = root.getChildNodes();
		for (int i = 0; i < childRoots.getLength(); i++) {
			Node child = childRoots.item(i);
			if (child.getNodeType() == Node.ELEMENT_NODE) {
System.err.println("===child.getNodeName===="+child.getNodeName());
				if (child.getNodeName().equalsIgnoreCase("GGPI")||child.getNodeName().equalsIgnoreCase("Product")||child.getNodeName().equalsIgnoreCase("GenericItem")) {
			//		dispAttributes(child, mode);
					dispNodes(child, mode);
				}
		
				if (mode.equalsIgnoreCase("Drug-Drug-Interaction")
						&& !(child.getNodeName().equalsIgnoreCase("GGPI")&&child.getNodeName().equalsIgnoreCase("Product")&&child.getNodeName().equalsIgnoreCase("GenericItem"))){
					dispDrugDrugInteractionNodes(child);
				}
			}
		}
	}

*/
/*comment for IN066787- Performance 
public void dispAttributes(Node root, String mode) throws Exception {
		NamedNodeMap attributes = root.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Node attribute = attributes.item(i);
			if(attribute.getNodeName().equalsIgnoreCase("mirror")|| mirror==false){
				mirror = false;
				break;
			}
		}
	}
*/


/* comment for IN066787- Performance - NEW Added MIMS Coding 2018
	public void dispDrugDrugInteractionNodes(Node root) throws Exception {
		//if(mirror==true){
			String mode = "Drug-Drug-Interaction";
			if (root.getNodeName().equalsIgnoreCase("Abbreviated")) {
				if (root.getParentNode().getNodeName().equalsIgnoreCase(
						"Interaction")) {
					if (!(this.interactionMessage.contains(root.getTextContent()))) {
						this.interactionMessage.add(root.getTextContent());

					// remove this
					if (root.getParentNode().getParentNode().getNodeName().equalsIgnoreCase("ClassInteraction")) {
						 if (root.getParentNode().getParentNode().getParentNode().getNodeName().equalsIgnoreCase("HealthIssueCode")) {
System.err.println("===ENTER====");							 
/*
							 /* Added in JUNE 2012 - New changes - Health Care Interaction */
/* comment for IN066787- Performance - NEW Added MIMS Coding 2018								String printHealthInteractionMessage = "";
								String printDrugName   = "";
								String printHealthName = "";
								String printHealthDesc = "";
								String printHealthHeading = "";
								String item_name		= "";
								
								if (root.getParentNode().getParentNode().getNodeName().equalsIgnoreCase("ClassInteraction")) {
									if ( (root.getParentNode().getParentNode().getParentNode().getParentNode().getParentNode().getNodeName().equalsIgnoreCase("GGPI") ) || (root.getParentNode().getParentNode().getParentNode().getParentNode().getParentNode().getNodeName().equalsIgnoreCase("Product")) || (root.getParentNode().getParentNode().getParentNode().getParentNode().getParentNode().getNodeName().equalsIgnoreCase("GenericItem") ) ) {
										NamedNodeMap attributesItem = root.getParentNode().getParentNode().getParentNode().getParentNode().getParentNode().getAttributes();
										for (int f = 0; f < attributesItem.getLength(); f++) {
											Node attribute_item = attributesItem.item(f);
											if(attribute_item.getNodeName().equalsIgnoreCase("reference"))   {															
												if(attribute_item.getNodeValue()!=null)
												   item_name = 	attribute_item.getNodeValue();
											}
										 }
									}
									if (root.getNodeName().equalsIgnoreCase("Abbreviated")) {
										if(root.getTextContent()!=null)
											printHealthInteractionMessage +=  "<br><b>Probable Mechanism:</b><br>" + root.getTextContent() +"<br>";
									}
System.err.println("===root.getNodeName()===="+root.getNodeName()+"==printHealthInteractionMessage"+printHealthInteractionMessage);
									NodeList childrenRoot = root.getParentNode().getParentNode().getChildNodes();
									for (int k = 0; k < childrenRoot.getLength(); k++) {
											Node child = childrenRoot.item(k);
											NamedNodeMap attributes = child.getAttributes();
											for (int i = 0; i < attributes.getLength(); i++) {
												Node nodeItem = attributes.item(i);
												if(child.getNodeName().equalsIgnoreCase("Severity") && nodeItem.getNodeName().equalsIgnoreCase("name") && printHealthHeading!=null)
												{
													printHealthHeading = child.getNodeName()+": " +nodeItem.getNodeValue() +" / ";
												} else if(child.getNodeName().equalsIgnoreCase("Documentation") && nodeItem.getNodeName().equalsIgnoreCase("name") && printHealthHeading!=null && child.getTextContent()!=null) {
													printHealthHeading = printHealthHeading + "<b>" +child.getNodeName() + " Level: "+ "</b>" +child.getTextContent();
												} else if(child.getNodeName().equalsIgnoreCase("PrescribingInteractionClass")) { 
													if(nodeItem.getNodeName().equalsIgnoreCase("name")) {
														printHealthName  =  nodeItem.getNodeValue();
													} else if(nodeItem.getNodeName().equalsIgnoreCase("description")) {
														printHealthDesc =   " ( "+ nodeItem.getNodeValue()+ ") " ;
													}

													if (child.getNodeType() == Node.ELEMENT_NODE && printDrugName!=null && printDrugName.equals("")) {
														Element routeElements = (Element)child;
														NodeList routeNodeChilds = routeElements.getChildNodes();
														for (int m=0; m<routeNodeChilds.getLength();m++ )
														{
															Node routeNode = routeNodeChilds.item(m);
															if(routeNode.getNodeName().equalsIgnoreCase("PrescribingMolecule") && printDrugName!=null && printDrugName.equals(""))
															{	
																NamedNodeMap attributesMolecule = routeNode.getAttributes();
																for (int s = 0; s < attributesMolecule.getLength(); s++) {
																	Node nodeItemMolecule = attributesMolecule.item(s);
																	if(nodeItemMolecule.getNodeName().equalsIgnoreCase("name") && printDrugName!=null && printDrugName.equals(""))
																	{
																		printDrugName = nodeItemMolecule.getNodeValue();
																	}
																}
															}
														}
													}
												}
											}
										}	 
									}
System.err.println("===printHealthHeading===="+printHealthHeading+"==printHealthName"+printHealthName+"==printHealthDesc"+printHealthDesc+"printHealthInteractionMessage=="+printHealthInteractionMessage);
									if(printHealthHeading!=null && printHealthInteractionMessage!=null)	  {
										printHealthInteractionMessage =   printHealthHeading + printHealthInteractionMessage;
										if(printHealthName!=null && printHealthDesc!=null)
										  printHealthInteractionMessage  = printHealthInteractionMessage + "<BR> <B> Description of Classes</b> <BR> "+ printDrugName + " belongs to the class of " +printHealthName + printHealthDesc;
										healthInteractionMessage.put(item_name, printHealthInteractionMessage);
									}
								}
						}  
	 		 
						alInterDrugListTemp = new ArrayList<String>();
					}
				}
			}
			else{
				dispNodes(root, mode);
			}
	}

*/
	/* comment for IN066787- Performance Added in JUNE 2012 - New changes - Health Care Interaction */
//	public void dispDrugTheraphyNodes(Node root) throws Exception {
		
//		if (root.getNodeName().equalsIgnoreCase("DuplicateTherapy")) { /* Added in JUNE 2012 - New changes - Health Care Interaction */
				//if (root.getParentNode().getNodeName().equalsIgnoreCase("Interaction")) {
				//	NodeList childrenRoot = root.getParentNode().getChildNodes();
				 
					/*if ( (root.getParentNode().getParentNode().getParentNode().getParentNode().getParentNode().getNodeName().equalsIgnoreCase("GGPI") )|| (root.getParentNode().getParentNode().getParentNode().getParentNode().getParentNode().getNodeName().equalsIgnoreCase("Product"))) {
						NamedNodeMap attributesItem = root.getParentNode().getParentNode().getParentNode().getParentNode().getParentNode().getAttributes();
						for (int f = 0; f < attributesItem.getLength(); f++) {
							Node attribute_item = attributesItem.item(f);
							if(attribute_item.getNodeName().equalsIgnoreCase("reference"))   {															
								if(attribute_item.getNodeValue()!=null)
//								   item_name = 	attribute_item.getNodeValue();
							}
						}
					}  */
		 

				/*NodeList childrenRoot = root.getParentNode().getParentNode().getChildNodes();

				for (int k = 0; k < childrenRoot.getLength(); k++) {
						Node child = childrenRoot.item(k);
						NamedNodeMap attributes = child.getAttributes();
						for (int i = 0; i < attributes.getLength(); i++) {
							Node nodeItem = attributes.item(i);
							if(child.getNodeName().equalsIgnoreCase("Severity") && nodeItem.getNodeName().equalsIgnoreCase("name"))// && printHealthHeading!=null)
							{
//								printHealthHeading = child.getNodeName()+": " +nodeItem.getNodeValue() +" / ";
							} else if(child.getNodeName().equalsIgnoreCase("Documentation") && nodeItem.getNodeName().equalsIgnoreCase("name") && child.getTextContent()!=null) { //&& printHealthHeading!=null  
//								printHealthHeading = printHealthHeading + "<b>" +child.getNodeName() + " Level: "+ "</b>" +child.getTextContent();
							} else if(child.getNodeName().equalsIgnoreCase("PrescribingInteractionClass")) { 
								if(nodeItem.getNodeName().equalsIgnoreCase("name")) {
//									printHealthName  =  nodeItem.getNodeValue();
								} else if(nodeItem.getNodeName().equalsIgnoreCase("description")) {
//									printHealthDesc =   " ( "+ nodeItem.getNodeValue()+ ") " ;
								}

								/*if (child.getNodeType() == Node.ELEMENT_NODE) { // && printDrugName!=null && printDrugName.equals("")) {
									Element routeElements = (Element)child;
									NodeList routeNodeChilds = routeElements.getChildNodes();
									for (int m=0; m<routeNodeChilds.getLength();m++ )
									{
										Node routeNode = routeNodeChilds.item(m);
										if(routeNode.getNodeName().equalsIgnoreCase("PrescribingMolecule")) // && printDrugName!=null && printDrugName.equals(""))
										{	
											NamedNodeMap attributesMolecule = routeNode.getAttributes();
											for (int s = 0; s < attributesMolecule.getLength(); s++) {
												Node nodeItemMolecule = attributesMolecule.item(s);
												if(nodeItemMolecule.getNodeName().equalsIgnoreCase("name")) // && printDrugName!=null && printDrugName.equals(""))
												{
//													printDrugName = nodeItemMolecule.getNodeValue();
												}
											}
										}
									}
								}	
							}
						}  
					}	*/ 
				//}
				/*if(printHealthHeading!=null && printHealthInteractionMessage!=null)	  {
					printHealthInteractionMessage =   printHealthHeading + printHealthInteractionMessage;
					if(printHealthName!=null && printHealthDesc!=null)
					  printHealthInteractionMessage  = printHealthInteractionMessage + "<BR> <B> Description of Classes</b> <BR> "+ printDrugName + " belongs to the class of " +printHealthName + printHealthDesc;
					healthInteractionMessage.put(item_name, printHealthInteractionMessage);
				}
			//} 
	//}/* Added in JUNE 2012 - New changes - Health Care Interaction -- Till Here*/

	/* comment for IN066787- Performance public void dispDrugAllergyNodes(Node root) throws Exception {
		String mode = "Drug-Drug-Interaction";
		NodeList nodeList = root.getChildNodes();
		for(int j=0;j<nodeList.getLength();j++){
			Node chldNode = nodeList.item(j);
			if (chldNode.getNodeType() == Node.ELEMENT_NODE) {
				NamedNodeMap attributes = chldNode.getAttributes();
				for (int i = 0; i < attributes.getLength(); i++) {
					Node attribute = attributes.item(i);
				}
			}
			if((chldNode.getNodeName().equalsIgnoreCase("SubstanceClass"))){
				//dispDrugDrugInteractionNodesAllergySubstance(chldNode);
				NodeList ndlist = chldNode.getChildNodes();
				for(int k=0;k<ndlist.getLength();k++){
					Node chldNodeTemp = ndlist.item(k);
					dispAttributes(chldNodeTemp, "Drug-Drug-Interaction");
				}
			}
			dispDrugAllergyNodes(chldNode);
		}
	}*/

	//public HashMap<String,String> getHealthInteractionMessage(){  /* Added in JUNE 2012 - New changes - Health Care Interaction */ - May 2018 // commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
		//return healthInteractionMessage;
	//}

   /* Fine tuning for performance issue in Brueni.
   -- this method not used at all
	public void dispDrugAllergyNodes(Node root) throws Exception {
		//allergy_desc = "";
		NodeList nodeList = root.getChildNodes();
		String molecule = "";
		for(int j=0;j<nodeList.getLength();j++){
			Node chldNode = nodeList.item(j);
			if((chldNode.getNodeName().equalsIgnoreCase("SubstanceClass"))){
				//this.allergy_desc = this.allergy_desc +"<B>Allergy History:</B> Patient has a known history of allergic reaction to Molecule, " +alPresMolecule.get(0)+". The molecule of allergic item,"+alPresMolecule.get(0)+".";
				//dispDrugDrugInteractionNodesAllergySubstance(chldNode);
				NodeList ndlist = chldNode.getChildNodes();
				for(int k=0;k<ndlist.getLength();k++){
					Node chldNodeTemp = ndlist.item(k);
					dispAttributes(chldNodeTemp, "allergy");
				}
			}
			if (chldNode.getNodeType() == Node.ELEMENT_NODE) {
				NamedNodeMap attributes = chldNode.getAttributes();
				for (int i = 0; i < attributes.getLength(); i++) {
					Node attribute = attributes.item(i);
					if(root.getNodeName().equalsIgnoreCase("Allergy") && chldNode.getNodeName().equalsIgnoreCase("molecule") && attribute.getNodeName().equalsIgnoreCase("name")){
						molecule =  attribute.getNodeValue();
						if(!this.allergy_desc.equals("") ){
							if(this.allergy_desc.indexOf(molecule) == -1 || this.allergy_desc.indexOf(molecule) == 0){
							this.allergy_desc = this.allergy_desc +"<b>WARNING:</b> Patient may be allergic to the prescribing item.<BR><B>Allergy History:</B> Patient has a known history of allergic reaction to Molecule, " +attribute.getNodeValue()+".";
						//allergy_desc = allergy_desc + attribute.getNodeValue()+"<br>";
							}
						}else{
								this.allergy_desc = this.allergy_desc +"<b>WARNING:</b> Patient may be allergic to the prescribing item.<BR><B>Allergy History:</B> Patient has a known history of allergic reaction to Molecule, " +attribute.getNodeValue()+".";
						}
							this.presc_molecule = attribute.getNodeValue();
						
					}

					if(chldNode.getNodeName().equalsIgnoreCase("SubstanceClass") && attribute.getNodeName().equalsIgnoreCase("name")){

						if(this.allergy_desc.indexOf("<BR><B>Prescribing</B>") != -1 ) {
							if((this.allergy_desc.substring(this.allergy_desc.indexOf("Prescribing"))).indexOf(molecule) == -1){
								this.allergy_desc = this.allergy_desc +"<BR><B>Prescribing</B>The molecule of allergic item,"+this.presc_molecule+", belongs to the substance class of  "+ attribute.getNodeValue();
							}
						}
						else{
							this.allergy_desc = this.allergy_desc +"<BR><B>Prescribing</B>The molecule of allergic item,"+this.presc_molecule+", belongs to the substance class of  "+ attribute.getNodeValue();
						}
					}
				}
			}
			dispDrugAllergyNodes(chldNode);
		}	

		//this.allergy_desc = this.allergy_desc + this.presc_molecule+"."+"<BR>Both prescribing and allergic molecule belong to the same class.<BR>";
	}
	*/
	/*public void dispDrugDrugInteractionNodesAllergySubstance(Node root) throws Exception{
		if (root.getNodeName().equalsIgnoreCase("SubstanceClass")) {
			NodeList nodeList = root.getChildNodes();
			for(int j=0;j<nodeList.getLength();j++){
				Node chldNode = nodeList.item(j);
				if (chldNode.getNodeType() == Node.ELEMENT_NODE) {
					NamedNodeMap attributes = chldNode.getAttributes();
					for (int i = 0; i < attributes.getLength(); i++) {
						Node attribute = attributes.item(i);
						//if(attribute.getNodeName().equalsIgnoreCase("name")){
						//}
					}
					//dispAttributes(chldNode.getParentNode(), mode);
				}
			}
		}		
	}*/
	
	/* 
	Removed for Performance Issue - Brueni (unwanted)   (remove it completely from the code after stabilization)
	public void dispDrugDrugInteractionNodesInteractionClass(Node root) throws Exception{
		String temp_flag = "";
		//if(!(func.equals("one"))){

		Node ggpiNode = root.getParentNode().getParentNode();
		NamedNodeMap attrib = ggpiNode.getAttributes();
		for (int i = 0; i < attrib.getLength(); i++) {
			Node attribute = attrib.item(i);
			if(attribute.getNodeName().equalsIgnoreCase("mirror")){
	 			temp_flag = "one";
				//break;
			}
		}
		if (temp_flag.equals("")) {
			NodeList nodeList = root.getChildNodes();
			for(int j=0;j<nodeList.getLength();j++){
				Node chldNode = nodeList.item(j);
				//NodeList ndlist = chldNode.getChildNodes();
				  Fine tuning on performance - Brueni
				if((chldNode.getNodeName().equalsIgnoreCase("PrescribingInteractionClass")) || (chldNode.getNodeName().equalsIgnoreCase("InteractionClass"))){
					NodeList ndlist = chldNode.getChildNodes();
					for(int k=0;k<ndlist.getLength();k++){
						Node chldNodeTemp = ndlist.item(k);
						dispAttributesTemp(chldNodeTemp, "Drug-Drug-Interaction");
					}
				}
				 
				if (chldNode.getNodeType() == Node.ELEMENT_NODE) {
					NamedNodeMap attributes = chldNode.getAttributes();
					for (int i = 0; i < attributes.getLength(); i++) {
						Node attribute = attributes.item(i);
						//if(attribute.getNodeName().equalsIgnoreCase("name")){

							if(chldNode.getNodeName().equalsIgnoreCase("PrescribingInteractionClass")&& attribute.getNodeName().equalsIgnoreCase("description")){
								alPresDesc.add(attribute.getNodeValue());
							}
							if(chldNode.getNodeName().equalsIgnoreCase("PrescribingInteractionClass")&& attribute.getNodeName().equalsIgnoreCase("name")){
								alPresName.add(attribute.getNodeValue());
							}
							if(chldNode.getNodeName().equalsIgnoreCase("InteractionClass")&& attribute.getNodeName().equalsIgnoreCase("description")){
								alInterDesc.add(attribute.getNodeValue());
							}
							if(chldNode.getNodeName().equalsIgnoreCase("InteractionClass")&& attribute.getNodeName().equalsIgnoreCase("name")){
								alInterName.add(attribute.getNodeValue());
							}
						//}
					}
					//dispAttributes(chldNode.getParentNode(), mode);
				}
			}
		//}
		}
	}
	*/

   /* Fine tuning ...this method not required at all...
   For Brueni peformance
	public void dispAttributesTemp(Node root, String mode) throws Exception {

		if(root.getNodeType() == Node.ELEMENT_NODE) {

			NamedNodeMap attributes = root.getAttributes();
			for (int i = 0; i < attributes.getLength(); i++) {
				Node attribute = attributes.item(i);
				if (mode.equalsIgnoreCase("Drug-Drug-Interaction")) {
					if(root.getNodeName().equalsIgnoreCase("PrescribingMolecule")&& attribute.getNodeName().equalsIgnoreCase("name")){
						alPresMolecule.add(attribute.getNodeValue());
					}
					if(root.getNodeName().equalsIgnoreCase("Molecule")&& attribute.getNodeName().equalsIgnoreCase("name")){
						alInterMolecule.add(attribute.getNodeValue());
					}
				}
			}
		}
	}	
   */
	
	
	/* Removed Performance tuning for Brueni 	(unwanted)
	public ArrayList<String> getInteractionMessage(){
		ArrayList<String> alFinalInterMessage = new ArrayList<String>();
		for(int i=0;i<this.interactionMessage.size();i++){
			inter_class_msg = "";
			inter_class_msg = "<BR><BR><B>Description of Classes:</B><BR>";
			if(alPresMolecule.size()>0 && alPresName.size()>0 && alPresDesc.size()>0)
				inter_class_msg = inter_class_msg + alPresMolecule.get(i)+" belongs to the class of "+ alPresName.get(i) +"("+alPresDesc.get(i)+")<BR>";
			if(alInterMolecule.size()>0 && alInterName.size()>0 && alInterDesc.size()>0)
				inter_class_msg = inter_class_msg + alInterMolecule.get(i)+" belongs to the class of "+ alInterName.get(i) +"("+alInterDesc.get(i)+")<BR>";
			alFinalInterMessage.add(i,interactionMessage.get(i)+""+inter_class_msg);
		}
		return alFinalInterMessage;
	}
	*/

	public ArrayList<String> getAllergyDrugList(String patient_id){
		ArrayList<String> allergyDrugList = new ArrayList<String>();
		try{
				Connection connection		 = null ;
				PreparedStatement pstmt		= null ;
				ResultSet resultSet			= null ;
				try {
					connection = getConnection() ;
					boolean third_party_type_appl=eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PH_THIRDPARTY_TYPE_APPL");
					if(third_party_type_appl){
						pstmt = connection.prepareStatement("SELECT DISTINCT ext_prod_generic_id, NVL (TYPE, 'Molecule') TYPE FROM (SELECT ext_prod_generic_id, NVL (thirdparty_type, 'Molecule') TYPE FROM pr_adverse_event_reaction a, pr_allergy_sensitivity c, ph_generic_ext_prod_ref b, pr_adverse_event e WHERE a.adv_event_type = 'DA' AND a.patient_id = ? AND a.allergen_code = b.generic_id AND b.product_id = 'CIMS' AND b.eff_status = 'E' AND a.status = 'A' AND a.patient_id = c.patient_id AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = c.adv_event_type AND a.allergen_code = c.allergen_code AND a.adv_event_srl_no = c.adv_event_srl_no AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.adv_event_dtl_srl_no = e.adv_event_dtl_srl_no AND c.status = 'A' UNION ALL SELECT ext_prod_generic_id, NVL (thirdparty_type, 'Molecule') TYPE FROM pr_adverse_event_reaction a, pr_allergy_sensitivity c, ph_generic_ext_prod_ref b, pr_adverse_event e WHERE a.adv_event_type = 'DA' AND a.patient_id = ? AND a.adv_reac_code = 'OTH' AND a.allergen_code = b.generic_id AND b.product_id = 'CIMS' AND b.eff_status = 'E' AND a.status = 'A' AND a.patient_id = c.patient_id AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = c.adv_event_type AND a.allergen_code = c.allergen_code AND a.adv_event_srl_no = c.adv_event_srl_no AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.adv_event_dtl_srl_no = e.adv_event_dtl_srl_no AND c.status = 'A')") ; //Modified for IN:071537, Modified for IN:072715 
					}
					else{
						pstmt = connection.prepareStatement("SELECT DISTINCT ext_prod_generic_id, NVL (TYPE, 'Molecule') TYPE FROM (SELECT ext_prod_generic_id, NVL (THIRDPARTY_TYPE, 'Molecule') TYPE FROM pr_adverse_event_reaction a, pr_allergy_sensitivity c, ph_generic_ext_prod_ref b, ph_drug d, pr_adverse_event e WHERE a.adv_event_type = 'DA' AND a.patient_id = ? AND d.drug_code IS NOT NULL AND d.generic_id = b.generic_id AND a.allergen_code = d.generic_id AND b.product_id = 'CIMS' AND b.eff_status = 'E' AND a.status = 'A' AND a.patient_id = c.patient_id AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = c.adv_event_type AND a.allergen_code = c.allergen_code AND a.adv_event_srl_no = c.adv_event_srl_no AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.adv_event_dtl_srl_no = e.adv_event_dtl_srl_no AND c.status = 'A' AND NVL (e.drug_code, d.drug_code) = d.drug_code UNION ALL SELECT ext_prod_generic_id, NVL (THIRDPARTY_TYPE, 'Molecule') TYPE FROM pr_adverse_event_reaction a, pr_allergy_sensitivity c, ph_generic_ext_prod_ref b, ph_drug d, pr_adverse_event e WHERE a.adv_event_type = 'DA' AND a.patient_id = ? AND a.adv_reac_code = 'OTH' AND d.drug_code IS NOT NULL AND d.generic_id = b.generic_id AND a.allergen_code = d.generic_id AND b.product_id = 'CIMS' AND b.eff_status = 'E' AND a.status = 'A' AND a.patient_id = c.patient_id AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = c.adv_event_type AND a.allergen_code = c.allergen_code AND a.adv_event_srl_no = c.adv_event_srl_no AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.adv_event_dtl_srl_no = e.adv_event_dtl_srl_no AND NVL (e.drug_code, d.drug_code) = d.drug_code AND c.status = 'A')") ; //Modified for IN:071537
					}
					
					pstmt.setString(1,patient_id);
					pstmt.setString(2,patient_id);
					resultSet = pstmt.executeQuery() ;

					while(resultSet.next()) { 
						allergyDrugList.add(resultSet.getString("EXT_PROD_GENERIC_ID")+"~"+(resultSet.getString("TYPE")==null?"Molecule":resultSet.getString("TYPE"))); //Modified for IN:071537
					}
				}
				catch ( Exception e ) {
					e.printStackTrace() ;
				}
				finally {
					try {
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
						closeConnection( connection );
					}
					catch(Exception es) {
						es.printStackTrace();
					}
				}
			}
			catch(Exception exp){
				exp.printStackTrace();
			}
			if(debugMsg.equals("Y"))
				System.err.println("In getAllergyDrugList - allergyDrugList="+allergyDrugList);
			return allergyDrugList;
		}

	public void generatePresRequest(ArrayList<String> prescrbing,ArrayList<String> drugs, HashMap  doseCheckParamsHash){	 
		if(debugMsg.equals("Y"))
			System.err.println("In generatePresRequest - prescrbing="+prescrbing+" ===drugs="+drugs);
		String ggpi_product_ref			= "";
		String reference_code			= "";
		ArrayList dosageCheckParams = new ArrayList();
		String ext_prod_id				= "";
		String dosage					= "";
		String dose_uom					= "";
		String frequency				= "";
		String duration					= "";
		String ext_dose_uom				= "";
		String route_code				= "";
		String frequency_period			= "24";
		String duration_str				= "";
		String duration_type			= "D"; //Default Day
		String frequency_num			= "0";
		String freq_nature				= "";
		String interval_value			= "1";
		//long age_in_days				= 0;
		double weightKG					= 0;
		double BSAInM2					= 0;
		double dosage_value				= 0;
		String age_in_year_month_days	= "";//, remain_age = "";
		//request						= "";    //uncomment for NEW Added MIMS Coding 2018
		request							= new StringBuffer(); 		// IN066787 - Performance comment for NEW Added MIMS Coding 2018
		//request						= "<Request> <Interaction> <Prescribing>";  // IN066787 - Performance  comment for NEW Added MIMS Coding 2018
		request.append("<Request> <Interaction> <Prescribing>");  // IN066787 - Performance
		//int count = 0;  Removed for IN063877
		if(drugs.size()>0){
			for(int i=0; i<drugs.size(); i++){
				StringTokenizer st = new StringTokenizer((String)drugs.get(i), "::");
				while (st.hasMoreTokens()) 	{
					ggpi_product_ref	=   st.nextToken() ;  // Added in Jan 2014 for dosage for dynamic
					reference_code		=   st.nextToken() ;  // Added in Jan 2014 for dosage for dynamic
					//request			= request+ "<"+ggpi_product_ref+" reference='"+reference_code+"' >"; // removed closing in Jan 2014 for dosage 
					request.append("<"+ggpi_product_ref+" reference='"+reference_code+"' >");
					// Added for Dose Module - January 2014
					 if(doseCheckParamsHash!=null && doseCheckParamsHash.size() >0 ) { 
						dosageCheckParams = (ArrayList)doseCheckParamsHash.get(reference_code);								
						if(dosageCheckParams != null && dosageCheckParams.size() == 15){
							ext_prod_id				= (String) dosageCheckParams.get(1);	//external product id
							weightKG				= Double.parseDouble(dosageCheckParams.get(2)==null?"0":(String)dosageCheckParams.get(2));			//patient weight
							BSAInM2					= Double.parseDouble( dosageCheckParams.get(3)==null?"0":(String)dosageCheckParams.get(3));	//patient BSA
							dosage					= (String) dosageCheckParams.get(4)==null?"0":(String) dosageCheckParams.get(4); 	//dosage
							dose_uom				= (String) dosageCheckParams.get(5);		//dosage UOM(eHIS) //qty_desc_code
							dose_uom				= dose_uom==null?"":dose_uom;
							frequency				= (String) dosageCheckParams.get(6)==null?"0":(String) dosageCheckParams.get(6); //frequency repeat value per day
							duration				= (String) dosageCheckParams.get(7)==null?"0":(String) dosageCheckParams.get(7); //duration
							route_code				= (String) dosageCheckParams.get(8)==null?"":(String) dosageCheckParams.get(8); // route_code
							duration_type			= (String) dosageCheckParams.get(9)==null?"D":(String) dosageCheckParams.get(9); // duration_type 
							freq_nature				= (String) dosageCheckParams.get(10)==null?"":(String) dosageCheckParams.get(10); // freq_nature 
							interval_value			= (String) dosageCheckParams.get(11)==null?"":(String) dosageCheckParams.get(11); // interval_value 
							ext_dose_uom			= (String) dosageCheckParams.get(12)==null?"":(String) dosageCheckParams.get(12);
							if(ext_dose_uom!=null && ext_dose_uom.equals("") && dose_uom!=null && !dose_uom.equals("")) // then pass the EM dose_uom
								ext_dose_uom = dose_uom;
							//age_in_days = Integer.parseInt(dosageCheckParams.get(10)==null?"0":(String) dosageCheckParams.get(10));
							age_in_year_month_days	= (String) dosageCheckParams.get(13)==null?"":(String) dosageCheckParams.get(13);
							gender					= (String) dosageCheckParams.get(14)==null?"":(String) dosageCheckParams.get(14);
							
							//Frequency convert to Hours based upon the duration type - MIMS accept it in Hours only
							if(frequency!=null && !frequency.equals("") && !frequency.equals("0")) {
								if(duration_type!=null && duration_type.equals("D")) {
									frequency_num		= new Float(Math.ceil(   (24) / Float.parseFloat(frequency))).intValue() + ""; 
								}
								else if(duration_type!=null && duration_type.equals("M")) {
									frequency_num		= new Float(Math.ceil(   (24*60)/ Float.parseFloat(frequency))).intValue() + ""; 
								}  else 
									frequency_num		= frequency;
							}

							if(freq_nature!=null && freq_nature.equals("") && !freq_nature.equals("F")) {
								frequency_period = 	"24";
							} 
							else  if(freq_nature!=null && freq_nature.equals("") && freq_nature.equals("F")) {
								if(duration_type!=null && duration_type.equals("D")) {
									frequency_period = new Float(Math.ceil(24*Float.parseFloat(interval_value))).intValue() + ""; 
								} 
								else if(duration_type!=null && duration_type.equals("M")) {
									frequency_period = new Float(Math.ceil(24*30*Float.parseFloat(interval_value))).intValue() + ""; 
								} 
								else if(duration_type!=null && duration_type.equals("W")) {
									frequency_period = new Float(Math.ceil(24*7*Float.parseFloat(interval_value))).intValue() + ""; 
								}
							}
							//if(dosage!=null && !dosage.equals("0") && frequency!=null && !frequency.equals("0"))
							if(dosage!=null &&  !dosage.equals("")  && !dosage.equals("0") && frequency!=null && !frequency.equals("") && !frequency.equals("0")) 
								dosage_value = 	 Double.parseDouble(dosage)*Double.parseDouble(frequency);
							 setAgeDetails(age_in_year_month_days); // Calculate Age and keep
							 duration_str = getDuration(duration_type, duration);
							 //Moved in the Loop
							 if(route_code!=null && !route_code.equals(""))
								 request.append( "<RouteOfAdministration name=\""+route_code+"\" />"); // IN066787 - Performance
								//request = request+ "<RouteOfAdministration name=\""+route_code+"\" />";
							else
								 request.append("<RouteOfAdministration name=\"oral\" />");  // IN066787 - Performance
							//	request = request+ "<RouteOfAdministration name=\"oral\" />";

							request.append("<Dosing><Dose><Value>"+dosage_value+"</Value><Unit>"+ext_dose_uom+"</Unit> </Dose><Frequency> <Hour>"+frequency_num+"</Hour> </Frequency> <FrequencyPeriod> <Hour>"+frequency_period+"</Hour> </FrequencyPeriod> <Duration>"+duration_str+"</Duration></Dosing>");
							//request = request+ "<Dosing><Dose><Value>"+dosage_value+"</Value><Unit>"+ext_dose_uom+"</Unit> </Dose><Frequency> <Hour>"+frequency_num+"</Hour> </Frequency> <FrequencyPeriod> <Hour>"+frequency_period+"</Hour> </FrequencyPeriod> <Duration>"+duration_str+"</Duration></Dosing>";
							doseCheckParamsHash.remove(reference_code);
						}
						/*if(route_code!=null && !route_code.equals(""))
							request = request+ "<RouteOfAdministration name=\""+route_code+"\" />";
						else 
							request = request+ "<RouteOfAdministration name=\"oral\" />";
							request = request+ "<Dosing><Dose><Value>"+dosage_value+"</Value><Unit>"+ext_dose_uom+"</Unit> </Dose><Frequency> <Hour>"+frequency_num+"</Hour> </Frequency> <FrequencyPeriod> <Hour>"+frequency_period+"</Hour> </FrequencyPeriod> <Duration>"+duration_str+"</Duration></Dosing>";	 
							//request = request+ "</"+ggpi_product_ref+">";  //Commented for Closing tag Duplicate	*/
						}  
						//request = request+ "</"+ggpi_product_ref+">"; 
						request.append("</"+ggpi_product_ref+">"); 

				} // added for while in june 2012
			}
		}
		if(debugMsg.equals("Y"))
			System.err.println("In generatePresRequest - request="+request.toString());
	}

	/* Added in JUNE 2012 - New changes - Health Care Interaction */
	public void generateCompleteRequest(String dupTheraphyCheckYN){
		//request = request + "</Prescribing>";
		request.append("</Prescribing>");
		//Modified for IN:074177 start
		if(dupTheraphyCheckYN.equals("Y")){
			request.append("<DuplicateTherapy checkSameDrug=\"true\"/>");
			request.append("<DuplicateIngredient checkSameDrug=\"true\"/>"); // Added for IN:071537 (ashutosh from MIMS requested to pass always for all customers)
		}
		//Modified for IN:074177 end
			//request = request + "<DuplicateTherapy checkSameDrug=\"true\"/>";
		System.err.println("In generateCompleteRequest dupTheraphyCheckYN = "+dupTheraphyCheckYN);//Added for IN:074177 
		if(debugMsg.equals("Y"))
			System.err.println("In generateCompleteRequest - request="+request.toString());
	}
	/* Added in JUNE 2012 - New changes - Health Care Interaction -- Till here */

	public void generateAllergyRequest(ArrayList<String> allergyList){
		if(debugMsg.equals("Y"))
			System.err.println("In generateAllergyRequest - allergyList="+allergyList);
		if(allergyList.size()>0){
			//Added for IN:071537 start
			StringTokenizer tokens						= null; 
			String allergy_type							= ""; 
			String reference_code						= ""; 
			//Added for IN:071537end
			//request		= request + "<Allergies>";
			request.append("<Allergies>");
			for(int i=0;i<allergyList.size();i++){
				//request	= request + "<Allergies><Molecule reference='"+allergyList.get(i)+"'/>";
				//request	= request + "<Molecule reference='"+allergyList.get(i)+"'/>";
				//request	= request + "<Molecule reference='"+allergyList.get(i)+"'/>";
				//Modified for IN:071537 start
				tokens = new StringTokenizer(allergyList.get(i), "~");  //  GHL-CRF-0614  

				while (tokens.hasMoreTokens()) {   // (at a time 2 values, type and ext_prod_id // GHL-CRF-0614
					reference_code = tokens.nextToken();
					if(reference_code==null) reference_code	= "";
					allergy_type   = tokens.nextToken();
					if(allergy_type==null) allergy_type		= "";
				}
					request.append("<"+allergy_type+" reference='"+reference_code+"'/>"); // GHL-CRF-0614  (added type dynamically)
				//Modified for IN:071537 end
			//	request.append("<Molecule reference='"+allergyList.get(i)+"'/>"); // GHL-CRF-0614

			}
			//request		= request + "</Allergies>";
			request.append("</Allergies>");
		}
		//request			= request + "<Molecule reference='{640522B2-2EE0-4357-A8B9-4F5055035D38}'/>  </Allergies>";
		
		// removed References as per mail communication with MIMS for avoiding references in result	 and moved to interaction to close request
			//request			= request+"<References/></Interaction>"; 		/* Added in JUNE 2012 - New changes - Health Care Interaction */
		
		if(debugMsg.equals("Y"))
			System.err.println("In generateAllergyRequest - request="+request.toString());
	}

 
	public void closeRequest(){
		//request		= request+"</Interaction>";  // moved here performance tuning - Brueni
		request.append("<References/>"); //Added for IN:071537 (MIMS requested to show for all customers)
		request.append("</Interaction>");  // moved here performance tuning - Brueni

		 if( ( (age_years!=null && !age_years.equals("")) || (age_months!=null && !age_months.equals("")) || (age_days!=null && !age_days.equals("")) ) &&  gender!=null && !gender.equals("")) {	 //If entered dosage for one then will have details
			//request	= request+"<PatientProfile><Gender>"+gender+"</Gender><Age>";
			request.append("<PatientProfile><Gender>"+gender+"</Gender><Age>");
			if(age_years!=null && !age_years.equals(""))
				request.append("<Year>"+age_years.trim()+"</Year>");
			//	request		= request + "<Year>"+age_years.trim()+"</Year>";
		    if(age_months!=null && !age_months.equals(""))
				request.append("<Month>"+age_months.trim()+"</Month>");
				//request	= request + "<Month>"+age_months.trim()+"</Month>";
			if(age_days!=null && !age_days.equals(""))
				request.append("<Day>"+age_days.trim()+"</Day>");
				//request	= request + "<Day>"+age_days.trim()+"</Day>";
			request.append("</Age></PatientProfile>");
			//request		= request+ "</Age></PatientProfile>";
		}// Added for Dose Module - January 2014
		request.append("</Request>");  
		//request			= request+"</Request>";  


	/*	request = new StringBuffer(); 
		request.append("<Request>");
		request.append("<Interaction>");
		request.append("<Prescribing>");         
		request.append("<GGPI reference=\"{B3E5E9FF-0857-4B5E-E034-080020E1DD8C}\" />");
		request.append("<GGPI reference=\"{3D3B5434-05BB-446D-B2B6-F011C7B39BD3}\" />");
		request.append("<GGPI reference=\"{497F3D6E-906D-4E0B-B3D5-CEC3C959865D}\" />");
		request.append("<GGPI reference=\"{5BD2DBDF-06C7-431C-A740-34FA818E2F30}\" />");
		request.append("</Prescribing>");
		request.append("<Allergies>");          
		request.append("<Molecule reference=\"{87B0113E-443C-4BD2-A772-1A722DE45CA8}\" />");                         
		request.append("</Allergies>");
		request.append("<References />");                                                                                                                                               
		request.append("</Interaction>");
		request.append("</Request>");*/




		if(debugMsg.equals("Y"))
		   System.err.println("Total - request="+request.toString());

//System.err.println("closeRequest  FINAL - request="+request.toString());
	}
	/* Added in JUNE 2012 - New changes - Health Care Interaction -- Till here */
	/* Added in JUNE 2012 - New changes - Health Care Interaction */
	public void generateDrugHealthRequest(ArrayList<String> healthInteractionDrugList){
		if(debugMsg.equals("Y"))
			System.err.println("In generateDrugHealthRequest - healthInteractionDrugList="+healthInteractionDrugList);
		if(healthInteractionDrugList.size()>0){
			 request.append("<HealthIssueCodes>");  
//			 request = request + "<HealthIssueCodes>";  
			for(int i=0;i<healthInteractionDrugList.size();i++){
				request.append("<HealthIssueCode code='"+healthInteractionDrugList.get(i)+"'  codeType='ICD10'/>");
//				request = request + "<HealthIssueCode code='"+healthInteractionDrugList.get(i)+"'  codeType='ICD10'/>";
			}
			 request.append("</HealthIssueCodes>");
//			 request = request + "</HealthIssueCodes>";
		}
		if(debugMsg.equals("Y"))
			System.err.println("In generateDrugHealthRequest - request="+request.toString());
	}

	public StringBuffer getMonographContent(String ext_prod_id){
	
		/*if(debugMsg.equals("Y")){
			jiLogger.setLevel(java.util.logging.Level.parse("WARNING"));		//Log set to warning
		}
		*/
	//	String result								= ""; Removed for IN063877
		String xmlResult							= "";
		StringBuffer sbf							= new StringBuffer();
		DocumentBuilderFactory docBuilderFactory	= null;
		DocumentBuilder docBuilder					= null;
		Document doc;
		String request								= "";
		
		StringTokenizer tokens						= new StringTokenizer(ext_prod_id, "::");
		while (tokens.hasMoreTokens()) 
			request="<Request> <Content><"+tokens.nextToken()+" reference='"+tokens.nextToken()+"'/></Content></Request>";
		//request="<Request> <Content><GGPI reference='"+ext_prod_id+"'/> </Content> </Request>";
		/*CIMSLoginDetails cimsDetails = new CIMSLoginDetails();
		host			= cimsDetails.getHost();
		domain			= cimsDetails.getDomain();
		user			= cimsDetails.getUser();
		pass			= cimsDetails.getPass();
		mrcPass			= cimsDetails.getMrcPass();
		mrc				= cimsDetails.getMrcPath();	 */

		try{
			//server	= new JFastTrack(host, domain, user, pass);
			//result	 = server.initializeServer(mrc, mrcPass);
			//if(server==null){
				if(debugMsg.equals("Y"))
					System.err.println("In getMonographContent() - The FastTrack server has been released. Calling loadInitializeCIMS()");
				//loadInitializeCIMS();//EMR-ICN-8023
			//}
			if(debugMsg.equals("Y"))
				System.err.println("In getMonographContent()====request="+request); //+" server="+server);
			//xmlResult = server.requestXML(request);
			//Leo
 
			xmlResult=requestXmlWithRetry(request, "", "", "" );  // HSA-ICN-0011 , passing patient id, login_by_id, login_ws_no as null 
			//xmlResult=requestXmlWithRetry(request);  // HSA-ICN-0011

			if(debugMsg.equals("Y"))
				System.err.println("In getMonographContent()====xmlResult="+xmlResult);
			sbf.append(xmlResult);
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();
			if(xmlResult!=null)
				doc = docBuilder.parse(new InputSource(new StringReader(xmlResult)));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(debugMsg.equals("Y"))
			System.err.println("@@CIMSExternalDataBaseBean===getMonographContent()====return value="+sbf);
		return sbf;
	}
	/*public ArrayList<String> getInterDrugList(){// commented for HSA-ICN-0002 and PMG-2018COMN-CRF-002
		return this.alInterDrugList;
	}*

	/* added IN June 2012 - For Dosage check */
/*	public StringBuffer generateDosageRequest(ArrayList dosageCheckParams, String ext_prod_id) {
		String result		= "";
		String xmlResult	= "";
		StringBuffer sbf	= new StringBuffer();
 
		String request		= "";
		
		StringTokenizer tokens = new StringTokenizer(ext_prod_id, "::");
		if(dosageCheckParams != null && dosageCheckParams.size() == 16){
String			ext_prod_id_test = (String) dosageCheckParams.get(1);	//external product id
Double			weightKG_test = Double.parseDouble(dosageCheckParams.get(2)==null?"0":(String)dosageCheckParams.get(2));			//patient weight
Double			BSAInM2_test = Double.parseDouble( dosageCheckParams.get(3)==null?"0":(String)dosageCheckParams.get(3));	//patient BSA
String			dosage = (String) dosageCheckParams.get(4);			//dosage
String			dose_uom = (String) dosageCheckParams.get(5);		//dosage UOM(eHIS)
String			frequency_test = (String) dosageCheckParams.get(6);		//frequency repeat value per day
String			duration = (String) dosageCheckParams.get(7);		//duration
Double			height	 =  Double.parseDouble(dosageCheckParams.get(8)==null?"0":(String)dosageCheckParams.get(8));
String			age_check = (String) dosageCheckParams.get(9);		//duration
Double			age  =  0.0;
String			age_uom = "D";
String			age_calc = age_check;
				if(age_check!=null && !age_check.equals("")) {
					if(age_check.indexOf("Y")!= -1 )  {
						age_check =  age_check.substring(0,	age_check.indexOf("Y"));
						age_uom	  =  age_calc.substring(age_calc.indexOf("Y"), age_calc.length());
						if(age_check!=null && !age_check.equals("")) 
							age =  Double.parseDouble(age_check==null?"0":age_check);
					} else if(age_check.indexOf("M")!= -1 )  {
						age_check =  age_check.substring(0,	age_check.indexOf("M"));
						age_uom	  =  age_calc.substring(age_calc.indexOf("M"), age_calc.length());
						if(age_check!=null && !age_check.equals("")) 
							age =  Double.parseDouble(age_check==null?"0":age_check);
					}  else if(age_check.indexOf("D")!= -1 )  {
						age_check =  age_check.substring(0,	age_check.indexOf("D"));
						age_uom	  =  age_calc.substring(age_calc.indexOf("D"), age_calc.length());
						if(age_check!=null && !age_check.equals("")) 
							age =  Double.parseDouble(age_check==null?"0":age_check);
					}
				}
String			sex = (String) dosageCheckParams.get(10);		//duration


String			route_code	      =(String) dosageCheckParams.get(11)==null?"":(String) dosageCheckParams.get(11);
String			route_desc		  = (String) dosageCheckParams.get(12)==null?"":(String) dosageCheckParams.get(12);
String			freq_code		  = (String) dosageCheckParams.get(13)==null?"":(String) dosageCheckParams.get(13);
String			ext_dose_uom_test =(String) dosageCheckParams.get(14)==null?"":(String) dosageCheckParams.get(14);
int				age_in_days_test = Integer.parseInt(dosageCheckParams.get(15)==null?"0":(String) dosageCheckParams.get(15));

		   String drug_id = "";
		   String  reference = "";
		 
	   request="<Request><Interaction><Prescribing>";
		while (tokens.hasMoreTokens())  {
				reference		= tokens.nextToken();
				drug_id			= tokens.nextToken();	

				request = request+ "<"+reference+" reference='"+drug_id+"'>";
				request = request + "<RouteOfAdministration name='"+route_desc+"'/>";
				request = request + "<Dosing><Dose><Value>"+dosage+"</Value><Unit>"+dose_uom+"</Unit></Dose>";

				if(freq_code!=null && !freq_code.equals("")) {
					if(freq_code.equals("TDS") || freq_code.equals("BID"))		// Remove this as of now no Mapping from MIMS, so hardcoded - Added in June 2012
						request = request + "<Frequency name='twice a day' /><Duration><Hour>"+duration+"</Hour></Duration>";
					else if(freq_code.equals("TID2"))		// Remove this as of now no Mapping from MIMS, so hardcoded - Added in June 2012
						request = request + "<Frequency name='three times a day' /><Duration><Day>"+duration+"</Day></Duration>";
					else if(freq_code.equals("Q4H"))		// Remove this as of now no Mapping from MIMS, so hardcoded - Added in June 2012
						request = request + "<Frequency name='four times a day' /><Duration><Day>"+duration+"</Day></Duration>";
					else if(freq_code.equals("OD1"))		// Remove this as of now no Mapping from MIMS, so hardcoded - Added in June 2012
						request = request + "<Frequency name='daily' /><Duration><Hour>24</Hour></Duration>";
					else if(freq_code.equals("Q4H"))		// Remove this as of now no Mapping from MIMS, so hardcoded - Added in June 2012
						request = request + "<Frequency name='4 hourly' /><Duration><Hour>6</Hour></Duration>";
					else if(freq_code.equals("E4") || freq_code.equals("E2"))		// Remove this as of now no Mapping from MIMS, so hardcoded - Added in June 2012
						request = request + "<Frequency name='2 hourly' />";
					else if(freq_code.equals("1WK"))		// Remove this as of now no Mapping from MIMS, so hardcoded - Added in June 2012
						request = request + "<Frequency name=weekly' /><Duration><Week>"+duration+"</Week></Duration>";
					else
						request = request + "<Frequency name='daily' /><Duration><Day>"+duration+"</Day></Duration>";
				}
				request = request + "</Dosing>";
				// As of now Duration is passed as days...
				request = request + "</"+reference+">"; 
			} // end of while
			request = request + "</Prescribing><References/></Interaction>";
			request = request + "<PatientProfile><Gender>"+sex+"</Gender>";
			
			if(age!=null && age!=null && !age_uom.equals("")){
				request = request + "<Age>";
				if(age_uom.equals("Y"))
					request = request + "<Year>"+age+"</Year>";
				else if(age_uom.equals("M")) 
					request = request + "<Month>"+age+"</Month>";						
				else if(age_uom.equals("D")) 
					request = request + "<Day>"+age+"</Day>";
				request = request + "</Age>";
			}
			request = request + "<Weight>"+weightKG_test+"</Weight><Height>"+height+"</Height><BSA>"+BSAInM2_test+"</BSA></PatientProfile>";

			request = request + "</Request> ";
		}
								// below one need to be in dynamic...now it is hardcoded to check the result.
	//								request = request + "<RouteOfAdministration name='Intramuscular'/><Dosing><Dose><Value>500000</Value><Unit>mg</Unit></Dose><Frequency name='twice a day' /></Dosing>";
									

		CIMSLoginDetails cimsDetails = new CIMSLoginDetails();
		host = cimsDetails.getHost();
		domain = cimsDetails.getDomain();
		user = cimsDetails.getUser();
		pass = cimsDetails.getPass();
		mrcPass = cimsDetails.getMrcPass();
		mrc = cimsDetails.getMrcPath();		  
		try{
			//server = new JFastTrack(host, domain, user, pass);
			result = server.initializeServer(mrc, mrcPass);
			xmlResult = server.requestXML(request);

			sbf.append(xmlResult);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				result = server.releaseServer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sbf;
	}*/
		/* added IN June 2012 - For Dosage check - Till here  */


		/* added IN June 2012 - For getDisplayLookUp */
	public StringBuffer getDisplayLookUp(String type, String code) {
		/*if(debugMsg.equals("Y")){
			jiLogger.setLevel(java.util.logging.Level.parse("WARNING"));		//Log set to warning
		}
		*/
		String xmlResult	= "";
		StringBuffer sbf	= new StringBuffer();
 
		String request		= "";
		request = "<Request><List>";
		if(type!=null && !type.equals("") && type.equalsIgnoreCase("Product")){
			request = request + "<Product><ByName>";
		}
		else if(type!=null && !type.equals("") && type.equalsIgnoreCase("GGPI")) {
			request = request + "<GGPI><ByMoleculeName>";
		}
		else if(type!=null && !type.equals("") && type.equalsIgnoreCase("GenericItem")){
			request = request + "<GenericItem><ByMoleculeName>";
		}
		else if(type!=null && !type.equals("") && type.equalsIgnoreCase("Molecule")){
			request = request + "<Molecule><ByName>";
		}
		//Added for IN:071537 start
		else if(type!=null && !type.equals("") && type.equalsIgnoreCase("SubstanceClass")){  // Added for GHL-CRF-0614
			request = request + "<SubstanceClass><ByName>";
		}
		else if(type!=null && !type.equals("") && type.equalsIgnoreCase("ActiveCompositionGroup")){  // Added for GHL-CRF-0614
			request = request + "<ActiveCompositionGroup><ByMoleculeName>";
		}
		//Added for IN:071537 end
		if(code!=null && !code.equals("")){
			if(code!=null && !code.equals(""))
				request = request + code;
		}
	
		if(type!=null && !type.equals("") && type.equalsIgnoreCase("Product")){
			request = request + "</ByName></Product>";
		}
		else if(type!=null && !type.equals("") && type.equalsIgnoreCase("GGPI")) {
			request = request + "</ByMoleculeName></GGPI>";
		} 
		else if(type!=null && !type.equals("") && type.equalsIgnoreCase("GenericItem")){
			request = request + "</ByMoleculeName></GenericItem>";
		}
		else if(type!=null && !type.equals("") && type.equalsIgnoreCase("Molecule")){
			request = request + "</ByName></Molecule>";
		}
		//Added for IN:071537 start
		else if(type!=null && !type.equals("") && type.equalsIgnoreCase("SubstanceClass")){  // Added for GHL-CRF-0614
			request = request + "</ByName></SubstanceClass>";
		}
		else if(type!=null && !type.equals("") && type.equalsIgnoreCase("ActiveCompositionGroup")){  // Added for GHL-CRF-0614
			request = request + "</ByMoleculeName></ActiveCompositionGroup>";
		}
		//Added for IN:071537 end
		request = request + "</List></Request>";

		try{
//			if(server==null){
				if(debugMsg.equals("Y"))
					System.err.println("In getDisplayLookUp() - The FastTrack server has been released. Calling loadInitializeCIMS()");
				//loadInitializeCIMS();//EMR-ICN-8023
//			}
			if(debugMsg.equals("Y"))
				System.err.println("In getDisplayLookUp()====request="+request+"===type"+type);
			//xmlResult	= server.requestXML(request);
			// Leo
			xmlResult=requestXmlWithRetry(request, "", "", "" );  // HSA-ICN-0011 , passing patient id, login_by_id, login_ws_no as null 
			//xmlResult=requestXmlWithRetry(request);// HSA-ICN-0011 
			if(debugMsg.equals("Y"))
				System.err.println("In getDisplayLookUp()====request="+request+"===type"+type);
			sbf.append(xmlResult);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
//				result = server.releaseServer();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(debugMsg.equals("Y"))
		  System.err.println("In getDisplayLookUp()====sbf="+sbf);
		return sbf;
	}
	// added in June 2012
	public StringBuffer getContentXML(StringBuffer xmlData, String exp_prodid, HashMap drugProduct){		
		if(debugMsg.equals("Y"))
		    System.err.println("============in getContentXML Start============");
		StringBuffer sbfResult = new StringBuffer();
		DocumentBuilderFactory docBuilderFactory = null;
		DocumentBuilder docBuilder = null;
		Document doc;
		FilterQuery cimsFilterNode = new FilterQuery();//IN063877

//		String interactionResult = ""; // IN063877
		//System.err.println("In CIMS  BEAN getContentXML Method @@========="+xmlData.toString());
		if(xmlData!=null && xmlData.length() > 0 ){
			try {


					if(xmlData!=null) {   // Calling CIMS Method to get content only for that specific EXP PROD ID to display the result 
						sbfResult = new StringBuffer();
						sbfResult.append(cimsFilterNode.ResponseXML(exp_prodid, xmlData)); // IN063877
						if(debugMsg.equals("Y"))
							System.err.println("In CIMS  BEAN getContentXML Method --- After REtrieve from MIMS Interaction @@=========exp_prodid"+exp_prodid+"====DATAsbfResult 	=========="+sbfResult);
					}

					if(sbfResult!=null && sbfResult.length() > 0 ){  // to remove duplicate theraphy or additionals

						docBuilderFactory = DocumentBuilderFactory.newInstance();
						docBuilder = docBuilderFactory.newDocumentBuilder();
						//doc = docBuilder.parse(new InputSource(new StringReader(xmlData.toString())));
						doc = docBuilder.parse(new InputSource(new StringReader(sbfResult.toString())));// IN063877
						Node root = doc.getDocumentElement();
						NodeList childRoots = root.getChildNodes();
						int count = 0;
						int match_count = 0;
						int next_count = 0;
						int remove_count = 0;
						//int allergy_count = 0;  Removed for IN063877
						int duplicateCount = 0;		 // duplicate changes
						String dupl_reference = ""; // duplicate changes
						for (int i = 0; i < childRoots.getLength(); i++) {	
							Node child = childRoots.item(i);
							if(child.getParentNode().getNodeName().equalsIgnoreCase("Result") && child.getNodeName().equalsIgnoreCase("Interaction")){
								// Route Nodes
								Element routeMainElement = (Element)child;
								NodeList routeChilds = routeMainElement.getChildNodes();
								for (int j=0; j<routeChilds.getLength();j++ ){
									Node routeCheckNode = routeChilds.item(j);
									if(routeCheckNode!=null && routeCheckNode.getNodeType() == Node.ELEMENT_NODE){
										if (routeCheckNode.getNodeName().equalsIgnoreCase("GGPI") || routeCheckNode.getNodeName().equalsIgnoreCase("Product") || routeCheckNode.getNodeName().equalsIgnoreCase("GenericItem")){
											count++;
										}
									}
								}
//		System.err.println("=====getContentXML =count===="+count);

								if(count > 2) { // more than ggpi or product selected
									for (int j=0; j<routeChilds.getLength();j++ ){
										Node routeNode = routeChilds.item(j);
									if(routeNode!=null && routeNode.getNodeType() == Node.ELEMENT_NODE){
											//NamedNodeMap namedNodeAttributes = routeNode.getAttributes(); //commented for common-icn-0048
											/*if (routeNode.getNodeName().equalsIgnoreCase("GGPI") || routeNode.getNodeName().equalsIgnoreCase("Product") || routeNode.getNodeName().equalsIgnoreCase("GenericItem")){	
												for (int k = 0; k < namedNodeAttributes.getLength(); k++) {
													Node attribute = namedNodeAttributes.item(k);
													if(attribute.getNodeName().equalsIgnoreCase("reference") && attribute.getNodeValue().equalsIgnoreCase(exp_prodid)){
														match_count++;
													}
													if(attribute.getNodeName().equalsIgnoreCase("reference") && !attribute.getNodeValue().equalsIgnoreCase(exp_prodid)){
													   //routeNode.removeChild(routeNode);	 // REMOVE THE GGPI/PRODUCT
														routeNode.getParentNode().removeChild(routeNode);  		   // the total element will be reduced
														j--; // reduce 			
														doc.normalize();
													}
														else if(attribute.getNodeName().equalsIgnoreCase("reference") && attribute.getNodeValue().equalsIgnoreCase(exp_prodid) && match_count > 1){	// in case same ggpi/product/generic more than once....(in case of allergies/previous orders), then also remove
														routeNode.getParentNode().removeChild(routeNode);  		   // the total element will be reduced
														j--; // reduce 
														doc.normalize();
													}
												}
											} 
											else*/
											
											if (routeNode.getNodeName().equalsIgnoreCase("DuplicateTherapy")){
												Element routeNewElement = (Element)routeNode;
												NodeList routeNewChilds = routeNewElement.getChildNodes();
												for (int d=0; d<routeNewChilds.getLength();d++ ){
													Node childNodeResult = routeNewChilds.item(d);
													if (childNodeResult.getNodeName().equalsIgnoreCase("Warning")){
														remove_count = 0;
														Element routeSecondElement = (Element)childNodeResult;
														NodeList routeSecondChilds = routeSecondElement.getChildNodes();
														for (int e=0; e<routeSecondChilds.getLength();e++ )
														{
															next_count = 0;	
															Node childDuplResult = routeSecondChilds.item(e);
															if (childDuplResult.getNodeName().equalsIgnoreCase("Duplicate"))			 
															{
																Element routeThirdElement = (Element)childDuplResult;
																NodeList routeThirdChilds = routeThirdElement.getChildNodes();
																for (int f=0; f<routeThirdChilds.getLength();f++ )
																{
																	Node routeFourthNode = routeThirdChilds.item(f);
																 
																	if (routeFourthNode.getNodeName().equalsIgnoreCase("GGPI") || routeFourthNode.getNodeName().equalsIgnoreCase("Product") || routeFourthNode.getNodeName().equalsIgnoreCase("GenericItem") && next_count==0)
																	{
																		NamedNodeMap namedNodeDuplicateAttributes = routeFourthNode.getAttributes();
																		 for (int g = 0; g < namedNodeDuplicateAttributes.getLength(); g++) {
																			Node duplAttribute = namedNodeDuplicateAttributes.item(g);
																			if(duplAttribute.getNodeName().equalsIgnoreCase("reference") && duplAttribute.getNodeValue().equalsIgnoreCase(exp_prodid) && next_count==0){
																				next_count++;
																				remove_count++;
																			}
																		}
																	}		
																}
//		System.err.println("===next_countnext_count=="+next_count+"===remove_count"+remove_count);
																if(next_count==0) {
																	childDuplResult.getParentNode().removeChild(childDuplResult);  		   // the total element will be reduced
																	e--;
																	doc.normalize();
																}
															}
														}
													 }
													if(remove_count==0) {
														// remove this warning also...not required when no child elements
														childNodeResult.getParentNode().removeChild(childNodeResult);  		   // the total element will be reduced
														d--;
														doc.normalize();
													}
												}

											}
										}
									}
								} 
								 else if (count ==2) {
									// Newly added for SKR-SCF-614.1  
									// for allergy remove the additional one... like already one recorded with allergy, now again try to record the same (it should not show duplicate allergy)
									for (int j=0; j<routeChilds.getLength();j++ ){
										Node routeNode = routeChilds.item(j);
										if(routeNode!=null && routeNode.getNodeType() == Node.ELEMENT_NODE){
											NamedNodeMap namedNodeAttributes = routeNode.getAttributes();
											if (routeNode.getNodeName().equalsIgnoreCase("GGPI") || routeNode.getNodeName().equalsIgnoreCase("Product") || routeNode.getNodeName().equalsIgnoreCase("GenericItem")){	
												for (int k = 0; k < namedNodeAttributes.getLength(); k++) {
													Node attribute = namedNodeAttributes.item(k);
													if(attribute.getNodeName().equalsIgnoreCase("reference") && attribute.getNodeValue().equalsIgnoreCase(exp_prodid)){
														 // Now check whether it is having allergy and if there are more than remove it..
														match_count++;	
													}
													if(attribute.getNodeName().equalsIgnoreCase("reference") && attribute.getNodeValue().equalsIgnoreCase(exp_prodid) && match_count > 1){	// in case same ggpi/product/generic more than once....(in case of allergies/previous orders), then also remove
														routeNode.getParentNode().removeChild(routeNode);  		   // the total element will be reduced
														j--; // reduce 
														doc.normalize();
													} 
												}
											}
										}
									}
								} 
								//Set the Drug Description for the Duplicate
								for (int j=0; j<routeChilds.getLength();j++ ){
									Node routeNode = routeChilds.item(j);
									if(routeNode!=null && routeNode.getNodeType() == Node.ELEMENT_NODE){
										if (routeNode.getNodeName().equalsIgnoreCase("GGPI") || routeNode.getNodeName().equalsIgnoreCase("Product") || routeNode.getNodeName().equalsIgnoreCase("GenericItem")){	
										} 
										else if (routeNode.getNodeName().equalsIgnoreCase("DuplicateTherapy")) {
											Element routeNewElement = (Element)routeNode;
											NodeList routeNewChilds = routeNewElement.getChildNodes();

											for (int d=0; d<routeNewChilds.getLength();d++ ){
												Node childNodeResult = routeNewChilds.item(d);
												if (childNodeResult.getNodeName().equalsIgnoreCase("Warning")){
													Element routeSecondElement = (Element)childNodeResult;
													NodeList routeSecondChilds = routeSecondElement.getChildNodes();
													for (int e=0; e<routeSecondChilds.getLength();e++ ){
														Node childDuplResult = routeSecondChilds.item(e);
														if (childDuplResult.getNodeName().equalsIgnoreCase("Duplicate")){
															Element routeThirdElement = (Element)childDuplResult;
															NodeList routeThirdChilds = routeThirdElement.getChildNodes();
															for (int f=0; f<routeThirdChilds.getLength();f++ ){
																Node routeFourthNode = routeThirdChilds.item(f);
																if (routeFourthNode.getNodeName().equalsIgnoreCase("GGPI") || routeFourthNode.getNodeName().equalsIgnoreCase("Product") || routeFourthNode.getNodeName().equalsIgnoreCase("GenericItem") && next_count==0){
																	duplicateCount = 0;
																	dupl_reference = "";
																	NamedNodeMap namedNodeDuplicateAttributes = routeFourthNode.getAttributes();
																	 for (int g = 0; g < namedNodeDuplicateAttributes.getLength(); g++) {
																		Node duplAttribute = namedNodeDuplicateAttributes.item(g);
																		if(duplAttribute.getNodeName().equalsIgnoreCase("reference")){
																			 dupl_reference	 = duplAttribute.getNodeValue(); //code
																		}
																		if(duplAttribute.getNodeName().equalsIgnoreCase("eHISDescription")){
																			duplicateCount++;
																		}
																	}
																	if(duplicateCount==0  && drugProduct!=null && drugProduct.size() > 0 && dupl_reference!=null) {
																		Element routeNewDuplicateElement = (Element)routeFourthNode;
																		routeNewDuplicateElement.setAttribute("eHISDescription",(String)drugProduct.get(dupl_reference)); // Duplicate Theraphy Node..
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}   
							}	
						}  
		 
						//if(attribute_item.getNodeName().equalsIgnoreCase("reference"))   {
						//}
							//XPathFactory xpf = XPathFactory.newInstance();
							//XPath xpath = xpf.newXPath();

							//XPathExpression expression = xpath.compile("//Result/Interaction/GGPI[@reference!='" +exp_prodid + "'] ");
							//Node b13Node = (Node) expression.evaluate(doc, XPathConstants.NODE);
		//				    expression = xpath.compile("//Result/Interaction/GGPI[@reference='" +isbnNum + "'] ");
		//				   NodeList  b13444Node = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
		//				   NodeList nodeListForDVD = b13444Node.item(0).getChildNodes();

		/*				  for (int index = 0; index < b13444Node.item(0).getChildNodes().getLength(); index++) {
								String tagName = nodeListForDVD.item(index).getNodeName();
								String tagValue = nodeListForDVD.item(index).getTextContent();
							}*/

							StringWriter buffer		= new StringWriter();
							TransformerFactory tf	= TransformerFactory.newInstance();
							Transformer t			= tf.newTransformer();
							t.transform(new DOMSource(doc), new StreamResult(buffer));
							sbfResult = new StringBuffer();
							sbfResult .append(buffer.toString());// IN063877
							//System.err.println("==Final after manipulation"+sbfResult.toString());
					
						//Newly Added
						System.err.println("In CIMS  BEAN getContentXML Method After checking loops @@=========exp_prodid"+exp_prodid+"====DATA=========="+sbfResult);
					}
				} 
				catch (Exception e) {
					e.printStackTrace();
					System.err.println(e.getMessage() + "\n" + e.getStackTrace());
				}
			}
			if(debugMsg.equals("Y"))
			    System.err.println("============in getContentXML End============"+sbfResult);
			return sbfResult;
	}

	public HashMap getInteraction(StringBuffer xmlData, String exp_prodid, ArrayList reqChecks){  //added reqChecks to speedup 16092019
		if(debugMsg.equals("Y"))
	         System.err.println("===========getInteraction method starting========");	

		double 	interactionCount				= 0; // Newly added 2018
		double 	duplicateTheraphyCount			= 0; // Newly added 2018
		double 	contraindicationCount			= 0; // Newly added 2018

		//String dosageCheckYN					= ""; //condition based to speed up - 16092019
		String dupTheraphyCheckYN				= ""; //condition based to speed up - 16092019
		String drugInteracCheckYN				= ""; //condition based to speed up - 16092019
		String drugContraIndCheckYN				= ""; //condition based to speed up - 16092019

		boolean interaction_reqd				= false;
		boolean duplicate_reqd					= false;
		boolean contraindication_reqd			= false;
		HashMap alert_reqd						= new HashMap();
		DocumentBuilderFactory docBuilderFactory= null;
		DocumentBuilder docBuilder				= null;
		Document doc;
		try {
			if(xmlData!=null && xmlData.length() > 0 ){
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();
				doc = docBuilder.parse(new InputSource(new StringReader(xmlData.toString())));


				if(reqChecks!=null && reqChecks.size()>0){
					//dosageCheckYN			= (String)reqChecks.get(0); // not used in this method
					dupTheraphyCheckYN		= (String)reqChecks.get(1);
					drugInteracCheckYN		= (String)reqChecks.get(2);
					drugContraIndCheckYN	= (String)reqChecks.get(3);
					//drugAllergyCheckYN		= (String)reqChecks.get(4); // not used in this method
				}

		//System.err.println("====================2018===INTERACTION exp_prodid"+ exp_prodid);

			 // IN066787 - Performance  
				XPathFactory xpf 		= XPathFactory.newInstance();
				XPath xpath 			= xpf.newXPath();
				XPathExpression expr	= null;

				if(drugInteracCheckYN !=null && drugInteracCheckYN.equals("Y")) {  // added condition based 16092019

					expr = xpath.compile("count(//Interaction/*[@reference='"+exp_prodid+"' and not(@Mirror)]/Route/*/Route/ClassInteraction|  //Interaction/*/Route/*[@reference= '"+exp_prodid+"' and not(@Mirror)]/Route/ClassInteraction)");   // IN066787 - Performance

				//Object result = expr.evaluate(Object item, XPathConstants.NUMBER);
				interactionCount = (Double) expr.evaluate(doc, XPathConstants.NUMBER);

					if(interactionCount > 0.0) {
						interaction_reqd = true;
					}
				}
			 
				//duplicateTheraphy // IN066787 - Performance
				if (dupTheraphyCheckYN !=null && dupTheraphyCheckYN.equals("Y")) { // added condition based 16092019

				expr	= xpath.compile("count(//Interaction/DuplicateTherapy/Warning/Duplicate/*[@reference='"+exp_prodid+"']  )");
 				// expr	= xpath.compile("count(//Duplicate/GGPI[@reference='"+exp_prodid+"']  )");

				//System.err.println("====================2018===DUPLICATE expr"+expr); 
				//Object result = expr.evaluate(Object item, XPathConstants.NUMBER);
				duplicateTheraphyCount = (Double) expr.evaluate(doc, XPathConstants.NUMBER);

					if(duplicateTheraphyCount > 0.0) {
						duplicate_reqd  = true; 
					}
				}

				// Contraindication Check // IN066787 - Performance
				if(drugContraIndCheckYN!=null && drugContraIndCheckYN.equals("Y")) { // added condition based 16092019

					expr	= xpath.compile("count(//Interaction/*[@reference='"+exp_prodid+"' and not(@Mirror)]/Route/HealthIssueCode/ClassInteraction|//Interaction/*/Route/*[@reference='"+exp_prodid+"' and not(@Mirror)]/Route/HealthIssueCode/ClassInteraction)");
					contraindicationCount = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
	
					if(contraindicationCount > 0.0) {
						contraindication_reqd  = true;
					}
				}
//				if(debugMsg.equals("Y"))
				System.err.println("====================2018===DUPLICATE COUNT=====duplicateCount"+duplicateTheraphyCount+"===duplicate_reqd"+duplicate_reqd+"==interactionCount"+interactionCount+"==interaction_reqd"+interaction_reqd+"=contraindicationCount="+contraindicationCount+"==contraindication_reqd"+contraindication_reqd);

			 // IN066787 - Performance  


/* Commented in  Feb 2018,  IN066787 - Performance -- Upgradation of MIMS and fine tuning with XPATH */
		/*		Node root = doc.getDocumentElement();
				NodeList childRoots = root.getChildNodes();
				for (int i = 0; i < childRoots.getLength(); i++) {	
					Node child = childRoots.item(i);
					if(child.getParentNode().getNodeName().equalsIgnoreCase("Result") && child.getNodeName().equalsIgnoreCase("Interaction") && interaction_reqd==false){
						// Route Nodes
						Element routeMainElement = (Element)child;
						NodeList routeChilds = routeMainElement.getChildNodes();
						for (int j=0; j<routeChilds.getLength();j++ ){
							Node childNode = routeChilds.item(j);
							if ((childNode.getNodeName().equalsIgnoreCase("GGPI") || childNode.getNodeName().equalsIgnoreCase("Product") || childNode.getNodeName().equalsIgnoreCase("GenericItem")) && interaction_reqd==false){
								Element routeNewElement = (Element)childNode;
								NodeList routeNewChilds = routeNewElement.getChildNodes();
								for (int k=0; k<routeNewChilds.getLength();k++ ){
									Node childNodeResult = routeNewChilds.item(k);
									if (childNodeResult.getNodeName().equalsIgnoreCase("Route") && interaction_reqd==false){
										Element routeSecondElement = (Element)childNodeResult;
										NodeList routeSecondChilds = routeSecondElement.getChildNodes();
										for (int l=0; l<routeSecondChilds.getLength();l++ ){
											Node childSecondResult = routeSecondChilds.item(l);
											if( (childSecondResult.getNodeName().equalsIgnoreCase("GGPI") || childSecondResult.getNodeName().equalsIgnoreCase("Product") || childSecondResult.getNodeName().equalsIgnoreCase("GenericItem") ) && childSecondResult.getFirstChild()!=null && childSecondResult.getFirstChild().getNodeName().equalsIgnoreCase("Route") && interaction_reqd==false){
												NamedNodeMap attributes = childSecondResult.getAttributes();
												NodeList routeListChilds = childSecondResult.getFirstChild().getChildNodes();
												for (int n=0; n<routeListChilds.getLength();n++ ){
													Node childThirdResult = routeListChilds.item(n);
													if(childThirdResult.getNodeName().equalsIgnoreCase("ClassInteraction") && interaction_reqd==false){
														for (int m = 0; m < attributes.getLength(); m++) {
															Node attribute = attributes.item(m);
															if(attribute.getNodeName().equalsIgnoreCase("Mirror") && attribute.getNodeValue()!=null && attribute.getNodeValue().equalsIgnoreCase("True"))   {
																interaction_reqd = true;
															}
														}
													}
												}
											}
										}
									} 
								}
							}
							else if (childNode.getNodeName().equalsIgnoreCase("DuplicateTherapy") && duplicate_reqd==false)  {	// FOR DUPLICATE THERAPHY..
								Element routeNewElement = (Element)childNode;
								NodeList routeNewChilds = routeNewElement.getChildNodes();
								for (int k=0; k<routeNewChilds.getLength();k++ ){
									Node childNodeResult = routeNewChilds.item(k);
									if (childNodeResult.getNodeName().equalsIgnoreCase("Warning") && duplicate_reqd==false){
										Element routeSecondElement = (Element)childNodeResult;
										NodeList routeSecondChilds = routeSecondElement.getChildNodes();
										for (int l=0; l<routeSecondChilds.getLength();l++ ){
											Node childDuplResult = routeSecondChilds.item(l);
											if (childDuplResult.getNodeName().equalsIgnoreCase("Duplicate") && duplicate_reqd==false){
												duplicate_reqd = true;
											}
 */
											/*Element routeThirdElement = (Element)childDuplResult;
											NodeList routeThirdChilds = routeThirdElement.getChildNodes();
											for (int m=0; m<routeThirdChilds.getLength();m++ )
											{
												Node childDuplNodeResult = routeThirdChilds.item(m);
												if (childDuplNodeResult.getNodeName().equalsIgnoreCase("Duplicate") && duplicate_reqd==false)			 //add later&& interaction_reqd==false
												{
													duplicate_reqd = true;
												}
 											} */
	/*									}
									}
								}
							}
						}
					} 
				}	*/	
			} // end of xmlData 
 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			alert_reqd.put("DUPCHECK",  duplicate_reqd);
			alert_reqd.put("INTRACHECK", interaction_reqd);
			alert_reqd.put("HEALTHINTRACHECK", contraindication_reqd);
		}
		if(debugMsg.equals("Y"))
		  System.err.println("===========getInteraction method ending========"+alert_reqd);	
		return alert_reqd;
	}

	public HashMap getAllergyCheck(StringBuffer xmlData, String exp_prodid){
		
		boolean allergy_alert_reqd   = false;  
		HashMap alert_reqd		 = new HashMap();  
		DocumentBuilderFactory docBuilderFactory = null;
		DocumentBuilder docBuilder = null;
		Document doc;
		double allergyCount			= 0.0;  // IN066787 - Performance
		try {
			if(xmlData!=null && xmlData.length() > 0 ){
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();
				doc = docBuilder.parse(new InputSource(new StringReader(xmlData.toString())));

			 /*   IN066787 - Performance  */
 				XPathFactory xpf		= XPathFactory.newInstance();
				XPath xpath				= xpf.newXPath();
				//XPathExpression expr	= xpath.compile("count(//Interaction/*[not(@Mirror)]/Allergy)");
				XPathExpression expr	= xpath.compile("count(//Interaction/*[@reference='"+exp_prodid+"' and not(@Mirror)]/Allergy)"); // IN066787 - Performance

				allergyCount			= (Double) expr.evaluate(doc, XPathConstants.NUMBER);
			    if(allergyCount > 0.0) {
					allergy_alert_reqd  = true;
				}
				System.err.println("====================2018===ALLERGY COUNT=====allergyCount"+allergyCount+"===allergy_alert_reqd"+allergy_alert_reqd);

			/* // IN066787 - Performance   */

			/*	// IN066787 - Performance -- 
				Node root = doc.getDocumentElement();
				NodeList childRoots = root.getChildNodes();
				for (int i = 0; i < childRoots.getLength(); i++) {	
					Node child = childRoots.item(i);
					if(child.getParentNode().getNodeName().equalsIgnoreCase("Result") && child.getNodeName().equalsIgnoreCase("Interaction") && allergy_alert_reqd==false){
						// Route Nodes
						Element routeMainElement = (Element)child;
						NodeList routeChilds = routeMainElement.getChildNodes();
						for (int j=0; j<routeChilds.getLength();j++ ){
							Node childNode = routeChilds.item(j);
							if ((childNode.getNodeName().equalsIgnoreCase("GGPI") || childNode.getNodeName().equalsIgnoreCase("Product") || childNode.getNodeName().equalsIgnoreCase("GenericItem")) && allergy_alert_reqd==false){
								//SCF-614.1
								NamedNodeMap namedNodeAttributes = childNode.getAttributes();
								for (int z = 0; z < namedNodeAttributes.getLength(); z++) {
									Node attribute = namedNodeAttributes.item(z);
									if(attribute.getNodeName().equalsIgnoreCase("reference") && attribute.getNodeValue().equalsIgnoreCase(exp_prodid)){

										Element routeNewElement = (Element)childNode;
										NodeList routeNewChilds = routeNewElement.getChildNodes();
										for (int k=0; k<routeNewChilds.getLength();k++ ){
											Node childNodeResult = routeNewChilds.item(k);
											if (childNodeResult.getNodeName().equalsIgnoreCase("Allergy") && allergy_alert_reqd==false){
												allergy_alert_reqd = true;
											} // FOR Allergy
										}
									}   // added in SKR-SCF-614.1 
								} // added in SKR-SCF-614.1
							}
						} 
					} 
				}	
					/* // IN066787 - Performance -- uncomment for NEW Added MIMS Coding 2018   */		

			} // end of xmlData 
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			alert_reqd.put("ALLERGYCHECK",  allergy_alert_reqd);
		}
		return alert_reqd;
	}
	// Till here added in June 2012

	//Added in January 2014 - Dosage Checks
	public StringBuffer getWithoutDosageWarningXML(StringBuffer xmlData, String exp_prodid){
		//boolean allergy_alert_reqd   = false;
		//HashMap alert_reqd		 = new HashMap();
		if(debugMsg.equals("Y"))
		   System.err.println("==============getWithoutDosageWarningXML Starting=========");
		StringBuffer sbfResult					 = new StringBuffer();
		DocumentBuilderFactory docBuilderFactory = null;
		DocumentBuilder docBuilder				 = null;
		Document doc;
		int next_count		= 0;
		int remove_count	= 0;

		try {
			if(xmlData!=null && xmlData.length() > 0 ){
				docBuilderFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docBuilderFactory.newDocumentBuilder();
				doc = docBuilder.parse(new InputSource(new StringReader(xmlData.toString())));
				Node root = doc.getDocumentElement();
				NodeList childRoots = root.getChildNodes();
				for (int i = 0; i < childRoots.getLength(); i++) {	
					Node child = childRoots.item(i);
					//if(child.getParentNode().getNodeName().equalsIgnoreCase("Result") && child.getNodeName().equalsIgnoreCase("Interaction") && allergy_alert_reqd==false)
					if(child.getParentNode().getNodeName().equalsIgnoreCase("Result") && child.getNodeName().equalsIgnoreCase("Interaction")){
						// Route Nodes
						Element routeMainElement = (Element)child;
						NodeList routeChilds = routeMainElement.getChildNodes();
						for (int j=0; j<routeChilds.getLength();j++ ){
							Node childNode = routeChilds.item(j);
							//if ((childNode.getNodeName().equalsIgnoreCase("GGPI") || childNode.getNodeName().equalsIgnoreCase("Product") || childNode.getNodeName().equalsIgnoreCase("GenericItem")) && allergy_alert_reqd==false)
							if  (childNode.getNodeName().equalsIgnoreCase("DoseCheck"))	{
								Element routeNewElement = (Element)childNode;
								NodeList routeNewChilds = routeNewElement.getChildNodes();
								for (int d=0; d<routeNewChilds.getLength();d++ ){
									Node childNodeResult = routeNewChilds.item(d);
									if ((childNodeResult.getNodeName().equalsIgnoreCase("GGPI") || childNodeResult.getNodeName().equalsIgnoreCase("Product") || childNodeResult.getNodeName().equalsIgnoreCase("GenericItem")))	{
										remove_count = 0;
										Element routeSecondElement = (Element)childNodeResult;
										NodeList routeSecondChilds = routeSecondElement.getChildNodes();
										for (int e=0; e<routeSecondChilds.getLength();e++ )	{
											next_count = 0;	
											Node childDuplResult = routeSecondChilds.item(e);
											if (childDuplResult.getNodeName().equalsIgnoreCase("Warnings")){
												Element routeThirdElement = (Element)childDuplResult;
												NodeList routeThirdChilds = routeThirdElement.getChildNodes();
												for (int f=0; f<routeThirdChilds.getLength();f++ ){
													Node routeFourthNode = routeThirdChilds.item(f);
													if (routeFourthNode.getNodeName().equalsIgnoreCase("Warning")){
														NamedNodeMap namedNodeDuplicateAttributes = routeFourthNode.getAttributes();
														 for (int g = 0; g < namedNodeDuplicateAttributes.getLength(); g++) {
															Node duplAttribute = namedNodeDuplicateAttributes.item(g);
															if(duplAttribute.getNodeName().equalsIgnoreCase("id") && !duplAttribute.getNodeValue().equalsIgnoreCase("IDS_DOSE_NO_PROFILE_WARNING") && !duplAttribute.getNodeValue().equalsIgnoreCase("IDS_DOSE_NO_SPECIFIC_INFO_WARNING") && next_count==0){
																next_count++;
																remove_count++;
															}
														}
													}		
												}
												if(next_count==0) {
													childDuplResult.getParentNode().removeChild(childDuplResult);  		   // the total element will be reduced
													e--;
													doc.normalize();
												}
											}
										}
									}
									if(remove_count==0) {
										// remove this warning also...not required when no child elements
										childNodeResult.getParentNode().removeChild(childNodeResult);  		   // the total element will be reduced
										d--;
										doc.normalize();
									}
								}
							}
						} 
					} 
				}
				StringWriter buffer = new StringWriter();
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer t = tf.newTransformer();
				t.transform(new DOMSource(doc), new StreamResult(buffer));
				sbfResult.append(buffer.toString());
			
			} // end of xmlData 
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
		//	alert_reqd.put("ALLERGYCHECK",  allergy_alert_reqd);
		}
		if(debugMsg.equals("Y"))
		  System.err.println("==============getWithoutDosageWarningXML Ending========="+sbfResult);

//System.err.println("========Final getWithoutDosageWarningXML Ending"+sbfResult.toString());
		return sbfResult;
	}

	private String getDuration(String duration_type, String duration){
		String duration_str = "";
		if(duration_type!=null && duration_type.equals("H"))
			duration_str = "<Hour>"+duration+"</Hour>";
		else if(duration_type!=null && duration_type.equals("M"))
			duration_str = "<Minute>"+duration+"</Minute>";
		else if(duration_type!=null && duration_type.equals("D"))
			duration_str = "<Day>"+duration+"</Day>";
		else if(duration_type!=null && duration_type.equals("W"))
			duration_str = "<Week>"+duration+"</Week>";
		else if(duration_type!=null && duration_type.equals("L"))
			duration_str = "<Month>"+duration+"</Month>";
		else if(duration_type!=null && duration_type.equals("M"))
			duration_str = "<Year>"+duration+"</Year>";
		return duration_str;
	}

	private void setAgeDetails(String age_in_year_month_days){
		String remain_age = "";
		if(age_in_year_month_days!=null && !age_in_year_month_days.equals("")){
			remain_age = age_in_year_month_days;
			if(age_in_year_month_days.indexOf("Y")!= -1 )  {
				age_years		=  age_in_year_month_days.substring(0,	age_in_year_month_days.indexOf("Y"));
				remain_age		=  age_in_year_month_days.substring(age_in_year_month_days.indexOf("Y"), age_in_year_month_days.length());
				if(age_years!=null && !age_years.equals(""))  {
					age_years =  (age_years==null?"0":age_years);
				}
			} 
			
			if(remain_age.indexOf("M")!= -1 )  {
				if(age_years!=null && !age_years.equals(""))  
					age_months		=  remain_age.substring(1,	remain_age.indexOf("M"));
				else
					age_months		=  remain_age.substring(0,	remain_age.indexOf("M"));
				remain_age		=  remain_age.substring(remain_age.indexOf("M"), remain_age.length());
				if(age_months!=null && !age_months.equals("")) {
					age_months	=  (age_months==null?"0":age_months);
				}
			} 
																	
			if(remain_age.indexOf("D")!= -1 )  {
				if( (age_years!=null && !age_years.equals("")) ||   (age_months!=null && !age_months.equals("")) )
					age_days		=  remain_age.substring(1,	remain_age.indexOf("D"));
				else
					age_days		=  remain_age.substring(0,	remain_age.indexOf("D"));

				remain_age		=  remain_age.substring(remain_age.indexOf("D"), remain_age.length());
				if(age_days!=null && !age_days.equals("")) 	{ 
					age_days	= (age_days==null?"0":age_days);
				}
			}
		}
	}
}
