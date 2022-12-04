public class clientQ1 {
    public static void main(String args[]){
        ElectoralSystem p = new Plurality();
        Country Canada = new Country("Canada", p);
        TrudeauGovernment gov = TrudeauGovernment.getInstanceTG();
        Canada.setGov(gov);
        Canada.elect();
    }
}
