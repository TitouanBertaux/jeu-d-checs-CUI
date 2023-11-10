package Pieces;

public class Dame
{
	// fonction qui vérifie si le déplacement voulu est possible
	public static boolean estPossible(String dameABouger, String caseDeDestination, int[][] echiquier)
	{
		int colonneDeLaDame = Character.getNumericValue(dameABouger.charAt(0));
		int ligneDeLaDame = Character.getNumericValue(dameABouger.charAt(1));

		int ligneDeDestination = Character.getNumericValue(caseDeDestination.charAt(1));
		int colonneDeDestination = Character.getNumericValue(caseDeDestination.charAt(0));
		int piece = echiquier[ligneDeLaDame][colonneDeLaDame];


		//vérification des valeurs entrée
		if(colonneDeLaDame < 0 || ligneDeDestination < 0 || colonneDeDestination < 0 || ligneDeDestination < 0 || colonneDeLaDame > 7 || ligneDeLaDame > 7 || colonneDeDestination > 7 || ligneDeDestination > 7 )
		{
			return false;
		}

		//pour les déplacement horizontaux et verticaux
		if(piece == 9 || piece == -9)
		{
			//la dame se déplace sur la colonne
			if(colonneDeLaDame == colonneDeDestination)
			{
				//si la dame doit monter
				if(ligneDeLaDame > ligneDeDestination)
				{
					while(ligneDeLaDame > ligneDeDestination+1)
					{
						if(echiquier[ligneDeLaDame-1][colonneDeLaDame] != 0)
						{
							return false;
						}
						ligneDeLaDame--;
					}
					if(echiquier[ligneDeLaDame-1][colonneDeLaDame] == echiquier[ligneDeDestination][colonneDeDestination] )
					{
						if(piece == 9 && echiquier[ligneDeDestination][colonneDeDestination] <= 0)
						{
							return true;
						}
						else if(piece == -9 && echiquier[ligneDeDestination][colonneDeDestination] >= 0 )
						{
							return true;
						}
						else
						{
							return false;
						}
					}
				}

				//si la dame doit descendre
				else if(ligneDeLaDame < ligneDeDestination)
				{
					while(ligneDeLaDame < ligneDeDestination-1)
					{
						if(echiquier[ligneDeLaDame+1][colonneDeLaDame] != 0)
						{
							return false;
						}
						ligneDeLaDame++;
					}
					if(echiquier[ligneDeLaDame+1][colonneDeLaDame] == echiquier[ligneDeDestination][colonneDeDestination])
					{
						if(piece == 9 && echiquier[ligneDeDestination][colonneDeDestination] <= 0)
						{
							return true;
						}
						else if(piece == -9 && echiquier[ligneDeDestination][colonneDeDestination] >= 0)
						{
							return true;
						}
						else
						{
							return false;
						}
					}
				}
				return true;
			}

			//la dame se déplace sur la ligne
			if(ligneDeLaDame == ligneDeDestination)
			{
				
				//si la tour doit aller a gauche
				if(colonneDeLaDame > colonneDeDestination)
				{
					while(colonneDeLaDame > colonneDeDestination+1)
					{
						if(echiquier[ligneDeLaDame][colonneDeLaDame-1] != 0)
						{
							return false;
						}
						colonneDeLaDame--;
						}
						if(echiquier[ligneDeLaDame][colonneDeLaDame-1] == echiquier[ligneDeDestination][colonneDeDestination])
					{
						if(piece == 9 && echiquier[ligneDeDestination][colonneDeDestination] <= 0)
						{
							return true;
						}
						if(piece == -9 && echiquier[ligneDeDestination][colonneDeDestination] >= 0)
						{
							return true;
						}
						else
						{
							return false;
						}
					}
				}

				//si la dame doit aller à droite
				else if(colonneDeLaDame < colonneDeDestination)
				{
					while(colonneDeLaDame < colonneDeDestination-1)
					{
						if(echiquier[ligneDeLaDame][colonneDeLaDame+1] != 0)
						{
							return false;
						}
						colonneDeLaDame++;
						}
						if(echiquier[ligneDeLaDame][colonneDeLaDame+1] == echiquier[ligneDeDestination][colonneDeDestination])
					{
						if(piece == 9 && echiquier[ligneDeDestination][colonneDeDestination] <= 0)
						{
							return true;
						}
						else if(piece == -9 && echiquier[ligneDeDestination][colonneDeDestination] >= 0)
						{
							return true;
						}
						else
						{
							return false;
						}
					}
				}
			}

			int cpt = 1;
			boolean bOk = false;


			while(ligneDeLaDame+cpt < ligneDeDestination && colonneDeLaDame+cpt < colonneDeDestination )
			{
				if(echiquier[ligneDeLaDame+cpt][colonneDeLaDame+cpt] != 0)
				{
					return false;
				}
				bOk = true;
				cpt++;
			}

			while(ligneDeLaDame+cpt < ligneDeDestination && colonneDeLaDame-cpt > colonneDeDestination )
			{
				if(echiquier[ligneDeLaDame+cpt][colonneDeLaDame-cpt] != 0)
				{
					return false;
				}
				bOk = true;
				cpt++;

			}
			while(ligneDeLaDame-cpt > ligneDeDestination && colonneDeLaDame+cpt < colonneDeDestination )
			{
				if(echiquier[ligneDeLaDame-cpt][colonneDeLaDame+cpt] != 0)
				{
					return false;
				}
				bOk = true;
				cpt++;

			}
			
			while(ligneDeLaDame-cpt > ligneDeDestination && colonneDeLaDame-cpt > colonneDeDestination )
			{
				if(echiquier[ligneDeLaDame-cpt][colonneDeLaDame-cpt] != 0)
				{
					return false;
				}
				bOk = true;
				cpt++;

			}
			if(ligneDeLaDame+1 == ligneDeDestination && colonneDeLaDame+1 == colonneDeDestination)
			{
				bOk = true;
			}
			if(ligneDeLaDame+1 == ligneDeDestination && colonneDeLaDame-1 == colonneDeDestination)
			{
				bOk = true;
			}
			if(ligneDeLaDame-1 == ligneDeDestination && colonneDeLaDame+1 == colonneDeDestination)
			{
				bOk = true;
			}
			if(ligneDeLaDame-1 == ligneDeDestination && colonneDeLaDame-1 == colonneDeDestination)
			{
				bOk = true;
			}

			if(bOk)
			{

				if(echiquier[ligneDeLaDame][colonneDeLaDame] == 9)
				{
					if(echiquier[ligneDeDestination][colonneDeDestination] <= 0)
					{
						return true;
					}
				}
				else if(echiquier[ligneDeLaDame][colonneDeLaDame] == -9)
				{
					if(echiquier[ligneDeDestination][colonneDeDestination] >= 0)
					{
						return true;
					}
				}
				
			}		

				
		}
		return false;
		

		
	}
}
