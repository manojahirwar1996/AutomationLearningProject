public class DriverStrategyImplementer  {
    public static  DriverStrategy chooseStrategy(String strategy){
        if (strategy.equals("Chrome")) {
            return new Chrome();
        } else if (strategy.equals("FireFox")) {
            return new Firefox();
        }
        return null;
    }
}
