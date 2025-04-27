/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.iba.framework.core.util.ServiceLocator;

public class QueryGetter {

	private List queryMaps;

	private static Hashtable queryHolder = null;

	public static String getQuery(String queryId)
			throws ParserConfigurationException, SAXException, IOException {
		String query = null;

		QueryGetter.queryHolder = new Hashtable();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		ClassLoader bundleClassLoader = Thread.currentThread()
				.getContextClassLoader();
		List list = ((QueryGetter) ServiceLocator.getInstance().getBean(
				"queryMapFile")).getQueryMaps();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = (Object) iter.next();
			URL url = bundleClassLoader.getResource((String) element);
			Document doc = builder.parse(new File(url.getFile()));
			Element firstNameElement = null;
			NodeList queryNodes = doc.getElementsByTagName("hibernate-mapping");
			for (int s = 0; s < queryNodes.getLength(); s++) {
				Node firstIdNode = queryNodes.item(s);

				if (firstIdNode.getNodeType() == Node.ELEMENT_NODE) {
					Element firstIdElement = (Element) firstIdNode;
					NodeList firstNameList = firstIdElement
							.getElementsByTagName("query");
					for (int i = 0; i < firstNameList.getLength(); i++) {
						Node projIdNode = firstNameList.item(i);
						if (projIdNode.getNodeType() == Node.ELEMENT_NODE) {
							Element projElement = (Element) projIdNode;
							String queryID = projElement.getAttribute("name");
							if (queryID.equals(queryId)) {
								firstNameElement = (Element) firstNameList
										.item(i);
								query = QueryGetter
										.getContentText(firstNameElement);

							}
							/* queryHolder.put(queryID, query); */
						}
					}

				}

			}
			// Get the initial query nodes
			/*
			 * queryNodes = doc.getChildNodes().item(3) .getChildNodes();
			 * 
			 * for (int queryNodeIndex = 0; queryNodeIndex < queryNodes
			 * .getLength(); queryNodeIndex++) { // Go only through the query
			 * Element nodes if (queryNodes.item(queryNodeIndex).getNodeType() ==
			 * Node.ELEMENT_NODE) {
			 * 
			 * Element queryElement = (Element) queryNodes
			 * .item(queryNodeIndex); // Get the query ID String queryID =
			 * queryElement.getAttribute("name");
			 * 
			 * query = getContentText(queryElement);
			 * 
			 * queryHolder.put(queryID, query); } }
			 */
		}
		/*
		 * query = (String) queryHolder.get(queryId); }
		 */

		return query;
	}

	private static String getContentText(Element element) {
		StringBuffer buffer = new StringBuffer();
		NodeList nodeList = element.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node instanceof CharacterData) {
				CharacterData characterData = (CharacterData) node;
				buffer.append(characterData.getData());
			}
		}
		return buffer.toString();
	}

	public List getQueryMaps() {
		return queryMaps;
	}

	public void setQueryMaps(List queryMaps) {
		this.queryMaps = queryMaps;
	}
}
