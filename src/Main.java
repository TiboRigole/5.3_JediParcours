import java.util.Scanner;


//https://stackoverflow.com/questions/15681885/bellman-ford-algorithm-in-java
//https://www.geeksforgeeks.org/dynamic-programming-set-23-bellman-ford-algorithm/
//https://gist.github.com/nodirt/4b780f5d0bc4e0fe1b8b

//Bellman ford algoritme
//dit algoritme heeft als objecten de pijlen van A naar B
//dus niet zoals in keigraaf, dat elke node een object is

public class Main {

    public static void main(String[] args) {
      //gebruik maken van Bellman Ford Algoritme

        Scanner sc =new Scanner(System.in);

        //inlezen van de gegevens
        int aantalTestGevallen = Integer.parseInt(sc.nextLine());

        //voor ieder testgeval
        for(int testGevalId = 0; testGevalId<aantalTestGevallen ; testGevalId++){

            String lijn[] = sc.nextLine().split(" ");

            int aantalKnoopPunten = Integer.parseInt(lijn[0]);
            int aantalVerbindingen = Integer.parseInt(lijn[1]);

            //aanmaken van de graaf
            JediParcours jediParcours = new JediParcours(aantalKnoopPunten, aantalVerbindingen);

            //inlezen van de knooppunten


            int verbindingBegin = 0;
            int verbindingEind = 0;
            int strafPunten = 0;

            //de knooppunten toevoegen
            for(int verbindingId=0 ; verbindingId<aantalVerbindingen; verbindingId++){

                lijn = sc.nextLine().split(" ");

                verbindingBegin = Integer.parseInt(lijn[0]);
                verbindingEind = Integer.parseInt(lijn[1]);
                strafPunten = Integer.parseInt(lijn[2]);

                jediParcours.voegEdgeToe(new Edge(verbindingBegin, verbindingEind, strafPunten));


            }//einde van de input

            String kortstepad = jediParcours.bellmanFord();
            System.out.println(kortstepad);











        }//einde van 1 testgeval

    }
}

