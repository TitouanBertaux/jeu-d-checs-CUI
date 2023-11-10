package Pieces;


public class Fou
{
	// fonction qui vérifie si le déplacement voulu est possible
	public static boolean estPossible(String fouABouger, String caseDeDestination, int[][] echiquier)
	{
		int colonneDuFou = Character.getNumericValue(fouABouger.charAt(0));
		int ligneDuFou = Character.getNumericValue(fouABouger.charAt(1));

		int ligneDeDestination = Character.getNumericValue(caseDeDestination.charAt(1));
		int colonneDeDestination = Character.getNumericValue(caseDeDestination.charAt(0));

		int cpt = 1;
		boolean bOk = false;


		//vérification des valeurs entrée
		if(colonneDuFou < 0 || ligneDuFou < 0 || colonneDeDestination < 0 || ligneDeDestination < 0 || colonneDuFou > 7 || ligneDuFou > 7 || colonneDeDestination > 7 || ligneDeDestination > 7 )
		{
			return false;
		}

	
		while(ligneDuFou+cpt < ligneDeDestination && colonneDuFou+cpt < colonneDeDestination )
		{
			if(echiquier[ligneDuFou+cpt][colonneDuFou+cpt] != 0)
			{
				return false;
			}
			bOk = true;
			cpt++;

		}
		while(ligneDuFou+cpt < ligneDeDestination && colonneDuFou-cpt > colonneDeDestination )
		{
			if(echiquier[ligneDuFou+cpt][colonneDuFou-cpt] != 0)
			{
				return false;
			}
			bOk = true;
			cpt++;

		}
		while(ligneDuFou-cpt > ligneDeDestination && colonneDuFou+cpt < colonneDeDestination )
		{
			if(echiquier[ligneDuFou-cpt][colonneDuFou+cpt] != 0)
			{
				return false;
			}
			bOk = true;
			cpt++;

		}
		while(ligneDuFou-cpt > ligneDeDestination && colonneDuFou-cpt > colonneDeDestination )
		{
			if(echiquier[ligneDuFou-cpt][colonneDuFou-cpt] != 0)
			{
				return false;
			}
			bOk = true;
			cpt++;

		}

		if(ligneDuFou+1 == ligneDeDestination && colonneDuFou+1 == colonneDeDestination)
		{
			bOk = true;
		}
		if(ligneDuFou+1 == ligneDeDestination && colonneDuFou-1 == colonneDeDestination)
		{
			bOk = true;
		}
		if(ligneDuFou-1 == ligneDeDestination && colonneDuFou+1 == colonneDeDestination)
		{
			bOk = true;
		}
		if(ligneDuFou-1 == ligneDeDestination && colonneDuFou-1 == colonneDeDestination)
		{
			bOk = true;
		}

		if(bOk)
		{
			if(echiquier[ligneDuFou][colonneDuFou] == 4)
			{
				if(echiquier[ligneDeDestination][colonneDeDestination] <= 0)
				{
					return true;
				}
			}
			else if(echiquier[ligneDuFou][colonneDuFou] == -4)
			{
				if(echiquier[ligneDeDestination][colonneDeDestination] >= 0)
				{
					return true;
				}
			}
			
		}			
	


		


		


		return false;
	}
}