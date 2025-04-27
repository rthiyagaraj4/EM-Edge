/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;
 public class Merger
	{
		private WordsCollection _original;
		private WordsCollection _modified;
		private IntVector fwdVector;
		private IntVector bwdVector;
		HtmlTextParser p1;
		HtmlTextParser p2;
		public Merger(String original, String modified)
		{	
			
			System.out.println(original);
			System.out.println(modified);
			
			_original = 	HtmlTextParser.parse(original);
			_modified = 	HtmlTextParser.parse(modified);
			fwdVector = new IntVector(_original.getCount() + _modified.getCount());
			bwdVector = new IntVector(_original.getCount() + _modified.getCount());
		}
		public final int getWordsInOriginalFile()
		{
			return _original.getCount();
		}

				/** 
				 Return the number of words in the parsed modified file
				 
				*/
				public final int getWordsInModifiedFile()
				{
					return _modified.getCount();
				}
		
		private MiddleSnake findMiddleSnake(mySequence1 src, mySequence1 des)
		{
			int d, k;
			int x, y;
			MiddleSnake midSnake = new MiddleSnake();
			int minDiag = src.StartIndex - des.EndIndex;
			int maxDiag = src.EndIndex - des.StartIndex;
			int fwdMid = src.StartIndex - des.StartIndex;
			int bwdMid = src.EndIndex - des.EndIndex;

			int fwdMin = fwdMid;
			int fwdMax = fwdMid;

			int bwdMin = bwdMid;
			int bwdMax = bwdMid;

			boolean odd = ((fwdMin - bwdMid) & 1) == 1;
					
			fwdVector.setItem(fwdMid,src.StartIndex);
			bwdVector.setItem(bwdMid,src.EndIndex);

		for (d = 1; ; d++)
			{
				if (fwdMin > minDiag)
				{
					fwdVector.setItem(--fwdMin -1,-1);
				}
				else
				{
					++fwdMin;
				}

				if(fwdMax < maxDiag)
				{
					fwdVector.setItem(++fwdMax +1,-1);
				}
				else
				{
					--fwdMax;
				}
				for (k = fwdMax; k >= fwdMin; k -= 2)
				{
					if (fwdVector.getItem(k-1) < fwdVector.getItem(k+1))
					{
						x = fwdVector.getItem(k+1);
					}
					else
					{
						x = fwdVector.getItem(k-1) + 1;
					}
					y = x - k;
					midSnake.Source.StartIndex = x;
					midSnake.Destination.StartIndex = y;

					while (x < src.EndIndex && y < des.EndIndex && Word.CompareTo(_original.getItem(x),_modified.getItem(y)) == 0)
					{
						x++;
						y++;
					}

					fwdVector.setItem(k,x);

					if (odd && k >= bwdMin && k <= bwdMax && x >= bwdVector.getItem(k))
					{
						midSnake.Source.EndIndex = x;
						midSnake.Destination.EndIndex = y;
						midSnake.SES_Length = 2 * d -1;

						return midSnake;
					}
				}

				if (bwdMin > minDiag)
				{
					bwdVector.setItem(--bwdMin -1,Integer.MAX_VALUE);
				}
				else
				{
					++bwdMin;
				}

				if(bwdMax < maxDiag)
				{
					bwdVector.setItem(++bwdMax +1,Integer.MAX_VALUE);
				}
				else
				{
					--bwdMax;
				}
				for (k = bwdMax; k >= bwdMin; k -= 2)
				{
					if (bwdVector.getItem(k - 1) < bwdVector.getItem(k + 1))
					{
						x = bwdVector.getItem(k - 1);
					}
					else
					{
						x = bwdVector.getItem(k + 1) - 1;
					}
					y = x - k;
					midSnake.Source.EndIndex = x;
					midSnake.Destination.EndIndex = y;

					while (x > src.StartIndex && y > des.StartIndex && Word.CompareTo(_original.getItem(x-1),_modified.getItem(y-1)) == 0)
					{
						x--;

						y--;
					}
					bwdVector.setItem(k,x);


					if (!odd && k >= fwdMin && k <= fwdMax && x <= fwdVector.getItem(k))
					{
						midSnake.Source.StartIndex = x;
						midSnake.Destination.StartIndex = y;
						midSnake.SES_Length = 2 * d;

						return midSnake;
					}
				}
			}
		}

		private String doMerge(mySequence1 src, mySequence1 des)
		{
			MiddleSnake snake;
			mySequence1 s;
			StringBuilder result = new StringBuilder();
			String tail = "";
			//mySequence1Status ss;

			int y = des.StartIndex;

			while(src.StartIndex < src.EndIndex && des.StartIndex < des.EndIndex && Word.CompareTo(_original.getItem(src.StartIndex),_modified.getItem(des.StartIndex)) == 0)
			{
				src.StartIndex++;
				des.StartIndex++;
			}

			if (des.StartIndex > y)
			{
				s = new mySequence1(y, des.StartIndex);
				result.append(constructText(s, Comparisons2.Nochange));
			}

			y = des.EndIndex;
		   while(src.StartIndex < src.EndIndex && des.StartIndex < des.EndIndex && Word.CompareTo(_original.getItem(src.EndIndex-1),_modified.getItem(des.EndIndex-1)) == 0)
			{
				src.EndIndex--;
				des.EndIndex--;
			}

			if (des.EndIndex < y)
			{
				s = new mySequence1(des.EndIndex, y);
				tail = constructText(s, Comparisons2.Nochange);
			}
			int N = src.EndIndex - src.StartIndex;
			int M = des.EndIndex - des.StartIndex;
			if (N < 1 && M < 1)
			{
				return (result.append(tail)).toString();
			}
			else if (N < 1)
			{
				result.append(constructText(des, Comparisons2.Inserted));
				result.append(tail);
				return result.toString();
			}
			else if (M < 1)
			{
				result.append(constructText(src, Comparisons2.Deleted));
				result.append(tail);
				return result.toString();
			}
			else if (M == 1 && N ==1)
			{
				result.append(constructText(src, Comparisons2.Deleted));
				result.append(constructText(des, Comparisons2.Inserted));
				result.append(tail);
				return result.toString();
			}
			else
			{
				snake = findMiddleSnake(src, des);

				if (snake.SES_Length > 1)
				{

					mySequence1 leftSrc = new mySequence1(src.StartIndex, snake.Source.StartIndex);
					mySequence1 leftDes = new mySequence1(des.StartIndex, snake.Destination.StartIndex);
					mySequence1 rightSrc = new mySequence1(snake.Source.EndIndex, src.EndIndex);

					mySequence1 rightDes = new mySequence1(snake.Destination.EndIndex, des.EndIndex);

					result.append(doMerge(leftSrc, leftDes));
					if (snake.Source.StartIndex < snake.Source.EndIndex)
					{
						result.append(constructText(snake.Destination, Comparisons2.Nochange));
					}
					result.append(doMerge(rightSrc, rightDes));
					result.append(tail);
					return result.toString();
				}
				else
				{
					if (N > M)
					{
						if (src.StartIndex != snake.Source.StartIndex)
						{
							// case 1
							mySequence1 leftSrc = new mySequence1(src.StartIndex, snake.Source.StartIndex);
							result.append(constructText(leftSrc,   Comparisons2.Deleted));
							result.append(constructText(snake.Destination, Comparisons2.Nochange));
						}
						else
						{
							// case 2
							mySequence1 rightSrc = new mySequence1(snake.Source.StartIndex, src.EndIndex);
							result.append(constructText(rightSrc,  Comparisons2.Deleted));
							result.append(constructText(snake.Destination, Comparisons2.Nochange));
						}
					}
					else
					{
						if (des.StartIndex != snake.Destination.StartIndex)
						{
							// case 3
							mySequence1 upDes = new mySequence1(des.StartIndex, snake.Destination.StartIndex);
							result.append(constructText(upDes,   Comparisons2.Inserted));
							result.append(constructText(snake.Destination, Comparisons2.Nochange));
						}
						else
						{
							// case 4
							mySequence1 bottomDes = new mySequence1(snake.Destination.EndIndex, des.EndIndex);
							result.append(constructText(bottomDes,  Comparisons2.Inserted));
							result.append(constructText(snake.Destination, Comparisons2.Nochange));
						}
					}
					result.append(tail);
					return result.toString();
				}
			}
		}

		private String constructText(mySequence1 seq, int status)
		{
			StringBuilder result = new StringBuilder();

			switch(status)
			{
				case 0:
					for (int i= seq.StartIndex; i < seq.EndIndex; i++)
					{
						result.append(_original.getItem(i).reconstruct(Comparisons2.BeginTag,Comparisons2.EndTag));
					}
					break;
				case 1:
					for (int i= seq.StartIndex; i < seq.EndIndex; i++)
					{
						result.append(_modified.getItem(i).reconstruct(Comparisons2.BeginTag1,Comparisons2.EndTag1));
					}
					break;
				case 2:
					for (int i= seq.StartIndex; i < seq.EndIndex; i++)
					{
						result.append(_modified.getItem(i).reconstruct());
					}
					break;
				default:
					break;
			}
			return result.toString();
		}

		public String merge()
		{
			mySequence1 src = new mySequence1(0, _original.getCount());
			mySequence1 des = new mySequence1(0, _modified.getCount());

			return doMerge(src, des);
		}
	}
