/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;
 public class HtmlTextParser
	{
		public static WordsCollection parse(String s)
		{
			int curPos = 0;
			int prevPos;
			String prefix = "";
			String suffix = "";
			String word = "";
			WordsCollection words = new WordsCollection();

			while (curPos < s.length())
			{

				prevPos = curPos;
				while (curPos < s.length() && (Character.isISOControl(s.charAt(curPos)) || Character.isWhitespace(s.charAt(curPos))))
				{
					curPos++;
				}
				prefix = prefix+(s.substring(prevPos, curPos));
				if (curPos == s.length())
				{
					if (!prefix.equals(""))
					{
						// report a empty word with prefix.
						words.add(new Word("", prefix, ""));
					}
					break;
				}

				if (s.charAt(curPos) == '<')
				{
					prevPos = curPos;
					while (s.charAt(curPos) != '>' && curPos < s.length())
					{
						curPos++;
					}
					prefix = prefix+(s.substring(prevPos, curPos + 1));

					if (curPos == s.length())
					{
						words.add(new Word("", prefix, ""));
						break;
					}
					curPos++;
					if (curPos == s.length())
					{
						words.add(new Word("", prefix, ""));
						break;
					}
					continue;
				}
				else if (s.charAt(curPos) == '&')
				{
					prevPos = curPos;

					if (curPos + 6 < s.length() && s.substring(prevPos, prevPos + 6).equals("&nbsp;"))
					{
						prefix = prefix+"&nbsp;";
						curPos = curPos+6;
						continue;
					}
					
				      String substr=s.substring(prevPos, prevPos + 6);
				   if (curPos + 6 < s.length()&& substr.matches("&#[0-9]{3};"))
					{
						words.add(new Word(s.substring(prevPos, prevPos + 6), prefix, ""));
						prefix = "";
						curPos = curPos+6;
						continue;
					}
					
				   
				   String substr1=s.substring(prevPos, prevPos + 5);
					if (curPos + 5 < s.length() && substr1.matches("&#[0-9]{2};"))
					{
						words.add(new Word(s.substring(prevPos, prevPos + 5), prefix, ""));
						prefix = "";
						curPos = curPos+5;
						continue;
					}

					prevPos = curPos;
					while (curPos < s.length() && !Character.isISOControl(s.charAt(curPos)) && !Character.isWhitespace(s.charAt(curPos)) && s.charAt(curPos) != '<')
					{
						curPos++;
					}
					word = s.substring(prevPos, curPos);
					prevPos = curPos;
					while (curPos < s.length() && (Character.isISOControl(s.charAt(curPos)) || Character.isWhitespace(s.charAt(curPos))))
					{
					curPos++;
					}
					suffix = suffix+(s.substring(prevPos, curPos));

					words.add(new Word(word, prefix, suffix));
					prefix = "";
					suffix = "";
				}
				else
				{
					prevPos = curPos;
					while (curPos < s.length() && !Character.isISOControl(s.charAt(curPos)) && !Character.isWhitespace(s.charAt(curPos)) && s.charAt(curPos) != '<' && s.charAt(curPos) != '&')
					{
						curPos++;
					}
					word = s.substring(prevPos, curPos);
					
					prevPos = curPos;
					while (curPos < s.length() && (Character.isISOControl(s.charAt(curPos)) || Character.isWhitespace(s.charAt(curPos))))
					{
						curPos++;
					}
					suffix = s.substring(prevPos, curPos);
					processWord(words, prefix, word, suffix);
					prefix = "";
					suffix = "";
				}
				
			}
			
			return words;
		}

		private static void processWord(WordsCollection words, String prefix, String word, String suffix)
		{
			int length = word.length();

			if (length == 1)
			{
				words.add(new Word(word, prefix, suffix));
			}
			else if (!Character.isLetterOrDigit(word.charAt(0)))
			{
				words.add(new Word(word.substring(0,0), prefix, ""));
				words.add(new Word(word.substring(1), "", suffix));
				return;
			}
			/*else if (Character.isPunctuation(word.charAt(length-1)))
			{
				words.add(new Word(word.substring(0, length-1), prefix, ""));
				words.add(new Word(word.substring(length-1,0), "", suffix));
			}*/
			else
			{
				words.add(new Word(word, prefix, suffix));
			}
		}
	}
