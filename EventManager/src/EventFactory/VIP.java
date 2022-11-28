package EventFactory;

import java.util.Optional;

public class VIP {
    public final String aName;
    public final String aCompany;

    /**
     * create a VIP with a Name and optionally a company.
     *      if no company is provided, the company is famous enough to
     *      be recognized by name and thus their company is themselves
     * @param pName
     * @param pCompany
     * @pre pName != null && pCompany != null
     */
    public VIP(String pName, Optional<String> pCompany) {
        assert pName != null && pCompany != null;
        aName = pName;
        if(pCompany.isPresent()) {
            aCompany = pCompany.get();
        }
        else{
            aCompany = pName;
        }
    }

    public String getName(){
        return aName;
    }

    public String getCompany(){
        return aCompany;
    }
}
