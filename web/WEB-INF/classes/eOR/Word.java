/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eOR;
 public class Word
	{
		private String _word = "";
		private String _prefix = "";
		private String _suffix = "";

		public Word()
		{
			_word = "";
			_prefix = "";
			_suffix = "";
		}

		 public Word(String word, String prefix, String suffix)
		{
			_word = word;
			_prefix = prefix;
			_suffix = suffix;
		}

		public final String getword()
		{
			return _word;
		}
		public final void setword(String value)
		{
			_word = value;
		}
		public final String getPrefix()
		{
			return _prefix;
		}
		public final void setPrefix(String value)
		{
			_prefix = value;
		}

		public final String getSuffix()
		{
			return _suffix;
		}
		public final void setSuffix(String value)
		{
			_suffix = value;
		}

		public final String reconstruct()
		{
			return _prefix + _word + _suffix;
		}

		public final String reconstruct(String BeginTag, String EndTag)
		{
			return _prefix + BeginTag + _word + EndTag + _suffix;
		}

		public static final int CompareTo(Word wrd,Word wrd1)
		{
			//if (obj instanceof Word)
			//{
				return wrd._word.compareTo(wrd1._word);
			//}
			
		}

		

	}
