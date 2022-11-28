package EventFactory;

public class Calculator {
    private int aConcertPercentage = 50; //default is 50%
    private int aWorkshopPercentage = 50;
    private int aGalaPercentage = 50;
    private int aScreeningPercentage = 50;

    /**
     * default constructor that uses default percentages (50%) for each event type
     */
    public Calculator(){};

    /**
     * creates a new calculator to be used to calculate expected profit
     * @param pConcertPercentage
     * @param pWorkshopPercentage
     * @param pGalaPercentage
     * @param pScreeningPercentage
     * @pre pConcertPercentage >= 0 && pGalaPercentage >= 0
     *          && pScreeningPercentage >= 0 && pWorkshopPercentage >= 0
     * @post aConcertPercentage == pConcertPercentage && aGalaPercentage == pGalaPercentage
     *          && aWorkshopPercentage == pWorkshopPercentage && aScreeningPercentage == pScreeningPercentage
     */
    public Calculator(int pConcertPercentage, int pWorkshopPercentage, int pGalaPercentage, int pScreeningPercentage){
        assert pConcertPercentage >= 0 && pGalaPercentage >= 0 && pScreeningPercentage >= 0 && pWorkshopPercentage >= 0;
        aConcertPercentage = pConcertPercentage;
        aWorkshopPercentage = pWorkshopPercentage;
        aGalaPercentage = pGalaPercentage;
        aScreeningPercentage = pScreeningPercentage;
    }

    public int getConcertPercentage() {
        return aConcertPercentage;
    }

    public int getWorkshopPercentage() {
        return aWorkshopPercentage;
    }

    public int getGalaPercentage() {
        return aGalaPercentage;
    }

    public int getScreeningPercentage() {
        return aScreeningPercentage;
    }

    /**
     * @param pConcertPercentage
     * @pre pConcertPercentage >=0
     * @post aConcertPercentage == pConcertPercentage
     */
    public void setConcertPercentage(int pConcertPercentage){
        assert pConcertPercentage >= 0;
        aConcertPercentage = pConcertPercentage;
    }

    /**
     * @param pWorkshopPercentage
     * @pre pWorkshopPercentage >=0
     * @post aWorkshopPercentage == pWorkshopPercentage
     */
    public void setWorkshopPercentage(int pWorkshopPercentage){
        assert pWorkshopPercentage >= 0;
        aWorkshopPercentage = pWorkshopPercentage;
    }

    /**
     * @param pGalaPercentage
     * @pre pGalaPercentage >= 0
     * @post aGalaPercentage == pGalaPercentage
     */
    public void setGalaPercentage(int pGalaPercentage){
        assert pGalaPercentage >= 0;
        aGalaPercentage = pGalaPercentage;
    }

    /**
     * @param pScreeningPercentage
     * @pre pScreeningPercentage >= 0
     * @post aScreeningPercentage == pScreeningPercentage
     */
    public void setScreeningPercentage(int pScreeningPercentage){
        assert pScreeningPercentage >=0;
        aScreeningPercentage = pScreeningPercentage;
    }
}
