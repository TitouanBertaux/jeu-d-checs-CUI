

public class Commandes
{
	public static void Abandon(int joueur)
	{
		System.out.println("abandon du joueur " + joueur);
		if(joueur == 1) {System.out.println("victoire du joueur 2");}
		else { System.out.println("victoire du joueur 1");}

		System.exit(0);
	}

	public static void Nulle(int joueur)
	{
		String reponse;
		System.out.println("le joueur " + joueur + " propose le match nul");
		if(joueur == 1) {System.out.println("Joueur 2, y ou n ?");}
		else { System.out.println("Joueur 1, y ou n ?");}

		reponse = GestionUtilisateur.lireString();

		while(!(reponse.equals("y") || reponse.equals("n")))
		{
			System.out.println("réponse impossible, recommencez, y ou n ?");
			reponse = GestionUtilisateur.lireString();
		}

		if(reponse.equals("y"))
		{
			System.out.println("partie nulle");
			System.exit(0);
		}
	}

}