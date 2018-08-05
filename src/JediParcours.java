import java.util.LinkedList;

public class JediParcours {

    //attributen
    int aantalKnoopPunten;
    int aantalEdges;
    LinkedList<Edge> edges;


    //constuctoren
    public JediParcours(int aantaKnoopPunten, int aantalEdges) {

        this.aantalKnoopPunten = aantaKnoopPunten;
        this.aantalEdges = aantalEdges;
        edges = new LinkedList<Edge>(); //sneller aangezien we telkens de gehele lijst doorlopen
    }


    //getters en setters
    public void voegEdgeToe(Edge e) {
        edges.add(e);
    }


    public String bellmanFord(){

        Integer[] afstanden = new Integer[aantalKnoopPunten];

        for(int i=0; i<aantalKnoopPunten; i++){
            afstanden[i] = Integer.MAX_VALUE;
        }
        afstanden[0] = 0;

        //stap 2 overloop aantalKnoopPunten -1 keer
        //een kortste pad, kan nooit 2x hetzelfde punt doorlopen
        for( int i=1; i<aantalKnoopPunten; i++){

            for(int j=0; j<aantalEdges; j++){

                int van = edges.get(j).van();
                int naar =edges.get(j).naar();
                int gewicht = edges.get(j).gewicht();

                if (afstanden[van-1] != Integer.MAX_VALUE &&
                        afstanden[van-1]+gewicht < afstanden[naar-1] ){

                    afstanden[naar-1] = afstanden[van-1]+gewicht;

                }



            }

        }

        //stap 3 , check voor negatieve gewicht cycles,
        //stap 2 garandeert niet dat er negatieve gewichtcycles zitten
        // als er een korter pad is, dan is er een cyle

        for(int j=0; j<aantalEdges; j++){

            int van = edges.get(j).van();
            int naar =edges.get(j).naar();
            int gewicht = edges.get(j).gewicht();

            if (afstanden[van-1] != Integer.MAX_VALUE &&
                    afstanden[van-1]+gewicht < afstanden[naar-1] ){

                return "min oneindig";

            }


        }
        //als er een gewoon resultaat is
        if(afstanden[aantalKnoopPunten-1] == Integer.MAX_VALUE){return "plus oneindig";}
        return afstanden[aantalKnoopPunten-1]+"";




        //stap 1 initieer alle afstanden als null

    }





}

