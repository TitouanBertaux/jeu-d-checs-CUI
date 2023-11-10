package Pieces;



public class Pion
{

	// fonction qui vérifie si le déplacement voulu est possible (case libre pour avancer/ prise pour manger)
	public static boolean estPossible(String pionABouger, String caseDeDestination, int[][] echiquier)
	{
		int colonneDuPion = Character.getNumericValue(pionABouger.charAt(0));
		int ligneDuPion = Character.getNumericValue(pionABouger.charAt(1));

		int ligneDeDestination = Character.getNumericValue(caseDeDestination.charAt(1));
		int colonneDeDestination = Character.getNumericValue(caseDeDestination.charAt(0));


		//vérification des valeurs entrée
		if(colonneDuPion < 0 || ligneDuPion < 0 || colonneDeDestination < 0 || ligneDeDestination < 0 || colonneDuPion > 7 || ligneDuPion > 7 || colonneDeDestination > 7 || ligneDeDestination > 7 )
		{
			return false;
		}

		//si le pion est blanc
		if(echiquier[ligneDuPion][colonneDuPion] == 1)
		{
			//premier cas : pour avancer d'une case
			if(ligneDuPion == ligneDeDestination+1 && colonneDuPion == colonneDeDestination && echiquier[ligneDeDestination][colonneDeDestination] == 0)
			{
				return true;
			}

			//deuxième cas : pour avancer de deux cases
			else if(ligneDuPion == ligneDeDestination+2 && colonneDuPion == colonneDeDestination && echiquier[ligneDeDestination][colonneDeDestination] == 0 && echiquier[ligneDeDestination+1][colonneDeDestination] == 0)
			{
				return true;
			}

			//troisième cas : pour manger à gauche
			else if(ligneDuPion == ligneDeDestination+1 && colonneDuPion == colonneDeDestination+1 && echiquier[ligneDeDestination][colonneDeDestination] < 0)
			{
				return true;
			}

			//quatrième cas : pour manger à droite
			else if(ligneDuPion == ligneDeDestination+1 && colonneDuPion == colonneDeDestination-1 && echiquier[ligneDeDestination][colonneDeDestination] < 0)
			{
				return true;
			}

		}

		//si le pion est noir
		if(echiquier[ligneDuPion][colonneDuPion] == -1)
		{
			//premier cas : pour avancer d'une case
			if(ligneDuPion == ligneDeDestination-1 && colonneDuPion == colonneDeDestination && echiquier[ligneDeDestination][colonneDeDestination] == 0)
			{
				return true;
			}
			
			//deuxième cas : pour avancer de deux cases
			else if(ligneDuPion == ligneDeDestination-2 && colonneDuPion == colonneDeDestination && echiquier[ligneDeDestination][colonneDeDestination] == 0 && echiquier[ligneDeDestination-1][colonneDeDestination] == 0)
			{
				return true;
			}

			//troisème cas : pour manger à gauche
			else if(ligneDuPion == ligneDeDestination-1 && colonneDuPion == colonneDeDestination+1 && echiquier[ligneDeDestination][colonneDeDestination] > 0)
			{
				return true;
			}

			//quatrième cas : pour manger à droite
			else if(ligneDuPion == ligneDeDestination-1 && colonneDuPion == colonneDeDestination-1 && echiquier[ligneDeDestination][colonneDeDestination] > 0)
			{
				return true;
			}
		}


		return false;
	}
}