import Pieces.*;

public class Lancement
{
	public static int joueur = 1;
	public static SauvegardePartie sauvegardePartie = new SauvegardePartie();

	public static void main(String[] args) 
	{
		/*création de l'échiquer*/
		int[][] echiquier = {
			{-5, -3, -4, -9, -8, -4, -3, -5},
			{-1, -1, -1, -1, -1, -1, -1, -1},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 1, 1},
			{5, 3, 4, 9, 8, 4, 3, 5}
		};

		while(true)
		{
			GestionUtilisateur.AfficheEchiquierJoli(echiquier);
			JouerCoups.ExecutionCoup(echiquier);
		}
		
		
	}

}