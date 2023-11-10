package Pieces;


public class Cavalier
{
	// fonction qui vérifie si le déplacement voulu est possible
	public static boolean estPossible(String cavalierABouger, String caseDeDestination, int[][] echiquier)
	{
		int colonneDuCavalier = Character.getNumericValue(cavalierABouger.charAt(0));
		int ligneDuCavalier = Character.getNumericValue(cavalierABouger.charAt(1));

		int ligneDeDestination = Character.getNumericValue(caseDeDestination.charAt(1));
		int colonneDeDestination = Character.getNumericValue(caseDeDestination.charAt(0));

		boolean bOk = false;

		//vérification des valeurs entrée
		if(colonneDuCavalier < 0 || ligneDuCavalier < 0 || colonneDeDestination < 0 || ligneDeDestination < 0 || colonneDuCavalier > 7 || ligneDuCavalier > 7 || colonneDeDestination > 7 || ligneDeDestination > 7 )
		{
			return false;
		}

		if(colonneDuCavalier+1 == colonneDeDestination && ligneDuCavalier+2 == ligneDeDestination)
		{
			bOk = true;
		}
		if(colonneDuCavalier-1 == colonneDeDestination && ligneDuCavalier+2 == ligneDeDestination)
		{
			bOk = true;
		}
		if(colonneDuCavalier+2 == colonneDeDestination && ligneDuCavalier+1 == ligneDeDestination)
		{
			bOk = true;
		}
		if(colonneDuCavalier-2 == colonneDeDestination && ligneDuCavalier+1 == ligneDeDestination)
		{
			bOk = true;
		}
		if(colonneDuCavalier+1 == colonneDeDestination && ligneDuCavalier-2 == ligneDeDestination)
		{
			bOk = true;
		}
		if(colonneDuCavalier-1 == colonneDeDestination && ligneDuCavalier-2 == ligneDeDestination)
		{
			bOk = true;
		}
		if(colonneDuCavalier+2 == colonneDeDestination && ligneDuCavalier-1 == ligneDeDestination)
		{
			bOk = true;
		}
		if(colonneDuCavalier-2 == colonneDeDestination && ligneDuCavalier-1 == ligneDeDestination)
		{
			bOk = true;
		}


		if(bOk)
		{
			switch (echiquier[ligneDuCavalier][colonneDuCavalier]) 
			{
				case 3:
					if(echiquier[ligneDeDestination][colonneDeDestination] <= 0 )
					{
						return true;
					}
					break;

				case -3:
					if(echiquier[ligneDeDestination][colonneDeDestination] >=0)
					{
						return true;
					}
					break;
			
			}
		}
		


		return false;
	}
}