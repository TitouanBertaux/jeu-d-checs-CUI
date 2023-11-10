import Pieces.*;


public class JouerCoups
{
	public static String DemanderCaseDepart(int[][] echiquier) // à rentrer sous forme de coordonnées échiquéennes
	{
		String coup;

		System.out.print("Joueur " + Lancement.joueur + " quelle est la case de la pièce à bouger jjjjjj: ");
		coup = GestionUtilisateur.lireString();

		int colonneDeDepart = Character.getNumericValue(GestionUtilisateur.Correspondance(coup).charAt(0));
		int ligneDeDepart = Character.getNumericValue(GestionUtilisateur.Correspondance(coup).charAt(1));


		if(coup.length() != 2) {GererCommandes(coup);}


		if(coup.charAt(0) > 'h' || coup.charAt(0) < 'a' || (int)coup.charAt(1) > (int)'8' || (int)coup.charAt(1) < (int)'1')
		{
			System.out.println("Ces coordonnées n'existent pas");
			return DemanderCaseDepart(echiquier);
		}

		if(Lancement.joueur == 1 && echiquier[ligneDeDepart][colonneDeDepart] <= 0)
		{
			return DemanderCaseDepart(echiquier);
		}
		if(Lancement.joueur == 2 && echiquier[ligneDeDepart][colonneDeDepart] >= 0)
		{
			return DemanderCaseDepart(echiquier);
		}
		return coup;
	}

	public static String DemanderCaseArrivee() // à rentrer sous forme de coordonnées échiquéennes
	{
		String coup;
		System.out.print("Joueur " + Lancement.joueur + " quelle est la case de destination : ");
		coup = GestionUtilisateur.lireString();

		if(coup.length() != 2) {GererCommandes(coup);}


		if(coup.charAt(0) > 'h' || coup.charAt(0) < 'a' || (int)coup.charAt(1) > (int)'8' || (int)coup.charAt(1) < (int)'1')
		{
			System.out.println("Ces coordonnées n'existent pas");
			return DemanderCaseArrivee();
		}
		

		return coup;
	}

	//permet d'exécuter les différentes commandes possibles si besoin
	public static void GererCommandes(String cmd)
	{
		switch (cmd) {
			case "abandon":
				Commandes.Abandon(Lancement.joueur);
				break;
			case "nulle":
				Commandes.Nulle(Lancement.joueur);
				break;
		}
	}


	public static boolean VerifierCoup(String caseDepart, String caseDestination, int[][] echiquier)
	{
		int colonneDeDepart = Character.getNumericValue(caseDepart.charAt(0));
		int ligneDeDepart = Character.getNumericValue(caseDepart.charAt(1));
		int piece = echiquier[ligneDeDepart][colonneDeDepart];

		switch (piece) {
			case 1:
				return Pion.estPossible(caseDepart, caseDestination, echiquier);
			case 3:
				return Cavalier.estPossible(caseDepart, caseDestination, echiquier);
			case 4:
				return Fou.estPossible(caseDepart, caseDestination, echiquier);
			case 5:
				if(Tour.estPossible(caseDepart, caseDestination, echiquier))
				{
					if(ligneDeDepart == 7 && colonneDeDepart == 0)
					{
						Tour.tBA = true;
					}
					else if(ligneDeDepart == 7 && colonneDeDepart == 7)
					{
						Tour.tBH = true;
					}
				}
				return Tour.estPossible(caseDepart, caseDestination, echiquier);
			case 8:
				return Roi.estPossible(caseDepart, caseDestination, echiquier);
			case 9:
				return Dame.estPossible(caseDepart, caseDestination, echiquier);
			
			case -1:
				return Pion.estPossible(caseDepart, caseDestination, echiquier);
			case -3:
				return Cavalier.estPossible(caseDepart, caseDestination, echiquier);
			case -4:
				return Fou.estPossible(caseDepart, caseDestination, echiquier);
			case -5:
				if(Tour.estPossible(caseDepart, caseDestination, echiquier))
				{
					if(ligneDeDepart == 0 && colonneDeDepart == 0)
					{
						Tour.tNA = true;
					}
					else if(ligneDeDepart == 0 && colonneDeDepart == 7)
					{
						Tour.tNH = true;
					}
				}
				return Tour.estPossible(caseDepart, caseDestination, echiquier);
			case -8:
				return Roi.estPossible(caseDepart, caseDestination, echiquier);
			case -9:
				return Dame.estPossible(caseDepart, caseDestination, echiquier);
		}

		return false;

		
	}


	public static void ExecutionCoup(int[][] echiquier)
	{
		String caseDepartSauvPartie = DemanderCaseDepart(echiquier);
		String caseArriveeSauvPartie = DemanderCaseArrivee();

		String demanderCoupDepart = GestionUtilisateur.Correspondance(caseDepartSauvPartie);
		String demanderCoupArrive = GestionUtilisateur.Correspondance(caseArriveeSauvPartie);

		int colonneDeDepart = Character.getNumericValue(demanderCoupDepart.charAt(0));
		int ligneDeDepart = Character.getNumericValue(demanderCoupDepart.charAt(1));

		int ligneDeDestination = Character.getNumericValue(demanderCoupArrive.charAt(1));
		int colonneDeDestination = Character.getNumericValue(demanderCoupArrive.charAt(0));

		if(VerifierCoup(demanderCoupDepart, demanderCoupArrive, echiquier))
		{
			System.out.println("c'est au tour de : " + Lancement.joueur);
			if(Roi.estEchec(Lancement.joueur, ImaginePosition(demanderCoupDepart, demanderCoupArrive, echiquier)))
			{
				System.out.println("coup impossible, vous etes échecs !");
				ExecutionCoup(echiquier);
			}
			else
			{
				if((echiquier[ligneDeDepart][colonneDeDepart] == 8 || echiquier[ligneDeDepart][colonneDeDepart] == -8) && ligneDeDepart == ligneDeDestination && colonneDeDepart+2 == colonneDeDestination)
				{
					echiquier[ligneDeDestination][colonneDeDestination] = echiquier[ligneDeDepart][colonneDeDepart];
					echiquier[ligneDeDepart][colonneDeDepart] = 0;
					echiquier[ligneDeDepart][colonneDeDepart+1] = echiquier[ligneDeDestination][colonneDeDestination+1];
					echiquier[ligneDeDestination][colonneDeDestination+1] = 0;
				}
				else if((echiquier[ligneDeDepart][colonneDeDepart] == 8 || echiquier[ligneDeDepart][colonneDeDepart] == -8) && ligneDeDepart == ligneDeDestination && colonneDeDepart-2 == colonneDeDestination)
				{
					echiquier[ligneDeDestination][colonneDeDestination] = echiquier[ligneDeDepart][colonneDeDepart];
					echiquier[ligneDeDepart][colonneDeDepart] = 0;
					echiquier[ligneDeDepart][colonneDeDepart-1] = echiquier[ligneDeDestination][colonneDeDestination-2];
					echiquier[ligneDeDestination][colonneDeDestination-2] = 0;
				}
				else
				{
					echiquier[ligneDeDestination][colonneDeDestination] = echiquier[ligneDeDepart][colonneDeDepart];
					echiquier[ligneDeDepart][colonneDeDepart] = 0;
				}
					switch (Lancement.joueur) {
						case 1:
							Lancement.joueur = 2;
							break;
						case 2:
							Lancement.joueur = 1;
					}
					Lancement.sauvegardePartie.AjouterCoup(ConversionNotation.Conversion(caseDepartSauvPartie, caseArriveeSauvPartie, echiquier));
			}
		}
		else
		{
			ExecutionCoup(echiquier);
		}

	}


	public static int[][] ImaginePosition(String caseDepart, String caseArrivee, int[][] echiquier)
	{
		int[][] positionImaginaire = new int[8][8];
		for(int i = 0; i < echiquier.length; i++)
		{
			for(int j = 0; j < echiquier.length; j++)
			{
				positionImaginaire[i][j] = echiquier[i][j];
			}
		}

		int colonneDeDepart = Character.getNumericValue(caseDepart.charAt(0));
		int ligneDeDepart = Character.getNumericValue(caseDepart.charAt(1));

		int ligneDeDestination = Character.getNumericValue(caseArrivee.charAt(1));
		int colonneDeDestination = Character.getNumericValue(caseArrivee.charAt(0));
		
		positionImaginaire[ligneDeDestination][colonneDeDestination] = positionImaginaire[ligneDeDepart][colonneDeDepart];
		positionImaginaire[ligneDeDepart][colonneDeDepart] = 0;

		return positionImaginaire;
	}
}