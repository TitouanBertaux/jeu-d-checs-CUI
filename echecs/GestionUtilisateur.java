import Pieces.*;
import java.io.*;


public class GestionUtilisateur
{

	//fonction d'affichage de l'echiquier
	public static void AfficheEchiquier(int[][] echiquier)
	{
		for(int i = 0; i<10; i++){System.out.println("\n\n");}
		//affichage des lettres 
		System.out.print("     ");
		for(int j = 0; j < echiquier.length; j++)
		{
			System.out.print((char)('a'+j));
		}
		System.out.println("\n");
		
		for(int i = 0; i < echiquier.length; i++)
		{
			System.out.print(8-i + "   ");
			for(int j = 0; j < echiquier.length; j++)
			{
				if(echiquier[i][j] < 0)
				{
					System.out.print(echiquier[i][j]);
				}
				else
				{
					System.out.print(" " + echiquier[i][j]);
				}
			}
			System.out.print("\n");
		}
	}


	public static void AfficheEchiquierJoli(int[][] echiquier)
	{
		for(int i = 0; i<10; i++){System.out.println("\n\n");}
		//affichage des lettres 
		System.out.print("       ");
		for(int j = 0; j < echiquier.length; j++)
		{
			System.out.print((char)('a'+j) + "   ");
		}
		System.out.println("\n");
		
		for(int i = 0; i < echiquier.length; i++)
		{
			System.out.println("     *---*---*---*---*---*---*---*---*");
			System.out.print("  " + (8-i) + "  ");
			for(int n = 0; n < echiquier.length; n++)
			{
				System.out.print("|");
				switch (echiquier[i][n]) {
					case 0:
						System.out.print("   ");
						break;
					case 1:
						System.out.print(" p ");
						break;
					case 3:
						System.out.print(" C ");
						break;
					case 4:
						System.out.print(" F ");
						break;
					case 5:
						System.out.print(" T ");
						break;
					case 8:
						System.out.print(" R ");
						break;
					case 9:
						System.out.print(" D ");
						break;
					case -1:
						System.out.print(" pN");
						break;
					case -3:
						System.out.print(" CN");
						break;
					case -4:
						System.out.print(" FN");
						break;
					case -5:
						System.out.print(" TN");
						break;
					case -8:
						System.out.print(" RN");
						break;
					case -9:
						System.out.print(" DN");
						break;
				}
			}
			System.out.println("|");

		}
		System.out.println("     *---*---*---*---*---*---*---*---*");

	}


	public static String DemanderCoupOrigine(int joueur)
	{
		String coup;
		System.out.println("joueur" + joueur + " quel est votre coup ? ");
		coup = lireString();
		return coup;
	}


	public static String DemanderCaseDestination(int joueur)
	{
		String coup;
		System.out.println("joueur" + joueur + " sur quel case voulez vous placer cette piece ? ");
		coup = lireString();
		return coup;
	}


	//transforme une coordonnés de type "a8" au formal "07" où le 1er nombre est la colonne et le second nombre la ligne 
	public static String Correspondance(String coordonnee)
	{
		String resultat;

		char[] coordonneePossibles = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

		for(int i = 0; i < coordonneePossibles.length; i++)
		{
			if(coordonneePossibles[i] == coordonnee.charAt(0))
			{
				resultat = i + "";
				resultat += 8-Character.getNumericValue(coordonnee.charAt(1)) ;
				return resultat;
			}
		}
		return "";
	}



	public static String lireString() 
	{
		byte b = -1;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str = new String("");
		while (b == -1) 
		{
		  try {
			str = bufferedReader.readLine();
			b = 0;
		  } catch (IOException iOException) {
			System.out.println("erreur : saisissez une chaine");
		  } 
		} 
		return str;
	  }
}