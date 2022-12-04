public class TrudeauGovernment {
    //singleton
    final String name = "Trudeau";
    final int session = 23;

    private TrudeauGovernment() {
    }

    public static final TrudeauGovernment INSTANCE = new TrudeauGovernment();

    public static TrudeauGovernment getInstanceTG(){
        return INSTANCE;
    }
}