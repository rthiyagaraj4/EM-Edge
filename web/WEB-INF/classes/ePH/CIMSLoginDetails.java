/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.Serializable ;

public class CIMSLoginDetails extends ePH.Common.PhAdapter implements Serializable{

	String host = "";
	String domain = "";
	String user = "";
	String pass = "";
	String mrcPath = "";
	String mrcPass = "";
	String debugMsg = "";

	public CIMSLoginDetails() {
		// TODO Auto-generated constructor stub
		try {
			//Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("d:/work/MyXMLFile.xml");
			//System.out.println("Root element@@===>"+ doc.getDocumentElement().getNodeName());
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("CIMSDataConnections.xml");
			//Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("CIMSDataConnections.xml");
			NodeList nodeLst = doc.getElementsByTagName("CIMSProperties");
			for (int s = 0; s < nodeLst.getLength(); s++) {
				Node fstNode = nodeLst.item(s);
				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
					Element fstElmnt = (Element) fstNode;
					setHost(fstElmnt.getElementsByTagName("host").item(0)
							.getChildNodes().item(0).getNodeValue());
					setDomain(fstElmnt.getElementsByTagName("domain")
							.item(0).getChildNodes().item(0).getNodeValue());
					setUser(fstElmnt.getElementsByTagName("user").item(0)
							.getChildNodes().item(0).getNodeValue());
					setPass(fstElmnt.getElementsByTagName("pass").item(0)
							.getChildNodes().item(0).getNodeValue());
					setMrcPass(fstElmnt.getElementsByTagName("mrcPass")
							.item(0).getChildNodes().item(0).getNodeValue());
					setMrcPath(fstElmnt.getElementsByTagName("mrcPath")
							.item(0).getChildNodes().item(0).getNodeValue());
					setDebugMsg(fstElmnt.getElementsByTagName("debugMsg")
							.item(0).getChildNodes().item(0).getNodeValue());
				}
			}
			//System.err.println("Host@@===>"+host + "~" + domain + "~" + user+ "~" + pass + "~" + mrcPath + "~" + mrcPass+" debugMsg="+debugMsg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMrcPath() {
		return mrcPath;
	}

	public void setMrcPath(String mrcPath) {
		this.mrcPath = mrcPath;
	}

	public String getMrcPass() {
		return mrcPass;
	}

	public void setMrcPass(String mrcPass) {
		this.mrcPass = mrcPass;
	}
	public String getDebugMsg() {
		return debugMsg;
	}

	public void setDebugMsg(String debugMsg) {
		if(debugMsg==null)
			debugMsg = "";
		this.debugMsg = debugMsg;
	}
}
