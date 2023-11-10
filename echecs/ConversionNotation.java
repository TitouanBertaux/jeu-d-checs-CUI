

public class ConversionNotation
{
	public static String Conversion(String caseDepart, String caseArrivee, int[][] echiquier)
	{
		
		String coupDepart = GestionUtilisateur.Correspondance(caseDepart);
		String coupArrive = GestionUtilisateur.Correspondance(caseArrivee);

		int colonneDarrivee = Character.getNumericValue(coupArrive.charAt(0));
		int ligneDarrivee = Character.getNumericValue(coupArrive.charAt(1));


		switch (echiquier[ligneDarrivee][colonneDarrivee]) {
			case 1:
				if(coupDepart.charAt(0) == coupArrive.charAt(0))
					return caseArrivee;	
				else
				{
					return caseDepart.charAt(0) + "x" + caseArrivee;
				}
			case 3:
				return "N"+caseDepart.charAt(0)+caseArrivee;	
			case 4:
				return "B"+caseArrivee;	
			case 5:
				return "R"+caseDepart.charAt(0)+caseArrivee;	
			case 8:
				return "K"+caseArrivee;	
			case 9:
				return "Q"+caseArrivee;	

			case -1:
				if(coupDepart.charAt(0) == coupArrive.charAt(0))
					return caseArrivee;	
				else
				{
					return caseDepart.charAt(0) + "x" + caseArrivee;
				}			
			case -3:
				return "N"+caseDepart.charAt(0)+caseArrivee;	
			case -4:
				return "B"+caseArrivee;	
			case -5:
				return "R"+caseDepart.charAt(0)+caseArrivee;	
			case -8:
				return "K"+caseArrivee;	
			case -9:
				return "Q"+caseArrivee;
		
		}

		return "erreur";
	}
}