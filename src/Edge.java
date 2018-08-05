public class Edge {

    //attribuur
    private int van;
    private int naar;
    private int gewicht;

    //constructor
    public Edge(int van, int naar, int gewicht){
        this.van = van;
        this.naar = naar;
        this.gewicht = gewicht;
    }

    //getters, zullen waarschijnlijk nodig zijn
    public int van() {
        return van;
    }

    public int naar() {
        return naar;
    }

    public int gewicht() {
        return gewicht;
    }

}
