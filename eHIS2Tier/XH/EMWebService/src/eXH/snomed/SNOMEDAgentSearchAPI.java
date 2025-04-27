/*******************************************************************************
 * Copyright 2014 Centre for Development of Advanced Computing(C-DAC), Pune
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package eXH.snomed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.lucene.queryparser.classic.ParseException;

import in.cdac.medinfo.csnotk.csnolib.agents.SNOMEDAgent;
import in.cdac.medinfo.csnotk.csnolib.commons.Constants;
import in.cdac.medinfo.csnotk.csnolib.commons.EnumAcceptability;
import in.cdac.medinfo.csnotk.csnolib.commons.EnumState;
import in.cdac.medinfo.csnotk.csnolib.model.CompositeDescription;
import in.cdac.medinfo.csnotk.csnolib.util.Logger;

/**
 * SampleforSearchAPI class contains the sample code for implementing the search
 * APIs in SNOMEDAgent class in CSNOLib. SNOMEDAgent contains the search APIs.
 * search method is overloaded.
 */
public class SNOMEDAgentSearchAPI {
	/**
	 * Main method
	 * 
	 * @param args
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		SNOMEDAgent agent = new SNOMEDAgent();		
		agent.init();		
		System.out.println("Do you want to create SNOMED CT database (y/n)");
		BufferedReader serviceInput = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			String dbOverride = serviceInput.readLine();
			if(dbOverride.equalsIgnoreCase("y"))
			{
				System.out.println("Please Enter SNOMED CT Release directory path till Snapshot");
				String snomedDirPath=serviceInput.readLine();		
				System.out.println(snomedDirPath);
				agent.createSNOMEDdb(snomedDirPath, true);
				
			}
		} catch (IOException e1) {
			//Get the Stack trace and form the exception message.
			StackTraceElement arrStackTraceElement[];
			arrStackTraceElement = e1.getStackTrace();
			String strMessage = e1.getClass() + Constants.NEW_LINE + Constants.CLASS_NAME + arrStackTraceElement[0].getClassName() + Constants.NEW_LINE + Constants.METHOD_NAME + arrStackTraceElement[0].getMethodName() + Constants.NEW_LINE +  Constants.LINE_NUMBER + arrStackTraceElement[0].getLineNumber()+ Constants.NEW_LINE +  Constants.MESSAGE_DESCRIPTION + e1.getMessage();
			//Log the Exception
			Logger.logException(strMessage);
		} 
		
		
		System.out.println("Do you want to create SNOMED CT Extension database (y/n)");
		
		try {
			String dbOverride = serviceInput.readLine();
			if(dbOverride.equalsIgnoreCase("y"))
			{
				System.out.println("Please Enter SNOMED CT Extension Release directory path till Snapshot");
				String snomedExtDirPath=serviceInput.readLine();
				agent.createExtensiondb(snomedExtDirPath, true);
			}
		} catch (IOException e1) {
			//Get the Stack trace and form the exception message.
			StackTraceElement arrStackTraceElement[];
			arrStackTraceElement = e1.getStackTrace();
			String strMessage = e1.getClass() + Constants.NEW_LINE + Constants.CLASS_NAME + arrStackTraceElement[0].getClassName() + Constants.NEW_LINE + Constants.METHOD_NAME + arrStackTraceElement[0].getMethodName() + Constants.NEW_LINE +  Constants.LINE_NUMBER + arrStackTraceElement[0].getLineNumber()+ Constants.NEW_LINE +  Constants.MESSAGE_DESCRIPTION + e1.getMessage();
			//Log the Exception
			Logger.logException(strMessage);
		}
		
				
		System.out
				.println("Sample for Search API. Please select the "
						+ "service you want to use\n1.Search by Term\n2.Search by Limit\n"
						+ "3.Search by State\n4.Search by Hierarchy\n5."
						+ "Search by Acceptability\n"
						+ "Please enter any of the above options:");
		try {
			
			// converts the user input to integer value
			int param = Integer.parseInt(serviceInput.readLine());
			System.out.println("Parameter: term\n"
					+ "It refers to the term/ SNOMED CT concept id that is to be searched"
					+ " in the SNOMED CT Repository. \nExamples- \nTerm: fever,"
					+ "myocardial infarction and etc.\nSNOMED CT Concept Id: 386661006\nPlease enter Search term:");
			/**
			 * termInput takes user Input for the search term.
			 */
			BufferedReader termInput = new BufferedReader(
					new InputStreamReader(System.in));
			/**
			 * matchTerm contains the actual search term. It can be a SNOMED CT
			 * Concept Id or any clinical term defined in SNOMED CT.
			 */
			String matchTerm = termInput.readLine();
			

			switch (param) { 
			case 1: {
				// ------------------search(term);						
				Set<CompositeDescription> descriptions = agent
						.search(matchTerm, false,null,null);				
				// Prints the list of search results obtained.
				for (CompositeDescription description : descriptions) {
					System.out.println(description.getConceptId() + " :"
							+ description.getTerm());
				}
				// Prints the size of the list of search results obtained.
				System.out.println("SIZE OF DESC : " + descriptions.size());				
				break;
			}
			case 2: {
				System.out.println("Parameter: returnlimit\n"
						+ "It refers to the maximum number of matching"
						+ " terms to be returned. It should be a numeric "
						+ "value. Pass -1 to get all the results."
						+ " \nPlease enter return limit:");
				/**
				 * returnlimitInput takes user Input for the return limit.
				 */
				BufferedReader returnlimitInput = new BufferedReader(
						new InputStreamReader(System.in));
				/**
				 * To specify the maximum number of matching terms to be
				 * returned. To get all the search results, returnlimit should
				 * be -1.
				 */
				int returnlimit = Integer.parseInt(returnlimitInput.readLine()
						.trim());
				// ------------------search(term ,returnlimit);
				Set<CompositeDescription> descriptions = agent.search(
						matchTerm, returnlimit, false,null,null);

				// Prints the size of the list of search results obtained.
				System.out.println("SIZE OF DESC : " + descriptions.size());

				// Prints the list of search results obtained.
				for (CompositeDescription description : descriptions) {
					System.out.println(description.getConceptId() + " :"
							+ description.getTerm());
				}				
				break;
			}
			case 3: {
				System.out.println("Parameter: returnlimit\n"
						+ "It refers to the maximum number of matching"
						+ " terms to be returned. It should be a numeric "
						+ "value. Pass -1 to get all the results."
						+ " \nPlease enter return limit:");
				/**
				 * returnlimitInput takes user Input for the return limit.
				 */
				BufferedReader returnlimitInput = new BufferedReader(
						new InputStreamReader(System.in));
				/**
				 * To specify the maximum number of matching terms to be
				 * returned. To get all the search results, returnlimit should
				 * be -1.
				 */
				int returnlimit = Integer.parseInt(returnlimitInput.readLine()
						.trim());
				System.out
						.println("Parameter: state\n"
								+ "It refers to the state of the component to be "
								+ "returned. Possible values are- active,inactive,both."
								+ " \nPlease enter state:");

				/**
				 * stateInput takes user Input for the state of the Concept.
				 */
				BufferedReader stateInput = new BufferedReader(
						new InputStreamReader(System.in));
				/**
				 * enumState defines the active status of the SNOMED CT
				 * Component. The possible values for this attribute are defined
				 * in the enum EnumState [ active,inactive,both]. If enumState
				 * is active, only active components shall be returned by the
				 * API. If enumState is inactive, only inactive components shall
				 * be returned. If enumState is both, both active and inactive
				 * components shall be returned.
				 */
				EnumState enumState = EnumState.getEnum(stateInput.readLine()
						);
				// ------------------search(term,state,returnlimit);
				Set<CompositeDescription> descriptions = agent.search(
						matchTerm, enumState, returnlimit, false,null,null);

				// Prints the size of the list of search results obtained.
				System.out.println("states: SIZE OF DESC : "
						+ descriptions.size());

				// Prints the list of search results obtained.
				for (CompositeDescription description : descriptions) {
					System.out.println(description.getConceptId() + " :"
							+ description.getTerm());
				}
				break;
			}
			case 4: {
				System.out.println("Parameter: returnlimit\n"
						+ "It refers to the maximum number of matching"
						+ " terms to be returned. It should be a numeric "
						+ "value. Pass -1 to get all the results."
						+ " \nPlease enter return limit:");
				/**
				 * returnlimitInput takes user Input for the return limit.
				 */
				BufferedReader returnlimitInput = new BufferedReader(
						new InputStreamReader(System.in));
				/**
				 * To specify the maximum number of matching terms to be
				 * returned. To get all the search results, returnlimit should
				 * be -1.
				 */
				int returnlimit = Integer.parseInt(returnlimitInput.readLine()
						.trim());
				System.out
						.println("Parameter: state\n"
								+ "It refers to the state of the component to be "
								+ "returned. Possible values are- active, inactive, both."
								+ " \nPlease enter state:");
				/**
				 * stateInput takes user Input for the state of the Concept.
				 */
				BufferedReader stateInput = new BufferedReader(
						new InputStreamReader(System.in));		
				
				/**
				 * enumState defines the active status of the SNOMED CT
				 * Component. The possible values for this attribute are defined
				 * in the enum EnumState [ active,inactive,both]. If enumState
				 * is active, only active components shall be returned by the
				 * API. If enumState is inactive, only inactive components shall
				 * be returned. If enumState is both, both active and inactive
				 * components shall be returned.
				 */
				
				EnumState enumState = EnumState.getEnum(stateInput.readLine());
				System.out.println(enumState);
				System.out.println("Parameter: semantictag\n"
								+ "It refers to the semantic tag in which the results are"
								+ "to be searched for. Possible values are as follows-\n"
								+ "all - It will search for SNOMED CT terms in all semantic tags\n"
								+ "Other possible values are- procedure, disorder, finding,"
								+ " observable entity, body structure, organism, substance, "
								+ "specimen, special concept, linkage concept, physical force,"
								+ " event, environment, geographic location, social concept, "
								+ "situation, staging scale, physical object, qualifier value,"
								+ " record artifact, person, link assertion, namespace concept,"
								+ " attribute, assessment scale, racial group, tumor staging, "
								+ "occupation, morphologic abnormality, cell, cell structure, "
								+ "ethnic group, product, inactive concept, navigational concept,"
								+ " life style, regime/therapy, religion/philosophy ."
								+ " \nPlease enter semantic tag:");

				/**
				 * semTagInput takes user Input for the semantic tag in which
				 * the term has to be searched for.
				 */
				BufferedReader semTagInput = new BufferedReader(new InputStreamReader(System.in));
				/**
				 * enumSemantictag specifies the semantic tag in which the term
				 * has to be searched. The possible values for this attribute
				 * are defined in the enum EnumSemanticTag [ all, procedure,
				 * disorder, finding, observable entity, body structure,
				 * organism, substance, specimen, special concept, linkage
				 * concept, physical force, event, environment, geographic
				 * location, social concept, situation, staging scale, physical
				 * object, qualifier value , record artifact, person, link
				 * assertion, namespace concept, attribute, assessment scale,
				 * racial group, tumor staging, occupation, morphologic
				 * abnormality, cell, cell structure, ethnic group, product,
				 * inactive concept, navigational concept, life style,
				 * regime/therapy, religion/philosophy ]
				 */
				List<String> semanticTagList = new ArrayList<String>();				
				semanticTagList.addAll(Arrays.asList(semTagInput.readLine().split("[++]")));			
			
				Set<CompositeDescription> descriptions = agent.search(
						matchTerm, enumState, semanticTagList, returnlimit, false,null,null);				
				// Prints the size of the list of search results obtained.
				System.out.println("Semantic: SIZE OF DESC : "+ descriptions.size());

				// Prints the list of search results obtained.
				for (CompositeDescription description : descriptions)
					System.out.println(description.getConceptId() + " :"+ description.getTerm());					
			
				break;
			}
			case 5: {
				System.out.println("Parameter: returnlimit\n"
						+ "It refers to the maximum number of matching"
						+ " terms to be returned. It should be a numeric "
						+ "value. Pass -1 to get all the results."
						+ " \nPlease enter return limit:");
				/**
				 * returnlimitInput takes user Input for the return limit.
				 */
				BufferedReader returnlimitInput = new BufferedReader(
						new InputStreamReader(System.in));
				/**
				 * To specify the maximum number of matching terms to be
				 * returned. To get all the search results, returnlimit should
				 * be -1.
				 */
				int returnlimit = Integer.parseInt(returnlimitInput.readLine()
						.trim());
				System.out
						.println("Parameter: state\n"
								+ "It refers to the state of the component to be "
								+ "returned. Possible values are- active, inactive, both."
								+ " \nPlease enter state:");
				/**
				 * stateInput takes user Input for the state of the Concept.
				 */
				BufferedReader stateInput = new BufferedReader(
						new InputStreamReader(System.in));
				/**
				 * enumState defines the active status of the SNOMED CT
				 * Component. The possible values for this attribute are defined
				 * in the enum EnumState [ active,inactive,both]. If enumState
				 * is active, only active components shall be returned by the
				 * API. If enumState is inactive, only inactive components shall
				 * be returned. If enumState is both, both active and inactive
				 * components shall be returned.
				 */
				EnumState enumState = EnumState.getEnum(stateInput.readLine());
				System.out.println("Parameter: semantictag\n"
								+ "It refers to the semantic tag in which the results are"
								+ "to be searched for. Possible values are as follows-\n"
								+ "all - It will search for SNOMED CT terms in all semantic tags\n"
								+ "Other possible values are- procedure, disorder, finding,"
								+ " observable entity, body structure, organism, substance, "
								+ "specimen, special concept, linkage concept, physical force,"
								+ " event, environment, geographic location, social concept, "
								+ "situation, staging scale, physical object, qualifier value,"
								+ " record artifact, person, link assertion, namespace concept,"
								+ " attribute, assessment scale, racial group, tumor staging, "
								+ "occupation, morphologic abnormality, cell, cell structure, "
								+ "ethnic group, product, inactive concept, navigational concept,"
								+ " life style, regime/therapy, religion/philosophy ."
								+ " \nPlease enter semantic tag:");
				/**
				 * semTagInput takes user Input for the semantic tag in which
				 * the term has to be searched for.
				 */
				BufferedReader semTagInput = new BufferedReader(new InputStreamReader(System.in));
				/**
				 * enumSemantictag specifies the semantic tag in which the term
				 * has to be searched. The possible values for this attribute
				 * are defined in the enum EnumSemanticTag [ all,procedure,
				 * disorder, finding, etc]
				 */
			
				List<String> semanticTagList = new ArrayList<String>();				
				semanticTagList.addAll(Arrays.asList(semTagInput.readLine().split("[++]")));			
				System.out
						.println("Parameter: acceptability\n"
								+ "refers to the acceptability value for the search term."
								+ "Possible values are as follows-\n"
								+ "[preferred, preferredexcludingfsn, synonyms, acceptable, all]"
								+ " \nPlease enter acceptability:");
				/**
				 * acceptabilityInput takes user Input for acceptability
				 */
				BufferedReader acceptabilityInput = new BufferedReader(
						new InputStreamReader(System.in));
				/**
				 * enumAcceptability refers to the acceptability value for the
				 * search term. Its possible values have been defined in the
				 * enum EnumAcceptability [preferred, preferredexcludingfsn,
				 * synonyms, acceptable, all]. If enumAcceptability is
				 * preferred, only preferred terms shall be returned by the API.
				 * If enumAcceptability is preferredexcludingfsn, only
				 * preferred terms excluding FSN shall be returned. If
				 * enumAcceptability is synonyms, only synonyms shall be
				 * returned. If enumAcceptability is acceptable, only acceptable
				 * terms shall be returned. If enumAcceptability is all, all
				 * terms shall be returned, irrespective of their acceptability
				 * value.
				 */
				EnumAcceptability enumAcceptability = EnumAcceptability
						.getEnum(acceptabilityInput.readLine());
				// ------------------search(term,state,semantictag,acceptability,returnlimit);
				Set<CompositeDescription> descriptions = agent.search(
						matchTerm, enumState, semanticTagList,
						enumAcceptability, returnlimit, false,null,null);

				// Prints the size of the list of search results obtained.
				System.out.println("Acceptability: SIZE OF DESC : "
						+ descriptions.size());

				// Prints the list of search results obtained.
				for (CompositeDescription description : descriptions) {
					System.out.println(description.getConceptId() + " :"
							+ description.getTerm());
				}
				break;
			}
			default: {
				System.out.println("Invalid option");
				break;
			}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
