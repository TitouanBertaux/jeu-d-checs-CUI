package Pieces;


public class Tour
{
	public static boolean tBH = false;
	public static boolean tBA = false;
	public static boolean tNH = false;
	public static boolean tNA = false;

	// fonction qui vérifie si le déplacement voulu est possible
	public static boolean estPossible(String tourABouger, String caseDeDestination, int[][] echiquier)
	{
		int colonneDeLaTour = Character.getNumericValue(tourABouger.charAt(0));
		int ligneDeLaTour = Character.getNumericValue(tourABouger.charAt(1));

		int ligneDeDestination = Character.getNumericValue(caseDeDestination.charAt(1));
		int colonneDeDestination = Character.getNumericValue(caseDeDestination.charAt(0));
		int piece = echiquier[ligneDeLaTour][colonneDeLaTour];


		//vérification des valeurs entrée
		if(colonneDeLaTour < 0 || ligneDeLaTour < 0 || colonneDeDestination < 0 || ligneDeDestination < 0 || colonneDeLaTour > 7 || ligneDeLaTour > 7 || colonneDeDestination > 7 || ligneDeDestination > 7 )
		{
			return false;
		}

		//si la tour est blanche
		if(piece == 5 || piece == -5)
		{
			//la tour se déplace sur la colonne
			if(colonneDeLaTour == colonneDeDestination)
			{
				//si la tour doit monter
				if(ligneDeLaTour > ligneDeDestination)
				{
					while(ligneDeLaTour > ligneDeDestination+1)
					{
						if(echiquier[ligneDeLaTour-1][colonneDeLaTour] != 0)
						{
							return false;
						}
						ligneDeLaTour--;
					}
					if(echiquier[ligneDeLaTour-1][colonneDeLaTour] == echiquier[ligneDeDestination][colonneDeDestination] )
					{
						if(piece == 5 && echiquier[ligneDeDestination][colonneDeDestination] <= 0)
						{
							return true;
						}
						else if(piece == -5 && echiquier[ligneDeDestination][colonneDeDestination] >= 0 )
						{
							return true;
						}
						else
						{
							return false;
						}
					}
				}

				//si la tour doit descendre
				else if(ligneDeLaTour < ligneDeDestination)
				{
					while(ligneDeLaTour < ligneDeDestination-1)
					{
						if(echiquier[ligneDeLaTour+1][colonneDeLaTour] != 0)
						{
							return false;
						}
						ligneDeLaTour++;
					}
					if(echiquier[ligneDeLaTour+1][colonneDeLaTour] == echiquier[ligneDeDestination][colonneDeDestination])
					{
						if(piece == 5 && echiquier[ligneDeDestination][colonneDeDestination] <= 0)
						{
							return true;
						}
						else if(piece == -5 && echiquier[ligneDeDestination][colonneDeDestination] >= 0)
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

			//la tour se déplace sur la ligne
			if(ligneDeLaTour == ligneDeDestination)
			{
				//si la tour doit aller a gauche
				if(colonneDeLaTour > colonneDeDestination)
				{
					while(colonneDeLaTour > colonneDeDestination+1)
					{
						if(echiquier[ligneDeLaTour][colonneDeLaTour-1] != 0)
						{
							return false;
						}
						colonneDeLaTour--;
 					}
 					if(echiquier[ligneDeLaTour][colonneDeLaTour-1] == echiquier[ligneDeDestination][colonneDeDestination])
					{
						if(piece == 5 && echiquier[ligneDeDestination][colonneDeDestination] <= 0)
						{
							return true;
						}
						if(piece == -5 && echiquier[ligneDeDestination][colonneDeDestination] >= 0)
						{
							return true;
						}
						else
						{
							return false;
						}
					}
				}

				//si la tour doit aller à droite
				else if(colonneDeLaTour < colonneDeDestination)
				{
					while(colonneDeLaTour < colonneDeDestination-1)
					{
						if(echiquier[ligneDeLaTour][colonneDeLaTour+1] != 0)
						{
							System.out.println("test");

							return false;
						}
						colonneDeLaTour++;
 					}
 					if(echiquier[ligneDeLaTour][colonneDeLaTour+1] == echiquier[ligneDeDestination][colonneDeDestination])
					{
						if(piece == 5 && echiquier[ligneDeDestination][colonneDeDestination] <= 0)
						{
							return true;
						}
						else if(piece == -5 && echiquier[ligneDeDestination][colonneDeDestination] >= 0)
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

			
		}

		return false;

	}
}