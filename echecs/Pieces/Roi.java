package Pieces;

public class Roi
{
	public static boolean roiBlancABouger = false;
	public static boolean roiNoirABouger = false;


	public static boolean estPossible(String roiABouger, String caseDeDestination, int[][] echiquier)
	{
		int colonneDuRoi = Character.getNumericValue(roiABouger.charAt(0));
		int ligneDuRoi = Character.getNumericValue(roiABouger.charAt(1));

		int ligneDeDestination = Character.getNumericValue(caseDeDestination.charAt(1));
		int colonneDeDestination = Character.getNumericValue(caseDeDestination.charAt(0));

		boolean bOk = false;

		if(colonneDuRoi > 7 || colonneDuRoi < 0 || ligneDuRoi > 7 || ligneDuRoi < 0 || colonneDeDestination > 7 || colonneDeDestination < 0 || ligneDeDestination > 7 || ligneDeDestination < 0)
		{
			return false;
		}

		if(ligneDuRoi+1 == ligneDeDestination && colonneDuRoi == colonneDeDestination)
		{
			bOk = true;
		}
		else if(ligneDuRoi-1 == ligneDeDestination && colonneDuRoi == colonneDeDestination)
		{
			bOk = true;
		}
		else if(ligneDuRoi == ligneDeDestination && colonneDuRoi+1 == colonneDeDestination)
		{
			bOk = true;
		}
		else if(ligneDuRoi == ligneDeDestination && colonneDuRoi-1 == colonneDeDestination)
		{
			bOk = true;
		}
		else if(ligneDuRoi+1 == ligneDeDestination && colonneDuRoi+1 == colonneDeDestination)
		{
			bOk = true;
		}
		else if(ligneDuRoi+1 == ligneDeDestination && colonneDuRoi-1 == colonneDeDestination)
		{
			bOk = true;
		}
		else if(ligneDuRoi-1 == ligneDeDestination && colonneDuRoi+1 == colonneDeDestination)
		{
			bOk = true;
		}
		else if(ligneDuRoi-1 == ligneDeDestination && colonneDuRoi-1 == colonneDeDestination)
		{
			bOk = true;
		}
		else if(ligneDuRoi == ligneDeDestination && colonneDuRoi+2 == colonneDeDestination)
		{
			if(echiquier[ligneDuRoi][colonneDuRoi+1] == 0 && echiquier[ligneDuRoi][colonneDuRoi+2] == 0)
			{
				if(echiquier[ligneDuRoi][colonneDuRoi] == 8 && !Tour.tBH) bOk = true;
				if(echiquier[ligneDuRoi][colonneDuRoi] == -8 && !Tour.tNH) bOk = true;

			}
		}
		else if(ligneDuRoi == ligneDeDestination && colonneDuRoi-2 == colonneDeDestination)
		{
			if(echiquier[ligneDuRoi][colonneDuRoi-1] == 0 && echiquier[ligneDuRoi][colonneDuRoi-2] == 0)
			{
				if(echiquier[ligneDuRoi][colonneDuRoi] == 8 && !Tour.tBA) bOk = true;
				if(echiquier[ligneDuRoi][colonneDuRoi] == -8 && !Tour.tNA) bOk = true;
			}
		}

		if(bOk)
		{
			if(echiquier[ligneDuRoi][colonneDuRoi] == 8)
			{
				if(echiquier[ligneDeDestination][colonneDeDestination] <= 0 )
				{
					roiBlancABouger = true;
					return true;
				}
			}
			else if(echiquier[ligneDuRoi][colonneDuRoi] == -8)
			{
				if(echiquier[ligneDeDestination][colonneDeDestination] >= 0)
				{
					roiNoirABouger = true;
					return true;
				}
			}
		}

		return false;
	}


	public static boolean estEchec(int joueur, int[][] echiquier)
	{
		int colonneDuRoi = 0;
		int ligneDuRoi = 0;

		for(int i = 0; i < echiquier.length; i++)
		{
			for(int j = 0; j < echiquier.length; j++)
			{
				if(joueur == 1)
				{
					if(echiquier[i][j] == 8)
					{
						ligneDuRoi = i;
						colonneDuRoi = j;
					}
				}
				if(joueur == 2)
				{
					if(echiquier[i][j] == -8)
					{
						ligneDuRoi = i;
						colonneDuRoi = j;
					}
				}
			}
		}


		// pour le roi blanc
		if(echiquier[ligneDuRoi][colonneDuRoi] == 8)
		{
			
			//si y'a un pion
			if((ligneDuRoi-1 >= 0 && colonneDuRoi-1 >= 0  && echiquier[ligneDuRoi-1][colonneDuRoi-1] == -1) || (ligneDuRoi-1 >= 0 && colonneDuRoi+1 <= 7  && echiquier[ligneDuRoi-1][colonneDuRoi+1] == -1))
			{
				return true;
			}

			//si y'a une tour ou une dame
			
			//à droite du roi
			for(int i = 1; i <= 7-colonneDuRoi; i++)
			{
				if(echiquier[ligneDuRoi][colonneDuRoi+i] != -5 && echiquier[ligneDuRoi][colonneDuRoi+i] != -9 && echiquier[ligneDuRoi][colonneDuRoi+i] != 0)
				{
					break;
				}
				if(echiquier[ligneDuRoi][colonneDuRoi+i] == -5 || echiquier[ligneDuRoi][colonneDuRoi+i] == -9)
				{
					return true;
				}
			}

			//à gauche du roi
			for(int i = 1; i <= colonneDuRoi; i++)
			{
				if(echiquier[ligneDuRoi][colonneDuRoi-i] != -5 && echiquier[ligneDuRoi][colonneDuRoi-i] != -9 && echiquier[ligneDuRoi][colonneDuRoi-i] != 0)
				{
					break;
				}
				if(echiquier[ligneDuRoi][colonneDuRoi-i] == -5 || echiquier[ligneDuRoi][colonneDuRoi-i] == -9)
				{
					return true;
				}
			}

			//en dessous du roi
			for(int i = 1; i <= 7-ligneDuRoi; i++)
			{
				if(echiquier[ligneDuRoi+i][colonneDuRoi] != -5 && echiquier[ligneDuRoi+i][colonneDuRoi] != -9 && echiquier[ligneDuRoi+i][colonneDuRoi] != 0)
				{
					break;
				}
				if(echiquier[ligneDuRoi+i][colonneDuRoi] == -5 || echiquier[ligneDuRoi+i][colonneDuRoi] == -9)
				{
					return true;
				}
			}

			//au dessus du roi
			for(int i = 1; i <= ligneDuRoi; i++)
			{
				if(echiquier[ligneDuRoi-i][colonneDuRoi] != -5 && echiquier[ligneDuRoi-i][colonneDuRoi] != -9 && echiquier[ligneDuRoi-i][colonneDuRoi] != 0)
				{
					break;
				}
				if(echiquier[ligneDuRoi-i][colonneDuRoi] == -5 || echiquier[ligneDuRoi-i][colonneDuRoi] == -9)
				{
					return true;
				}
			}



			//si y'a un cavalier
			if(ligneDuRoi+1 <= 7 && colonneDuRoi+2 <= 7 && echiquier[ligneDuRoi+1][colonneDuRoi+2] == -3)
			{
				return true;
			}
			if(ligneDuRoi-1 >= 0 && colonneDuRoi+2 <= 7 && echiquier[ligneDuRoi-1][colonneDuRoi+2] == -3)
			{
				return true;
			}
			if(ligneDuRoi+1 <= 7 && colonneDuRoi-2 >= 0 && echiquier[ligneDuRoi+1][colonneDuRoi-2] == -3)
			{
				return true;
			}
			if(ligneDuRoi-1 >= 0 && colonneDuRoi-2 >= 0 && echiquier[ligneDuRoi-1][colonneDuRoi-2] == -3)
			{
				return true;
			}
			if(ligneDuRoi+2 <= 7 && colonneDuRoi+1 <= 7 && echiquier[ligneDuRoi+2][colonneDuRoi+1] == -3)
			{
				return true;
			}
			if(ligneDuRoi-2 >= 0 && colonneDuRoi+1 <= 7 && echiquier[ligneDuRoi-2][colonneDuRoi+1] == -3)
			{
				return true;
			}
			if(ligneDuRoi+2 <= 7 && colonneDuRoi-1 >= 0 && echiquier[ligneDuRoi+2][colonneDuRoi-1] == -3)
			{
				return true;
			}
			if(ligneDuRoi-2 >= 0 && colonneDuRoi-1 >= 0 && echiquier[ligneDuRoi-2][colonneDuRoi-1] == -3)
			{
				return true;
			}

			//si y'a un fou ou une dame 
			int cpt = 1;
			while(ligneDuRoi+cpt <= 7 && colonneDuRoi+cpt <= 7 )
			{
				
				if(echiquier[ligneDuRoi+cpt][colonneDuRoi+cpt] != -4 && echiquier[ligneDuRoi+cpt][colonneDuRoi+cpt] != 0 && echiquier[ligneDuRoi+cpt][colonneDuRoi+cpt] != -9 )
				{
					break;
				}
				if(echiquier[ligneDuRoi+cpt][colonneDuRoi+cpt] == -4 || echiquier[ligneDuRoi+cpt][colonneDuRoi+cpt] == -9)
				{
					return true;
				}
				cpt++;
			}

			cpt = 1;
			while(ligneDuRoi+cpt <= 7 && colonneDuRoi-cpt >= 0 )
			{
				if(echiquier[ligneDuRoi+cpt][colonneDuRoi-cpt] != -4 && echiquier[ligneDuRoi+cpt][colonneDuRoi-cpt] != 0  && echiquier[ligneDuRoi+cpt][colonneDuRoi-cpt] != -9)
				{
					break;
				}
				if(echiquier[ligneDuRoi+cpt][colonneDuRoi-cpt] == -4  || echiquier[ligneDuRoi+cpt][colonneDuRoi-cpt] == -9)
				{
					return true;
				}
				cpt++;

			}

			cpt = 1;
			while(ligneDuRoi-cpt >= 0 && colonneDuRoi+cpt <= 7 )
			{
				if(echiquier[ligneDuRoi-cpt][colonneDuRoi+cpt] != -4 && echiquier[ligneDuRoi-cpt][colonneDuRoi+cpt] != 0  && echiquier[ligneDuRoi-cpt][colonneDuRoi+cpt] != -9)
				{
					break;
				}
				if(echiquier[ligneDuRoi-cpt][colonneDuRoi+cpt] == -4  || echiquier[ligneDuRoi-cpt][colonneDuRoi+cpt] == -9)
				{
					return true;
				}
				cpt++;

			}

			cpt = 1;
			while(ligneDuRoi-cpt >= 0 && colonneDuRoi-cpt >= 0 )
			{
				if(echiquier[ligneDuRoi-cpt][colonneDuRoi-cpt] != -4 && echiquier[ligneDuRoi-cpt][colonneDuRoi-cpt] != 0  && echiquier[ligneDuRoi-cpt][colonneDuRoi-cpt] != -9)
				{
					break;
				}
				if(echiquier[ligneDuRoi-cpt][colonneDuRoi-cpt] == -4  || echiquier[ligneDuRoi-cpt][colonneDuRoi-cpt] == -9)
				{
					return true;
				}
				cpt++;
			}	
		}


		//pour le roi noir
		else if(echiquier[ligneDuRoi][colonneDuRoi] == -8)
		{
			
			//si y'a un pion
			if((ligneDuRoi+1 >= 0 && colonneDuRoi-1 >= 0  && echiquier[ligneDuRoi+1][colonneDuRoi-1] == 1) || (ligneDuRoi+1 >= 0 && colonneDuRoi+1 <= 7  && echiquier[ligneDuRoi+1][colonneDuRoi+1] == 1))
			{
				return true;
			}
				
			//si y'a une tour ou une dame
			
			//à droite du roi
			for(int i = 1; i <= 7-colonneDuRoi; i++)
			{
				if(echiquier[ligneDuRoi][colonneDuRoi+i] != 5 && echiquier[ligneDuRoi][colonneDuRoi+i] != 9 && echiquier[ligneDuRoi][colonneDuRoi+i] != 0)
				{
					break;
				}
				if(echiquier[ligneDuRoi][colonneDuRoi+i] == 5 || echiquier[ligneDuRoi][colonneDuRoi+i] == 9)
				{
					return true;
				}
			}

			//à gauche du roi
			for(int i = 1; i <= colonneDuRoi; i++)
			{
				if(echiquier[ligneDuRoi][colonneDuRoi-i] != 5 && echiquier[ligneDuRoi][colonneDuRoi-i] != 9 && echiquier[ligneDuRoi][colonneDuRoi-i] != 0)
				{
					break;
				}
				if(echiquier[ligneDuRoi][colonneDuRoi-i] == 5 || echiquier[ligneDuRoi][colonneDuRoi-i] == 9)
				{
					return true;
				}
			}

			//en dessous du roi
			for(int i = 1; i <= 7-ligneDuRoi; i++)
			{
				if(echiquier[ligneDuRoi+i][colonneDuRoi] != 5 && echiquier[ligneDuRoi+i][colonneDuRoi] != 9 && echiquier[ligneDuRoi+i][colonneDuRoi] != 0)
				{
					break;
				}
				if(echiquier[ligneDuRoi+i][colonneDuRoi] == 5 || echiquier[ligneDuRoi+i][colonneDuRoi] == 9)
				{
					return true;
				}
			}

			//au dessus du roi
			for(int i = 1; i <= ligneDuRoi; i++)
			{
				if(echiquier[ligneDuRoi-i][colonneDuRoi] != 5 && echiquier[ligneDuRoi-i][colonneDuRoi] != 9 && echiquier[ligneDuRoi-i][colonneDuRoi] != 0)
				{
					break;
				}
				if(echiquier[ligneDuRoi-i][colonneDuRoi] == 5 || echiquier[ligneDuRoi-i][colonneDuRoi] == 9)
				{
					return true;
				}
			}



			//si y'a un cavalier
			if(ligneDuRoi+1 <= 7 && colonneDuRoi+2 <= 7 && echiquier[ligneDuRoi+1][colonneDuRoi+2] == 3)
			{
				return true;
			}
			if(ligneDuRoi-1 >= 0 && colonneDuRoi+2 <= 7 && echiquier[ligneDuRoi-1][colonneDuRoi+2] == 3)
			{
				return true;
			}
			if(ligneDuRoi+1 <= 7 && colonneDuRoi-2 >= 0 && echiquier[ligneDuRoi+1][colonneDuRoi-2] == 3)
			{
				return true;
			}
			if(ligneDuRoi-1 >= 0 && colonneDuRoi-2 >= 0 && echiquier[ligneDuRoi-1][colonneDuRoi-2] == 3)
			{
				return true;
			}
			if(ligneDuRoi+2 <= 7 && colonneDuRoi+1 <= 7 && echiquier[ligneDuRoi+2][colonneDuRoi+1] == 3)
			{
				return true;
			}
			if(ligneDuRoi-2 >= 0 && colonneDuRoi+1 <= 7 && echiquier[ligneDuRoi-2][colonneDuRoi+1] == 3)
			{
				return true;
			}
			if(ligneDuRoi+2 <= 7 && colonneDuRoi-1 >= 0 && echiquier[ligneDuRoi+2][colonneDuRoi-1] == 3)
			{
				return true;
			}
			if(ligneDuRoi-2 >= 0 && colonneDuRoi-1 >= 0 && echiquier[ligneDuRoi-2][colonneDuRoi-1] == 3)
			{
				return true;
			}
			//si y'a un fou ou une dame 
			int cpt = 1;
			while(ligneDuRoi+cpt <= 7 && colonneDuRoi+cpt <= 7 )
			{
				
				if(echiquier[ligneDuRoi+cpt][colonneDuRoi+cpt] != 4 && echiquier[ligneDuRoi+cpt][colonneDuRoi+cpt] != 0 && echiquier[ligneDuRoi+cpt][colonneDuRoi+cpt] != 9 )
				{
					break;
				}
				if(echiquier[ligneDuRoi+cpt][colonneDuRoi+cpt] == 4 || echiquier[ligneDuRoi+cpt][colonneDuRoi+cpt] == 9)
				{
					return true;
				}
				cpt++;
			}

			cpt = 1;
			while(ligneDuRoi+cpt <= 7 && colonneDuRoi-cpt >= 0 )
			{
				if(echiquier[ligneDuRoi+cpt][colonneDuRoi-cpt] != 4 && echiquier[ligneDuRoi+cpt][colonneDuRoi-cpt] != 0  && echiquier[ligneDuRoi+cpt][colonneDuRoi-cpt] != 9)
				{
					break;
				}
				if(echiquier[ligneDuRoi+cpt][colonneDuRoi-cpt] == 4  || echiquier[ligneDuRoi+cpt][colonneDuRoi-cpt] == 9)
				{

					return true;
				}
				cpt++;

			}

			cpt = 1;
			while(ligneDuRoi-cpt >= 0 && colonneDuRoi+cpt <= 7 )
			{
				if(echiquier[ligneDuRoi-cpt][colonneDuRoi+cpt] != 4 && echiquier[ligneDuRoi-cpt][colonneDuRoi+cpt] != 0  && echiquier[ligneDuRoi-cpt][colonneDuRoi+cpt] != 9)
				{
					break;
				}
				if(echiquier[ligneDuRoi-cpt][colonneDuRoi+cpt] == 4  || echiquier[ligneDuRoi-cpt][colonneDuRoi+cpt] == 9)
				{
					return true;
				}
				cpt++;

			}
			cpt = 1;
			while(ligneDuRoi-cpt >= 0 && colonneDuRoi-cpt >= 0 )
			{
				if(echiquier[ligneDuRoi-cpt][colonneDuRoi-cpt] != 4 && echiquier[ligneDuRoi-cpt][colonneDuRoi-cpt] != 0  && echiquier[ligneDuRoi-cpt][colonneDuRoi-cpt] != 9)
				{
					break;
				}
				if(echiquier[ligneDuRoi-cpt][colonneDuRoi-cpt] == 4  || echiquier[ligneDuRoi-cpt][colonneDuRoi-cpt] != 9)
				{
					return true;
				}
				cpt++;
			}
		}
		return false;
	}
}