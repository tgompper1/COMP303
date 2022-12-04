public class Country {
    String name;
    TrudeauGovernment officialGov;
    GovernmentArchive Governments;
    ElectoralSystem es;

    Country(String pName, ElectoralSystem e){
        name = pName;
        es = e;
    }

    public void setGov(TrudeauGovernment gov){

        officialGov = gov;
    }

    public void elect(){
        System.out.println(es.toString());
    }

}
