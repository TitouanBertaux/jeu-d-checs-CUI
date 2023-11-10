import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SauvegardePartie
{
	private String joueur1;
	private String joueur2;
	private String nomPartie;
	private int nbCoup;


	public SauvegardePartie()
	{

		System.out.println("qui est le joueur 1 : ");
		this.joueur1 = GestionUtilisateur.lireString();
		System.out.println("qui est le joueur 2 : ");
		this.joueur2 = GestionUtilisateur.lireString();
		this.nbCoup = 1;

		int cpt = 1;
		this.nomPartie = joueur1 + "_" + joueur2 + "_partie" + cpt + ".pgn";


		try {
			File file = new File("Archives_parties/" + this.nomPartie);
			if (file.createNewFile()) 
			{
				System.out.println("Partie créée avec le nom : " + file.getName());
			}
			else {
				while(!file.createNewFile())
				{
					cpt++;
					this.nomPartie = joueur1 + "_" + joueur2 + "_partie" + cpt + ".pgn";
					file = new File("Archives_parties/" + this.nomPartie);
				}
				System.out.println("Partie créée avec le nom : " + file.getName());

			}
			Initaliser();

		} catch (IOException e) {
			System.out.println("erreur, partie non créée");
			e.printStackTrace();
		}
	}

	public void AjouterCoup(String coup) {
		try {
		  BufferedWriter writer = new BufferedWriter(new FileWriter("Archives_parties/"+this.nomPartie, true));
		  if(Lancement.joueur == 2)
		  {
			writer.write(this.nbCoup + ". " + coup + " ");
			writer.close();
		  }
		  else if(Lancement.joueur == 1)
		  {
			writer.write(coup + " ");
			this.nbCoup++;
			writer.close();
		  }

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void Initaliser()
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Archives_parties/"+this.nomPartie, true));
			
			writer.write("[Event \"Live Chess\"]\n");
			writer.write("[Site \"Computer\"]\n");
			writer.write("[Date \"2023.06.02\"]\n");
			writer.write("[Round \"?\"]\n");
			writer.write("[White \"" + this.joueur1 + "\"]\n");
			writer.write("[Black \"" + this.joueur2 + "\"]\n");


			writer.write("\n");
			writer.close();
			
  
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}